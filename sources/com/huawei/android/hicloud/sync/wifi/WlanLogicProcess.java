package com.huawei.android.hicloud.sync.wifi;

import ad.C0100a;
import android.content.Context;
import android.text.TextUtils;
import bd.C1164a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.sync.contact.SyncProcessBase;
import com.huawei.android.hicloud.sync.protocol.C2924c;
import com.huawei.android.hicloud.sync.protocol.C2925d;
import com.huawei.android.hicloud.sync.protocol.C2926e;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfo;
import com.huawei.android.hicloud.sync.service.aidl.Etag;
import com.huawei.android.hicloud.sync.syncutil.C2980i;
import com.huawei.android.hicloud.sync.wifi.datamanager.SyncWlanBean;
import com.huawei.android.hicloud.sync.wifi.datamanager.WlanBean;
import com.huawei.android.hicloud.sync.wifi.datamanager.WlanManager;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRet;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Record;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Changes;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9722c;
import gp.C10028c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import je.C10781c0;
import p015ak.C0227m;
import p255ed.C9453i;
import p514o9.C11839m;
import p551pc.C12127a;
import p709vj.C13452e;
import sc.C12770c;
import sc.C12777j;
import tc.C13007b;

/* loaded from: classes3.dex */
public class WlanLogicProcess extends SyncProcessBase {
    private static final int ADD = 3;
    private static final int DELETE = 1;
    private static final int MODIFY = 2;
    private static final int NOCHANGE = 0;
    private static final String TAG = "WlanLogicProcess";
    protected int cAdd;
    protected List<SyncWlanBean> cAddData;
    protected int cDel;
    protected List<String> cDelItems;
    protected int cMod;
    protected int cModNoChange;
    protected List<SyncWlanBean> cModifyData;
    protected Map<String, SyncWlanBean> cNewData;
    protected Map<String, SyncWlanBean> cNewItems;
    protected List<String> cNewUpdaItems;
    protected Map<String, SyncWlanBean> cUpdaData;
    protected Map<String, SyncWlanBean> cUpdaItems;
    protected boolean genCtag;
    protected int lAdd;
    protected List<SyncWlanBean> lAddData;
    protected int lDel;
    protected Map<String, SyncWlanBean> lDelItems;
    protected List<SyncWlanBean> lDeleteData;
    protected int lMod;
    protected List<SyncWlanBean> lModifyData;
    protected Map<String, SyncWlanBean> lNewItems;
    protected Map<String, SyncWlanBean> lUpdItems;
    protected int mSyncMode;
    protected boolean updateCtag;

    /* renamed from: wm */
    protected WlanManager f13028wm;

    public WlanLogicProcess(Context context, String str, String str2, String str3, String str4, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        super(context, str, str2, str3, str4, "", concurrentHashMap);
        this.updateCtag = false;
        this.genCtag = false;
        this.f13028wm = null;
        this.lNewItems = new HashMap(10);
        this.lUpdItems = new HashMap(10);
        this.lDelItems = new HashMap(10);
        this.cNewItems = new HashMap(10);
        this.cUpdaItems = new HashMap(10);
        this.cNewData = new HashMap(10);
        this.cUpdaData = new HashMap(10);
        this.cDelItems = new ArrayList(10);
        this.cNewUpdaItems = new ArrayList(10);
        this.cAddData = new ArrayList(10);
        this.cModifyData = new ArrayList(10);
        this.lAddData = new ArrayList(10);
        this.lModifyData = new ArrayList(10);
        this.lDeleteData = new ArrayList(10);
        this.lAdd = 0;
        this.lMod = 0;
        this.lDel = 0;
        this.cAdd = 0;
        this.cMod = 0;
        this.cDel = 0;
        this.cModNoChange = 0;
        this.f13028wm = new WlanManager(context);
    }

    private void batchUpdateLocalData() throws C9722c {
        isCancel();
        Iterator<Map.Entry<String, SyncWlanBean>> it = this.cNewData.entrySet().iterator();
        while (it.hasNext()) {
            this.cAddData.add(it.next().getValue());
        }
        if (this.cAddData.size() > 0) {
            updateToLocal(this.cAddData, 3);
        }
        this.cNewData.clear();
        this.cAddData.clear();
        Iterator<Map.Entry<String, SyncWlanBean>> it2 = this.cUpdaData.entrySet().iterator();
        while (it2.hasNext()) {
            this.cModifyData.add(it2.next().getValue());
        }
        if (this.cModifyData.size() > 0) {
            updateToLocal(this.cModifyData, 2);
        }
        this.cUpdaData.clear();
        this.cModifyData.clear();
    }

    private void compareEtagIntellgent(Map<String, SyncWlanBean> map) {
        List<String> listM65632b = C10781c0.m65632b(this.mContext);
        for (Map.Entry<String, Etag> entry : this.cloudEtagMap.entrySet()) {
            String key = entry.getKey();
            Etag value = entry.getValue();
            SyncWlanBean syncWlanBean = map.get(key);
            if (value != null && value.getEtag() != null) {
                if (!map.containsKey(key) || syncWlanBean == null) {
                    SyncWlanBean syncWlanBean2 = new SyncWlanBean();
                    syncWlanBean2.setGuid(key);
                    syncWlanBean2.setEtag(value.getEtag());
                    syncWlanBean2.setStatus(value.getStatus());
                    this.cNewItems.put(key, syncWlanBean2);
                    this.cNewUpdaItems.add(key);
                } else if (value.getEtag().equals(syncWlanBean.getEtag())) {
                    String luid = syncWlanBean.getLuid();
                    if (C10781c0.m65631a(listM65632b, luid)) {
                        C11839m.m70686d(TAG, "compareEtagIntellgent: delete could vehicle ssid = " + luid);
                        this.lDelItems.put(luid, getSyncWlanBean(key, value, syncWlanBean));
                    }
                } else if (syncWlanBean.getStatus() == 0) {
                    this.cUpdaItems.put(key, getSyncWlanBean(key, value, syncWlanBean));
                    this.cNewUpdaItems.add(key);
                }
            }
        }
        for (Map.Entry<String, SyncWlanBean> entry2 : map.entrySet()) {
            String key2 = entry2.getKey();
            SyncWlanBean value2 = entry2.getValue();
            String luid2 = value2.getLuid();
            if (!this.cloudEtagMap.containsKey(key2)) {
                if (value2.getStatus() == 0) {
                    this.cDelItems.add(luid2);
                } else if (value2.getStatus() == 1) {
                    this.cDelItems.add(luid2);
                    this.lDelItems.remove(luid2);
                } else if (value2.getStatus() != 2) {
                    continue;
                } else {
                    if (listM65632b.contains(luid2)) {
                        C11839m.m70686d(TAG, "compareEtagIntellgent: filtering vehicle ssid = " + luid2);
                        return;
                    }
                    this.lNewItems.put(luid2, this.lUpdItems.get(luid2));
                    this.lUpdItems.remove(luid2);
                }
            }
        }
    }

    private static SyncWlanBean getSyncWlanBean(String str, Etag etag, SyncWlanBean syncWlanBean) {
        SyncWlanBean syncWlanBean2 = new SyncWlanBean();
        syncWlanBean2.setGuid(str);
        syncWlanBean2.setEtag(etag.getEtag());
        syncWlanBean2.setStatus(etag.getStatus());
        syncWlanBean2.setLuid(syncWlanBean.getLuid());
        return syncWlanBean2;
    }

    private void parseAddDataV2(Map<String, List<Record>> map, Map<String, List<FailRet>> map2) throws C9722c {
        List<Record> list = map.get("addSuccessList");
        List<FailRet> list2 = map2.get("addFailList");
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (SyncWlanBean syncWlanBean : this.lAddData) {
                Iterator<Record> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Record next = it.next();
                        if (syncWlanBean.getGuid().equals(next.getId())) {
                            syncWlanBean.setEtag(next.getVersion().toString());
                            arrayList.add(syncWlanBean);
                            break;
                        }
                    }
                }
            }
        }
        this.cAdd += updateWlanData(arrayList, false, null, false);
        C11839m.m70686d(TAG, "syncWlan local suc add data size: " + arrayList.size() + ", dataType = " + this.mDataType);
        C2980i.m17875j(this.mReportEndInfo, this.mDataType, arrayList.size());
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        C11839m.m70688i(TAG, "syncWlan local fail add size = " + list2.size() + ", dataType = " + this.mDataType);
        baseBeanParseFailList(this.lAddData, list2, "local_add_upload");
    }

    private void parseUpdateDataV2(Map<String, List<Record>> map, Map<String, List<FailRet>> map2) throws C9722c {
        List<Record> list = map.get("updateSuccessList");
        List<FailRet> list2 = map2.get("updateFailList");
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (SyncWlanBean syncWlanBean : this.lModifyData) {
                Iterator<Record> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Record next = it.next();
                        if (syncWlanBean.getGuid().equals(next.getId())) {
                            if (next.getStatus() == null || next.getStatus().intValue() == 200) {
                                syncWlanBean.setEtag(next.getVersion().toString());
                                arrayList.add(syncWlanBean);
                            } else if (next.getStatus().intValue() == 210) {
                                syncWlanBean.setEtag(next.getVersion().toString());
                                this.cModNoChange++;
                                arrayList.add(syncWlanBean);
                            }
                        }
                    }
                }
            }
        }
        this.cMod += updateWlanData(arrayList, false, null, false);
        C11839m.m70686d(TAG, "syncWlan local suc update data size: " + arrayList.size());
        C2980i.m17875j(this.mReportEndInfo, this.mDataType, arrayList.size());
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        C11839m.m70688i(TAG, "syncWlan local fail update size = " + list2.size() + ", dataType = " + this.mDataType);
        baseBeanParseFailList(this.lModifyData, list2, "local_modify_upload");
    }

    private void processAddDataV2(List<Record> list) throws C9722c, IOException {
        List<SyncWlanBean> list2 = this.lAddData;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        C11839m.m70688i(TAG, "syncWlan local add size = " + this.lAddData.size());
        List<String> listGenerateGuids = generateGuids(this.mSyncType, this.mDataType, Integer.valueOf(this.lAddData.size()));
        checkGuids(listGenerateGuids, this.lAddData.size(), "local_add_upload");
        for (int i10 = 0; i10 < listGenerateGuids.size(); i10++) {
            SyncWlanBean syncWlanBean = this.lAddData.get(i10);
            syncWlanBean.setGuid(listGenerateGuids.get(i10));
            Record record = new Record();
            record.setId(listGenerateGuids.get(i10));
            if (encryptDataV2(this.traceId, record, this.mSyncType, syncWlanBean.getLuid(), syncWlanBean.getData().toString(), null, "local_add_upload") == null) {
                throw new C9722c(2220, "syncWlan encryptData data is null", this.mSyncType, "local_add_upload");
            }
            record.setRecycled(Boolean.FALSE);
            list.add(record);
        }
    }

    private void processDataAddResult() throws C9722c {
        Map<String, C2926e> map = SyncProcessBase.getMapModifyRsp().get(SyncProtocol.Constant.ADDRSP);
        if (map == null || map.size() == 0) {
            return;
        }
        for (Map.Entry<String, C2926e> entry : map.entrySet()) {
            String key = entry.getKey();
            C2926e value = entry.getValue();
            String strM17758c = value.m17758c();
            for (SyncWlanBean syncWlanBean : this.lAddData) {
                if (strM17758c.equals(syncWlanBean.getLuid())) {
                    if (value.m17759d() != 200) {
                        throw new C9722c(2009, "WLAN processDataAddResult failed, status = " + value.m17759d(), this.mSyncType, "local_upload");
                    }
                    syncWlanBean.setGuid(key);
                    syncWlanBean.setEtag(value.m17757b());
                }
            }
        }
        this.cAdd += updateWlanData(this.lAddData, false, null, false);
        C11839m.m70686d(TAG, "syncWlan cloud add data = " + this.cAdd);
    }

    private void processDataDeleteResult() throws C9722c {
        Map<String, C2926e> map = SyncProcessBase.getMapModifyRsp().get(SyncProtocol.Constant.REMOVERSP);
        if (map == null || map.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, C2926e> entry : map.entrySet()) {
            String key = entry.getKey();
            C2926e value = entry.getValue();
            for (SyncWlanBean syncWlanBean : this.lDeleteData) {
                if (key.equals(syncWlanBean.getGuid())) {
                    if (value.m17759d() != 200) {
                        throw new C9722c(2009, "syncWlan processDataDeleteResult failed, status = " + value.m17759d(), this.mSyncType, "local_upload");
                    }
                    arrayList.add(syncWlanBean.getLuid());
                }
            }
        }
        updateWlanData(null, true, arrayList, false);
        C11839m.m70686d(TAG, "syncWlan cloud delete data = " + this.cDel);
    }

    private void processDataModifyResult() throws C9722c {
        Map<String, C2926e> map = SyncProcessBase.getMapModifyRsp().get(SyncProtocol.Constant.UPDATERSP);
        if (map == null || map.size() == 0) {
            return;
        }
        for (Map.Entry<String, C2926e> entry : map.entrySet()) {
            String key = entry.getKey();
            C2926e value = entry.getValue();
            for (SyncWlanBean syncWlanBean : this.lModifyData) {
                if (key.equals(syncWlanBean.getGuid())) {
                    if (value.m17759d() == 200) {
                        syncWlanBean.setEtag(value.m17757b());
                    } else {
                        if (value.m17759d() != 210) {
                            throw new C9722c(2009, "syncWlan processDataModifyResult failed, status = " + value.m17759d(), this.mSyncType, "local_upload");
                        }
                        syncWlanBean.setGuid(key);
                        syncWlanBean.setEtag(value.m17757b());
                        this.cModNoChange++;
                    }
                }
            }
        }
        this.cMod += updateWlanData(this.lModifyData, false, null, false);
    }

    private void processDelDataV2() throws Throwable {
        List<SyncWlanBean> list = this.lDeleteData;
        if (list == null || list.size() <= 0) {
            return;
        }
        C11839m.m70688i(TAG, "syncWlan local delete size = " + this.lDeleteData.size());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<SyncWlanBean> it = this.lDeleteData.iterator();
        while (it.hasNext()) {
            arrayList3.add(it.next().getGuid());
        }
        if (arrayList3.isEmpty()) {
            return;
        }
        deleteRecords(this.mSyncType, this.mDataType, arrayList3, arrayList, arrayList2, "local_delete_upload");
        C11839m.m70686d(TAG, "syncWlan delete succ = " + arrayList.toString());
        if (arrayList.size() > 0) {
            ArrayList arrayList4 = new ArrayList();
            for (String str : arrayList) {
                Iterator<SyncWlanBean> it2 = this.lDeleteData.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        SyncWlanBean next = it2.next();
                        if (str != null && str.equals(next.getGuid())) {
                            arrayList4.add(next.getLuid());
                            break;
                        }
                    }
                }
            }
            C11839m.m70686d(TAG, "syncWlan delete luids = " + arrayList4.toString());
            C11839m.m70688i(TAG, "syncWlan local delete succ size = " + arrayList4.size());
            updateWlanData(null, true, arrayList4, false);
            this.cDel = arrayList4.size();
            C2980i.m17875j(this.mReportEndInfo, this.mDataType, arrayList4.size());
        }
    }

    private void processLocalDataToCloudV2() throws Throwable {
        processDelDataV2();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        List<SyncWlanBean> list = this.lModifyData;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            processUpdateDataV2(arrayList);
            if (arrayList.size() > 0) {
                updateRecords(Constants.NORMAL_CACHE, arrayList, map, map2);
                parseUpdateDataV2(map, map2);
            }
        }
        List<SyncWlanBean> list2 = this.lAddData;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        checkIsHasPartialException(this.mSyncType);
        ArrayList arrayList2 = new ArrayList();
        processAddDataV2(arrayList2);
        if (arrayList2.size() > 0) {
            createRecords(Constants.NORMAL_CACHE, arrayList2, map, map2);
        }
        parseAddDataV2(map, map2);
    }

    private Map<String, List<C2925d>> processUpdateData() throws C9722c {
        HashMap map = new HashMap();
        List<SyncWlanBean> list = this.lAddData;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (SyncWlanBean syncWlanBean : this.lAddData) {
                C2925d c2925d = new C2925d();
                c2925d.m17755h(syncWlanBean.getLuid());
                c2925d.m17753f(syncWlanBean.getData().toString(), "wlan");
                arrayList.add(c2925d);
            }
            map.put(SyncProtocol.Constant.ADD, arrayList);
        }
        List<SyncWlanBean> list2 = this.lModifyData;
        if (list2 != null && list2.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            for (SyncWlanBean syncWlanBean2 : this.lModifyData) {
                C2925d c2925d2 = new C2925d();
                c2925d2.m17754g(syncWlanBean2.getGuid());
                c2925d2.m17753f(syncWlanBean2.getData().toString(), "wlan");
                arrayList2.add(c2925d2);
            }
            map.put(SyncProtocol.Constant.UPDATE, arrayList2);
        }
        List<SyncWlanBean> list3 = this.lDeleteData;
        if (list3 != null && list3.size() > 0) {
            ArrayList arrayList3 = new ArrayList();
            for (SyncWlanBean syncWlanBean3 : this.lDeleteData) {
                C2925d c2925d3 = new C2925d();
                c2925d3.m17754g(syncWlanBean3.getGuid());
                arrayList3.add(c2925d3);
            }
            map.put(SyncProtocol.Constant.REMOVE, arrayList3);
        }
        return map;
    }

    private void processUpdateDataV2(List<Record> list) throws C9722c {
        List<SyncWlanBean> list2 = this.lModifyData;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        C11839m.m70688i(TAG, "syncWlan local update size = " + this.lModifyData.size());
        for (SyncWlanBean syncWlanBean : this.lModifyData) {
            Record record = new Record();
            record.setId(syncWlanBean.getGuid());
            if (encryptDataV2(this.traceId, record, this.mSyncType, syncWlanBean.getLuid(), syncWlanBean.getData().toString(), null, "local_modify_upload") == null) {
                throw new C9722c(2220, "syncWlan encryptData data is null", this.mSyncType, "local_modify_upload");
            }
            record.setRecycled(Boolean.FALSE);
            list.add(record);
        }
    }

    private void queryCloudDataV2(String str, String str2, List<String> list) throws C9722c {
        this.cloudData = new HashMap();
        ArrayList<Record> recordsDataByIdList = getRecordsDataByIdList(str, str2, list, "records(attributes,cipher,createdTime,editedTime,id,kind,recycled,recycledTime,status,version)", "getData");
        if (!recordsDataByIdList.isEmpty()) {
            for (Record record : recordsDataByIdList) {
                this.cloudData.put(record.getId(), new C2924c(getDecryptData(str, record)));
            }
        }
        Map<String, C2924c> map = this.cloudData;
        if (map == null || map.isEmpty()) {
            return;
        }
        parseData();
    }

    private void updateDataToCloud() throws Throwable {
        isCancel();
        processLocalDataToCloudV2();
        this.lDeleteData.clear();
        this.lModifyData.clear();
        this.lAddData.clear();
    }

    private void updateLocalData() throws C9722c {
        List<String> list = this.cNewUpdaItems;
        if (list == null || list.size() == 0) {
            return;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < this.cNewUpdaItems.size()) {
            isCancel();
            int i12 = i11 * 100;
            int size = i12 + 100;
            if (size > this.cNewUpdaItems.size()) {
                size = this.cNewUpdaItems.size();
            }
            queryCloudDataV2(this.mSyncType, this.mDataType, this.cNewUpdaItems.subList(i12, size));
            Map<String, SyncWlanBean> map = this.lNewItems;
            if (map != null && map.size() > 0) {
                compareData();
            }
            batchUpdateLocalData();
            i11++;
            i10 = size;
        }
    }

    private void updateToLocal(List<SyncWlanBean> list, int i10) throws C9722c {
        if (3 == i10) {
            C11839m.m70688i(TAG, "syncWlan updateToLocal add size: " + list.size());
            this.lAdd = this.lAdd + updateWlanData(this.f13028wm.updateData(list, true), false, null, false);
            C2980i.m17872g(this.mReportEndInfo, this.mDataType, list.size());
            C11839m.m70688i(TAG, "syncWlan lAdd size: " + this.lAdd);
            return;
        }
        if (2 == i10) {
            C11839m.m70688i(TAG, "syncWlan updateToLocal modify size: " + list.size());
            this.lMod = this.lMod + updateWlanData(this.f13028wm.updateData(list, false), false, null, false);
            C2980i.m17872g(this.mReportEndInfo, this.mDataType, list.size());
            C11839m.m70688i(TAG, "syncWlan lMod size: " + this.lMod);
        }
    }

    public void beginSyncDataPre() throws C9722c {
        if (this.mSyncMode == 3) {
            HashMap<String, Map<String, SyncWlanBean>> mapPrepareLocalData = this.f13028wm.prepareLocalData();
            this.lNewItems = mapPrepareLocalData.get("0");
            this.lUpdItems = mapPrepareLocalData.get("1");
            this.lDelItems = mapPrepareLocalData.get("2");
            return;
        }
        throw new C9722c(2003, "SyncSource " + this.mModuleName + ": invalid sync mode " + this.mSyncMode, this.mSyncType, "local_pre_sync");
    }

    public void compareData() throws C9722c {
        isCancel();
        if (this.cNewData == null) {
            this.cNewData = new HashMap(10);
        }
        if (this.lUpdItems == null) {
            this.lUpdItems = new HashMap(10);
        }
        if (this.lNewItems == null) {
            this.lNewItems = new HashMap(10);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, SyncWlanBean> entry : this.cNewData.entrySet()) {
            String ssid = entry.getValue().getData().getSsid();
            Iterator<Map.Entry<String, SyncWlanBean>> it = this.lNewItems.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<String, SyncWlanBean> next = it.next();
                    String ssid2 = next.getValue().getData().getSsid();
                    if (ssid != null && ssid2 != null && ssid.equals(ssid2)) {
                        updateModifyData(next.getValue(), entry.getValue());
                        arrayList.add(entry.getKey());
                        this.lNewItems.remove(next.getKey());
                        break;
                    }
                }
            }
        }
        if (arrayList.size() != 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.cNewData.remove((String) it2.next());
            }
        }
    }

    public boolean compareWlanEtag() {
        List<String> list;
        Map<String, SyncWlanBean> mapM711k = C0100a.m711k(C0100a.m710j());
        if (3 == this.mSyncMode) {
            compareEtagIntellgent(mapM711k);
        }
        List<String> list2 = this.cNewUpdaItems;
        return ((list2 == null || list2.size() == 0) && ((list = this.cDelItems) == null || list.size() == 0)) ? false : true;
    }

    public void deleteLocalData(List<String> list) throws C9722c {
        this.lDel += updateWlanData(null, true, list, true);
        C2980i.m17872g(this.mReportEndInfo, this.mDataType, list.size());
    }

    public int getmSyncMode() {
        return this.mSyncMode;
    }

    public boolean isNeedQueryCloudData() {
        return this.mSyncMode != 3 || isCloudDataChanged("wlan", 1) || C13007b.m78205Y(this.mContext).m78247Z();
    }

    public boolean isNeedQueryCloudDataV2() {
        return this.mSyncMode != 3 || isCloudDataChanged("wlan", 1) || C13007b.m78205Y(this.mContext).m78247Z() || C13007b.m78205Y(this.mContext).m78298z(this.mSyncType, this.mDataType);
    }

    public void parseData() throws C9722c {
        for (Map.Entry<String, C2924c> entry : this.cloudData.entrySet()) {
            String key = entry.getKey();
            try {
                WlanBean wlanBean = (WlanBean) new Gson().fromJson(entry.getValue().m17741a(), WlanBean.class);
                String strM1593f = C0227m.m1593f(wlanBean.toString());
                if (this.cNewItems.containsKey(key)) {
                    this.cNewItems.get(key).setLuid(wlanBean.getSsid());
                    this.cNewItems.get(key).setData(wlanBean);
                    this.cNewItems.get(key).setHash(strM1593f);
                    this.cNewData.put(key, this.cNewItems.get(key));
                } else if (this.cUpdaItems.containsKey(key)) {
                    this.cUpdaItems.get(key).setLuid(wlanBean.getSsid());
                    this.cUpdaItems.get(key).setData(wlanBean);
                    this.cUpdaItems.get(key).setHash(strM1593f);
                    this.cUpdaData.put(key, this.cUpdaItems.get(key));
                }
            } catch (JsonSyntaxException unused) {
                throw new C12127a(2107, "syncWlan json syntax error, guid = " + key, this.mSyncType, "local_download_struct");
            }
        }
    }

    public void processCloudData() throws C9722c {
        deleteLocalData(this.cDelItems);
        updateLocalData();
    }

    public void processLocalData() throws Throwable {
        Map<String, SyncWlanBean> map = this.lDelItems;
        if (map != null && map.size() > 0) {
            isCancel();
            this.genCtag = true;
            Iterator<Map.Entry<String, SyncWlanBean>> it = this.lDelItems.entrySet().iterator();
            while (it.hasNext()) {
                this.lDeleteData.add(it.next().getValue());
                if (100 == this.lDeleteData.size()) {
                    updateDataToCloud();
                }
            }
        }
        Map<String, SyncWlanBean> map2 = this.lUpdItems;
        if (map2 != null && map2.size() > 0) {
            isCancel();
            this.genCtag = true;
            Iterator<Map.Entry<String, SyncWlanBean>> it2 = this.lUpdItems.entrySet().iterator();
            while (it2.hasNext()) {
                this.lModifyData.add(it2.next().getValue());
                if (100 == this.lModifyData.size() + this.lDeleteData.size()) {
                    updateDataToCloud();
                }
            }
        }
        Map<String, SyncWlanBean> map3 = this.lNewItems;
        if (map3 != null && map3.size() > 0) {
            isCancel();
            this.genCtag = true;
            Iterator<Map.Entry<String, SyncWlanBean>> it3 = this.lNewItems.entrySet().iterator();
            while (it3.hasNext()) {
                this.lAddData.add(it3.next().getValue());
                if (100 == this.lDeleteData.size() + this.lModifyData.size() + this.lAddData.size()) {
                    updateDataToCloud();
                }
            }
        }
        updateDataToCloud();
        this.updateCtag = true;
    }

    public void setmSyncMode(int i10) {
        this.mSyncMode = i10;
    }

    public void unLockV2() throws Throwable {
        try {
            C11839m.m70688i(TAG, "syncWlan unLockV2");
            C9453i c9453iM7268d = C1164a.m7265f().m7268d(this.mSyncType);
            if (c9453iM7268d == null) {
                throw new C9722c(2208, "drive builder is null", this.mSyncType, "locks_delete");
            }
            if (C13452e.m80781L().m80917g1()) {
                throw new C9722c(1102, "cloudsync error st invalid.", this.mSyncType, "locks_delete");
            }
            if (C10028c.m62182c0().m62380q1() && C10028c.m62182c0().m62320e1()) {
                throw new C9722c(2201, "cloudsync error force upgrade.", this.mSyncType, "locks_delete");
            }
            if (TextUtils.isEmpty(C13007b.m78205Y(this.mContext).m78224J(this.mSyncType, this.mSyncModulePackageName))) {
                C11839m.m70689w(TAG, "syncWlan x-hw-lock is null or empty, don't need unlock, syncType = " + this.mSyncType);
                return;
            }
            if (this.genCtag) {
                Changes.GetStartCursor startCursor = c9453iM7268d.m59249h().getStartCursor(DriveSyncUtil.m17958C(this.mSyncType));
                DriveSyncUtil.m17994g(startCursor.getHeaders(), this.traceId, this.mSyncType, this.mSyncModulePackageName);
                startCursor.setFields2("startCursor");
                String startCursor2 = startCursor.execute().getStartCursor();
                C11839m.m70686d(TAG, "syncWlan getStartCursor getStartCursor: " + startCursor2);
                this.ctagList.clear();
                CtagInfo ctagInfo = new CtagInfo();
                ctagInfo.setCtagName("wlan");
                ctagInfo.setCtagValue(startCursor2);
                this.ctagList.add(ctagInfo);
                updateCtag();
            }
            unlockV2(this.mSyncType);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "syncWlan unLock error: " + e10.getMessage());
        }
    }

    public void updateCtag() throws Exception {
        C11839m.m70686d(TAG, "syncWlan updateCtag");
        new C12770c().m76642j(this.ctagList);
    }

    public void updateModifyData(SyncWlanBean syncWlanBean, SyncWlanBean syncWlanBean2) {
        SyncWlanBean syncWlanBean3 = new SyncWlanBean();
        syncWlanBean3.setLuid(syncWlanBean.getLuid());
        syncWlanBean3.setGuid(syncWlanBean2.getGuid());
        syncWlanBean3.setEtag(syncWlanBean2.getEtag());
        syncWlanBean3.setData(syncWlanBean.getData());
        syncWlanBean3.setHash(syncWlanBean.getHash());
        this.lUpdItems.put(syncWlanBean.getLuid(), syncWlanBean3);
    }

    public int updateWlanData(List<SyncWlanBean> list, boolean z10, List<String> list2, boolean z11) throws C9722c {
        C12777j c12777j = new C12777j();
        try {
            if (!z10) {
                if (list != null && list.size() != 0) {
                    c12777j.m76686f(list, this.mDataType);
                    int size = list.size();
                    C11839m.m70688i(TAG, "syncWlan updateData size: " + list.size());
                    return size;
                }
                return 0;
            }
            if (list2 != null && list2.size() != 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (z11) {
                    arrayList = this.f13028wm.deleteData(list2, false);
                    c12777j.m76685e(arrayList, this.mDataType);
                    C11839m.m70688i(TAG, "syncWlan sucDeleteData size: " + arrayList.size());
                } else {
                    c12777j.m76685e(list2, this.mDataType);
                }
                return arrayList.size();
            }
            return 0;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "syncWlan database error message:" + e10.getMessage());
            throw new C9722c(2007, "WlanLogicProcess updateWlanData fail " + e10.getMessage(), "wlan", "local_download_struct");
        }
    }
}
