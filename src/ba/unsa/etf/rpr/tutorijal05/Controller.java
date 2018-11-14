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

    public void btn00(ActionEvent actionEvent) {
        if(displej.get()!="0") displej.set(displej.get()+"0");
    }

    public void btn11(ActionEvent actionEvent) {
        if(displej.get()=="0"|| operacija.get()=="=") displej.set("");
        displej.set(displej.get()+"1");
    }

    public void btn22(ActionEvent actionEvent) {
        if(displej.get()=="0"|| operacija.get()=="=") displej.set("");
        displej.set(displej.get()+"2");
    }

    public void btn33(ActionEvent actionEvent) {
        if(displej.get()=="0"|| operacija.get()=="=") displej.set("");
        displej.set(displej.get()+"3");
    }

    public void btn44(ActionEvent actionEvent) {
        if(displej.get()=="0"|| operacija.get()=="=") displej.set("");
        displej.set(displej.get()+"4");
    }

    public void btn66(ActionEvent actionEvent) {
        if(displej.get()=="0"|| operacija.get()=="=") displej.set("");
        displej.set(displej.get()+"6");
    }

    public void btn77(ActionEvent actionEvent) {
        if(displej.get()=="0"|| operacija.get()=="=") displej.set("");
        displej.set(displej.get()+"7");

    }

    public void btn88(ActionEvent actionEvent) {
        if(displej.get()=="0"|| operacija.get()=="=") displej.set("");
        displej.set(displej.get()+"8");
    }

    public void btn99(ActionEvent actionEvent) {
        if(displej.get()=="0"|| operacija.get()=="=") displej.set("");
        displej.set(displej.get()+"9");
    }
}