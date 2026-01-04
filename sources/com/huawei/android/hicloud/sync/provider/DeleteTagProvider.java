package com.huawei.android.hicloud.sync.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import p514o9.C11839m;
import p675uc.C13153a;

/* loaded from: classes3.dex */
public class DeleteTagProvider extends ContentProvider {

    /* renamed from: a */
    public static final UriMatcher f12981a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f12981a = uriMatcher;
        uriMatcher.addURI("com.huawei.hicloud.deleteTagProvider", "delete_tag", 1);
    }

    /* renamed from: a */
    public final boolean m17788a(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            C11839m.m70688i("DeleteTagProvider", "deleteTag error: selectionArgs is null or empty.");
            return false;
        }
        for (String str : strArr) {
            try {
                C13153a.m79133s(str, getContext());
            } catch (Exception e10) {
                C11839m.m70687e("DeleteTagProvider", "deleteTag exception = " + e10.toString());
                return false;
            }
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        C11839m.m70686d("DeleteTagProvider", "delete, uri = " + uri);
        if (f12981a.match(uri) == 1) {
            return m17788a(strArr) ? 0 : -1;
        }
        C11839m.m70689w("DeleteTagProvider", "delete fail: unknown uri = " + uri);
        return -1;
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
