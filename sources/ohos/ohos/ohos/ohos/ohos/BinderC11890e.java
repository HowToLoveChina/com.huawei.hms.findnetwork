package ohos.ohos.ohos.ohos.ohos;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import ohos.ohos.ohos.ohos.ohos.InterfaceC11900x;

/* renamed from: ohos.ohos.ohos.ohos.ohos.e */
/* loaded from: classes9.dex */
public class BinderC11890e extends InterfaceC11900x.a {

    /* renamed from: a */
    public final /* synthetic */ Intent f55035a;

    /* renamed from: b */
    public final /* synthetic */ Context f55036b;

    /* renamed from: c */
    public final /* synthetic */ int f55037c;

    /* renamed from: d */
    public final /* synthetic */ C11891f f55038d;

    public BinderC11890e(C11891f c11891f, Intent intent, Context context, int i10) {
        this.f55038d = c11891f;
        this.f55035a = intent;
        this.f55036b = context;
        this.f55037c = i10;
    }

    @Override // ohos.ohos.ohos.ohos.ohos.InterfaceC11900x
    /* renamed from: a */
    public void mo71403a(int i10, String str) {
        if (i10 == 0) {
            C11891f.m71407u(this.f55038d, this.f55035a, this.f55036b, this.f55037c);
            return;
        }
        Log.e("AbilityProxy", "silentInstallPageAbility onFinished resultCode = " + i10 + ",resultMsg = " + str);
    }
}
