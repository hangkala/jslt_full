/**
 * Copyright(C) 2019 Luvina JSC
 * UserBean.java, Sep 30, 2019, HangHT
 */
package model;

/**
 * @author HangHT
 *
 */
public class UserBean {
	private int id;
	private String name, birthday, birthplace;

	/**
	 * 
	 */
	public UserBean() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the birthplace
	 */
	public String getBirthplace() {
		return birthplace;
	}

	/**
	 * @param birthplace the birthplace to set
	 */
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

}
