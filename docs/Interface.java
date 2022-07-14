package Assignments;

	interface A{
		void Adisplay();
	}
	interface B{
		void B display();
	}
	
	class AB implements A,B
	{
		public void Adisplay() 
		{
		System.out.println("A display");
		}
		public void Bdisplay()
		{
		System.out.println("B display");
		}
	}
	
	public class Interface{
		public static void main(String[] args) 
		{
		AB obj=new AB();
		obj.Adisplay();
		obj.Bdisplay();
		}
	}
	
	

