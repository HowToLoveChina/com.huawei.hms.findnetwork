package com.huawei.hicloud.request.cbs.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class CBSDevCalllogSmsCount {
    private List<CBSDevCount> countRet;
    private String info;
    private List<CBSDevice> notQuaryDeviceList;
    private int result;

    public List<CBSDevCount> getCountRet() {
        return this.countRet;
    }

    public String getInfo() {
        return this.info;
    }

    public List<CBSDevice> getNotQuaryDeviceList() {
        return this.notQuaryDeviceList;
    }

    public int getResult() {
        return this.result;
    }

    public void setCountRet(List<CBSDevCount> list) {
        this.countRet = list;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setNotQuaryDeviceList(List<CBSDevice> list) {
        this.notQuaryDeviceList = list;
    }

    public void setResult(int i10) {
        this.result = i10;
    }
}
