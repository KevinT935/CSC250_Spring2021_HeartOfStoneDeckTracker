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
		    			//I am only here is this is a minion card!!!
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
	
	public void sortLowestCostToHighestCost()
	{
		if(obj instanceof JSONArray)
		{
			JSONArray array = (JSONArray)obj;
			for(int d = 0; d < 5; d++)
			{
				for(int i = 0; i < this.theMinions.size(); i++)
		{	
	JSONObject cardData = (JSONObject)array.get(i);
	if(cardData.containsKey("cost")&&cardData.get("cost").equals(d))
	{
		
	}
		}
			}
		}
	}
}