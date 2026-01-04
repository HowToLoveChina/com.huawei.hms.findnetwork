package com.huawei.openalliance.p169ad.beans.metadata;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes8.dex */
public class InstallConfig implements Serializable {
    private static final long serialVersionUID = 546555599564481045L;
    private String appBtnInstallWay;
    private String contentBtnInstallWay;
    private String creativeInstallWay;

    /* renamed from: a */
    public String m40192a() {
        return this.creativeInstallWay;
    }

    /* renamed from: b */
    public String m40194b() {
        return this.appBtnInstallWay;
    }

    /* renamed from: c */
    public String m40196c() {
        return TextUtils.isEmpty(this.contentBtnInstallWay) ? this.appBtnInstallWay : this.contentBtnInstallWay;
    }

    /* renamed from: a */
    public void m40193a(String str) {
        this.creativeInstallWay = str;
    }

    /* renamed from: b */
    public void m40195b(String str) {
        this.appBtnInstallWay = str;
    }

    /* renamed from: c */
    public void m40197c(String str) {
        this.contentBtnInstallWay = str;
    }
}
