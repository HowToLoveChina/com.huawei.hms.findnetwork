package com.huawei.cloud.pay.model;

import com.google.gson.Gson;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class MemGradeRightDetail {
    private String gotoURI;
    private Map i18ResourceMap;
    private boolean isSelected;
    private List<GradePicture> pictures;
    private Map propInsts;
    private String rightCode;
    private String rightName;
    private String rightShortDesc;
    private int status;

    public String getGotoURI() {
        return this.gotoURI;
    }

    public Map getI18ResourceMap() {
        return this.i18ResourceMap;
    }

    public List<GradePicture> getPictures() {
        return this.pictures;
    }

    public Map getPropInsts() {
        return this.propInsts;
    }

    public String getRightCode() {
        return this.rightCode;
    }

    public String getRightName() {
        return this.rightName;
    }

    public String getRightShortDesc() {
        return this.rightShortDesc;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setGotoURI(String str) {
        this.gotoURI = str;
    }

    public void setI18ResourceMap(Map map) {
        this.i18ResourceMap = map;
    }

    public void setPictures(List<GradePicture> list) {
        this.pictures = list;
    }

    public void setPropInsts(Map map) {
        this.propInsts = map;
    }

    public void setRightCode(String str) {
        this.rightCode = str;
    }

    public void setRightName(String str) {
        this.rightName = str;
    }

    public void setRightShortDesc(String str) {
        this.rightShortDesc = str;
    }

    public void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
