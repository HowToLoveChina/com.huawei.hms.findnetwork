package com.huawei.android.hicloud.common.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import p514o9.C11839m;
import zm.C14348f;

/* loaded from: classes3.dex */
public class HiCloudVideoProgressProvider extends ContentProvider {

    /* renamed from: b */
    public static final UriMatcher f11951b;

    /* renamed from: a */
    public SQLiteDatabase f11952a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f11951b = uriMatcher;
        uriMatcher.addURI("com.huawei.android.hicloud.videoProgressProvider", "online_video_play_progress", 1);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        C11839m.m70688i("HiCloudVideoProgressProvider", "delete");
        if (uri == null) {
            C11839m.m70688i("HiCloudVideoProgressProvider", "delete uri is null");
            return -1;
        }
        int iMatch = f11951b.match(uri);
        if (-1 == iMatch) {
            C11839m.m70688i("HiCloudVideoProgressProvider", "delete uri not match: " + uri);
            return -1;
        }
        if (1 == iMatch) {
            SQLiteDatabase writableDatabase = C14348f.m85529b(getContext()).getWritableDatabase();
            this.f11952a = writableDatabase;
            if (writableDatabase != null) {
                return writableDatabase.delete("online_video_play_progress", str, strArr);
            }
        }
        return -1;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        C11839m.m70688i("HiCloudVideoProgressProvider", "getType");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        C11839m.m70688i("HiCloudVideoProgressProvider", "insert");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (uri == null) {
            C11839m.m70688i("HiCloudVideoProgressProvider", "query uri is null");
            return null;
        }
        int iMatch = f11951b.match(uri);
        if (-1 == iMatch) {
            C11839m.m70688i("HiCloudVideoProgressProvider", "query uri not match: " + uri);
            return null;
        }
        if (1 != iMatch) {
            return null;
        }
        this.f11952a = C14348f.m85529b(getContext()).getWritableDatabase();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("db is null ? ");
        sb2.append(this.f11952a == null);
        C11839m.m70688i("HiCloudVideoProgressProvider", sb2.toString());
        SQLiteDatabase sQLiteDatabase = this.f11952a;
        if (sQLiteDatabase != null) {
            return sQLiteDatabase.query("online_video_play_progress", strArr, null, null, null, null, null);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        C11839m.m70688i("HiCloudVideoProgressProvider", SyncProtocol.Constant.UPDATE);
        return 0;
    }
}
