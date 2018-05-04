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
@TableName("user_group_role")
public class UserGroupRole extends Model<UserGroupRole> {

    private static final long serialVersionUID = 1L;

    @TableId("group_id")
	private String groupId;
	@TableField("role_id")
	private String roleId;


	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	protected Serializable pkVal() {
		return this.groupId;
	}

	@Override
	public String toString() {
		return "UserGroupRole{" +
			"groupId=" + groupId +
			", roleId=" + roleId +
			"}";
	}
}
