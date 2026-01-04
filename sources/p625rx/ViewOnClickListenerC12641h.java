package p625rx;

import android.util.Log;
import android.view.View;
import ohos.ohos.ohos.ohos.ohos.C11889d;

/* renamed from: rx.h */
/* loaded from: classes9.dex */
public class ViewOnClickListenerC12641h implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ C11889d f58098a;

    public ViewOnClickListenerC12641h(C11889d c11889d) {
        this.f58098a = c11889d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f58098a.f55015j = true;
        this.f58098a.f55023r.setAlpha(0.38f);
        this.f58098a.f55023r.setEnabled(false);
        this.f58098a.f55023r.setVisibility(4);
        this.f58098a.f55024s.setVisibility(0);
        Log.d("UpdateDialog", "start begin download and update");
        this.f58098a.m71401i();
    }
}
