package lc;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.servercontrol.ServerControlResultCallback;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.HiCloudNotification;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.request.basic.bean.PostOpDescInfo;
import com.huawei.hicloud.router.data.SwitchInfo;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0212e0;
import p015ak.C0213f;
import p020ap.C1006a;
import p336he.C10155f;
import p514o9.C11836j;
import p514o9.C11839m;
import p572qb.C12299b;
import p616rk.C12515a;
import p746wn.C13622a;

/* renamed from: lc.b */
/* loaded from: classes3.dex */
public class C11268b implements ServerControlResultCallback {

    /* renamed from: b */
    public static final C11268b f52891b = new C11268b();

    /* renamed from: c */
    public static final Object f52892c = new Object();

    /* renamed from: d */
    public static final Object f52893d = new Object();

    /* renamed from: a */
    public String f52894a = "";

    /* renamed from: i */
    public static C11268b m67619i() {
        return f52891b;
    }

    @Override // com.huawei.android.hicloud.servercontrol.ServerControlResultCallback
    /* renamed from: a */
    public void mo17194a(String str) {
        C11839m.m70688i("ServerControlManager", "resetFailed");
        C11269c c11269c = new C11269c(this);
        PostOpDescInfo postOpDescInfoM67625k = m67625k();
        postOpDescInfoM67625k.setResult("fail" + str);
        C11839m.m70688i("ServerControlManager", "failInfo:" + postOpDescInfoM67625k.toString());
        c11269c.m67632c(postOpDescInfoM67625k.toString());
        C12515a.m75110o().m75172d(c11269c);
        C11836j.m70658k().m70664f();
    }

    @Override // com.huawei.android.hicloud.servercontrol.ServerControlResultCallback
    /* renamed from: b */
    public void mo17195b() {
        C11839m.m70688i("ServerControlManager", "resetSuccess");
        C11270d.m67633k();
        m67628n(8);
        C11269c c11269c = new C11269c(this);
        PostOpDescInfo postOpDescInfoM67625k = m67625k();
        postOpDescInfoM67625k.setResult("ok");
        C11839m.m70688i("ServerControlManager", "successInfo:" + postOpDescInfoM67625k.toString());
        c11269c.m67632c(postOpDescInfoM67625k.toString());
        C12515a.m75110o().m75172d(c11269c);
    }

    @Override // com.huawei.android.hicloud.servercontrol.ServerControlResultCallback
    /* renamed from: c */
    public void mo17196c() {
        C11839m.m70688i("ServerControlManager", "notifyFailed");
        C11836j.m70658k().m70664f();
    }

    @Override // com.huawei.android.hicloud.servercontrol.ServerControlResultCallback
    /* renamed from: d */
    public void mo17197d() {
        C11839m.m70688i("ServerControlManager", "notifySuccess");
    }

    /* renamed from: e */
    public void m67620e() {
        C11839m.m70688i("ServerControlManager", "checkServerControlStatus");
        if (m67626l() != 0) {
            C11839m.m70688i("ServerControlManager", "resetStatus not finish");
            C12515a.m75110o().m75172d(new C11270d(this));
        } else if (m67624j() != 0) {
            C11839m.m70688i("ServerControlManager", "notifyStatus not finish");
            C12515a.m75110o().m75172d(new C11269c(this));
        }
    }

    /* renamed from: f */
    public void m67621f() {
        m67630p(0);
        m67629o(0);
    }

    /* renamed from: g */
    public final void m67622g() {
        if (C10155f.m63249B()) {
            SwitchInfo switchInfoM5970q = C1006a.m5936k().m5970q(C0213f.m1377a());
            Bundle bundle = new Bundle();
            bundle.putBoolean("GeneralAblum", switchInfoM5970q.isGeneralAlbumOn());
            bundle.putBoolean("ShareAlbum", switchInfoM5970q.isShareAlbumOn());
            C1006a.m5936k().m5943G(C0213f.m1377a(), bundle, 8);
        }
    }

    /* renamed from: h */
    public final void m67623h(int i10) {
        C11839m.m70688i("ServerControlManager", "executeSync");
        HiCloudNotification.getInstance().getConfigVersion();
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        boolean zM62388s = c10028cM62182c0.m62388s("addressbook");
        boolean zM62388s2 = c10028cM62182c0.m62388s("calendar");
        boolean zM62388s3 = c10028cM62182c0.m62388s("notepad");
        boolean zM62388s4 = c10028cM62182c0.m62388s("wlan");
        boolean zM62388s5 = c10028cM62182c0.m62388s("browser");
        boolean zM62395t1 = c10028cM62182c0.m62395t1("funcfg_contacts");
        boolean zM62395t12 = c10028cM62182c0.m62395t1("funcfg_calendar");
        boolean zM62395t13 = c10028cM62182c0.m62395t1("funcfg_notes");
        boolean zM62395t14 = c10028cM62182c0.m62395t1("funcfg_wlan");
        boolean zM62395t15 = c10028cM62182c0.m62395t1("funcfg_browser");
        String strM81958d = C13622a.m81958d("03011");
        if (zM62388s && zM62395t1) {
            C10155f.m63272Y(C0213f.m1377a(), strM81958d, SyncType.OPEN_SWITCH_FROM_GUIDE, i10);
        }
        if (zM62388s2 && zM62395t12) {
            C10155f.m63271X(C0213f.m1377a(), strM81958d, i10);
        }
        if (zM62388s3 && zM62395t13) {
            C10155f.m63275a0(C0213f.m1377a(), strM81958d, i10);
        }
        if (zM62388s4 && zM62395t14) {
            C10155f.m63279c0(C0213f.m1377a(), strM81958d, i10);
        }
        if (zM62388s5 && zM62395t15) {
            C10155f.m63270W(C0213f.m1377a(), strM81958d, i10);
        }
        m67631q(c10028cM62182c0, strM81958d, i10);
    }

    /* renamed from: j */
    public int m67624j() {
        int iM1358h;
        synchronized (f52893d) {
            iM1358h = C0212e0.m1358h(C0213f.m1377a(), "push_control", "push_reset_notify_status", 0);
        }
        return iM1358h;
    }

    /* renamed from: k */
    public final PostOpDescInfo m67625k() {
        PostOpDescInfo postOpDescInfo = new PostOpDescInfo();
        if (!TextUtils.isEmpty(this.f52894a)) {
            try {
                postOpDescInfo.setAction(new JSONObject(this.f52894a).optInt(CommonNotifyReceiver.COMMAND_KEY, 0));
            } catch (JSONException e10) {
                C11839m.m70688i("ServerControlManager", "JSONException:" + e10.toString());
            }
        }
        postOpDescInfo.setService(CloudBackupConstant.RestoreDataDictionaryType.BASIC);
        return postOpDescInfo;
    }

    /* renamed from: l */
    public int m67626l() {
        int iM1358h;
        synchronized (f52892c) {
            iM1358h = C0212e0.m1358h(C0213f.m1377a(), "push_control", "push_reset_status", 0);
        }
        return iM1358h;
    }

    /* renamed from: m */
    public void m67627m(String str) {
        this.f52894a = str;
        C12515a.m75110o().m75172d(new C11270d(this));
    }

    /* renamed from: n */
    public final void m67628n(int i10) {
        if (C10028c.m62182c0().m62221H1()) {
            m67623h(i10);
            m67622g();
        }
    }

    /* renamed from: o */
    public void m67629o(int i10) {
        synchronized (f52893d) {
            C0212e0.m1369s(C0213f.m1377a(), "push_control", "push_reset_notify_status", i10);
        }
    }

    /* renamed from: p */
    public void m67630p(int i10) {
        synchronized (f52892c) {
            C0212e0.m1369s(C0213f.m1377a(), "push_control", "push_reset_status", i10);
            C12299b.m73931m(i10);
        }
    }

    /* renamed from: q */
    public final void m67631q(C10028c c10028c, String str, int i10) {
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(C0213f.m1377a());
        if (shownSyncServiceItems.size() > 0) {
            Iterator<SyncConfigService> it = shownSyncServiceItems.iterator();
            while (it.hasNext()) {
                SyncConfigService next = it.next();
                if (next != null) {
                    String id2 = next.getId();
                    if (!TextUtils.isEmpty(id2) && c10028c.m62388s(id2)) {
                        C10155f.m63277b0(C0213f.m1377a(), id2, str, i10);
                    }
                }
            }
        }
    }
}
