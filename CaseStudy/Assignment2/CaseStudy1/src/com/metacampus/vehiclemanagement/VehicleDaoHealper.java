package com.metacampus.vehiclemanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.metacampus.vehiclemanagement.model.Vehicle;
import com.metacampus.vehiclemanagement.model.Car;
import com.metacampus.vehiclemanagement.model.Bike;


public class VehicleDaoHealper {
	
	public static boolean insertIntoVehicle(Vehicle vehicle) {

		Connection con = null;
		PreparedStatement ps = null;
		int result;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		String query = "INSERT INTO vehicle (`vehicleId`, `make`, `model`, `engineInCC`, `fuelCapacity`,"
				+ " `mileage`, `price`, `roadTax`)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?); ";	
		try {
			ps = con.prepareStatement(query);
			
			ps.setDouble(1,vehicle.getVehicleId());
			ps.setString(2,vehicle.getMake());
			ps.setString(3,vehicle.getModel());
			ps.setInt(4,vehicle.getEngineInCC());
			ps.setInt(5,vehicle.getFuelCapacity());
			ps.setInt(6,vehicle.getMileage());
			ps.setFloat(7,vehicle.getPrice());
			ps.setFloat(8,vehicle.getRoadTax());
			result = ps.executeUpdate();
			
			if(result>0) {
				if(vehicle instanceof Car) {
					  boolean b = insertIntoCar(vehicle);
					  if(b==true)
						  return true;
					  else
						  return false;
				}
				else {
					 boolean b = insertIntoBike(vehicle);
					 if(b==true)
						 return true;
					 else
						 return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	private static boolean insertIntoCar(Vehicle vehicle) {
		Connection con = null;
		PreparedStatement ps = null;
		int result;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		String query = "INSERT INTO Car (`vehicleId`, `ac`, `powerSteering`, `accessoryKit`)"
				+ " VALUES (?, ?, ?, ?); ";
		
		try {
			ps = con.prepareStatement(query);
			ps.setDouble(1,vehicle.getVehicleId());
			ps.setBoolean(2,((Car) vehicle).isAC());
			ps.setBoolean(3,((Car) vehicle).isPowerSteering());
			ps.setString(4,((Car) vehicle).getAccessoryKit());
			result = ps.executeUpdate();
			if(result>0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			  }
		}
		return false;
	}

	private static boolean insertIntoBike(Vehicle vehicle) {
		Connection con = null;
		PreparedStatement ps = null;
		int result;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		String query = "INSERT INTO Bike (`vehicleId`, `SelfStart`, `HelmetPrice`)"
				+ " VALUES (?, ?, ?);  ";
		try {
			ps = con.prepareStatement(query);
			ps.setDouble(1,vehicle.getVehicleId());
			ps.setBoolean(2,((Bike) vehicle).isSelfStart());
			ps.setInt(3,((Bike) vehicle).getHelmetPrice());
			result = ps.executeUpdate();
			if(result>0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;
	}
}
