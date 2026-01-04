package p341hj;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.DlAppCampInfo;
import com.huawei.cloud.pay.model.GetActivityEntryResp;
import com.huawei.cloud.pay.model.UserTags;
import com.huawei.hicloud.bean.GetCampaignActivityEntryResp;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.util.CampaignCheckUtil;
import fj.C9718g;
import java.util.Iterator;
import java.util.List;
import je.C10779b0;
import jp.C10906b;
import jp.C10907c;
import kp.C11128d;
import p015ak.C0209d;
import p015ak.C0213f;
import p315gj.C9948a;
import p329h7.C10121i;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p709vj.C13452e;
import p778xk.C13823d;

/* renamed from: hj.p0 */
/* loaded from: classes5.dex */
public class C10256p0 extends AbstractC12367d {

    /* renamed from: a */
    public String f49685a;

    /* renamed from: b */
    public Handler f49686b;

    /* renamed from: c */
    public String f49687c;

    /* renamed from: d */
    public List<PortraitAndGrade.UserTag> f49688d;

    public C10256p0(String str, Handler handler) {
        this.f49685a = str;
        this.f49686b = handler;
        C11839m.m70688i("HicloudLinkTextCheckTask", "HicloudLinkTextCheckTask entrance = " + str);
    }

    /* renamed from: c */
    public final boolean m63416c(C10906b c10906b) {
        C10907c c10907cM65939k = c10906b.m65939k();
        if (c10907cM65939k == null) {
            return false;
        }
        if (!TextUtils.equals(c10907cM65939k.m65946b(), NotifyConstants.HICLOUD_DLAPP)) {
            return true;
        }
        GetActivityEntryResp getActivityEntryRespM63422j = m63422j();
        if (getActivityEntryRespM63422j == null) {
            C11839m.m70687e("HicloudLinkTextCheckTask", " getActivityEntryResp null");
            return false;
        }
        ActivityEntry entry = getActivityEntryRespM63422j.getEntry();
        if (entry == null) {
            return false;
        }
        this.f49687c = entry.getUrl();
        DlAppCampInfo campaignInfo = entry.getCampaignInfo();
        if (campaignInfo == null) {
            C11839m.m70687e("HicloudLinkTextCheckTask", "get activity entry SUCCESS, but campaignInfo is null");
            return false;
        }
        AdParametersExt adParametersExt = campaignInfo.getAdParametersExt();
        if (adParametersExt == null) {
            C11839m.m70687e("HicloudLinkTextCheckTask", " but adParametersExt is null");
            return false;
        }
        C10121i.m63036b(adParametersExt);
        if (!TextUtils.isEmpty(adParametersExt.getPpsAdid())) {
            return true;
        }
        C11839m.m70687e("HicloudLinkTextCheckTask", " PpsAdid is null");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d8 A[SYNTHETIC] */
    @Override // p616rk.AbstractRunnableC12516b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void call() throws java.io.IOException {
        /*
            r7 = this;
            kp.b r0 = kp.C11126b.m66896m()
            jp.b[] r0 = r0.m66913r()
            java.lang.String r1 = "HicloudLinkTextCheckTask"
            if (r0 == 0) goto Lee
            int r2 = r0.length
            if (r2 != 0) goto L11
            goto Lee
        L11:
            java.util.List r2 = p454lj.C11278a.m67689g()
            r7.f49688d = r2
            int r2 = r0.length
            r3 = 0
        L19:
            if (r3 >= r2) goto Lea
            r4 = r0[r3]
            if (r4 != 0) goto L26
            java.lang.String r4 = "textLink null"
            p514o9.C11839m.m70688i(r1, r4)
            goto Ld4
        L26:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "textLink id: "
            r5.append(r6)
            java.lang.String r6 = r4.m65935g()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            p514o9.C11839m.m70686d(r1, r5)
            boolean r5 = r7.m63418e(r4)
            if (r5 != 0) goto L4b
            java.lang.String r4 = "entrance check fail"
            p514o9.C11839m.m70688i(r1, r4)
            goto Ld4
        L4b:
            boolean r5 = r7.m63417d(r4)
            if (r5 != 0) goto L58
            java.lang.String r4 = "checkEffectTime fail"
            p514o9.C11839m.m70688i(r1, r4)
            goto Ld4
        L58:
            boolean r5 = r7.m63421h(r4)
            if (r5 != 0) goto L65
            java.lang.String r4 = "checkUserTags fail"
            p514o9.C11839m.m70688i(r1, r4)
            goto Ld4
        L65:
            boolean r5 = r7.m63420g(r4)
            if (r5 != 0) goto L71
            java.lang.String r4 = "checkUnDisplayTime fail"
            p514o9.C11839m.m70688i(r1, r4)
            goto Ld4
        L71:
            boolean r5 = r7.m63416c(r4)
            if (r5 != 0) goto L7d
            java.lang.String r4 = "checkActivityEntry fail"
            p514o9.C11839m.m70688i(r1, r4)
            goto Ld4
        L7d:
            boolean r5 = r7.m63419f(r4)
            if (r5 != 0) goto L89
            java.lang.String r4 = "checkTaskCenter fail"
            p514o9.C11839m.m70688i(r1, r4)
            goto Ld4
        L89:
            jp.c r5 = r4.m65939k()
            if (r5 != 0) goto L95
            java.lang.String r4 = "aGoto null"
            p514o9.C11839m.m70688i(r1, r4)
            goto Ld4
        L95:
            java.lang.String r5 = r5.m65946b()
            java.lang.String r6 = "hicloud_dlapp"
            boolean r5 = android.text.TextUtils.equals(r5, r6)
            if (r5 == 0) goto Lc1
            vj.e r5 = p709vj.C13452e.m80781L()
            boolean r5 = r5.m80795D0()
            if (r5 == 0) goto Lb1
            java.lang.String r4 = "textLinks HICLOUD_DLAPP can not show in child account"
            p514o9.C11839m.m70688i(r1, r4)
            goto Ld4
        Lb1:
            jp.c r5 = new jp.c
            r5.<init>()
            r5.m65947c(r6)
            java.lang.String r6 = r7.f49687c
            r5.m65948d(r6)
            r4.m65944p(r5)
        Lc1:
            kp.b r5 = kp.C11126b.m66896m()
            java.lang.String r5 = r5.m66915t(r4)
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 == 0) goto Ld8
            java.lang.String r4 = "languageStr null"
            p514o9.C11839m.m70688i(r1, r4)
        Ld4:
            int r3 = r3 + 1
            goto L19
        Ld8:
            r4.m65943o(r5)
            kp.b r0 = kp.C11126b.m66896m()
            android.graphics.drawable.Drawable r0 = r0.m66914s(r4)
            r4.m65942n(r0)
            r7.m63424l(r4)
            return
        Lea:
            r7.m63423k()
            return
        Lee:
            java.lang.String r0 = "textLinks null"
            p514o9.C11839m.m70688i(r1, r0)
            r7.m63423k()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p341hj.C10256p0.call():void");
    }

    /* renamed from: d */
    public final boolean m63417d(C10906b c10906b) {
        String strM65929a = c10906b.m65929a();
        String strM65933e = c10906b.m65933e();
        if (TextUtils.isEmpty(strM65929a) || TextUtils.isEmpty(strM65933e)) {
            return false;
        }
        return C0209d.m1238b2(strM65929a, strM65933e);
    }

    /* renamed from: e */
    public final boolean m63418e(C10906b c10906b) {
        String[] strArrM65934f = c10906b.m65934f();
        if (strArrM65934f == null || strArrM65934f.length == 0) {
            C11839m.m70687e("HicloudLinkTextCheckTask", "entrances null");
            return false;
        }
        for (String str : strArrM65934f) {
            if (TextUtils.equals(str, this.f49685a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public final boolean m63419f(C10906b c10906b) {
        C10907c c10907cM65939k = c10906b.m65939k();
        if (c10907cM65939k == null) {
            return false;
        }
        if (!TextUtils.equals(c10907cM65939k.m65946b(), NotifyConstants.ACTIVITIE_CENTER)) {
            return true;
        }
        if (C0209d.m1293p1()) {
            C11839m.m70688i("HicloudLinkTextCheckTask", "isInkScreen not show campaign");
            return false;
        }
        if (C13452e.m80781L().m80795D0()) {
            C11839m.m70688i("HicloudLinkTextCheckTask", "child account not show campaign");
            return false;
        }
        if (!C0209d.m1166E1()) {
            C11839m.m70688i("HicloudLinkTextCheckTask", "no owner user not show campaign");
            return false;
        }
        if (C11829c.m70629x0(true)) {
            return false;
        }
        GetCampaignActivityEntryResp getCampaignActivityEntryRespM63414a = new C10252o(2).m63414a();
        if (getCampaignActivityEntryRespM63414a.isExceedRedemptionLimit() || getCampaignActivityEntryRespM63414a.getResultCode() != 0) {
            C13823d.m82904y().m82919b(C0213f.m1377a());
            return false;
        }
        if (!C9718g.m60602t().m60612J(C0213f.m1377a())) {
            C11839m.m70688i("HicloudLinkTextCheckTask", "checkTaskCenter not show");
            return false;
        }
        if (C9718g.m60602t().m60608F(C0213f.m1377a())) {
            C11839m.m70688i("HicloudLinkTextCheckTask", "checkTaskCenter exceed redemption limit");
            return false;
        }
        if (C9718g.m60602t().m60606D(C0213f.m1377a())) {
            C11839m.m70688i("HicloudLinkTextCheckTask", "checkTaskCenter activity finished");
            return false;
        }
        if (CampaignCheckUtil.checkCampaignEntryCondition(C0213f.m1377a())) {
            return true;
        }
        C11839m.m70688i("HicloudLinkTextCheckTask", "checkTaskCenter checkCampaignEntryCondition");
        return false;
    }

    /* renamed from: g */
    public final boolean m63420g(C10906b c10906b) {
        return new C10779b0().m65624c(c10906b.m65935g()) < System.currentTimeMillis();
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.CHECK_TEXT_LINK;
    }

    /* renamed from: h */
    public final boolean m63421h(C10906b c10906b) {
        String[] strArrM65941m = c10906b.m65941m();
        if (strArrM65941m == null || strArrM65941m.length == 0) {
            C11839m.m70688i("HicloudLinkTextCheckTask", "userGroupExtIDs null");
            return true;
        }
        List<PortraitAndGrade.UserTag> list = this.f49688d;
        if (list == null || list.isEmpty()) {
            C11839m.m70687e("HicloudLinkTextCheckTask", "userTags null");
            return false;
        }
        for (String str : strArrM65941m) {
            Iterator<PortraitAndGrade.UserTag> it = this.f49688d.iterator();
            while (it.hasNext()) {
                if (it.next().getUserGroupExtID().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: j */
    public final GetActivityEntryResp m63422j() {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06020"), "getActivityEntry", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        try {
            return C9948a.m61631C().m61689q(new UserTags(), 415, c11060cM66626a);
        } catch (Exception e10) {
            C11839m.m70687e("HicloudLinkTextCheckTask", "getActivityEntry Exception = " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: k */
    public final void m63423k() {
        C11839m.m70686d("HicloudLinkTextCheckTask", "sendCheckFailMessage");
        Message messageObtainMessage = this.f49686b.obtainMessage();
        messageObtainMessage.what = 7050;
        this.f49686b.sendMessage(messageObtainMessage);
        C11128d.m66921d(this.f49685a, "check_text_link_fail");
    }

    /* renamed from: l */
    public final void m63424l(C10906b c10906b) {
        C11839m.m70686d("HicloudLinkTextCheckTask", "sendCheckSuccessMessage");
        Message messageObtainMessage = this.f49686b.obtainMessage();
        messageObtainMessage.what = 7051;
        messageObtainMessage.obj = c10906b;
        this.f49686b.sendMessage(messageObtainMessage);
        C11128d.m66921d(this.f49685a, "check_text_link_success");
    }
}
