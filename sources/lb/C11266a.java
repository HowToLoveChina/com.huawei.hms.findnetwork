package lb;

import android.content.Context;
import java.io.File;
import p015ak.C0213f;
import p475mb.C11435a;
import p514o9.C11839m;
import p616rk.C12515a;

/* renamed from: lb.a */
/* loaded from: classes3.dex */
public class C11266a {

    /* renamed from: a */
    public static C11266a f52888a;

    /* renamed from: b */
    public static final Object f52889b = new Object();

    /* renamed from: b */
    public static C11266a m67614b() {
        C11266a c11266a;
        synchronized (f52889b) {
            try {
                if (f52888a == null) {
                    f52888a = new C11266a();
                }
                c11266a = f52888a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c11266a;
    }

    /* renamed from: a */
    public void m67615a() {
        try {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                C11839m.m70687e("GuideInfoManager", "clearGuideH5InfoConfig context is null.");
                return;
            }
            File file = new File(contextM1377a.getFilesDir() + "/HiCloudOperPageHints.json");
            if (!file.exists()) {
                C11839m.m70688i("GuideInfoManager", "clearGuideH5InfoConfig file not exist");
            } else {
                if (file.delete()) {
                    return;
                }
                C11839m.m70687e("GuideInfoManager", "clearGuideH5InfoConfig deleteResult is false");
            }
        } catch (Exception e10) {
            C11839m.m70687e("GuideInfoManager", "clearGuideH5InfoConfig exception:" + e10.toString());
        }
    }

    /* renamed from: c */
    public void m67616c(String str) {
        C12515a.m75110o().m75172d(new C11435a(str));
    }
}
