package com.vo;

import javax.persistence.*;

@Entity
@Table(name="area_tbl")
public class AreaVO {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

@Column(name="AreaName")
private String areaName;

@Column(name="AreaDescription")
private String areaDescription;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getAreaName() {
	return areaName;
}

public void setAreaName(String areaName) {
	this.areaName = areaName;
}

public String getAreaDescription() {
	return areaDescription;
}

public void setAreaDescription(String areaDescription) {
	this.areaDescription = areaDescription;
}




}
