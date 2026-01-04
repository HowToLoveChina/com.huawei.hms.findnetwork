package p423ka;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import p514o9.C11839m;

/* renamed from: ka.a */
/* loaded from: classes3.dex */
public class C11021a extends SQLiteOpenHelper {

    /* renamed from: a */
    public static C11021a f52100a;

    public C11021a(Context context) {
        super(context, "clouddiskasset.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    /* renamed from: b */
    public static synchronized C11021a m66458b(Context context) {
        try {
            if (f52100a == null) {
                f52100a = new C11021a(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f52100a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C11839m.m70686d("AssetDBHelper", "AssetDBHelper onCreate.");
        sQLiteDatabase.execSQL("create table if not exists t_asset_status (localId text not null, assetId text not null, versionId text not null, fileId text not null, sha256 text not null, uploadType text, taskType text not null, layerId text, data1 text, data2 text, data3 text, tag text, contentVersion text, primary key (localId));");
        sQLiteDatabase.execSQL("create table if not exists t_slice_download_status (hmac text not null, path text not null, num integer default 0, object text not null, synckey text, taskId integer default 0, uuid text not null, status integer default 0, data1 text, data2 text, data3 text, unique (hmac, path, num asc));");
        sQLiteDatabase.execSQL("create index if not exists idx_hmac on t_slice_download_status(hmac)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        C11839m.m70686d("AssetDBHelper", "AssetDBHelper onDowngrade.");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        C11839m.m70686d("AssetDBHelper", "AssetDBHelper onUpgrade.");
        sQLiteDatabase.execSQL("drop table if exists t_asset_status");
        sQLiteDatabase.execSQL("drop table if exists t_slice_download_status");
        sQLiteDatabase.execSQL("create table if not exists t_asset_status (localId text not null, assetId text not null, versionId text not null, fileId text not null, sha256 text not null, uploadType text, taskType text not null, layerId text, data1 text, data2 text, data3 text, tag text, contentVersion text, primary key (localId));");
        sQLiteDatabase.execSQL("create table if not exists t_slice_download_status (hmac text not null, path text not null, num integer default 0, object text not null, synckey text, taskId integer default 0, uuid text not null, status integer default 0, data1 text, data2 text, data3 text, unique (hmac, path, num asc));");
        sQLiteDatabase.execSQL("create index if not exists idx_hmac on t_slice_download_status(hmac)");
    }
}
