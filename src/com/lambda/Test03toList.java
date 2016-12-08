package com.lambda;

import java.util.List;
import java.util.stream.Collectors;

public class Test03toList {

	public static void main(String[] args) {

		List<Person2> pl = Person2.createShortList();

		SearchCriteria search = SearchCriteria.getInstance();

		// Make a new list after filtering.
		List<Person2> pilotList = pl.stream().filter(search.getCriteria("allPilots")).collect(Collectors.toList());

		System.out.println("\n=== Western Pilot Phone List ===");
		pilotList.forEach(Person2::printWesternName);
	}

}
