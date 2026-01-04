package com.huawei.android.hicloud.cloudbackup.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.CloudRestoreTask;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil;
import fk.C9721b;
import p015ak.C0209d;
import p514o9.C11839m;
import p709vj.C13452e;
import p711vl.C13466f;
import p744wl.C13617a;
import tl.C13029h;
import tl.C13030i;
import tl.C13033l;

/* loaded from: classes2.dex */
public class CloudBackupStateProvider extends ContentProvider {
    public static final String AUTHORITY = "com.huawei.hidisk.cloudbackup.backupstate";
    private static final UriMatcher MATCHER;
    private static final String METHOD_CANCEL_BROADCAST = "endRefurbish";
    public static final String METHOD_START_MAIN_PROCESS = "start_main_process";
    private static final String QUERY_BACKUP_INFO = "querybackupinfo";
    private static final String QUERY_BACKUP_STATE = "querybackupstate";
    public static final String QUERY_INTERIM_BACKUP_STATUS = "interimBackupStatus";
    public static final String QUERY_RESTORE_ID = "queryrestoreid";
    private static final String QUERY_RESTORE_STATE = "queryrestorestate";
    public static final String QUERY_TIME_WINDOW_CONFIG = "queryTimeWindowOmConfig";
    private static final String QUERY_VERSION = "version";
    private static final String TAG = "CloudBackupStateProvider";
    private static final String UNKNOWN_URI = "Unknown URI ";
    private static final int URI_QUERY_BACKUP_INFO = 6;
    private static final int URI_QUERY_BACKUP_STATE = 1;
    private static final int URI_QUERY_INTERIM_BACKUP_STATUS = 7;
    private static final int URI_QUERY_RESTORE_ID = 5;
    private static final int URI_QUERY_RESTORE_STATE = 2;
    private static final int URI_QUERY_TIMER_WINDOW_CONFIG = 4;
    private static final int URI_QUERY_VERSION_STATE = 3;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        MATCHER = uriMatcher;
        uriMatcher.addURI(AUTHORITY, QUERY_BACKUP_STATE, 1);
        uriMatcher.addURI(AUTHORITY, QUERY_RESTORE_STATE, 2);
        uriMatcher.addURI(AUTHORITY, "version", 3);
        uriMatcher.addURI(AUTHORITY, QUERY_TIME_WINDOW_CONFIG, 4);
        uriMatcher.addURI(AUTHORITY, QUERY_RESTORE_ID, 5);
        uriMatcher.addURI(AUTHORITY, QUERY_BACKUP_INFO, 6);
        uriMatcher.addURI(AUTHORITY, QUERY_INTERIM_BACKUP_STATUS, 7);
    }

    private void clearRestoreDataBase(String str) {
        try {
            C13030i c13030i = new C13030i();
            C13029h c13029hM78495f = c13030i.m78495f(3);
            if (c13029hM78495f == null) {
                C11839m.m70688i(TAG, "end refurbish return null.");
                return;
            }
            if (!c13029hM78495f.m78478s().contains(CloudRestoreTask.MYHUAWEI_TAG)) {
                C11839m.m70688i(TAG, "tags not contains myhuawei.");
                return;
            }
            c13030i.m78491b(3, str);
            new C13033l().m78543a(2);
            RestoreProgress.clearCache();
            C13452e.m80781L().m80890b();
            C13617a.m81932n(true);
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "end refurbish clear db error: " + e10.toString());
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        C0209d.m1247e(getContext());
        Bundle bundle2 = new Bundle();
        if (METHOD_START_MAIN_PROCESS.equals(str)) {
            C11839m.m70688i(TAG, "METHOD_START_MAIN_PROCESS");
            return bundle2;
        }
        bundle2.putBoolean("isSucess", false);
        if (bundle == null) {
            C11839m.m70688i(TAG, "extras is null.");
            return bundle2;
        }
        String string = bundle.getString("broadCastType", CloudBackupConstant.Command.PMS_CMD_BACKUP);
        String string2 = bundle.getString("backId", "default");
        C11839m.m70688i(TAG, "call method: " + str + ", cancelType: " + string + ", backupId: " + string2);
        if (METHOD_CANCEL_BROADCAST.equals(str)) {
            if ("restore".equals(string)) {
                bundle2.putString("broadCastType", "restore");
                C13466f.m81073d().m81084l("broadcast_restoreId", "");
                bundle2.putBoolean("isSucess", true);
                clearRestoreDataBase(string2);
            } else {
                bundle2.putString("broadCastType", CloudBackupConstant.Command.PMS_CMD_BACKUP);
                C13466f.m81073d().m81084l("broadcast_backupId", "");
                bundle2.putBoolean("isSucess", true);
            }
        }
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
        C0209d.m1247e(getContext());
        switch (MATCHER.match(uri)) {
            case 1:
                return CloudBackupStateUtil.getInstance().queryBackupState(strArr2);
            case 2:
                return CloudBackupStateUtil.getInstance().queryRestoreState(strArr2);
            case 3:
                return CloudBackupStateUtil.getInstance().queryVersionState(strArr2);
            case 4:
                return CloudBackupStateUtil.getInstance().getTimeWindowConfig();
            case 5:
                return CloudBackupStateUtil.getInstance().queryRestoreId();
            case 6:
                return CloudBackupStateUtil.getInstance().queryBackupInfo(strArr2, getContext());
            case 7:
                return CloudBackupStateUtil.getInstance().queryTempBackupStatus();
            default:
                C11839m.m70688i(TAG, "unknow uri" + uri);
                throw new IllegalArgumentException("Unknown URI  " + uri);
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
