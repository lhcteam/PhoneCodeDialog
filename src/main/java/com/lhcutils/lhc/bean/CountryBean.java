package com.lhcutils.lhc.bean;

/**
 * Created by debug on 2017/8/10.
 */

public class CountryBean {
    /**
     * country_id : 100006
     * country_code : +244
     * country_name_en : Angola
     * country_name_cn : 安哥拉
     * ab : AO
     */

    private int country_id;
    private String country_code;
    private String country_name_en;
    private String country_name_cn;
    private String country_name_ft;

    public String getCountry_name_ft() {
        return country_name_ft;
    }

    public void setCountry_name_ft(String country_name_ft) {
        this.country_name_ft = country_name_ft;
    }

    private String ab;

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry_name_en() {
        return country_name_en;
    }

    public void setCountry_name_en(String country_name_en) {
        this.country_name_en = country_name_en;
    }

    public String getCountry_name_cn() {
        return country_name_cn;
    }

    public void setCountry_name_cn(String country_name_cn) {
        this.country_name_cn = country_name_cn;
    }

    public String getAb() {
        return ab;
    }

    public void setAb(String ab) {
        this.ab = ab;
    }
}
