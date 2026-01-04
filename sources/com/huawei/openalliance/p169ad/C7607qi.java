package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.C7569pc;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.beans.metadata.Monitor;
import com.huawei.openalliance.p169ad.beans.server.ThirdReportRsp;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EncryptionField;
import com.huawei.openalliance.p169ad.p171db.bean.ThirdPartyEventRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.RunnableC7813df;
import com.huawei.openalliance.p169ad.utils.ThreadFactoryC7835n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.openalliance.ad.qi */
/* loaded from: classes8.dex */
public class C7607qi {

    /* renamed from: a */
    private static final Executor f35476a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC7835n("ThirdMonitor-Event"));

    /* renamed from: b */
    private Context f35477b;

    /* renamed from: c */
    private InterfaceC7138fv f35478c;

    /* renamed from: d */
    private C7569pc f35479d;

    /* renamed from: e */
    private InterfaceC7140fx f35480e;

    /* renamed from: f */
    private InterfaceC7671st f35481f;

    /* renamed from: g */
    private List<a> f35482g;

    /* renamed from: com.huawei.openalliance.ad.qi$a */
    public interface a {
        /* renamed from: a */
        String mo47035a(String str);
    }

    public C7607qi(Context context, InterfaceC7671st interfaceC7671st) {
        this.f35477b = context.getApplicationContext();
        this.f35478c = C7108ex.m43156a(context);
        this.f35479d = C7569pc.m46686a(context);
        this.f35480e = C7118fb.m43196a(context);
        this.f35481f = interfaceC7671st;
    }

    /* renamed from: a */
    private String m47021a(String str) {
        if (!AbstractC7760bg.m47767a(this.f35482g) && !TextUtils.isEmpty(str)) {
            for (a aVar : this.f35482g) {
                if (aVar != null) {
                    str = aVar.mo47035a(str);
                }
            }
        }
        return str;
    }

    /* renamed from: b */
    private static List<String> m47030b(List<ThirdPartyEventRecord> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<ThirdPartyEventRecord> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m41829a());
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<Monitor> m47022a(String str, ContentRecord contentRecord, Context context) {
        EncryptionField<List<Monitor>> encryptionFieldM41405L;
        List<Monitor> listM41652a;
        if (contentRecord == null || (encryptionFieldM41405L = contentRecord.m41405L()) == null || (listM41652a = encryptionFieldM41405L.m41652a(context)) == null || listM41652a.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Monitor monitor : listM41652a) {
            if (str.equals(monitor.m40347a())) {
                arrayList.add(monitor);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m47031b() {
        String str;
        List<ThirdPartyEventRecord> listMo43171b = this.f35478c.mo43171b(120000L, 3);
        AbstractC7185ho.m43820b("ThirdMonitorReporter", "uploadThirdPartyCacheEvents size: " + listMo43171b.size());
        if (AbstractC7760bg.m47767a(listMo43171b)) {
            return;
        }
        this.f35478c.mo43164a(AbstractC7741ao.m47566c(), m47030b(listMo43171b));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        byte[] bArrM48089b = AbstractC7796cp.m48089b(this.f35477b);
        for (ThirdPartyEventRecord thirdPartyEventRecord : listMo43171b) {
            EncryptionField<String> encryptionFieldM41833b = thirdPartyEventRecord.m41833b();
            if (encryptionFieldM41833b == null) {
                str = "urlField is empty";
            } else {
                C7569pc.a aVarM46692a = this.f35479d.m46692a(encryptionFieldM41833b.m41653a(bArrM48089b), thirdPartyEventRecord.m41839d(), thirdPartyEventRecord.m41846i());
                if (aVarM46692a == null) {
                    str = "monitorUrl is empty";
                } else {
                    String strM46696a = aVarM46692a.m46696a();
                    if (TextUtils.isEmpty(strM46696a)) {
                        AbstractC7185ho.m43823c("ThirdMonitorReporter", "formatThirdPartyUrl is empty when format third party cache url ");
                        arrayList.add(thirdPartyEventRecord.m41829a());
                    } else {
                        ContentRecord contentRecord = new ContentRecord();
                        contentRecord.m41507b(thirdPartyEventRecord.m41837c());
                        contentRecord.m41543d(thirdPartyEventRecord.m41841e());
                        contentRecord.m41549e(thirdPartyEventRecord.m41843f());
                        contentRecord.m41592o(thirdPartyEventRecord.m41845h());
                        contentRecord.m41560g(thirdPartyEventRecord.m41846i());
                        long jM47566c = AbstractC7741ao.m47566c();
                        ThirdReportRsp thirdReportRspMo43279b = this.f35480e.mo43279b(strM46696a);
                        long jM47566c2 = AbstractC7741ao.m47566c() - jM47566c;
                        if (m47029a(thirdReportRspMo43279b)) {
                            arrayList.add(thirdPartyEventRecord.m41829a());
                            m47024a(this.f35477b, thirdPartyEventRecord.m41844g(), strM46696a, aVarM46692a.m46697b(), contentRecord, jM47566c2);
                        } else {
                            arrayList2.add(thirdPartyEventRecord.m41829a());
                            this.f35478c.mo43169a(thirdPartyEventRecord.m41829a(), aVarM46692a.m46697b());
                            m47023a(this.f35477b, thirdPartyEventRecord.m41844g(), strM46696a, aVarM46692a.m46697b(), jM47566c2, contentRecord, thirdReportRspMo43279b);
                        }
                    }
                }
            }
            AbstractC7185ho.m43820b("ThirdMonitorReporter", str);
            arrayList.add(thirdPartyEventRecord.m41829a());
        }
        this.f35478c.mo43172b(AbstractC7741ao.m47566c(), arrayList2);
        this.f35478c.mo43170a(arrayList);
    }

    /* renamed from: a */
    public void m47032a() {
        m47027a(new Runnable() { // from class: com.huawei.openalliance.ad.qi.2
            @Override // java.lang.Runnable
            public void run() {
                C7607qi.this.m47031b();
            }
        });
    }

    /* renamed from: a */
    private static void m47023a(Context context, String str, String str2, String str3, long j10, ContentRecord contentRecord, ThirdReportRsp thirdReportRsp) {
        String str4;
        if (contentRecord == null) {
            return;
        }
        C6922c c6922c = new C6922c(context);
        StringBuilder sb2 = new StringBuilder();
        if (thirdReportRsp != null) {
            sb2.append("httpCode:");
            sb2.append(thirdReportRsp.m40964a());
            if (!TextUtils.isEmpty(thirdReportRsp.errorReason)) {
                sb2.append(", errorReason:");
                str4 = thirdReportRsp.errorReason;
            }
            c6922c.m39107a(str, str2, sb2.toString(), str3, j10, contentRecord);
        }
        str4 = "httpCode:-1";
        sb2.append(str4);
        c6922c.m39107a(str, str2, sb2.toString(), str3, j10, contentRecord);
    }

    /* renamed from: a */
    private static void m47024a(Context context, String str, String str2, String str3, ContentRecord contentRecord, long j10) {
        if (contentRecord == null) {
            return;
        }
        new C6922c(context).m39105a(str, str2, str3, j10, contentRecord);
    }

    /* renamed from: a */
    private void m47027a(Runnable runnable) {
        f35476a.execute(new RunnableC7813df(runnable));
    }

    /* renamed from: a */
    public void m47033a(final String str, final ContentRecord contentRecord) {
        final List<Monitor> listM47022a = m47022a(str, contentRecord, this.f35477b);
        if (AbstractC7760bg.m47767a(listM47022a)) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("ThirdMonitorReporter", "reportThirdMonitor, eventType: %s, monitors: %s", str, AbstractC7819dl.m48375a(AbstractC7758be.m47742b(listM47022a)));
        }
        AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.qi.1
            @Override // java.lang.Runnable
            public void run() {
                C7607qi.this.m47028a((List<Monitor>) listM47022a, str, contentRecord);
            }
        });
    }

    /* renamed from: a */
    public void m47034a(List<a> list) {
        this.f35482g = new ArrayList(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m47028a(List<Monitor> list, String str, ContentRecord contentRecord) {
        byte[] bArr;
        Iterator<Monitor> it;
        if (list == null || list.isEmpty()) {
            AbstractC7185ho.m43823c("ThirdMonitorReporter", "fail to report to thirdParty event, thirdParty  is empty");
            return;
        }
        byte[] bArrM48089b = AbstractC7796cp.m48089b(this.f35477b);
        Iterator<Monitor> it2 = list.iterator();
        while (it2.hasNext()) {
            Monitor next = it2.next();
            List<String> listM40351b = next.m40351b();
            if (listM40351b == null || listM40351b.isEmpty()) {
                byte[] bArr2 = bArrM48089b;
                Iterator<Monitor> it3 = it2;
                AbstractC7185ho.m43823c("ThirdMonitorReporter", "thirdParty monitor urls is empty ");
                it2 = it3;
                bArrM48089b = bArr2;
            } else {
                int iM40352c = next.m40352c();
                for (String str2 : listM40351b) {
                    if (!AbstractC7806cz.m48165b(str2)) {
                        AbstractC7185ho.m43821b("ThirdMonitorReporter", "report third party event，excute origin url, eventType:%s, originUrl:%s", str, AbstractC7819dl.m48375a(str2));
                        if (C7340jn.m45347a(contentRecord.m41588n()) || !C7340jn.m45346a(contentRecord.m41505b(), str2)) {
                            String strM47021a = m47021a(str2);
                            C7569pc.a aVarM46691a = this.f35479d.m46691a(strM47021a, contentRecord.m41460aL());
                            if (aVarM46691a != null) {
                                String strM46696a = aVarM46691a.m46696a();
                                if (TextUtils.isEmpty(strM46696a)) {
                                    AbstractC7185ho.m43823c("ThirdMonitorReporter", "url is empty when format third party url ");
                                } else {
                                    AbstractC7185ho.m43821b("ThirdMonitorReporter", "report third party event, eventType:%s, url:%s", str, AbstractC7819dl.m48375a(strM46696a));
                                    long jM47566c = AbstractC7741ao.m47566c();
                                    ThirdReportRsp thirdReportRspMo43279b = this.f35480e.mo43279b(strM46696a);
                                    long jM47566c2 = AbstractC7741ao.m47566c() - jM47566c;
                                    if (m47029a(thirdReportRspMo43279b)) {
                                        bArr = bArrM48089b;
                                        it = it2;
                                        m47024a(this.f35477b, str, strM46696a, aVarM46691a.m46697b(), contentRecord, jM47566c2);
                                    } else if (iM40352c == 1) {
                                        ThirdPartyEventRecord thirdPartyEventRecord = new ThirdPartyEventRecord(this.f35481f.mo47212a(), strM47021a, aVarM46691a.m46697b());
                                        thirdPartyEventRecord.m41840d(contentRecord.m41588n());
                                        thirdPartyEventRecord.m41838c(contentRecord.m41585m());
                                        thirdPartyEventRecord.m41830a(contentRecord.m41552f());
                                        thirdPartyEventRecord.m41834b(contentRecord.m41492an());
                                        thirdPartyEventRecord.m41857a(bArrM48089b);
                                        thirdPartyEventRecord.m41842e(str);
                                        bArr = bArrM48089b;
                                        it = it2;
                                        thirdPartyEventRecord.m41831a(System.currentTimeMillis());
                                        thirdPartyEventRecord.m41835b(contentRecord.m41460aL());
                                        this.f35478c.mo43166a(thirdPartyEventRecord);
                                        m47023a(this.f35477b, str, strM46696a, aVarM46691a.m46697b(), jM47566c2, contentRecord, thirdReportRspMo43279b);
                                    }
                                    it2 = it;
                                    bArrM48089b = bArr;
                                }
                            }
                        } else {
                            AbstractC7185ho.m43820b("ThirdMonitorReporter", "mz url had reported by ICustMonitor.");
                        }
                    }
                    bArr = bArrM48089b;
                    it = it2;
                    it2 = it;
                    bArrM48089b = bArr;
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m47029a(ThirdReportRsp thirdReportRsp) {
        return thirdReportRsp != null && thirdReportRsp.responseCode == 0;
    }
}
