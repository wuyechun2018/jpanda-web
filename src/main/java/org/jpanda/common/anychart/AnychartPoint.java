package org.jpanda.common.anychart;

public class AnychartPoint {

	private String pointName;
	private String pointValue;
	
	public AnychartPoint(String pointName, String pointValue) {
		super();
		this.pointName = pointName;
		this.pointValue = pointValue;
	}

	public AnychartPoint() {
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public String getPointValue() {
		return pointValue;
	}

	public void setPointValue(String pointValue) {
		this.pointValue = pointValue;
	}

}
