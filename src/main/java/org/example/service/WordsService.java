package org.example.service;

import org.example.dto.Words;
import org.example.repository.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WordsService {
    @Autowired
    private WordsRepository wordsRepository;

    @Autowired
    private Scanner scanner;


    public void deleteByIdService(int id) {
        if (wordsRepository.deleteById(id)) {
            System.out.println("Success");
        }
    }

    public void createWordsService(Words test) {
        if (wordsRepository.createWordsRepository(test)) {
            System.out.println("Success");
        } else {
            System.out.println("test not added");
        }
    }

    public void getWordsListService() {
        List<Words> wordsList = wordsRepository.getWordsList();
        if (!wordsList.isEmpty()) {
            for (Words words : wordsList) {
                String format = words.getId() + "." + words.getWord() + " --> " + words.getTranslate() + " --> " + words.getDescription();
                System.out.println(format);
            }
        } else {
            System.out.println("Bazada hecqanday malumot saqlanmagan!!");
        }
    }

    public void spellingService(int choose) {
        int closedTestCount = 0;
        List<Words> words = wordsRepository.getWordsList();
        for (int i = 0; i < words.size(); i++) {
            boolean bool = true;
            Words words1 = words.get(i);
            while (bool) {
                System.out.println(">>>>> Balingiz :" + closedTestCount + " <<<<<<");
                if (choose == 1) {
                    System.out.print(words1.getWord() + " -->  ");
                    String sc = scanner.next();
                    if (sc.equals(words1.getTranslate())) {
                        closedTestCount++;
                        bool = false;
                    }
                } else if (choose == 2) {
                    System.out.print(words1.getTranslate() + " --> ");
                    String sc = scanner.next();
                    if (sc.equals(words1.getWord())) {
                        closedTestCount++;
                        bool = false;
                    }
                }
            }
        }

    }

    public void multipleChoiceService(int choose) {
        int countProfileTest = 0;
        List<Words> words = wordsRepository.getWordsList();
        Random random = new Random();
        for (int i = 0; i < words.size(); i++) {
            boolean bool = true;
            while (bool) {
                System.out.println(">>>>>>>> Balingiz :" + countProfileTest + " <<<<<<<<");
                List<String> list = new ArrayList<>(4);
                Words word = words.get(i);
                if (choose == 1) {
                    System.out.println((i + 1) + "." + word.getWord() + "?");
                    list.add(word.getTranslate());
                    while (list.size() != 4) {
                        String translate = words.get(random.nextInt(words.size())).getTranslate();
                        if ((!list.contains(translate))) {
                            list.add(translate);
                        }
                    }
                    String chooseAnswer = getChooseAnswer(list);
                    if (word.getTranslate().equals(chooseAnswer)) {
                        countProfileTest++;
                        bool = false;
                    } else if (chooseAnswer.equals("0")) {
                        return;
                    }

                } else if (choose == 2) {
                    System.out.println((i + 1) + "." + word.getTranslate() + "?");
                    list.add(word.getWord());
                    while (list.size() != 4) {
                        String wor = words.get(random.nextInt(words.size())).getWord();
                        if ((!list.contains(wor))) {
                            list.add(wor);
                        }
                    }
                    String chooseAnswer = getChooseAnswer(list);
                    if (word.getWord().equals(chooseAnswer)) {
                        countProfileTest++;
                        bool = false;
                    } else if (chooseAnswer.equals("0")) {
                        return;
                    }
                }
            }
        }

    }


    public String getChooseAnswer(List<String> list) {
        Collections.shuffle(list);
        System.out.println("a)" + list.get(0));
        System.out.println("b)" + list.get(1));
        System.out.println("c)" + list.get(2));
        System.out.println("d)" + list.get(3));
        System.out.println("0->exit");
        System.out.print("choose the answer:");
        String answer = scanner.next();
        String answerChoose = switch (answer) {
            case "a" -> list.get(0);
            case "b" -> list.get(1);
            case "c" -> list.get(2);
            case "d" -> list.get(3);
            case "0" -> "0";
            default -> "";
        };
        return answerChoose;
    }

}
