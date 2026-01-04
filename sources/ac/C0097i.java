package ac;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBETopView;
import p514o9.C11839m;
import p514o9.C11842p;

/* renamed from: ac.i */
/* loaded from: classes3.dex */
public class C0097i extends C0089a {
    @Override // ac.C0089a
    /* renamed from: a */
    public void mo688a(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout, OOBENavLayout oOBENavLayout) throws Resources.NotFoundException {
        if (oOBETopView == null || relativeLayout == null || oOBENavLayout == null) {
            C11839m.m70687e("OOBELayoutHelper110", "layoutPhoneSetTopAndNavMargin topLayout mainRegion null");
            return;
        }
        oOBETopView.m17054d(context, 48);
        C11842p.m70799c2(context, oOBENavLayout);
        C11842p.m70827j2(relativeLayout, C11842p.m70789a0(context));
    }

    @Override // ac.C0089a
    /* renamed from: b */
    public void mo689b(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout, OOBENavLayout oOBENavLayout) {
    }

    @Override // ac.C0089a
    /* renamed from: c */
    public void mo690c(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout, OOBENavLayout oOBENavLayout) {
    }

    @Override // ac.C0089a
    /* renamed from: d */
    public void mo691d(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout, OOBENavLayout oOBENavLayout) throws Resources.NotFoundException {
        if (oOBETopView == null || relativeLayout == null || oOBENavLayout == null) {
            C11839m.m70687e("OOBELayoutHelper110", "layoutPadPortrait topLayout mainRegion navLayout null");
        } else {
            C11842p.m70799c2(context, oOBENavLayout);
            C11842p.m70827j2(relativeLayout, C11842p.m70789a0(context));
        }
    }

    @Override // ac.C0089a
    /* renamed from: f */
    public void mo693f(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout) {
        if (oOBETopView == null || relativeLayout == null || context == null) {
            C11839m.m70687e("OOBELayoutHelper110", "layoutPadPortrait topLayout mainRegion context null");
        } else {
            oOBETopView.m17054d(context, 48);
        }
    }

    @Override // ac.C0089a
    /* renamed from: g */
    public void mo694g(Activity activity) {
    }

    @Override // ac.C0089a
    /* renamed from: h */
    public void mo695h(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout) {
        if (oOBETopView == null || relativeLayout == null || context == null) {
            C11839m.m70687e("OOBELayoutHelper110", "layoutPadPortrait topLayout mainRegion context null");
        } else {
            oOBETopView.m17054d(context, 80);
        }
    }

    @Override // ac.C0089a
    /* renamed from: i */
    public void mo696i(Activity activity) {
    }

    @Override // ac.C0089a
    /* renamed from: j */
    public void mo697j(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout, OOBENavLayout oOBENavLayout) throws Resources.NotFoundException {
        if (oOBETopView == null || relativeLayout == null || oOBENavLayout == null) {
            C11839m.m70687e("OOBELayoutHelper110", "layoutPadPortrait topLayout mainRegion null");
            return;
        }
        oOBETopView.m17054d(context, 48);
        C11842p.m70799c2(context, oOBENavLayout);
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

    @Override // ac.C0089a
    /* renamed from: m */
    public void mo700m(Context context, View view) {
        C11842p.m70795b2(context, view);
    }
}
