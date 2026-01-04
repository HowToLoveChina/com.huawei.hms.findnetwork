package com.huawei.hms.aaid.encrypt;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.opendevice.AbstractC6274l;
import cu.C8952a;

/* loaded from: classes8.dex */
public class PushEncrypter {
    public static String decrypter(Context context, String str) {
        return TextUtils.isEmpty(str) ? "" : C8952a.m56686h(str, AbstractC6274l.m36455b(context));
    }

    public static String encrypter(Context context, String str) {
        return TextUtils.isEmpty(str) ? "" : C8952a.m56690l(str, AbstractC6274l.m36455b(context));
    }

    public static String encrypterOld(Context context, String str) {
        return TextUtils.isEmpty(str) ? "" : C8952a.m56691m(str, AbstractC6274l.m36451a(context));
    }
}
