package com.san.graduation.common;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by huangdongliang on 16/12/5.
 */
@MappedSuperclass
public class BaseEntity extends BaseBean {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long id;
   
    @CreatedDate
    @Column(name="CREATED_AT")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    protected Date createdAt;

    @LastModifiedDate
    @Column(name="UPDATED_AT")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    protected Date updatedAt;

    @CreatedBy
    @Column(name="CREATED_BY", length = 60)
    protected String createdBy;

    @LastModifiedBy
    @Column(name="UPDATED_BY", length = 60)
    protected String updatedBy;

    @Column(name="IS_DELETE")
    protected Boolean isDelete=false;

    //用于做乐观锁
    @Column(name="VERSION")
    @Version
    protected Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

   
}
