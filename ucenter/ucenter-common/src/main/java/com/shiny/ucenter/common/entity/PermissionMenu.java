package com.shiny.ucenter.common.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author shiny
 * @since 2018-05-02
 */
@TableName("permission_menu")
public class PermissionMenu extends Model<PermissionMenu> {

    private static final long serialVersionUID = 1L;

    @TableId("permission_id")
	private String permissionId;
	@TableField("menu_id")
	private String menuId;


	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	@Override
	protected Serializable pkVal() {
		return this.permissionId;
	}

	@Override
	public String toString() {
		return "PermissionMenu{" +
			"permissionId=" + permissionId +
			", menuId=" + menuId +
			"}";
	}
}
