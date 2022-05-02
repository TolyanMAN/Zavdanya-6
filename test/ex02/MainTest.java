package ex02;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import java.io.IOException;
import ex01.Item2d;

/** Выполняет тестирование

 * разработанных классов.
 
 * @author Maksim
 
 * @version 2.0
 */

public class MainTest {
    /** Проверка основной функциональности класса {@linkplain ViewResult} */
    @Test
    public void testCalc() {
        ViewResult view = new ViewResult(5);
        view.init(5.0);
        Item2d item = new Item2d();
        
        int ctr = 0;
        
        item.setOnesNumberAndArguments(7, new double[]{0, 100, 200, 300});
        
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
                view.getItems().get(ctr).equals(item));
        ctr++;
        item.setOnesNumberAndArguments(5, new double[]{5, 105, 205, 305});
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
                   
                view.getItems().get(ctr).equals(item));
        ctr++;
        
        
        item.setOnesNumberAndArguments(6, new double[]{10, 110, 210, 310});
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
                view.getItems().get(ctr).equals(item));
        ctr++;
        item.setOnesNumberAndArguments(5, new double[]{15, 115, 215, 315});
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
                view.getItems().get(ctr).equals(item));
        ctr++;
        
        item.setOnesNumberAndArguments(5, new double[]{20, 120, 220, 320});
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
                view.getItems().get(ctr).equals(item));
        
    }
    /** Проверка сериализации. Корректность восстановления данных. */
    @Test
    public void testRestore() {
        ViewResult view1 = new ViewResult(1000);
        ViewResult view2 = new ViewResult();
        // Вычислим значение функции со случайным шагом приращения аргумента
        view1.init(Math.random()*100.0);
        // Сохраним коллекцию view1.items
        try {
            view1.viewSave();
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
        // Загрузим коллекцию view2.items
        
        try {
            view2.viewRestore();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
        // Должны загрузить столько же элементов, сколько сохранили
        assertEquals(view1.getItems().size(), view2.getItems().size());
        // Причем эти элементы должны быть равны.
        // Для этого нужно определить метод equals
        assertTrue("containsAll()", view1.getItems().containsAll(view2.getItems()));
    }
}
