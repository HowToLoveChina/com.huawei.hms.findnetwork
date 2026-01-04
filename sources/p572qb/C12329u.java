package p572qb;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.contact.SyncProcessBase;
import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import com.huawei.android.hicloud.sync.syncutil.C2985n;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Attachment;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRet;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Record;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Resource;
import fk.C9722c;
import hk.C10278a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import je.C10812z;
import p015ak.C0209d;
import p514o9.C11839m;
import p818yp.C14034a;
import za.C14165b;

/* renamed from: qb.u */
/* loaded from: classes3.dex */
public class C12329u extends SyncProcessBase {

    /* renamed from: a */
    public final Map<String, Record> f57062a;

    /* renamed from: b */
    public final Map<String, b> f57063b;

    /* renamed from: c */
    public boolean f57064c;

    /* renamed from: d */
    public volatile FailRet f57065d;

    /* renamed from: e */
    public final String f57066e;

    /* renamed from: f */
    public List<String> f57067f;

    /* renamed from: g */
    public HashMap<String, List<String>> f57068g;

    /* renamed from: h */
    public List<String> f57069h;

    /* renamed from: i */
    public String f57070i;

    /* renamed from: j */
    public ExecutorService f57071j;

    /* renamed from: k */
    public int f57072k;

    /* renamed from: qb.u$b */
    public class b {

        /* renamed from: a */
        public String f57073a;

        /* renamed from: b */
        public int f57074b;

        /* renamed from: c */
        public SyncData f57075c;

        /* renamed from: d */
        public Record f57076d;

        public b() {
        }

        /* renamed from: a */
        public Record m74136a() {
            return this.f57076d;
        }

        /* renamed from: b */
        public String m74137b() {
            return this.f57073a;
        }

        /* renamed from: c */
        public int m74138c() {
            return this.f57074b;
        }

        /* renamed from: d */
        public SyncData m74139d() {
            return this.f57075c;
        }

        /* renamed from: e */
        public void m74140e(Record record) {
            this.f57076d = record;
        }

        /* renamed from: f */
        public void m74141f(String str) {
            this.f57073a = str;
        }

        /* renamed from: g */
        public void m74142g(int i10) {
            this.f57074b = i10;
        }

        /* renamed from: h */
        public void m74143h(SyncData syncData) {
            this.f57075c = syncData;
        }
    }

    /* renamed from: qb.u$c */
    public class c implements Callable<String> {

        /* renamed from: a */
        public String f57078a;

        /* renamed from: b */
        public List<Attachment> f57079b;

        public c(String str, List<Attachment> list) {
            this.f57078a = str;
            this.f57079b = list;
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
        public java.lang.String call() throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 1749
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p572qb.C12329u.c.call():java.lang.String");
        }
    }

    public C12329u(Context context, String str, String str2, String str3, String str4, String str5, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        super(context, str, str2, str3, str4, str5, concurrentHashMap);
        this.f57062a = new HashMap();
        this.f57063b = new HashMap();
        this.f57064c = true;
        this.f57065d = null;
        this.f57066e = "upload_record_with_lost_file";
        this.f57067f = new ArrayList();
        this.f57068g = new HashMap<>();
        this.f57069h = new ArrayList();
        this.f57072k = 0;
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m74093a(C12329u c12329u) {
        return c12329u.isAbortSyncNowThrowException();
    }

    /* renamed from: b */
    public static /* synthetic */ String m74094b(C12329u c12329u) {
        return c12329u.mSyncModulePackageName;
    }

    /* renamed from: c */
    public static /* synthetic */ String m74095c(C12329u c12329u) {
        return c12329u.mSyncType;
    }

    /* renamed from: d */
    public static /* synthetic */ String m74096d(C12329u c12329u) {
        return c12329u.mDataType;
    }

    /* renamed from: e */
    public static /* synthetic */ Asset m74097e(C12329u c12329u, String str, String str2, String str3, String str4, String str5, String str6, Asset asset, String str7) throws C9722c {
        return c12329u.updateSingleAssetRevision(str, str2, str3, str4, str5, str6, asset, str7);
    }

    /* renamed from: f */
    public static /* synthetic */ HashMap m74098f(C12329u c12329u) {
        return c12329u.f57068g;
    }

    /* renamed from: g */
    public static /* synthetic */ Context m74099g(C12329u c12329u) {
        return c12329u.mContext;
    }

    /* renamed from: h */
    public static /* synthetic */ String m74100h(C12329u c12329u) {
        return c12329u.mSyncType;
    }

    /* renamed from: i */
    public static /* synthetic */ String m74101i(C12329u c12329u) {
        return c12329u.traceId;
    }

    /* renamed from: j */
    public static /* synthetic */ int m74102j(C12329u c12329u) {
        return c12329u.f57072k;
    }

    /* renamed from: k */
    public static /* synthetic */ void m74103k(C12329u c12329u, Context context, String str, String str2, int i10, int i11) {
        c12329u.checkUploadFileException(context, str, str2, i10, i11);
    }

    /* renamed from: l */
    public static /* synthetic */ FailRet m74104l(C12329u c12329u) {
        return c12329u.f57065d;
    }

    /* renamed from: m */
    public static /* synthetic */ void m74105m(C12329u c12329u) {
        c12329u.m74129t();
    }

    /* renamed from: n */
    public static /* synthetic */ void m74106n(C12329u c12329u) throws C9722c {
        c12329u.isCancel();
    }

    /* renamed from: o */
    public static /* synthetic */ String m74107o(C12329u c12329u) {
        return c12329u.f57070i;
    }

    /* renamed from: p */
    public static /* synthetic */ String m74108p(C12329u c12329u) {
        return c12329u.mSyncType;
    }

    /* renamed from: q */
    public static /* synthetic */ String m74109q(C12329u c12329u) {
        return c12329u.traceId;
    }

    /* renamed from: r */
    public static /* synthetic */ String m74110r(C12329u c12329u) {
        return c12329u.mSyncType;
    }

    /* renamed from: s */
    public static /* synthetic */ String m74111s(C12329u c12329u) {
        return c12329u.mDataType;
    }

    /* renamed from: A */
    public final void m74112A(List<SyncData> list, Map<String, List<Attachment>> map, Map<String, List<Attachment>> map2) throws Throwable {
        if (this.f57063b.isEmpty()) {
            m74127P(list);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (b bVar : this.f57063b.values()) {
            int iM74138c = bVar.m74138c();
            if (iM74138c == 2) {
                arrayList2.add(bVar);
            } else if (iM74138c == 3) {
                arrayList.add(bVar);
            }
        }
        C11839m.m70686d("LostFileRefundImpl", "before filter, abnormal size = " + arrayList2.size() + ", original lost size = " + arrayList.size());
        m74135z(arrayList2, map);
        m74113B(arrayList, map2, map);
        C11839m.m70686d("LostFileRefundImpl", "after filter, abnormal size = " + map.size() + ", original lost size = " + map2.size());
    }

    /* renamed from: B */
    public final void m74113B(List<b> list, Map<String, List<Attachment>> map, Map<String, List<Attachment>> map2) throws Throwable {
        C11839m.m70688i("LostFileRefundImpl", "start filterToFixOriginalLostData");
        for (b bVar : list) {
            String strM74137b = bVar.m74137b();
            SyncData syncDataM74139d = bVar.m74139d();
            List<Attachment> attachments = bVar.m74136a().getAttachments();
            ArrayList arrayList = new ArrayList();
            if (attachments != null && !attachments.isEmpty()) {
                m74134y(attachments);
                List<Attachment> listM74114C = m74114C(strM74137b, attachments, arrayList);
                C11839m.m70688i("LostFileRefundImpl", "syncV2 recordId = " + strM74137b + ", refundSize = " + listM74114C.size() + ", cloud exist = " + attachments.size());
                m74123L(strM74137b, attachments.size(), listM74114C, map2, arrayList);
            }
            List<UnstructData> fileList = syncDataM74139d.getFileList();
            if (fileList == null) {
                C11839m.m70689w("LostFileRefundImpl", "local fileList is null, recordId = " + strM74137b);
                m74129t();
                this.f57068g.put(strM74137b, arrayList);
            } else {
                m74132w(strM74137b, fileList, map2);
                if (fileList.isEmpty()) {
                    this.f57069h.add(strM74137b);
                } else {
                    List<Attachment> listM74115D = m74115D(strM74137b, fileList, arrayList);
                    C11839m.m70688i("LostFileRefundImpl", "syncV2 recordId = " + strM74137b + ", refundSize = " + listM74115D.size() + ", cloud not exist = " + fileList.size());
                    m74123L(strM74137b, fileList.size(), listM74115D, map, arrayList);
                }
            }
        }
    }

    /* renamed from: C */
    public final List<Attachment> m74114C(String str, List<Attachment> list, List<String> list2) throws Throwable {
        ArrayList arrayList = new ArrayList();
        for (Attachment attachment : list) {
            String usage = attachment.getUsage();
            try {
                File fileM63442h = C10278a.m63442h(this.f57070i + "/" + usage);
                if (m74117F(usage, fileM63442h)) {
                    String strM85045a = C14165b.m85035h(fileM63442h).m85045a();
                    String sha256 = attachment.getSha256();
                    if (TextUtils.equals(strM85045a, sha256)) {
                        Attachment attachment2 = new Attachment();
                        Asset assetM74121J = m74121J(fileM63442h);
                        assetM74121J.setId(attachment.getAssetId());
                        attachment2.setAsset(assetM74121J);
                        attachment2.setUsage(usage);
                        attachment2.setHash(assetM74121J.getResource().getHash());
                        attachment2.setSha256(assetM74121J.getResource().getSha256());
                        attachment2.setLength(fileM63442h.length());
                        arrayList.add(attachment2);
                    } else {
                        C11839m.m70689w("LostFileRefundImpl", "syncV2 file sha256 not equal, fileName = " + usage + ", recordId = " + str);
                        C11839m.m70686d("LostFileRefundImpl", "syncV2 file sha256 not equal, localSha256 = " + strM85045a + ", cloudSha256 = " + sha256);
                        m74119H();
                        m74129t();
                        list2.add(usage);
                    }
                } else {
                    C11839m.m70689w("LostFileRefundImpl", "syncV2 local file not exsit, fileName = " + usage + ", recordId = " + str);
                    m74119H();
                    m74129t();
                    list2.add(usage);
                }
            } catch (Exception e10) {
                C11839m.m70687e("LostFileRefundImpl", "syncV2 abnormal lost error " + e10.getMessage());
                m74129t();
                list2.add(usage);
            }
        }
        return arrayList;
    }

    /* renamed from: D */
    public final List<Attachment> m74115D(String str, List<UnstructData> list, List<String> list2) throws Throwable {
        ArrayList arrayList = new ArrayList();
        Iterator<UnstructData> it = list.iterator();
        while (it.hasNext()) {
            String name = it.next().getName();
            try {
                File fileM63442h = C10278a.m63442h(this.f57070i + "/" + name);
                if (m74117F(name, fileM63442h)) {
                    Attachment attachment = new Attachment();
                    Asset assetM74121J = m74121J(fileM63442h);
                    attachment.setAsset(assetM74121J);
                    attachment.setUsage(name);
                    attachment.setHash(assetM74121J.getResource().getHash());
                    attachment.setSha256(assetM74121J.getResource().getSha256());
                    attachment.setLength(fileM63442h.length());
                    arrayList.add(attachment);
                } else {
                    C11839m.m70689w("LostFileRefundImpl", "syncV2 local file not exsit, fileName = " + name + ", recordId = " + str);
                    m74119H();
                    m74129t();
                    list2.add(name);
                }
            } catch (Exception e10) {
                C11839m.m70687e("LostFileRefundImpl", "syncV2 original lost error " + e10.getMessage());
                m74129t();
                list2.add(name);
            }
        }
        return arrayList;
    }

    /* renamed from: E */
    public final boolean m74116E(Record record) {
        List<Attachment> attachments = record.getAttachments();
        if (attachments != null && !attachments.isEmpty()) {
            for (Attachment attachment : attachments) {
                if (attachment != null && attachment.getStatus() != null && C2985n.m17937g(attachment.getStatus().intValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: F */
    public final boolean m74117F(String str, File file) {
        try {
            return CloudSyncUtil.m16021k(this.mContext, 3, this.mSyncType, this.mSyncModulePackageName, file, str, "upload_record_with_lost_file");
        } catch (C9722c unused) {
            return false;
        }
    }

    /* renamed from: G */
    public final Map<String, List<Attachment>> m74118G(Map<String, List<Attachment>> map, Map<String, List<Attachment>> map2) {
        List<Attachment> list;
        if (map2 == null || map2.size() <= 0) {
            return map;
        }
        HashMap map3 = new HashMap();
        if (map2.size() > 0) {
            Iterator<Map.Entry<String, List<Attachment>>> it = map2.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, List<Attachment>> next = it.next();
                String key = next.getKey();
                List<Attachment> value = next.getValue();
                if (value == null) {
                    it.remove();
                } else if (map.containsKey(key) && (list = map.get(key)) != null) {
                    list.addAll(value);
                    it.remove();
                }
            }
        }
        if (map.size() > 0) {
            map3.putAll(map);
        }
        if (map2.size() > 0) {
            map3.putAll(map2);
        }
        return map3;
    }

    /* renamed from: H */
    public final void m74119H() {
        C2985n.m17943m(this.mContext, this.mSyncType, this.mDataType);
        C11839m.m70688i("LostFileRefundImpl", "no need retry refund, update time");
    }

    /* renamed from: I */
    public final void m74120I(List<Future> list, List<String> list2) throws C9722c {
        if (list == null || list2 == null) {
            C11839m.m70689w("LostFileRefundImpl", "parseFutureResult param is null");
            return;
        }
        for (Future future : list) {
            if (future != null) {
                try {
                    String str = future.get() == null ? null : (String) future.get();
                    if (str != null) {
                        list2.add(str);
                    }
                } catch (InterruptedException | ExecutionException e10) {
                    C11839m.m70687e("LostFileRefundImpl", "syncv2 upload parseFutureResult error: " + e10.toString());
                    m74129t();
                    if (!C0209d.m1333z1(this.mContext)) {
                        throw new C9722c(2028, "syncv2 upload file, parseFutureResult " + e10.getMessage(), this.mSyncType, "local_upload");
                    }
                }
            }
        }
    }

    /* renamed from: J */
    public final Asset m74121J(File file) throws Throwable {
        Asset asset = new Asset();
        asset.setMimeType(C14034a.m84169f(file));
        Resource resource = new Resource();
        String strM85040m = C14165b.m85040m(file);
        resource.setHash(C14165b.m85042o(strM85040m));
        resource.setSha256(C14165b.m85035h(file).m85045a());
        resource.setLength(Long.valueOf(file.length()));
        asset.setResource(resource);
        asset.setCipher(CloudSyncUtil.m16059y(this.traceId, this.mSyncType, strM85040m));
        return asset;
    }

    /* renamed from: K */
    public final void m74122K(List<String> list, List<FailRet> list2) {
        if (list.size() > 0) {
            this.f57067f.addAll(list);
        }
        if (list2.size() > 0) {
            m74129t();
            for (FailRet failRet : list2) {
                if (failRet != null && !TextUtils.isEmpty(failRet.getRecordId())) {
                    String recordId = failRet.getRecordId();
                    List<String> arrayList = this.f57068g.get(recordId);
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    String usage = failRet.getUsage();
                    if (!TextUtils.isEmpty(usage) && !arrayList.contains(usage)) {
                        arrayList.add(usage);
                    }
                    this.f57068g.put(recordId, arrayList);
                }
            }
        }
    }

    /* renamed from: L */
    public final void m74123L(String str, int i10, List<Attachment> list, Map<String, List<Attachment>> map, List<String> list2) {
        if (!list.isEmpty()) {
            map.put(str, list);
        }
        if (list.size() < i10) {
            this.f57068g.put(str, list2);
        }
    }

    /* renamed from: M */
    public final Map<String, List<Attachment>> m74124M(Map<String, List<Attachment>> map) throws Throwable {
        if (map == null || map.size() <= 0) {
            return new HashMap();
        }
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            int maxBatchNum = getMaxBatchNum();
            HashMap map3 = new HashMap();
            for (Map.Entry<String, List<Attachment>> entry : map.entrySet()) {
                map3.put(entry.getKey(), entry.getValue());
                if (map3.size() == maxBatchNum) {
                    Map<String, List<Attachment>> mapCreateLostAssets = createLostAssets(this.mSyncType, this.mDataType, map3, arrayList);
                    map3.clear();
                    if (mapCreateLostAssets.size() > 0) {
                        map2.putAll(mapCreateLostAssets);
                    }
                }
            }
            if (map3.size() > 0) {
                Map<String, List<Attachment>> mapCreateLostAssets2 = createLostAssets(this.mSyncType, this.mDataType, map3, arrayList);
                if (mapCreateLostAssets2.size() > 0) {
                    map2.putAll(mapCreateLostAssets2);
                }
            }
            if (arrayList.size() > 0) {
                m74129t();
            }
        } catch (C9722c e10) {
            C11839m.m70687e("LostFileRefundImpl", "syncV2 lost asset create error, code = " + e10.m60666c() + ", msg = " + e10.getMessage());
            m74129t();
        } catch (Exception e11) {
            C11839m.m70687e("LostFileRefundImpl", "syncV2 lost asset create error, msg = " + e11.getMessage());
            m74129t();
        }
        C11839m.m70688i("LostFileRefundImpl", "syncv2 lost asset create, suc size = " + map2.size() + ", fail size = " + arrayList.size());
        return map2;
    }

    /* renamed from: N */
    public final Map<String, List<Attachment>> m74125N(Map<String, List<Attachment>> map) {
        if (map == null || map.size() <= 0) {
            return new HashMap();
        }
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            int maxBatchNum = getMaxBatchNum();
            HashMap map3 = new HashMap();
            for (Map.Entry<String, List<Attachment>> entry : map.entrySet()) {
                map3.put(entry.getKey(), entry.getValue());
                if (map3.size() == maxBatchNum) {
                    Map<String, List<Attachment>> mapCreateLostAssetRevision = createLostAssetRevision(this.mSyncType, this.mDataType, map3, arrayList, "upload_record_with_lost_file");
                    map3.clear();
                    if (mapCreateLostAssetRevision.size() > 0) {
                        map2.putAll(mapCreateLostAssetRevision);
                    }
                }
            }
            if (map3.size() > 0) {
                Map<String, List<Attachment>> mapCreateLostAssetRevision2 = createLostAssetRevision(this.mSyncType, this.mDataType, map3, arrayList, "upload_record_with_lost_file");
                if (mapCreateLostAssetRevision2.size() > 0) {
                    map2.putAll(mapCreateLostAssetRevision2);
                }
            }
            if (arrayList.size() > 0) {
                m74129t();
            }
        } catch (C9722c e10) {
            C11839m.m70687e("LostFileRefundImpl", "syncV2 lost revision create error, code = " + e10.m60666c() + ", msg = " + e10.getMessage());
            m74129t();
        } catch (Exception e11) {
            C11839m.m70687e("LostFileRefundImpl", "syncV2 lost revision create error, msg = " + e11.getMessage());
            m74129t();
        }
        C11839m.m70688i("LostFileRefundImpl", "syncv2 lost revision create, suc size = " + map2.size() + ", fail size = " + arrayList.size());
        return map2;
    }

    /* renamed from: O */
    public void m74126O(List<Record> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (Record record : list) {
            String id2 = record.getId();
            if (!TextUtils.isEmpty(id2)) {
                this.f57062a.put(id2, record);
            }
        }
        C11839m.m70688i("LostFileRefundImpl", "reset cloud lost map = " + this.f57062a.size());
    }

    /* renamed from: P */
    public void m74127P(List<SyncData> list) {
        Record record;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (SyncData syncData : list) {
            if (syncData != null) {
                String guid = syncData.getGuid();
                if (!TextUtils.isEmpty(guid) && !this.f57062a.isEmpty() && (record = this.f57062a.get(guid)) != null) {
                    b bVar = new b();
                    bVar.m74141f(guid);
                    bVar.m74142g(record.getStatus().intValue());
                    bVar.m74140e(record);
                    bVar.m74143h(syncData);
                    this.f57063b.put(guid, bVar);
                }
            }
        }
        C11839m.m70688i("LostFileRefundImpl", "syncv2 setBatchLostData, batch avaliable data size = " + this.f57063b.size());
    }

    /* renamed from: Q */
    public final List<String> m74128Q(Map<String, List<Attachment>> map) {
        ExecutorService executorService;
        C11839m.m70688i("LostFileRefundImpl", "syncv2 upload lost start, size: " + map.size());
        if (this.f57071j == null) {
            C11839m.m70689w("LostFileRefundImpl", "ExecutorService is null, create it");
            this.f57071j = Executors.newFixedThreadPool(3);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            try {
                for (Map.Entry<String, List<Attachment>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    List<Attachment> value = entry.getValue();
                    if (value != null && value.size() > 0) {
                        arrayList.add(this.f57071j.submit(new c(key, value)));
                    }
                }
                m74120I(arrayList, arrayList2);
                executorService = this.f57071j;
            } catch (Exception e10) {
                C11839m.m70687e("LostFileRefundImpl", "syncv2 upload lost exception: " + e10.getMessage());
                m74129t();
                executorService = this.f57071j;
                if (executorService != null) {
                }
            }
            if (executorService != null) {
                executorService.shutdown();
            }
            C11839m.m70688i("LostFileRefundImpl", "syncv2 upload lost file end, suc size: " + arrayList2.size());
            return arrayList2;
        } catch (Throwable th2) {
            ExecutorService executorService2 = this.f57071j;
            if (executorService2 != null) {
                executorService2.shutdown();
            }
            throw th2;
        }
    }

    /* renamed from: t */
    public final void m74129t() {
        this.f57064c = false;
    }

    /* renamed from: u */
    public void m74130u(List<SyncData> list, String str) throws Throwable {
        String message;
        if (list == null || list.size() <= 0) {
            return;
        }
        C11839m.m70688i("LostFileRefundImpl", "syncV2 start doLostRefund");
        if (!C2985n.m17935e(this.mSyncType)) {
            C11839m.m70689w("LostFileRefundImpl", "syncV2 not support lostRefund");
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            try {
                C11839m.m70688i("LostFileRefundImpl", "syncV2 batch lost size = " + list.size());
                this.f57072k = list.size();
                this.f57070i = str;
                m74127P(list);
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                m74112A(list, map, map2);
                C11839m.m70688i("LostFileRefundImpl", "syncV2 only need update status = " + this.f57069h.toString());
                Map<String, List<Attachment>> mapM74118G = m74118G(m74125N(map), m74124M(map2));
                C11839m.m70688i("LostFileRefundImpl", "syncV2 after merge refund size = " + mapM74118G.size());
                if (mapM74118G.size() > 0) {
                    List<String> listM74128Q = m74128Q(mapM74118G);
                    C11839m.m70688i("LostFileRefundImpl", "syncV2 file upload suc size = " + listM74128Q.size());
                    List<String> listM74131v = m74131v(listM74128Q);
                    C11839m.m70688i("LostFileRefundImpl", "syncV2 after upload need update status size = " + listM74131v.size());
                    if (!listM74131v.isEmpty()) {
                        this.f57069h.addAll(listM74131v);
                    }
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                C11839m.m70688i("LostFileRefundImpl", "syncV2 all need update status size = " + this.f57069h.size());
                updateRecordLostStatus(this.f57069h, arrayList, arrayList2, "upload_record_with_lost_file");
                m74122K(arrayList, arrayList2);
                if (this.f57064c) {
                    C2985n.m17942l(this.mContext, this.mSyncType, this.mDataType);
                    C2985n.m17943m(this.mContext, this.mSyncType, this.mDataType);
                    C11839m.m70686d("LostFileRefundImpl", "syncV2 update lost cursor and time");
                }
                C11839m.m70688i("LostFileRefundImpl", "syncV2 finally sucList = " + arrayList.toString() + ", failList = " + this.f57068g.keySet().toString());
                linkedHashMap.put("syncType", this.mSyncType);
                linkedHashMap.put("dataType", this.mDataType);
                linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                linkedHashMap.put("batchAvaliableLostSize", this.f57063b.keySet().toString());
                linkedHashMap.put("successList", this.f57067f.toString());
                linkedHashMap.put("failList", this.f57068g.toString());
                linkedHashMap.put("sucSize", String.valueOf(this.f57067f.size()));
                linkedHashMap.put("failSize", String.valueOf(this.f57068g.size()));
                C10812z.m65844m("mecloud_sync_lost_refund", linkedHashMap);
                C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, 0, "", "03001", "upload_record_with_lost_file", this.traceId, linkedHashMap, false);
            } catch (Throwable th2) {
                th = th2;
                message = "";
                linkedHashMap.put("syncType", this.mSyncType);
                linkedHashMap.put("dataType", this.mDataType);
                linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                linkedHashMap.put("batchAvaliableLostSize", this.f57063b.keySet().toString());
                linkedHashMap.put("successList", this.f57067f.toString());
                linkedHashMap.put("failList", this.f57068g.toString());
                linkedHashMap.put("sucSize", String.valueOf(this.f57067f.size()));
                linkedHashMap.put("failSize", String.valueOf(this.f57068g.size()));
                C10812z.m65844m("mecloud_sync_lost_refund", linkedHashMap);
                C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, 0, message, "03001", "upload_record_with_lost_file", this.traceId, linkedHashMap, false);
                C11839m.m70688i("LostFileRefundImpl", "syncV2 end doLostRefund");
                throw th;
            }
        } catch (Exception e10) {
            message = e10.getMessage();
            try {
                C11839m.m70687e("LostFileRefundImpl", "doLostRefund error " + e10.getMessage());
                linkedHashMap.put("syncType", this.mSyncType);
                linkedHashMap.put("dataType", this.mDataType);
                linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                linkedHashMap.put("batchAvaliableLostSize", this.f57063b.keySet().toString());
                linkedHashMap.put("successList", this.f57067f.toString());
                linkedHashMap.put("failList", this.f57068g.toString());
                linkedHashMap.put("sucSize", String.valueOf(this.f57067f.size()));
                linkedHashMap.put("failSize", String.valueOf(this.f57068g.size()));
                C10812z.m65844m("mecloud_sync_lost_refund", linkedHashMap);
                C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, 0, message, "03001", "upload_record_with_lost_file", this.traceId, linkedHashMap, false);
            } catch (Throwable th3) {
                th = th3;
                linkedHashMap.put("syncType", this.mSyncType);
                linkedHashMap.put("dataType", this.mDataType);
                linkedHashMap.putAll(C10812z.m65833b(this.mSyncModulePackageName));
                linkedHashMap.put("batchAvaliableLostSize", this.f57063b.keySet().toString());
                linkedHashMap.put("successList", this.f57067f.toString());
                linkedHashMap.put("failList", this.f57068g.toString());
                linkedHashMap.put("sucSize", String.valueOf(this.f57067f.size()));
                linkedHashMap.put("failSize", String.valueOf(this.f57068g.size()));
                C10812z.m65844m("mecloud_sync_lost_refund", linkedHashMap);
                C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, 0, message, "03001", "upload_record_with_lost_file", this.traceId, linkedHashMap, false);
                C11839m.m70688i("LostFileRefundImpl", "syncV2 end doLostRefund");
                throw th;
            }
        }
        C11839m.m70688i("LostFileRefundImpl", "syncV2 end doLostRefund");
    }

    /* renamed from: v */
    public final List<String> m74131v(List<String> list) {
        if (list == null || list.size() <= 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (this.f57068g.get(str) != null) {
                m74129t();
            } else {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: w */
    public final void m74132w(String str, List<UnstructData> list, Map<String, List<Attachment>> map) {
        if (map.get(str) == null || map.get(str).isEmpty()) {
            return;
        }
        Iterator<UnstructData> it = list.iterator();
        while (it.hasNext()) {
            String name = it.next().getName();
            Iterator<Attachment> it2 = map.get(str).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                } else if (TextUtils.equals(name, it2.next().getUsage())) {
                    it.remove();
                    break;
                }
            }
        }
    }

    /* renamed from: x */
    public void m74133x(List<Record> list, String str) {
        StringBuilder sb2;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (!C2985n.m17935e(this.mSyncType)) {
            C11839m.m70689w("LostFileRefundImpl", "syncV2 not support lostRefund");
            return;
        }
        C11839m.m70688i("LostFileRefundImpl", "before filterLost, lostSize = " + list.size());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        try {
            try {
                for (Record record : list) {
                    if (record != null && !m74116E(record)) {
                        arrayList.add(record.getId());
                    }
                }
                if (!arrayList.isEmpty()) {
                    C11839m.m70688i("LostFileRefundImpl", "filterLost, to only update record size = " + arrayList.size() + ", " + arrayList.toString());
                    updateRecordLostStatus(arrayList, arrayList2, arrayList3, str);
                }
            } catch (Exception e10) {
                C11839m.m70687e("LostFileRefundImpl", "filterLost error " + e10.getMessage());
                if (arrayList2.isEmpty()) {
                    return;
                }
                Iterator<Record> it = list.iterator();
                while (it.hasNext()) {
                    Record next = it.next();
                    if (next != null && arrayList2.contains(next.getId())) {
                        it.remove();
                    }
                }
                sb2 = new StringBuilder();
            }
            if (arrayList2.isEmpty()) {
                return;
            }
            Iterator<Record> it2 = list.iterator();
            while (it2.hasNext()) {
                Record next2 = it2.next();
                if (next2 != null && arrayList2.contains(next2.getId())) {
                    it2.remove();
                }
            }
            sb2 = new StringBuilder();
            sb2.append("after filterLost, lostSize = ");
            sb2.append(list.size());
            C11839m.m70688i("LostFileRefundImpl", sb2.toString());
        } catch (Throwable th2) {
            if (!arrayList2.isEmpty()) {
                Iterator<Record> it3 = list.iterator();
                while (it3.hasNext()) {
                    Record next3 = it3.next();
                    if (next3 != null && arrayList2.contains(next3.getId())) {
                        it3.remove();
                    }
                }
                C11839m.m70688i("LostFileRefundImpl", "after filterLost, lostSize = " + list.size());
            }
            throw th2;
        }
    }

    /* renamed from: y */
    public final void m74134y(List<Attachment> list) {
        Iterator<Attachment> it = list.iterator();
        while (it.hasNext()) {
            Attachment next = it.next();
            if (next.getStatus() != null && !C2985n.m17937g(next.getStatus().intValue())) {
                it.remove();
            }
        }
    }

    /* renamed from: z */
    public final void m74135z(List<b> list, Map<String, List<Attachment>> map) throws Throwable {
        C11839m.m70688i("LostFileRefundImpl", "start filterToFixAbnormalData");
        for (b bVar : list) {
            String strM74137b = bVar.m74137b();
            List<Attachment> attachments = bVar.m74136a().getAttachments();
            ArrayList arrayList = new ArrayList();
            if (attachments == null) {
                C11839m.m70689w("LostFileRefundImpl", "syncv2 attachments is null, continue");
                m74129t();
                this.f57068g.put(strM74137b, arrayList);
            } else {
                m74134y(attachments);
                if (attachments.isEmpty()) {
                    this.f57069h.add(strM74137b);
                } else {
                    List<Attachment> listM74114C = m74114C(strM74137b, attachments, arrayList);
                    C11839m.m70688i("LostFileRefundImpl", "syncV2 recordId = " + strM74137b + ", toRefundSize = " + listM74114C.size());
                    m74123L(strM74137b, attachments.size(), listM74114C, map, arrayList);
                }
            }
        }
    }
}
