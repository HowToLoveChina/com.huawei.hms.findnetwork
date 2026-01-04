package com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.script;

/* loaded from: classes2.dex */
public class SnapshotDBScript {
    public static final String CREATE_INDEX_TABLE_BACKUPRECORD_META = "CREATE INDEX IF NOT EXISTS idx_record_id ON backuprecord_meta(record_id);";
    public static final String CREATE_TABLE_BACKUPRECORD_META = "CREATE TABLE IF NOT EXISTS backuprecord_meta (id INTEGER PRIMARY KEY AUTOINCREMENT,current_record_id TEXT NOT NULL UNIQUE,record_id TEXT,date INTEGER,version INTEGER,status INTEGER,emui_version TEXT,data1 TEXT,data2 TEXT,data3 TEXT,data4 TEXT,data5 TEXT,data6 TEXT);";
    public static final int CUR_VERSION = 1;
    public static final String DATABASENAME = "snapshot.db";
    public static final String DROP_TABLE_BACKUPRECORD_META = "DROP TABLE if exists backuprecord_meta;";
    public static final String PRAGMA_INTEGRITY_CHECK = "pragma integrity_check";
    public static final String PRAGMA_JOURNAL_MODE = "PRAGMA journal_mode";
    public static final String PRAGMA_WAL_CHECKPOINT = "PRAGMA wal_checkpoint";
}
