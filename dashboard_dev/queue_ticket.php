<?php 
	$id_problem = $_GET['id_problem'];
	//Import File Koneksi Database
	require_once('../koneksi.php');
	
	//Membuat SQL Query
	$sql = "SELECT * 
			FROM ticket 
			WHERE assign_date LIKE '0000-00-00'
			AND id_problem = $id_problem;";
	
	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result = array();
	
	while($row = mysqli_fetch_array($r)){
		
		//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
		array_push($result,array(
			"id_ticket"=>$row['id_ticket'],
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