package Assignments;

public class Static {
	int i;
	static int j=13;
	void setvalue(int i) {
		this.i=i;
		
	}
	void show() {
		System.out.println(i);
		System.out.println(j);
	}
	static {
		System.out.println("static block");
	}
	public static void main(Strings[] args) {
		Static v=new Static();
		v.setvalue(123);
		v.show();
	}

}
