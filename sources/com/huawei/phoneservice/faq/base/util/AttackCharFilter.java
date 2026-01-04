package com.huawei.phoneservice.faq.base.util;

import android.text.InputFilter;
import android.text.Spanned;
import androidx.annotation.Keep;
import java.util.regex.Pattern;

@Keep
/* loaded from: classes4.dex */
public class AttackCharFilter implements InputFilter {
    private final Pattern pattern = Pattern.compile("[\\u0733\\u0734\\u0736\\u0737]");

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        if (this.pattern.matcher(charSequence).find()) {
            return "";
        }
        return null;
    }
}
