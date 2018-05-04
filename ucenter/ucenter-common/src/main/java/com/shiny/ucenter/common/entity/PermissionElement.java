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
@TableName("permission_element")
public class PermissionElement extends Model<PermissionElement> {

    private static final long serialVersionUID = 1L;

    @TableId("permission_id")
	private String permissionId;
	@TableField("element_id")
	private String elementId;


	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	@Override
	protected Serializable pkVal() {
		return this.permissionId;
	}

	@Override
	public String toString() {
		return "PermissionElement{" +
			"permissionId=" + permissionId +
			", elementId=" + elementId +
			"}";
	}
}
