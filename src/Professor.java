
public class Professor extends HumanAttribute {
	public int idProfessor ;
	private  int salary ;
	public College professorCollege ;
	public Departments professorDepartment ;
	public Courses professorCourse ;
	
	
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.
	public Professor (String frNam , String lasNam ,String telNum , String addrs , int salary){
		this.professorCollege = College.getmycollege() ;
		this.idProfessor = professorCollege.prfessorNum + 1 ;
		this.fristName = frNam ;
		this.lastName = lasNam ;
		this.telephone = telNum ;
		this.address = addrs ;
		this.salary = salary ;
		professorCollege.prfessorNum ++ ;
		professorCollege.professorInCollege[this.idProfessor]= this ;

	}
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Report
	public void report(){
		System.out.println("Salary: "+this.salary);
		String test ;
		if (this.professorCourse==null) {
			test = "No Assigned";
		}else {
			test =  this.professorCourse.name;
		}
		System.out.println("Courses: "+ test);
		super.report();
		return;
	}
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public int getRaise (double ratio){
		
		this.salary += ratio* this.salary ;
		return this.salary ;
	}

	public int getSalary() {
		return salary;
	}



}
