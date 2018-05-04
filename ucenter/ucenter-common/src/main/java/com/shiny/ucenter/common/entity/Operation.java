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
public class Operation extends Model<Operation> {

    private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String code;
	@TableField("url_prefix")
	private String urlPrefix;


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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrlPrefix() {
		return urlPrefix;
	}

	public void setUrlPrefix(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Operation{" +
			"id=" + id +
			", name=" + name +
			", code=" + code +
			", urlPrefix=" + urlPrefix +
			"}";
	}
}
