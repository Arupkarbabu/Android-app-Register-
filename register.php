<?php

require 'init.php';

$name=$_POST["name"];
$rollno=$_POST["rollno"];
$department=$_POST["department"];












$sql_query="INSERT INTO Register(name,rollno,department)VALUES('$name','$rollno','$department')";

if ($db->query($sql_query)==TRUE) {
	
	echo "inserted data";
}else{

	echo "sorry";
}

?>

