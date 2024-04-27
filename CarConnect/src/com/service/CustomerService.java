package com.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.dto.CustomerReservationDetailsDto;
import com.dto.CustomersWithReservationsDto;
import com.dto.CustomersWithTotalSpentDto;
import com.exception.ResourceNotFoundException;
import com.model.Customer;
import com.utility.ReservationNumSortUtilityAsc;
import com.utility.TotalSpentSortUtilityAsc;

public class CustomerService {
	CustomerDao customerDao = new CustomerDaoImpl();

	public int insert(Customer customer) throws SQLException {
		return customerDao.save(customer);
	}

	public void deleteById(int id) throws ResourceNotFoundException, SQLException {
		boolean isValid = customerDao.findOne(id);

		if (!isValid)
			throw new ResourceNotFoundException("Id given is invalid!!!");
		customerDao.deleteById(id);
	}

	public void softDeleteById(int id) throws SQLException, ResourceNotFoundException {
		boolean isValid = customerDao.findOne(id);

		if (!isValid)
			throw new ResourceNotFoundException("Id given is invalid!!!");
		customerDao.softDeleteById(id);
	}

	public List<Customer> findAll() throws SQLException {
		return customerDao.findALL();
	}

	public int update(Customer customer) throws SQLException, ResourceNotFoundException {
		return customerDao.update(customer);
	}

	public List<CustomersWithReservationsDto> getCustomerWithNumberOfReservations() throws SQLException {
		List<CustomersWithReservationsDto> list = customerDao.getCustomerWithNumberOfReservations();
		Collections.sort(list, new ReservationNumSortUtilityAsc());
		return list;
	}

	public List<CustomersWithTotalSpentDto> getTotalSpentByCustomer() throws SQLException {
		List<CustomersWithTotalSpentDto> list = customerDao.getTotalSpentByCustomer();
		Collections.sort(list, new TotalSpentSortUtilityAsc());
		return list;
	}

	public List<CustomerReservationDetailsDto> getCustomerReservationDetails(int customerId) throws SQLException {
		return customerDao.getCustomerReservationDetails(customerId);
	}

	public int getCustomerIdByUsernamePassword(String username, String password) throws SQLException {
		return customerDao.getCustomerIdByUsernamePassword(username, password);
	}
}
