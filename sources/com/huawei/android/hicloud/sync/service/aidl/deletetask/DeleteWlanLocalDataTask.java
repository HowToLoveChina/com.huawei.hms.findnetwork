package com.huawei.android.hicloud.sync.service.aidl.deletetask;

import android.content.Context;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.wifi.datamanager.SyncWlanBean;
import com.huawei.android.hicloud.sync.wifi.datamanager.WlanManager;
import java.util.ArrayList;
import java.util.Iterator;
import je.C10812z;
import p514o9.C11839m;
import sc.C12770c;
import sc.C12777j;

/* loaded from: classes3.dex */
public final class DeleteWlanLocalDataTask extends DeleteLocalDataBaseTask {
    private static final String TAG = "DeleteWlanLocalDataTask";

    public DeleteWlanLocalDataTask(Context context, int i10, String str) {
        super(context, i10, str);
    }

    public static void deleteWlanData(Context context, int i10, String str) {
        if (context == null) {
            C11839m.m70689w(TAG, "deleteSyncData: context is null");
            return;
        }
        int i11 = (102 == i10 || 1 == i10) ? 1 : 2;
        C11839m.m70688i(TAG, "deleteSyncData: deleteType = " + i11);
        if (1 != i11) {
            return;
        }
        try {
            ArrayList<SyncWlanBean> arrayListM76690j = new C12777j().m76690j("wlan");
            ArrayList arrayList = new ArrayList();
            Iterator<SyncWlanBean> it = arrayListM76690j.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getLuid());
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            new WlanManager(context).deleteData(arrayList, true);
            new C12770c().m76637e("wlan");
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            C10812z.m65843l(context, "delete_end", "wlan", arrayListM76690j.size(), i11, "useTime: " + jCurrentTimeMillis2, str);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "deleteSyncData: deleteTag error: " + e10.toString());
        }
    }

    public static void deleteWlanTag() {
        C11839m.m70688i(TAG, "deleteTag: deleteWlanTag");
        try {
            new C12777j().m76687g("wlan");
            new C12770c().m76637e("wlan");
            CloudSyncUtil.m16048t("wlannotAllSucess");
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "deleteTag error: " + e10.toString());
        }
    }

    @Override // com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteLocalDataBaseTask
    public void deleteSyncData(String str) {
        C11839m.m70688i(TAG, "deleteSyncData: mOption = " + this.mOption);
        deleteWlanData(this.mContext, this.mOption, str);
        C11839m.m70688i(TAG, "deleteSyncData: end");
    }

    @Override // com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteLocalDataBaseTask
    public void deleteTag() {
        deleteWlanTag();
    }
}
