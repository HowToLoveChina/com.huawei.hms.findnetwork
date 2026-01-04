package com.huawei.android.hicloud.common.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import p015ak.C0214f0;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class DeviceNameProvider extends ContentProvider {

    /* renamed from: a */
    public static final UriMatcher f11944a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f11944a = uriMatcher;
        uriMatcher.addURI("com.huawei.android.hicloud.devicenameprovider", "backup_end_time", 1);
        uriMatcher.addURI("com.huawei.android.hicloud.devicenameprovider", "backup_notAllSucess", 2);
        uriMatcher.addURI("com.huawei.android.hicloud.devicenameprovider", "recordingtimestamp", 3);
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
        SharedPreferences sharedPreferencesM1382b;
        int iMatch = f11944a.match(uri);
        C11839m.m70686d("DeviceNameProvider", "match result" + iMatch);
        if (iMatch == -1) {
            throw new IllegalArgumentException("Unkown URI " + uri);
        }
        if (iMatch != 1) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"autophonemanagerkey_endtime"});
        Context context = getContext();
        String string = "0";
        if (context != null && (sharedPreferencesM1382b = C0214f0.m1382b(context, "deviceNameSp", 0)) != null) {
            string = sharedPreferencesM1382b.getString(str, "0");
        }
        matrixCursor.addRow(new Object[]{string});
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        SharedPreferences sharedPreferencesM1382b;
        C11839m.m70686d("DeviceNameProvider", "update uri: " + uri);
        int iMatch = f11944a.match(uri);
        Context context = getContext();
        if (context == null || (sharedPreferencesM1382b = C0214f0.m1382b(context, "deviceNameSp", 0)) == null) {
            return -1;
        }
        if (iMatch == 2) {
            sharedPreferencesM1382b.edit().putBoolean(str, true).commit();
        } else if (iMatch == 3) {
            sharedPreferencesM1382b.edit().putLong(str, contentValues.getAsLong(str).longValue()).commit();
        }
        return 0;
    }
}
