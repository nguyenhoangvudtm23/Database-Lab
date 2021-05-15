package Scenario;

import java.sql.SQLException;

import Execution.BusinessStatistics;
import Execution.CustomerStatistics;
import Execution.IngredientStatistics;
import Execution.Installation;
import Execution.ProductStatistics;
import Execution.SupplierStatistics;

public abstract class Scenario {
	public static void starting() throws ClassNotFoundException, SQLException
	{
		CustomerStatistics.getConnection();
		BusinessStatistics.getConnection();
		Installation.getConnection();
		ProductStatistics.getConnection();
		SupplierStatistics.getConnection();
		IngredientStatistics.getConnection();
	}
	public static void closing() throws SQLException
	{
		CustomerStatistics.closeConnection();
		BusinessStatistics.closeConnection();
		Installation.closeConnection();
		ProductStatistics.closeConnection();
		SupplierStatistics.closeConnection();
		IngredientStatistics.closeConnection();
	}
}
