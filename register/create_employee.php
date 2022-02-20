<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		require_once('../koneksi.php');
		$result = array();
		
		//Mendapatkan Nilai Variable
		$nama_emp = $_POST['nama_emp'];
		$email = $_POST['email'];
		$address = $_POST['address'];
        $id_branch = $_POST['id_branch'];
        $id_division = $_POST['id_division'];
        $phone = $_POST['phone'];
        $birth_date = $_POST['birth_date'];
        $job_title = $_POST['job_title'];
        $password = $_POST['password'];

        if(empty($nama_emp)){
        	    array_push($result,array(
			        "status" => "failed",
			        "message"=>"Please input name"
			    ));
				http_response_code(404);
        }
        else if(!preg_match("/^[a-zA-Z-' ]*$/",$nama_emp)){
  			array_push($result,array(
			        "status" => "failed",
			        "message"=>"Please input character"
			    ));
				http_response_code(404);
        }
        else if(empty($email)){
        	array_push($result,array(
			        "status" => "failed",
			        "message"=>"Please input email"
			    ));
				http_response_code(404);
        }
		else if (!filter_var($email, FILTER_VALIDATE_EMAIL)){
     		array_push($result,array(
			        "status" => "failed",
			        "message"=>"Invalid email format"
			    ));
				http_response_code(404);
        }

        else if(empty($address)){
        	array_push($result,array(
			        "status" => "failed",
			        "message"=>"Please input adress"
			    ));
				http_response_code(404);
        }

        else if(empty($phone)){
    		array_push($result,array(
		        "status" => "failed",
		        "message"=>"Please input phone number"
		    	));
				http_response_code(404);
        }
        else if(!preg_match("/^(\\+62|62|0)8[1-9][0-9]{6,9}$/",$phone)){
        	array_push($result,array(
		        "status" => "failed",
		        "message"=>"Please input Indonesia phone number"
		    	));	
				http_response_code(404);
        }
        else if(empty($birth_date)){
        	array_push($result,array(
		        "status" => "failed",
		        "message"=>"Please input birth date"
		    	));
				http_response_code(404);
        }
        else if(empty($job_title)){
			array_push($result,array(
		        "status" => "failed",
		        "message"=>"Please input job title"
		    	));
				http_response_code(404);
        }
		else if(empty($password)){
			array_push($result,array(
		        "status" => "failed",
		        "message"=>"Please input password !"
		    	));
				http_response_code(404);
		}
		else if(strlen($password) <= 8){
			array_push($result,array(
				"status" => "failed",
				"message"=>"Your Password Must Contain At Least 8 Characters!"
				));
				http_response_code(404);
		}
		else if(!preg_match("#[0-9]+#",$password)) {
			array_push($result,array(
				"status" => "failed",
				"message"=>"Your Password Must Contain At Least 1 Number!"
				));
				http_response_code(404);
		}
		else if(!preg_match("#[A-Z]+#",$password)) {
			array_push($result,array(
				"status" => "failed",
				"message"=>"Your Password Must Contain At Least 1 Capital Letter!"
				));
				http_response_code(404);
		}
		else if(!preg_match("#[a-z]+#",$password)) {
			array_push($result,array(
				"status" => "failed",
				"message"=>"Your Password Must Contain At Least 1 Lowercase Letter!"
				));
				http_response_code(404);
		}
        else {
				$hash_password = password_hash($password, PASSWORD_DEFAULT);
		        //Pembuatan Syntax SQL
				$sql = "INSERT INTO employee 
				(name_emp,email,address,id_branch,id_division,phone,birth_date,job_title) 
				VALUES ('$nama_emp','$email','$address','$id_branch','$id_division','$phone','$birth_date','$job_title')";
				
				//Import File Koneksi database
				
				//Eksekusi Query database
				if(mysqli_query($con,$sql)){
					// echo 'Berhasil Menambahkan Peserta';
					$sql2 = "SELECT id_emp FROM employee where name_emp = '$nama_emp'";
					//Mendapatkan Hasil
					$r1 = mysqli_query($con,$sql2);
					// echo($sql2);
					$result = array();

					$row = mysqli_fetch_array($r1);

					$id_employee = $row["id_emp"];

					//Mendapatkan Nilai Variable
					$id_emp = $id_employee;
					
					//Pembuatan Syntax SQL
					$sql3 = "INSERT INTO account (id_emp,password) VALUES ('$id_emp','$hash_password')";
					
					//Import File Koneksi database
					// require_once('../koneksi.php');
					
					//Eksekusi Query database
					if(mysqli_query($con,$sql3)){
						array_push($result,array(
		       			 "status" => "success",
		       			 "message"=>"Save Data Completed"
		    		));
						http_response_code(200);
					}else{
						array_push($result,array(
		       			 "status" => "failed",
		       			 "message"=>"Can't create the account"
		    		));
						http_response_code(404);
					}	
				}
				else{
					array_push($result,array(
		       			 "status" => "failed",
		       			 "message"=>"Save Data Failed"
		    		));
					http_response_code(404);
				}
				
			}
			echo json_encode(array('result'=>$result));
			mysqli_close($con);
	}
	

?>