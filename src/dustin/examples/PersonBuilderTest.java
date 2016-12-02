package dustin.examples;


public class PersonBuilderTest {
	public static void main(String[] args) {
		PersonBuilder p = new PersonBuilder().setNewLastName("Nguyen").setNewFirstName("Thuat");
		System.out.println(p);
	}
}
