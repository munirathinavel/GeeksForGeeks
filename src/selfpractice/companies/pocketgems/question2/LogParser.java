package selfpractice.companies.pocketgems.question2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Find % of time there were no network issues.
 *
 * Log File Format:
 (11/01/2015-04:00:00) :: START
 (11/01/2015-04:00:00) :: CONNECTED
 (11/01/2015-04:30:00) :: DISCONNECTED
 (11/01/2015-04:45:00) :: CONNECTED
 (11/01/2015-05:00:00) :: SHUTDOWN

 Find
    Total session time = Shutdown time - Start Time
    Active seesion time = Time between CONNECTED to DISCONNECTED and CONNECTED to SHUTDOWN
    Return Percentage
 */
public class LogParser {
    private static final String PATH = "D:\\workspace\\SandeepSadanandKulkarni\\github-projects\\GeeksForGeeks\\src\\selfpractice\\pocketgems\\question2";

    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = PATH+"\\"+"input_1.txt";
        if (args.length > 0) {
        	filename = args[0];
        }

        String answer = parseFile(filename);
        System.out.println(answer);
    }

    static String parseFile(String filename)
            throws FileNotFoundException, IOException {
        /*
    	 *  Don't modify this function
    	 */
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = input.readLine()) != null) {
            allLines.add(line);
        }
        input.close();

        return parseLines(allLines.toArray(new String[allLines.size()]));
    }

    static String parseLines(String[] lines) {
        Date startDt = null;
        Date shutDt = null;
        long activeTime = 0;
        long activityTime = 0;
        boolean isConnected = false;        //Imp flag to know when CONNECTED
        
        for(String line : lines){           
            String dateTime = line.substring(line.indexOf("(")+1, line.indexOf(")"));
            String message = line.substring(line.indexOf("::")+3);

            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy-hh:mm:ss");
            Date inputDate;
            try {
                inputDate = dateFormat.parse(dateTime);
                System.out.println(inputDate + " " + message);
                
                if(message.equalsIgnoreCase("START")){
                    startDt = inputDate;
                }else if(message.equalsIgnoreCase("SHUTDOWN")){
                    shutDt = inputDate;
                    if(isConnected){                                        //Check if it was Connected to calculate time diff
                        activityTime += (inputDate.getTime() - activeTime);
                    }
                }else if(message.equalsIgnoreCase("CONNECTED")){
                    activeTime = inputDate.getTime();       
                    isConnected = true;                                     //CONNECTED = true
                }else if(message.equalsIgnoreCase("DISCONNECTED")){
                    activityTime += (inputDate.getTime() - activeTime);
                    isConnected = false;                                    //Disconnect so flag is set to false
                }
                
            } catch (ParseException e) {
                e.printStackTrace();
            }           
        }

        long sessionTime = shutDt.getTime() - startDt.getTime();
        System.out.println("activitytime: "+activityTime+" session:"+sessionTime);

        int percent = (int) (activityTime*100/sessionTime);
        return percent+"%";
    }
}
