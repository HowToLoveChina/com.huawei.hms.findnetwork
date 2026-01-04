package com.huawei.openalliance.p169ad;

import android.widget.CompoundButton;

/* renamed from: com.huawei.openalliance.ad.vm */
/* loaded from: classes8.dex */
public class C8191vm implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    private CompoundButton.OnCheckedChangeListener f38429a;

    /* renamed from: b */
    private boolean f38430b = false;

    public C8191vm(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f38429a = onCheckedChangeListener;
    }

    /* renamed from: a */
    public void m50730a(boolean z10) {
        this.f38430b = z10;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        if (this.f38430b) {
            this.f38429a.onCheckedChanged(compoundButton, z10);
        } else {
            AbstractC7185ho.m43820b("OAIDOnCheckedChangeListener", "not click able");
        }
    }
}
