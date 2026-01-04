package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class BakCreate extends C11707b {

    @InterfaceC4648p
    private String backupDeviceId;

    @InterfaceC4648p
    private String backupVersion;

    @InterfaceC4648p
    private int bmDataType;

    @InterfaceC4648p
    private Integer expireInDay;

    @InterfaceC4648p
    private Integer frequency;

    @InterfaceC4648p
    private Integer incType;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private C4644l startTime;

    public String getBackupDeviceId() {
        return this.backupDeviceId;
    }

    public String getBackupVersion() {
        return this.backupVersion;
    }

    public Integer getFrequency() {
        return this.frequency;
    }

    public Integer getIncType() {
        return this.incType;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public C4644l getStartTime() {
        return this.startTime;
    }

    public BakCreate setBackupDeviceId(String str) {
        this.backupDeviceId = str;
        return this;
    }

    public BakCreate setBackupVersion(String str) {
        this.backupVersion = str;
        return this;
    }

    public BakCreate setBmDataType(int i10) {
        this.bmDataType = i10;
        return this;
    }

    public BakCreate setExpireInDay(Integer num) {
        if (num == null) {
            return this;
        }
        this.expireInDay = num;
        return this;
    }

    public BakCreate setFrequency(Integer num) {
        this.frequency = num;
        return this;
    }

    public BakCreate setIncType(Integer num) {
        this.incType = num;
        return this;
    }

    public BakCreate setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public BakCreate setStartTime(C4644l c4644l) {
        this.startTime = c4644l;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public BakCreate set(String str, Object obj) {
        return (BakCreate) super.set(str, obj);
    }
}
