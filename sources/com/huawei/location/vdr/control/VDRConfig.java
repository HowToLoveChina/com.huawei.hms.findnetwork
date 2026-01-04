package com.huawei.location.vdr.control;

import as.C1016d;
import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.config.ConfigBaseResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p588qr.C12390b;

/* loaded from: classes8.dex */
public final class VDRConfig {

    /* renamed from: a */
    public ConfigEntity f31426a = null;

    public static class ConfigEntity extends ConfigBaseResponse {

        @SerializedName("VDR_SWITCH")
        private boolean vdrSwitch = false;

        @SerializedName("MIN_SPEED")
        private int minSpeed = 3;

        @SerializedName("PACKAGE_LIST")
        private List<String> packageList = new ArrayList();

        @SerializedName("DEVICE_LIST")
        private List<String> deviceList = new ArrayList();

        private ConfigEntity() {
        }

        public String toString() {
            return "ConfigEntity{vdrSwitch=" + this.vdrSwitch + ", PACKAGE_LIST=" + this.packageList.toString() + '}';
        }
    }

    /* renamed from: a */
    public final void m38533a() {
        C1016d.m6186f("VDRConfig", "init vdr config");
        this.f31426a = (ConfigEntity) C12390b.m74456g().m74460d("vdr", ConfigEntity.class);
    }

    /* renamed from: b */
    public final boolean m38534b() {
        if (this.f31426a == null) {
            m38533a();
            StringBuilder sb2 = new StringBuilder("get config failed, configEntity is Empty, get again not null:");
            sb2.append(this.f31426a != null);
            C1016d.m6190j("VDRConfig", sb2.toString());
        }
        return this.f31426a != null;
    }

    /* renamed from: c */
    public final boolean m38535c(int i10) {
        C1016d.m6186f("VDRConfig", "checkSpeed :" + i10);
        return i10 > this.f31426a.minSpeed;
    }

    /* renamed from: d */
    public final boolean m38536d(String str) {
        Iterator it = this.f31426a.packageList.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(str)) {
                return true;
            }
        }
        C1016d.m6190j("VDRConfig", "checkPackage not support:" + str);
        return false;
    }

    /* renamed from: e */
    public final boolean m38537e(String str, String str2) {
        String str3 = str + "_" + str2;
        Iterator it = this.f31426a.deviceList.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(str3)) {
                return true;
            }
        }
        C1016d.m6190j("VDRConfig", "checkDevice not support :" + str3);
        return false;
    }
}
