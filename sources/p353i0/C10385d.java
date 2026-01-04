package p353i0;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* renamed from: i0.d */
/* loaded from: classes.dex */
public final class C10385d {

    /* renamed from: a */
    public final b f50173a;

    /* renamed from: i0.d$a */
    public static final class a implements b {

        /* renamed from: a */
        public final InputContentInfo f50174a;

        public a(Object obj) {
            this.f50174a = (InputContentInfo) obj;
        }

        @Override // p353i0.C10385d.b
        /* renamed from: a */
        public Uri mo63850a() {
            return this.f50174a.getContentUri();
        }

        @Override // p353i0.C10385d.b
        /* renamed from: b */
        public void mo63851b() {
            this.f50174a.requestPermission();
        }

        @Override // p353i0.C10385d.b
        /* renamed from: c */
        public Uri mo63852c() {
            return this.f50174a.getLinkUri();
        }

        @Override // p353i0.C10385d.b
        /* renamed from: d */
        public Object mo63853d() {
            return this.f50174a;
        }

        @Override // p353i0.C10385d.b
        public ClipDescription getDescription() {
            return this.f50174a.getDescription();
        }
    }

    /* renamed from: i0.d$b */
    public interface b {
        /* renamed from: a */
        Uri mo63850a();

        /* renamed from: b */
        void mo63851b();

        /* renamed from: c */
        Uri mo63852c();

        /* renamed from: d */
        Object mo63853d();

        ClipDescription getDescription();
    }

    public C10385d(b bVar) {
        this.f50173a = bVar;
    }

    /* renamed from: f */
    public static C10385d m63844f(Object obj) {
        if (obj == null) {
            return null;
        }
        return new C10385d(new a(obj));
    }

    /* renamed from: a */
    public Uri m63845a() {
        return this.f50173a.mo63850a();
    }

    /* renamed from: b */
    public ClipDescription m63846b() {
        return this.f50173a.getDescription();
    }

    /* renamed from: c */
    public Uri m63847c() {
        return this.f50173a.mo63852c();
    }

    /* renamed from: d */
    public void m63848d() {
        this.f50173a.mo63851b();
    }

    /* renamed from: e */
    public Object m63849e() {
        return this.f50173a.mo63853d();
    }
}
