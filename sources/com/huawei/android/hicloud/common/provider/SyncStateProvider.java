package com.huawei.android.hicloud.common.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.android.hicloud.sync.syncutil.C2986o;
import gp.C10028c;
import md.C11440c;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p684un.C13230i;

/* loaded from: classes3.dex */
public class SyncStateProvider extends ContentProvider {

    /* renamed from: a */
    public static final UriMatcher f11985a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f11985a = uriMatcher;
        uriMatcher.addURI("com.huawei.android.hicloud.syncstate", "contacts_autosyncswitch", 1);
        uriMatcher.addURI("com.huawei.android.hicloud.syncstate", "is_sync_task_exist", 3);
        uriMatcher.addURI("com.huawei.android.hicloud.syncstate", "reset_sync_retry_time", 4);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        C11839m.m70686d("SyncStateProvider", "delete");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        C11839m.m70686d("SyncStateProvider", "getType");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        C11839m.m70686d("SyncStateProvider", "insert");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int iMatch = f11985a.match(uri);
        C11839m.m70686d("SyncStateProvider", "match result" + iMatch);
        C0209d.m1247e(getContext());
        C13230i.m79500C0(C0213f.m1377a(), "SyncStateProvider", getCallingPackage(), String.valueOf(iMatch));
        if (iMatch == -1) {
            throw new IllegalArgumentException("Unkown URI " + uri);
        }
        if (iMatch != 1) {
            if (iMatch != 3) {
                return null;
            }
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{"is_sync_task_exist_key"});
            matrixCursor.addRow(new Object[]{Boolean.valueOf(strArr2.length > 0 ? C11440c.m68534l(strArr2[0]) : false)});
            return matrixCursor;
        }
        MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{"isopen"});
        C10028c c10028cM62183d0 = C10028c.m62183d0(getContext());
        if (c10028cM62183d0 != null) {
            if (c10028cM62183d0.m62403v("is_exit_finish", true)) {
                zM62388s = c10028cM62183d0.m62388s("addressbook");
            } else {
                C11839m.m70689w("SyncStateProvider", "The last exit progress hasn't finished, assume contact switch is false");
            }
        }
        matrixCursor2.addRow(new Object[]{Boolean.valueOf(zM62388s)});
        return matrixCursor2;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        C11839m.m70686d("SyncStateProvider", SyncProtocol.Constant.UPDATE);
        if (f11985a.match(uri) != 4) {
            return 0;
        }
        C2986o.m17948e(str);
        return 0;
    }
}
