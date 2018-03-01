<?php
	define("GREETING", "Welcome to lienminh69.vn");
	echo GREETING;
	echo "<br>";

	define("GREETING2", "Welcome to lienminh69.vn", false); // default case-insensitive is true
	echo greeting2; // because case-insensitive is false so echo greeting2 will get error
	echo "<br>";
	echo "<br>";

	// Constants are automatically global and can be used across the entire script.
	function myTest() {
		echo GREETING;
	}

	myTest();
?>