package com.huawei.android.remotecontrol.http;

import android.content.Context;
import android.os.Build;
import ck.C1443a;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import mk.C11475a;
import okhttp3.C11918e0;
import p015ak.C0209d;
import p809yg.C13981a;

/* renamed from: com.huawei.android.remotecontrol.http.a */
/* loaded from: classes4.dex */
public class C4343a extends C4348f {

    /* renamed from: k */
    public String f19816k;

    public C4343a(Context context, String str, String str2, String str3, int i10, String str4) {
        super(context, str, str2, str3, i10);
        this.f19816k = str4;
    }

    @Override // com.huawei.android.remotecontrol.http.C4348f, com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(C11918e0.a aVar) {
        String str;
        aVar.m71574a("x-hw-auth-version", "2");
        aVar.m71574a("x-hw-terminal", Build.MODEL);
        aVar.m71574a("version", C1443a.f6213a);
        String strM26248h = m26248h(this.f19816k);
        try {
            Charset charset = StandardCharsets.UTF_8;
            str = new String(C11475a.m68618a(strM26248h.getBytes(charset)), charset);
        } catch (Exception unused) {
            C13981a.m83988e("AppAtRequestWrapper", "utf-8 is not supported");
            str = "";
        }
        aVar.m71574a("AppAuthorization", str);
        aVar.m71574a("x-hw-os-brand", C0209d.m1276l0());
        aVar.m71574a("x-hw-client-mode", RequestModeConfig.getInstance().getMode(Integer.valueOf(this.f19835d)));
        aVar.m71574a("x-hw-framework-type", "0");
        if (3102 == this.f19835d) {
            aVar.m71574a("rsaVersion", InterfaceC5323b.f24693t);
        }
    }
}
