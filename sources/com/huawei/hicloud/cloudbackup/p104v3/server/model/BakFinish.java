package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class BakFinish extends C11707b {

    @InterfaceC4648p
    private String backupVersion;

    @InterfaceC4648p
    private Integer bmDataType;

    @InterfaceC4648p
    private C4644l endTime;

    @InterfaceC4648p
    private Integer incType;

    @InterfaceC4648p
    private Map<String, String> properties;

    public String getBackupVersion() {
        return this.backupVersion;
    }

    public Integer getBmDataType() {
        return this.bmDataType;
    }

    public C4644l getEndTime() {
        return this.endTime;
    }

    public Integer getIncType() {
        return this.incType;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public BakFinish setBackupVersion(String str) {
        this.backupVersion = str;
        return this;
    }

    public void setBmDataType(Integer num) {
        this.bmDataType = num;
    }

    public BakFinish setEndTime(C4644l c4644l) {
        this.endTime = c4644l;
        return this;
    }

    public BakFinish setIncType(Integer num) {
        this.incType = num;
        return this;
    }

    public BakFinish setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public BakFinish set(String str, Object obj) {
        return (BakFinish) super.set(str, obj);
    }
}
