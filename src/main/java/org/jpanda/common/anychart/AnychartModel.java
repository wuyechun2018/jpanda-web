package org.jpanda.common.anychart;

import java.util.List;

public class AnychartModel {
	
	private String titleText;
	//是否显示X轴
	private String isShowAxisLabel="true";
	
	//X轴显示模式,Normal,正常显示,Stager,交错显示
	private String axisDisPlayMode=AnychartConstant.ANYCHART_AXIS_DISPLAY_MODE_NORMAL;
	
	
	private List<AnychartSeries> series;


	public String getTitleText() {
		return titleText;
	}


	public void setTitleText(String titleText) {
		this.titleText = titleText;
	}


	public String getIsShowAxisLabel() {
		return isShowAxisLabel;
	}


	public void setIsShowAxisLabel(String isShowAxisLabel) {
		this.isShowAxisLabel = isShowAxisLabel;
	}


	public String getAxisDisPlayMode() {
		return axisDisPlayMode;
	}


	public void setAxisDisPlayMode(String axisDisPlayMode) {
		this.axisDisPlayMode = axisDisPlayMode;
	}


	public List<AnychartSeries> getSeries() {
		return series;
	}


	public void setSeries(List<AnychartSeries> series) {
		this.series = series;
	}

}
