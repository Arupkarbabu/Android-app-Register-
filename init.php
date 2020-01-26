<?php
$server_name = "localhost";
$username = "root";
$password = "";

$db= mysqli_connect($server_name, $username, $password);
	if (!$db )
 die( "Couldn't connect to MySQL: " .mysql_error());

	$db_selected =mysqli_select_db($db ,'database');
		
if (!$db_selected)
  {
  printf("Can\'t use test_db : ");
  }
  else{

  	echo "connect";
  }

?>

