package p303g;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.appcompat.R$style;

/* renamed from: g.d */
/* loaded from: classes.dex */
public class C9816d extends ContextWrapper {

    /* renamed from: f */
    public static Configuration f48238f;

    /* renamed from: a */
    public int f48239a;

    /* renamed from: b */
    public Resources.Theme f48240b;

    /* renamed from: c */
    public LayoutInflater f48241c;

    /* renamed from: d */
    public Configuration f48242d;

    /* renamed from: e */
    public Resources f48243e;

    /* renamed from: g.d$a */
    public static class a {
        /* renamed from: a */
        public static Context m61009a(C9816d c9816d, Configuration configuration) {
            return c9816d.createConfigurationContext(configuration);
        }
    }

    public C9816d() {
        super(null);
    }

    /* renamed from: e */
    public static boolean m61003e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f48238f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f48238f = configuration2;
        }
        return configuration.equals(f48238f);
    }

    /* renamed from: a */
    public void m61004a(Configuration configuration) {
        if (this.f48243e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f48242d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f48242d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* renamed from: b */
    public final Resources m61005b() {
        if (this.f48243e == null) {
            Configuration configuration = this.f48242d;
            if (configuration == null || m61003e(configuration)) {
                this.f48243e = super.getResources();
            } else {
                this.f48243e = a.m61009a(this, this.f48242d).getResources();
            }
        }
        return this.f48243e;
    }

    /* renamed from: c */
    public int m61006c() {
        return this.f48239a;
    }

    /* renamed from: d */
    public final void m61007d() {
        boolean z10 = this.f48240b == null;
        if (z10) {
            this.f48240b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f48240b.setTo(theme);
            }
        }
        m61008f(this.f48240b, this.f48239a, z10);
    }

    /* renamed from: f */
    public void m61008f(Resources.Theme theme, int i10, boolean z10) {
        theme.applyStyle(i10, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return m61005b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f48241c == null) {
            this.f48241c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f48241c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f48240b;
        if (theme != null) {
            return theme;
        }
        if (this.f48239a == 0) {
            this.f48239a = R$style.Theme_AppCompat_Light;
        }
        m61007d();
        return this.f48240b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        if (this.f48239a != i10) {
            this.f48239a = i10;
            m61007d();
        }
    }

    public C9816d(Context context, int i10) {
        super(context);
        this.f48239a = i10;
    }

    public C9816d(Context context, Resources.Theme theme) {
        super(context);
        this.f48240b = theme;
    }
}
