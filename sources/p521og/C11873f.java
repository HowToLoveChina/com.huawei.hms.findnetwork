package p521og;

import android.content.Context;
import android.os.Handler;
import java.util.HashMap;
import java.util.Map;

/* renamed from: og.f */
/* loaded from: classes4.dex */
public class C11873f {

    /* renamed from: f */
    public static C11873f f54926f = new C11873f();

    /* renamed from: a */
    public Context f54927a;

    /* renamed from: b */
    public int f54928b;

    /* renamed from: c */
    public boolean f54929c = false;

    /* renamed from: d */
    public Handler f54930d;

    /* renamed from: e */
    public final Map<String, String> f54931e;

    public C11873f() {
        HashMap map = new HashMap();
        this.f54931e = map;
        map.put("activetrue", "");
    }

    /* renamed from: f */
    public static C11873f m71178f() {
        return f54926f;
    }

    /* renamed from: a */
    public void m71179a(boolean z10) {
        this.f54929c = z10;
    }

    /* renamed from: b */
    public Handler m71180b() {
        return this.f54930d;
    }

    /* renamed from: c */
    public Context m71181c() {
        return this.f54927a;
    }

    /* renamed from: d */
    public Map<String, String> m71182d() {
        return this.f54931e;
    }

    /* renamed from: e */
    public int m71183e() {
        return this.f54928b;
    }

    /* renamed from: g */
    public boolean m71184g() {
        return this.f54929c;
    }

    /* renamed from: h */
    public void m71185h(Handler handler) {
        this.f54930d = handler;
    }

    /* renamed from: i */
    public void m71186i(Context context) {
        if (context == null) {
            return;
        }
        this.f54927a = context;
    }

    /* renamed from: j */
    public void m71187j(int i10) {
        this.f54928b = i10;
    }
}
