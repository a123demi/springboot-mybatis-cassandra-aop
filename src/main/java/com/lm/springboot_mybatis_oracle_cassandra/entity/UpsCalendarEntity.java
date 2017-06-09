package com.lm.springboot_mybatis_oracle_cassandra.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * UpsCalendra实体
 * @author liangming.deng
 * @date   2017年6月9日
 *
 */
public class UpsCalendarEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

    private String name;

    private String description;

    private Long org_id;

    private String is_active;

    private Date created;

    private String createdby;

    private Date updated;

    private String updatedby;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getOrg_id() {
		return org_id;
	}

	public void setOrg_id(Long org_id) {
		this.org_id = org_id;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	@Override
	public String toString() {
		return "UpsCalendarEntity [id=" + id + ", name=" + name + ", description=" + description + ", org_id=" + org_id
				+ ", is_active=" + is_active + ", created=" + created + ", createdby=" + createdby + ", updated="
				+ updated + ", updatedby=" + updatedby + "]";
	}
    
}
