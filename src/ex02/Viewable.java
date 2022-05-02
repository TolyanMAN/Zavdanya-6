package ex02;
/** Creator

 * (шаблон проектирования
 
 * Factory Method)<br>
 
 * Объявляет метод,
 
 * "фабрикующий" объекты
 * @author Maksim
 
 * @version 1.0
 * @see Viewable#getView()
 */
public interface Viewable {
    /** Создаёт объект, реализующий {@linkplain View} */
    
    View getView();

}
