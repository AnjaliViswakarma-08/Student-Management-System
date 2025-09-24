package model;

public class Student {
    private int id;
    private String name;
    private String gender;
    private String course;

    public Student(int id, String name, String gender, String course) {
        this.id=id;
        this.name=name;
        this.gender=gender;
        this.course=course;
    }
    //getter and setter
    //id
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id=id;
    }
    //name
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name=name;
    }
    //gender
    public String getGender() {
        return this.gender;
    }
    public void setGender(String gender) {
        this.gender=gender;
    } 
    //course
    public String getCourse() {
        return this.course;
    }
    public void setCourse(String course) {
        this.course=course;
    }

    //convert toString to (id|name|gender|course)
    public String toString() {
        return id+"|"+name+"|"+gender+"|"+course;
    }

    public static Student fromString(String s) { //string input from the above method
        String str[]=s.split("\\|");
        if(str.length==4) {
            int id=Integer.parseInt(str[0]);
            String name=str[1];
            String gender=str[2];
            String course=str[3];
            return new Student(id, name, gender, course);
        }
        return null;
    }
}
