package com.huawei.hicloud.base.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hicloud.base.R$color;
import com.huawei.hicloud.base.R$id;
import com.huawei.hicloud.base.R$layout;
import com.huawei.hicloud.base.R$string;
import p015ak.C0209d;
import p399jk.AbstractC10896a;
import sk.C12809f;

/* loaded from: classes6.dex */
public class HightLightNumView extends RelativeLayout {

    /* renamed from: a */
    public TextView f22181a;

    /* renamed from: b */
    public float f22182b;

    public HightLightNumView(Context context) {
        this(context, null);
    }

    private ForegroundColorSpan getColorSpan() {
        Resources resources;
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null) {
            return null;
        }
        return new ForegroundColorSpan(resources.getColor(R$color.emui_color_text_primary, null));
    }

    private int getNoneUsedSizeFontScaleSize() {
        float f10 = this.f22182b;
        if (f10 >= 1.75f && f10 < 2.0f) {
            return 28;
        }
        if (f10 < 2.0f || f10 >= 3.2f) {
            return f10 >= 3.2f ? 50 : 16;
        }
        return 32;
    }

    private int getNormalTextFontScaleSize() {
        float f10 = this.f22182b;
        if (f10 >= 1.75f && f10 < 2.0f) {
            return 35;
        }
        if (f10 < 2.0f || f10 >= 3.2f) {
            return f10 >= 3.2f ? 64 : 20;
        }
        return 40;
    }

    private ForegroundColorSpan getSecondaryColorSpan() {
        Resources resources;
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null) {
            return null;
        }
        return new ForegroundColorSpan(resources.getColor(R$color.emui_color_text_secondary, null));
    }

    private int getUsedSpaceSizeFontScaleSize() {
        float f10 = this.f22182b;
        if (f10 >= 1.75f && f10 < 2.0f) {
            return 52;
        }
        if (f10 < 2.0f || f10 >= 3.2f) {
            return f10 >= 3.2f ? 96 : 30;
        }
        return 60;
    }

    private int getUsedTextFontScaleSize() {
        float f10 = this.f22182b;
        if (f10 >= 1.75f && f10 < 2.0f) {
            return 24;
        }
        if (f10 < 2.0f || f10 >= 3.2f) {
            return f10 >= 3.2f ? 44 : 14;
        }
        return 28;
    }

    /* renamed from: a */
    public final SpannableString m29161a(Context context, SpannableString spannableString, String str, String str2, String str3, String str4) {
        if (context == null) {
            AbstractC10896a.m65886e("HightLightNumView", "getSpannableTitleText exception: context == null");
            return spannableString;
        }
        int iIndexOf = str.indexOf(str2);
        int length = str2.length() + iIndexOf;
        int iIndexOf2 = str.substring(0, str.indexOf(context.getString(R$string.cloudpay_used_total_space, "", ""))).indexOf(str3);
        int length2 = str3.length() + iIndexOf2;
        int iIndexOf3 = str.indexOf(str4);
        int length3 = str4.length() + iIndexOf3;
        if (iIndexOf >= 0 && length >= 0) {
            spannableString.setSpan(new AbsoluteSizeSpan(getUsedTextFontScaleSize(), true), iIndexOf, length, 33);
            ForegroundColorSpan colorSpan = getColorSpan();
            if (colorSpan != null) {
                spannableString.setSpan(colorSpan, iIndexOf, length, 33);
            }
        }
        if (iIndexOf2 >= 0 && length2 >= 0) {
            spannableString.setSpan(new AbsoluteSizeSpan(getUsedSpaceSizeFontScaleSize(), true), iIndexOf2, length2, 33);
            ForegroundColorSpan colorSpan2 = getColorSpan();
            if (colorSpan2 != null) {
                spannableString.setSpan(colorSpan2, iIndexOf2, length2, 33);
            }
            spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf2, length2, 33);
        }
        if (iIndexOf3 >= 0 && length3 >= 0) {
            spannableString.setSpan(new AbsoluteSizeSpan(getNoneUsedSizeFontScaleSize(), true), iIndexOf3, length3, 33);
            ForegroundColorSpan secondaryColorSpan = getSecondaryColorSpan();
            if (secondaryColorSpan != null) {
                spannableString.setSpan(secondaryColorSpan, iIndexOf3, length3, 33);
            }
        }
        return spannableString;
    }

    /* renamed from: b */
    public final void m29162b(Context context) {
        if (this.f22182b >= 1.75f) {
            View.inflate(context, R$layout.high_light_num_font_scale, this);
        } else {
            View.inflate(context, R$layout.high_light_num, this);
        }
    }

    /* renamed from: c */
    public final void m29163c(Context context) {
        this.f22182b = C0209d.m1195O(context);
        m29162b(context);
        this.f22181a = (TextView) C12809f.m76831d(this, R$id.hight_light);
    }

    /* renamed from: d */
    public void m29164d(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2.isEmpty()) {
            return;
        }
        try {
            int length = str.length();
            SpannableString spannableString = new SpannableString(str.concat(str2));
            spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), 0, length, 33);
            spannableString.setSpan(new AbsoluteSizeSpan(getNormalTextFontScaleSize(), true), 0, length, 33);
            ForegroundColorSpan colorSpan = getColorSpan();
            if (colorSpan != null) {
                spannableString.setSpan(colorSpan, 0, length, 33);
            }
            this.f22181a.setText(spannableString);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HightLightNumView", "setTitleText exception:" + e10.toString());
        }
    }

    /* renamed from: e */
    public void m29165e(int i10, String str, String str2, String str3) throws Resources.NotFoundException {
        Resources resources;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str3.isEmpty()) {
            return;
        }
        try {
            Context context = getContext();
            if (context == null || (resources = context.getResources()) == null) {
                return;
            }
            String string = resources.getString(i10, " " + str2.concat(str3));
            this.f22181a.setText(m29161a(context, new SpannableString(string), string, str, str2, str3));
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HightLightNumView", "setTitleText exception:" + e10.toString());
        }
    }

    public HightLightNumView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HightLightNumView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m29163c(context);
    }
}
