package selfpractice.companies.palantir;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
See Image for description
 */
public class SmallestTimeDifference {

    public static void main(String[] args) {
        SmallestTimeDifference std = new SmallestTimeDifference();

        String[] times = {"10:00", "19:20", "06:45", "00:12", "23:50", "04:22"};
        int diff = std.getSmallestTimeDiff(times);
        System.out.println(diff);
    }

    private int getSmallestTimeDiff(String[] times) {
        int smallestDiff = Integer.MAX_VALUE;

        for(int i=0; i < times.length; i++){
            String t1 = times[i];

            for(int j=i+1; j < times.length; j++){
                String t2 = times[j];
                int diff = getDiff(t1, t2);

                if(diff < smallestDiff){
                    smallestDiff = diff;
                }
            }
        }

        return smallestDiff;
    }

    private int getDiff(String t1, String t2) {
        int h1 = Integer.parseInt(t1.substring(0, t1.indexOf(':')));
        int h2 = Integer.parseInt(t2.substring(0, t2.indexOf(':')));

        String time1 = null;
        String time2 = null;

        if(h1 > 12){
            time1 = "2016-07-20 " + t1 + ":00";
        }else{
            time1 = "2016-07-21 " + t1 + ":00";
        }

        if(h2 > 12){
            time2 = "2016-07-20 " + t2 + ":00";
        }else{
            time2 = "2016-07-21 " + t2 + ":00";
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = format.parse(time1);
            date2 = format.parse(time2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long difference = date1.compareTo(date2) > 0 ? date1.getTime() - date2.getTime() : date2.getTime() - date1.getTime();
        long diffMinutes = difference / (60 * 1000);

        return (int)diffMinutes;
    }

}
