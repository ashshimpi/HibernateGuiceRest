<?xml version="1.0" encoding="utf-8"?>

<student>
	<name>$name$</name>
	<dateOfBirth>$dateOfBirth$</dateOfBirth>
	$phones: { ph |
		<phone>$ph.phone$</phone>
		<phoneType>$ph.phoneType$</phoneType>}$
	
	<department>
		<name>$department.name$</name>
	</department>
</student>