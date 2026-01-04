package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.widget.b0 */
/* loaded from: classes.dex */
public class C0517b0 extends ContextWrapper {

    /* renamed from: c */
    public static final Object f2291c = new Object();

    /* renamed from: d */
    public static ArrayList<WeakReference<C0517b0>> f2292d;

    /* renamed from: a */
    public final Resources f2293a;

    /* renamed from: b */
    public final Resources.Theme f2294b;

    public C0517b0(Context context) {
        super(context);
        if (!C0533j0.m3048c()) {
            this.f2293a = new C0521d0(this, context.getResources());
            this.f2294b = null;
            return;
        }
        C0533j0 c0533j0 = new C0533j0(this, context.getResources());
        this.f2293a = c0533j0;
        Resources.Theme themeNewTheme = c0533j0.newTheme();
        this.f2294b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    /* renamed from: a */
    public static boolean m2915a(Context context) {
        if ((context instanceof C0517b0) || (context.getResources() instanceof C0521d0) || (context.getResources() instanceof C0533j0)) {
            return false;
        }
        return C0533j0.m3048c();
    }

    /* renamed from: b */
    public static Context m2916b(Context context) {
        if (!m2915a(context)) {
            return context;
        }
        synchronized (f2291c) {
            try {
                ArrayList<WeakReference<C0517b0>> arrayList = f2292d;
                if (arrayList == null) {
                    f2292d = new ArrayList<>();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference<C0517b0> weakReference = f2292d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f2292d.remove(size);
                        }
                    }
                    for (int size2 = f2292d.size() - 1; size2 >= 0; size2--) {
                        WeakReference<C0517b0> weakReference2 = f2292d.get(size2);
                        C0517b0 c0517b0 = weakReference2 != null ? weakReference2.get() : null;
                        if (c0517b0 != null && c0517b0.getBaseContext() == context) {
                            return c0517b0;
                        }
                    }
                }
                C0517b0 c0517b02 = new C0517b0(context);
                f2292d.add(new WeakReference<>(c0517b02));
                return c0517b02;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f2293a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f2293a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f2294b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        Resources.Theme theme = this.f2294b;
        if (theme == null) {
            super.setTheme(i10);
        } else {
            theme.applyStyle(i10, true);
        }
    }
}
