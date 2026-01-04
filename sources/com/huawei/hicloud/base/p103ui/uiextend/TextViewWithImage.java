package com.huawei.hicloud.base.p103ui.uiextend;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class TextViewWithImage extends TextView {

    /* renamed from: a */
    public static final Pattern f22176a = Pattern.compile("\\Q[img]\\E");

    /* renamed from: com.huawei.hicloud.base.ui.uiextend.TextViewWithImage$b */
    public static class C4861b {

        /* renamed from: a */
        public int f22177a;

        /* renamed from: b */
        public int f22178b;

        /* renamed from: c */
        public int f22179c;

        /* renamed from: d */
        public int f22180d;

        public C4861b() {
        }
    }

    public TextViewWithImage(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    /* renamed from: a */
    public static boolean m29144a(Context context, Spannable spannable, int i10, int i11, int i12) {
        C4861b c4861bM29150g = m29150g(spannable);
        spannable.setSpan(m29148e(context, i10, i12), c4861bM29150g.f22177a, c4861bM29150g.f22178b, 33);
        spannable.setSpan(m29148e(context, i11, i12), c4861bM29150g.f22179c, c4861bM29150g.f22180d, 33);
        return true;
    }

    /* renamed from: b */
    public static boolean m29145b(Context context, Spannable spannable, Bitmap bitmap, Bitmap bitmap2, int i10) {
        C4861b c4861bM29150g = m29150g(spannable);
        spannable.setSpan(m29149f(context, bitmap, i10), c4861bM29150g.f22177a, c4861bM29150g.f22178b, 33);
        spannable.setSpan(m29149f(context, bitmap2, i10), c4861bM29150g.f22179c, c4861bM29150g.f22180d, 33);
        return true;
    }

    /* renamed from: c */
    public static boolean m29146c(Context context, Spannable spannable, int i10, int i11) {
        C4861b c4861bM29151h = m29151h(spannable);
        if (c4861bM29151h == null) {
            return false;
        }
        spannable.setSpan(m29148e(context, i10, i11), c4861bM29151h.f22177a, c4861bM29151h.f22178b, 33);
        return true;
    }

    /* renamed from: d */
    public static boolean m29147d(Context context, Spannable spannable, Bitmap bitmap, int i10) {
        C4861b c4861bM29151h = m29151h(spannable);
        if (c4861bM29151h == null) {
            return false;
        }
        spannable.setSpan(m29149f(context, bitmap, i10), c4861bM29151h.f22177a, c4861bM29151h.f22178b, 33);
        return true;
    }

    /* renamed from: e */
    public static ImageSpan m29148e(Context context, int i10, int i11) {
        Drawable drawable = context.getDrawable(i10);
        drawable.mutate();
        drawable.setBounds(0, 0, i11, i11);
        return new ImageSpan(drawable);
    }

    /* renamed from: f */
    public static ImageSpan m29149f(Context context, Bitmap bitmap, int i10) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        bitmapDrawable.mutate();
        bitmapDrawable.setBounds(0, 0, i10, i10);
        return new ImageSpan(bitmapDrawable);
    }

    /* renamed from: g */
    public static C4861b m29150g(Spannable spannable) {
        C4861b c4861b = new C4861b();
        Matcher matcher = Pattern.compile("\\Q[img1]\\E").matcher(spannable);
        if (matcher.find()) {
            c4861b.f22177a = matcher.start();
            c4861b.f22178b = matcher.end();
        }
        Matcher matcher2 = Pattern.compile("\\Q[img2]\\E").matcher(spannable);
        if (matcher2.find()) {
            c4861b.f22179c = matcher2.start();
            c4861b.f22180d = matcher2.end();
        }
        return c4861b;
    }

    /* renamed from: h */
    public static C4861b m29151h(Spannable spannable) {
        Matcher matcher = f22176a.matcher(spannable);
        if (!matcher.find()) {
            return null;
        }
        C4861b c4861b = new C4861b();
        c4861b.f22177a = matcher.start();
        c4861b.f22178b = matcher.end();
        return c4861b;
    }

    /* renamed from: i */
    public static Spannable m29152i(Context context, CharSequence charSequence, int i10, int i11, int i12) {
        Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(charSequence);
        m29144a(context, spannableNewSpannable, i10, i11, i12);
        return spannableNewSpannable;
    }

    /* renamed from: j */
    public static Spannable m29153j(Context context, CharSequence charSequence, Bitmap bitmap, Bitmap bitmap2, int i10) {
        Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(charSequence);
        m29145b(context, spannableNewSpannable, bitmap, bitmap2, i10);
        return spannableNewSpannable;
    }

    /* renamed from: k */
    public static Spannable m29154k(Context context, CharSequence charSequence, int i10, int i11) {
        Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(charSequence);
        m29146c(context, spannableNewSpannable, i10, i11);
        return spannableNewSpannable;
    }

    /* renamed from: l */
    public static Spannable m29155l(Context context, CharSequence charSequence, Bitmap bitmap, int i10) {
        Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(charSequence);
        m29147d(context, spannableNewSpannable, bitmap, i10);
        return spannableNewSpannable;
    }

    /* renamed from: m */
    public void m29156m(CharSequence charSequence, int i10) {
        super.setText(m29154k(getContext(), charSequence, i10, getLineHeight()), TextView.BufferType.SPANNABLE);
    }

    /* renamed from: n */
    public void m29157n(CharSequence charSequence, int i10, int i11) {
        super.setText(m29152i(getContext(), charSequence, i10, i11, getLineHeight()), TextView.BufferType.SPANNABLE);
    }

    /* renamed from: o */
    public void m29158o(CharSequence charSequence, Bitmap bitmap) {
        super.setText(m29155l(getContext(), charSequence, bitmap, getLineHeight()), TextView.BufferType.SPANNABLE);
    }

    /* renamed from: p */
    public void m29159p(CharSequence charSequence, Bitmap bitmap, Bitmap bitmap2) {
        super.setText(m29153j(getContext(), charSequence, bitmap, bitmap2, getLineHeight()), TextView.BufferType.SPANNABLE);
    }

    public TextViewWithImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TextViewWithImage(Context context) {
        super(context);
    }
}
