package pw;

import com.huawei.phoneservice.faq.base.constants.TrackConstants$Events;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kw.C11177h;
import p692uw.C13267j;
import p720vw.AbstractC13499c;
import p720vw.C13498b;

/* renamed from: pw.a */
/* loaded from: classes9.dex */
public class C12239a {

    /* renamed from: pw.a$a */
    public static final class a {

        /* renamed from: a */
        public static final a f56626a = new a();

        /* renamed from: b */
        public static final Method f56627b;

        /* renamed from: c */
        public static final Method f56628c;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            C13267j.m79676d(methods, "throwableMethods");
            int length = methods.length;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                method = null;
                if (i11 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i11];
                if (C13267j.m79673a(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    C13267j.m79676d(parameterTypes, "it.parameterTypes");
                    if (C13267j.m79673a(C11177h.m67153m(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i11++;
            }
            f56627b = method2;
            int length2 = methods.length;
            while (true) {
                if (i10 >= length2) {
                    break;
                }
                Method method3 = methods[i10];
                if (C13267j.m79673a(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i10++;
            }
            f56628c = method;
        }
    }

    /* renamed from: a */
    public void mo73439a(Throwable th2, Throwable th3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13267j.m79677e(th2, "cause");
        C13267j.m79677e(th3, TrackConstants$Events.EXCEPTION);
        Method method = a.f56627b;
        if (method != null) {
            method.invoke(th2, th3);
        }
    }

    /* renamed from: b */
    public AbstractC13499c mo73440b() {
        return new C13498b();
    }
}
