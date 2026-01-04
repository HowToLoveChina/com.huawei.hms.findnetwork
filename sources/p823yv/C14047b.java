package p823yv;

import java.lang.annotation.Annotation;
import p374iv.C10626e;
import p559pv.InterfaceC12231a;
import p789xv.C13867a;

/* renamed from: yv.b */
/* loaded from: classes9.dex */
public class C14047b {

    /* renamed from: a */
    public final String f62836a;

    /* renamed from: b */
    public final Annotation f62837b;

    /* renamed from: c */
    public final InterfaceC12231a f62838c;

    public C14047b(String str, Annotation annotation, Class<?> cls) throws C10626e {
        try {
            this.f62836a = str;
            this.f62837b = annotation;
            this.f62838c = (InterfaceC12231a) C13867a.m83203a(annotation.annotationType(), cls).newInstance();
        } catch (IllegalAccessException | InstantiationException e10) {
            throw new C10626e("create constraint meta data for field:" + str + " failed, " + e10.getMessage());
        }
    }

    /* renamed from: a */
    public <T> void m84255a(T t10) throws C10626e {
        InterfaceC12231a interfaceC12231a = this.f62838c;
        if (interfaceC12231a == null) {
            return;
        }
        interfaceC12231a.mo73425c(this.f62836a, this.f62837b);
        if (!this.f62838c.mo73424b(t10)) {
            throw new C10626e(this.f62838c.mo73423a());
        }
    }
}
