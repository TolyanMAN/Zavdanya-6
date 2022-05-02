package ex03;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import java.io.IOException;
import ex01.Item2d;

/** Выполняет тестирование

 * разработанных классов.
 
 * @author Maksim
 
 * @version 3.0
 */
public class MainTest {
    /** Проверка основной функциональности класса {@linkplain ViewTable} */
    @Test
    
    public void testCalc() {
        
        ViewTable tbl = new ViewTable(10, 5);
        assertEquals(10, tbl.getWidth());
        
        assertEquals(5, tbl.getItems().size());
        
        tbl.init(40, 5);
        
        Item2d item = new Item2d();
        
        int ctr = 0;
        item.setOnesNumberAndArguments(7, new double[]{0, 100, 200, 300});
        
        assertTrue("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",
                tbl.getItems().get(ctr).equals(item));
        ctr++;
        item.setOnesNumberAndArguments(5, new double[]{5, 105, 205, 305});
        assertTrue("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",
                tbl.getItems().get(ctr).equals(item));
        ctr++;
        item.setOnesNumberAndArguments(6, new double[]{10, 110, 210, 310});
        assertTrue("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",
                tbl.getItems().get(ctr).equals(item));
        ctr++;
        item.setOnesNumberAndArguments(5, new double[]{15, 115, 215, 315});
        
        assertTrue("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",
                   
                tbl.getItems().get(ctr).equals(item));
        
        ctr++;
        item.setOnesNumberAndArguments(5, new double[]{20, 120, 220, 320});
        assertTrue("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",
                tbl.getItems().get(ctr).equals(item));
    }
    /** Проверка сериализации. Корректность восстановления данных. */
    @Test
    public void testRestore() {
        
        ViewTable tbl1 = new ViewTable(10, 1000);
        
        ViewTable tbl2 = new ViewTable();
        
        // Вычислим значение функции со случайным шагом приращения аргумента
        
        tbl1.init(30, Math.random()*100.0);
        // Сохраним коллекцию tbl1.items
        try {
            tbl1.viewSave();
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
        // Загрузим коллекцию tbl2.items
        try {
            tbl2.viewRestore();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
        // Должны загрузить столько же элементов, сколько сохранили
        assertEquals(tbl1.getItems().size(), tbl2.getItems().size());
        // Причем эти элементы должны быть равны.
        // Для этого нужно определить метод equals
        assertTrue("containsAll()", tbl1.getItems().containsAll(tbl2.getItems()));
    }
}
