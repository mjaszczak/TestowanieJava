package test.java.rzymskie;



import main.java.rzymskie.LiczbaRzymska;
import org.junit.Test;
import static org.junit.Assert.*;

public class LiczbaRzymskaTest {

    private LiczbaRzymska liczba;

    @Test(expected = NumberFormatException.class)
    public void ZeroTest() {
        liczba = new LiczbaRzymska(0);
        liczba.toString();
    }

    @Test
    public void ZamianaMalejLiczby() {
        liczba = new LiczbaRzymska(15);
        assertEquals("XV", liczba.toString());
    }


    @Test
    public void DuzaLiczba() {
        liczba = new LiczbaRzymska(3476);
        assertEquals("MMMCDLXXVI", liczba.toString());
    }

    @Test(expected = NumberFormatException.class)
    public void LiczbaUjemna() {
        liczba = new LiczbaRzymska(-77);
        liczba.toString();
    }




}
