package com.huawei.updatesdk.p191b.p195b;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;

/* renamed from: com.huawei.updatesdk.b.b.b */
/* loaded from: classes9.dex */
public class C8808b {

    /* renamed from: a */
    private final SharedPreferences f45141a;

    private C8808b(SharedPreferences sharedPreferences) {
        this.f45141a = sharedPreferences;
    }

    /* renamed from: a */
    public long m56220a(String str, long j10) {
        try {
            return this.f45141a.getLong(str, j10);
        } catch (Exception unused) {
            return j10;
        }
    }

    /* renamed from: b */
    public void m56223b(String str, long j10) {
        try {
            SharedPreferences.Editor editorEdit = this.f45141a.edit();
            editorEdit.putLong(str, j10);
            editorEdit.commit();
        } catch (Exception e10) {
            C8777a.m56027a("SharedPreferencesWrapper", "putLong error!!key:" + str, e10);
        }
    }

    /* renamed from: a */
    public static C8808b m56219a(String str, Context context) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.createDeviceProtectedStorageContext().getSharedPreferences(str, 0);
        } catch (Exception unused) {
            C8777a.m56028b("SharedPreferencesWrapper", "getSharedPreference error");
            sharedPreferences = null;
        }
        return new C8808b(sharedPreferences);
    }

    /* renamed from: b */
    public void m56224b(String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = this.f45141a.edit();
            editorEdit.putString(str, str2);
            editorEdit.commit();
        } catch (Exception e10) {
            C8777a.m56027a("SharedPreferencesWrapper", "putString error!!key:" + str, e10);
        }
    }

    /* renamed from: a */
    public String m56221a(String str, String str2) {
        try {
            return this.f45141a.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    /* renamed from: a */
    public void m56222a(String str) {
        try {
            if (this.f45141a.contains(str)) {
                SharedPreferences.Editor editorEdit = this.f45141a.edit();
                editorEdit.remove(str);
                editorEdit.commit();
            }
        } catch (Exception unused) {
            C8777a.m56028b("SharedPreferencesWrapper", "remove error!!key:" + str);
        }
    }
}
