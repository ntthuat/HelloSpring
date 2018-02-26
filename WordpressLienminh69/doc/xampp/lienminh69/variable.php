<?php
	$txt = "Hello World Variable";
	$x = 10;
	$y = 10.5;

	echo "I love $txt!";
	echo "<p>\n</p>";
	echo "I love " . $txt . "!";

	echo "<p>\n</p>";
	echo "x = $x";
	echo "<p>\n</p>";
	echo "y = $y";
	echo "<p>\n</p>";
	echo "x + y = ";
	echo $x + $y;
	function myTest() {
	    $local_variable = 5; // local scope
	    echo "<p>Variable local_variable inside function is: $local_variable</p>";
	} 
	myTest();

	// using x outside the function will generate an error
	echo "<p>Variable x outside function is: $local_variable</p>";

	function myTest2() {
	    static $x = 0;
	    echo $x;
	    $x++;
	}

	myTest2();
	myTest2();
	myTest2();

?>