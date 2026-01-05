package p710vk;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import ck.C1443a;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.huawei.hicloud.bean.FeatureSwitchFact;
import com.huawei.hicloud.bean.FeatureSwitchReq;
import com.huawei.hicloud.okhttp.callback.AbstractC4975a;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9720a;
import fk.C9721b;
import java.io.IOException;
import mk.C11475a;
import okhttp3.AbstractC11920f0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import p015ak.C0209d;
import p015ak.C0219i;
import p015ak.C0228m0;
import p015ak.C0234s;
import p292fn.C9733f;
import p399jk.AbstractC10896a;
import p709vj.C13452e;
import p846zj.C14306d;

/* renamed from: vk.a */
/* loaded from: classes6.dex */
public class C13457a extends AbstractC4975a<String> {

    /* renamed from: a */
    public String f60624a;

    /* renamed from: b */
    public String f60625b;

    public C13457a(String str, String str2) {
        this.f60624a = str;
        this.f60625b = str2;
    }

    @Override // com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public void prepare(HttpRequestBuilder.a aVar) throws C9721b, JsonIOException, IOException {
        String strM80931j0 = C13452e.m80781L().m80931j0();
        String strM80971t0 = C13452e.m80781L().m80971t0();
        String strM80942m = C13452e.m80781L().m80942m();
        String strM80970t = C13452e.m80781L().m80970t();
        String strM80954p = C13452e.m80781L().m80954p();
        String strM80790C = C13452e.m80781L().m80790C();
        String strM80857T = C13452e.m80781L().m80857T();
        boolean zM80892b1 = C13452e.m80781L().m80892b1();
        C9720a.m60653b(strM80971t0, "userId is null");
        C9720a.m60653b(strM80942m, "countryCode is null");
        C9720a.m60653b(strM80970t, "deviceType is null");
        C9720a.m60653b(strM80954p, "deviceId is null");
        aVar.addHeader(JsbMapKeyNames.H5_USER_ID, strM80971t0);
        aVar.addHeader("x-hw-country-code", strM80942m);
        aVar.addHeader("x-hw-device-type", strM80970t);
        aVar.addHeader("x-hw-device-id", strM80954p);
        aVar.addHeader("x-hw-deviceUUID", C0209d.m1209S1(C0228m0.m1597b().m1599c()));
        aVar.addHeader("x-hw-os-brand", C0209d.m1276l0());
        String str = C1443a.f6213a;
        aVar.addHeader("version", str);
        String str2 = Build.MODEL;
        aVar.addHeader("x-hw-terminal", str2);
        aVar.addHeader("x-hw-os", C0209d.m1315v());
        aVar.addHeader("x-hw-trace-id", this.f60625b);
        aVar.addHeader("x-hw-app-version", str);
        aVar.addHeader("Accept-Language", C0234s.m1627e());
        aVar.addHeader("x-hw-auth-version", "1");
        C14306d.m85213n(aVar);
        aVar.addHeader(FeedbackWebConstants.AUTHORIZATION, new String(C11475a.m68618a((strM80970t + ":" + strM80954p + ":com.huawei.hidisk:" + strM80931j0 + ":" + Uri.encode(this.f60624a)).getBytes("utf-8")), "utf-8"));
        aVar.addHeader("x-hw-account-brand-id", C14306d.m85201b());
        MimeClass MimeClassM71445d = MimeClass.m71445d("application/json; charset=utf-8");
        FeatureSwitchFact featureSwitchFact = new FeatureSwitchFact("appVersion", str);
        FeatureSwitchFact featureSwitchFact2 = new FeatureSwitchFact("deviceCategory", C0209d.m1170F1() ? "pad" : "phone");
        FeatureSwitchFact featureSwitchFact3 = new FeatureSwitchFact("countryCode", strM80942m);
        FeatureSwitchFact featureSwitchFact4 = new FeatureSwitchFact("userGrade", strM80790C);
        FeatureSwitchFact featureSwitchFact5 = new FeatureSwitchFact(JsbMapKeyNames.H5_USER_ID, strM80971t0);
        FeatureSwitchFact featureSwitchFact6 = new FeatureSwitchFact("uid", strM80971t0);
        FeatureSwitchFact featureSwitchFact7 = new FeatureSwitchFact(FaqConstants.FAQ_OSVERSION, String.valueOf(C0219i.m1463a()));
        FeatureSwitchFact featureSwitchFact8 = new FeatureSwitchFact(FaqConstants.FAQ_EMUIVERSION, C0209d.m1186L());
        FeatureSwitchFact featureSwitchFact9 = new FeatureSwitchFact("deviceBrand", C0209d.m1160D());
        FeatureSwitchFact featureSwitchFact10 = new FeatureSwitchFact("osBrand", C0209d.m1276l0());
        FeatureSwitchFact featureSwitchFact11 = new FeatureSwitchFact("terminalMode", str2);
        FeatureSwitchReq featureSwitchReq = new FeatureSwitchReq();
        featureSwitchReq.getFacts().add(new FeatureSwitchFact("userTags", strM80857T));
        AbstractC10896a.m65887i("FeatureConfigCallback", "userTagsFact:" + strM80857T);
        AbstractC10896a.m65887i("FeatureConfigCallback", "newUser:" + zM80892b1);
        featureSwitchReq.getFacts().add(new FeatureSwitchFact("newUser", zM80892b1 ? "1" : "0"));
        featureSwitchReq.getFacts().add(new FeatureSwitchFact("spaceShareEnable", String.valueOf(C13452e.m80781L().m80963r0())));
        featureSwitchReq.getFacts().add(featureSwitchFact);
        featureSwitchReq.getFacts().add(featureSwitchFact2);
        featureSwitchReq.getFacts().add(featureSwitchFact3);
        featureSwitchReq.getFacts().add(featureSwitchFact4);
        featureSwitchReq.getFacts().add(featureSwitchFact5);
        featureSwitchReq.getFacts().add(featureSwitchFact6);
        featureSwitchReq.getFacts().add(featureSwitchFact11);
        featureSwitchReq.getFacts().add(featureSwitchFact7);
        featureSwitchReq.getFacts().add(featureSwitchFact8);
        featureSwitchReq.getFacts().add(featureSwitchFact9);
        featureSwitchReq.getFacts().add(featureSwitchFact10);
        C9733f.m60705z().m60740e0(featureSwitchReq);
        String json = new Gson().toJson(featureSwitchReq, FeatureSwitchReq.class);
        AbstractC10896a.m65887i("FeatureConfigCallback", "req json:" + json);
        if (TextUtils.isEmpty(json)) {
            return;
        }
        aVar.m71581h(AbstractC11920f0.create(MimeClassM71445d, json.getBytes(Constants.UTF_8)));
    }

    @Override // com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public String onResponse(HttpResponseBuilder HttpResponseBuilder) throws IOException {
        return HttpResponseBuilder.m71595s().m71637z();
    }
}
