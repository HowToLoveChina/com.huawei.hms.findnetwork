package ac;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.widget.RelativeLayout;
import com.huawei.android.hicloud.oobe.R$dimen;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBETopView;
import p514o9.C11839m;
import p514o9.C11842p;

/* renamed from: ac.k */
/* loaded from: classes3.dex */
public class C0099k extends C0089a {

    /* renamed from: a */
    public int f335a;

    public C0099k(int i10) {
        this.f335a = i10;
    }

    @Override // ac.C0089a
    /* renamed from: d */
    public void mo691d(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout, OOBENavLayout oOBENavLayout) {
        if (oOBETopView == null) {
            C11839m.m70687e("OOBEMigrateLayoutEmui8Helper", "layoutPadPortrait topLayout null");
        } else {
            C11842p.m70815g2(oOBETopView.getTitleView(), context.getResources().getDimension(R$dimen.pad_oobe_title_text_margin_bootom));
        }
    }

    @Override // ac.C0089a
    /* renamed from: f */
    public void mo693f(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout) {
        if (oOBETopView == null || relativeLayout == null) {
            C11839m.m70687e("OOBEMigrateLayoutEmui8Helper", "layoutPadPortrait topLayout mainRegion null");
            return;
        }
        if (1 == this.f335a) {
            oOBETopView.m17056f(context);
            C11842p.m70831k2(context, relativeLayout);
        } else {
            oOBETopView.m17059i(context);
        }
        if (!(context instanceof Activity) || C11842p.m70774V0((Activity) context)) {
            return;
        }
        C11842p.m70775V1(context, relativeLayout);
    }

    @Override // ac.C0089a
    /* renamed from: h */
    public void mo695h(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout) {
        if (oOBETopView == null || relativeLayout == null) {
            C11839m.m70687e("OOBEMigrateLayoutEmui8Helper", "layoutPadPortrait topLayout mainRegion null");
            return;
        }
        if (1 == this.f335a) {
            oOBETopView.m17057g(context);
            C11842p.m70831k2(context, relativeLayout);
        } else {
            oOBETopView.m17060j(context);
        }
        C11842p.m70791a2(relativeLayout);
    }

    @Override // ac.C0089a
    /* renamed from: j */
    public void mo697j(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout, OOBENavLayout oOBENavLayout) {
        if (oOBETopView == null || relativeLayout == null) {
            C11839m.m70687e("OOBEMigrateLayoutEmui8Helper", "layoutPadPortrait topLayout mainRegion null");
            return;
        }
        int i10 = this.f335a;
        if (1 == i10) {
            C11842p.m70838m1(context, oOBETopView, oOBETopView.getIconView(), relativeLayout);
            Resources resources = context.getResources();
            if (resources == null) {
                return;
            } else {
                C11842p.m70815g2(oOBETopView.getTitleView(), resources.getDimension(R$dimen.attention_margin));
            }
        } else if (2 == i10) {
            C11842p.m70834l1(context, oOBETopView, oOBETopView.getIconView(), relativeLayout);
        }
        oOBETopView.m17054d(context, 48);
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
