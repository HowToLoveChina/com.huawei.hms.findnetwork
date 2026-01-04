package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p243e0.C9373h;
import p438l.C11208b;

/* renamed from: androidx.emoji2.text.e */
/* loaded from: classes.dex */
public class C0688e {

    /* renamed from: n */
    public static final Object f3594n = new Object();

    /* renamed from: o */
    public static final Object f3595o = new Object();

    /* renamed from: p */
    public static volatile C0688e f3596p;

    /* renamed from: b */
    public final Set<e> f3598b;

    /* renamed from: e */
    public final b f3601e;

    /* renamed from: f */
    public final g f3602f;

    /* renamed from: g */
    public final boolean f3603g;

    /* renamed from: h */
    public final boolean f3604h;

    /* renamed from: i */
    public final int[] f3605i;

    /* renamed from: j */
    public final boolean f3606j;

    /* renamed from: k */
    public final int f3607k;

    /* renamed from: l */
    public final int f3608l;

    /* renamed from: m */
    public final d f3609m;

    /* renamed from: a */
    public final ReadWriteLock f3597a = new ReentrantReadWriteLock();

    /* renamed from: c */
    public volatile int f3599c = 3;

    /* renamed from: d */
    public final Handler f3600d = new Handler(Looper.getMainLooper());

    /* renamed from: androidx.emoji2.text.e$a */
    public static final class a extends b {

        /* renamed from: b */
        public volatile C0691h f3610b;

        /* renamed from: c */
        public volatile C0696m f3611c;

        /* renamed from: androidx.emoji2.text.e$a$a */
        public class C14407a extends h {
            public C14407a() {
            }

            @Override // androidx.emoji2.text.C0688e.h
            /* renamed from: a */
            public void mo4199a(Throwable th2) {
                a.this.f3613a.m4232m(th2);
            }

            @Override // androidx.emoji2.text.C0688e.h
            /* renamed from: b */
            public void mo4200b(C0696m c0696m) {
                a.this.m4244d(c0696m);
            }
        }

        public a(C0688e c0688e) {
            super(c0688e);
        }

        @Override // androidx.emoji2.text.C0688e.b
        /* renamed from: a */
        public void mo4241a() {
            try {
                this.f3613a.f3602f.mo4196a(new C14407a());
            } catch (Throwable th2) {
                this.f3613a.m4232m(th2);
            }
        }

        @Override // androidx.emoji2.text.C0688e.b
        /* renamed from: b */
        public CharSequence mo4242b(CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
            return this.f3610b.m4266h(charSequence, i10, i11, i12, z10);
        }

        @Override // androidx.emoji2.text.C0688e.b
        /* renamed from: c */
        public void mo4243c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f3611c.m4300e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f3613a.f3603g);
        }

        /* renamed from: d */
        public void m4244d(C0696m c0696m) {
            if (c0696m == null) {
                this.f3613a.m4232m(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f3611c = c0696m;
            C0696m c0696m2 = this.f3611c;
            i iVar = new i();
            d dVar = this.f3613a.f3609m;
            C0688e c0688e = this.f3613a;
            this.f3610b = new C0691h(c0696m2, iVar, dVar, c0688e.f3604h, c0688e.f3605i);
            this.f3613a.m4233n();
        }
    }

    /* renamed from: androidx.emoji2.text.e$b */
    public static class b {

        /* renamed from: a */
        public final C0688e f3613a;

        public b(C0688e c0688e) {
            this.f3613a = c0688e;
        }

        /* renamed from: a */
        public void mo4241a() {
            throw null;
        }

        /* renamed from: b */
        public CharSequence mo4242b(CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
            throw null;
        }

        /* renamed from: c */
        public void mo4243c(EditorInfo editorInfo) {
            throw null;
        }
    }

    /* renamed from: androidx.emoji2.text.e$c */
    public static abstract class c {

        /* renamed from: a */
        public final g f3614a;

        /* renamed from: b */
        public boolean f3615b;

        /* renamed from: c */
        public boolean f3616c;

        /* renamed from: d */
        public int[] f3617d;

        /* renamed from: e */
        public Set<e> f3618e;

        /* renamed from: f */
        public boolean f3619f;

        /* renamed from: g */
        public int f3620g = -16711936;

        /* renamed from: h */
        public int f3621h = 0;

        /* renamed from: i */
        public d f3622i = new C0687d();

        public c(g gVar) {
            C9373h.m58746g(gVar, "metadataLoader cannot be null.");
            this.f3614a = gVar;
        }

        /* renamed from: a */
        public final g m4245a() {
            return this.f3614a;
        }

        /* renamed from: b */
        public c m4246b(int i10) {
            this.f3621h = i10;
            return this;
        }
    }

    /* renamed from: androidx.emoji2.text.e$d */
    public interface d {
        /* renamed from: a */
        boolean mo4219a(CharSequence charSequence, int i10, int i11, int i12);
    }

    /* renamed from: androidx.emoji2.text.e$e */
    public static abstract class e {
        /* renamed from: a */
        public void mo2835a(Throwable th2) {
        }

        /* renamed from: b */
        public void mo2836b() {
        }
    }

    /* renamed from: androidx.emoji2.text.e$f */
    public static class f implements Runnable {

        /* renamed from: a */
        public final List<e> f3623a;

        /* renamed from: b */
        public final Throwable f3624b;

        /* renamed from: c */
        public final int f3625c;

        public f(e eVar, int i10) {
            this(Arrays.asList((e) C9373h.m58746g(eVar, "initCallback cannot be null")), i10, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f3623a.size();
            int i10 = 0;
            if (this.f3625c != 1) {
                while (i10 < size) {
                    this.f3623a.get(i10).mo2835a(this.f3624b);
                    i10++;
                }
            } else {
                while (i10 < size) {
                    this.f3623a.get(i10).mo2836b();
                    i10++;
                }
            }
        }

        public f(Collection<e> collection, int i10) {
            this(collection, i10, null);
        }

        public f(Collection<e> collection, int i10, Throwable th2) {
            C9373h.m58746g(collection, "initCallbacks cannot be null");
            this.f3623a = new ArrayList(collection);
            this.f3625c = i10;
            this.f3624b = th2;
        }
    }

    /* renamed from: androidx.emoji2.text.e$g */
    public interface g {
        /* renamed from: a */
        void mo4196a(h hVar);
    }

    /* renamed from: androidx.emoji2.text.e$h */
    public static abstract class h {
        /* renamed from: a */
        public abstract void mo4199a(Throwable th2);

        /* renamed from: b */
        public abstract void mo4200b(C0696m c0696m);
    }

    /* renamed from: androidx.emoji2.text.e$i */
    public static class i {
        /* renamed from: a */
        public AbstractC0692i m4247a(C0690g c0690g) {
            return new C0698o(c0690g);
        }
    }

    public C0688e(c cVar) {
        this.f3603g = cVar.f3615b;
        this.f3604h = cVar.f3616c;
        this.f3605i = cVar.f3617d;
        this.f3606j = cVar.f3619f;
        this.f3607k = cVar.f3620g;
        this.f3602f = cVar.f3614a;
        this.f3608l = cVar.f3621h;
        this.f3609m = cVar.f3622i;
        C11208b c11208b = new C11208b();
        this.f3598b = c11208b;
        Set<e> set = cVar.f3618e;
        if (set != null && !set.isEmpty()) {
            c11208b.addAll(cVar.f3618e);
        }
        this.f3601e = new a(this);
        m4231l();
    }

    /* renamed from: b */
    public static C0688e m4221b() {
        C0688e c0688e;
        synchronized (f3594n) {
            c0688e = f3596p;
            C9373h.m58747h(c0688e != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return c0688e;
    }

    /* renamed from: e */
    public static boolean m4222e(InputConnection inputConnection, Editable editable, int i10, int i11, boolean z10) {
        return C0691h.m4260c(inputConnection, editable, i10, i11, z10);
    }

    /* renamed from: f */
    public static boolean m4223f(Editable editable, int i10, KeyEvent keyEvent) {
        return C0691h.m4261d(editable, i10, keyEvent);
    }

    /* renamed from: g */
    public static C0688e m4224g(c cVar) {
        C0688e c0688e = f3596p;
        if (c0688e == null) {
            synchronized (f3594n) {
                try {
                    c0688e = f3596p;
                    if (c0688e == null) {
                        c0688e = new C0688e(cVar);
                        f3596p = c0688e;
                    }
                } finally {
                }
            }
        }
        return c0688e;
    }

    /* renamed from: h */
    public static boolean m4225h() {
        return f3596p != null;
    }

    /* renamed from: c */
    public int m4226c() {
        return this.f3607k;
    }

    /* renamed from: d */
    public int m4227d() {
        this.f3597a.readLock().lock();
        try {
            return this.f3599c;
        } finally {
            this.f3597a.readLock().unlock();
        }
    }

    /* renamed from: i */
    public boolean m4228i() {
        return this.f3606j;
    }

    /* renamed from: j */
    public final boolean m4229j() {
        return m4227d() == 1;
    }

    /* renamed from: k */
    public void m4230k() {
        C9373h.m58747h(this.f3608l == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (m4229j()) {
            return;
        }
        this.f3597a.writeLock().lock();
        try {
            if (this.f3599c == 0) {
                return;
            }
            this.f3599c = 0;
            this.f3597a.writeLock().unlock();
            this.f3601e.mo4241a();
        } finally {
            this.f3597a.writeLock().unlock();
        }
    }

    /* renamed from: l */
    public final void m4231l() {
        this.f3597a.writeLock().lock();
        try {
            if (this.f3608l == 0) {
                this.f3599c = 0;
            }
            this.f3597a.writeLock().unlock();
            if (m4227d() == 0) {
                this.f3601e.mo4241a();
            }
        } catch (Throwable th2) {
            this.f3597a.writeLock().unlock();
            throw th2;
        }
    }

    /* renamed from: m */
    public void m4232m(Throwable th2) {
        ArrayList arrayList = new ArrayList();
        this.f3597a.writeLock().lock();
        try {
            this.f3599c = 2;
            arrayList.addAll(this.f3598b);
            this.f3598b.clear();
            this.f3597a.writeLock().unlock();
            this.f3600d.post(new f(arrayList, this.f3599c, th2));
        } catch (Throwable th3) {
            this.f3597a.writeLock().unlock();
            throw th3;
        }
    }

    /* renamed from: n */
    public void m4233n() {
        ArrayList arrayList = new ArrayList();
        this.f3597a.writeLock().lock();
        try {
            this.f3599c = 1;
            arrayList.addAll(this.f3598b);
            this.f3598b.clear();
            this.f3597a.writeLock().unlock();
            this.f3600d.post(new f(arrayList, this.f3599c));
        } catch (Throwable th2) {
            this.f3597a.writeLock().unlock();
            throw th2;
        }
    }

    /* renamed from: o */
    public CharSequence m4234o(CharSequence charSequence) {
        return m4235p(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    /* renamed from: p */
    public CharSequence m4235p(CharSequence charSequence, int i10, int i11) {
        return m4236q(charSequence, i10, i11, Integer.MAX_VALUE);
    }

    /* renamed from: q */
    public CharSequence m4236q(CharSequence charSequence, int i10, int i11, int i12) {
        return m4237r(charSequence, i10, i11, i12, 0);
    }

    /* renamed from: r */
    public CharSequence m4237r(CharSequence charSequence, int i10, int i11, int i12, int i13) {
        boolean z10;
        C9373h.m58747h(m4229j(), "Not initialized yet");
        C9373h.m58743d(i10, "start cannot be negative");
        C9373h.m58743d(i11, "end cannot be negative");
        C9373h.m58743d(i12, "maxEmojiCount cannot be negative");
        C9373h.m58740a(i10 <= i11, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        C9373h.m58740a(i10 <= charSequence.length(), "start should be < than charSequence length");
        C9373h.m58740a(i11 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i10 == i11) {
            return charSequence;
        }
        if (i13 != 1) {
            z10 = i13 != 2 ? this.f3603g : false;
        } else {
            z10 = true;
        }
        return this.f3601e.mo4242b(charSequence, i10, i11, i12, z10);
    }

    /* renamed from: s */
    public void m4238s(e eVar) {
        C9373h.m58746g(eVar, "initCallback cannot be null");
        this.f3597a.writeLock().lock();
        try {
            if (this.f3599c == 1 || this.f3599c == 2) {
                this.f3600d.post(new f(eVar, this.f3599c));
            } else {
                this.f3598b.add(eVar);
            }
            this.f3597a.writeLock().unlock();
        } catch (Throwable th2) {
            this.f3597a.writeLock().unlock();
            throw th2;
        }
    }

    /* renamed from: t */
    public void m4239t(e eVar) {
        C9373h.m58746g(eVar, "initCallback cannot be null");
        this.f3597a.writeLock().lock();
        try {
            this.f3598b.remove(eVar);
        } finally {
            this.f3597a.writeLock().unlock();
        }
    }

    /* renamed from: u */
    public void m4240u(EditorInfo editorInfo) {
        if (!m4229j() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.f3601e.mo4243c(editorInfo);
    }
}
