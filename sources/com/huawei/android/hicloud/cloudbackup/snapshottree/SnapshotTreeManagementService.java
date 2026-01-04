package com.huawei.android.hicloud.cloudbackup.snapshottree;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.snapshottree.bean.SnapshotNode;
import com.huawei.android.hicloud.cloudbackup.snapshottree.method.SnapshotTreeInterface;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.BackupRecordMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.operator.SnapshotBackupMetaOperator;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p015ak.C0213f;
import p015ak.C0221j;
import p514o9.C11839m;
import p744wl.C13617a;
import pl.C12164f;

/* loaded from: classes2.dex */
public class SnapshotTreeManagementService implements SnapshotTreeInterface {
    private static final int MAX_FILE_SIZE = 100;
    private static final String TAG = "SnapshotTreeManagementService";
    private SnapshotBackupMeta mCurrentRootSnapshotMeta;
    private List<SnapshotBackupMeta> mFileBackupMetas;

    public static class Holder {
        private static SnapshotTreeManagementService instance = new SnapshotTreeManagementService();

        private Holder() {
        }
    }

    public static SnapshotTreeManagementService getInstance() {
        return Holder.instance;
    }

    private boolean isFileContainsId(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.contains(str2)) ? false : true;
    }

    private void traverseSnapshotTree(SnapshotNode snapshotNode, List<SnapshotBackupMeta> list) {
        if (list == null) {
            C11839m.m70688i(TAG, "traverseSnapshotTree error, metaList is null.");
            return;
        }
        if (snapshotNode == null || snapshotNode.getBackupMeta() == null) {
            return;
        }
        list.add(snapshotNode.getBackupMeta());
        if (snapshotNode.getChilds().size() > 0) {
            Iterator<SnapshotNode> it = snapshotNode.getChilds().iterator();
            while (it.hasNext()) {
                traverseSnapshotTree(it.next(), list);
            }
        }
    }

    public void addChildNodeToParent(SnapshotNode snapshotNode, SnapshotNode snapshotNode2) {
        if (snapshotNode == null || snapshotNode2 == null) {
            return;
        }
        snapshotNode2.getChilds().add(snapshotNode);
    }

    public void addFileMeta(SnapshotBackupMeta snapshotBackupMeta, String str, boolean z10) throws C9721b {
        if (snapshotBackupMeta != null) {
            this.mFileBackupMetas.add(snapshotBackupMeta);
            SnapshotBackupMeta snapshotBackupMeta2 = this.mCurrentRootSnapshotMeta;
            if (snapshotBackupMeta2 != null) {
                snapshotBackupMeta2.setRight(snapshotBackupMeta.getRight() + 1);
            }
        }
        if (z10 || this.mFileBackupMetas.size() > 100) {
            SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str);
            SnapshotBackupMeta snapshotBackupMeta3 = this.mCurrentRootSnapshotMeta;
            if (snapshotBackupMeta3 != null) {
                this.mFileBackupMetas.add(snapshotBackupMeta3);
            }
            if (this.mFileBackupMetas.isEmpty()) {
                return;
            }
            snapshotBackupMetaOperator.batchReplace(this.mFileBackupMetas);
            this.mFileBackupMetas.clear();
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.snapshottree.method.SnapshotTreeInterface
    public List<SnapshotBackupMeta> addTree(String str, SnapshotNode snapshotNode, String str2) throws C9721b {
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str2);
        ArrayList arrayList = new ArrayList();
        traverseSnapshotTree(snapshotNode, arrayList);
        if (arrayList.size() > 0) {
            snapshotBackupMetaOperator.batchReplace(arrayList);
            return arrayList;
        }
        C11839m.m70688i(TAG, "addTree tree error, no root node.appId = " + str);
        return arrayList;
    }

    public long buildSnapshotTree(String str, SnapshotNode snapshotNode, List<SnapshotBackupMeta> list) throws C9721b {
        long left = snapshotNode.getBackupMeta().getLeft() + 1;
        int i10 = 0;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        String str2 = str + ".apk";
        long size = 0;
        for (SnapshotBackupMeta snapshotBackupMeta : list) {
            if (snapshotBackupMeta == null) {
                C11839m.m70687e(TAG, "buildSnapshotTree appId = " + str + ", snapshotBackupMeta is null");
            } else {
                C11839m.m70686d(TAG, "buildSnapshotTree  date = " + snapshotBackupMeta.getData());
                if (snapshotBackupMeta.getData().endsWith(str2)) {
                    snapshotBackupMeta.setType(0L);
                }
                snapshotBackupMeta.setLeft(left);
                snapshotBackupMeta.setRight(left + 1);
                addChildNodeToParent(createTreeLeafNode(snapshotBackupMeta), snapshotNode);
                size += snapshotBackupMeta.getSize();
                snapshotBackupMeta.setAppId(str);
                i10++;
                left += 2;
            }
        }
        if (i10 != 0) {
            treeCreationCompleted(snapshotNode.getBackupMeta(), snapshotNode.getBackupMeta().getLeft() + (i10 * 2) + 1, size);
        }
        return i10;
    }

    public boolean checkSuccessfulBackupRecordStatus(String str) {
        List<SnapshotBackupMeta> arrayList;
        List<SnapshotBackupMeta> arrayList2;
        if (!existSnapshotDataBase(str)) {
            return false;
        }
        try {
            arrayList = getRoots(str);
        } catch (C9721b unused) {
            C11839m.m70689w(TAG, "check record: " + str + " query root nodes exception.");
            arrayList = new ArrayList<>();
        }
        if (arrayList.size() <= 0) {
            C11839m.m70688i(TAG, "check record: " + str + " snashot database is invalid ,delete it.");
            deleteSnapshotDB(str);
            return false;
        }
        try {
            arrayList2 = queryUnsuccessfulNodes(str);
        } catch (C9721b unused2) {
            C11839m.m70689w(TAG, "check record: " + str + " query unsuccessful nodes exception.");
            arrayList2 = new ArrayList<>();
        }
        if (arrayList2.size() <= 0) {
            C11839m.m70688i(TAG, "check record: " + str + " snashot database is valid.");
            return true;
        }
        C11839m.m70688i(TAG, "check record: " + str + " snashot meta data is invalid ,delete it.");
        deleteSnapshotDB(str);
        return false;
    }

    public void clear() {
        this.mFileBackupMetas.clear();
        this.mCurrentRootSnapshotMeta = null;
    }

    public void clearNotExistFileFlag(String str) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str).clearNotExistFileFlag();
    }

    public void closeSnapshotDB(String str) {
        C11839m.m70688i(TAG, "close snapshot database");
        SnapshotDBManager.closeDB(str);
    }

    public SnapshotNode createDBRootNode(String str) {
        SnapshotBackupMeta snapshotBackupMeta;
        try {
            snapshotBackupMeta = getRootNode(SnapshotBackupMeta.DB_ROOT_NODE_APPID, str);
        } catch (C9721b unused) {
            C11839m.m70687e(TAG, "db root node is null, create a new root node");
            snapshotBackupMeta = null;
        }
        if (snapshotBackupMeta == null) {
            snapshotBackupMeta = new SnapshotBackupMeta();
            snapshotBackupMeta.setData(SnapshotBackupMeta.DB_ROOT_NODE_APPID);
            snapshotBackupMeta.setRoot("");
            snapshotBackupMeta.setName(SnapshotBackupMeta.DB_ROOT_NODE_APPID);
            snapshotBackupMeta.setType(10L);
            snapshotBackupMeta.setAppId(SnapshotBackupMeta.DB_ROOT_NODE_APPID);
            snapshotBackupMeta.setCount(0L);
            snapshotBackupMeta.setLeft(1L);
            snapshotBackupMeta.setRight(2L);
            snapshotBackupMeta.setStatus(0);
            snapshotBackupMeta.setDateCreate(System.currentTimeMillis());
        }
        SnapshotNode snapshotNode = new SnapshotNode();
        snapshotNode.setBackupMeta(snapshotBackupMeta);
        return snapshotNode;
    }

    public String createSnapshotBackupMetaTable(String str) throws C9721b, SQLException {
        C11839m.m70688i(TAG, "create snapshot backup meta table");
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str);
        snapshotBackupMetaOperator.createSnapshotBackupMetaTable();
        BackupRecordMeta backupRecordMetaQueryLastBackupRecordMeta = snapshotBackupMetaOperator.queryLastBackupRecordMeta();
        return (backupRecordMetaQueryLastBackupRecordMeta == null || TextUtils.isEmpty(backupRecordMetaQueryLastBackupRecordMeta.getRecordId())) ? "" : backupRecordMetaQueryLastBackupRecordMeta.getRecordId();
    }

    public SnapshotNode createTreeLeafNode(SnapshotBackupMeta snapshotBackupMeta) {
        SnapshotNode snapshotNode = new SnapshotNode();
        snapshotNode.setBackupMeta(snapshotBackupMeta);
        return snapshotNode;
    }

    public SnapshotNode createTreeRootNode(String str, SnapshotBackupMeta snapshotBackupMeta, long j10, long j11) {
        SnapshotNode snapshotNode = new SnapshotNode();
        if (snapshotBackupMeta == null) {
            snapshotBackupMeta = new SnapshotBackupMeta();
        }
        snapshotBackupMeta.setData(str);
        snapshotBackupMeta.setRoot("");
        snapshotBackupMeta.setName(str);
        snapshotBackupMeta.setType(4L);
        snapshotBackupMeta.setCount(j10);
        snapshotBackupMeta.setLeft(j11);
        snapshotBackupMeta.setRight(j11 + 1);
        snapshotBackupMeta.setAppId(str);
        snapshotBackupMeta.setDateCreate(System.currentTimeMillis());
        snapshotNode.setBackupMeta(snapshotBackupMeta);
        this.mCurrentRootSnapshotMeta = snapshotBackupMeta;
        return snapshotNode;
    }

    public void databaseRepaired(String str) throws SQLException {
        if (str == null || str.isEmpty() || SnapshotDBManager.integrityCheck(str)) {
            return;
        }
        new SnapshotBackupMetaOperator(str).integrityRepaired();
    }

    public void databaseUpdate(String str) throws SQLException {
        if (str == null || str.isEmpty()) {
            C11839m.m70688i(TAG, "databaseUpdate backupId is empty");
            return;
        }
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str);
        try {
            if (snapshotBackupMetaOperator.isOldSnapshot()) {
                C11839m.m70688i(TAG, "databaseUpdate old snapshot upload");
                snapshotBackupMetaOperator.integrityRepaired();
            }
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "databaseUpdate error: " + e10.toString());
        }
    }

    public void defaultNotSuccessModule(String str) throws SQLException {
        try {
            new SnapshotBackupMetaOperator(str).defaultNotSuccessModuleStatus();
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "defaultNotSuccessModule error: " + e10.toString());
        }
    }

    public void defaultRootNodeStatus(String str, String str2) throws SQLException {
        try {
            new SnapshotBackupMetaOperator(str2).updateRootNodeStatus(str, 0L);
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "defaultRootNodeStatus appId: " + str + " error: " + e10.toString());
        }
    }

    public void deleteDataFromSnapshot(String str, String str2) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str2).deleteData(str);
    }

    public void deleteLargeDbDiffIncMetaByAppId(String str, String str2, String str3, String str4) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str2).deleteLargeDbDiffIncMetaByAppId(str, str3, str4);
    }

    public void deleteMetaByAppId(String str, String str2) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str2).deleteMetaByAppId(str);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.snapshottree.method.SnapshotTreeInterface
    public void deleteNode(String str, String str2, String str3, String str4) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str3).deleteLeafNode(str, str2, str4);
    }

    public void deleteNotExistFileByAppId(String str, String str2) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str2).deleteNotExistFileByAppId(str);
    }

    public void deleteRootNode(String str, String str2) throws SQLException {
        try {
            new SnapshotBackupMetaOperator(str2).deleteNodes(str);
        } catch (C9721b unused) {
            C11839m.m70688i(TAG, "deleteRootNode  error, no root node.appId = " + str);
        }
    }

    public void deleteSdcardFromSnapshot(String str, String str2) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str2).deleteSdcard(str);
    }

    public void deleteSnapshotDB() {
        SQLiteDatabase db2;
        C11839m.m70688i(TAG, "delete snapshot");
        File databasePath = C0213f.m1378b().getDatabasePath(getDBName(SnapshotDBManager.PREFIX_DATABASE_NAME));
        if (databasePath != null) {
            String parent = databasePath.getParent();
            C11839m.m70686d(TAG, "get  databasePath: " + parent);
            File fileM63442h = C10278a.m63442h(parent);
            if (fileM63442h.exists()) {
                File[] fileArrListFiles = fileM63442h.listFiles();
                if (fileArrListFiles == null) {
                    return;
                }
                for (File file : fileArrListFiles) {
                    if (file != null && file.exists() && file.isFile()) {
                        String name = file.getName();
                        if (name.startsWith("snapshot_") && name.endsWith(SnapshotDBManager.SUFFIX_DATABASE_NAME)) {
                            C11839m.m70688i(TAG, "delete database: " + name);
                            String backupRecordIdFromName = getBackupRecordIdFromName(name);
                            if (!TextUtils.isEmpty(backupRecordIdFromName) && (db2 = SnapshotDBManager.getDB(backupRecordIdFromName)) != null && db2.isOpen()) {
                                closeSnapshotDB(backupRecordIdFromName);
                            }
                            C0221j.m1499i(C10279b.m63452a(file));
                        } else if (name.startsWith("snapshot_")) {
                            C0221j.m1499i(C10279b.m63452a(file));
                        }
                    }
                }
            }
        }
        C11839m.m70688i(TAG, "delete snapshot end");
    }

    public void deleteSnapshotDBWithId(String str) {
        SQLiteDatabase db2;
        C11839m.m70688i(TAG, "delete snapshot");
        File databasePath = C0213f.m1378b().getDatabasePath(getDBName(SnapshotDBManager.PREFIX_DATABASE_NAME));
        if (databasePath != null) {
            String parent = databasePath.getParent();
            C11839m.m70686d(TAG, "get  databasePath: " + parent);
            File fileM63442h = C10278a.m63442h(parent);
            if (fileM63442h.exists()) {
                File[] fileArrListFiles = fileM63442h.listFiles();
                if (fileArrListFiles == null) {
                    return;
                }
                for (File file : fileArrListFiles) {
                    if (file != null && file.exists() && file.isFile()) {
                        String name = file.getName();
                        if (!isFileContainsId(name, str)) {
                            if (name.startsWith("snapshot_") && name.endsWith(SnapshotDBManager.SUFFIX_DATABASE_NAME)) {
                                C11839m.m70688i(TAG, "delete database: " + name);
                                String backupRecordIdFromName = getBackupRecordIdFromName(name);
                                if (!TextUtils.isEmpty(backupRecordIdFromName) && (db2 = SnapshotDBManager.getDB(backupRecordIdFromName)) != null && db2.isOpen()) {
                                    closeSnapshotDB(backupRecordIdFromName);
                                }
                                C0221j.m1499i(C10279b.m63452a(file));
                            } else if (name.startsWith("snapshot_")) {
                                C0221j.m1499i(C10279b.m63452a(file));
                            }
                        }
                    }
                }
            }
        }
        C11839m.m70688i(TAG, "delete snapshot end");
    }

    public void deleteSnapshotDatabase(String str) {
        closeSnapshotDB(str);
        String dBName = getDBName(str);
        C0213f.m1378b().deleteDatabase(dBName);
        C11839m.m70688i(TAG, "deleteSnapshotDatabase " + dBName);
    }

    public void deleteSnapshotMetaCache(String str) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str).deleteMetas();
    }

    public void endTree(String str, String str2) throws C9721b {
        if (SnapshotBackupMeta.DB_ROOT_NODE_APPID.equals(str) || this.mCurrentRootSnapshotMeta == null) {
            return;
        }
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str2);
        SnapshotBackupMeta snapshotBackupMetaQueryRootNodeMeta = snapshotBackupMetaOperator.queryRootNodeMeta(SnapshotBackupMeta.DB_ROOT_NODE_APPID);
        snapshotBackupMetaQueryRootNodeMeta.setRight(this.mCurrentRootSnapshotMeta.getRight() + 1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(snapshotBackupMetaQueryRootNodeMeta);
        snapshotBackupMetaOperator.batchReplace(arrayList);
    }

    public boolean existSnapshotDataBase(String str) {
        Context contextM1378b;
        String dBName;
        File databasePath;
        if (!TextUtils.isEmpty(getDBName(str)) && (databasePath = (contextM1378b = C0213f.m1378b()).getDatabasePath((dBName = getDBName(str)))) != null && databasePath.exists()) {
            try {
                contextM1378b.openOrCreateDatabase(dBName, 0, null).close();
                return true;
            } catch (Exception unused) {
                C11839m.m70688i(TAG, "existSnapshotDataBase  open database error.");
            }
        }
        return false;
    }

    public int getAllFilesCount(String str) throws C9721b {
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str);
        if (snapshotBackupMetaOperator.checkTableExist()) {
            return snapshotBackupMetaOperator.queryAllFileMetasCountSafety();
        }
        return 0;
    }

    public String getBackupRecordIdFromName(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith(SnapshotDBManager.PREFIX_DATABASE_NAME) || !str.endsWith(SnapshotDBManager.SUFFIX_DATABASE_NAME)) {
            return "";
        }
        String strSubstring = str.substring(9, str.length() - 3);
        C11839m.m70688i(TAG, "get backupId from name: " + strSubstring);
        return strSubstring;
    }

    public String getDBName(String str) {
        return SnapshotDBManager.getDBName(str);
    }

    public String getLastSuccessBackupId(String str) throws C9721b {
        BackupRecordMeta backupRecordMetaQueryLastBackupRecordMeta = new SnapshotBackupMetaOperator(str).queryLastBackupRecordMeta();
        String recordId = (backupRecordMetaQueryLastBackupRecordMeta == null || TextUtils.isEmpty(backupRecordMetaQueryLastBackupRecordMeta.getRecordId())) ? "" : backupRecordMetaQueryLastBackupRecordMeta.getRecordId();
        C11839m.m70688i(TAG, "getLastSuccessBackupId = " + recordId);
        return recordId;
    }

    public long getModuleDateInvalid(String str, String str2) throws C9721b {
        return getRootNode(str, str2).getDateInvalid();
    }

    public int getOneModuleFileNum(String str, String str2) {
        try {
            return (int) new SnapshotBackupMetaOperator(str2).queryMetasSizeByAppId(str);
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "getOneModuleFileNum: " + str + " queryMetasSize error" + e10.toString());
            return 0;
        }
    }

    public long getOneModuleFileSize(String str, String str2) {
        try {
            return new SnapshotBackupMetaOperator(str2).queryAllSizeSumByAppId(str);
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "getOneModuleFileSize: " + str + " queryAllSizeSum error" + e10.toString());
            return 0L;
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.snapshottree.method.SnapshotTreeInterface
    public SnapshotBackupMeta getRootNode(String str, String str2) throws C9721b {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SnapshotBackupMetaOperator(str2).queryRootNodeMeta(str);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.snapshottree.method.SnapshotTreeInterface
    public List<SnapshotBackupMeta> getRoots(String str) throws C9721b {
        return new SnapshotBackupMetaOperator(str).queryAllRootNodeMetas();
    }

    public List<SnapshotBackupMeta> getRootsSafety(String str) throws C9721b {
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str);
        return !snapshotBackupMetaOperator.checkTableExist() ? Collections.emptyList() : snapshotBackupMetaOperator.queryAllRootNodeMetasSafety();
    }

    public boolean isSnapshotDataBaseIntegrityOk(String str) {
        if (TextUtils.isEmpty(getDBName(str))) {
            return false;
        }
        Context contextM1378b = C0213f.m1378b();
        String dBName = getDBName(str);
        File databasePath = contextM1378b.getDatabasePath(dBName);
        if (databasePath == null || !databasePath.exists()) {
            return true;
        }
        SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = null;
        try {
            try {
                sQLiteDatabaseOpenOrCreateDatabase = contextM1378b.openOrCreateDatabase(dBName, 0, null);
                boolean zIsDatabaseIntegrityOk = sQLiteDatabaseOpenOrCreateDatabase.isDatabaseIntegrityOk();
                try {
                    sQLiteDatabaseOpenOrCreateDatabase.close();
                } catch (Exception unused) {
                    C11839m.m70688i(TAG, "existSnapshotDataBase  close error.");
                }
                return zIsDatabaseIntegrityOk;
            } catch (Exception unused2) {
                C11839m.m70688i(TAG, "existSnapshotDataBase  open database error.");
                if (sQLiteDatabaseOpenOrCreateDatabase == null) {
                    return true;
                }
                try {
                    sQLiteDatabaseOpenOrCreateDatabase.close();
                    return true;
                } catch (Exception unused3) {
                    C11839m.m70688i(TAG, "existSnapshotDataBase  close error.");
                    return true;
                }
            }
        } catch (Throwable th2) {
            if (sQLiteDatabaseOpenOrCreateDatabase != null) {
                try {
                    sQLiteDatabaseOpenOrCreateDatabase.close();
                } catch (Exception unused4) {
                    C11839m.m70688i(TAG, "existSnapshotDataBase  close error.");
                }
            }
            throw th2;
        }
    }

    public long queryAllMetasNum(String str) {
        try {
            return new SnapshotBackupMetaOperator(str).queryAllMetasNum();
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "queryAllMetasNum error: " + e10.toString());
            return 0L;
        }
    }

    public SnapshotBackupMeta queryAppApkFile(String str, String str2) throws C9721b {
        return new SnapshotBackupMetaOperator(str2).queryAppApkFile(str, str + ".apk");
    }

    public SnapshotBackupMeta queryAppIconFile(String str, String str2) {
        try {
            return new SnapshotBackupMetaOperator(str2).queryAppInfoFile(str, str + "/" + str + ".icon");
        } catch (C9721b unused) {
            C11839m.m70689w(TAG, "query 3rd icon info is null.");
            return null;
        }
    }

    public SnapshotBackupMeta queryAppInfoFile(String str, String str2) throws C9721b {
        return new SnapshotBackupMetaOperator(str2).queryAppInfoFile(str, str + "/info.xml");
    }

    public Map<String, List<String>> queryDeletedLeafNodes(String str) throws C9721b {
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str);
        if (!snapshotBackupMetaOperator.checkTableExist()) {
            C11839m.m70687e(TAG, "checkTableExist is false.");
            return null;
        }
        try {
            return snapshotBackupMetaOperator.queryDeletedLeafNodes();
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "queryDeletedLeafNodesByStatus error.");
            throw e10;
        }
    }

    public boolean queryIsHaveAppDataFile(String str, String str2) throws C9721b {
        return new SnapshotBackupMetaOperator(str2).queryIsHaveAppDataFile(str, str + "/%", "/sdata/");
    }

    public SnapshotBackupMeta queryLeafNodeByHash(String str, String str2, String str3, String str4) throws C9721b {
        return new SnapshotBackupMetaOperator(str2).queryMetaByHash(str, str3, str4);
    }

    public List<SnapshotBackupMeta> queryLeafNodesByType(String str, String str2, int i10) throws C9721b {
        return new SnapshotBackupMetaOperator(str2).queryMetasByType(str, i10);
    }

    public long queryMaxRightIndex(String str) throws C9721b {
        return new SnapshotBackupMetaOperator(str).queryMaxRightIndex();
    }

    public boolean querySameAppFile(String str, String str2, String str3) {
        return new SnapshotBackupMetaOperator(str).querySameAppFile(str2, str3);
    }

    public long querySizeByAppIdExcludeStandApk(String str, String str2) throws C9721b {
        return new SnapshotBackupMetaOperator(str).querySizeByAppIdExcludeStandApk(str2);
    }

    public long querySizeExcludeStandApk(String str) {
        try {
            return new SnapshotBackupMetaOperator(str).querySizeExcludeStandApk();
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "querySizeExcludeStandApk error: " + e10.toString());
            return 0L;
        }
    }

    public long queryStatusMetaCount(String str, int i10, String str2) throws C9721b {
        return new SnapshotBackupMetaOperator(str2).queryStatusMetaCount(str, i10);
    }

    public List<String> queryTarCloudPathByAppId(String str, String str2) throws C9721b {
        return new SnapshotBackupMetaOperator(str2).queryTarCloudPathByAppId(str);
    }

    public List<SnapshotBackupMeta> queryUnsuccessfulNodes(String str) throws C9721b {
        return new SnapshotBackupMetaOperator(str).queryStatusNotSuccessNodeMetas();
    }

    public synchronized List<SnapshotBackupMeta> saveTree(String str, SnapshotNode snapshotNode, String str2) throws C9721b {
        return addTree(str, snapshotNode, str2);
    }

    public void setCurrentRootSnapshotMeta(SnapshotBackupMeta snapshotBackupMeta) {
        this.mCurrentRootSnapshotMeta = snapshotBackupMeta;
    }

    public void setEmuiVersionForSnapshot(String str, String str2) throws C9721b, SQLException {
        C11839m.m70688i(TAG, "set snapshot backup meta emuiVersion");
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str);
        BackupRecordMeta backupRecordMetaQueryLastBackupRecordMeta = snapshotBackupMetaOperator.queryLastBackupRecordMeta();
        if (backupRecordMetaQueryLastBackupRecordMeta == null) {
            backupRecordMetaQueryLastBackupRecordMeta = new BackupRecordMeta();
        }
        backupRecordMetaQueryLastBackupRecordMeta.setCurrentRecordId(str);
        backupRecordMetaQueryLastBackupRecordMeta.setEmuiVersion(str2);
        backupRecordMetaQueryLastBackupRecordMeta.setVersion(1L);
        snapshotBackupMetaOperator.setLastBackupRecordMeta(backupRecordMetaQueryLastBackupRecordMeta);
    }

    public void setLastSuccessBackupIdForSnapshot(String str, BackupRecordMeta backupRecordMeta) throws C9721b, SQLException {
        C11839m.m70688i(TAG, "set snapshot backup meta");
        new SnapshotBackupMetaOperator(str).setLastBackupRecordMeta(backupRecordMeta);
    }

    public void snapshotDataToRestoreMeta(String str, String str2, String str3) throws C9721b, SQLException {
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str2);
        File databasePath = C0213f.m1378b().getDatabasePath("cloudbackup_metadata.db");
        if (databasePath == null || !databasePath.exists()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "snapshotDataToRestoreMeta error, backupId: " + str2 + "  hicloudbackup db is not exist.");
        }
        snapshotBackupMetaOperator.attachHistorySnapshotDB(databasePath.getPath());
        try {
            try {
                snapshotBackupMetaOperator.replaceDataToAppMetaInfo(str, str3);
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "snapshotDataToRestoreMeta");
                throw e10;
            }
        } finally {
            snapshotBackupMetaOperator.detachHistorySnapshotDB();
        }
    }

    public synchronized void treeCreationCompleted(SnapshotBackupMeta snapshotBackupMeta, long j10, long j11) {
        snapshotBackupMeta.setRight(j10);
        snapshotBackupMeta.setSize(j11);
    }

    public void updataCloudPathByPath(String str, String str2, String str3, String str4, String str5) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str5).updataCloudPathByPath(str, str2, str3, str4);
    }

    public void updateBackupRecordMetaSuccessful(String str) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str).updateNodeStatus(6L);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.snapshottree.method.SnapshotTreeInterface
    public synchronized void updateCache(String str, String str2, String str3) throws C9721b {
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str2);
        File databasePath = C0213f.m1378b().getDatabasePath(getDBName(str));
        if (databasePath == null || !databasePath.exists()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateCache error, backupId: " + str + "  snapshot db is not exist.");
        }
        snapshotBackupMetaOperator.attachHistorySnapshotDB(databasePath.getPath());
        try {
            try {
                snapshotBackupMetaOperator.updateSnapshotBackupMetaCache("last", str3);
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "updateCache error.");
                throw e10;
            }
        } finally {
            snapshotBackupMetaOperator.detachHistorySnapshotDB();
        }
    }

    public void updateCloudPathByCloudPath(String str, String str2, String str3, String str4) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str4).updateCloudPathByCloudPath(str, str2, str3);
    }

    public void updateDeletedLeafNodes(String str) throws C9721b, SQLException {
        try {
            new SnapshotBackupMetaOperator(str).updateDeletedLeafNodes();
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "updateDeletedLeafNodes error.");
            throw e10;
        }
    }

    public void updateDeletedLeafNodesByCloudPathAndAppId(String str, Map<String, String> map) throws C9721b {
        try {
            new SnapshotBackupMetaOperator(str).updateDeletedLeafNodesByCloudPathAndAppId(map);
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "updateDeletedLeafNodesByCloudPathAndAppId error.");
            throw e10;
        }
    }

    public void updateDeletedLeafNodesByStatus(String str, int i10) throws C9721b, SQLException {
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str);
        try {
            if (snapshotBackupMetaOperator.checkTableExist()) {
                snapshotBackupMetaOperator.updateDeletedLeafNodesByStatus(i10);
            } else {
                C11839m.m70687e(TAG, "checkTableExist is false.");
            }
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "updateDeletedLeafNodesByStatus error.");
            throw e10;
        }
    }

    public void updateLargeDbFilesType(String str, String str2, long j10, int i10) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str2).updateLargeDbFilesType(str, j10, i10);
    }

    public void updateLeafNodeInfo(String str, long j10, String str2, int i10, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str10).updateLeafNodeInfo(str, j10, str2, i10, str3, str4, str5, str6, str7, str8, str9);
    }

    public void updateLeafNodeStatus(String str, String str2, long j10, String str3, String str4) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str3).updateLeafNodeStatus(str, str2, j10, str4);
    }

    public void updateLeafNodeStatusByAppIdAndCloudPath(int i10, String str, String str2, String str3) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str3).updateLeafNodeStatusByAppIdAndCloudPath(str, str2, i10);
    }

    public void updateMetaMkInfo(String str, String str2, String str3, String str4) throws SQLException {
        try {
            new SnapshotBackupMetaOperator(str4).updateMetaMkInfo(str, str2, str3);
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "updateMetaMkInfo error: " + e10.toString());
        }
    }

    public void updateModuleDateCreate(String str, long j10, String str2) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str2).updateRootDateCreate(str, j10);
    }

    public void updateModuleDateInvalid(String str, long j10, String str2) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str2).updateRootNodeDateInvalid(str, j10);
    }

    public void updateRootNode(String str, SnapshotBackupMeta snapshotBackupMeta) throws C9721b {
        ArrayList arrayList = new ArrayList();
        arrayList.add(snapshotBackupMeta);
        new SnapshotBackupMetaOperator(str).batchReplace(arrayList);
    }

    public void updateRootNodeStatus(String str, long j10, String str2) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str2).updateRootNodeStatus(str, j10);
    }

    public void updateSameLeafNodes(String str, String str2) throws C9721b, SQLException {
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str);
        File databasePath = C0213f.m1378b().getDatabasePath(getDBName(str2));
        if (databasePath == null || !databasePath.exists()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateSameLeafNodes error, backupId: " + str2 + "  snapshot db is not exist.");
        }
        snapshotBackupMetaOperator.attachHistorySnapshotDB(databasePath.getPath());
        try {
            try {
                snapshotBackupMetaOperator.updateSameSnapshotBackupMetas("last");
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "updateSameLeafNodes error.");
                throw e10;
            }
        } finally {
            snapshotBackupMetaOperator.detachHistorySnapshotDB();
        }
    }

    public void updateSkipThisApp(String str, String str2) throws C9721b, SQLException {
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str);
        try {
            if (snapshotBackupMetaOperator.checkTableExist()) {
                snapshotBackupMetaOperator.updateV2AllWithApp(str2);
            } else {
                C11839m.m70686d(TAG, "updateSkipThisApp do nothing.");
            }
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "updateSkipThisApp error.");
            throw e10;
        }
    }

    public void updateSkipThisAppV3(String str, String str2, int i10) throws C9721b {
        C12164f c12164f = new C12164f(str, str2, 0, i10);
        try {
            if (c12164f.m73103s()) {
                c12164f.m73049M0(str2);
            } else {
                C11839m.m70686d(TAG, "updateSkipThisApp do nothing.");
            }
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "updateSkipThisApp error.");
            throw e10;
        }
    }

    public void updateTarLeafNodeInfo(String str, int i10, int i11, String str2, String str3, String str4, String str5, String str6, String str7, String str8) throws C9721b, SQLException {
        new SnapshotBackupMetaOperator(str8).updateTarLeafNodeInfo(str, i10, i11, str2, str3, str4, str5, str6, str7);
    }

    public void updateUploadMidStatus(String str) throws C9721b, SQLException {
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str);
        snapshotBackupMetaOperator.updateUploadMidStatus(-4, 4);
        snapshotBackupMetaOperator.updateUploadMidStatus(-6, 6);
    }

    public void updateUploadMidStatusByAppId(String str, String str2) throws C9721b, SQLException {
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str2);
        snapshotBackupMetaOperator.updateUploadMidStatusByAppId(str, -4, 4);
        snapshotBackupMetaOperator.updateUploadMidStatusByAppId(str, -6, 6);
    }

    public void updateV2SameFileNodesByV3(String str, String str2, String str3, int i10) throws C9721b, SQLException {
        SnapshotBackupMetaOperator snapshotBackupMetaOperator = new SnapshotBackupMetaOperator(str);
        snapshotBackupMetaOperator.attachHistorySnapshotDB(C13617a.m81942x(str2, str3, 0, i10));
        try {
            try {
                snapshotBackupMetaOperator.updateV2SameFileMetasByV3(str3);
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "updateV2SameNodesByV3 error.");
                throw e10;
            }
        } finally {
            snapshotBackupMetaOperator.detachHistorySnapshotDB();
        }
    }

    public void updateV2SameNotStandApkNodesByV3(String str, String str2, String str3) throws C9721b, SQLException {
        try {
            new SnapshotBackupMetaOperator(str).updateV2SameNotStandApkByV3(str2, str3);
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "updateV2SameNotStandApkNodesByV3 error.");
            throw e10;
        }
    }

    public void updateV3SameNodesByOldRecord(String str, String str2, String str3, int i10) throws C9721b, SQLException {
        C12164f c12164f = new C12164f(str2, str3, 0, i10);
        File databasePath = C0213f.m1378b().getDatabasePath(getDBName(str));
        if (databasePath == null || !databasePath.exists()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateV3SameNodesByOldRecord error, backupId: " + str + "  snapshot db is not exist.");
        }
        c12164f.m73069b(databasePath.getPath());
        try {
            try {
                c12164f.m73055P0(str3);
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "updateV3SameNodesByOldRecordOldRecord error.");
                throw e10;
            }
        } finally {
            c12164f.detach();
        }
    }

    public void updateV3SameNodesByV3(String str, String str2, String str3, int i10) throws C9721b, SQLException {
        C12164f c12164f = new C12164f(str2, str3, 0, i10);
        c12164f.m73069b(C13617a.m81942x(str, str3, 0, i10));
        try {
            try {
                c12164f.m73057Q0(str3);
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "updateV3SameNodesByV3 error.");
                throw e10;
            }
        } finally {
            c12164f.detach();
        }
    }

    private SnapshotTreeManagementService() {
        this.mFileBackupMetas = new ArrayList();
        this.mCurrentRootSnapshotMeta = null;
    }

    public List<SnapshotBackupMeta> queryUnsuccessfulNodes(String str, String str2) throws C9721b {
        return new SnapshotBackupMetaOperator(str2).queryStatusNotSuccessMetas(str);
    }

    public void deleteSnapshotDB(String str) {
        closeSnapshotDB(str);
        String dBName = getDBName(str);
        C0221j.m1499i(C10279b.m63452a(C0213f.m1378b().getDatabasePath(dBName)));
        C11839m.m70688i(TAG, "delete " + dBName);
    }
}
