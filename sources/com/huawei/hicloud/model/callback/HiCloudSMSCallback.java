package com.huawei.hicloud.model.callback;

import android.os.Build;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.hicloud.model.AccountConstant;
import com.huawei.hicloud.okhttp.request.AbstractC4977a;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import java.io.IOException;
import okhttp3.AbstractC11920f0;
import okhttp3.C11910a0;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import p015ak.C0209d;
import p015ak.C0213f;
import p709vj.C13452e;

/* loaded from: classes6.dex */
public class HiCloudSMSCallback extends AbstractC4977a {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String CALL_MODE = "auto";
    private static final String DEVICE_CATEGORY_TYPE_PAD = "pad";
    private static final String DEVICE_CATEGORY_TYPE_PHONE = "phone";
    private static final int STATUS_SUCCESS = 0;
    private static final String TAG = "HiCloudSMSCallback";
    private String body;
    private String sessionId;
    private String signature;

    public HiCloudSMSCallback(String str, String str2, String str3, String str4, String str5, String str6) {
        super(str, str3, str4);
        this.body = str2;
        this.signature = str5;
        this.sessionId = str6;
    }

    @Override // com.huawei.hicloud.okhttp.callback.AbstractC4976b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(C11910a0.m71445d("application/json; charset=utf-8"), this.body.getBytes(Constants.UTF_8));
    }

    @Override // com.huawei.hicloud.okhttp.request.AbstractC4977a, com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public void prepare(C11918e0.a aVar) throws C9721b, NoSuchMethodException, IOException, SecurityException {
        super.prepare(aVar);
        aVar.m71574a("x-hw-app-id", "10055832");
        StringBuilder sb2 = new StringBuilder("com.huawei.hidisk/");
        sb2.append("16.0.0.300");
        sb2.append(" (Linux; HarmonyOS ");
        sb2.append(Build.VERSION.RELEASE);
        sb2.append("; ");
        sb2.append(Build.MODEL);
        sb2.append("; ");
        String str = AccountConstant.DEVICE_NAME;
        sb2.append(str);
        sb2.append(") HMS/");
        sb2.append("2.6.3.306 (");
        sb2.append("10055832)");
        aVar.m71574a("User-Agent", sb2.toString());
        aVar.m71574a("x-hw-device-category", C0209d.m1170F1() ? DEVICE_CATEGORY_TYPE_PAD : DEVICE_CATEGORY_TYPE_PHONE);
        aVar.m71574a("x-hw-device-name", str);
        aVar.m71574a("x-hw-app-package-name", "com.huawei.hidisk");
        aVar.m71574a("x-hw-network", C0209d.m1228Z(C0209d.m1225Y(C0213f.m1377a())));
        String strM1324x0 = C0209d.m1324x0();
        if (TextUtils.isEmpty(strM1324x0)) {
            strM1324x0 = "";
        }
        aVar.m71574a("x-hw-deviceUDID", strM1324x0);
        aVar.m71574a("x-hw-app-version", C1443a.f6213a);
        if (!TextUtils.isEmpty(this.signature)) {
            aVar.m71574a("x-hw-signature", this.signature);
        }
        if (!TextUtils.isEmpty(this.sessionId)) {
            aVar.m71574a("x-hw-sessionID", this.sessionId);
        }
        aVar.m71574a("x-hw-device-type", C13452e.m80781L().m80970t());
    }

    @Override // com.huawei.hicloud.okhttp.request.AbstractC4977a, com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public String onResponse(C11922g0 c11922g0) throws C9721b, IOException, NumberFormatException {
        String strM71637z = c11922g0.m71595s().m71637z();
        String strM71599w = c11922g0.m71599w("NSP_STATUS");
        if (strM71599w != null && !strM71599w.isEmpty()) {
            StringBuilder sb2 = new StringBuilder(this.svc);
            sb2.append(" nsp status = ");
            sb2.append(strM71599w);
            sb2.append("=>");
            try {
                int i10 = Integer.parseInt(strM71599w);
                if (i10 != 0) {
                    sb2.append(strM71637z);
                    throw new C9721b(4000, i10, sb2.toString(), this.svc);
                }
            } catch (NumberFormatException unused) {
                sb2.append(strM71637z);
                throw new C9721b(4000, -1, sb2.toString(), this.svc);
            }
        }
        parseErrorByRsp(strM71637z);
        return strM71637z;
    }
}
