package ohos.ohos.ohos.ohos.ohos;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import ohos.ohos.ohos.ohos.ohos.InterfaceC11900x;

/* renamed from: ohos.ohos.ohos.ohos.ohos.g */
/* loaded from: classes9.dex */
public class BinderC11892g extends InterfaceC11900x.a {

    /* renamed from: a */
    public final /* synthetic */ Intent f55040a;

    /* renamed from: b */
    public final /* synthetic */ Context f55041b;

    /* renamed from: c */
    public final /* synthetic */ int f55042c;

    /* renamed from: d */
    public final /* synthetic */ C11891f f55043d;

    public BinderC11892g(C11891f c11891f, Intent intent, Context context, int i10) {
        this.f55043d = c11891f;
        this.f55040a = intent;
        this.f55041b = context;
        this.f55042c = i10;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.InterfaceC11900x
    /* renamed from: a */
    public void mo71403a(int i10, String str) {
        if (i10 != 0) {
            Log.e("AbilityProxy", "upgradeInstall onFinished resultCode = " + i10 + ",resultMsg = " + str);
        }
        C11891f.m71407u(this.f55043d, this.f55040a, this.f55041b, this.f55042c);
    }
}
