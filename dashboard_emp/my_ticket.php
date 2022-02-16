<?php 
	$id_emp = $_GET['id_emp'];
	//Import File Koneksi Database
	require_once('../koneksi.php');
	
	//Membuat SQL Query
	$sql = "SELECT * 
			FROM ticket
			WHERE id_emp = $id_emp;";
	
	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result = array();
	
	while($row = mysqli_fetch_array($r)){
		
		//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
		array_push($result,array(
			"id_branch"=>$row['id_branch'],
			"branch_name"=>$row['branch_name'],
			"branch_address"=>$row['branch_address']
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>