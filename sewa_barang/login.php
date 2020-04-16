<?php

include_once "koneksi.php";

	 class usr{}
	
	 $username = $_POST["username"];
	 $password = $_POST["password"];
	
	 if ((empty($username)) || (empty($password))) { 
	 	$response = new usr();
		$response->success = 0;
		$response->messa6uge = "Kolom tidak boleh kosong"; 
		die(json_encode($response));
	 }
	
	 $query = mysqli_query($conn, "SELECT * FROM tabel_user WHERE username='$username' AND pass='$password'");
	
	 $row = mysqli_fetch_array($query);
	
	 if (!empty($row)){
	 	$response = new usr();
	 	$response->success = 1;
	 	$response->message = "Selamat datang ".$row['username'];
		$response->id = $row['id'];
	 	$response->username = $row['username'];
	 	die(json_encode($response));
		
	 } else { 
	 	$response = new usr();
	 	$response->success = 0;
	 	$response->message = "Username atau password salah";
	 	die(json_encode($response));
	 }
	
	 mysqli_close($conn);

?>