package com.ropi.ropispring.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Industry {
	private String industrycode;
	private String koindustryshname;
	private String koindustryname;
	private String enindustryshname;
	private String enindustryname;
	private String cnindustryname;
	private String jpcnindustryname;
	public String getIndustrycode() {
		return industrycode;
	}
	public void setIndustrycode(String industrycode) {
		this.industrycode = industrycode;
	}
	public String getKoindustryshname() {
		return koindustryshname;
	}
	public void setKoindustryshname(String koindustryshname) {
		this.koindustryshname = koindustryshname;
	}
	public String getKoindustryname() {
		return koindustryname;
	}
	public void setKoindustryname(String koindustryname) {
		this.koindustryname = koindustryname;
	}
	public String getEnindustryshname() {
		return enindustryshname;
	}
	public void setEnindustryshname(String enindustryshname) {
		this.enindustryshname = enindustryshname;
	}
	public String getEnindustryname() {
		return enindustryname;
	}
	public void setEnindustryname(String enindustryname) {
		this.enindustryname = enindustryname;
	}
	public String getCnindustryname() {
		return cnindustryname;
	}
	public void setCnindustryname(String cnindustryname) {
		this.cnindustryname = cnindustryname;
	}
	public String getJpcnindustryname() {
		return jpcnindustryname;
	}
	public void setJpcnindustryname(String jpcnindustryname) {
		this.jpcnindustryname = jpcnindustryname;
	}
	@Override
	public String toString() {
		return "Industry [industrycode=" + industrycode + ", koindustryshname=" + koindustryshname + ", koindustryname="
				+ koindustryname + ", enindustryshname=" + enindustryshname + ", enindustryname=" + enindustryname
				+ ", cnindustryname=" + cnindustryname + ", jpcnindustryname=" + jpcnindustryname + "]";
	}
	
	
}
