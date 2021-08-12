import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Student {
	String A;
	int B;
	int C;

	public Student(String a, int b, int c) {
		this.A = a;
		this.B = b;
		this.C = c;
	}

	static public String PercentageOptions() {
		System.out.println("1. view pass percentage");
		System.out.println("2. view fail percentage");
		System.out.println("3. show overall pass/fail percentage for all years");
		Scanner sc = new Scanner(System.in);
		String choice = sc.next();

		switch (choice) {
		case "1":
			return "A";
		case "2":
			return "B";
		case "3":
			return "C";
		default:
			System.err.println("Invalid Input");
			System.exit(0);
		}
		return "";
	}

	static public String SubOptions() {
		System.out.println("1. for each year\n2. for all years \n3. based on gender – M/F");
		Scanner sc = new Scanner(System.in);
		String choice = sc.next();

		switch (choice) {
		case "1":
			return "1";
		case "2":
			return "2";
		case "3":
			return "3";
		default:
			System.err.println("Invalid Input");
			System.exit(0);
		}
		return "";
	}

	public static void main(String[] args) {

		HashMap<Integer, Student> myMap = new HashMap<Integer, Student>();
		myMap.put(1, new Student("M", 2001, 40));
		myMap.put(2, new Student("W", 2001, 60));
		myMap.put(3, new Student("M", 2002, 65));
		myMap.put(4, new Student("W", 2002, 35));
		myMap.put(5, new Student("M", 2003, 65));
		myMap.put(6, new Student("W", 2003, 35));
		myMap.put(7, new Student("M", 2004, 65));
		myMap.put(8, new Student("W", 2004, 35));

		System.out.println("gender 		year of passing 	pass percentage");
		System.out.println("-------------------------------------------------------");
		for (int i = 1; i <= myMap.size(); i++) {
			System.out.println(myMap.get(i).A + "\t\t\t" + myMap.get(i).B + "\t\t\t" + myMap.get(i).C);
			if (i % 2 == 0) {
				System.out.println("-------------------------------------------------------");
			}
		}
		String option = PercentageOptions();
		if (option == "A") {
			String so = SubOptions();
			if (so == "1") {
				int k = myMap.size();

				HashMap<Integer, Integer> details = new HashMap<Integer, Integer>();
				int l = details.size();
				for (int i = 1; i <= k; i++) {
					details.put(myMap.get(i).B, null);
				}
				int sum[] = new int[details.size()];
				int avg[] = new int[details.size()];
				int count = 0;
				Iterator itr = details.keySet().iterator();
				while (itr.hasNext()) {
					int key = (int) itr.next();
					int size = 0;
					for (int i = 1; i <= k; i++) {
						if (key == myMap.get(i).B) {
							sum[count] +=  myMap.get(i).C;
							size++;
						}
					}
					avg[count]= sum[count]/size;
					System.out.println("Year: "+key+"\nAggregate Pass Percentage: "+avg[count]+"%\n");
					count++;
					
				}
			} else if (so == "2") {
				int sum = 0;
				int k = myMap.size();
				for (int i = 1; i <= k; i++) {
					int y = myMap.get(i).C;
					sum += y;
				}
				int pass = sum / k;
				System.out.println("Pass Percentage for all years: " + pass + "%");
				
			} else if (so == "3") {
				
				int k = myMap.size();

				HashMap<String, Integer> details = new HashMap<String, Integer>();
				int l = details.size();
				for (int i = 1; i <= k; i++) {
					details.put(myMap.get(i).A, null);
				}
				double sum[] = new double[details.size()];
				double avg[] = new double[details.size()];
				int count = 0;
				Iterator itr = details.keySet().iterator();
				while (itr.hasNext()) {
					String key = (String) itr.next();
					int size = 0;
					for (int i = 1; i <= k; i++) {
						if (key == myMap.get(i).A) {
							sum[count] +=  myMap.get(i).C;
							size++;
						}
					}
					avg[count]= sum[count]/size;
					System.out.println("Gender: "+key+"\nAggregate Pass Percentage: "+avg[count]+"%\n");
					count++;
					
				}
			}

		} else if (option == "B") {
			String so = SubOptions();
			if (so == "1") {
				int k = myMap.size();

				HashMap<Integer, Integer> details = new HashMap<Integer, Integer>();
				int l = details.size();
				for (int i = 1; i <= k; i++) {
					details.put(myMap.get(i).B, null);
				}
				int sum[] = new int[details.size()];
				int avg[] = new int[details.size()];
				int count = 0;
				Iterator itr = details.keySet().iterator();
				while (itr.hasNext()) {
					int key = (int) itr.next();
					int size = 0;
					for (int i = 1; i <= k; i++) {
						if (key == myMap.get(i).B) {
							sum[count] +=  myMap.get(i).C;
							size++;
						}
					}
					avg[count]= sum[count]/size;
					System.out.println("Year: "+key+"\nAggregate Fail Percentage: "+(100-avg[count])+"%\n");
					count++;
					
				}
			} else if (so == "2") {
				int sum = 0;
				int k = myMap.size();
				for (int i = 1; i <= k; i++) {
					int y = myMap.get(i).C;
					sum += y;
				}
				int pass = sum / k;
				System.out.println("Fail Percentage for all years: " + (100 - pass) + "%");
				
			} else if (so == "3") {
				
				int k = myMap.size();

				HashMap<String, Integer> details = new HashMap<String, Integer>();
				int l = details.size();
				for (int i = 1; i <= k; i++) {
					details.put(myMap.get(i).A, null);
				}
				double sum[] = new double[details.size()];
				double avg[] = new double[details.size()];
				int count = 0;
				Iterator itr = details.keySet().iterator();
				while (itr.hasNext()) {
					String key = (String) itr.next();
					int size = 0;
					for (int i = 1; i <= k; i++) {
						if (key == myMap.get(i).A) {
							sum[count] +=  myMap.get(i).C;
							size++;
						}
					}
					avg[count]= sum[count]/size;
					System.out.println("Gender: "+key+"\nAggregate Fail Percentage: "+(100-avg[count])+"%\n");
					count++;
					
				}
			}

		} else if (option == "C") {
			int sum = 0;
			int k = myMap.size();
			for (int i = 1; i <= k; i++) {
				int y = myMap.get(i).C;
				sum += y;
			}
			int pass = sum / k;
			System.out.println("Pass Percentage: " + pass + "%");
			System.out.println("Fail Percentage: " + (100 - pass) + "%");
		}

	}

}
