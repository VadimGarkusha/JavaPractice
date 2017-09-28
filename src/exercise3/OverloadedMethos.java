package exercise3;

public class OverloadedMethos {
	
	public static void main(String[] args) 
	{
		//circle
		findObjectArea(5.7);
		//rectangle
		findObjectArea(3, 6.9);
		//triangle
		findObjectArea(12, 10.7, 18);
	}
	
	//method for circle
	public static void findObjectArea(double radius) 
	{
		System.out.printf("Area of the circle is %.2f square centimeters\n\n", radius*radius*Math.PI);
	}
	//method for rectangle
	public static void findObjectArea(double side1, double side2) 
	{
		System.out.printf("Area of the rectangle is %.2f square centimeters\n\n", side1*side2);
	}	
	//method for triangle
	public static void findObjectArea(double side1, double side2, double side3) 
	{
		double p = (side1 + side2 + side3)/2;
		System.out.printf("Area of the triangle is %.2f square centimeters\n\n", Math.sqrt(p * (p - side1) * (p - side3) *(p - side2)));
	}
}
