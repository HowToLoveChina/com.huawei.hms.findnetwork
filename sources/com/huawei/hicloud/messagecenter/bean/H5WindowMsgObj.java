package com.huawei.hicloud.messagecenter.bean;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes6.dex */
public class H5WindowMsgObj extends BaseMsgObj {
    private int h5DialogAction;
    private String h5DialogUrl;
    private List<String> param;
    private int priority;
    private List<String> realTimeParam;
    private int supportTrigger;
    private String trigger;

    public int getH5DialogAction() {
        return this.h5DialogAction;
    }

    public String getH5DialogUrl() {
        return this.h5DialogUrl;
    }

    @Override // com.huawei.hicloud.messagecenter.bean.BaseMsgObj
    public long getNotifyTime() {
        return this.notifyTime;
    }

    public List<String> getParam() {
        return this.param;
    }

    public String getParamForString() {
        List<String> list = this.param;
        if (list == null || list.size() <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str : this.param) {
            sb2.append(str);
            if (this.param.indexOf(str) != this.param.size() - 1) {
                sb2.append(",");
            }
        }
        return sb2.toString();
    }

    @Override // com.huawei.hicloud.messagecenter.bean.BaseMsgObj
    public int getPriority() {
        return this.priority;
    }

    public List<String> getRealTimeParam() {
        return this.realTimeParam;
    }

    public String getRealTimeParamForString() {
        List<String> list = this.realTimeParam;
        if (list == null || list.size() <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str : this.realTimeParam) {
            sb2.append(str);
            if (this.realTimeParam.indexOf(str) != this.realTimeParam.size() - 1) {
                sb2.append(",");
            }
        }
        return sb2.toString();
    }

    public int getSupportTrigger() {
        return this.supportTrigger;
    }

    public String getTrigger() {
        return this.trigger;
    }

    public void setH5DialogAction(int i10) {
        this.h5DialogAction = i10;
    }

    public void setH5DialogUrl(String str) {
        this.h5DialogUrl = str;
    }

    @Override // com.huawei.hicloud.messagecenter.bean.BaseMsgObj
    public void setNotifyTime(long j10) {
        this.notifyTime = j10;
    }

    public void setParam(List<String> list) {
        this.param = list;
    }

    public void setParamByString(String str) {
        if (TextUtils.isEmpty(str)) {
            this.param = new ArrayList();
        } else {
            this.param = new ArrayList(Arrays.asList(str.split(",")));
        }
    }

    @Override // com.huawei.hicloud.messagecenter.bean.BaseMsgObj
    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setRealTimeParam(List<String> list) {
        this.realTimeParam = list;
    }

    public void setRealTimeParamByString(String str) {
        if (TextUtils.isEmpty(str)) {
            this.realTimeParam = new ArrayList();
        } else {
            this.realTimeParam = new ArrayList(Arrays.asList(str.split(",")));
        }
    }

    public void setSupportTrigger(int i10) {
        this.supportTrigger = i10;
    }

    public void setTrigger(String str) {
        this.trigger = str;
    }
}
