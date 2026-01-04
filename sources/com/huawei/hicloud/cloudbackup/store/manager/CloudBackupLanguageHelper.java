package com.huawei.hicloud.cloudbackup.store.manager;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import p514o9.C11839m;

/* loaded from: classes6.dex */
public class CloudBackupLanguageHelper extends SQLiteOpenHelper {
    public CloudBackupLanguageHelper(Context context) {
        super(context, "cloudbackup_language.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS backup_app_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        super.onDowngrade(sQLiteDatabase, i10, i11);
        sQLiteDatabase.execSQL("drop table if exists backup_app_language");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS backup_app_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 < i11) {
            C11839m.m70688i("CloudBackupLanguageHelper", "cloud backup language database upgrade. oldVersion = " + i10);
        }
    }
}
