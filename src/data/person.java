package data;

import java.util.ArrayList;

public class person {
    int ID;
    String Name,LastName;

    public person(int ID, String name, String lastName) {
        this.ID = ID;
        Name = name;
        LastName = lastName;
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

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
