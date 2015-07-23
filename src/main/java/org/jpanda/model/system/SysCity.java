package org.jpanda.model.system;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/*******************************************************************************
 *  功能说明: 系统管理-城市  实体
  
 *  2014-10-23 下午2:58:49 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2014-10-23 下午2:58:49 ycwu 修改文件
 * 
 ******************************************************************************/
@Entity
@Table(name = "SYS_CITY")
public class SysCity implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	//主键
	private Long id;
	//城市编码
	private String cityCode;
	//城市名称
	private String cityName;
	//省份编码
	private String provinceCode;
	//地理坐标
	private String coordinate;
	//排序
	private Long orderby;

	// Constructors

	/** default constructor */
	public SysCity() {
	}

	/** minimal constructor */
	public SysCity(Long id) {
		this.id = id;
	}

	/** full constructor */
	public SysCity(Long id, String cityCode, String cityName,
			String provinceCode, String coordinate, Long orderby) {
		this.id = id;
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.provinceCode = provinceCode;
		this.coordinate = coordinate;
		this.orderby = orderby;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator="SysCity")
	@TableGenerator(name="SysCity",table="PK_GENERERATE_SEQ",pkColumnName="gen_key",valueColumnName="gen_value",pkColumnValue="SYS_CITY",allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CITY_CODE")
	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	@Column(name = "CITY_NAME")
	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Column(name = "PROVINCE_CODE")
	public String getProvinceCode() {
		return this.provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	@Column(name = "COORDINATE")
	public String getCoordinate() {
		return this.coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	@Column(name = "ORDERBY", precision = 10, scale = 0)
	public Long getOrderby() {
		return this.orderby;
	}

	public void setOrderby(Long orderby) {
		this.orderby = orderby;
	}

}