package org.jpanda.model;

/*******************************************************************************
 *  功能说明: 系统登录用户实体类

 *  2013-3-8 下午5:35:37 wuyechun 创建文件
 * 
 *  修改说明: 创建文件

 *  2013-3-8 下午5:35:37 wuyechun 修改文件
 * 
 ******************************************************************************/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * SysLoginUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SYS_LOGIN_USER")
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
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator="SysLoginUser")
	@TableGenerator(name="SysLoginUser",table="PK_GENERERATE_SEQ",pkColumnName="gen_key",valueColumnName="gen_value",pkColumnValue="SYS_LOGIN_USER")
	@Column(name = "USER_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "USER_NAME", nullable = false, length = 20)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "USER_ALIAS", length = 20)
	public String getUserAlias() {
		return this.userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}

	@Column(name = "USER_CODE", length = 20)
	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Column(name = "SEX", nullable = false, length = 1)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "LOGIN_ACCOUNT", nullable = false, length = 30)
	public String getLoginAccount() {
		return this.loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	@Column(name = "LOGIN_PWD", nullable = false, length = 40)
	public String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	@Column(name = "USER_EMAIL", nullable = false, length = 30)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "USER_STATE", nullable = false, length = 1)
	public String getUserState() {
		return this.userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	@Column(name = "USER_TYPE", nullable = true, length = 1)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "USER_THEME", nullable = true, length = 50)
	public String getUserTheme() {
		return this.userTheme;
	}

	public void setUserTheme(String userTheme) {
		this.userTheme = userTheme;
	}

	@Column(name = "MEMO", length = 500)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "ORDER_BY", nullable = false, precision = 10, scale = 0)
	public Long getOrderBy() {
		return this.orderBy;
	}

	public void setOrderBy(Long orderBy) {
		this.orderBy = orderBy;
	}

}
