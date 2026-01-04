package zm;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import cn.C1461a;
import com.huawei.hicloud.p105db.helper.LanguageDbHelper;
import p015ak.C0213f;
import p015ak.C0214f0;

/* renamed from: zm.e */
/* loaded from: classes6.dex */
public class C14347e {

    /* renamed from: a */
    public static volatile SQLiteDatabase f63705a;

    /* renamed from: a */
    public static synchronized SQLiteDatabase m85528a() {
        if (f63705a == null) {
            try {
                f63705a = new LanguageDbHelper(C0214f0.m1381a(C0213f.m1377a(), "hicloudlanguage_v2.db")).getWritableDatabase();
            } catch (SQLiteException e10) {
                C1461a.m8358e("LanguageDbManager", "getDB() error, " + e10.getMessage());
            }
        }
        return f63705a;
    }
}
