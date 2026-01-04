package com.huawei.openalliance.p169ad.analysis;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7077du;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.C7653sb;
import com.huawei.openalliance.p169ad.C7662sk;
import com.huawei.openalliance.p169ad.InterfaceC7003ct;
import com.huawei.openalliance.p169ad.beans.inner.HttpConnection;
import com.huawei.openalliance.p169ad.beans.inner.LocationSwitches;
import com.huawei.openalliance.p169ad.beans.metadata.AdTimeStatistics;
import com.huawei.openalliance.p169ad.beans.metadata.BluetoothInfo;
import com.huawei.openalliance.p169ad.beans.metadata.Location;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.download.DownloadTask;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.net.http.Response;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7803cw;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.C7762bi;
import com.huawei.openalliance.p169ad.utils.C7838q;
import java.lang.reflect.Field;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONException;

/* renamed from: com.huawei.openalliance.ad.analysis.h */
/* loaded from: classes8.dex */
public class C6927h extends AbstractC6925f implements InterfaceC7003ct {
    public C6927h(Context context) {
        super(context);
    }

    /* renamed from: a */
    private int m39169a(Throwable th2) {
        if (th2 instanceof SSLHandshakeException) {
            return 10000;
        }
        if (th2 instanceof SocketTimeoutException) {
            return 10001;
        }
        if (th2 instanceof ConnectException) {
            return 10002;
        }
        if (th2 instanceof UnknownHostException) {
            return 10003;
        }
        return th2 instanceof JSONException ? 10004 : -1;
    }

    /* renamed from: b */
    private String m39176b(int i10) {
        String strM39171a;
        try {
            strM39171a = m39171a(ErrorCode.class, Integer.valueOf(i10));
        } catch (IllegalAccessException unused) {
            AbstractC7185ho.m43823c("AnalysisReport", "getVariableNameByValue Exception");
            strM39171a = null;
        }
        return !TextUtils.isEmpty(strM39171a) ? strM39171a.replace("error_code_", "") : strM39171a;
    }

    /* renamed from: a */
    private String m39170a(RequestOptions requestOptions) {
        StringBuilder sb2 = new StringBuilder();
        RequestOptions requestConfiguration = HiAd.getInstance(this.f31973a).getRequestConfiguration();
        String str = (requestConfiguration == null || requestConfiguration.isRequestLocation()) ? "1" : "0";
        String str2 = (requestOptions == null || requestOptions.isRequestLocation()) ? "1" : "0";
        LocationSwitches locationSwitchesM47779a = C7762bi.m47779a(this.f31973a);
        String str3 = locationSwitchesM47779a.m39413c() == 1 ? "1" : "0";
        String str4 = locationSwitchesM47779a.m39410b() == 1 ? "1" : "0";
        String str5 = locationSwitchesM47779a.m39407a() == 1 ? "1" : "0";
        sb2.append("1");
        sb2.append("1");
        sb2.append("1");
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str4);
        sb2.append(str5);
        AbstractC7185ho.m43818a("AnalysisReport", "addition info is %s", sb2.toString());
        return sb2.toString();
    }

    /* renamed from: a */
    private String m39171a(Class cls, Object obj) {
        for (Field field : cls.getDeclaredFields()) {
            if (((~field.getModifiers()) & 24) == 0 && field.get(cls).equals(obj)) {
                return field.getName().toLowerCase(Locale.ENGLISH);
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m39177a(int i10, C6920a c6920a, String str, ContentRecord contentRecord) {
        String str2;
        String str3 = Constants.NORMAL_CACHE;
        try {
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a != null && c6920a != null) {
                c6921bM39159a.m38827ak("54");
                c6921bM39159a.m38936a(c6920a.m38873d());
                c6921bM39159a.m39039s(c6920a.m38866a());
                c6921bM39159a.m39031o(c6920a.m38869b());
                c6921bM39159a.m38998c(i10);
                c6921bM39159a.m38828al(Constants.NORMAL_CACHE);
                c6921bM39159a.m38830an(str);
                if (contentRecord != null) {
                    c6921bM39159a.m38898H(contentRecord.m41591o());
                    c6921bM39159a.m39033p(contentRecord.m41588n());
                    c6921bM39159a.m38939a(Integer.valueOf(contentRecord.m41392E()));
                    if (contentRecord.m41495aq()) {
                        str3 = "exsplash";
                    }
                    c6921bM39159a.m38828al(str3);
                    c6921bM39159a.m38829am(String.valueOf(contentRecord.m41498at()));
                }
                c6921bM39159a.m39037r("errorCode:" + i10 + ", reason:" + m39176b(i10));
                AbstractC7185ho.m43818a("AnalysisReport", "onSplashAdLoadFailed, reason: %s", c6921bM39159a.m39036r());
                Context context = this.f31973a;
                new C7560ou(context, C7662sk.m47225a(context, c6920a.m38873d())).mo46609b(c6921bM39159a, false, true);
            }
        } catch (RuntimeException unused) {
            str2 = "onSplashAdLoadFailed RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str2);
        } catch (Exception unused2) {
            str2 = "onSplashAdLoadFailed Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str2);
        }
    }

    /* renamed from: a */
    private void m39172a(final int i10, AdSlotParam adSlotParam, final C6921b c6921b) {
        Location locationM40658k = adSlotParam == null ? null : adSlotParam.m40658k();
        c6921b.m38862o(System.currentTimeMillis());
        if (locationM40658k != null) {
            Double dM40237c = locationM40658k.m40237c();
            Double dM40235b = locationM40658k.m40235b();
            c6921b.m38993b(dM40237c);
            c6921b.m38938a(dM40235b);
            m39165a(c6921b, dM40235b, dM40237c, 1);
        }
        c6921b.m38863p(System.currentTimeMillis());
        final int iMo43091y = C7124fh.m43316b(this.f31973a).mo43091y();
        c6921b.m38940a(Long.valueOf(AbstractC7811dd.m48327f()));
        C7838q.m48498a(this.f31973a, new C7838q.a() { // from class: com.huawei.openalliance.ad.analysis.h.1
            @Override // com.huawei.openalliance.p169ad.utils.C7838q.a
            /* renamed from: a */
            public void mo39194a(List<BluetoothInfo> list, int i11) {
                if (list != null) {
                    int size = list.size();
                    int i12 = iMo43091y;
                    if (size > i12) {
                        list = list.subList(0, i12);
                    }
                }
                if (!AbstractC7760bg.m47767a(list)) {
                    c6921b.m38926V(AbstractC7758be.m47742b(list));
                }
                c6921b.m39012f(Integer.valueOf(i11));
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("AnalysisReport", "wifi retCode: %s,  bt retCode: %s", c6921b.m38974ak(), c6921b.m38975al());
                }
                Context context = C6927h.this.f31973a;
                new C7560ou(context, C7662sk.m47225a(context, i10)).mo46609b(c6921b, true, false);
            }
        });
    }

    /* renamed from: a */
    private void m39173a(C6921b c6921b, HttpConnection httpConnection, String str) {
        if (httpConnection != null) {
            c6921b.m39045v(AbstractC7806cz.m48170d(httpConnection.m39402a()));
            c6921b.m38955aa(AbstractC7806cz.m48170d(httpConnection.m39405b()));
            c6921b.m38957ab(AbstractC7806cz.m48170d(httpConnection.m39406c()));
            c6921b.m38959ac(AbstractC7806cz.m48170d(httpConnection.m39403a("dl-from")));
        }
        String strM38982as = c6921b.m38982as();
        String strM38983at = c6921b.m38983at();
        if (TextUtils.isEmpty(strM38982as) || TextUtils.isEmpty(strM38983at)) {
            try {
                String host = Uri.parse(str).getHost();
                c6921b.m38955aa(AbstractC7806cz.m48170d(host));
                c6921b.m38957ab(AbstractC7806cz.m48170d(InetAddress.getByName(host).getHostAddress()));
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("AnalysisReport", "onAdResDownload parse url exception: %s", th2.getClass().getSimpleName());
            }
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("AnalysisReport", "onAdResDownload analysisType: %s, cdnDomain: %s, cdnIp: %s, dlFrom: %s, trackVersion: %s", c6921b.m38812aL(), AbstractC7819dl.m48375a(c6921b.m38982as()), AbstractC7819dl.m48375a(c6921b.m38983at()), c6921b.m38984au(), c6921b.m38951aI());
        }
    }

    /* renamed from: a */
    private void m39174a(C6921b c6921b, Response response) {
        if (c6921b == null || response == null) {
            return;
        }
        Object objM45987b = response.m45987b();
        AdContentRsp adContentRsp = objM45987b instanceof AdContentRsp ? (AdContentRsp) objM45987b : null;
        if (adContentRsp == null || adContentRsp.m40860t() == null) {
            return;
        }
        c6921b.m38833aq(AbstractC7758be.m47742b(adContentRsp.m40860t()));
    }

    /* renamed from: a */
    private void m39175a(AdSlotParam adSlotParam, Response response, String str, List<String> list, C6921b c6921b, boolean z10) {
        if (response != null) {
            c6921b.m38830an(String.valueOf(response.m46004i()));
            c6921b.m39047w(response.m46005j());
            HttpConnection httpConnectionM46008m = response.m46008m();
            if (httpConnectionM46008m != null) {
                c6921b.m39045v(AbstractC7806cz.m48170d(httpConnectionM46008m.m39402a()));
            }
            c6921b.m38834ar(String.valueOf(response.m46010o() ? 1 : 0));
            c6921b.m38837au(String.valueOf(response.m46015t()));
        }
        if (!AbstractC7760bg.m47767a(list)) {
            c6921b.m38835as(String.valueOf(list.size()));
        }
        if (adSlotParam != null) {
            c6921b.m39008e(adSlotParam.m40621E());
            AbstractC7185ho.m43818a("AnalysisReport", "grpIdCode: %s", Integer.valueOf(c6921b.m38950aH()));
        }
        if (z10) {
            c6921b.m38932Y(str);
            if (adSlotParam != null) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("AnalysisReport", "WlacStatus: %s", adSlotParam.m40670w());
                }
                c6921b.m38836at(String.valueOf(adSlotParam.m40670w()));
            }
        }
    }

    /* renamed from: a */
    public void m39178a(ContentRecord contentRecord, String str) {
        StringBuilder sb2;
        String str2;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onDiskSpaceInsufficient, contentRecord is null");
                return;
            }
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("73");
            c6921bM39167f.m38828al(str);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue()), contentRecord).mo46609b(c6921bM39167f, false, true);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "onDiskSpaceInsufficient RuntimeException:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "onDiskSpaceInsufficient Exception:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39179a(C7077du c7077du, String str, long j10) {
        ContentRecord contentRecord;
        int iM42096a;
        if (c7077du == null) {
            AbstractC7185ho.m43823c("AnalysisReport", "reportAdResDownloadEvent, task is null");
        }
        contentRecord = new ContentRecord();
        contentRecord.m41507b(c7077du.m42696G());
        contentRecord.m41549e(c7077du.m42691B());
        contentRecord.m41543d(c7077du.m42692C());
        contentRecord.m41555f(c7077du.mo42082n());
        contentRecord.m41592o(c7077du.m42698I());
        DownloadTask.EnumC7030b enumC7030bM42078j = c7077du.m42078j();
        if (enumC7030bM42078j == null) {
            enumC7030bM42078j = DownloadTask.EnumC7030b.NONE;
        }
        iM42096a = enumC7030bM42078j.m42096a();
        str.hashCode();
        switch (str) {
            case "2":
                m39186a(c7077du.m42045a(), iM42096a, c7077du.m42697H(), null, c7077du.m42694E(), j10, contentRecord, null, c7077du.m42089u());
                break;
            case "5":
                m39189a(c7077du.m42045a(), null, c7077du.m42694E(), c7077du.m42695F(), Long.valueOf(j10), c7077du.m42693D(), contentRecord, null, c7077du.m42073f(), c7077du.m42089u());
                break;
            case "72":
                m39190a(c7077du.m42045a(), (Long) null, c7077du.m42694E(), c7077du.m42693D(), contentRecord, (String) null, c7077du.m42089u());
                break;
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7003ct
    /* renamed from: a */
    public void mo39180a(C7653sb c7653sb, String str, long j10, long j11, int i10, String str2) {
        if (c7653sb == null) {
            AbstractC7185ho.m43823c("AnalysisReport", "reportAdResDownloadEvent, sourceParam is null");
        }
        str.hashCode();
        switch (str) {
            case "2":
                m39186a(c7653sb.m47194i(), i10, str2, c7653sb.m47196k(), Long.valueOf(j10), j11, c7653sb.m47197l(), c7653sb.m47202q(), c7653sb.m47199n());
                break;
            case "3":
                m39188a(c7653sb.m47194i(), c7653sb.m47196k(), Long.valueOf(j10), j11, c7653sb.m47197l(), c7653sb.m47202q());
                break;
            case "5":
                m39189a(c7653sb.m47194i(), c7653sb.m47196k(), Long.valueOf(j10), c7653sb.m47201p(), Long.valueOf(j11), false, c7653sb.m47197l(), c7653sb.m47202q(), c7653sb.m47200o(), c7653sb.m47199n());
                break;
            case "72":
                m39190a(c7653sb.m47194i(), c7653sb.m47196k(), Long.valueOf(j10), false, c7653sb.m47197l(), c7653sb.m47202q(), c7653sb.m47199n());
                break;
            case "73":
                m39178a(c7653sb.m47197l(), c7653sb.m47202q());
                break;
        }
    }

    /* renamed from: a */
    public void m39181a(String str, int i10, int i11) {
        try {
            if (AbstractC7806cz.m48165b(str) || i10 <= 0) {
                AbstractC7185ho.m43820b("AnalysisReport", "no fc");
            }
            C6921b c6921bM39152a = m39152a();
            c6921bM39152a.m38827ak("162");
            c6921bM39152a.m39031o(str);
            c6921bM39152a.m38936a(i11);
            c6921bM39152a.m38828al(String.valueOf(i10));
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, -1)).mo46609b(c6921bM39152a, false, true);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "fc analysis err, %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public void m39182a(String str, int i10, int i11, long j10, boolean z10, Response response, String str2) {
        int iM46003h;
        StringBuilder sb2;
        String str3;
        if (response == null) {
            iM46003h = 0;
        } else {
            try {
                iM46003h = response.m46003h();
            } catch (RuntimeException e10) {
                e = e10;
                sb2 = new StringBuilder();
                str3 = "onAdRequestSuccess RuntimeException:";
                sb2.append(str3);
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
                return;
            } catch (Exception e11) {
                e = e11;
                sb2 = new StringBuilder();
                str3 = "onAdRequestSuccess Exception:";
                sb2.append(str3);
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
                return;
            }
        }
        C6921b c6921bM39153a = m39153a(iM46003h);
        if (c6921bM39153a == null) {
            return;
        }
        c6921bM39153a.m38827ak(iM46003h == 1 ? "75" : iM46003h == 3 ? "123" : z10 ? "28" : "7");
        c6921bM39153a.m39039s(str);
        c6921bM39153a.m39037r("retCode:" + i11);
        c6921bM39153a.m38936a(i10);
        c6921bM39153a.m38932Y(str2);
        c6921bM39153a.m39051y(AbstractC7807d.m48250m(this.f31973a));
        m39164a(c6921bM39153a, response, j10);
        Context context = this.f31973a;
        new C7560ou(context, C7662sk.m47225a(context, i10)).mo46609b(c6921bM39153a, false, false);
    }

    /* renamed from: a */
    public void m39183a(String str, int i10, int i11, Integer num, boolean z10, AdTimeStatistics adTimeStatistics) {
        StringBuilder sb2;
        String str2;
        try {
            C6921b c6921bM39152a = m39152a();
            if (c6921bM39152a == null) {
                return;
            }
            c6921bM39152a.m38827ak("113");
            c6921bM39152a.m39039s(str);
            c6921bM39152a.m38936a(i10);
            c6921bM39152a.m38994b(Integer.valueOf(!z10 ? 1 : 0));
            c6921bM39152a.m38932Y(AbstractC7758be.m47742b(adTimeStatistics));
            c6921bM39152a.m38829am(String.valueOf(i11));
            if (num != null) {
                c6921bM39152a.m38830an(String.valueOf(num));
            }
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, i10)).mo46609b(c6921bM39152a, false, false);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "onAdCounting RuntimeException:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "onAdCounting Exception:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39184a(String str, int i10, int i11, String str2, int i12, long j10, boolean z10, Response response) {
        int iM46003h;
        StringBuilder sb2;
        String str3;
        if (response == null) {
            iM46003h = 0;
        } else {
            try {
                iM46003h = response.m46003h();
            } catch (RuntimeException e10) {
                e = e10;
                sb2 = new StringBuilder();
                str3 = "onAdRequestFail RuntimeException:";
                sb2.append(str3);
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
                return;
            } catch (Exception e11) {
                e = e11;
                sb2 = new StringBuilder();
                str3 = "onAdRequestFail Exception:";
                sb2.append(str3);
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
                return;
            }
        }
        C6921b c6921bM39153a = m39153a(iM46003h);
        if (c6921bM39153a == null) {
            return;
        }
        c6921bM39153a.m38827ak(iM46003h == 1 ? "76" : iM46003h == 3 ? "124" : z10 ? "29" : "8");
        c6921bM39153a.m39039s(str);
        c6921bM39153a.m39037r("httpCode:" + i11 + ", reason:" + str2 + ", retCode:" + i12);
        c6921bM39153a.m38936a(i10);
        m39164a(c6921bM39153a, response, j10);
        Context context = this.f31973a;
        new C7560ou(context, C7662sk.m47225a(context, i10)).mo46609b(c6921bM39153a, false, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065 A[Catch: Exception -> 0x002a, RuntimeException -> 0x002d, TryCatch #2 {RuntimeException -> 0x002d, Exception -> 0x002a, blocks: (B:6:0x0015, B:12:0x0026, B:24:0x0043, B:26:0x0053, B:32:0x0065, B:34:0x006b, B:36:0x007b, B:37:0x0082, B:40:0x00f7, B:42:0x00ff, B:43:0x0103, B:18:0x0032, B:20:0x0038, B:5:0x0011), top: B:49:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007b A[Catch: Exception -> 0x002a, RuntimeException -> 0x002d, TryCatch #2 {RuntimeException -> 0x002d, Exception -> 0x002a, blocks: (B:6:0x0015, B:12:0x0026, B:24:0x0043, B:26:0x0053, B:32:0x0065, B:34:0x006b, B:36:0x007b, B:37:0x0082, B:40:0x00f7, B:42:0x00ff, B:43:0x0103, B:18:0x0032, B:20:0x0038, B:5:0x0011), top: B:49:0x0011 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m39185a(java.lang.String r19, int r20, long r21, com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam r23, com.huawei.openalliance.p169ad.net.http.Response r24, java.lang.String r25, java.util.List<java.lang.String> r26) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.analysis.C6927h.m39185a(java.lang.String, int, long, com.huawei.openalliance.ad.beans.parameter.AdSlotParam, com.huawei.openalliance.ad.net.http.Response, java.lang.String, java.util.List):void");
    }

    /* renamed from: a */
    public void m39186a(String str, int i10, String str2, Long l10, Long l11, long j10, ContentRecord contentRecord, String str3, HttpConnection httpConnection) {
        StringBuilder sb2;
        String str4;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onAdResDownloadFailed, contentRecord is null");
                return;
            }
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("2");
            c6921bM39167f.m39035q(str);
            c6921bM39167f.m39037r("httpCode:" + i10 + ", reason:" + str2);
            c6921bM39167f.m38998c(i10);
            c6921bM39167f.m39047w(str2);
            if (l10 != null) {
                long jLongValue = j10 - l10.longValue();
                AbstractC7185ho.m43818a("AnalysisReport", "onAdResDownloadFailed - adReqToContentDownloadDuration: %d", Long.valueOf(jLongValue));
                c6921bM39167f.m39041t(String.valueOf(jLongValue));
            }
            if (l11 != null) {
                long jLongValue2 = j10 - l11.longValue();
                AbstractC7185ho.m43818a("AnalysisReport", "onAdResDownloadFailed - contentDownloadDuration: %d", Long.valueOf(jLongValue2));
                c6921bM39167f.m39043u(String.valueOf(jLongValue2));
            }
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("AnalysisReport", "ExceptionType is %s, TrackVersion is %s", c6921bM39167f.m38812aL(), c6921bM39167f.m38951aI());
            }
            String strM48136f = AbstractC7803cw.m48136f(this.f31973a);
            if (!TextUtils.isEmpty(strM48136f)) {
                c6921bM39167f.m38855h(AbstractC7731ae.m47463d(strM48136f).longValue());
                c6921bM39167f.m38856i(AbstractC7731ae.m47459c(strM48136f).longValue());
            }
            String strM48137g = AbstractC7803cw.m48137g(this.f31973a);
            if (!TextUtils.isEmpty(strM48137g)) {
                c6921bM39167f.m38857j(AbstractC7731ae.m47463d(strM48137g).longValue());
                c6921bM39167f.m38858k(AbstractC7731ae.m47459c(strM48137g).longValue());
            }
            c6921bM39167f.m38828al(str3);
            c6921bM39167f.m38829am(contentRecord.m41423U());
            m39173a(c6921bM39167f, httpConnection, str);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue()), contentRecord).mo46609b(c6921bM39167f, false, true);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str4 = "onAdResDownloadFailed RuntimeException:";
            sb2.append(str4);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str4 = "onAdResDownloadFailed Exception:";
            sb2.append(str4);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39187a(String str, ContentRecord contentRecord, long j10) {
        String str2;
        try {
            if (str == null || contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onAdExpire, contentRecord or ExceptionType is null ");
                return;
            }
            String strM41585m = contentRecord.m41585m();
            String strM41588n = contentRecord.m41588n();
            int iM41552f = contentRecord.m41552f();
            C6921b c6921bM39153a = m39153a(contentRecord.m41492an());
            if (c6921bM39153a == null) {
                return;
            }
            c6921bM39153a.m38827ak(str);
            c6921bM39153a.m39031o(strM41585m);
            c6921bM39153a.m39033p(strM41588n);
            c6921bM39153a.m38936a(iM41552f);
            if (j10 > 0) {
                c6921bM39153a.m38851d(j10);
            }
            Context context = this.f31973a;
            C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, iM41552f));
            c7560ou.mo46590a(contentRecord);
            c7560ou.mo46609b(c6921bM39153a, false, true);
        } catch (RuntimeException unused) {
            str2 = "onAdInvalid RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str2);
        } catch (Exception unused2) {
            str2 = "onAdInvalid Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str2);
        }
    }

    /* renamed from: a */
    public void m39188a(String str, Long l10, Long l11, long j10, ContentRecord contentRecord, String str2) {
        String str3;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onAdResCheckFailed, contentRecord is null");
                return;
            }
            C6921b c6921bM39152a = m39152a();
            if (c6921bM39152a == null) {
                return;
            }
            c6921bM39152a.m38827ak("3");
            C6921b c6921bM39154a = m39154a(c6921bM39152a, contentRecord);
            c6921bM39154a.m39035q(str);
            if (l10 != null) {
                long jLongValue = j10 - l10.longValue();
                AbstractC7185ho.m43818a("AnalysisReport", "onAdResCheckFailed - adReqToContentDownloadDuration: %d", Long.valueOf(jLongValue));
                c6921bM39154a.m39041t(String.valueOf(jLongValue));
            }
            if (l11 != null) {
                long jLongValue2 = j10 - l11.longValue();
                AbstractC7185ho.m43818a("AnalysisReport", "onAdResCheckFailed - contentDownloadDuration: %d", Long.valueOf(jLongValue2));
                c6921bM39154a.m39043u(String.valueOf(jLongValue2));
            }
            c6921bM39154a.m38828al(str2);
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("AnalysisReport", "ExceptionType is %s, TrackVersion is %s", c6921bM39154a.m38812aL(), c6921bM39154a.m38951aI());
            }
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39154a.m39040t().intValue()), contentRecord).mo46609b(c6921bM39154a, false, true);
        } catch (RuntimeException unused) {
            str3 = "onAdResCheckFailed RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str3);
        } catch (Exception unused2) {
            str3 = "onAdResCheckFailed Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str3);
        }
    }

    /* renamed from: a */
    public void m39189a(String str, Long l10, Long l11, Long l12, Long l13, boolean z10, ContentRecord contentRecord, String str2, long j10, HttpConnection httpConnection) {
        StringBuilder sb2;
        String str3;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onAdResDownloadSuccess, contentRecord is null");
                return;
            }
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("5");
            c6921bM39167f.m39037r("isCached:" + z10);
            c6921bM39167f.m39035q(str);
            if (l12 != null) {
                if (l10 != null) {
                    long jLongValue = l12.longValue() - l10.longValue();
                    AbstractC7185ho.m43818a("AnalysisReport", "onAdResDownloadSuccess - adReqToContentDownloadDuration: %d", Long.valueOf(jLongValue));
                    c6921bM39167f.m39041t(String.valueOf(jLongValue));
                }
                if (l11 != null) {
                    long jLongValue2 = l12.longValue() - l11.longValue();
                    AbstractC7185ho.m43818a("AnalysisReport", "onAdResDownloadSuccess - contentDownloadDuration: %d", Long.valueOf(jLongValue2));
                    c6921bM39167f.m39043u(String.valueOf(jLongValue2));
                    if (jLongValue2 > 0 && j10 > 0) {
                        long j11 = ((100000 * j10) / jLongValue2) / 100;
                        c6921bM39167f.m38853f(j11);
                        if (AbstractC7185ho.m43819a()) {
                            AbstractC7185ho.m43818a("AnalysisReport", "onAdResDownloadSuccess - total download time: %d(ms) total download size: %d(bytes) avg. speed: %d(bytes/s)", Long.valueOf(jLongValue2), Long.valueOf(j10), Long.valueOf(j11));
                        }
                    }
                }
                if (l13 != null && !z10) {
                    long jLongValue3 = l13.longValue() - l12.longValue();
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("AnalysisReport", "onAdResDownloadSuccess - fileOperateDuration: %s", Long.valueOf(jLongValue3));
                    }
                    c6921bM39167f.m38851d(jLongValue3);
                }
            }
            c6921bM39167f.m38854g(j10);
            String strM48136f = AbstractC7803cw.m48136f(this.f31973a);
            if (!TextUtils.isEmpty(strM48136f)) {
                c6921bM39167f.m38855h(AbstractC7731ae.m47463d(strM48136f).longValue());
                c6921bM39167f.m38856i(AbstractC7731ae.m47459c(strM48136f).longValue());
            }
            String strM48137g = AbstractC7803cw.m48137g(this.f31973a);
            if (!TextUtils.isEmpty(strM48137g)) {
                c6921bM39167f.m38857j(AbstractC7731ae.m47463d(strM48137g).longValue());
                c6921bM39167f.m38858k(AbstractC7731ae.m47459c(strM48137g).longValue());
            }
            c6921bM39167f.m38828al(str2);
            c6921bM39167f.m38829am(contentRecord.m41423U());
            m39173a(c6921bM39167f, httpConnection, str);
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("AnalysisReport", "ExceptionType is %s, TrackVersion is %s", c6921bM39167f.m38812aL(), c6921bM39167f.m38951aI());
            }
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue()), contentRecord).mo46609b(c6921bM39167f, false, true);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str3 = "onAdResDownloadSuccess RuntimeException:";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str3 = "onAdResDownloadSuccess Exception:";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39190a(String str, Long l10, Long l11, boolean z10, ContentRecord contentRecord, String str2, HttpConnection httpConnection) {
        StringBuilder sb2;
        String str3;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onAdResDownload, contentRecord is null");
                return;
            }
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak("72");
            c6921bM39167f.m39035q(str);
            c6921bM39167f.m38828al(str2);
            c6921bM39167f.m38829am(contentRecord.m41423U());
            m39173a(c6921bM39167f, httpConnection, str);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, c6921bM39167f.m39040t().intValue()), contentRecord).mo46609b(c6921bM39167f, false, true);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str3 = "onAdResDownload RuntimeException:";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str3 = "onAdResDownload Exception:";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39191a(String str, String str2, int i10, int i11, String str3, String str4) {
        StringBuilder sb2;
        String str5;
        try {
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38827ak("81");
            c6921bM39159a.m39031o(str2);
            c6921bM39159a.m39039s(str);
            c6921bM39159a.m38936a(i10);
            c6921bM39159a.m38998c(i11);
            c6921bM39159a.m38828al(str3);
            c6921bM39159a.m39037r(str4);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, i10)).mo46609b(c6921bM39159a, false, false);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str5 = "onInnerError RuntimeException:";
            sb2.append(str5);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str5 = "onInnerError Exception:";
            sb2.append(str5);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39192a(String str, List<String> list, int i10, Response response) {
        String simpleName;
        String message;
        int iM39169a;
        Throwable thM46009n;
        if (response == null || (thM46009n = response.m46009n()) == null) {
            simpleName = null;
            message = "unknown";
            iM39169a = -1;
        } else {
            simpleName = thM46009n.getClass().getSimpleName();
            message = thM46009n.getMessage();
            iM39169a = m39169a(thM46009n);
        }
        for (String str2 : list) {
            if (!TextUtils.isEmpty(str2)) {
                m39191a(str, str2, i10, iM39169a, simpleName, message);
            }
        }
    }

    /* renamed from: a */
    public void m39193a(List<ContentResource> list, Integer num) {
        StringBuilder sb2;
        String str;
        try {
            if (AbstractC7760bg.m47767a(list)) {
                AbstractC7185ho.m43823c("AnalysisReport", "onContentResourceRemoved, contentRecord is null");
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            int size = list.size();
            String strM41621a = null;
            int iM41631d = -1;
            int iM41637f = 1;
            for (int i10 = 0; i10 < size; i10++) {
                ContentResource contentResource = list.get(i10);
                if (i10 == 0) {
                    iM41631d = contentResource.m41631d();
                    iM41637f = contentResource.m41637f();
                    strM41621a = contentResource.m41621a();
                } else {
                    sb3.append(",");
                }
                sb3.append(contentResource.m41628c());
                sb3.append("#");
                sb3.append(contentResource.m41631d());
                sb3.append("#");
                sb3.append(contentResource.m41640h());
                sb3.append("#");
                sb3.append(contentResource.m41634e());
                sb3.append("#");
                sb3.append(contentResource.m41625b());
            }
            C6921b c6921bM39152a = m39152a();
            if (c6921bM39152a == null) {
                return;
            }
            c6921bM39152a.m38936a(iM41631d);
            c6921bM39152a.m38827ak("77");
            c6921bM39152a.m39037r(sb3.toString());
            c6921bM39152a.m38994b(Integer.valueOf(iM41637f));
            c6921bM39152a.m39035q(strM41621a);
            if (num != null) {
                c6921bM39152a.m38828al(String.valueOf(num));
            }
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, -1)).mo46609b(c6921bM39152a, false, true);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "onContentResourceRemoved RuntimeException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "onContentResourceRemoved Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }
}
