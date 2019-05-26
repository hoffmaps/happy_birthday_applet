import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JPanel {

	public static int xStart = 100;
	public static int yStart = 30;
	public static int xBounds = 1750;
	public static int yBounds = 1000;
	
	public static String name;
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		getNameOfPerson();
		
		// This stuff sets up the JFrame that is the game window
		/*Default things that shouldn't be changed */
		JFrame gameWindow = new JFrame("Game Window"); //declares a new frame and calls it Game Window
		gameWindow.setBounds(xStart, yStart, xBounds, yBounds); //  (x coord, y coord, distance in x, distance in y) uses top left corner
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when x is clicked, it closes
		gameWindow.setVisible(true);//makes the window visible
		
		// creates the main jPanel
		Main tempMain = new Main();
		// has to add the jPanel to the jFrame
		gameWindow.add(tempMain);
		
		
		// repaints the window using the paintComponent
		tempMain.repaint();
	}

	public static void getNameOfPerson()
	{
		System.out.println("What is the name of the birthday child??");
		name = scan.next();
		
	}
	
	
	// this draws the window
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0,0,xBounds, yBounds);
		g.setColor(Color.WHITE);
		g.drawString(name, 0, yBounds-55);
	}
	
	
	
	
	
}
