package com.huawei.hicloud.request.cbs.bean;

import com.google.gson.Gson;
import java.util.List;

/* loaded from: classes6.dex */
public class CBSFullBackup {
    List<String> clientActions;
    String info;
    String lockId;
    Integer lockInterval;
    int result;

    public List<String> getClientActions() {
        return this.clientActions;
    }

    public String getInfo() {
        return this.info;
    }

    public String getLockId() {
        return this.lockId;
    }

    public Integer getLockInterval() {
        return this.lockInterval;
    }

    public int getResult() {
        return this.result;
    }

    public void setClientActions(List<String> list) {
        this.clientActions = list;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setLockId(String str) {
        this.lockId = str;
    }

    public void setLockInterval(Integer num) {
        this.lockInterval = num;
    }

    public void setResult(int i10) {
        this.result = i10;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
