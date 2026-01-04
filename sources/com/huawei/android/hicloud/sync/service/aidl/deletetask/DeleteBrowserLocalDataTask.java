package com.huawei.android.hicloud.sync.service.aidl.deletetask;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import je.C10812z;
import p015ak.C0209d;
import p514o9.C11839m;
import p675uc.C13153a;
import p783xp.C13843a;
import sc.C12770c;
import sc.C12771d;

/* loaded from: classes3.dex */
public class DeleteBrowserLocalDataTask extends DeleteLocalDataBaseTask {
    private static final String TAG = "DeleteBrowserLocalDataTask";
    private String bussinessId;

    public DeleteBrowserLocalDataTask(Context context, int i10, String str) {
        super(context, i10, str);
        this.bussinessId = str;
    }

    public static void deleteBrowserData(Context context, int i10, String str) {
        if (context == null) {
            C11839m.m70689w(TAG, "deleteSyncData: context is null");
            return;
        }
        int i11 = 1;
        if (102 != i10 && 1 != i10) {
            i11 = 2;
        }
        deleteBrowserData(context, i11, "com.android.browser", str);
        deleteBrowserData(context, i11, C13843a.m83091m(), str);
    }

    public static void deleteBrowserTag() throws Exception {
        C11839m.m70688i(TAG, "deleteTag: deleteBrowserTag");
        new C12771d().m76645g("bookmark");
        new C12770c().m76637e("bookmark");
    }

    private void sendStopSyncBroadCast(String str) {
        Intent intent = new Intent("com.huawei.android.hicloud.intent.STOPSYNC");
        C0209d.m1302r2(intent, str);
        intent.putExtra("syncType", "browser");
        this.mContext.sendBroadcast(intent, "com.huawei.hicloud.permission.hicloudSync");
    }

    @Override // com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteLocalDataBaseTask
    public void deleteSyncData(String str) {
        C11839m.m70688i(TAG, "deleteSyncData: mOption = " + this.mOption);
        deleteBrowserData(this.mContext, this.mOption, str);
        C11839m.m70688i(TAG, "deleteSyncData: end");
        C11839m.m70688i(TAG, "Send stop sync broadcast");
        if (C13843a.m83078b0(this.mContext, "com.android.browser")) {
            sendStopSyncBroadCast("com.android.browser");
        }
        String strM83092n = C13843a.m83092n(this.mContext);
        if (strM83092n != null) {
            sendStopSyncBroadCast(strM83092n);
        }
    }

    @Override // com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteLocalDataBaseTask
    public void deleteTag() {
        try {
            deleteBrowserTag();
            C13153a.m79117c(this.mContext);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "deleteTag exception = " + e10.toString());
        }
    }

    private static void deleteBrowserData(Context context, int i10, String str, String str2) {
        long jCurrentTimeMillis;
        StringBuilder sb2;
        if (context == null) {
            C11839m.m70687e(TAG, "deleteSyncData: context is null");
            return;
        }
        C11839m.m70688i(TAG, "deleteSyncData: deleteType = " + i10 + ", packageName = " + str);
        Uri uriBuild = new Uri.Builder().authority(str).scheme("content").appendPath("bookmarks").appendQueryParameter("caller", "hw_system").appendQueryParameter("synced", "1").appendQueryParameter("sync_opt", String.valueOf(i10)).build();
        if (!C0209d.m1227Y1(context, uriBuild)) {
            C11839m.m70687e(TAG, "deleteSyncData: TargetApp is not SystemApp");
            return;
        }
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uriBuild);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        try {
            try {
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "deleteSyncData: error: " + e10.toString());
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                sb2 = new StringBuilder();
            }
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                C11839m.m70687e(TAG, "deleteSyncData: cpClient is null");
                return;
            }
            contentProviderClientAcquireUnstableContentProviderClient.delete(uriBuild, null, null);
            contentProviderClientAcquireUnstableContentProviderClient.release();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" useTime: ");
            sb2.append(jCurrentTimeMillis);
            C10812z.m65843l(context, "delete_end", "browser", 0, i10, sb2.toString(), str2);
        } finally {
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                contentProviderClientAcquireUnstableContentProviderClient.release();
            }
            C10812z.m65843l(context, "delete_end", "browser", 0, i10, str + " useTime: " + (System.currentTimeMillis() - jCurrentTimeMillis2), str2);
        }
    }
}
