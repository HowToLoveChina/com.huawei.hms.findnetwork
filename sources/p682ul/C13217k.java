package p682ul;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import p514o9.C11839m;

/* renamed from: ul.k */
/* loaded from: classes6.dex */
public class C13217k extends SQLiteOpenHelper {
    public C13217k(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C11839m.m70686d("CloudBackupMetadataDBHelper", "onCreate");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS snapshot_data (id INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT NOT NULL,root TEXT,name TEXT,type INTEGER,left INTEGER NOT NULL,right INTEGER NOT NULL,app_id TEXT NOT NULL,app_name TEXT NOT NULL,hash1 TEXT,hash2 TEXT,status INTEGER NOT NULL DEFAULT 0,size INTEGER,count INTEGER,cloud_path TEXT,file_id TEXT,assert_id TEXT,version_id TEXT,flag INTEGER,cloud_size INTEGER,cloud_hash TEXT,cloud_encoded INTEGER,date_create INTEGER,date_modify INTEGER,date_invalid INTEGER,date_taken INTEGER,extend TEXT,data1 TEXT,data2 TEXT,data3 TEXT,data4 TEXT,data5 TEXT,data6 TEXT,UNIQUE(data, root, app_id));");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_data ON snapshot_data(data);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_difference_packet (id INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT NOT NULL,root TEXT,name TEXT,type TEXT,app_id TEXT,hash1 TEXT,hash2 TEXT,status INTEGER NOT NULL DEFAULT 0,size INTEGER,file_id TEXT,assert_id TEXT,version_id TEXT,flag INTEGER,idex INTEGER,source_file TEXT,source_hash TEXT,backupid TEXT,isvalid INTEGER NOT NULL DEFAULT 0,cloud_size INTEGER,cloud_hash TEXT,cloud_encoded INTEGER,date_create INTEGER,date_modify INTEGER,date_invalid INTEGER,date_taken INTEGER,extend TEXT,data1 TEXT,data2 TEXT,data3 TEXT,data4 TEXT,data5 TEXT,data6 TEXT,UNIQUE(data, root, app_id));");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_data ON t_difference_packet(data);");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_snapshot_status ON snapshot_data(status);");
        sQLiteDatabase.execSQL("create table if not exists t_asset_status(id text not null primary key, length integer, hash1 text not null, hash2 text not null, hmac text, status integer default 0, kindId text, recordId text, assetId text, versionId text, sliceSize integer, data1 text, data2 text, data3 text, data4 text, data5 text);");
        sQLiteDatabase.execSQL("create table if not exists t_asset_slice(id text not null, number integer, objectId text not null, start integer, length integer, status integer default 0, data1 text, data2 text, data3 text, data4 text, data5 text,unique(id, number));");
        sQLiteDatabase.execSQL("create index if not exists idx_asset_id on t_asset_status(id);");
        sQLiteDatabase.execSQL("create index if not exists idx_slice_id on t_asset_slice(id);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_recovery_meta_info (id INTEGER PRIMARY KEY AUTOINCREMENT,file_id TEXT,app_id TEXT,cipher TEXT,fek_mac TEXT,hash1 TEXT,hash2 TEXT,assert_id TEXT,version_id TEXT,data1 TEXT,data2 TEXT,data3 TEXT,data4 TEXT,data5 TEXT,data6 TEXT,UNIQUE(file_id));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_backup_module_info (id INTEGER PRIMARY KEY AUTOINCREMENT,app_id TEXT NOT NULL,uri TEXT NOT NULL,is_need_backup_uri INTEGER DEFAULT 1,is_need_count_uri INTEGER,prepare_count INTEGER DEFAULT 0,count INTEGER DEFAULT 0,error_info TEXT,data1 TEXT, data2 TEXT, data3 TEXT, data4 TEXT, data5 TEXT, data6 TEXT,UNIQUE(uri));");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 > i11) {
            C11839m.m70688i("CloudBackupMetadataDBHelper", "snapshot database downgrade. oldVersion = " + i10);
            sQLiteDatabase.execSQL("drop table if exists snapshot_data;");
            sQLiteDatabase.execSQL("drop table if exists t_asset_status;");
            sQLiteDatabase.execSQL("drop table if exists t_asset_slice;");
            sQLiteDatabase.execSQL("drop table if exists t_difference_packet;");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_backup_module_info;");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS snapshot_data (id INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT NOT NULL,root TEXT,name TEXT,type INTEGER,left INTEGER NOT NULL,right INTEGER NOT NULL,app_id TEXT NOT NULL,app_name TEXT NOT NULL,hash1 TEXT,hash2 TEXT,status INTEGER NOT NULL DEFAULT 0,size INTEGER,count INTEGER,cloud_path TEXT,file_id TEXT,assert_id TEXT,version_id TEXT,flag INTEGER,cloud_size INTEGER,cloud_hash TEXT,cloud_encoded INTEGER,date_create INTEGER,date_modify INTEGER,date_invalid INTEGER,date_taken INTEGER,extend TEXT,data1 TEXT,data2 TEXT,data3 TEXT,data4 TEXT,data5 TEXT,data6 TEXT,UNIQUE(data, root, app_id));");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_data ON snapshot_data(data);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_difference_packet (id INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT NOT NULL,root TEXT,name TEXT,type TEXT,app_id TEXT,hash1 TEXT,hash2 TEXT,status INTEGER NOT NULL DEFAULT 0,size INTEGER,file_id TEXT,assert_id TEXT,version_id TEXT,flag INTEGER,idex INTEGER,source_file TEXT,source_hash TEXT,backupid TEXT,isvalid INTEGER NOT NULL DEFAULT 0,cloud_size INTEGER,cloud_hash TEXT,cloud_encoded INTEGER,date_create INTEGER,date_modify INTEGER,date_invalid INTEGER,date_taken INTEGER,extend TEXT,data1 TEXT,data2 TEXT,data3 TEXT,data4 TEXT,data5 TEXT,data6 TEXT,UNIQUE(data, root, app_id));");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_data ON t_difference_packet(data);");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_snapshot_status ON snapshot_data(status);");
            sQLiteDatabase.execSQL("create table if not exists t_asset_status(id text not null primary key, length integer, hash1 text not null, hash2 text not null, hmac text, status integer default 0, kindId text, recordId text, assetId text, versionId text, sliceSize integer, data1 text, data2 text, data3 text, data4 text, data5 text);");
            sQLiteDatabase.execSQL("create table if not exists t_asset_slice(id text not null, number integer, objectId text not null, start integer, length integer, status integer default 0, data1 text, data2 text, data3 text, data4 text, data5 text,unique(id, number));");
            sQLiteDatabase.execSQL("create index if not exists idx_asset_id on t_asset_status(id);");
            sQLiteDatabase.execSQL("create index if not exists idx_slice_id on t_asset_slice(id);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_recovery_meta_info (id INTEGER PRIMARY KEY AUTOINCREMENT,file_id TEXT,app_id TEXT,cipher TEXT,fek_mac TEXT,hash1 TEXT,hash2 TEXT,assert_id TEXT,version_id TEXT,data1 TEXT,data2 TEXT,data3 TEXT,data4 TEXT,data5 TEXT,data6 TEXT,UNIQUE(file_id));");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_backup_module_info (id INTEGER PRIMARY KEY AUTOINCREMENT,app_id TEXT NOT NULL,uri TEXT NOT NULL,is_need_backup_uri INTEGER DEFAULT 1,is_need_count_uri INTEGER,prepare_count INTEGER DEFAULT 0,count INTEGER DEFAULT 0,error_info TEXT,data1 TEXT, data2 TEXT, data3 TEXT, data4 TEXT, data5 TEXT, data6 TEXT,UNIQUE(uri));");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 < i11) {
            C11839m.m70688i("CloudBackupMetadataDBHelper", "snapshot database upgrade. oldVersion = " + i10);
        }
    }
}
