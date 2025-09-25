
import model.*;
import service.*;
import java.util.*;

import service.StudentService;

public class RecordApp {
    private static Scanner sc=new Scanner(System.in);
    private static StudentService ss=new StudentService();
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("---Student Record---");
            System.out.println("1.Add student");
            System.out.println("2.View student");
            System.out.println("3.Update student");
            System.out.println("4.Delete student");
            System.out.println("5.Exit");
            System.out.println("Enter your choice: ");
            choice=sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1->addRecord();
                case 2->viewRecord();
                case 3->updateRecord();
                case 4->deleteRecord();
                case 5->System.out.println("Byyee!");
                default->System.out.println("Invalid choice!!");
            }
        }while(choice!=5);
    }

    //add
    public static void addRecord() {
        System.out.println("Enter id: ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name: ");
        String name=sc.nextLine();
        System.out.println("Enter gender: ");
        String gender=sc.nextLine();
        System.out.println("Enter course: ");
        String course=sc.nextLine();

        Student s=new Student(id, name, gender, course);
        ss.addRecord(s);
        System.out.println("Student added successfully");
    }
    //view
    public static void viewRecord() {
        List<Student> stu=ss.getAllRecords();
        if(stu.isEmpty()) {
            System.out.println("No record available!");
        }
        else {
            System.out.println("Available record..");
            for(Student i:stu) {
                System.out.println(i.toString());
            }
        }
    }
    //update
    public static void updateRecord() {
        System.out.println("Enter the ID to update: ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name: ");
        String name=sc.nextLine();
        System.out.println("Enter gender: ");
        String gender=sc.nextLine();
        System.out.println("Enter course: ");
        String course=sc.nextLine();

        boolean up=ss.updateRecord(id, name, gender, course);
        if(up) {
            System.out.println("Record updated successfully");
        }
        else {
            System.out.println("Record not found!");
        }
    }
    //delete
    public static void deleteRecord() {
        System.out.println("Enter ID to delete: ");
        int id=sc.nextInt();
        sc.nextLine();

        boolean dl=ss.deleteRecord(id);
        if(dl) {
            System.out.println("Record deleted successfully");
        }
        else {
            System.out.println("Record not found!");
        }
    }
}
