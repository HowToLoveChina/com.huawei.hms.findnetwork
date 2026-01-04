package com.huawei.hicloud.p105db.helper;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.C1461a;

/* loaded from: classes6.dex */
public class LanguageDbHelper extends SQLiteOpenHelper {
    public LanguageDbHelper(Context context) {
        super(context, "hicloudlanguage_v2.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C1461a.m8357d("LanguageDbHelper", "onCreate");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS extra_notice_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        C1461a.m8359i("LanguageDbHelper", "onDowngrade oldVersion = " + i10 + " newVersion = " + i11);
        if (i10 > 2) {
            sQLiteDatabase.execSQL("DROP TABLE if exists extra_notice_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS extra_notice_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        C1461a.m8359i("LanguageDbHelper", "onUpgrade oldVersion = " + i10 + " newVersion = " + i11);
        if (i10 < 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS extra_notice_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
    }
}
