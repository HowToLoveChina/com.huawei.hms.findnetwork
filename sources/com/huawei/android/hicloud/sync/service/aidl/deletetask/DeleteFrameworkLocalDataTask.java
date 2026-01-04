package com.huawei.android.hicloud.sync.service.aidl.deletetask;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import je.C10812z;
import p015ak.C0209d;
import p514o9.C11839m;
import p675uc.C13153a;

/* loaded from: classes3.dex */
public class DeleteFrameworkLocalDataTask extends DeleteLocalDataBaseTask {
    private static final String TAG = "DeleteFrameworkLocalDataTask";
    private String bussinessId;
    private String syncType;

    public DeleteFrameworkLocalDataTask(Context context, String str, int i10, String str2) {
        super(context, i10, str2);
        this.syncType = str;
        this.bussinessId = str2;
    }

    public static void deleteFrameworkData(Context context, String str, int i10, String str2) {
        long jCurrentTimeMillis;
        StringBuilder sb2;
        if (context == null) {
            C11839m.m70687e(TAG, "deleteSyncData: context is null, packageName: " + str);
            return;
        }
        int i11 = 1;
        if (102 != i10 && 1 != i10) {
            i11 = 2;
        }
        int i12 = i11;
        C11839m.m70688i(TAG, "deleteSyncData: packageName = " + str + ", deleteType = " + i12);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        Uri uriBuild = new Uri.Builder().authority(str + ".cloudSync").scheme("content").appendPath("delete_sync_data").appendQueryParameter("sync_opt", String.valueOf(i12)).build();
        if (!C0209d.m1227Y1(context, uriBuild) && !NotifyUtil.isTargetAppInWhitelist(context, uriBuild)) {
            C11839m.m70687e(TAG, "deleteSyncData: Target App is not valid");
            return;
        }
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uriBuild);
        try {
            try {
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "deleteSyncData: error: " + e10.toString());
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                }
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                sb2 = new StringBuilder();
            }
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                C11839m.m70687e(TAG, "delete_sync_data: cpClient is null");
                return;
            }
            contentProviderClientAcquireUnstableContentProviderClient.delete(uriBuild, "", null);
            contentProviderClientAcquireUnstableContentProviderClient.close();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            sb2 = new StringBuilder();
            sb2.append("useTime: ");
            sb2.append(jCurrentTimeMillis);
            C10812z.m65843l(context, "delete_end", str, 0, i12, sb2.toString(), str2);
        } finally {
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                contentProviderClientAcquireUnstableContentProviderClient.close();
            }
            C10812z.m65843l(context, "delete_end", str, 0, i12, "useTime: " + (System.currentTimeMillis() - jCurrentTimeMillis2), str2);
        }
    }

    private void genDeleteSyncData(String str) {
        try {
            deleteFrameworkData(this.mContext, str, this.mOption, this.bussinessId);
            C11839m.m70688i(TAG, "genDeleteSyncData end, packageName : " + str + " call provider");
            Uri uri = Uri.parse("content://" + str + ".cloudSync");
            Bundle bundle = new Bundle();
            bundle.putString("syncType", this.syncType);
            bundle.putInt("syncScene", 0);
            this.mContext.getContentResolver().call(uri, "sync_scene_change", (String) null, bundle);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "genDeleteSyncData: call provider sync_scene_change error: " + e10.getMessage());
        }
    }

    @Override // com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteLocalDataBaseTask
    public void deleteSyncData(String str) throws Throwable {
        C11839m.m70688i(TAG, "deleteSyncData, syncType: " + this.syncType + ", mOption = " + this.mOption);
        SyncConfigService serviceById = new SyncConfigOperator().getServiceById(this.syncType);
        if (serviceById == null) {
            C11839m.m70688i(TAG, "syncConfig is null");
            return;
        }
        for (String str2 : serviceById.getApplications()) {
            if (!C0209d.m1221W1(this.mContext, str2)) {
                C11839m.m70687e(TAG, "deleteSyncData, package not support SyncAbility, packageName: " + str2);
            } else {
                if (!NotifyUtil.isFingerPrintEmpty(serviceById) && NotifyUtil.isAppFingerPrintValid(this.mContext, serviceById)) {
                    genDeleteSyncData(str2);
                    return;
                }
                deleteFrameworkData(this.mContext, str2, this.mOption, str);
                C11839m.m70688i(TAG, "deleteSyncData: end");
                if ("provider".equals(serviceById.getNotifyType())) {
                    try {
                        C11839m.m70688i(TAG, "deleteSyncData packageName : " + str2 + " call provider");
                        Uri uri = Uri.parse("content://" + str2 + ".cloudSync");
                        if (C0209d.m1227Y1(this.mContext, uri)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("syncType", this.syncType);
                            bundle.putInt("syncScene", 0);
                            this.mContext.getContentResolver().call(uri, "sync_scene_change", (String) null, bundle);
                        } else {
                            C11839m.m70687e(TAG, "deleteSyncData, TargetApp is not SystemApp");
                        }
                    } catch (Exception e10) {
                        C11839m.m70687e(TAG, "call provider sync_scene_change error: " + e10.getMessage());
                    }
                } else {
                    C11839m.m70688i(TAG, "Send stop sync broadcast");
                    Intent intent = new Intent("com.huawei.android.hicloud.intent.STOPSYNC");
                    intent.putExtra("syncType", this.syncType);
                    C0209d.m1302r2(intent, str2);
                    this.mContext.sendBroadcast(intent, "com.huawei.hicloud.permission.hicloudSync");
                }
            }
        }
    }

    @Override // com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteLocalDataBaseTask
    public void deleteTag() throws Throwable {
        try {
            SyncConfigService serviceById = new SyncConfigOperator().getServiceById(this.syncType);
            if (serviceById != null) {
                for (String str : serviceById.getApplications()) {
                    if (C0209d.m1221W1(this.mContext, str)) {
                        C13153a.m79124j(this.mContext, str);
                    } else {
                        C11839m.m70687e(TAG, "deleteTag, package not support SyncAbility, packageName: " + str);
                    }
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "deleteTag exception = " + e10.toString());
        }
    }
}
