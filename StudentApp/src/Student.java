//Creates a student class with name, age, town and gpa
//Declare constructors, getters and setters
public class Student {
	private String name;
	private String town;
	private int age;
	private double gpa;
	
	public Student(String name, String town, int age, double gpa){
		this.name = name;
		this.town = town;
		this.age = age;
		this.gpa = gpa;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {		
			this.name = name;			
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if((age < 18)||(age > 100))
		{
			throw new IllegalArgumentException();
		}else{
			this.age = age;
		}		
	}	
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		if((gpa < 0.0)||(gpa > 4.0)){
			throw new IllegalArgumentException();
		}else{
			this.gpa = gpa;
		}		
	}

}
