

public class HumanAttribute {
	public String fristName ;
	public String lastName ;
	public String telephone ;
	public String address ;

	public  String fullName (){
		
	return	(this.fristName+ " " + this.lastName)  ;
		
	}
//	>>>>>>>>>>>>>>>>>>>>>>Report Student & Professor
	public void report(){
		System.out.println("Telephone: "+ this.telephone);
		System.out.println("Address: "+this.address);
		return;
	}

}
