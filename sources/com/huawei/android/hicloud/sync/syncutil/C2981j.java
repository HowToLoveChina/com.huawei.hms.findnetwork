package com.huawei.android.hicloud.sync.syncutil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.android.hicloud.sync.service.aidl.FileDownloadProgress;
import com.huawei.android.hicloud.sync.service.aidl.SerializableMap;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicService;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicServiceUtil;
import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p514o9.C11839m;
import p664u0.C13108a;

/* renamed from: com.huawei.android.hicloud.sync.syncutil.j */
/* loaded from: classes3.dex */
public class C2981j {

    /* renamed from: a */
    public static final Map<String, Map<String, Integer>> f13020a = new HashMap();

    /* renamed from: a */
    public static int m17887a(String str, String str2) {
        Integer num;
        Map<String, Integer> map = f13020a.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 0;
        }
        C11839m.m70688i("RequireSyncModelUtil", str2 + " syncModel = " + num);
        return num.intValue();
    }

    /* renamed from: b */
    public static boolean m17888b(String str, String str2) {
        boolean z10 = SyncLogicService.getSdkVersion(str) >= 107;
        boolean z11 = m17887a(str, str2) >= 1;
        C11839m.m70688i("RequireSyncModelUtil", "isSupportRequire " + str2 + ": versionCode = " + z10 + ", syncModel = " + z11);
        return z10 && z11;
    }

    /* renamed from: c */
    public static void m17889c(Context context, String str, String str2, String str3, UnstructData unstructData, String str4) {
        C11839m.m70688i("RequireSyncModelUtil", "processDownLoadFileAborted fileName = " + unstructData.getName());
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.REQUIREDOWNLOADCALLBACK");
        intent.putExtra("msgType", str);
        intent.putExtra("msgID", 10025);
        Bundle bundle = new Bundle();
        bundle.putString("callbackUuid", str4);
        bundle.putString("syncType", str);
        bundle.putString("dataType", str2);
        bundle.putString("sync_module_package_name", str3);
        bundle.putParcelable("down_file_data", unstructData);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(context).m78881d(intent);
    }

    /* renamed from: d */
    public static void m17890d(Context context, String str, String str2, String str3, ArrayList<String> arrayList, Map<String, Integer> map, String str4, String str5) {
        C11839m.m70688i("RequireSyncModelUtil", "processDownLoadFileCompelete");
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.REQUIREDOWNLOADCALLBACK");
        intent.putExtra("msgType", str);
        intent.putExtra("msgID", 10021);
        Bundle bundle = new Bundle();
        bundle.putString("callbackUuid", str5);
        bundle.putString("syncType", str);
        bundle.putString("dataType", str2);
        bundle.putString("session_id", str4);
        bundle.putString("sync_module_package_name", str3);
        bundle.putStringArrayList("down_file_success_list", arrayList);
        SerializableMap serializableMap = new SerializableMap();
        serializableMap.setMap(SyncLogicServiceUtil.buildFailErrorCodeMap(map));
        bundle.putSerializable("down_file_fail_map", serializableMap);
        C11839m.m70686d("RequireSyncModelUtil", "failIdMap : " + map.toString());
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(context).m78881d(intent);
    }

    /* renamed from: e */
    public static void m17891e(Context context, String str, String str2, String str3, UnstructData unstructData, int i10, String str4) {
        C11839m.m70688i("RequireSyncModelUtil", "processDownLoadFileFail fileName = " + unstructData.getName() + ", errorCode = " + i10);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.REQUIREDOWNLOADCALLBACK");
        intent.putExtra("msgType", str);
        intent.putExtra("msgID", 10020);
        Bundle bundle = new Bundle();
        bundle.putString("callbackUuid", str4);
        bundle.putString("syncType", str);
        bundle.putString("dataType", str2);
        bundle.putInt("down_file_error_code", i10);
        bundle.putString("sync_module_package_name", str3);
        bundle.putParcelable("down_file_data", unstructData);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(context).m78881d(intent);
    }

    /* renamed from: f */
    public static void m17892f(Context context, String str, String str2, String str3, long j10, long j11, String str4, UnstructData unstructData, String str5) {
        C11839m.m70688i("RequireSyncModelUtil", "processDownLoadFileProgress dataType = " + str2 + ", recordId = " + str4 + ", fileName = " + unstructData.getName() + ", increase = " + j10 + ", total = " + j11);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.REQUIREDOWNLOADCALLBACK");
        intent.putExtra("msgType", str);
        intent.putExtra("msgID", 10018);
        Bundle bundle = new Bundle();
        bundle.putString("callbackUuid", str5);
        bundle.putString("syncType", str);
        bundle.putString("dataType", str2);
        bundle.putString("sync_module_package_name", str3);
        FileDownloadProgress fileDownloadProgress = new FileDownloadProgress();
        fileDownloadProgress.setAlreadyLoadSize(j10);
        fileDownloadProgress.setFileSize(j11);
        fileDownloadProgress.setProgress((j10 / j11) * 100);
        fileDownloadProgress.setDataType(str2);
        fileDownloadProgress.setSyncType(str);
        fileDownloadProgress.setGuid(str4);
        fileDownloadProgress.setId(unstructData.getId());
        fileDownloadProgress.setName(unstructData.getName());
        bundle.putParcelable("down_file_progress_data", fileDownloadProgress);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(context).m78881d(intent);
    }

    /* renamed from: g */
    public static void m17893g(Context context, String str, String str2, String str3, UnstructData unstructData, String str4) {
        C11839m.m70688i("RequireSyncModelUtil", "processDownLoadFileSucess fileName = " + unstructData.getName());
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.REQUIREDOWNLOADCALLBACK");
        intent.putExtra("msgType", str);
        intent.putExtra("msgID", 10019);
        Bundle bundle = new Bundle();
        bundle.putString("callbackUuid", str4);
        bundle.putString("syncType", str);
        bundle.putString("dataType", str2);
        bundle.putString("sync_module_package_name", str3);
        bundle.putParcelable("down_file_data", unstructData);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(context).m78881d(intent);
    }

    /* renamed from: h */
    public static void m17894h(Context context, String str, String str2, String str3, UnstructData unstructData, int i10, String str4) {
        if (6000 == i10) {
            m17889c(context, str, str2, str3, unstructData, str4);
        } else {
            m17891e(context, str, str2, str3, unstructData, i10, str4);
        }
    }

    /* renamed from: i */
    public static void m17895i(String str) {
        f13020a.remove(str);
    }

    /* renamed from: j */
    public static void m17896j(String str, String str2, int i10) {
        C11839m.m70688i("RequireSyncModelUtil", "dataType = " + str2 + ", setSyncModel = " + i10);
        Map<String, Map<String, Integer>> map = f13020a;
        Map<String, Integer> map2 = map.get(str);
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        map2.put(str2, Integer.valueOf(i10));
        map.put(str, map2);
    }
}
