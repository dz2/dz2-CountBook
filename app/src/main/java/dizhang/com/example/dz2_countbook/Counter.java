package dizhang.com.example.dz2_countbook;

import java.util.Date;

/**
 * Created by ggranked on 2017-10-01.
 */

public class Counter {
    public String nameC;
    public String initValueC;
    //public String curValue;
    public String commentC;
    //public Date date;
    //public Integer edited;


    public Counter (String name, String initValue, String comment) {
        this.nameC = name;
        this.initValueC = initValue;
        //this.curValue = curValue;
        this.commentC = comment;
        //this.date = new Date();
    }

  /*  public Counter (String name, String initValue) {
        this.name = name;
        this.initValue = initValue;
        this.date = new Date();
    }

*/
    public String CountertoString() {

        return nameC + "\n" + initValueC + "\n" + commentC; // + date.toString() + "\n";

    }
}
