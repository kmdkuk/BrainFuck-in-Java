package brainfuck;

import static org.junit.Assert.*;

import org.junit.Test;

public class BrainfuckTest {

	@Test
	public void testrun() {
		String helloworld = "+++++++++[>++++++++>+++++++++++>+++++<<<-]>.>++.+++++++..+++.>-.------------.<++++++++.--------.+++.------.--------.>+.";
		Brainfuck bf = new Brainfuck();
		assertEquals("helloworldじゃない","Hello, World!",bf.run(helloworld));
	}

}
