package dustin.examples;


public class PersonTest {
	public static void main(String[] args) {
		// khởi tạo cho 3 param required thôi. Các param còn lại sẽ là null.
		Person p = new Person.PersonBuilder("Thuat", "Ben Tre", "Ben Tre State").createPerson();
		System.out.println(p);
		System.out.println("---------------------");
		// khởi tạo thêm có các param optional
		Person p2 = new Person.PersonBuilder("Hien", "Chau Duc", "Dong Nai State").lastName("Tran").createPerson();
		System.out.println(p2);
		System.out.println("---------------------");
	}
}
