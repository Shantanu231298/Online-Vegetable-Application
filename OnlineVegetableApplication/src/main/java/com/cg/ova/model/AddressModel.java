package com.cg.ova.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//Model Class
@Embeddable
public class AddressModel {
	@NotNull(message="Flat Number cannot be null")
	@NotBlank(message="Flat Number cannot be blank")
	@Column(name="flat_no")
	private String flatNo;
	
	@Column(name="building_name")
	@NotEmpty(message="building name cannot be empty")
	@NotNull(message="building name cannot be omitted")
    private String buildingName;
	
	@NotNull(message="Area cannot be null")
	@NotBlank(message="Area cannot be blank")
	private String area;
	
	
	@NotNull(message="City Name cannot be null")
	@NotBlank(message="City Name cannot be blank")
	private String city;
	
	@NotNull(message="State Name cannot be null")
	@NotBlank(message="State Name cannot be blank")
	private String state;
	
	
	@Min(value=6, message="Pincode should be valid of length 6")
	@Max(value=6, message="Pincode should be valid of length 6")
	private String pincode;
	
	public AddressModel() {
		//no implementation
		}

	public AddressModel(
			@NotNull(message = "Flat Number cannot be null") @NotBlank(message = "Flat Number cannot be blank") String flatNo,
			@NotNull(message = "Building Name cannot be null") @NotBlank(message = "Building Name cannot be blank") @NotEmpty(message = "building name cannot be empty") @NotNull(message = "building name cannot be omitted") String buildingName,
			@NotNull(message = "Area cannot be null") @NotBlank(message = "Area cannot be blank") String area,
			@NotNull(message = "City Name cannot be null") @NotBlank(message = "City Name cannot be blank") String city,
			@NotNull(message = "State Name cannot be null") @NotBlank(message = "State Name cannot be blank") String state,
			@Min(value = 6, message = "Pincode should be valid of length 6") @Max(value = 6, message = "Pincode should be valid of length 6") String pincode) {
		super();
		this.flatNo = flatNo;
		this.buildingName = buildingName;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((buildingName == null) ? 0 : buildingName.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((flatNo == null) ? 0 : flatNo.hashCode());
		result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressModel other = (AddressModel) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (buildingName == null) {
			if (other.buildingName != null)
				return false;
		} else if (!buildingName.equals(other.buildingName))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (flatNo == null) {
			if (other.flatNo != null)
				return false;
		} else if (!flatNo.equals(other.flatNo))
			return false;
		if (pincode == null) {
			if (other.pincode != null)
				return false;
		} else if (!pincode.equals(other.pincode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AddressModel [flatNo=" + flatNo + ", buildingName=" + buildingName + ", area=" + area + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + "]";
	}

}
