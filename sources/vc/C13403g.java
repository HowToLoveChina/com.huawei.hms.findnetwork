package vc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.location.p065a.C1529a;
import com.huawei.android.hicloud.complexutil.C2786g;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.contact.SyncProcessBase;
import com.huawei.android.hicloud.sync.service.aidl.Ctag;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfo;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfoCompatible;
import com.huawei.android.hicloud.sync.service.aidl.Etag;
import com.huawei.android.hicloud.sync.service.aidl.LocalId;
import com.huawei.android.hicloud.sync.service.aidl.ParcelableMap;
import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicService;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicServiceUtil;
import com.huawei.android.hicloud.sync.syncutil.C2974c;
import com.huawei.android.hicloud.sync.syncutil.C2980i;
import com.huawei.android.hicloud.sync.syncutil.C2984m;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Change;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Record;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import fk.C9722c;
import gp.C10028c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import je.C10812z;
import org.json.JSONException;
import p514o9.C11829c;
import p514o9.C11839m;
import p664u0.C13108a;
import tc.C13007b;

/* renamed from: vc.g */
/* loaded from: classes3.dex */
public class C13403g extends SyncProcessBase {

    /* renamed from: a */
    public final Context f60458a;

    /* renamed from: b */
    public List<LocalId> f60459b;

    /* renamed from: c */
    public Map<String, SyncData> f60460c;

    /* renamed from: d */
    public final ArrayList<SyncData> f60461d;

    /* renamed from: e */
    public final ArrayList<String> f60462e;

    /* renamed from: f */
    public final ArrayList<String> f60463f;

    /* renamed from: g */
    public final ArrayList<String> f60464g;

    /* renamed from: h */
    public final ArrayList<String> f60465h;

    /* renamed from: i */
    public final ArrayList<String> f60466i;

    /* renamed from: j */
    public final ArrayList<String> f60467j;

    /* renamed from: k */
    public final ArrayList<String> f60468k;

    /* renamed from: l */
    public final ArrayList<String> f60469l;

    /* renamed from: m */
    public final ArrayList<String> f60470m;

    /* renamed from: n */
    public boolean f60471n;

    /* renamed from: o */
    public final int f60472o;

    /* renamed from: p */
    public final String f60473p;

    /* renamed from: q */
    public ArrayList<CtagInfoCompatible> f60474q;

    /* renamed from: r */
    public int f60475r;

    public C13403g(Context context, String str, String str2, List<LocalId> list, int i10, String str3, String str4, String str5, String str6, ArrayList<CtagInfoCompatible> arrayList, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        super(context, str, str2, str3, str4, str5, concurrentHashMap);
        this.f60459b = new ArrayList(10);
        this.f60461d = new ArrayList<>();
        this.f60462e = new ArrayList<>(10);
        this.f60463f = new ArrayList<>(10);
        this.f60464g = new ArrayList<>(10);
        this.f60465h = new ArrayList<>(10);
        this.f60466i = new ArrayList<>(10);
        this.f60467j = new ArrayList<>(10);
        this.f60468k = new ArrayList<>(10);
        this.f60469l = new ArrayList<>(10);
        this.f60470m = new ArrayList<>(10);
        this.f60471n = false;
        this.f60475r = 0;
        C11839m.m70688i("StartSyncImpl", "Sync type = " + str + ", dataType = " + str2 + ", order = " + i10 + ", packageName = " + str5);
        this.f60458a = context;
        if (list != null) {
            this.f60459b = list;
        }
        this.f60472o = i10;
        this.f60473p = str6;
        this.f60474q = arrayList;
    }

    /* renamed from: o */
    private byte[] m80546o(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes(Constants.UTF_8);
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    /* renamed from: A */
    public final void m80547A() {
        if (this.f60460c.isEmpty()) {
            C11839m.m70688i("StartSyncImpl", "Set all data as cloud added, cloud etag size = " + this.cloudEtagMap.size());
            m80559M();
            return;
        }
        HashMap map = new HashMap(10);
        for (Map.Entry<String, SyncData> entry : this.f60460c.entrySet()) {
            map.put(entry.getValue().getGuid(), entry.getValue());
        }
        C11839m.m70688i("StartSyncImpl", "Identify cloud data status, cloud etag size = " + this.cloudEtagMap.size());
        HashSet hashSet = new HashSet(this.cloudEtagMap.size());
        for (Map.Entry<String, Etag> entry2 : this.cloudEtagMap.entrySet()) {
            String key = entry2.getKey();
            Etag value = entry2.getValue();
            SyncData syncData = map.get(key);
            if (value == null || value.getEtag() == null) {
                C11839m.m70687e("StartSyncImpl", "Cloud Etag is null, guid = " + key);
            } else {
                hashSet.add(key);
                if (!map.containsKey(key) || syncData == null) {
                    SyncData syncDataM80568e = m80568e(key, value.getEtag());
                    this.f60463f.add(key);
                    this.f60461d.add(syncDataM80568e);
                } else if (!value.getEtag().equals(syncData.getEtag())) {
                    String luid = syncData.getLuid();
                    SyncData syncDataM80567d = m80567d(key, luid, value.getEtag());
                    if (syncData.getStatus() == 0) {
                        this.f60462e.add(key);
                        this.f60461d.add(syncDataM80567d);
                    }
                    if (syncData.getStatus() == 2) {
                        this.f60467j.remove(luid);
                        this.f60469l.add(luid);
                        this.f60465h.add(key);
                        this.f60461d.add(syncDataM80567d);
                    }
                    if (syncData.getStatus() == 1) {
                        this.f60468k.remove(luid);
                        this.f60469l.add(luid);
                        this.f60465h.add(key);
                        this.f60461d.add(syncDataM80567d);
                    }
                }
            }
        }
        m80548B(map, hashSet);
    }

    /* renamed from: B */
    public final void m80548B(Map<String, SyncData> map, Set<String> set) {
        if (map == null || set == null) {
            C11839m.m70687e("StartSyncImpl", "Identify cloud deleted data, variables is null");
            return;
        }
        HashSet hashSet = new HashSet(map.keySet());
        hashSet.removeAll(set);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            SyncData syncData = map.get((String) it.next());
            String luid = syncData.getLuid();
            if (syncData.getStatus() == 0) {
                this.f60464g.add(luid);
            } else if (syncData.getStatus() == 2) {
                this.f60466i.add(luid);
                this.f60467j.remove(luid);
                this.f60470m.add(luid);
            } else if (syncData.getStatus() == 1) {
                this.f60464g.add(luid);
                this.f60468k.remove(luid);
            }
        }
    }

    /* renamed from: C */
    public final void m80549C() {
        Map<String, SyncData> mapQueryModuleEtag = SyncProcessBase.queryModuleEtag(this.mDataType);
        this.f60460c = mapQueryModuleEtag;
        if (mapQueryModuleEtag.isEmpty()) {
            m80560N();
            return;
        }
        HashSet hashSet = new HashSet(this.f60459b.size());
        for (LocalId localId : this.f60459b) {
            String id2 = localId.getId();
            hashSet.add(id2);
            if (!this.f60460c.containsKey(id2)) {
                this.f60466i.add(id2);
            } else if (localId.getDirty() == 1) {
                this.f60460c.get(id2).setStatus(2);
                this.f60467j.add(id2);
            } else {
                this.f60460c.get(id2).setStatus(0);
            }
        }
        Set<String> hashSet2 = new HashSet<>(this.f60460c.keySet());
        hashSet2.removeAll(hashSet);
        m80561O(hashSet2);
    }

    /* renamed from: D */
    public final void m80550D(int i10) throws JSONException {
        C11839m.m70688i("StartSyncImpl", "start send increment callBack over");
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putBoolean("is_incrementally_query", this.isQueryEtagIncremental);
        bundle.putString("sync_module_package_name", this.mSyncModulePackageName);
        bundle.putBoolean("is_send_over", true);
        bundle.putBoolean("increment_bundle", true);
        bundle.putBoolean("is_increment_send_data", true);
        C2980i.m17883r(this.mReportEndInfo, this.isQueryEtagIncremental);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.SENDCALLBACK");
        intent.putExtra("msgType", this.mSyncType);
        intent.putExtra("msgID", 10001);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.f60458a).m78881d(intent);
        CloudSyncUtil.m15993a1(this.f60458a, this.mSyncType, i10);
        reportPreSync(this.cloudEtagMap, this.f60475r, this.isQueryEtagIncremental);
    }

    /* renamed from: E */
    public final int m80551E(Change change, Map<String, Etag> map) throws C9722c {
        String id2 = change.getId();
        Record record = change.getRecord();
        Etag etag = new Etag();
        if (change.getDeleted() == null) {
            throw new C9722c(2237, "getChangeList, etag operation is null, recordId = " + id2, this.mSyncType, "getChangeList");
        }
        int i10 = 1;
        if (record != null) {
            if (record.getVersion() == null) {
                throw new C9722c(2223, "getChangeList, record version is null, recordId = " + id2, this.mSyncType, "getChangeList");
            }
            etag.setEtag(record.getVersion().toString());
            if (change.getDeleted().booleanValue()) {
                etag.setOperation(2);
            } else {
                etag.setOperation(1);
                i10 = 0;
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
            etag.setEtag("");
            etag.setOperation(2);
            this.cloudEtagMap.put(id2, etag);
        } else {
            i10 = 0;
        }
        map.put(id2, etag);
        return i10;
    }

    /* renamed from: F */
    public int m80552F(C9722c c9722c, boolean z10) throws C9722c {
        int iDeleteTag;
        C11839m.m70687e("StartSyncImpl", "syncV2 proChangeListSyncException errorCode = " + c9722c.m60666c() + ", errorMsg = " + c9722c.getMessage() + ", isIncrement = " + z10);
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
        int recordList = !z10 ? getRecordList() : m80588z(this.mSyncType, this.mDataType, "nextCursor,records(id,recycled,version)");
        reportPropfind("getRecordList", "cursorInvalid", this.cloudEtagMap.size(), 0);
        return recordList;
    }

    /* renamed from: G */
    public void m80553G(int i10, boolean z10, Map<String, Etag> map) {
        C11839m.m70688i("StartSyncImpl", "start send increment callBack end");
        Bundle bundle = new Bundle();
        StringBuilder sb2 = new StringBuilder();
        if (z10) {
            sb2.append(m80555I());
        }
        sb2.append(SyncLogicServiceUtil.parseIncrementEtagMapToString(map, z10, true, "]}"));
        m80556J(i10, bundle, sb2);
    }

    /* renamed from: H */
    public void m80554H(int i10, boolean z10, Map<String, Etag> map) {
        C11839m.m70688i("StartSyncImpl", "start send increment callBack middle");
        Bundle bundle = new Bundle();
        StringBuilder sb2 = new StringBuilder();
        if (z10) {
            sb2.append(m80555I());
        }
        sb2.append(SyncLogicServiceUtil.parseIncrementEtagMapToString(map, z10, false, "]}"));
        m80556J(i10, bundle, sb2);
    }

    /* renamed from: I */
    public final String m80555I() {
        StringBuilder sb2 = new StringBuilder();
        String incrementCtagMapToString = SyncLogicServiceUtil.parseIncrementCtagMapToString(this.cloudCtagMap);
        sb2.append("{\"cloud_ctag_map\":[");
        sb2.append(incrementCtagMapToString);
        sb2.append("]");
        sb2.append(",\"cloud_etag_map\":[");
        return sb2.toString();
    }

    /* renamed from: J */
    public final void m80556J(int i10, Bundle bundle, StringBuilder sb2) {
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putString("dataType", this.mDataType);
        bundle.putString("traceId", this.traceId);
        bundle.putBoolean("is_incrementally_query", this.isQueryEtagIncremental);
        bundle.putByteArray("batches_data_bytes_key", m80546o(sb2.toString()));
        bundle.putString("sync_module_package_name", this.mSyncModulePackageName);
        bundle.putBoolean("is_in_batches", true);
        bundle.putBoolean("is_send_over", false);
        bundle.putBoolean("increment_bundle", true);
        bundle.putBoolean("is_increment_send_data", true);
        C2980i.m17883r(this.mReportEndInfo, this.isQueryEtagIncremental);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.SENDCALLBACK");
        intent.putExtra("msgType", this.mSyncType);
        intent.putExtra("msgID", 10001);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.f60458a).m78881d(intent);
    }

    /* renamed from: K */
    public final void m80557K(int i10, boolean z10) throws JSONException {
        if (z10) {
            m80550D(i10);
        } else {
            m80562P(false);
        }
    }

    /* renamed from: L */
    public final void m80558L(int i10) throws JSONException {
        if (i10 == 0) {
            m80550D(checkHasGetAllCloudEtag(i10));
        } else {
            m80562P(false);
            m80573j(checkHasGetAllCloudEtag(i10));
        }
    }

    /* renamed from: M */
    public final void m80559M() {
        for (Map.Entry<String, Etag> entry : this.cloudEtagMap.entrySet()) {
            String key = entry.getKey();
            Etag value = entry.getValue();
            if (value == null || value.getEtag() == null) {
                C11839m.m70687e("StartSyncImpl", "Etag is null, guid = " + key);
            } else {
                SyncData syncDataM80568e = m80568e(key, value.getEtag());
                this.f60463f.add(key);
                this.f60461d.add(syncDataM80568e);
            }
        }
    }

    /* renamed from: N */
    public final void m80560N() {
        Iterator<LocalId> it = this.f60459b.iterator();
        while (it.hasNext()) {
            this.f60466i.add(it.next().getId());
        }
    }

    /* renamed from: O */
    public final void m80561O(Set<String> set) {
        for (String str : set) {
            this.f60468k.add(str);
            this.f60460c.get(str).setStatus(1);
        }
    }

    /* renamed from: P */
    public final void m80562P(boolean z10) {
        this.f60471n = z10;
    }

    /* renamed from: Q */
    public int m80563Q() throws JSONException {
        C2984m c2984m = new C2984m();
        String message = "";
        boolean zIsPersistedDataSavedInCloudSyncSDK = SyncLogicService.isPersistedDataSavedInCloudSyncSDK(this.mSyncModulePackageName);
        int iM17923a = 0;
        try {
            try {
                if (this.f60472o == 1) {
                    C2786g.m16223l(this.f60458a, this.traceId, this.mSyncType, this.serverFlowControlEffected);
                    C2786g.m16224m(this.f60458a, this.traceId, this.mSyncType);
                    m80572i();
                    CloudSyncUtil.m16053v(this.mSyncType);
                    if ("addressbook".equals(this.mSyncType)) {
                        getDataVersion(this.mSyncType, true);
                    } else {
                        getDataVersion(this.mSyncType, false);
                    }
                }
                if (!zIsPersistedDataSavedInCloudSyncSDK) {
                    m80549C();
                    if (new C2974c(this.f60458a, this.mSyncType, this.mSyncModulePackageName, this.mDataType, this.f60466i.size(), this.f60468k.size(), this.f60467j.size(), this.traceId).m17833f()) {
                        throw new C9722c(FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED, "risk management effective");
                    }
                }
                isCancel();
                m80586x();
                m80577n();
                boolean zM15955I = CloudSyncUtil.m15955I(this.f60458a, this.mSyncType);
                CloudSyncUtil.m15984W0(this.f60458a, this.mSyncType, false);
                m80582t(zIsPersistedDataSavedInCloudSyncSDK, zM15955I);
            } catch (C9722c e10) {
                iM17923a = c2984m.m17923a(e10);
                if (SyncLogicService.cloudSyncSDKHasCollaborativeAbility(this.mSyncModulePackageName)) {
                    iM17923a = e10.m60666c();
                }
                message = e10.getMessage();
                C10812z.m65841j(this.f60458a, e10.m60668e(), this.mDataType, e10.m60666c(), e10.m60667d(), e10.getMessage(), this.operationType, e10.m60665b(), this.traceId);
            } catch (Exception e11) {
                iM17923a = 5;
                message = e11.getMessage();
                C11839m.m70687e("StartSyncImpl", "Start sync, error: " + e11.toString());
                C10812z.m65840i(this.f60458a, this.mSyncType, this.mDataType, 5, e11.toString(), this.operationType, "", this.traceId);
            }
            int iCheckHasGetAllCloudEtag = checkHasGetAllCloudEtag(iM17923a);
            m80573j(iCheckHasGetAllCloudEtag);
            C2980i.m17879n(this.mReportEndInfo, iCheckHasGetAllCloudEtag, message);
            return iCheckHasGetAllCloudEtag;
        } catch (Throwable th2) {
            int iCheckHasGetAllCloudEtag2 = checkHasGetAllCloudEtag(0);
            m80573j(iCheckHasGetAllCloudEtag2);
            C2980i.m17879n(this.mReportEndInfo, iCheckHasGetAllCloudEtag2, "");
            throw th2;
        }
    }

    /* renamed from: a */
    public final void m80564a(int i10, int i11, boolean z10, Map<String, Etag> map) {
        if (z10) {
            m80575l(i10, false, map);
        } else {
            m80575l(i10, true, map);
        }
        m80574k(i10);
        C11839m.m70688i("StartSyncImpl", "syncV2 getChangesListByIncrement dataType = " + this.mDataType + ", send times = " + (i11 + 1));
    }

    /* renamed from: b */
    public final void m80565b(int i10, int i11, boolean z10, Map<String, Etag> map) {
        if (z10) {
            m80553G(i10, false, map);
        } else {
            m80553G(i10, true, map);
        }
        C11839m.m70688i("StartSyncImpl", "syncV2 getRecordsListForAtlas dataType = " + this.mDataType + ", send times = " + i11);
    }

    /* renamed from: c */
    public final Bundle m80566c(int i10) throws JSONException {
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putString("sync_module_package_name", this.mSyncModulePackageName);
        bundle.putString("dataType", this.mDataType);
        bundle.putString("traceId", this.traceId);
        bundle.putBoolean("is_increment_send_data", false);
        if (i10 == 0) {
            if (SyncLogicService.isPersistedDataSavedInCloudSyncSDK(this.mSyncModulePackageName)) {
                ParcelableMap parcelableMap = new ParcelableMap();
                parcelableMap.setMap(m80569f(this.cloudCtagMap, SyncLogicService.getSdkVersion(this.mSyncModulePackageName)));
                bundle.putParcelable("cloud_ctag_map", parcelableMap);
                C11839m.m70688i("StartSyncImpl", "cloudCtagMap.size = " + this.cloudCtagMap.size());
                ParcelableMap parcelableMap2 = new ParcelableMap();
                parcelableMap2.setMap(m80570g(this.cloudEtagMap, SyncLogicService.getSdkVersion(this.mSyncModulePackageName)));
                bundle.putParcelable("cloud_etag_map", parcelableMap2);
                C11839m.m70688i("StartSyncImpl", "cloudEtagMap.size = " + this.cloudEtagMap.size());
                bundle.putBoolean("is_incrementally_query", this.isQueryEtagIncremental);
            } else {
                bundle.putStringArrayList("cadd", this.f60463f);
                bundle.putStringArrayList("cmod", this.f60462e);
                bundle.putStringArrayList("cdel", this.f60464g);
                bundle.putStringArrayList("cconflict", this.f60465h);
                bundle.putStringArrayList("ladd", this.f60466i);
                bundle.putStringArrayList("lmod", this.f60467j);
                bundle.putStringArrayList("ldel", this.f60468k);
                bundle.putStringArrayList("Lconflict", this.f60469l);
                bundle.putStringArrayList("lmodcdel", this.f60470m);
                bundle.putParcelableArrayList("coperatemap", this.f60461d);
            }
            reportPreSync(this.cloudEtagMap, this.f60475r, this.isQueryEtagIncremental);
        }
        C2980i.m17883r(this.mReportEndInfo, this.isQueryEtagIncremental);
        return bundle;
    }

    /* renamed from: d */
    public final SyncData m80567d(String str, String str2, String str3) {
        SyncData syncData = new SyncData();
        syncData.setGuid(str);
        syncData.setEtag(str3);
        syncData.setLuid(str2);
        return syncData;
    }

    /* renamed from: e */
    public final SyncData m80568e(String str, String str2) {
        SyncData syncData = new SyncData();
        syncData.setGuid(str);
        syncData.setEtag(str2);
        return syncData;
    }

    /* renamed from: f */
    public final Map<String, Ctag> m80569f(Map<String, Ctag> map, int i10) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, Ctag> entry : map.entrySet()) {
            Ctag value = entry.getValue();
            value.setVersion(i10);
            map2.put(entry.getKey(), value);
        }
        return map2;
    }

    /* renamed from: g */
    public final Map<String, Etag> m80570g(Map<String, Etag> map, int i10) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, Etag> entry : map.entrySet()) {
            Etag value = entry.getValue();
            value.setVersion(i10);
            map2.put(entry.getKey(), value);
        }
        return map2;
    }

    /* renamed from: h */
    public final boolean m80571h(C13007b c13007b) {
        return "calendar".equals(this.mSyncType) && c13007b.m78286t();
    }

    /* renamed from: i */
    public final void m80572i() throws C9722c {
        if ("calendar".equals(this.mSyncType)) {
            C10028c c10028cM62182c0 = C10028c.m62182c0();
            String strM62271S0 = c10028cM62182c0.m62271S0(this.mSyncType);
            String strM70622v = C11829c.m70622v(C1529a.f6579e, System.currentTimeMillis());
            if (strM62271S0 == null || !strM62271S0.equals(strM70622v)) {
                c10028cM62182c0.m62241L3(this.mSyncType, strM70622v);
                c10028cM62182c0.m62236K3(this.mSyncType, 1);
            } else {
                boolean z10 = System.currentTimeMillis() - c10028cM62182c0.m62389s0(this.mSyncType) < 300000;
                String str = this.mSyncType;
                c10028cM62182c0.m62236K3(str, c10028cM62182c0.m62267R0(str) + 1);
                if (c10028cM62182c0.m62267R0(this.mSyncType) > 500 && z10) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("syncCount", String.valueOf(c10028cM62182c0.m62267R0(this.mSyncType)));
                    String str2 = "calender call count up to max and less than five minutes since the last call" + linkedHashMap.toString();
                    C9722c c9722c = new C9722c(SNSCode.Status.GET_FRIEND_LIST_FAIL, str2);
                    c9722c.m60671h(this.mSyncType);
                    c9722c.m60670g("calender sync");
                    c9722c.m60669f("calendar_sync_flow_control");
                    C11839m.m70687e("StartSyncImpl", "calendarFlowControl error: " + str2);
                    throw c9722c;
                }
            }
            c10028cM62182c0.m62337h3(this.mSyncType, System.currentTimeMillis());
        }
    }

    @Override // com.huawei.android.hicloud.sync.contact.SyncProcessBase
    public boolean isSupportIncrementalQuery() {
        boolean zM17977V = DriveSyncUtil.m17977V(this.mSyncModulePackageName);
        C11839m.m70688i("StartSyncImpl", "getIsSupportIncremental = " + zM17977V);
        return zM17977V;
    }

    /* renamed from: j */
    public void m80573j(int i10) throws JSONException {
        if (!this.f60471n) {
            C11839m.m70688i("StartSyncImpl", "CallBack, value = " + i10);
            Bundle bundleM80566c = m80566c(i10);
            Intent intent = new Intent();
            intent.setAction("com.huawei.android.hicloud.intent.SENDCALLBACK");
            intent.putExtra("msgType", this.mSyncType);
            intent.putExtra("msgID", 10001);
            intent.putExtra("bundle", bundleM80566c);
            C13108a.m78878b(this.f60458a).m78881d(intent);
            CloudSyncUtil.m15993a1(this.f60458a, this.mSyncType, i10);
        }
        m80562P(false);
    }

    /* renamed from: k */
    public final void m80574k(int i10) {
        C11839m.m70688i("StartSyncImpl", "start send increment callBack end");
        Bundle bundle = new Bundle();
        StringBuilder sb2 = new StringBuilder();
        String incrementCtagMapToString = SyncLogicServiceUtil.parseIncrementCtagMapToString(this.cloudCtagMap);
        sb2.append(",\"cloud_ctag_map\":[");
        sb2.append(incrementCtagMapToString);
        sb2.append("]}");
        m80556J(i10, bundle, sb2);
    }

    /* renamed from: l */
    public final void m80575l(int i10, boolean z10, Map<String, Etag> map) {
        C11839m.m70688i("StartSyncImpl", "start send increment callBack end");
        Bundle bundle = new Bundle();
        StringBuilder sb2 = new StringBuilder();
        if (z10) {
            sb2.append("{\"cloud_etag_map\":[");
        }
        sb2.append(SyncLogicServiceUtil.parseIncrementEtagMapToString(map, z10, true, "]"));
        m80556J(i10, bundle, sb2);
    }

    /* renamed from: m */
    public final void m80576m(int i10, boolean z10, Map<String, Etag> map) {
        C11839m.m70688i("StartSyncImpl", "start send increment callBack middle");
        Bundle bundle = new Bundle();
        StringBuilder sb2 = new StringBuilder();
        if (z10) {
            sb2.append("{\"cloud_etag_map\":[");
        }
        sb2.append(SyncLogicServiceUtil.parseIncrementEtagMapToString(map, z10, false, "]"));
        m80556J(i10, bundle, sb2);
    }

    /* renamed from: n */
    public final void m80577n() throws C9722c {
        Set<String> setM78242T;
        C13007b c13007bM78205Y = C13007b.m78205Y(this.f60458a);
        if (c13007bM78205Y == null || (setM78242T = c13007bM78205Y.m78242T(this.mSyncType)) == null || setM78242T.isEmpty() || setM78242T.contains(this.mDataType)) {
            return;
        }
        throw new C9722c(2202, "pimds not support data type: " + this.mDataType, this.mSyncType, "local_pre_sync");
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0098: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r5 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:17:0x0098 */
    /* renamed from: p */
    public final void m80578p(String str) throws Throwable {
        int i10;
        int i11;
        C11839m.m70688i("StartSyncImpl", "syncV2 need changes.list,dataType: " + this.mDataType);
        this.isQueryEtagIncremental = true;
        this.cloudEtagMap.clear();
        int i12 = 0;
        try {
            try {
                List<Change> changesList = getChangesList(this.mSyncType, this.mDataType, str);
                C11839m.m70686d("StartSyncImpl", "syncV2 dataType: " + this.mDataType + ", changeList run: " + changesList.toString());
                i10 = 0;
                for (Change change : changesList) {
                    try {
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
                                boolean z10 = SyncLogicService.isSdkSupportRecycleProcess(this.mSyncModulePackageName) && SyncLogicService.isServiceSupportRecycleProcess(this.f60458a, this.mSyncType, this.mDataType);
                                if (record.getRecycled() == null || !record.getRecycled().booleanValue() || z10) {
                                    etag.setOperation(1);
                                } else {
                                    etag.setOperation(2);
                                }
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
                    } catch (C9722c e10) {
                        e = e10;
                        C11839m.m70688i("StartSyncImpl", "syncV2 getChangesList errorCode: " + e.m60666c() + ", errMsg = " + e.getMessage());
                        if ("atlas".equals(this.mSyncType)) {
                            m80552F(e, true);
                        } else {
                            m80552F(e, false);
                        }
                        this.f60475r = i10;
                        reportPropfind("getChangeList", "change", this.cloudEtagMap.size(), i10);
                    }
                }
            } catch (C9722c e11) {
                e = e11;
                i10 = 0;
            } catch (Throwable th2) {
                th = th2;
                this.f60475r = i12;
                reportPropfind("getChangeList", "change", this.cloudEtagMap.size(), i12);
                throw th;
            }
            this.f60475r = i10;
            reportPropfind("getChangeList", "change", this.cloudEtagMap.size(), i10);
        } catch (Throwable th3) {
            th = th3;
            i12 = i11;
            this.f60475r = i12;
            reportPropfind("getChangeList", "change", this.cloudEtagMap.size(), i12);
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0195, code lost:
    
        if (android.text.TextUtils.isEmpty(r8.getNewStartCursor()) != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0197, code lost:
    
        r13.m78265i0(r26.mDataType, r8.getNewStartCursor());
        r0 = new com.huawei.android.hicloud.sync.service.aidl.Ctag();
        r0.setCtag(r8.getNewStartCursor());
        r26.cloudCtagMap.put(r26.mDataType, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01b3, code lost:
    
        r2 = r16;
     */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02ac  */
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.huawei.android.hicloud.syncdrive.cloudsync.model.Change> m80579q(java.lang.String r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 780
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: vc.C13403g.m80579q(java.lang.String):java.util.List");
    }

    /* renamed from: r */
    public final void m80580r(String str) throws Throwable {
        if (CloudSyncUtil.m15973R(this.f60458a, this.mSyncType, this.mSyncModulePackageName) && CloudSyncUtil.m15956I0(this.mSyncType)) {
            m80579q(str);
        } else {
            m80578p(str);
        }
    }

    /* renamed from: s */
    public final void m80581s(boolean z10) throws Throwable {
        isCancel();
        C13007b c13007bM78205Y = C13007b.m78205Y(this.f60458a);
        String strM80584v = m80584v(this.mDataType);
        String strM78234O = c13007bM78205Y.m78234O(this.mSyncType);
        boolean zM78298z = c13007bM78205Y.m78298z(this.mSyncType, this.mDataType);
        boolean zM80571h = m80571h(c13007bM78205Y);
        C11839m.m70688i("StartSyncImpl", "syncV2 dataType: " + this.mDataType + ", localCtag:" + strM80584v + ", cloudCtag: " + strM78234O);
        if (z10 || TextUtils.isEmpty(strM80584v) || zM78298z || zM80571h) {
            C11839m.m70688i("StartSyncImpl", "syncV2 need record.list mDataType: " + this.mDataType + ", isOpenSwitch: " + z10 + " isNeedFullSync: " + zM78298z + ", isCalendarNeedFullSync: " + zM80571h);
            this.isQueryEtagIncremental = false;
            this.hasGetAllCloudEtag = true;
            m80587y(this.mSyncType, this.mDataType, "nextCursor,records(id,recycled,version)");
            if (zM78298z) {
                c13007bM78205Y.m78279p0(this.mSyncType, this.mDataType, false);
            }
            String str = z10 ? "openSwitch" : TextUtils.isEmpty(strM80584v) ? "localCtagEmpty" : zM78298z ? "firstMigrate" : "";
            if (zM80571h) {
                c13007bM78205Y.m78263h0(false);
                str = "calendarFirstUpgrade";
            }
            reportPropfind("getRecordList", str, this.cloudEtagMap.size(), this.f60475r);
            return;
        }
        if (TextUtils.isEmpty(strM80584v) || strM80584v.equals(strM78234O)) {
            boolean zM17977V = DriveSyncUtil.m17977V(this.mSyncModulePackageName);
            C11839m.m70686d("StartSyncImpl", "syncV2 mDataType: " + this.mDataType + ",isSupportIncrementQuery: " + zM17977V);
            if (zM17977V) {
                this.isQueryEtagIncremental = true;
                return;
            }
            return;
        }
        boolean zM17977V2 = DriveSyncUtil.m17977V(this.mSyncModulePackageName);
        C11839m.m70686d("StartSyncImpl", "syncV2 mDataType: " + this.mDataType + ",isSupportIncrementQuery: " + zM17977V2);
        if (zM17977V2) {
            this.isQueryEtagIncremental = true;
            m80580r(strM80584v);
            return;
        }
        C11839m.m70688i("StartSyncImpl", "syncV2 need record.list");
        this.isQueryEtagIncremental = false;
        this.hasGetAllCloudEtag = true;
        m80587y(this.mSyncType, this.mDataType, "nextCursor,records(id,recycled,version)");
        reportPropfind("getRecordList", "noSupportIncre", this.cloudEtagMap.size(), this.f60475r);
    }

    /* renamed from: t */
    public final void m80582t(boolean z10, boolean z11) throws Throwable {
        if (z10) {
            m80581s(z11);
        } else {
            m80585w(z11);
        }
    }

    /* renamed from: u */
    public final CtagInfo m80583u(String str) {
        ArrayList<CtagInfoCompatible> arrayList = this.f60474q;
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

    /* renamed from: v */
    public final String m80584v(String str) {
        CtagInfo ctagInfoM80583u = m80583u(str);
        return ctagInfoM80583u != null ? ctagInfoM80583u.getCtagValue() : this.f60473p;
    }

    /* renamed from: w */
    public final void m80585w(boolean z10) throws Throwable {
        String localCtag = getLocalCtag(this.mDataType);
        C13007b c13007bM78205Y = C13007b.m78205Y(this.f60458a);
        boolean zM78298z = c13007bM78205Y.m78298z(this.mSyncType, this.mDataType);
        if (z10 || TextUtils.isEmpty(localCtag) || isCloudDataChanged(this.mDataType, this.f60472o) || zM78298z) {
            C11839m.m70688i("StartSyncImpl", "syncV2 need record.list mDataType: " + this.mDataType + ", isOpenSwitch: " + z10 + " isNeedFullSync: " + zM78298z + ",localCtag: " + localCtag);
            isCancel();
            getRecordList();
            if (zM78298z) {
                c13007bM78205Y.m78279p0(this.mSyncType, this.mDataType, false);
            }
            isCancel();
            m80547A();
        }
    }

    /* renamed from: x */
    public final void m80586x() throws Throwable {
        if (this.f60472o == 1) {
            if (1 == CloudSyncUtil.m15979U(this.mSyncType)) {
                SyncLogicServiceUtil.syncApplyPowerkit(this.mSyncType);
            }
            syncV2(this.mSyncType);
        }
    }

    /* renamed from: y */
    public final void m80587y(String str, String str2, String str3) throws Throwable {
        if ("atlas".equals(this.mSyncType)) {
            m80588z(str, str2, str3);
        } else {
            getRecordList();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x01f7, code lost:
    
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01f8, code lost:
    
        m80565b(0, r14, r13, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01fb, code lost:
    
        m80558L(0);
        p514o9.C11839m.m70688i("StartSyncImpl", "syncV2 Method result: dataType = " + r19 + ", recordSize = " + r12);
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x021b, code lost:
    
        r0 = e;
     */
    /* renamed from: z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m80588z(java.lang.String r18, java.lang.String r19, java.lang.String r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 650
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: vc.C13403g.m80588z(java.lang.String, java.lang.String, java.lang.String):int");
    }
}
