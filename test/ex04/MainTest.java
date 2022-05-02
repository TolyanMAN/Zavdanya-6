package ex04;
import static org.junit.Assert.*;
import org.junit.Test;
import ex01.Item2d;
import ex02.ViewResult;
/** Тестирование класса
 * ChangeItemCommand
 * @author Maksim
 
 * @version 4.0
 * @see ChangeItemCommand
 
 */
public class MainTest {
    /** Проверка метода {@linkplain ChangeItemCommand#execute()} */
    
    @Test
    
    public void testExecute() {
        
        ChangeItemCommand cmd = new ChangeItemCommand();
        cmd.setItem(new Item2d());
        
        double offset;
        byte onesNumber;
        
        double []arguments;
        for (int ctr = 0; ctr < 1000; ctr++) {
            cmd.getItem().setOnesNumberAndArguments(onesNumber = 7, arguments = new double[]{0, 100, 200, 300});
            cmd.setOffset(offset = Math.random() * 100.0);
            
            cmd.execute();
            assertEquals(arguments, cmd.getItem().getArguments());
            assertEquals((int)(onesNumber * offset), cmd.getItem().getOnesNumber());
        }
    }

    /** Проверка класса {@linkplain ChangeConsoleCommand} */
    @Test
    public void testChangeConsoleCommand() {
        ChangeConsoleCommand cmd = new ChangeConsoleCommand(new ViewResult());
        cmd.getView().viewInit();
        cmd.execute();
        assertEquals("'c'hange", cmd.toString());
        assertEquals('c', cmd.getKey());
    }
}
