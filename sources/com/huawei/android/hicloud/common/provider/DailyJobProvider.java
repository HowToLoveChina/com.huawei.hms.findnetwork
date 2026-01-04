package com.huawei.android.hicloud.common.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import gp.C10028c;
import mn.C11500d;
import p015ak.C0209d;
import p015ak.C0213f;
import p221d9.C9053a;
import p221d9.C9054b;
import p221d9.C9055c;
import p221d9.C9056d;
import p514o9.C11839m;
import p684un.C13230i;

/* loaded from: classes3.dex */
public class DailyJobProvider extends ContentProvider {

    /* renamed from: a */
    public static final UriMatcher f11943a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f11943a = uriMatcher;
        uriMatcher.addURI("com.huawei.android.hicloud.provider.dailyjob", "dailyJob", 1);
    }

    /* renamed from: a */
    public final void m15616a() {
        C11500d.m68648g().m68659l(new C9054b());
        C11500d.m68648g().m68659l(new C9056d());
        C11500d.m68648g().m68659l(new C9053a());
        C11500d.m68648g().m68659l(new C9055c());
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        if (!TextUtils.equals(getCallingPackage(), "com.huawei.hidisk")) {
            C11839m.m70687e("DailyJobProvider", "call not match package name");
            return null;
        }
        if (!C0209d.m1247e(getContext())) {
            C11839m.m70687e("DailyJobProvider", "initContext failed");
            return null;
        }
        C13230i.m79500C0(C0213f.m1377a(), "DailyJobProvider", getCallingPackage(), str);
        if (TextUtils.equals(str, "dailyJob")) {
            m15616a();
            C11500d.m68648g().m68649a(bundle);
        } else if (TextUtils.equals(str, "refresh_last_daily_time")) {
            C10028c.m62183d0(C0213f.m1377a()).m62293X2(System.currentTimeMillis());
        }
        return super.call(str, str2, bundle);
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
        return true;
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
