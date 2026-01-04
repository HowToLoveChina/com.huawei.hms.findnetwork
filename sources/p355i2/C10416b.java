package p355i2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import p211d.C8968a;
import p303g.C9816d;

/* renamed from: i2.b */
/* loaded from: classes.dex */
public final class C10416b {

    /* renamed from: a */
    public static volatile boolean f50251a = true;

    /* renamed from: a */
    public static Drawable m63957a(Context context, int i10, Resources.Theme theme) {
        return m63959c(context, context, i10, theme);
    }

    /* renamed from: b */
    public static Drawable m63958b(Context context, Context context2, int i10) {
        return m63959c(context, context2, i10, null);
    }

    /* renamed from: c */
    public static Drawable m63959c(Context context, Context context2, int i10, Resources.Theme theme) {
        try {
            if (f50251a) {
                return m63961e(context2, i10, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e10) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e10;
            }
            return ContextCompat.getDrawable(context2, i10);
        } catch (NoClassDefFoundError unused2) {
            f50251a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return m63960d(context2, i10, theme);
    }

    /* renamed from: d */
    public static Drawable m63960d(Context context, int i10, Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i10, theme);
    }

    /* renamed from: e */
    public static Drawable m63961e(Context context, int i10, Resources.Theme theme) {
        if (theme != null) {
            context = new C9816d(context, theme);
        }
        return C8968a.m56743b(context, i10);
    }
}
