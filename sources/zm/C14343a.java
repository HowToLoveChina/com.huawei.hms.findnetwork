package zm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.C1461a;

/* renamed from: zm.a */
/* loaded from: classes6.dex */
public class C14343a extends SQLiteOpenHelper {

    /* renamed from: a */
    public static final Object f63698a = new Object();

    /* renamed from: b */
    public static C14343a f63699b;

    public C14343a(Context context) {
        super(context, "FileManager.db", (SQLiteDatabase.CursorFactory) null, 5);
    }

    /* renamed from: b */
    public static C14343a m85521b(Context context) {
        synchronized (f63698a) {
            try {
                if (f63699b == null) {
                    f63699b = new C14343a(context);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f63699b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C1461a.m8357d("BookMarkDbHelper", "onCreate");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
