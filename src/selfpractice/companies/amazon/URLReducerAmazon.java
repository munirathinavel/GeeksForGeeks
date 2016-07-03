package selfpractice.companies.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** The one you implemented in Call
Example:
http://www.amazon.com//Playstation-System-Video-Game-Console-Pc//dp//B000K6TOK6//ref=sr_1_5?ie=UTF8&qid=1454648463&sr=8-5&keywords=playstation >> http://amzn.to//1nQW316

bit.ly/<>
*/
public class URLReducerAmazon {

	static Map<String, String> map = new HashMap<String, String>();
	static List<String> sameKeysList = new ArrayList<String>();

	public static void main(String[] args) {

		String inputURL = "http://www.amazon.com//Playstation-System-Video-Game-Console-Pc//dp//B000K6TOK6//ref=sr_1_5?ie=UTF8&qid=1454648463&sr=8-5&keywords=playstation";

		String shortURL = urlShorten(inputURL);

		String originalURL = getOriginalUrl(shortURL);

	}

	private static String urlShorten(String inputURL) {
		String[] tokens = inputURL.split("/");
		StringBuilder sb = new StringBuilder();

		//sb.append("http://amzn.to/");

		//Tokens : http:, www.amazon.com, Playstation-System-Video-Game-Console-Pc
		for(String token : tokens) {
			//Optimize further can use MD5, SHA hashing algorithms
			String key = getHashValue(token,0);

			//Assumption : we will have unique keys returned. 
			if(!map.containsKey(key)) {
				map.put(key, token);
				sb.append(key);
			}else{
				sameKeysList.add(token);
			}

			//Handle tokens with same keys
			for(String s : sameKeysList){                    
				key = getHashValue(token,1);

				//Same logic : Check in Map, till we get unique key
				//TODO:
			}

		}            
		return sb.toString();    //return shortened URL                      
	}


	private static String getOriginalUrl(String shortURL) {
		StringBuilder sb = new StringBuilder();

		//key will have 2 characters in String
		for(int i=0; i < shortURL.length()-1; i=i+2){    //O(n)
			String key = shortURL.substring(i, i+2);    //O(n)
			String value = map.get(key);

			sb.append(value+ "/");
		}                                            //Total O(n^2)

		return sb.toString();        
	}


	// TODO
	private static String getHashValue(String input, int index) { 
		int len = input.length();

		int hashValue = len % 7;    //can improve this to get wide range of buckets

		return ""+input.charAt(index)+hashValue;            
	}
}