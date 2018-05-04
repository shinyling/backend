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
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private Integer type;
	@TableField("permission_val")
	private String permissionVal;
	private String uri;
	private String icon;


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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPermissionVal() {
		return permissionVal;
	}

	public void setPermissionVal(String permissionVal) {
		this.permissionVal = permissionVal;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Permission{" +
			"id=" + id +
			", name=" + name +
			", type=" + type +
			", permissionVal=" + permissionVal +
			", uri=" + uri +
			", icon=" + icon +
			"}";
	}
}
