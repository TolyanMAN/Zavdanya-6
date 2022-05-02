package ex03;
import ex02.View;
/** Вычисление и отображение результатов<br>

 * Содержит реализацию статического метода main()
 
 * @author Maksim
 
 * @version 3.0
 
 * @see Main#main
 */
public class Main extends ex02.Main {
    /** Инициализирует поле {@linkplain ex02.Main#view view} */
    
    public Main(View view) {
        super(view);
    }
    /** Выполняется при запуске программы;
    
     * вызывает метод {@linkplain ex02.Main#menu menu()}
     
     * @param args - параметры запуска программы
     */
    public static void main(String[] args) {
        
        Main main = new Main(new ViewableTable().getView());
        
        main.menu();
    }
}
