import java.util.Random;
public class DiceItem extends BagItemSuperclass
{
	private int randomNumber;
	
	public int ItemDrawn()
	{
		System.out.println("Oh no! You drew a four-sized die and need to roll it...");
		Random random=new Random();
		//generating a random integer number between 0 and 3 inclusive.
		randomNumber =random.nextInt(4);
		System.out.println("You rolled a "+randomNumber+" so that will be added to your bust total!");
		return randomNumber;
		
		
	}

}
