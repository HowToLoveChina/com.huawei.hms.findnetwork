package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.Utils;
import com.huawei.hms.network.NetworkKit;
import com.huawei.hms.network.api.advance.BandwidthCallBack;
import com.huawei.hms.network.httpclient.Callback;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.embedded.l1 */
/* loaded from: classes8.dex */
public final class C5991l1 {
    public static final int MAX_SIZE_FOR_RECEIVED_BANDWIDTH = 32;

    /* renamed from: h */
    public static final String f27341h = "NetworkBandwidthManager";

    /* renamed from: i */
    public static volatile C5991l1 f27342i = null;

    /* renamed from: j */
    public static final long f27343j = 1000;

    /* renamed from: k */
    public static final String f27344k = "GET";

    /* renamed from: d */
    public String f27348d;

    /* renamed from: f */
    public HttpClient f27350f;

    /* renamed from: a */
    public List<BandwidthCallBack> f27345a = new CopyOnWriteArrayList();

    /* renamed from: b */
    public final List<C5978k1> f27346b = new CopyOnWriteArrayList();

    /* renamed from: c */
    public final ExecutorService f27347c = ExecutorsUtils.newSingleThreadExecutor("NK-BW");

    /* renamed from: e */
    public int f27349e = 0;

    /* renamed from: g */
    public String f27351g = "";

    /* renamed from: com.huawei.hms.network.embedded.l1$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f27352a;

        /* renamed from: b */
        public final /* synthetic */ String f27353b;

        public a(String str, String str2) {
            this.f27352a = str;
            this.f27353b = str2;
        }

        @Override // java.lang.Runnable
        public void run() throws NumberFormatException {
            long j10;
            C5888d3 c5888d3 = new C5888d3(this.f27352a);
            try {
                j10 = Long.parseLong(this.f27353b);
            } catch (NumberFormatException unused) {
                Logger.m32145w(C5991l1.f27341h, "the realBandwidth has error,abandon it this time");
                j10 = 0;
            }
            if (j10 <= 0) {
                Logger.m32143v(C5991l1.f27341h, "the realBandwidth <= 0, return it");
                return;
            }
            C5978k1 c5978k1 = new C5978k1(Utils.getCurrentTime(true), c5888d3.getHost(), j10);
            C5991l1.this.m34641a(c5978k1);
            C5978k1 c5978k1M34643b = C5991l1.this.m34643b();
            Logger.m32143v(C5991l1.f27341h, "the bandwidthInfo will callback, bandwidthInfo = " + c5978k1);
            for (BandwidthCallBack bandwidthCallBack : C5991l1.this.f27345a) {
                if (bandwidthCallBack != null) {
                    bandwidthCallBack.onBandwidth(c5978k1M34643b.getCurrentHost(), c5978k1M34643b.getEstimatedBandwidthBps());
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.l1$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C5991l1.this.clearBandwidthInfo();
            if (NetworkUtil.getCurrentNetworkType() != -1 && NetworkUtil.getCurrentNetworkType() != 0) {
                C5991l1.this.m34647d();
                return;
            }
            Logger.m32141i(C5991l1.f27341h, "this time the networkType = " + NetworkUtil.getCurrentNetworkType());
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.l1$c */
    public class c extends Callback<ResponseBody> {
        public c() {
        }

        @Override // com.huawei.hms.network.httpclient.Callback
        public void onFailure(Submit<ResponseBody> submit, Throwable th2) {
            Logger.m32145w(C5991l1.f27341h, "request fail for bandwidth this time! ");
        }

        @Override // com.huawei.hms.network.httpclient.Callback
        public void onResponse(Submit<ResponseBody> submit, Response<ResponseBody> response) throws IOException {
            if (response.isSuccessful()) {
                response.getBody().bytes();
                response.close();
            }
            Logger.m32141i(C5991l1.f27341h, "the request has finished ,and responseCode = " + response.getCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public C5978k1 m34643b() {
        C5978k1 c5978k1 = new C5978k1();
        for (int i10 = 0; i10 < this.f27346b.size(); i10++) {
            if (c5978k1.getEstimatedBandwidthBps() <= this.f27346b.get(i10).getEstimatedBandwidthBps()) {
                c5978k1 = this.f27346b.get(i10);
            }
        }
        Logger.m32143v(f27341h, "the bandwidthInfoList is: " + this.f27346b.toString());
        return c5978k1;
    }

    /* renamed from: c */
    private String m34645c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("quic_enable_bandwidth", true);
            if (!TextUtils.isEmpty(this.f27351g)) {
                jSONObject.put(C6018n2.CONGESTION_CONTROL_TYPE, this.f27351g);
            }
        } catch (JSONException unused) {
            Logger.m32145w(f27341h, "the networkBandwidth option quic_enable_bandwidth or congestion_control_type has error!");
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m34647d() {
        if (TextUtils.isEmpty(this.f27348d)) {
            Logger.m32143v(f27341h, "probeURL == null,return it");
        } else if (TextUtils.isEmpty(this.f27351g)) {
            Logger.m32141i(f27341h, "the CronetEngine has not created , don't request this time!");
        } else {
            this.f27350f.newSubmit(m34640a().newRequest().url(this.f27348d).method("GET").build()).enqueue(new c());
        }
    }

    public static C5991l1 getInstance() {
        if (f27342i == null) {
            synchronized (C5991l1.class) {
                try {
                    if (f27342i == null) {
                        f27342i = new C5991l1();
                    }
                } finally {
                }
            }
        }
        return f27342i;
    }

    public void clearBandwidthInfo() {
        this.f27346b.clear();
        C5978k1 c5978k1 = new C5978k1();
        for (BandwidthCallBack bandwidthCallBack : this.f27345a) {
            if (bandwidthCallBack != null) {
                bandwidthCallBack.onBandwidth(c5978k1.getCurrentHost(), c5978k1.getEstimatedBandwidthBps());
            }
        }
    }

    public void init(String str, int i10) {
        this.f27348d = str;
        this.f27349e = i10;
        NetworkKit.getInstance().addQuicHint(true, str);
        C5927g2.getInstance().maybeExtraBandwidthEvaluation();
        C5994l4.m34650b().m34652a(new C6004m1(this));
    }

    public void onBandwidthMessageReceived(String str, String str2) {
        this.f27347c.submit(new a(str2, str));
    }

    public void processNetworkReceiveMsg() {
        this.f27347c.submit(new b());
    }

    public void recordCongestionTypeInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f27351g = str;
        Logger.m32143v(f27341h, "the CronetEngine can use for bandwidth after, and congestionType = " + str);
    }

    public void registerBandwidthCallback(BandwidthCallBack bandwidthCallBack) {
        this.f27345a.add(bandwidthCallBack);
    }

    /* renamed from: a */
    private synchronized HttpClient m34640a() {
        try {
            if (this.f27350f == null) {
                this.f27350f = new HttpClient.Builder().retryTimeOnConnectionFailure(0).options(m34645c()).enableQuic(true).build();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f27350f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m34641a(C5978k1 c5978k1) {
        long receivedTime = c5978k1.getReceivedTime() - (this.f27349e * 1000);
        if (this.f27346b.size() == 32) {
            this.f27346b.remove(0);
        }
        this.f27346b.add(c5978k1);
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < this.f27346b.size() && this.f27346b.get(i10).getReceivedTime() < receivedTime; i10++) {
            hashSet.add(this.f27346b.get(i10));
        }
        Logger.m32143v(f27341h, "the bandwidthInfoList will remove : " + hashSet.toString());
        this.f27346b.removeAll(hashSet);
    }
}
