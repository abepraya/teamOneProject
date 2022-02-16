<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$nama_emp = $_POST['nama_emp'];
		$email = $_POST['email'];
		$address = $_POST['address'];
        $id_branch = $_POST['id_branch'];
        $id_division = $_POST['id_division'];
        $birth_date = $_POST['birth_date'];
        $job_title = $_POST['job_title'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO employee (nama_emp,email,address,id_branch,id_division,birth_date,job_title) VALUES ('$nama_emp','$email','$address','$id_branch','$id_division','$birth_date','$job_title')";
		
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