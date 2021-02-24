import java.net.URL;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Scanner;

public class Driver 
{

	public static void main(String[] args) 
	{
			URLReader HeartstoneURLReader = new URLReader("https://api.hearthstonejson.com/v1/25770/enUS/cards.json");
			Object obj = JSONValue.parse(HeartstoneURLReader.getTheURLContents());
			HeartstoneCard [] theMinions = new Heartstonecard[1924];
			ArrayList<HeartstoneCard> theMinions = new ArrayList<HeartstoneCard>();
		
		if(obj instanceof JSONArray)
		{
			JSONArray array = (JSONArray)obj;
			int count = 0;
				for(int i = 0; i < array.size(); i++)
				{
					JSONObject cardData = (JSONObject)array.get(i);
					if(cardData.containsKey("cost") && cardData.containsKey("name"))
		    	{
						if(cardData.containsKey("type")&& cardData.get("type").equals("MINION"))
						{
							String name = (String)cardData.get("name");
							System.out.println(cardData.get("name"));
							System.out.println(cardData.get("cost"));
							System.out.println(cardData.get("attack"));
							System.out.println(cardData.get("health"));
							count++;
						}
					}
				}
				System.out.println(count);
		}
	}
}