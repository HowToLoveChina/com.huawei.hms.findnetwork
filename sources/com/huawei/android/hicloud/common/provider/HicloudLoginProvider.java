package com.huawei.android.hicloud.common.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p684un.C13230i;
import p709vj.C13452e;
import p742wj.C13612b;

/* loaded from: classes3.dex */
public class HicloudLoginProvider extends ContentProvider {

    /* renamed from: a */
    public static final UriMatcher f11966a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f11966a = uriMatcher;
        uriMatcher.addURI("com.huawei.android.hicloud.loginProvider", "login_user", 1);
        uriMatcher.addURI("com.huawei.android.hicloud.loginProvider", "login_status", 2);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        C11839m.m70688i("HicloudLoginProvider", "delete");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        C11839m.m70688i("HicloudLoginProvider", "getType");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        C11839m.m70688i("HicloudLoginProvider", "insert");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        C11839m.m70688i("HicloudLoginProvider", "login query from " + getCallingPackage());
        int iMatch = f11966a.match(uri);
        C0209d.m1247e(getContext());
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{HwPayConstant.KEY_SITE_ID, "deviceID", JsbMapKeyNames.H5_DEVICE_TYPE, "accountName", "userPhoto", HwPayConstant.KEY_USER_ID});
        C13230i.m79500C0(C0213f.m1377a(), "HicloudLoginProvider", getCallingPackage(), String.valueOf(iMatch));
        if (-1 == iMatch) {
            matrixCursor.close();
            throw new IllegalArgumentException("Unkown URI " + uri);
        }
        if (1 == iMatch) {
            C11839m.m70686d("HicloudLoginProvider", "login_user");
            if (C13612b.m81829B().isLogin()) {
                matrixCursor.addRow(new Object[]{String.valueOf(C13452e.m80781L().m80947n0()), C13452e.m80781L().m80950o(), C13452e.m80781L().m80966s(), C13452e.m80781L().m80900d(), C13452e.m80781L().m80891b0(), C13452e.m80781L().m80971t0()});
            }
            return matrixCursor;
        }
        if (2 != iMatch) {
            return matrixCursor;
        }
        C11839m.m70686d("HicloudLoginProvider", "login_status");
        matrixCursor.close();
        MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{"login_status"});
        matrixCursor2.addRow(new Object[]{String.valueOf(C13612b.m81829B().m81852P())});
        return matrixCursor2;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        C11839m.m70688i("HicloudLoginProvider", SyncProtocol.Constant.UPDATE);
        return 0;
    }
}
