package data;

import java.util.ArrayList;

public class collage {
    int ID;
    String Name;
    ArrayList<String> professor = new ArrayList<>();
    ArrayList<String> Lesson = new ArrayList<>();
    ArrayList<String> student = new ArrayList<>();

    public collage(int ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public ArrayList<String> getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student.add(student);
    }
}
