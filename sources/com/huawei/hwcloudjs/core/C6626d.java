package com.huawei.hwcloudjs.core;

import android.content.Context;
import com.huawei.hwcloudjs.p164f.C6659d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.huawei.hwcloudjs.core.d */
/* loaded from: classes8.dex */
public class C6626d {

    /* renamed from: a */
    private static final String f30807a = "JsListenerCenter";

    /* renamed from: b */
    private static C6626d f30808b = new C6626d();

    /* renamed from: c */
    private final List<Class<? extends InterfaceC6625c>> f30809c = new ArrayList();

    /* renamed from: a */
    public static C6626d m37771a() {
        return f30808b;
    }

    /* renamed from: a */
    public void m37772a(Context context, String str, String str2, String str3, List<String> list, JSONObject jSONObject) {
        String str4;
        InterfaceC6625c interfaceC6625cNewInstance;
        C6659d.m37882c(f30807a, "onCompletedConfig begin", true);
        synchronized (this.f30809c) {
            Iterator<Class<? extends InterfaceC6625c>> it = this.f30809c.iterator();
            while (it.hasNext()) {
                try {
                    interfaceC6625cNewInstance = it.next().newInstance();
                } catch (IllegalAccessException unused) {
                } catch (InstantiationException unused2) {
                }
                try {
                    if (list.contains(interfaceC6625cNewInstance.getApi())) {
                        interfaceC6625cNewInstance.onCompletedConfig(context, str, str2, str3, jSONObject);
                    }
                } catch (IllegalAccessException unused3) {
                    str4 = "IllegalAccessException";
                    C6659d.m37881b(f30807a, str4, true);
                } catch (InstantiationException unused4) {
                    str4 = "InstantiationException";
                    C6659d.m37881b(f30807a, str4, true);
                }
            }
        }
    }

    /* renamed from: a */
    public void m37773a(Class<? extends InterfaceC6625c> cls) {
        synchronized (this.f30809c) {
            this.f30809c.add(cls);
        }
    }

    /* renamed from: a */
    public void m37774a(String str) {
        String str2;
        C6659d.m37882c(f30807a, "onDestroy begin", true);
        synchronized (this.f30809c) {
            Iterator<Class<? extends InterfaceC6625c>> it = this.f30809c.iterator();
            while (it.hasNext()) {
                try {
                    it.next().newInstance().onDestroy(str);
                } catch (IllegalAccessException unused) {
                    str2 = "IllegalAccessException";
                    C6659d.m37881b(f30807a, str2, true);
                } catch (InstantiationException unused2) {
                    str2 = "InstantiationException";
                    C6659d.m37881b(f30807a, str2, true);
                }
            }
        }
    }
}
