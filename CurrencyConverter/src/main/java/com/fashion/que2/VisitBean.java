/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fashion.que2;

/**
 *
 * @author root
 */
import jakarta.ejb.Stateful;
import jakarta.persistence.*;

@Stateful
public class VisitBean {
    @PersistenceContext(unitName = "Ass3PU")
    private EntityManager em;

    public int recordVisit(String ipAddress) {

        PageVisit visit = em.find(PageVisit.class, ipAddress);

        if (visit == null) {
            visit = new PageVisit(ipAddress, 1);
            em.persist(visit);
            return 1;
        } else {
            int newCount = visit.getVisitCount() + 1;
            visit.setVisitCount(newCount);
            em.merge(visit);
            return newCount;
        }
    }
}
