package zm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.C1461a;

/* renamed from: zm.d */
/* loaded from: classes6.dex */
public class C14346d extends SQLiteOpenHelper {

    /* renamed from: a */
    public static final Object f63703a = new Object();

    /* renamed from: b */
    public static C14346d f63704b;

    public C14346d(Context context) {
        super(context, "RecentAndSourceFile.db", (SQLiteDatabase.CursorFactory) null, 9);
    }

    /* renamed from: b */
    public static C14346d m85527b(Context context) {
        synchronized (f63703a) {
            try {
                if (f63704b == null) {
                    f63704b = new C14346d(context);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f63704b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C1461a.m8359i("FileManagerDbHelper", "onCreate");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
