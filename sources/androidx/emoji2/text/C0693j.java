package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.emoji2.text.C0688e;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import p024b0.C1094j;
import p042c0.C1372e;
import p042c0.C1374g;
import p243e0.C9373h;
import p723w.C13510i;

/* renamed from: androidx.emoji2.text.j */
/* loaded from: classes.dex */
public class C0693j extends C0688e.c {

    /* renamed from: j */
    public static final a f3651j = new a();

    /* renamed from: androidx.emoji2.text.j$a */
    public static class a {
        /* renamed from: a */
        public Typeface m4280a(Context context, C1374g.b bVar) throws PackageManager.NameNotFoundException {
            return C1374g.m7896a(context, null, new C1374g.b[]{bVar});
        }

        /* renamed from: b */
        public C1374g.a m4281b(Context context, C1372e c1372e) throws PackageManager.NameNotFoundException {
            return C1374g.m7897b(context, null, c1372e);
        }

        /* renamed from: c */
        public void m4282c(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* renamed from: androidx.emoji2.text.j$b */
    public static class b implements C0688e.g {

        /* renamed from: a */
        public final Context f3652a;

        /* renamed from: b */
        public final C1372e f3653b;

        /* renamed from: c */
        public final a f3654c;

        /* renamed from: d */
        public final Object f3655d = new Object();

        /* renamed from: e */
        public Handler f3656e;

        /* renamed from: f */
        public Executor f3657f;

        /* renamed from: g */
        public ThreadPoolExecutor f3658g;

        /* renamed from: h */
        public C0688e.h f3659h;

        /* renamed from: i */
        public ContentObserver f3660i;

        /* renamed from: j */
        public Runnable f3661j;

        public b(Context context, C1372e c1372e, a aVar) {
            C9373h.m58746g(context, "Context cannot be null");
            C9373h.m58746g(c1372e, "FontRequest cannot be null");
            this.f3652a = context.getApplicationContext();
            this.f3653b = c1372e;
            this.f3654c = aVar;
        }

        @Override // androidx.emoji2.text.C0688e.g
        /* renamed from: a */
        public void mo4196a(C0688e.h hVar) {
            C9373h.m58746g(hVar, "LoaderCallback cannot be null");
            synchronized (this.f3655d) {
                this.f3659h = hVar;
            }
            m4285d();
        }

        /* renamed from: b */
        public final void m4283b() {
            synchronized (this.f3655d) {
                try {
                    this.f3659h = null;
                    ContentObserver contentObserver = this.f3660i;
                    if (contentObserver != null) {
                        this.f3654c.m4282c(this.f3652a, contentObserver);
                        this.f3660i = null;
                    }
                    Handler handler = this.f3656e;
                    if (handler != null) {
                        handler.removeCallbacks(this.f3661j);
                    }
                    this.f3656e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f3658g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f3657f = null;
                    this.f3658g = null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: c */
        public void m4284c() {
            synchronized (this.f3655d) {
                try {
                    if (this.f3659h == null) {
                        return;
                    }
                    try {
                        C1374g.b bVarM4286e = m4286e();
                        int iM7903b = bVarM4286e.m7903b();
                        if (iM7903b == 2) {
                            synchronized (this.f3655d) {
                            }
                        }
                        if (iM7903b != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + iM7903b + ")");
                        }
                        try {
                            C1094j.m6490a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface typefaceM4280a = this.f3654c.m4280a(this.f3652a, bVarM4286e);
                            ByteBuffer byteBufferM81258a = C13510i.m81258a(this.f3652a, null, bVarM4286e.m7905d());
                            if (byteBufferM81258a == null || typefaceM4280a == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            C0696m c0696mM4296b = C0696m.m4296b(typefaceM4280a, byteBufferM81258a);
                            C1094j.m6491b();
                            synchronized (this.f3655d) {
                                try {
                                    C0688e.h hVar = this.f3659h;
                                    if (hVar != null) {
                                        hVar.mo4200b(c0696mM4296b);
                                    }
                                } finally {
                                }
                            }
                            m4283b();
                        } catch (Throwable th2) {
                            C1094j.m6491b();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        synchronized (this.f3655d) {
                            try {
                                C0688e.h hVar2 = this.f3659h;
                                if (hVar2 != null) {
                                    hVar2.mo4199a(th3);
                                }
                                m4283b();
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        /* renamed from: d */
        public void m4285d() {
            synchronized (this.f3655d) {
                try {
                    if (this.f3659h == null) {
                        return;
                    }
                    if (this.f3657f == null) {
                        ThreadPoolExecutor threadPoolExecutorM4202b = C0685b.m4202b("emojiCompat");
                        this.f3658g = threadPoolExecutorM4202b;
                        this.f3657f = threadPoolExecutorM4202b;
                    }
                    this.f3657f.execute(new Runnable() { // from class: androidx.emoji2.text.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f3662a.m4284c();
                        }
                    });
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: e */
        public final C1374g.b m4286e() {
            try {
                C1374g.a aVarM4281b = this.f3654c.m4281b(this.f3652a, this.f3653b);
                if (aVarM4281b.m7901c() == 0) {
                    C1374g.b[] bVarArrM7900b = aVarM4281b.m7900b();
                    if (bVarArrM7900b == null || bVarArrM7900b.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return bVarArrM7900b[0];
                }
                throw new RuntimeException("fetchFonts failed (" + aVarM4281b.m7901c() + ")");
            } catch (PackageManager.NameNotFoundException e10) {
                throw new RuntimeException("provider not found", e10);
            }
        }

        /* renamed from: f */
        public void m4287f(Executor executor) {
            synchronized (this.f3655d) {
                this.f3657f = executor;
            }
        }
    }

    public C0693j(Context context, C1372e c1372e) {
        super(new b(context, c1372e, f3651j));
    }

    /* renamed from: c */
    public C0693j m4279c(Executor executor) {
        ((b) m4245a()).m4287f(executor);
        return this;
    }
}
