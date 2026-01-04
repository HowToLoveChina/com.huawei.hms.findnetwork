package androidx.activity;

import android.annotation.SuppressLint;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.InterfaceC0794j;
import androidx.lifecycle.InterfaceC0796l;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import p024b0.C1085a;
import p243e0.InterfaceC9366a;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a */
    public final Runnable f1096a;

    /* renamed from: c */
    public InterfaceC9366a<Boolean> f1098c;

    /* renamed from: d */
    public OnBackInvokedCallback f1099d;

    /* renamed from: e */
    public OnBackInvokedDispatcher f1100e;

    /* renamed from: b */
    public final ArrayDeque<AbstractC0333g> f1097b = new ArrayDeque<>();

    /* renamed from: f */
    public boolean f1101f = false;

    public class LifecycleOnBackPressedCancellable implements InterfaceC0794j, InterfaceC0327a {

        /* renamed from: a */
        public final AbstractC0791h f1102a;

        /* renamed from: b */
        public final AbstractC0333g f1103b;

        /* renamed from: c */
        public InterfaceC0327a f1104c;

        public LifecycleOnBackPressedCancellable(AbstractC0791h abstractC0791h, AbstractC0333g abstractC0333g) {
            this.f1102a = abstractC0791h;
            this.f1103b = abstractC0333g;
            abstractC0791h.mo4948a(this);
        }

        @Override // androidx.activity.InterfaceC0327a
        public void cancel() {
            this.f1102a.mo4950c(this);
            this.f1103b.m1951e(this);
            InterfaceC0327a interfaceC0327a = this.f1104c;
            if (interfaceC0327a != null) {
                interfaceC0327a.cancel();
                this.f1104c = null;
            }
        }

        @Override // androidx.lifecycle.InterfaceC0794j
        /* renamed from: d */
        public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
            if (bVar == AbstractC0791h.b.ON_START) {
                this.f1104c = OnBackPressedDispatcher.this.m1935c(this.f1103b);
                return;
            }
            if (bVar != AbstractC0791h.b.ON_STOP) {
                if (bVar == AbstractC0791h.b.ON_DESTROY) {
                    cancel();
                }
            } else {
                InterfaceC0327a interfaceC0327a = this.f1104c;
                if (interfaceC0327a != null) {
                    interfaceC0327a.cancel();
                }
            }
        }
    }

    /* renamed from: androidx.activity.OnBackPressedDispatcher$a */
    public static class C0325a {
        /* renamed from: a */
        public static OnBackInvokedCallback m1941a(Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new C0336j(runnable);
        }

        /* renamed from: b */
        public static void m1942b(Object obj, int i10, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i10, (OnBackInvokedCallback) obj2);
        }

        /* renamed from: c */
        public static void m1943c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* renamed from: androidx.activity.OnBackPressedDispatcher$b */
    public class C0326b implements InterfaceC0327a {

        /* renamed from: a */
        public final AbstractC0333g f1106a;

        public C0326b(AbstractC0333g abstractC0333g) {
            this.f1106a = abstractC0333g;
        }

        @Override // androidx.activity.InterfaceC0327a
        public void cancel() {
            OnBackPressedDispatcher.this.f1097b.remove(this.f1106a);
            this.f1106a.m1951e(this);
            if (C1085a.m6463c()) {
                this.f1106a.m1953g(null);
                OnBackPressedDispatcher.this.m1940h();
            }
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f1096a = runnable;
        if (C1085a.m6463c()) {
            this.f1098c = new InterfaceC9366a() { // from class: androidx.activity.h
                @Override // p243e0.InterfaceC9366a
                public final void accept(Object obj) {
                    this.f1115a.m1937e((Boolean) obj);
                }
            };
            this.f1099d = C0325a.m1941a(new Runnable() { // from class: androidx.activity.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1116a.m1938f();
                }
            });
        }
    }

    @SuppressLint({"LambdaLast"})
    /* renamed from: b */
    public void m1934b(InterfaceC0796l interfaceC0796l, AbstractC0333g abstractC0333g) {
        AbstractC0791h abstractC0791hMo1915g = interfaceC0796l.mo1915g();
        if (abstractC0791hMo1915g.mo4949b() == AbstractC0791h.c.DESTROYED) {
            return;
        }
        abstractC0333g.m1947a(new LifecycleOnBackPressedCancellable(abstractC0791hMo1915g, abstractC0333g));
        if (C1085a.m6463c()) {
            m1940h();
            abstractC0333g.m1953g(this.f1098c);
        }
    }

    /* renamed from: c */
    public InterfaceC0327a m1935c(AbstractC0333g abstractC0333g) {
        this.f1097b.add(abstractC0333g);
        C0326b c0326b = new C0326b(abstractC0333g);
        abstractC0333g.m1947a(c0326b);
        if (C1085a.m6463c()) {
            m1940h();
            abstractC0333g.m1953g(this.f1098c);
        }
        return c0326b;
    }

    /* renamed from: d */
    public boolean m1936d() {
        Iterator<AbstractC0333g> itDescendingIterator = this.f1097b.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            if (itDescendingIterator.next().m1949c()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public final /* synthetic */ void m1937e(Boolean bool) {
        if (C1085a.m6463c()) {
            m1940h();
        }
    }

    /* renamed from: f */
    public void m1938f() {
        Iterator<AbstractC0333g> itDescendingIterator = this.f1097b.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            AbstractC0333g next = itDescendingIterator.next();
            if (next.m1949c()) {
                next.mo1948b();
                return;
            }
        }
        Runnable runnable = this.f1096a;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* renamed from: g */
    public void m1939g(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        this.f1100e = onBackInvokedDispatcher;
        m1940h();
    }

    /* renamed from: h */
    public void m1940h() {
        boolean zM1936d = m1936d();
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f1100e;
        if (onBackInvokedDispatcher != null) {
            if (zM1936d && !this.f1101f) {
                C0325a.m1942b(onBackInvokedDispatcher, 0, this.f1099d);
                this.f1101f = true;
            } else {
                if (zM1936d || !this.f1101f) {
                    return;
                }
                C0325a.m1943c(onBackInvokedDispatcher, this.f1099d);
                this.f1101f = false;
            }
        }
    }
}
