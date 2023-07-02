package data;

import java.util.ArrayList;

public class lesson {
    int ID;
    String LessonUnit;
    String Name;
    ArrayList<String> Collage = new ArrayList<>();

    public lesson(int ID, String lessonUnit, String name) {
        this.ID = ID;
        LessonUnit = lessonUnit;
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLessonUnit() {
        return LessonUnit;
    }

    public void setLessonUnit(String lessonUnit) {
        LessonUnit = lessonUnit;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<String> getCollage() {
        return Collage;
    }

    public void setCollage(String collage) {
        this.Collage.add(collage);
    }
}
