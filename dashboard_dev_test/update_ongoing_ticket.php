<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//Mendapatkan Nilai Dari Variable
		$id_ticket = $_POST['id_ticket'];
		//$end_date = $_POST['end_date'];
		$dev_note = $_POST['dev_note'];
		//$status = $_POST['status'];
		
		//import file koneksi database 
		require_once('../koneksi.php');
		
		//Membuat SQL Query
		$sql = "UPDATE ticket SET end_date = CURDATE(), dev_note = '$dev_note', status = 'Solved'  WHERE id_ticket = $id_ticket;";
		
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