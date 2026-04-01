/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_que5;
import java.sql.*;
import java.util.*;


/**
 *
 * @author root
 */
public class CategoryTree {
    public static void main(String[] args) {

        // Step 1: Store all categories
        Map<Integer, Category> categoryMap = new HashMap<>();
        List<Category> rootCategories = new ArrayList<>();

        try {
            // Step 2: Database Connection
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/category_db",
                "root",
                "root"
            );

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Category_Master");

            // Step 3: Read all records
            while (rs.next()) {
                int id = rs.getInt("category_id");
                String name = rs.getString("category_name");
                Integer parentId = rs.getObject("parent_category_id") != null
                        ? rs.getInt("parent_category_id")
                        : null;

                Category category = new Category(id, name, parentId);
                categoryMap.put(id, category);
            }

            // Step 4: Build tree
            for (Category cat : categoryMap.values()) {
                if (cat.parentId == null) {
                    rootCategories.add(cat);
                } else {
                    Category parent = categoryMap.get(cat.parentId);
                    if (parent != null) {
                        parent.children.add(cat);
                    }
                }
            }

            // Step 5: Print Tree
            for (Category root : rootCategories) {
                printTree(root, 0);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Recursive method to print tree
    public static void printTree(Category category, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println(category.name);

        for (Category child : category.children) {
            printTree(child, level + 1);
        }
    }

}
