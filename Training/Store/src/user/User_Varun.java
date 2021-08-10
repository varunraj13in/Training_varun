package user;

import java.io.Console;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import store.Store_Varun;

public class User_Varun extends Store_Varun {
	private String role;
	private String username;
	private String password;

	public User_Varun(String role, String username, String password) {
		this.role = role;
		this.username = username;
		this.password = password;

	}

	static Map<String, User_Varun> user_details = new HashMap<>();

	static Scanner sc = new Scanner(System.in);

	public static void homeIntro() {
		System.out.println("\n------Home------\n");
		System.out.println("Hi,\n");
		System.out.println("1. Login");
		System.out.println("2. Register\n");
		System.out.println("Please choose one of the option:");
		String input = "";
		String lc = "";
		while (true) {
			input = (String) sc.next();
			lc = loginCheck(input);
			if (lc.equals("Invalid Input")) {
				System.err.println("invalid input enter again!");
				continue;
			} else {
				break;
			}
		}
	}

	public static String loginCheck(String input) {
		switch (input) {
		case "1":
			Login();
			break;
		case "2": {
			String r = "";
			while (true) {
				r = Register();
				if (r.equals("invalid input")) {
					System.err.println("Username already exists try another one!");
					continue;
				} else {
					break;
				}
			}
		}
			break;
		default:
			return "Invalid Input";
		}
		return "";
	}

	public static String Register() {
		Console console = System.console();
		System.out.println("\n------Register Window------\n");
		System.out.println("Enter Username: ");
		String username = sc.next();
		Iterator itr = user_details.keySet().iterator();
		while (itr.hasNext()) {
			String key = "" + itr.next();
			if (username.equals(user_details.get(key).username)) {
				return "invalid input";
			}
		}
		System.out.println("Enter Password: ");
		String password = sc.next();

		chooseRole();
		String role = sc.next();
		role = roleCheck(role);
		if (user_details.containsKey(role) == true) {
			while (user_details.containsKey(role) == true) {
				System.err.println("Role is already assigned try again!");
				chooseRole();
				while (true) {
					role = sc.next();
					role = roleCheck(role);
					if (role.equals("Invalid Input")) {
						System.err.println("invalid input try again!");
						continue;
					} else {
						break;
					}
				}
			}
		}

		User_Varun.user_details.put(role, new User_Varun(role, username, password));
		System.out.println("\n" + username + " successfully created!\n");
		homeIntro();
		return "";
	}

	public static String Login() {
		Store_Varun sv = new Store_Varun();
		System.out.println("\n------Login Window------\n");
		System.out.println("Enter Username: ");
		String u = sc.next();
		System.out.println("Enter Password: ");
		String p = sc.next();
		Iterator itr = user_details.keySet().iterator();
		while (itr.hasNext()) {
			String key = "" + itr.next();
			if (u.equals(user_details.get(key).username)) {
				if (p.equals(user_details.get(key).password)) {
					System.out.println("\n" + user_details.get(key).username + " Login successful!\n");
					System.out.println("------Welcome - " + user_details.get(key).role + "------\n");
					sv.userid = user_details.get(key).username;
					sv.userrole = user_details.get(key).role;
					return "";
				} else {
					System.err.println("Incorrect password try again!");
					Login();
				}
			}

		}
		if (user_details.containsValue(u) == false) {
			System.err.println("Username doesn't exist try again or Register.");
		}
		homeIntro();
		return "";
	}

	public static void chooseRole() {
		System.out.println("Choose a role from below: ");
		System.out.println("1. Admin");
		System.out.println("2. User");
		System.out.println("3. Manager");
	}

	public static String roleCheck(String role) {
		switch (role) {
		case "1":
			role = "Admin";
			break;
		case "2":
			role = "User";
			break;
		case "3":
			role = "Manager";
			break;
		default:
			return "Invalid Input";
		}
		return role;
	}

}
