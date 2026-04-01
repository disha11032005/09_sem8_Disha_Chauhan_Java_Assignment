/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fashion.que2;
import jakarta.persistence.*;
/**
 *
 * @author root
 */
@Entity
@Table(name = "page_visits")
public class PageVisit {
    @Id
    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "visit_count")
    private int visitCount;

    public PageVisit() {
    }

    public PageVisit(String ipAddress, int visitCount) {
        this.ipAddress = ipAddress;
        this.visitCount = visitCount;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }
}
