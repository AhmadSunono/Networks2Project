package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

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
    private StackPane stack;

    @FXML
    void submitHandler(ActionEvent event) {

        ArrayList cities = new ArrayList();
        String start = "";
        String end = "";
        String server = "";
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
        System.out.println(user);
        System.out.println(pass);

    }

}
