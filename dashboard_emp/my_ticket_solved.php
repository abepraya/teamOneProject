<?php 
	$email = $_GET['email'];
	//Import File Koneksi Database
	require_once('../koneksi.php');

	$sql1 = "SELECT id_emp FROM employee where email = '$email';";

	$r1 = mysqli_query($con,$sql1);

	$result = array();

	$row = mysqli_fetch_array($r1);

	$id_employee = $row["id_emp"];


	//Membuat SQL Query
	$sql = "SELECT t.id_ticket, e.name_emp, t.create_date, t.assign_date, t.end_date
			FROM ticket t
			JOIN employee e ON (t.id_emp = e.id_emp)
			WHERE e.id_emp = $id_employee
			AND status = 'Solved';";
	
	//Mendapatkan Hasil	
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result1 = array();
	
	while($row = mysqli_fetch_array($r)){
		
		//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
		array_push($result1,array(
			"t.id_ticket"=>$row['id_ticket'],
			"e.name_emp"=>$row['name_emp'],
			"t.create_date"=>$row['create_date'],
			"t.assign_date"=>$row['assign_date'],
			"t.end_date"=>$row['end_date']
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode(array('result'=>$result1));
	
	mysqli_close($con);
?>