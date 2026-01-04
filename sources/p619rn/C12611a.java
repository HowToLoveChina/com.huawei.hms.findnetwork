package p619rn;

import android.content.Context;
import android.content.SharedPreferences;
import p015ak.C0214f0;

/* renamed from: rn.a */
/* loaded from: classes6.dex */
public class C12611a {

    /* renamed from: b */
    public static C12611a f58024b;

    /* renamed from: a */
    public SharedPreferences f58025a;

    public C12611a(Context context) {
        this(context, 0);
    }

    /* renamed from: a */
    public static synchronized C12611a m76098a(Context context) {
        try {
            if (f58024b == null) {
                f58024b = new C12611a(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f58024b;
    }

    /* renamed from: b */
    public long m76099b() {
        SharedPreferences sharedPreferences = this.f58025a;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong("pushTokenTime", 0L);
    }

    /* renamed from: c */
    public boolean m76100c(long j10) {
        SharedPreferences sharedPreferences = this.f58025a;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putLong("pushTokenTime", j10);
        return editorEdit.commit();
    }

    public C12611a(Context context, int i10) {
        this.f58025a = C0214f0.m1382b(context, "push_info", i10);
    }
}
