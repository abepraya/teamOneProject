<?php 
	$id_solver = $_GET['id_solver'];
	$id_ticket = $_GET['id_ticket'];

	//Import File Koneksi Database
	require_once('../koneksi.php');
	
	//Membuat SQL Query
	/*$sql = "SELECT t.id_ticket, t.status, b.branch_name, t.assign_date, t.create_date, e.name_emp, p.problem_name, t.problem_detail
	FROM ticket t JOIN problem p ON t.id_problem = p.id_problem
	JOIN employee e ON t.id_emp = e.id_emp
	JOIN branch b ON e.id_branch = b.id_branch
	WHERE t.end_date LIKE '0000-00-00' AND t.assign_date NOT LIKE '0000-00-00'
	AND t.id_problem = $id_problem AND t.id_ticket = $id_ticket;";
	Cari yg ada assign date tapi end_date kosong ATAU dari status seperti berikut: */
	$sql = "SELECT t.id_ticket, t.status, b.branch_name, t.assign_date, t.create_date, e.name_emp, p.problem_name, t.problem_detail
	FROM ticket t JOIN problem p ON t.id_problem = p.id_problem
	JOIN employee e ON t.id_emp = e.id_emp
	JOIN branch b ON e.id_branch = b.id_branch
	WHERE t.status = 'Assigned'
	AND t.id_solver = $id_solver AND t.id_ticket = $id_ticket;";
	
	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result = array();
	
	while($row = mysqli_fetch_array($r)){
		
		//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
		array_push($result,array(
			"id_ticket"=>$row['id_ticket'],
			"status"=>$row['status'],
			"assign_date"=>$row['assign_date'],
			"problem_name"=>$row['problem_name'],
			"create_date"=>$row['create_date'],
			"name_emp"=>$row['name_emp'],
			"branch_name"=>$row['branch_name'],
			"problem_detail"=>$row['problem_detail']
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>