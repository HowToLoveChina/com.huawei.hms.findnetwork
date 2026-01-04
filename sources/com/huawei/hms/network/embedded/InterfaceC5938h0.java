package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.AbstractRunnableC5912f0;

/* renamed from: com.huawei.hms.network.embedded.h0 */
/* loaded from: classes8.dex */
public interface InterfaceC5938h0 {

    /* renamed from: a */
    public static final String f26896a = "Dns";

    /* renamed from: b */
    public static final InterfaceC5938h0 f26897b = new a();

    /* renamed from: c */
    public static final InterfaceC5938h0 f26898c = new b();

    /* renamed from: d */
    public static final InterfaceC5938h0 f26899d = new c();

    /* renamed from: com.huawei.hms.network.embedded.h0$a */
    public class a implements InterfaceC5938h0 {
        @Override // com.huawei.hms.network.embedded.InterfaceC5938h0
        public C6003m0 lookup(String str) {
            return C5925g0.m34275a(new C5977k0(str, "dns_sync_query", new AbstractRunnableC5912f0.b()));
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.h0$b */
    public class b implements InterfaceC5938h0 {
        @Override // com.huawei.hms.network.embedded.InterfaceC5938h0
        public C6003m0 lookup(String str) {
            return C5925g0.m34275a(new C5899e0(str, null));
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.h0$c */
    public class c implements InterfaceC5938h0 {
        @Override // com.huawei.hms.network.embedded.InterfaceC5938h0
        public C6003m0 lookup(String str) {
            return C5925g0.m34275a(new C5964j0(str, "dns_sync_query", new AbstractRunnableC5912f0.b()));
        }
    }

    C6003m0 lookup(String str);
}
