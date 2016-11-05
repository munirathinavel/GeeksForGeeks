package selfpractice.companies.coursehero;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 Given a string in different formats, return : Subject, Course No, Semester, Year
 Sample strings:
 CS 101 Fall 2015
 CS101 Fall 2015
 CS:101 Fall 2015
 CS#101 Fall 2015
 CS 101 Fall2015
 CS 101 F2015
 CS101 Fall2015
 CS101 Fall2015
 */
class Info{
    private String dept;
    private int courseNo;
    private int year;
    private String sem;

    public Info(String dept, int courseNo, int year, String sem){
        this.dept = dept;
        this.courseNo = courseNo;
        this.year = year;
        this.sem = sem;
    }

    public String toString(){
        return dept + " " +  courseNo + " " + year + " " + sem;
    }
}
public class StringManipulation {

    public static void main(String[] args) {
        StringManipulation obj = new StringManipulation();
        String s = "CS#101     Fall   2015";
        Info info = obj.getInfoFromInput(s);
        System.out.println(info);
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private int getNoOfDigits(int value){
        return (int)(Math.log10(value)+1);
    }

    public Info getInfoFromInput(String input){

        String regex = "[a-zA-Z]+|[0-9]+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);

        String[] arr = new String[4];
        int i=0;
        while(m.find()){
            String s = m.group();
            //System.out.println(s);
            arr[i++] = s;
        }

        //System.out.println(Arrays.toString(arr));

        String dept = "";
        int courseNo = 0;
        int year = 0;
        String sem = "";
        for(String value : arr){

            if(dept.isEmpty()){
                dept = value;
            }

            if(isNumeric(value)) {
                if(courseNo == 0)
                    courseNo = Integer.parseInt(value);
                else{
                    if(getNoOfDigits(Integer.parseInt(value)) == 2)
                        year = Integer.parseInt("20"+value);
                    else
                        year = Integer.parseInt(value);
                }
            }

            if(sem.isEmpty()){
                if(value.equalsIgnoreCase("fall") || value.equalsIgnoreCase("f")){
                    sem = "Fall";
                }else if(value.equalsIgnoreCase("winter") || value.equalsIgnoreCase("w")){
                    sem = "Winter";
                }else if(value.equalsIgnoreCase("summer") || value.equalsIgnoreCase("su")){
                    sem = "Summer";
                }else if(value.equalsIgnoreCase("spring") || value.equalsIgnoreCase("s")){
                    sem = "Spring";
                }
            }
        }

        Info info = new Info(dept, courseNo, year, sem);

        return info;
    }


}
