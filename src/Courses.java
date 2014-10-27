
public class Courses {
	public College courseCollege ;
	public int idCourse;
	public String name;
	public String description;
	public int maxNumOfStudent;
	public int numOfLectures;
	public Students[] studentsInCourse;
	public Professor professorIncourse;
	public Departments courseDepartment;
	private int numOfStudent;
/////////////////////////////////////////////////////////////////////------------------------------------>>>>>>>>>>>>>>>>>>>Constructor
	public Courses(String namCourse, String descriptionCourse,
			int maxNumOfStudentCourse, int numOfLecturesCorse, String department) {
		courseCollege = College.getmycollege() ;
		this.idCourse = courseCollege.coursNum + 1 ; 
		this.name = namCourse;
		this.description = descriptionCourse;  
		this.maxNumOfStudent = maxNumOfStudentCourse;
		this.numOfLectures = numOfLecturesCorse;
		this.courseCollege.coursNum ++ ;
		this.studentsInCourse = new Students[50];
		
		if (this.courseCollege.findDepartments(department)){
			this.courseDepartment = this.courseCollege.getStoreDepartments() ;
		}else {
			System.out.println("department err");
			return ;
		}
//		 add course in his department and his college
		this.courseDepartment.departmentCourse[this.idCourse] = this;
		this.courseDepartment.updateDataCourses();
		this.courseDepartment.numOfCourses++;
		System.out.println("goode");
	}

	// ///////////////////////////////////////////////////////////
	// i want make this method void
	public void assignProfessor(Professor pro) {
//		if (this.professorIncourse.equals(pro)) {
//			return ;
//		} else {
			this.professorIncourse = pro;
//			this.updatedData() ;
			return;
//		}
	}
	// //////////////////////////////////////////////////////////////
	public void unassignProfessor(Professor pro) {
		this.professorIncourse = null;

	}
	// //////////////////////////////////////////////////////////////
	public boolean isAssigned() {
		if (this.professorIncourse == null) {
			return false;

		} else {
			return true;
		}
	}
	// //////////////////////////////////////////////////////////////
	public String professorName (){
		if (this.isAssigned()== true) {
			return this.professorIncourse.fullName();
			
		}else {
			String s = " no professor assigned ";
			return s;
		}
	}
	// ///////////////////////////////////////////////////////////////
	public boolean isFull (){
		if (this.maxNumOfStudent== this.numOfStudent) {
			return true ;
			
		}else {
			return false ;
		}
		
	}
	// ///////////////////////////////////////////////////////////////
	public boolean enroll (Students s){
		if( this.isFull()) {
			System.out.println("course is full ");
			return false ;

		}else if (this.courseDepartment.equals(s.studentDepartment)) {
			
			this.studentsInCourse[this.numOfStudent+1]= s ;
			this.studentsInCourse[this.numOfStudent+1].indexStudentCourse = this.numOfStudent+1 ;
			this.studentsInCourse[this.numOfStudent+1].enroll = true ;
			this.studentsInCourse[this.numOfStudent+1].studentCourse = this ;
			this.updatedData() ;
			this.courseCollege.saveingNewStudentAfter(this.studentsInCourse[this.numOfStudent+1].idStudent);
			this.numOfStudent ++ ;
			return true ;
		}else {
			System.out.println("student not in this Department");
			return false ;
			
		}
		
	}
	// ///////////////////////////////////////////////////////////////
	public void updatedData (){
		this.courseDepartment.departmentStudent [this.idCourse]= this.studentsInCourse ;
		this.courseDepartment.updatedDataStudent();
	}
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.Report
	public void report (){
		System.out.println("Description: "+ this.description);
		System.out.println("Department: "+this.courseDepartment.name);
		System.out.println("Lectures: "+ this.numOfLectures);
		System.out.println("Max Students: "+ this.maxNumOfStudent);
		System.out.println("Students: "+this.numOfStudent);
		String status = "" ;
		if(this.isFull()){
			status= "Full";
		}else {
			status= "Not Full";	
		}
		System.out.println("Status: "+ status);
		if (this.isAssigned()) {
			status= this.professorName();
			
		}else {
			status= "null";
		}
		System.out.println("Professor: "+ status);
	}
	
	
	// ///////////////////////////////////////////////////////////////
	public int getNumOfStudent() {
		return numOfStudent;
	}
	// //////////////////////////////////////////////////////////////
}
