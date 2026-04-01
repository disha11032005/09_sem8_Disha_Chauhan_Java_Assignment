/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_que2;

/**
 *
 * @author root
 */
public class Address {
     private String name;
    private String homeAddress;
    private String homePhone;
    private String businessAddress;
    private String businessPhone;
    private String fax;
    private String mobile;
    private String pager;

    public Address(String name, String homeAddress, String homePhone,
                   String businessAddress, String businessPhone,
                   String fax, String mobile, String pager) {
        this.name = name;
        this.homeAddress = homeAddress;
        this.homePhone = homePhone;
        this.businessAddress = businessAddress;
        this.businessPhone = businessPhone;
        this.fax = fax;
        this.mobile = mobile;
        this.pager = pager;
    }

    public String getName() {
        return name;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getMobile() {
        return mobile;
    }
}
