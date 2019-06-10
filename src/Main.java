import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 


public class Main extends JPanel {

	public static int xStart = 100;
	public static int yStart = 30;
	public static int xBounds = 1750;
	public static int yBounds = 1000;
	
	public static String name;
	public static String age;
	public static String msg1;
	public static String msg2;
	
	public static String filePath = "happy_birthday_song.wav";
	
	public static Scanner scan = new Scanner(System.in);
	public static final Font f = new Font("Monospaced", Font.PLAIN, 50); 
	
	public static void main(String[] args) throws LineUnavailableException, UnsupportedAudioFileException, IOException {

		name = Main.getInput("Enter the name of the person who's birthday it is");
		age = Main.getInput("How old will this individual be?");
		msg1 = "Happy Birthday " + name + "!";
		msg2 = "You are " + age + " years old!!! DAYUM SON";
		
		
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
		
		// plays the audio input I hope
		// yes it does! Plays the sound file given by filePath
		AudioInputStream ais = AudioSystem.getAudioInputStream(new File(filePath));
		AudioFormat format = ais.getFormat();
		DataLine.Info info = new DataLine.Info(Clip.class, format);
		Clip clip = (Clip) AudioSystem.getLine(info);
		//System.out.println(ais);
		clip.open(ais);
		clip.start();
	}

	// generic method to get input
	public static String getInput(String msg)
	{
		System.out.println(msg);
		String input = scan.next();
		return input;
	}
	
	// this draws the window
	public void paintComponent(Graphics g)
	{
		Dimension d = this.getSize();
		g.setColor(Color.BLACK);
		g.fillRect(0,0,xBounds, yBounds);
		g.setColor(Color.WHITE);
		g.setFont(f);
		drawCenteredString(msg1, d.width, d.height, g, -100);
		drawCenteredString(msg2, d.width, d.height, g, 100);
		
	} 
	
	// draws the string centered in on the screen
	public void drawCenteredString(String s, int w, int h, Graphics g, int yOffset) {
	    FontMetrics fm = g.getFontMetrics();
	    int x = (w - fm.stringWidth(s)) / 2;
	    int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
	    g.drawString(s, x, y+yOffset);
	  }
	
	
	
	
	
	
	
}
