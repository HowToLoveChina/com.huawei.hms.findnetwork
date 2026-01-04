package p723w;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import p042c0.C1374g;
import p438l.C11211e;

/* renamed from: w.f */
/* loaded from: classes.dex */
public class C13507f {

    /* renamed from: a */
    public static final C13509h f60779a = new C13508g();

    /* renamed from: b */
    public static final C11211e<String, Typeface> f60780b = new C11211e<>(16);

    /* renamed from: w.f$a */
    public static class a extends C1374g.c {

        /* renamed from: a */
        public ResourcesCompat.FontCallback f60781a;

        public a(ResourcesCompat.FontCallback fontCallback) {
            this.f60781a = fontCallback;
        }

        @Override // p042c0.C1374g.c
        /* renamed from: a */
        public void mo7908a(int i10) {
            ResourcesCompat.FontCallback fontCallback = this.f60781a;
            if (fontCallback != null) {
                fontCallback.lambda$callbackFailAsync$1(i10);
            }
        }

        @Override // p042c0.C1374g.c
        /* renamed from: b */
        public void mo7909b(Typeface typeface) {
            ResourcesCompat.FontCallback fontCallback = this.f60781a;
            if (fontCallback != null) {
                fontCallback.lambda$callbackSuccessAsync$0(typeface);
            }
        }
    }

    /* renamed from: a */
    public static Typeface m81246a(Context context, Typeface typeface, int i10) {
        if (context != null) {
            return Typeface.create(typeface, i10);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    /* renamed from: b */
    public static Typeface m81247b(Context context, CancellationSignal cancellationSignal, C1374g.b[] bVarArr, int i10) {
        return f60779a.mo81255b(context, cancellationSignal, bVarArr, i10);
    }

    /* renamed from: c */
    public static Typeface m81248c(Context context, FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, Resources resources, int i10, String str, int i11, int i12, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean z10) {
        Typeface typefaceMo81254a;
        if (familyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry;
            Typeface typefaceM81252g = m81252g(providerResourceEntry.getSystemFontFamilyName());
            if (typefaceM81252g != null) {
                if (fontCallback != null) {
                    fontCallback.callbackSuccessAsync(typefaceM81252g, handler);
                }
                return typefaceM81252g;
            }
            typefaceMo81254a = C1374g.m7898c(context, providerResourceEntry.getRequest(), i12, !z10 ? fontCallback != null : providerResourceEntry.getFetchStrategy() != 0, z10 ? providerResourceEntry.getTimeout() : -1, ResourcesCompat.FontCallback.getHandler(handler), new a(fontCallback));
        } else {
            typefaceMo81254a = f60779a.mo81254a(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry, resources, i12);
            if (fontCallback != null) {
                if (typefaceMo81254a != null) {
                    fontCallback.callbackSuccessAsync(typefaceMo81254a, handler);
                } else {
                    fontCallback.callbackFailAsync(-3, handler);
                }
            }
        }
        if (typefaceMo81254a != null) {
            f60780b.m67308d(m81250e(resources, i10, str, i11, i12), typefaceMo81254a);
        }
        return typefaceMo81254a;
    }

    /* renamed from: d */
    public static Typeface m81249d(Context context, Resources resources, int i10, String str, int i11, int i12) {
        Typeface typefaceMo81256c = f60779a.mo81256c(context, resources, i10, str, i12);
        if (typefaceMo81256c != null) {
            f60780b.m67308d(m81250e(resources, i10, str, i11, i12), typefaceMo81256c);
        }
        return typefaceMo81256c;
    }

    /* renamed from: e */
    public static String m81250e(Resources resources, int i10, String str, int i11, int i12) {
        return resources.getResourcePackageName(i10) + '-' + str + '-' + i11 + '-' + i10 + '-' + i12;
    }

    /* renamed from: f */
    public static Typeface m81251f(Resources resources, int i10, String str, int i11, int i12) {
        return f60780b.m67307c(m81250e(resources, i10, str, i11, i12));
    }

    /* renamed from: g */
    public static Typeface m81252g(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }
}
