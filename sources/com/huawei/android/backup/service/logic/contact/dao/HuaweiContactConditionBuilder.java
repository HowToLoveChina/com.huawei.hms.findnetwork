package com.huawei.android.backup.service.logic.contact.dao;

import android.content.Context;
import p385j5.InterfaceC10709a;
import p444l5.C11237e;
import p444l5.C11241i;

/* loaded from: classes.dex */
public class HuaweiContactConditionBuilder implements InterfaceC10709a {

    /* renamed from: a */
    public Context f9605a;

    public HuaweiContactConditionBuilder(Context context) {
        this.f9605a = context;
    }

    @Override // p385j5.InterfaceC10709a
    public InterfaceC10709a addBuilder(InterfaceC10709a interfaceC10709a) {
        return this;
    }

    @Override // p385j5.InterfaceC10709a
    public String build() {
        return C11237e.m67530j(this.f9605a) ? C11241i.f52783h : "";
    }
}
