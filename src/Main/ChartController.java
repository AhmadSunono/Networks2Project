package Main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

import java.util.HashMap;

public class ChartController {

    @FXML
    private PieChart chart;

    public void displayData(HashMap<String, String> data) {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Nablus", Integer.parseInt(data.get("nablus"))),
                        new PieChart.Data("Jerusalem", Integer.parseInt(data.get("jerusalem"))),
                        new PieChart.Data("Tulkarm", Integer.parseInt(data.get("tulkarm"))),
                        new PieChart.Data("Ramallah", Integer.parseInt(data.get("ramallah"))),
                        new PieChart.Data("Hebron", Integer.parseInt(data.get("hebron"))));

        chart.setData(pieChartData);
    }

}
