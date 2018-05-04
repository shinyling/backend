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
@TableName("user_role")
public class UserRole extends Model<UserRole> {

    private static final long serialVersionUID = 1L;

    @TableId("user_id")
	private String userId;
	@TableField("role_id")
	private String roleId;


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	protected Serializable pkVal() {
		return this.userId;
	}

	@Override
	public String toString() {
		return "UserRole{" +
			"userId=" + userId +
			", roleId=" + roleId +
			"}";
	}
}
