package exercise1;

import java.util.Random;

import javax.swing.JOptionPane;

public class QuestionBank {
	
	private Random rand;
	private String questions[];
	private String answers[][];
	private char rightAnswers[];
	
	public QuestionBank() 
	{
		rand = new Random();
		//questions
		questions = new String[] {"Whay IDE do we use in class?","Why do we need encapsulation?","What is a default value for integer?","What is a right placeholder for method that doesn't return any values?","What is the right way of outputing the text to console?","What is the main advantage of Java?"};
		//answers
		answers = new String[6][4];
		answers[0][0] = "IntelliJ IDEA"; 
		answers[0][1] = "NetBeans"; 
		answers[0][2] = "Visual Studio"; 
		answers[0][3] = "Eclipse"; //right
		answers[1][0] = "Data hiding"; //right
		answers[1][1] = "Data managing"; 
		answers[1][2] = "Type of class on Java"; 
		answers[1][3] = "FUnction to open the browser";
		answers[2][0] = "1"; 
		answers[2][1] = "null"; 
		answers[2][2] = "0"; //right
		answers[2][3] = "01"; 
		answers[3][0] = "noval"; 
		answers[3][1] = "void"; //right
		answers[3][2] = "String"; 
		answers[3][3] = "anyval"; 
		answers[4][0] = "JOptionPane.showMessageDialog(Text);"; 
		answers[4][1] = "Console.print(text);"; 
		answers[4][2] = "cout<<text<<endl;"; 
		answers[4][3] = "System.out.print(text);"; //right
		answers[5][0] = "Is avaliable for Mac users"; 
		answers[5][1] = "It doesn't requires IDE"; 
		answers[5][2] = "Cross-platform ";//right 
		answers[5][3] = "Has unicorns";
		//right answers
		rightAnswers = new char[] {'d','a','c','b','d','c'};
	}
	
	public int simulateQuestions() 
	{
		String question;
		int numberOfRightAnswers = 0;
		for(int i=0; i < questions.length; i++) 
		{
			//creating string with questions and options for answer
			question = (i+1) + ") " + questions[i];
			for (int j = 0; j < 4; j++)
			{	//options for answer
				String k = "";
				switch (j) {
				case 0:
					k = "a";
					break;
				case 1:
					k = "b";
					break;				
				case 2:
					k = "c";
					break;
				case 3:
					k = "d";
					break;
				default:
					break;
				}
				question += "\n"+ k + ") " + answers[i][j];
			}
			//dialog input window
			String response = JOptionPane.showInputDialog(question);
			//counting right answers
			numberOfRightAnswers += checkAnswer(i,response.charAt(0));
		}
		
		return numberOfRightAnswers;
	}
	
	public int checkAnswer(int num, char ans) 
	{
		//checks answer
		if(rightAnswers[num] == ans) 
		{
			generateMessage(true);
			return 1;
		}
		else 
		{
			generateMessage(false);
			return 0;
		}
	}

	public void generateMessage(boolean answer) 
	{
		//random generator of congratulatory message 
		if(answer) {
			switch (rand.nextInt(4)) {
			case 0:
				JOptionPane.showMessageDialog(null,"Excellent!");
				break;
			case 1:
				JOptionPane.showMessageDialog(null,"Good!");
				break;
			case 2:
				JOptionPane.showMessageDialog(null,"Keep up the good work!");
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"Nice work!");
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
	
	public void inputAnswer() 
	{
		JOptionPane.showMessageDialog(null,"Welcome to the test app!\nLet's get started.");
		//calling method to start the test
		double rightAnswers = simulateQuestions();
		//results output
		JOptionPane.showMessageDialog(null,String.format("Thank you for taking the test!\nYour result: \n\tPercentage: %.2f%%\n\tCorrect answers: %.0f\n\tIncorrect answers: %.0f",((rightAnswers/6)*100),rightAnswers,(6-rightAnswers)));
	}
}
