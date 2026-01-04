package p736wc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.contact.C2878c;
import com.huawei.android.hicloud.sync.service.aidl.GenSyncLogicService;
import com.huawei.android.hicloud.sync.service.aidl.SerializableMap;
import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicServiceUtil;
import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import com.huawei.android.hicloud.sync.syncutil.C2977f;
import com.huawei.android.hicloud.sync.syncutil.C2980i;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Attachment;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRet;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Record;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import fk.C9722c;
import gp.C10028c;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import je.C10812z;
import p015ak.C0209d;
import p514o9.C11839m;
import p572qb.C12329u;
import p664u0.C13108a;
import sc.C12772e;
import tc.C13007b;

/* renamed from: wc.g */
/* loaded from: classes3.dex */
public class C13587g extends C2878c {

    /* renamed from: D */
    public static long f61120D;

    /* renamed from: A */
    public ArrayList<String> f61121A;

    /* renamed from: B */
    public ArrayList<String> f61122B;

    /* renamed from: C */
    public ExecutorService f61123C;

    /* renamed from: u */
    public C12329u f61124u;

    /* renamed from: v */
    public final CopyOnWriteArrayList<FailRet> f61125v;

    /* renamed from: w */
    public final CopyOnWriteArrayList<FailRet> f61126w;

    /* renamed from: x */
    public final ConcurrentHashMap<String, Integer> f61127x;

    /* renamed from: y */
    public final ConcurrentHashMap<String, Integer> f61128y;

    /* renamed from: z */
    public int f61129z;

    /* renamed from: wc.g$a */
    public class a implements Callable<Record> {

        /* renamed from: a */
        public Record f61130a;

        public a(Record record) {
            this.f61130a = record;
        }

        /*  JADX ERROR: Type inference failed
            jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
            */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.huawei.android.hicloud.syncdrive.cloudsync.model.Record call() throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 2975
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p736wc.C13587g.a.call():com.huawei.android.hicloud.syncdrive.cloudsync.model.Record");
        }
    }

    /* renamed from: wc.g$b */
    public class b implements Callable<Record> {

        /* renamed from: a */
        public Record f61132a;

        public b(Record record) {
            this.f61132a = record;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:398:0x0969  */
        /* JADX WARN: Removed duplicated region for block: B:415:0x0a2d  */
        /* JADX WARN: Removed duplicated region for block: B:427:0x0a65  */
        /* JADX WARN: Type inference failed for: r15v22, types: [java.util.HashMap, java.util.Map] */
        /* JADX WARN: Type inference failed for: r16v10 */
        /* JADX WARN: Type inference failed for: r16v11 */
        /* JADX WARN: Type inference failed for: r16v12 */
        /* JADX WARN: Type inference failed for: r16v13 */
        /* JADX WARN: Type inference failed for: r16v17 */
        /* JADX WARN: Type inference failed for: r16v18 */
        /* JADX WARN: Type inference failed for: r16v21 */
        /* JADX WARN: Type inference failed for: r16v22 */
        /* JADX WARN: Type inference failed for: r16v26 */
        /* JADX WARN: Type inference failed for: r16v27 */
        /* JADX WARN: Type inference failed for: r16v3, types: [com.huawei.android.hicloud.syncdrive.cloudsync.model.Attachment] */
        /* JADX WARN: Type inference failed for: r16v4 */
        /* JADX WARN: Type inference failed for: r16v5 */
        /* JADX WARN: Type inference failed for: r16v8 */
        /* JADX WARN: Type inference failed for: r16v9 */
        /* JADX WARN: Type inference failed for: r36v0, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r8v104 */
        /* JADX WARN: Type inference failed for: r8v105 */
        /* JADX WARN: Type inference failed for: r8v54, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r8v55 */
        /* JADX WARN: Type inference failed for: r8v64 */
        /* JADX WARN: Type inference failed for: r9v32, types: [java.util.List] */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.huawei.android.hicloud.syncdrive.cloudsync.model.Record call() throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 2687
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p736wc.C13587g.b.call():com.huawei.android.hicloud.syncdrive.cloudsync.model.Record");
        }
    }

    public C13587g(Context context, String str, String str2, ArrayList<SyncData> arrayList, ArrayList<SyncData> arrayList2, ArrayList<SyncData> arrayList3, ArrayList<UnstructData> arrayList4, ArrayList<String> arrayList5, boolean z10, String str3, String str4, String str5, C12329u c12329u, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        super(context, str, str2, str3, str4, str5, concurrentHashMap);
        this.f61124u = null;
        this.f61125v = new CopyOnWriteArrayList<>();
        this.f61126w = new CopyOnWriteArrayList<>();
        this.f61127x = new ConcurrentHashMap<>();
        this.f61128y = new ConcurrentHashMap<>();
        this.f61129z = -1;
        this.f61121A = new ArrayList<>();
        this.f61122B = new ArrayList<>();
        if (arrayList != null) {
            this.f12823k = arrayList;
        }
        if (arrayList2 != null) {
            this.f12822j = arrayList2;
        }
        if (arrayList5 != null) {
            this.f12826n = arrayList5;
        }
        if (arrayList3 != null) {
            this.f12825m = arrayList3;
        }
        if (c12329u != null) {
            this.f61124u = c12329u;
        }
        this.f12821i = z10;
        this.f12813a = this.mContext.getFilesDir() + "/sync/" + this.mDataType + "/sync_upload";
        C11839m.m70688i("GenUploadDataImpl", "Sync type = " + str + ", dataType = " + this.mDataType + " , mHaveFile = " + this.f12821i + " , mAdd = " + this.f12823k.toString() + " , mModify = " + this.f12822j.toString() + " , mLost = " + this.f12825m.toString() + " , mDelete = " + this.f12826n.toString());
    }

    /* renamed from: A */
    public static /* synthetic */ boolean m81628A(C13587g c13587g, List list, Record record, StringBuilder sb2) throws C9722c {
        return c13587g.m17337p(list, record, sb2);
    }

    /* renamed from: A0 */
    public static /* synthetic */ void m81629A0(C13587g c13587g, String str, String str2, int i10, String str3, List list) {
        c13587g.m81715v1(str, str2, i10, str3, list);
    }

    /* renamed from: A1 */
    private List<Record> m81630A1(List<Record> list) throws C9722c {
        C11839m.m70688i("GenUploadDataImpl", "syncv2 upload add file start, size: " + list.size());
        m81662R0();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        isCancel();
        try {
            for (Record record : list) {
                isCancel();
                arrayList.add(this.f61123C.submit(new a(record)));
            }
            m81688g1(arrayList, arrayList2);
        } catch (Exception e10) {
            C11839m.m70687e("GenUploadDataImpl", "syncv2 upload add file exception: " + e10.getMessage());
        }
        C11839m.m70688i("GenUploadDataImpl", "syncv2 upload add file end, successList size: " + arrayList2.size());
        return arrayList2;
    }

    /* renamed from: B */
    public static /* synthetic */ void m81631B(C13587g c13587g, String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        c13587g.reportUploadFileBIEvent(str, str2, str3, str4, i10, str5, str6, str7);
    }

    /* renamed from: C */
    public static /* synthetic */ void m81633C(C13587g c13587g) throws C9722c {
        c13587g.isCancel();
    }

    /* renamed from: C1 */
    private List<Record> m81635C1(List<Record> list) throws C9722c {
        C11839m.m70688i("GenUploadDataImpl", "syncv2 upload modify file start size: " + list.size());
        m81662R0();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        isCancel();
        try {
            for (Record record : list) {
                isCancel();
                if (record != null) {
                    arrayList.add(this.f61123C.submit(new b(record)));
                }
            }
            m81688g1(arrayList, arrayList2);
        } catch (Exception e10) {
            C11839m.m70687e("GenUploadDataImpl", "syncv2 upload modify file error info: " + e10.toString());
        }
        C11839m.m70688i("GenUploadDataImpl", "syncv2 upload modify file successList size: " + arrayList2.size());
        return arrayList2;
    }

    /* renamed from: D */
    public static /* synthetic */ String m81636D(C13587g c13587g) {
        return c13587g.f12813a;
    }

    /* renamed from: E */
    public static /* synthetic */ void m81638E(C13587g c13587g, String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        c13587g.reportUploadFileBIEvent(str, str2, str3, str4, i10, str5, str6, str7);
    }

    /* renamed from: F */
    public static /* synthetic */ void m81640F(C13587g c13587g, String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        c13587g.reportUploadFileBIEvent(str, str2, str3, str4, i10, str5, str6, str7);
    }

    /* renamed from: G */
    public static /* synthetic */ String m81642G(C13587g c13587g) {
        return c13587g.mSyncType;
    }

    /* renamed from: H */
    public static /* synthetic */ String m81644H(C13587g c13587g) {
        return c13587g.traceId;
    }

    /* renamed from: I */
    public static /* synthetic */ boolean m81646I(C13587g c13587g) {
        return c13587g.isAbortSyncNowThrowException();
    }

    /* renamed from: J */
    public static /* synthetic */ String m81648J(C13587g c13587g) {
        return c13587g.mSyncType;
    }

    /* renamed from: J0 */
    public static /* synthetic */ void m81649J0(C13587g c13587g, String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        c13587g.reportUploadFileBIEvent(str, str2, str3, str4, i10, str5, str6, str7);
    }

    /* renamed from: K */
    public static /* synthetic */ String m81650K(C13587g c13587g) {
        return c13587g.mDataType;
    }

    /* renamed from: K0 */
    public static /* synthetic */ void m81651K0(C13587g c13587g, Record record) throws Throwable {
        c13587g.m17336o(record);
    }

    /* renamed from: L */
    public static /* synthetic */ String m81652L(C13587g c13587g) {
        return c13587g.mSyncModulePackageName;
    }

    /* renamed from: L0 */
    public static /* synthetic */ CopyOnWriteArrayList m81653L0(C13587g c13587g) {
        return c13587g.f61125v;
    }

    /* renamed from: M */
    public static /* synthetic */ void m81654M(C13587g c13587g, String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        c13587g.reportUploadFileBIEvent(str, str2, str3, str4, i10, str5, str6, str7);
    }

    /* renamed from: M0 */
    public static void m81655M0(ArrayList<String> arrayList, ArrayList<String> arrayList2, SyncData syncData) {
        if (arrayList.contains(syncData.getLuid())) {
            arrayList2.add(syncData.getLuid());
        }
    }

    /* renamed from: N */
    public static /* synthetic */ void m81656N(C13587g c13587g) throws C9722c {
        c13587g.isCancel();
    }

    /* renamed from: O */
    public static /* synthetic */ String m81657O(C13587g c13587g) {
        return c13587g.mSyncType;
    }

    /* renamed from: P */
    public static /* synthetic */ String m81658P(C13587g c13587g) {
        return c13587g.mDataType;
    }

    /* renamed from: Q */
    public static /* synthetic */ Asset m81659Q(C13587g c13587g, String str, String str2, String str3, String str4, String str5, String str6, Asset asset, String str7) throws C9722c {
        return c13587g.updateSingleAssetRevision(str, str2, str3, str4, str5, str6, asset, str7);
    }

    /* renamed from: Q0 */
    private void m81660Q0(int i10) {
        C11839m.m70688i("GenUploadDataImpl", this.mDataType + " CallBack, value = " + i10);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.GENSENDCALLBACK");
        intent.putExtra("msgType", this.mSyncType);
        intent.putExtra("msgID", 10007);
        Bundle bundle = new Bundle();
        if (this.mIsPartialSuc) {
            bundle.putBoolean("fail_error_need_update_sync_result", true);
        }
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putString("sync_module_package_name", this.mSyncModulePackageName);
        m81721x1();
        if (i10 == 0 || this.mIsPartialSuc) {
            if (this.f12821i) {
                m17342u();
                bundle.putParcelableArrayList("cadd", this.f12814b);
                bundle.putParcelableArrayList("cmod", this.f12832t);
                SerializableMap serializableMap = new SerializableMap();
                HashMap map = new HashMap();
                map.putAll(this.f12819g);
                map.putAll(this.f12818f);
                serializableMap.setMap(SyncLogicServiceUtil.buildFailErrorCodeMap(map));
                bundle.putSerializable("fail_error_code_map", serializableMap);
                C11839m.m70688i("GenUploadDataImpl", this.mDataType + " failUnstructIdMap.size(): " + this.f12819g.size() + ", failStructIdMap.size(): " + this.f12818f.size());
            } else {
                C11839m.m70688i("GenUploadDataImpl", this.mDataType + " mAddSuc.size = " + this.f12827o.size() + " mModifySuc.size = " + this.f12828p.size() + " mDeleteSuc.size = " + this.f12829q.size());
                bundle.putParcelableArrayList("cadd", this.f12827o);
                bundle.putParcelableArrayList("cmod", this.f12828p);
                bundle.putStringArrayList("cdel", this.f12829q);
                SerializableMap serializableMap2 = new SerializableMap();
                serializableMap2.setMap(SyncLogicServiceUtil.buildFailErrorCodeMap(this.f12818f));
                bundle.putSerializable("fail_error_code_map", serializableMap2);
                C11839m.m70688i("GenUploadDataImpl", this.mDataType + " failStructIdMap.size() : " + this.f12818f.size());
            }
            C10812z.m65840i(this.mContext, this.mSyncType, this.mDataType, 0, "", this.operationType, "local_upload", this.traceId);
        }
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.mContext).m78881d(intent);
        CloudSyncUtil.m15993a1(this.mContext, this.mSyncType, i10);
    }

    /* renamed from: R */
    public static /* synthetic */ void m81661R(C13587g c13587g, String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        c13587g.reportUploadFileBIEvent(str, str2, str3, str4, i10, str5, str6, str7);
    }

    /* renamed from: R0 */
    private void m81662R0() {
        if (this.f61123C == null) {
            C11839m.m70689w("GenUploadDataImpl", "ExecutorService is null, create it");
            this.f61123C = Executors.newFixedThreadPool(3);
        }
    }

    /* renamed from: S */
    public static /* synthetic */ long m81663S(long j10) {
        long j11 = f61120D + j10;
        f61120D = j11;
        return j11;
    }

    /* renamed from: T */
    public static /* synthetic */ FailRet m81664T(C13587g c13587g) {
        return c13587g.needAbortSync;
    }

    /* renamed from: T0 */
    private void m81665T0(List<Record> list, List<Record> list2, List<Record> list3, String str) throws C9722c {
        Attachment attachment;
        for (Record record : list) {
            String id2 = record.getId();
            List<Attachment> attachments = record.getAttachments();
            if (attachments != null && attachments.size() > 0) {
                List<Attachment> list4 = this.f12817e.get(id2);
                if (list4 == null || list4.size() <= 0) {
                    list3.add(record);
                } else {
                    HashMap map = new HashMap();
                    for (Attachment attachment2 : list4) {
                        map.put(attachment2.getUsage(), attachment2);
                    }
                    for (Attachment attachment3 : attachments) {
                        String usage = attachment3.getUsage();
                        String hash = attachment3.getHash();
                        if (!map.containsKey(usage) || (attachment = (Attachment) map.get(usage)) == null || !hash.equals(attachment.getHash())) {
                            list3.add(record);
                            break;
                        }
                        C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData compareFileNoChange: file no change usage = " + usage + ", recordId = " + id2);
                    }
                    list2.add(record);
                }
            } else {
                if (CloudSyncUtil.m15958J0(this.mContext, C10812z.m65833b(this.mSyncModulePackageName).get("packageName"))) {
                    throw new C9722c(2248, "syncV2 modify compareFileNoChange, local attachment size is empty", this.mSyncType, str);
                }
                list2.add(record);
            }
        }
        C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData compareFileNoChange: modifyNoChangeFileList size = " + list2.size() + ", modifyWithFileList size = " + list3.size());
    }

    /* renamed from: U */
    public static /* synthetic */ Context m81666U(C13587g c13587g) {
        return c13587g.mContext;
    }

    /* renamed from: U0 */
    private void m81667U0(List<Attachment> list, List<Attachment> list2, List<Attachment> list3, List<Attachment> list4, String str) throws C9722c {
        if (list == null || list.size() <= 0) {
            C11839m.m70689w("GenUploadDataImpl", "syncv2 uploadData compareFileModify: local attachment is 0, return");
            throw new C9722c(2248, "uploadData file compareFileModify: local attachment is 0", this.mSyncType, str);
        }
        if (list2 == null || list2.size() <= 0) {
            for (Attachment attachment : list) {
                C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData compareFileModify: cloudFile size is 0, add local all file, fileName = " + attachment.getUsage() + ", localHash = " + attachment.getHash());
                list3.add(attachment);
            }
            return;
        }
        HashMap map = new HashMap();
        for (Attachment attachment2 : list2) {
            map.put(attachment2.getUsage(), attachment2);
        }
        for (Attachment attachment3 : list) {
            String usage = attachment3.getUsage();
            String hash = attachment3.getHash();
            if (map.containsKey(usage)) {
                Attachment attachment4 = (Attachment) map.get(usage);
                if (attachment4 == null) {
                    C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData compareFileModify: cloud file null, all add file, add size = " + attachment3.size());
                    list3.add(attachment3);
                } else {
                    String hash2 = attachment4.getHash();
                    if (hash.isEmpty() || hash2.isEmpty()) {
                        C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData compareFileModify: add file, fileName = " + usage + ", localHash = " + hash + ", cloudHash = " + hash2);
                        list3.add(attachment3);
                    } else if (!hash.equals(hash2)) {
                        C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData compareFileModify: modify file, fileName = " + usage + ", localHash = " + hash + ", cloudHash = " + hash2);
                        attachment3.getAsset().setId(attachment4.getAssetId());
                        list4.add(attachment3);
                    }
                }
            } else {
                C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData compareFileModify: cloud not exist, add file, fileName = " + usage + ", localHash = " + hash);
                list3.add(attachment3);
            }
        }
        C11839m.m70688i("GenUploadDataImpl", "syncV2 uploadData compareFileModify: add file size = " + list3.size() + ", modify file size  = " + list4.size());
    }

    /* renamed from: V */
    public static /* synthetic */ String m81668V(C13587g c13587g) {
        return c13587g.mSyncType;
    }

    /* renamed from: W */
    public static /* synthetic */ String m81669W(C13587g c13587g) {
        return c13587g.traceId;
    }

    /* renamed from: W0 */
    private ArrayList<String> m81670W0() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.f12821i) {
            Iterator<SyncData> it = this.f12823k.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getLuid());
            }
            Iterator<SyncData> it2 = this.f12822j.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().getLuid());
            }
        }
        Iterator<SyncData> it3 = this.f12825m.iterator();
        while (it3.hasNext()) {
            arrayList.add(it3.next().getLuid());
        }
        C11839m.m70686d("GenUploadDataImpl", "getLuidList： luidList = " + arrayList.toString());
        return arrayList;
    }

    /* renamed from: X */
    public static /* synthetic */ int m81671X(C13587g c13587g) {
        return c13587g.f12820h;
    }

    /* renamed from: Y */
    public static /* synthetic */ void m81672Y(C13587g c13587g, Context context, String str, String str2, int i10, int i11) {
        c13587g.checkUploadFileException(context, str, str2, i10, i11);
    }

    /* renamed from: Y0 */
    private List<Record> m81673Y0(List<SyncData> list) throws Throwable {
        Iterator<SyncData> it;
        Record record;
        SyncData syncData;
        if (list == null || list.size() <= 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.f12816d.clear();
        Iterator<SyncData> it2 = list.iterator();
        while (it2.hasNext()) {
            SyncData next = it2.next();
            String guid = next.getGuid();
            Record record2 = new Record();
            record2.setKind(this.mDataType);
            record2.setId(guid);
            this.f12816d.put(record2.getId(), next.getLuid());
            this.f12815c.put(record2.getId(), next);
            try {
                checkDataAvaliable(guid, next.getLuid(), next.getData(), "update_record_with_file");
                CloudSyncUtil.m16024l(this.mSyncType, this.f12813a, next.getFileList(), this.f61127x, this.f61128y, "update_record_with_file");
                it = it2;
                record = record2;
                try {
                } catch (C9722c e10) {
                    e = e10;
                    syncData = next;
                }
            } catch (C9722c e11) {
                e = e11;
                it = it2;
                record = record2;
                syncData = next;
            }
            if (encryptDataV2(this.traceId, record2, this.mSyncType, next.getLuid(), next.getData(), next.getExtensionData(), "local_modify_upload") != null) {
                if (!CloudSyncUtil.m16049t0(this.mContext, this.mSyncType, this.mDataType, next.getFileList(), this.mSyncModulePackageName, "update_record_with_file")) {
                    List<Attachment> listM17331j = m17331j(record, next.getFileList());
                    if (listM17331j.size() > 0) {
                        record.setAttachments(listM17331j);
                    } else {
                        if (CloudSyncUtil.m15958J0(this.mContext, C10812z.m65833b(this.mSyncModulePackageName).get("packageName"))) {
                            throw new C9722c(2248, "syncV2 modify attachment size after encrypt is empty", this.mSyncType, "update_record_with_file");
                        }
                        C11839m.m70689w("GenUploadDataImpl", "syncv2 uploadData modify with file prepare, local attachment size 0, only upload record, recordId = " + record.getId() + ", luid = " + next.getLuid());
                    }
                }
                m81724y1(next, record);
                arrayList.add(record);
                it2 = it;
            } else {
                syncData = next;
                try {
                    throw new C9722c(2220, "syncV2 modify with file encryptData data is null", this.mSyncType, "update_record_with_file");
                } catch (C9722c e12) {
                    e = e12;
                    int iM60666c = e.m60666c();
                    String str = "syncv2 uploadData modify with file prepare error, " + e.getMessage() + ", recordId = " + record.getId() + ", luid = " + syncData.getLuid();
                    C11839m.m70689w("GenUploadDataImpl", str + ", continue");
                    m81715v1(syncData.getLuid(), record.getId(), iM60666c, str, arrayList2);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("bussinessId", "update_record_with_file");
                    linkedHashMap.putAll(getCommonUploadReportInfo(syncData.getLuid(), syncData.getGuid(), iM60666c, e.getMessage()));
                    C10812z.m65844m("mecloud_sync_data_upload", linkedHashMap);
                    it2 = it;
                }
            }
        }
        if (arrayList2.size() > 0) {
            this.f61126w.addAll(arrayList2);
            C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData modify with file, afer prepare, sucSize: " + arrayList.size() + ", failSize: " + arrayList2.size());
        }
        return arrayList;
    }

    /* renamed from: Z */
    public static /* synthetic */ void m81674Z(C13587g c13587g, String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        c13587g.reportUploadFileBIEvent(str, str2, str3, str4, i10, str5, str6, str7);
    }

    /* renamed from: Z0 */
    private int m81675Z0(C9722c c9722c) {
        return c9722c.m60666c();
    }

    /* renamed from: a0 */
    public static /* synthetic */ void m81676a0(C13587g c13587g, String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        c13587g.reportUploadFileBIEvent(str, str2, str3, str4, i10, str5, str6, str7);
    }

    /* renamed from: a1 */
    private void m81677a1() throws Exception {
        ArrayList<String> arrayListM81670W0 = m81670W0();
        C11839m.m70688i("GenUploadDataImpl", "getUploadFiles luidlist = " + arrayListM81670W0);
        if (arrayListM81670W0.size() > 0) {
            new C13582b(this.mContext, this.mDataType).m81589b(this.f12813a, this.mSyncType, arrayListM81670W0, this.mSyncModulePackageName);
            C2977f.m17864g(this.mSyncType, this.mDataType, this.traceId, this.f12813a, this.f12813a + "/sync_upload.zip", this.f61127x, this.f61128y);
        }
    }

    /* renamed from: b1 */
    private String m81679b1() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f12826n.size() > 0) {
            sb2.append("delSize:");
            sb2.append(this.f12826n.size());
            sb2.append(",delSucc:");
            sb2.append(this.f12829q.size());
        }
        if (this.f12823k.size() > 0) {
            sb2.append(",addSize:");
            sb2.append(this.f12823k.size());
            sb2.append(",addSucc:");
            sb2.append(this.f12827o.size());
            m17322a(this.f12823k, sb2);
        }
        if (this.f12824l.size() > 0) {
            sb2.append(",addWithFileSize:");
            sb2.append(this.f12824l.size());
            sb2.append(",addWithFileSucc:");
            sb2.append(this.f12814b.size());
            m17322a(this.f12824l, sb2);
        }
        if (this.f12822j.size() > 0) {
            sb2.append(",modifySize:");
            sb2.append(this.f12822j.size());
            sb2.append(",modifySucc:");
            sb2.append(this.f12828p.size());
            m17322a(this.f12822j, sb2);
        }
        if (this.f12832t.size() > 0) {
            sb2.append(",modifyWithFileSucc:");
            sb2.append(this.f12832t.size());
            m17322a(this.f12832t, sb2);
        }
        if (this.f12818f.size() > 0) {
            sb2.append(",failSize:");
            sb2.append(this.f12818f.size());
            sb2.append(",failReason:");
            sb2.append(this.f12818f.toString());
        }
        return sb2.toString();
    }

    /* renamed from: d1 */
    private void m81682d1(List<SyncData> list, Map<String, List<Record>> map, Map<String, List<FailRet>> map2, String str) throws C9722c {
        List<Record> list2 = map.get("addSuccessList");
        List<FailRet> list3 = map2.get("addFailList");
        HashMap map3 = new HashMap();
        Iterator<SyncData> it = this.f12823k.iterator();
        while (it.hasNext()) {
            SyncData next = it.next();
            map3.put(next.getGuid(), next);
        }
        if (list2 != null && list2.size() > 0) {
            for (Record record : list2) {
                SyncData syncData = (SyncData) map3.get(record.getId());
                if (syncData != null) {
                    syncData.setGuid(record.getId());
                    syncData.setEtag(record.getVersion().toString());
                    syncData.setUnstructUuid(record.getId());
                    this.f12827o.add(syncData);
                }
            }
        }
        m81686f1(list, list3, str);
    }

    /* renamed from: e0 */
    public static /* synthetic */ FailRet m81683e0(C13587g c13587g) {
        return c13587g.needAbortSync;
    }

    /* renamed from: e1 */
    private void m81684e1(List<SyncData> list, List<Record> list2) {
        HashMap map = new HashMap();
        if (list2.size() <= 0) {
            C11839m.m70689w("GenUploadDataImpl", "syncv2 parse add with file normal data success size is 0, return");
            return;
        }
        for (SyncData syncData : list) {
            map.put(syncData.getLuid(), syncData);
        }
        for (Record record : list2) {
            String id2 = record.getId();
            String str = this.f12816d.get(id2);
            if (TextUtils.isEmpty(str)) {
                C11839m.m70689w("GenUploadDataImpl", "parseAddWithFileSucData luid is null, recordId: " + id2);
            } else {
                SyncData syncData2 = (SyncData) map.get(str);
                if (syncData2 == null) {
                    C11839m.m70689w("GenUploadDataImpl", "parseAddWithFileSucData data is null, recordId: " + id2 + ", luid: " + str);
                } else {
                    if (syncData2.getFileList() != null && !syncData2.getFileList().isEmpty()) {
                        Iterator<UnstructData> it = syncData2.getFileList().iterator();
                        while (it.hasNext()) {
                            it.next().setUnstructUuid(id2);
                        }
                    }
                    syncData2.setGuid(id2);
                    syncData2.setUnstructUuid(id2);
                    syncData2.setEtag(String.valueOf(record.getVersion()));
                    this.f12814b.add(syncData2);
                }
            }
        }
        this.f12816d.clear();
    }

    /* renamed from: f1 */
    private void m81686f1(List<SyncData> list, List<FailRet> list2, String str) throws C9722c {
        super.baseSyncParseFailList(this.f12821i, this.f12818f, this.f12819g, list, list2, str);
    }

    /* renamed from: g1 */
    private void m81688g1(List<Future> list, List<Record> list2) throws C9722c {
        if (list == null || list2 == null) {
            C11839m.m70689w("GenUploadDataImpl", "parseFutureResult param is null");
            return;
        }
        for (Future future : list) {
            if (future != null) {
                try {
                    Record record = future.get() == null ? null : (Record) future.get();
                    if (record != null) {
                        list2.add(record);
                    }
                } catch (InterruptedException | ExecutionException e10) {
                    C11839m.m70687e("GenUploadDataImpl", "syncv2 upload parseFutureResult error: " + e10.toString());
                    if (!C0209d.m1333z1(this.mContext)) {
                        throw new C9722c(2028, "syncv2 upload file, parseFutureResult: " + e10.getMessage(), this.mSyncType, "local_upload");
                    }
                }
            }
        }
    }

    /* renamed from: h1 */
    private void m81690h1(List<SyncData> list, Map<String, List<Record>> map, Map<String, List<FailRet>> map2, String str) throws C9722c {
        List<Record> list2 = map.get("updateSuccessList");
        List<FailRet> list3 = map2.get("updateFailList");
        HashMap map3 = new HashMap();
        Iterator<SyncData> it = this.f12822j.iterator();
        while (it.hasNext()) {
            SyncData next = it.next();
            map3.put(next.getGuid(), next);
        }
        if (list2 != null && list2.size() > 0) {
            for (Record record : list2) {
                SyncData syncData = (SyncData) map3.get(record.getId());
                if (syncData != null) {
                    syncData.setGuid(record.getId());
                    syncData.setEtag(record.getVersion().toString());
                    syncData.setUnstructUuid(record.getId());
                    this.f12828p.add(syncData);
                }
            }
        }
        m81686f1(list, list3, str);
    }

    /* renamed from: i1 */
    private void m81692i1(List<Record> list) throws C9722c, IOException {
        C11839m.m70688i("GenUploadDataImpl", "syncV2 uploadData add size: " + this.f12823k.size());
        List<String> listGenerateGuids = generateGuids(this.mSyncType, this.mDataType, Integer.valueOf(this.f12823k.size()));
        checkGuids(listGenerateGuids, this.f12823k.size(), "local_add_upload");
        for (int i10 = 0; i10 < listGenerateGuids.size(); i10++) {
            SyncData syncData = this.f12823k.get(i10);
            syncData.setGuid(listGenerateGuids.get(i10));
            Record record = new Record();
            record.setId(listGenerateGuids.get(i10));
            this.f12816d.put(listGenerateGuids.get(i10), syncData.getLuid());
            checkDataAvaliable(syncData.getGuid(), syncData.getLuid(), syncData.getData(), "local_add_upload");
            if (encryptDataV2(this.traceId, record, this.mSyncType, syncData.getLuid(), syncData.getData(), syncData.getExtensionData(), "local_add_upload") == null) {
                throw new C9722c(2220, "syncV2 encryptData data is null", this.mSyncType, "local_add_upload");
            }
            if (syncData.getRecycleStatus() == -1) {
                record.setRecycled(Boolean.TRUE);
                record.setRecycledTime(new C4644l(syncData.getRecycleTime()));
            } else {
                record.setRecycled(Boolean.FALSE);
            }
            list.add(record);
        }
        C11839m.m70688i("GenUploadDataImpl", "syncV2 uploadData add after, record size = " + listGenerateGuids.size());
        C11839m.m70686d("GenUploadDataImpl", "syncV2 uploadData add after, record list = " + listGenerateGuids.toString() + ", record-luid = " + this.f12816d.toString());
    }

    /* renamed from: j1 */
    private List<Record> m81694j1(List<SyncData> list, List<Record> list2) throws Throwable {
        if (list2.size() <= 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        updateNormalRecords(list2, arrayList, arrayList2);
        m81684e1(list, arrayList);
        m81686f1(list, arrayList2, "create_record_with_file_normal");
        if (arrayList2.size() > 0) {
            this.f61125v.addAll(arrayList2);
        }
        reportUploadEvet(0, "", arrayList.size(), this.f61125v, "create_record_with_file_normal");
        return arrayList;
    }

    /* renamed from: k1 */
    private void m81696k1() throws Throwable {
        C11839m.m70688i("GenUploadDataImpl", "syncV2 uploadData add or modify start");
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.f12816d.clear();
        if (this.f12822j.size() > 0) {
            m81709r1(arrayList);
            if (arrayList.size() > 0) {
                C11839m.m70688i("GenUploadDataImpl", "syncV2 uploadData update");
                updateRecords(Constants.NORMAL_CACHE, arrayList, map, map2);
                m81690h1(this.f12822j, map, map2, "update_record_no_file");
            }
        }
        if (this.f12823k.size() > 0) {
            m81692i1(arrayList2);
            if (arrayList2.size() > 0) {
                createRecords(Constants.NORMAL_CACHE, arrayList2, map, map2);
                m81682d1(this.f12823k, map, map2, "create_record_no_file");
            }
        }
        if (NotifyUtil.HI_NOTE_SYNC_TYPE.equals(this.mSyncType)) {
            m17339r(CloudSyncUtil.m16057x(arrayList, map.get("updateSuccessList")));
        }
        C11839m.m70688i("GenUploadDataImpl", "syncV2 uploadData add succSize: " + this.f12827o.size() + ",modify succSize: " + this.f12828p.size() + ",failSize: " + this.f12818f.size() + ",failReason: " + this.f12818f.toString());
        this.f12816d.clear();
    }

    /* renamed from: m1 */
    private void m81699m1(List<SyncData> list, List<Record> list2) throws Throwable {
        SyncData syncData;
        List<String> list3;
        String str;
        if (list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<String> listGenerateGuids = generateGuids(this.mSyncType, this.mDataType, Integer.valueOf(list.size()));
        checkGuids(listGenerateGuids, list.size(), "create_record_with_file_temp");
        this.f12816d.clear();
        int i10 = 0;
        while (i10 < listGenerateGuids.size()) {
            SyncData syncData2 = list.get(i10);
            syncData2.setGuid(listGenerateGuids.get(i10));
            Record record = new Record();
            record.setId(listGenerateGuids.get(i10));
            this.f12816d.put(record.getId(), syncData2.getLuid());
            this.f12815c.put(record.getId(), syncData2);
            try {
                checkDataAvaliable(syncData2.getGuid(), syncData2.getLuid(), syncData2.getData(), "create_record_with_file_temp");
                CloudSyncUtil.m16024l(this.mSyncType, this.f12813a, syncData2.getFileList(), this.f61127x, this.f61128y, "create_record_with_file_temp");
                syncData = syncData2;
                list3 = listGenerateGuids;
                str = "GenUploadDataImpl";
            } catch (C9722c e10) {
                e = e10;
                syncData = syncData2;
                list3 = listGenerateGuids;
                str = "GenUploadDataImpl";
            }
            try {
            } catch (C9722c e11) {
                e = e11;
                int iM60666c = e.m60666c();
                String str2 = "syncv2 add temp data, prepare error, " + e.getMessage() + ", luid = " + syncData.getLuid();
                C11839m.m70689w(str, str2 + ", errorCode = " + iM60666c + ", continue");
                m81715v1(syncData.getLuid(), syncData.getGuid(), iM60666c, str2, arrayList2);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("bussinessId", "create_record_with_file_temp");
                linkedHashMap.putAll(getCommonUploadReportInfo(syncData.getLuid(), syncData.getGuid(), iM60666c, e.getMessage()));
                C10812z.m65844m("mecloud_sync_data_upload", linkedHashMap);
                i10++;
                listGenerateGuids = list3;
            }
            if (encryptDataV2(this.traceId, record, this.mSyncType, syncData2.getLuid(), syncData2.getData(), syncData2.getExtensionData(), "create_record_with_file_temp") == null) {
                throw new C9722c(2220, "syncV2 add temp data encryptData data is null", this.mSyncType, "create_record_with_file_temp");
            }
            if (!CloudSyncUtil.m16040q0(this.mSyncType, this.mDataType, syncData.getFileList(), "create_record_with_file_temp")) {
                List<Attachment> listM17329h = m17329h(record, syncData.getFileList());
                if (listM17329h.size() <= 0) {
                    throw new C9722c(2248, "syncV2 add temp file, attachment size after encrypt is empty", this.mSyncType, "create_record_with_file_temp");
                }
                record.setAttachments(listM17329h);
                if (!m17338q(syncData.getLuid(), listM17329h)) {
                    throw new C9722c(SNSCode.Status.HWID_UNLOGIN, "syncv2 add temp data, prepare attachment, space not enough", this.mSyncType, "create_record_with_file_temp");
                }
            }
            if (syncData.getRecycleStatus() == -1) {
                record.setRecycled(Boolean.TRUE);
                record.setRecycledTime(new C4644l(syncData.getRecycleTime()));
            } else {
                record.setRecycled(Boolean.FALSE);
            }
            arrayList.add(record);
            i10++;
            listGenerateGuids = list3;
        }
        C11839m.m70688i("GenUploadDataImpl", "syncV2 add temp data, after prepare, sucTempSize: " + arrayList.size() + ", failTempSize:" + arrayList2.size());
        if (arrayList2.size() > 0) {
            this.f61125v.addAll(arrayList2);
        }
        ArrayList arrayList3 = new ArrayList();
        createRecords("temp", arrayList, list2, arrayList3, "attachments,attributes,cipher,createdTime,editedTime,id,kind,recycled,recycledTime,status,version");
        filterSuc(list2, arrayList3, "create_record_with_file");
        try {
            m81686f1(list, arrayList3, "create_record_with_file");
        } catch (C9722c e12) {
            if (list2.isEmpty()) {
                C11839m.m70689w("GenUploadDataImpl", "syncV2 add temp data, all fail");
                throw e12;
            }
            C11839m.m70688i("GenUploadDataImpl", "syncV2 add temp data, partial suc, continue");
        }
        C11839m.m70688i("GenUploadDataImpl", "syncV2 add temp data, after onece create Temp, sucSize :" + list2.size() + ", failSize:" + arrayList3.size());
        if (arrayList3.size() > 0) {
            this.f61125v.addAll(arrayList3);
        }
        reportUploadEvet(0, "", list2.size(), this.f61125v, "create_record_with_file_temp");
    }

    /* renamed from: n1 */
    private void m81701n1(List<SyncData> list) throws Throwable {
        if (list != null) {
            C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData add with file start, addSize = " + list.size());
            ArrayList arrayList = new ArrayList();
            m81699m1(list, arrayList);
            List<Record> arrayList2 = new ArrayList<>();
            if (arrayList.size() > 0) {
                arrayList2 = m81630A1(arrayList);
            }
            C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData upload add file suc size list = " + arrayList2.size());
            C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData upload add file, finally sucSize: " + m81694j1(list, arrayList2).size() + ", failSize: " + this.f61125v.size());
        }
        C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData add with file end");
    }

    /* renamed from: o1 */
    private void m81703o1() throws Throwable {
        if (this.f12826n.size() > 0) {
            C11839m.m70688i("GenUploadDataImpl", "syncV2 uploadData delete size = " + this.f12826n.size() + " , delete data = " + this.f12826n.toString());
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = this.f12826n.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            deleteRecords(this.mSyncType, this.mDataType, arrayList, arrayList2, arrayList3, "local_delete_upload");
            C11839m.m70688i("GenUploadDataImpl", "syncV2 uploadData delete suc size = " + arrayList2.size() + " , fail size = " + arrayList3.toString());
            Iterator<String> it2 = this.f12826n.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                Iterator<String> it3 = arrayList2.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        String next2 = it3.next();
                        if (next.equals(next2)) {
                            this.f12829q.add(next2);
                            break;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: p0 */
    public static /* synthetic */ CopyOnWriteArrayList m81704p0(C13587g c13587g) {
        return c13587g.f61126w;
    }

    /* renamed from: p1 */
    private List<Record> m81705p1(List<SyncData> list, List<Record> list2) throws C9722c, IOException {
        if (list2 == null || list2.size() <= 0) {
            return new ArrayList();
        }
        C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData modify with file, upload file start, modifyRecordList size = " + list2.size());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        m17330i(list2);
        m81665T0(list2, arrayList2, arrayList, "update_compare_file_change");
        ArrayList arrayList3 = new ArrayList(arrayList2);
        if (arrayList.size() > 0) {
            arrayList3.addAll(m81635C1(arrayList));
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData modify with file, toUpdateRecordList size = " + arrayList3.size());
        putUpdateRecords(Constants.NORMAL_CACHE, arrayList3, arrayList4, arrayList5, "attributes,cipher,createdTime,editedTime,id,kind,recycled,recycledTime,status,version", "update_record_with_file");
        m17335n(list, arrayList4);
        m81686f1(list, arrayList5, "update_record_with_file");
        if (arrayList5.size() > 0) {
            this.f61126w.addAll(arrayList5);
        }
        reportUploadEvet(0, "", arrayList4.size(), this.f61126w, "update_record_with_file");
        C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData modify with file, sucRecord size = " + arrayList4.size() + ", faileRecord size = " + arrayList5.size());
        return arrayList4;
    }

    /* renamed from: q1 */
    private void m81707q1(List<SyncData> list) throws Throwable {
        if (list != null) {
            C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData modify with file start, modifySize: " + list.size());
            List<Record> listM81673Y0 = m81673Y0(list);
            List<Record> arrayList = new ArrayList<>();
            if (listM81673Y0.size() > 0) {
                arrayList = m81705p1(list, listM81673Y0);
                if (NotifyUtil.HI_NOTE_SYNC_TYPE.equals(this.mSyncType) && arrayList.size() > 0) {
                    m17340s(list, arrayList);
                }
            }
            C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData modify with file, finally sucSize = " + arrayList.size() + ", failSize = " + this.f61126w.size());
            this.f12816d.clear();
        }
        C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData modify with file end");
    }

    /* renamed from: r1 */
    private void m81709r1(List<Record> list) throws C9722c {
        C11839m.m70688i("GenUploadDataImpl", "syncV2 uploadData modify size = " + this.f12822j.size());
        Iterator<SyncData> it = this.f12822j.iterator();
        while (it.hasNext()) {
            SyncData next = it.next();
            String guid = next.getGuid();
            checkDataAvaliable(next.getGuid(), next.getLuid(), next.getData(), "local_modify_upload");
            Record record = new Record();
            record.setId(guid);
            this.f12816d.put(guid, next.getLuid());
            if (encryptDataV2(this.traceId, record, this.mSyncType, next.getLuid(), next.getData(), next.getExtensionData(), "local_modify_upload") == null) {
                throw new C9722c(2220, "syncV2 encryptData data is null", this.mSyncType, "local_modify_upload");
            }
            if (next.getRecycleStatus() == -1) {
                record.setRecycled(Boolean.TRUE);
                record.setRecycledTime(new C4644l(next.getRecycleTime()));
            } else {
                record.setRecycled(Boolean.FALSE);
            }
            list.add(record);
        }
        C11839m.m70686d("GenUploadDataImpl", "syncV2 uploadData after modify, record-luid: " + this.f12816d.toString());
        C11839m.m70688i("GenUploadDataImpl", "syncV2 uploadData after modify list size: " + list.size());
    }

    /* renamed from: t1 */
    private void m81712t1() throws Exception {
        C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData struct data with file start");
        this.f12824l = new ArrayList<>(this.f12823k);
        ArrayList arrayList = new ArrayList(this.f12823k);
        this.f12823k.clear();
        try {
            isCancel();
            if (arrayList.size() > 0) {
                this.f61123C = Executors.newFixedThreadPool(3);
                this.f12820h = arrayList.size();
                isCancel();
                m81701n1(arrayList);
            }
            ArrayList arrayList2 = new ArrayList(this.f12822j);
            this.f12822j.clear();
            if (arrayList2.size() > 0) {
                this.f12820h = arrayList2.size();
                isCancel();
                m81707q1(arrayList2);
            }
            C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData struct data with file end");
            ExecutorService executorService = this.f61123C;
            if (executorService != null) {
                executorService.shutdown();
            }
        } catch (Throwable th2) {
            C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData struct data with file end");
            ExecutorService executorService2 = this.f61123C;
            if (executorService2 != null) {
                executorService2.shutdown();
            }
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v1 */
    public void m81715v1(String str, String str2, int i10, String str3, List<FailRet> list) {
        m81718w1(str2, i10);
        FailRet failRet = new FailRet();
        if (!TextUtils.isEmpty(str)) {
            failRet.setLuid(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            failRet.setRecordId(str2);
        }
        failRet.setErrCode(i10);
        failRet.setErrMsg(str3);
        if (list != null) {
            list.add(failRet);
        }
        C2980i.m17879n(this.mReportEndInfo, i10, str3);
    }

    /* renamed from: w */
    public static /* synthetic */ Map m81716w(C13587g c13587g) {
        return c13587g.f12816d;
    }

    /* renamed from: w1 */
    private void m81718w1(String str, int i10) {
        super.baseRecordUploadFileFail(this.f12818f, this.f12819g, str, i10);
    }

    /* renamed from: x */
    public static /* synthetic */ void m81719x(C13587g c13587g) throws C9722c {
        c13587g.isCancel();
    }

    /* renamed from: x1 */
    private void m81721x1() {
        if (this.f12821i) {
            C12772e c12772e = new C12772e();
            ArrayList arrayList = new ArrayList();
            Iterator<SyncData> it = this.f12814b.iterator();
            while (it.hasNext()) {
                String luid = it.next().getLuid();
                if (this.f12831s.containsKey(luid)) {
                    arrayList.add(this.f12831s.get(luid));
                }
            }
            if (arrayList.size() > 0) {
                C11839m.m70688i("GenUploadDataImpl", "setFileInfoToDataBase: toDeleteList.size = " + arrayList.size());
                c12772e.m76659m(this.mSyncType, this.mDataType, arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            this.f12824l.removeAll(this.f12814b);
            Iterator<SyncData> it2 = this.f12824l.iterator();
            while (it2.hasNext()) {
                SyncData next = it2.next();
                if (this.f12830r.containsKey(next.getLuid())) {
                    arrayList2.add(this.f12830r.get(next.getLuid()));
                }
            }
            if (arrayList2.size() > 0) {
                C11839m.m70688i("GenUploadDataImpl", "setFileInfoToDataBase: toAddList.size = " + arrayList2.size());
                c12772e.m76653g(this.mSyncType, this.mDataType, arrayList2);
            }
        }
    }

    /* renamed from: y */
    public static /* synthetic */ void m81722y(C13587g c13587g, String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        c13587g.reportUploadFileBIEvent(str, str2, str3, str4, i10, str5, str6, str7);
    }

    /* renamed from: y1 */
    private void m81724y1(SyncData syncData, Record record) {
        if (syncData.getRecycleStatus() != -1) {
            record.setRecycled(Boolean.FALSE);
        } else {
            record.setRecycled(Boolean.TRUE);
            record.setRecycledTime(new C4644l(syncData.getRecycleTime()));
        }
    }

    /* renamed from: z */
    public static /* synthetic */ void m81725z(C13587g c13587g) throws C9722c {
        c13587g.isCancel();
    }

    /* renamed from: z1 */
    private void m81727z1(ArrayList<SyncData> arrayList) {
        int sdkVersion;
        if (arrayList == null || arrayList.size() == 0 || (sdkVersion = GenSyncLogicService.getSdkVersion(this.mSyncModulePackageName)) < 104) {
            return;
        }
        Iterator<SyncData> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().setVersion(sdkVersion);
        }
    }

    /* renamed from: B1 */
    public int m81728B1() {
        File file;
        C11839m.m70688i("GenUploadDataImpl", this.mDataType + " syncV2 Begin uploadDataV2");
        long jCurrentTimeMillis = System.currentTimeMillis();
        String message = "";
        int iM81675Z0 = 0;
        try {
            try {
            } catch (C9722c e10) {
                message = e10.getMessage();
                iM81675Z0 = m81675Z0(e10);
                C10812z.m65841j(this.mContext, e10.m60668e(), this.mDataType, e10.m60666c(), e10.m60667d(), e10.getMessage(), this.operationType, e10.m60665b(), this.traceId);
                m81660Q0(iM81675Z0);
                file = new File(this.f12813a);
            } catch (Exception e11) {
                message = e11.getMessage();
                iM81675Z0 = 5;
                C11839m.m70687e("GenUploadDataImpl", "Upload data v2, error: " + e11.toString());
                C10812z.m65840i(this.mContext, this.mSyncType, this.mDataType, 5, e11.toString(), this.operationType, "local_upload", this.traceId);
                m81660Q0(5);
                file = new File(this.f12813a);
            }
            if (C10028c.m62182c0().m62206E1()) {
                throw new C9722c(FamilyShareConstants.MessageCode.GET_FAMILY_IMAGE, "Incremental migration", this.mSyncType, "local_upload");
            }
            m81727z1(this.f12823k);
            m81727z1(this.f12822j);
            if (m81732S0()) {
                m81737s1();
            } else {
                m81731P0();
            }
            C13007b.m78205Y(this.mContext).m78233N0(this.mDataType, true);
            checkIsHasPartialException(this.mSyncType);
            if (isAbortSyncNowThrowException()) {
                throw new C9722c(this.needAbortSync.getErrCode(), "syncv2 upload file error, need abort sync, errorMsg: " + this.needAbortSync.getErrMsg(), this.mSyncType, "local_upload");
            }
            isCancel();
            m81660Q0(0);
            file = new File(this.f12813a);
            C13582b.m81588a(file);
            getPostStructDataRspResult().m17768a();
            reportUploadDataV2(iM81675Z0, message, m81679b1());
            C2980i.m17879n(this.mReportEndInfo, iM81675Z0, message);
            C2980i.m17875j(this.mReportEndInfo, this.mDataType, this.f12827o.size() + this.f12828p.size() + this.f12814b.size() + this.f12832t.size() + this.f12829q.size());
            C2980i.m17876k(this.mReportEndInfo, this.mDataType, f61120D);
            C2980i.m17877l(this.mReportEndInfo, this.mDataType, System.currentTimeMillis() - jCurrentTimeMillis);
            return iM81675Z0;
        } catch (Throwable th2) {
            m81660Q0(0);
            C13582b.m81588a(new File(this.f12813a));
            getPostStructDataRspResult().m17768a();
            reportUploadDataV2(0, "", m81679b1());
            C2980i.m17879n(this.mReportEndInfo, 0, "");
            C2980i.m17875j(this.mReportEndInfo, this.mDataType, this.f12827o.size() + this.f12828p.size() + this.f12814b.size() + this.f12832t.size() + this.f12829q.size());
            C2980i.m17876k(this.mReportEndInfo, this.mDataType, f61120D);
            C2980i.m17877l(this.mReportEndInfo, this.mDataType, System.currentTimeMillis() - jCurrentTimeMillis);
            throw th2;
        }
    }

    /* renamed from: N0 */
    public final List<Attachment> m81729N0(Record record, StringBuilder sb2, Map<String, Integer> map) throws Throwable {
        ArrayList arrayList = new ArrayList();
        List<Attachment> attachments = record.getAttachments();
        List<Attachment> list = this.f12817e.get(record.getId());
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        m81667U0(attachments, list, arrayList2, arrayList3, "update_compare_file_change");
        sb2.append("addFileSize: ");
        sb2.append(arrayList2.size());
        sb2.append(", modifyFileSize: ");
        sb2.append(arrayList3.size());
        if (arrayList2.size() > 0) {
            isCancel();
            List<Attachment> listM17324c = m17324c(record, arrayList2);
            if (listM17324c == null) {
                C11839m.m70688i("GenUploadDataImpl", "syncV2 upload file fail, create asset fail, recordId = " + record.getId());
                sb2.append(", addFileResult: ");
                sb2.append(2221);
                return null;
            }
            map.put("addAttachmentCount", Integer.valueOf(listM17324c.size()));
            sb2.append(", addFileResult: 0");
            arrayList.addAll(listM17324c);
        }
        if (arrayList3.size() > 0) {
            isCancel();
            List<Attachment> listM17325d = m17325d(record, arrayList3);
            if (listM17325d == null) {
                C11839m.m70688i("GenUploadDataImpl", "syncV2 upload file fail, create asset revision fail, recordId = " + record.getId());
                sb2.append(", modifyFileResul: ");
                sb2.append(2221);
                return null;
            }
            map.put("modifyAttachmentCount", Integer.valueOf(listM17325d.size()));
            sb2.append(", modifyFileResult: 0");
            arrayList.addAll(listM17325d);
        }
        return arrayList;
    }

    /* renamed from: O0 */
    public final void m81730O0() throws Exception {
        ArrayList<String> arrayListM81734X0 = m81734X0(this.f61121A);
        C11839m.m70688i("GenUploadDataImpl", "batchGetUploadFiles luidlist = " + arrayListM81734X0);
        if (arrayListM81734X0 == null || arrayListM81734X0.size() <= 0) {
            return;
        }
        new C13582b(this.mContext, this.mDataType).m81590c(this.f12813a, this.mSyncType, arrayListM81734X0, this.mSyncModulePackageName, this.f61129z);
        C2977f.m17864g(this.mSyncType, this.mDataType, this.traceId, this.f12813a, this.f12813a + "/sync_upload.zip", this.f61127x, this.f61128y);
    }

    /* renamed from: P0 */
    public final void m81731P0() throws Exception {
        m81703o1();
        HashMap<String, SyncData> map = new HashMap<>();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        for (int i10 = 0; i10 < this.f12823k.size(); i10++) {
            SyncData syncData = this.f12823k.get(i10);
            String luid = syncData.getLuid();
            map.put(luid, syncData);
            map2.put(luid, syncData);
        }
        for (int i11 = 0; i11 < this.f12822j.size(); i11++) {
            SyncData syncData2 = this.f12822j.get(i11);
            String luid2 = syncData2.getLuid();
            map.put(luid2, syncData2);
            map3.put(luid2, syncData2);
        }
        for (int i12 = 0; i12 < this.f12825m.size(); i12++) {
            SyncData syncData3 = this.f12825m.get(i12);
            String luid3 = syncData3.getLuid();
            map.put(luid3, syncData3);
            map4.put(luid3, syncData3);
        }
        while (map.size() > 0) {
            ArrayList<SyncData> arrayList = new ArrayList<>();
            ArrayList<SyncData> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            ArrayList<String> arrayList4 = this.f61121A;
            if (arrayList4 != null) {
                arrayList4.clear();
            }
            ArrayList<String> arrayList5 = this.f61122B;
            if (arrayList5 != null) {
                arrayList5.clear();
            }
            C11839m.m70688i("GenUploadDataImpl", "totalMap = " + map.size());
            m81733V0(map);
            C11839m.m70688i("GenUploadDataImpl", "after getCurrentLuids validList = " + this.f61121A + ", failedList = " + this.f61122B);
            if (this.f61121A != null) {
                for (int i13 = 0; i13 < this.f61121A.size(); i13++) {
                    String str = this.f61121A.get(i13);
                    if (map.containsKey(str)) {
                        map.remove(str);
                    }
                    if (map2.containsKey(str)) {
                        arrayList.add((SyncData) map2.get(str));
                        map2.remove(str);
                    }
                    if (map3.containsKey(str)) {
                        arrayList2.add((SyncData) map3.get(str));
                        map3.remove(str);
                    }
                    if (map4.containsKey(str)) {
                        arrayList3.add((SyncData) map4.get(str));
                        map4.remove(str);
                    }
                }
            }
            C11839m.m70688i("GenUploadDataImpl", "removed totalMap = " + map.size());
            if (this.f61122B != null) {
                for (int i14 = 0; i14 < this.f61122B.size(); i14++) {
                    String str2 = this.f61122B.get(i14);
                    if (map.containsKey(str2)) {
                        map.remove(str2);
                    }
                    if (map2.containsKey(str2)) {
                        map2.remove(str2);
                    }
                    if (map3.containsKey(str2)) {
                        map3.remove(str2);
                    }
                    if (map4.containsKey(str2)) {
                        map4.remove(str2);
                    }
                }
            }
            m81730O0();
            if (this.f12821i) {
                C2980i.m17882q(this.mReportEndInfo, true);
                m81738u1(arrayList, arrayList2);
            } else {
                C11839m.m70688i("GenUploadDataImpl", "syncV2 uploadData struct data");
                m81736l1(arrayList, arrayList2);
            }
            C12329u c12329u = this.f61124u;
            if (c12329u != null) {
                c12329u.m74130u(arrayList3, this.f12813a);
            }
        }
    }

    /* renamed from: S0 */
    public final boolean m81732S0() {
        ArrayList<String> arrayListM81670W0 = m81670W0();
        Bundle bundleM81735c1 = m81735c1(arrayListM81670W0);
        if (bundleM81735c1 == null) {
            return true;
        }
        this.f61129z = bundleM81735c1.getInt("task_id");
        this.f61121A = bundleM81735c1.getStringArrayList("valid_ids");
        ArrayList<String> stringArrayList = bundleM81735c1.getStringArrayList("failed_ids");
        this.f61122B = stringArrayList;
        if (this.f61121A == null || stringArrayList == null) {
            return true;
        }
        C11839m.m70688i("GenUploadDataImpl", "checkUploadFile validListSize = " + this.f61121A.size() + "luidListSize = " + arrayListM81670W0.size());
        return this.f61121A.size() + this.f61122B.size() == arrayListM81670W0.size();
    }

    /* renamed from: V0 */
    public final void m81733V0(HashMap<String, SyncData> map) {
        Bundle bundleM81735c1 = m81735c1(new ArrayList<>(map.keySet()));
        if (bundleM81735c1 != null) {
            this.f61129z = bundleM81735c1.getInt("task_id");
            this.f61121A = bundleM81735c1.getStringArrayList("valid_ids");
            this.f61122B = bundleM81735c1.getStringArrayList("failed_ids");
            C11839m.m70688i("GenUploadDataImpl", "getCurrentLuids taskId = " + this.f61129z + "avildIds = " + this.f61121A + "failedIds = " + this.f61122B);
        }
    }

    /* renamed from: X0 */
    public final ArrayList<String> m81734X0(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (arrayList != null && !arrayList.isEmpty()) {
            if (this.f12821i) {
                Iterator<SyncData> it = this.f12823k.iterator();
                while (it.hasNext()) {
                    m81655M0(arrayList, arrayList2, it.next());
                }
                Iterator<SyncData> it2 = this.f12822j.iterator();
                while (it2.hasNext()) {
                    m81655M0(arrayList, arrayList2, it2.next());
                }
            }
            Iterator<SyncData> it3 = this.f12825m.iterator();
            while (it3.hasNext()) {
                m81655M0(arrayList, arrayList2, it3.next());
            }
            C11839m.m70686d("GenUploadDataImpl", "getLuidList needLuidList luidList = " + arrayList2.toString());
        }
        return arrayList2;
    }

    /* renamed from: c1 */
    public final Bundle m81735c1(ArrayList<String> arrayList) {
        C11839m.m70688i("GenUploadDataImpl", "getUploadValidIds luidlist = " + arrayList);
        if (arrayList.size() > 0) {
            return new C13582b(this.mContext, this.mDataType).m81591d(this.mSyncType, arrayList, this.mSyncModulePackageName);
        }
        return null;
    }

    @Override // com.huawei.android.hicloud.sync.contact.SyncProcessBase
    public boolean isHasPartialSucData() {
        if (this.f12818f.size() <= 0) {
            return false;
        }
        return this.f12821i ? this.f12814b.size() > 0 || this.f12832t.size() > 0 : this.f12827o.size() > 0 || this.f12828p.size() > 0 || this.f12829q.size() > 0;
    }

    /* renamed from: l1 */
    public final void m81736l1(ArrayList<SyncData> arrayList, ArrayList<SyncData> arrayList2) throws Throwable {
        C11839m.m70688i("GenUploadDataImpl", "syncV2 uploadData add or modify start");
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        this.f12816d.clear();
        if (arrayList2.size() > 0) {
            m81709r1(arrayList3);
            if (arrayList3.size() > 0) {
                C11839m.m70688i("GenUploadDataImpl", "syncV2 uploadData update");
                updateRecords(Constants.NORMAL_CACHE, arrayList3, map, map2);
                m81690h1(arrayList2, map, map2, "update_record_no_file");
            }
        }
        if (arrayList.size() > 0) {
            m81692i1(arrayList4);
            if (arrayList4.size() > 0) {
                createRecords(Constants.NORMAL_CACHE, arrayList4, map, map2);
                m81682d1(arrayList, map, map2, "create_record_no_file");
            }
        }
        if (NotifyUtil.HI_NOTE_SYNC_TYPE.equals(this.mSyncType)) {
            m17339r(CloudSyncUtil.m16057x(arrayList3, map.get("updateSuccessList")));
        }
        C11839m.m70688i("GenUploadDataImpl", "syncV2 uploadData add succSize: " + this.f12827o.size() + ",modify succSize: " + this.f12828p.size() + ",failSize: " + this.f12818f.size() + ",failReason: " + this.f12818f.toString());
        this.f12816d.clear();
    }

    /* renamed from: s1 */
    public final void m81737s1() throws Exception {
        m81677a1();
        if (this.f12821i) {
            C2980i.m17882q(this.mReportEndInfo, true);
            m81712t1();
        } else {
            C11839m.m70688i("GenUploadDataImpl", "syncV2 uploadData struct data");
            m81703o1();
            m81696k1();
        }
        C12329u c12329u = this.f61124u;
        if (c12329u != null) {
            c12329u.m74130u(this.f12825m, this.f12813a);
        }
    }

    /* renamed from: u1 */
    public final void m81738u1(ArrayList<SyncData> arrayList, ArrayList<SyncData> arrayList2) throws Exception {
        C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData struct data with file start");
        ArrayList arrayList3 = new ArrayList(arrayList);
        arrayList.clear();
        try {
            isCancel();
            if (arrayList3.size() > 0) {
                this.f61123C = Executors.newFixedThreadPool(3);
                this.f12820h += arrayList3.size();
                isCancel();
                m81701n1(arrayList3);
            }
            ArrayList arrayList4 = new ArrayList(arrayList2);
            arrayList2.clear();
            if (arrayList4.size() > 0) {
                this.f12820h += arrayList4.size();
                isCancel();
                m81707q1(arrayList4);
            }
            C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData struct data with file end");
            ExecutorService executorService = this.f61123C;
            if (executorService != null) {
                executorService.shutdown();
            }
        } catch (Throwable th2) {
            C11839m.m70688i("GenUploadDataImpl", "syncv2 uploadData struct data with file end");
            ExecutorService executorService2 = this.f61123C;
            if (executorService2 != null) {
                executorService2.shutdown();
            }
            throw th2;
        }
    }
}
