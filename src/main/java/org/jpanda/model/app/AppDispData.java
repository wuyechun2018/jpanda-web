package org.jpanda.model.app;

// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AppDispData entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "APP_DISP_DATA")
public class AppDispData implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	
	private Long appDispDataId;
	private String dataType;
	private String dataKey;
	private Double dataValue;
	private Date dataDate;

	// Constructors

	/** default constructor */
	public AppDispData() {
	}

	/** minimal constructor */
	public AppDispData(Long appDispDataId) {
		this.appDispDataId = appDispDataId;
	}

	/** full constructor */
	public AppDispData(Long appDispDataId, String dataType, String dataKey,
			Double dataValue, Date dataDate) {
		this.appDispDataId = appDispDataId;
		this.dataType = dataType;
		this.dataKey = dataKey;
		this.dataValue = dataValue;
		this.dataDate = dataDate;
	}

	// Property accessors
	@Id
	@Column(name = "APP_DISP_DATA_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getAppDispDataId() {
		return this.appDispDataId;
	}

	public void setAppDispDataId(Long appDispDataId) {
		this.appDispDataId = appDispDataId;
	}

	@Column(name = "DATA_TYPE", length = 50)
	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	@Column(name = "DATA_KEY", length = 20)
	public String getDataKey() {
		return this.dataKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	@Column(name = "DATA_VALUE", precision = 20, scale = 4)
	public Double getDataValue() {
		return this.dataValue;
	}

	public void setDataValue(Double dataValue) {
		this.dataValue = dataValue;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_DATE")
	public Date getDataDate() {
		return this.dataDate;
	}

	public void setDataDate(Date dataDate) {
		this.dataDate = dataDate;
	}

}