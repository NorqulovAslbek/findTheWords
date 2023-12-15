package org.example;

import org.example.controller.WordController;
import org.example.db.Database;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Database database = (Database) context.getBean("database");
        database.crateTable();
        WordController wordController = (WordController) context.getBean("wordController");
        wordController.start();
    }
}
