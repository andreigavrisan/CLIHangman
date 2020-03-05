package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myCLIHangman.myRandom;

class MyRandomTest {

	@Test
	void test() {
		myRandom number = new myRandom();
		int output = number.randomIntegerNumber(1, 5);
		System.out.println("output is " + output);
		assertTrue(1 <= output);
		assertTrue(output <= 5);
	}
	
	@Test
	void test2() {
		myRandom number = new myRandom();
		int output = number.randomIntegerNumber(2, 2);
		System.out.println("output is " + output);
		assertTrue(2 == output);
	}

}
