<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$id_emp = $_POST['id_emp'];
		$password = $_POST['password'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO account (id_emp,password) VALUES ('$id_emp','$password')";
		
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