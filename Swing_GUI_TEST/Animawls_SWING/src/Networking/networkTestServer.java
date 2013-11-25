package Networking;

import java.awt.Component;

import javax.swing.*;

import GameEngine.User;

public class networkTestServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
;
		User Henry = new User("Henry","henry");
		User Billy = new User("Billy","billy");

		chatWindowServer server= new chatWindowServer(Billy,Henry);

	}

}
