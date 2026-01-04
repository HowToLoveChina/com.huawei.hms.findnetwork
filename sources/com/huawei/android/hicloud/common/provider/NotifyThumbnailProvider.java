package com.huawei.android.hicloud.common.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import p015ak.C0213f;
import p514o9.C11839m;
import p664u0.C13108a;

/* loaded from: classes3.dex */
public class NotifyThumbnailProvider extends ContentProvider {

    /* renamed from: a */
    public static final UriMatcher f11975a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f11975a = uriMatcher;
        uriMatcher.addURI("com.huawei.android.sync.notifyThumbnailProvider", "thumbnail_data", 1);
    }

    /* renamed from: a */
    public final void m15716a(String str, String str2) {
        Intent intent = new Intent("com.huawei.android.hicloud.nofityThumbnail");
        intent.putExtra("thumbnailPath", str);
        intent.putExtra("fileId", str2);
        C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        C11839m.m70688i("NotifyThumbnailProvider", "execute NotifyThumbnailProvider#call");
        if ("notify_thumbnail".equals(str)) {
            m15716a(bundle.getString("thumbnailPath"), bundle.getString("fileId"));
        }
        return bundle;
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
