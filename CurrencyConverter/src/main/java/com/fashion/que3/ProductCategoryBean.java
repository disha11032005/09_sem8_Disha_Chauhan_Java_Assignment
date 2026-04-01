/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fashion.que3;

/**
 *
 * @author root
 */
import jakarta.ejb.Stateful;
import jakarta.annotation.Resource;
import java.sql.*;
import java.util.*;
import javax.sql.DataSource;

@Stateful
public class ProductCategoryBean {
    @Resource(lookup = "jdbc/question1_09")
    private DataSource ds;

    // ---------------- CATEGORY CRUD ----------------

    public void addCategory(String name) throws Exception {
        try (Connection con = ds.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO CategoryMaster(category_name) VALUES(?)");
            ps.setString(1, name);
            ps.executeUpdate();
        }
    }

    public void updateCategory(int id, String name) throws Exception {
        try (Connection con = ds.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE CategoryMaster SET category_name=? WHERE category_id=?");
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public void deleteCategory(int id) throws Exception {
        try (Connection con = ds.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM CategoryMaster WHERE category_id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<String> getCategories() throws Exception {
        List<String> list = new ArrayList<>();
        try (Connection con = ds.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CategoryMaster");
            while (rs.next()) {
                list.add(rs.getInt("category_id") + " - " +
                         rs.getString("category_name"));
            }
        }
        return list;
    }
    
    public String getCategoryById(int id) throws Exception {

    Connection con = ds.getConnection();

    PreparedStatement ps = con.prepareStatement(
        "SELECT category_name FROM CategoryMaster WHERE category_id=?");

    ps.setInt(1, id);

    ResultSet rs = ps.executeQuery();

    String name = "";

    if (rs.next()) {
        name = rs.getString("category_name");
    }

    con.close();

    return name;
}

    // ---------------- PRODUCT CRUD ----------------

    public void addProduct(String name, double price,
                           int stock, int categoryId) throws Exception {

        try (Connection con = ds.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO ProductMaster(product_name,price,stock,category_id) VALUES(?,?,?,?)");

            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, stock);
            ps.setInt(4, categoryId);

            ps.executeUpdate();
        }
    }

    public void updateProduct(int id, String name,
                              double price, int stock) throws Exception {

        try (Connection con = ds.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE ProductMaster SET product_name=?,price=?,stock=? WHERE product_id=?");

            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, stock);
            ps.setInt(4, id);

            ps.executeUpdate();
        }
    }

    public void deleteProduct(int id) throws Exception {
        try (Connection con = ds.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM ProductMaster WHERE product_id=?");

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    
    public ResultSet getProductById(int id) throws Exception {

    Connection con = ds.getConnection();
    PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM ProductMaster WHERE product_id=?");

    ps.setInt(1, id);

    return ps.executeQuery();
}

    public List<String> getProducts() throws Exception {
        List<String> list = new ArrayList<>();

        try (Connection con = ds.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT p.product_id, p.product_name, p.price, p.stock, c.category_name " +
                "FROM ProductMaster p JOIN CategoryMaster c " +
                "ON p.category_id=c.category_id");

            while (rs.next()) {
                        list.add(rs.getInt(1) + " | " +
                 rs.getString(2) + " | \u20B9" +
                 rs.getDouble(3) + " | Stock: " +
                 rs.getInt(4) + " | " +
                 rs.getString(5));
            }
        }
        return list;
    }
}
