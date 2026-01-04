package com.huawei.hicloud.cloudbackup.store.manager;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.script.SnapshotBackupMetaScript;
import gp.C10028c;
import java.util.Arrays;
import java.util.Locale;
import p514o9.C11839m;
import p848zl.C14333b;

/* loaded from: classes6.dex */
public class CloudBackupTagsDBHelper extends SQLiteOpenHelper {

    /* renamed from: a */
    public static final String f22416a;

    /* renamed from: b */
    public static final String f22417b;

    /* renamed from: c */
    public static final String f22418c;

    /* renamed from: d */
    public static final String f22419d;

    /* renamed from: e */
    public static final String f22420e;

    static {
        Locale locale = Locale.ENGLISH;
        f22416a = String.format(locale, "create table if not exists %s (id INTEGER not null,state INTEGER not null,progress REAL default 0,startTime INTEGER default 0,updateTime INTEGER default 0,endTime INTEGER default 0,returnCode INTEGER not null,deviceId TEXT,backupDeviceId TEXT,version TEXT,backupId TEXT,currentModule TEXT,isNextShow INTEGER default 0,data1 TEXT, data2 TEXT, data3 TEXT, data4 TEXT, data5 TEXT,primary key (id));", "t_cloudbackup_state");
        f22417b = String.format(locale, "create table if not exists %s (id INTEGER not null,state INTEGER not null,progress REAL default 0,startTime INTEGER default 0,updateTime INTEGER default 0,endTime INTEGER default 0,returnCode INTEGER not null,deviceId TEXT,backupDeviceId TEXT,version TEXT,backupId TEXT,currentModule TEXT,isNextShow INTEGER default 0,data1 TEXT, data2 TEXT, data3 TEXT, data4 TEXT, data5 TEXT,primary key (id));", "t_temp_cloudbackup_state");
        f22418c = String.format(locale, "create table if not exists  %s (appId text not null,uid integer not null default 0,appName text,appType integer not null,itemTotal integer not null,dataBytes integer not null,codeBytes integer not null,backup_switch integer not null default 0,backup_data integer not null default 0,operateType integer not null default 0,operateTime INTEGER not null default 0,parent text not null,increase1 integer not null,increase2 integer not null,isDisable integer not null default 0,isDataEnable integer not null default 0,oriBackupAppName text,splitApkType text,data1 text, data2 text, data3 text,data4 text, data5 text, data6 text,primary key (appId,uid));", "t_cloudbackup_options");
        f22419d = String.format(locale, "create table if not exists  %s (appId text not null,uid integer not null default 0,appName text,appType integer not null,itemTotal integer not null,dataBytes integer not null,codeBytes integer not null,backup_switch integer not null default 0,backup_data integer not null default 0,operateType integer not null default 0,operateTime INTEGER not null default 0,parent text not null,increase1 integer not null,increase2 integer not null,isDisable integer not null default 0,isDataEnable integer not null default 0,oriBackupAppName text,splitApkType text,data1 text, data2 text, data3 text,data4 text, data5 text, data6 text,primary key (appId,uid));", "t_backup_options_refurbish");
        f22420e = String.format(locale, "create table if not exists  %s (appId text not null,uid integer not null default 0,appName text,appType integer not null,itemTotal integer not null,dataBytes integer not null,codeBytes integer not null,backup_switch integer not null default 0,backup_data integer not null default 0,operateType integer not null default 0,operateTime INTEGER not null default 0,parent text not null,increase1 integer not null,increase2 integer not null,isDisable integer not null default 0,isDataEnable integer not null default 0,oriBackupAppName text,splitApkType text,data1 text, data2 text, data3 text,data4 text, data5 text, data6 text,primary key (appId,uid));", "t_backup_options_temporary");
    }

    public CloudBackupTagsDBHelper(Context context) {
        super(context, "cloudbackup_tags.db", (SQLiteDatabase.CursorFactory) null, 12);
    }

    /* renamed from: b */
    public final void m29572b(SQLiteDatabase sQLiteDatabase) throws SQLException {
        if (m29575e("%backupStartTime INTEGER%", "backup_tags", sQLiteDatabase)) {
            C11839m.m70688i("CloudBackupTagsDBHelper", "backupstartTime column is exist");
            return;
        }
        C11839m.m70688i("CloudBackupTagsDBHelper", "backupstartTime column is not exist");
        sQLiteDatabase.execSQL("Alter table backup_tags add column backupStartTime INTEGER default 0");
        sQLiteDatabase.execSQL("Alter table backup_tags add column data4 TEXT");
        sQLiteDatabase.execSQL("Alter table backup_tags add column data5 TEXT");
        sQLiteDatabase.execSQL("Alter table backup_tags add column data6 TEXT");
    }

    /* renamed from: c */
    public final void m29573c(SQLiteDatabase sQLiteDatabase) throws SQLException {
        if (m29575e("%progress REAL%", "t_cloudbackup_state", sQLiteDatabase)) {
            C11839m.m70688i("CloudBackupTagsDBHelper", "progress column is correct");
            return;
        }
        C11839m.m70688i("CloudBackupTagsDBHelper", "progress column is not correct");
        sQLiteDatabase.execSQL("alter table t_cloudbackup_state rename to t_cloudbackup_state_tmp;");
        sQLiteDatabase.execSQL(f22416a);
        sQLiteDatabase.execSQL("replace into t_cloudbackup_state select * from t_cloudbackup_state_tmp");
        sQLiteDatabase.execSQL("drop table if exists t_cloudbackup_state_tmp");
    }

    /* renamed from: d */
    public final void m29574d(SQLiteDatabase sQLiteDatabase, String str) throws SQLException {
        C11839m.m70686d("CloudBackupTagsDBHelper", "doExeSql, sql: " + str);
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupTagsDBHelper", "execSQL failed, e: " + e10.getMessage());
        }
    }

    /* renamed from: e */
    public boolean m29575e(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {str2, str};
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
                C11839m.m70687e("CloudBackupTagsDBHelper", "catch exception when isExistColumn" + e10.getMessage());
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

    /* renamed from: f */
    public final void m29576f(SQLiteDatabase sQLiteDatabase) throws SQLException {
        m29577g(sQLiteDatabase, "t_cloudbackup_options");
        m29577g(sQLiteDatabase, "t_backup_options_temporary");
        m29577g(sQLiteDatabase, "t_backup_options_refurbish");
    }

    /* renamed from: g */
    public final void m29577g(SQLiteDatabase sQLiteDatabase, String str) throws SQLException {
        Locale locale = Locale.ENGLISH;
        m29574d(sQLiteDatabase, String.format(locale, "create table if not exists  %s (appId text not null,uid integer not null default 0,appName text,appType integer not null,itemTotal integer not null,dataBytes integer not null,codeBytes integer not null,backup_switch integer not null default 0,backup_data integer not null default 0,operateType integer not null default 0,operateTime INTEGER not null default 0,parent text not null,increase1 integer not null,increase2 integer not null,isDisable integer not null default 0,isDataEnable integer not null default 0,oriBackupAppName text,splitApkType text,data1 text, data2 text, data3 text,data4 text, data5 text, data6 text,primary key (appId,uid));", str));
        if (m29575e("%oriBackupAppName text%", str, sQLiteDatabase)) {
            C11839m.m70688i("CloudBackupTagsDBHelper", "ORIBACKUPAPPNAME column is exist");
        } else {
            C11839m.m70688i("CloudBackupTagsDBHelper", "ORIBACKUPAPPNAME column is not exist");
            sQLiteDatabase.execSQL(String.format(locale, "Alter table %s add column oriBackupAppName text", str));
        }
        if (m29575e("%splitApkType text%", str, sQLiteDatabase)) {
            C11839m.m70688i("CloudBackupTagsDBHelper", "SPLITAPKTYPE column is exist");
        } else {
            C11839m.m70688i("CloudBackupTagsDBHelper", "SPLITAPKTYPE column is not exist");
            sQLiteDatabase.execSQL(String.format(locale, "Alter table %s add column splitApkType text", str));
        }
    }

    /* renamed from: h */
    public final void m29578h(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            if (C10028c.m62182c0().m62303a1()) {
                return;
            }
            C10028c.m62182c0().m62351k2(true);
            sQLiteDatabase.execSQL("update t_cloudbackup_options set backup_switch = ?, operateType = ? where appId not in (?) and appId in (select appId from t_cloudbackup_base_service_app)", new String[]{String.valueOf(0), String.valueOf(0), Arrays.toString(C14333b.f63654f.toArray())});
        } catch (Exception unused) {
            C11839m.m70687e("CloudBackupTagsDBHelper", "updateDbVersionTo12 error");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C11839m.m70688i("CloudBackupTagsDBHelper", "onCreate");
        sQLiteDatabase.execSQL("create table if not exists backup_tags (tag INTEGER default 0,id String not null,status INTEGER default 0,dot INTEGER default 0,deviceId TEXT not null,deviceType INTEGER default 0,backupId TEXT not null,traceId TEXT not null,count INTEGER default 0,code INTEGER default 0,size INTEGER default 0,used INTEGER default 0,total INTEGER default 0,startTime INTEGER default 0,endTime INTEGER default 0,beginTime INTEGER default 0,appId TEXT, businessId TEXT,isNextShow INTEGER default 0,localNeedSpace INTEGER default 0,data1 TEXT, data2 TEXT, data3 TEXT,backupStartTime INTEGER default 0,data4 TEXT, data5 TEXT, data6 TEXT,primary key (tag));");
        sQLiteDatabase.execSQL("create table if not exists app_restore_status(appId text not null,appName text,appType integer not null default -1,action integer not null default 0,status integer not null default 0,type integer not null default 0,current integer,count integer,size integer,aid text,versionName text,versionCode integer,asize integer,version integer,flag integer,apath text,aurl text,iconPath text,iconUrl text,iconId text,iconLocal text,launchFlag integer,data1 text, data2 text, data3 text, data4 text, data5 text,primary key (appId));");
        sQLiteDatabase.execSQL("create table if not exists backup_options_status(appId text not null,name text,parent text not null,isDisable integer not null default 0,switchStatus integer not null default 0,isBackupData integer not null default 0,isDataEnable integer not null default 0,apkSize integer,dataSize integer,count integer,operateTime INTEGER default 0,data1 text, data2 text, data3 text,primary key (appId));");
        sQLiteDatabase.execSQL("create table if not exists t_backup_black_module(id integer PRIMARY KEY AUTOINCREMENT,appId text not null,type integer not null default 0,flag integer not null default 0,data1 text, data2 text, data3 text);");
        sQLiteDatabase.execSQL("create index if not exists app_idx_app_id on t_backup_black_module(appId)");
        sQLiteDatabase.execSQL(f22419d);
        sQLiteDatabase.execSQL(f22420e);
        sQLiteDatabase.execSQL("create table if not exists backup_record_infos (backupId TEXT,startTime INTEGER not null,endTime INTEGER default 0,backupStatus INTEGER default 0,uploadSize INTEGER default 0,uploadDuration INTEGER default 0,backupType INTEGER not null,lastUploadSpeedFlag INTEGER default 0,data1 TEXT, data2 TEXT, data3 TEXT,primary key (startTime));");
        sQLiteDatabase.execSQL(f22416a);
        sQLiteDatabase.execSQL(f22417b);
        sQLiteDatabase.execSQL(f22418c);
        sQLiteDatabase.execSQL("create table if not exists t_other_device_record (deviceName TEXT,deviceId TEXT,size INTEGER default 0,lastbackupTime INTEGER default 0,isCurrent INTEGER default 0,deviceType INTEGER default 0,devDisplayName TEXT,deviceCategory TEXT,backupDeviceId TEXT,data1 TEXT, data2 TEXT, data3 TEXT, data4 TEXT, data5 TEXT,terminalType TEXT);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        C11839m.m70688i("CloudBackupTagsDBHelper", "onDowngrade");
        if (i10 > i11) {
            C11839m.m70688i("CloudBackupTagsDBHelper", "cloud backup tags database downgrade. oldVersion = " + i10);
            sQLiteDatabase.execSQL("drop table if exists tags;");
            sQLiteDatabase.execSQL("drop table if exists backup_tags;");
            sQLiteDatabase.execSQL("create table if not exists backup_tags (tag INTEGER default 0,id String not null,status INTEGER default 0,dot INTEGER default 0,deviceId TEXT not null,deviceType INTEGER default 0,backupId TEXT not null,traceId TEXT not null,count INTEGER default 0,code INTEGER default 0,size INTEGER default 0,used INTEGER default 0,total INTEGER default 0,startTime INTEGER default 0,endTime INTEGER default 0,beginTime INTEGER default 0,appId TEXT, businessId TEXT,isNextShow INTEGER default 0,localNeedSpace INTEGER default 0,data1 TEXT, data2 TEXT, data3 TEXT,backupStartTime INTEGER default 0,data4 TEXT, data5 TEXT, data6 TEXT,primary key (tag));");
            sQLiteDatabase.execSQL("drop table if exists app_restore_status;");
            sQLiteDatabase.execSQL("create table if not exists app_restore_status(appId text not null,appName text,appType integer not null default -1,action integer not null default 0,status integer not null default 0,type integer not null default 0,current integer,count integer,size integer,aid text,versionName text,versionCode integer,asize integer,version integer,flag integer,apath text,aurl text,iconPath text,iconUrl text,iconId text,iconLocal text,launchFlag integer,data1 text, data2 text, data3 text, data4 text, data5 text,primary key (appId));");
            sQLiteDatabase.execSQL("drop table if exists backup_options_status;");
            sQLiteDatabase.execSQL("create table if not exists backup_options_status(appId text not null,name text,parent text not null,isDisable integer not null default 0,switchStatus integer not null default 0,isBackupData integer not null default 0,isDataEnable integer not null default 0,apkSize integer,dataSize integer,count integer,operateTime INTEGER default 0,data1 text, data2 text, data3 text,primary key (appId));");
            sQLiteDatabase.execSQL("drop table if exists t_backup_options_refurbish;");
            sQLiteDatabase.execSQL(f22419d);
            sQLiteDatabase.execSQL("drop table if exists t_backup_options_temporary;");
            sQLiteDatabase.execSQL(f22420e);
            sQLiteDatabase.execSQL("drop table if exists t_backup_black_module;");
            sQLiteDatabase.execSQL("create table if not exists t_backup_black_module(id integer PRIMARY KEY AUTOINCREMENT,appId text not null,type integer not null default 0,flag integer not null default 0,data1 text, data2 text, data3 text);");
            sQLiteDatabase.execSQL("create index if not exists app_idx_app_id on t_backup_black_module(appId)");
            sQLiteDatabase.execSQL("drop table if exists t_cloudbackup_state;");
            sQLiteDatabase.execSQL(f22416a);
            sQLiteDatabase.execSQL("drop table if exists t_temp_cloudbackup_state;");
            sQLiteDatabase.execSQL(f22417b);
            sQLiteDatabase.execSQL("drop table if exists t_other_device_record;");
            sQLiteDatabase.execSQL("create table if not exists t_other_device_record (deviceName TEXT,deviceId TEXT,size INTEGER default 0,lastbackupTime INTEGER default 0,isCurrent INTEGER default 0,deviceType INTEGER default 0,devDisplayName TEXT,deviceCategory TEXT,backupDeviceId TEXT,data1 TEXT, data2 TEXT, data3 TEXT, data4 TEXT, data5 TEXT,terminalType TEXT);");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        C11839m.m70688i("CloudBackupTagsDBHelper", "onUpgrade, oldVersion = " + i10 + ", newVersion = " + i11);
        if (i10 < 2) {
            C11839m.m70688i("CloudBackupTagsDBHelper", "cloud backup tags database upgrade. oldVersion = " + i10);
            sQLiteDatabase.execSQL("create table if not exists backup_options_status(appId text not null,name text,parent text not null,isDisable integer not null default 0,switchStatus integer not null default 0,isBackupData integer not null default 0,isDataEnable integer not null default 0,apkSize integer,dataSize integer,count integer,operateTime INTEGER default 0,data1 text, data2 text, data3 text,primary key (appId));");
        }
        if (i10 < 3) {
            if (m29575e("%localNeedSpace INTEGER%", "backup_tags", sQLiteDatabase)) {
                C11839m.m70688i("CloudBackupTagsDBHelper", "localNeedSpace column is exist");
            } else {
                sQLiteDatabase.execSQL("Alter table backup_tags add column localNeedSpace INTEGER default 0");
            }
            sQLiteDatabase.execSQL("create table if not exists backup_record_infos (backupId TEXT,startTime INTEGER not null,endTime INTEGER default 0,backupStatus INTEGER default 0,uploadSize INTEGER default 0,uploadDuration INTEGER default 0,backupType INTEGER not null,lastUploadSpeedFlag INTEGER default 0,data1 TEXT, data2 TEXT, data3 TEXT,primary key (startTime));");
        }
        if (i10 < 4) {
            sQLiteDatabase.execSQL(f22416a);
        }
        if (i10 < 5) {
            m29574d(sQLiteDatabase, "create table if not exists backup_options_status(appId text not null,name text,parent text not null,isDisable integer not null default 0,switchStatus integer not null default 0,isBackupData integer not null default 0,isDataEnable integer not null default 0,apkSize integer,dataSize integer,count integer,operateTime INTEGER default 0,data1 text, data2 text, data3 text,primary key (appId));");
            if (m29575e("%operateTime INTEGER%", "backup_options_status", sQLiteDatabase)) {
                C11839m.m70688i("CloudBackupTagsDBHelper", "operatetime column is exist");
            } else {
                sQLiteDatabase.execSQL("Alter table backup_options_status add column operateTime INTEGER default 0");
            }
        }
        if (i10 < 6) {
            m29572b(sQLiteDatabase);
            sQLiteDatabase.execSQL("create table if not exists t_other_device_record (deviceName TEXT,deviceId TEXT,size INTEGER default 0,lastbackupTime INTEGER default 0,isCurrent INTEGER default 0,deviceType INTEGER default 0,devDisplayName TEXT,deviceCategory TEXT,backupDeviceId TEXT,data1 TEXT, data2 TEXT, data3 TEXT, data4 TEXT, data5 TEXT,terminalType TEXT);");
            sQLiteDatabase.execSQL("alter table t_cloudbackup_state rename to t_cloudbackup_state_tmp;");
            sQLiteDatabase.execSQL(f22416a);
            sQLiteDatabase.execSQL("replace into t_cloudbackup_state select * from t_cloudbackup_state_tmp");
            sQLiteDatabase.execSQL("drop table if exists t_cloudbackup_state_tmp");
        }
        if (i10 < 7) {
            sQLiteDatabase.execSQL("create table if not exists t_other_device_record (deviceName TEXT,deviceId TEXT,size INTEGER default 0,lastbackupTime INTEGER default 0,isCurrent INTEGER default 0,deviceType INTEGER default 0,devDisplayName TEXT,deviceCategory TEXT,backupDeviceId TEXT,data1 TEXT, data2 TEXT, data3 TEXT, data4 TEXT, data5 TEXT,terminalType TEXT);");
            m29572b(sQLiteDatabase);
            m29573c(sQLiteDatabase);
        }
        if (i10 < 8) {
            sQLiteDatabase.execSQL(f22417b);
        }
        if (i10 < 9) {
            if (m29575e("%localNeedSpace INTEGER%", "backup_tags", sQLiteDatabase)) {
                C11839m.m70688i("CloudBackupTagsDBHelper", "localNeedSpace column is exist");
            } else {
                C11839m.m70688i("CloudBackupTagsDBHelper", "localNeedSpace column is not exist");
                m29574d(sQLiteDatabase, "Alter table backup_tags add column localNeedSpace INTEGER default 0");
            }
            m29574d(sQLiteDatabase, "create table if not exists backup_record_infos (backupId TEXT,startTime INTEGER not null,endTime INTEGER default 0,backupStatus INTEGER default 0,uploadSize INTEGER default 0,uploadDuration INTEGER default 0,backupType INTEGER not null,lastUploadSpeedFlag INTEGER default 0,data1 TEXT, data2 TEXT, data3 TEXT,primary key (startTime));");
            if (m29575e("%data6 TEXT%", "backup_tags", sQLiteDatabase)) {
                C11839m.m70688i("CloudBackupTagsDBHelper", "data6 column is exist");
            } else {
                C11839m.m70688i("CloudBackupTagsDBHelper", "data6 column is not exist");
                m29574d(sQLiteDatabase, "Alter table backup_tags add column data6 TEXT");
            }
        }
        if (i10 < 10) {
            m29576f(sQLiteDatabase);
        }
        if (i10 < 11) {
            if (m29575e("%terminalType TEXT%", "t_other_device_record", sQLiteDatabase)) {
                C11839m.m70688i("CloudBackupTagsDBHelper", "TERMINAL_TYPE column is exist");
            } else {
                C11839m.m70688i("CloudBackupTagsDBHelper", "TERMINAL_TYPE column is not exist");
                sQLiteDatabase.execSQL("ALTER TABLE t_other_device_record ADD COLUMN terminalType TEXT");
            }
        }
        if (i10 < 12) {
            m29578h(sQLiteDatabase);
        }
    }
}
