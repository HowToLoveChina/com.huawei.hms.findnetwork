package com.huawei.phoneservice.feedbackcommon.utils.encrypt;

import android.content.Context;
import com.huawei.phoneservice.feedbackcommon.utils.C8661c;
import com.huawei.secure.android.common.encrypt.aes.AesGcm;

/* renamed from: com.huawei.phoneservice.feedbackcommon.utils.encrypt.a */
/* loaded from: classes5.dex */
public class C8664a {
    /* renamed from: a */
    public static String m53417a(Context context) {
        return AesGcm.decrypt(C8661c.m53398b(context, "r_config", "faq_normal_config"), C8665b.m53418a(context));
    }
}
