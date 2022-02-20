<?php 
	$id_solver = $_GET['id_solver'];

	//Import File Koneksi Database
	require_once('../koneksi.php');
	
	//Membuat SQL Query
	$sql = "SELECT t.id_ticket, e.name_emp name_submitter, t.create_date, 
			t.assign_date, t.end_date, p.problem_name, t.problem_detail, 
			es.name_emp name_solver, t.dev_note
			FROM ticket t
			JOIN employee e ON (t.id_emp = e.id_emp)
            JOIN problem p ON (t.id_problem = p.id_problem)
            JOIN employee es ON (t.id_solver = es.id_emp)
			WHERE t.id_solver = $id_solver
			AND t.status = 'Solved'
			ORDER BY t.end_date DESC;";

	// $sql = "SELECT t.id_ticket, t.assign_date, e.name_emp, t.end_date
    // FROM ticket t JOIN employee e ON t.id_emp = e.id_emp
    // WHERE t.status = 'Solved'
    // AND t.id_solver = $id_solver;";
	
	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result = array();
	
	while($row = mysqli_fetch_array($r)){
		array_push($result,array(
			"id_ticket"=>$row['id_ticket'],
			"assign_date"=>$row['assign_date'],
			"reporter"=>$row['name_submitter'],
			"person_in_charge"=>$row['name_solver'],
			"end_date"=>$row['end_date'],
			"create_date"=>$row['create_date'],
			"problem_name"=>$row['problem_name'],
			"problem_detail"=>$row['problem_detail'],
			"dev_note"=>$row['dev_note']
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>