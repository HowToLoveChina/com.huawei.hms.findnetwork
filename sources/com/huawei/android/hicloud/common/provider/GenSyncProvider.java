package com.huawei.android.hicloud.common.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.android.hicloud.sync.service.aidl.GenSyncLogicService;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import gp.C10028c;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p514o9.C11839m;
import p684un.C13230i;
import p742wj.C13612b;

/* loaded from: classes3.dex */
public class GenSyncProvider extends ContentProvider {

    /* renamed from: a */
    public static final UriMatcher f11948a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f11948a = uriMatcher;
        uriMatcher.addURI("com.huawei.android.sync.genSyncProvider", "switchState", 1);
        uriMatcher.addURI("com.huawei.android.sync.genSyncProvider", "isSyncRecycle", 2);
        uriMatcher.addURI("com.huawei.android.sync.genSyncProvider", "login_status", 4);
    }

    /* renamed from: a */
    public final void m15625a(String str) throws IllegalArgumentException {
        if (NotifyUtil.isAppFingerPrintValid(getContext(), str, getCallingPackage())) {
            return;
        }
        C11839m.m70687e("GenSyncProvider", "checkCallingPackage: syncType " + str + ", pkg " + getCallingPackage() + ", finger prints not valid.");
        throw new IllegalArgumentException("general signature is not valid.");
    }

    /* renamed from: b */
    public final void m15626b(String[] strArr) {
        if (strArr == null || strArr.length < 1) {
            C11839m.m70687e("GenSyncProvider", "query, selectionArgs is null");
            throw new IllegalArgumentException("selection args is error.");
        }
        String str = strArr[0];
        if (!m15629e(str) && !NotifyUtil.getAllShownSyncServiceId(getContext()).contains(str)) {
            throw new IllegalArgumentException("selection args is error: syncType = " + str);
        }
        if (strArr.length >= 2) {
            String str2 = strArr[1];
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("selection args is error: syncType or dataType is null");
            }
        }
    }

    /* renamed from: c */
    public final void m15627c(String[] strArr) {
        if (strArr == null || strArr.length < 1) {
            C11839m.m70687e("GenSyncProvider", "query, selectionArgs is null");
            throw new IllegalArgumentException("selection args is error.");
        }
    }

    /* renamed from: d */
    public final boolean m15628d(String str) {
        return NotifyUtil.HINOTE_PKG_NAME.equals(getCallingPackage()) && "notepad".equals(str);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        C11839m.m70688i("GenSyncProvider", "delete");
        return 0;
    }

    /* renamed from: e */
    public final boolean m15629e(String str) {
        String callingPackage = getCallingPackage();
        return (NextRestoreConstants.PKG_NAME_MEMO.equals(callingPackage) || "com.example.android.notepad".equals(callingPackage)) && NotifyUtil.HI_NOTE_SYNC_TYPE.equals(str);
    }

    /* renamed from: f */
    public final boolean m15630f(Context context, String[] strArr) throws Throwable {
        if (strArr.length < 2) {
            return false;
        }
        String str = strArr[0];
        String str2 = strArr[1];
        boolean zIsServiceSupportRecycleProcess = GenSyncLogicService.isServiceSupportRecycleProcess(context, str, str2);
        C11839m.m70688i("GenSyncProvider", "Module name: " + strArr[0] + ", dataType: " + str2 + ", isSyncRecycle: " + zIsServiceSupportRecycleProcess);
        return zIsServiceSupportRecycleProcess;
    }

    /* renamed from: g */
    public final Cursor m15631g(int i10, Uri uri) {
        C11839m.m70688i("GenSyncProvider", "queryHiCloudLogin");
        String[] strArr = {"login_status"};
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        if (-1 == i10) {
            matrixCursor.close();
            throw new IllegalArgumentException("Unkown URI " + uri);
        }
        if (4 != i10) {
            return matrixCursor;
        }
        C11839m.m70688i("GenSyncProvider", "login_status");
        matrixCursor.close();
        MatrixCursor matrixCursor2 = new MatrixCursor(strArr);
        matrixCursor2.addRow(new Object[]{String.valueOf(C13612b.m81829B().m81852P())});
        return matrixCursor2;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        C11839m.m70688i("GenSyncProvider", "getType");
        return null;
    }

    /* renamed from: h */
    public final void m15632h(String[] strArr, MatrixCursor matrixCursor, C10028c c10028c) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(getContext(), "account_info", 0);
        boolean z10 = (sharedPreferencesM1382b == null || sharedPreferencesM1382b.getString("user_id", null) == null) ? false : true;
        m15626b(strArr);
        String str = strArr[0];
        boolean zM16060y0 = CloudSyncUtil.m16060y0(str);
        if (m15628d(str)) {
            if (!z10 || zM16060y0) {
                matrixCursor.addRow(new Object[]{"false", 107});
                C11839m.m70688i("GenSyncProvider", "hinote sync notepad while hinote switch off, return false.");
                return;
            } else {
                matrixCursor.addRow(new Object[]{String.valueOf(c10028c.m62388s(NotifyUtil.HI_NOTE_SYNC_TYPE)), 107});
                C11839m.m70688i("GenSyncProvider", "hinote sync notepad data, return true.");
                return;
            }
        }
        if (m15629e(str)) {
            if (!z10 || zM16060y0) {
                matrixCursor.addRow(new Object[]{"false", 107});
                C11839m.m70688i("GenSyncProvider", "notepad sync hinote while notepad switch off, return false.");
                return;
            } else {
                matrixCursor.addRow(new Object[]{String.valueOf(c10028c.m62388s("notepad")), 107});
                C11839m.m70688i("GenSyncProvider", "notepad sync hinote data, return true.");
                return;
            }
        }
        if (!z10 || zM16060y0) {
            matrixCursor.addRow(new Object[]{"false", 107});
            C11839m.m70688i("GenSyncProvider", "Module name: " + str + ", switch status = false");
            return;
        }
        boolean zM62388s = c10028c.m62388s(str);
        C11839m.m70688i("GenSyncProvider", "Module name: " + str + ", isSwitchOn = " + zM62388s);
        matrixCursor.addRow(new Object[]{String.valueOf(zM62388s), 107});
    }

    /* renamed from: i */
    public final Cursor m15633i(int i10, String[] strArr, Uri uri) {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"switchState", "getVersionCode"});
        C10028c c10028cM62183d0 = C10028c.m62183d0(getContext());
        if (i10 == -1) {
            matrixCursor.close();
            return matrixCursor;
        }
        if (i10 == 1) {
            m15632h(strArr, matrixCursor, c10028cM62183d0);
            return matrixCursor;
        }
        if (i10 == 2) {
            MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{"isSyncRecycle"});
            m15626b(strArr);
            matrixCursor2.addRow(new Object[]{Boolean.valueOf(m15630f(getContext(), strArr))});
            return matrixCursor2;
        }
        throw new IllegalArgumentException("Unkown URI " + uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        C11839m.m70688i("GenSyncProvider", "insert");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws IllegalArgumentException {
        C11839m.m70688i("GenSyncProvider", "query");
        m15627c(strArr2);
        m15625a(strArr2[0]);
        C0209d.m1247e(getContext());
        int iMatch = f11948a.match(uri);
        C13230i.m79500C0(C0213f.m1377a(), "GenSyncProvider", getCallingPackage(), String.valueOf(iMatch));
        if (iMatch == 1 || iMatch == 2) {
            return m15633i(iMatch, strArr2, uri);
        }
        if (iMatch == 4) {
            return m15631g(iMatch, uri);
        }
        throw new IllegalArgumentException("Unkown URI " + uri);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        C11839m.m70688i("GenSyncProvider", SyncProtocol.Constant.UPDATE);
        return 0;
    }
}
