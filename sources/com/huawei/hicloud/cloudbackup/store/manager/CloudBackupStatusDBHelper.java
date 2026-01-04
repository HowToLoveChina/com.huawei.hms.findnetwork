package com.huawei.hicloud.cloudbackup.store.manager;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.script.SnapshotBackupMetaScript;
import java.util.Locale;
import p514o9.C11839m;

/* loaded from: classes6.dex */
public class CloudBackupStatusDBHelper extends SQLiteOpenHelper {

    /* renamed from: a */
    public static final String f22413a;

    /* renamed from: b */
    public static final String f22414b;

    /* renamed from: c */
    public static final String f22415c;

    static {
        Locale locale = Locale.ENGLISH;
        f22413a = String.format(locale, "create table if not exists %s (appId text not null,uid integer not null default 0,appName text,appType integer,itemTotal integer default 0,dataBytes integer default 0,codeBytes integer default 0,backup_switch INTEGER default 0,backup_data integer default 0,attachBytes integer default 0,alreadyCount integer default 0,itemCount integer default 0,alreadyBytes integer default 0,increase integer default 0,scenceId integer default 0,backupType integer default 0,status integer default 0,type integer,dataTime integer default 0,briefTime integer default 0,sdcardTime integer default 0,updateTime integer default 0,record_id TEXT,quotaType integer,properties text,oriBackupAppName text,splitApkType text,androidDataStrategy text,data1 text, data2 text, data3 text,data4 text, data5 text, data6 text,progressPower integer default 0,data7 text, data8 text, data9 text,data10 text, data11 text, data12 text,primary key (appId,uid));", "t_backup_status");
        f22414b = String.format(locale, "create table if not exists %s (appId text not null,uid integer not null default 0,appName text,appType integer,itemTotal integer default 0,dataBytes integer default 0,codeBytes integer default 0,backup_switch INTEGER default 0,backup_data integer default 0,attachBytes integer default 0,alreadyCount integer default 0,itemCount integer default 0,alreadyBytes integer default 0,increase integer default 0,scenceId integer default 0,backupType integer default 0,status integer default 0,type integer,dataTime integer default 0,briefTime integer default 0,sdcardTime integer default 0,updateTime integer default 0,record_id TEXT,quotaType integer,properties text,oriBackupAppName text,splitApkType text,androidDataStrategy text,data1 text, data2 text, data3 text,data4 text, data5 text, data6 text,progressPower integer default 0,data7 text, data8 text, data9 text,data10 text, data11 text, data12 text,primary key (appId,uid));", "t_backup_status_refurbish");
        f22415c = String.format(locale, "create table if not exists %s (appId text not null,uid integer not null default 0,appName text,appType integer,itemTotal integer default 0,dataBytes integer default 0,codeBytes integer default 0,backup_switch INTEGER default 0,backup_data integer default 0,attachBytes integer default 0,alreadyCount integer default 0,itemCount integer default 0,alreadyBytes integer default 0,increase integer default 0,scenceId integer default 0,backupType integer default 0,status integer default 0,type integer,dataTime integer default 0,briefTime integer default 0,sdcardTime integer default 0,updateTime integer default 0,record_id TEXT,quotaType integer,properties text,oriBackupAppName text,splitApkType text,androidDataStrategy text,data1 text, data2 text, data3 text,data4 text, data5 text, data6 text,progressPower integer default 0,data7 text, data8 text, data9 text,data10 text, data11 text, data12 text,primary key (appId,uid));", "t_backup_status_tempbackup");
    }

    public CloudBackupStatusDBHelper(Context context) {
        super(context, "cloudbackup_status.db", (SQLiteDatabase.CursorFactory) null, 9);
    }

    /* renamed from: b */
    public final boolean m29565b(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        String[] strArr = {str, str2};
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery(SnapshotBackupMetaScript.QUERY_OLD_SNAPSHOT_FLAG_BY_UNIQUE, strArr);
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    while (TextUtils.isEmpty(cursorRawQuery.getString(0))) {
                        if (!cursorRawQuery.moveToNext()) {
                        }
                    }
                    cursorRawQuery.close();
                    return true;
                }
            } catch (Exception e10) {
                C11839m.m70687e("CloudBackupAppStatusDBHelper", "catch exception when isExistColumn" + e10.getMessage());
                if (cursorRawQuery != null) {
                }
            }
            return false;
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    /* renamed from: c */
    public boolean m29566c(SQLiteDatabase sQLiteDatabase, String str) {
        String string = null;
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select sql from sqlite_master where name = ?", new String[]{str});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        string = cursorRawQuery.getString(0);
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupAppStatusDBHelper", "checkAndCreateTable error." + e10.getMessage());
        }
        return !TextUtils.isEmpty(string);
    }

    /* renamed from: d */
    public final void m29567d(SQLiteDatabase sQLiteDatabase) throws SQLException {
        m29568e(sQLiteDatabase, "t_backup_status", "alter table t_backup_status add column %s;");
        m29568e(sQLiteDatabase, "t_backup_status_tempbackup", "alter table t_backup_status_tempbackup add column %s;");
        m29568e(sQLiteDatabase, "t_backup_status_refurbish", "alter table t_backup_status_refurbish add column %s;");
    }

    /* renamed from: e */
    public final void m29568e(SQLiteDatabase sQLiteDatabase, String str, String str2) throws SQLException {
        if (m29566c(sQLiteDatabase, str) && !m29565b(sQLiteDatabase, str, "%oriBackupAppName%")) {
            sQLiteDatabase.execSQL(String.format(Locale.ENGLISH, str2, "oriBackupAppName text"));
        }
        if (m29566c(sQLiteDatabase, str) && !m29565b(sQLiteDatabase, str, "%splitApkType%")) {
            sQLiteDatabase.execSQL(String.format(Locale.ENGLISH, str2, "splitApkType text"));
        }
        if (!m29566c(sQLiteDatabase, str) || m29565b(sQLiteDatabase, str, "%androidDataStrategy%")) {
            return;
        }
        sQLiteDatabase.execSQL(String.format(Locale.ENGLISH, str2, "androidDataStrategy text"));
    }

    /* renamed from: f */
    public final void m29569f(SQLiteDatabase sQLiteDatabase) throws SQLException {
        if (m29566c(sQLiteDatabase, "t_backup_status") && !m29565b(sQLiteDatabase, "t_backup_status", "%progressPower%")) {
            Locale locale = Locale.ENGLISH;
            sQLiteDatabase.execSQL(String.format(locale, "alter table t_backup_status add column %s;", "progressPower Integer default 0"));
            sQLiteDatabase.execSQL(String.format(locale, "alter table t_backup_status add column %s;", "data7 text"));
            sQLiteDatabase.execSQL(String.format(locale, "alter table t_backup_status add column %s;", "data8 text"));
            sQLiteDatabase.execSQL(String.format(locale, "alter table t_backup_status add column %s;", "data9 text"));
            sQLiteDatabase.execSQL(String.format(locale, "alter table t_backup_status add column %s;", "data10 text"));
            sQLiteDatabase.execSQL(String.format(locale, "alter table t_backup_status add column %s;", "data11 text"));
            sQLiteDatabase.execSQL(String.format(locale, "alter table t_backup_status add column %s;", "data12 text"));
        }
        if (!m29566c(sQLiteDatabase, "t_backup_status_refurbish") || m29565b(sQLiteDatabase, "t_backup_status_refurbish", "%progressPower%")) {
            return;
        }
        Locale locale2 = Locale.ENGLISH;
        sQLiteDatabase.execSQL(String.format(locale2, "alter table t_backup_status_refurbish add column %s;", "progressPower Integer default 0"));
        sQLiteDatabase.execSQL(String.format(locale2, "alter table t_backup_status_refurbish add column %s;", "data7 text"));
        sQLiteDatabase.execSQL(String.format(locale2, "alter table t_backup_status_refurbish add column %s;", "data8 text"));
        sQLiteDatabase.execSQL(String.format(locale2, "alter table t_backup_status_refurbish add column %s;", "data9 text"));
        sQLiteDatabase.execSQL(String.format(locale2, "alter table t_backup_status_refurbish add column %s;", "data10 text"));
        sQLiteDatabase.execSQL(String.format(locale2, "alter table t_backup_status_refurbish add column %s;", "data11 text"));
        sQLiteDatabase.execSQL(String.format(locale2, "alter table t_backup_status_refurbish add column %s;", "data12 text"));
    }

    /* renamed from: g */
    public final void m29570g(SQLiteDatabase sQLiteDatabase) throws SQLException {
        m29571h(sQLiteDatabase);
        m29567d(sQLiteDatabase);
    }

    /* renamed from: h */
    public final void m29571h(SQLiteDatabase sQLiteDatabase) throws SQLException {
        if (m29566c(sQLiteDatabase, "t_restore_status_v3")) {
            if (!m29565b(sQLiteDatabase, "t_restore_status_v3", "%oriBackupAppName%")) {
                sQLiteDatabase.execSQL("alter table t_restore_status_v3 add column oriBackupAppName text;");
            }
            if (m29565b(sQLiteDatabase, "t_restore_status_v3", "%splitApkType%")) {
                return;
            }
            sQLiteDatabase.execSQL("alter table t_restore_status_v3 add column splitApkType text;");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("create table if not exists t_backup_static (appId text not null primary key,appName text,appType integer,appVersionName text,appVersionCode text,status integer default 0,type integer,startTime integer default 0,updateTime integer default 0,endTime integer default 0,returnCode integer default 0,increase integer default 0,estimateIncrease1 integer default 0,estimateIncrease2 integer default 0,data1 text, data2 text, data3 text, data4 text, data5 text);");
        sQLiteDatabase.execSQL("create table if not exists t_restore_status_v3(id text,appId text not null,appName text,appType integer not null default 0,action integer not null default 0,status integer not null default 0,type integer not null default 0,current integer,count integer,size integer,asize integer,showType integer not null default 0,dataType integer not null default 0,attachmentCount integer,versionName text,versionCode integer,localVersion integer,iconLocal text,launchFlag integer,retCode text,message text,uid integer not null default 0,subStatus text,properties text,isCompatible integer,isHarmonyNext integer,appShowType integer,aggVirtualAppId text,oriBackupAppName text,splitApkType text,data1 text, data2 text, data3 text, data4 text, data5 text,primary key (appId, uid));");
        sQLiteDatabase.execSQL("create table if not exists t_restore_attachment_status(appId text not null,assetId text not null,versionId text not null,usage text not null,status integer not null default 0,size integer,count integer,hash1 text not null, hash2 text not null, flag integer not null,uid integer not null default 0,data1 text, data2 text, data3 text, data4 text, data5 text,UNIQUE(appId, assetId));");
        sQLiteDatabase.execSQL("create table if not exists t_asset_status(id text not null primary key, length integer, hash1 text not null, hash2 text not null, hmac text, status integer default 0, kindId text, recordId text, assetId text, versionId text, sliceSize integer, data1 text, data2 text, data3 text, data4 text, data5 text);");
        sQLiteDatabase.execSQL("create table if not exists t_asset_slice(id text not null, number integer, objectId text not null, start integer, length integer, status integer default 0, data1 text, data2 text, data3 text, data4 text, data5 text,unique(id, number));");
        sQLiteDatabase.execSQL("create index if not exists idx_asset_id on t_asset_status(id);");
        sQLiteDatabase.execSQL("create index if not exists idx_slice_id on t_asset_slice(id);");
        sQLiteDatabase.execSQL("create table if not exists t_app_backup_attachment_status(appId text not null,uid integer not null default 0,assetId text,versionId text,usage text not null,status integer not null default 0,size integer,count integer,hash1 text not null, hash2 text not null, flag integer not null,data1 text, data2 text, data3 text, data4 text, data5 text,primary key (appId, uid, usage));");
        sQLiteDatabase.execSQL(f22413a);
        sQLiteDatabase.execSQL(f22414b);
        sQLiteDatabase.execSQL(f22415c);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 > i11) {
            C11839m.m70688i("CloudBackupAppStatusDBHelper", "cloud backup status database downgrade. oldVersion = " + i10);
            sQLiteDatabase.execSQL("drop table if exists app_backup_status;");
            sQLiteDatabase.execSQL("drop table if exists t_backup_static;");
            sQLiteDatabase.execSQL("drop table if exists app_restore_status_v3;");
            sQLiteDatabase.execSQL("drop table if exists t_restore_status_v3;");
            sQLiteDatabase.execSQL("drop table if exists app_attachment_status;");
            sQLiteDatabase.execSQL("drop table if exists t_restore_attachment_status;");
            sQLiteDatabase.execSQL("drop table if exists t_asset_status;");
            sQLiteDatabase.execSQL("drop table if exists t_asset_slice;");
            sQLiteDatabase.execSQL("drop table if exists t_backup_status_tempbackup;");
            sQLiteDatabase.execSQL("create table if not exists t_backup_static (appId text not null primary key,appName text,appType integer,appVersionName text,appVersionCode text,status integer default 0,type integer,startTime integer default 0,updateTime integer default 0,endTime integer default 0,returnCode integer default 0,increase integer default 0,estimateIncrease1 integer default 0,estimateIncrease2 integer default 0,data1 text, data2 text, data3 text, data4 text, data5 text);");
            sQLiteDatabase.execSQL("create table if not exists t_restore_status_v3(id text,appId text not null,appName text,appType integer not null default 0,action integer not null default 0,status integer not null default 0,type integer not null default 0,current integer,count integer,size integer,asize integer,showType integer not null default 0,dataType integer not null default 0,attachmentCount integer,versionName text,versionCode integer,localVersion integer,iconLocal text,launchFlag integer,retCode text,message text,uid integer not null default 0,subStatus text,properties text,isCompatible integer,isHarmonyNext integer,appShowType integer,aggVirtualAppId text,oriBackupAppName text,splitApkType text,data1 text, data2 text, data3 text, data4 text, data5 text,primary key (appId, uid));");
            sQLiteDatabase.execSQL("create table if not exists t_restore_attachment_status(appId text not null,assetId text not null,versionId text not null,usage text not null,status integer not null default 0,size integer,count integer,hash1 text not null, hash2 text not null, flag integer not null,uid integer not null default 0,data1 text, data2 text, data3 text, data4 text, data5 text,UNIQUE(appId, assetId));");
            sQLiteDatabase.execSQL("create table if not exists t_asset_status(id text not null primary key, length integer, hash1 text not null, hash2 text not null, hmac text, status integer default 0, kindId text, recordId text, assetId text, versionId text, sliceSize integer, data1 text, data2 text, data3 text, data4 text, data5 text);");
            sQLiteDatabase.execSQL("create table if not exists t_asset_slice(id text not null, number integer, objectId text not null, start integer, length integer, status integer default 0, data1 text, data2 text, data3 text, data4 text, data5 text,unique(id, number));");
            sQLiteDatabase.execSQL("create index if not exists idx_asset_id on t_asset_status(id);");
            sQLiteDatabase.execSQL("create index if not exists idx_slice_id on t_asset_slice(id);");
            sQLiteDatabase.execSQL("drop table if exists t_app_backup_attachment_status;");
            sQLiteDatabase.execSQL("create table if not exists t_app_backup_attachment_status(appId text not null,uid integer not null default 0,assetId text,versionId text,usage text not null,status integer not null default 0,size integer,count integer,hash1 text not null, hash2 text not null, flag integer not null,data1 text, data2 text, data3 text, data4 text, data5 text,primary key (appId, uid, usage));");
            sQLiteDatabase.execSQL(f22413a);
            sQLiteDatabase.execSQL(f22414b);
            sQLiteDatabase.execSQL(f22415c);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 < 2) {
            C11839m.m70688i("CloudBackupAppStatusDBHelper", "cloud backup status database upgrade. oldVersion = " + i10);
            sQLiteDatabase.execSQL("drop table if exists backup_app_status;");
            sQLiteDatabase.execSQL("create table if not exists app_backup_status (appId text not null primary key,appName text,appType integer,status integer default 0,type integer,itemCount integer default 0,alreadyCount integer default 0,itemTotal integer default 0,alreadyBytes integer default 0,dataBytes integer default 0,codeBytes integer default 0,data_flag INTEGER default 0,backup_switch INTEGER default 0,is_bundle INTEGER default 0,runtime_type INTEGER,app_version TEXT,version_code TEXT,app_slice TEXT,icon_path TEXT,date_create INTEGER default 0,date_modify INTEGER default 0,date_invalid INTEGER default 0,date_taken INTEGER default 0,record_id TEXT,data1 TEXT, data2 TEXT, data3 TEXT, data4 TEXT, data5 TEXT, data6 TEXT);");
            sQLiteDatabase.execSQL("create table if not exists t_backup_static (appId text not null primary key,appName text,appType integer,appVersionName text,appVersionCode text,status integer default 0,type integer,startTime integer default 0,updateTime integer default 0,endTime integer default 0,returnCode integer default 0,increase integer default 0,estimateIncrease1 integer default 0,estimateIncrease2 integer default 0,data1 text, data2 text, data3 text, data4 text, data5 text);");
        }
        if (i10 < 3) {
            sQLiteDatabase.execSQL(f22414b);
        }
        if (i10 < 4) {
            m29569f(sQLiteDatabase);
        }
        if (i10 < 5 && m29566c(sQLiteDatabase, "t_restore_status_v3") && !m29565b(sQLiteDatabase, "t_restore_status_v3", "%subStatus%")) {
            sQLiteDatabase.execSQL(String.format(Locale.ENGLISH, "alter table t_restore_status_v3 add column %s;", "subStatus text"));
        }
        if (i10 < 6 && m29566c(sQLiteDatabase, "t_restore_status_v3") && !m29565b(sQLiteDatabase, "t_restore_status_v3", "%properties%")) {
            sQLiteDatabase.execSQL(String.format(Locale.ENGLISH, "alter table t_restore_status_v3 add column %s;", "properties text"));
        }
        if (i10 < 7) {
            sQLiteDatabase.execSQL(f22415c);
        }
        if (i10 < 8 && m29566c(sQLiteDatabase, "t_restore_status_v3")) {
            if (!m29565b(sQLiteDatabase, "t_restore_status_v3", "%isCompatible%")) {
                sQLiteDatabase.execSQL("alter table t_restore_status_v3 add column isCompatible integer;");
            }
            if (!m29565b(sQLiteDatabase, "t_restore_status_v3", "%isHarmonyNext%")) {
                sQLiteDatabase.execSQL("alter table t_restore_status_v3 add column isHarmonyNext integer;");
            }
            if (!m29565b(sQLiteDatabase, "t_restore_status_v3", "%appShowType%")) {
                sQLiteDatabase.execSQL("alter table t_restore_status_v3 add column appShowType integer;");
            }
            if (!m29565b(sQLiteDatabase, "t_restore_status_v3", "%aggVirtualAppId%")) {
                sQLiteDatabase.execSQL(String.format(Locale.ENGLISH, "alter table t_restore_status_v3 add column %s;", "aggVirtualAppId text"));
            }
        }
        if (i10 < 9) {
            m29570g(sQLiteDatabase);
        }
    }
}
