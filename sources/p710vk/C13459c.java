package p710vk;

import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import ck.C1443a;
import com.huawei.hicloud.bean.Keys;
import com.huawei.hicloud.okhttp.callback.AbstractC4976b;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9720a;
import fk.C9721b;
import gp.C10028c;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Predicate;
import mk.C11475a;
import okhttp3.AbstractC11920f0;
import okhttp3.C11910a0;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import p015ak.C0209d;
import p015ak.C0228m0;
import p015ak.C0234s;
import p292fn.C9733f;
import p399jk.AbstractC10896a;
import p681uj.C13191h;
import p709vj.C13452e;
import p846zj.C14306d;

/* renamed from: vk.c */
/* loaded from: classes6.dex */
public class C13459c extends AbstractC4976b<String> {

    /* renamed from: a */
    public String f60627a;

    /* renamed from: b */
    public String f60628b;

    /* renamed from: c */
    public String f60629c;

    /* renamed from: d */
    public Keys[] f60630d;

    /* renamed from: e */
    public String f60631e;

    /* renamed from: f */
    public boolean f60632f;

    public C13459c(String str, String str2, String str3, Keys[] keysArr, boolean z10) {
        this.f60627a = str;
        this.f60628b = str3;
        this.f60629c = str2;
        this.method = "POST";
        this.f60630d = keysArr;
        this.f60632f = z10;
    }

    @Override // com.huawei.hicloud.okhttp.callback.AbstractC4976b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(C11910a0.m71445d("application/json; charset=utf-8"), this.f60629c.getBytes(Constants.UTF_8));
    }

    @Override // com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public void prepare(C11918e0.a aVar) throws C9721b, IOException {
        String strM80971t0 = C13452e.m80781L().m80971t0();
        String strM80942m = C13452e.m80781L().m80942m();
        String strM80970t = C13452e.m80781L().m80970t();
        String strM80954p = C13452e.m80781L().m80954p();
        C9720a.m60653b(strM80971t0, "userId is null");
        C9720a.m60653b(strM80942m, "countryCode is null");
        C9720a.m60653b(strM80970t, "deviceType is null");
        C9720a.m60653b(strM80954p, "deviceId is null");
        aVar.m71574a(JsbMapKeyNames.H5_USER_ID, strM80971t0);
        aVar.m71574a("x-hw-country-code", strM80942m);
        aVar.m71574a("x-hw-device-type", strM80970t);
        aVar.m71574a("x-hw-device-id", strM80954p);
        aVar.m71574a("x-hw-deviceUUID", C0209d.m1209S1(C0228m0.m1597b().m1599c()));
        aVar.m71574a("x-hw-os-brand", C0209d.m1276l0());
        String str = C1443a.f6213a;
        aVar.m71574a("version", str);
        aVar.m71574a("x-hw-terminal", Build.MODEL);
        aVar.m71574a("x-hw-os", C0209d.m1315v());
        aVar.m71574a("x-hw-trace-id", this.f60628b);
        aVar.m71574a("x-hw-app-version", str);
        aVar.m71574a("Accept-Language", C0234s.m1627e());
        aVar.m71574a("x-hw-auth-version", "1");
        aVar.m71574a(FeedbackWebConstants.AUTHORIZATION, new String(C11475a.m68618a((strM80970t + ":" + strM80954p + ":com.huawei.hidisk::" + Uri.encode(this.f60627a)).getBytes("utf-8")), "utf-8"));
        boolean zM60720O = C9733f.m60705z().m60720O("downloadOMConfigFileFlowControl");
        AbstractC10896a.m65887i("GetLatestConfigCallback", "GetLatestConfigCallback isGrayFlowControlOpen: " + zM60720O + " isDefaultFlowControl: " + C13191h.m79248a().m79251d() + "  configPoint: " + this.f60630d + "  isConfigFileExist: " + this.f60632f);
        if (zM60720O && this.f60632f) {
            final String str2 = "HiCloudActivesH5";
            if (!Arrays.stream(this.f60630d).anyMatch(new Predicate() { // from class: vk.b
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return str2.equals((Keys) obj);
                }
            })) {
                final String str3 = "HiCloudSysParam";
                if (!Arrays.stream(this.f60630d).anyMatch(new Predicate() { // from class: vk.b
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return str3.equals((Keys) obj);
                    }
                })) {
                    final String str4 = "HiCloudSpaceNoticeConfigV3";
                    if (!Arrays.stream(this.f60630d).anyMatch(new Predicate() { // from class: vk.b
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return str4.equals((Keys) obj);
                        }
                    })) {
                        long jM62409w0 = C10028c.m62182c0().m62409w0(this.f60630d[0].getKey());
                        long j10 = jM62409w0 % 1000;
                        if (j10 == 0) {
                            aVar.m71574a("x-hw-tc-seconds", String.valueOf(0));
                        } else {
                            aVar.m71574a("x-hw-tc-seconds", String.valueOf((SystemClock.elapsedRealtime() - jM62409w0) % 1000));
                        }
                        AbstractC10896a.m65887i("GetLatestConfigCallback", "x-hw-tc-seconds00000: " + j10 + " x-hw-tc-seconds: " + ((SystemClock.elapsedRealtime() - jM62409w0) % 1000) + "  x-hw-tc-times: " + C10028c.m62182c0().m62205E0(this.f60630d[0].getKey()));
                        aVar.m71574a("x-hw-tc-times", String.valueOf(C10028c.m62182c0().m62205E0(this.f60630d[0].getKey())));
                    }
                }
            }
        }
        C14306d.m85213n(aVar);
    }

    @Override // com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public String onResponse(C11922g0 c11922g0) throws IOException {
        return c11922g0.m71595s().m71637z();
    }

    public C13459c(String str, String str2, String str3, String str4, boolean z10) {
        this.f60627a = str;
        this.f60628b = str3;
        this.f60629c = str2;
        this.method = "POST";
        this.f60631e = str4;
        this.f60632f = z10;
        this.f60630d = new Keys[]{new Keys(str4, "")};
    }
}
