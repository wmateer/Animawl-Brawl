package Networking;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import GameEngine.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class chatWindowClient extends JFrame {
private JTextArea chatWindow;
private JScrollPane chatCase;
private JTextField userInput;
private JButton	submit;
private User uZero;
private User uOne;
private JPanel content;
private Socket mySocket;
private PrintWriter out;
private BufferedReader in;
private BufferedReader stdIn;

public chatWindowClient(User inZero, User inOne) {
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(500, 200, 1000, 600);
		getContentPane().setLayout(null);

		uZero=inZero;
		uOne=inOne;
		//initialize variables
		//chat window
		chatWindow=new JTextArea(100,100);
		chatWindow.setBackground(Color.white);
		chatWindow.setBounds(50, 50,400, 400);
		chatWindow.setLineWrap(true);
		chatWindow.setVisible(true);
		
		//scroll pane for chat area
		/*chatCase=new JScrollPane();
		chatCase.setVisible(true);
		chatCase.setBackground(Color.white);
		chatCase.setViewportView(chatWindow);
		*/
		//user input text feild
		userInput=new JTextField();
		userInput.setBounds(150, 500, 300, 50);
		userInput.setVisible(true);
		
		submit= new JButton("Submit");
		submit.addActionListener(new submitListner());
		submit.setBounds(50, 500, 100, 50);
		submit.setVisible(true);
		
		this.add(submit);
		this.add(chatWindow);
		//this.add(chatCase);
		this.add(userInput);
		this.setVisible(true);
		
		
		try {
			mySocket= new Socket("localhost", 1234);
			out= new PrintWriter(mySocket.getOutputStream());
			in= new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
			stdIn= new BufferedReader(new InputStreamReader(System.in));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*
String serverInput;
try {
	while((serverInput= stdIn.readLine()) !=null){
		out.println(userInput);
		System.out.println("server: " + in.readLine());
	}
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
		*/
	}
public class submitListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		String userIn= userInput.getText();
		String toAdd= uZero.getName()+": "+ userIn+"\n";
		userInput.setText("");
		chatWindow.append(toAdd);
		}
		}
}
