
package org.jpanda.util;

/*******************************************************************************
 *  功能说明: 树节点
  
 *  2013-7-23 下午8:38:20 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2013-7-23 下午8:38:20 ycwu 修改文件
 * 
 ******************************************************************************/

public class TreeNode {
	
		private String id;            //ID   
	    private String text;          //节点显示   
	    private String iconCls;        //图标   
	    private String icon;           //图标   
	    private String menuPath;      //路径    系统管理->角色管理
	    private boolean leaf;         //是否叶子   
	    private String href;          //链接     /views/system/role
	    private String hrefTarget;    //链接指向   
	    private boolean expandable;   //是否展开   
	    private String description;   //描述信息
	    private String bizType;       //用于描述业务类型
	    private String bizKey;		  //业务数据
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		
		public String getIconCls() {
			return iconCls;
		}
		public void setIconCls(String iconCls) {
			this.iconCls = iconCls;
		}
		public boolean isLeaf() {
			return leaf;
		}
		public void setLeaf(boolean leaf) {
			this.leaf = leaf;
		}
		public String getHref() {
			return href;
		}
		public void setHref(String href) {
			this.href = href;
		}
		public String getHrefTarget() {
			return hrefTarget;
		}
		public void setHrefTarget(String hrefTarget) {
			this.hrefTarget = hrefTarget;
		}
		public boolean isExpandable() {
			return expandable;
		}
		public void setExpandable(boolean expandable) {
			this.expandable = expandable;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public String getMenuPath() {
			return menuPath;
		}
		public void setMenuPath(String menuPath) {
			this.menuPath = menuPath;
		}
		public String getBizType() {
			return bizType;
		}
		public void setBizType(String bizType) {
			this.bizType = bizType;
		}
		public String getBizKey() {
			return bizKey;
		}
		public void setBizKey(String bizKey) {
			this.bizKey = bizKey;
		}
		
}


