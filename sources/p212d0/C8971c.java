package p212d0;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import p243e0.C9368c;

/* renamed from: d0.c */
/* loaded from: classes.dex */
public class C8971c implements Spannable {

    /* renamed from: c */
    public static final Object f45498c = new Object();

    /* renamed from: a */
    public final Spannable f45499a;

    /* renamed from: b */
    public final PrecomputedText f45500b;

    /* renamed from: d0.c$a */
    public static final class a {

        /* renamed from: a */
        public final TextPaint f45501a;

        /* renamed from: b */
        public final TextDirectionHeuristic f45502b;

        /* renamed from: c */
        public final int f45503c;

        /* renamed from: d */
        public final int f45504d;

        /* renamed from: e */
        public final PrecomputedText.Params f45505e;

        public a(PrecomputedText.Params params) {
            this.f45501a = params.getTextPaint();
            this.f45502b = params.getTextDirection();
            this.f45503c = params.getBreakStrategy();
            this.f45504d = params.getHyphenationFrequency();
            this.f45505e = params;
        }

        /* renamed from: a */
        public boolean m56772a(a aVar) {
            if (this.f45503c == aVar.m56773b() && this.f45504d == aVar.m56774c() && this.f45501a.getTextSize() == aVar.m56776e().getTextSize() && this.f45501a.getTextScaleX() == aVar.m56776e().getTextScaleX() && this.f45501a.getTextSkewX() == aVar.m56776e().getTextSkewX() && this.f45501a.getLetterSpacing() == aVar.m56776e().getLetterSpacing() && TextUtils.equals(this.f45501a.getFontFeatureSettings(), aVar.m56776e().getFontFeatureSettings()) && this.f45501a.getFlags() == aVar.m56776e().getFlags() && this.f45501a.getTextLocales().equals(aVar.m56776e().getTextLocales())) {
                return this.f45501a.getTypeface() == null ? aVar.m56776e().getTypeface() == null : this.f45501a.getTypeface().equals(aVar.m56776e().getTypeface());
            }
            return false;
        }

        /* renamed from: b */
        public int m56773b() {
            return this.f45503c;
        }

        /* renamed from: c */
        public int m56774c() {
            return this.f45504d;
        }

        /* renamed from: d */
        public TextDirectionHeuristic m56775d() {
            return this.f45502b;
        }

        /* renamed from: e */
        public TextPaint m56776e() {
            return this.f45501a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m56772a(aVar) && this.f45502b == aVar.m56775d();
        }

        public int hashCode() {
            return C9368c.m58730b(Float.valueOf(this.f45501a.getTextSize()), Float.valueOf(this.f45501a.getTextScaleX()), Float.valueOf(this.f45501a.getTextSkewX()), Float.valueOf(this.f45501a.getLetterSpacing()), Integer.valueOf(this.f45501a.getFlags()), this.f45501a.getTextLocales(), this.f45501a.getTypeface(), Boolean.valueOf(this.f45501a.isElegantTextHeight()), this.f45502b, Integer.valueOf(this.f45503c), Integer.valueOf(this.f45504d));
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("{");
            sb2.append("textSize=" + this.f45501a.getTextSize());
            sb2.append(", textScaleX=" + this.f45501a.getTextScaleX());
            sb2.append(", textSkewX=" + this.f45501a.getTextSkewX());
            sb2.append(", letterSpacing=" + this.f45501a.getLetterSpacing());
            sb2.append(", elegantTextHeight=" + this.f45501a.isElegantTextHeight());
            sb2.append(", textLocale=" + this.f45501a.getTextLocales());
            sb2.append(", typeface=" + this.f45501a.getTypeface());
            sb2.append(", variationSettings=" + this.f45501a.getFontVariationSettings());
            sb2.append(", textDir=" + this.f45502b);
            sb2.append(", breakStrategy=" + this.f45503c);
            sb2.append(", hyphenationFrequency=" + this.f45504d);
            sb2.append("}");
            return sb2.toString();
        }
    }

    /* renamed from: a */
    public PrecomputedText m56771a() {
        Spannable spannable = this.f45499a;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f45499a.charAt(i10);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f45499a.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f45499a.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f45499a.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        return (T[]) this.f45500b.getSpans(i10, i11, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f45499a.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f45499a.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        this.f45500b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        this.f45500b.setSpan(obj, i10, i11, i12);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        return this.f45499a.subSequence(i10, i11);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f45499a.toString();
    }
}
