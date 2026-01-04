package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class DeviceConditionReport extends C11707b {

    @InterfaceC4648p
    private String gradeCode;

    @InterfaceC4648p
    private String timeWindow;

    @InterfaceC4648p
    private List<Map<String, String>> transBandwidths;

    public String getGradeCode() {
        return this.gradeCode;
    }

    public String getTimeWindow() {
        return this.timeWindow;
    }

    public List<Map<String, String>> getTransBandwidths() {
        return this.transBandwidths;
    }

    public DeviceConditionReport setGradeCode(String str) {
        this.gradeCode = str;
        return this;
    }

    public DeviceConditionReport setTimeWindow(String str) {
        this.timeWindow = str;
        return this;
    }

    public DeviceConditionReport setTransBandwidths(List<Map<String, String>> list) {
        this.transBandwidths = list;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public DeviceConditionReport set(String str, Object obj) {
        return (DeviceConditionReport) super.set(str, obj);
    }
}
