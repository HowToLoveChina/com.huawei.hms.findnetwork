package com.huawei.hms.p148ui;

import android.os.Bundle;
import com.huawei.hms.base.p117ui.LogUtil;

/* loaded from: classes8.dex */
public class SafeBundle {

    /* renamed from: a */
    private final Bundle f30130a;

    public SafeBundle() {
        this(new Bundle());
    }

    public boolean containsKey(String str) {
        try {
            return this.f30130a.containsKey(str);
        } catch (Throwable unused) {
            LogUtil.m30634e("SafeBundle", "containsKey exception. key:");
            return false;
        }
    }

    public Object get(String str) {
        try {
            return this.f30130a.get(str);
        } catch (Exception e10) {
            LogUtil.m30635e("SafeBundle", "get exception: " + e10.getMessage(), true);
            return null;
        }
    }

    public Bundle getBundle() {
        return this.f30130a;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public String getString(String str) {
        try {
            return this.f30130a.getString(str);
        } catch (Throwable th2) {
            LogUtil.m30635e("SafeBundle", "getString exception: " + th2.getMessage(), true);
            return "";
        }
    }

    public boolean isEmpty() {
        try {
            return this.f30130a.isEmpty();
        } catch (Exception unused) {
            LogUtil.m30634e("SafeBundle", "isEmpty exception");
            return true;
        }
    }

    public int size() {
        try {
            return this.f30130a.size();
        } catch (Exception unused) {
            LogUtil.m30634e("SafeBundle", "size exception");
            return 0;
        }
    }

    public String toString() {
        return this.f30130a.toString();
    }

    public SafeBundle(Bundle bundle) {
        this.f30130a = bundle == null ? new Bundle() : bundle;
    }

    public int getInt(String str, int i10) {
        try {
            return this.f30130a.getInt(str, i10);
        } catch (Throwable th2) {
            LogUtil.m30635e("SafeBundle", "getInt exception: " + th2.getMessage(), true);
            return i10;
        }
    }

    public String getString(String str, String str2) {
        try {
            return this.f30130a.getString(str, str2);
        } catch (Exception e10) {
            LogUtil.m30635e("SafeBundle", "getString exception: " + e10.getMessage(), true);
            return str2;
        }
    }
}
