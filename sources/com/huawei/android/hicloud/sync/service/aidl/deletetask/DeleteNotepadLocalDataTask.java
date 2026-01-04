package com.huawei.android.hicloud.sync.service.aidl.deletetask;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.android.hicloud.sync.service.aidl.SerializableMap;
import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import je.C10812z;
import p015ak.C0209d;
import p514o9.C11839m;
import p675uc.C13153a;
import p783xp.C13843a;
import sc.C12770c;
import sc.C12771d;
import sc.C12773f;

/* loaded from: classes3.dex */
public final class DeleteNotepadLocalDataTask extends DeleteLocalDataBaseTask {
    private static final String METHOD_NAME = "notepad_cloud_STOPSYNC";
    private static final String TAG = "DeleteNotepadLocalDataTask";
    private String bussinessId;

    public DeleteNotepadLocalDataTask(Context context, int i10, String str) {
        super(context, i10, str);
    }

    public static void deleteNotePadTag() throws Exception {
        C11839m.m70688i(TAG, "deleteTag: deleteNotePadTag");
        C12773f c12773f = new C12773f();
        c12773f.m76665g("note");
        c12773f.m76665g("shorthand");
        C12771d c12771d = new C12771d();
        c12771d.m76645g("note");
        c12771d.m76645g("notetag");
        c12771d.m76645g("shorthand");
        C12770c c12770c = new C12770c();
        c12770c.m76637e("note");
        c12770c.m76637e("notetag");
        c12770c.m76637e("shorthand");
    }

    private static void deleteNotepad(Context context, int i10, String str) {
        SerializableMap serializableMap = new SerializableMap();
        C12771d c12771d = new C12771d();
        ArrayList<SyncData> arrayListM76650l = c12771d.m76650l("note");
        ArrayList arrayList = new ArrayList();
        Iterator<SyncData> it = arrayListM76650l.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getLuid());
        }
        C11839m.m70686d(TAG, "deleteSyncData: noteId list = " + arrayList.toString());
        ArrayList<SyncData> arrayListM76650l2 = c12771d.m76650l("notetag");
        ArrayList arrayList2 = new ArrayList();
        Iterator<SyncData> it2 = arrayListM76650l2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().getLuid());
        }
        C11839m.m70686d(TAG, "deleteSyncData: noteTag id list = " + arrayList2.toString());
        ArrayList<SyncData> arrayListM76650l3 = c12771d.m76650l("shorthand");
        ArrayList arrayList3 = new ArrayList();
        Iterator<SyncData> it3 = arrayListM76650l3.iterator();
        while (it3.hasNext()) {
            arrayList3.add(it3.next().getLuid());
        }
        C11839m.m70686d(TAG, "deleteSyncData: shorthand list = " + arrayList3.toString());
        HashMap map = new HashMap();
        map.put("note", arrayList);
        map.put("notetag", arrayList2);
        map.put("shorthand", arrayList3);
        serializableMap.setMap(map);
        C11839m.m70686d(TAG, "deleteSyncData: Send broadCast to delete notepad");
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bundle bundle = new Bundle();
        bundle.putSerializable("deleteData", serializableMap);
        Bundle bundleDeleteNotepadData = deleteNotepadData(context, bundle);
        C10812z.m65843l(context, "delete_end", "notepad", 0, i10, "old note,tag,shorthand size:" + arrayList.size() + "," + arrayList2.size() + "," + arrayList3.size() + ";useTime: " + (System.currentTimeMillis() - jCurrentTimeMillis), str);
        if (bundleDeleteNotepadData == null) {
            C11839m.m70687e(TAG, "deleteSyncData: return null");
            return;
        }
        Object obj = bundleDeleteNotepadData.get("deleteSyncData: delete_total_count");
        int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        Object obj2 = bundleDeleteNotepadData.get("deleteSyncData: delete_sucess_count");
        C11839m.m70688i(TAG, "deleteSyncData: result ,totalNum = " + iIntValue + " , sucNum = " + (obj2 instanceof Integer ? ((Integer) obj2).intValue() : 0));
    }

    public static void deleteNotepadData(Context context, String str, int i10, String str2) {
        if (context == null) {
            C11839m.m70689w(TAG, "deleteSyncData: context is null");
            return;
        }
        int i11 = (102 == i10 || 1 == i10) ? 1 : 2;
        int iM1304s0 = C0209d.m1304s0(context, str);
        C11839m.m70688i(TAG, "deleteSyncData: packageName = " + str + ", sdkVersion = " + iM1304s0 + ", deleteType = " + i11);
        if (iM1304s0 >= 100) {
            deleteNotepadDataForProvider(context, i11, str2);
        } else if (1 == i11) {
            deleteNotepad(context, i11, str2);
        }
    }

    private static void deleteNotepadDataForProvider(Context context, int i10, String str) {
        long jCurrentTimeMillis;
        StringBuilder sb2;
        String strM83052D = C13843a.m83052D();
        if (context == null) {
            C11839m.m70687e(TAG, "deleteSyncData: provider: context is null");
            return;
        }
        C11839m.m70688i(TAG, "deleteSyncData: provider deleteType = " + i10 + ", packageName = " + strM83052D);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        Uri uriBuild = new Uri.Builder().authority(strM83052D).scheme("content").appendPath("delete_sync_data").appendQueryParameter("sync_opt", String.valueOf(i10)).build();
        if (!C0209d.m1227Y1(context, uriBuild)) {
            C11839m.m70687e(TAG, "deleteSyncData, TargetApp is not SystemApp");
            return;
        }
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uriBuild);
        try {
            try {
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "deleteSyncData: provider error: " + e10.toString());
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
            sb2.append("new useTime: ");
            sb2.append(jCurrentTimeMillis);
            C10812z.m65843l(context, "delete_end", "notepad", 0, i10, sb2.toString(), str);
        } finally {
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                contentProviderClientAcquireUnstableContentProviderClient.close();
            }
            C10812z.m65843l(context, "delete_end", "notepad", 0, i10, "new useTime: " + (System.currentTimeMillis() - jCurrentTimeMillis2), str);
        }
    }

    @Override // com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteLocalDataBaseTask
    public void deleteSyncData(String str) {
        C11839m.m70688i(TAG, "deleteSyncData: mOption = " + this.mOption);
        String strM83050B = C13843a.m83050B(this.mContext);
        C11839m.m70688i(TAG, "notepad package name: " + strM83050B);
        C11839m.m70688i(TAG, "Send stop sync broadcast");
        Intent intent = new Intent(C13843a.m83063O("notepad"));
        C0209d.m1302r2(intent, strM83050B);
        intent.putExtra("syncType", "notepad");
        this.mContext.sendBroadcast(intent, "com.huawei.hicloud.permission.hicloudSync");
        deleteNotepadData(this.mContext, strM83050B, this.mOption, str);
        C11839m.m70688i(TAG, "deleteSyncData: end");
    }

    @Override // com.huawei.android.hicloud.sync.service.aidl.deletetask.DeleteLocalDataBaseTask
    public void deleteTag() {
        try {
            deleteNotePadTag();
            C13153a.m79127m(this.mContext);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "deleteTag: exception = " + e10.toString());
        }
    }

    private static Bundle deleteNotepadData(Context context, Bundle bundle) {
        C11839m.m70688i(TAG, "deleteSyncData: Delete notepad data");
        if (!C0209d.m1227Y1(context, C13843a.m83051C())) {
            C11839m.m70687e(TAG, "TargetApp is not SystemApp");
            return null;
        }
        try {
            if (!C0209d.m1227Y1(context, C13843a.m83051C())) {
                C11839m.m70687e(TAG, "deleteNotepadData, TargetApp is not SystemApp");
                return null;
            }
            return context.getContentResolver().call(C13843a.m83051C(), METHOD_NAME, (String) null, bundle);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "deleteSyncData: delete error: " + e10.toString());
            return null;
        }
    }
}
