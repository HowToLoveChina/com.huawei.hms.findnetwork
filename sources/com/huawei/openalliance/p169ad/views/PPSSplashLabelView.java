package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.beans.metadata.AdSource;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;

/* loaded from: classes2.dex */
public class PPSSplashLabelView extends PPSLabelView {
    public PPSSplashLabelView(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void m49649a(AdSource adSource, String str, Integer num, boolean z10) {
        this.f36776b = num;
        this.f36777c = z10;
        mo49217b(adSource, str);
    }

    @Override // com.huawei.openalliance.p169ad.views.PPSLabelView
    /* renamed from: b */
    public void mo49217b(AdSource adSource, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (adSource == null) {
            AbstractC7185ho.m43820b("PPSSplashLabelView", "adSource is null");
            setClick(spannableStringBuilder);
            return;
        }
        String strM48168c = AbstractC7806cz.m48168c(adSource.m39551a()) == null ? "" : AbstractC7806cz.m48168c(adSource.m39551a());
        if (str == null) {
            str = "";
        }
        String str2 = strM48168c + str;
        String strM39554b = adSource.m39554b();
        if (TextUtils.isEmpty(strM48168c) && TextUtils.isEmpty(strM39554b)) {
            setClick(spannableStringBuilder);
        } else if (TextUtils.isEmpty(strM48168c) || !TextUtils.isEmpty(strM39554b)) {
            m49213a(str2, strM39554b);
        } else {
            setClick(new SpannableStringBuilder(str2));
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.PPSLabelView
    public void setTextWhenImgLoadFail(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append((CharSequence) str);
        }
        setClick(spannableStringBuilder);
    }

    public PPSSplashLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.openalliance.p169ad.views.PPSLabelView
    /* renamed from: a */
    public void mo49212a(String str, Drawable drawable) {
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            boolean z10 = !TextUtils.isEmpty(str);
            spannableStringBuilder.append((CharSequence) str);
            ImageSpan imageSpanM49209a = m49209a(drawable, z10);
            if (imageSpanM49209a != null) {
                spannableStringBuilder.setSpan(imageSpanM49209a, 0, 1, 33);
            }
            setClick(spannableStringBuilder);
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("PPSSplashLabelView", "setTextWhenImgLoaded error");
        }
    }

    public PPSSplashLabelView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
