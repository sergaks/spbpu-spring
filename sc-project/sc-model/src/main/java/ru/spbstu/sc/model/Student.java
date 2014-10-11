package ru.spbstu.sc.model;


public class Student extends User {

	private short startYear;
	private short graduationYear;
	
	public short getStartYear() {
		return startYear;
	}
	public void setStartYear(short startYear) {
		this.startYear = startYear;
	}
	public short getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(short graduationYear) {
		this.graduationYear = graduationYear;
	}
	@Override
	public String toString() {
		return super.toString() + " [startYear=" + startYear + ", graduationYear="
				+ graduationYear + "]";
	}
	
	
	
}
