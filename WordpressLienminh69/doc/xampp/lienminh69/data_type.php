<?php
	$x = 1234;
	var_dump($x);
	echo "<br>";

	$y = 1234.5678;
	var_dump($y);
	echo "<br>";

	$b = true;
	var_dump($b);
	echo "<br>";

	$arrayName = array("Volvo","BMW","Toyota");
	var_dump($arrayName);
	echo "<br>";

	class Car {
	    function Car() {
	        $this->model = "VW";
	    }
	}

	// create an object
	$herbie = new Car();

	// show object properties
	echo $herbie->model;
	echo "<br>";
	var_dump($herbie);
	echo "<br>";

	$x2 = "Hello world!";
	$x2 = null;
	var_dump($x2);
?>