
public class Driver 
{

	public static void main(String[] args) 
	{
		HeartstoneCard c1 = new HeartstoneCard("Armor Vendor", 1, 1, 3);
		HeartstoneCard c2 = new HeartstoneCard("Wand Maker", 2, 2, 2);
		c1.display();
		c2.display();
		
		c1.name = "woot";
		c1.display();
	}

}
