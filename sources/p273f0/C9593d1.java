package p273f0;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p438l.C11213g;

/* renamed from: f0.d1 */
/* loaded from: classes.dex */
public final class C9593d1 {

    /* renamed from: a */
    public final e f47694a;

    /* renamed from: f0.d1$a */
    public static class a extends e {

        /* renamed from: a */
        public final Window f47695a;

        /* renamed from: b */
        public final View f47696b;

        public a(Window window, View view) {
            this.f47695a = window;
            this.f47696b = view;
        }

        /* renamed from: c */
        public void m59811c(int i10) {
            View decorView = this.f47695a.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        /* renamed from: d */
        public void m59812d(int i10) {
            this.f47695a.addFlags(i10);
        }

        /* renamed from: e */
        public void m59813e(int i10) {
            View decorView = this.f47695a.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        /* renamed from: f */
        public void m59814f(int i10) {
            this.f47695a.clearFlags(i10);
        }
    }

    /* renamed from: f0.d1$b */
    public static class b extends a {
        public b(Window window, View view) {
            super(window, view);
        }

        @Override // p273f0.C9593d1.e
        /* renamed from: b */
        public void mo59815b(boolean z10) {
            if (!z10) {
                m59813e(8192);
                return;
            }
            m59814f(HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
            m59812d(Integer.MIN_VALUE);
            m59811c(8192);
        }
    }

    /* renamed from: f0.d1$c */
    public static class c extends b {
        public c(Window window, View view) {
            super(window, view);
        }

        @Override // p273f0.C9593d1.e
        /* renamed from: a */
        public void mo59816a(boolean z10) {
            if (!z10) {
                m59813e(16);
                return;
            }
            m59814f(HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
            m59812d(Integer.MIN_VALUE);
            m59811c(16);
        }
    }

    /* renamed from: f0.d1$e */
    public static class e {
        /* renamed from: a */
        public void mo59816a(boolean z10) {
            throw null;
        }

        /* renamed from: b */
        public void mo59815b(boolean z10) {
            throw null;
        }
    }

    public C9593d1(Window window, View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f47694a = new d(window, this);
        } else {
            this.f47694a = new c(window, view);
        }
    }

    /* renamed from: a */
    public void m59809a(boolean z10) {
        this.f47694a.mo59816a(z10);
    }

    /* renamed from: b */
    public void m59810b(boolean z10) {
        this.f47694a.mo59815b(z10);
    }

    /* renamed from: f0.d1$d */
    public static class d extends e {

        /* renamed from: a */
        public final C9593d1 f47697a;

        /* renamed from: b */
        public final WindowInsetsController f47698b;

        /* renamed from: c */
        public final C11213g<Object, WindowInsetsController.OnControllableInsetsChangedListener> f47699c;

        /* renamed from: d */
        public Window f47700d;

        public d(Window window, C9593d1 c9593d1) {
            this(window.getInsetsController(), c9593d1);
            this.f47700d = window;
        }

        @Override // p273f0.C9593d1.e
        /* renamed from: a */
        public void mo59816a(boolean z10) {
            if (z10) {
                if (this.f47700d != null) {
                    m59817c(16);
                }
                this.f47698b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f47700d != null) {
                    m59818d(16);
                }
                this.f47698b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // p273f0.C9593d1.e
        /* renamed from: b */
        public void mo59815b(boolean z10) {
            if (z10) {
                if (this.f47700d != null) {
                    m59817c(8192);
                }
                this.f47698b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f47700d != null) {
                    m59818d(8192);
                }
                this.f47698b.setSystemBarsAppearance(0, 8);
            }
        }

        /* renamed from: c */
        public void m59817c(int i10) {
            View decorView = this.f47700d.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        /* renamed from: d */
        public void m59818d(int i10) {
            View decorView = this.f47700d.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        public d(WindowInsetsController windowInsetsController, C9593d1 c9593d1) {
            this.f47699c = new C11213g<>();
            this.f47698b = windowInsetsController;
            this.f47697a = c9593d1;
        }
    }
}
