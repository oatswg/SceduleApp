import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    protected TableView table;
    @FXML
    protected TableColumn<Table, Integer> number;
    @FXML
    protected TableColumn<Table, String> assignment;
    @FXML
    protected TableColumn<Table, String> date;
    @FXML
    protected TableColumn<Table, String> time;
    @FXML
    protected TextField assignText;
    @FXML
    protected TextField dateText;
    @FXML
    protected TextField timeText;

    int number1 = 1;

    ObservableList<Table> data = FXCollections.observableArrayList();

    private IntegerProperty index = new SimpleIntegerProperty();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        index.set(-1);

        number.setCellValueFactory(new PropertyValueFactory<Table, Integer>("sNumber"));
        assignment.setCellValueFactory(new PropertyValueFactory<Table, String>("sAssment"));
        date.setCellValueFactory(new PropertyValueFactory<Table, String>("sDate"));
        time.setCellValueFactory(new PropertyValueFactory<Table, String>("sTime"));
        table.setItems(data);


        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                index.set(data.indexOf(newValue));

            }
        });
    }

    public void AddBtn(ActionEvent event) {
        Table t = new Table(number1, assignText.getText(), dateText.getText(), timeText.getText());
        data.add(t);
        number1++;
    }

    public void DeleteBtn(ActionEvent event) {
        int i = index.get();
        if (i > -1) {
            data.remove(i);
            table.getSelectionModel().clearSelection();


        }
    }
}
