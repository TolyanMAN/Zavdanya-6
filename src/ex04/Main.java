package ex04;
/** Вычисление и отображение
 * результатов; cодержит реализацию
 * статического метода main()
 * @author Vlada
 * @version 4.0
 * @see Main#main
 */
public class Main {
    /** Выполняется при запуске программы;
     * вызывает метод {@linkplain Application#run()}
     * @param args параметры запуска программы
     */
    public static void main(String[] args) {
        Application app = Application.getInstance();
        app.run();
    }
}