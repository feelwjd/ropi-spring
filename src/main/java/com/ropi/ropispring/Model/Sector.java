package com.ropi.ropispring.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sector {
	private String sectorcode;
	private String kosectorname;
	private String ensectorname;
	private String cnsectorname;
	
	public String getSectorcode() {
		return sectorcode;
	}
	public void setSectorcode(String sectorcode) {
		this.sectorcode = sectorcode;
	}
	public String getKosectorname() {
		return kosectorname;
	}
	public void setKosectorname(String kosectorname) {
		this.kosectorname = kosectorname;
	}
	public String getEnsectorname() {
		return ensectorname;
	}
	public void setEnsectorname(String ensectorname) {
		this.ensectorname = ensectorname;
	}
	public String getCnsectorname() {
		return cnsectorname;
	}
	public void setCnsectorname(String cnsectorname) {
		this.cnsectorname = cnsectorname;
	}
	
	@Override
	public String toString() {
		return "Sector [sectorcode=" + sectorcode + ", kosectorname=" + kosectorname + ", ensectorname=" + ensectorname
				+ ", cnsectorname=" + cnsectorname + "]";
	}
	
	
}
