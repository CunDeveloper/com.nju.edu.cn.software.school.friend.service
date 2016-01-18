package com.nju.edu.cn.software.domain;

import java.util.Date;
import java.util.UUID;

import org.springframework.util.Assert;
 
public abstract class BaseEntity {

	private int version;
	private String id;
	private Date timeCreated;
	
	public BaseEntity(){
		this(UUID.randomUUID());
	}
	
	public BaseEntity(UUID uuid){
		Assert.notNull(uuid,"UUID is required");
		id = uuid.toString();
		this.timeCreated = new Date();
	}
	
	public String getId(){
		return id;
	}
	
	public int hashCode(){
		return getId().hashCode();
	}
	
	@Override
	public boolean equals(Object o){
		if(this == o) return true;
		if(o==null || getClass() != o.getClass()) return false;
		
		BaseEntity that = (BaseEntity) o;
		
		if(!id.equals(that.id)) return false;
		
		return true;
	}
	
	public int getVersion(){
		return version;
	}
	
	public Date getTimeCreated(){
		return timeCreated;
	}
}
