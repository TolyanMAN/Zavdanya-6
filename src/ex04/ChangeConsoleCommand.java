package ex04;
import ex01.Item2d;
import ex02.View;
import ex02.ViewResult;
/** Консольная команда
 * Change item;
 * шаблон Command
 * @author Maksim
 
 * @version 1.0
 */
public class ChangeConsoleCommand
        
        extends ChangeItemCommand
        
        implements ConsoleCommand {

    /** Объект, реализующий интерфейс {@linkplain View};
    
     * обслуживает коллекцию объектов {@linkplain ex01.Item2d}
     
     */
    private View view;


    /** Возвращает поле {@linkplain ChangeConsoleCommand#view}
    
     * @return значение {@linkplain ChangeConsoleCommand#view}
     
     */
    public View getView() {
        return view;
    }
    /** Устанавливает поле {@linkplain ChangeConsoleCommand#view}
     * @param view значение для {@linkplain ChangeConsoleCommand#view}
     
     * @return новое значение {@linkplain ChangeConsoleCommand#view}
     */
    public View setView(View view) {
        return this.view = view;
        
    }
    
    
    /** Инициализирует поле {@linkplain ChangeConsoleCommand#view}
    
     * @param view объект, реализующий интерфейс {@linkplain View}
     
     */
    public ChangeConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'c';
    }
    @Override
    public String toString() {
        return "'c'hange";
    }
    @Override
    public void execute() {
        System.out.println("Change item: scale factor " + setOffset(Math.random() * 100.0));
        for (Item2d item : ((ViewResult)view).getItems()) {
            super.setItem(item);
            super.execute();
        }
        view.viewShow();
    }
}
