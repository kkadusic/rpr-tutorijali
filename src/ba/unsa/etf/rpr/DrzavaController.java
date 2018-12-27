package ba.unsa.etf.rpr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import net.sf.jasperreports.engine.JRException;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DrzavaController implements Initializable {
    public ComboBox<String> drzavaCombo;
    private ObservableList<String> listaDrzava = FXCollections.observableArrayList();
    ArrayList<Drzava> drzave;

    public DrzavaController() {}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        drzave = GeografijaDAO.getInstance().drzave();
        System.out.println(drzave);
        for (Drzava d: drzave) {
            listaDrzava.add(d.getNaziv());
        }
        drzavaCombo.setItems(listaDrzava);
    }

    //prema predavanju
    public void kreirajIzvjestaj(ActionEvent actionEvent) {
        GradoviReport gradoviReport = new GradoviReport();
        try {
            gradoviReport.showReportDrzava(GeografijaDAO.getConn(), drzavaCombo.getValue());
        }
        catch (JRException ex) {
            ex.printStackTrace();
        }
    }
}
