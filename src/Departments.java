

public class Departments {
	public College departmentCollege ;
	public int idDepartments;
	public String name;
	public String description;
	public int maxNumOfStudent;
	public Students [][] departmentStudent ;
	public Courses [] departmentCourse ;
	public int numOfCourses ;
	private int numOfStudent;
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public Departments (String nam , String descr ,int maxstud  ) {       // Constructor 
		this.departmentCollege = College.getmycollege() ;
		this.name =nam ;
		this.description = descr ;
		this.maxNumOfStudent = maxstud ;
		this.idDepartments = this.departmentCollege.departmentNum +1 ;
		this.departmentCollege.departmentNum ++ ;
		this.departmentCollege.departmentsInCollege[this.idDepartments]= this ;
		this.departmentStudent = new Students [50][50];
		this.departmentCourse = new Courses [50];
	}
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public boolean enrollStudent (Students stud){
		if (this.numOfStudent == this.maxNumOfStudent) {
			System.out.println("is full");
			return false ;
		}else {
		this.departmentStudent [0][this.numOfStudent] = stud ;
		this.departmentStudent [0][this.numOfStudent].studentDepartment= this ;    // wiiiiiiiiiiiiiiiiiii
		this.numOfStudent ++ ;
		
		this.updatedDataStudent();
		return true ;
		}
		
	}
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public boolean isFull (){
		if (this.maxNumOfStudent == this.numOfStudent) {
			return true ;
		}else{
			return false ;
			
		}
	}
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public void report (){
		System.out.println("Description: "+this.description);
		System.out.println("Max Students: "+ this.maxNumOfStudent);
		System.out.println("Students: "+this.numOfStudent);
		String status = "" ;
		if(this.isFull()){
			status= "Full";
		}else {
			status= "Not Full";	
		}
		System.out.println("Status: "+ status);
		System.out.println("Courses: "+ this.numOfCourses);
		return;
	}
	// ///////////////////////////////////////////////////////////////
	public void updatedDataStudent (){
		this.departmentCollege.saveingNewStudentBefor() ;
		this.departmentCollege.studentInCollege [this.idDepartments]= this.departmentStudent;
	}
//	>>>>>>>>>>>>>>>>>>>>>>
	public void updateDataCourses (){
		this.departmentCollege.coursesInInCollege [this.idDepartments] = this.departmentCourse ;
	}
	public int getNumOfStudent() {
		return numOfStudent;
	}
	
	// ///////////////////////////////////////////////////////////////
	
}
