<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$id_emp = $_POST['id_emp'];
		$create_date = $_POST['create_date'];
		$id_problem = $_POST['id_problem'];
        $problem_detail = $_POST['problem_detail'];
        $status = $_POST['status'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO ticket (id_emp,create_date,id_problem,problem_detail) VALUES ('$id_emp','$create_date','$id_problem','$problem_detail','$status')";
		
		//Import File Koneksi database
		require_once('../koneksi.php');
		
		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan Peserta';
		}else{
			echo 'Gagal Menambahkan Peserta';
		}
		
		mysqli_close($con);
	}
?>