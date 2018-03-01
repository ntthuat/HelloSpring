<?php
	$x = 75;
	$y = 25;

	function addition() {
		$GLOBALS['z'] = $GLOBALS['x'] + $GLOBALS['y'];
	}

	addition();
	echo $z;
	echo "<br>";

	echo "\$_SERVER['PHP_SELF'] = ";
	echo $_SERVER['PHP_SELF'];
	echo "<br>";
	echo $_SERVER['SERVER_NAME'];
	echo "<br>";
	echo $_SERVER['HTTP_HOST'];
	echo "<br>";
	echo $_SERVER['HTTP_REFERER']; // this is error now
	echo "<br>";
	echo $_SERVER['HTTP_USER_AGENT'];
	echo "<br>";
	echo $_SERVER['SCRIPT_NAME'];
	echo "<br>";
	echo $GLOBALS['thuat'];
	echo "<br>";
	echo $_SERVER["REQUEST_METHOD"];

?>