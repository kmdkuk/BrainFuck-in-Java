package brainfuck;

public class Brainfuck
{
	String sourceCode = "";
	private int codePointer;
	private final int memoryNumber = 100;
	private int ptr;
	private int memory[] = new int[memoryNumber];

	public static void main(String[] args) {
		String helloworld = "+++++++++[>++++++++>+++++++++++>+++++<<<-]>."
				+ ">++.+++++++..+++.>-.------------.<++++++++.--------.+++."
				+ "------.--------.>+.";
		String fizzBuzz = "++++++[->++++>>+>+>-<<<<<]>"
				+ "[<++++>>+++>++++>>+++>+++++>+++++>>>>>>"
				+ "++>>++<<<<<<<<<<<<<<-]<++++>+++>-->+++>->>"
				+ "--->++>>>+++++[->++>++<<]<<<<<<<<<<"
				+ "[->-[>>>>>>>]>[<+++>.>.>>>>..>>>+<]<<<<<-[>>>>]>[<+++++>.>.>..>>>+<]>>>>+<-[<<<]"
				+ "<[[-<<+>>]>>>+>+<<<<<<[->>+>+>-<<<<]<]>>[[-]<]>[>>>[>.<<.<<<]<[.<<<<]>]>.<<<<<<<<<<<]";
		Brainfuck bf = new Brainfuck(helloworld);
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
		int loopStart=0;
		int loopEnd=-1;
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
				loopStart = codePointer;
				if(memory[ptr]==0)
				{
					if(loopEnd != -1)
					{
						codePointer = loopEnd;
						loopEnd = -1;
					}else
					{
						codePointer = sourceCode.indexOf("]", codePointer);
					}
				}
				break;
			case ']':
				loopEnd = codePointer;
				if(memory[ptr] != 0)
				{
					codePointer = loopStart;
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

	private int searchCorrespondingParenthesis(int index)
	{
		if("[".equals(sourceCode.charAt(index)))
		{
			//対応する]を探す

		}else if("]".equals(sourceCode.charAt(index)))
		{
			//対応する[を探す

		}
		return -1;
	}


}
