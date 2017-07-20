package brainfuck;

import static org.junit.Assert.*;

import org.junit.Test;

public class BrainfuckTest {

	@Test
	public void testrun() {
		String helloworld = "+++++++++[>++++++++>+++++++++++>+++++<<<-]>.>++.+++++++..+++.>-.------------.<++++++++.--------.+++.------.--------.>+.";
		String nestLoopHelloworld = ">++++++++[-<+++++++++>]<.>[][<-]>+>-[+]++>++>+++[>[->+++<<+++>]<<]>-----."
				+ ">->+++..+++.>-.<<+[>[+>+]>>]<--------------.>>.+++.------.--------.>+.>+.";
		Brainfuck bf = new Brainfuck();
		assertEquals("helloworldじゃない","Hello, world!",bf.run(helloworld));

		assertEquals("nestLoopに対応できてない","Hello World!\n",bf.run(nestLoopHelloworld));
	}

}
