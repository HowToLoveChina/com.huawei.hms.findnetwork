package p736wc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.contact.SyncProcessBase;
import com.huawei.android.hicloud.sync.service.aidl.GenSyncLogicService;
import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import com.huawei.android.hicloud.sync.syncutil.C2980i;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Record;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import fk.C9722c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import je.C10812z;
import p514o9.C11839m;
import p664u0.C13108a;

/* renamed from: wc.c */
/* loaded from: classes3.dex */
public class C13583c extends SyncProcessBase {

    /* renamed from: a */
    public List<String> f61090a;

    /* renamed from: b */
    public final List<Record> f61091b;

    /* renamed from: c */
    public final ArrayList<SyncData> f61092c;

    /* renamed from: d */
    public final HashMap<String, Integer> f61093d;

    /* renamed from: e */
    public final boolean f61094e;

    public C13583c(Context context, String str, String str2, List<String> list, String str3, String str4, String str5, boolean z10, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        super(context, str, str2, str3, str4, str5, concurrentHashMap);
        this.f61090a = new ArrayList();
        this.f61091b = new ArrayList(10);
        this.f61092c = new ArrayList<>(10);
        this.f61093d = new HashMap<>(10);
        if (list != null) {
            this.f61090a = list;
        }
        this.f61094e = z10;
        C11839m.m70688i("GenQueryCloudDataImpl", "Sync type = " + str + ", dataType = " + str2 + ", guid list size = " + this.f61090a.size());
    }

    /* renamed from: a */
    private void m81592a(int i10) {
        C11839m.m70688i("GenQueryCloudDataImpl", "CallBack, value = " + i10);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.GENSENDCALLBACK");
        intent.putExtra("msgType", this.mSyncType);
        intent.putExtra("msgID", 10002);
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putString("sync_module_package_name", this.mSyncModulePackageName);
        appendFailMapToQueryCloud(this.f61094e, bundle, this.f61093d);
        bundle.putParcelableArrayList("cdata", this.f61092c);
        C10812z.m65840i(this.mContext, this.mSyncType, this.mDataType, 0, "", this.operationType, "batch_of_local_download_struct", this.traceId);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.mContext).m78881d(intent);
        CloudSyncUtil.m15993a1(this.mContext, this.mSyncType, i10);
    }

    private void queryCloudDataV2(String str, String str2, List<String> list) throws Throwable {
        String str3;
        String str4;
        int i10;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        int iM60666c;
        String str11 = "recycleSize";
        String str12 = "failList";
        String str13 = "syncV2 all cloud records failed";
        this.f61091b.addAll(getRecordsDataByIdList(str, str2, list, getBatchGetFields(this.mSyncModulePackageName), "getData"));
        C11839m.m70688i("GenQueryCloudDataImpl", "syncV2 totalDataList size: " + this.f61091b.size());
        int i11 = 0;
        try {
            String str14 = "local_download_struct";
            if (this.f61091b.isEmpty()) {
                str3 = "recycleSize";
                str4 = "failList";
                try {
                    str6 = "syncV2 cloud records list is empty";
                } catch (Throwable th2) {
                    th = th2;
                    str6 = "syncV2 cloud records list is empty";
                }
                try {
                    throw new C9722c(2227, str6, this.mSyncType, "local_download_struct");
                } catch (Throwable th3) {
                    th = th3;
                    i10 = 2227;
                    str5 = str6;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("dataType", this.mDataType);
                    linkedHashMap.put("totalSize", String.valueOf(this.f61091b.size()));
                    linkedHashMap.put("sucSize", String.valueOf(this.f61092c.size()));
                    linkedHashMap.put("failSize", String.valueOf(this.f61093d.size()));
                    linkedHashMap.put(str4, this.f61093d.toString());
                    linkedHashMap.put(str3, String.valueOf(i11));
                    linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                    C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, i10, str5, "03001", "getData", this.traceId, linkedHashMap, false);
                    throw th;
                }
            }
            int sdkVersion = GenSyncLogicService.getSdkVersion(this.mSyncModulePackageName);
            Iterator<Record> it = this.f61091b.iterator();
            int i12 = 0;
            while (it.hasNext()) {
                try {
                    try {
                        Record next = it.next();
                        if (next != null) {
                            Iterator<Record> it2 = it;
                            String id2 = next.getId();
                            isCancel();
                            String str15 = str13;
                            try {
                                SyncData syncData = new SyncData();
                                syncData.setGuid(id2);
                                if (next.getVersion() != null) {
                                    try {
                                        str10 = str14;
                                        try {
                                            syncData.setEtag(next.getVersion().toString());
                                        } catch (C9722c e10) {
                                            e = e10;
                                            str8 = str11;
                                            str9 = str12;
                                            C11839m.m70687e("GenQueryCloudDataImpl", "syncV2 totalDataList err: " + e.m60666c() + ", msg:" + e.getMessage() + ", recordId = " + id2);
                                            iM60666c = e.m60666c();
                                            try {
                                                this.f61093d.put(id2, Integer.valueOf(e.m60666c()));
                                                i12 = iM60666c;
                                                it = it2;
                                                str14 = str10;
                                                str13 = str15;
                                                str11 = str8;
                                                str12 = str9;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                str3 = str8;
                                                i10 = iM60666c;
                                                str4 = str9;
                                                str5 = "";
                                                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                                linkedHashMap2.put("dataType", this.mDataType);
                                                linkedHashMap2.put("totalSize", String.valueOf(this.f61091b.size()));
                                                linkedHashMap2.put("sucSize", String.valueOf(this.f61092c.size()));
                                                linkedHashMap2.put("failSize", String.valueOf(this.f61093d.size()));
                                                linkedHashMap2.put(str4, this.f61093d.toString());
                                                linkedHashMap2.put(str3, String.valueOf(i11));
                                                linkedHashMap2.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                                                C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, i10, str5, "03001", "getData", this.traceId, linkedHashMap2, false);
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        i10 = i12;
                                        str3 = str11;
                                        str4 = str12;
                                        str5 = "";
                                        LinkedHashMap linkedHashMap22 = new LinkedHashMap();
                                        linkedHashMap22.put("dataType", this.mDataType);
                                        linkedHashMap22.put("totalSize", String.valueOf(this.f61091b.size()));
                                        linkedHashMap22.put("sucSize", String.valueOf(this.f61092c.size()));
                                        linkedHashMap22.put("failSize", String.valueOf(this.f61093d.size()));
                                        linkedHashMap22.put(str4, this.f61093d.toString());
                                        linkedHashMap22.put(str3, String.valueOf(i11));
                                        linkedHashMap22.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                                        C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, i10, str5, "03001", "getData", this.traceId, linkedHashMap22, false);
                                        throw th;
                                    }
                                } else {
                                    str10 = str14;
                                }
                                syncData.setData(getDecryptData(str, next));
                                if (next.getRecycled().booleanValue()) {
                                    syncData.setRecycleStatus(-1);
                                    if (next.getRecycledTime() != null) {
                                        str8 = str11;
                                        str9 = str12;
                                        try {
                                            try {
                                                syncData.setRecycleTime(next.getRecycledTime().m28458c());
                                            } catch (C9722c e11) {
                                                e = e11;
                                                C11839m.m70687e("GenQueryCloudDataImpl", "syncV2 totalDataList err: " + e.m60666c() + ", msg:" + e.getMessage() + ", recordId = " + id2);
                                                iM60666c = e.m60666c();
                                                this.f61093d.put(id2, Integer.valueOf(e.m60666c()));
                                                i12 = iM60666c;
                                                it = it2;
                                                str14 = str10;
                                                str13 = str15;
                                                str11 = str8;
                                                str12 = str9;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            str3 = str8;
                                            str4 = str9;
                                            str5 = "";
                                            i10 = i12;
                                            LinkedHashMap linkedHashMap222 = new LinkedHashMap();
                                            linkedHashMap222.put("dataType", this.mDataType);
                                            linkedHashMap222.put("totalSize", String.valueOf(this.f61091b.size()));
                                            linkedHashMap222.put("sucSize", String.valueOf(this.f61092c.size()));
                                            linkedHashMap222.put("failSize", String.valueOf(this.f61093d.size()));
                                            linkedHashMap222.put(str4, this.f61093d.toString());
                                            linkedHashMap222.put(str3, String.valueOf(i11));
                                            linkedHashMap222.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                                            C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, i10, str5, "03001", "getData", this.traceId, linkedHashMap222, false);
                                            throw th;
                                        }
                                    } else {
                                        str8 = str11;
                                        str9 = str12;
                                    }
                                    i11++;
                                } else {
                                    str8 = str11;
                                    str9 = str12;
                                    syncData.setRecycleStatus(2);
                                }
                                syncData.setVersion(sdkVersion);
                                syncData.setUnstructUuid(id2);
                                if (sdkVersion >= 107) {
                                    String decryptExtensionData = getDecryptExtensionData(str, next);
                                    if (!TextUtils.isEmpty(decryptExtensionData)) {
                                        syncData.setExtensionData(decryptExtensionData);
                                    }
                                }
                                this.f61092c.add(syncData);
                            } catch (C9722c e12) {
                                e = e12;
                                str10 = str14;
                            }
                            it = it2;
                            str14 = str10;
                            str13 = str15;
                            str11 = str8;
                            str12 = str9;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        str8 = str11;
                        str9 = str12;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    str3 = str11;
                    str4 = str12;
                }
            }
            String str16 = str14;
            String str17 = str11;
            String str18 = str12;
            String str19 = str13;
            try {
                if (this.f61092c.isEmpty()) {
                    str3 = str17;
                    str4 = str18;
                    try {
                        C11839m.m70687e("GenQueryCloudDataImpl", "syncV2 all cloud records failed, code = " + i12);
                        str7 = str19;
                    } catch (Throwable th9) {
                        th = th9;
                        str7 = str19;
                    }
                    try {
                        throw new C9722c(i12, str7, this.mSyncType, str16);
                    } catch (Throwable th10) {
                        th = th10;
                        str5 = str7;
                        i10 = i12;
                        LinkedHashMap linkedHashMap2222 = new LinkedHashMap();
                        linkedHashMap2222.put("dataType", this.mDataType);
                        linkedHashMap2222.put("totalSize", String.valueOf(this.f61091b.size()));
                        linkedHashMap2222.put("sucSize", String.valueOf(this.f61092c.size()));
                        linkedHashMap2222.put("failSize", String.valueOf(this.f61093d.size()));
                        linkedHashMap2222.put(str4, this.f61093d.toString());
                        linkedHashMap2222.put(str3, String.valueOf(i11));
                        linkedHashMap2222.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                        C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, i10, str5, "03001", "getData", this.traceId, linkedHashMap2222, false);
                        throw th;
                    }
                }
                if (this.f61093d.isEmpty()) {
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    linkedHashMap3.put("dataType", this.mDataType);
                    linkedHashMap3.put("totalSize", String.valueOf(this.f61091b.size()));
                    linkedHashMap3.put("sucSize", String.valueOf(this.f61092c.size()));
                    linkedHashMap3.put("failSize", String.valueOf(this.f61093d.size()));
                    linkedHashMap3.put(str18, this.f61093d.toString());
                    linkedHashMap3.put(str17, String.valueOf(i11));
                    linkedHashMap3.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                    C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, i12, "", "03001", "getData", this.traceId, linkedHashMap3, false);
                    return;
                }
                str3 = str17;
                str4 = str18;
                try {
                    throw new C9722c(i12, "syncV2 cloud records partical success", this.mSyncType, str16);
                } catch (Throwable th11) {
                    th = th11;
                    i10 = i12;
                    str5 = "";
                    LinkedHashMap linkedHashMap22222 = new LinkedHashMap();
                    linkedHashMap22222.put("dataType", this.mDataType);
                    linkedHashMap22222.put("totalSize", String.valueOf(this.f61091b.size()));
                    linkedHashMap22222.put("sucSize", String.valueOf(this.f61092c.size()));
                    linkedHashMap22222.put("failSize", String.valueOf(this.f61093d.size()));
                    linkedHashMap22222.put(str4, this.f61093d.toString());
                    linkedHashMap22222.put(str3, String.valueOf(i11));
                    linkedHashMap22222.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                    C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, i10, str5, "03001", "getData", this.traceId, linkedHashMap22222, false);
                    throw th;
                }
            } catch (Throwable th12) {
                th = th12;
                str3 = str17;
                str4 = str18;
            }
        } catch (Throwable th13) {
            th = th13;
            str3 = "recycleSize";
            str4 = "failList";
            i10 = 0;
        }
        LinkedHashMap linkedHashMap222222 = new LinkedHashMap();
        linkedHashMap222222.put("dataType", this.mDataType);
        linkedHashMap222222.put("totalSize", String.valueOf(this.f61091b.size()));
        linkedHashMap222222.put("sucSize", String.valueOf(this.f61092c.size()));
        linkedHashMap222222.put("failSize", String.valueOf(this.f61093d.size()));
        linkedHashMap222222.put(str4, this.f61093d.toString());
        linkedHashMap222222.put(str3, String.valueOf(i11));
        linkedHashMap222222.putAll(C10812z.m65833b(this.mSyncModulePackageName));
        C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, i10, str5, "03001", "getData", this.traceId, linkedHashMap222222, false);
        throw th;
    }

    /* renamed from: b */
    public int m81593b() {
        List<String> list;
        String message = "";
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iM60666c = 0;
        try {
            try {
                list = this.f61090a;
            } catch (C9722c e10) {
                iM60666c = e10.m60666c();
                message = e10.getMessage();
                C10812z.m65841j(this.mContext, e10.m60668e(), this.mDataType, e10.m60666c(), e10.m60667d(), e10.getMessage(), this.operationType, e10.m60665b(), this.traceId);
            } catch (Exception e11) {
                iM60666c = 5;
                message = e11.getMessage();
                C11839m.m70687e("GenQueryCloudDataImpl", "Exception occurred , e = " + e11.toString());
                C10812z.m65840i(this.mContext, this.mSyncType, this.mDataType, 5, e11.toString(), this.operationType, "local_download_struct", this.traceId);
            }
            if (list != null && list.size() != 0) {
                C11839m.m70688i("GenQueryCloudDataImpl", "syncV2 cloudDataList dataType: " + this.mDataType);
                isCancel();
                queryCloudDataV2(this.mSyncType, this.mDataType, this.f61090a);
                C11839m.m70688i("GenQueryCloudDataImpl", "syncV2 cloudDataList dataType: " + this.mDataType + ", sucSize  = " + this.f61092c.size() + ", failSize = " + this.f61093d.size());
                return iM60666c;
            }
            C11839m.m70689w("GenQueryCloudDataImpl", "Guid list is null or empty");
            return 0;
        } finally {
            m81592a(0);
            C2980i.m17879n(this.mReportEndInfo, 0, "");
            C2980i.m17872g(this.mReportEndInfo, this.mDataType, this.f61092c.size());
            C2980i.m17874i(this.mReportEndInfo, this.mDataType, System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }
}
