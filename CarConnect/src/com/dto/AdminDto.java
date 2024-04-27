package com.dto;

public class AdminDto {
	public int vehicleId;
	public int vehicleRevenue;
	
	
	
	@Override
	public String toString() {
		return "AdminDto [vehicleId=" + vehicleId + ", vehicleRevenue=" + vehicleRevenue + "]";
	}
	public AdminDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminDto(int vehicleId, int vehicleRevenue) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleRevenue = vehicleRevenue;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public int getVehicleRevenue() {
		return vehicleRevenue;
	}
	public void setVehicleRevenue(int vehicleRevenue) {
		this.vehicleRevenue = vehicleRevenue;
	}
}
