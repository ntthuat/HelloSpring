package com.lambda;

import java.util.List;
import java.util.function.Function;

/**
 * @author MikeW
 */
public class NameTestNew {

	public static void main(String[] args) {

		System.out.println("\n==== NameTestNew ===");

		List<Person2> list1 = Person2.createShortList();

		// Print Custom First Name and e-mail
		System.out.println("===Custom List===");
		list1.forEach(person2 -> {
			System.out.println(person2.printCustom(p -> "Name: " + p.getGivenName() + " EMail: " + p.getEmail()));
		});

		// Define Western and Eastern Lambdas

		Function<Person2, String> westernStyle = p -> {
			return "\nName: " + p.getGivenName() + " " + p.getSurName() + "\n" + "Age: " + p.getAge() + "  "
			        + "Gender: " + p.getGender() + "\n" + "EMail: " + p.getEmail() + "\n" + "Phone: " + p.getPhone()
			        + "\n" + "Address: " + p.getAddress();
		};

		Function<Person2, String> easternStyle = p -> "\nName: " + p.getSurName() + " " + p.getGivenName() + "\n"
		        + "Age: " + p.getAge() + "  " + "Gender: " + p.getGender() + "\n" + "EMail: " + p.getEmail() + "\n"
		        + "Phone: " + p.getPhone() + "\n" + "Address: " + p.getAddress();

		// Print Western List
		System.out.println("\n===Western List===");
		list1.forEach(person2 -> {
			System.out.println(person2.printCustom(westernStyle));
		});

		// Print Eastern List
		System.out.println("\n===Eastern List===");
		for (Person2 person : list1) {
			System.out.println(person.printCustom(easternStyle));
		}

	}
}
