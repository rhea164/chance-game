import java.util.Scanner;
import java.util.Random;
public class CoinItem extends BagItemSuperclass
{
	
	Scanner scan=new Scanner(System.in);
	Random random=new Random();
	//generating a random integer number which is either 0 or 1.
	private int hOrT=random.nextInt(2);
	
	
	public int ItemDrawn()
	{
		String coinSide="";
		if(hOrT==0)
		{
			coinSide="H";
		}
		else
		{
			coinSide="T";
		}
		System.out.println("Oh no! You drew a coin and need to flip it. Call...\n"
				+"[H]eads\n"
				+"[T]ails");
		String input=scan.next();
		if(input.equalsIgnoreCase(coinSide))
		{
			System.out.println("Phew! You guessed right! Nothing happens...");
			return 0;
		}
		else
		{
			System.out.println("Oh no, you guessed wrong. Your bust total is increased by 2...");
			return 2;
		}
		
	}


}

