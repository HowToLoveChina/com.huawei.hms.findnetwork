package zm;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import cn.C1461a;
import com.huawei.hicloud.p105db.helper.CommonDbHelper;
import p015ak.C0213f;
import p015ak.C0214f0;

/* renamed from: zm.c */
/* loaded from: classes6.dex */
public class C14345c {

    /* renamed from: a */
    public static volatile SQLiteDatabase f63702a;

    /* renamed from: a */
    public static synchronized SQLiteDatabase m85526a() {
        if (f63702a == null) {
            try {
                f63702a = new CommonDbHelper(C0214f0.m1381a(C0213f.m1377a(), "hicloudcommon_v2.db")).getWritableDatabase();
            } catch (SQLiteException e10) {
                C1461a.m8358e("CommonDbManager", "getDB() error, " + e10.getMessage());
            }
        }
        return f63702a;
    }
}
