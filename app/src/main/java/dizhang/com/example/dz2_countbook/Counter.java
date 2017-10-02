package dizhang.com.example.dz2_countbook;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by ggranked on 2017-10-01.
 */

public class Counter {
    private String name;
    private Integer initValue;
    private Integer curValue;
    private String comment;
    private Date date;
    //public Integer edited;


    public Counter (String name, Integer initValue, String comment) {
        this.name = name;
        this.initValue = initValue;
        this.curValue = initValue;
        this.comment = comment;
        date = new Date();
    }

    public Counter (String name, Integer initValue, Integer curValue, String comment) {
        this.name = name;
        this.initValue = initValue;
        this.curValue = curValue;
        this.comment = comment;
        date = new Date();
    }

    public void setNameC(String name){
        this.name = name;
        date = new Date();
    }
    public String getNameC(){
        return this.name;
    }


    public void setInitValueC(Integer initValue){
        this.initValue = initValue;
        date = new Date();
    }
    public Integer getInitValue() {
        return this.initValue;
    }


    public void setCurValue(Integer value){
        this.curValue = value;
        date = new Date();
    }
    public Integer getCurValue() {
        return this.curValue;
    }

    public void setComment(String comment){
        this.comment= comment;
        date = new Date();
    }
    public String getComment(){
        return comment;
    }


    public java.util.Date getDate() {
        return date;
    }

//   I didnt have time to implement increment and decrement by 1 and reset to initValue
    //below shows how they are defined

    public void incCurValue(){
        curValue++;
        date = new Date();
    }
    public void decCurValue(){
        curValue--;
        date = new Date();
    }

    public void resetToInitValue(){
        this.curValue = this.initValue;
        date = new Date();
    }

    public String counterToString(){
        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(this.date);
        return( "Name:  " + this.name + "\nCurrent Count:  " + curValue + "\n"+dateString);
    }
}
