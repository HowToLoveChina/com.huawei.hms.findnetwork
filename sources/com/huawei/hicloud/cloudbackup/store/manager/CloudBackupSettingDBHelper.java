package com.huawei.hicloud.cloudbackup.store.manager;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.script.SnapshotBackupMetaScript;
import p514o9.C11839m;

/* loaded from: classes6.dex */
public class CloudBackupSettingDBHelper extends SQLiteOpenHelper {
    public CloudBackupSettingDBHelper(Context context) {
        super(context, "cloudbackup_setting_v2.db", (SQLiteDatabase.CursorFactory) null, 4);
    }

    /* renamed from: b */
    public final void m29563b(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("create table if not exists app_file_info(id text not null,appId text not null,appType integer,appName text,appIcon text,listType integer,appVer text,appVersRegex text,emuiVersRegex text,devCompatible integer,include text,exclude text,wakeUpService text,skipWhenInsuff integer,supportOsVersRegex integer,osVersRegex text,priority integer,foregroundBackup integer,foregroundBackupTime text,minClientVersion integer,effectDevice text,effectPackage text,sdcardAcptErrNum integer,sdcardAcptErrRate integer,dataAcptErrNum integer,dataAcptErrRate integer,isSupportTwinApp integer,data1 text,data2 text,data3 text,data4 text,data5 text,data6 text,primary key(id))");
        sQLiteDatabase.execSQL("create index if not exists app_file_info_index on app_file_info(appId)");
        sQLiteDatabase.execSQL("create table if not exists cloud_restore_config(id text not null,appId text not null,appVer text not null,appVersRegex text,exclude text, data text,primary key(id))");
        sQLiteDatabase.execSQL("create index if not exists cloud_restore_config_index on cloud_restore_config(appId)");
        sQLiteDatabase.execSQL("create table if not exists cloud_backup_om_config(name text,value text)");
        sQLiteDatabase.execSQL("create table if not exists app_config_version(id text not null,date text not null,version integer,data text)");
        sQLiteDatabase.execSQL("create table if not exists app_restore_sequence(appId text not null,sequence text)");
        sQLiteDatabase.execSQL("create table if not exists app_restore_thread_sequence(appId text not null,sequence text)");
    }

    /* renamed from: c */
    public final boolean m29564c(String str, SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery(SnapshotBackupMetaScript.QUERY_OLD_SNAPSHOT_FLAG_BY_UNIQUE, new String[]{"app_file_info", str});
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    while (TextUtils.isEmpty(cursorRawQuery.getString(0))) {
                        if (!cursorRawQuery.moveToNext()) {
                        }
                    }
                    cursorRawQuery.close();
                    return true;
                }
            } catch (Exception e10) {
                C11839m.m70687e("CloudBackupSettingDBHelper", "catch exception when isExistColumn" + e10.getMessage());
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

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("create table if not exists settings (name text not null, value text not null, type integer not null, primary key(name));");
        m29563b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 > i11) {
            C11839m.m70688i("CloudBackupSettingDBHelper", "cloud backup setting database downgrade. oldVersion = " + i10);
            sQLiteDatabase.execSQL("drop table if exists settings;");
            sQLiteDatabase.execSQL("drop table if exists app_file_info");
            sQLiteDatabase.execSQL("drop table if exists cloud_restore_config");
            sQLiteDatabase.execSQL("drop table if exists cloud_backup_om_config");
            sQLiteDatabase.execSQL("drop table if exists app_config_version");
            sQLiteDatabase.execSQL("drop table if exists app_restore_sequence");
            sQLiteDatabase.execSQL("drop table if exists app_restore_thread_sequence");
            sQLiteDatabase.execSQL("create table if not exists settings (name text not null, value text not null, type integer not null, primary key(name));");
            m29563b(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        C11839m.m70688i("CloudBackupSettingDBHelper", "cloud backup setting database upgrade. oldVersion = " + i10);
        if (i10 < 2) {
            sQLiteDatabase.execSQL("drop table if exists app_file_info");
            sQLiteDatabase.execSQL("create table if not exists app_file_info(id text not null,appId text not null,appType integer,appName text,appIcon text,listType integer,appVer text,appVersRegex text,emuiVersRegex text,devCompatible integer,include text,exclude text,wakeUpService text,skipWhenInsuff integer,supportOsVersRegex integer,osVersRegex text,priority integer,foregroundBackup integer,foregroundBackupTime text,minClientVersion integer,effectDevice text,effectPackage text,sdcardAcptErrNum integer,sdcardAcptErrRate integer,dataAcptErrNum integer,dataAcptErrRate integer,isSupportTwinApp integer,data1 text,data2 text,data3 text,data4 text,data5 text,data6 text,primary key(id))");
            sQLiteDatabase.execSQL("create index if not exists app_file_info_index on app_file_info(appId)");
        }
        if (i10 < 3) {
            C11839m.m70688i("CloudBackupSettingDBHelper", "app_file_info add column ");
            if (!m29564c("%sdcardAcptErrNum INTEGER%", sQLiteDatabase)) {
                sQLiteDatabase.execSQL("Alter table app_file_info add column sdcardAcptErrNum INTEGER default -1");
            }
            if (!m29564c("%sdcardAcptErrRate INTEGER%", sQLiteDatabase)) {
                sQLiteDatabase.execSQL("Alter table app_file_info add column sdcardAcptErrRate INTEGER default -1");
            }
            if (!m29564c("%dataAcptErrNum INTEGER%", sQLiteDatabase)) {
                sQLiteDatabase.execSQL("Alter table app_file_info add column dataAcptErrNum INTEGER default -1");
            }
            if (!m29564c("%dataAcptErrRate INTEGER%", sQLiteDatabase)) {
                sQLiteDatabase.execSQL("Alter table app_file_info add column dataAcptErrRate INTEGER default -1");
            }
        }
        if (i10 < 4) {
            C11839m.m70688i("CloudBackupSettingDBHelper", "app_file_info add column isSupportTwinApp");
            if (m29564c("%isSupportTwinApp INTEGER%", sQLiteDatabase)) {
                return;
            }
            sQLiteDatabase.execSQL("Alter table app_file_info add column isSupportTwinApp INTEGER default -1");
        }
    }
}
