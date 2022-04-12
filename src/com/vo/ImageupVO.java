package com.vo;

import javax.persistence.*;

@Entity
@Table(name = "img_tbl")
public class ImageupVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "filename")
	private String filename;

	@Column(name = "filepath")
	private String filepath;

	@ManyToOne
	@JoinColumn(name = "Location_Id")
	private LocationVO locationVO;

/*	@ManyToOne
	@JoinColumn(name = "Area_Id")
	private AreaVO areaVO;

	public AreaVO getAreaVO() {
		return areaVO;
	}

	public void setAreaVO(AreaVO areaVO) {
		this.areaVO = areaVO;
	}
*/
	@Column(name = "ocrResult")
	private String ocrResult;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public LocationVO getLocationVO() {
		return locationVO;
	}

	public void setLocationVO(LocationVO locationVO) {
		this.locationVO = locationVO;
	}

	
	

	public String getOcrResult() {
		return ocrResult;
	}

	public void setOcrResult(String ocrResult) {
		this.ocrResult = ocrResult;
	}

	
}
