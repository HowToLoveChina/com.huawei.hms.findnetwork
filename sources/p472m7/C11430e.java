package p472m7;

import android.content.Context;
import p015ak.C0209d;
import p514o9.C11839m;
import p709vj.C13452e;
import tm.C13040c;

/* renamed from: m7.e */
/* loaded from: classes2.dex */
public class C11430e extends C11427b {
    public C11430e(Context context, String str) {
        super(context, str);
    }

    @Override // p472m7.C11427b, com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
    public void onClick() {
        if (C0209d.m1226Y0()) {
            C11839m.m70689w("WelcomeTermsClickListener", "fast click");
            return;
        }
        if (this.f53260a == null) {
            C11839m.m70687e("WelcomeTermsClickListener", "onClick mContext is null");
            return;
        }
        C13040c.m78609F().m78652i0(this.f53260a, C13452e.m80781L().m80942m(), true);
        C11839m.m70688i("WelcomeTermsClickListener", "termType onClick " + this.f53261b);
        m68472c(this.f53260a, this.f53261b);
    }
}
