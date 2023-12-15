package org.example.controller;


import org.example.dto.Words;
import org.example.service.WordsService;
import org.example.util.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.util.Scanner;

@Controller
public class WordController {
    @Autowired
    private Scanner scanner;
    @Autowired
    private WordsService wordsService;

    public void start() {
        boolean n = true;
        while (n) {
            menu();
            switch (Action.getAction()) {
                case 1 -> addWord();
                case 2 -> wordListList();
                case 3 -> multipleChoice();
                case 4 -> spelling();
                case 5 -> deleteById();
                case 0 -> n = false;
                default -> System.out.println("You have selected a number that does not exist!!");
            }

        }


    }

    private void deleteById() {
        System.out.print("Enter id>");
        int id=scanner.nextInt();
        wordsService.deleteByIdService(id);
    }

    private void spelling() {
        int chooseMenu = getChooseMenu();
        wordsService.spellingService(chooseMenu);
    }

    private void multipleChoice() {
        int chooseMenu = getChooseMenu();
        wordsService.multipleChoiceService(chooseMenu);
    }

    private void wordListList() {
        wordsService.getWordsListService();
    }

    private void addWord() {
        System.out.print("Enter word:");
        String word = scanner.next();
        System.out.print("Enter Translate:");
        String translate = scanner.next();
        scanner = new Scanner(System.in);
        System.out.print("Enter description:");
        String description = scanner.nextLine();
        Words words = new Words();
        words.setWord(word);
        words.setTranslate(translate);
        words.setDescription(description);
        wordsService.createWordsService(words);
    }


    private void menu() {
        System.out.print("""
                ************* MENU *************
                1. Add Word >
                2. WordList List >
                3. Multiple Choice >
                4. Spelling >
                5. Searching >
                6. Delete by id >
                0. exit>
                """);
    }

    private int getChooseMenu() {
        System.out.print("""
                >>>>>>>>>>>>>>>>>>>>> Tanlang <<<<<<<<<<<<<<<<<<<<<
                1.Savollari O'bekcha , javoblari english tilida >
                2.Savollari English tilida , javoblari uzbekchada > 
                """);
        return scanner.nextInt();
    }


}
