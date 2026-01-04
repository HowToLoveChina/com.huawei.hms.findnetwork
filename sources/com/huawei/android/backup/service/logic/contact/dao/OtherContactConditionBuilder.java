package com.huawei.android.backup.service.logic.contact.dao;

import android.content.Context;
import java.util.ArrayList;
import p385j5.InterfaceC10709a;
import p444l5.AbstractC11233a;
import p444l5.C11237e;
import p444l5.C11239g;
import p699v4.C13348q;

/* loaded from: classes.dex */
public class OtherContactConditionBuilder implements InterfaceC10709a {

    /* renamed from: a */
    public Context f9606a;

    public OtherContactConditionBuilder(Context context) {
        this.f9606a = context;
    }

    /* renamed from: a */
    public final String m12771a() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(account_type is null or ");
        ArrayList<C11239g> arrayListM67440f = AbstractC11233a.m67440f(this.f9606a);
        if (C13348q.m80082b(arrayListM67440f)) {
            sb2.append("account_type not like '%sim%')");
        } else {
            sb2.append("(account_type not in (");
            StringBuilder sb3 = new StringBuilder();
            for (C11239g c11239g : arrayListM67440f) {
                sb3.append(",'");
                sb3.append(c11239g.m67538c());
                sb3.append("'");
            }
            if (sb3.length() > 0) {
                sb2.append(sb3.substring(1, sb3.length()));
                sb2.append(") and account_type not like '%sim%'))");
            }
        }
        return sb2.toString();
    }

    @Override // p385j5.InterfaceC10709a
    public InterfaceC10709a addBuilder(InterfaceC10709a interfaceC10709a) {
        return this;
    }

    @Override // p385j5.InterfaceC10709a
    public String build() {
        return C11237e.m67530j(this.f9606a) ? "" : m12771a();
    }
}
