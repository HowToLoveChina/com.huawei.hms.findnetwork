package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script;

/* loaded from: classes2.dex */
public class PmsMetaStatusDBScript {
    public static final String CHECK_METASTATUS_TABLE_EXIST = "select count(*) from sqlite_master where type = 'table' and name = 'meta_status';";
    public static final String CHECK_METASTATUS_TABLE_EXIST_V3 = "select count(*) from sqlite_master where type = 'table' and name = 'meta_status_v3';";
    public static final String CREATE_META_STATUS_SQL = "create table if not exists meta_status (id INTEGER PRIMARY KEY AUTOINCREMENT,status INTEGER not null,modifytime INTEGER not null,data1 TEXT,data2 TEXT,data3 TEXT,data4 TEXT,data5 TEXT,data6 TEXT)";
    public static final String CREATE_META_STATUS_V3_SQL = "create table if not exists meta_status_v3 (id INTEGER PRIMARY KEY AUTOINCREMENT,status INTEGER not null,modifytime INTEGER not null,data1 TEXT,data2 TEXT,data3 TEXT,data4 TEXT,data5 TEXT,data6 TEXT)";
    public static final String QUERY_META_STATUS = "select status, modifytime, data1, data2, data3, data4, data5, data6 from meta_status;";
    public static final String QUERY_META_STATUS_V3 = "select status, modifytime, data1, data2, data3, data4, data5, data6 from meta_status_v3;";
    public static final String REPLACE_PMSMETASTATUS = "replace into meta_status(status, modifytime, data1, data2, data3, data4, data5, data6) values(?,?,?,?,?,?,?,?);";
    public static final String REPLACE_PMSMETASTATUS_V3 = "replace into meta_status_v3(status, modifytime, data1, data2, data3, data4, data5, data6) values(?,?,?,?,?,?,?,?);";
    public static final String UPDATE_MODIFYTIME = "update meta_status set modifytime = ?;";
    public static final String UPDATE_MODIFYTIME_V3 = "update meta_status_v3 set modifytime = ?;";
    public static final String UPDATE_STATUS = "update meta_status set status = ?;";
    public static final String UPDATE_STATUS_V3 = "update meta_status_v3 set status = ?;";
}
