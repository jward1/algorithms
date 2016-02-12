import java.util.Random;

public class GenerateRandomIntegers
{
	public static void main(String[] args)
	{
		int num = Integer.parseInt(args[0]);
		Random rand = new Random();

		System.out.println(num);
		for (int i=0; i<num; i++) { 
			System.out.println(rand.nextInt(2000000)-1000000); 
		}
	}
}