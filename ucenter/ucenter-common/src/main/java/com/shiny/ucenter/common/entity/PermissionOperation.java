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
@TableName("permission_operation")
public class PermissionOperation extends Model<PermissionOperation> {

    private static final long serialVersionUID = 1L;

    @TableId("permission_id")
	private String permissionId;
	@TableField("operation_id")
	private String operationId;


	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	@Override
	protected Serializable pkVal() {
		return this.permissionId;
	}

	@Override
	public String toString() {
		return "PermissionOperation{" +
			"permissionId=" + permissionId +
			", operationId=" + operationId +
			"}";
	}
}
