package org.jpanda.service.system;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jpanda.dao.jpa.system.SysProvinceJpaDao;
import org.jpanda.model.system.SysProvince;
import org.jpanda.util.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*******************************************************************************
 *  功能说明: 省份维护 服务层
  
 *  2014-10-23 下午1:08:13 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2014-10-23 下午1:08:13 ycwu 修改文件
 * 
 ******************************************************************************/
@Component
public class SysProvinceService {
	@Autowired
	private SysProvinceJpaDao sysProvinceJpaDao;

	/***
	 * 
	 * 功能 :获取省份
	
	 * 开发：ycwu 2014-10-27
	
	 * @param node
	 * @param request
	 * @return
	 */
	public Object getPorvinceList(String node, HttpServletRequest request) {
		List<SysProvince> proviceList=sysProvinceJpaDao.findAllProvinceList();
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		for (int i = 0; i < proviceList.size(); i++) {
			SysProvince sysProvince = proviceList.get(i);
			TreeNode treeNode=new TreeNode();
			treeNode.setId(sysProvince.getId().toString());
			//treeNode.setText("【"+sysProvince.getOrderby()+"】"+sysProvince.getProvinceName());
			treeNode.setText(sysProvince.getProvinceName());
			treeNode.setLeaf(true);
			//省份编码
			treeNode.setBizKey(sysProvince.getProvinceCode());
			nodeList.add(treeNode);
		}
		return nodeList;
	}

	/***
	 * 
	 * 功能 :根据省份编码获取省份信息
	
	 * 开发：ycwu 2014-10-27
	
	 * @param provinceCode
	 * @return
	 */
	public Object findByProvinceCode(String provinceCode) {
		return sysProvinceJpaDao.findByProvinceCode(provinceCode);
	}

	/***
	 * 
	 * 功能 :根据主键获取省份信息
	
	 * 开发：ycwu 2014-10-27
	
	 * @param id
	 * @return
	 */
	public Object findById(Long id) {
		return sysProvinceJpaDao.findOne(id);
	}

	/***
	 * 
	 * 功能 :保存
	
	 * 开发：ycwu 2014-10-27
	
	 * @param sysProvince
	 */
	public void save(SysProvince sysProvince) {
		sysProvinceJpaDao.save(sysProvince);
	}

	/**
	 * 
	 * 功能 :删除
	
	 * 开发：ycwu 2014-10-27
	
	 * @param id
	 */
	public void delete(Long id) {
		sysProvinceJpaDao.delete(id);
	}

	/**
	 * 
	 * 功能 :获取所有的省份信息
	
	 * 开发：ycwu 2014-10-28
	
	 * @return
	 */
	public Object getAllProvinceList() {
		//return sysProvinceJpaDao.findAll();
		return sysProvinceJpaDao.findAllProvinceList();
	}

}
