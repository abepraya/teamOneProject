<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){

		//Import File Koneksi database
		require_once('../koneksi.php');


		$create_date = $_POST['create_date'];
		$id_problem = $_POST['id_problem'];
        $problem_detail = $_POST['problem_detail'];
        $status = "Created";
		$email = $_POST['email'];

		$sql = "SELECT id_emp FROM employee where email = '$email';";

		$r1 = mysqli_query($con,$sql);

		$result = array();

		$row = mysqli_fetch_array($r1);

		$id_employee = $row["id_emp"];

		$id_emp = $id_employee;

		//Mendapatkan Nilai Variable

		
		//Pembuatan Syntax SQL
		$sql2 = "INSERT INTO ticket (id_emp,create_date,id_problem,problem_detail,status) VALUES ('$id_emp','$create_date','$id_problem','$problem_detail','$status')";

		echo($sql2);

		//Eksekusi Query database
		if(mysqli_query($con,$sql2)){
			echo 'Berhasil Menambahkan Peserta';
		}else{
			echo 'Gagal Menambahkan Peserta';
		}
		
		mysqli_close($con);
	}
?>