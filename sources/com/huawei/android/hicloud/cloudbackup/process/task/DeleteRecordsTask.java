package com.huawei.android.hicloud.cloudbackup.process.task;

import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.BackupPowerKitKeepTimer;
import com.huawei.android.hicloud.cloudbackup.process.CBLockTimer;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeUtil;
import com.huawei.android.hicloud.cloudbackup.snapshottree.bean.SnapshotNode;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.request.cbs.bean.CBSAppInfo;
import com.huawei.hicloud.request.cbs.bean.CBSBackupRecord;
import com.huawei.hicloud.request.cbs.bean.CBSFileInfo;
import com.huawei.hicloud.request.opengw.bean.Result;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.secure.android.common.util.SafeString;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mk.C11476b;
import p015ak.C0213f;
import p015ak.C0241z;
import p429kk.C11058a;
import p429kk.C11060c;
import p458lo.C11322a;
import p514o9.C11835i;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p606r9.C12478a;
import p616rk.C12515a;
import p617rl.C12526j;
import p618rm.C12590s0;
import p652t9.EnumC12999a;
import p684un.C13225d;
import p709vj.C13452e;
import p711vl.C13466f;
import p746wn.C13622a;
import to.C13049a;

/* loaded from: classes2.dex */
public class DeleteRecordsTask extends AbstractC12367d {
    private static final String TAG = "DeleteRecordsTask";
    private String backupId;
    private String backupTraceID;
    private int backupType;
    private CBLockTimer deleteLockTimer;
    private String deviceId;
    private int deviceType;
    private C9721b exception;
    private C13049a gwService;
    private boolean isAfterBackup;
    private ProgressCallback progressCallback;
    private ReportDeleteInfo reportDeleteInfo;
    private String serverPath;
    private C11322a service;
    private SnapshotTreeManagementService snapshotTreeService;
    private String deleteRecordAction = "";
    private String traceID = C11058a.m66627b("02007");

    public static class ReportDeleteInfo {
        private long deleteEndTime;
        private long deleteStartTime;
        private boolean isAfterBackup;
        private long taskEndTime;
        private long time;
        private Map<String, Long> recordsMap = new HashMap();
        private long taskStartTime = System.currentTimeMillis();

        public long getDeleteEndTime() {
            return this.deleteEndTime;
        }

        public long getDeleteStartTime() {
            return this.deleteStartTime;
        }

        public Map<String, Long> getRecordsMap() {
            return this.recordsMap;
        }

        public long getTaskEndTime() {
            return this.taskEndTime;
        }

        public long getTaskStartTime() {
            return this.taskStartTime;
        }

        public long getTime() {
            return this.time;
        }

        public boolean isAfterBackup() {
            return this.isAfterBackup;
        }

        public void setAfterBackup(boolean z10) {
            this.isAfterBackup = z10;
        }

        public void setDeleteEndTime(long j10) {
            this.deleteEndTime = j10;
        }

        public void setDeleteStartTime(long j10) {
            this.deleteStartTime = j10;
        }

        public void setRecordsMap(String str, long j10) {
            this.recordsMap.put(str, Long.valueOf(j10));
        }

        public void setTaskEndTime(long j10) {
            this.taskEndTime = j10;
        }

        public void setTaskStartTime(long j10) {
            this.taskStartTime = j10;
        }

        public void setTime(long j10) {
            this.time = j10;
        }
    }

    public DeleteRecordsTask(String str, String str2, int i10, int i11, String str3, ProgressCallback progressCallback, boolean z10) {
        this.deviceId = str;
        this.backupId = str2;
        this.deviceType = i10;
        this.backupType = i11;
        this.backupTraceID = str3;
        if (progressCallback == null) {
            this.progressCallback = new ProgressCallback();
        } else {
            this.progressCallback = progressCallback;
        }
        this.isAfterBackup = z10;
        this.service = new C11322a(this.traceID);
        this.gwService = new C13049a(EnumC12999a.CLOUD_BACKUP, this.traceID);
        SnapshotTreeManagementService snapshotTreeManagementService = SnapshotTreeManagementService.getInstance();
        this.snapshotTreeService = snapshotTreeManagementService;
        snapshotTreeManagementService.clear();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(isEncrypt() ? "" : "/Backup");
        sb2.append("/CloudBackup/");
        sb2.append(C11476b.m68626h(str));
        sb2.append("/");
        this.serverPath = sb2.toString();
    }

    private void convertCBSBackupRecordToSnapshotMeta(List<CBSBackupRecord> list) throws C9721b, SQLException {
        if (list.size() <= 0) {
            return;
        }
        C11839m.m70688i(TAG, "convertCBSBackupRecordToSnapshotMeta begin");
        for (CBSBackupRecord cBSBackupRecord : list) {
            String backupId = cBSBackupRecord.getBackupId();
            if (this.snapshotTreeService.checkSuccessfulBackupRecordStatus(backupId)) {
                C11839m.m70688i(TAG, "old backupRecord Id = " + backupId + ", snapshot database already exist.");
            } else {
                C11839m.m70688i(TAG, "convert old backup record Id = " + backupId);
                CBSBackupRecord cBSBackupRecordQueryBackupRecordDetail = queryBackupRecordDetail(this.deviceId, this.deviceType, cBSBackupRecord);
                if (cBSBackupRecordQueryBackupRecordDetail != null) {
                    reportQuerySingleRecord(backupId);
                    this.snapshotTreeService.createSnapshotBackupMetaTable(backupId);
                    this.snapshotTreeService.saveTree(SnapshotBackupMeta.DB_ROOT_NODE_APPID, this.snapshotTreeService.createDBRootNode(backupId), backupId);
                    List<CBSAppInfo> appIdInfos = cBSBackupRecordQueryBackupRecordDetail.getAppIdInfos();
                    if (appIdInfos != null) {
                        HashMap map = new HashMap();
                        ArrayList arrayList = new ArrayList();
                        for (CBSAppInfo cBSAppInfo : appIdInfos) {
                            String appId = cBSAppInfo.getAppId();
                            SnapshotBackupMeta snapshotBackupMeta = new SnapshotBackupMeta();
                            snapshotBackupMeta.setData(appId);
                            snapshotBackupMeta.setRoot("");
                            snapshotBackupMeta.setName(appId);
                            snapshotBackupMeta.setSize(cBSAppInfo.getSize());
                            map.put(appId, snapshotBackupMeta);
                            Iterator<CBSFileInfo> it = cBSAppInfo.getFileInfos().iterator();
                            while (it.hasNext()) {
                                arrayList.add(this.serverPath + appId + File.separator + it.next().getFileName());
                            }
                        }
                        Map<String, SnapshotBackupMeta> leafNodeBackupMetas = getLeafNodeBackupMetas(arrayList);
                        for (CBSAppInfo cBSAppInfo2 : appIdInfos) {
                            String appId2 = cBSAppInfo2.getAppId();
                            SnapshotNode snapshotNodeCreateTreeRootNode = this.snapshotTreeService.createTreeRootNode(appId2, (SnapshotBackupMeta) map.get(appId2), 0L, this.snapshotTreeService.getRootNode(SnapshotBackupMeta.DB_ROOT_NODE_APPID, backupId).getRight());
                            ArrayList arrayList2 = new ArrayList();
                            Iterator<CBSFileInfo> it2 = cBSAppInfo2.getFileInfos().iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(leafNodeBackupMetas.get(appId2 + File.separator + it2.next().getFileName()));
                            }
                            arrayList2.addAll(SnapshotTreeUtil.getAppinfoMetas(cBSAppInfo2));
                            long jBuildSnapshotTree = this.snapshotTreeService.buildSnapshotTree(appId2, snapshotNodeCreateTreeRootNode, arrayList2);
                            this.snapshotTreeService.saveTree(appId2, snapshotNodeCreateTreeRootNode, backupId);
                            this.snapshotTreeService.endTree(appId2, backupId);
                            C11839m.m70686d(TAG, "convertCBSBackupRecordToSnapshotMeta appid = " + appId2 + ", file size = " + jBuildSnapshotTree);
                        }
                        this.snapshotTreeService.updateBackupRecordMetaSuccessful(backupId);
                    } else {
                        if (cBSBackupRecord.getStatus() != 1) {
                            throw new C9721b(3107, "convert CBSBackupRecords appInfos is null.", "convertOldCBSBackupRecords");
                        }
                        C11839m.m70689w(TAG, "convert CBSBackupRecords appInfos is null");
                    }
                } else {
                    if (cBSBackupRecord.getStatus() != 1) {
                        throw new C9721b(3107, "convert CBSBackupRecords query backupRecordDetailReq return null.", "convertOldCBSBackupRecords");
                    }
                    C11839m.m70689w(TAG, "convert CBSBackupRecords query backupRecordDetailReq return null");
                }
            }
        }
        C11839m.m70688i(TAG, "convertCBSBackupRecordToSnapshotMeta end");
    }

    private void deleteBackupRecord(String str, List<String> list) throws C9721b, SQLException {
        if (str == null) {
            return;
        }
        C11839m.m70688i(TAG, "deleteBackupRecord backup record, id = " + str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (list.size() > 0) {
            for (String str2 : list) {
                if (!str.equalsIgnoreCase(str2)) {
                    C11839m.m70688i(TAG, "query backup record, id = " + str2);
                    this.snapshotTreeService.updateSameLeafNodes(str, str2);
                }
            }
            this.snapshotTreeService.updateDeletedLeafNodes(str);
        } else {
            this.snapshotTreeService.updateDeletedLeafNodesByStatus(str, 4);
            this.snapshotTreeService.updateDeletedLeafNodesByStatus(str, -4);
            this.snapshotTreeService.updateDeletedLeafNodesByStatus(str, 5);
            this.snapshotTreeService.updateDeletedLeafNodesByStatus(str, 6);
            this.snapshotTreeService.updateDeletedLeafNodesByStatus(str, -6);
        }
        C11839m.m70688i(TAG, "after pick up, update metas data3 spend seconds = " + getSecondsTime(jCurrentTimeMillis));
        deleteFilesFromVFSServer(str);
        String str3 = this.serverPath + this.snapshotTreeService.getDBName(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str3);
        deleteVFSFiles(arrayList);
        this.reportDeleteInfo.setRecordsMap(str, this.snapshotTreeService.querySizeExcludeStandApk(str));
        this.snapshotTreeService.deleteSnapshotDB(str);
    }

    private void deleteFilesFromVFSServer(String str) throws C9721b {
        if (str == null) {
            return;
        }
        Map<String, List<String>> mapQueryDeletedLeafNodes = this.snapshotTreeService.queryDeletedLeafNodes(str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (mapQueryDeletedLeafNodes == null) {
            C11839m.m70688i(TAG, "deletedPaths is null");
            return;
        }
        C11839m.m70688i(TAG, "delete files start, delete file size = " + mapQueryDeletedLeafNodes.size());
        HashSet<String> hashSet = new HashSet();
        for (Map.Entry<String, List<String>> entry : mapQueryDeletedLeafNodes.entrySet()) {
            String key = entry.getKey();
            for (String str2 : entry.getValue()) {
                String str3 = this.serverPath + key + "/" + str2;
                if (!hashSet.contains(str3)) {
                    C11839m.m70688i(TAG, "delete appId: " + key + ", path = " + str2);
                    hashSet.add(str3);
                }
            }
        }
        if (hashSet.size() <= 0) {
            C11839m.m70688i(TAG, "no need to delete files.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        int iM75423v = new C12526j().m75423v();
        int size = 0;
        int i10 = 0;
        for (String str4 : hashSet) {
            if (!TextUtils.isEmpty(str4)) {
                arrayList.add(str4);
            }
            i10++;
            if (arrayList.size() >= iM75423v) {
                deleteVFSFiles(arrayList);
                size += arrayList.size();
                arrayList.clear();
            }
            if (i10 >= hashSet.size() && !arrayList.isEmpty()) {
                deleteVFSFiles(arrayList);
                size += arrayList.size();
            }
        }
        C11839m.m70688i(TAG, "delete files end,, spend seconds = " + getSecondsTime(jCurrentTimeMillis) + ", delete size = " + size);
    }

    private void deleteInvalidBackupRecords(Map<String, CBSBackupRecord> map, List<String> list, List<String> list2) throws SQLException {
        for (String str : list2) {
            try {
                deleteBackupRecord(str, list);
                this.service.m68032p(this.deviceId, this.deviceType, str);
                map.remove(str);
                reportDeleteSingleRecord(str, false);
            } catch (C9721b e10) {
                if (this.exception == null) {
                    this.exception = e10;
                }
                C11839m.m70687e(TAG, "delete invalid record error: " + e10.getMessage());
            }
        }
    }

    private boolean deleteVFSFiles(List<String> list) throws C9721b {
        Result resultM78736f0 = this.gwService.m78736f0((String[]) list.toArray(new String[list.size()]), false);
        boolean z10 = true;
        if (!resultM78736f0.getFailList().isEmpty()) {
            Iterator<Result.ErrMsg> it = resultM78736f0.getFailList().iterator();
            while (it.hasNext()) {
                int errCode = it.next().getErrCode();
                if (errCode != 102 && errCode != 401) {
                    z10 = false;
                }
            }
        }
        if (z10) {
            return z10;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "delete error");
    }

    private Map<String, CBSBackupRecord> getAllRecordsFromServer() throws C9721b {
        HashMap map = new HashMap();
        for (CBSBackupRecord cBSBackupRecord : this.service.m67998E(false, false, false)) {
            String deviceId = cBSBackupRecord.getDevice().getDeviceId();
            if (deviceId != null && !deviceId.isEmpty() && this.deviceId.equals(deviceId)) {
                map.put(cBSBackupRecord.getBackupId(), cBSBackupRecord);
            }
        }
        return map;
    }

    private Map<String, SnapshotBackupMeta> getLeafNodeBackupMetas(List<String> list) throws C9721b {
        int i10;
        int i11;
        SnapshotBackupMeta snapshotBackupMeta;
        String strSubstring;
        String str;
        DeleteRecordsTask deleteRecordsTask = this;
        HashMap map = new HashMap();
        if (list.isEmpty()) {
            return map;
        }
        int size = list.size();
        int i12 = 0;
        int i13 = 0;
        while (i12 < size) {
            int i14 = i13 * 200;
            int i15 = i14 + 200;
            if (i15 > size) {
                i15 = size;
            }
            List<String> listSubList = list.subList(i14, i15);
            Result resultM78709H = deleteRecordsTask.gwService.m78709H((String[]) listSubList.toArray(new String[listSubList.size()]), new String[]{"name", "md5", "size", JsbMapKeyNames.H5_LOC, "encoded"});
            List<Map<String, Object>> successList = resultM78709H.getSuccessList();
            List<Result.ErrMsg> failList = resultM78709H.getFailList();
            if (!failList.isEmpty()) {
                deleteRecordsTask.reportVFSGetattrFail(failList);
            }
            for (Map<String, Object> map2 : successList) {
                try {
                    snapshotBackupMeta = new SnapshotBackupMeta();
                    strSubstring = SafeString.substring((String) map2.get("name"), deleteRecordsTask.serverPath.length());
                    String str2 = (String) map2.get(JsbMapKeyNames.H5_LOC);
                    str = (String) map2.get("size");
                    String rootPath = ICBUtil.getRootPath(str2);
                    i10 = size;
                    try {
                        String strSubstring2 = SafeString.substring(str2, rootPath.length());
                        snapshotBackupMeta.setRoot(rootPath);
                        snapshotBackupMeta.setData(strSubstring2);
                        String str3 = File.separator;
                        int iLastIndexOf = strSubstring2.lastIndexOf(str3);
                        snapshotBackupMeta.setName(SafeString.substring(strSubstring2, iLastIndexOf <= 0 ? 0 : iLastIndexOf + 1));
                        int iIndexOf = strSubstring.indexOf(str3);
                        snapshotBackupMeta.setCloudPath(SafeString.substring(strSubstring, iIndexOf <= 0 ? 0 : iIndexOf + 1));
                        snapshotBackupMeta.setStatus(5);
                        i11 = i15;
                    } catch (Exception unused) {
                        i11 = i15;
                        C11839m.m70689w(TAG, "getLeafNodeBackupMetas create backup meta error." + map2);
                        i15 = i11;
                        size = i10;
                        deleteRecordsTask = this;
                    }
                } catch (Exception unused2) {
                    i10 = size;
                }
                try {
                    snapshotBackupMeta.setType(6L);
                    snapshotBackupMeta.setSize(C0241z.m1688f(str));
                    if (isEncrypt()) {
                        int iLastIndexOf2 = strSubstring.lastIndexOf(95);
                        String strReplace = iLastIndexOf2 > 0 ? SafeString.substring(strSubstring, iLastIndexOf2).replace("_", "") : "";
                        snapshotBackupMeta.setHash2(strReplace);
                        snapshotBackupMeta.setCloudHash(strReplace);
                    } else {
                        snapshotBackupMeta.setHash1((String) map2.get("md5"));
                        snapshotBackupMeta.setCloudHash((String) map2.get("md5"));
                    }
                    String str4 = (String) map2.get("encoded");
                    snapshotBackupMeta.setCloudEncoded(TextUtils.isEmpty(str4) ? 0L : C0241z.m1688f(str4));
                    map.put(strSubstring, snapshotBackupMeta);
                } catch (Exception unused3) {
                    C11839m.m70689w(TAG, "getLeafNodeBackupMetas create backup meta error." + map2);
                    i15 = i11;
                    size = i10;
                    deleteRecordsTask = this;
                }
                i15 = i11;
                size = i10;
                deleteRecordsTask = this;
            }
            i13++;
            i12 = i15;
            deleteRecordsTask = this;
        }
        return map;
    }

    private CBSBackupRecord getOldestBackupRecord(List<CBSBackupRecord> list) {
        String deviceId;
        CBSBackupRecord cBSBackupRecord = null;
        for (CBSBackupRecord cBSBackupRecord2 : list) {
            if (cBSBackupRecord2.getStatus() == 0 && (deviceId = cBSBackupRecord2.getDevice().getDeviceId()) != null && !deviceId.isEmpty() && this.deviceId.equals(deviceId) && (cBSBackupRecord == null || cBSBackupRecord.getEndTime() > cBSBackupRecord2.getEndTime())) {
                cBSBackupRecord = cBSBackupRecord2;
            }
        }
        return cBSBackupRecord;
    }

    public static boolean isEncrypt() {
        return !C10028c.m62182c0().m62420y1();
    }

    private void keepDeleteLock() throws C9721b {
        boolean deleteLockTimerResult;
        deleteLock();
        try {
            deleteLockTimerResult = getDeleteLockTimerResult();
            e = null;
        } catch (C9721b e10) {
            e = e10;
            C11839m.m70689w(TAG, "delete oldest backup record, lock requeset exception");
            deleteLockTimerResult = false;
        }
        if (deleteLockTimerResult) {
            return;
        }
        C11839m.m70689w(TAG, "delete oldest backup record, lock requeset error.");
        deleteUnLock();
        throw e;
    }

    private void parseRecordSize(LinkedHashMap<String, String> linkedHashMap) {
        for (Map.Entry<String, Long> entry : this.reportDeleteInfo.getRecordsMap().entrySet()) {
            linkedHashMap.put(entry.getKey(), String.valueOf(entry.getValue().longValue()));
        }
    }

    private Map<String, List<String>> prepareDeleteRecord(Map<String, CBSBackupRecord> map) throws Throwable {
        ArrayList arrayList = new ArrayList(map.values());
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (CBSBackupRecord cBSBackupRecord : arrayList) {
            if (cBSBackupRecord.getStatus() == 0) {
                C11839m.m70688i(TAG, "successful backupRecord: " + cBSBackupRecord.getBackupId());
                arrayList2.add(cBSBackupRecord.getBackupId());
                if (!cBSBackupRecord.isSupportSnapshot()) {
                    arrayList5.add(cBSBackupRecord);
                }
            } else {
                if (cBSBackupRecord.getStatus() == 7) {
                    C11839m.m70688i(TAG, "invalid backupRecord: " + cBSBackupRecord.getBackupId());
                    arrayList3.add(cBSBackupRecord.getBackupId());
                }
                if (cBSBackupRecord.getStatus() == 1 && cBSBackupRecord.isSupportSnapshot()) {
                    C11839m.m70688i(TAG, "in backuping backupRecord: " + cBSBackupRecord.getBackupId());
                    arrayList4.add(cBSBackupRecord.getBackupId());
                }
            }
        }
        convertCBSBackupRecordToSnapshotMeta(arrayList5);
        int size = arrayList2.size();
        int iM75751H0 = C12590s0.m75751H0();
        while (size > iM75751H0) {
            CBSBackupRecord oldestBackupRecord = getOldestBackupRecord(arrayList);
            if (oldestBackupRecord == null) {
                C11839m.m70689w(TAG, "prepareDeleteRecord oldestRecord is null");
            } else {
                this.service.m68015V(oldestBackupRecord.getBackupId(), oldestBackupRecord.getDevice().getDeviceId(), oldestBackupRecord.getDevice().getDeviceType(), this.backupType, 7, oldestBackupRecord.getSnapshot());
                size--;
                arrayList.remove(oldestBackupRecord);
                arrayList2.remove(oldestBackupRecord.getBackupId());
                arrayList3.add(oldestBackupRecord.getBackupId());
                C11839m.m70688i(TAG, "successful backup record maxRecordNum = " + iM75751H0 + " ,count = " + size + ", update oldest record invalid: " + oldestBackupRecord.getBackupId());
            }
        }
        List<String> listVerifyCBSBackupRecords = verifyCBSBackupRecords(new ArrayList(map.values()));
        arrayList2.removeAll(listVerifyCBSBackupRecords);
        arrayList3.removeAll(listVerifyCBSBackupRecords);
        HashMap map2 = new HashMap();
        if (arrayList4.size() > 0) {
            String str = (String) arrayList4.get(0);
            try {
                if (this.snapshotTreeService.queryMaxRightIndex(str) > 0) {
                    C11839m.m70688i(TAG, "add inBackuping record to successful backup record list, compare with invalid record");
                    arrayList2.add(str);
                }
            } catch (C9721b unused) {
                C11839m.m70688i(TAG, "in backuping backupRecord: " + str + " has no snapshot metadata");
            }
        }
        map2.put("successfulBackupRecordIds", arrayList2);
        map2.put("invalidBackupRecordsIds", arrayList3);
        return map2;
    }

    private void processDownloadException(C9721b c9721b, CBSBackupRecord cBSBackupRecord, List<String> list, List<CBSBackupRecord> list2) throws C9721b {
        if (cBSBackupRecord.getStatus() == 7) {
            if (ICBUtil.isSnapshotNotExist(c9721b)) {
                list2.add(cBSBackupRecord);
                list.add(cBSBackupRecord.getBackupId());
                return;
            } else {
                C11839m.m70688i(TAG, "download invalid record error, delete invalid record in next task");
                list.add(cBSBackupRecord.getBackupId());
                return;
            }
        }
        if (cBSBackupRecord.getStatus() == 0) {
            if (!ICBUtil.isSnapshotNotExist(c9721b)) {
                C11839m.m70688i(TAG, "download success record error, stop delete task");
                throw c9721b;
            }
            list2.add(cBSBackupRecord);
            list.add(cBSBackupRecord.getBackupId());
            if (this.exception == null) {
                this.exception = c9721b;
            }
        }
    }

    private void processSnapshotNotExsitRecords(List<CBSBackupRecord> list) throws Throwable {
        if (list.isEmpty()) {
            return;
        }
        C11839m.m70688i(TAG, "server delete record action: " + this.deleteRecordAction);
        if (!this.deleteRecordAction.equals("2")) {
            C9721b c9721b = this.exception;
            if (c9721b != null) {
                throw c9721b;
            }
            return;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            CBSBackupRecord cBSBackupRecord = list.get(i10);
            if (i10 == list.size() - 1) {
                C11839m.m70688i(TAG, "last snapshot not exist record, update clientActions to server");
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.deleteRecordAction);
                this.service.m68014U(cBSBackupRecord.getBackupId(), cBSBackupRecord.getDevice().getDeviceId(), cBSBackupRecord.getDevice().getDeviceType(), this.backupType, arrayList, 7, cBSBackupRecord.getSnapshot());
                this.service.m68032p(this.deviceId, this.deviceType, cBSBackupRecord.getBackupId());
                reportDeleteSingleRecord(cBSBackupRecord.getBackupId(), true);
            } else if (cBSBackupRecord.getStatus() == 7) {
                C11839m.m70688i(TAG, "invalid backup record snapshot not exist, backupId: " + cBSBackupRecord.getBackupId());
                this.service.m68032p(this.deviceId, this.deviceType, cBSBackupRecord.getBackupId());
                reportDeleteSingleRecord(cBSBackupRecord.getBackupId(), true);
            } else if (cBSBackupRecord.getStatus() == 0) {
                C11839m.m70688i(TAG, "success backup record snapshot not exist, backupId: " + cBSBackupRecord.getBackupId());
                this.service.m68015V(cBSBackupRecord.getBackupId(), cBSBackupRecord.getDevice().getDeviceId(), cBSBackupRecord.getDevice().getDeviceType(), this.backupType, 7, cBSBackupRecord.getSnapshot());
                this.service.m68032p(this.deviceId, this.deviceType, cBSBackupRecord.getBackupId());
                reportDeleteSingleRecord(cBSBackupRecord.getBackupId(), true);
            }
        }
    }

    private void releaseDeleteLock() {
        try {
            try {
                this.service.m68013T(this.deviceId, this.backupId, this.deviceType, 1);
            } catch (C9721b unused) {
                C11839m.m70687e(TAG, "unlock delete lock requeset exception");
            }
        } finally {
            deleteUnLock();
        }
    }

    private void reportDeleteRecordTime() {
        if (this.reportDeleteInfo != null) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("taskStartTime", String.valueOf(this.reportDeleteInfo.getTaskStartTime()));
            linkedHashMap.put("taskEndTime", String.valueOf(System.currentTimeMillis()));
            linkedHashMap.put("deleteStartTime", String.valueOf(this.reportDeleteInfo.getDeleteStartTime()));
            linkedHashMap.put("deleteEndTime", String.valueOf(this.reportDeleteInfo.getDeleteEndTime()));
            ReportDeleteInfo reportDeleteInfo = this.reportDeleteInfo;
            reportDeleteInfo.setTime(reportDeleteInfo.getDeleteEndTime() - this.reportDeleteInfo.getDeleteStartTime());
            linkedHashMap.put("time", String.valueOf(this.reportDeleteInfo.getTime()));
            linkedHashMap.put("isAfterBackup", String.valueOf(this.isAfterBackup ? 1 : 0));
            C9721b c9721b = this.exception;
            linkedHashMap.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, c9721b == null ? "0" : c9721b.m60660d());
            C9721b c9721b2 = this.exception;
            linkedHashMap.put("errorMessage", c9721b2 == null ? "success" : c9721b2.getMessage());
            linkedHashMap.put("backupTraceID", this.backupTraceID);
            parseRecordSize(linkedHashMap);
            C11060c c11060cM66626a = C11058a.m66626a(this.traceID, "deleteRecordTime", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u("010_200");
            C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
            C13225d.m79490f1().m79549A0("delete_records_task_end", linkedHashMap);
            C11839m.m70688i(TAG, "reportDeleteRecordTime: " + this.reportDeleteInfo.getTime());
        }
    }

    private void reportDeleteSingleRecord(String str, boolean z10) {
        String str2 = "delete single record success, backupid: " + str;
        C11060c c11060cM66626a = C11058a.m66626a(this.traceID, "deleteSingleRecord", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66635A(str2);
        c11060cM66626a.m66665u("0");
        c11060cM66626a.m66668x("1");
        c11060cM66626a.m66664t("success");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("backupTraceID", this.backupTraceID);
        linkedHashMap.put("isSnapshotNotExist", String.valueOf(z10));
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
        linkedHashMap.put(JsbMapKeyNames.H5_USER_ID, C13452e.m80781L().m80971t0());
        linkedHashMap.put("traceID", this.traceID);
        linkedHashMap.put("errorReason", str2);
        linkedHashMap.put("code", "0");
        C13225d.m79490f1().m79603z0("delete_single_record", linkedHashMap);
    }

    private List<String> verifyCBSBackupRecords(List<CBSBackupRecord> list) throws Throwable {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (CBSBackupRecord cBSBackupRecord : list) {
            if (cBSBackupRecord.isSupportSnapshot()) {
                String backupId = cBSBackupRecord.getBackupId();
                if (!this.snapshotTreeService.existSnapshotDataBase(backupId)) {
                    C11839m.m70688i(TAG, "download snapshot db, backup id = " + backupId + ", status = " + cBSBackupRecord.getStatus());
                    String snapshot = (cBSBackupRecord.getStatus() == 7 || cBSBackupRecord.getStatus() == 1) ? this.serverPath + this.snapshotTreeService.getDBName(backupId) : cBSBackupRecord.getStatus() == 0 ? cBSBackupRecord.getSnapshot() : "";
                    if (!TextUtils.isEmpty(snapshot)) {
                        try {
                            downloadSnapshotDb(snapshot, this.snapshotTreeService.getDBName(backupId));
                        } catch (C9721b e10) {
                            C11839m.m70687e(TAG, "download snapshot.db error: " + e10.getMessage());
                            processDownloadException(e10, cBSBackupRecord, arrayList, arrayList2);
                        }
                    }
                }
            }
        }
        processSnapshotNotExsitRecords(arrayList2);
        return arrayList;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        Map<String, CBSBackupRecord> allRecordsFromServer;
        C13466f.m81073d().m81081i("isDeleteTaskSuccess", false);
        try {
            allRecordsFromServer = getAllRecordsFromServer();
        } catch (C9721b unused) {
            allRecordsFromServer = null;
        }
        if (allRecordsFromServer == null || allRecordsFromServer.size() == 0) {
            C11839m.m70688i(TAG, "backupRecords is null or empty");
            C13466f.m81073d().m81081i("isDeleteTaskSuccess", true);
            return;
        }
        try {
            try {
                ReportDeleteInfo reportDeleteInfo = new ReportDeleteInfo();
                this.reportDeleteInfo = reportDeleteInfo;
                reportDeleteInfo.setAfterBackup(this.isAfterBackup);
                keepDeleteLock();
                Map<String, List<String>> mapPrepareDeleteRecord = prepareDeleteRecord(allRecordsFromServer);
                List<String> list = mapPrepareDeleteRecord.get("successfulBackupRecordIds");
                List<String> list2 = mapPrepareDeleteRecord.get("invalidBackupRecordsIds");
                if (list2 != null && list2.size() > 0) {
                    this.reportDeleteInfo.setDeleteStartTime(System.currentTimeMillis());
                    deleteInvalidBackupRecords(allRecordsFromServer, list, list2);
                    this.reportDeleteInfo.setDeleteEndTime(System.currentTimeMillis());
                }
                C13466f.m81073d().m81081i("isDeleteTaskSuccess", true);
                releaseDeleteLock();
                if (this.exception != null) {
                    C13466f.m81073d().m81082j("deleteErrorCode", this.exception.m60659c());
                    C13466f.m81073d().m81084l("deleteErrorMessage", this.exception.getMessage());
                }
                reportDeleteRecordTime();
                for (CBSBackupRecord cBSBackupRecord : allRecordsFromServer.values()) {
                    if (cBSBackupRecord != null && !TextUtils.isEmpty(cBSBackupRecord.getBackupId())) {
                        this.snapshotTreeService.closeSnapshotDB(cBSBackupRecord.getBackupId());
                    }
                }
            } catch (C9721b e10) {
                if (this.exception == null) {
                    this.exception = e10;
                }
                C11839m.m70687e(TAG, "delete backup record error: " + this.exception.getMessage());
                releaseDeleteLock();
                if (this.exception != null) {
                    C13466f.m81073d().m81082j("deleteErrorCode", this.exception.m60659c());
                    C13466f.m81073d().m81084l("deleteErrorMessage", this.exception.getMessage());
                }
                reportDeleteRecordTime();
                for (CBSBackupRecord cBSBackupRecord2 : allRecordsFromServer.values()) {
                    if (cBSBackupRecord2 != null && !TextUtils.isEmpty(cBSBackupRecord2.getBackupId())) {
                        this.snapshotTreeService.closeSnapshotDB(cBSBackupRecord2.getBackupId());
                    }
                }
            }
        } catch (Throwable th2) {
            releaseDeleteLock();
            if (this.exception != null) {
                C13466f.m81073d().m81082j("deleteErrorCode", this.exception.m60659c());
                C13466f.m81073d().m81084l("deleteErrorMessage", this.exception.getMessage());
            }
            reportDeleteRecordTime();
            for (CBSBackupRecord cBSBackupRecord3 : allRecordsFromServer.values()) {
                if (cBSBackupRecord3 != null && !TextUtils.isEmpty(cBSBackupRecord3.getBackupId())) {
                    this.snapshotTreeService.closeSnapshotDB(cBSBackupRecord3.getBackupId());
                }
            }
            throw th2;
        }
    }

    public void deleteLock() {
        this.deleteLockTimer = null;
        this.deleteLockTimer = new CBLockTimer(this.deviceId, this.traceID, this.deviceType, 1, BackupPowerKitKeepTimer.getInstance().getApplyType(this.backupType == 1));
        C12515a.m75110o().m75172d(this.deleteLockTimer);
    }

    public void deleteUnLock() {
        CBLockTimer cBLockTimer = this.deleteLockTimer;
        if (cBLockTimer != null) {
            cBLockTimer.cancel();
            this.deleteLockTimer = null;
        }
    }

    public void downloadSnapshotDb(String str, String str2) throws C9721b {
        C12478a c12478a = new C12478a(EnumC12999a.CLOUD_BACKUP, this.traceID);
        String parent = C0213f.m1378b().getDatabasePath(str2).getParent();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getLocation());
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(str2);
        String string = sb2.toString();
        File fileM63442h = C10278a.m63442h(string);
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadSnapshotDb tempFile delete file error");
        }
        c12478a.m74913i(str, string, this.progressCallback);
        File fileM63442h2 = C10278a.m63442h(parent + str3 + str2);
        if (fileM63442h2.exists() && !fileM63442h2.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadSnapshot delete file error");
        }
        if (!C11835i.m70654r(fileM63442h, fileM63442h2)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadSnapshot snapFile rename error");
        }
    }

    public boolean getDeleteLockTimerResult() throws C9721b {
        C11839m.m70688i(TAG, "start getDeleteLockTimerResult ");
        CBLockTimer cBLockTimer = this.deleteLockTimer;
        if (cBLockTimer == null) {
            return false;
        }
        List<String> clientActionList = cBLockTimer.getClientActionList();
        if (clientActionList == null || clientActionList.isEmpty() || !clientActionList.contains("2")) {
            return true;
        }
        this.deleteRecordAction = "2";
        return true;
    }

    public String getLocation() {
        return C10279b.m63452a(C10278a.m63442h(C0213f.m1377a().getFilesDir() + "/cloudbackup"));
    }

    public long getSecondsTime(long j10) {
        return (System.currentTimeMillis() - j10) / 1000;
    }

    public CBSBackupRecord queryBackupRecordDetail(String str, int i10, CBSBackupRecord cBSBackupRecord) throws C9721b {
        try {
            return this.service.m68001H(str, i10, cBSBackupRecord.getBackupId(), true, false);
        } catch (C9721b e10) {
            if (cBSBackupRecord.getStatus() != 1) {
                throw e10;
            }
            C11839m.m70689w(TAG, "query old backupRecordDetailReq exception");
            return null;
        }
    }

    public void reportQuerySingleRecord(String str) {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02006"), "querySingleRecordDetail", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66666v("isSuccess", "0", "1", "query one backup record detail, backupId: " + str);
        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
    }

    public void reportVFSGetattrFail(List<Result.ErrMsg> list) throws C9721b {
        C11839m.m70688i(TAG, "report getattr fail file");
        int i10 = 0;
        for (Result.ErrMsg errMsg : list) {
            C11839m.m70689w(TAG, "getattr fail file err: " + errMsg.toString());
            if (errMsg.getErrCode() != 103) {
                throw new C9721b(3207, errMsg.getErrCode(), errMsg.getErrMsg());
            }
            i10++;
        }
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02009"), "restoreFileExits", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66666v("isSuccess", "0", "1", "query vfs failed, file path is not exits, count: " + i10);
        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
    }
}
