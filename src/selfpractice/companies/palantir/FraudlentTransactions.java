package selfpractice.companies.palantir;

import java.io.*;
import java.util.*;

/**
 See Image for description and sample input / output files

 Imagine you are working for a small bank, attempting to   analyze fraudulent credit card transactions.
 You are given a list of strings describing credit card transactions for a single day. All strings are pipe‐delimited and
 will take the form of "<person name>|<integer whole dollar amount>|<location>|<integer time in minutes since 00:00>".
 The list is sorted in ascending order by time. Your job is to return a list of people's names whose accounts reflect
 suspicious activity. A person's account reflects suspicious activity if you see of the following:
 1. A transaction spending more than $3000
 2. A transaction for which the next transaction for the same person differs in location, and is less than an hour later

 The list you return should be ordered by when the first suspicious was detected.
 For the second type of fraud, consider the "first suspicious activity" to be the earlier of the two transactions.
 You have to complete the function getSuspiciousActivity to return the list of suspicious activities.
 The list you return should contain the person names as they appeared in the input.
 Please note that the first line of the input is the number of transactions in the array.

 Sample Input 1:
 Shilpa|500|California|63
 Tom|25|New York|615
 Krasi|9000|California|1230
 Tom|25|New York|1235
 Tom|25|New York|1238
 Shilpa|50|Michigan|1300
 Matt|90000|Georgia|1305
 Jay|100000|Virginia|1310
 Krasi|49|Florida|1320
 Krasi|83|California|1325
 Shilpa|50|California|1350

 Sample Output 1:
 Krasi
 Shilpa
 Matt
 Jay

 Explanation Krasi is first because she has exhibited amount fraud before any other account exhibited either types of fraud
 (she then later also committed location fraud, but this doesn't matter).
 Shilpa is second, having committed location fraud where the first transaction took place before either of Matt or Jay's amount fraud.
 Matt and Jay both exhibited amount fraud, but Matt's fraud was recorded before Jay's.
 Tom is not on this list because he did not commit either type of fraud.
 */

class Transaction {
    String name;
    int amount;
    String place;
    double time;

    Transaction(String name, int amount, String place, double time) {
        this.name = name;
        this.amount = amount;
        this.place = place;
        this.time = time;
    }
}

public class FraudlentTransactions {

    public static void main(String[] args) throws IOException {
        /*Scanner in = new Scanner(System.in);
        final String fileName = "D://input001.txt";//System.getenv("OUTPUT_PATH");
        BufferedReader bw = new BufferedReader(new FileReader(fileName));
        String[] res;

        int _transactions_size = 0;
        _transactions_size = Integer.parseInt(in.nextLine());
        String[] _transactions = new String[_transactions_size];
        String _transactions_item;
        for(int _transactions_i = 0; _transactions_i < _transactions_size; _transactions_i++) {
            try {
                _transactions_item = in.nextLine();
            } catch (Exception e) {
                _transactions_item = null;
            }
            _transactions[_transactions_i] = _transactions_item;
        }

        res = getSuspiciousList(_transactions);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(res[res_i]);
//            bw.write(String.valueOf(res[res_i]));
//            bw.newLine();
        }

        bw.close();*/
        List<String> list = new ArrayList<>();
        list.add("Shilpa|500|California|63");
        list.add("Tom|25|New York|615");
        list.add("Krasi|9000|California|1230");
        list.add("Tom|25|New York|1235");
        list.add("Tom|25|New York|1238");
        list.add("Shilpa|50|Michigan|1300");
        list.add("Matt|90000|Georgia|1305");
        list.add("Jay|100000|Virginia|1310");
        list.add("Krasi|49|Florida|1320");
        list.add("Krasi|83|California|1325");
        list.add("Shilpa|50|California|1350");

        String[] res = getSuspiciousList(list.toArray(new String[0]));
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(res[res_i]);
        }
    }


    static String[] getSuspiciousList(String[] transactions) {
        Set<String>names=new TreeSet();
        LinkedHashMap<String,Transaction> map=new LinkedHashMap();
        HashMap<String,Integer> namePos=new HashMap();
        int count=0;
        for(int i=0;i<transactions.length;i++){
            String []transact=transactions[i].split("\\|");

            String name=transact[0];
            String amount=transact[1];
            String place=transact[2];
            String time=transact[3];
            Transaction tran=new Transaction(name,Integer.parseInt(amount),place,Double.parseDouble(time));

            if(namePos.get(name)==null)
                namePos.put(name,i);

            if(map.get(name)==null){
                if(tran.amount>3000){
                    names.add(name);
                    continue;
                }
                else{

                    map.put(name,tran);
                }
            }
            else{
                if(map.get(name).time-tran.time<60&& !map.get(name).place.equals(tran.place)){
                    names.add(name);
                    continue;
                }


            }
        }
        String[]susp=new String[transactions.length];

        for(String s:names){
            susp[namePos.get(s)]=s;
        }

        String[] newSusp=new String[names.size()];
        int index=0;
        for(int i=0;i<susp.length;i++){
            if(susp[i]!=null)
                newSusp[index++]=susp[i];
        }


        return newSusp;





    }
}



