package com.huawei.phoneservice.feedbackcommon.utils.encrypt;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.phoneservice.feedbackcommon.R$string;
import com.huawei.phoneservice.feedbackcommon.utils.C8661c;
import gu.C10050d;

/* renamed from: com.huawei.phoneservice.feedbackcommon.utils.encrypt.b */
/* loaded from: classes5.dex */
public class C8665b {

    /* renamed from: a */
    public static String f40361a = "";

    /* renamed from: a */
    public static String m53418a(Context context) {
        if (TextUtils.isEmpty(f40361a)) {
            m53419b(context);
        }
        return f40361a;
    }

    /* renamed from: b */
    public static void m53419b(Context context) {
        f40361a = C10050d.m62478e("4b5e505724af766fd53ee28510651144397bf939b10f83e1437354b761f6a2b2b7afc5acfe347f63b19fd6ce9b03f98ed26392ebce804fe6f915c7bb3b69768f666e8f20acdced78adaa66b6625684cfb9dffbbc05e8ba82c49ac8edb416f68a15e1c0d2936b4216974cab0bf0fa6d24ee7055a05cfa00e61479e3e4e8f7fe66", C8661c.m53398b(context, "k2_config", "faq_normal_config"), context.getString(R$string.k3_config), C8661c.m53398b(context, "yekr4_config", "faq_normal_config")).m62482d();
    }
}
