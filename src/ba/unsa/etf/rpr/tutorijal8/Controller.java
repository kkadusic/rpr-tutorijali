package ba.unsa.etf.rpr.tutorijal8;

import javafx.application.Platform;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ProgressIndicator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    public SimpleStringProperty text;
    public SimpleListProperty<String> lista;
    public TextField searchField;
    public Button searchBtn;
    public ListView list;
    public List<String> result1;
    public Button stopButton;
    public ProgressIndicator progressIndicator;
    public boolean prekidanje = false;

    private Thread thread1, thread2;

    public Controller() {
        text = new SimpleStringProperty("");
        lista = new SimpleListProperty<>();
        result1 = Collections.synchronizedList(new ArrayList<>());
        progressIndicator = new ProgressIndicator(0);
    }

    @FXML
    public void initialize() {
        searchField.textProperty().bindBidirectional(text);
        list.itemsProperty().bindBidirectional(lista);
        lista.set(FXCollections.observableArrayList(result1));
        //stopButton.setDisable(true);
        prekidanje = false;
        progressIndicator.setProgress(0);
    }

    public void nadjiFajlove(File f) {
        if (prekidanje) return;
        try {
            File[] files = f.listFiles();
            if (files == null) return;
            for (File file : files) {
                if (file.isDirectory()) {
                    nadjiFajlove(file);
                } else {
                    if (file.getCanonicalPath().toLowerCase().contains(searchField.getText().toLowerCase())) {
                        String result = file.getCanonicalPath();
                        Platform.runLater(() -> {
                            list.getItems().add(result);
                        });
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickOnSearchBtn(ActionEvent actionEvent) {
        Runnable r = () -> nadjiFajlove(new File(System.getProperty("user.home")));
        Thread thread = new Thread(r);
        thread.start();
        initialize();
        Runnable r1 = () -> {
            searchBtn.setDisable(true);
            searchField.setDisable(true);
            //stopButton.setDisable(false);
            nadjiFajlove(new File(System.getProperty("user.home")));
        };
        Runnable r2 = () -> {
            for (int i = 1; i <= 1000; i++) {
                if (prekidanje) {
                    progressIndicator.setProgress(0);
                    break;
                }
                progressIndicator.setProgress(i / 1000.0);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread1 = new Thread(r1);
        thread2 = new Thread(r2);
        thread1.start();
        thread2.start();
    }
}