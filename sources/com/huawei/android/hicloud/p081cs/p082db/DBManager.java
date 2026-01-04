package com.huawei.android.hicloud.p081cs.p082db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import p015ak.C0213f;
import p514o9.C11839m;
import p637s9.C12765a;
import p673u9.C13136a;
import p673u9.C13139d;
import p673u9.C13140e;
import p673u9.C13141f;
import p767x9.C13735d;

/* loaded from: classes3.dex */
public class DBManager {

    /* renamed from: a */
    public static volatile SQLiteDatabase f12145a;

    public static class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            super(context, "cs.db", (SQLiteDatabase.CursorFactory) null, 2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
            C11839m.m70686d("DBHelper", "DBHelper onCreate.");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_backup_status (id INTEGER DEFAULT 0,hash1 TEXT NOT NULL,hash2 TEXT NOT NULL,path TEXT NOT NULL,size INTEGER NOT NULL,status INTEGER DEFAULT 0,createTime INTEGER NOT NULL,updateTime INTEGER NOT NULL,slice INTEGER DEFAULT 0,type INTEGER DEFAULT 0,version TEXT, sliceSize INTEGER, hmac TEXT, efek TEXT, iv TEXT,data1 TEXT, data2 TEXT, data3 TEXT,UNIQUE(id, hash1));");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_id ON t_backup_status(id);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_backup_meta (id INTEGER DEFAULT 0,hash1 TEXT NOT NULL,path TEXT NOT NULL,sig TEXT NOT NULL,ts TEXT NOT NULL,createTime INTEGER NOT NULL,data1 TEXT, data2 TEXT, data3 TEXT,UNIQUE(id, hash1));");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_id ON t_backup_meta(id);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_backup_slice (id INTEGER DEFAULT 0,hash1 TEXT NOT NULL,num INTEGER DEFAULT 0,bucket TEXT NOT NULL,object TEXT NOT NULL,synckey TEXT NOT NULL,time TEXT NOT NULL,status INTEGER DEFAULT 0,createTime INTEGER NOT NULL,data1 TEXT, data2 TEXT, data3 TEXT,UNIQUE(id, hash1, num));");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_id ON t_backup_slice(id);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_restore_slice (id INTEGER DEFAULT 0,server TEXT NOT NULL,path TEXT NOT NULL,object TEXT NOT NULL,synckey TEXT NOT NULL,bucket TEXT NOT NULL,time TEXT NOT NULL,sliceSize INTEGER,num INTEGER DEFAULT 0,status INTEGER DEFAULT 0,taskId INTEGER DEFAULT -1,offset INTEGER DEFAULT 0,data1 TEXT, data2 TEXT, data3 TEXT,UNIQUE(id, server, path, num));");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_id ON t_backup_slice(id);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
            C11839m.m70686d("DBHelper", "DBHelper onDowngrade.");
            sQLiteDatabase.execSQL("DROP TABLE if exists t_backup_meta;");
            sQLiteDatabase.execSQL("DROP TABLE if exists t_backup_slice;");
            sQLiteDatabase.execSQL("DROP TABLE if exists t_backup_status;");
            sQLiteDatabase.execSQL("DROP TABLE if exists t_restore_slice;");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_backup_status (id INTEGER DEFAULT 0,hash1 TEXT NOT NULL,hash2 TEXT NOT NULL,path TEXT NOT NULL,size INTEGER NOT NULL,status INTEGER DEFAULT 0,createTime INTEGER NOT NULL,updateTime INTEGER NOT NULL,slice INTEGER DEFAULT 0,type INTEGER DEFAULT 0,version TEXT, sliceSize INTEGER, hmac TEXT, efek TEXT, iv TEXT,data1 TEXT, data2 TEXT, data3 TEXT,UNIQUE(id, hash1));");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_id ON t_backup_status(id);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_backup_meta (id INTEGER DEFAULT 0,hash1 TEXT NOT NULL,path TEXT NOT NULL,sig TEXT NOT NULL,ts TEXT NOT NULL,createTime INTEGER NOT NULL,data1 TEXT, data2 TEXT, data3 TEXT,UNIQUE(id, hash1));");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_id ON t_backup_meta(id);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_backup_slice (id INTEGER DEFAULT 0,hash1 TEXT NOT NULL,num INTEGER DEFAULT 0,bucket TEXT NOT NULL,object TEXT NOT NULL,synckey TEXT NOT NULL,time TEXT NOT NULL,status INTEGER DEFAULT 0,createTime INTEGER NOT NULL,data1 TEXT, data2 TEXT, data3 TEXT,UNIQUE(id, hash1, num));");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_id ON t_backup_slice(id);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_restore_slice (id INTEGER DEFAULT 0,server TEXT NOT NULL,path TEXT NOT NULL,object TEXT NOT NULL,synckey TEXT NOT NULL,bucket TEXT NOT NULL,time TEXT NOT NULL,sliceSize INTEGER,num INTEGER DEFAULT 0,status INTEGER DEFAULT 0,taskId INTEGER DEFAULT -1,offset INTEGER DEFAULT 0,data1 TEXT, data2 TEXT, data3 TEXT,UNIQUE(id, server, path, num));");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_id ON t_backup_slice(id);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
            C11839m.m70686d("DBHelper", "DBHelper onUpgrade.");
            if (i10 < 2) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_restore_slice (id INTEGER DEFAULT 0,server TEXT NOT NULL,path TEXT NOT NULL,object TEXT NOT NULL,synckey TEXT NOT NULL,bucket TEXT NOT NULL,time TEXT NOT NULL,sliceSize INTEGER,num INTEGER DEFAULT 0,status INTEGER DEFAULT 0,taskId INTEGER DEFAULT -1,offset INTEGER DEFAULT 0,data1 TEXT, data2 TEXT, data3 TEXT,UNIQUE(id, server, path, num));");
                sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_id ON t_backup_slice(id);");
            }
        }
    }

    /* renamed from: a */
    public static void m16248a() {
        C12765a.m76606f().m76608d();
        C13735d.m82531s().m82539i();
        new C13141f().m79039f();
        new C13136a().m79011f();
        new C13140e().m79033f();
        new C13139d().m79028g();
    }

    /* renamed from: b */
    public static synchronized SQLiteDatabase m16249b() {
        if (f12145a == null) {
            try {
                f12145a = new DBHelper(C0213f.m1378b()).getWritableDatabase();
            } catch (SQLiteException e10) {
                C11839m.m70687e("DBManager", "getDB() error, " + e10.getMessage());
            }
        }
        return f12145a;
    }
}
