package org.jpanda.model.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/*******************************************************************************
 *  功能说明: 系统管理-省份  实体
  
 *  2014-10-23 下午2:58:49 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2014-10-23 下午2:58:49 ycwu 修改文件
 * 
 ******************************************************************************/
@Entity
@Table(name = "SYS_PROVINCE")
public class SysProvince implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	//主键
	private Long id;
	//编码
	private String provinceCode;
	//名称
	private String provinceName;
	//排序
	private Long orderby;

	// Constructors

	/** default constructor */
	public SysProvince() {
	}

	/** minimal constructor */
	public SysProvince(Long id) {
		this.id = id;
	}

	/** full constructor */
	public SysProvince(Long id, String provinceCode, String provinceName,
			Long orderby) {
		this.id = id;
		this.provinceCode = provinceCode;
		this.provinceName = provinceName;
		this.orderby = orderby;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator="SysProvince")
	@TableGenerator(name="SysProvince",table="PK_GENERERATE_SEQ",pkColumnName="gen_key",valueColumnName="gen_value",pkColumnValue="SYS_PROVINCE",allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "PROVINCE_CODE")
	public String getProvinceCode() {
		return this.provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	@Column(name = "PROVINCE_NAME")
	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	@Column(name = "ORDERBY", precision = 10, scale = 0)
	public Long getOrderby() {
		return this.orderby;
	}

	public void setOrderby(Long orderby) {
		this.orderby = orderby;
	}

}