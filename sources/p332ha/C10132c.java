package p332ha;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import p031b7.C1120a;

/* renamed from: ha.c */
/* loaded from: classes3.dex */
public class C10132c extends SQLiteOpenHelper {

    /* renamed from: a */
    public static C10132c f49396a;

    public C10132c(Context context) {
        super(context, "asset.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    /* renamed from: c */
    public static synchronized C10132c m63105c(Context context) {
        try {
            if (f49396a == null) {
                f49396a = new C10132c(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f49396a;
    }

    /* renamed from: b */
    public void m63106b(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C1120a.m6675d("DatabaseHelper", "DatabaseHelper clear.");
        if (sQLiteDatabase == null) {
            C1120a.m6678w("DatabaseHelper", "db is null.");
            return;
        }
        try {
            sQLiteDatabase.execSQL("delete from t_asset_status");
            sQLiteDatabase.execSQL("delete from t_slices_upload_status");
            sQLiteDatabase.execSQL("delete from t_slice_download_status");
        } catch (Exception e10) {
            C1120a.m6678w("DatabaseHelper", "exec clear sql Exception：" + e10.toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C1120a.m6675d("DatabaseHelper", "DatabaseHelper onCreate.");
        sQLiteDatabase.execSQL("create table if not exists t_asset_status (localID text not null, sha256 text not null, size integer, hmac text, efek text, iv text, sliceSize integer, version integer, status integer default 0, bucket text, data1 text, data2 text, data3 text, assetID text not null, versionId text not null, mediaId text not null, primary key (localID));");
        sQLiteDatabase.execSQL("create table if not exists t_slices_upload_status (id text not null, num integer default 0, object text not null, synckey text, time text not null, status integer default 0, data1 text, data2 text, data3 text, unique (id, num asc));");
        sQLiteDatabase.execSQL("create index if not exists idx_id on t_slices_upload_status(id)");
        sQLiteDatabase.execSQL("create table if not exists t_slice_download_status (hmac text not null, path text not null, num integer default 0, object text not null, synckey text, taskId integer default 0, uuid text not null, status integer default 0, data1 text, data2 text, data3 text, unique (hmac, path, num asc));");
        sQLiteDatabase.execSQL("create index if not exists idx_hmac on t_slice_download_status(hmac)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        C1120a.m6675d("DatabaseHelper", "DatabaseHelper onDowngrade.");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        C1120a.m6675d("DatabaseHelper", "DatabaseHelper onUpgrade.");
        sQLiteDatabase.execSQL("drop table if exists t_asset_status");
        sQLiteDatabase.execSQL("drop table if exists t_slices_upload_status");
        sQLiteDatabase.execSQL("drop table if exists t_slice_download_status");
        sQLiteDatabase.execSQL("create table if not exists t_asset_status (localID text not null, sha256 text not null, size integer, hmac text, efek text, iv text, sliceSize integer, version integer, status integer default 0, bucket text, data1 text, data2 text, data3 text, assetID text not null, versionId text not null, mediaId text not null, primary key (localID));");
        sQLiteDatabase.execSQL("create table if not exists t_slices_upload_status (id text not null, num integer default 0, object text not null, synckey text, time text not null, status integer default 0, data1 text, data2 text, data3 text, unique (id, num asc));");
        sQLiteDatabase.execSQL("create index if not exists idx_id on t_slices_upload_status(id)");
        sQLiteDatabase.execSQL("create table if not exists t_slice_download_status (hmac text not null, path text not null, num integer default 0, object text not null, synckey text, taskId integer default 0, uuid text not null, status integer default 0, data1 text, data2 text, data3 text, unique (hmac, path, num asc));");
        sQLiteDatabase.execSQL("create index if not exists idx_hmac on t_slice_download_status(hmac)");
    }
}
