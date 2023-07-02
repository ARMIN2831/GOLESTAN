package data;

import java.util.ArrayList;

public class student extends person{
    ArrayList<String> Lesson = new ArrayList<>();
    ArrayList<String> professor = new ArrayList<>();
    ArrayList<int[]> evo = new ArrayList<>();
    ArrayList<String> evoName = new ArrayList<>();


    public student(int ID, String name, String lastName) {
        super(ID,name,lastName);
    }
    public ArrayList<String> getLesson() {
        return Lesson;
    }

    public void setLesson(String lesson) {
        this.Lesson.add(lesson);
    }

    public ArrayList<String> getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor.add(professor);
    }


    public ArrayList<int[]> getEvo() {
        return evo;
    }

    public void setEvo(int[] evo) {
        this.evo.add(evo);
    }

    public ArrayList<String> getEvoName() {
        return evoName;
    }

    public void setEvoName(String evoName) {
        this.evoName.add(evoName);
    }
}
