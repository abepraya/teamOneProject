<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$result_error = array();
		
		//Mendapatkan Nilai Variable
		$nama_emp = $_POST['nama_emp'];
		$email = $_POST['email'];
		$address = $_POST['address'];
        $id_branch = $_POST['id_branch'];
        $id_division = $_POST['id_division'];
        $phone = $_POST['phone'];
        $birth_date = $_POST['birth_date'];
        $job_title = $_POST['job_title'];
        $password = $_POST['password'];


   //      if(empty($nama_emp)){
   //      	    array_push($result_error,array(
			//         "status" => "failed",
			//         "message"=>"Please input name"
			//     ));
   //      }
   //      else if(!preg_match("/^[a-zA-Z-' ]*$/",$nama_emp)){
  	// 		array_push($result_error,array(
			//         "status" => "failed",
			//         "message"=>"Please input character"
			//     ));
   //      }
   //      else if(empty($email)){
   //      	array_push($result_error,array(
			//         "status" => "failed",
			//         "message"=>"Please input email"
			//     ));
   //      }else if (!filter_var($email, FILTER_VALIDATE_EMAIL)){
   //   		array_push($result_error,array(
			//         "status" => "failed",
			//         "message"=>"Invalid email format"
			//     ));
   //      }

   //      else if(empty($address)){
   //      	array_push($result_error,array(
			//         "status" => "failed",
			//         "message"=>"Please input adress"
			//     ));
   //      }

   //      else if(empty($phone)){
   //  		array_push($result_error,array(
		 //        "status" => "failed",
		 //        "message"=>"Please input adress"
		 //    	));
   //      }
   //      else if(!preg_match("/^(\\+62|62|0)8[1-9][0-9]{6,9}$/",$phone)){
   //      	array_push($result_error,array(
		 //        "status" => "failed",
		 //        "message"=>"must be number"
		 //    	));	
   //      }

   //      else if(empty($birth_date)){
   //      	array_push($result_error,array(
		 //        "status" => "failed",
		 //        "message"=>"Please input birth_date"
		 //    	));
   //      }

   //      else if(empty($job_title)){
			// array_push($result_error,array(
		 //        "status" => "failed",
		 //        "message"=>"Please input job title"
		 //    	));
   //      }
   //      else {

		 //        	//Pembuatan Syntax SQL
			// 	$sql = "INSERT INTO employee 
			// 	(name_emp,email,address,id_branch,id_division,phone,birth_date,job_title) 
			// 	VALUES ('$nama_emp','$email','$address','$id_branch','$id_division','$phone','$birth_date','$job_title')";
				
			// 	//Import File Koneksi database
			// 	require_once('../koneksi.php');
				
			// 	//Eksekusi Query database
			// 	if(mysqli_query($con,$sql)){
			// 		echo 'Berhasil Menambahkan Peserta';
			// 		$sql2 = "SELECT id_emp FROM employee where name_emp = '$nama_emp'";
			// 		//Mendapatkan Hasil
			// 		$r1 = mysqli_query($con,$sql2);
			// 		echo($sql2);
			// 		$result = array();

			// 		$row = mysqli_fetch_array($r1);

			// 		$id_employee = $row["id_emp"];

			// 		//Mendapatkan Nilai Variable
			// 		$id_emp = $id_employee;
					
			// 		//Pembuatan Syntax SQL
			// 		$sql3 = "INSERT INTO account (id_emp,password) VALUES ('$id_emp','$password')";
					
			// 		//Import File Koneksi database
			// 		require_once('../koneksi.php');
					
			// 		//Eksekusi Query database
			// 		if(mysqli_query($con,$sql3)){
			// 			echo 'Berhasil Menambahkan password account';
			// 		}else{
			// 			echo 'Gagal Menambahkan account';
			// 		}	
			// 	}
			// 	else{
			// 		array_push($result_error,array(
		 //       			 "status" => "failed",
		 //       			 "message"=>"Gagal mendapatkan peserta"
		 //    		));
			// 		echo 'Gagal Menambahkan Peserta';
			// 	}

			// 	mysqli_close($con);

   //      }


		        	//Pembuatan Syntax SQL
				$sql = "INSERT INTO employee 
				(name_emp,email,address,id_branch,id_division,phone,birth_date,job_title) 
				VALUES ('$nama_emp','$email','$address','$id_branch','$id_division','$phone','$birth_date','$job_title')";
				
				//Import File Koneksi database
				require_once('../koneksi.php');
				
				//Eksekusi Query database
				if(mysqli_query($con,$sql)){
					echo 'Berhasil Menambahkan Peserta';
					$sql2 = "SELECT id_emp FROM employee where name_emp = '$nama_emp'";
					//Mendapatkan Hasil
					$r1 = mysqli_query($con,$sql2);
					echo($sql2);
					$result = array();

					$row = mysqli_fetch_array($r1);

					$id_employee = $row["id_emp"];

					//Mendapatkan Nilai Variable
					$id_emp = $id_employee;
					
					//Pembuatan Syntax SQL
					$sql3 = "INSERT INTO account (id_emp,password) VALUES ('$id_emp','$password')";
					
					//Import File Koneksi database
					require_once('../koneksi.php');
					
					//Eksekusi Query database
					if(mysqli_query($con,$sql3)){
						echo 'Berhasil Menambahkan password account';
					}else{
						echo 'Gagal Menambahkan account';
					}	
				}
				else{
					array_push($result_error,array(
		       			 "status" => "failed",
		       			 "message"=>"Gagal mendapatkan peserta"
		    		));
					echo 'Gagal Menambahkan Peserta';
				}
				
				mysqli_close($con);


	}

?>