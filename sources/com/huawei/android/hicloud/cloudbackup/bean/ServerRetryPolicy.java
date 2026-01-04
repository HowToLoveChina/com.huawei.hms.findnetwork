package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ServerRetryPolicy {
    private String requestCmd = "";
    private List<Integer> retryErrorCodes = new ArrayList();
    private Integer retryInterval = 0;
    private Integer retryTimes = 0;

    public String getRequestCmd() {
        String str = this.requestCmd;
        return str == null ? "" : str;
    }

    public List<Integer> getRetryErrorCodes() {
        List<Integer> list = this.retryErrorCodes;
        return list == null ? new ArrayList() : list;
    }

    public Integer getRetryInterval() {
        Integer num = this.retryInterval;
        return Integer.valueOf(num != null ? Math.max(0, num.intValue()) : 0);
    }

    public Integer getRetryTimes() {
        Integer num = this.retryTimes;
        return Integer.valueOf(num != null ? Math.max(0, num.intValue()) : 0);
    }

    public void setRequestCmd(String str) {
        this.requestCmd = str;
    }

    public void setRetryErrorCodes(List<Integer> list) {
        this.retryErrorCodes = list;
    }

    public void setRetryInterval(Integer num) {
        this.retryInterval = num;
    }

    public void setRetryTimes(Integer num) {
        this.retryTimes = num;
    }

    public String toString() {
        return "ServerRetryPolicy{requestCmd='" + this.requestCmd + "', retryErrorCodes=" + this.retryErrorCodes + ", retryInterval=" + this.retryInterval + ", retryTimes=" + this.retryTimes + '}';
    }
}
