package test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import types.Permission;
import utilisateur.User;

public class test {

	public static void main(String[] args) throws UnknownHostException, IOException {
		User u = new User();
		u.login("test", "mdpTest");
		System.out.println(u.getPermission());
		System.out.println(u.getInfo());

	}

}