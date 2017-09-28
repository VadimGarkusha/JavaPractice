package exercise2;

import java.util.Random;

import javax.swing.JOptionPane;

public class Lotto {
	
	private int numbers[];
	private Random rand;
	
	//constructor
	public Lotto() 
	{
		rand = new Random();
		numbers = new int[3];
		generateNumber();
	}

	//getter for array
	public int[] getNumbers() 
	{
		return numbers;
	}
	
	//generating and assigning array elements
	private void generateNumber() 
	{
		for (int i = 0; i < numbers.length; i++) 
		{
			numbers[i] = rand.nextInt(9)+1;
		}
	}
	

	public void generateMessage(boolean answer) 
	{
		//random generator of congratulatory message 
		if(answer) {
			switch (rand.nextInt(4)) {
			case 0:
				JOptionPane.showMessageDialog(null,"Excellent!\n You won!");
				break;
			case 1:
				JOptionPane.showMessageDialog(null,"Congratulations!\n You won!");
				break;
			case 2:
				JOptionPane.showMessageDialog(null,"Awesome!\n You won!");
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"Nice work!\n You won!");
				break;
			default:
				break;
			}
		}else {
			switch (rand.nextInt(4)) {
			case 0:
				JOptionPane.showMessageDialog(null,"No. Please try again.");
				break;
			case 1:
				JOptionPane.showMessageDialog(null,"Wrong. Try once more.");
				break;
			case 2:
				JOptionPane.showMessageDialog(null,"Don't give up!");
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"No. Keep trying.");
				break;
			default:
				break;
			}
		}
	}
	
	//method for starting the game
	public void startGame() 
	{
		int answer;
		JOptionPane.showMessageDialog(null,"Welcome to the Loto!\nLet's get started.");
		//loop to run the game 5 times
		for (int i = 0; i < 5; i++) 
		{
			System.out.println(numbers[0]+numbers[1]+numbers[2]);//console output of a right answer
			answer = Integer.valueOf(JOptionPane.showInputDialog("Run number " + (i+1) + "\nEnter the number please:"));
			//checking the answers
			if(answer == numbers[0]+numbers[1]+numbers[2]) 
			{
				generateMessage(true);
				break;
			}
			else 
			{
				if(i == 4)
					JOptionPane.showMessageDialog(null,"Sorry. Computer won :(");
				else
					generateMessage(false);
			}
			//calling the method to generate new numbers
			generateNumber();
		}
		JOptionPane.showMessageDialog(null,"Thank you for playing this game!!!");
	}
}
