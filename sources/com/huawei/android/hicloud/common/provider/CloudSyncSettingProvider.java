package com.huawei.android.hicloud.common.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import nc.C11662a;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class CloudSyncSettingProvider extends ContentProvider {

    /* renamed from: a */
    public static final UriMatcher f11942a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f11942a = uriMatcher;
        uriMatcher.addURI("com.huawei.android.ds.cloudsync.provider", "sync_switch", 1);
        uriMatcher.addURI("com.huawei.android.ds.cloudsync.provider", "clear", 2);
    }

    /* renamed from: a */
    public final boolean m15615a(ContentValues contentValues) {
        return (contentValues == null || contentValues.keySet() == null) ? false : true;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (f11942a.match(uri) == 2) {
            C11662a.m69650c(getContext()).m69651a();
            return 0;
        }
        throw new IllegalArgumentException("Unknown URI  " + uri);
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
        if (!m15615a(contentValues)) {
            return -1;
        }
        if (f11942a.match(uri) != 1) {
            throw new IllegalArgumentException("Unknown URI  " + uri);
        }
        C11662a c11662aM69650c = C11662a.m69650c(getContext());
        c11662aM69650c.m69654e("wlan", contentValues.getAsBoolean("wlan").booleanValue());
        c11662aM69650c.m69654e("autosmslistkey", contentValues.getAsBoolean("autosmslistkey").booleanValue());
        c11662aM69650c.m69654e("autocallloglistkey", contentValues.getAsBoolean("autocallloglistkey").booleanValue());
        c11662aM69650c.m69654e("autorecordingkey", contentValues.getAsBoolean("autorecordingkey").booleanValue());
        c11662aM69650c.m69654e("autophonemanagerkey", contentValues.getAsBoolean("autophonemanagerkey").booleanValue());
        C11839m.m70688i("CloudSyncSettingProvider", "update switch to ds result = 0");
        return 0;
    }
}
