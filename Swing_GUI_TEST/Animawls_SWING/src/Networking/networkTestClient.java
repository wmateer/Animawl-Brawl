package Networking;

import java.awt.Component;

import javax.swing.*;

import GameEngine.User;

public class networkTestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
;
		User Henry = new User("Henry","henry");
		User Billy = new User("Billy","billy");

		chatWindowClient test= new chatWindowClient(Henry, Billy);

	}

}
