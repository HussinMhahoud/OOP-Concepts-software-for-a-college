import java.util.Arrays;
import java.util.Scanner;

import javax.swing.DebugGraphics;

public class StartProg {

	/**
	 * @param args
	 */
	private static boolean testOprat(char[] mainop, char operat) {
		for (int i = 0; i < mainop.length; i++) {
			if (operat != mainop[i]) {
				continue;
			} else {
				return true;
			}

		}
		return false;
	}

	private static void enterOperation() {
		System.out.println("============");
		System.out.println("Enter Operation");
		System.out.println("============");
		return;
	}

	private static char checinput(char[] operat, College myCollege) {
		char Operat;
		while (true) {
			String operation = myCollege.inputText();
			if (testOprat(operat, operation.charAt(0))
					&& operation.length() == 1) {
				Operat = operation.charAt(0);
				break;
			} else {
				System.out.println("please tray agien");
				continue;
			}
		}
		return Operat;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// only object of college
		College myCollege = College.getmycollege();
			Departments newDepartment;
		Courses newCourse;
		Professor newProfessor;
		Students newStudent;
		String nameDep; // to inside it inputs
		String nameStud;
		String nameCours;
		String nameProfes;
		boolean toQuitProgram = true; // to ending program when it = false
		char[] mainOperatin = { '1', '2', '3', '4', '5', '6' };
		while (toQuitProgram) {
			System.out.println("Welcome to our university!");
			System.out.println("Operations:");
			System.out.println("1- College");
			System.out.println("2- Department");
			System.out.println("3- Course");
			System.out.println("4- Professor");
			System.out.println("5- Student");
			System.out.println("6- Quit");
			enterOperation();
			char firstOperat;
			char secondOperat;
			boolean caseCollege = true;
			boolean caseDepartment = true;
			boolean caseStudent = true;
			boolean caseProfessor = true;
			boolean caseCourse = true;
			firstOperat = checinput(mainOperatin, myCollege);
			switch (firstOperat) {
			// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>College
			// case
			case '1':
				while (caseCollege) {

					System.out.println("1- College");
					System.out.println("a) Number of Departments");
					System.out.println("b) Number of Courses");
					System.out.println("c) Number of Professors");
					System.out.println("d) Number of Students");
					System.out.println("e) Report");
					System.out.println("f) Back");
					enterOperation();
					char[] collegeOperation = { 'a', 'b', 'c', 'd', 'e', 'f' };
					secondOperat = checinput(collegeOperation, myCollege);
					switch (secondOperat) {
					case 'a':
						System.out.println(myCollege.departmentNum
								+ " Departments");
						break;
					case 'b':
						System.out.println(myCollege.coursNum + " Courses");

						break;
					case 'c':
						System.out.println(myCollege.prfessorNum
								+ " Professors");
						break;
					case 'd':
						System.out.println(myCollege.studentNum + " Students");
						break;
					case 'e':
						myCollege.report();
						break;
					case 'f':
						caseCollege = false;
						break;
					default:
						break;
					}
				}

				break; // that has case '1'
			// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
			case '2':
				while (caseDepartment) {
					System.out.println("2- Department");
					System.out.println("a) New");
					System.out.println("b) Number of Courses");
					System.out.println("c) Number of Students");
					System.out.println("d) Is Full");
					System.out.println("e) Enroll");
					System.out.println("f) Report");
					System.out.println("g) Back");
					enterOperation();
					char[] departmentOperation = { 'a', 'b', 'c', 'd', 'e',
							'f', 'g' };
					secondOperat = checinput(departmentOperation, myCollege);

					switch (secondOperat) {
					case 'a':
						System.out.println("Department Name:");
						String name = myCollege.inputText();
						System.out.println("Department Description:");
						String description = myCollege.inputText();
						System.out.println("Department Max Students:");
						int maxStud = myCollege.inputNumber();
						newDepartment = new Departments(name, description,
								maxStud);
						myCollege.inputText(); // to err in scanner input int
												// after string
						break;

					case 'b':
						System.out.println("Department");
						nameDep = myCollege.inputText();

						if (myCollege.findDepartments(nameDep)) {
							System.out
									.println("Number of Courses: "
											+ myCollege.getStoreDepartments().numOfCourses);
						} else {
							System.out
									.println("please tray agien after write corrict");
						}

						break;

					case 'c':
						System.out.println("Department");
						nameDep = myCollege.inputText();

						if (myCollege.findDepartments(nameDep)) {
							System.out.println("Number of Students: "
									+ myCollege.getStoreDepartments()
											.getNumOfStudent());
						} else {
							System.out
									.println("please tray agien after write corrict");
						}

						break;

					case 'd':
						System.out.println("Department");
						nameDep = myCollege.inputText();

						if (myCollege.findDepartments(nameDep)) {
							if (myCollege.getStoreDepartments().isFull()) {
								System.out.println("Full");
							} else {
								System.out.println("Not Full");
							}
						} else {
							System.out
									.println("please tray agien after write corrict");
						}
						break;

					case 'e':
						System.out.println("Department");
						nameDep = myCollege.inputText();

						if (myCollege.findDepartments(nameDep)) {
							System.out.println("Student");
							nameStud = myCollege.inputText();
							if (myCollege.findStudent(nameStud)) {
								if (myCollege.getStoreDepartments()
										.enrollStudent(
												myCollege.getStoreStudent())) { // that
																				// after
																				// run
																				// well
																				// print
																				// Congratulations
									System.out.println("Congratulations");
								} else {
									System.out.println("not enroll Student");
								}
							} else {
								System.out
										.println("please tray agien after write student corrict");
							}

						} else {
							System.out
									.println("please tray agien after write corrict");
						}
						break;

					case 'f':
						System.out.println("Department");
						nameDep = myCollege.inputText();

						if (myCollege.findDepartments(nameDep)) {
							myCollege.getStoreDepartments().report();
						} else {
							System.out
									.println("please tray agien after write corrict");
						}

						break;

					case 'g':
						caseDepartment = false;
						break;

					default:
						break;
					}
				}
				break; // that has case '2'
			// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
			case '3':
				while (caseCourse) {
					System.out.println("3- Course");
					System.out.println("a) New");
					System.out.println("b) Number of Students");
					System.out.println("c) Assign");
					System.out.println("d) Is Assigned");
					System.out.println("e) Professor Name");
					System.out.println("f) Is Full");
					System.out.println("g) Enroll");
					System.out.println("h) Report");
					System.out.println("i) Back");
					enterOperation();
					char[] courseOperation = { 'a', 'b', 'c', 'd', 'e', 'f',
							'g', 'h', 'i' };
					secondOperat = checinput(courseOperation, myCollege);

					switch (secondOperat) {
					case 'a':
						System.out.println("Course Name:");
						String coursname = myCollege.inputText();
						System.out.println("Course Description:");
						String descrip = myCollege.inputText();
						System.out.println("Cours Max Students:");
						int  maxStudent = myCollege.inputNumber();
						System.out.println("Course Lectures:");
						int numLenctu = myCollege.inputNumber();
						 myCollege.inputText();
						System.out.println("Department:");
						nameDep = myCollege.inputText();
						newCourse = new Courses(coursname, descrip, maxStudent, numLenctu, nameDep);

						break;
					case 'b':
						System.out.println("Course:");
						nameCours= myCollege.inputText();
						if (myCollege.findCourse(nameCours)) {
							System.out.println("Number of Students"+myCollege.getStoreCourses().getNumOfStudent());
						}else {
							System.out
							.println("please tray agien after write corrict");
				}
						

						break;
					case 'c':
						System.out.println("Course:");
						nameCours= myCollege.inputText();
						System.out.println("Professor");
						nameProfes = myCollege.inputText();
						if (myCollege.findCourse(nameCours)) {
							if(myCollege.findProfessor(nameProfes)){
							myCollege.getStoreCourses().assignProfessor(myCollege.getStoreProfessor());
								
							}else {
								System.out
								.println("please tray agien after write Professor corrict");
					}
						}else {
							System.out
							.println("please tray agien after write Course corrict");
				}

						break;
					case 'd':
						System.out.println("Course:");
						nameCours= myCollege.inputText();
						if (myCollege.findCourse(nameCours)) {
							if(myCollege.getStoreCourses().isAssigned()){
								System.out.println("Is Assigned");
							}else {
								System.out.println("Not Assigned");
							}
						}else {
							System.out
							.println("please tray agien after write Course corrict");
				}

						break;
					case 'e':
						System.out.println("Course:");
						nameCours= myCollege.inputText();
						if (myCollege.findCourse(nameCours)) {
							if(myCollege.getStoreCourses().isAssigned()){
								System.out.println(myCollege.getStoreCourses().professorName());
							}else {
								System.out.println("Not Assigned");
							}
						
						}else {
							System.out
							.println("please tray agien after write Course corrict");
				}

						break;
					case 'f':
						System.out.println("Course:");
						nameCours= myCollege.inputText();
						if (myCollege.findCourse(nameCours)) {
							if(myCollege.getStoreCourses().isFull()){
								System.out.println("Full");
							}else {
								System.out.println("Not Full");
							}
						}else {
							System.out
							.println("please tray agien after write Course corrict");
				}

						break;
					case 'g':
						System.out.println("Course:");
						nameCours= myCollege.inputText();
						System.out.println("Student");
						nameStud = myCollege.inputText();
						if (myCollege.findCourse(nameCours)) {
							if(myCollege.findStudent(nameStud)){
								myCollege.getStoreCourses().enroll(myCollege.getStoreStudent());
								System.out.println("Successfully");
							}else {
								System.out
								.println("please tray agien after write Student corrict");
							}
						}else {
							System.out
							.println("please tray agien after write Course corrict");
						}
						break;
					case 'h':
						System.out.println("Course:");
						nameCours= myCollege.inputText();
						if (myCollege.findCourse(nameCours)) {
							myCollege.getStoreCourses().report();
						}else {
							System.out
							.println("please tray agien after write Course corrict");
				}

						break;
						
						case 'i':
							caseCourse = false ;

							break;

					default:
						break;
					}
				}
				break;
			// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
			case '4':
				while (caseProfessor) {

					System.out.println("4- Professor");
					System.out.println("a) New");
					System.out.println("b) Display Salary");
					System.out.println("c) Get Raise");
					System.out.println("d) Report");
					System.out.println("e) Back");
					enterOperation();
					char[] professorOperation = { 'a', 'b', 'c', 'd', 'e' };
					secondOperat = checinput(professorOperation, myCollege);
					switch (secondOperat) {
					case 'a':
						System.out.println("Professor Firstname:");
						String fname = myCollege.inputText();
						System.out.println("Professor Lastname:");
						String lname = myCollege.inputText();
						System.out.println("Professor Telephone:");
						String tel = myCollege.inputText();
						System.out.println("Professor Address:");
						String adrs = myCollege.inputText();
						System.out.println("Professor Salary:");
						int salary = myCollege.inputNumber();
						myCollege.inputText();
						newProfessor = new Professor(fname, lname, tel, adrs,
								salary);

						break;
					case 'b':
						System.out.println("Professor");
						nameProfes = myCollege.inputText();
						if (myCollege.findProfessor(nameProfes)) {
							System.out
									.println("Salary: "
											+ myCollege.getStoreProfessor()
													.getSalary());
						} else {
							System.out
									.println("please tray agien after write corrict");
						}

						break;
					case 'c':
						System.out.println("Professor");
						nameProfes = myCollege.inputText();
						if (myCollege.findProfessor(nameProfes)) {
							System.out.println("Raise:");
							double raise = myCollege.inputDouble();
							myCollege.inputText();
							myCollege.getStoreProfessor().getRaise(raise);
							System.out
									.println("Salary: "
											+ myCollege.getStoreProfessor()
													.getSalary());
						} else {
							System.out
									.println("please tray agien after write corrict");
						}

						break;
					case 'd':
						System.out.println("Professor");
						nameProfes = myCollege.inputText();
						if (myCollege.findProfessor(nameProfes)) {
							myCollege.getStoreProfessor().report();
						} else {
							System.out
									.println("please tray agien after write corrict");
						}

						break;
					case 'e':
						caseProfessor = false;

						break;

					default:
						break;
					}
				}
				break;
			// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
			case '5':
				while (caseStudent) {
					System.out.println("5- Student");
					System.out.println("a) New");
					System.out.println("b) Report");
					System.out.println("c) Back");
					enterOperation();
					char[] studentOperation = { 'a', 'b', 'c' };
					secondOperat = checinput(studentOperation, myCollege);
					switch (secondOperat) {
					case 'a':
						System.out.println("Student Firstname:");
						String fname = myCollege.inputText();
						System.out.println("Student Lastname:");
						String lname = myCollege.inputText();
						System.out.println("Student Telephone:");
						String tel = myCollege.inputText();
						System.out.println("Student Address:");
						String adrs = myCollege.inputText();
						System.out.println("Student Age");
						int age = myCollege.inputNumber();
						myCollege.inputText();
						newStudent = new Students(fname, lname, tel, adrs, age);

						break;

					case 'b':
						System.out.println("Student");
						nameStud = myCollege.inputText();
						if (myCollege.findStudent(nameStud)) {
							myCollege.getStoreStudent().report();
						} else {
							System.out
									.println("please tray agien after write corrict");
						}

						break;
					case 'c':
						caseStudent = false;

						break;

					default:
						break;
					}

				}
				break;

			// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
			// To end program
			case '6':
				toQuitProgram = false;
				break;
			// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
			default:
				break;
			}

		} // end codenig

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>end program
	}

}
