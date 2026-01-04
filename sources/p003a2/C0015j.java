package p003a2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: a2.j */
/* loaded from: classes.dex */
public class C0015j implements InterfaceC0009d {

    /* renamed from: k */
    public static final Bitmap.Config f16k = Bitmap.Config.ARGB_8888;

    /* renamed from: a */
    public final InterfaceC0016k f17a;

    /* renamed from: b */
    public final Set<Bitmap.Config> f18b;

    /* renamed from: c */
    public final long f19c;

    /* renamed from: d */
    public final a f20d;

    /* renamed from: e */
    public long f21e;

    /* renamed from: f */
    public long f22f;

    /* renamed from: g */
    public int f23g;

    /* renamed from: h */
    public int f24h;

    /* renamed from: i */
    public int f25i;

    /* renamed from: j */
    public int f26j;

    /* renamed from: a2.j$a */
    public interface a {
        /* renamed from: a */
        void mo59a(Bitmap bitmap);

        /* renamed from: b */
        void mo60b(Bitmap bitmap);
    }

    /* renamed from: a2.j$b */
    public static final class b implements a {
        @Override // p003a2.C0015j.a
        /* renamed from: a */
        public void mo59a(Bitmap bitmap) {
        }

        @Override // p003a2.C0015j.a
        /* renamed from: b */
        public void mo60b(Bitmap bitmap) {
        }
    }

    public C0015j(long j10, InterfaceC0016k interfaceC0016k, Set<Bitmap.Config> set) {
        this.f19c = j10;
        this.f21e = j10;
        this.f17a = interfaceC0016k;
        this.f18b = set;
        this.f20d = new b();
    }

    @TargetApi(26)
    /* renamed from: e */
    public static void m47e(Bitmap.Config config) {
        if (config != Bitmap.Config.HARDWARE) {
            return;
        }
        throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    }

    /* renamed from: f */
    public static Bitmap m48f(int i10, int i11, Bitmap.Config config) {
        if (config == null) {
            config = f16k;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    @TargetApi(26)
    /* renamed from: j */
    public static Set<Bitmap.Config> m49j() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        hashSet.remove(Bitmap.Config.HARDWARE);
        return Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: k */
    public static InterfaceC0016k m50k() {
        return new C0018m();
    }

    @TargetApi(19)
    /* renamed from: n */
    public static void m51n(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    /* renamed from: o */
    public static void m52o(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        m51n(bitmap);
    }

    @Override // p003a2.InterfaceC0009d
    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public void mo14a(int i10) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i10);
        }
        if (i10 >= 40 || i10 >= 20) {
            clearMemory();
        } else if (i10 >= 20 || i10 == 15) {
            m58p(m57m() / 2);
        }
    }

    @Override // p003a2.InterfaceC0009d
    /* renamed from: b */
    public synchronized void mo15b(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.f17a.mo65e(bitmap) <= this.f21e && this.f18b.contains(bitmap.getConfig())) {
                int iMo65e = this.f17a.mo65e(bitmap);
                this.f17a.mo62b(bitmap);
                this.f20d.mo60b(bitmap);
                this.f25i++;
                this.f22f += iMo65e;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f17a.mo66f(bitmap));
                }
                m53g();
                m55i();
                return;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f17a.mo66f(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f18b.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // p003a2.InterfaceC0009d
    /* renamed from: c */
    public Bitmap mo16c(int i10, int i11, Bitmap.Config config) {
        Bitmap bitmapM56l = m56l(i10, i11, config);
        if (bitmapM56l == null) {
            return m48f(i10, i11, config);
        }
        bitmapM56l.eraseColor(0);
        return bitmapM56l;
    }

    @Override // p003a2.InterfaceC0009d
    public void clearMemory() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        m58p(0L);
    }

    @Override // p003a2.InterfaceC0009d
    /* renamed from: d */
    public Bitmap mo17d(int i10, int i11, Bitmap.Config config) {
        Bitmap bitmapM56l = m56l(i10, i11, config);
        return bitmapM56l == null ? m48f(i10, i11, config) : bitmapM56l;
    }

    /* renamed from: g */
    public final void m53g() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            m54h();
        }
    }

    /* renamed from: h */
    public final void m54h() {
        Log.v("LruBitmapPool", "Hits=" + this.f23g + ", misses=" + this.f24h + ", puts=" + this.f25i + ", evictions=" + this.f26j + ", currentSize=" + this.f22f + ", maxSize=" + this.f21e + "\nStrategy=" + this.f17a);
    }

    /* renamed from: i */
    public final void m55i() {
        m58p(this.f21e);
    }

    /* renamed from: l */
    public final synchronized Bitmap m56l(int i10, int i11, Bitmap.Config config) {
        Bitmap bitmapMo63c;
        try {
            m47e(config);
            bitmapMo63c = this.f17a.mo63c(i10, i11, config != null ? config : f16k);
            if (bitmapMo63c == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Missing bitmap=" + this.f17a.mo64d(i10, i11, config));
                }
                this.f24h++;
            } else {
                this.f23g++;
                this.f22f -= this.f17a.mo65e(bitmapMo63c);
                this.f20d.mo59a(bitmapMo63c);
                m52o(bitmapMo63c);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Get bitmap=" + this.f17a.mo64d(i10, i11, config));
            }
            m53g();
        } catch (Throwable th2) {
            throw th2;
        }
        return bitmapMo63c;
    }

    /* renamed from: m */
    public long m57m() {
        return this.f21e;
    }

    /* renamed from: p */
    public final synchronized void m58p(long j10) {
        while (this.f22f > j10) {
            try {
                Bitmap bitmapMo61a = this.f17a.mo61a();
                if (bitmapMo61a == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        m54h();
                    }
                    this.f22f = 0L;
                    return;
                }
                this.f20d.mo59a(bitmapMo61a);
                this.f22f -= this.f17a.mo65e(bitmapMo61a);
                this.f26j++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Evicting bitmap=" + this.f17a.mo66f(bitmapMo61a));
                }
                m53g();
                bitmapMo61a.recycle();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public C0015j(long j10) {
        this(j10, m50k(), m49j());
    }
}
