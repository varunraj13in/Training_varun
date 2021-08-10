package billing;
// Varun Raj Dounjeghar

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import store.Store_Varun;

public class Bill_Varun extends Store_Varun {
    public static String invoiceOutput(String pd, String qty, float[] amt, String[] p) {
        float b = Float.parseFloat(qty);
        float price = 0;
        for (int i = 0; i < p.length; i++) {
            if (pd.equals(p[i]))
                price = amt[i];
        }
        int final_p = (int) (price * b);
        double[] gst = { 1.3, 1.2, 1.1 };
        int count = 0;
        if (final_p >= 500) {
            final_p *= gst[0];
            count = 0;
        } else if (final_p >= 200) {
            final_p *= gst[1];
            count = 1;
        } else if (final_p >= 100) {
            final_p *= gst[2];
            count = 2;
        } else if (final_p < 100) {
        }

        String c = "" + (final_p);

        System.out.println("\nInvoice generated: ");
        System.out.println("----------------------------");
        System.out.println("products  quantity  Bill ");
        System.out.println("----------------------------");
        System.out.println("   " + pd + "          " + qty + "     " + c);
        System.out.println("----------------------------");
        double val = (gst[count] - 1) * 100;
        double val2 = (gst[count] - 1) * price * b;
        System.out.println(
                "Total: " + c + "(" + (int) (price * b) + "Rs " + "+ " + (int) (Math.round(val * 100.0) / 100.0)
                        + "%GST i.e. " + (int) (Math.round(val2 * 100.0) / 100.0) + "Rs)");
        System.out.println("\nDo you want to print invoice: (y/n) :");

        Scanner sc = new Scanner(System.in);
        String print = sc.next();
        switch (print.toLowerCase()) {
            case "y":
                try {
                    File f = new File("invoice.txt");
                    FileWriter fw = new FileWriter(f);
                    fw.write("Invoice generated: \n");
                    fw.write("----------------------------\n");
                    fw.write("products  quantity  Bill \n");
                    fw.write("----------------------------\n");
                    fw.write("   " + pd + "          " + qty + "     " + c);
                    fw.write("\n----------------------------\n");
                    fw.write("Total: " + c + "(" + (int) (price * b) + "Rs " + "+ "
                            + (int) (Math.round(val * 100.0) / 100.0) + "%GST i.e. "
                            + (int) (Math.round(val2 * 100.0) / 100.0) + "Rs)\n");
                    fw.close();
                    System.out.println("Invoice Print Successful");
                    return c;
                } catch (IOException e) {
                    System.out.println("Invoice Print Failed");
                }
                break;
            case "n":
                return c;
            default:
                return "Invalid Input";
        }
        return "";
    }
}
