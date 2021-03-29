package Scenario;

import java.sql.SQLException;

import Execution.BusinessStatistics;
import Execution.CustomerStatistics;
import Execution.Installation;
import Execution.ProductStatistics;

public abstract class Scenario {
	public static void Starting() throws ClassNotFoundException, SQLException
	{
		CustomerStatistics.getConnection();
		BusinessStatistics.getConnection();
		Installation.getConnection();
		ProductStatistics.getConnection();
	}
	
}
