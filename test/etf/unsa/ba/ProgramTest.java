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

}