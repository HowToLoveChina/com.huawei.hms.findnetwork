package p552pd;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupConditionsUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker;
import com.huawei.android.hicloud.cloudbackup.process.util.ThermalChecker;
import com.huawei.android.hicloud.p088ui.uiutil.NewHiSyncUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import p015ak.C0206b0;
import p015ak.C0209d;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p529op.C11979a;
import p581qk.AbstractC12369f;
import p618rm.C12590s0;
import p664u0.C13108a;
import p684un.C13225d;
import p711vl.C13463c;
import p711vl.C13464d;
import p746wn.C13622a;

/* renamed from: pd.b */
/* loaded from: classes3.dex */
public class C12130b extends AbstractC12369f {

    /* renamed from: a */
    public Context f56246a;

    /* renamed from: b */
    public Handler f56247b;

    /* renamed from: c */
    public boolean f56248c;

    /* renamed from: d */
    public boolean f56249d;

    /* renamed from: e */
    public boolean f56250e;

    /* renamed from: f */
    public boolean f56251f;

    /* renamed from: g */
    public boolean f56252g;

    /* renamed from: h */
    public boolean f56253h;

    /* renamed from: i */
    public long f56254i;

    /* renamed from: j */
    public long f56255j;

    /* renamed from: k */
    public String f56256k;

    /* renamed from: l */
    public long f56257l;

    /* renamed from: m */
    public long f56258m;

    /* renamed from: n */
    public boolean f56259n;

    /* renamed from: o */
    public boolean f56260o;

    /* renamed from: p */
    public boolean f56261p;

    /* renamed from: q */
    public boolean f56262q;

    /* renamed from: r */
    public int f56263r;

    /* renamed from: s */
    public boolean f56264s;

    /* renamed from: t */
    public boolean f56265t;

    /* renamed from: u */
    public boolean f56266u;

    /* renamed from: v */
    public ICycleChecker f56267v;

    /* renamed from: w */
    public boolean f56268w;

    public C12130b(Context context, Handler handler, boolean z10, long j10, long j11) {
        super(j10, j11);
        this.f56248c = false;
        this.f56249d = false;
        this.f56250e = false;
        this.f56251f = false;
        this.f56252g = false;
        this.f56254i = 0L;
        this.f56255j = 0L;
        this.f56256k = "";
        this.f56257l = 0L;
        this.f56258m = 0L;
        this.f56259n = false;
        this.f56260o = false;
        this.f56261p = false;
        this.f56262q = false;
        this.f56263r = -1;
        this.f56246a = context;
        this.f56247b = handler;
        this.f56253h = z10;
    }

    /* renamed from: A */
    public void m72710A(boolean z10) {
        this.f56248c = z10;
    }

    /* renamed from: B */
    public void m72711B(boolean z10) {
        this.f56252g = z10;
    }

    /* renamed from: C */
    public void m72712C(long j10) {
        this.f56258m = j10;
    }

    /* renamed from: D */
    public void m72713D(boolean z10) {
        this.f56249d = z10;
    }

    /* renamed from: E */
    public void m72714E() {
        C13463c c13463cM81022c = C13463c.m81022c(this.f56246a);
        if (this.f56252g) {
            C11839m.m70686d("CBObserverTimer", "satisfy the auto backup condition again");
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f56255j = jCurrentTimeMillis;
            c13463cM81022c.m81028g("dissatisfyTime", jCurrentTimeMillis);
            return;
        }
        C11839m.m70686d("CBObserverTimer", "satisfy the auto backup condition");
        this.f56252g = true;
        this.f56254i = System.currentTimeMillis();
        c13463cM81022c.m81027f("isSatisfy", true);
        c13463cM81022c.m81028g("satisfyTime", this.f56254i);
        c13463cM81022c.m81028g("dissatisfyTime", this.f56254i);
    }

    /* renamed from: c */
    public void m72715c() {
        this.f56252g = false;
        this.f56254i = 0L;
        this.f56255j = 0L;
        boolean zM81024b = C13463c.m81022c(this.f56246a).m81024b("isSatisfy");
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strM72728q = m72728q(this.f56248c, this.f56249d, this.f56251f, this.f56250e, false, this.f56268w);
        if (!zM81024b) {
            this.f56257l++;
            return;
        }
        C13464d c13464dM81030f = C13464d.m81030f(this.f56246a);
        String strM81042m = c13464dM81030f.m81042m();
        String strM81043n = c13464dM81030f.m81043n("user_type");
        if (!TextUtils.isEmpty(strM81042m) && !TextUtils.isEmpty(strM81043n)) {
            long jM81025d = C13463c.m81022c(this.f56246a).m81025d("satisfyTime");
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(JsbMapKeyNames.H5_USER_ID, strM81042m);
            linkedHashMap.put("satisfy_time", String.valueOf(jM81025d));
            linkedHashMap.put("dissatisfy_time", String.valueOf(jCurrentTimeMillis));
            linkedHashMap.put("period", String.valueOf(jCurrentTimeMillis - jM81025d));
            linkedHashMap.put("reason", strM72728q);
            linkedHashMap.put("userType", strM81043n);
            linkedHashMap.put("gradeCode", C12590s0.m75747G0());
            linkedHashMap.put("checkType", CloudBackupConditionsUtil.getBackUpCheckType());
            C13225d.m79490f1().m79569S("cloudbackup_auto_condition_cycle", linkedHashMap, this.f56253h);
            UBAAnalyze.m29947H("CKC", "cloudbackup_auto_condition_cycle", linkedHashMap);
        }
        long jM81025d2 = C13463c.m81022c(this.f56246a).m81025d("lastPowerConnectTime");
        C13463c.m81022c(this.f56246a).m81023a();
        C13463c.m81022c(this.f56246a).m81028g("lastPowerConnectTime", jM81025d2);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws NoSuchAlgorithmException {
        C11839m.m70686d("CBObserverTimer", "CBObserverTimer call begin");
        m72733v();
        this.f56259n = C13464d.m81030f(this.f56246a).m81033c("hasDispersed");
        this.f56267v = CloudBackupConditionsUtil.getCycleChecker();
        this.f56265t = false;
        if (this.f56259n) {
            C13464d.m81030f(this.f56246a).m81045p("hasDispersed", false);
        }
        boolean zIsSmartCharging = CloudBackupConditionsUtil.isSmartCharging();
        this.f56266u = zIsSmartCharging;
        if (this.f56248c || zIsSmartCharging) {
            this.f56264s = false;
            this.f56252g = C13463c.m81022c(this.f56246a).m81024b("isSatisfy");
            this.f56260o = this.f56267v.isCycleSatisfy();
            this.f56261p = CloudBackupConditionsUtil.isRetryIntervalSatisfy();
            this.f56262q = CloudBackupConditionsUtil.isNextBackupTimeSatisfy();
            this.f56256k = m72720h();
            boolean zIsCycleSatisfy = this.f56260o;
            long jM81037h = C13464d.m81030f(this.f56246a).m81037h("doBackupTime");
            long jM72729r = 0;
            if (System.currentTimeMillis() - jM81037h < 240000 && jM81037h != 0) {
                this.f56258m = 0L;
                m72730s(1L, 0L, 0L, zIsCycleSatisfy);
                return;
            }
            this.f56268w = "interim".equals(C13464d.m81030f(this.f56246a).m81039j("backupAction", ""));
            boolean z10 = C0206b0.m1131c("backup_key", this.f56246a) || this.f56268w;
            PowerManager powerManager = (PowerManager) this.f56246a.getSystemService("power");
            if (powerManager != null) {
                this.f56249d = powerManager.isInteractive();
            }
            this.f56251f = C0209d.m1254f2(this.f56246a);
            boolean zM72725n = m72725n();
            this.f56250e = zM72725n;
            if (z10 && !this.f56249d && this.f56251f && zM72725n) {
                this.f56257l = 0L;
                long j10 = this.f56258m + 1;
                this.f56258m = j10;
                if (j10 >= 2 || this.f56259n) {
                    zIsCycleSatisfy = this.f56267v.isCycleSatisfy();
                    jM72729r = m72729r(zIsCycleSatisfy);
                    this.f56258m = 0L;
                } else {
                    this.f56264s = true;
                }
                m72714E();
            } else {
                C11839m.m70688i("CBObserverTimer", "dissatisfy  the auto backup condition");
                this.f56258m = 0L;
                this.f56264s = true;
                m72715c();
            }
            long j11 = jM72729r;
            if (this.f56264s) {
                m72730s(this.f56257l, this.f56258m, j11, zIsCycleSatisfy);
            }
        }
        m72726o();
        C11839m.m70686d("CBObserverTimer", "CBObserverTimer call end");
    }

    /* renamed from: d */
    public final long m72716d() {
        return CloudBackupConditionsUtil.checkDelayTime(CloudBackupConditionsUtil.getTargetBackupTime(this.f56267v.isCycleSatisfy(), this.f56267v, CloudBackupConditionsUtil.isRetryIntervalSatisfy(), CloudBackupConditionsUtil.isNextBackupTimeSatisfy()));
    }

    /* renamed from: e */
    public boolean m72717e() {
        return this.f56252g;
    }

    /* renamed from: f */
    public boolean m72718f() {
        return this.f56249d;
    }

    /* renamed from: g */
    public final long m72719g() {
        return C13464d.m81030f(this.f56246a).m81037h(CloudBackupConstant.ReportReason.REPORT_REASON_TIME);
    }

    /* renamed from: h */
    public final String m72720h() {
        return C13464d.m81030f(this.f56246a).m81039j("reason", "");
    }

    /* renamed from: j */
    public long m72721j() {
        return this.f56254i;
    }

    /* renamed from: k */
    public boolean m72722k(boolean z10) {
        boolean zIsRetryIntervalSatisfy = CloudBackupConditionsUtil.isRetryIntervalSatisfy();
        boolean zIsNextBackupTimeSatisfy = CloudBackupConditionsUtil.isNextBackupTimeSatisfy();
        if (z10) {
            return zIsRetryIntervalSatisfy || zIsNextBackupTimeSatisfy;
        }
        return false;
    }

    /* renamed from: l */
    public boolean m72723l() {
        return this.f56268w;
    }

    /* renamed from: m */
    public boolean m72724m() {
        return this.f56250e;
    }

    /* renamed from: n */
    public final boolean m72725n() {
        if (!ThermalChecker.matchThermalControlDevice(true) || ThermalChecker.isBlowOut(true)) {
            return true;
        }
        int iM72105j = C11979a.m72102l().m72105j();
        this.f56263r = iM72105j;
        return ThermalChecker.isThermalControlByDs(iM72105j);
    }

    /* renamed from: o */
    public void m72726o() {
        String strM72728q = m72728q(this.f56248c, this.f56249d, this.f56251f, this.f56250e, false, this.f56268w);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jM72719g = m72719g();
        C11839m.m70686d("CBObserverTimer", "reason: " + this.f56256k + ", currentReason: " + strM72728q + ", currentTime: " + jCurrentTimeMillis + ", lastReportTime: " + jM72719g);
        if (!this.f56256k.equals(strM72728q) || jCurrentTimeMillis - jM72719g > 1800000) {
            this.f56256k = strM72728q;
            m72734y(strM72728q, jCurrentTimeMillis);
            m72727p(this.f56256k);
        }
    }

    /* renamed from: p */
    public void m72727p(String str) {
        C13464d c13464dM81030f = C13464d.m81030f(this.f56246a);
        int iM25633c = NewHiSyncUtil.m25633c(this.f56246a);
        C13464d c13464dM81030f2 = C13464d.m81030f(this.f56246a);
        String strM81042m = c13464dM81030f2.m81042m();
        String strM81043n = c13464dM81030f2.m81043n("user_type");
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02012"), "success", strM81042m);
        c11060cM66626a.m66665u("0");
        if (TextUtils.isEmpty(strM81042m) || TextUtils.isEmpty(strM81043n)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(JsbMapKeyNames.H5_USER_ID, strM81042m);
        linkedHashMap.put("userType", strM81043n);
        linkedHashMap.put("gradeCode", C12590s0.m75747G0());
        linkedHashMap.put("pn", "com.huawei.hidisk\u0001_cloudbackup");
        linkedHashMap.put("reason", str);
        linkedHashMap.put("batteryLevel", String.valueOf(iM25633c));
        linkedHashMap.put("chargePlug", String.valueOf(c13464dM81030f.m81036g("chargePlug", -1)));
        linkedHashMap.put("time", String.valueOf(System.currentTimeMillis()));
        linkedHashMap.put("lastSuccesTime", String.valueOf(c13464dM81030f.m81037h("lastsuccesstime")));
        C11839m.m70688i("CBObserverTimer", "om report condition " + str);
        C13622a.m81971q(c11060cM66626a, linkedHashMap, this.f56253h, true);
    }

    /* renamed from: q */
    public String m72728q(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        StringBuilder sb2 = new StringBuilder("");
        sb2.append(z10 ? "0" : "1");
        sb2.append(!z11 ? "0" : "1");
        sb2.append(z12 ? "0" : "1");
        sb2.append(!z14 ? "0" : "1");
        sb2.append(this.f56260o ? "0" : "1");
        sb2.append((this.f56261p || this.f56262q) ? "0" : "1");
        sb2.append(this.f56266u ? "0" : "1");
        sb2.append(z13 ? "0" : "1");
        sb2.append(z15 ? "0" : "1");
        C11839m.m70686d("CBObserverTimer", "parseReason reason: " + ((Object) sb2));
        return sb2.toString();
    }

    /* renamed from: r */
    public final long m72729r(boolean z10) throws NoSuchAlgorithmException {
        if (!m72722k(z10)) {
            this.f56264s = true;
            return m72716d();
        }
        int iDelayedAutoBackup = CloudBackupConditionsUtil.delayedAutoBackup(C13464d.m81030f(this.f56246a).m81034d(), this.f56259n);
        if (iDelayedAutoBackup <= 0) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3203;
            messageObtain.obj = this.f56267v.getType();
            this.f56247b.sendMessage(messageObtain);
            C11839m.m70688i("CBObserverTimer", "send auto backup msg");
            return 0L;
        }
        C11839m.m70688i("CBObserverTimer", "CBTimer backup to be delayed in:" + iDelayedAutoBackup);
        C13464d.m81030f(this.f56246a).m81045p("hasDispersed", true);
        this.f56265t = true;
        this.f56264s = true;
        return iDelayedAutoBackup * 1000;
    }

    @Override // p581qk.AbstractC12369f, p616rk.AbstractRunnableC12516b
    public void release() {
        super.release();
        C11979a.m72102l().m72111q(1);
    }

    /* renamed from: s */
    public final void m72730s(long j10, long j11, long j12, boolean z10) {
        long j13 = j10;
        C13464d c13464dM81030f = C13464d.m81030f(this.f56246a);
        long jM81037h = c13464dM81030f.m81037h("checkInterval");
        long jM81037h2 = c13464dM81030f.m81037h("checkIntervalMax");
        C11839m.m70688i("CBObserverTimer", "get adjustVal: " + j13 + ", checkInterval: " + jM81037h + ", checkIntervalMax = " + jM81037h2 + ", delayTime = " + j12);
        if (j13 == 0) {
            j13 = 1;
        }
        long j14 = jM81037h * j13;
        if (getPeriod() == 60 * j14 && j12 <= 0) {
            C11839m.m70688i("CBObserverTimer", "checkInterval is same,and delay time is 0, no need to reinit timer");
            return;
        }
        if (j14 > jM81037h2) {
            C11839m.m70688i("CBObserverTimer", "set checkInterval to checkIntervalMax");
        } else {
            jM81037h2 = j14;
        }
        if (jM81037h2 <= 0) {
            C11839m.m70688i("CBObserverTimer", "set checkInterval to two minutes");
            jM81037h2 = 2;
        }
        Intent intent = new Intent("com.huawei.hicloud.intent.action.CB_OBSERVER_TIMER_REGISTER");
        intent.putExtra("checkInterval", jM81037h2);
        intent.putExtra("cycle_check_type", this.f56267v.getType() + z10);
        intent.putExtra("delayedstarttime", j12);
        intent.putExtra("satisfyNum", j11);
        intent.putExtra("isdispersed", this.f56265t);
        C13108a.m78878b(this.f56246a).m78881d(intent);
    }

    /* renamed from: t */
    public void m72731t() {
        Handler handler = this.f56247b;
        if (handler == null || !handler.hasMessages(3203)) {
            return;
        }
        this.f56247b.removeMessages(3203);
    }

    /* renamed from: u */
    public void m72732u(long j10, long j11, String str) {
        C13464d c13464dM81030f = C13464d.m81030f(this.f56246a);
        String strM81042m = c13464dM81030f.m81042m();
        String strM81043n = c13464dM81030f.m81043n("user_type");
        if (!TextUtils.isEmpty(strM81043n)) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(JsbMapKeyNames.H5_USER_ID, strM81042m);
            linkedHashMap.put("satisfy_time", String.valueOf(j10));
            linkedHashMap.put("dissatisfy_time", String.valueOf(j11));
            linkedHashMap.put("period", String.valueOf(j11 - j10));
            linkedHashMap.put("reason", str);
            linkedHashMap.put("userType", strM81043n);
            linkedHashMap.put("gradeCode", C12590s0.m75747G0());
            linkedHashMap.put("checkType", CloudBackupConditionsUtil.getBackUpCheckType());
            C11839m.m70688i("CBObserverTimer", "report auto condition cycle");
            C13225d.m79490f1().m79569S("cloudbackup_auto_condition_cycle", linkedHashMap, this.f56253h);
            UBAAnalyze.m29947H("CKC", "cloudbackup_auto_condition_cycle", linkedHashMap);
        }
        C13463c.m81022c(this.f56246a).m81023a();
    }

    /* renamed from: v */
    public final void m72733v() {
        C13463c c13463cM81022c = C13463c.m81022c(this.f56246a);
        boolean zM81024b = c13463cM81022c.m81024b("isSatisfy");
        if (this.f56252g) {
            if (zM81024b) {
                return;
            }
            String strM72728q = m72728q(true, false, true, this.f56250e, true, this.f56268w);
            this.f56256k = strM72728q;
            m72727p(strM72728q);
            return;
        }
        if (zM81024b) {
            C11839m.m70686d("CBObserverTimer", "report exception exit condition");
            long jM81025d = c13463cM81022c.m81025d("satisfyTime");
            long jM81025d2 = c13463cM81022c.m81025d("dissatisfyTime");
            String strM72728q2 = m72728q(true, false, true, this.f56250e, true, this.f56268w);
            this.f56256k = strM72728q2;
            if (jM81025d2 - jM81025d >= 120000) {
                m72732u(jM81025d, jM81025d2, strM72728q2);
            } else {
                c13463cM81022c.m81023a();
            }
            m72727p(this.f56256k);
        }
    }

    /* renamed from: y */
    public final void m72734y(String str, long j10) {
        C13464d c13464dM81030f = C13464d.m81030f(this.f56246a);
        c13464dM81030f.m81049t("reason", str);
        c13464dM81030f.m81048s(CloudBackupConstant.ReportReason.REPORT_REASON_TIME, j10);
    }

    /* renamed from: z */
    public void m72735z(long j10) {
        this.f56257l = j10;
    }
}
