package com.laptrinhjavaweb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rentarea")
public class RentAreaEntity extends BaseEntity {
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="buildingid", nullable=false)
	private BuildingEntity building;
	
	@Column(name="value")
	private Integer value;
	
	public BuildingEntity getBuilding() {
		return building;
	}

	public void setBuilding(BuildingEntity building) {
		this.building = building;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	
}
