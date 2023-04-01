/*
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
Добавить функции 1) Добавление номера
2) Вывод всего
*/
package Task_1;

import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> phonBook = new HashMap<>();
        phonBook.put("Стас", List.of("8 222 111 11 11", "8 222 222 22 22"));
        phonBook.put("Юра", List.of("8 333 111 11 11", "8 333 222 22 22"));
        phonBook.put("Борис", List.of("8 444 111 11 11", "8 444 222 22 22"));
        phonBook.put("Наиль", List.of("8 555 111 11 11", "8 555 222 222 22"));

        menu(phonBook);
    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        // scanner.close();
        return scanner.nextLine();
    }
    public static void find(Map<String, List<String>> phonBook) {
        System.out.println("Введите имя: ");
        String name = scanner();
        System.out.println(phonBook.get(name));
    }
    public static void allBook(Map<String, List<String>> phonBook) {
        System.out.println(phonBook);
    }

    public static void add(Map<String, List<String>> phonBook) {
        System.out.println("Перестать вводить номера введите '!'");
        System.out.println("Введите имя: ");
        String name = scanner();
        List<String> number = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер: ");
            String phon = scanner();
            if (phon.equals("!")) {
                break;
            } 
            
            else {
                number.add(phon);
            }
        }
        phonBook.put(name, number);
    }
    public static void menu(Map<String, List<String>> phonBook) {
        System.out.println(
                "Введите команду из списка: 1 - найти контакт, 2 - добавить контакт, 3 - показать всю телефонную книгу, 0 - выйти");
        while (true) {
            String comands = scanner();
            if (comands.equals("0")) {
                break;
            } else {
                switch (comands) {
                    case "1" -> find(phonBook);
                    case "2" -> add(phonBook);
                    case "3" -> allBook(phonBook);
                    default -> {
                    }
                }
            }
        }
    }
}