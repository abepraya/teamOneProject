<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
    require_once('../koneksi.php');

    $email = $_POST['email'];  
    $password = $_POST['password'];  
      
    $sql = "SELECT e.id_emp, e.email, e.name_emp, a.password, d.role, e.job_title, d.id_division
    FROM account a JOIN employee e ON a.id_emp = e.id_emp
    JOIN division d ON e.id_division = d.id_division
    WHERE e.email = '$email';";

//Mendapatkan Hasil
$r = mysqli_query($con,$sql);
	
//Membuat Array Kosong 
$result = array();

$row = mysqli_fetch_array($r);

function generate_jwt($headers, $payload, $secret = 'secret') {
	$headers_encoded = base64url_encode(json_encode($headers));
	
	$payload_encoded = base64url_encode(json_encode($payload));
	
	$signature = hash_hmac('SHA256', "$headers_encoded.$payload_encoded", $secret, true);
	$signature_encoded = base64url_encode($signature);
	
	$jwt = "$headers_encoded.$payload_encoded.$signature_encoded";
	
	return $jwt;
}

function base64url_encode($str) {
    return rtrim(strtr(base64_encode($str), '+/', '-_'), '=');
}

function is_jwt_valid($jwt, $secret = 'secret') {
	// split the jwt
	$tokenParts = explode('.', $jwt);
	$header = base64_decode($tokenParts[0]);
	$payload = base64_decode($tokenParts[1]);
	$signature_provided = $tokenParts[2];

	// check the expiration time - note this will cause an error if there is no 'exp' claim in the jwt
	$expiration = json_decode($payload)->exp;
	$is_token_expired = ($expiration - time()) < 0;

	// build a signature based on the header and payload using the secret
	$base64_url_header = base64url_encode($header);
	$base64_url_payload = base64url_encode($payload);
	$signature = hash_hmac('SHA256', $base64_url_header . "." . $base64_url_payload, $secret, true);
	$base64_url_signature = base64url_encode($signature);

	// verify it matches the signature provided in the jwt
	$is_signature_valid = ($base64_url_signature === $signature_provided);
	
	if ($is_token_expired || !$is_signature_valid) {
		return FALSE;
	} else {
		return TRUE;
	}
}


if(mysqli_num_rows($r) == 1){
    $temp_email = $row['email'];
    $temp_password = $row['password'];
    $temp_role = $row['role'];

    if(password_verify($password, $temp_password)){
        $headers = array('alg'=>'HS256','typ'=>'JWT');
        $payload = array('sub'=>$row['id_emp'],'name'=>$row['name_emp'], 'admin'=>true, 'exp'=>(time() + 60));
        
        $jwt = generate_jwt($headers, $payload);

        $_SESSION['access_token'] = $jwt;

        array_push($result, array(
            "status" => "success",
            "message" => "Login Success",
            "name_emp"=> $row['name_emp'],
            "email"=> $row['email'],
            "role"=> $row['role'],
            "job_title" => $row['job_title'],
            "id_division" => $row['id_division'],
            "id_emp"=> $row['id_emp'],
            "access_token" => $jwt
        ));
        http_response_code(200);
    }
    else{
        array_push($result, array(
            "status" => "failed",
            "message" => "Invalid password"
        ));
        http_response_code(404);

    }
}
else if(empty($email) || empty($password)){
    array_push($result,array(
        "status" => "failed",
        "message"=>"Please input email and password"
    ));
    http_response_code(404);
}

else{
    array_push($result,array(
        "status" => "failed",
        "message"=>"invalid email & password"
    ));
    http_response_code(404);
}


//Menampilkan Array dalam Format JSON
echo json_encode(array('result'=>$result));

mysqli_close($con);
}  

?>