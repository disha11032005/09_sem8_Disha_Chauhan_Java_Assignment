/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_que3;



import java.util.Hashtable;
import java.util.Scanner;
/**
 *
 * @author root
 */
public class Main3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter rows: ");
            int r = sc.nextInt();
            System.out.print("Enter columns: ");
            int c = sc.nextInt();

            DataTable dt = new DataTable(r, c);

            while (true) {
                System.out.println("\n1 Insert Value");
                System.out.println("2 Display Table");
                System.out.println("3 Insert Row");
                System.out.println("4 Insert Column");
                System.out.println("5 Populate from Hashtable");
                System.out.println("6 Exit");

                System.out.print("Choice: ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("Row: ");
                        int row = sc.nextInt();
                        System.out.print("Col: ");
                        int col = sc.nextInt();
                        System.out.print("Value: ");
                        String val = sc.next();
                        dt.setValue(row, col, val);
                        break;

                    case 2:
                        dt.display();
                        break;

                    case 3:
                        dt.insertRow();
                        System.out.println("Row inserted");
                        break;

                    case 4:
                        dt.insertColumn();
                        System.out.println("Column inserted");
                        break;

                    case 5:
                        Hashtable<Integer, String> ht = new Hashtable<>();
                        ht.put(1, "A");
                        ht.put(2, "B");
                        ht.put(3, "C");
                        dt.populateFromHashtable(ht);
                        System.out.println("Table populated");
                        break;

                    case 6:
                        System.exit(0);
                }
            }

        } catch (TableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
