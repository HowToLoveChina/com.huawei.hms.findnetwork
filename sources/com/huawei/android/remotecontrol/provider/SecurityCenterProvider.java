package com.huawei.android.remotecontrol.provider;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.android.remotecontrol.sdk.R$string;
import gp.C10028c;
import p015ak.C0209d;
import p459lp.C11330h;
import p709vj.C13452e;
import p809yg.C13981a;
import ug.C13171a;

/* loaded from: classes4.dex */
public class SecurityCenterProvider extends ContentProvider {
    /* renamed from: c */
    public static boolean m26459c(String str) {
        if (!PhoneFinderFeatureProvider.m26447d(str)) {
            C13981a.m83989i("SecurityCenterProvider", "not support countryCode");
            return false;
        }
        if (!C10028c.m62182c0().m62400u1("funcfg_find_my_phone_globe", true)) {
            C13981a.m83989i("SecurityCenterProvider", "not enable in server");
            return false;
        }
        if (C10028c.m62182c0().m62350k1(true, str)) {
            return true;
        }
        C13981a.m83989i("SecurityCenterProvider", "isEnable false");
        return false;
    }

    /* renamed from: a */
    public final boolean m26460a() {
        if (!C0209d.m1166E1()) {
            C13981a.m83989i("SecurityCenterProvider", "is not OwnerUser");
            return false;
        }
        if (!C13171a.m79199e()) {
            C13981a.m83989i("SecurityCenterProvider", "is not support AntiTheft");
            return false;
        }
        if (!C11330h.m68077a()) {
            C13981a.m83989i("SecurityCenterProvider", "new honor not show");
            return false;
        }
        if (C13452e.m80781L().m80842P0()) {
            return m26459c(C13452e.m80781L().m80942m());
        }
        C13981a.m83989i("SecurityCenterProvider", "account is not login");
        return C10028c.m62182c0().m62355l1();
    }

    /* renamed from: b */
    public final boolean m26461b() throws IllegalAccessException, InstantiationException {
        try {
            Object objNewInstance = Class.forName("com.huawei.android.app.admin.DeviceSettingsManager").newInstance();
            return ((Boolean) objNewInstance.getClass().getDeclaredMethod("isPhoneFindDisabled", ComponentName.class).invoke(objNewInstance, null)).booleanValue();
        } catch (Exception e10) {
            C13981a.m83988e("SecurityCenterProvider", "isPhoneFindDisabled error: " + e10.getMessage());
            return false;
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        C13981a.m83989i("SecurityCenterProvider", "call method = " + str + " ; arg = " + str2 + " ; extras = " + bundle);
        if (!C0209d.m1247e(getContext())) {
            C13981a.m83988e("SecurityCenterProvider", "initContext failed");
            return null;
        }
        if (!"checkMenuIsSupportToShow".equals(str)) {
            return null;
        }
        C13981a.m83989i("SecurityCenterProvider", "put result.");
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("IS_SUPPORT", m26460a());
        bundle2.putString("FEATURE_TITLE_NAME", getContext().getString(R$string.app_name));
        boolean z10 = !m26461b();
        bundle2.putBoolean("IS_ITEM_ENABLE", z10);
        bundle2.putBoolean("IS_ITEM_CLICKABLE", z10);
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
