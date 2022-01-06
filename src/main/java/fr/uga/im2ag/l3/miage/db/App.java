package fr.uga.im2ag.l3.miage.db;


import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("JPA-HBM").createEntityManager();

    }
}
