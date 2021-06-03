package Application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import Execution.BusinessStatistics;
import Execution.CustomerStatistics;
import Execution.IngredientStatistics;
import Execution.ProductStatistics;
import Execution.SupplierStatistics;
import Scenario.Starter;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public final class SceneHolder {
	private Parent mainMenu;
	private Parent statisticsMenu;
	private Parent managementMenu;
	private Parent billScene;
	private Parent buyOrderScene;
	private final static SceneHolder singleton = new SceneHolder();
	public static Parent getBillScene()
	{
		return singleton.billScene;
	}
	public static Parent getBuyOrderScene()
	{
		return singleton.buyOrderScene;
	}
	public static SceneHolder getSingleton()
	{
		return singleton;
	}
	public static Parent getMainMenu()
	{
		return singleton.mainMenu;
	}
	public static Parent getStatisticsMenu()
	{
		return singleton.statisticsMenu;
	}
	public static Parent getManagementMenu()
	{
		return singleton.managementMenu;
	}
	public void setup() throws IOException
	{
		singleton.mainMenu = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		singleton.statisticsMenu = FXMLLoader.load(getClass().getResource("StatisticsMenu.fxml"));	
		singleton.managementMenu = FXMLLoader.load(getClass().getResource("ManagementMenu.fxml"));
		singleton.billScene = FXMLLoader.load(getClass().getResource("BillScene.fxml"));
		singleton.buyOrderScene = FXMLLoader.load(getClass().getResource("BuyOrder.fxml"));
	}
}
