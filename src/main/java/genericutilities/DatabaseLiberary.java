package genericutilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DatabaseLiberary {
	
	Driver driverRef;
    Connection con;
    
    public void connectToDB() throws SQLException {
    	driverRef=new Driver();
    	DriverManager.registerDriver(driverRef);
    	con=DriverManager.getConnection(Iconstant.dbURL, Iconstant.dbun, Iconstant.dbpwd);
    	
    }
    
    
    
    public void closeDB() throws SQLException {
    	con.close();
    }
    
    
    public String readDataFromDBAndValidate(String quary,int columnIndex,String expData) throws SQLException {
    	
    	boolean flag=false;
    	ResultSet result = con.createStatement().executeQuery(quary);
    	while(result.next()) {
    		if(result.getString(columnIndex).equalsIgnoreCase(expData)) {
    			flag=true;
    			break;
    		}
    	}
    	if(flag==true) {
    		System.out.println("verified");
    		return expData;
    	}
    	else {
    		System.out.println("data not verified");
    		return "";
    	}
    }
}
