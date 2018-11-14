package ba.unsa.etf.rpr.tutorijal05;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;

public class Controller {

    private SimpleStringProperty displej;
    private SimpleStringProperty prvi_operand = new SimpleStringProperty("");
    private SimpleStringProperty operacija = new SimpleStringProperty("");

    public String getDisplej() {
        return displej.get();
    }

    public SimpleStringProperty displejProperty() {
        return displej;
    }

    public void setDisplej(String displej) {
        this.displej.set(displej);
    }

    public Controller(){
        displej = new SimpleStringProperty("0");
    }
}