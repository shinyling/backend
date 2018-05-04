package com.shiny.ucenter.common.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author shiny
 * @since 2018-05-02
 */
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	@TableField("en_code")
	private String enCode;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnCode() {
		return enCode;
	}

	public void setEnCode(String enCode) {
		this.enCode = enCode;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Role{" +
			"id=" + id +
			", name=" + name +
			", enCode=" + enCode +
			"}";
	}
}
