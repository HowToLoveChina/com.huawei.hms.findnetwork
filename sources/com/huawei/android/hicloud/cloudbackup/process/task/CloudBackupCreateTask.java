package com.huawei.android.hicloud.cloudbackup.process.task;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupTaskManager;
import com.huawei.android.hicloud.cloudbackup.process.task.CloudBackupOneCreateTask;
import com.huawei.android.hicloud.cloudbackup.snapshottree.QueryBackupMetaExcludeTar;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.request.cbs.bean.CBSAppInfo;
import com.huawei.hicloud.request.cbs.bean.CBSFileInfo;
import com.huawei.hicloud.request.cbs.bean.MkFile;
import com.huawei.hicloud.request.opengw.bean.MakeFileReq;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.secure.android.common.util.SafeString;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import mk.C11476b;
import p015ak.C0213f;
import p015ak.C0240y;
import p015ak.C0241z;
import p514o9.C11839m;
import p618rm.C12590s0;
import p709vj.C13452e;
import p848zl.C14333b;

/* loaded from: classes2.dex */
public class CloudBackupCreateTask extends CloudBackupBaseTask {
    private static final String TAG = "CloudBackupCreateTask";
    private String appId;
    private String backupId;
    private CloudBackupCreateCallback callback;
    private C9721b exception;
    private boolean isVirtual;
    private String location;
    private SnapshotBackupMeta rootNode;
    private int rowBatch;
    private String serverPath;
    private SnapshotTreeManagementService snapshotTreeService = SnapshotTreeManagementService.getInstance();
    private String traceID;

    public CloudBackupCreateTask(SnapshotBackupMeta snapshotBackupMeta, String str, String str2, int i10, boolean z10, CloudBackupCreateCallback cloudBackupCreateCallback) {
        this.rootNode = snapshotBackupMeta;
        this.appId = snapshotBackupMeta.getData();
        this.backupId = str;
        this.traceID = str2;
        this.rowBatch = i10;
        this.isVirtual = z10;
        this.callback = cloudBackupCreateCallback;
    }

    private void build3rdFileInfo(CBSAppInfo cBSAppInfo, List<MakeFileReq> list, List<String> list2, List<CBSFileInfo> list3) throws Throwable {
        if (this.isVirtual) {
            cBSAppInfo.setExtend(this.rootNode.getExtend());
            return;
        }
        String appId = cBSAppInfo.getAppId();
        C11839m.m70688i(TAG, "build 3rd file info start, localAppId = " + appId);
        SnapshotBackupMeta snapshotBackupMetaQueryAppApkFile = this.snapshotTreeService.queryAppApkFile(appId, this.backupId);
        if (snapshotBackupMetaQueryAppApkFile != null) {
            int appType = (int) snapshotBackupMetaQueryAppApkFile.getAppType();
            cBSAppInfo.setExtend(snapshotBackupMetaQueryAppApkFile.getExtend() + "&" + SnapshotBackupMeta.KEY_STRING_APP_SIZE + "=" + snapshotBackupMetaQueryAppApkFile.getSize() + "&" + SnapshotBackupMeta.KEY_STRING_APP_SLICE_PATH + "=" + snapshotBackupMetaQueryAppApkFile.getAppSlice());
            cBSAppInfo.setApkPath(getApkPath(snapshotBackupMetaQueryAppApkFile));
            cBSAppInfo.setApkType(appType);
            cBSAppInfo.setRuntimeType((int) snapshotBackupMetaQueryAppApkFile.getType());
            boolean z10 = appType == 3;
            C11839m.m70688i(TAG, "build 3rd file info, isStandard = " + z10);
            if (z10) {
                this.snapshotTreeService.updateLeafNodeStatusByAppIdAndCloudPath(5, snapshotBackupMetaQueryAppApkFile.getCloudPath(), appId, this.backupId);
            } else {
                buildFileRequest(snapshotBackupMetaQueryAppApkFile, list, list2);
                CBSFileInfo cBSFileInfoBuildFileInfo = buildFileInfo(snapshotBackupMetaQueryAppApkFile, false);
                MkFile mkFileBuild3rdMkFile = build3rdMkFile(snapshotBackupMetaQueryAppApkFile);
                cBSFileInfoBuildFileInfo.setIsApkOrIcon(1);
                cBSFileInfoBuildFileInfo.setMkFile(mkFileBuild3rdMkFile);
                list3.add(cBSFileInfoBuildFileInfo);
            }
            SnapshotBackupMeta snapshotBackupMetaQueryAppIconFile = this.snapshotTreeService.queryAppIconFile(appId, this.backupId);
            if (snapshotBackupMetaQueryAppIconFile != null) {
                cBSAppInfo.setIconPath(snapshotBackupMetaQueryAppIconFile.getAppSlice());
                if (z10) {
                    this.snapshotTreeService.updateLeafNodeStatusByAppIdAndCloudPath(5, snapshotBackupMetaQueryAppIconFile.getCloudPath(), appId, this.backupId);
                } else {
                    buildFileRequest(snapshotBackupMetaQueryAppIconFile, list, list2);
                    CBSFileInfo cBSFileInfoBuildFileInfo2 = buildFileInfo(snapshotBackupMetaQueryAppIconFile, false);
                    MkFile mkFileBuild3rdMkFile2 = build3rdMkFile(snapshotBackupMetaQueryAppIconFile);
                    cBSFileInfoBuildFileInfo2.setIsApkOrIcon(2);
                    cBSFileInfoBuildFileInfo2.setMkFile(mkFileBuild3rdMkFile2);
                    list3.add(cBSFileInfoBuildFileInfo2);
                }
            }
        }
        C11839m.m70688i(TAG, "build 3rd file info end, appId = " + appId);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hicloud.request.cbs.bean.MkFile build3rdMkFile(com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.String r6 = r11.getAppId()
            r0 = 0
            r9.a r1 = new r9.a     // Catch: fk.C9721b -> L29
            t9.a r2 = p652t9.EnumC12999a.CLOUD_BACKUP     // Catch: fk.C9721b -> L29
            java.lang.String r3 = r10.traceID     // Catch: fk.C9721b -> L29
            r1.<init>(r2, r3)     // Catch: fk.C9721b -> L29
            java.lang.String r2 = r11.getHash1()     // Catch: fk.C9721b -> L29
            java.util.Map r1 = r1.m74927y(r2)     // Catch: fk.C9721b -> L29
            com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService r2 = r10.snapshotTreeService     // Catch: fk.C9721b -> L27
            java.lang.String r3 = r11.getCloudPath()     // Catch: fk.C9721b -> L27
            java.lang.String r4 = com.huawei.android.hicloud.cloudbackup.util.ICBUtil.mapToJson(r1)     // Catch: fk.C9721b -> L27
            java.lang.String r5 = r10.backupId     // Catch: fk.C9721b -> L27
            r2.updateMetaMkInfo(r6, r3, r4, r5)     // Catch: fk.C9721b -> L27
        L25:
            r7 = r0
            goto L44
        L27:
            r0 = move-exception
            goto L2d
        L29:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
        L2d:
            int r2 = r11.getStatus()
            r3 = 5
            if (r2 == r3) goto L3b
            int r2 = r11.getStatus()
            r3 = 6
            if (r2 != r3) goto L25
        L3b:
            java.lang.String r1 = r11.getData1()
            java.util.Map r1 = com.huawei.android.hicloud.cloudbackup.util.ICBUtil.jsonToMap(r1)
            goto L25
        L44:
            if (r1 != 0) goto L7f
            com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService r0 = r10.snapshotTreeService
            r1 = 0
            java.lang.String r3 = r10.backupId
            r0.updateRootNodeStatus(r6, r1, r3)
            com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService r0 = r10.snapshotTreeService
            java.lang.String r1 = r11.getData()
            java.lang.String r2 = r11.getHash1()
            r3 = 0
            java.lang.String r5 = r10.backupId
            r0.updateLeafNodeStatus(r1, r2, r3, r5, r6)
            if (r7 != 0) goto L7e
            fk.b r7 = new fk.b
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "query 3rd metas for make file error: "
            r10.append(r0)
            java.lang.String r11 = r11.getHash1()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r11 = 1008(0x3f0, float:1.413E-42)
            r7.<init>(r11, r10)
        L7e:
            throw r7
        L7f:
            java.lang.String r0 = "sig"
            java.lang.Object r2 = r1.get(r0)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "ts"
            java.lang.Object r4 = r1.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "url"
            java.lang.Object r1 = r1.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            com.huawei.hicloud.request.cbs.bean.MkFile r7 = new com.huawei.hicloud.request.cbs.bean.MkFile
            r7.<init>()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = r10.serverPath
            r8.append(r10)
            r8.append(r6)
            java.lang.String r10 = java.io.File.separator
            r8.append(r10)
            java.lang.String r10 = r11.getCloudPath()
            r8.append(r10)
            java.lang.String r10 = r8.toString()
            r7.setName(r10)
            long r10 = r11.getSize()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r7.setSize(r10)
            r10 = 0
            r7.setNeedRun(r10)
            if (r2 == 0) goto Ld5
            boolean r10 = r2.isEmpty()
            if (r10 == 0) goto Ld4
            goto Ld5
        Ld4:
            r0 = r2
        Ld5:
            r7.setSig(r0)
            if (r4 == 0) goto Le2
            boolean r10 = r4.isEmpty()
            if (r10 == 0) goto Le1
            goto Le2
        Le1:
            r3 = r4
        Le2:
            r7.setTs(r3)
            if (r1 == 0) goto Lef
            boolean r10 = r1.isEmpty()
            if (r10 == 0) goto Lee
            goto Lef
        Lee:
            r5 = r1
        Lef:
            r7.setUrl(r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.task.CloudBackupCreateTask.build3rdMkFile(com.huawei.android.hicloud.cloudbackup.snapshottree.db.bean.SnapshotBackupMeta):com.huawei.hicloud.request.cbs.bean.MkFile");
    }

    private CBSFileInfo buildFileInfo(SnapshotBackupMeta snapshotBackupMeta, boolean z10) {
        CBSFileInfo cBSFileInfo = new CBSFileInfo();
        cBSFileInfo.setHash(isEncrypt() ? snapshotBackupMeta.getHash2() : snapshotBackupMeta.getHash1());
        cBSFileInfo.setFileName(snapshotBackupMeta.getCloudPath());
        if (z10) {
            cBSFileInfo.setExpand(String.format(Locale.ENGLISH, "modifiedtime=%d&datetaken=%d", Long.valueOf(snapshotBackupMeta.getDateModify()), Long.valueOf(snapshotBackupMeta.getDateTaken())));
        }
        return cBSFileInfo;
    }

    private List<CBSFileInfo> buildFileInfoList(String str, boolean z10, List<MakeFileReq> list, List<String> list2) throws C9721b {
        C11839m.m70688i(TAG, "build file info list start, appId = " + str);
        boolean zEquals = HNConstants.DataType.MEDIA.equals(str);
        ArrayList arrayList = new ArrayList();
        QueryBackupMetaExcludeTar queryBackupMetaExcludeTar = new QueryBackupMetaExcludeTar(str, this.backupId);
        long j10 = 0;
        while (queryBackupMetaExcludeTar.hasNext()) {
            List<SnapshotBackupMeta> next = queryBackupMetaExcludeTar.getNext();
            if (next != null && !next.isEmpty()) {
                for (SnapshotBackupMeta snapshotBackupMeta : next) {
                    String str2 = snapshotBackupMeta.getRoot() + snapshotBackupMeta.getData();
                    if (!z10 || (!ICBUtil.isApkFile(str2, this.location, str) && !ICBUtil.isIconFile(str2, this.location, str))) {
                        buildFileRequest(snapshotBackupMeta, list, list2);
                        boolean zIsInfoFile = ICBUtil.isInfoFile(str2, this.location, str);
                        if (!z10 || zIsInfoFile) {
                            arrayList.add(buildFileInfo(snapshotBackupMeta, zEquals));
                        } else {
                            j10++;
                        }
                    }
                }
                next.clear();
            }
        }
        if (z10 && j10 > 0) {
            this.rootNode.setData1(String.valueOf(1));
        }
        C11839m.m70688i(TAG, "build file info list end, appId = " + str);
        return arrayList;
    }

    private void buildFileRequest(SnapshotBackupMeta snapshotBackupMeta, List<MakeFileReq> list, List<String> list2) throws C9721b {
        if (4 == snapshotBackupMeta.getStatus()) {
            String str = snapshotBackupMeta.getRoot() + snapshotBackupMeta.getData();
            TreeMap treeMap = new TreeMap();
            treeMap.put(JsbMapKeyNames.H5_LOC, str);
            treeMap.put("encoded", String.valueOf(snapshotBackupMeta.getCloudEncoded()));
            treeMap.put("isencrypted", "0");
            treeMap.put("ftime", String.valueOf(snapshotBackupMeta.getDateCreate()));
            MakeFileReq makeFileReq = new MakeFileReq(snapshotBackupMeta.getHash1(), this.serverPath + snapshotBackupMeta.getAppId() + File.separator + snapshotBackupMeta.getCloudPath());
            makeFileReq.setAttribute(treeMap);
            list.add(makeFileReq);
            list2.add(snapshotBackupMeta.getCloudPath());
            makeFile(snapshotBackupMeta.getAppId(), list, list2, false);
        }
    }

    private String getApkPath(SnapshotBackupMeta snapshotBackupMeta) {
        String appSlice = snapshotBackupMeta.getAppSlice();
        if (!isEncrypt()) {
            return appSlice;
        }
        String str = File.separator;
        String strSubstring = SafeString.substring(appSlice, 0, appSlice.lastIndexOf(str));
        return "/" + snapshotBackupMeta.getAppId() + "/" + C0241z.m1685c(SafeString.substring(strSubstring, strSubstring.lastIndexOf(str) + 1)) + "/" + snapshotBackupMeta.getAppId() + ".apk_" + snapshotBackupMeta.getHash1() + "_" + snapshotBackupMeta.getHash2();
    }

    public static boolean isEncrypt() {
        return !C10028c.m62182c0().m62420y1();
    }

    private void makeFile(String str, List<MakeFileReq> list, List<String> list2, boolean z10) throws C9721b {
        int size = list.size();
        if (size > 0) {
            if (z10 || size >= this.rowBatch) {
                CloudBackupCreateManager.getInstance().await(this);
                C9721b c9721b = this.exception;
                if (c9721b != null) {
                    throw c9721b;
                }
                CloudBackupCreateManager.getInstance().addTask(str, new CloudBackupOneCreateTask(str, this.traceID, this.backupId, new ArrayList(list), new ArrayList(list2), new CloudBackupOneCreateTask.CloudBackupOneCreateCallback() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.CloudBackupCreateTask.1
                    @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudBackupOneCreateTask.CloudBackupOneCreateCallback
                    public void onError(C9721b c9721b2) {
                        if (CloudBackupCreateTask.this.exception == null) {
                            CloudBackupCreateTask.this.exception = c9721b2;
                        }
                    }
                }));
                list.clear();
                list2.clear();
            }
        }
    }

    private void makeTarFiles(String str, boolean z10, List<MakeFileReq> list, List<String> list2) throws C9721b {
        if (z10) {
            C11839m.m70688i(TAG, "make 3rd tar files start, appId = " + str);
            List<String> listQueryTarCloudPathByAppId = this.snapshotTreeService.queryTarCloudPathByAppId(str, this.backupId);
            if (listQueryTarCloudPathByAppId == null || listQueryTarCloudPathByAppId.isEmpty()) {
                C11839m.m70688i(TAG, "make 3rd tar files no tar files, appId = " + str);
                return;
            }
            this.rootNode.setData1(String.valueOf(1));
            for (String str2 : listQueryTarCloudPathByAppId) {
                String tarHashByCloudPath = ICBUtil.getTarHashByCloudPath(str2);
                MakeFileReq makeFileReq = new MakeFileReq(tarHashByCloudPath, ICBUtil.getTarPathByCloudPath(this.serverPath, str2, str));
                TreeMap treeMap = new TreeMap();
                treeMap.put(JsbMapKeyNames.H5_LOC, ICBUtil.getRelativePath(this.location + File.separator + str + ICBUtil.TAR_LOCAL_DIR + tarHashByCloudPath + ".tar", this.location));
                treeMap.put("isencrypted", "0");
                makeFileReq.setAttribute(treeMap);
                list.add(makeFileReq);
                list2.add(str2);
                makeFile(str, list, list2, false);
            }
            C11839m.m70688i(TAG, "make 3rd tar files end, appId = " + str);
        }
    }

    private void setGuid(CBSAppInfo cBSAppInfo) throws C9721b {
        if (isEncrypt()) {
            String userKeyGuid = UserKeyUtils.getInstance().getSyncUser(1, this.traceID).getUserKeyGuid();
            if (TextUtils.isEmpty(userKeyGuid)) {
                return;
            }
            cBSAppInfo.setUnstrGuid(userKeyGuid);
            cBSAppInfo.setUnstrDataVer("1");
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void call() {
        CBSAppInfo cBSAppInfo;
        C9721b c9721b;
        try {
            try {
                C11839m.m70688i(TAG, "make file task start, appId = " + this.appId);
                String strM80950o = C13452e.m80781L().m80950o();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(isEncrypt() ? "" : "/Backup");
                sb2.append("/CloudBackup/");
                sb2.append(C11476b.m68626h(strM80950o));
                sb2.append("/");
                this.serverPath = sb2.toString();
                this.location = C10279b.m63452a(C10278a.m63442h(C0213f.m1377a().getFilesDir() + "/cloudbackup"));
                boolean zContainsKey = C14333b.m85486u().containsKey(this.appId) ^ true;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                makeTarFiles(this.appId, zContainsKey, arrayList, arrayList2);
                List<CBSFileInfo> listBuildFileInfoList = buildFileInfoList(this.appId, zContainsKey, arrayList, arrayList2);
                cBSAppInfo = new CBSAppInfo();
                cBSAppInfo.setSize(this.snapshotTreeService.querySizeByAppIdExcludeStandApk(this.backupId, this.appId));
                cBSAppInfo.setAppId(this.appId);
                if (zContainsKey) {
                    build3rdFileInfo(cBSAppInfo, arrayList, arrayList2, listBuildFileInfoList);
                    cBSAppInfo.setExtend(cBSAppInfo.getExtend() + ("&containsappdata=" + (this.isVirtual ? String.valueOf(2) : this.rootNode.getData1())));
                } else {
                    cBSAppInfo.setExtend(String.format(Locale.ENGLISH, "count=%d&newData=%s", Long.valueOf(this.rootNode.getCount()), Integer.valueOf(HNConstants.DataType.MEDIA.equals(this.appId) ? 1 : 0)));
                }
                cBSAppInfo.setExtend(cBSAppInfo.getExtend() + ("&backupApkVersion=" + (zContainsKey ? C0240y.m1680b(C0213f.m1377a(), this.appId) : C12590s0.m75790R(this.appId))));
                cBSAppInfo.setFileInfos(listBuildFileInfoList);
                cBSAppInfo.setCreateTime(System.currentTimeMillis());
                setGuid(cBSAppInfo);
                makeFile(this.appId, arrayList, arrayList2, true);
                CloudBackupCreateManager.getInstance().syncLock(this.appId, this);
                c9721b = this.exception;
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "make file error, appId = " + this.appId + " " + e10.toString());
                abort();
                this.callback.onCreateError(e10);
            }
            if (c9721b != null) {
                throw c9721b;
            }
            List<SnapshotBackupMeta> listQueryUnsuccessfulNodes = this.snapshotTreeService.queryUnsuccessfulNodes(this.appId, this.backupId);
            if (listQueryUnsuccessfulNodes.size() <= 0) {
                this.snapshotTreeService.updateRootNodeStatus(this.appId, 5L, this.backupId);
                this.callback.onCreateSuccess(cBSAppInfo);
                C11839m.m70688i(TAG, "make file task end, appId = " + this.appId);
                this.callback.onCreateEnd();
                CloudBackupCreateManager.getInstance().removeTask(this.appId);
                return;
            }
            C11839m.m70687e(TAG, "check snapshot backup metas error, size = " + listQueryUnsuccessfulNodes.size());
            this.snapshotTreeService.defaultRootNodeStatus(this.appId, this.backupId);
            throw new C9721b(1018, "make file not all success. appId = " + this.appId);
        } catch (Throwable th2) {
            this.callback.onCreateEnd();
            CloudBackupCreateManager.getInstance().removeTask(this.appId);
            throw th2;
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void cancel(boolean z10) {
        abort();
        super.cancel(z10);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void release() {
        CloudBackupTaskManager.getInstance().removeCreateTask(this.appId, this);
    }
}
