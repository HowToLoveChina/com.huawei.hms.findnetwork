package p360i7;

import android.os.Build;
import android.text.TextUtils;
import ao.C1005a;
import ca.C1403f;
import com.huawei.android.hicloud.agd.ads.AdInfo;
import com.huawei.android.hicloud.agd.ads.MaterialMeta;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;
import p429kk.C11058a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p651t8.C12996d;
import p709vj.C13452e;

/* renamed from: i7.a */
/* loaded from: classes2.dex */
public class C10451a extends AbstractC12367d {

    /* renamed from: a */
    public String f50416a;

    /* renamed from: b */
    public String f50417b;

    /* renamed from: c */
    public String f50418c;

    /* renamed from: d */
    public String f50419d;

    /* renamed from: e */
    public boolean f50420e;

    public C10451a(String str, String str2, String str3, String str4, boolean z10) {
        this.f50416a = str;
        this.f50417b = str2;
        this.f50418c = str3;
        this.f50419d = str4;
        this.f50420e = z10;
    }

    /* renamed from: c */
    public final String m64254c(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JsbMapKeyNames.H5_DEVICE_TYPE, Build.MODEL);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pos", new JSONObject(str).getString("pos"));
            }
        } catch (JSONException e10) {
            C11839m.m70688i("ReportAGEventTask", "reportAGEvent JSONException: " + e10.getMessage());
        }
        return jSONObject.toString();
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws JSONException {
        m64255d(this.f50416a, this.f50417b, this.f50418c, this.f50419d);
    }

    /* renamed from: d */
    public final void m64255d(String str, String str2, String str3, String str4) throws JSONException {
        AdInfo adInfoM77995h = this.f50420e ? C12996d.m77971n().m77995h(str, str2) : C1403f.m8066n().m8090g(str, str2);
        if (adInfoM77995h == null) {
            C11839m.m70687e("ReportAGEventTask", "reportAGEvent show begin adId: " + str + "uniqueId: " + str2 + " type: " + str4);
            return;
        }
        MaterialMeta material = adInfoM77995h.getMaterial();
        if (material == null) {
            C11839m.m70687e("ReportAGEventTask", "reportAGEvent show begin adId: " + str + "uniqueId: " + str2 + " type: " + str4);
            return;
        }
        if (ParamConstants.CallbackMethod.ON_SHOW.equals(str4)) {
            String showUrl = material.getShowUrl();
            if (TextUtils.isEmpty(showUrl)) {
                C11839m.m70687e("ReportAGEventTask", "reportAGEvent show showUrl is null");
                return;
            }
            String strReplace = showUrl.replace("__TIME__", "1000");
            String strM64254c = m64254c(str3);
            String strReplace2 = !TextUtils.isEmpty(strM64254c) ? strReplace.replace("__EXTINFO__", m64256e(strM64254c)) : strReplace;
            C11839m.m70686d("ReportAGEventTask", "reportAGEvent show begin adId: " + str + "uniqueId: " + str2 + " showUrl: " + strReplace2);
            C1005a.m5932b().m5935d(str, str2, strReplace2, str4, C11058a.m66626a(C11058a.m66627b("07052"), "07052", C13452e.m80781L().m80971t0()));
            C1403f.m8066n().m8071E(str, str2, "impression_agd_ads_event", "Y");
            return;
        }
        if ("click".equals(str4)) {
            String clickUrl = material.getClickUrl();
            if (TextUtils.isEmpty(clickUrl)) {
                C11839m.m70687e("ReportAGEventTask", "reportAGEvent click clickUrl is null");
                return;
            }
            String strReplace3 = clickUrl.replace("__CLICKTYPE__", JsbMapKeyNames.H5_TEXT_DOWNLOAD_INSTALL);
            String strM64254c2 = m64254c(str3);
            String strReplace4 = !TextUtils.isEmpty(strM64254c2) ? strReplace3.replace("__EXTINFO__", m64256e(strM64254c2)) : strReplace3;
            C11839m.m70686d("ReportAGEventTask", "reportAGEvent click begin adId: " + str + "uniqueId: " + str2 + " clickUrl: " + strReplace4);
            C1005a.m5932b().m5935d(str, str2, strReplace4, str4, C11058a.m66626a(C11058a.m66627b("07052"), "07052", C13452e.m80781L().m80971t0()));
            C1403f.m8066n().m8071E(str, str2, "click_agd_ads_event", "Y");
        }
    }

    /* renamed from: e */
    public String m64256e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Charset charset = StandardCharsets.UTF_8;
            return URLEncoder.encode(new String(str.getBytes(charset), charset), Constants.UTF_8);
        } catch (Exception e10) {
            C11839m.m70687e("ReportAGEventTask", "toUrlEncoded exception: " + e10.getMessage());
            return "";
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.REPORT_AG_EVENT;
    }
}
