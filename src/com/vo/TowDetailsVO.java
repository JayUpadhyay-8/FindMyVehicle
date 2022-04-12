package com.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tow_detail_tbl")
public class TowDetailsVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="img_id")
	private ImageupVO imageupvo;
	
	@ManyToOne
	@JoinColumn(name="rto_id")
	private RtoVO rtoVO;
	
	@Column
	private String date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ImageupVO getImageupvo() {
		return imageupvo;
	}

	public void setImageupvo(ImageupVO imageupvo) {
		this.imageupvo = imageupvo;
	}

	public RtoVO getRtoVO() {
		return rtoVO;
	}

	public void setRtoVO(RtoVO rtoVO) {
		this.rtoVO = rtoVO;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
	

}
