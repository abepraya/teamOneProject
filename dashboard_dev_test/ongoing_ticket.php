<?php 
	$id_solver = $_GET['id_solver'];

	//Import File Koneksi Database
	require_once('../koneksi.php');
	
	//Membuat SQL Query
	/*$sql = "SELECT t.id_ticket, t.create_date, e.name_emp, t.assign_date
			FROM ticket t JOIN employee e ON t.id_emp = e.id_emp
			WHERE t.end_date LIKE '0000-00-00' AND t.assign_date NOT LIKE '0000-00-00'
			AND t.id_problem = $id_problem;";
	Cari yg ada assign date tapi end_date kosong ATAU dari status seperti berikut: */
	$sql = "SELECT t.id_ticket, t.create_date, e.name_emp, t.assign_date
			FROM ticket t JOIN employee e ON t.id_emp = e.id_emp
			WHERE t.status = 'Assigned'
			AND t.id_solver = $id_solver
			ORDER BY t.create_date ASC;";
	
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
			"create_date"=>$row['create_date'],
			"name_emp"=>$row['name_emp'],
			"assign_date"=>$row['assign_date']
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>