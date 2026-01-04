package com.huawei.android.hicloud.sync.service.aidl.deletetask;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.huawei.android.hicloud.sync.contact.ContactManager;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.util.ArrayList;
import je.C10812z;
import p015ak.C0209d;
import p514o9.C11839m;
import p517oc.C11847b;
import p517oc.C11848c;
import p675uc.C13153a;
import p783xp.C13843a;
import sc.C12769b;
import sc.C12770c;
import sc.C12774g;

/* loaded from: classes3.dex */
public final class DeleteContactLocalDataTask extends DeleteLocalDataBaseTask {
    private static final String TAG = "DeleteContactLocalDataTask";

    public DeleteContactLocalDataTask(Context context, int i10, String str) {
        super(context, i10, str);
    }

    private static void deleteContact(Context context, ContactManager contactManager, int i10, String str) {
        ArrayList<C11847b> arrayListM76635l = new C12769b().m76635l(HNConstants.DataType.CONTACT);
        C11839m.m70688i(TAG, "deleteSyncData: deleteContact list size = " + arrayListM76635l.size());
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i11 = 0;
        for (int i12 = 0; i12 < arrayListM76635l.size() / 100; i12++) {
            ArrayList arrayList = new ArrayList();
            if (arrayListM76635l.size() - i11 < 100) {
                break;
            }
            for (int i13 = 0; i13 < 100; i13++) {
                arrayList.add(arrayListM76635l.get(i11).getLuid());
                i11++;
            }
            contactManager.m17226h(arrayList, true, DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN);
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayListM76635l.size() - i11;
        for (int i14 = 0; i14 < size; i14++) {
            arrayList2.add(arrayListM76635l.get(i11).getLuid());
            i11++;
        }
        C11839m.m70688i(TAG, "deleteContact index = " + i11);
        contactManager.m17226h(arrayList2, true, DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN);
        if (arrayListM76635l.size() > 0) {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            C10812z.m65843l(context, "delete_end", "addressbook", arrayListM76635l.size(), i10, "contact useTime: " + jCurrentTimeMillis2, str);
        }
    }

    public static void deleteContactData(Context context, int i10, String str) {
        if (context == null) {
            C11839m.m70689w(TAG, "deleteSyncData: context is null");
            return;
        }
        int i11 = (102 == i10 || 1 == i10) ? 1 : 2;
        if (C13843a.m83073Y(context)) {
            deleteContactDataForProvider(context, i11, str);
            return;
        }
        if (1 == i11) {
            try {
                ContactManager contactManager = new ContactManager(context);
                deleteContact(context, contactManager, i11, str);
                deleteGroupInfo(context, contactManager, i11, str);
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "deleteLocalData exception = " + e10.toString());
            }
        }
    }

    private static void deleteContactDataForProvider(Context context, int i10, String str) {
        long jCurrentTimeMillis;
        StringBuilder sb2;
        if (context == null) {
            C11839m.m70687e(TAG, "deleteSyncData: provider error : context is null");
            return;
        }
        C11839m.m70688i(TAG, "deleteSyncData: for provider: deleteType = " + i10);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        Uri uriBuild = new Uri.Builder().authority(C13843a.m83095q()).scheme("content").appendPath("delete_sync_data").appendQueryParameter("sync_opt", String.valueOf(i10)).build();
        if (!C0209d.m1227Y1(context, uriBuild)) {
            C11839m.m70687e(TAG, "deleteSyncData, TargetApp is not SystemApp");
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
            C10812z.m65843l(context, "delete_end", "addressbook", 0, i10, sb2.toString(), str);
        } finally {
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                contentProviderClientAcquireUnstableContentProviderClient.close();
            }
            C10812z.m65843l(context, "delete_end", "addressbook", 0, i10, "useTime: " + (System.currentTimeMillis() - jCurrentTimeMillis2), str);
        }
    }

    public static void deleteContactTag() throws Exception {
        C11839m.m70688i(TAG, "deleteTag: deleteContactTag");
        new C12769b().m76630g(HNConstants.DataType.CONTACT);
        new C12774g().m76672g("group");
        C12770c c12770c = new C12770c();
        c12770c.m76637e(HNConstants.DataType.CONTACT);
        c12770c.m76637e("group");
    }

    private static void deleteGroupInfo(Context context, ContactManager contactManager, int i10, String str) {
        ArrayList<C11848c> arrayListM76675j = new C12774g().m76675j("group");
        C11839m.m70688i(TAG, "deleteSyncData: deleteGroupInfo list size = " + arrayListM76675j.size());
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i11 = 0;
        for (int i12 = 0; i12 < arrayListM76675j.size() / 100; i12++) {
            ArrayList arrayList = new ArrayList();
            if (arrayListM76675j.size() - i11 < 100) {
                break;
            }
            for (int i13 = 0; i13 < 100; i13++) {
                arrayList.add(arrayListM76675j.get(i11).getLuid());
                i11++;
            }
            contactManager.m17228j(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayListM76675j.size() - i11;
        for (int i14 = 0; i14 < size; i14++) {
            arrayList2.add(arrayListM76675j.get(i11).getLuid());
            i11++;
        }
        contactManager.m17228j(arrayList2);
        if (arrayListM76675j.size() > 0) {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            C10812z.m65843l(context, "delete_end", "addressbook", arrayListM76675j.size(), i10, "group useTime: " + jCurrentTimeMillis2, str);
        }
    }

    @Override // com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteLocalDataBaseTask
    public void deleteSyncData(String str) {
        C11839m.m70688i(TAG, "deleteSyncData: mOption = " + this.mOption);
        deleteContactData(this.mContext, this.mOption, str);
        C11839m.m70688i(TAG, "deleteSyncData: end");
        if (C13843a.m83073Y(this.mContext)) {
            C11839m.m70688i(TAG, "Send stop sync broadcast");
            if (C0209d.m1277l1()) {
                Intent intent = new Intent("com.hihonor.android.cloudSync.intent.STOPSYNC");
                C0209d.m1302r2(intent, "com.hihonor.contacts.sync");
                intent.putExtra("syncType", "addressbook");
                this.mContext.sendBroadcast(intent, "com.huawei.hicloud.permission.hicloudSync");
                return;
            }
            Intent intent2 = new Intent("com.huawei.android.hicloud.intent.STOPSYNC");
            C0209d.m1302r2(intent2, "com.huawei.contacts.sync");
            intent2.putExtra("syncType", "addressbook");
            this.mContext.sendBroadcast(intent2, "com.huawei.hicloud.permission.hicloudSync");
        }
    }

    @Override // com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteLocalDataBaseTask
    public void deleteTag() {
        try {
            deleteContactTag();
            C13153a.m79121g(this.mContext);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "deleteTag exception = " + e10.toString());
        }
    }
}
