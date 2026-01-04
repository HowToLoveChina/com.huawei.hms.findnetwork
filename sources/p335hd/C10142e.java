package p335hd;

import android.app.KeyguardManager;
import android.text.TextUtils;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.hicloud.messagecenter.bean.DeskPopupMsgObj;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.bean.DeskPopupJump;
import com.huawei.hicloud.notification.bean.SecondWindows;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.HiCloudMsgNoticeConfigManager;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import fk.C9721b;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p292fn.C9733f;
import p336he.C10155f;
import p514o9.C11839m;
import p572qb.C12311h;
import p581qk.AbstractC12364a;
import p684un.C13230i;
import p709vj.C13452e;
import p742wj.C13612b;

/* renamed from: hd.e */
/* loaded from: classes3.dex */
public class C10142e extends AbstractC12364a {

    /* renamed from: c */
    public LinkedHashMap<String, String> f49435c;

    /* renamed from: d */
    public boolean f49436d;

    /* renamed from: e */
    public int f49437e;

    /* renamed from: hd.e$a */
    public static class a {

        /* renamed from: a */
        public static final C10142e f49438a = new C10142e();
    }

    public C10142e() {
        super(0L, 10L);
        this.f49435c = C13230i.m79497A(C13452e.m80781L().m80971t0());
        this.f49436d = false;
        this.f49437e = 0;
    }

    /* renamed from: d */
    public static C10142e m63197d() {
        return a.f49438a;
    }

    /* renamed from: c */
    public final boolean m63198c(String str, int i10) {
        long requestCacheDuration = C9733f.m60705z().m60761t().getRequestCacheDuration();
        if (TextUtils.equals(str, "tCenter")) {
            if (Math.abs(System.currentTimeMillis() - C0212e0.m1359i(C0213f.m1377a(), "sp_desktop_dialog", "key_t_center_time", 0L)) <= requestCacheDuration) {
                return C0212e0.m1354d(C0213f.m1377a(), "sp_desktop_dialog", "key_t_center_has_data", false);
            }
            boolean zIsHasCampaignActivityData = CloudSpaceNotifyUtil.getInstance().isHasCampaignActivityData(i10);
            C0212e0.m1365o(C0213f.m1377a(), "sp_desktop_dialog", "key_t_center_has_data", zIsHasCampaignActivityData);
            C0212e0.m1370t(C0213f.m1377a(), "sp_desktop_dialog", "key_t_center_time", System.currentTimeMillis());
            return zIsHasCampaignActivityData;
        }
        if (!TextUtils.equals(str, "dlapp")) {
            return false;
        }
        if (Math.abs(System.currentTimeMillis() - C0212e0.m1359i(C0213f.m1377a(), "sp_desktop_dialog", "key_dl_app_time", 0L)) <= requestCacheDuration) {
            return C0212e0.m1354d(C0213f.m1377a(), "sp_desktop_dialog", "key_dl_app_has_data", false);
        }
        boolean zIsHasActivityEntry = CloudSpaceNotifyUtil.getInstance().isHasActivityEntry(i10);
        C0212e0.m1365o(C0213f.m1377a(), "sp_desktop_dialog", "key_dl_app_has_data", zIsHasActivityEntry);
        C0212e0.m1370t(C0213f.m1377a(), "sp_desktop_dialog", "key_dl_app_time", System.currentTimeMillis());
        return zIsHasActivityEntry;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b, ParseException {
        DeskPopupMsgObj next;
        C11839m.m70688i("DesktopCheckTimer", "task start");
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        this.f49435c = linkedHashMapM79497A;
        if (this.f49436d) {
            linkedHashMapM79497A.put("fromUnlock", String.valueOf(true));
            int screenUnlockCheckTimes = NotifyUtil.getDesktopUnlockFrequency().getScreenUnlockCheckTimes();
            C11839m.m70688i("DesktopCheckTimer", "from unlock, numberTimes: " + screenUnlockCheckTimes + ", curNumberTimes: " + this.f49437e);
            int i10 = this.f49437e;
            if (i10 >= screenUnlockCheckTimes) {
                this.f49436d = false;
                this.f49437e = 0;
                setPeriod(10L);
                super.cancel();
                C12311h.m74013c().m74024l();
                return;
            }
            this.f49437e = i10 + 1;
        }
        if (!C10155f.m63258K()) {
            C11839m.m70688i("DesktopCheckTimer", "the pop-up limit has been exceeded");
            this.f49435c.put("event", "the pop-up limit has been exceeded");
            C12311h.m74013c().m74021i("DesktopCheckTimer", this.f49435c);
            m63204k();
            super.cancel();
            return;
        }
        if (!C0209d.m1265i1(C0213f.m1377a())) {
            C11839m.m70688i("DesktopCheckTimer", "task now not on desktop");
            this.f49435c.put("event", "task now not on desktop");
            C12311h.m74013c().m74021i("DesktopCheckTimer", this.f49435c);
            return;
        }
        if (!C13612b.m81829B().isLogin()) {
            C11839m.m70688i("DesktopCheckTimer", "task now not login");
            this.f49435c.put("event", "task now not login");
            C12311h.m74013c().m74021i("DesktopCheckTimer", this.f49435c);
            super.cancel();
            return;
        }
        if (NotifyUtil.isSilentNotifyTime()) {
            C11839m.m70688i("DesktopCheckTimer", "task now is silent time");
            long silentNotifyEndTimeMillis = NotifyUtil.getSilentNotifyEndTimeMillis();
            long jM1264i0 = C0209d.m1264i0(silentNotifyEndTimeMillis, (C9733f.m60705z().m60761t().getSilentPeriodCheckRandomDuration() * 1000) + silentNotifyEndTimeMillis);
            C11839m.m70688i("DesktopCheckTimer", "silent time, delayMills: " + jM1264i0);
            C10139b.m63185a().m63187c(jM1264i0);
            this.f49435c.put("event", "task now is silent time");
            this.f49435c.put("delayMills", String.valueOf(jM1264i0));
            C12311h.m74013c().m74021i("DesktopCheckTimer", this.f49435c);
            super.cancel();
            return;
        }
        if (((KeyguardManager) C0213f.m1377a().getSystemService("keyguard")).isKeyguardLocked()) {
            C11839m.m70688i("DesktopCheckTimer", "task now isLocked");
            ScreenListener.m18023c(C0213f.m1377a()).m18025b(new C12311h.b());
            this.f49435c.put("event", "task now isLocked");
            C12311h.m74013c().m74021i("DesktopCheckTimer", this.f49435c);
            super.cancel();
            return;
        }
        List<DeskPopupMsgObj> listM74020h = C12311h.m74013c().m74020h();
        if (listM74020h == null || listM74020h.isEmpty()) {
            C11839m.m70688i("DesktopCheckTimer", "task deskPopupMsgObjList is null or empty");
            this.f49435c.put("event", "task deskPopupMsgObjList is null or empty");
            C12311h.m74013c().m74021i("DesktopCheckTimer", this.f49435c);
            super.cancel();
            return;
        }
        Iterator<DeskPopupMsgObj> it = listM74020h.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (C12311h.m74013c().m74018f(next)) {
                try {
                    m63201g(next);
                    String strReplaceParams = CloudSpaceNotifyUtil.getInstance().replaceParams(next.getDesktopTitle(), "DESKTOP_DIALOG", next.getContext());
                    if (!TextUtils.isEmpty(strReplaceParams)) {
                        next.setDesktopTitle(strReplaceParams);
                        m63200f(next);
                        String strReplaceParams2 = CloudSpaceNotifyUtil.getInstance().replaceParams(next.getDesktopText(), "DESKTOP_DIALOG", next.getContext());
                        if (!TextUtils.isEmpty(strReplaceParams2)) {
                            next.setDesktopText(strReplaceParams2);
                            next.setSecondWindows(m63199e(next));
                            break;
                        } else {
                            C11839m.m70688i("DesktopCheckTimer", "task desktopText is null");
                            this.f49435c.put("event", "task desktopText is null");
                            C12311h.m74013c().m74014a(this.f49435c, next);
                            C12311h.m74013c().m74021i("DesktopCheckTimer", this.f49435c);
                        }
                    } else {
                        C11839m.m70688i("DesktopCheckTimer", "task desktopTitle is null");
                        this.f49435c.put("event", "task desktopTitle is null");
                        C12311h.m74013c().m74014a(this.f49435c, next);
                        C12311h.m74013c().m74021i("DesktopCheckTimer", this.f49435c);
                    }
                } catch (C9721b e10) {
                    C11839m.m70687e("DesktopCheckTimer", "refreshTextKey failed, e = " + e10.getMessage());
                }
            } else {
                C11839m.m70687e("DesktopCheckTimer", "task not isParamSatisfy");
                C12311h.m74013c().m74015b(next.getUniqueId());
                this.f49435c.put("event", "task not isParamSatisfy");
                C12311h.m74013c().m74014a(this.f49435c, next);
                C12311h.m74013c().m74021i("DesktopCheckTimer", this.f49435c);
            }
        }
        if (!C0209d.m1265i1(C0213f.m1377a())) {
            C11839m.m70688i("DesktopCheckTimer", "task now not on desktop2");
            this.f49435c.put("event", "task now not on desktop2");
            C12311h.m74013c().m74014a(this.f49435c, next);
            C12311h.m74013c().m74021i("DesktopCheckTimer", this.f49435c);
            return;
        }
        if (next == null) {
            C11839m.m70689w("DesktopCheckTimer", "task now validData is null");
            this.f49435c.put("event", "task now validData is null");
            C12311h.m74013c().m74021i("DesktopCheckTimer", this.f49435c);
            super.cancel();
            return;
        }
        if (!C12311h.m74013c().m74018f(next)) {
            C11839m.m70687e("DesktopCheckTimer", "task not isParamSatisfy");
            C12311h.m74013c().m74015b(next.getUniqueId());
            this.f49435c.put("event", "task not isParamSatisfy");
            C12311h.m74013c().m74014a(this.f49435c, next);
            C12311h.m74013c().m74021i("DesktopCheckTimer", this.f49435c);
            return;
        }
        try {
            C12311h.m74013c().m74023k(next);
            C11839m.m70688i("DesktopCheckTimer", "task begin show dialog");
            this.f49435c.put("event", "task begin show dialog");
            C12311h.m74013c().m74014a(this.f49435c, next);
            C12311h.m74013c().m74021i("DesktopCheckTimer", this.f49435c);
        } catch (Exception e11) {
            C11839m.m70687e("DesktopCheckTimer", "show dialog failed, e: " + e11.getMessage());
            this.f49435c.put("errMsg", e11.getMessage());
            this.f49435c.put("event", "task begin show dialog error");
            C12311h.m74013c().m74014a(this.f49435c, next);
            C12311h.m74013c().m74021i("DesktopCheckTimer", this.f49435c);
            super.cancel();
        }
    }

    /* renamed from: e */
    public final List<SecondWindows> m63199e(DeskPopupMsgObj deskPopupMsgObj) {
        C11839m.m70688i("DesktopCheckTimer", "getSecondWindow, enter");
        ArrayList arrayList = new ArrayList();
        if (deskPopupMsgObj == null) {
            C11839m.m70688i("DesktopCheckTimer", "getSecondWindow, deskPopupMsgObj is null");
            return arrayList;
        }
        List<SecondWindows> secondWindows = deskPopupMsgObj.getSecondWindows();
        if (secondWindows == null) {
            C11839m.m70688i("DesktopCheckTimer", "getSecondWindow, no data");
            return arrayList;
        }
        Iterator<SecondWindows> it = secondWindows.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SecondWindows next = it.next();
            try {
                m63202h(next);
            } catch (C9721b e10) {
                C11839m.m70687e("DesktopCheckTimer", "getSecondWindow, refreshTextKey failed, e = " + e10.getMessage());
            }
            if (m63198c(next.getWinType(), next.getSource())) {
                C11839m.m70686d("DesktopCheckTimer", "getSecondWindow, " + next.getWinType() + " has data");
                arrayList.add(next);
                break;
            }
        }
        C11839m.m70688i("DesktopCheckTimer", "getSecondWindow, exit");
        return arrayList;
    }

    /* renamed from: f */
    public final void m63200f(DeskPopupMsgObj deskPopupMsgObj) {
        if (deskPopupMsgObj == null) {
            return;
        }
        for (DeskPopupJump deskPopupJump : deskPopupMsgObj.getDesktopGoto()) {
            if (NotifyConstants.TYPE_DEEPLINK.equals(deskPopupJump.getNotifyType())) {
                deskPopupJump.setNotifyUri(CloudSpaceNotifyUtil.getInstance().replaceDeepLinkParams(deskPopupJump.getNotifyUri(), "NOTIFY_BAR", deskPopupMsgObj.getContext()));
            }
        }
    }

    /* renamed from: g */
    public final void m63201g(DeskPopupMsgObj deskPopupMsgObj) throws C9721b {
        String stringFromDB = HiCloudMsgNoticeConfigManager.getInstance().getStringFromDB(deskPopupMsgObj.getDesktopTitle());
        if (TextUtils.isEmpty(stringFromDB)) {
            throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "desktopTitle is empty");
        }
        deskPopupMsgObj.setDesktopTitle(stringFromDB);
        String stringFromDB2 = HiCloudMsgNoticeConfigManager.getInstance().getStringFromDB(deskPopupMsgObj.getDesktopText());
        if (TextUtils.isEmpty(stringFromDB2)) {
            throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "desktopText is empty");
        }
        deskPopupMsgObj.setDesktopText(stringFromDB2);
        for (DeskPopupJump deskPopupJump : deskPopupMsgObj.getDesktopGoto()) {
            String stringFromDB3 = HiCloudMsgNoticeConfigManager.getInstance().getStringFromDB(deskPopupJump.getNotifyKey());
            if (TextUtils.isEmpty(stringFromDB3)) {
                throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "notifyKey is empty");
            }
            deskPopupJump.setNotifyKey(stringFromDB3);
        }
    }

    /* renamed from: h */
    public final void m63202h(SecondWindows secondWindows) throws C9721b {
        String stringFromDB = HiCloudMsgNoticeConfigManager.getInstance().getStringFromDB(secondWindows.getTitle());
        if (TextUtils.isEmpty(stringFromDB)) {
            throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "title is empty");
        }
        secondWindows.setTitle(stringFromDB);
        String stringFromDB2 = HiCloudMsgNoticeConfigManager.getInstance().getStringFromDB(secondWindows.getMainText());
        if (TextUtils.isEmpty(stringFromDB2)) {
            throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "mainText is empty");
        }
        secondWindows.setMainText(stringFromDB2);
        for (DeskPopupJump deskPopupJump : secondWindows.getButtons()) {
            String stringFromDB3 = HiCloudMsgNoticeConfigManager.getInstance().getStringFromDB(deskPopupJump.getNotifyKey());
            if (TextUtils.isEmpty(stringFromDB3)) {
                throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "notifyKey is empty");
            }
            deskPopupJump.setNotifyKey(stringFromDB3);
        }
    }

    /* renamed from: j */
    public void m63203j(boolean z10) {
        this.f49436d = z10;
        this.f49437e = 0;
    }

    /* renamed from: k */
    public final void m63204k() {
        long jCurrentTimeMillis = (System.currentTimeMillis() - C0212e0.m1359i(C0213f.m1377a(), "sp_desktop_dialog", "key_last_show_time", 0L)) + (((Integer) C10155f.m63282f().first).intValue() * C5863b6.g.f26453g);
        C11839m.m70688i("DesktopCheckTimer", "can not show, delay: " + jCurrentTimeMillis);
        C10139b.m63185a().m63187c(jCurrentTimeMillis);
    }

    @Override // p581qk.AbstractC12364a, p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return true;
    }
}
