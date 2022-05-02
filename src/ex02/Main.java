package ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Вычисление и отображение результатов.
 * Содержит реализацию статического метода main().
 *
 * @author Vlada
 * @version 1.0
 * @see Main#main
 */
@SuppressWarnings("SpellCheckingInspection")
public class Main {
    /** Объект, реализующий интерфейс {@linkplain View};
     * обслуживает коллекцию объектов {@linkplain ex01.Item2d}
     */
    public View view;

    /** Инициализирует поле {@linkplain Main#view view}. */
    public Main(View view) {
        this.view = view;
    }

    /**
     * Отображает меню.
     */
    public void menu() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Enter command...");
                System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
                try {
                    s = in.readLine();
                } catch (IOException e) {
                    System.out.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            switch (s.charAt(0)) {
                case 'q' -> System.out.println("Exit.");
                case 'v' -> {
                    System.out.println("View current.");
                    view.viewShow();
                }
                case 'g' -> {
                    System.out.println("Random generation.");
                    view.viewInit();
                    view.viewShow();
                }
                case 's' -> {
                    System.out.println("Save current.");
                    try {
                        view.viewSave();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    view.viewShow();
                }
                case 'r' -> {
                    System.out.println("Restore last saved.");
                    try {
                        view.viewRestore();
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    view.viewShow();
                }
                default -> System.out.print("Wrong command. ");
            }
        } while (s.charAt(0) != 'q');
    }

    /**
     * Выполняется при запуске программы.
     * Вычисляется значение функции для различных аргументов.
     * Результаты вычислений выводятся на экран.
     *
     * @param args - параметры запуска программы.
     */
    public static void main(String[] args) {
        Main main = new Main(new ViewableResult().getView());
        main.menu();
    }
}