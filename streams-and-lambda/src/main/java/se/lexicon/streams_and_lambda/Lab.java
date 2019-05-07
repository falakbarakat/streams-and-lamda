package se.lexicon.streams_and_lambda;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import se.lexicon.streams_and_lambda.utility.Gender;
import se.lexicon.streams_and_lambda.utility.Person;

/**
 * All exercises should be completed using Lambda expressions and the new
 * methods added to JDK 8 where appropriate. There is no need to use an
 * explicit loop in any of the code.
 *
 */
public class Lab {
	 private List<Person> persons;

	    public Lab(List<Person> persons) {
	        this.persons = persons;
	    }
	
    

    /**
     * Exercise1
     * Create print out the first names of each person in the list
     */
    public void exercise1() {
    	
    	System.out.println("\nRunning exercise 1:\n");
//       List<Person>persons=new ArrayList<>();
    	//List have self forEach without the need to writing stream() 
    	//printing all information of persons
    // persons.forEach(System.out::println);there is
    	//a red line because println is not known in English
     // printing only first names using reference method???
	       persons.forEach(p->System.out.println(p.getFirstName()));
          }
       /**
     * Exercise2
     * Remove the words that have odd lengths from the local list using removeIf()
     * Print out the remainder
     */
    public void exercise2() {
    	System.out.println("\nRunning exercise 2:\n");
    	System.out.println("-----------------------");
        List<String> list = new ArrayList<>(Arrays.asList(
        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));
        list.removeIf(w-> (w.length() %2) != 0);
        System.out.println(list);
    }

    /**
     * Exercise 3
     * Replace every word in the list with its upper case equivalent using replaceAll()
     * Print out the remainder
     */
    public void exercise3() {
        System.out.println("\nRunning exercise 3:\n");
        System.out.println("-----------------------");
        List<String> list = new ArrayList<>(Arrays.asList(
       "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));
       list.replaceAll(String::toUpperCase);
       list.forEach(System.out::println);
    }

    /**
     * Exercise 4
     * Convert every key-value pair of the map into a string and append them all
     * into a single string
     * Hint: Maps forEach takes a BiConsumer...
     */
    public void exercise4() {
        System.out.println("\nRunning exercise 4:\n");
        System.out.println("-----------------------");
        Map<String, Integer> map = new HashMap<>();
        map.put("c", 3);
        map.put("b", 2);
        map.put("a", 1);
        StringBuilder sb = new StringBuilder();
        map.forEach((s, i) -> sb.append(s).append(i));
		System.out.println(sb);
    }

    /**
     * Exercise 5
     * Create a new thread that prints the numbers 
     * from the local list
     */
    public void exercise5() {
        System.out.println("\nRunning exercise 5:\n");
        System.out.println("-----------------------");
 List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        list.forEach(n->System.out.print(n+","));
    }

    /**
     * Exercise 6
     * By using stream create a new list with all the strings from the original list converted to
     * lower case and print them out.
     * Hint: Use .collect as a terminal operation(closing and ending)
     */
    public void exercise6() {
        System.out.println("\nRunning exercise 6:\n");
        System.out.println("-----------------------");
        List<String> list = Arrays.asList(
                "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");
        Set<String>newNames=list.stream().map(l->l.toLowerCase()).collect(TreeSet::new,TreeSet::add,TreeSet::addAll);
        System.out.print(newNames);
        //printout
        //[brown, dog, fox, jumped, lazy, over, quick, the]
    }

    /**
     * Exercise 7
     * Modify exercise 6 so that the new list only contains 
     * strings that have an odd length */
        
    public void exercise7() {
        System.out.println("\nRunning exercise 7:\n");
        System.out.println("-----------------------");
        List<String> list = Arrays.asList(
                "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");
        Set<String>newNames=list.stream().filter(w->w.length()%2!=0).collect(Collectors.toSet());
        System.out.println(newNames);
        //another way without using collect
        list.stream().filter(w->w.length()%2!=0).forEach(System.out::println);
    }

    /**
     * Exercise 8
      Turn list persons into a stream and print all elements
       whose lastName starts with 'A'
     * Use a forEach as a terminate operation
     */
    public void exercise8() {
        System.out.println("\nRunning exercise 8:\n");
        
     Predicate<Person>letter= p-> p.getLastName().charAt(0)=='A';
     persons.stream().filter(letter).forEach(w-> System.out.println(w));
    }
    /*
     * Exercise 9
    * Create a new list from this.persons that should be sorted by lastName
    */
    public void exercise9(){
        System.out.println("\nRunning exercise 9:\n");

        /* Your code here */


    }

    /**
     * Exercise 10
     * Create a new list from persons that should only contain those with lastname "Ali".
     * then change the first name of all inside the stream to Muhammad
     */
    public void exercise10(){
    System.out.println("\nRunning exercise 10:\n");
    System.out.println("-----------------------");
    Predicate<Person>result=p->p.getLastName().equals("Ali");
    List<Person>people=persons.stream().filter(result)
    .peek(p->p.setFirstName("mohammad")).collect(Collectors.toList());
    people.forEach(System.out::println);
    }

    /**
     * Exercise 11
     * lCount how many persons is of female gender in
     * this.persons.
     * Present the result
     * 
     */
    public void exercise11(){
        System.out.println("\nRunning exercise 11:\n");
          System.out.println("-------------------------");
        long NumberOfFemales=persons.stream()
    			.filter(p-> p.getGender().equals(Gender.FEMALE))
    			.count(); 
    			System.out.println(NumberOfFemales+" Females Contains This List");
        }
  } 