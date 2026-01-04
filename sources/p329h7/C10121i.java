package p329h7;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import gp.C10028c;
import p514o9.C11839m;

/* renamed from: h7.i */
/* loaded from: classes2.dex */
public class C10121i {

    /* renamed from: a */
    public static AdParametersExt f49365a;

    /* renamed from: a */
    public static AdParametersExt m63035a() {
        try {
            f49365a = (AdParametersExt) new Gson().fromJson(C10028c.m62182c0().m62263Q0("agd_ext_param_key", ""), AdParametersExt.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("AgdParamKeeper", "getAdParametersExt, json exception is: " + e10.getMessage());
        }
        return f49365a;
    }

    /* renamed from: b */
    public static void m63036b(AdParametersExt adParametersExt) {
        if (adParametersExt != null) {
            f49365a = adParametersExt;
            C11839m.m70688i("AgdParamKeeper", "save adParametersExt:" + adParametersExt.toString());
            C10028c.m62182c0().m62232J3("agd_ext_param_key", new Gson().toJson(adParametersExt));
        }
    }
}
