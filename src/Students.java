public class Students extends HumanAttribute {
	public int idStudent;
	private int age;
	public College studentCollege;
	public Departments studentDepartment;
	public Courses studentCourse;
	public int indexStudentCourse;
	public boolean enroll;
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> constructor
	public Students(String frNam, String lasNam, String telNum, String addrs,
			int age) {
		this.studentCollege = College.getmycollege();
		this.idStudent = this.studentCollege.studentNum + 1;
		this.fristName = frNam;
		this.lastName = lasNam;
		this.telephone = telNum;
		this.address = addrs;
		this.age = age;
		this.studentCollege.studentNum++;
		this.studentCollege.studentInCollege[0][0][this.idStudent] = this;

	}
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Report
	public void report(){
		String test ;
		if (this.studentCourse==null) {
			test = "No Assigned";
		}else {
			test =  this.studentCourse.name;
		}
		System.out.println("Courses: "+ test);
		super.report();
		return;
	}
	public int getAge() {
		return age;
	}

	

}
