package p781xn;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hicloud.okhttp.callback.AbstractC4976b;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;
import okhttp3.AbstractC11920f0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0228m0;
import p399jk.AbstractC10896a;
import p846zj.C14306d;

/* renamed from: xn.b */
/* loaded from: classes6.dex */
public class C13838b extends AbstractC4976b<Void> {

    /* renamed from: b */
    public static final String f62064b = "HUAWEI" + Build.MODEL;

    /* renamed from: a */
    public JSONObject f62065a;

    public C13838b(JSONObject jSONObject) {
        this.method = "POST";
        this.f62065a = jSONObject;
    }

    /* renamed from: a */
    public final void m82989a(HttpRequestBuilder.a aVar, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            aVar.addHeader("X-Model", str);
            UBAAnalyze.m29991n0("X-Model", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            aVar.addHeader("X-AppVer", str2);
            UBAAnalyze.m29991n0("X-AppVer", str2);
        }
        aVar.addHeader("x-hw-deviceUUID", C0209d.m1209S1(C0228m0.m1597b().m1599c()));
        aVar.addHeader("x-hw-os-brand", C0209d.m1276l0());
    }

    @Override // com.huawei.hicloud.okhttp.callback.AbstractC4976b
    public AbstractC11920f0 create() throws IOException {
        MimeClass MimeClassM71445d = MimeClass.m71445d("application/json; charset=utf-8");
        byte[] bytes = this.f62065a.toString().getBytes(StandardCharsets.UTF_8);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bytes);
        gZIPOutputStream.close();
        return AbstractC11920f0.create(MimeClassM71445d, byteArrayOutputStream.toByteArray());
    }

    @Override // com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public Void onResponse(HttpResponseBuilder HttpResponseBuilder) {
        return null;
    }

    @Override // com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public void prepare(HttpRequestBuilder.a aVar) {
        String string = UUID.randomUUID().toString();
        String strM1168F = C0209d.m1168F();
        String str = "com.huawei.hidisk/16.0.0.300 (Linux; HarmonyOS " + Build.VERSION.RELEASE + "; " + Build.MODEL + "; " + f62064b + ") HMS/2.6.3.306 (10055832)";
        String strM1149A0 = C0209d.m1149A0();
        String strSubstring = !TextUtils.isEmpty(strM1149A0) ? strM1149A0.substring(strM1149A0.lastIndexOf("_") + 1) : null;
        String strM1315v = C0209d.m1315v();
        String language = Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry();
        aVar.addHeader("X-ReqID", string).addHeader("X-AppID", "com.huawei.hidisk");
        UBAAnalyze.m29991n0("X-ReqID", string);
        m82989a(aVar, strM1168F, "16.0.0.300");
        aVar.addHeader("User-Agent", str);
        if (!TextUtils.isEmpty(strSubstring)) {
            aVar.addHeader("X-EmuiVer", strSubstring);
        }
        aVar.addHeader("X-RomVer", strM1315v);
        aVar.addHeader("X-Lang", language);
        aVar.addHeader("X-SerLocation", country);
        aVar.addHeader("Content-Type", InterfaceC5483d.f25084j);
        aVar.addHeader("Content-Encoding", Constants.GZIP);
        UBAAnalyze.m29991n0("User-Agent", str);
        UBAAnalyze.m29991n0("X-RomVer", strM1315v);
        UBAAnalyze.m29991n0("X-Lang", language);
        UBAAnalyze.m29991n0("X-SerLocation", country);
        C14306d.m85213n(aVar);
        AbstractC10896a.m65885d("UBAAnalyzeCallback", "reqID: " + string);
    }
}
