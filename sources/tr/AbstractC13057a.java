package tr;

import android.content.Context;
import com.huawei.location.lite.common.report.ReportBuilder;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: tr.a */
/* loaded from: classes8.dex */
public abstract class AbstractC13057a implements InterfaceC13059c {

    /* renamed from: q */
    public static final int f59399q = Runtime.getRuntime().availableProcessors();

    /* renamed from: a */
    public List<InterfaceC13062f> f59400a;

    /* renamed from: b */
    public List<InterfaceC13062f> f59401b;

    /* renamed from: c */
    public int f59402c;

    /* renamed from: d */
    public int f59403d;

    /* renamed from: e */
    public int f59404e;

    /* renamed from: f */
    public int f59405f;

    /* renamed from: g */
    public SSLSocketFactory f59406g;

    /* renamed from: h */
    public X509TrustManager f59407h;

    /* renamed from: i */
    public HostnameVerifier f59408i;

    /* renamed from: j */
    public Proxy f59409j;

    /* renamed from: k */
    public boolean f59410k;

    /* renamed from: l */
    public boolean f59411l;

    /* renamed from: m */
    public boolean f59412m;

    /* renamed from: n */
    public boolean f59413n;

    /* renamed from: o */
    public ReportBuilder f59414o;

    /* renamed from: p */
    public Context f59415p;

    public AbstractC13057a(C13058b c13058b, Context context) {
        this.f59415p = context;
        this.f59402c = c13058b.f59418c;
        this.f59403d = c13058b.f59419d;
        this.f59404e = c13058b.f59420e;
        this.f59405f = c13058b.f59421f;
        this.f59406g = c13058b.f59422g;
        this.f59407h = c13058b.f59423h;
        this.f59408i = c13058b.f59424i;
        this.f59409j = c13058b.f59425j;
        this.f59410k = c13058b.f59426k;
        this.f59411l = c13058b.f59427l;
        this.f59412m = c13058b.f59428m;
        this.f59413n = c13058b.f59429n;
        this.f59414o = c13058b.f59430o;
        List<InterfaceC13062f> list = c13058b.f59416a;
        this.f59400a = list;
        if (list == null) {
            this.f59400a = new ArrayList(8);
        }
        this.f59401b = c13058b.f59417b;
    }

    /* renamed from: c */
    public abstract void mo38445c();

    /* renamed from: d */
    public ReportBuilder m78784d() {
        return this.f59414o;
    }

    /* renamed from: e */
    public abstract void mo38446e();

    @Override // tr.InterfaceC13059c
    public void init() {
        if (this.f59410k) {
            mo38445c();
        }
        mo38446e();
    }
}
