package com.huawei.phoneservice.faq.base.util;

import android.text.TextUtils;
import androidx.annotation.Keep;

/* loaded from: classes4.dex */
public class FaqStringUtil {
    @Keep
    public static boolean isEmpty(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && !"\"\"".equals(charSequence) && !"null".equals(charSequence)) {
            for (int i10 = 0; i10 < charSequence.length(); i10++) {
                char cCharAt = charSequence.charAt(i10);
                if (cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\r' && cCharAt != '\n') {
                    return false;
                }
            }
        }
        return true;
    }
}
