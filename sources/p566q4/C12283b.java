package p566q4;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;

/* renamed from: q4.b */
/* loaded from: classes.dex */
public class C12283b extends SQLiteOpenHelper {
    public C12283b(Context context, String str) {
        super(new C12282a(context, m73808c(context)), m73807b(str), (SQLiteDatabase.CursorFactory) null, 1);
    }

    /* renamed from: b */
    public static String m73807b(String str) {
        return str + "_Cache.db";
    }

    /* renamed from: c */
    public static String m73808c(Context context) {
        if (context == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(2048);
        sb2.append(context.getFilesDir());
        sb2.append(File.separator);
        sb2.append("mediacache");
        return sb2.toString();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.execSQL("CREATE TABLE normal_file (_id INTEGER PRIMARY KEY AUTOINCREMENT, filepath TEXT NOT NULL, filesize INTEGER NOT NULL, last_modified INTEGER, duration INTEGER, bucket_id TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE small_file (_id INTEGER PRIMARY KEY AUTOINCREMENT, filepath TEXT NOT NULL, filesize INTEGER NOT NULL, last_modified INTEGER, duration INTEGER, bucket_id TEXT)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
