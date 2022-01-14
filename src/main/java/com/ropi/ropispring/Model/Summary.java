package com.ropi.ropispring.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Summary {
    private String symbol;
    private String countrycode;
    private String sectorcode;
    private String industrycode;
    private String koname;
    private String enname;
    private String cnname;
    private String kosummary;
    private String ensummary;
    private String cnsummary;
    private String jpsummary;
    private int tradunit;
    private String nationcode;
    private String nationkoname;
    private String nationenname;
    private String nationcnname;
    private String nationjpname;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getSectorcode() {
        return sectorcode;
    }

    public void setSectorcode(String sectorcode) {
        this.sectorcode = sectorcode;
    }

    public String getIndustrycode() {
        return industrycode;
    }

    public void setIndustrycode(String industrycode) {
        this.industrycode = industrycode;
    }

    public String getKoname() {
        return koname;
    }

    public void setKoname(String koname) {
        this.koname = koname;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public String getKosummary() {
        return kosummary;
    }

    public void setKosummary(String kosummary) {
        this.kosummary = kosummary;
    }

    public String getEnsummary() {
        return ensummary;
    }

    public void setEnsummary(String ensummary) {
        this.ensummary = ensummary;
    }

    public String getCnsummary() {
        return cnsummary;
    }

    public void setCnsummary(String cnsummary) {
        this.cnsummary = cnsummary;
    }

    public String getJpsummary() {
        return jpsummary;
    }

    public void setJpsummary(String jpsummary) {
        this.jpsummary = jpsummary;
    }

    public int getTradunit() {
        return tradunit;
    }

    public void setTradunit(int tradunit) {
        this.tradunit = tradunit;
    }

    public String getNationcode() {
        return nationcode;
    }

    public void setNationcode(String nationcode) {
        this.nationcode = nationcode;
    }

    public String getNationkoname() {
        return nationkoname;
    }

    public void setNationkoname(String nationkoname) {
        this.nationkoname = nationkoname;
    }

    public String getNationenname() {
        return nationenname;
    }

    public void setNationenname(String nationenname) {
        this.nationenname = nationenname;
    }

    public String getNationcnname() {
        return nationcnname;
    }

    public void setNationcnname(String nationcnname) {
        this.nationcnname = nationcnname;
    }

    public String getNationjpname() {
        return nationjpname;
    }

    public void setNationjpname(String nationjpname) {
        this.nationjpname = nationjpname;
    }
}
