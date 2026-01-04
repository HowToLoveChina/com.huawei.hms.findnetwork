package androidx.emoji2.text;

import android.content.Context;
import androidx.emoji2.text.C0688e;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.InterfaceC0781c;
import androidx.lifecycle.InterfaceC0796l;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import p024b0.C1094j;
import p794y0.C13898a;
import p794y0.InterfaceC13899b;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements InterfaceC13899b<Boolean> {

    /* renamed from: androidx.emoji2.text.EmojiCompatInitializer$a */
    public static class C0681a extends C0688e.c {
        public C0681a(Context context) {
            super(new C0682b(context));
            m4246b(1);
        }
    }

    /* renamed from: androidx.emoji2.text.EmojiCompatInitializer$b */
    public static class C0682b implements C0688e.g {

        /* renamed from: a */
        public final Context f3586a;

        /* renamed from: androidx.emoji2.text.EmojiCompatInitializer$b$a */
        public class a extends C0688e.h {

            /* renamed from: a */
            public final /* synthetic */ C0688e.h f3587a;

            /* renamed from: b */
            public final /* synthetic */ ThreadPoolExecutor f3588b;

            public a(C0688e.h hVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f3587a = hVar;
                this.f3588b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.C0688e.h
            /* renamed from: a */
            public void mo4199a(Throwable th2) {
                try {
                    this.f3587a.mo4199a(th2);
                } finally {
                    this.f3588b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.C0688e.h
            /* renamed from: b */
            public void mo4200b(C0696m c0696m) {
                try {
                    this.f3587a.mo4200b(c0696m);
                } finally {
                    this.f3588b.shutdown();
                }
            }
        }

        public C0682b(Context context) {
            this.f3586a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.C0688e.g
        /* renamed from: a */
        public void mo4196a(final C0688e.h hVar) {
            final ThreadPoolExecutor threadPoolExecutorM4202b = C0685b.m4202b("EmojiCompatInitializer");
            threadPoolExecutorM4202b.execute(new Runnable() { // from class: androidx.emoji2.text.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3626a.m4198d(hVar, threadPoolExecutorM4202b);
                }
            });
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void m4198d(C0688e.h hVar, ThreadPoolExecutor threadPoolExecutor) {
            try {
                C0693j c0693jM4206a = C0686c.m4206a(this.f3586a);
                if (c0693jM4206a == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                c0693jM4206a.m4279c(threadPoolExecutor);
                c0693jM4206a.m4245a().mo4196a(new a(hVar, threadPoolExecutor));
            } catch (Throwable th2) {
                hVar.mo4199a(th2);
                threadPoolExecutor.shutdown();
            }
        }
    }

    /* renamed from: androidx.emoji2.text.EmojiCompatInitializer$c */
    public static class RunnableC0683c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                C1094j.m6490a("EmojiCompat.EmojiCompatInitializer.run");
                if (C0688e.m4225h()) {
                    C0688e.m4221b().m4230k();
                }
            } finally {
                C1094j.m6491b();
            }
        }
    }

    @Override // p794y0.InterfaceC13899b
    /* renamed from: a */
    public List<Class<? extends InterfaceC13899b<?>>> mo4189a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // p794y0.InterfaceC13899b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean mo4190b(Context context) {
        C0688e.m4224g(new C0681a(context));
        m4192d(context);
        return Boolean.TRUE;
    }

    /* renamed from: d */
    public void m4192d(Context context) {
        final AbstractC0791h abstractC0791hMo1915g = ((InterfaceC0796l) C13898a.m83303e(context).m83308f(ProcessLifecycleInitializer.class)).mo1915g();
        abstractC0791hMo1915g.mo4948a(new InterfaceC0781c() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.InterfaceC0785e
            /* renamed from: c */
            public void mo4194c(InterfaceC0796l interfaceC0796l) {
                EmojiCompatInitializer.this.m4193e();
                abstractC0791hMo1915g.mo4950c(this);
            }
        });
    }

    /* renamed from: e */
    public void m4193e() {
        C0685b.m4204d().postDelayed(new RunnableC0683c(), 500L);
    }
}
