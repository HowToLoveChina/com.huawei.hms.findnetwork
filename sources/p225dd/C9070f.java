package p225dd;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import p514o9.C11839m;

/* renamed from: dd.f */
/* loaded from: classes3.dex */
public class C9070f extends SQLiteOpenHelper {

    /* renamed from: a */
    public static C9070f f45816a;

    public C9070f(Context context) {
        super(context, "sync_asset.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    /* renamed from: b */
    public static synchronized C9070f m57240b(Context context) {
        try {
            if (f45816a == null) {
                f45816a = new C9070f(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f45816a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C11839m.m70686d("DatabaseHelper", "DatabaseHelper onCreate.");
        sQLiteDatabase.execSQL("create table if not exists t_sync_asset_status (id integer, databaseId integer, kind text not null, recordId text not null, length long, hash text not null, sha256 text not null, size integer, hash1 text not null, hash2 text not null, hmac text, efek text, iv text, sliceSize integer, version integer, status integer default 0, assetId text not null, versionId text not null, bucket text, data1 text, data2 text, data3 text, primary key (id));");
        sQLiteDatabase.execSQL("create table if not exists t_sync_slices_upload_status (id text not null, number integer default 0, objectId text not null, start integer, length integer, status integer default 0, time text not null, data1 text, data2 text, data3 text, data4 text, data5 text, unique (id, number asc));");
        sQLiteDatabase.execSQL("create index if not exists idx_id on t_sync_slices_upload_status(id)");
        sQLiteDatabase.execSQL("create table if not exists t_sync_slices_download_status (assetId text not null, path text not null, num integer default 0, sliceObjectId text not null, synckey text, taskId integer default 0, uuid text not null, status integer default 0, data1 text, data2 text, data3 text, unique (assetId, path, num asc));");
        sQLiteDatabase.execSQL("create index if not exists idx_assetId on t_sync_slices_download_status(assetId)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        C11839m.m70686d("DatabaseHelper", "DatabaseHelper onDowngrade.");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        C11839m.m70686d("DatabaseHelper", "DatabaseHelper onUpgrade.");
        sQLiteDatabase.execSQL("drop table if exists t_sync_asset_status");
        sQLiteDatabase.execSQL("drop table if exists t_sync_slices_upload_status");
        sQLiteDatabase.execSQL("drop table if exists t_sync_slices_download_status");
        sQLiteDatabase.execSQL("create table if not exists t_sync_asset_status (id integer, databaseId integer, kind text not null, recordId text not null, length long, hash text not null, sha256 text not null, size integer, hash1 text not null, hash2 text not null, hmac text, efek text, iv text, sliceSize integer, version integer, status integer default 0, assetId text not null, versionId text not null, bucket text, data1 text, data2 text, data3 text, primary key (id));");
        sQLiteDatabase.execSQL("create table if not exists t_sync_slices_upload_status (id text not null, number integer default 0, objectId text not null, start integer, length integer, status integer default 0, time text not null, data1 text, data2 text, data3 text, data4 text, data5 text, unique (id, number asc));");
        sQLiteDatabase.execSQL("create index if not exists idx_id on t_sync_slices_upload_status(id)");
        sQLiteDatabase.execSQL("create table if not exists t_sync_slices_download_status (assetId text not null, path text not null, num integer default 0, sliceObjectId text not null, synckey text, taskId integer default 0, uuid text not null, status integer default 0, data1 text, data2 text, data3 text, unique (assetId, path, num asc));");
        sQLiteDatabase.execSQL("create index if not exists idx_assetId on t_sync_slices_download_status(assetId)");
    }
}
