package com.sshop.core.model;

import java.util.Date;

import com.sshop.core.base.BaseModel;

@SuppressWarnings("serial")
public class User extends BaseModel {
	
	private Integer id;
    //用户名
    private String lastname;
    private String firstname;
    //密码
    private String password;
    //手机号
    private String mobile;
    //邮箱
    private String email;
    //性别
    private String sex;
    //身份证号码
    private String personalid;
    //籍贯
    private String nativeplace;
    //工作状态
    private String state;
    //教育背景
    private String education;
    //头像
    private Integer headerimageid;
    //用户状态 ：0- 在用  1-删除
    private Integer status;
    //创建时间
    private Date createtime;
    //更新时间
    private Date updatetime;
    //lastLoginTime
    private Date lastlogintime;
    //头像
    private Images header;
    //用户说明
    private String usernote;
    //用户生日
    private Date birthday;
    //感情状态
    private String emotion;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPersonalid() {
		return personalid;
	}
	public void setPersonalid(String personalid) {
		this.personalid = personalid;
	}
	public String getNativeplace() {
		return nativeplace;
	}
	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Integer getHeaderimageid() {
		return headerimageid;
	}
	public void setHeaderimageid(Integer headerimageid) {
		this.headerimageid = headerimageid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public Date getLastlogintime() {
		return lastlogintime;
	}
	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
	public Images getHeader() {
		return header;
	}
	public void setHeader(Images header) {
		this.header = header;
	}
	public String getUsernote() {
		return usernote;
	}
	public void setUsernote(String usernote) {
		this.usernote = usernote;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmotion() {
		return emotion;
	}
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	
}	
