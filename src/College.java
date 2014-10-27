import java.util.Scanner;

public class College {
	public int studentNum;
	public int prfessorNum;
	public int coursNum;
	public int departmentNum;
	public Students[][][] studentInCollege;
	public Professor[] professorInCollege;
	public Departments[] departmentsInCollege;
	public Courses[][] coursesInInCollege;
	private Students storeStudent;
	private Professor storeProfessor;
	private Courses storeCourses;
	private Departments storeDepartments;
	public Students[] newStudent;
	public Scanner input;
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.
		// to only object of College  constructor
		private static volatile College mycollege;

		private College() {
			this.studentInCollege = new Students[50][50][50];
			this.professorInCollege = new Professor[50];
			this.departmentsInCollege = new Departments[50];
			this.coursesInInCollege = new Courses[50][50];
			// this.newStudent = new Students [50];
			input = new Scanner(System.in);
		}
		
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> to get the object of college
		public static College getmycollege() {
			if (mycollege == null) {
				mycollege = new College();
			}
			return mycollege;
		}
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.
	

	public boolean findProfessor(String s) {
		for (int i = 1; i <= this.prfessorNum; i++) {
			if (this.professorInCollege[i] == null) {
				continue;
			}
			if (this.professorInCollege[i].fullName().equals(s)) {
				this.storeProfessor = this.professorInCollege[i];
				return true;
			}

		}
		System.out.println("not found");
		return false;
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public boolean findStudent(String s) {
		for (int i = 0; i < 50; i++) {
			if (this.studentInCollege[i] == null) {
				continue;
			}
			for (int j = 0; j < 50; j++) {
				if (this.studentInCollege[i][j] == null) {
					continue;

				}
				for (int z = 1; z < 50; z++) {
					if (this.studentInCollege[i][j][z] == null) {
						continue;
					}
					if (this.studentInCollege[i][j][z].fullName().equals(s)) {
						this.storeStudent = this.studentInCollege[i][j][z];
						return true;
					}

				}

			}
		}
		System.out.println("not found");
		return false;

	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public boolean findDepartments(String s) {
		for (int i = 1; i < 50; i++) {
			if (this.departmentsInCollege[i] == null) {
				continue;
			} else if (this.departmentsInCollege[i].name.equals(s)) {
				this.storeDepartments = this.departmentsInCollege[i];
				return true;
			}
		}
		System.out.println("not found");
		return false;
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public boolean findCourse(String s) {
		for (int i = 1; i < 50; i++) {
			if (this.coursesInInCollege[i] == null) {
				continue;
			}
			for (int j = 1; j < 50; j++) {
				if (this.coursesInInCollege[i][j] == null) {
					continue;
				} else if (this.coursesInInCollege[i][j].name.equals(s)) {
					this.storeCourses = this.coursesInInCollege[i][j];
					return true;
				}

			}
		}
		System.out.println("not found");
		return false;
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>that to don't lost any data by update methods
	public void saveingNewStudentBefor() {
		this.newStudent = this.studentInCollege[0][0];
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public void saveingNewStudentAfter(int idstud) {
		this.newStudent[idstud] = null;
		this.studentInCollege[0][0] = this.newStudent;
	}

	

	
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> function to take input from user
	public String inputText (){
		return this.input.nextLine();
	}
	
	public int inputNumber (){
		return  this.input.nextInt() ;
	}
	
	public double inputDouble (){
		return this.input.nextDouble();
		
	}
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	Report college
	public void report (){
		System.out.println(this.prfessorNum + " Professors");
		System.out.println(this.studentNum +" Students");
		System.out.println(this.departmentNum + " Departments");
		System.out.println(this.coursNum +" Courses");
		return ;
	}
	
	
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
//	many getter that i want
	public Students getStoreStudent() {
		return storeStudent;
	}

	public Professor getStoreProfessor() {
		return storeProfessor;
	}

	public Courses getStoreCourses() {
		return storeCourses;
	}

	public Departments getStoreDepartments() {
		return storeDepartments;
	}
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//	public Departments getdepartment(String nam){
//		if(this.findDepartments(nam)){
//			return this.getStoreDepartments() ;
//		}else{
//			System.out.println("");
//			return null;
//		}
//	}

}
