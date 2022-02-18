<?php 
	$id_division = $_GET['id_division'];
	//Import File Koneksi Database
	require_once('../koneksi.php');
	
	/*$sql = "SELECT t.id_ticket, t.create_date, e.name_emp, p.problem_name
	FROM ticket t JOIN problem p ON t.id_problem = p.id_problem
	JOIN employee e ON t.id_emp = e.id_emp
	WHERE t.assign_date LIKE '0000-00-00'
	AND t.id_problem = $id_problem;";
	Cari yg assign_date kosong  ATAU status seperti berikut: */
	$sql = "SELECT t.id_ticket, t.create_date, e.name_emp, p.problem_name
	FROM ticket t JOIN problem p ON t.id_problem = p.id_problem
	JOIN employee e ON t.id_emp = e.id_emp
	WHERE t.status  = 'Created'
	AND p.id_division = $id_division;";
	
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
			"status"=>$row['status']
		));*/

		array_push($result,array(
			"id_ticket"=>$row['id_ticket'],
			"create_date"=>$row['create_date'],
			"name_emp"=>$row['name_emp'],
			"problem_name"=>$row['problem_name']
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>