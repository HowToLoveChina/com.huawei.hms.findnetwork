package com.huawei.hms.support.hwid.common;

import android.content.Context;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.support.hwid.common.a */
/* loaded from: classes8.dex */
public class C6462a {

    /* renamed from: a */
    private static C6462a f30004a;

    /* renamed from: b */
    private Map<String, List<String>> f30005b = new HashMap();

    /* renamed from: c */
    private Context f30006c;

    private C6462a() {
    }

    /* renamed from: a */
    public static synchronized C6462a m36833a() {
        try {
            if (f30004a == null) {
                f30004a = new C6462a();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f30004a;
    }

    /* renamed from: b */
    public Context m36836b() {
        return this.f30006c;
    }

    /* renamed from: c */
    public List<String> m36837c() {
        return this.f30005b.get("packageNamesNotUseApk");
    }

    /* renamed from: a */
    public void m36834a(Context context) {
        this.f30006c = context;
    }

    /* renamed from: a */
    public void m36835a(List<String> list) {
        this.f30005b.put("packageNamesNotUseApk", list);
    }
}
