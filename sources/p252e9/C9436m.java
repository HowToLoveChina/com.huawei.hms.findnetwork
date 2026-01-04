package p252e9;

import android.content.Context;
import android.text.TextUtils;
import cn.C1461a;
import com.huawei.hicloud.bean.SpaceInsufficientH5PageInfo;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.secure.android.common.intent.SafeIntent;
import gp.C10028c;
import java.util.HashMap;
import java.util.Map;
import p292fn.C9733f;
import p336he.C10155f;
import p514o9.C11839m;
import p709vj.C13452e;

/* renamed from: e9.m */
/* loaded from: classes3.dex */
public class C9436m {

    /* renamed from: a */
    public Map<String, String> f47135a = new HashMap();

    /* renamed from: e9.m$a */
    public static class a {

        /* renamed from: a */
        public static C9436m f47136a = new C9436m();
    }

    /* renamed from: d */
    public static C9436m m59180d() {
        return a.f47136a;
    }

    /* renamed from: a */
    public void m59181a(Context context) {
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70688i("ServiceChangeManage", "gotoServiceChangeH5 not login");
            return;
        }
        if (C10028c.m62182c0().m62191B1()) {
            C11839m.m70688i("ServiceChangeManage", "gotoServiceChangeH5 isReceiveActivityGift");
            return;
        }
        boolean zM80807G0 = C13452e.m80781L().m80807G0("is_bm_type");
        C11839m.m70688i("ServiceChangeManage", "isContainsBmType " + zM80807G0);
        if (zM80807G0) {
            C11839m.m70688i("ServiceChangeManage", "new bm type: " + C13452e.m80781L().m80887a1());
            String[] strArrM59183c = m59183c();
            if (TextUtils.isEmpty(strArrM59183c[1])) {
                C11839m.m70689w("ServiceChangeManage", "h5Url is empty");
                return;
            }
            if (TextUtils.equals(strArrM59183c[0], "bmNewUserGuidPage") && !C13452e.m80781L().m80791C0()) {
                C11839m.m70689w("ServiceChangeManage", "current user is new member");
                return;
            }
            boolean zEquals = TextUtils.equals(C13452e.m80781L().m80790C(), "N");
            if (TextUtils.equals(strArrM59183c[0], "bmFreeUserGuidPage") && !zEquals) {
                C11839m.m70689w("ServiceChangeManage", "current user is old member");
                return;
            }
            if (TextUtils.equals(strArrM59183c[0], "bmPaidUserGuidPage") && zEquals) {
                C11839m.m70689w("ServiceChangeManage", "current user is old free");
                return;
            }
            try {
                C11839m.m70688i("ServiceChangeManage", "getOperWebViewIntent");
                SafeIntent safeIntent = new SafeIntent(NotifyUtil.getOperWebViewIntent(context, strArrM59183c[1], 7));
                safeIntent.putExtra("is_support_orientation", false);
                safeIntent.putExtra("is_support_dark_mode", true);
                safeIntent.putExtra("page_source_type", strArrM59183c[0]);
                safeIntent.putExtra("actionbar_background", true);
                safeIntent.putExtra("isFormMainPage", true);
                context.startActivity(safeIntent);
                m59182b();
            } catch (Exception e10) {
                C11839m.m70687e("ServiceChangeManage", "getOperWebViewIntent error: " + e10.getMessage());
            }
        }
    }

    /* renamed from: b */
    public void m59182b() {
        this.f47135a.clear();
        C13452e.m80781L().m80969s2("");
        C13452e.m80781L().m80973t2("");
        C13452e.m80781L().m80977u2("");
    }

    /* renamed from: c */
    public String[] m59183c() {
        String[] strArr = new String[2];
        for (Map.Entry<String, String> entry : this.f47135a.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(value)) {
                strArr[0] = key;
                strArr[1] = value;
                return strArr;
            }
        }
        String strM80874X0 = C13452e.m80781L().m80874X0();
        if (!TextUtils.isEmpty(strM80874X0)) {
            strArr[0] = "bmNewUserGuidPage";
            strArr[1] = strM80874X0;
            return strArr;
        }
        String strM80878Y0 = C13452e.m80781L().m80878Y0();
        if (!TextUtils.isEmpty(strM80878Y0)) {
            strArr[0] = "bmFreeUserGuidPage";
            strArr[1] = strM80878Y0;
            return strArr;
        }
        String strM80882Z0 = C13452e.m80781L().m80882Z0();
        if (!TextUtils.isEmpty(strM80882Z0)) {
            strArr[0] = "bmPaidUserGuidPage";
            strArr[1] = strM80882Z0;
        }
        return strArr;
    }

    /* renamed from: e */
    public final String m59184e(String str) {
        SpaceInsufficientH5PageInfo spaceInsufficientH5PageInfoM60710E = C9733f.m60705z().m60710E(str);
        if (spaceInsufficientH5PageInfoM60710E != null) {
            String url = spaceInsufficientH5PageInfoM60710E.getUrl();
            return url == null ? "" : url;
        }
        C11839m.m70689w("ServiceChangeManage", "protocolPackageInfo is null, key: " + str);
        return "";
    }

    /* renamed from: f */
    public final void m59185f(boolean z10) {
        C1461a.m8359i("ServiceChangeManage", "initNbmMap enter");
        boolean zM80892b1 = C13452e.m80781L().m80892b1();
        if (z10 && zM80892b1 && C9733f.m60705z().m60720O("bmNewUserGuidPage")) {
            String strM59184e = m59184e("bmNewUserGuidPage");
            this.f47135a.put("bmNewUserGuidPage", strM59184e);
            C13452e.m80781L().m80969s2(strM59184e);
        } else {
            this.f47135a.put("bmNewUserGuidPage", "");
            C13452e.m80781L().m80969s2("");
        }
        boolean zM80897c1 = C13452e.m80781L().m80897c1();
        if (!z10 && zM80897c1 && C9733f.m60705z().m60720O("bmFreeUserGuidPage")) {
            String strM59184e2 = m59184e("bmFreeUserGuidPage");
            this.f47135a.put("bmFreeUserGuidPage", strM59184e2);
            C13452e.m80781L().m80973t2(strM59184e2);
        } else {
            this.f47135a.put("bmFreeUserGuidPage", "");
            C13452e.m80781L().m80973t2("");
        }
        if (z10 || zM80897c1 || !C9733f.m60705z().m60720O("bmPaidUserGuidPage")) {
            this.f47135a.put("bmPaidUserGuidPage", "");
            C13452e.m80781L().m80977u2("");
        } else {
            String strM59184e3 = m59184e("bmPaidUserGuidPage");
            this.f47135a.put("bmPaidUserGuidPage", strM59184e3);
            C13452e.m80781L().m80977u2(strM59184e3);
        }
        C1461a.m8359i("ServiceChangeManage", "initNbmMap exit");
    }

    /* renamed from: g */
    public void m59186g() {
        C1461a.m8359i("ServiceChangeManage", "initStatus enter");
        boolean zM63295s = C10155f.m63295s();
        boolean zM60720O = C9733f.m60705z().m60720O("bmEnabled");
        C1461a.m8359i("ServiceChangeManage", "isNewBmTypeFromServer: " + zM63295s + ", isBmEnabled: " + zM60720O);
        if (zM60720O) {
            m59185f(zM63295s);
        }
        C1461a.m8359i("ServiceChangeManage", "initStatus exit");
    }
}
