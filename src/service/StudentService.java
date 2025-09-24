package service;
import model.Student;
import util.FileUtil;
import java.util.*;

public class StudentService {
    private final String FN="data/Student.txt";

    //Create:adding a record
    public void addRecord(Student s) {
        FileUtil.appendFile(FN, s.toString());
        System.out.println(s.getName() + "added");
    }

    //Read:getting all records
    public List<Student> getAllRecords() {
        List<String> lists=FileUtil.readFile(FN);
        List<Student> l=new ArrayList<>();
        for(String s:lists) {
            Student x=Student.fromString(s);
            if(x!=null) {
                l.add(x);
            }
        }
        return l;
    }

    //Update:updating the record
    public boolean updateRecord(int id, String name, String gender, String course) {
        List<Student> rec=getAllRecords();
        boolean update=false;

        for(Student i: rec) {
            if(i.getId()==id) {
                i.setName(name);
                i.setGender(gender);
                i.setCourse(course);
                update=true;
                break;
            }
        }
        List<String> data=new ArrayList<>();
        for(Student i:rec) {
            data.add(i.toString());
        }

        FileUtil.writeFile(FN, data);
        return update;
    }

    //Delete:deleting a record
    public boolean deleteRecord(int id) {
        List<Student> rec=getAllRecords();
    
        boolean del=false;
        for(int i=0; i<rec.size(); i++) {
            if(rec.get(i).getId()==id) {
                rec.remove(i);
                del=true;
                break;
            }
        }
        List<String> data=new ArrayList<>();
        for(Student i:rec) {
            data.add(i.toString());
        }
        FileUtil.writeFile(FN, data);

        return del;
    }
}
