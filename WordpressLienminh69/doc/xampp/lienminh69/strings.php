<?php
	$stringTest = "Nguyen Thien Thuat";
	echo "String Test = " . "\"" . $stringTest . "\"";
	echo "<br>";
	echo "Length = " . strlen($stringTest);
	echo "<br>";
	echo "Number of word = " . str_word_count($stringTest);
	echo "<br>";
	echo "Sring reverse = " . strrev($stringTest);
	echo "<br>";
	echo "Position of \"Thuat\" = " . strpos($stringTest, "Thuat");
	echo "<br>";
	echo str_replace("Thuat", "Tin", $stringTest);
?>