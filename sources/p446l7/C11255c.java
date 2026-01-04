package p446l7;

import bo.C1269c;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.request.agreement.request.QueryProtocolOpenRegionsRsp;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.SkipPosition;
import fk.C9721b;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p709vj.C13452e;
import ro.C12612a;
import tm.C13040c;

/* renamed from: l7.c */
/* loaded from: classes2.dex */
public class C11255c extends AbstractC12367d {

    /* renamed from: c */
    public static final Gson f52843c = new Gson();

    /* renamed from: a */
    public Consumer<List<String>> f52844a;

    /* renamed from: b */
    public final String[] f52845b = {"af", "ag", "ai", "am", "ao", "aq", "as", "aw", "az", "bb", "bd", "bf", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bs", "bt", "bv", "bw", "by", "bz", "cc", "cd", "cf", "cg", "ci", "ck", "cl", "cm", "cr", "cu", "cv", "cx", "dj", "dm", "do", "dz", "ec", "eg", "eh", "er", "et", "fj", "fk", "fm", "ga", "gd", "ge", "gf", "gh", "gm", "gn", "gp", "gq", "gs", "gt", "gu", "gw", "gy", "hm", "hn", "ht", "id", "in", "io", "iq", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "lk", SkipPosition.LOWER_RIGHT, "ls", "ly", "ma", "mg", "mh", "ml", "mm", "mn", "mp", "mq", "mr", "ms", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "np", "nr", "nu", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pn", "pr", "ps", "pw", "py", "qa", "re", "rw", "sb", "sc", "sd", "sh", "sl", "sn", "so", "sr", "ss", "st", "sv", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", RemoteMessageConst.f29664TO, "tt", "tv", "tz", "ug", "uz", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "zm", "zw"};

    public C11255c(Consumer<List<String>> consumer) {
        this.f52844a = consumer;
    }

    /* renamed from: d */
    public static <T> T m67586d(String str, Class<T> cls) throws C9721b {
        try {
            return (T) f52843c.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException unused) {
            throw new C9721b(4003, "json err = " + str, "AgreementService_fromJson");
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        final List<String> listM67589f = m67589f("07059");
        Optional.ofNullable(this.f52844a).ifPresent(new Consumer() { // from class: l7.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Consumer) obj).accept(listM67589f);
            }
        });
    }

    /* renamed from: e */
    public final String m67588e(String str) throws C9721b {
        try {
            return C13195l.m79272J().m79344y("Agreement", str);
        } catch (C13194k e10) {
            C11839m.m70687e("QueryProtocolOpenRegionsTask", "onAccessToken: " + e10.toString());
            throw new C9721b(1201, e10.toString(), str);
        } catch (C13199p e11) {
            C11839m.m70687e("QueryProtocolOpenRegionsTask", "onAccessToken: " + e11.toString());
            C13452e.m80781L().m80972t1();
            throw new C9721b(1102, e11.toString(), str);
        }
    }

    /* renamed from: f */
    public List<String> m67589f(String str) throws C9721b {
        try {
            String strM67588e = m67588e(str);
            String str2 = C13040c.m78609F().m78646f0() + "/HiCloudUserInformationService/v1/protocol/regions/open";
            String strM66627b = C11058a.m66627b("07059");
            C11060c c11060c = new C11060c();
            c11060c.m66636B("06008");
            c11060c.m66643I(strM66627b);
            c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
            c11060c.m66670z("2.0");
            c11060c.m66644J(C13452e.m80781L().m80971t0());
            c11060c.m66664t(str);
            String str3 = (String) C12612a.m76107g(str2, new C1269c(strM67588e, str, "", strM66627b), c11060c);
            C11839m.m70686d("QueryProtocolOpenRegionsTask", "response:" + str3);
            if (str3 == null || str3.isEmpty()) {
                throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "response is null", str);
            }
            return ((QueryProtocolOpenRegionsRsp) m67586d(str3, QueryProtocolOpenRegionsRsp.class)).getCountryList();
        } catch (Exception e10) {
            C11839m.m70687e("QueryProtocolOpenRegionsTask", "query protocol open regions exception:" + e10.getMessage());
            return Arrays.asList(this.f52845b);
        }
    }
}
