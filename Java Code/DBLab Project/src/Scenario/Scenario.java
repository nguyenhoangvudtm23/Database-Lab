package Scenario;

import java.sql.SQLException;

import Execution.BusinessStatistics;
import Execution.CustomerStatistics;
import Execution.Installation;
import Execution.ProductStatistics;

public abstract class Scenario {
	public static void starting() throws ClassNotFoundException, SQLException
	{
		CustomerStatistics.getConnection();
		BusinessStatistics.getConnection();
		Installation.getConnection();
		ProductStatistics.getConnection();
	}
	public static void closing() throws SQLException
	{
		CustomerStatistics.closeConnection();
		BusinessStatistics.closeConnection();
		Installation.closeConnection();
		ProductStatistics.closeConnection();
	}
}
