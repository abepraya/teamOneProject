<?php 
	$id_emp = $_GET['id_emp'];
	$id_ticket = $_GET['id_ticket'];
	//Import File Koneksi Database
	require_once('../koneksi.php');
	
	//Membuat SQL Query
	$sql = "SELECT * 
			FROM ticket
			WHERE id_emp = $id_emp
			AND id_ticket = $id_ticket;";
	
	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result = array();
	
	while($row = mysqli_fetch_array($r)){
		
		//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
		array_push($result,array(
			"id_emp"=>$row['id_emp'],
			"create_date"=>$row['create_date'],
			"id_problem"=>$row['id_problem'],
			"problem_detail"=>$row['problem_detail'],
			"status"=>$row['status']
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>