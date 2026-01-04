package p625rx;

import android.widget.RelativeLayout;
import ohos.ohos.ohos.ohos.ohos.C11893h;

/* renamed from: rx.p */
/* loaded from: classes9.dex */
public class RunnableC12649p implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f58117a;

    /* renamed from: b */
    public final /* synthetic */ C11893h f58118b;

    public RunnableC12649p(C11893h c11893h, int i10) {
        this.f58118b = c11893h;
        this.f58117a = i10;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f58118b.f55053n.getMeasuredHeight());
        this.f58118b.f55054o.setVisibility(4);
        this.f58118b.f55053n.setLayoutParams(layoutParams);
        this.f58118b.f55055p.setVisibility(0);
        C11893h c11893h = this.f58118b;
        c11893h.f55050k.setText(c11893h.f58105b.getResources().getString(this.f58117a));
    }
}
