package p417k4;

import android.content.Context;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p469m4.C11402c;
import p484n4.C11632a;

/* renamed from: k4.e */
/* loaded from: classes.dex */
public final class C10986e {

    /* renamed from: a */
    public String f52049a;

    /* renamed from: c */
    public InputStream f52051c;

    /* renamed from: b */
    public C10983b f52050b = C10983b.f52043b;

    /* renamed from: d */
    public final Map<String, String> f52052d = new HashMap();

    /* renamed from: e */
    public final List<C11632a> f52053e = new ArrayList();

    /* renamed from: a */
    public InterfaceC10985d m66358a(Context context) {
        return new C11402c(context, this.f52049a, this.f52050b, this.f52051c, this.f52052d, this.f52053e, null);
    }

    /* renamed from: b */
    public C10986e m66359b(InputStream inputStream) {
        this.f52051c = inputStream;
        return this;
    }
}
