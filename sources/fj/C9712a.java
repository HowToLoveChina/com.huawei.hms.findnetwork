package fj;

import com.google.gson.Gson;
import com.huawei.cloud.pay.model.AdAppsQueryResp;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0213f;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: fj.a */
/* loaded from: classes5.dex */
public class C9712a {

    /* renamed from: a */
    public static C9712a f47923a = new C9712a();

    /* renamed from: a */
    public static synchronized C9712a m60564a() {
        return f47923a;
    }

    /* renamed from: b */
    public String m60565b(int i10, int i11) {
        List<String> arrayList = new ArrayList<>();
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07067"), "queryAdApps", C13452e.m80781L().m80971t0());
        try {
            try {
                c11060cM66626a.m66665u(String.valueOf(0));
                c11060cM66626a.m66635A("success");
                AdAppsQueryResp adAppsQueryRespM61657Z = C9948a.m61631C().m61657Z(c11060cM66626a, i10, i11, 30, 1);
                if (adAppsQueryRespM61657Z.getResultCode() == 0) {
                    arrayList = adAppsQueryRespM61657Z.getPackageNameList();
                }
            } catch (C9721b e10) {
                C1442a.m8291w("AdAppsQueryManager", "AdAppsQueryManager err. " + e10.m60659c() + " " + e10.getMessage());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("114_");
                sb2.append(e10.m60659c());
                c11060cM66626a.m66665u(sb2.toString());
                c11060cM66626a.m66635A(e10.getMessage());
            }
            return new Gson().toJson(arrayList);
        } finally {
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        }
    }
}
