package com.tencent.p204mm.opensdk.diffdev.p206a;

import com.tencent.p204mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p204mm.opensdk.diffdev.OAuthListener;
import com.tencent.p204mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.b */
/* loaded from: classes9.dex */
final class C8920b implements OAuthListener {

    /* renamed from: f */
    final /* synthetic */ C8919a f45402f;

    public C8920b(C8919a c8919a) {
        this.f45402f = c8919a;
    }

    @Override // com.tencent.p204mm.opensdk.diffdev.OAuthListener
    public final void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
        Log.m56638d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", oAuthErrCode.toString(), str));
        C8919a.m56628c(this.f45402f);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f45402f.f45399c);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((OAuthListener) it.next()).onAuthFinish(oAuthErrCode, str);
        }
    }

    @Override // com.tencent.p204mm.opensdk.diffdev.OAuthListener
    public final void onAuthGotQrcode(String str, byte[] bArr) {
        Log.m56638d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f45402f.f45399c);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((OAuthListener) it.next()).onAuthGotQrcode(str, bArr);
        }
    }

    @Override // com.tencent.p204mm.opensdk.diffdev.OAuthListener
    public final void onQrcodeScanned() {
        Log.m56638d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
        if (this.f45402f.handler != null) {
            this.f45402f.handler.post(new RunnableC8921c(this));
        }
    }
}
