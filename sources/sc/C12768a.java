package sc;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import p514o9.C11839m;
import p675uc.C13153a;

/* renamed from: sc.a */
/* loaded from: classes3.dex */
public class C12768a {

    /* renamed from: a */
    public static final Object f58427a = new Object();

    /* renamed from: a */
    public static void m76624a(Context context) {
        synchronized (f58427a) {
            C13153a.m79116b(context);
            C13153a.m79115a(context);
            m76626c();
            m76625b();
        }
    }

    /* renamed from: b */
    public static void m76625b() {
        C11839m.m70688i("ClearAllDBInfo", "begin clearStatusInfo");
        new C12776i().m76680f();
    }

    /* renamed from: c */
    public static void m76626c() {
        try {
            new C12770c().m76638f();
            new C12771d().m76646h();
            new C12773f().m76666h();
            new C12772e().m76655i();
        } catch (SQLiteException unused) {
            C11839m.m70687e("ClearAllDBInfo", "deleteTag: clearAllInfo SQLiteException");
        } catch (Exception unused2) {
            C11839m.m70687e("ClearAllDBInfo", "deleteTag: clearAllInfo Exception");
        }
    }
}
