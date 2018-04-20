package com.ho.dvla.common;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.ho.autotest.model.Vehicle;



public class Helper {
	
   public static void generateVehicleReport(List<Vehicle> vehicleList)
   {
	   
    try   
    {
    	//VehicleRegNo, make, colour, fueltype
        FileWriter writer = new FileWriter(System.getProperty("user.dir")+"/report/VehicleReport.csv",false);
  
            writer.append("RegNo");
        writer.append(',');
        writer.append("Make");
        writer.append(',');
        writer.append("Colour");
        writer.append(',');
        writer.append("Reult");
        
        
        for(Vehicle v:vehicleList)
        {
        	writer.append('\n');
        	writer.append(v.toCSVString());
        }
  
        writer.flush();
        writer.close();
    }
    catch(IOException e)
    {
         e.printStackTrace();
    } 
    }

}
