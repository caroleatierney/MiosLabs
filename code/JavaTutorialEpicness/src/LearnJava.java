
public class LearnJava {

	public static void main(String[] args) {

		// Primitive data types - purple
//		int a = 5;
//		char b = 'i';
//		long c = 400;
//		double d = 3.2;
		
		// non primitive data types - not purple
		// . shows everything you can do to that variable
//		String name = "Susan";
//		System.out.println(name.toUpperCase());

//		addExclamationPoint("hot dogs");	
		
		String exclaim = addExclamationPoint("hot dogs");
		System.out.println(exclaim);
	}
	
//	public static void addExclamationPoint(String s) {
		public static String addExclamationPoint(String s) {
		//		System.out.println(s + "!");
		return s + "!";
//		System.out.println(name.toUpperCase());
//		String name = "Susan";
//		System.out.println(name.toUpperCase());
	}
}
