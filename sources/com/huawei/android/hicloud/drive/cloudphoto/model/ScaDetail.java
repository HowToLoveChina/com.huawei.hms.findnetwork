package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class ScaDetail extends C11707b {

    @InterfaceC4648p
    private Map<String, Object> scaAttributes;

    @InterfaceC4648p
    private Integer scaRank;

    @InterfaceC4648p
    private Integer scaState;

    @InterfaceC4648p
    private String usage;

    public Map<String, Object> getScaAttributes() {
        return this.scaAttributes;
    }

    public Integer getScaRank() {
        return this.scaRank;
    }

    public Integer getScaState() {
        return this.scaState;
    }

    public String getUsage() {
        return this.usage;
    }

    public void setScaAttributes(Map<String, Object> map) {
        this.scaAttributes = map;
    }

    public void setScaRank(Integer num) {
        this.scaRank = num;
    }

    public void setScaState(Integer num) {
        this.scaState = num;
    }

    public void setUsage(String str) {
        this.usage = str;
    }
}
