package brainfuck;

public class Brainfuck
{
	String sourceCode = "";
	private int codePointer;
	private final int memoryNumber = 20;
	private int ptr;
	private int memory[] = new int[memoryNumber];

	Brainfuck(String sourceCode)
	{
		this.sourceCode = sourceCode;
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
				break;
			case '<':
				ptr--;
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
						codePointer = loopEnd+1;
						loopEnd = -1;
					}else
					{
						codePointer = sourceCode.indexOf("]", codePointer)+1;
					}
				}
				break;
			case ']':
				loopEnd = codePointer;
				if(memory[ptr] != 0)
				{
					codePointer = loopStart+1;
				}
				break;
			default:
				break;
			}
			codePointer++;
		}
		return result;
	}

	private void init()
	{
		codePointer = 0;
		ptr = 0;
		for(int i=0;i<memoryNumber;i++)memory[i] = 0;
	}
}
