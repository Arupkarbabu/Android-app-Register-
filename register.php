<?php

require 'init.php';

$name=$_POST["name"];
$rollno=$_POST["rollno"];
$department=$_POST["department"];
$longitude=$_POST["longitudee"];
$latitude=$_POST["latitude"];











$sql_query="INSERT INTO oder(name,rollno,department,longitude,latitude)VALUES('$name','$rollno','$department','$longitude','$latitude')";

if ($db->query($sql_query)==TRUE) {
	
	echo "inserted data";
}else{

	echo "sorry";
}

?>

