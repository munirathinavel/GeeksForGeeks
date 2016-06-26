package selfpractice.amazon;

/**
 http://www.geeksforgeeks.org/how-to-design-a-tiny-url-or-url-shortener/
 https://www.careercup.com/question?id=5185808560553984

 Simple Solution:
    Use a Hashing algorithm and generate Hash for long urls. Need to deal with collisions using a list.

 Optimal Solution (below):
    2 steps:
        A) Shortening: Convert Long Url to Short Url
            1. Take Long Url and store it in DB with auto-generated ID
            2. Convert ID to Base 62 value and return http://bit.ly/<Base62-value> as short url. Note: Base-62[a-zA-Z0-9]

        B) Redirection: Convert Short Url to Long Url
            1. Take Short Url, convert Base62-value in short url to get decimal ID
            2. Using ID (primary key) of table, get Long Url and then issue a redirect, which is a HTTP 302 response
                and the target URL in the header.

    So its essentially, Decimal to Base-62 conversion and vice versa problem.

    With this approach we can store: 62^6 = ~56 billion unique urls

 */
public class URLShortner {

    private static final String ALPHABET_MAP = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = ALPHABET_MAP.length();  //62  => Thus Base-62

    public static void main(String[] args) {
        int id = 12345;
        //Step 1: Convert ID (primary key) to Base62 and return Base-62 value
        String base62value = encode(id);
        System.out.println("Short URL = http://bit.ly/"+base62value);

        //Step 2: Convert Base-62 value to decimal ID. Do a lookup using ID and return long URL.
        //Here we assume we have a DB to which we can pass the converted ID
        int convertedId = decode(base62value);
        System.out.println("Converted ID = "+ convertedId);
    }

    /**
     * CONVERT Decimal ID to Base-62 value
     * Take primary key ID of row where long url is inserted, convert that ID to Base-62 value
     * and return it as http://bit.ly/<Base62-value>
     */
    private static String encode(int id){
        StringBuilder sb = new StringBuilder();

        while(id > 0){
            int remainder = id % BASE;
            sb.append(ALPHABET_MAP.charAt(remainder));
            id = id / BASE;
        }
        //Need to reverse as - LSB is first remainder and MSB is last remainder
        return sb.reverse().toString();
    }

    /**
     * CONVERT Base-62 value in short url to decimal ID (primary key). Do a lookup using ID and return long URL.
     * Here we assume we have a DB to which we can pass the converted ID and get long original url and return that
     */
    private static int decode(String base62value){
        int id = 0;
        for(int i=0; i < base62value.length(); i++){
            char c = base62value.charAt(i);
            id = id * BASE + ALPHABET_MAP.indexOf(c);
        }
        return id;
    }

}
