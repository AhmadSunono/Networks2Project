package Main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import Main.TableController.City;

public class Controller {

    @FXML
    private CheckBox cityJerusalem;

    @FXML
    private CheckBox cityNablus;

    @FXML
    private CheckBox cityHebron;

    @FXML
    private CheckBox cityRamallah;

    @FXML
    private CheckBox cityTulkarm;

    @FXML
    private DatePicker startDate;

    @FXML
    private DatePicker endDate;

    @FXML
    private ToggleGroup viewAsGroup;

    @FXML
    private ToggleGroup serverGroup;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button submit;

    @FXML
    private ToggleGroup methodGroup;

    @FXML
    private Button add;

    @FXML
    private StackPane stack;

    @FXML
    void addHandler(ActionEvent event) {
        // Create the custom dialog.
        Dialog<HashMap<String, String>> dialog = new Dialog<>();
        dialog.setTitle("ADD/EDIT Cases");
        dialog.setHeaderText("Add/Edit Coronavirus Cases And Recovered");


        // Set the button types.
        ButtonType addType = new ButtonType("ADD/EDIT", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField newCases = new TextField();
        newCases.setPromptText("New Cases");
        TextField newRecovered = new TextField();
        newRecovered.setPromptText("New Recovered");
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Nablus",
                        "Jerusalem",
                        "Tulkarm",
                        "Hebron",
                        "Ramallah"
                );
        final ComboBox<String> cities = new ComboBox<String>(options);
        DatePicker date = new DatePicker();

        grid.add(new Label("New Cases:"), 0, 0);
        grid.add(newCases, 1, 0);
        grid.add(new Label("New Recovered:"), 0, 1);
        grid.add(newRecovered, 1, 1);
        grid.add(new Label("Date:"), 0, 2);
        grid.add(date, 1, 2);
        grid.add(new Label("City:"), 0, 3);
        grid.add(cities, 1, 3);

        dialog.getDialogPane().setContent(grid);

        // Convert the result
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addType) {
                HashMap <String, String>res = new HashMap<String, String>();
                res.put("cases", newCases.getText().toString());
                res.put("recovered", newRecovered.getText().toString());
                res.put("date", date.getValue().toString());
                res.put("city", cities.getValue().toString());
                return res;
            }
            return null;
        });

        Optional<HashMap<String, String>> result = dialog.showAndWait();

        result.ifPresent(hashResult -> {
            System.out.println("Cases= " + hashResult.get("cases") + ", Recovered= " + hashResult.get("recovered") + ", Date= " + hashResult.get("date") + ", City= " + hashResult.get("city"));
        });
    }

    @FXML
    void submitHandler(ActionEvent event) throws IOException {

        ArrayList cities = new ArrayList();
        String start = "";
        String end = "";
        String server = "";
        String method = "";
        String viewAs = "";
        String user = "";
        String pass = "";

        if(cityHebron.isSelected()) cities.add("hebron");
        if(cityJerusalem.isSelected()) cities.add("jerusalem");
        if(cityNablus.isSelected()) cities.add("nablus");
        if(cityRamallah.isSelected()) cities.add("ramallah");
        if(cityTulkarm.isSelected()) cities.add("tulkarm");

        start = startDate.getValue() == null? "" : startDate.getValue().toString();
        end = endDate.getValue() == null? "" : endDate.getValue().toString();

        viewAs = ((RadioButton) viewAsGroup.getSelectedToggle()).getText();
        server = ((RadioButton) serverGroup.getSelectedToggle()).getText();
        method = ((RadioButton) methodGroup.getSelectedToggle()).getText();

        user = username.getText() == "" ? "" : username.getText();
        pass = password.getText() == "" ? "" : password.getText();

        for (Object city: cities
             ) {
            System.out.print(city + ",");
        }
        System.out.println();
        System.out.println(start);
        System.out.println(end);
        System.out.println(viewAs);
        System.out.println(server);
        System.out.println(method);
        System.out.println(user);
        System.out.println(pass);

//        FXMLLoader pieLoader = new FXMLLoader(getClass().getResource("/Main/chart.fxml"));
//
//        stack.getChildren()
//                .add((AnchorPane)pieLoader.load());
//
//
//        ChartController chartController = pieLoader.getController();
//
//        HashMap<String, String> data = new HashMap<String, String>();
//        data.put("nablus", "15");
//        data.put("jerusalem", "15");
//        data.put("tulkarm", "15");
//        data.put("ramallah", "5");
//        data.put("hebron", "50");
//
//
//        chartController.displayData(data);


        FXMLLoader tableLoader = new FXMLLoader(getClass().getResource("/Main/table.fxml"));

        stack.getChildren()
                .add((AnchorPane)tableLoader.load());

        TableController tableController = tableLoader.getController();
        ArrayList<City> citiesData = new ArrayList<TableController.City>();

        citiesData.add(new City("Nablus", 70, 15));
        citiesData.add(new City("Tulkarm", 50, 5));
        citiesData.add(new City("Ramallah", 60, 6));
        citiesData.add(new City("Hebron", 120, 1));
        citiesData.add(new City("Jerusalem", 3, 0));

        tableController.setData(citiesData);


    }

}
