package com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.BackupRecordMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.script.BackupRecordMetaScript;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import fk.C9721b;
import java.util.List;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class BackupRecordMetaOperator extends BaseOperator<BackupRecordMeta> {
    private static final String TAG = "BackupRecordMetaOperator";

    public BackupRecordMetaOperator(String str) {
        super(str);
    }

    public void deleteTable() throws C9721b, SQLException {
        execSQL(BackupRecordMetaScript.DELETE_TABLE);
    }

    public int getVersion() {
        if (getDb() != null) {
            return getDb().getVersion();
        }
        C11839m.m70689w(TAG, "getVersion db is null.");
        return 0;
    }

    public List<BackupRecordMeta> queryAllMetas() throws C9721b {
        return queryResult4Vo(BackupRecordMetaScript.QUERY_ALL_METAS, new String[0]);
    }

    public void replace(BackupRecordMeta backupRecordMeta) throws C9721b, SQLException {
        if (backupRecordMeta == null) {
            return;
        }
        try {
            execSQL(BackupRecordMetaScript.REPLACE_BY_BACKUPRECORD_ID, new String[]{backupRecordMeta.getCurrentRecordId(), backupRecordMeta.getRecordId(), String.valueOf(backupRecordMeta.getDate()), String.valueOf(backupRecordMeta.getVersion()), String.valueOf(backupRecordMeta.getStatus()), backupRecordMeta.getEmuiVersion(), backupRecordMeta.getData1(), backupRecordMeta.getData2(), backupRecordMeta.getData3(), backupRecordMeta.getData4(), backupRecordMeta.getData5(), backupRecordMeta.getData6()});
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "replace status error." + e10.getMessage());
            throw e10;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.operator.BaseOperator
    public BackupRecordMeta getVo(Cursor cursor) {
        BackupRecordMeta backupRecordMeta = new BackupRecordMeta();
        backupRecordMeta.setId(cursor.getLong(cursor.getColumnIndex("id")));
        backupRecordMeta.setCurrentRecordId(cursor.getString(cursor.getColumnIndex("current_record_id")));
        backupRecordMeta.setRecordId(cursor.getString(cursor.getColumnIndex("record_id")));
        backupRecordMeta.setDate(cursor.getLong(cursor.getColumnIndex(CallLogCons.DATE)));
        backupRecordMeta.setVersion(cursor.getLong(cursor.getColumnIndex("version")));
        backupRecordMeta.setStatus(cursor.getLong(cursor.getColumnIndex("status")));
        backupRecordMeta.setEmuiVersion(cursor.getString(cursor.getColumnIndex("emui_version")));
        backupRecordMeta.setData1(cursor.getString(cursor.getColumnIndex("data1")));
        backupRecordMeta.setData2(cursor.getString(cursor.getColumnIndex("data2")));
        backupRecordMeta.setData3(cursor.getString(cursor.getColumnIndex("data3")));
        backupRecordMeta.setData4(cursor.getString(cursor.getColumnIndex("data4")));
        backupRecordMeta.setData5(cursor.getString(cursor.getColumnIndex("data5")));
        backupRecordMeta.setData6(cursor.getString(cursor.getColumnIndex("data6")));
        return backupRecordMeta;
    }
}
