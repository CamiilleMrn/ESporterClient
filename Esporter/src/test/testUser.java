package test;

import java.io.IOException;
import java.net.UnknownHostException;

import utilisateur.User;

public class testUser {

	public static void main(String[] args) throws UnknownHostException, IOException {
		User u = new User();
		
		for(int id : u.getData().getStables().keySet()) {
			System.out.println("Ecurie : "+u.getData().getStables().get(id)+"\n");
		}
	}
}
