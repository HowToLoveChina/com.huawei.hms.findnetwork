package com.huawei.android.hicloud.agd.ads;

import com.huawei.openalliance.p169ad.constant.SystemProperties;
import p015ak.C0209d;
import p015ak.C0219i;
import p015ak.C0224k0;

/* loaded from: classes2.dex */
public class DeviceInfo {
    private static final int ANDROID_AND_HARMONY_OS = 3;
    private static final int ANDROID_OS = 1;
    private static final int HARMONY_OS = 2;
    private Integer deviceType;
    private String oaid;
    private String vudid;
    private Integer androidApiLevel = Integer.valueOf(C0209d.m1312u0());
    private Integer emuiApiLevel = Integer.valueOf(C0219i.m1463a());
    private String emuiVersion = C0209d.m1315v();
    private Integer gmsSupport = 0;
    private Integer harmonyApiLevel = Integer.valueOf(C0224k0.a.m1575d(SystemProperties.HW_SC_BUILD_OS_API_VERSION, 0));

    /* renamed from: os */
    private Integer f11500os = getOsType();
    private String osv = C0209d.m1316v0();

    private Integer getOsType() {
        if (this.androidApiLevel.intValue() != 0 && this.harmonyApiLevel.intValue() == 0) {
            return 1;
        }
        if (this.androidApiLevel.intValue() != 0 || this.harmonyApiLevel.intValue() == 0) {
            return this.androidApiLevel.intValue() != 0 ? 3 : 0;
        }
        return 2;
    }

    public Integer getAndroidApiLevel() {
        return this.androidApiLevel;
    }

    public Integer getDeviceType() {
        return this.deviceType;
    }

    public Integer getEmuiApiLevel() {
        return this.emuiApiLevel;
    }

    public String getEmuiVersion() {
        return this.emuiVersion;
    }

    public Integer getGmsSupport() {
        return this.gmsSupport;
    }

    public Integer getHarmonyApiLevel() {
        return this.harmonyApiLevel;
    }

    public String getOaid() {
        return this.oaid;
    }

    public Integer getOs() {
        return this.f11500os;
    }

    public String getOsv() {
        return this.osv;
    }

    public String getVudid() {
        return this.vudid;
    }

    public void setAndroidApiLevel(Integer num) {
        this.androidApiLevel = num;
    }

    public void setDeviceType(Integer num) {
        this.deviceType = num;
    }

    public void setEmuiApiLevel(Integer num) {
        this.emuiApiLevel = num;
    }

    public void setEmuiVersion(String str) {
        this.emuiVersion = str;
    }

    public void setGmsSupport(Integer num) {
        this.gmsSupport = num;
    }

    public void setHarmonyApiLevel(Integer num) {
        this.harmonyApiLevel = num;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public void setOs(Integer num) {
        this.f11500os = num;
    }

    public void setOsv(String str) {
        this.osv = str;
    }

    public void setVudid(String str) {
        this.vudid = str;
    }
}
