package test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import types.TypesPermission;
import types.exception.ExceptionLogin;
import utilisateur.User;

public class test {

	public static void main(String[] args) throws UnknownHostException, IOException, ExceptionLogin {
		User u = new User();
		u.login("test", "mdpTest");
		System.out.println(u.getPermission());
		System.out.println(u.getInfo());

	}

}
