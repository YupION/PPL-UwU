<?php
 include_once "koneksi.php";

	 class usr{}

	 $username = $_POST["username"];
     $password = $_POST["password"];
     $nik = $_POST["nik"];
     $nama = $_POST["nama"];
     $telp = $_POST["telp"];
     $email = $_POST["email"];
     $alamat = $_POST["alamat"];
	 $confirm_password = $_POST["confirm_password"];

     if ((empty($username))) {
	 	$response = new usr();
	 	$response->success = 0;
	 	$response->message = "Kolom username tidak boleh kosong";
	 	die(json_encode($response));
	 } else if ((empty($password))) {
		$response = new usr();
	 	$response->success = 0;
	 	$response->message = "Kolom password tidak boleh kosong";
	 	die(json_encode($response));
	 } else if ((empty($nik))) {
        $response = new usr();
        $response->success = 0;
        $response->message = "Kolom NIK tidak boleh kosong";
       die(json_encode($response));
    }else if ((empty($nama))) {
       $response = new usr();
       $response->success = 0;
       $response->message = "Kolom nama tidak boleh kosong";
       die(json_encode($response));
    }else if ((empty($telp))) {
       $response = new usr();
       $response->success = 0;
       $response->message = "Kolom Telp tidak boleh kosong";
       die(json_encode($response));
    }else if ((empty($email))) {
       $response = new usr();
       $response->success = 0;
       $response->message = "Kolom email tidak boleh kosong";
       die(json_encode($response));
    }else if ((empty($alamat))) {
       $response = new usr();
       $response->success = 0;
       $response->message = "Kolom alamat tidak boleh kosong";
       die(json_encode($response));
    } else if ((empty($confirm_password)) || $password != $confirm_password) { 
		$response = new usr();
		$response->success = 0;
		$response->message = "Konfirmasi password tidak sama"; 
		die(json_encode($response));
	 } else {
		 if (!empty($username) && $password == $confirm_password){
		 	$num_rows = mysqli_num_rows(mysqli_query($conn, "SELECT * FROM tabel_user WHERE username='".$username."'"));

		 	if ($num_rows == 0){
		 		$query = mysqli_query($conn, "INSERT INTO tabel_user (id,nik,nama,email,alamat,telp,username,pass) VALUES(0,'".$nik."','".$nama."','".$email."','".$alamat."','".$telp."','".$username."','".$password."')");

		 		if ($query){
		 			$response = new usr();
		 			$response->success = 1;
		 			$response->message = "Register berhasil, silahkan login.";
		 			die(json_encode($response));

		 		} else {
		 			$response = new usr();
		 			$response->success = 0;
		 			$response->message = "Username sudah ada";
		 			die(json_encode($response));
		 		}
		 	} else {
		 		$response = new usr();
		 		$response->success = 0;
		 		$response->message = "Username sudah ada";
		 		die(json_encode($response));
		 	}
		 }
	 }

	 mysqli_close($conn);

?>