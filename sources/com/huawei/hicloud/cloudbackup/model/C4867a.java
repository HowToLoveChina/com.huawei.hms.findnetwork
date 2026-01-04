package com.huawei.hicloud.cloudbackup.model;

import android.text.TextUtils;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.router.data.UserBackupInfo;
import java.util.Objects;
import mk.C11477c;
import ni.C11707b;

/* renamed from: com.huawei.hicloud.cloudbackup.model.a */
/* loaded from: classes6.dex */
public class C4867a extends C11707b {

    /* renamed from: b */
    @InterfaceC4648p
    public int f22256b;

    /* renamed from: c */
    @InterfaceC4648p
    public String f22257c;

    /* renamed from: d */
    @InterfaceC4648p
    public String f22258d;

    /* renamed from: e */
    @InterfaceC4648p
    public long f22259e;

    /* renamed from: f */
    @InterfaceC4648p
    public long f22260f;

    /* renamed from: g */
    @InterfaceC4648p
    public boolean f22261g;

    /* renamed from: h */
    @InterfaceC4648p
    public int f22262h;

    /* renamed from: i */
    @InterfaceC4648p
    public String f22263i;

    /* renamed from: j */
    @InterfaceC4648p
    public String f22264j;

    /* renamed from: k */
    @InterfaceC4648p
    public String f22265k;

    /* renamed from: l */
    @InterfaceC4648p
    public boolean f22266l;

    /* renamed from: m */
    @InterfaceC4648p
    public boolean f22267m;

    /* renamed from: n */
    public UserBackupInfo.UserDeviceInfo f22268n;

    public C4867a(int i10) {
        this.f22257c = "";
        this.f22258d = "";
        this.f22259e = 0L;
        this.f22260f = 0L;
        this.f22261g = false;
        this.f22262h = 0;
        this.f22263i = "";
        this.f22264j = "phone";
        this.f22265k = "";
        this.f22266l = false;
        this.f22267m = false;
        this.f22256b = i10;
    }

    /* renamed from: b */
    public final String m29218b(String str) {
        String strM68633c = C11477c.m68633c(str);
        return TextUtils.isEmpty(strM68633c) ? str : strM68633c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C4867a c4867a = (C4867a) obj;
        return TextUtils.equals(this.f22258d, c4867a.f22258d) && TextUtils.equals(this.f22265k, c4867a.f22265k) && this.f22261g == c4867a.f22261g;
    }

    /* renamed from: f */
    public long m29219f() {
        return this.f22259e;
    }

    public String getBackupDeviceId() {
        return this.f22265k;
    }

    public String getDeviceCategory() {
        return this.f22264j;
    }

    public String getDeviceId() {
        return this.f22258d;
    }

    public String getDeviceName() {
        return this.f22257c;
    }

    public int getDeviceType() {
        return this.f22262h;
    }

    public String getTerminalType() {
        return this.f22263i;
    }

    public int getType() {
        return this.f22256b;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.f22257c, this.f22258d, Long.valueOf(this.f22259e), Long.valueOf(this.f22260f), Boolean.valueOf(this.f22261g), Integer.valueOf(this.f22262h), this.f22264j, this.f22265k);
    }

    public boolean isCurrent() {
        return this.f22261g;
    }

    public boolean isOnlyHarmonyNext() {
        return this.f22267m;
    }

    public boolean isOnlyRefurbish() {
        return this.f22266l;
    }

    /* renamed from: k */
    public long m29220k() {
        return this.f22260f;
    }

    /* renamed from: p */
    public UserBackupInfo.UserDeviceInfo m29221p() {
        return this.f22268n;
    }

    public void setDeviceName(String str) {
        this.f22257c = str;
    }

    public C4867a(UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        this.f22256b = 1;
        this.f22257c = "";
        this.f22258d = "";
        this.f22259e = 0L;
        this.f22260f = 0L;
        this.f22261g = false;
        this.f22262h = 0;
        this.f22263i = "";
        this.f22264j = "phone";
        this.f22265k = "";
        this.f22266l = false;
        this.f22267m = false;
        this.f22268n = userDeviceInfo;
        this.f22257c = m29218b(userDeviceInfo.getDeviceName());
        this.f22258d = m29218b(userDeviceInfo.getDeviceID());
        this.f22259e = userDeviceInfo.getSize();
        this.f22260f = userDeviceInfo.getLastbackupTime();
        this.f22261g = userDeviceInfo.isCurrent();
        this.f22262h = userDeviceInfo.getDeviceType();
        this.f22263i = userDeviceInfo.getTerminalType();
        this.f22264j = userDeviceInfo.getDeviceCategory();
        this.f22265k = userDeviceInfo.getBackupDeviceId();
        this.f22266l = userDeviceInfo.isOnlyRefurbish();
        this.f22267m = userDeviceInfo.isOnlyHarmonyNext();
    }
}
