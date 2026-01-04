package p292fn;

import cn.C1461a;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import gp.C10028c;

/* renamed from: fn.g */
/* loaded from: classes6.dex */
public class C9734g {

    /* renamed from: fn.g$b */
    public static class b {

        /* renamed from: a */
        public static C9734g f47984a = new C9734g();
    }

    /* renamed from: a */
    public static C9734g m60767a() {
        return b.f47984a;
    }

    /* renamed from: b */
    public int m60768b() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p != null) {
            return hiCloudSysParamMapM60757p.getDownloadOMConfigFileFlowControl();
        }
        C1461a.m8358e("OMConfigFlowManager", "getOMConfigFileFlowControlInteval configMap is null");
        return 30;
    }

    /* renamed from: c */
    public void m60769c(String str) {
        C1461a.m8359i("OMConfigFlowManager", "resetControlData configPoint: " + str);
        C10028c.m62182c0().m62357l3(0L, str);
        C10028c.m62182c0().m62397t3(0, str);
        C10028c.m62182c0().m62402u3(0L, str);
        C10028c.m62182c0().m62244M1(str);
    }

    public C9734g() {
    }
}
