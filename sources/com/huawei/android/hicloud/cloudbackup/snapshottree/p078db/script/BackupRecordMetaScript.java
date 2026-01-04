package com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.script;

/* loaded from: classes2.dex */
public class BackupRecordMetaScript {
    public static final String DELETE_TABLE = "delete from backuprecord_meta";
    public static final String QUERY_ALL_METAS = "select id,current_record_id,record_id,date,version,status,emui_version,data1,data2,data3,data4,data5,data6 from backuprecord_meta;";
    public static final String REPLACE_BY_BACKUPRECORD_ID = "replace into backuprecord_meta(current_record_id,record_id,date,version,status,emui_version,data1,data2,data3,data4,data5,data6) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
    public static final String REPLACE_EMUI_VERSION = "replace into backuprecord_meta(emui_version) VALUES(?);";
}
