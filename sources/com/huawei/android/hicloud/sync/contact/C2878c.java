package com.huawei.android.hicloud.sync.contact;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.bean.FileInfo;
import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicService;
import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Attachment;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRet;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Record;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Resource;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import fk.C9722c;
import hk.C10278a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p015ak.C0214f0;
import p015ak.C0237v;
import p514o9.C11839m;
import p818yp.C14034a;
import sc.C12772e;
import sc.C12773f;
import za.C14165b;

/* renamed from: com.huawei.android.hicloud.sync.contact.c */
/* loaded from: classes3.dex */
public class C2878c extends SyncProcessBase {

    /* renamed from: a */
    public String f12813a;

    /* renamed from: b */
    public ArrayList<SyncData> f12814b;

    /* renamed from: c */
    public Map<String, SyncData> f12815c;

    /* renamed from: d */
    public Map<String, String> f12816d;

    /* renamed from: e */
    public Map<String, List<Attachment>> f12817e;

    /* renamed from: f */
    public Map<String, Integer> f12818f;

    /* renamed from: g */
    public Map<String, Integer> f12819g;

    /* renamed from: h */
    public int f12820h;

    /* renamed from: i */
    public boolean f12821i;

    /* renamed from: j */
    public ArrayList<SyncData> f12822j;

    /* renamed from: k */
    public ArrayList<SyncData> f12823k;

    /* renamed from: l */
    public ArrayList<SyncData> f12824l;

    /* renamed from: m */
    public ArrayList<SyncData> f12825m;

    /* renamed from: n */
    public ArrayList<String> f12826n;

    /* renamed from: o */
    public ArrayList<SyncData> f12827o;

    /* renamed from: p */
    public ArrayList<SyncData> f12828p;

    /* renamed from: q */
    public ArrayList<String> f12829q;

    /* renamed from: r */
    public Map<String, FileInfo> f12830r;

    /* renamed from: s */
    public Map<String, FileInfo> f12831s;

    /* renamed from: t */
    public ArrayList<SyncData> f12832t;

    public C2878c(Context context, String str, String str2, String str3, String str4, String str5, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        super(context, str, str2, str3, str4, str5, concurrentHashMap);
        this.f12814b = new ArrayList<>(10);
        this.f12815c = new HashMap();
        this.f12816d = new HashMap();
        this.f12817e = new HashMap();
        this.f12818f = new HashMap();
        this.f12819g = new HashMap();
        this.f12820h = 0;
        this.f12822j = new ArrayList<>(10);
        this.f12823k = new ArrayList<>(10);
        this.f12824l = new ArrayList<>(10);
        this.f12825m = new ArrayList<>(10);
        this.f12826n = new ArrayList<>(10);
        this.f12827o = new ArrayList<>(10);
        this.f12828p = new ArrayList<>(10);
        this.f12829q = new ArrayList<>(10);
        this.f12830r = new HashMap();
        this.f12831s = new HashMap();
        this.f12832t = new ArrayList<>(10);
    }

    /* renamed from: a */
    public void m17322a(List<SyncData> list, StringBuilder sb2) {
        Iterator<SyncData> it = list.iterator();
        int i10 = 0;
        int i11 = 0;
        while (it.hasNext()) {
            if (it.next().getRecycleStatus() == -1) {
                i11++;
            } else {
                i10++;
            }
        }
        sb2.append(",normalSize:");
        sb2.append(i10);
        sb2.append(",recycleSize:");
        sb2.append(i11);
    }

    /* renamed from: b */
    public void m17323b(Map<String, List<String>> map, List<FailRet> list, List<Record> list2, List<SyncData> list3) throws C9722c {
        List<String> list4;
        if (map == null) {
            C11839m.m70687e("BaseUploadDataImpl", "batchUpdateSDKFileV2: delete file result is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (map.size() > 0) {
            C11839m.m70688i("BaseUploadDataImpl", "batchUpdateSDKFileV2: successList size = " + map.size() + ", fail list = " + list.size());
            HashMap map2 = new HashMap();
            for (SyncData syncData : list3) {
                map2.put(syncData.getGuid(), syncData);
            }
            for (Record record : list2) {
                ArrayList arrayList3 = new ArrayList();
                String id2 = record.getId();
                List<Attachment> attachments = record.getAttachments();
                if (attachments != null && attachments.size() > 0 && map.containsKey(id2) && (list4 = map.get(id2)) != null && list4.size() > 0) {
                    record.setAttachmentsDeleteCount(Integer.valueOf(list4.size()));
                    for (Attachment attachment : attachments) {
                        String usage = attachment.getUsage();
                        String hash = attachment.getHash();
                        if (list4.contains(usage)) {
                            UnstructData unstructData = new UnstructData();
                            unstructData.setUnstructUuid(id2);
                            unstructData.setId(this.f12816d.get(id2));
                            unstructData.setHash(hash);
                            unstructData.setName(usage);
                            arrayList2.add(unstructData);
                            arrayList3.add(unstructData);
                            SyncData syncData2 = (SyncData) map2.get(id2);
                            if (syncData2 != null) {
                                syncData2.setDeleteFileList(arrayList3);
                            }
                            FileInfo fileInfo = new FileInfo();
                            fileInfo.setUuid(id2);
                            fileInfo.setName(usage);
                            arrayList.add(fileInfo);
                        }
                    }
                }
            }
            try {
                if (!SyncLogicService.isPersistedDataSavedInCloudSyncSDK(this.mSyncModulePackageName)) {
                    new C12773f().m76664f(arrayList2, this.mDataType);
                }
                C11839m.m70688i("BaseUploadDataImpl", "batchUpdateSDKFileV2: update toDelete file size is " + arrayList.size());
                new C12772e().m76656j(this.mSyncType, this.mDataType, arrayList);
            } catch (Exception e10) {
                C11839m.m70687e("BaseUploadDataImpl", "batchUpdateSDKFileV2: batch delete db error:" + e10.getMessage());
            }
        }
    }

    /* renamed from: c */
    public List<Attachment> m17324c(Record record, List<Attachment> list) throws Throwable {
        if (list == null || list.size() <= 0) {
            C11839m.m70688i("BaseUploadDataImpl", "syncV2 upload file fail, before upload add file, attatchment is null, return, recordId = " + record.getId());
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int maxBatchNum = getMaxBatchNum();
        m17327f(list);
        List<Attachment> arrayList2 = new ArrayList<>(list);
        while (arrayList2.size() >= maxBatchNum) {
            List<Attachment> arrayList3 = new ArrayList<>(arrayList2.subList(0, maxBatchNum));
            List<Attachment> listM17332k = m17332k(record, arrayList3);
            if (listM17332k.size() <= 0) {
                C11839m.m70688i("BaseUploadDataImpl", "syncV2 upload file fail, create asset fail, recordId = " + record.getId());
                return null;
            }
            arrayList.addAll(listM17332k);
            arrayList2.removeAll(arrayList3);
        }
        if (arrayList2.size() > 0) {
            List<Attachment> listM17332k2 = m17332k(record, arrayList2);
            if (listM17332k2.size() <= 0) {
                C11839m.m70688i("BaseUploadDataImpl", "syncV2 upload file fail, create asset fail, recordId = " + record.getId());
                return null;
            }
            arrayList.addAll(listM17332k2);
        }
        return arrayList;
    }

    /* renamed from: d */
    public List<Attachment> m17325d(Record record, List<Attachment> list) throws Throwable {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() <= 0) {
            C11839m.m70688i("BaseUploadDataImpl", "syncV2 upload file fail, before upload modify, attachment is null, return, recordId = " + record.getId());
            return null;
        }
        int maxBatchNum = getMaxBatchNum();
        m17327f(list);
        List<Attachment> arrayList2 = new ArrayList<>(list);
        while (arrayList2.size() >= maxBatchNum) {
            List<Attachment> arrayList3 = new ArrayList<>(arrayList2.subList(0, maxBatchNum));
            List<Attachment> listM17333l = m17333l(record, arrayList3);
            if (listM17333l.size() <= 0) {
                C11839m.m70688i("BaseUploadDataImpl", "syncV2 upload file fail, create asset revision fail, recordId = " + record.getId());
                return null;
            }
            arrayList.addAll(listM17333l);
            arrayList2.removeAll(arrayList3);
        }
        if (arrayList2.size() > 0) {
            List<Attachment> listM17333l2 = m17333l(record, arrayList2);
            if (listM17333l2.size() <= 0) {
                C11839m.m70688i("BaseUploadDataImpl", "syncV2 upload file fail, create asset revision fail, recordId = " + record.getId());
                return null;
            }
            arrayList.addAll(listM17333l2);
        }
        return arrayList;
    }

    /* renamed from: e */
    public void m17326e(List<FailRet> list) throws C9722c {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (FailRet failRet : list) {
            if (failRet != null) {
                int errCode = failRet.getErrCode();
                if (DriveSyncUtil.m17976U("4039", errCode)) {
                    errCode = SNSCode.Status.HWID_UNLOGIN;
                }
                C11839m.m70689w("BaseUploadDataImpl", "syncV2 upload file fail, checkSpaceNotEnoughError, error code is: " + errCode);
                throw new C9722c(errCode, "syncV2 upload file fail, checkSpaceNotEnoughError " + failRet.getErrMsg(), this.mSyncType, "local_upload");
            }
        }
    }

    /* renamed from: f */
    public void m17327f(List<Attachment> list) throws C9722c {
        if (CloudSyncUtil.m16015i(this.f12813a, list)) {
            return;
        }
        C11839m.m70688i("BaseUploadDataImpl", "syncV2 upload file fail, checkSpaceError, space not enough, return null");
        throw new C9722c(SNSCode.Status.HWID_UNLOGIN, "syncV2 upload file fail, checkSpaceError, space not enough fail", this.mSyncType, "local_upload");
    }

    /* renamed from: g */
    public void m17328g(String str, Map<String, List<String>> map, Map<String, List<Attachment>> map2) {
        if (this.f12817e == null || map == null || map.size() <= 0) {
            C11839m.m70689w("BaseUploadDataImpl", "syncv2 uploadData compareFileDelete: cloud file or local files is empty");
            return;
        }
        if (this.f12817e.get(str) == null) {
            C11839m.m70689w("BaseUploadDataImpl", "syncv2 uploadData compareFileDelete: cloud file is empty, recordId = " + str);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Attachment attachment : this.f12817e.get(str)) {
            String usage = attachment.getUsage();
            List<String> list = map.get(str);
            if (list != null && list.size() > 0 && !list.contains(usage)) {
                arrayList.add(attachment);
            }
        }
        if (!arrayList.isEmpty()) {
            map2.put(str, arrayList);
        }
        C11839m.m70688i("BaseUploadDataImpl", "syncv2 uploadData compareFileDelete: toDeleteAttachment = " + arrayList.size() + ", deleteFileList = " + map2.size());
    }

    /* renamed from: h */
    public List<Attachment> m17329h(Record record, List<UnstructData> list) throws Throwable {
        if (record == null || list == null || list.size() <= 0) {
            C11839m.m70688i("BaseUploadDataImpl", "syncv2 attachments size is 0, return");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        String id2 = record.getId();
        String name = "";
        try {
            for (UnstructData unstructData : list) {
                Attachment attachment = new Attachment();
                attachment.setUsage(unstructData.getName());
                name = unstructData.getName();
                Asset asset = new Asset();
                File fileM63442h = C10278a.m63442h(this.f12813a + "/" + unstructData.getName());
                CloudSyncUtil.m16021k(this.mContext, 1, this.mSyncType, this.mSyncModulePackageName, fileM63442h, name, "add_check_file_before_upload");
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
                attachment.setHash(strM85042o);
                attachment.setSha256(aVarM85035h.m85045a());
                attachment.setLength(fileM63442h.length());
                attachment.setAsset(asset);
                arrayList.add(attachment);
            }
            return arrayList;
        } catch (C9721b e10) {
            C11839m.m70688i("BaseUploadDataImpl", "syncV2 uploadData getRecordsAttachment error, code = " + e10.m60659c() + ", msg = " + e10.getMessage());
            throw new C9722c(e10.m60659c(), "local file " + e10.getMessage() + ", recordId = " + id2 + ", usageName = " + name, this.mSyncType, "check_file_before_upload");
        }
    }

    /* renamed from: i */
    public Map<String, List<Attachment>> m17330i(List<Record> list) throws C9722c {
        StringBuilder sb2;
        ArrayList arrayList;
        try {
            try {
                arrayList = new ArrayList();
                Iterator<Record> it = list.iterator();
                while (it.hasNext()) {
                    String id2 = it.next().getId();
                    if (TextUtils.isEmpty(id2)) {
                        C11839m.m70688i("BaseUploadDataImpl", "getCloudUnstructsV2 guid is null, continue");
                    } else {
                        arrayList.add(id2);
                    }
                }
                this.f12817e.clear();
            } catch (Exception e10) {
                C11839m.m70687e("BaseUploadDataImpl", "syncV2 getCloudUnstructsV2 get cloud file error, msg = " + e10.getMessage());
                sb2 = new StringBuilder();
            }
            if (arrayList.isEmpty()) {
                C11839m.m70687e("BaseUploadDataImpl", "syncV2 getCloudUnstructsV2 get cloud file error, recordId list is empty, return");
                Map<String, List<Attachment>> map = this.f12817e;
                C11839m.m70688i("BaseUploadDataImpl", "syncV2 getCloudUnstructsV2 cloud file size = " + this.f12817e.size());
                return map;
            }
            for (Record record : getRecordsDataByIdList(this.mSyncType, this.mDataType, arrayList, "records(attachments(usage,hash,assetId),id)", "getCloudFileList")) {
                if (record != null) {
                    String id3 = record.getId();
                    List<Attachment> attachments = record.getAttachments();
                    if (attachments != null && attachments.size() > 0) {
                        this.f12817e.put(id3, attachments);
                    }
                }
            }
            sb2 = new StringBuilder();
            sb2.append("syncV2 getCloudUnstructsV2 cloud file size = ");
            sb2.append(this.f12817e.size());
            C11839m.m70688i("BaseUploadDataImpl", sb2.toString());
            return this.f12817e;
        } catch (Throwable th2) {
            C11839m.m70688i("BaseUploadDataImpl", "syncV2 getCloudUnstructsV2 cloud file size = " + this.f12817e.size());
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0176  */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.huawei.android.hicloud.syncdrive.cloudsync.model.Attachment> m17331j(com.huawei.android.hicloud.syncdrive.cloudsync.model.Record r22, java.util.List<com.huawei.android.hicloud.sync.service.aidl.UnstructData> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.contact.C2878c.m17331j(com.huawei.android.hicloud.syncdrive.cloudsync.model.Record, java.util.List):java.util.List");
    }

    /* renamed from: k */
    public List<Attachment> m17332k(Record record, List<Attachment> list) throws Throwable {
        ArrayList arrayList = new ArrayList();
        isCancel();
        List<Attachment> listCreateAssets = createAssets(this.mSyncType, this.mDataType, record, list, arrayList);
        if (arrayList.size() > 0) {
            m17326e(arrayList);
        }
        C11839m.m70688i("BaseUploadDataImpl", "syncV2 upload file, create asset, success size = " + listCreateAssets.size());
        return listCreateAssets;
    }

    /* renamed from: l */
    public List<Attachment> m17333l(Record record, List<Attachment> list) throws Throwable {
        ArrayList arrayList = new ArrayList();
        isCancel();
        List<Attachment> listCreateAssetRevision = createAssetRevision(this.mSyncType, this.mDataType, record, list, arrayList);
        if (arrayList.size() > 0) {
            m17326e(arrayList);
        }
        C11839m.m70688i("BaseUploadDataImpl", "syncV2 upload file, create asset revision, success size = " + listCreateAssetRevision.size());
        return listCreateAssetRevision;
    }

    /* renamed from: m */
    public void m17334m(List<SyncData> list, List<Record> list2, List<FailRet> list3, String str) throws C9722c {
        HashMap map = new HashMap();
        Iterator<SyncData> it = this.f12822j.iterator();
        while (it.hasNext()) {
            SyncData next = it.next();
            map.put(next.getGuid(), next);
        }
        if (list2 != null && list2.size() > 0) {
            for (Record record : list2) {
                SyncData syncData = (SyncData) map.get(record.getId());
                if (syncData != null) {
                    syncData.setGuid(record.getId());
                    syncData.setEtag(record.getVersion().toString());
                    syncData.setUnstructUuid(record.getId());
                }
            }
        }
        baseSyncParseFailList(this.f12821i, this.f12818f, this.f12819g, list, list3, str);
    }

    /* renamed from: n */
    public void m17335n(List<SyncData> list, List<Record> list2) {
        if (list.size() > 0) {
            for (Record record : list2) {
                for (SyncData syncData : list) {
                    if (syncData.getGuid().equals(record.getId())) {
                        if (syncData.getFileList() != null && syncData.getFileList().size() > 0) {
                            Iterator<UnstructData> it = syncData.getFileList().iterator();
                            while (it.hasNext()) {
                                it.next().setUnstructUuid(record.getId());
                            }
                        }
                        syncData.setGuid(record.getId());
                        syncData.setUnstructUuid(record.getId());
                        syncData.setEtag(String.valueOf(record.getVersion()));
                        this.f12832t.add(syncData);
                    }
                }
            }
        }
    }

    /* renamed from: o */
    public void m17336o(Record record) throws Throwable {
        SyncData syncData = this.f12815c.get(record.getId());
        if (syncData == null) {
            return;
        }
        try {
            if (CloudSyncUtil.m16040q0(this.mSyncType, this.mDataType, syncData.getFileList(), "local_add_upload")) {
                List<Attachment> listM17329h = m17329h(record, syncData.getFileList());
                if (listM17329h.size() <= 0) {
                    throw new C9722c(2248, "attachment size after encrypt is empty", this.mSyncType, "local_add_upload");
                }
                record.setAttachments(listM17329h);
                m17327f(listM17329h);
            }
        } catch (C9722c e10) {
            C11839m.m70687e("BaseUploadDataImpl", "syncV2 upload file fail, prepare attachments, encryptDataV2 error, recordId = " + record.getId() + ", luid = " + syncData.getLuid() + ", error = " + e10.getMessage());
            throw new C9722c(e10.m60666c(), "syncV2 upload file fail, prepare attachments, encryptDataV2 code = " + e10.m60666c() + ", msg =" + e10.getMessage() + "recordId = " + record.getId() + ", luid = " + syncData.getLuid(), this.mSyncType, "check_file_before_upload");
        }
    }

    /* renamed from: p */
    public boolean m17337p(List<Attachment> list, Record record, StringBuilder sb2) throws Throwable {
        sb2.append("addFileSize = ");
        sb2.append(list.size());
        SyncData syncData = this.f12815c.get(record.getId());
        if (syncData == null) {
            return false;
        }
        if (!CloudSyncUtil.m16040q0(this.mSyncType, this.mDataType, syncData.getFileList(), "local_add_upload")) {
            return true;
        }
        C11839m.m70688i("BaseUploadDataImpl", "syncV2 upload add file, attachment size > 100, recordId = " + record.getId() + ", fileList size = " + list.size());
        List<Attachment> listM17324c = m17324c(record, list);
        if (listM17324c != null && listM17324c.size() > 0) {
            sb2.append(", addFileResult = 0");
            record.setAttachments(listM17324c);
            return true;
        }
        sb2.append(", addFileResult = ");
        sb2.append(2221);
        C11839m.m70689w("BaseUploadDataImpl", "syncV2 upload add file fail, create asset fail, recordId = " + record.getId());
        return false;
    }

    /* renamed from: q */
    public boolean m17338q(String str, List<Attachment> list) {
        if (C0214f0.m1382b(this.mContext, "sync_contact_spfile", 0).getBoolean(this.mSyncType + "cloudSpaceNotEnough", false)) {
            baseRecordUploadFileFail(this.f12818f, this.f12819g, str, SNSCode.Status.HWID_UNLOGIN);
            return false;
        }
        if (CloudSyncUtil.m16015i(this.f12813a, list)) {
            return true;
        }
        CloudSyncUtil.m15978T0(this.mContext, this.mSyncType);
        CloudSyncUtil.m15969P(this.mContext, this.mSyncType, this.mDataType, this.traceId, this.f12820h);
        baseRecordUploadFileFail(this.f12818f, this.f12819g, str, SNSCode.Status.HWID_UNLOGIN);
        C0237v.m1661c();
        return false;
    }

    /* renamed from: r */
    public void m17339r(List<Record> list) throws Throwable {
        C11839m.m70688i("BaseUploadDataImpl", "syncV2 uploadData no file, delete file start, dataType = " + this.mDataType);
        if (list == null || list.size() <= 0) {
            C11839m.m70689w("BaseUploadDataImpl", "syncV2 uploadData delete file: no data to delete");
            return;
        }
        Map<String, List<Attachment>> mapM17330i = m17330i(list);
        if (!mapM17330i.isEmpty()) {
            C11839m.m70686d("BaseUploadDataImpl", "syncV2 uploadDataNoFile delete file, cloud file = " + mapM17330i.toString());
            m17341t(mapM17330i);
        }
        List<Record> listM15987Y = CloudSyncUtil.m15987Y(mapM17330i, list);
        C11839m.m70688i("BaseUploadDataImpl", "syncV2 uploadDataNoFile delete record size = " + listM15987Y.size());
        if (!mapM17330i.isEmpty()) {
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            deleteAssets(mapM17330i, map, arrayList);
            reportDeleteFileEvent(map, arrayList);
            m17323b(map, arrayList, listM15987Y, this.f12822j);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            CloudSyncUtil.m16029m1(listM15987Y, map);
            m17343v(listM15987Y, arrayList2, arrayList3);
            m17334m(this.f12822j, arrayList2, arrayList3, "local_after_remove_files_update");
        }
        C11839m.m70688i("BaseUploadDataImpl", "syncV2 uploadData delete file end");
    }

    /* renamed from: s */
    public void m17340s(List<SyncData> list, List<Record> list2) throws Throwable {
        if (list2 == null || list2.size() <= 0) {
            C11839m.m70689w("BaseUploadDataImpl", "syncV2 uploadData delete file: no data to delete");
            return;
        }
        C11839m.m70688i("BaseUploadDataImpl", "syncV2 uploadData modify with file, delete file start, dataType = " + this.mDataType);
        HashMap map = new HashMap();
        Map<String, List<String>> mapM15957J = CloudSyncUtil.m15957J(list);
        Iterator<Record> it = list2.iterator();
        while (it.hasNext()) {
            m17328g(it.next().getId(), mapM15957J, map);
        }
        if (!map.isEmpty()) {
            m17341t(map);
        }
        List<Record> listM15987Y = CloudSyncUtil.m15987Y(map, list2);
        if (!map.isEmpty()) {
            HashMap map2 = new HashMap();
            ArrayList arrayList = new ArrayList();
            C11839m.m70688i("BaseUploadDataImpl", "syncV2 uploadDataWithFile start delete cloud file");
            deleteAssets(map, map2, arrayList);
            reportDeleteFileEvent(map2, arrayList);
            m17323b(map2, arrayList, listM15987Y, list);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            CloudSyncUtil.m16029m1(listM15987Y, map2);
            m17343v(listM15987Y, arrayList2, arrayList3);
            m17335n(list, arrayList2);
            baseSyncParseFailList(this.f12821i, this.f12818f, this.f12819g, list, arrayList3, "local_after_remove_files_update");
        }
        C11839m.m70688i("BaseUploadDataImpl", "syncV2 uploadData modify with file, delete file end");
    }

    /* renamed from: t */
    public void m17341t(Map<String, List<Attachment>> map) throws C9722c {
        if (map == null || map.size() <= 0) {
            C11839m.m70688i("BaseUploadDataImpl", "saveToDeleteFile: no file to delete and save.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<Attachment>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<Attachment> value = entry.getValue();
            String str = this.f12816d.get(key);
            Iterator<Attachment> it = value.iterator();
            while (it.hasNext()) {
                String usage = it.next().getUsage();
                FileInfo fileInfo = new FileInfo();
                fileInfo.setName(usage);
                fileInfo.setUuid(key);
                fileInfo.setLuid(str);
                arrayList.add(fileInfo);
            }
        }
        try {
            new C12772e().m76652f(this.mSyncType, this.mDataType, arrayList);
        } catch (Exception e10) {
            C11839m.m70687e("BaseUploadDataImpl", "saveToDeleteFile: error message " + e10.getMessage());
        }
    }

    /* renamed from: u */
    public void m17342u() {
        C11839m.m70688i("BaseUploadDataImpl", "setUnStructUidForAddFile");
        Iterator<SyncData> it = this.f12814b.iterator();
        while (it.hasNext()) {
            SyncData next = it.next();
            List<UnstructData> fileList = next.getFileList();
            if (fileList != null && !fileList.isEmpty()) {
                Iterator<UnstructData> it2 = fileList.iterator();
                while (it2.hasNext()) {
                    it2.next().setUnstructUuid(next.getUnstructUuid());
                }
            }
        }
    }

    /* renamed from: v */
    public void m17343v(List<Record> list, List<Record> list2, List<FailRet> list3) throws Throwable {
        String str;
        C11839m.m70688i("BaseUploadDataImpl", "syncV2 uploadData updateAfterRemove, toDelete size = " + list.size());
        List<FailRet> list4 = null;
        list4 = null;
        list4 = null;
        int i10 = 0;
        try {
            try {
                putUpdateRecords(Constants.NORMAL_CACHE, list, list2, list3, "createdTime,editedTime,id,kind,recycled,recycledTime,status,version", "local_after_remove_files_update");
                List<FailRet> list5 = list3;
                reportUploadEvet(0, "", list2.size(), list5, "local_after_remove_files_update");
                list4 = list5;
            } catch (C9722c e10) {
                C11839m.m70687e("BaseUploadDataImpl", "syncV2 uploadData delete file update error, error msg = " + e10.getMessage());
                String message = e10.getMessage();
                try {
                    reportUploadEvet(e10.m60666c(), message, list2.size(), list3, "local_after_remove_files_update");
                } catch (Throwable th2) {
                    th = th2;
                    str = message;
                    reportUploadEvet(i10, str, list2.size(), list3, "local_after_remove_files_update");
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            str = "";
            i10 = list4;
            reportUploadEvet(i10, str, list2.size(), list3, "local_after_remove_files_update");
            throw th;
        }
    }
}
