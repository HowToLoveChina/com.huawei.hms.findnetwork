package ac;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBETopView;
import p514o9.C11839m;
import p514o9.C11842p;

/* renamed from: ac.h */
/* loaded from: classes3.dex */
public class C0096h extends C0089a {
    @Override // ac.C0089a
    /* renamed from: a */
    public void mo688a(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout, OOBENavLayout oOBENavLayout) {
    }

    @Override // ac.C0089a
    /* renamed from: b */
    public void mo689b(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout, OOBENavLayout oOBENavLayout) {
        if (oOBETopView == null || relativeLayout == null || oOBENavLayout == null) {
            C11839m.m70687e("OOBELayoutHelper9", "layoutPadPortrait topLayout mainRegion null");
            return;
        }
        oOBETopView.m17054d(context, 48);
        float fM70844o = C11842p.m70844o(context, 24) + (C11842p.m70876w(context).widthPixels / 12);
        oOBENavLayout.setMarginHorizontal((int) fM70844o);
        C11842p.m70823i2(relativeLayout, fM70844o);
        C11842p.m70827j2(relativeLayout, C11842p.m70789a0(context));
    }

    @Override // ac.C0089a
    /* renamed from: c */
    public void mo690c(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout, OOBENavLayout oOBENavLayout) {
        if (oOBETopView == null || relativeLayout == null || oOBENavLayout == null) {
            C11839m.m70687e("OOBELayoutHelper9", "layoutPadPortrait topLayout mainRegion null");
            return;
        }
        oOBETopView.m17054d(context, 48);
        float fM70844o = C11842p.m70844o(context, 24) + (C11842p.m70876w(context).widthPixels / 8);
        oOBENavLayout.setMarginHorizontal((int) fM70844o);
        C11842p.m70823i2(relativeLayout, fM70844o);
        C11842p.m70827j2(relativeLayout, C11842p.m70789a0(context));
    }

    @Override // ac.C0089a
    /* renamed from: d */
    public void mo691d(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout, OOBENavLayout oOBENavLayout) {
        if (oOBETopView == null || relativeLayout == null || oOBENavLayout == null) {
            C11839m.m70687e("OOBELayoutHelper9", "layoutPadPortrait topLayout mainRegion navLayout null");
            return;
        }
        float fM70844o = C11842p.m70844o(context, 24);
        C11842p.m70823i2(relativeLayout, fM70844o);
        oOBENavLayout.setMarginHorizontal((int) fM70844o);
        C11842p.m70827j2(relativeLayout, C11842p.m70789a0(context));
    }

    @Override // ac.C0089a
    /* renamed from: f */
    public void mo693f(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout) {
        C11842p.m70843n2(oOBETopView, C11842p.m70840n(context, 200));
        oOBETopView.m17054d(context, 48);
    }

    @Override // ac.C0089a
    /* renamed from: g */
    public void mo694g(Activity activity) {
        C11842p.m70802d1(activity);
    }

    @Override // ac.C0089a
    /* renamed from: h */
    public void mo695h(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout) {
        C11842p.m70843n2(oOBETopView, C11842p.m70840n(context, 240));
        oOBETopView.m17054d(context, 80);
    }

    @Override // ac.C0089a
    /* renamed from: i */
    public void mo696i(Activity activity) {
        C11842p.m70798c1(activity);
    }

    @Override // ac.C0089a
    /* renamed from: j */
    public void mo697j(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout, OOBENavLayout oOBENavLayout) {
        if (oOBETopView == null || relativeLayout == null || oOBENavLayout == null) {
            C11839m.m70687e("OOBELayoutHelper9", "layoutPadPortrait topLayout mainRegion null");
            return;
        }
        oOBETopView.m17054d(context, 48);
        float fM70844o = C11842p.m70844o(context, 24);
        oOBENavLayout.setMarginHorizontal((int) fM70844o);
        C11842p.m70823i2(relativeLayout, fM70844o);
        C11842p.m70827j2(relativeLayout, C11842p.m70789a0(context));
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
