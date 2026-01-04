package com.huawei.hms.opendevice;

import android.text.TextUtils;

/* renamed from: com.huawei.hms.opendevice.n */
/* loaded from: classes8.dex */
public class C6276n {
    /* renamed from: a */
    public static boolean m36469a(String... strArr) {
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
        }
        return true;
    }
}
