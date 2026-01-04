package p221d9;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.hicloud.task.simple.C3097x1;
import mn.InterfaceC11499c;
import p015ak.C0213f;
import p616rk.C12515a;
import p709vj.C13452e;

/* renamed from: d9.d */
/* loaded from: classes3.dex */
public class C9056d implements InterfaceC11499c {
    @Override // mn.InterfaceC11499c
    /* renamed from: a */
    public String mo57108a() {
        return "SysRefreshDailyCallback";
    }

    @Override // mn.InterfaceC11499c
    /* renamed from: b */
    public void mo57109b(Bundle bundle) {
        Context contextM1377a;
        if (!C13452e.m80781L().m80842P0() || (contextM1377a = C0213f.m1377a()) == null) {
            return;
        }
        C12515a.m75110o().m75172d(new C3097x1(contextM1377a, bundle));
    }
}
