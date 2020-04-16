<?php
include_once "koneksi.php";

$query = "SELECT * FROM tabel_barang";
$res = mysqli_query($conn,$query);
$json_data = array();

while($row = mysqli_fetch_assoc($res)){
    $json_data[] = $row;
}
echo json_encode($json_data);
?>