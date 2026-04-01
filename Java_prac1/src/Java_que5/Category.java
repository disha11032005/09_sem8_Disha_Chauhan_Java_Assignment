/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_que5;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author root
 */
public class Category {
     int id;
    String name;
    Integer parentId;
    List<Category> children = new ArrayList<>();

    public Category(int id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
}
