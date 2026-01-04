package com.huawei.android.backup.service.logic.contact.dao;

import android.content.Context;
import java.util.Locale;
import p385j5.C10710b;
import p385j5.InterfaceC10709a;

/* loaded from: classes.dex */
public class DefaultContactConditionBuilder implements InterfaceC10709a {

    /* renamed from: a */
    public Context f9603a;

    /* renamed from: b */
    public InterfaceC10709a f9604b = new C10710b();

    public DefaultContactConditionBuilder(Context context) {
        this.f9603a = context;
        m12770a();
    }

    /* renamed from: a */
    public final void m12770a() {
        this.f9604b.addBuilder(new HuaweiContactConditionBuilder(this.f9603a)).addBuilder(new OtherContactConditionBuilder(this.f9603a));
    }

    @Override // p385j5.InterfaceC10709a
    public InterfaceC10709a addBuilder(InterfaceC10709a interfaceC10709a) {
        if (interfaceC10709a != null) {
            this.f9604b.addBuilder(interfaceC10709a);
        }
        return this;
    }

    @Override // p385j5.InterfaceC10709a
    public String build() {
        return String.format(Locale.ROOT, "deleted = 0 AND account_id in (select _id from accounts where %s)", this.f9604b.build());
    }
}
