package org.jpanda.common.anychart;

import java.util.List;

public class AnychartSeries {

	private String seriesName;
	private String seriesType;
	private List<AnychartPoint> points;
	
	public String getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	
	public String getSeriesType() {
		return seriesType;
	}
	public void setSeriesType(String seriesType) {
		this.seriesType = seriesType;
	}
	public List<AnychartPoint> getPoints() {
		return points;
	}
	public void setPoints(List<AnychartPoint> points) {
		this.points = points;
	}
	
	
}
