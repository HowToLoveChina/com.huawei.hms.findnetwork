package p723w;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.content.res.FontResourcesParserCompat;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import java.io.IOException;
import p042c0.C1374g;

/* renamed from: w.g */
/* loaded from: classes.dex */
public class C13508g extends C13509h {
    /* renamed from: e */
    public static int m81253e(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // p723w.C13509h
    /* renamed from: a */
    public Typeface mo81254a(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i10) throws IOException {
        try {
            FontFamily.Builder builder = null;
            for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.getEntries()) {
                try {
                    Font fontBuild = new Font.Builder(resources, fontFileResourceEntry.getResourceId()).setWeight(fontFileResourceEntry.getWeight()).setSlant(fontFileResourceEntry.isItalic() ? 1 : 0).setTtcIndex(fontFileResourceEntry.getTtcIndex()).setFontVariationSettings(fontFileResourceEntry.getVariationSettings()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(m81257d(fontFamilyBuild, i10).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // p723w.C13509h
    /* renamed from: b */
    public Typeface mo81255b(Context context, CancellationSignal cancellationSignal, C1374g.b[] bVarArr, int i10) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (C1374g.b bVar : bVarArr) {
                try {
                    parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(bVar.m7905d(), "r", cancellationSignal);
                } catch (IOException unused) {
                }
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                    }
                } else {
                    try {
                        Font fontBuild = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(bVar.m7906e()).setSlant(bVar.m7907f() ? 1 : 0).setTtcIndex(bVar.m7904c()).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(fontBuild);
                        } else {
                            builder.addFont(fontBuild);
                        }
                    } catch (Throwable th2) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
                parcelFileDescriptorOpenFileDescriptor.close();
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(m81257d(fontFamilyBuild, i10).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // p723w.C13509h
    /* renamed from: c */
    public Typeface mo81256c(Context context, Resources resources, int i10, String str, int i11) throws IOException {
        try {
            Font fontBuild = new Font.Builder(resources, i10).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: d */
    public final Font m81257d(FontFamily fontFamily, int i10) {
        FontStyle fontStyle = new FontStyle((i10 & 1) != 0 ? ErrorCode.ERROR_NATIVE_AD_NO : 400, (i10 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iM81253e = m81253e(fontStyle, font.getStyle());
        for (int i11 = 1; i11 < fontFamily.getSize(); i11++) {
            Font font2 = fontFamily.getFont(i11);
            int iM81253e2 = m81253e(fontStyle, font2.getStyle());
            if (iM81253e2 < iM81253e) {
                font = font2;
                iM81253e = iM81253e2;
            }
        }
        return font;
    }
}
