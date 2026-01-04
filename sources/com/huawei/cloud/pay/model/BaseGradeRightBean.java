package com.huawei.cloud.pay.model;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class BaseGradeRightBean implements Serializable {
    protected static final long serialVersionUID = 1;
    protected long newEndTime;
    protected List<GradePicture> pictures;
    protected Map propInsts;
    protected String rightCode;
    protected String rightName;
    protected String rightShortDesc;
    protected int status;

    public long getNewEndTime() {
        return this.newEndTime;
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

    public void setNewEndTime(long j10) {
        this.newEndTime = j10;
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

    public void setStatus(int i10) {
        this.status = i10;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
