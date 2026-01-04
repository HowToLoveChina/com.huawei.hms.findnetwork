package com.huawei.openalliance.p169ad.inter.data;

import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.inter.data.f */
/* loaded from: classes2.dex */
public class C7303f implements IPreCheckInfo {

    /* renamed from: a */
    private String f33855a;

    /* renamed from: b */
    private String f33856b;

    /* renamed from: c */
    private Map<String, String> f33857c;

    /* renamed from: d */
    private int f33858d = -1;

    /* renamed from: e */
    private boolean f33859e;

    /* renamed from: a */
    public void m44859a(int i10) {
        this.f33858d = i10;
    }

    /* renamed from: b */
    public void m44863b(String str) {
        this.f33856b = str;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPreCheckInfo
    public String getContentId() {
        return this.f33856b;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPreCheckInfo
    public Map<String, String> getExt() {
        return this.f33857c;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPreCheckInfo
    public int getPreCheckResult() {
        return this.f33858d;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPreCheckInfo
    public String getSlotId() {
        return this.f33855a;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPreCheckInfo
    public boolean isStrategyFiltered() {
        return this.f33859e;
    }

    /* renamed from: a */
    public void m44860a(String str) {
        this.f33855a = str;
    }

    /* renamed from: a */
    public void m44861a(Map<String, String> map) {
        this.f33857c = map;
    }

    /* renamed from: a */
    public void m44862a(boolean z10) {
        this.f33859e = z10;
    }
}
