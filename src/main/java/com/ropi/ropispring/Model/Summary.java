package com.ropi.ropispring.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Summary {
    private String symbol;
    private String sector_code;
    private String industry_code;
    private String ko_name;
    private String en_name;
    private String cn_name;
    private String ko_summary;
    private String en_summary;
    private String cn_summary;
    private String jp_summary;
    private int trad_unit;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSector_code() {
        return sector_code;
    }

    public void setSector_code(String sector_code) {
        this.sector_code = sector_code;
    }

    public String getIndustry_code() {
        return industry_code;
    }

    public void setIndustry_code(String industry_code) {
        this.industry_code = industry_code;
    }

    public String getKo_name() {
        return ko_name;
    }

    public void setKo_name(String ko_name) {
        this.ko_name = ko_name;
    }

    public String getEn_name() {
        return en_name;
    }

    public void setEn_name(String en_name) {
        this.en_name = en_name;
    }

    public String getCn_name() {
        return cn_name;
    }

    public void setCn_name(String cn_name) {
        this.cn_name = cn_name;
    }

    public String getKo_summary() {
        return ko_summary;
    }

    public void setKo_summary(String ko_summary) {
        this.ko_summary = ko_summary;
    }

    public String getEn_summary() {
        return en_summary;
    }

    public void setEn_summary(String en_summary) {
        this.en_summary = en_summary;
    }

    public String getCn_summary() {
        return cn_summary;
    }

    public void setCn_summary(String cn_summary) {
        this.cn_summary = cn_summary;
    }

    public String getJp_summary() {
        return jp_summary;
    }

    public void setJp_summary(String jp_summary) {
        this.jp_summary = jp_summary;
    }

    public int getTrad_unit() {
        return trad_unit;
    }

    public void setTrad_unit(int trad_unit) {
        this.trad_unit = trad_unit;
    }
}
