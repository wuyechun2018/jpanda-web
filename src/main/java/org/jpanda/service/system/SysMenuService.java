package org.jpanda.service.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jpanda.model.system.SysMenu;
import org.jpanda.util.NativeSqlHelper;
import org.jpanda.util.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/*******************************************************************************
 *  功能说明: 系统菜单 服务层
  
 *  2014-1-23 下午1:09:08 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2014-1-23 下午1:09:08 ycwu 修改文件
 * 
 ******************************************************************************/
@Component
public class SysMenuService {

	@Autowired
	private NativeSqlHelper sqlHelper;
	
	/**
	 * 
	 * 功能 :获取子节点
	
	 * 开发：ycwu 2014-1-23
	
	 * @param node
	 * @return
	 */
	public Object getChildList(String node,HttpServletRequest request) {
		
		//String menuUrl=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/static/images/menu/";
		
		String querySql="SELECT *\n" +
						"  FROM sys_menu t\n" + 
						" WHERE t.menu_pid = ?1\n" + 
						"   AND t.is_use = 'Y'\n" + 
						" ORDER BY t.order_no";
		List<SysMenu> menuList = sqlHelper.queryByNativeSQL(querySql,new Object[]{node},SysMenu.class);
		
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		for (int i = 0; i < menuList.size(); i++) {

			SysMenu sysMenu = menuList.get(i);

			TreeNode treeNode = new TreeNode();
			treeNode.setId(sysMenu.getMenuId().toString());
			treeNode.setText(sysMenu.getMenuName());
			treeNode.setHref(sysMenu.getMenuAddr());
			
			if(sysMenu.getMenuType()!=null&&"0".equals(sysMenu.getMenuType())){
				treeNode.setLeaf(false);
			}else{
				treeNode.setLeaf(true);
			}
			treeNode.setIconCls(sysMenu.getMenuIconUrl());
			treeNode.setMenuPath(sysMenu.getMenuPath());
			//如果要自定义树图标,可以加上下面两句,地址类似于http://localhost:9999/dms/static/images/menu/1-1.png"
			//String iconUrl=menuUrl+sysMenu.getMenuIconUrl()+".png";
			//treeNode.setIcon(iconUrl);  
			nodeList.add(treeNode);
		}
		return nodeList;
	}
	

}


