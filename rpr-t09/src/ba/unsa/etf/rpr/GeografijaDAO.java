package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.ArrayList;

public class GeografijaDAO {
    private static GeografijaDAO instance = null;
    private static Connection conn;

    public GeografijaDAO() {
        conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:resources/baza.db");
            generisiBazu();
        } catch (SQLException e) {
            System.out.println("Neuspjesno citanje iz baze: " + e.getMessage());
        }
    }

    private void generisiBazu() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Grad (\n"
                + "	id INTEGER PRIMARY KEY,\n"
                + "	naziv text NOT NULL UNIQUE,\n"
                + " brojStanovnika INTEGER,\n"
                + " drzava INTEGER,\n"
                + "	FOREIGN KEY (drzava) REFERENCES Drzava(id) ON DELETE CASCADE\n"
                + ");";
        //cascade (ako je zapis u roditelj tabeli obrisan, onda ce i odg. zapis u dijete tabeli biti aut. obrisan

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute(); //prema "stack overflow-u" bolje koristiti PreparedStatement nego Statement

        sql = "CREATE TABLE IF NOT EXISTS Drzava (\n"
                + "	id INTEGER PRIMARY KEY,\n"
                + "	naziv text NOT NULL UNIQUE,\n"
                + " glavniGrad INTEGER,\n"
                + "	FOREIGN KEY (glavniGrad) REFERENCES Grad(id) ON DELETE CASCADE\n"
                + ");";

        stmt = conn.prepareStatement(sql);
        stmt.execute();

        Grad pariz = new Grad();
        pariz.setNaziv("Pariz");
        pariz.setBrojStanovnika(2206488);
        Drzava francuska = new Drzava();
        francuska.setNaziv("Francuska");
        francuska.setGlavniGrad(pariz);
        dodajDrzavu(francuska);
        dodajGrad(pariz);

        Grad london = new Grad();
        london.setNaziv("London");
        london.setBrojStanovnika(8825000);
        Drzava velikaBritanija = new Drzava();
        velikaBritanija.setNaziv("Velika Britanija");
        velikaBritanija.setGlavniGrad(london);
        dodajDrzavu(velikaBritanija);
        dodajGrad(london);

        Grad bec = new Grad();
        bec.setNaziv("Beč");
        bec.setBrojStanovnika(1899055);
        Drzava austrija = new Drzava();
        austrija.setNaziv("Austrija");
        austrija.setGlavniGrad(bec);
        dodajDrzavu(austrija);
        dodajGrad(bec);

        Grad manchester = new Grad();
        manchester.setNaziv("Manchester");
        manchester.setBrojStanovnika(545500);
        manchester.setDrzava(velikaBritanija);
        dodajGrad(manchester);

        Grad graz = new Grad();
        graz.setNaziv("Graz");
        graz.setBrojStanovnika(280200);
        graz.setDrzava(austrija);
        dodajGrad(graz);
    }

    private static void initialize() {
        instance = new GeografijaDAO();
    }

    public static void removeInstance() {
        try {
            conn.close();
            conn = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        instance = null;
    }

    public static GeografijaDAO getInstance() {
        if (instance == null) initialize();
        return instance;
    }


    public Drzava nadjiDrzavu(String drzava) {
        Drzava d = new Drzava();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT id, naziv, glavniGrad FROM Drzava WHERE naziv=?");
            stmt.setString(1, drzava);
            ResultSet rs = stmt.executeQuery(); //ResultSet je kolekcija koja sadrzi rezultate upita
            if (rs.isClosed())
                return null;
            while (rs.next()) { //next() vraca sljedeci red rezultata
                d.setId(rs.getInt(1));
                d.setNaziv(rs.getString(2));
                return d;
            }
            //Metode tipa getInt, getString… vraćaju jedan rezultat koji se konvertuje u odabrani tip.
            // Parametar je redni broj kolone sa rezultatom (počevši od 1!) ili naziv kolone
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Grad nadjiGrad(String grad) {
        Grad g = new Grad();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT id, naziv, brojStanovnika, drzava FROM Grad WHERE naziv=?");
            stmt.setString(1, grad);
            ResultSet rs = stmt.executeQuery();
            if (rs.isClosed())
                return null;
            while (rs.next()) {
                g.setId(rs.getInt(1));
                g.setNaziv(rs.getString(2));
                g.setBrojStanovnika(rs.getInt(3));
                return g;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public void izmijeniDrzavu(Drzava drzava) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE Drzava SET naziv=?, glavniGrad=? WHERE id=?");
            stmt.setString(1, drzava.getNaziv());
            stmt.setInt(2, drzava.getGlavniGrad().getId());
            stmt.setInt(3, drzava.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void izmijeniGrad(Grad grad) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE Grad SET naziv=?, brojStanovnika=?, drzava=? WHERE id=?");
            stmt.setString(1, grad.getNaziv());
            stmt.setInt(2, grad.getBrojStanovnika());
            stmt.setInt(3, grad.getDrzava().getId());
            stmt.setInt(4, grad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void dodajGrad(Grad grad) {
        try {
            if (nadjiGrad(grad.getNaziv()) != null)
                return;
            PreparedStatement stmt = conn.prepareStatement("INSERT OR REPLACE INTO Grad (naziv, brojStanovnika, drzava) VALUES(?,?,?)");
            stmt.setString(1, grad.getNaziv());
            stmt.setInt(2, grad.getBrojStanovnika());
            stmt.setInt(3, grad.getDrzava().getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void dodajDrzavu(Drzava drzava) {
        try {
            if (nadjiDrzavu(drzava.getNaziv()) != null)
                return;
            PreparedStatement stmt = conn.prepareStatement("INSERT OR REPLACE INTO Drzava (naziv, glavniGrad) VALUES(?, null)");
            stmt.setString(1, drzava.getNaziv());
            stmt.executeUpdate();
            Drzava d = nadjiDrzavu(drzava.getNaziv());
            drzava.getGlavniGrad().setDrzava(d);
            dodajGrad(drzava.getGlavniGrad());
            Grad g = nadjiGrad(drzava.getGlavniGrad().getNaziv());
            drzava.getGlavniGrad().setId(g.getId());
            drzava.setId(d.getId());
            g.setDrzava(drzava);
            izmijeniGrad(g);
            izmijeniDrzavu(drzava);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void obrisiDrzavu(String drzava) { //brise i sve gradove u toj drzavi
        Drzava d;
        try {
            if ((d = nadjiDrzavu(drzava)) == null)
                return;
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Drzava WHERE naziv=?");
            stmt.setString(1, drzava);
            stmt.executeUpdate();
            obrisiGradove(d.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void obrisiGradove(Integer drzavaId) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Grad WHERE drzava=?");
            stmt.setInt(1, drzavaId);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public Grad glavniGrad(String drzava) {
        Grad g = new Grad();
        if (nadjiDrzavu(drzava) == null)
            return null; //ako ne postoji
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT Grad.id, Grad.naziv, brojStanovnika, drzava, Drzava.id " +
                            "AS d_id, Drzava.naziv AS d_naziv, Drzava.glavniGrad AS d_gg " +
                            "FROM Grad INNER JOIN Drzava ON " +
                            "Grad.drzava = Drzava.id " +
                            "WHERE Drzava.naziv = ?");
            stmt.setString(1, drzava);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                g.setId(rs.getInt(1));
                g.setNaziv(rs.getString(2));
                g.setBrojStanovnika(rs.getInt(3));
                Drzava d = new Drzava();
                d.setId(rs.getInt(5));
                d.setNaziv(rs.getString(6));
                d.setGlavniGrad(g);
                g.setDrzava(d);
                return g;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Grad> gradovi() { //vraca spisak gradova sortiranih po br. stan. u op. redoslijedu
        ArrayList<Grad> rezultat = new ArrayList<Grad>();
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT Grad.id, Grad.naziv, brojStanovnika, drzava, " +
                            "Drzava.id AS d_id, Drzava.naziv AS d_naziv, Drzava.glavniGrad AS d_gg FROM Grad INNER JOIN Drzava ON " +
                            "Grad.drzava = Drzava.id " + "ORDER BY brojStanovnika DESC");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Drzava d = new Drzava();
                Grad g = new Grad();
                g.setId(rs.getInt(1));
                g.setNaziv(rs.getString(2));
                g.setBrojStanovnika(rs.getInt(3));
                d.setId(rs.getInt(5));
                d.setNaziv(rs.getString(6));
                Grad gg = nadjiGradPoIDu(rs.getInt(7));
                d.setGlavniGrad(gg);
                g.setDrzava(d);
                rezultat.add(g);
            }
            return rezultat;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Grad nadjiGradPoIDu(Integer id) {
        Grad g = new Grad();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT id, naziv, brojStanovnika, drzava FROM Grad WHERE id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                g.setId(rs.getInt(1));
                g.setNaziv(rs.getString(2));
                g.setBrojStanovnika(rs.getInt(3));
                return g;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
