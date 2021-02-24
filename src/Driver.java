import java.net.URL; 
import org.json.simple.JSONValue; 
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import java.util.ArrayList; 
import java.util.Scanner; 
public class Driver  
{ 
	public static void main(String[] args)  
	{ 
			URLReader HeartstoneURLReader = new URLReader("https://api.hearthstonejson.com/v1/25770/enUS/cards.json"); 
			Object obj = JSONValue.parse(HeartstoneURLReader.getTheURLContents()); 
			//HeartstoneCard[] theMinions = new HeartstoneCard[1924];
			ArrayList<HeartstoneCard> theMinions = new ArrayList<HeartstoneCard>();
		if(obj instanceof JSONArray) 
		{ 
			JSONArray array = (JSONArray)obj; 
				for(int i = 0; i < array.size(); i++) 
				{ 
					JSONObject cardData = (JSONObject)array.get(i); 
					if(cardData.containsKey("cost") && cardData.containsKey("name")) 
		    	{ 
						if(cardData.containsKey("type")&& cardData.get("type").equals("MINION")) 
						{ 
							String name = (String)cardData.get("name"); 
							int cost = Integer.parseInt(cardData.get("cost").toString());
							int attack = Integer.parseInt(cardData.get("attack").toString());
							int health = Integer.parseInt(cardData.get("health").toString());
							theMinions.add(new HeartstoneCard(name, cost, attack, health));
							theMinions.get(theMinions.size()-1).display();
						} 
					} 
				} 
				System.out.println(theMinions.size()); 
		} 
	} 
} 