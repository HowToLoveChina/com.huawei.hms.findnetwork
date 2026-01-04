package p446l7;

import android.text.TextUtils;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.HicloudPushGuideManager;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.agreement.request.SignPushGuideRsp;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import fk.C9721b;
import gp.C10028c;
import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;
import p015ak.C0234s;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import p846zj.C14306d;
import p861do.C9281a;

/* renamed from: l7.f */
/* loaded from: classes2.dex */
public class C11258f extends AbstractC12367d {

    /* renamed from: j */
    public static final Object f52858j = new Object();

    /* renamed from: a */
    public boolean f52859a;

    /* renamed from: b */
    public String f52860b;

    /* renamed from: c */
    public String f52861c;

    /* renamed from: d */
    public C11060c f52862d;

    /* renamed from: e */
    public String f52863e;

    /* renamed from: f */
    public String f52864f;

    /* renamed from: g */
    public boolean f52865g;

    /* renamed from: h */
    public long f52866h;

    /* renamed from: i */
    public Timer f52867i;

    /* renamed from: l7.f$a */
    public static class a extends TimerTask {

        /* renamed from: a */
        public Timer f52868a;

        /* renamed from: b */
        public C11258f f52869b;

        public a(Timer timer, C11258f c11258f) {
            this.f52869b = c11258f;
            this.f52868a = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Timer timer;
            if (this.f52869b == null) {
                C11839m.m70687e("SignPushGuideTask", "push guide sign,signPushGuideTask is null");
                return;
            }
            C9281a c9281a = new C9281a();
            try {
                try {
                    String strM70533N = C11829c.m70533N();
                    String strM1635m = C0234s.m1635m();
                    C11258f c11258f = this.f52869b;
                    SignPushGuideRsp signPushGuideRspM58355j = c9281a.m58355j(strM70533N, strM1635m, c11258f.f52859a, c11258f.f52860b);
                    C11839m.m70688i("SignPushGuideTask", "push guide sign result code = " + signPushGuideRspM58355j.getErrorCode());
                    if (signPushGuideRspM58355j.getErrorCode() == 0) {
                        C10028c.m62182c0().m62300Z1(false);
                    }
                    LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
                    linkedHashMapM79497A.put("push_guide_type", "push_guide_sign");
                    linkedHashMapM79497A.put("sign_from", this.f52869b.f52863e);
                    linkedHashMapM79497A.put("show_push_guide_dialog_scene", this.f52869b.f52864f);
                    linkedHashMapM79497A.put("sign_push_guide_status", "success");
                    C11258f.m67594c(this.f52869b, linkedHashMapM79497A);
                    linkedHashMapM79497A.put(TrackConstants$Opers.RESPONSE, signPushGuideRspM58355j.toString());
                    C13622a.m81970p(this.f52869b.f52862d, linkedHashMapM79497A, false);
                    C13230i.m79504I().m79567R("07031", linkedHashMapM79497A);
                    UBAAnalyze.m29947H("CKC", "07031", linkedHashMapM79497A);
                    timer = this.f52868a;
                    if (timer == null) {
                        return;
                    }
                } catch (C9721b e10) {
                    C11839m.m70687e("SignPushGuideTask", "SignPushGuideTask failed, " + e10.getMessage());
                    LinkedHashMap<String, String> linkedHashMapM79497A2 = C13230i.m79497A(C13452e.m80781L().m80971t0());
                    linkedHashMapM79497A2.put("push_guide_type", "push_guide_sign");
                    linkedHashMapM79497A2.put("sign_from", this.f52869b.f52863e);
                    linkedHashMapM79497A2.put("sign_push_guide_status", NotifyConstants.CommonReportConstants.FAILED);
                    linkedHashMapM79497A2.put("fail_reason", e10.toString());
                    C13622a.m81970p(this.f52869b.f52862d, linkedHashMapM79497A2, false);
                    C10028c.m62182c0().m62300Z1(true);
                    C10028c.m62182c0().m62292X1(this.f52869b.f52864f);
                    timer = this.f52868a;
                    if (timer == null) {
                        return;
                    }
                }
                timer.cancel();
                this.f52868a = null;
            } catch (Throwable th2) {
                Timer timer2 = this.f52868a;
                if (timer2 != null) {
                    timer2.cancel();
                    this.f52868a = null;
                }
                throw th2;
            }
        }
    }

    public C11258f(boolean z10, String str, String str2, boolean z11, long j10) {
        this(z10, str, str2);
        this.f52865g = z11;
        this.f52866h = j10;
    }

    /* renamed from: c */
    public static void m67594c(C11258f c11258f, LinkedHashMap<String, String> linkedHashMap) {
        String str = c11258f.f52860b;
        if (str != null) {
            char[] charArray = str.toCharArray();
            HicloudPushGuideManager.getInstance();
            linkedHashMap.put("push_guide_switch_status", HicloudPushGuideManager.checkSubConsentStatus(charArray) ? JsbMapKeyNames.H5_TEXT_DOWNLOAD_OPEN : "close");
            HicloudPushGuideManager.getInstance();
            String str2 = HicloudPushGuideManager.checkSingleSubConsentStatus(charArray, 0) ? JsbMapKeyNames.H5_TEXT_DOWNLOAD_OPEN : "close";
            HicloudPushGuideManager.getInstance();
            String str3 = HicloudPushGuideManager.checkSingleSubConsentStatus(charArray, 1) ? JsbMapKeyNames.H5_TEXT_DOWNLOAD_OPEN : "close";
            HicloudPushGuideManager.getInstance();
            String str4 = HicloudPushGuideManager.checkSingleSubConsentStatus(charArray, 2) ? JsbMapKeyNames.H5_TEXT_DOWNLOAD_OPEN : "close";
            HicloudPushGuideManager.getInstance();
            String str5 = HicloudPushGuideManager.checkSingleSubConsentStatus(charArray, 3) ? JsbMapKeyNames.H5_TEXT_DOWNLOAD_OPEN : "close";
            linkedHashMap.put("push_notification", str2);
            linkedHashMap.put("email", str3);
            linkedHashMap.put("instant_message", str4);
            linkedHashMap.put(NavigationUtils.SMS_SCHEMA_PREF, str5);
        }
    }

    /* renamed from: d */
    private int m67595d() {
        String strM80910f = C13452e.m80781L().m80910f();
        if (strM80910f != null && (strM80910f.equals(String.valueOf(1)) || strM80910f.equals(String.valueOf(2)))) {
            return 1;
        }
        C11839m.m70688i("SignPushGuideTask", "childAccountModeFromLogin can not get result");
        return C14306d.m85215p();
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        synchronized (f52858j) {
            try {
                int iM67595d = m67595d();
                if (iM67595d == -1) {
                    C11839m.m70687e("SignPushGuideTask", "queryIsChildAccount error");
                    LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
                    linkedHashMapM79497A.put("push_guide_type", "push_guide_sign");
                    linkedHashMapM79497A.put("sign_from", this.f52863e);
                    linkedHashMapM79497A.put("sign_push_guide_status", NotifyConstants.CommonReportConstants.FAILED);
                    linkedHashMapM79497A.put("fail_reason", "queryIsChildAccount error");
                    C13622a.m81970p(this.f52862d, linkedHashMapM79497A, false);
                }
                if (iM67595d == 1) {
                    C11839m.m70688i("SignPushGuideTask", "is Child Account, can not show push guide");
                } else {
                    Timer timer = this.f52867i;
                    if (timer != null) {
                        timer.cancel();
                    }
                    this.f52867i = new Timer("pushguide");
                    a aVar = new a(this.f52867i, this);
                    if (this.f52865g) {
                        this.f52867i.schedule(aVar, this.f52866h);
                    } else {
                        this.f52867i.schedule(aVar, 0L);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return false;
    }

    public C11258f(boolean z10, String str, String str2) {
        String str3;
        this.f52861c = null;
        this.f52862d = null;
        this.f52863e = "";
        this.f52865g = false;
        this.f52866h = 0L;
        this.f52859a = z10;
        this.f52860b = str;
        this.f52864f = str2;
        if (TextUtils.isEmpty(str2)) {
            str3 = "sign_from_push_notice";
        } else {
            str3 = "sign_from_dialog";
        }
        this.f52863e = str3;
        String strM66627b = C11058a.m66627b("07031");
        this.f52861c = strM66627b;
        C11060c c11060cM66626a = C11058a.m66626a(strM66627b, "cs.user.client.sign", C13452e.m80781L().m80971t0());
        this.f52862d = c11060cM66626a;
        c11060cM66626a.m66665u("0");
    }
}
