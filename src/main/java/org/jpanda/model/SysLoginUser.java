package org.jpanda.model;

/*******************************************************************************
 *  功能说明: 系统登录用户实体类

 *  2013-3-8 下午5:35:37 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2013-3-8 下午5:35:37 ycwu 修改文件
 * 
 ******************************************************************************/


/**
 * SysLoginUser entity. @author MyEclipse Persistence Tools
 */
public class SysLoginUser implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	// Fields

	private Long userId;
	private String userName; //用户名
	private String userAlias;//用户昵称
	private String userCode; //用户编码
	private String sex; //性别   0 女  1男  2 不确定
	private String loginAccount; //用户账号
	private String loginPwd; //用户密码
	private String userEmail; //用户邮件
	private String userState; //用户状态   R:注册  U:在用  L:锁定   D:删除
	private String userType; //用户类型 
	private String userTheme; //用户主题
	private String memo; //说明
	private Long orderBy; //排序

	// Constructors

	/** default constructor */
	public SysLoginUser() {
	}

	/** minimal constructor */
	public SysLoginUser(Long userId, String userName, String sex,
			String loginAccount, String loginPwd, String userEmail,
			String userState, String userType, String userTheme, Long orderBy) {
		this.userId = userId;
		this.userName = userName;
		this.sex = sex;
		this.loginAccount = loginAccount;
		this.loginPwd = loginPwd;
		this.userEmail = userEmail;
		this.userState = userState;
		this.userType = userType;
		this.userTheme = userTheme;
		this.orderBy = orderBy;
	}

	/** full constructor */
	public SysLoginUser(Long userId, String userName, String userAlias,
			String userCode, String sex, String loginAccount, String loginPwd,
			String userEmail, String userState, String userType,
			String userTheme, String memo, Long orderBy) {
		this.userId = userId;
		this.userName = userName;
		this.userAlias = userAlias;
		this.userCode = userCode;
		this.sex = sex;
		this.loginAccount = loginAccount;
		this.loginPwd = loginPwd;
		this.userEmail = userEmail;
		this.userState = userState;
		this.userType = userType;
		this.userTheme = userTheme;
		this.memo = memo;
		this.orderBy = orderBy;
	}

	// Property accessors
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAlias() {
		return this.userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLoginAccount() {
		return this.loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserState() {
		return this.userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserTheme() {
		return this.userTheme;
	}

	public void setUserTheme(String userTheme) {
		this.userTheme = userTheme;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Long getOrderBy() {
		return this.orderBy;
	}

	public void setOrderBy(Long orderBy) {
		this.orderBy = orderBy;
	}

}
