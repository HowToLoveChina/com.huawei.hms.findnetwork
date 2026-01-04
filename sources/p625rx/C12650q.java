package p625rx;

import android.text.style.ClickableSpan;
import android.view.View;
import ohos.ohos.ohos.ohos.ohos.C11893h;
import p625rx.C12645l;

/* renamed from: rx.q */
/* loaded from: classes9.dex */
public class C12650q extends ClickableSpan {

    /* renamed from: a */
    public final /* synthetic */ String f58119a;

    /* renamed from: b */
    public final /* synthetic */ C11893h f58120b;

    public C12650q(C11893h c11893h, String str) {
        this.f58120b = c11893h;
        this.f58119a = str;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        this.f58120b.m71431c(this.f58119a);
        C12645l.a aVar = this.f58120b.f58104a;
        if (aVar != null) {
            aVar.mo38539a();
        }
    }
}
