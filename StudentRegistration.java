package ExceptionCollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class studentnotexception extends Exception{
	public studentnotexception(String message) {
		super(message);
	}
}

class studentnotfound extends Exception{
	public studentnotfound(String message) {
		super(message);
	}
}

class student {
	int id;
	String name;
	String coursename;
	
	student(int id,String name,String coursename){
		this.id  = id;
		this.name = name;
		this.coursename = coursename;
	}
	
	public String toString() {
		return "Student ID : " + id + "Student name : " + name + "Course name :" + coursename; 
	}
}



public class StudentRegistration {
	private HashMap<Integer , student> stud = new HashMap<>();
	private ArrayList<student> registeredstudent = new ArrayList<>();
	
	public void registernewstudent(student s)  {
		stud.put(s.id , s);
		System.out.println("New ID added : " + s);
	}
	
	public void removeregiterstud(int id) throws studentnotexception{
		if(!stud.containsKey(id)) {
			throw new studentnotexception("student not found !!" + id);
		}
		
		stud.remove(id);
		System.out.println("Student Removedd !!!");
	}
	
	public void searchstudent(int id) throws studentnotexception{
		if(!stud.containsKey(id)) {
			System.out.println("the student is not found !!" + id);
		}
		
		stud.get(id);
		System.out.println("Student is : " + stud);
	}
	
	public void displayall() {
		if(stud.isEmpty()) {
			System.out.println("the student list is empty!!!!");
		}else {
			System.out.println("the available students aare !!!");
			for(student stud : stud.values()) {
				System.out.println(stud);
			}
		}
	}
	
	public static void main(String[]args) {
		StudentRegistration studentreg = new StudentRegistration();
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		
		while(!exit) {
			System.out.println("\n--- Student Registration ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            try {
            	int choice = Integer.parseInt(sc.nextLine());
            	
            	switch(choice) {
            	case 1 : 
            		System.out.println("enter the student ID : ");
            		int id = Integer.parseInt(sc.nextLine());
            		System.out.println("enter the student name : ");
            		String name = sc.nextLine();
            		System.out.println("enter the course name : ");
            		String coursename = sc.nextLine();      
            		studentreg.registernewstudent(new student(id,name,coursename));
            		break;
            	case 2:
            		System.out.println("remove the student!!");
            		studentreg.removeregiterstud(Integer.parseInt(sc.nextLine()));      
            		break;
            	case 3 : 
            		System.out.println("search for the student!!!");
            		studentreg.searchstudent(Integer.parseInt(sc.nextLine()));
            		break;
            	case 4:
            		studentreg.displayall();
            		break;
            	case 5:
            		System.out.println("thank you for registering");
            		exit = true;
            		break;
            	default : 
            		System.out.println("enter the valid choice");
            	}
        
            	}catch(studentnotexception e) {
            		System.out.println("error :::: " + e.getMessage());
            	}catch(NumberFormatException e) {
            		System.out.println("Format of the number is invalid : " + e.getMessage());
            	}
            }
		sc.close();
		}
		
		
	}
	
