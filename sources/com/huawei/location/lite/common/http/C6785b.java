package com.huawei.location.lite.common.http;

import java.util.HashMap;
import tr.InterfaceC13062f;

/* renamed from: com.huawei.location.lite.common.http.b */
/* loaded from: classes8.dex */
public class C6785b {

    /* renamed from: a */
    public static final HashMap<String, Class> f31375a = new HashMap<>();

    /* renamed from: a */
    public static InterfaceC13062f m38447a(String str) {
        Class cls = f31375a.get(str);
        if (cls == null) {
            return null;
        }
        try {
            return (InterfaceC13062f) cls.newInstance();
        } catch (Exception unused) {
            return null;
        }
    }
}
