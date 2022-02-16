<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//Mendapatkan Nilai Dari Variable
		$id_ticket = $_POST['id_ticket'];
		$assign_date = $_POST['assign_date'];
		$id_solver = $_POST['id_solver'];
		$status = $_POST['status'];
		
		//import file koneksi database 
		require_once('../koneksi.php');
		
		//Membuat SQL Query
		$sql = "UPDATE ticket SET assign_date = '$assign_date', id_solver = '$id_solver', status = '$status'  WHERE id_ticket = $id_ticket;";
		
		//Meng-update Database 
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data Detail Kelas';
		}else{
			echo 'Gagal Update Data Detail Kelas';
			echo($sql);
		}
		
		mysqli_close($con);
	}
?>