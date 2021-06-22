package Application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;

public class BarChartController extends ChartControllerUtil implements ChartController, Initializable{
	@FXML
	BarChart barChart;
	@FXML
	Button createChart;
	
	public void createABarChart() throws SQLException, ClassNotFoundException
	{
		//BusinessStatistics.getConnection();
		barChart.setTitle(ChartChooserController.chartName);
		ObservableList<Series> series = BarChartController.convert_Result_Set_To_Bar_Chart_Data
				(ChartChooserController.resultToDisplay);
		barChart.getData().clear();
		//loi ngu ngoc voi truc X cac ban a dcm nha no
		barChart.getXAxis().setAnimated(false);
		barChart.getData().addAll(series);
	}
	public void clear()
	{
		barChart.getData().clear();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		barChart.setTitle(ChartChooserController.chartName);
		vBox.prefWidthProperty().bind(anchorPane.widthProperty());
		vBox.prefHeightProperty().bind(anchorPane.heightProperty());
		vBox.setAlignment(Pos.CENTER);
	}
}
