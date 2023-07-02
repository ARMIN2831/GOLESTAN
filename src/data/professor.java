package data;

import java.util.ArrayList;

public class professor extends person{
    private int ID;
    private String Status,NumTerm;
    ArrayList<String> Lesson = new ArrayList<>();

    public professor(String Name, String LastName, int ID, String NumTerm, String Status) {
        super(ID,Name,LastName);
        this.NumTerm = NumTerm;
        this.Status = Status;
    }



    public String getNumTerm() {
        return NumTerm;
    }

    public void setNumTerm(String NumTerm) {
        this.NumTerm = NumTerm;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public ArrayList<String> getLesson() {
        return Lesson;
    }

    public void setLesson(String lesson) {
        this.Lesson.add(lesson);
    }
}
