package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Java8StreamTests {

	static class Programmer {
		
		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

		public String[] getTechnologies() {
			return technologies;
		}

		String name;
		int age;
		String[] technologies;
		
		public Programmer(String name, int age, String[] technologies) {
			super();
			this.name = name;
			this.age = age;
			this.technologies = technologies;
		}
	}
	
	List<Programmer> programmers;
	String[] technologies1 = {"Java", "SQL", "C++"};
	String[] technologies2 = {"Java"};
	String[] technologies3 = {"Java", "React", "SQL"};
	
	@BeforeEach
	void setUp() {
		programmers = Arrays.asList(new Programmer("Vasya", 30, technologies1),
									new Programmer("Petya", 25, technologies2),
									new Programmer("Sara", 35, technologies1));
	}

	@Test
	void testSumTwoDimArray() {
		int ar[][] = {{Integer.MAX_VALUE ,2}, {3 ,4, 5}, {7}};
		assertEquals(Integer.MAX_VALUE + 21L, sumTwoDimArray(ar));
	}

	private Long sumTwoDimArray(int[][] ar) {
		
		return Arrays.stream(ar).flatMapToInt(a -> Arrays.stream(a)).asLongStream().sum();
	}
	
	@Test
	void averageProgrammersAgeTest() {
		assertEquals(30.0, getAverageAge());
	}

	private Double getAverageAge() {
		
//		return programmers.stream().mapToInt(p -> p.getAge())
//				.average().orElse(0);
		return programmers.stream()
				.collect(Collectors.averagingInt(Programmer::getAge));
	}
	
	@Test
	void mostPopularTechnologyTest() {
		assertEquals("Java", getMostPopularTechnology());
	}

	private String getMostPopularTechnology() {

		return programmers.stream().flatMap(p -> Arrays.stream(p.getTechnologies()))
				.collect(Collectors.groupingBy(t -> t, Collectors.counting()))
				.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
				.map(Map.Entry<String, Long>::getKey)
				.findFirst().orElse(null);
	}
	

	@Test
	void printDigitsOccurrences() {
		Arrays.stream(new Random().ints(0, Integer.MAX_VALUE).limit(1000000)
				.mapToObj(n -> Integer.toString(n))
				.collect(Collectors.joining()).chars().map(n -> Character.getNumericValue(n))
				.toArray()).boxed().collect(Collectors.groupingBy(t -> t, Collectors.counting()))
				.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
				.forEach(n -> System.out.println(n.getKey() + ": " + n.getValue()));
	}
	
}
