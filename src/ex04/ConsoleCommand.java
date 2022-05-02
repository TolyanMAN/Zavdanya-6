package ex04;
/** Интерфейс
 * консольной команды;
 * шаблон Command
 * @author Vlada
 * @version 1.0
 */
public interface ConsoleCommand extends Command {

    /** Горячая клавиша команды;
     * шаблон Command
     * @return символ горячей клавиши
     */
    public char getKey();
}
