package ex02;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ex01.Item2d;

/** ConcreteProduct
 * (Øàáëîí ïðîåêòèðîâàíèÿ
 * Factory Method)<br>
 * Âû÷èñëåíèå ôóíêöèè,
 
 * ñîõðàíåíèå è îòîáðàæåíèå
 
 * ðåçóëüòàòîâ
 * @author Maksim
 
 * @version 1.0
 * @see View
 */
public class ViewResult implements View {
    
    /**
     * Èìÿ ôàéëà, èñïîëüçóåìîå ïðè ñåðèàëèçàöèè.
     */
    
    private static final String FNAME = "ex0.Data.bin";
    

    /** Îïðåäåëÿåò êîëè÷åñòâî çíà÷åíèé äëÿ âû÷èñëåíèÿ ïî óìîë÷àíèþ */
    private static final int DEFAULT_NUM = 10;

    /** Êîëëåêöèÿ àðãóìåíòîâ è ðåçóëüòàòîâ âû÷èñëåíèé */
    private ArrayList<Item2d> items = new ArrayList();

    /** Âûçûâàåò {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
     * ñ ïàðàìåòðîì {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
     */
    public ViewResult() {
        this(DEFAULT_NUM);
    }
    /** Èíèöèàëèçèðóåò êîëëåêöèþ {@linkplain ViewResult#items}
     * @param n íà÷àëüíîå êîëè÷åñòâî ýëåìåíòîâ
     */
    public ViewResult(int n) {
        for(int ctr = 0; ctr < n; ctr++) {
            items.add(new Item2d());
        }
    }

    /** Ïîëó÷èòü çíà÷åíèå {@linkplain ViewResult#items}
     * @return òåêóùåå çíà÷åíèå ññûëêè íà îáúåêò {@linkplain ArrayList}
     */
    public ArrayList<Item2d> getItems() {
        return items;
    }

    /**
     * Âû÷èñëÿåò çíà÷åíèå ôóíêöèè.
     *
     * @param arguments - àðãóìåíòû âû÷èñëÿåìîé ôóíêöèè.
     * @return ðåçóëüòàò âû÷èñëåíèÿ ôóíêöèè.
     */
    private byte calc(double []arguments) {
        int number = (int)((Math.sin(arguments[0]) + Math.sin(arguments[1]) + Math.sin(arguments[2]) + Math.sin(arguments[3])) / 4.0 * 1000);
        
        byte count = 0;

        
        if(number < 0) {
            number *= -1;
        }

        while (number > 0) {
            number &= (number - 1);
            
            count++;
        }

        return count;
    }

    
    /** Âû÷èñëÿåò çíà÷åíèå ôóíêöèè è ñîõðàíÿåò
     * ðåçóëüòàò â êîëëåêöèè {@linkplain ViewResult#items}
     *
     
     * @param argumentsStep - øàã ïðèðàùåíèÿ àðãóìåíòà
     */
    public void init(double argumentsStep) {
        double []arguments = new double[]{ 10, 100, 50, 500 };

        for(Item2d item: items) {
            item.setOnesNumberAndArguments(calc(arguments), arguments.clone());

            for(int i = 0; i < 4; i++) {
                arguments[i] += argumentsStep;
            }
        }
    }

    /** Âûçûâàåò <b>init(double argumentsStep)</b> ñî ñëó÷àéíûì çíà÷åíèåì àðãóìåíòà<br>
     * {@inheritDoc}
     */
    @Override
    public void viewInit() {
        init(Math.random() * 180.0);
    }

    /** Ðåàëèçàöèÿ ìåòîäà {@linkplain View#viewSave()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(items);
        os.flush();
        os.close();
    }

    /** Ðåàëèçàöèÿ ìåòîäà {@linkplain View#viewRestore()}<br>
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        items = (ArrayList<Item2d>) is.readObject();
        is.close();
    }

    /** Ðåàëèçàöèÿ ìåòîäà {@linkplain View#viewHeader()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewHeader() {
        System.out.println("Results:");
    }

    /** Ðåàëèçàöèÿ ìåòîäà {@linkplain View#viewBody()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewBody() {
        for(Item2d item : items) {
            System.out.println(item);
            
        }
    }

    /** Ðåàëèçàöèÿ ìåòîäà {@linkplain View#viewFooter()}<br>
    
     * {@inheritDoc}
     */
    @Override
    public void viewFooter() {
        System.out.println("End.");
    }

    /** Ðåàëèçàöèÿ ìåòîäà {@linkplain View#viewShow()}<br>
    
     * {@inheritDoc}
     */
    @Override
    public void viewShow() {
        
        viewHeader();
        viewBody();
        viewFooter();
    }
}
