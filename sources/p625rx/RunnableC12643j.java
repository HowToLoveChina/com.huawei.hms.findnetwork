package p625rx;

import android.widget.RelativeLayout;
import ohos.ohos.ohos.ohos.ohos.C11889d;

/* renamed from: rx.j */
/* loaded from: classes9.dex */
public class RunnableC12643j implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f58100a;

    /* renamed from: b */
    public final /* synthetic */ C11889d f58101b;

    public RunnableC12643j(C11889d c11889d, int i10) {
        this.f58101b = c11889d;
        this.f58100a = i10;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f58101b.f55018m.getMeasuredHeight());
        this.f58101b.f55018m.setVisibility(4);
        this.f58101b.f55019n.setLayoutParams(layoutParams);
        this.f58101b.f55019n.setVisibility(0);
        C11889d c11889d = this.f58101b;
        c11889d.f55020o.setText(c11889d.f58105b.getResources().getString(this.f58100a));
    }
}
