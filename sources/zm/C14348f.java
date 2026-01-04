package zm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.C1461a;

/* renamed from: zm.f */
/* loaded from: classes6.dex */
public class C14348f extends SQLiteOpenHelper {

    /* renamed from: a */
    public static final Object f63706a = new Object();

    /* renamed from: b */
    public static C14348f f63707b;

    public C14348f(Context context) {
        super(context, "CloudVideoOld.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    /* renamed from: b */
    public static C14348f m85529b(Context context) {
        synchronized (f63706a) {
            try {
                if (f63707b == null) {
                    f63707b = new C14348f(context);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f63707b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C1461a.m8357d("VideoOldDBHelper", "onCreate");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
