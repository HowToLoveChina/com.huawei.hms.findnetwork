package p692uw;

import java.io.ObjectStreamException;
import java.io.Serializable;
import p824yw.InterfaceC14049a;
import p824yw.InterfaceC14051c;

/* renamed from: uw.c */
/* loaded from: classes9.dex */
public abstract class AbstractC13260c implements InterfaceC14049a, Serializable {

    /* renamed from: g */
    public static final Object f59959g = a.f59966a;

    /* renamed from: a */
    public transient InterfaceC14049a f59960a;

    /* renamed from: b */
    public final Object f59961b;

    /* renamed from: c */
    public final Class f59962c;

    /* renamed from: d */
    public final String f59963d;

    /* renamed from: e */
    public final String f59964e;

    /* renamed from: f */
    public final boolean f59965f;

    /* renamed from: uw.c$a */
    public static class a implements Serializable {

        /* renamed from: a */
        public static final a f59966a = new a();

        private Object readResolve() throws ObjectStreamException {
            return f59966a;
        }
    }

    public AbstractC13260c(Object obj) {
        this(obj, null, null, null, false);
    }

    /* renamed from: c */
    public InterfaceC14049a m79661c() {
        InterfaceC14049a interfaceC14049a = this.f59960a;
        if (interfaceC14049a != null) {
            return interfaceC14049a;
        }
        InterfaceC14049a interfaceC14049aMo79662d = mo79662d();
        this.f59960a = interfaceC14049aMo79662d;
        return interfaceC14049aMo79662d;
    }

    /* renamed from: d */
    public abstract InterfaceC14049a mo79662d();

    /* renamed from: e */
    public Object m79663e() {
        return this.f59961b;
    }

    /* renamed from: f */
    public String m79664f() {
        return this.f59963d;
    }

    /* renamed from: g */
    public InterfaceC14051c m79665g() {
        Class cls = this.f59962c;
        if (cls == null) {
            return null;
        }
        return this.f59965f ? C13274q.m79692b(cls) : C13274q.m79691a(cls);
    }

    /* renamed from: h */
    public String m79666h() {
        return this.f59964e;
    }

    public AbstractC13260c() {
        this(f59959g);
    }

    public AbstractC13260c(Object obj, Class cls, String str, String str2, boolean z10) {
        this.f59961b = obj;
        this.f59962c = cls;
        this.f59963d = str;
        this.f59964e = str2;
        this.f59965f = z10;
    }
}
