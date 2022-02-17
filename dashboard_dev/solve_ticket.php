<?php 
	$id_problem = $_GET['id_problem'];

	//Import File Koneksi Database
	require_once('../koneksi.php');
	
	//Membuat SQL Query
	$sql = "SELECT t.id_ticket, t.assign_date, e.name_emp, t.end_date
    FROM ticket t JOIN employee e ON t.id_emp = e.id_emp
    WHERE t.status = 'Solved'
    AND t.id_problem = $id_problem;";
	
	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result = array();
	
	while($row = mysqli_fetch_array($r)){
		
		/*Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
		array_push($result,array(
			"id_ticket"=>$row['id_ticket'],
			"id_emp"=>$row['id_emp'],
			"create_date"=>$row['create_date'],
			"id_problem"=>$row['id_problem'],
			"problem_detail"=>$row['problem_detail'],
			"status"=>$row['status'],
			"assign_date"=>$row['assign_date']
		));*/

		array_push($result,array(
			"id_ticket"=>$row['id_ticket'],
			"assign_date"=>$row['assign_date'],
			"name_emp"=>$row['name_emp'],
			"end_date"=>$row['end_date']
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>