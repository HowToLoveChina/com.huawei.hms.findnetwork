package p841ze;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import bf.AbstractC1177c;
import bf.C1175a;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import eg.AbstractC9478g;
import fk.C9721b;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0219i;
import p015ak.C0224k0;
import p015ak.C0241z;
import p366if.AbstractC10482g;
import p366if.C10481f;
import p521og.C11877j;
import p616rk.C12515a;
import p774xg.C13811a;
import p809yg.C13981a;
import pg.AbstractC12139d;

/* renamed from: ze.b */
/* loaded from: classes4.dex */
public class C14288b extends AbstractC1177c implements InterfaceC14290d {

    /* renamed from: p */
    public static final Object f63514p = new Object();

    /* renamed from: q */
    public static boolean f63515q = true;

    /* renamed from: l */
    public String f63516l;

    /* renamed from: m */
    public long f63517m;

    /* renamed from: n */
    public CountDownLatch f63518n;

    /* renamed from: o */
    public CountDownLatch f63519o;

    /* renamed from: ze.b$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException, C9721b {
            try {
                if (C14288b.this.f63518n != null) {
                    C13981a.m83987d("Clear", "clearLocateDownLatch:" + C14288b.this.f63518n.await(C14288b.this.f63517m, TimeUnit.MILLISECONDS));
                }
            } catch (InterruptedException unused) {
                C13981a.m83988e("Clear", "startClearDelay InterruptedException");
            }
            if (C14288b.this.m85128n0()) {
                C13981a.m83989i("Clear", "cancel clear");
            } else {
                C14288b.this.m85130q0();
            }
        }
    }

    /* renamed from: ze.b$b */
    public class b implements Handler.Callback {

        /* renamed from: a */
        public int f63521a;

        /* renamed from: b */
        public int f63522b;

        /* renamed from: c */
        public int f63523c = 0;

        public b(int i10, int i11) {
            this.f63521a = i11;
            this.f63522b = i10;
            C13981a.m83989i("Clear", "HttpCallback param:" + this.f63521a);
        }

        /* renamed from: a */
        public final void m85135a(Message message) throws JSONException {
            int iM1685c = C0241z.m1685c(message.getData().getString("result"));
            this.f63523c = iM1685c;
            if (200 != iM1685c) {
                C14292f.m85147d().m26439b(C14288b.this.f5580a);
                C13981a.m83989i("Clear", "handleClearDataReportResult->report error:result=" + this.f63523c);
                C14288b.this.m7427Q("Clear", "001_3003", -1, "phoneFinder handleClearDataReportResult fail,result:" + this.f63523c, null, C14288b.this.f5581b.getOperation(), "pushClear", true, null);
                return;
            }
            int iM7438x = C14288b.this.m7438x(message.getData().getString("response_info"));
            C13981a.m83989i("Clear", "handleClearDataReportResult->resultCode =" + iM7438x);
            if (iM7438x != 0) {
                C14288b.this.m7427Q("Clear", "001_3004", iM7438x, "phoneFinder handleClearDataReportResult fail,resultCode:" + iM7438x, null, C14288b.this.f5581b.getOperation(), "pushClear", true, null);
                return;
            }
            if (C14288b.m85120t0()) {
                C14288b.m85122z0(C14288b.this.f5580a, 0);
            } else {
                C14288b.this.m85125C0();
            }
            C11877j.m71231R0(C14288b.this.f5580a, true);
            C13981a.m83989i("Clear", "handleClearDataReportResult clear data success,AppEventLogParam report success");
            C14288b c14288b = C14288b.this;
            c14288b.m7427Q("Clear", "0", -1, "handleClearDataReportResult clear data success", null, c14288b.f5581b.getOperation(), "pushClear", true, null);
        }

        /* renamed from: b */
        public final void m85136b(Message message) {
            if (C14288b.this.f63519o != null) {
                C14288b.this.f63519o.countDown();
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws JSONException {
            int i10 = this.f63522b;
            if (3021 == i10) {
                m85135a(message);
                return true;
            }
            if (3103 != i10) {
                return true;
            }
            m85136b(message);
            return true;
        }
    }

    /* renamed from: ze.b$c */
    public interface c {
        /* renamed from: a */
        void mo85099a(boolean z10);
    }

    public C14288b(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
        this.f63517m = 0L;
        this.f63516l = "";
    }

    /* renamed from: m0 */
    public static String m85116m0(Context context) throws JSONException {
        String strM71218L = C11877j.m71218L(context);
        if (TextUtils.isEmpty(strM71218L)) {
            strM71218L = AbstractC12139d.m72766e(context).getClearCmdData();
        }
        if (!TextUtils.isEmpty(strM71218L)) {
            try {
                JSONObject jSONObject = new JSONObject(strM71218L);
                if (!jSONObject.has(HwPayConstant.KEY_SIGN)) {
                    jSONObject.put(HwPayConstant.KEY_SIGN, "");
                }
                return jSONObject.toString();
            } catch (JSONException e10) {
                C13981a.m83988e("Clear", "getDataToSave error:" + e10.getMessage());
            }
        }
        return "";
    }

    /* renamed from: p0 */
    public static void m85117p0(Context context) {
        int iM85118r0 = m85118r0(context);
        C13981a.m83989i("Clear", "checkClearState:status = " + iM85118r0);
        if (2 == iM85118r0 || 5 == iM85118r0) {
            m85122z0(context, 0);
            return;
        }
        if (iM85118r0 == 0) {
            return;
        }
        Intent intent = new Intent();
        String strM71218L = C11877j.m71218L(context);
        if (TextUtils.isEmpty(strM71218L)) {
            C13981a.m83988e("Clear", "checkClearState error empty amdData");
        } else {
            intent.putExtra("msg_data", strM71218L);
        }
        C14288b c14288b = new C14288b(new PushCmdParser(intent, context), context);
        if (1 == iM85118r0 || 3 == iM85118r0) {
            c14288b.m85129o0(3);
        } else if (4 == iM85118r0) {
            c14288b.m85129o0(4);
        }
    }

    /* renamed from: r0 */
    public static int m85118r0(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        Settings.Secure.getInt(contentResolver, "hw_suw_frp_state", 0);
        return Settings.Secure.getInt(contentResolver, "phonefinder.clearstate", 0);
    }

    /* renamed from: s0 */
    public static String m85119s0(PushCmdParser pushCmdParser) {
        try {
            JSONObject jSONObject = new JSONObject(pushCmdParser.getPushCmd());
            if (jSONObject.has(HwPayConstant.KEY_SIGN)) {
                jSONObject.remove(HwPayConstant.KEY_SIGN);
            }
            if (jSONObject.has(RemoteMessageConst.MessageBody.PARAM)) {
                jSONObject.remove(RemoteMessageConst.MessageBody.PARAM);
            }
            return jSONObject.toString();
        } catch (JSONException e10) {
            C13981a.m83988e("Clear", "getDataToSave error:" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: t0 */
    public static boolean m85120t0() {
        return C0219i.m1463a() >= 17;
    }

    /* renamed from: x0 */
    public static void m85121x0(Context context) {
        if (m85120t0()) {
            if (5 == m85118r0(context)) {
                m85122z0(context, 0);
            }
            if (C1175a.m7389k(context)) {
                if (C0209d.m1206R1(context)) {
                    C13981a.m83989i("Clear", "isStartupGuideFinishedNormally");
                    return;
                }
                if (m85118r0(context) == 0) {
                    C13981a.m83989i("Clear", "reportClearSuccess in nit CLEAR_STATE_NONE");
                    String strM85116m0 = m85116m0(context);
                    if (TextUtils.isEmpty(strM85116m0)) {
                        C13981a.m83988e("Clear", "reportClearSuccess error: get cmdData failued");
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("msg_data", strM85116m0);
                    new C14288b(new PushCmdParser(intent, context), context).m85133w0();
                }
            }
        }
    }

    /* renamed from: z0 */
    public static void m85122z0(Context context, int i10) {
        Settings.Secure.putInt(context.getContentResolver(), "phonefinder.clearstate", i10);
    }

    /* renamed from: A0 */
    public final void m85123A0() {
        C13981a.m83989i("Clear", "startClearDelay");
        C12515a.m75110o().m75175e(new a(), false);
    }

    /* renamed from: B0 */
    public void m85124B0() throws JSONException {
        Intent intent = new Intent();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", "locate");
            jSONObject.put("x-hw-trace-id", this.f5581b.getTraceID());
            intent.putExtra("msg_data", jSONObject.toString());
        } catch (JSONException unused) {
            C13981a.m83988e("Clear", "startClearLocateReport JSONException:");
        }
        C13981a.m83989i("Clear", "clear locate start...");
        Context context = this.f5580a;
        AbstractC10482g abstractC10482gM64431g = C10481f.m64431g(context, new PushCmdParser(intent, context), true, "clear_locate");
        abstractC10482gM64431g.m64454F0("[ClearLocate]");
        abstractC10482gM64431g.m64452D0(this);
        m85122z0(this.f5580a, 1);
        abstractC10482gM64431g.mo7440z();
    }

    @SuppressLint({"ObsoleteSdkInt"})
    /* renamed from: C0 */
    public final void m85125C0() {
        Intent intent = new Intent("com.huawei.remotecontrol.WRITEFRPINFO");
        intent.putExtra("message", this.f63516l);
        if (m85120t0()) {
            String strM85119s0 = m85119s0(this.f5581b);
            if (!TextUtils.isEmpty(strM85119s0)) {
                intent.putExtra("cmd", strM85119s0);
            }
        }
        this.f5580a.sendBroadcast(intent, "com.huawei.remotocontrol.permission.REMOTECALL");
        synchronized (f63514p) {
            try {
                if (f63515q) {
                    C13981a.m83989i("Clear", "come into ClearMThread");
                    f63515q = false;
                    new C14291e(this.f5580a, new c() { // from class: ze.a
                        @Override // p841ze.C14288b.c
                        /* renamed from: a */
                        public final void mo85099a(boolean z10) throws InterruptedException {
                            this.f63513a.m85131u0(z10);
                        }
                    }).start();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: D0 */
    public final void m85126D0(int i10) {
        if (i10 == 3) {
            m85125C0();
            m85122z0(this.f5580a, 3);
        } else {
            if (i10 != 4) {
                return;
            }
            m85122z0(this.f5580a, 4);
            new C14291e(this.f5580a, null).m85146c();
        }
    }

    @Override // bf.AbstractC1177c
    /* renamed from: J */
    public boolean mo7422J() {
        JSONObject jSONObjectM7436u = m7436u(RemoteMessageConst.MessageBody.PARAM);
        if (jSONObjectM7436u == null) {
            C13981a.m83988e("Clear", "parseControlCmd error:param is null");
            return false;
        }
        try {
            if (jSONObjectM7436u.has("isCrypt")) {
                this.f5585f = C0241z.m1686d(jSONObjectM7436u.getString("isCrypt"), 0);
            }
            if (jSONObjectM7436u.has("message")) {
                this.f63516l = m7429m(jSONObjectM7436u.getString("message"), this.f5585f);
            }
            if (!jSONObjectM7436u.has(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME)) {
                return true;
            }
            this.f63517m = jSONObjectM7436u.getLong(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME);
            return true;
        } catch (JSONException unused) {
            C13981a.m83988e("Clear", "parseControlCmd get wait time JSONException");
            return true;
        }
    }

    @Override // p841ze.InterfaceC14290d
    /* renamed from: a */
    public void mo85127a() {
        C13981a.m83989i("Clear", "onClearLocateSuc");
        CountDownLatch countDownLatch = this.f63518n;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* renamed from: n0 */
    public boolean m85128n0() {
        if (2 != m85118r0(this.f5580a)) {
            return false;
        }
        m85122z0(this.f5580a, 0);
        return true;
    }

    /* renamed from: o0 */
    public final void m85129o0(int i10) {
        if (m85120t0()) {
            m85126D0(i10);
        } else {
            m85133w0();
        }
    }

    /* renamed from: q0 */
    public final void m85130q0() {
        m85122z0(this.f5580a, 3);
        if (m85120t0()) {
            C13981a.m83989i("Clear", "start clear");
            m85126D0(3);
        } else {
            C13981a.m83989i("Clear", "report result first");
            m85133w0();
        }
    }

    /* renamed from: u0 */
    public final void m85131u0(boolean z10) throws InterruptedException {
        String str;
        C13981a.m83989i("Clear", "onClearDataCb:isSuccess=" + z10);
        if (m85120t0()) {
            m85122z0(this.f5580a, 4);
            if (z10) {
                this.f5582c = 200;
                str = "0";
            } else {
                this.f5582c = 201;
                str = "001_3004";
            }
            String str2 = str;
            m7417D(null);
            m7427Q("Clear", str2, this.f5582c, "phonefinder onClearDataCb, resultCode:" + this.f5582c, null, this.f5581b.getOperation(), "pushClear", true, null);
            this.f5582c = 0;
            m7417D(new b(3103, 0));
            m7427Q("Clear", "0", -1, "start clear data", null, this.f5581b.getOperation(), "pushClear", false, null);
            try {
                CountDownLatch countDownLatch = this.f63519o;
                if (countDownLatch != null) {
                    C13981a.m83987d("Clear", "clearReportDownLatch:" + countDownLatch.await(5000L, TimeUnit.MILLISECONDS));
                }
            } catch (InterruptedException unused) {
                C13981a.m83988e("Clear", "reportClearResult InterruptedException");
            }
        }
    }

    /* renamed from: v0 */
    public void m85132v0() {
        C13981a.m83989i("Clear", "reportClearFail");
        this.f5582c = 9;
        m7417D(null);
        m7427Q("Clear", "001_1005", -1, "clear fail", null, this.f5581b.getOperation(), "pushClear", false, null);
    }

    /* renamed from: w0 */
    public void m85133w0() {
        this.f5582c = 0;
        m7417D(new b(3021, 0));
        C13981a.m83989i("Clear", "handleControlCmd clear data success,AppEventLogParam report success");
        m7427Q("Clear", "0", -1, "clear data success", null, this.f5581b.getOperation(), "pushClear", false, null);
    }

    /* renamed from: y0 */
    public final void m85134y0() {
        C11877j.m71229Q0(this.f5580a, m85119s0(this.f5581b));
    }

    @Override // bf.AbstractC1177c
    /* renamed from: z */
    public void mo7440z() throws JSONException {
        C13811a.m82805b(true, "clear_locate");
        if (C0224k0.m1571z(this.f5580a)) {
            this.f5582c = 203;
            m7417D(null);
            m7427Q("Clear", "001_1005", -1, "the device do not support factory reset", null, this.f5581b.getOperation(), "pushClear", false, null);
            return;
        }
        if (!mo7422J()) {
            this.f5582c = 9;
            m7417D(null);
            m7427Q("Clear", "001_1005", -1, "clear data parseControlCmd fail", null, this.f5581b.getOperation(), "pushClear", false, null);
            return;
        }
        m85134y0();
        long j10 = this.f63517m;
        if (j10 > 0) {
            this.f63517m = Math.min(j10, 5000L);
        } else {
            this.f63517m = 5000L;
        }
        C13981a.m83989i("Clear", "mLocateWaitTime=" + this.f63517m);
        this.f63518n = new CountDownLatch(1);
        this.f63519o = new CountDownLatch(1);
        m85124B0();
        m85123A0();
    }
}
