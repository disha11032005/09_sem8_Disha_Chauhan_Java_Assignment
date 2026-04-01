/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_que3;


import java.util.Hashtable;
/**
 *
 * @author root
 */


public class DataTable implements Featurable {

    private int rows, cols;
    private String[][] table;

    private String foreground, background, font;

    public DataTable(int r, int c) throws TableException {
        if (r > 200 || c > 200)
            throw new TableException("Rows or Columns cannot exceed 200");

        rows = r;
        cols = c;
        table = new String[rows][cols];
    }

    public void setValue(int r, int c, String val) {
        table[r][c] = val;
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print((table[i][j] == null ? "-" : table[i][j]) + "\t");
            }
            System.out.println();
        }
    }

    public void insertRow() {
        rows++;
        String[][] temp = new String[rows][cols];
        for (int i = 0; i < rows - 1; i++)
            temp[i] = table[i];
        table = temp;
    }

    public void insertColumn() {
        cols++;
        String[][] temp = new String[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols - 1; j++)
                temp[i][j] = table[i][j];
        table = temp;
    }

    public void populateFromHashtable(Hashtable<Integer, String> ht) {
        int index = 0;
        for (String val : ht.values()) {
            table[index / cols][index % cols] = val;
            index++;
            if (index == rows * cols)
                break;
        }
    }

    // Featurable methods
    public void setForeground(String c) { foreground = c; }
    public void setBackground(String c) { background = c; }
    public void setFont(String f) { font = f; }

    public String getForeground() { return foreground; }
    public String getBackground() { return background; }
    public String getFont() { return font; }
}