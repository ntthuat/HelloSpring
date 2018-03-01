<?php
	$cars = array("Volvo", "BMW", "Toyota");

	echo "I like " . $cars[0] . ", " . $cars[1] . ", " . $cars[2];
	echo "<br>";
	echo "count = " . count($cars) . "<br>";

	$age = array("Peter"=>"35", "Ben"=>"37", "Joe"=>"43");
	echo "Peter is " . $age['Peter'] . " years old." . "<br>";

	foreach ($age as $x => $x_value) {
		echo "Key = " . $x . ", Value = " . $x_value . "<br>";
	}

	sort($cars);

	for ($x = 0; $x < count($cars); $x++) {
		echo $cars[$x];
		echo "<br>";
	}

	rsort($cars);
	echo "<br><br>";

	for ($x = 0; $x < count($cars); $x++) {
		echo $cars[$x];
		echo "<br>";
	}
?>