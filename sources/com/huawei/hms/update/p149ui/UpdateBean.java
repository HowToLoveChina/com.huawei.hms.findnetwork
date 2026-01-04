package com.huawei.hms.update.p149ui;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class UpdateBean implements Serializable {

    /* renamed from: a */
    private boolean f30137a;

    /* renamed from: b */
    private boolean f30138b;

    /* renamed from: c */
    private String f30139c;

    /* renamed from: d */
    private int f30140d;

    /* renamed from: e */
    private String f30141e;

    /* renamed from: f */
    private String f30142f;

    /* renamed from: g */
    private ArrayList f30143g;

    /* renamed from: h */
    private boolean f30144h = true;

    /* renamed from: a */
    private static <T> T m36999a(T t10) {
        return t10;
    }

    public String getClientAppId() {
        return (String) m36999a(this.f30141e);
    }

    public String getClientAppName() {
        return (String) m36999a(this.f30142f);
    }

    public String getClientPackageName() {
        return (String) m36999a(this.f30139c);
    }

    public int getClientVersionCode() {
        return ((Integer) m36999a(Integer.valueOf(this.f30140d))).intValue();
    }

    public boolean getResolutionInstallHMS() {
        return this.f30138b;
    }

    public ArrayList getTypeList() {
        return (ArrayList) m36999a(this.f30143g);
    }

    public boolean isHmsOrApkUpgrade() {
        return ((Boolean) m36999a(Boolean.valueOf(this.f30137a))).booleanValue();
    }

    public boolean isNeedConfirm() {
        return ((Boolean) m36999a(Boolean.valueOf(this.f30144h))).booleanValue();
    }

    public void setClientAppId(String str) {
        this.f30141e = str;
    }

    public void setClientAppName(String str) {
        this.f30142f = str;
    }

    public void setClientPackageName(String str) {
        this.f30139c = str;
    }

    public void setClientVersionCode(int i10) {
        this.f30140d = i10;
    }

    public void setHmsOrApkUpgrade(boolean z10) {
        this.f30137a = z10;
    }

    public void setNeedConfirm(boolean z10) {
        this.f30144h = z10;
    }

    public void setResolutionInstallHMS(boolean z10) {
        this.f30138b = z10;
    }

    public void setTypeList(ArrayList arrayList) {
        this.f30143g = arrayList;
    }
}
