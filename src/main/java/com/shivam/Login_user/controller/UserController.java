package com.shivam.Login_user.controller;

import java.time.LocalDate;
import java.util.Scanner;

import com.shivam.Login_user.dao.UserDao;
import com.shivam.Login_user.entity.User;
import com.shivam.Login_user.service.UserService;

/**
 * Hello world!
 */
public class UserController {
	public static void main(String[] args) {

		UserDao dao = new UserDao();
		UserService service = new UserService();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. TO LOGIN INTO YOUR EXISTING ACCOUNT\n" + "2. TO MAKE YOUR NEW ACCOUNT\n"
					+ "3. TO EXIT THE APPLICATION");
			int option = sc.nextInt();

			switch (option) {
			case 1:
				while (true) {
					System.out.println("ENTER THE USERNAME");
					String uName = sc.next();
					System.out.println("ENTER THE PASSWORD");
					String pas = sc.next();
					if (service.loginUser(uName, pas)) {
						System.out.println("LOGGED IN SUCCESSFULLY");
						break;
					} else {
						System.out.println("CHECK YOUR USERNAME AND PASSWORD");
					}
				}
				break;

			case 2:
				System.out.println("ENTER THE YOUR NAME");
				sc.nextLine();
				String Name = sc.nextLine();
				System.out.println("ENTER THE USERNAME");
				String userName = sc.next();
				System.out.println("ENTER THE ID FOR THE USER");
				int id = sc.nextInt();
				System.out.println();
				System.out.println("LOGIN DATE WILL BE GENERATED AUTOMATICALLY");
				System.out.println();
				LocalDate date = LocalDate.now();
				while (true) {
					System.out.println("ENTER THE PASSWORD\n" + "* PASSWORD SHOULD BE ALPHA NUMERIC");
					String password = sc.next();
					User user = new User(id, Name, userName, password, date);
					boolean a = service.checkPassword(user);
					if (a) {
						System.out.println("SUCCESSFULLY MADE YOUR NEW ACCOUNT");
						break;
					} else {
						System.out.println("ENTER THE CORRECT PASSWORD");
					}
				}
				break;
			case 3:
				System.out.println("THANK YOU.....");
				return;

			}
		}

	}
}
