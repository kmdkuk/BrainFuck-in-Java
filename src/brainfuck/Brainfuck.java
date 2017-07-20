package brainfuck;

public class Brainfuck
{
	String sourceCode = "";
	private int codePointer;
	private final int memoryNumber = 999;
	private int ptr;
	private int memory[] = new int[memoryNumber];

	public static void main(String[] args) {
		String helloworld = "+++++++++[>++++++++>+++++++++++>+++++<<<-]>."
				+ ">++.+++++++..+++.>-.------------.<++++++++.--------.+++."
				+ "------.--------.>+.";
		String nestLoopHelloworld = ">++++++++[-<+++++++++>]<.>[][<-]>+>-[+]++>++>+++[>[->+++<<+++>]<<]>-----."
				+ ">->+++..+++.>-.<<+[>[+>+]>>]<--------------.>>.+++.------.--------.>+.>+.";
		String fizzBuzz = "++++++[->++++>>+>+>-<<<<<]>"
				+ "[<++++>>+++>++++>>+++>+++++>+++++>>>>>>"
				+ "++>>++<<<<<<<<<<<<<<-]<++++>+++>-->+++>->>"
				+ "--->++>>>+++++[->++>++<<]<<<<<<<<<<"
				+ "[->-[>>>>>>>]>[<+++>.>.>>>>..>>>+<]<<<<<-[>>>>]>[<+++++>.>.>..>>>+<]>>>>+<-[<<<]"
				+ "<[[-<<+>>]>>>+>+<<<<<<[->>+>+>-<<<<]<]>>[[-]<]>[>>>[>.<<.<<<]<[.<<<<]>]>.<<<<<<<<<<<]";
		Brainfuck bf = new Brainfuck(nestLoopHelloworld);
		//bf.test();
		System.out.println(bf.run());
	}

	Brainfuck(){}

	Brainfuck(String sourceCode)
	{
		this.sourceCode = sourceCode;
	}

	public String run(String sourceCode)
	{
		this.sourceCode = sourceCode;
		return this.run();
	}

	public String run()
	{
		String result = "";
		init();
		while(sourceCode.length() > codePointer)
		{
			char command = sourceCode.charAt(codePointer);
			switch(command)
			{
			case '>':
				ptr++;
				//System.out.println("codePointer:"+codePointer);
				//System.out.println("ptr:"+ptr);
				break;
			case '<':
				ptr--;
				//System.out.println("codePointer:"+codePointer);
				//System.out.println("ptr:"+ptr);
				break;
			case '+':
				memory[ptr]++;
				break;
			case '-':
				memory[ptr]--;
				break;
			case '.':
				result += (char)memory[ptr];
				break;
			case ',':

				break;
			case '[':
				if(memory[ptr]==0)
				{
					codePointer = searchCorrespondingParenthesis(codePointer);
				}
				break;
			case ']':
				if(memory[ptr] != 0)
				{
					codePointer = searchCorrespondingParenthesis(codePointer);
				}
				break;
			default:
				break;
			}
			//showMemory();
			codePointer++;
		}
		return result;
	}

	private void showMemory()
	{
		for(int i=0;i<memoryNumber;i++)
		{
			System.out.print(memory[i]+"\t");
		}
		System.out.println();
	}

	private void init()
	{
		codePointer = 0;
		ptr = 0;
		for(int i=0;i<memoryNumber;i++)memory[i] = 0;
	}

	void test()
	{
		sourceCode = "[[[[]]]]";
		System.out.println(searchCorrespondingParenthesis(7));
	}

	private int searchCorrespondingParenthesis(int index)
	{
		int parenthesisCounter = 0;
		//System.out.println(sourceCode);
		if(']' == sourceCode.charAt(index))
		{
			//System.out.println("]を見つけた");
			//対応する[を探す
			for(int i=index-1;i>-1;i--)
			{
				//System.out.println(i);
				if(']' == sourceCode.charAt(i))
				{
					parenthesisCounter++;
				}if('[' == sourceCode.charAt(i))
				{
					if(parenthesisCounter==0)
					{
						return i;
					}else
					{
						parenthesisCounter--;
					}
				}
			}
		}else if('[' == sourceCode.charAt(index))
		{
			//System.out.println("[を見つけた");
			//対応する]を探す
			for(int i=index+1;i<sourceCode.length();i++)
			{
				if('[' == sourceCode.charAt(i))
				{
					parenthesisCounter++;
				}if(']' == sourceCode.charAt(i))
				{
					if(parenthesisCounter==0)
					{
						return i;
					}else
					{
						parenthesisCounter--;
					}
				}
				//System.out.println(parenthesisCounter);
			}

		}
		System.out.println("error");
		return -1;
	}


}
