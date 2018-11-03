package etf.unsa.ba;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {
    @Test
    void PostojiPredmet() {
        Program p = new Program();
        assertEquals(false, p.PostojiPredmet("QQQ"));
        p.KreirajPredmet("QQQ", 123, 50);
        assertEquals(true, p.PostojiPredmet("QQQ"));
    }

    @Test
    void PostojiStudent() {
        Program p = new Program();
        assertEquals(false, p.PostojiStudent(10000)));
        p.DodajStudenta("Jerry", "Tom", 20000);
        assertEquals(true, p.PostojiStudent(20000));
    }
    
    @Test
    void imaStudent() {
        Program p = new Program();
        assertEquals(false, p.ImaStudent(10000));
        p.DodajStudenta("Tony", "Stark", 10000);
        assertEquals(true, p.ImaStudent(10000));
    }
    
    @Test
    void imaPredmet() {
        Program p = new Program();
        assertEquals(false, p.ImaPredmet("KKK"));
        p.KreirajPredmet("KKK", 123, 50);
        assertEquals(true, p.ImaPredmet("KKK"));
    }
}
