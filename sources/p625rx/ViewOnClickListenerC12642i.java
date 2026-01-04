package p625rx;

import android.view.View;
import ohos.ohos.ohos.ohos.ohos.C11889d;
import ohos.ohos.ohos.ohos.ohos.C11891f;

/* renamed from: rx.i */
/* loaded from: classes9.dex */
public class ViewOnClickListenerC12642i implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ C11889d f58099a;

    public ViewOnClickListenerC12642i(C11889d c11889d) {
        this.f58099a = c11889d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f58099a.f55031z.dismiss();
        C11889d c11889d = this.f58099a;
        if (c11889d.f55016k) {
            C11891f.f55039a.m71414h(c11889d.f58106c, c11889d.f55012g, c11889d.f55011f, false, c11889d.f55013h);
        }
    }
}
