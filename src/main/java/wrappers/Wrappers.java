package wrappers;

public class Wrappers {
    
    public static void main(String[] args) {
       	Integer i = new Integer(500);
       	Integer j = new Integer(500);

       	//------------------- автораспаковка

       	int z = i + 10;
       	// эквивалентно 
       	z = i.intValue() + 10;

       	System.out.println(z);

		System.out.println("------------------- автораспаковка");
       	System.out.println(i == j); // false, разные обьекты
		System.out.println(i == j + 0); // true, автораспаковка до int
		System.out.println(i == 500); // true, автораспаковка

		//------------------- выделенная байтовая зона -128...127

		Integer x = new Integer(10);
       	Integer y = new Integer(10);

		System.out.println("------------------- выделенная байтовая зона");
       	System.out.println(x == y); // true, байтовая зона
		System.out.println(x == 5); // true, байтовая зона
		// after checking it's FALSE for both

		//------------------- инкремент, декремент

		i = new Integer(500);
		j = i;

		System.out.println("------------------- инкремент, декремент");
		System.out.println(i == j); // true, ссылки на один обьект
		System.out.println(i++);
		System.out.println(j++);

		System.out.println(i == j); // false, после инкремента пересоздались обьекты

		//------------------- лонг

		Integer ten = 10;
		Long lten = 10L;

		System.out.println("------------------- лонг");
		// System.out.println(ten == lten); // compilation error
		System.out.println(ten + 0 == lten); // автораспаковка до long
		System.out.println(ten.equals(lten)); // false 
		System.out.println(ten.equals(10L)); // false
		System.out.println(lten.equals(10)); // false
    }
}
