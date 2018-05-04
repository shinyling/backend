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
@TableName("permission_file")
public class PermissionFile extends Model<PermissionFile> {

    private static final long serialVersionUID = 1L;

    @TableId("permission_id")
	private String permissionId;
	@TableField("file_id")
	private String fileId;


	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	@Override
	protected Serializable pkVal() {
		return this.permissionId;
	}

	@Override
	public String toString() {
		return "PermissionFile{" +
			"permissionId=" + permissionId +
			", fileId=" + fileId +
			"}";
	}
}
