package org.jpanda.dto.system;

public class SysCityProvinceDto {

		//主键
		private Long id;
		//城市编码
		private String cityCode;
		//城市名称
		private String cityName;
		//省份编码
		private String provinceCode;
		//省份名称
		private String provinceName;
		//地理坐标
		private String coordinate;
		//排序
		private Long orderby;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCityCode() {
			return cityCode;
		}
		public void setCityCode(String cityCode) {
			this.cityCode = cityCode;
		}
		public String getCityName() {
			return cityName;
		}
		public void setCityName(String cityName) {
			this.cityName = cityName;
		}
		public String getProvinceCode() {
			return provinceCode;
		}
		public void setProvinceCode(String provinceCode) {
			this.provinceCode = provinceCode;
		}
		public String getProvinceName() {
			return provinceName;
		}
		public void setProvinceName(String provinceName) {
			this.provinceName = provinceName;
		}
		public String getCoordinate() {
			return coordinate;
		}
		public void setCoordinate(String coordinate) {
			this.coordinate = coordinate;
		}
		public Long getOrderby() {
			return orderby;
		}
		public void setOrderby(Long orderby) {
			this.orderby = orderby;
		}
		
}
