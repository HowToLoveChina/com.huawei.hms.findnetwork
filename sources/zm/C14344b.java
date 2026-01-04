package zm;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.C1461a;

/* renamed from: zm.b */
/* loaded from: classes6.dex */
public class C14344b extends SQLiteOpenHelper {

    /* renamed from: a */
    public static final Object f63700a = new Object();

    /* renamed from: b */
    public static C14344b f63701b;

    public C14344b(Context context) {
        super(context, "hidisk.db", (SQLiteDatabase.CursorFactory) null, 13);
    }

    /* renamed from: d */
    public static C14344b m85522d(Context context) {
        synchronized (f63700a) {
            try {
                if (f63701b == null) {
                    f63701b = new C14344b(context);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f63701b;
    }

    /* renamed from: b */
    public final void m85523b(SQLiteDatabase sQLiteDatabase, String str, String str2) throws SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE cloudFileInfo ADD " + str + " " + str2);
    }

    /* renamed from: c */
    public final void m85524c(SQLiteDatabase sQLiteDatabase, String str, String str2) throws SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE cloudUpload ADD " + str + " " + str2);
    }

    /* renamed from: e */
    public final void m85525e(SQLiteDatabase sQLiteDatabase) throws SQLException {
        m85523b(sQLiteDatabase, "recycledTime", "TEXT");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C1461a.m8357d("CloudHidiskDbHelper", "onCreate");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 >= 12) {
            if (i10 == 12) {
                m85525e(sQLiteDatabase);
                m85524c(sQLiteDatabase, "parentName", "TEXT");
                return;
            }
            return;
        }
        sQLiteDatabase.execSQL("DROP INDEX IF EXISTS index_uptime");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS picture");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS fileinfo");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS setFavoriteFailed");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS splititemlist");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS uploadlist");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloadlist");
    }
}
