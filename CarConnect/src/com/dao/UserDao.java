package com.dao;

import java.sql.SQLException;
import java.util.List;
import com.dto.UserCountByRoleDto;
import com.dto.UserReservationHistoryDto;
import com.dto.UserTotalReservationsByStatusDto;
import com.exception.ResourceNotFoundException;
import com.model.User;

public interface UserDao {
	int save(User user) throws SQLException;
	void deleteById(int id) throws SQLException,ResourceNotFoundException;
	void softDeleteById(int id) throws SQLException,ResourceNotFoundException;
	int update(User user) throws SQLException,ResourceNotFoundException;
	List<User> findALL() throws SQLException;
	boolean findOne(int id) throws SQLException,ResourceNotFoundException;
	List<UserCountByRoleDto> getUserCountByRole() throws SQLException,ResourceNotFoundException;
	List<UserTotalReservationsByStatusDto> getUserTotalReservationsByStatus() throws SQLException,ResourceNotFoundException;
	List<UserReservationHistoryDto> getUserReservationHistory() throws SQLException,ResourceNotFoundException;	
}
