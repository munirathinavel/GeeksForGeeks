package selfpractice.companies.study;

/**
 Simple data structure representing a Date
 */
public class SimpleDate {
    protected int year = 0;
    protected int month = 0;
    protected int day = 0;

    public SimpleDate (int year, int month, int day) {
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void setDate (int year, int month, int day) {
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void setYear (int year) {
        this.year=year;
    }
    public int getYear () {
        return year;
    }
    public void setMonth (int month) {
        this.month=month;
    }
    public int getMonth () {
        return month;
    }
    public void setDay (int day) {
        this.day=day;
    }
    public int getDay () {
        return day;
    }

    public static SimpleDate getFirstDayOfNextQuarter (SimpleDate date){

        int curMonth=date.getMonth();
        int newMonth=0;
        int newYear=date.getYear();
        if(curMonth>=1 && curMonth<=3)
            newMonth=4;
        else if(curMonth>=4 && curMonth<=6)
            newMonth=7;
        else if(curMonth>=7 && curMonth<=9)
            newMonth=10;
        else{
            newMonth=1;
            newYear+=1;
        }

        SimpleDate newDate=new SimpleDate(newYear,newMonth,1);
        return newDate;
    }

    @Override
    public String toString() {
        return "SimpleDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public static void main(String[] args) {
        SimpleDate sd = new SimpleDate(2000, 11,10);
        SimpleDate d = SimpleDate.getFirstDayOfNextQuarter(sd);
        System.out.println(d);
    }
}
