package ru.spbstu.sc.model;

public class Address extends BaseEntity {

	City city;
	String street;
	String house;
	String flat;
	String discription;
	SubwayStation subwayStation;
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getFlat() {
		return flat;
	}
	public void setFlat(String flat) {
		this.flat = flat;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public SubwayStation getSubwayStation() {
		return subwayStation;
	}
	public void setSubwayStation(SubwayStation subwayStation) {
		this.subwayStation = subwayStation;
	}
}
