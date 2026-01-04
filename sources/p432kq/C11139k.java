package p432kq;

import android.content.Context;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p557pq.C12204b;

/* renamed from: kq.k */
/* loaded from: classes8.dex */
public final class C11139k {

    /* renamed from: a */
    public static final ThreadPoolExecutor f52464a = new C12204b(1, 2, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), "Picker-Oauth-Pool");

    /* renamed from: b */
    public static final C11139k f52465b = new C11139k();

    /* renamed from: a */
    public static C11139k m66996a() {
        return f52465b;
    }

    /* renamed from: b */
    public void m66997b(Context context, String str, AbstractC11138j abstractC11138j, InterfaceC11137i interfaceC11137i) {
        new AsyncTaskC11132d(context, str, abstractC11138j, interfaceC11137i).executeOnExecutor(f52464a, abstractC11138j);
    }
}
