package test;

public class testClasss {

	public static void main(String[] args) {
		Object o = 9;
		ok(o);
	}
	
	
	public static <T> void ok(Object t) {
		System.out.println(t.getClass());
	}
}
