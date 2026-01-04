package cn.com.miaozhen.mobile.tracking.viewability.origin;

import android.content.Context;
import android.view.View;
import cn.com.miaozhen.mobile.tracking.api.C1480d;
import cn.com.miaozhen.mobile.tracking.viewability.origin.p059e.C1501b;
import cn.com.miaozhen.mobile.tracking.viewability.origin.p059e.C1506g;
import com.huawei.riemann.location.common.utils.Constant;
import ijiami_release01.NCall;

/* renamed from: cn.com.miaozhen.mobile.tracking.viewability.origin.c */
/* loaded from: classes.dex */
public class C1498c {

    /* renamed from: a */
    public static boolean f6382a = true;

    /* renamed from: b */
    private InterfaceC1497b f6383b;

    static {
        NCall.m64618IV(new Object[]{Integer.valueOf(Constant.ERROR_ROTATION_ANGLE_INVALID)});
    }

    public C1498c(Context context, InterfaceC1496a interfaceC1496a, C1506g c1506g) {
        this.f6383b = null;
        this.f6383b = new C1501b(context, interfaceC1496a, c1506g);
    }

    /* renamed from: a */
    public void m8503a(String str) {
        NCall.m64618IV(new Object[]{265, this, str});
    }

    /* renamed from: a */
    public void m8504a(String str, View view, String str2, String str3, C1499d c1499d, MzCallBack mzCallBack, C1480d.a aVar) {
        NCall.m64618IV(new Object[]{266, this, str, view, str2, str3, c1499d, mzCallBack, aVar});
    }

    /* renamed from: a */
    public void m8505a(String str, MzCallBack mzCallBack, C1480d.a aVar) {
        NCall.m64618IV(new Object[]{267, this, str, mzCallBack, aVar});
    }
}
