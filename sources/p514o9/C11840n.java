package p514o9;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.android.hicloud.commonlib.view.CommonDialogInterface;

/* renamed from: o9.n */
/* loaded from: classes3.dex */
public class C11840n {

    /* renamed from: o9.n$a */
    public class a implements d {

        /* renamed from: a */
        public final /* synthetic */ int f54780a;

        public a(int i10) {
            this.f54780a = i10;
        }

        @Override // p514o9.C11840n.d
        /* renamed from: a */
        public void mo70697a(View view) {
            C11840n.m70691b(view, this.f54780a);
        }
    }

    /* renamed from: o9.n$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Window f54781a;

        public b(Window window) {
            this.f54781a = window;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f54781a.clearFlags(8);
        }
    }

    /* renamed from: o9.n$d */
    public interface d {
        /* renamed from: a */
        void mo70697a(View view);
    }

    @TargetApi(21)
    /* renamed from: a */
    public static void m70690a(Window window, int i10) {
        m70693d(window, new a(i10));
    }

    /* renamed from: b */
    public static void m70691b(View view, int i10) {
        view.setSystemUiVisibility(i10 | view.getSystemUiVisibility());
    }

    /* renamed from: c */
    public static void m70692c(Window window, int i10) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.systemUiVisibility = i10 | attributes.systemUiVisibility;
        window.setAttributes(attributes);
    }

    /* renamed from: d */
    public static void m70693d(Window window, d dVar) {
        new c(null).m70704g(window, dVar, 3);
    }

    /* renamed from: e */
    public static void m70694e(Dialog dialog) {
        try {
            Window window = dialog.getWindow();
            if (window != null) {
                m70696g(window);
                m70692c(window, 4098);
                m70690a(window, 4098);
                window.setNavigationBarColor(0);
                window.setStatusBarColor(0);
            }
        } catch (Exception e10) {
            C11839m.m70687e("SystemBarHelper", "hideSystemBars fail!" + e10.getMessage());
        }
    }

    /* renamed from: f */
    public static void m70695f(CommonDialogInterface commonDialogInterface) {
        try {
            Window window = commonDialogInterface.getWindow();
            if (window != null) {
                m70696g(window);
                m70692c(window, 4098);
                m70690a(window, 4098);
                window.setNavigationBarColor(0);
                window.setStatusBarColor(0);
            }
        } catch (Exception e10) {
            C11839m.m70687e("SystemBarHelper", "hideSystemBarsForCommonDialogInterface fail!" + e10.getMessage());
        }
    }

    /* renamed from: g */
    public static void m70696g(Window window) {
        window.setFlags(8, 8);
        window.setSoftInputMode(256);
        new Handler().post(new b(window));
    }

    /* renamed from: o9.n$c */
    public static class c {

        /* renamed from: a */
        public final Handler f54782a;

        /* renamed from: b */
        public Window f54783b;

        /* renamed from: c */
        public int f54784c;

        /* renamed from: d */
        public d f54785d;

        /* renamed from: e */
        public Runnable f54786e;

        /* renamed from: o9.n$c$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                View viewPeekDecorView = c.this.f54783b.peekDecorView();
                if (viewPeekDecorView != null) {
                    c.this.f54785d.mo70697a(viewPeekDecorView);
                    return;
                }
                c.m70701d(c.this);
                if (c.this.f54784c >= 0) {
                    c.this.f54782a.post(c.this.f54786e);
                    return;
                }
                Log.w("SystemBarHelper", "Cannot get decor view of window: " + c.this.f54783b);
            }
        }

        public c() {
            this.f54782a = new Handler();
            this.f54786e = new a();
        }

        /* renamed from: d */
        public static /* synthetic */ int m70701d(c cVar) {
            int i10 = cVar.f54784c;
            cVar.f54784c = i10 - 1;
            return i10;
        }

        /* renamed from: g */
        public void m70704g(Window window, d dVar, int i10) {
            this.f54783b = window;
            this.f54784c = i10;
            this.f54785d = dVar;
            this.f54786e.run();
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
