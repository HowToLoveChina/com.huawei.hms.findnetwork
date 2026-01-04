package vc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.contact.C2878c;
import com.huawei.android.hicloud.sync.service.aidl.SerializableMap;
import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicService;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicServiceUtil;
import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import com.huawei.android.hicloud.sync.syncimpl.FileProcess;
import com.huawei.android.hicloud.sync.syncutil.C2977f;
import com.huawei.android.hicloud.sync.syncutil.C2980i;
import com.huawei.android.hicloud.sync.syncutil.C2981j;
import com.huawei.android.hicloud.sync.syncutil.C2984m;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Attachment;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRet;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Record;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Resource;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import fk.C9721b;
import fk.C9722c;
import gp.C10028c;
import hk.C10278a;
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
import p818yp.C14034a;
import sc.C12771d;
import sc.C12772e;
import sc.C12773f;
import tc.C13007b;
import za.C14165b;

/* renamed from: vc.i */
/* loaded from: classes3.dex */
public class C13405i extends C2878c {

    /* renamed from: H */
    public static long f60478H;

    /* renamed from: A */
    public final ConcurrentHashMap<String, Integer> f60479A;

    /* renamed from: B */
    public final ConcurrentHashMap<String, List<String>> f60480B;

    /* renamed from: C */
    public Map<String, String> f60481C;

    /* renamed from: D */
    public ExecutorService f60482D;

    /* renamed from: E */
    public int f60483E;

    /* renamed from: F */
    public int f60484F;

    /* renamed from: G */
    public int f60485G;

    /* renamed from: u */
    public C12329u f60486u;

    /* renamed from: v */
    public final String f60487v;

    /* renamed from: w */
    public final Map<String, String> f60488w;

    /* renamed from: x */
    public final CopyOnWriteArrayList<FailRet> f60489x;

    /* renamed from: y */
    public final CopyOnWriteArrayList<FailRet> f60490y;

    /* renamed from: z */
    public final ConcurrentHashMap<String, Integer> f60491z;

    /* renamed from: vc.i$a */
    public class a implements Callable<Record> {

        /* renamed from: a */
        public Record f60492a;

        public a(Record record) {
            this.f60492a = record;
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
                Method dump skipped, instructions count: 2730
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: vc.C13405i.a.call():com.huawei.android.hicloud.syncdrive.cloudsync.model.Record");
        }
    }

    /* renamed from: vc.i$b */
    public class b implements Callable<Record> {

        /* renamed from: a */
        public Record f60494a;

        public b(Record record) {
            this.f60494a = record;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:378:0x08db  */
        /* JADX WARN: Removed duplicated region for block: B:395:0x0998  */
        /* JADX WARN: Removed duplicated region for block: B:407:0x09d1  */
        /* JADX WARN: Type inference failed for: r14v10, types: [java.util.List] */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.huawei.android.hicloud.syncdrive.cloudsync.model.Record call() throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 2539
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: vc.C13405i.b.call():com.huawei.android.hicloud.syncdrive.cloudsync.model.Record");
        }
    }

    public C13405i(Context context, String str, String str2, ArrayList<SyncData> arrayList, ArrayList<SyncData> arrayList2, ArrayList<SyncData> arrayList3, ArrayList<UnstructData> arrayList4, ArrayList<String> arrayList5, boolean z10, String str3, String str4, String str5, C12329u c12329u, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        super(context, str, str2, str3, str4, str5, concurrentHashMap);
        this.f60486u = null;
        this.f60488w = new HashMap();
        this.f60489x = new CopyOnWriteArrayList<>();
        this.f60490y = new CopyOnWriteArrayList<>();
        this.f60491z = new ConcurrentHashMap<>();
        this.f60479A = new ConcurrentHashMap<>();
        this.f60480B = new ConcurrentHashMap<>();
        this.f60481C = new HashMap();
        this.f60483E = 10;
        this.f60484F = 50;
        this.f60485G = 50;
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
            this.f60486u = c12329u;
        }
        this.f12821i = z10;
        this.f12813a = this.mContext.getFilesDir() + "/sync/" + this.mDataType + "/sync_upload";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f12813a);
        sb2.append("/");
        sb2.append("sync_upload.zip");
        this.f60487v = sb2.toString();
        if ("addressbook".equals(this.mSyncType)) {
            this.f60483E = 100;
        } else if ("notepad".equals(this.mSyncType)) {
            this.f60483E = 1;
        }
        C11839m.m70688i("UploadDataImpl", "Sync type = " + str + ", dataType = " + this.mDataType + " , mHaveFile = " + this.f12821i + " , mAdd = " + this.f12823k.toString() + " , mModify = " + this.f12822j.toString() + " , mLost = " + this.f12825m.toString() + " , mDelete = " + this.f12826n.toString());
    }

    /* renamed from: A */
    public static /* synthetic */ boolean m80592A(C13405i c13405i, List list, Record record, StringBuilder sb2) throws C9722c {
        return c13405i.m17337p(list, record, sb2);
    }

    /* renamed from: A0 */
    public static /* synthetic */ void m80593A0(C13405i c13405i, String str, String str2, int i10, String str3, List list) {
        c13405i.m80699v1(str, str2, i10, str3, list);
    }

    /* renamed from: B */
    public static /* synthetic */ void m80594B(C13405i c13405i, String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        c13405i.reportUploadFileBIEvent(str, str2, str3, str4, i10, str5, str6, str7);
    }

    /* renamed from: C */
    public static /* synthetic */ void m80596C(C13405i c13405i) throws C9722c {
        c13405i.isCancel();
    }

    /* renamed from: D */
    public static /* synthetic */ String m80598D(C13405i c13405i) {
        return c13405i.f12813a;
    }

    /* renamed from: E */
    public static /* synthetic */ void m80600E(C13405i c13405i, String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        c13405i.reportUploadFileBIEvent(str, str2, str3, str4, i10, str5, str6, str7);
    }

    /* renamed from: F */
    public static /* synthetic */ void m80602F(C13405i c13405i, String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        c13405i.reportUploadFileBIEvent(str, str2, str3, str4, i10, str5, str6, str7);
    }

    /* renamed from: G */
    public static /* synthetic */ String m80604G(C13405i c13405i) {
        return c13405i.mSyncType;
    }

    /* renamed from: H */
    public static /* synthetic */ String m80606H(C13405i c13405i) {
        return c13405i.traceId;
    }

    /* renamed from: I */
    public static /* synthetic */ boolean m80608I(C13405i c13405i) {
        return c13405i.isAbortSyncNowThrowException();
    }

    /* renamed from: J */
    public static /* synthetic */ String m80610J(C13405i c13405i) {
        return c13405i.mSyncType;
    }

    /* renamed from: K */
    public static /* synthetic */ String m80612K(C13405i c13405i) {
        return c13405i.mDataType;
    }

    /* renamed from: K0 */
    public static /* synthetic */ void m80613K0(C13405i c13405i, String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        c13405i.reportUploadFileBIEvent(str, str2, str3, str4, i10, str5, str6, str7);
    }

    /* renamed from: L */
    public static /* synthetic */ String m80614L(C13405i c13405i) {
        return c13405i.mSyncModulePackageName;
    }

    /* renamed from: L0 */
    public static /* synthetic */ void m80615L0(C13405i c13405i, Record record) throws Throwable {
        c13405i.m17336o(record);
    }

    /* renamed from: M */
    public static /* synthetic */ void m80616M(C13405i c13405i, String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        c13405i.reportUploadFileBIEvent(str, str2, str3, str4, i10, str5, str6, str7);
    }

    /* renamed from: M0 */
    public static /* synthetic */ CopyOnWriteArrayList m80617M0(C13405i c13405i) {
        return c13405i.f60489x;
    }

    /* renamed from: N */
    public static /* synthetic */ void m80618N(C13405i c13405i) throws C9722c {
        c13405i.isCancel();
    }

    /* renamed from: O */
    public static /* synthetic */ String m80619O(C13405i c13405i) {
        return c13405i.mSyncType;
    }

    /* renamed from: O0 */
    private void m80620O0(int i10) {
        C11839m.m70688i("UploadDataImpl", this.mDataType + " CallBack, value = " + i10);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.SENDCALLBACK");
        intent.putExtra("msgType", this.mSyncType);
        intent.putExtra("msgID", 10007);
        Bundle bundle = new Bundle();
        boolean z10 = true;
        if (this.mIsPartialSuc) {
            bundle.putBoolean("fail_error_need_update_sync_result", true);
        }
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putString("sync_module_package_name", this.mSyncModulePackageName);
        m80701x1();
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
                C11839m.m70688i("UploadDataImpl", this.mDataType + " failUnstructIdMap.size(): " + this.f12819g.size() + ", failStructIdMap.size(): " + this.f12818f.size());
            } else {
                C11839m.m70688i("UploadDataImpl", this.mDataType + " mAddSuc.size = " + this.f12827o.size() + " mModifySuc.size = " + this.f12828p.size() + " mDeleteSuc.size = " + this.f12829q.size());
                bundle.putParcelableArrayList("cadd", this.f12827o);
                bundle.putParcelableArrayList("cmod", this.f12828p);
                bundle.putStringArrayList("cdel", this.f12829q);
                SerializableMap serializableMap2 = new SerializableMap();
                serializableMap2.setMap(SyncLogicServiceUtil.buildFailErrorCodeMap(this.f12818f));
                bundle.putSerializable("fail_error_code_map", serializableMap2);
                C11839m.m70688i("UploadDataImpl", this.mDataType + " failStructIdMap.size() : " + this.f12818f.size());
            }
            boolean z11 = (this.f12827o.isEmpty() && this.f12828p.isEmpty() && this.f12829q.isEmpty()) ? false : true;
            boolean z12 = (this.f12814b.isEmpty() && this.f12832t.isEmpty()) ? false : true;
            if (!z11 && !z12) {
                z10 = false;
            }
            CloudSyncUtil.m16032n1(z10);
            C10812z.m65840i(this.mContext, this.mSyncType, this.mDataType, 0, "", this.operationType, "local_upload", this.traceId);
        }
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.mContext).m78881d(intent);
        CloudSyncUtil.m15993a1(this.mContext, this.mSyncType, i10);
    }

    /* renamed from: P */
    public static /* synthetic */ String m80621P(C13405i c13405i) {
        return c13405i.mDataType;
    }

    /* renamed from: Q */
    public static /* synthetic */ Asset m80622Q(C13405i c13405i, String str, String str2, String str3, String str4, String str5, String str6, Asset asset, String str7) throws C9722c {
        return c13405i.updateSingleAssetRevision(str, str2, str3, str4, str5, str6, asset, str7);
    }

    /* renamed from: R */
    public static /* synthetic */ void m80623R(C13405i c13405i, String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        c13405i.reportUploadFileBIEvent(str, str2, str3, str4, i10, str5, str6, str7);
    }

    /* renamed from: S */
    public static /* synthetic */ long m80624S(long j10) {
        long j11 = f60478H + j10;
        f60478H = j11;
        return j11;
    }

    /* renamed from: T */
    public static /* synthetic */ FailRet m80625T(C13405i c13405i) {
        return c13405i.needAbortSync;
    }

    /* renamed from: U */
    public static /* synthetic */ Context m80626U(C13405i c13405i) {
        return c13405i.mContext;
    }

    /* renamed from: V */
    public static /* synthetic */ String m80627V(C13405i c13405i) {
        return c13405i.mSyncType;
    }

    /* renamed from: W */
    public static /* synthetic */ String m80628W(C13405i c13405i) {
        return c13405i.traceId;
    }

    /* renamed from: X */
    public static /* synthetic */ int m80629X(C13405i c13405i) {
        return c13405i.f12820h;
    }

    /* renamed from: Y */
    public static /* synthetic */ void m80630Y(C13405i c13405i, Context context, String str, String str2, int i10, int i11) {
        c13405i.checkUploadFileException(context, str, str2, i10, i11);
    }

    /* renamed from: Z */
    public static /* synthetic */ void m80631Z(C13405i c13405i, String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        c13405i.reportUploadFileBIEvent(str, str2, str3, str4, i10, str5, str6, str7);
    }

    /* renamed from: a0 */
    public static /* synthetic */ void m80632a0(C13405i c13405i, String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        c13405i.reportUploadFileBIEvent(str, str2, str3, str4, i10, str5, str6, str7);
    }

    /* renamed from: e0 */
    public static /* synthetic */ FailRet m80636e0(C13405i c13405i) {
        return c13405i.needAbortSync;
    }

    /* renamed from: g1 */
    private void m80639g1(List<Future> list, List<Record> list2) throws C9722c {
        if (list == null || list2 == null) {
            C11839m.m70689w("UploadDataImpl", "parseFutureResult param is null");
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
                    C11839m.m70687e("UploadDataImpl", "syncv2 upload parseFutureResult error: " + e10.toString());
                    if (!C0209d.m1333z1(this.mContext)) {
                        throw new C9722c(2028, "syncv2 upload file, parseFutureResult " + e10.getMessage(), this.mSyncType, "local_upload");
                    }
                }
            }
        }
    }

    /* renamed from: p0 */
    public static /* synthetic */ CopyOnWriteArrayList m80648p0(C13405i c13405i) {
        return c13405i.f60490y;
    }

    /* renamed from: w */
    public static /* synthetic */ Map m80655w(C13405i c13405i) {
        return c13405i.f12816d;
    }

    /* renamed from: x */
    public static /* synthetic */ void m80657x(C13405i c13405i) throws C9722c {
        c13405i.isCancel();
    }

    /* renamed from: y */
    public static /* synthetic */ void m80659y(C13405i c13405i, String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        c13405i.reportUploadFileBIEvent(str, str2, str3, str4, i10, str5, str6, str7);
    }

    /* renamed from: z */
    public static /* synthetic */ void m80661z(C13405i c13405i) throws C9722c {
        c13405i.isCancel();
    }

    /* renamed from: A1 */
    public final void m80663A1(ArrayList<SyncData> arrayList) {
        int sdkVersion;
        if (arrayList == null || arrayList.size() == 0 || (sdkVersion = SyncLogicService.getSdkVersion(this.mSyncModulePackageName)) < 104) {
            return;
        }
        Iterator<SyncData> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().setVersion(sdkVersion);
        }
    }

    /* renamed from: B1 */
    public final List<Record> m80664B1(List<Record> list) throws C9722c {
        C11839m.m70688i("UploadDataImpl", "syncv2 upload add file start, size: " + list.size());
        m80668P0();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        isCancel();
        try {
            for (Record record : list) {
                isCancel();
                arrayList.add(this.f60482D.submit(new a(record)));
            }
            m80639g1(arrayList, arrayList2);
        } catch (Exception e10) {
            C11839m.m70687e("UploadDataImpl", "syncv2 upload add file exception: " + e10.getMessage());
        }
        C11839m.m70688i("UploadDataImpl", "syncv2 upload add file end, successList size: " + arrayList2.size());
        return arrayList2;
    }

    /* renamed from: C1 */
    public int m80665C1() {
        File file;
        C11839m.m70688i("UploadDataImpl", this.mDataType + " syncV2 Begin uploadDataV2");
        long jCurrentTimeMillis = System.currentTimeMillis();
        String message = "";
        int iM80679a1 = 0;
        try {
            try {
            } catch (C9722c e10) {
                C11839m.m70687e("UploadDataImpl", "Upload data v2, errorCode " + e10.m60666c() + ", errorMsg = " + e10.toString());
                message = e10.getMessage();
                iM80679a1 = m80679a1(e10);
                C10812z.m65841j(this.mContext, e10.m60668e(), this.mDataType, e10.m60666c(), e10.m60667d(), e10.getMessage(), this.operationType, e10.m60665b(), this.traceId);
                file = new File(this.f12813a);
            } catch (Exception e11) {
                message = e11.getMessage();
                iM80679a1 = 5;
                C11839m.m70687e("UploadDataImpl", "Upload data v2, error: " + e11.toString());
                C10812z.m65840i(this.mContext, this.mSyncType, this.mDataType, 5, e11.toString(), this.operationType, "local_upload", this.traceId);
                file = new File(this.f12813a);
            }
            if (C10028c.m62182c0().m62206E1()) {
                throw new C9722c(FamilyShareConstants.MessageCode.GET_FAMILY_IMAGE, "Incremental migration", this.mSyncType, "local_upload");
            }
            m80663A1(this.f12823k);
            m80663A1(this.f12822j);
            m80663A1(this.f12825m);
            m80680b1();
            if (this.f12821i) {
                C2980i.m17882q(this.mReportEndInfo, true);
                m80698u1();
            } else {
                C11839m.m70688i("UploadDataImpl", "syncV2 uploadData, struct data");
                m80691n1();
                m80688k1();
            }
            C12329u c12329u = this.f60486u;
            if (c12329u != null) {
                c12329u.m74130u(this.f12825m, this.f12813a);
            }
            C13007b.m78205Y(this.mContext).m78233N0(this.mDataType, true);
            checkIsHasPartialException(this.mSyncType);
            if (isAbortSyncNowThrowException()) {
                throw new C9722c(this.needAbortSync.getErrCode(), "syncv2 upload file error, need abort sync, errorMsg = " + this.needAbortSync.getErrMsg(), this.mSyncType, "local_upload");
            }
            isCancel();
            file = new File(this.f12813a);
            FileProcess.m17795b(file);
            m80620O0(iM80679a1);
            getPostStructDataRspResult().m17768a();
            reportUploadDataV2(iM80679a1, message, m80681c1());
            C2980i.m17879n(this.mReportEndInfo, iM80679a1, message);
            C2980i.m17875j(this.mReportEndInfo, this.mDataType, this.f12827o.size() + this.f12828p.size() + this.f12814b.size() + this.f12832t.size() + this.f12829q.size());
            C2980i.m17876k(this.mReportEndInfo, this.mDataType, f60478H);
            C2980i.m17877l(this.mReportEndInfo, this.mDataType, System.currentTimeMillis() - jCurrentTimeMillis);
            return iM80679a1;
        } catch (Throwable th2) {
            FileProcess.m17795b(new File(this.f12813a));
            m80620O0(0);
            getPostStructDataRspResult().m17768a();
            reportUploadDataV2(0, "", m80681c1());
            C2980i.m17879n(this.mReportEndInfo, 0, "");
            C2980i.m17875j(this.mReportEndInfo, this.mDataType, this.f12827o.size() + this.f12828p.size() + this.f12814b.size() + this.f12832t.size() + this.f12829q.size());
            C2980i.m17876k(this.mReportEndInfo, this.mDataType, f60478H);
            C2980i.m17877l(this.mReportEndInfo, this.mDataType, System.currentTimeMillis() - jCurrentTimeMillis);
            throw th2;
        }
    }

    /* renamed from: D1 */
    public final List<Record> m80666D1(List<Record> list) throws C9722c {
        C11839m.m70688i("UploadDataImpl", "syncv2 upload modify file start, size: " + list.size());
        m80668P0();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        isCancel();
        try {
            for (Record record : list) {
                isCancel();
                if (record != null) {
                    arrayList.add(this.f60482D.submit(new b(record)));
                }
            }
            m80639g1(arrayList, arrayList2);
        } catch (Exception e10) {
            C11839m.m70687e("UploadDataImpl", "syncv2 upload modify file error: " + e10.toString());
        }
        C11839m.m70688i("UploadDataImpl", "syncv2 upload modify file successList size: " + arrayList2.size());
        return arrayList2;
    }

    /* renamed from: N0 */
    public final List<Attachment> m80667N0(SyncData syncData, Record record, StringBuilder sb2, Map<String, Integer> map) throws Throwable {
        ArrayList arrayList = new ArrayList();
        List<Attachment> attachments = record.getAttachments();
        List<Attachment> list = this.f12817e.get(record.getId());
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (C2981j.m17888b(this.mSyncModulePackageName, this.mDataType)) {
            m80672T0(record, syncData, list, arrayList2, arrayList3, "update_compare_file_change");
        } else {
            m80671S0(attachments, list, arrayList2, arrayList3, "update_compare_file_change");
        }
        sb2.append("addFileSize = ");
        sb2.append(arrayList2.size());
        sb2.append(", modifyFileSize = ");
        sb2.append(arrayList3.size());
        if (arrayList2.size() > 0) {
            isCancel();
            List<Attachment> listM17324c = m17324c(record, arrayList2);
            if (listM17324c == null) {
                C11839m.m70688i("UploadDataImpl", "syncV2 upload file fail, create asset fail, recordId = " + record.getId());
                sb2.append(", addFileResult = ");
                sb2.append(2221);
                return null;
            }
            map.put("addAttachmentCount", Integer.valueOf(listM17324c.size()));
            sb2.append(", addFileResult = 0");
            arrayList.addAll(listM17324c);
        }
        if (arrayList3.size() > 0) {
            isCancel();
            List<Attachment> listM17325d = m17325d(record, arrayList3);
            if (listM17325d == null) {
                C11839m.m70688i("UploadDataImpl", "syncV2 upload file fail, create asset revision fail, recordId = " + record.getId());
                sb2.append(", modifyFileResult = ");
                sb2.append(2221);
                return null;
            }
            map.put("modifyAttachmentCount", Integer.valueOf(listM17325d.size()));
            sb2.append(", modifyFileResult = 0");
            arrayList.addAll(listM17325d);
        }
        return arrayList;
    }

    /* renamed from: P0 */
    public final void m80668P0() {
        if (this.f60482D == null) {
            C11839m.m70689w("UploadDataImpl", "ExecutorService is null, create it");
            this.f60482D = Executors.newFixedThreadPool(3);
        }
    }

    /* renamed from: Q0 */
    public final void m80669Q0(List<Record> list, List<Record> list2, List<Record> list3, String str) throws C9722c {
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
                        C11839m.m70688i("UploadDataImpl", "syncv2 uploadData compareFileNoChange: file no change usage = " + usage + ", recordId = " + id2);
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
        C11839m.m70688i("UploadDataImpl", "syncv2 uploadData compareFileNoChange: modifyNoChangeFileList size = " + list2.size() + ", modifyWithFileList size = " + list3.size());
    }

    /* renamed from: R0 */
    public final void m80670R0(List<SyncData> list, List<Record> list2, List<Record> list3, List<Record> list4, String str) {
        HashMap map = new HashMap();
        for (Record record : list2) {
            map.put(record.getId(), record);
        }
        boolean z10 = false;
        for (SyncData syncData : list) {
            String guid = syncData.getGuid();
            for (UnstructData unstructData : syncData.getFileList()) {
                if (unstructData.getOptType() == 1 || unstructData.getOptType() == 2) {
                    z10 = true;
                    break;
                }
            }
            if (z10) {
                list4.add((Record) map.get(guid));
            } else {
                list3.add((Record) map.get(guid));
            }
        }
        C11839m.m70688i("UploadDataImpl", "syncv2 uploadData compareFileNoChangeRequire: modifyNoChangeFileList size = " + list3.size() + ", modifyWithFileList size = " + list4.size());
    }

    /* renamed from: S0 */
    public final void m80671S0(List<Attachment> list, List<Attachment> list2, List<Attachment> list3, List<Attachment> list4, String str) throws C9722c {
        if (list == null || list.size() <= 0) {
            C11839m.m70689w("UploadDataImpl", "syncv2 uploadData compareFileModify: local attachment is 0, return");
            throw new C9722c(2248, "uploadData file compareFileModify: local attachment is 0", this.mSyncType, str);
        }
        if (list2 == null || list2.size() <= 0) {
            for (Attachment attachment : list) {
                C11839m.m70688i("UploadDataImpl", "syncv2 uploadData compareFileModify: cloudFile size is 0, add local all file, fileName = " + attachment.getUsage() + ", localHash = " + attachment.getHash());
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
                    C11839m.m70688i("UploadDataImpl", "syncv2 uploadData compareFileModify: cloud file null, all add file, add size = " + attachment3.size());
                    list3.add(attachment3);
                } else {
                    String hash2 = attachment4.getHash();
                    if (hash.isEmpty() || hash2.isEmpty()) {
                        C11839m.m70688i("UploadDataImpl", "syncv2 uploadData compareFileModify: add file, fileName = " + usage + ", localHash = " + hash + ", cloudHash = " + hash2);
                        list3.add(attachment3);
                    } else if (!hash.equals(hash2)) {
                        C11839m.m70688i("UploadDataImpl", "syncv2 uploadData compareFileModify: modify file, fileName = " + usage + ", localHash = " + hash + ", cloudHash = " + hash2);
                        attachment3.getAsset().setId(attachment4.getAssetId());
                        list4.add(attachment3);
                    }
                }
            } else {
                C11839m.m70688i("UploadDataImpl", "syncv2 uploadData compareFileModify: cloud not exist, add file, fileName = " + usage + ", localHash = " + hash);
                list3.add(attachment3);
            }
        }
        C11839m.m70688i("UploadDataImpl", "syncV2 uploadData compareFileModify: add file size = " + list3.size() + ", modify file size  = " + list4.size());
    }

    /* renamed from: T0 */
    public final void m80672T0(Record record, SyncData syncData, List<Attachment> list, List<Attachment> list2, List<Attachment> list3, String str) throws Throwable {
        List<UnstructData> fileList = syncData.getFileList();
        if (fileList == null || fileList.size() <= 0) {
            C11839m.m70689w("UploadDataImpl", "syncv2 uploadData compareFileModify: local attachment is 0, return");
            throw new C9722c(2249, "uploadData file compareFileModify: local filelist is 0", this.mSyncType, str);
        }
        if (list == null || list.size() <= 0) {
            for (UnstructData unstructData : fileList) {
                C11839m.m70688i("UploadDataImpl", "syncv2 uploadData compareFileModify: cloudFile size is 0, add local all file, fileName = " + unstructData.getName());
                list2.add(m80673U0(unstructData, str));
            }
            return;
        }
        HashMap map = new HashMap();
        for (Attachment attachment : list) {
            map.put(attachment.getUsage(), attachment);
        }
        ArrayList arrayList = new ArrayList();
        for (UnstructData unstructData2 : fileList) {
            String name = unstructData2.getName();
            Attachment attachmentM80673U0 = m80673U0(unstructData2, str);
            if (unstructData2.getOptType() == 1) {
                list2.add(attachmentM80673U0);
            } else if (unstructData2.getOptType() == 2) {
                if (map.get(name) != null) {
                    Attachment attachment2 = (Attachment) map.get(name);
                    if (attachment2 == null) {
                        C11839m.m70689w("UploadDataImpl", "file local modify, cloud not have, add file");
                        list2.add(attachmentM80673U0);
                    } else {
                        if (attachmentM80673U0.getAsset() != null) {
                            attachmentM80673U0.getAsset().setId(attachment2.getAssetId());
                        }
                        attachmentM80673U0.setAssetId(attachment2.getAssetId());
                        list3.add(attachmentM80673U0);
                    }
                } else {
                    list2.add(attachmentM80673U0);
                }
            }
            arrayList.add(attachmentM80673U0);
        }
        record.setAttachments(arrayList);
        C11839m.m70688i("UploadDataImpl", "syncV2 uploadData compareFileModify: add file size = " + list2.size() + ", modify file size  = " + list3.size() + ", all size = " + arrayList.size());
    }

    /* renamed from: U0 */
    public final Attachment m80673U0(UnstructData unstructData, String str) throws Throwable {
        try {
            Attachment attachment = new Attachment();
            String name = unstructData.getName();
            Asset asset = new Asset();
            File fileM63442h = C10278a.m63442h(this.f12813a + "/" + name);
            if (!CloudSyncUtil.m16021k(this.mContext, 2, this.mSyncType, this.mSyncModulePackageName, fileM63442h, name, str)) {
                throw new C9722c(2246, "file not exsits");
            }
            asset.setMimeType(C14034a.m84169f(fileM63442h));
            Resource resource = new Resource();
            String strM85040m = C14165b.m85040m(fileM63442h);
            C14165b.a aVarM85035h = C14165b.m85035h(fileM63442h);
            String strM85042o = C14165b.m85042o(strM85040m);
            resource.setHash(strM85042o);
            resource.setSha256(aVarM85035h.m85045a());
            resource.setLength(Long.valueOf(fileM63442h.length()));
            asset.setResource(resource);
            asset.setCipher(CloudSyncUtil.m16059y(this.traceId, this.mSyncType, strM85040m));
            attachment.setAsset(asset);
            attachment.setUsage(name);
            attachment.setHash(strM85042o);
            attachment.setSha256(aVarM85035h.m85045a());
            attachment.setLength(fileM63442h.length());
            return attachment;
        } catch (C9721b e10) {
            throw new C9722c(e10.m60659c(), "creatAttachment error " + e10.getMessage());
        }
    }

    /* renamed from: V0 */
    public final List<String> m80674V0(List<SyncData> list, int i10) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (SyncData syncData : list) {
                if (syncData != null) {
                    List<UnstructData> fileList = syncData.getFileList();
                    if (fileList == null || fileList.size() <= 0) {
                        C11839m.m70689w("UploadDataImpl", "getFileNames fileList is empty, recordId = " + syncData.getGuid() + ", luid = " + syncData.getLuid());
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        for (UnstructData unstructData : fileList) {
                            if (unstructData != null) {
                                if (i10 != 2) {
                                    arrayList.add(unstructData.getName());
                                } else if (unstructData.getOptType() == 1 || unstructData.getOptType() == 2) {
                                    arrayList.add(unstructData.getName());
                                } else if (unstructData.getOptType() == 3) {
                                    arrayList2.add(unstructData.getName());
                                }
                            }
                        }
                        this.f60480B.put(syncData.getLuid(), arrayList2);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: W0 */
    public final ArrayList<SyncData> m80675W0(SyncData syncData) {
        if (syncData == null) {
            return new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(syncData.getLuid());
        return new C12771d().m76649k(arrayList, this.mDataType);
    }

    /* renamed from: X0 */
    public final ArrayList<String> m80676X0() {
        if (!C2981j.m17888b(this.mSyncModulePackageName, this.mDataType)) {
            C11839m.m70689w("UploadDataImpl", "not support require mode");
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.f12821i) {
            if (this.f12823k.size() > 0) {
                arrayList.addAll(m80674V0(this.f12823k, 1));
            }
            if (this.f12822j.size() > 0) {
                arrayList.addAll(m80674V0(this.f12822j, 2));
            }
        }
        if (this.f12825m.size() > 0) {
            arrayList.addAll(m80674V0(this.f12825m, 3));
        }
        return arrayList;
    }

    /* renamed from: Y0 */
    public final ArrayList<String> m80677Y0() {
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
        return arrayList;
    }

    /* renamed from: Z0 */
    public final List<Record> m80678Z0(List<SyncData> list) throws Throwable {
        ArrayList arrayList;
        boolean z10;
        Record record;
        SyncData syncData;
        ArrayList arrayList2;
        String str;
        ArrayList arrayList3;
        if (list == null || list.size() <= 0) {
            return new ArrayList();
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        boolean zIsPersistedDataSavedInCloudSyncSDK = SyncLogicService.isPersistedDataSavedInCloudSyncSDK(this.mSyncModulePackageName);
        this.f12816d.clear();
        for (SyncData syncData2 : list) {
            String guid = syncData2.getGuid();
            if (!zIsPersistedDataSavedInCloudSyncSDK) {
                ArrayList<SyncData> arrayListM80675W0 = m80675W0(syncData2);
                if (arrayListM80675W0.size() > 0) {
                    String guid2 = arrayListM80675W0.get(0).getGuid();
                    syncData2.setGuid(arrayListM80675W0.get(0).getGuid());
                    guid = guid2;
                }
            }
            Record record2 = new Record();
            record2.setKind(this.mDataType);
            record2.setId(guid);
            this.f12816d.put(record2.getId(), syncData2.getLuid());
            this.f12815c.put(record2.getId(), syncData2);
            try {
                checkDataAvaliable(guid, syncData2.getLuid(), syncData2.getData(), "update_record_with_file");
                CloudSyncUtil.m16024l(this.mSyncType, this.f12813a, syncData2.getFileList(), this.f60491z, this.f60479A, "update_record_with_file");
                z10 = zIsPersistedDataSavedInCloudSyncSDK;
                record = record2;
                arrayList = arrayList5;
                syncData = syncData2;
                arrayList3 = arrayList4;
                str = "UploadDataImpl";
                try {
                } catch (C9722c e10) {
                    e = e10;
                    arrayList2 = arrayList3;
                }
            } catch (C9722c e11) {
                e = e11;
                arrayList = arrayList5;
                z10 = zIsPersistedDataSavedInCloudSyncSDK;
                record = record2;
                syncData = syncData2;
                arrayList2 = arrayList4;
                str = "UploadDataImpl";
            }
            if (encryptDataV2(this.traceId, record2, this.mSyncType, syncData2.getLuid(), syncData2.getData(), syncData2.getExtensionData(), "update_record_with_file") != null) {
                uploadSetExtraParam(syncData, record);
                if (C2981j.m17888b(this.mSyncModulePackageName, this.mDataType)) {
                    if (syncData.getFileList() == null || syncData.getFileList().size() <= 0) {
                        C11839m.m70687e(str, "syncData fileList is empty, mdataType = " + this.mDataType);
                        throw new C9722c(2249, "syncData fileList is empty, mdataType = " + this.mDataType, this.mSyncType, "update_record_with_file");
                    }
                } else if (!CloudSyncUtil.m16049t0(this.mContext, this.mSyncType, this.mDataType, syncData.getFileList(), this.mSyncModulePackageName, "update_record_with_file")) {
                    List<Attachment> listM17331j = m17331j(record, syncData.getFileList());
                    if (listM17331j.size() > 0) {
                        record.setAttachments(listM17331j);
                    } else {
                        if (CloudSyncUtil.m15958J0(this.mContext, C10812z.m65833b(this.mSyncModulePackageName).get("packageName"))) {
                            throw new C9722c(2248, "attachment size after encrypt is empty", this.mSyncType, "update_record_with_file");
                        }
                        C11839m.m70689w(str, "syncv2 uploadData modify with file prepare, local attachment size 0, only upload record, recordId = " + record.getId() + ", luid = " + syncData.getLuid());
                    }
                }
                m80703z1(syncData, record);
                arrayList2 = arrayList3;
                arrayList2.add(record);
                arrayList4 = arrayList2;
                zIsPersistedDataSavedInCloudSyncSDK = z10;
                arrayList5 = arrayList;
            } else {
                arrayList2 = arrayList3;
                try {
                    throw new C9722c(2220, "encryptData data is null", this.mSyncType, "update_record_with_file");
                } catch (C9722c e12) {
                    e = e12;
                    int iM60666c = e.m60666c();
                    String str2 = "syncv2 uploadData modify with file prepare error, " + e.getMessage() + ", recordId = " + record.getId() + ", luid = " + syncData.getLuid();
                    C11839m.m70689w(str, str2 + ", continue");
                    m80699v1(syncData.getLuid(), record.getId(), iM60666c, str2, arrayList);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("bussinessId", "update_record_with_file");
                    linkedHashMap.putAll(getCommonUploadReportInfo(syncData.getLuid(), syncData.getGuid(), iM60666c, e.getMessage()));
                    C10812z.m65844m("mecloud_sync_data_upload", linkedHashMap);
                    arrayList4 = arrayList2;
                    zIsPersistedDataSavedInCloudSyncSDK = z10;
                    arrayList5 = arrayList;
                }
            }
        }
        ArrayList arrayList6 = arrayList4;
        ArrayList arrayList7 = arrayList5;
        if (arrayList7.size() > 0) {
            this.f60490y.addAll(arrayList7);
            C11839m.m70688i("UploadDataImpl", "syncv2 uploadData modify with file, afer prepare, sucSize = " + arrayList6.size() + ", failSize = " + arrayList7.size());
        }
        return arrayList6;
    }

    /* renamed from: a1 */
    public final int m80679a1(C9722c c9722c) {
        return SyncLogicService.cloudSyncSDKHasCollaborativeAbility(this.mSyncModulePackageName) ? c9722c.m60666c() : new C2984m().m17923a(c9722c);
    }

    /* renamed from: b1 */
    public final void m80680b1() throws Exception {
        if (C2981j.m17888b(this.mSyncModulePackageName, this.mDataType)) {
            m80696s1();
        } else {
            m80695r1();
        }
    }

    /* renamed from: c1 */
    public final String m80681c1() {
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
        if (this.f12814b.size() > 0) {
            sb2.append(",addWithFileSucc:");
            sb2.append(this.f12814b.size());
            m17322a(this.f12814b, sb2);
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
    public final void m80682d1(List<SyncData> list, Map<String, List<Record>> map, Map<String, List<FailRet>> map2, String str) throws C9722c {
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
        m80684f1(list, list3, str);
    }

    /* renamed from: e1 */
    public final void m80683e1(List<SyncData> list, List<Record> list2) {
        HashMap map = new HashMap();
        C12773f c12773f = new C12773f();
        if (list2.size() <= 0) {
            C11839m.m70689w("UploadDataImpl", "syncv2 parse add with file normalData success size is 0, return");
            return;
        }
        for (SyncData syncData : list) {
            map.put(syncData.getLuid(), syncData);
        }
        for (Record record : list2) {
            String id2 = record.getId();
            String str = this.f12816d.get(id2);
            if (TextUtils.isEmpty(str)) {
                C11839m.m70689w("UploadDataImpl", "parseAddWithFileSucData luid is null, recordId = " + id2);
            } else {
                SyncData syncData2 = (SyncData) map.get(str);
                if (syncData2 == null) {
                    C11839m.m70689w("UploadDataImpl", "parseAddWithFileSucData syncdata is null, recordId = " + id2 + ", luid = " + str);
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
                    if (!SyncLogicService.isPersistedDataSavedInCloudSyncSDK(this.mSyncModulePackageName)) {
                        ArrayList arrayList = new ArrayList();
                        List<Attachment> attachments = record.getAttachments();
                        if (attachments != null && attachments.size() > 0) {
                            for (Attachment attachment : attachments) {
                                UnstructData unstructData = new UnstructData();
                                unstructData.setHash(attachment.getHash());
                                unstructData.setName(attachment.getUsage());
                                unstructData.setUnstructUuid(id2);
                                arrayList.add(unstructData);
                            }
                            c12773f.m76669k(arrayList, this.mDataType);
                        }
                    }
                }
            }
        }
        this.f12816d.clear();
    }

    /* renamed from: f1 */
    public final void m80684f1(List<SyncData> list, List<FailRet> list2, String str) throws C9722c {
        super.baseSyncParseFailList(this.f12821i, this.f12818f, this.f12819g, list, list2, str);
    }

    /* renamed from: h1 */
    public final void m80685h1(List<SyncData> list, Map<String, List<Record>> map, Map<String, List<FailRet>> map2, String str) throws C9722c {
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
        m80684f1(list, list3, str);
    }

    /* renamed from: i1 */
    public final void m80686i1(List<Record> list) throws C9722c, IOException {
        C11839m.m70688i("UploadDataImpl", "syncV2 uploadData add size:" + this.f12823k.size());
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
            uploadSetExtraParam(syncData, record);
            if (syncData.getRecycleStatus() == -1) {
                record.setRecycled(Boolean.TRUE);
                record.setRecycledTime(new C4644l(syncData.getRecycleTime()));
            } else {
                record.setRecycled(Boolean.FALSE);
            }
            list.add(record);
        }
        C11839m.m70688i("UploadDataImpl", "syncV2 uploadData add after, record size = " + listGenerateGuids.size());
        C11839m.m70686d("UploadDataImpl", "syncV2 uploadData add after, record list = " + listGenerateGuids.toString() + ", record-luid = " + this.f12816d.toString());
    }

    @Override // com.huawei.android.hicloud.sync.contact.SyncProcessBase
    public boolean isHasPartialSucData() {
        if (this.f12818f.size() <= 0) {
            return false;
        }
        return this.f12821i ? this.f12814b.size() > 0 || this.f12832t.size() > 0 : this.f12827o.size() > 0 || this.f12828p.size() > 0 || this.f12829q.size() > 0;
    }

    /* renamed from: j1 */
    public final List<Record> m80687j1(List<SyncData> list, List<Record> list2) throws Throwable {
        if (list2.size() <= 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        updateNormalRecords(list2, arrayList, arrayList2);
        m80683e1(list, arrayList);
        m80684f1(list, arrayList2, "create_record_with_file_normal");
        if (arrayList2.size() > 0) {
            this.f60489x.addAll(arrayList2);
        }
        reportUploadEvet(0, "", arrayList.size(), this.f60489x, "create_record_with_file_normal");
        return arrayList;
    }

    /* renamed from: k1 */
    public final void m80688k1() throws Throwable {
        C11839m.m70688i("UploadDataImpl", "syncV2 uploadData add or modify start");
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.f12816d.clear();
        if (this.f12822j.size() > 0) {
            m80697t1(arrayList);
            if (arrayList.size() > 0) {
                C11839m.m70688i("UploadDataImpl", "syncV2 uploadData update");
                updateRecords(Constants.NORMAL_CACHE, arrayList, map, map2);
                m80685h1(this.f12822j, map, map2, "update_record_no_file");
            }
        }
        if (this.f12823k.size() > 0) {
            m80686i1(arrayList2);
            if (arrayList2.size() > 0) {
                createRecords(Constants.NORMAL_CACHE, arrayList2, map, map2);
                m80682d1(this.f12823k, map, map2, "create_record_no_file");
            }
        }
        if (HNConstants.DataType.CONTACT.equals(this.mDataType) || NotifyUtil.HI_NOTE_SYNC_TYPE.equals(this.mSyncType)) {
            m17339r(CloudSyncUtil.m16057x(arrayList, map.get("updateSuccessList")));
        }
        C11839m.m70688i("UploadDataImpl", "syncV2 uploadData add succSize:" + this.f12827o.size() + ",modify succSize:" + this.f12828p.size() + ",failSize:" + this.f12818f.size() + ",failReason:" + this.f12818f.toString());
        this.f12816d.clear();
    }

    /* renamed from: l1 */
    public final void m80689l1(List<SyncData> list, List<Record> list2) throws Throwable {
        List<String> list3;
        SyncData syncData;
        String str;
        if (list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<String> listGenerateGuids = generateGuids(this.mSyncType, this.mDataType, Integer.valueOf(list.size()));
        checkGuids(listGenerateGuids, list.size(), "local_add_upload");
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
                CloudSyncUtil.m16024l(this.mSyncType, this.f12813a, syncData2.getFileList(), this.f60491z, this.f60479A, "create_record_with_file_temp");
                list3 = listGenerateGuids;
                syncData = syncData2;
                try {
                } catch (C9722c e10) {
                    e = e10;
                    str = "create_record_with_file_temp";
                }
            } catch (C9722c e11) {
                e = e11;
                list3 = listGenerateGuids;
                syncData = syncData2;
                str = "create_record_with_file_temp";
            }
            if (encryptDataV2(this.traceId, record, this.mSyncType, syncData2.getLuid(), syncData2.getData(), syncData2.getExtensionData(), "create_record_with_file_temp") == null) {
                throw new C9722c(2220, "encryptData data is null", this.mSyncType, "create_record_with_file_temp");
            }
            uploadSetExtraParam(syncData, record);
            str = "create_record_with_file_temp";
            try {
                if (!CloudSyncUtil.m16040q0(this.mSyncType, this.mDataType, syncData.getFileList(), str)) {
                    List<Attachment> listM17329h = m17329h(record, syncData.getFileList());
                    if (listM17329h.size() <= 0) {
                        throw new C9722c(2248, "attachment size after encrypt is empty", this.mSyncType, str);
                    }
                    record.setAttachments(listM17329h);
                    if (!m17338q(syncData.getLuid(), listM17329h)) {
                        throw new C9722c(SNSCode.Status.HWID_UNLOGIN, "prepare attachment, space not enough", this.mSyncType, str);
                    }
                }
                if (syncData.getRecycleStatus() == -1) {
                    record.setRecycled(Boolean.TRUE);
                    record.setRecycledTime(new C4644l(syncData.getRecycleTime()));
                } else {
                    record.setRecycled(Boolean.FALSE);
                }
                arrayList.add(record);
            } catch (C9722c e12) {
                e = e12;
                int iM60666c = e.m60666c();
                String str2 = "syncv2 add temp data, prepare error, " + e.getMessage() + ", luid = " + syncData.getLuid();
                C11839m.m70689w("UploadDataImpl", str2 + ", errorCode = " + iM60666c + ", continue");
                m80699v1(syncData.getLuid(), syncData.getGuid(), iM60666c, str2, arrayList2);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("bussinessId", str);
                linkedHashMap.putAll(getCommonUploadReportInfo(syncData.getLuid(), syncData.getGuid(), iM60666c, e.getMessage()));
                C10812z.m65844m("mecloud_sync_data_upload", linkedHashMap);
                i10++;
                listGenerateGuids = list3;
            }
            i10++;
            listGenerateGuids = list3;
        }
        C11839m.m70688i("UploadDataImpl", "syncV2 add temp data, after prepare, sucTempSize : " + arrayList.size() + ", failTempSize :" + arrayList2.size());
        if (arrayList2.size() > 0) {
            this.f60489x.addAll(arrayList2);
        }
        ArrayList arrayList3 = new ArrayList();
        createRecords("temp", arrayList, list2, arrayList3, "attachments,attributes,cipher,createdTime,editedTime,id,kind,recycled,recycledTime,status,version");
        filterSuc(list2, arrayList3, "create_record_with_file");
        try {
            m80684f1(list, arrayList3, "create_record_with_file");
        } catch (C9722c e13) {
            if (list2.isEmpty()) {
                C11839m.m70689w("UploadDataImpl", "syncV2 add temp data, all fail");
                throw e13;
            }
            C11839m.m70688i("UploadDataImpl", "syncV2 add temp data, partial suc, continue");
        }
        C11839m.m70688i("UploadDataImpl", "syncV2 add temp data, after onece create Temp, sucSize :" + list2.size() + ", failSize:" + arrayList3.size());
        if (arrayList3.size() > 0) {
            this.f60489x.addAll(arrayList3);
        }
        reportUploadEvet(0, "", list2.size(), this.f60489x, "create_record_with_file_temp");
    }

    /* renamed from: m1 */
    public final void m80690m1(List<SyncData> list) throws Throwable {
        if (list != null) {
            C11839m.m70688i("UploadDataImpl", "syncv2 uploadData add with file start, addSize = " + list.size());
            ArrayList arrayList = new ArrayList();
            m80689l1(list, arrayList);
            List<Record> arrayList2 = new ArrayList<>();
            if (arrayList.size() > 0) {
                arrayList2 = m80664B1(arrayList);
            }
            C11839m.m70688i("UploadDataImpl", "syncv2 uploadData upload add file suc size list = " + arrayList2.size());
            C11839m.m70688i("UploadDataImpl", "syncv2 uploadData upload add file, finally sucSize = " + m80687j1(list, arrayList2).size() + ", failSize = " + this.f60489x.size());
        }
        C11839m.m70688i("UploadDataImpl", "syncv2 uploadData add with file end");
    }

    /* renamed from: n1 */
    public final void m80691n1() throws Throwable {
        boolean zIsPersistedDataSavedInCloudSyncSDK = SyncLogicService.isPersistedDataSavedInCloudSyncSDK(this.mSyncModulePackageName);
        if (this.f12826n.size() > 0) {
            C11839m.m70688i("UploadDataImpl", "syncV2 uploadData delete size = " + this.f12826n.size() + " , delete data = " + this.f12826n.toString());
            ArrayList arrayList = new ArrayList();
            if (zIsPersistedDataSavedInCloudSyncSDK) {
                Iterator<String> it = this.f12826n.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            } else {
                ArrayList<SyncData> arrayListM76649k = new C12771d().m76649k(this.f12826n, this.mDataType);
                if (arrayListM76649k.size() != this.f12826n.size()) {
                    throw new C9722c(2005, "syncV2 uploadData get delete eTagList size error.", this.mSyncType, "local_upload");
                }
                this.f60481C = new HashMap();
                for (SyncData syncData : arrayListM76649k) {
                    arrayList.add(syncData.getGuid());
                    this.f60481C.put(syncData.getLuid(), syncData.getGuid());
                }
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            deleteRecords(this.mSyncType, this.mDataType, arrayList, arrayList2, arrayList3, "local_delete_upload");
            C11839m.m70688i("UploadDataImpl", "syncV2 uploadData delete suc size = " + arrayList2.size() + " , fail size = " + arrayList3.toString());
            Iterator<String> it2 = this.f12826n.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                Iterator<String> it3 = arrayList2.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        String next2 = it3.next();
                        if (!zIsPersistedDataSavedInCloudSyncSDK || !next.equals(next2)) {
                            if (!zIsPersistedDataSavedInCloudSyncSDK && this.f60481C.get(next) != null && next2.equals(this.f60481C.get(next))) {
                                this.f12829q.add(next);
                                break;
                            }
                        } else {
                            this.f12829q.add(next2);
                            break;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: o1 */
    public final void m80692o1(List<SyncData> list, List<Record> list2) throws Throwable {
        if (list2.size() > 0) {
            if ((HNConstants.DataType.CONTACT.equals(this.mDataType) || NotifyUtil.HI_NOTE_SYNC_TYPE.equals(this.mSyncType)) && list2.size() > 0) {
                m17340s(list, list2);
            }
        }
    }

    /* renamed from: p1 */
    public final List<Record> m80693p1(List<SyncData> list, List<Record> list2) throws C9722c, IOException {
        if (list2 == null || list2.size() <= 0) {
            return new ArrayList();
        }
        C11839m.m70688i("UploadDataImpl", "syncv2 uploadData modify with file, upload file start, modifyRecordList size = " + list2.size());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        m17330i(list2);
        if (C2981j.m17888b(this.mSyncModulePackageName, this.mDataType)) {
            m80670R0(list, list2, arrayList2, arrayList, "update_compare_file_change");
        } else {
            m80669Q0(list2, arrayList2, arrayList, "update_compare_file_change");
        }
        ArrayList arrayList3 = new ArrayList(arrayList2);
        if (arrayList.size() > 0) {
            arrayList3.addAll(m80666D1(arrayList));
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        C11839m.m70688i("UploadDataImpl", "syncv2 uploadData modify with file, toUpdateRecordList size = " + arrayList3.size());
        if (arrayList3.size() > 0) {
            putUpdateRecords(Constants.NORMAL_CACHE, arrayList3, arrayList4, arrayList5, "attributes,cipher,createdTime,editedTime,id,kind,recycled,recycledTime,status,version", "update_record_with_file");
            m17335n(list, arrayList4);
            m80684f1(list, arrayList5, "update_record_with_file");
        }
        if (arrayList5.size() > 0) {
            this.f60490y.addAll(arrayList5);
        }
        reportUploadEvet(0, "", arrayList4.size(), this.f60490y, "update_record_with_file");
        C11839m.m70688i("UploadDataImpl", "syncv2 uploadData modify with file, sucRecord size = " + arrayList4.size() + ", faileRecord size = " + arrayList5.size());
        return arrayList4;
    }

    /* renamed from: q1 */
    public final void m80694q1(List<SyncData> list) throws Throwable {
        if (list != null) {
            C11839m.m70688i("UploadDataImpl", "syncv2 uploadData modify with file start, modifySize = " + list.size());
            List<Record> listM80678Z0 = m80678Z0(list);
            List<Record> arrayList = new ArrayList<>();
            if (listM80678Z0.size() > 0) {
                arrayList = m80693p1(list, listM80678Z0);
                m80692o1(list, arrayList);
            }
            C11839m.m70688i("UploadDataImpl", "syncv2 uploadData modify with file, finally sucSize = " + arrayList.size() + ", failSize = " + this.f60490y.size());
            this.f12816d.clear();
        }
        C11839m.m70688i("UploadDataImpl", "syncv2 uploadData modify with file end");
    }

    /* renamed from: r1 */
    public final void m80695r1() throws Exception {
        ArrayList<String> arrayListM80677Y0 = m80677Y0();
        C11839m.m70686d("UploadDataImpl", "getUploadFiles luidlist = " + arrayListM80677Y0.toString());
        if (arrayListM80677Y0.size() > 0) {
            FileProcess fileProcess = new FileProcess(this.mContext);
            isCancel();
            fileProcess.m17798e(this.f12813a, this.f60487v, this.mSyncType, this.mDataType, arrayListM80677Y0, this.mSyncModulePackageName);
            isCancel();
            C2977f.m17864g(this.mSyncType, this.mDataType, this.traceId, this.f12813a, this.f60487v, this.f60491z, this.f60479A);
        }
    }

    /* renamed from: s1 */
    public final void m80696s1() throws Exception {
        ArrayList<String> arrayListM80677Y0 = m80677Y0();
        ArrayList<String> arrayListM80676X0 = m80676X0();
        C11839m.m70686d("UploadDataImpl", "getUploadFiles luidlist = " + arrayListM80677Y0.toString() + ", fileNames = " + arrayListM80676X0.toString());
        if (arrayListM80677Y0.size() > 0 || arrayListM80676X0.size() > 0) {
            FileProcess fileProcess = new FileProcess(this.mContext);
            isCancel();
            fileProcess.m17799f(this.f12813a, this.f60487v, this.mSyncType, this.mDataType, arrayListM80677Y0, arrayListM80676X0, this.mSyncModulePackageName);
            isCancel();
            C2977f.m17864g(this.mSyncType, this.mDataType, this.traceId, this.f12813a, this.f60487v, this.f60491z, this.f60479A);
        }
    }

    /* renamed from: t1 */
    public final void m80697t1(List<Record> list) throws C9722c {
        C11839m.m70688i("UploadDataImpl", "syncV2 uploadData modify size = " + this.f12822j.size());
        m80702y1();
        boolean zIsPersistedDataSavedInCloudSyncSDK = SyncLogicService.isPersistedDataSavedInCloudSyncSDK(this.mSyncModulePackageName);
        Iterator<SyncData> it = this.f12822j.iterator();
        while (it.hasNext()) {
            SyncData next = it.next();
            String guid = next.getGuid();
            if (!zIsPersistedDataSavedInCloudSyncSDK) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next.getLuid());
                ArrayList<SyncData> arrayListM76649k = new C12771d().m76649k(arrayList, this.mDataType);
                if (arrayListM76649k.size() > 0) {
                    String guid2 = arrayListM76649k.get(0).getGuid();
                    next.setGuid(arrayListM76649k.get(0).getGuid());
                    guid = guid2;
                }
            }
            checkDataAvaliable(next.getGuid(), next.getLuid(), next.getData(), "local_modify_upload");
            Record record = new Record();
            record.setId(guid);
            this.f12816d.put(guid, next.getLuid());
            if (encryptDataV2(this.traceId, record, this.mSyncType, next.getLuid(), next.getData(), next.getExtensionData(), "local_modify_upload") == null) {
                throw new C9722c(2220, "syncV2 encryptData data is null", this.mSyncType, "local_modify_upload");
            }
            uploadSetExtraParam(next, record);
            if (next.getRecycleStatus() == -1) {
                record.setRecycled(Boolean.TRUE);
                record.setRecycledTime(new C4644l(next.getRecycleTime()));
            } else {
                record.setRecycled(Boolean.FALSE);
            }
            list.add(record);
        }
        C11839m.m70686d("UploadDataImpl", "syncV2 uploadData after modify, record-luid = " + this.f12816d.toString());
        C11839m.m70688i("UploadDataImpl", "syncV2 uploadData after modify list size = " + list.size());
    }

    /* renamed from: u1 */
    public final void m80698u1() throws Exception {
        C11839m.m70688i("UploadDataImpl", "syncv2 uploadData, struct data with file start");
        this.f12824l = new ArrayList<>(this.f12823k);
        ArrayList arrayList = new ArrayList(this.f12823k);
        this.f12823k.clear();
        try {
            isCancel();
            if (arrayList.size() > 0) {
                this.f60482D = Executors.newFixedThreadPool(3);
                this.f12820h = arrayList.size();
                isCancel();
                m80690m1(arrayList);
            }
            ArrayList arrayList2 = new ArrayList(this.f12822j);
            this.f12822j.clear();
            if (arrayList2.size() > 0) {
                this.f12820h = arrayList2.size();
                isCancel();
                m80694q1(arrayList2);
            }
            C11839m.m70688i("UploadDataImpl", "syncv2 uploadData, struct data with file end");
            ExecutorService executorService = this.f60482D;
            if (executorService != null) {
                executorService.shutdown();
            }
        } catch (Throwable th2) {
            C11839m.m70688i("UploadDataImpl", "syncv2 uploadData, struct data with file end");
            ExecutorService executorService2 = this.f60482D;
            if (executorService2 != null) {
                executorService2.shutdown();
            }
            throw th2;
        }
    }

    /* renamed from: v1 */
    public final void m80699v1(String str, String str2, int i10, String str3, List<FailRet> list) {
        m80700w1(str, i10);
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

    /* renamed from: w1 */
    public final void m80700w1(String str, int i10) {
        super.baseRecordUploadFileFail(this.f12818f, this.f12819g, str, i10);
    }

    /* renamed from: x1 */
    public final void m80701x1() {
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
                C11839m.m70688i("UploadDataImpl", "setFileInfoToDataBase: toDeleteList.size = " + arrayList.size());
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
                C11839m.m70688i("UploadDataImpl", "setFileInfoToDataBase: toAddList.size = " + arrayList2.size());
                c12772e.m76653g(this.mSyncType, this.mDataType, arrayList2);
            }
        }
    }

    /* renamed from: y1 */
    public final void m80702y1() {
        if (SyncLogicService.isPersistedDataSavedInCloudSyncSDK(this.mSyncModulePackageName)) {
            return;
        }
        C12771d c12771d = new C12771d();
        ArrayList arrayList = new ArrayList();
        Iterator<SyncData> it = this.f12822j.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getLuid());
        }
        ArrayList<SyncData> arrayListM76649k = c12771d.m76649k(arrayList, this.mDataType);
        Iterator<SyncData> it2 = this.f12822j.iterator();
        while (it2.hasNext()) {
            SyncData next = it2.next();
            Iterator<SyncData> it3 = arrayListM76649k.iterator();
            while (true) {
                if (it3.hasNext()) {
                    SyncData next2 = it3.next();
                    if (next.getLuid().equals(next2.getLuid())) {
                        next.setGuid(next2.getGuid());
                        break;
                    }
                }
            }
        }
    }

    /* renamed from: z1 */
    public final void m80703z1(SyncData syncData, Record record) {
        if (syncData.getRecycleStatus() != -1) {
            record.setRecycled(Boolean.FALSE);
        } else {
            record.setRecycled(Boolean.TRUE);
            record.setRecycledTime(new C4644l(syncData.getRecycleTime()));
        }
    }
}
