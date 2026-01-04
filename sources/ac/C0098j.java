package ac;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBETopView;
import p015ak.C0219i;
import p514o9.C11839m;
import p514o9.C11842p;

/* renamed from: ac.j */
/* loaded from: classes3.dex */
public class C0098j extends C0089a {
    @Override // ac.C0089a
    /* renamed from: b */
    public void mo689b(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout, OOBENavLayout oOBENavLayout) {
        if (oOBETopView == null || relativeLayout == null) {
            C11839m.m70687e("OOBELayoutEmui9SettingHelper", "layoutFoldableExpandLand topLayout mainRegion null");
            return;
        }
        oOBETopView.m17054d(context, 48);
        float fM70844o = C11842p.m70844o(context, 24);
        if (C0219i.m1463a() >= 21) {
            fM70844o = C11842p.m70844o(context, 24);
        }
        C11842p.m70823i2(relativeLayout, fM70844o);
    }

    @Override // ac.C0089a
    /* renamed from: c */
    public void mo690c(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout, OOBENavLayout oOBENavLayout) {
        if (oOBETopView == null || relativeLayout == null) {
            C11839m.m70687e("OOBELayoutEmui9SettingHelper", "layoutFoldableExpandPortrait topLayout mainRegion null");
            return;
        }
        oOBETopView.m17054d(context, 48);
        float fM70844o = C11842p.m70844o(context, 24);
        if (C0219i.m1463a() >= 21) {
            fM70844o = C11842p.m70844o(context, 24);
        }
        C11842p.m70823i2(relativeLayout, fM70844o);
    }

    @Override // ac.C0089a
    /* renamed from: d */
    public void mo691d(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout, OOBENavLayout oOBENavLayout) {
        if (oOBETopView == null || relativeLayout == null) {
            C11839m.m70687e("OOBELayoutEmui9SettingHelper", "layoutPadPortrait topLayout mainRegion null");
        } else {
            C11842p.m70823i2(relativeLayout, C11842p.m70844o(context, 24));
        }
    }

    @Override // ac.C0089a
    /* renamed from: e */
    public void mo692e(Activity activity) {
        C11842p.m70790a1(activity);
    }

    @Override // ac.C0089a
    /* renamed from: f */
    public void mo693f(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout) {
        oOBETopView.m17054d(context, 48);
    }

    @Override // ac.C0089a
    /* renamed from: g */
    public void mo694g(Activity activity) {
        C11842p.m70786Z0(activity);
    }

    @Override // ac.C0089a
    /* renamed from: h */
    public void mo695h(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout) {
        oOBETopView.m17054d(context, 80);
    }

    @Override // ac.C0089a
    /* renamed from: i */
    public void mo696i(Activity activity) {
        C11842p.m70794b1(activity);
    }

    @Override // ac.C0089a
    /* renamed from: j */
    public void mo697j(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout, OOBENavLayout oOBENavLayout) {
        if (oOBETopView == null || relativeLayout == null) {
            C11839m.m70687e("OOBELayoutEmui9SettingHelper", "layoutPadPortrait topLayout mainRegion null");
            return;
        }
        oOBETopView.m17054d(context, 48);
        float fM70844o = C11842p.m70844o(context, 24);
        if (C0219i.m1463a() >= 21) {
            fM70844o = C11842p.m70844o(context, 24);
        }
        C11842p.m70823i2(relativeLayout, fM70844o);
    }

    @Override // ac.C0089a
    /* renamed from: k */
    public void mo698k() {
    }

    @Override // ac.C0089a
    /* renamed from: l */
    public void mo699l() {
    }
}
