package sample.model;

import java.sql.Timestamp;

public class Askhelp {
    private int askhelpid;
    private int userid;
     private String  subject1;
     private String problem_description;
    private Timestamp dateandtime;
    public Askhelp(){}
    public Askhelp(String subject1,String problem_description,Timestamp dateandtime){

      //  this.askhelpid=askhelpid;
        this.subject1=subject1;
        this.problem_description=problem_description;
        this.dateandtime=dateandtime;
    }

//    public String getDateandtime() {
//        return dateandtime;
//    }
//
//    public void setDateandtime(String dateandtime) {
//        this.dateandtime = dateandtime;
//    }

    // private Timestamp dateandtime;


    public int getAskhelpid() {
        return askhelpid;
    }

    public void setAskhelpid(int askhelpid) {
        this.askhelpid = askhelpid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getSubject() {
        return subject1;
    }

    public void setSubject(String subject) {
        this.subject1= subject;
    }

    public String getProblem_description() {
        return problem_description;
    }

    public void setProblem_description(String problem_description) {
        this.problem_description = problem_description;
    }

   public Timestamp getDateandtime() {
        return dateandtime;
    }

    public void setDateandtime(Timestamp dateandtime) {
       this.dateandtime = dateandtime;
    }
}
