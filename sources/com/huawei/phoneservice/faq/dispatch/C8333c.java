package com.huawei.phoneservice.faq.dispatch;

import android.content.Intent;
import android.os.BadParcelableException;
import android.text.TextUtils;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.phoneservice.faq.dispatch.c */
/* loaded from: classes4.dex */
public class C8333c {

    /* renamed from: a */
    public static final Map<String, InterfaceC8334d> f38750a;

    static {
        HashMap map = new HashMap();
        f38750a = map;
        map.put(FaqConstants.PATH_FAQ, new C8332b());
        map.put(FaqConstants.GOTOFAQ, new C8331a());
    }

    /* renamed from: a */
    public static InterfaceC8334d m51917a(Intent intent) throws Throwable {
        InterfaceC8334d interfaceC8334d;
        InterfaceC8334d interfaceC8334d2 = null;
        if (intent == null) {
            return null;
        }
        try {
            if (intent.getData() != null && intent.getData().getPath() != null) {
                interfaceC8334d = f38750a.get(intent.getData().getPath());
            } else if (!TextUtils.isEmpty(intent.getStringExtra(FaqConstants.GOTOFAQ))) {
                interfaceC8334d = f38750a.get(FaqConstants.GOTOFAQ);
            } else {
                if (!intent.getBooleanExtra(FaqConstants.GO_TO_FAQ, false)) {
                    return null;
                }
                interfaceC8334d = f38750a.get(FaqConstants.PATH_FAQ);
            }
            interfaceC8334d2 = interfaceC8334d;
            return interfaceC8334d2;
        } catch (BadParcelableException e10) {
            FaqLogger.print("FaqDispatchFactory", "BadParcelableException: " + e10.getMessage());
            return interfaceC8334d2;
        }
    }
}
