package p052cb;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.feedback.log.BaseLogger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import lu.AbstractC11346e;
import p015ak.C0209d;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p709vj.C13452e;
import p746wn.C13622a;
import yt.AbstractC14041b;
import yt.C14040a;

/* renamed from: cb.h */
/* loaded from: classes3.dex */
public class C1411h {

    /* renamed from: a */
    public static Map<String, Long> f6046a = new HashMap();

    /* renamed from: cb.h$b */
    public static class b extends AbstractC14041b {
        public b() {
        }

        @Override // yt.AbstractC14041b
        /* renamed from: b */
        public void mo8145b(Throwable th2) {
            C11839m.m70687e("ExceptionDetector", "main thread exception happened");
            m8150h(th2);
        }

        @Override // yt.AbstractC14041b
        /* renamed from: c */
        public void mo8146c(Thread thread, Throwable th2) {
            if (thread == Looper.getMainLooper().getThread()) {
                C11839m.m70687e("ExceptionDetector", "main thread exception happened");
            } else {
                C11839m.m70687e("ExceptionDetector", "sub thread exception happened");
            }
            m8150h(th2);
        }

        /* renamed from: e */
        public final String m8147e(String str) {
            if (str.length() <= 1000) {
                return str;
            }
            return str.substring(0, 1000) + "...";
        }

        /* renamed from: f */
        public final void m8148f(String str) {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07028"), "07028", "");
            c11060cM66626a.m66665u("0");
            c11060cM66626a.m66635A(str);
            if (!TextUtils.isEmpty(C13452e.m80781L().m80971t0())) {
                c11060cM66626a.m66644J(C13452e.m80781L().m80971t0());
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(1);
            linkedHashMap.put("errorReason", str);
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
        }

        /* renamed from: g */
        public final boolean m8149g(Throwable th2) {
            Long l10 = (Long) C1411h.f6046a.get(th2.getMessage());
            if (l10 == null) {
                C1411h.f6046a.put(th2.getMessage(), Long.valueOf(System.currentTimeMillis()));
                return false;
            }
            if (System.currentTimeMillis() - l10.longValue() < 43200000) {
                C11839m.m70689w("ExceptionDetector", "exception not report in interval");
                return true;
            }
            C1411h.f6046a.put(th2.getMessage(), Long.valueOf(System.currentTimeMillis()));
            return false;
        }

        /* renamed from: h */
        public final void m8150h(Throwable th2) {
            if (th2 == null) {
                C11839m.m70687e("ExceptionDetector", "throwable is null");
                return;
            }
            C11839m.m70687e("ExceptionDetector", "exception happened:" + th2.getMessage());
            if (m8149g(th2)) {
                return;
            }
            String strM8147e = m8147e(th2.getMessage() + System.lineSeparator() + AbstractC11346e.m68156b("", th2) + System.lineSeparator());
            BaseLogger.appendFeedBack("ExceptionDetector", strM8147e);
            m8148f(strM8147e);
        }
    }

    /* renamed from: b */
    public static void m8144b(Context context) {
        if (C0209d.m1309t1(context)) {
            C14040a.m84240o(context, new b());
        } else {
            C11839m.m70688i("ExceptionDetector", "not main process,do not init detector");
        }
    }
}
