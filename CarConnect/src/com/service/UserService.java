package com.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.dto.UserCountByRoleDto;
import com.dto.UserReservationHistoryDto;
import com.dto.UserTotalReservationsByStatusDto;
import com.exception.ResourceNotFoundException;
import com.model.User;
import com.utility.UserCountByRoleUtilityAsc;
import com.utility.UserTotalReservationsUtilityAsc;

public class UserService {
	UserDao userDao = new UserDaoImpl();

	public int insert(User user) throws SQLException {
		return userDao.save(user);
	}

	public void deleteById(int id) throws ResourceNotFoundException, SQLException {
		boolean isValid = userDao.findOne(id);

		if (!isValid)
			throw new ResourceNotFoundException("Id given is invalid!!!");
		userDao.deleteById(id);
	}

	public void softDeleteById(int id) throws SQLException, ResourceNotFoundException {
		boolean isValid = userDao.findOne(id);

		if (!isValid)
			throw new ResourceNotFoundException("Id given is invalid!!!");
		userDao.softDeleteById(id);
	}

	public List<User> findAll() throws SQLException {
		return userDao.findALL();
	}

	public int update(User user) throws SQLException, ResourceNotFoundException {
		return userDao.update(user);
	}

	public List<UserCountByRoleDto> getUserCountByRole() throws SQLException, ResourceNotFoundException {
		List<UserCountByRoleDto> list = userDao.getUserCountByRole();
		Collections.sort(list, new UserCountByRoleUtilityAsc());
		return list;
	}

	public List<UserTotalReservationsByStatusDto> getUserTotalReservationsByStatus()
			throws SQLException, ResourceNotFoundException {
		List<UserTotalReservationsByStatusDto> list = userDao.getUserTotalReservationsByStatus();
		Collections.sort(list, new UserTotalReservationsUtilityAsc());
		return list;
	}

	public List<UserReservationHistoryDto> getUserReservationHistory() throws SQLException, ResourceNotFoundException {
		return userDao.getUserReservationHistory();
	}

}
