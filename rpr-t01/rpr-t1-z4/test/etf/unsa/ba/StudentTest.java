package etf.unsa.ba;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void getIme() {
        Student s = new Student("Tom","Jerry",10000);
        assertEquals("Tom",s.getIme());
    }

    @Test
    void getPrezime() {
        Student s = new Student("Tom","Jerry",10000);
        assertEquals("Jerry",s.getPrezime());
    }

    @Test
    void setIme() {
        Student s = new Student("Tom","Jerry",10000);
        s.setIme("Mickey");
        assertEquals("Mickey",s.getIme());
    }

    @Test
    void setPrezime() {
        Student s = new Student("Tom","Jerry",10000);
        s.setPrezime("Mouse");
        assertEquals("Mouse",s.getPrezime());
    }

    @Test
    void getIndex() {
        Student novi = new Student("Tom", "Jerry", 10000);
        int index = novi.getIndex();
        assertEquals (10000, index);
    }
}