package com.service;
import java.sql.SQLException;
import java.util.List;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.dto.AdminDto;
import com.dto.AdminDtoNew;
import com.dto.AdminDtoNew2;



public class AdminService {
	AdminDao dao = new AdminDaoImpl();
	
	//Total revenue service forwarded to AdminDao class for implementation
	public double getRevenue() throws SQLException {
		return dao.getRevenue();
	}
	
	//vehicle revenue service
	public List<AdminDto> vehicleRevenue() throws SQLException {
		
		return dao.vehicleRevenue();
	}
	//display city wise reservations
	public List<AdminDtoNew> demographicReservationReport() throws SQLException {
		return dao.demographicReservationReport();
	}
	
	public List<AdminDtoNew2> vehicleReviewReport() throws SQLException {
		return dao.vehicleReviewReport();
	}

}
