package com.divijgupta.bolkarassignment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("t")
    @Expose
    private String t;
    @SerializedName("cat")
    @Expose
    private String cat;
    @SerializedName("d")
    @Expose
    private String d;
    @SerializedName("p")
    @Expose
    private String p;
    @SerializedName("pF")
    @Expose
    private String pF;
    @SerializedName("pFBig")
    @Expose
    private String pFBig;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("c")
    @Expose
    private String c;

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getPF() {
        return pF;
    }

    public void setPF(String pF) {
        this.pF = pF;
    }

    public String getPFBig() {
        return pFBig;
    }

    public void setPFBig(String pFBig) {
        this.pFBig = pFBig;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

}
