package store;
// Varun Raj Dounjeghar

import java.util.Scanner;

import billing.Bill_Varun;
import invoice.service.Invoice_Service;
import payment.Payment;
import product.service.Product_Service;
import user.User_Varun;

public class Store_Varun {

	String productTypes[] = { "Jeans", "shoes", "shirts" };
	String products[] = { "A", "B", "C" };
	float amount[] = { 100, 200, 300 };
	int quantity[] = { 1, 2, 3 };
	public static String userid;
	public static String userrole;

	public static String Intro() {
		System.out.println("Hi There, Welcome to Clothing Store");
		System.out.println("please select clothing for M/W: ");
		Scanner sc = new Scanner(System.in);
		String gender = sc.next();

		return gender;
	}

	public static String genderCheck(String s) {
		if (s.toLowerCase().equals("m") || s.toLowerCase().equals("w"))
			return s;
		else {
		}
		return s;
	}

	public static void productDisplay(String[] pt, String gender) {
		if (gender.toLowerCase().equals("m"))
			System.out.println("******Displaying Men Clothing*******");
		else
			System.out.println("******Displaying Women Clothing*****");

		for (int i = 0; i < pt.length; i++) {
			System.out.println("*	   " + (i + 1) + " " + pt[i] + "	 	   *");
		}
		System.out.println("* Please choose clothing type:     *");
		System.out.println("************************************");
	}

	public static String productChoice() {
		Scanner s = new Scanner(System.in);
		String sc = s.next();
		if (sc.equals("1") || sc.equals("2") || sc.equals("3"))
			return sc;
		else {
			System.err.println("Invalid input enter again!");
		}
		return sc;
	}

	public static void priceDisplay(String[] p, float[] amt, int[] q) {
		System.out.println("----------------------------");
		System.out.println("products  quantity  Amount ");
		System.out.println("----------------------------");
		for (int i = 0; i < p.length; i++) {
			System.out.println("   " + p[i] + "          " + q[i] + "     " + amt[i]);
		}
		System.out.println("----------------------------");

	}

	public static String itemChoice() {
		System.out.println("select product:");
		Scanner sc = new Scanner(System.in);
		String st = sc.next().toUpperCase();
		if (st.equals("A") || st.equals("B") || st.equals("C")) {
			return st;
		} else {
			return "product is not valid enter again!";
		}
	}

	public static String quantityInput(String productChosen) {
		System.out.println("select quantity:");
		Scanner s = new Scanner(System.in);
		String sc = s.next();

		if (sc.equals("1") || sc.equals("2") || sc.equals("3")) {
			int i = Integer.parseInt(sc);
			if ((productChosen.equals("A") && i == 1) || (productChosen.equals("B") && (i >= 1 && i <= 2))
					|| (productChosen.equals("C") && (i >= 1 && i <= 3)))
				return sc;
			else {
				return "quantity is not valid";
			}
		} else {
			return "quantity is not valid";
		}
	}

	public static void main(String[] args) {

		User_Varun uv = new User_Varun(null, null, null);
		uv.homeIntro();
		Store_Varun shop = new Store_Varun();
		String pt[] = shop.productTypes;
		String p[] = shop.products;
		float amt[] = shop.amount;
		int q[] = shop.quantity;
		while (userrole.equals("Admin")) {
			System.out.println("1. import product data\n2. check product data\n3. check invoice\n4. Exit Program");
			System.out.println("Please choose an option: ");
			Scanner sc = new Scanner(System.in);
			String choice = sc.next();

			switch (choice) {
			case "1":
				Product_Service.Data_Import();
				break;
			case "2":
				Product_Service.Data_Display();
				break;
			case "3":
				Invoice_Service.Invoice_Display();
				break;
			case "4":
				System.out.println("Store Exited.");
				System.exit(0);
				break;
			default:
				System.err.println("Invalid Input");
				continue;
			}
		}
		String gender = "";
		String check = "";
		String product_choice = "";
		while (true) {
			gender = Store_Varun.Intro();
			check = Store_Varun.genderCheck(gender);
			if (check.toLowerCase().equals("m") || check.toLowerCase().equals("w")) {
				break;
			} else {
				System.err.println("Invalid input");
				continue;
			}

		}
		Store_Varun.productDisplay(pt, gender);
		while (true) {
			product_choice = Store_Varun.productChoice();
			if (product_choice.equals("1") || product_choice.equals("2") || product_choice.equals("3")) {
				break;
			} else {
				continue;
			}
		}

		Store_Varun.priceDisplay(p, amt, q);

		String productChosen = "";
		String qty = "";

		while (true) {
			productChosen = Store_Varun.itemChoice();
			if (productChosen.equals("product is not valid enter again!")) {
				System.err.println("product is not valid enter again!");
				continue;
			} else {
				break;
			}
		}
		while (true) {
			qty = Store_Varun.quantityInput(productChosen);
			if (qty.equals("quantity is not valid")) {
				System.err.println("quantity is not valid enter again!");
				continue;
			} else {
				break;
			}
		}

		Bill_Varun b = new Bill_Varun();
		String billamount = "";

		while (true) {
			billamount = b.invoiceOutput(productChosen, qty, amt, p);
			if (billamount.equals("Invalid Input")) {
				System.err.println("invalid input enter again!");
				continue;
			} else {
				break;
			}
		}

		Invoice_Service iv = new Invoice_Service();
		iv.update(userid, productChosen, qty, billamount);
		
		
		System.out.println("\nStore Exited");
		System.exit(0);

	}

}
