package p444l5;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import java.util.HashMap;
import java.util.HashSet;
import p006a5.AbstractC0048c;

/* renamed from: l5.k */
/* loaded from: classes.dex */
public class C11243k {

    /* renamed from: a */
    public Context f52809a;

    /* renamed from: b */
    public Cursor f52810b;

    /* renamed from: c */
    public AbstractC0048c f52811c;

    /* renamed from: d */
    public Handler.Callback f52812d;

    /* renamed from: e */
    public Object f52813e;

    /* renamed from: f */
    public HashSet<Integer> f52814f;

    /* renamed from: g */
    public HashMap<Integer, Long> f52815g;

    public C11243k(Context context, Cursor cursor, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        this.f52809a = context;
        this.f52810b = cursor;
        this.f52811c = abstractC0048c;
        this.f52812d = callback;
        this.f52813e = obj;
    }

    /* renamed from: a */
    public Handler.Callback m67568a() {
        return this.f52812d;
    }

    /* renamed from: b */
    public Object m67569b() {
        return this.f52813e;
    }

    /* renamed from: c */
    public Context m67570c() {
        return this.f52809a;
    }

    /* renamed from: d */
    public Cursor m67571d() {
        return this.f52810b;
    }

    /* renamed from: e */
    public HashMap<Integer, Long> m67572e() {
        return this.f52815g;
    }

    /* renamed from: f */
    public HashSet<Integer> m67573f() {
        return this.f52814f;
    }

    /* renamed from: g */
    public AbstractC0048c m67574g() {
        return this.f52811c;
    }

    /* renamed from: h */
    public void m67575h(Cursor cursor) {
        this.f52810b = cursor;
    }

    public C11243k(Handler.Callback callback, Object obj, HashSet<Integer> hashSet, HashMap<Integer, Long> map) {
        this.f52812d = callback;
        this.f52813e = obj;
        this.f52814f = hashSet;
        this.f52815g = map;
    }

    public C11243k(Context context, Handler.Callback callback, Object obj) {
        this.f52809a = context;
        this.f52812d = callback;
        this.f52813e = obj;
    }
}
