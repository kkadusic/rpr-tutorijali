package etf.unsa.ba;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PredmetTest {
    @Test
    void Upisi() {
        Predmet p = new Predmet("XXX", 123, 50);
        Student s = new Student("Tom", "Jerry", 10000);
        p.Upisi(s);
        assertEquals(true, p.Upisan(s));
    }

    @Test
    void setSifraPredmeta() {
        Predmet p = new Predmet("XXX", 123, 50);
        p.setSifraPredmeta(123);
        assertEquals(123, p.getSifraPredmeta());
    }

    @Test
    void setNazivPredmeta() {
        Predmet p = new Predmet("XXX", 123, 50);
        p.setNazivPredmeta("YYY");
        assertEquals("YYY", p.getNazivPredmeta());
    }
}