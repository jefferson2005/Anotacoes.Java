package Objetos;

import javax.swing.JFrame;

import Class.DrawSmiley;

public class DrawSmilewyTest {

	public static void main(String[] args) {

		DrawSmiley panel = new DrawSmiley();
		JFrame application = new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(230, 250);
		application.setVisible(true);
	}

}