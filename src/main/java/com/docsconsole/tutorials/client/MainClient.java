package com.docsconsole.tutorials.client;


import com.docsconsole.tutorials.entity.Player;
import com.docsconsole.tutorials.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MainClient {


    public static void main(String[] args) {

        System.out.println("The main method@MainClient");

        EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;
        try {

            transaction = entityManager.getTransaction();
            transaction.begin();

            Player player = new Player();
            player.setFirstName("Sachin");
            player.setLastName("Tendulkar");
            player.setGame("Cricket");
            player.setAge(47l);
            player.setSalaryIncome(400000L);
            entityManager.persist(player);

            Player player1 = new Player();
            player1.setFirstName("Tom");
            player1.setLastName("Brady");
            player1.setGame("Football");
            player1.setAge(43l);
            player1.setSalaryIncome(400000L);
            entityManager.persist(player1);

            transaction.commit();


        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


}
