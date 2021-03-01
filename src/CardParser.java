import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class CardParser 
{
	private String urlString;
	private ArrayList<HeartstoneCard> theMinions;
	private JSONArray obj;
	
	public CardParser(String urlString)
	{
		this.urlString = urlString;
		theMinions = new ArrayList< HeartstoneCard >();

		URLReader hearthstoneURLReader = new URLReader(this.urlString);
		Object obj = JSONValue.parse(hearthstoneURLReader.getTheURLContents());
		
	    if(obj instanceof JSONArray)
	    {
	    
	    	JSONArray array = (JSONArray)obj;
	    	
		    for(int i = 0; i < array.size(); i++)
		    {
		    	JSONObject cardData = (JSONObject)array.get(i);
		    	if(cardData.containsKey("cost") && cardData.containsKey("name"))
		    	{
		    		if(cardData.containsKey("type") && cardData.get("type").equals("MINION"))
		    		{
		    			System.out.println(cardData.keySet().toString());
		    			String name = (String)cardData.get("name");
		    			int cost = Integer.parseInt(cardData.get("cost").toString());
		    			int attack = Integer.parseInt(cardData.get("attack").toString());
		    			int health = Integer.parseInt(cardData.get("health").toString());
		    			HeartstoneCard temp = new HeartstoneCard(name, cost, attack, health);
		    			theMinions.add(temp);
		    		}
		    	}
		    	
		    }
	    }
	}
	
	public void showMinions()
	{
		for(int i = 0; i < this.theMinions.size(); i++)
		{
			this.theMinions.get(i).display();
		}
	}
	public void insertionSortLowestCostToHighestCost()
	{ 
		for(int currStart = 1; currStart < this.theMinions.size(); currStart++)
		{
			HeartstoneCard currValue = this.theMinions.get(currStart);
			int currIndex = currStart;
			HeartstoneCard temp;
			while(currIndex > 0 && this.theMinions.get(currIndex).getCost() < this.theMinions.get(currIndex-1).getCost())
			{
				temp = this.theMinions.get(currIndex);
				this.theMinions.set(currIndex,  this.theMinions.get(currIndex-1));
				this.theMinions.set(currIndex-1,  temp);
				currIndex --;
			}
		}
	}
	
	public void sortLowestCostToHighestCost()
	{
		ArrayList<HeartstoneCard> theSortedList = new ArrayList<HeartstoneCard>();
		HeartstoneCard nextSmallest;
		while(this.theMinions.size() > 0)
		{
			nextSmallest = this.findSmallest();
			theSortedList.add(nextSmallest);
		}
		this.theMinions = theSortedList;
	}
	private HeartstoneCard findSmallest()
	{
		HeartstoneCard currWinner = this.theMinions.get(0);
		int indexOfWinner = 0;
		
		for(int i = 1; i < this.theMinions.size(); i++)
		{
			if(this.theMinions.get(i).getCost() > currWinner.getCost())
			{
				currWinner = this.theMinions.get(i);
				indexOfWinner = i;
			}
		}
		this.theMinions.remove(indexOfWinner);
		return currWinner;
	}
}