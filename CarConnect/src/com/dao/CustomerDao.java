package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.CustomerReservationDetailsDto;
import com.dto.CustomersWithReservationsDto;
import com.dto.CustomersWithTotalSpentDto;
import com.exception.ResourceNotFoundException;
import com.model.Customer;

public interface CustomerDao {
	int save(Customer customer) throws SQLException;
	void deleteById(int id) throws SQLException,ResourceNotFoundException;
	void softDeleteById(int id) throws SQLException,ResourceNotFoundException;
	int update(Customer customer) throws SQLException,ResourceNotFoundException;
	List<Customer> findALL() throws SQLException;
	boolean findOne(int id) throws SQLException,ResourceNotFoundException;
	List<CustomersWithReservationsDto> getCustomerWithNumberOfReservations() throws SQLException;
	List<CustomersWithTotalSpentDto> getTotalSpentByCustomer() throws SQLException;
	List<CustomerReservationDetailsDto> getCustomerReservationDetails(int customerId) throws SQLException;
	int getCustomerIdByUsernamePassword(String username, String password)throws SQLException;
}
