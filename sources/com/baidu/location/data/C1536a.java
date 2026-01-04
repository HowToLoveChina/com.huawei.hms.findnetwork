package com.baidu.location.data;

import android.util.Log;

/* renamed from: com.baidu.location.data.a */
/* loaded from: classes.dex */
public class C1536a {

    /* renamed from: a */
    public static boolean f6685a = false;

    /* renamed from: a */
    public static void m8738a(Exception exc) {
        if (f6685a) {
            exc.printStackTrace();
            m8739a(exc.getMessage());
        }
    }

    /* renamed from: a */
    public static void m8739a(String str) {
        if (f6685a) {
            Log.e("data", "" + str);
        }
    }
}
