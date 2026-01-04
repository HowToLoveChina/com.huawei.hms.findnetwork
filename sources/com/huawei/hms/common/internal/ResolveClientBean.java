package com.huawei.hms.common.internal;

/* loaded from: classes8.dex */
public class ResolveClientBean {

    /* renamed from: a */
    private final int f23507a;

    /* renamed from: b */
    private final AnyClient f23508b;

    /* renamed from: c */
    private int f23509c;

    public ResolveClientBean(AnyClient anyClient, int i10) {
        this.f23508b = anyClient;
        this.f23507a = Objects.hashCode(anyClient);
        this.f23509c = i10;
    }

    public void clientReconnect() {
        this.f23508b.connect(this.f23509c, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ResolveClientBean)) {
            return false;
        }
        return this.f23508b.equals(((ResolveClientBean) obj).f23508b);
    }

    public AnyClient getClient() {
        return this.f23508b;
    }

    public int hashCode() {
        return this.f23507a;
    }
}
