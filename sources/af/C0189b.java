package af;

import android.text.TextUtils;
import com.huawei.android.remotecontrol.config.FindWebConfigInfo;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import p292fn.C9733f;
import p371ik.C10527a;
import p809yg.C13981a;

/* renamed from: af.b */
/* loaded from: classes4.dex */
public class C0189b {

    /* renamed from: af.b$b */
    public static class b {

        /* renamed from: a */
        public static C0189b f751a = new C0189b();
    }

    /* renamed from: a */
    public static C0189b m1071a() {
        return b.f751a;
    }

    /* renamed from: b */
    public final FindWebConfigInfo m1072b() {
        HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
        if (hiCloudSysParamMapM60758q == null) {
            C13981a.m83990w("FindSysParamManager", "getWebViewConfig config file is empty");
            return new FindWebConfigInfo();
        }
        String findWebViewSetting = hiCloudSysParamMapM60758q.getFindWebViewSetting();
        if (TextUtils.isEmpty(findWebViewSetting)) {
            C13981a.m83990w("FindSysParamManager", "getWebViewConfig config is empty");
            return new FindWebConfigInfo();
        }
        C13981a.m83987d("FindSysParamManager", "getWebViewConfig config string:" + findWebViewSetting);
        FindWebConfigInfo findWebConfigInfo = (FindWebConfigInfo) C10527a.m64629g(findWebViewSetting, FindWebConfigInfo.class);
        if (findWebConfigInfo != null) {
            return findWebConfigInfo;
        }
        C13981a.m83990w("FindSysParamManager", "getWebViewConfig parseObject is empty");
        return new FindWebConfigInfo();
    }

    /* renamed from: c */
    public boolean m1073c() {
        int findWapAccSwitch = m1072b().getFindWapAccSwitch();
        C13981a.m83989i("FindSysParamManager", "findWapAcc:" + findWapAccSwitch);
        return findWapAccSwitch == 1;
    }

    public C0189b() {
    }
}
