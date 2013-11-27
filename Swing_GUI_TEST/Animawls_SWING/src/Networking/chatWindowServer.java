package Networking;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

import GameEngine.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class chatWindowServer extends JFrame {
	
	private JTextArea chatWindow;
	private JScrollPane chatCase;
	private JTextField userInput;
	private JButton	submit;
	private User uZero;
	private User uOne;
	private JPanel content;
	private Socket mySocket;
	private ServerSocket myServerSocket;
	private PrintWriter out;
	private BufferedReader in;

	

		public chatWindowServer(User inZero, User inOne) {
			this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Server");
			this.setBounds(500, 200, 500, 600);
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
			    myServerSocket = new ServerSocket(4444);
				mySocket = myServerSocket.accept();
				System.out.println("connection accepted");
				out= new PrintWriter(mySocket.getOutputStream(), true);
				in= new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
				out.println("it worked\n");
				int i=0;
				while(i==0){
				 if (in.ready()) {
		        chatWindow.append((in.readLine())); // Read one line and output it
				 }
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	public class submitListner implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
			String userIn= userInput.getText();
			String toAdd= "\n"+uZero.getName()+": "+ userIn+"\n";
			userInput.setText("");
			chatWindow.append(toAdd);
			out.println(toAdd);
			}
			}
}
