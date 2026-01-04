package com.huawei.phoneservice.faq.base.util;

import android.content.Context;
import android.widget.Toast;
import androidx.annotation.Keep;

/* loaded from: classes4.dex */
public class FaqToastUtils {
    @Keep
    public static void makeText(Context context, String str) throws Throwable {
        try {
            Toast toastMakeText = Toast.makeText(context, (CharSequence) null, 0);
            toastMakeText.setText(str);
            toastMakeText.show();
        } catch (Throwable unused) {
            FaqLogger.m51840e("FaqToastUtils", "toast makeText exception");
        }
    }
}
