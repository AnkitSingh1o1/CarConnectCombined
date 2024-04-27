package com.dao;

import java.sql.*;
import java.util.*;

import com.dto.AdminDto;
import com.dto.AdminDtoNew;
import com.dto.AdminDtoNew2;
import com.utility.DBConnect;
public class AdminDaoImpl implements AdminDao{


	@Override
	public double getRevenue() throws SQLException {
		Connection con = DBConnect.dbConnect();
		String sql = "SELECT SUM(reservation_total_cost) as 'totalRevenue' FROM reservation WHERE reservation_status = 'completed'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		double totalRevenue = 0;
		 if (rst.next())
			totalRevenue = rst.getDouble("totalRevenue");
		DBConnect.dbClose();
		
		return totalRevenue;
		
	}

	@Override
	public List<AdminDto> vehicleRevenue() throws SQLException {
		Connection con = DBConnect.dbConnect();
		
		String sql = " SELECT vehicle_id, sum(reservation_total_cost) as 'vehicleRevenue' "
				+"FROM reservation GROUP BY vehicle_id ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		
		List<AdminDto>list = new ArrayList<>();
		
		while(rst.next()==true) {
			int vehicleId = rst.getInt("vehicle_id");
			int totalRevenue = rst.getInt("vehicleRevenue");
			
			AdminDto admin = new AdminDto(vehicleId, totalRevenue);
			list.add(admin);
			
		}
		DBConnect.dbClose();
		return list;
	}

	
	
	@Override
	public List<AdminDtoNew> demographicReservationReport() throws SQLException {
		Connection con = DBConnect.dbConnect();
		
		String sql = " SELECT address_city, count(reservation_id) as 'numOfReservation' "
				+"FROM reservation r JOIN customer c ON r.customer_id = c.customer_id "
				+"JOIN address a ON c.address_id = a.address_id GROUP BY a.address_city";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		
		List<AdminDtoNew>list = new ArrayList<>();
		
		while(rst.next()==true) {
			String city = rst.getString("address_city");
			int numOfReservation = rst.getInt("numOfReservation");
			
			AdminDtoNew admin = new AdminDtoNew(city, numOfReservation);
			list.add(admin);
			
		}
		DBConnect.dbClose();
		return list;
	}

	@Override
	public List<AdminDtoNew2> vehicleReviewReport() throws SQLException {
		Connection con = DBConnect.dbConnect();
		String sql = "SELECT v.vehicle_id, v.vendor_id, AVG(r.review_rating) AS 'averageRating'"
				+"FROM vehicle v JOIN review r ON v.vehicle_id = r.vehicle_id GROUP BY r.review_rating " ;
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		
		List<AdminDtoNew2> list = new ArrayList<AdminDtoNew2>();
		while(rst.next() == true) {
			int vehicleId = rst.getInt("vehicle_id");
			int vendorId = rst.getInt("vendor_id");
			double averageRating = rst.getDouble("averageRating");
			
			AdminDtoNew2 newObj = new AdminDtoNew2(vehicleId,vendorId, averageRating);
			list.add(newObj);
		}
		
		return list;
	}

}
