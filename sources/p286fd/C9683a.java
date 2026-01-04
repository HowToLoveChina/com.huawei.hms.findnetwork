package p286fd;

import android.content.Context;
import android.text.TextUtils;
import bd.C1164a;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.hicloud.base.drive.model.Channel;
import com.huawei.hicloud.base.drive.model.ChannelSubscribeRequest;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.util.NotifyUtil;
import fk.C9722c;
import gp.C10028c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import je.C10812z;
import p020ap.C1006a;
import p237du.C9310c;
import p255ed.C9453i;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p709vj.C13452e;
import p742wj.C13612b;
import tc.C13007b;

/* renamed from: fd.a */
/* loaded from: classes3.dex */
public class C9683a extends AbstractC12367d {

    /* renamed from: a */
    public Context f47900a;

    /* renamed from: b */
    public List<String> f47901b;

    /* renamed from: c */
    public String f47902c;

    /* renamed from: d */
    public String f47903d;

    public C9683a(Context context, String str) {
        this.f47900a = context;
        this.f47902c = str;
    }

    /* renamed from: c */
    public final boolean m60508c(String str, String str2, C13007b c13007b) {
        if (!"v2PushReport".equals(str2) && !"V2.0".equalsIgnoreCase(c13007b.m78296y(str))) {
            return false;
        }
        long jM78218G = c13007b.m78218G(str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        C11839m.m70686d("ChangesSubscribeTask", "syncType: " + str + " lastReportTime: " + jM78218G + " currentTime: " + jCurrentTimeMillis);
        long j10 = jCurrentTimeMillis - jM78218G;
        if (j10 < 0) {
            return true;
        }
        if (("fullReport".equals(str2) || "syncReport".equals(str2) || "v2PushReport".equals(str2)) && j10 < 86400000) {
            C11839m.m70686d("ChangesSubscribeTask", "syncV2 syncType: " + str + " reportType: " + str2 + " in 24 hours ,no need subscribe.");
            return false;
        }
        if (!"refreshReport".equals(str2) || j10 >= 604800000) {
            return true;
        }
        C11839m.m70686d("ChangesSubscribeTask", "syncV2 syncType: " + str + " reportType: " + str2 + " in 7 days ,no need subscribe.");
        return false;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("ChangesSubscribeTask", "syncV2 ChangesSubscribeTask call reportType: " + this.f47902c);
        if (C13452e.m80781L().m80842P0()) {
            try {
                C9453i c9453iM7268d = C1164a.m7265f().m7268d(this.f47902c);
                if (this.f47901b == null) {
                    this.f47901b = new ArrayList();
                    m60510e();
                }
                C13007b c13007bM78205Y = C13007b.m78205Y(this.f47900a);
                List<String> list = this.f47901b;
                if (list == null || list.isEmpty()) {
                    return;
                }
                if (this.f47903d == null) {
                    this.f47903d = C10812z.m65832a("03001");
                }
                for (String str : this.f47901b) {
                    long jCurrentTimeMillis = System.currentTimeMillis() + 2592000000L;
                    try {
                        if (m60508c(str, this.f47902c, c13007bM78205Y)) {
                            String strM17958C = DriveSyncUtil.m17958C(str);
                            if (TextUtils.isEmpty(strM17958C)) {
                                C11839m.m70687e("ChangesSubscribeTask", "syncV2 getDatabaseId is null, syncType: " + str);
                            } else {
                                C11839m.m70686d("ChangesSubscribeTask", "syncV2 begin subscribe syncType: " + str);
                                ChannelSubscribeRequest channelSubscribeRequest = new ChannelSubscribeRequest();
                                channelSubscribeRequest.setExpirationTime(Long.valueOf(jCurrentTimeMillis));
                                channelSubscribeRequest.setId(C9310c.m58618b(C13452e.m80781L().m80950o() + "10055832"));
                                channelSubscribeRequest.setPushToken(C13612b.m81829B().m81845H(this.f47900a));
                                channelSubscribeRequest.setSignVersion(2);
                                channelSubscribeRequest.setType("push");
                                Channel channelExecute = c9453iM7268d.m59249h().subscribe(strM17958C, channelSubscribeRequest).addHeader("x-hw-trace-id", (Object) this.f47903d).execute();
                                c13007bM78205Y.m78297y0(str, System.currentTimeMillis());
                                c13007bM78205Y.m78221H0(str, true);
                                C11839m.m70686d("ChangesSubscribeTask", "syncV2 syncType: " + str + ",changes.subscribe: " + channelExecute.toString());
                                m60509d(str, 0, "", jCurrentTimeMillis, c13007bM78205Y);
                            }
                        }
                    } catch (IOException e10) {
                        String message = e10.getMessage();
                        C11839m.m70687e("ChangesSubscribeTask", "syncV2 changesNotify IOException: " + e10.toString());
                        if (DriveSyncUtil.m17972Q(e10)) {
                            C11839m.m70688i("ChangesSubscribeTask", "syncV2 DATA_MIGRATING changesNotify clear data version sp.");
                            DriveSyncUtil.m18003m(this.f47900a, str);
                        }
                        m60509d(str, 5, message, jCurrentTimeMillis, c13007bM78205Y);
                    } catch (Exception e11) {
                        String message2 = e11.getMessage();
                        C11839m.m70687e("ChangesSubscribeTask", "syncV2 changesNotify Exception: " + e11.toString());
                        m60509d(str, 5, message2, jCurrentTimeMillis, c13007bM78205Y);
                    }
                }
            } catch (C9722c e12) {
                C11839m.m70687e("ChangesSubscribeTask", "ChangesSubscribeTask get drive expand is null exception = " + e12.getMessage());
            }
        }
    }

    /* renamed from: d */
    public final void m60509d(String str, int i10, String str2, long j10, C13007b c13007b) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("reportType", this.f47902c);
        linkedHashMap.put("expireTime", String.valueOf(j10));
        linkedHashMap.put("sp_data_version", c13007b.m78296y(str));
        C10812z.m65846o(this.f47900a, str, i10, str2, "03001", "changesSubscribe", this.f47903d, linkedHashMap, false);
    }

    /* renamed from: e */
    public final void m60510e() {
        C10028c c10028cM62183d0 = C10028c.m62183d0(this.f47900a);
        if (C1006a.m5936k().m5975v(this.f47900a)) {
            this.f47901b.add("atlas");
        }
        if (c10028cM62183d0.m62388s("addressbook")) {
            this.f47901b.add("addressbook");
        }
        if (c10028cM62183d0.m62388s("notepad")) {
            this.f47901b.add("notepad");
        }
        if (c10028cM62183d0.m62388s("calendar")) {
            this.f47901b.add("calendar");
        }
        if (c10028cM62183d0.m62388s("browser")) {
            this.f47901b.add("browser");
        }
        if (c10028cM62183d0.m62388s("wlan")) {
            this.f47901b.add("wlan");
        }
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(this.f47900a);
        if (shownSyncServiceItems.size() > 0) {
            Iterator<SyncConfigService> it = shownSyncServiceItems.iterator();
            while (it.hasNext()) {
                SyncConfigService next = it.next();
                if (next != null) {
                    String id2 = next.getId();
                    if (!TextUtils.isEmpty(id2) && c10028cM62183d0.m62388s(id2)) {
                        this.f47901b.add(id2);
                    }
                }
            }
        }
    }

    public C9683a(Context context, List<String> list, String str, String str2) {
        this.f47900a = context;
        this.f47901b = list;
        this.f47902c = str;
        this.f47903d = str2;
    }
}
