package test;

import java.util.Scanner;

import types.Permission;
import utilisateur.User;

public class test {

	public static void main(String[] args) {
		User u = new User();
		u.login("test", "mdpTest");
		System.out.println(u.getPermission());
		System.out.println(u.getInfo());
		Scanner s = new Scanner(System.in);
		s.next();

	}

}
