package p736wc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.C2786g;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.contact.SyncProcessBase;
import com.huawei.android.hicloud.sync.service.aidl.Ctag;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfo;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfoCompatible;
import com.huawei.android.hicloud.sync.service.aidl.Etag;
import com.huawei.android.hicloud.sync.service.aidl.GenSyncLogicService;
import com.huawei.android.hicloud.sync.service.aidl.LocalId;
import com.huawei.android.hicloud.sync.service.aidl.ParcelableMap;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicServiceUtil;
import com.huawei.android.hicloud.sync.syncutil.C2980i;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Change;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Record;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import fk.C9722c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import je.C10812z;
import org.json.JSONException;
import p514o9.C11839m;
import p664u0.C13108a;
import tc.C13007b;

/* renamed from: wc.f */
/* loaded from: classes3.dex */
public class C13586f extends SyncProcessBase {

    /* renamed from: a */
    public final Context f61113a;

    /* renamed from: b */
    public String f61114b;

    /* renamed from: c */
    public boolean f61115c;

    /* renamed from: d */
    public final int f61116d;

    /* renamed from: e */
    public final String f61117e;

    /* renamed from: f */
    public ArrayList<CtagInfoCompatible> f61118f;

    /* renamed from: g */
    public int f61119g;

    public C13586f(Context context, String str, String str2, List<LocalId> list, int i10, String str3, String str4, String str5, String str6, ArrayList<CtagInfoCompatible> arrayList, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        super(context, str, str2, str3, str4, str5, concurrentHashMap);
        this.f61115c = false;
        this.f61119g = 0;
        C11839m.m70688i("GenStartSyncImpl", "Sync type = " + str + ", dataType = " + str2 + ", order = " + i10 + ", packageName = " + str5);
        this.f61113a = context;
        this.f61116d = i10;
        this.f61117e = str6;
        this.f61118f = arrayList;
    }

    /* renamed from: a */
    private Bundle m81613a(int i10) throws JSONException {
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putString("sync_module_package_name", this.mSyncModulePackageName);
        bundle.putString("dataType", this.mDataType);
        bundle.putString("traceId", this.traceId);
        if (i10 == 0) {
            ParcelableMap parcelableMap = new ParcelableMap();
            parcelableMap.setMap(m81614b(this.cloudCtagMap, GenSyncLogicService.getSdkVersion(this.mSyncModulePackageName)));
            bundle.putParcelable("cloud_ctag_map", parcelableMap);
            C11839m.m70688i("GenStartSyncImpl", "cloudCtagMap.size = " + this.cloudCtagMap.size());
            ParcelableMap parcelableMap2 = new ParcelableMap();
            parcelableMap2.setMap(m81615c(this.cloudEtagMap, GenSyncLogicService.getSdkVersion(this.mSyncModulePackageName)));
            bundle.putParcelable("cloud_etag_map", parcelableMap2);
            C11839m.m70688i("GenStartSyncImpl", "cloudEtagMap.size = " + this.cloudEtagMap.size());
            bundle.putBoolean("is_incrementally_query", this.isQueryEtagIncremental);
        }
        C2980i.m17883r(this.mReportEndInfo, this.isQueryEtagIncremental);
        reportPreSync(this.cloudEtagMap, this.f61119g, this.isQueryEtagIncremental);
        return bundle;
    }

    /* renamed from: b */
    private Map<String, Ctag> m81614b(Map<String, Ctag> map, int i10) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, Ctag> entry : map.entrySet()) {
            Ctag value = entry.getValue();
            value.setVersion(i10);
            map2.put(entry.getKey(), value);
        }
        return map2;
    }

    /* renamed from: c */
    private Map<String, Etag> m81615c(Map<String, Etag> map, int i10) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, Etag> entry : map.entrySet()) {
            Etag value = entry.getValue();
            value.setVersion(i10);
            map2.put(entry.getKey(), value);
        }
        return map2;
    }

    /* renamed from: e */
    private void m81616e() throws C9722c {
        Set<String> setM78242T;
        C13007b c13007bM78205Y = C13007b.m78205Y(this.f61113a);
        if (c13007bM78205Y == null || (setM78242T = c13007bM78205Y.m78242T(this.mSyncType)) == null || setM78242T.isEmpty() || setM78242T.contains(this.mDataType)) {
            return;
        }
        throw new C9722c(2202, "pimds not support data type: " + this.mDataType, this.f61114b, "local_pre_sync");
    }

    /* renamed from: f */
    private void m81617f(String str) throws C9722c, IOException {
        C11839m.m70688i("GenStartSyncImpl", "syncV2 need changes.list, dataType: " + this.mDataType);
        this.isQueryEtagIncremental = true;
        this.cloudEtagMap.clear();
        int i10 = 0;
        try {
            try {
                List<Change> changesList = getChangesList(this.mSyncType, this.mDataType, str);
                C11839m.m70686d("GenStartSyncImpl", "syncV2 dataType: " + this.mDataType + ", changeList run: " + changesList.toString());
                for (Change change : changesList) {
                    String id2 = change.getId();
                    Record record = change.getRecord();
                    if (change.getDeleted() == null) {
                        throw new C9722c(2237, "getChangeList, etag operation is null, recordId = " + id2, this.mSyncType, "getChangeList");
                    }
                    if (record != null) {
                        Etag etag = new Etag();
                        if (record.getVersion() == null) {
                            throw new C9722c(2223, "getChangeList, record version is null, recordId = " + id2, this.mSyncType, "getChangeList");
                        }
                        etag.setEtag(record.getVersion().toString());
                        if (change.getDeleted().booleanValue()) {
                            etag.setOperation(2);
                            i10++;
                        } else {
                            etag.setOperation(1);
                        }
                        if (record.getRecycled() != null) {
                            if (record.getRecycled().booleanValue()) {
                                etag.setRecycleStatus(-1);
                            } else {
                                etag.setRecycleStatus(2);
                            }
                        }
                        this.cloudEtagMap.put(id2, etag);
                    } else if (change.getDeleted().booleanValue()) {
                        Etag etag2 = new Etag();
                        etag2.setEtag("");
                        etag2.setOperation(2);
                        this.cloudEtagMap.put(id2, etag2);
                        i10++;
                    }
                }
            } catch (C9722c e10) {
                C11839m.m70688i("GenStartSyncImpl", "syncV2 getChangesList errorCode: " + e10.m60666c() + ", errMsg = " + e10.getMessage());
                m81625l(e10);
            }
            this.f61119g = i10;
            reportPropfind("getChangeList", "change", this.cloudEtagMap.size(), i10);
        } catch (Throwable th2) {
            this.f61119g = 0;
            reportPropfind("getChangeList", "change", this.cloudEtagMap.size(), 0);
            throw th2;
        }
    }

    /* renamed from: g */
    private void m81618g(boolean z10) throws Throwable {
        isCancel();
        C13007b c13007bM78205Y = C13007b.m78205Y(this.f61113a);
        String strM81620i = m81620i(this.mDataType);
        String strM78234O = c13007bM78205Y.m78234O(this.mSyncType);
        C11839m.m70688i("GenStartSyncImpl", "syncV2 dataType: " + this.mDataType + ", localCtag:" + strM81620i + ", cloudCtag: " + strM78234O);
        if (z10 || TextUtils.isEmpty(strM81620i)) {
            C11839m.m70688i("GenStartSyncImpl", "syncV2 need record.list mDataType: " + this.mDataType + ", isOpenSwitch: " + z10);
            this.isQueryEtagIncremental = false;
            this.hasGetAllCloudEtag = true;
            getRecordList();
            reportPropfind("getRecordList", z10 ? "openSwitch" : TextUtils.isEmpty(strM81620i) ? "localCtagEmpty" : "", this.cloudEtagMap.size(), 0);
            return;
        }
        if (TextUtils.isEmpty(strM81620i) || strM81620i.equals(strM78234O)) {
            this.isQueryEtagIncremental = true;
            return;
        }
        C11839m.m70686d("GenStartSyncImpl", "syncV2 mDataType: " + this.mDataType + ", increment sync.");
        this.isQueryEtagIncremental = true;
        m81617f(strM81620i);
    }

    /* renamed from: h */
    private CtagInfo m81619h(String str) {
        ArrayList<CtagInfoCompatible> arrayList = this.f61118f;
        if (arrayList == null) {
            return null;
        }
        Iterator<CtagInfoCompatible> it = arrayList.iterator();
        while (it.hasNext()) {
            CtagInfoCompatible next = it.next();
            if (str.equals(next.getCtagName())) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: i */
    private String m81620i(String str) {
        CtagInfo ctagInfoM81619h = m81619h(str);
        return ctagInfoM81619h != null ? ctagInfoM81619h.getCtagValue() : this.f61117e;
    }

    /* renamed from: j */
    private void m81621j() throws Throwable {
        if (this.f61116d == 1) {
            if (1 == CloudSyncUtil.m15979U(this.mSyncType)) {
                SyncLogicServiceUtil.syncApplyPowerkit(this.mSyncType);
            }
            syncV2(this.mSyncType, m81624k());
        }
    }

    /* renamed from: m */
    private void m81622m(boolean z10) {
        this.f61115c = z10;
    }

    /* renamed from: d */
    public void m81623d(int i10) throws JSONException {
        if (!this.f61115c) {
            C11839m.m70688i("GenStartSyncImpl", "CallBack, value = " + i10);
            Bundle bundleM81613a = m81613a(i10);
            Intent intent = new Intent();
            intent.setAction("com.huawei.android.hicloud.intent.GENSENDCALLBACK");
            intent.putExtra("msgType", this.mSyncType);
            intent.putExtra("msgID", 10001);
            intent.putExtra("bundle", bundleM81613a);
            C13108a.m78878b(this.f61113a).m78881d(intent);
            CloudSyncUtil.m15993a1(this.f61113a, this.mSyncType, i10);
        }
        m81622m(false);
    }

    @Override // com.huawei.android.hicloud.sync.contact.SyncProcessBase
    public int getRecordList() throws Throwable {
        this.cloudEtagMap.clear();
        C11839m.m70688i("GenStartSyncImpl", "syncV2 getRecordsList dataType:" + this.mDataType);
        try {
            this.isQueryEtagIncremental = false;
            this.hasGetAllCloudEtag = true;
            ArrayList<Record> recordsList = getRecordsList(this.mSyncType, this.mDataType, "nextCursor,records(id,recycled,version)");
            C11839m.m70688i("GenStartSyncImpl", "syncV2 getRecordsList dataType:" + this.mDataType + " end size: " + recordsList.size());
            for (Record record : recordsList) {
                if (record != null) {
                    String id2 = record.getId();
                    Etag etag = new Etag();
                    if (record.getVersion() == null) {
                        throw new C9722c(2223, "getRecordList, record version is null, recordId = " + id2, "getRecordList");
                    }
                    if (record.getRecycled() != null) {
                        if (GenSyncLogicService.isServiceSupportRecycleProcess(this.f61113a, this.mSyncType, this.mDataType)) {
                            if (record.getRecycled().booleanValue()) {
                                etag.setRecycleStatus(-1);
                            } else {
                                etag.setRecycleStatus(2);
                            }
                        } else if (!record.getRecycled().booleanValue()) {
                            etag.setRecycleStatus(2);
                        }
                    }
                    etag.setEtag(record.getVersion().toString());
                    this.cloudEtagMap.put(id2, etag);
                }
            }
            return 0;
        } catch (C9722c e10) {
            C11839m.m70688i("GenStartSyncImpl", "getRecordList error code = " + e10.m60666c() + ", msg = " + e10.getMessage());
            throw e10;
        }
    }

    @Override // com.huawei.android.hicloud.sync.contact.SyncProcessBase
    public boolean isSupportIncrementalQuery() {
        return true;
    }

    /* renamed from: k */
    public final boolean m81624k() {
        String str = this.f61114b;
        return str != null && "download".equals(str);
    }

    /* renamed from: l */
    public int m81625l(C9722c c9722c) throws Throwable {
        int iDeleteTag;
        C11839m.m70687e("GenStartSyncImpl", "syncV2 proChangeListSyncException errorCode = " + c9722c.m60666c() + ", errorMsg = " + c9722c.getMessage());
        int iM60666c = c9722c.m60666c();
        if (iM60666c != 2216 && iM60666c != 2239) {
            throw c9722c;
        }
        if (iM60666c == 2239 && (iDeleteTag = deleteTag(this.mSyncType)) != 0) {
            throw new C9722c(getErrorCode(iDeleteTag), "cursor param invalid, delete tag exception", this.mSyncType, "delete_tag");
        }
        this.cloudEtagMap.clear();
        this.isQueryEtagIncremental = false;
        this.hasGetAllCloudEtag = true;
        int recordList = getRecordList();
        reportPropfind("getChangeList", "cursorInvalid", this.cloudEtagMap.size(), 0);
        return recordList;
    }

    /* renamed from: n */
    public void m81626n(String str) {
        this.f61114b = str;
    }

    /* renamed from: o */
    public int m81627o() throws Throwable {
        Throwable th2;
        int iCheckHasGetAllCloudEtag;
        String message = "";
        int iM60666c = 0;
        try {
            try {
                if (this.f61116d == 1) {
                    C2786g.m16223l(this.f61113a, this.traceId, this.mSyncType, this.serverFlowControlEffected);
                    CloudSyncUtil.m16053v(this.mSyncType);
                    getDataVersion(this.mSyncType, false);
                }
                isCancel();
                m81621j();
                m81616e();
                boolean zM15955I = CloudSyncUtil.m15955I(this.f61113a, this.mSyncType);
                CloudSyncUtil.m15984W0(this.f61113a, this.mSyncType, false);
                m81618g(zM15955I);
            } catch (C9722c e10) {
                iM60666c = e10.m60666c();
                message = e10.getMessage();
                C10812z.m65841j(this.f61113a, e10.m60668e(), this.mDataType, e10.m60666c(), e10.m60667d(), e10.getMessage(), this.operationType, e10.m60665b(), this.traceId);
            } catch (Exception e11) {
                try {
                    message = e11.getMessage();
                    C11839m.m70687e("GenStartSyncImpl", "Start sync, error: " + e11.toString());
                    C10812z.m65840i(this.f61113a, this.mSyncType, this.mDataType, 5, e11.toString(), this.operationType, "", this.traceId);
                    iCheckHasGetAllCloudEtag = checkHasGetAllCloudEtag(5);
                } catch (Throwable th3) {
                    th2 = th3;
                    iM60666c = 5;
                    int iCheckHasGetAllCloudEtag2 = checkHasGetAllCloudEtag(iM60666c);
                    m81623d(iCheckHasGetAllCloudEtag2);
                    C2980i.m17879n(this.mReportEndInfo, iCheckHasGetAllCloudEtag2, message);
                    throw th2;
                }
            }
            iCheckHasGetAllCloudEtag = checkHasGetAllCloudEtag(iM60666c);
            m81623d(iCheckHasGetAllCloudEtag);
            C2980i.m17879n(this.mReportEndInfo, iCheckHasGetAllCloudEtag, message);
            return iCheckHasGetAllCloudEtag;
        } catch (Throwable th4) {
            th2 = th4;
            int iCheckHasGetAllCloudEtag22 = checkHasGetAllCloudEtag(iM60666c);
            m81623d(iCheckHasGetAllCloudEtag22);
            C2980i.m17879n(this.mReportEndInfo, iCheckHasGetAllCloudEtag22, message);
            throw th2;
        }
    }
}
