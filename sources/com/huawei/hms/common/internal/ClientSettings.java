package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes8.dex */
public class ClientSettings {

    /* renamed from: a */
    private String f23481a;

    /* renamed from: b */
    private String f23482b;

    /* renamed from: c */
    private List<Scope> f23483c;

    /* renamed from: d */
    private String f23484d;

    /* renamed from: e */
    private List<String> f23485e;

    /* renamed from: f */
    private String f23486f;

    /* renamed from: g */
    private SubAppInfo f23487g;

    /* renamed from: h */
    private WeakReference<Activity> f23488h;

    /* renamed from: i */
    private boolean f23489i;

    /* renamed from: j */
    private String f23490j;

    /* renamed from: k */
    private boolean f23491k;

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2) {
        this.f23481a = str;
        this.f23482b = str2;
        this.f23483c = list;
        this.f23484d = str3;
        this.f23485e = list2;
    }

    public List<String> getApiName() {
        return this.f23485e;
    }

    public String getAppID() {
        return this.f23484d;
    }

    public String getClientClassName() {
        return this.f23482b;
    }

    public String getClientPackageName() {
        return this.f23481a;
    }

    public Activity getCpActivity() {
        WeakReference<Activity> weakReference = this.f23488h;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getCpID() {
        return this.f23486f;
    }

    public String getInnerHmsPkg() {
        return this.f23490j;
    }

    public List<Scope> getScopes() {
        return this.f23483c;
    }

    public SubAppInfo getSubAppID() {
        return this.f23487g;
    }

    public boolean isHasActivity() {
        return this.f23489i;
    }

    public boolean isUseInnerHms() {
        return this.f23491k;
    }

    public void setApiName(List<String> list) {
        this.f23485e = list;
    }

    public void setAppID(String str) {
        this.f23484d = str;
    }

    public void setClientClassName(String str) {
        this.f23482b = str;
    }

    public void setClientPackageName(String str) {
        this.f23481a = str;
    }

    public void setCpActivity(Activity activity) {
        this.f23488h = new WeakReference<>(activity);
        this.f23489i = true;
    }

    public void setCpID(String str) {
        this.f23486f = str;
    }

    public void setInnerHmsPkg(String str) {
        this.f23490j = str;
    }

    public void setScopes(List<Scope> list) {
        this.f23483c = list;
    }

    public void setSubAppId(SubAppInfo subAppInfo) {
        this.f23487g = subAppInfo;
    }

    public void setUseInnerHms(boolean z10) {
        this.f23491k = z10;
    }

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2, SubAppInfo subAppInfo) {
        this(str, str2, list, str3, list2);
        this.f23487g = subAppInfo;
    }
}
