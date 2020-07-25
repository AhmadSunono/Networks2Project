package Main;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    public static class City {

        public SimpleStringProperty name = new SimpleStringProperty();
        public SimpleIntegerProperty active = new SimpleIntegerProperty();
        public SimpleIntegerProperty recovered = new SimpleIntegerProperty();
        public SimpleIntegerProperty total = new SimpleIntegerProperty();

        public String getName() {
            return name.get();
        }

        public SimpleStringProperty nameProperty() {
            return name;
        }

        public int getActive() {
            return active.get();
        }

        public SimpleIntegerProperty activeProperty() {
            return active;
        }

        public int getRecovered() {
            return recovered.get();
        }

        public SimpleIntegerProperty recoveredProperty() {
            return recovered;
        }

        public int getTotal() {
            return total.get();
        }

        public SimpleIntegerProperty totalProperty() {
            return total;
        }

                public City(){
            this("", 0, 0);
        }


        public City(String name, Integer active, Integer recovered){
            this.name.setValue(name);
            this.active.setValue(active);
            this.recovered.setValue(recovered);
            this.total.setValue(active - recovered);

        }


    }

    @FXML
    private TableView<City> table;

    @FXML
    private TableColumn<City, String> cityColumn;

    @FXML
    private TableColumn<City, Integer> totalColumn;

    @FXML
    private TableColumn<City, Integer> activeColumn;

    @FXML
    private TableColumn<City, Integer> recColumn;


    public ObservableList<City> data;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cityColumn.setCellValueFactory(new PropertyValueFactory<City, String>("name"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<City, Integer>("total"));
        activeColumn.setCellValueFactory(new PropertyValueFactory<City, Integer>("active"));
        recColumn.setCellValueFactory(new PropertyValueFactory<City, Integer>("recovered"));

        data = FXCollections.observableArrayList();
        table.setItems(data);

    }

    public void setData(ArrayList<City> data){

        this.data.addAll(data);

    }

}

