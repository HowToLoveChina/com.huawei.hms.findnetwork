package com.huawei.android.hicloud.sync.service.aidl.deletetask;

import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import je.C10812z;
import p015ak.C0209d;
import p514o9.C11839m;
import p675uc.C13153a;
import p783xp.C13843a;
import sc.C12770c;
import sc.C12771d;

/* loaded from: classes3.dex */
public final class DeleteCalendarLocalDataTask extends DeleteLocalDataBaseTask {
    private static final String TAG = "DeleteCalendarLocalDataTask";
    private static final long WAIT_TIME_OUT = 1800000;
    private static volatile ExecutorService executor;
    private String bussinessId;

    public static class DeleteCalendarDataTask implements Callable<String> {
        String bussinessId;
        Context context;
        int mDeleteType;

        public DeleteCalendarDataTask(Context context, int i10, String str) {
            this.context = context;
            this.mDeleteType = i10;
            this.bussinessId = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            return String.valueOf(DeleteCalendarLocalDataTask.deleteLocalData(this.context, this.mDeleteType, this.bussinessId));
        }
    }

    public DeleteCalendarLocalDataTask(Context context, int i10, String str) {
        super(context, i10, str);
    }

    private static int applyBatch(Context context, ArrayList<ContentProviderOperation> arrayList) throws Exception {
        ContentProviderResult[] contentProviderResultArrApplyBatch = context.getContentResolver().applyBatch("com.android.calendar", arrayList);
        if (contentProviderResultArrApplyBatch.length == 0) {
            return 0;
        }
        int iIntValue = 0;
        for (ContentProviderResult contentProviderResult : contentProviderResultArrApplyBatch) {
            iIntValue += contentProviderResult.count.intValue();
        }
        return iIntValue;
    }

    public static void deleteCalendarData(Context context, int i10, String str) {
        if (context == null) {
            C11839m.m70689w(TAG, "deleteSyncData: context is null");
            return;
        }
        int i11 = (102 == i10 || 1 == i10) ? 1 : 2;
        int iM1304s0 = C0209d.m1304s0(context, "com.android.providers.calendar");
        C11839m.m70688i(TAG, "deleteSyncData: packageName = com.android.providers.calendar, sdkVersion = " + iM1304s0 + ", deleteType = " + i11);
        if (iM1304s0 >= 100) {
            deleteCalendarDataForProvider(context, i11, str);
            return;
        }
        if (1 == i11) {
            if (executor == null) {
                executor = Executors.newSingleThreadExecutor();
            }
            try {
                try {
                    C11839m.m70688i(TAG, "deleteSyncData: result = " + ((String) executor.submit(new DeleteCalendarDataTask(context, i11, str)).get(1800000L, TimeUnit.MILLISECONDS)));
                } catch (Exception e10) {
                    C11839m.m70687e(TAG, "deleteSyncData: exception = " + e10.toString());
                    if (executor != null) {
                    }
                }
                if (executor != null) {
                    executor.shutdown();
                    executor = null;
                }
            } catch (Throwable th2) {
                if (executor != null) {
                    executor.shutdown();
                    executor = null;
                }
                throw th2;
            }
        }
    }

    private static void deleteCalendarDataForProvider(Context context, int i10, String str) {
        long jCurrentTimeMillis;
        StringBuilder sb2;
        if (context == null) {
            C11839m.m70687e(TAG, "deleteSyncData: provider error : context is null");
            return;
        }
        C11839m.m70688i(TAG, "deleteSyncData calendar: for provider: deleteType = " + i10);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        Uri uriBuild = new Uri.Builder().authority("com.android.providers.calendar.cloudSync").scheme("content").appendPath("delete_sync_data").appendQueryParameter("sync_opt", String.valueOf(i10)).build();
        if (!C0209d.m1227Y1(context, uriBuild)) {
            C11839m.m70687e(TAG, "deleteSyncData, TargetApp is not SystemApp");
            return;
        }
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uriBuild);
        try {
            try {
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "deleteSyncData calendar: error: " + e10.toString());
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
            C10812z.m65843l(context, "delete_end", "calendar", 0, i10, sb2.toString(), str);
        } finally {
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                contentProviderClientAcquireUnstableContentProviderClient.close();
            }
            C10812z.m65843l(context, "delete_end", "calendar", 0, i10, "useTime: " + (System.currentTimeMillis() - jCurrentTimeMillis2), str);
        }
    }

    public static void deleteCalendarTag() throws Exception {
        C11839m.m70688i(TAG, "deleteTag: deleteCalendarTag");
        C12771d c12771d = new C12771d();
        c12771d.m76645g("calendar");
        c12771d.m76645g("calendareventarc");
        c12771d.m76645g("calendarmeta");
        c12771d.m76645g("eventattach");
        C12770c c12770c = new C12770c();
        c12770c.m76637e("calendar");
        c12770c.m76637e("calendareventarc");
        c12770c.m76637e("calendarmeta");
        c12771d.m76645g("eventattach");
    }

    public static int deleteLocalData(Context context, int i10, String str) throws Exception {
        ArrayList<SyncData> arrayListM76650l = new C12771d().m76650l("calendar");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (arrayListM76650l.size() > 0) {
            C10812z.m65843l(context, "delete_begin", "calendar", arrayListM76650l.size(), i10, "beginTime: " + jCurrentTimeMillis, str);
        }
        C11839m.m70688i(TAG, "calendar etag size: " + arrayListM76650l.size());
        Uri uri = Uri.parse("content://com.android.calendar/hw_sync_support");
        int iApplyBatch = 0;
        if (!C0209d.m1227Y1(context, uri)) {
            C11839m.m70687e(TAG, "TargetApp is not SystemApp");
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<SyncData> it = arrayListM76650l.iterator();
        while (it.hasNext()) {
            arrayList.add(ContentProviderOperation.newDelete(uri.buildUpon().appendPath(it.next().getLuid()).build()).build());
            if (arrayList.size() >= 100) {
                iApplyBatch += applyBatch(context, arrayList);
                arrayList.clear();
            }
        }
        if (arrayList.size() > 0) {
            iApplyBatch += applyBatch(context, arrayList);
            arrayList.clear();
        }
        int i11 = iApplyBatch;
        if (arrayListM76650l.size() > 0) {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            C10812z.m65843l(context, "delete_end", "calendar", arrayListM76650l.size(), i10, "useTime: " + jCurrentTimeMillis2, str);
        }
        return i11;
    }

    @Override // com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteLocalDataBaseTask
    public void deleteSyncData(String str) {
        C11839m.m70688i(TAG, "deleteSyncData: mOption = " + this.mOption);
        deleteCalendarData(this.mContext, this.mOption, str);
        C11839m.m70688i(TAG, "deleteSyncData: end");
        C11839m.m70688i(TAG, "Send stop sync broadcast");
        Intent intent = new Intent(C13843a.m83063O("calendar"));
        C0209d.m1302r2(intent, "com.android.providers.calendar");
        intent.putExtra("syncType", "calendar");
        this.mContext.sendBroadcast(intent, "com.huawei.hicloud.permission.hicloudSync");
    }

    @Override // com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteLocalDataBaseTask
    public void deleteTag() {
        try {
            deleteCalendarTag();
            C13153a.m79119e(this.mContext);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "deleteTag: exception = " + e10.toString());
        }
    }
}
