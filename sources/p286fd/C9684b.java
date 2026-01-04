package p286fd;

import android.content.Context;
import android.text.TextUtils;
import bd.C1164a;
import com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.hicloud.base.drive.model.Channel;
import gp.C10028c;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p020ap.C1006a;
import p237du.C9310c;
import p255ed.C9453i;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p709vj.C13452e;
import tc.C13007b;

/* renamed from: fd.b */
/* loaded from: classes3.dex */
public class C9684b extends AbstractC12367d {

    /* renamed from: a */
    public Context f47904a;

    /* renamed from: b */
    public List<String> f47905b;

    /* renamed from: c */
    public boolean f47906c;

    public C9684b(Context context, List<String> list, boolean z10) {
        this.f47904a = context;
        this.f47905b = list;
        this.f47906c = z10;
    }

    /* renamed from: c */
    public final void m60511c(C9453i c9453i, String str, String str2, C13007b c13007b, C10028c c10028c) {
        try {
            Channel channel = new Channel();
            channel.setId(C9310c.m58618b(C13452e.m80781L().m80950o() + "10055832"));
            c9453i.m59250i().stop(str2, channel).execute();
            c13007b.m78260g(str);
            c13007b.m78282r(str);
            C11839m.m70688i("ChannelsStopTask", "syncV2 channels.stop success");
        } catch (Exception e10) {
            C11839m.m70687e("ChannelsStopTask", "syncV2 channels.stop Exception: " + e10.toString());
            if (m60512d(e10)) {
                c13007b.m78260g(str);
            } else if (DriveSyncUtil.m17972Q(e10)) {
                C11839m.m70688i("ChannelsStopTask", "syncV2 DATA_MIGRATING channels.stop clear data version sp.");
                DriveSyncUtil.m18003m(this.f47904a, str);
            } else {
                c13007b.m78291v0(str, true);
                c10028c.m62281U2("has_channels_stop_fail", true);
            }
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("ChannelsStopTask", "syncV2 ChannelsStopTask call");
        if (this.f47906c) {
            if (C0209d.m1208S0(this.f47904a)) {
                try {
                    m60514f();
                    return;
                } catch (Exception e10) {
                    C11839m.m70687e("ChannelsStopTask", "retryChannelsStop error: " + e10.getMessage());
                    return;
                }
            }
            return;
        }
        List<String> list = this.f47905b;
        if (list == null || list.size() == 0) {
            C11839m.m70687e("ChannelsStopTask", "syncV2 channels.stop syncTypes null.");
            return;
        }
        C13007b c13007bM78205Y = C13007b.m78205Y(this.f47904a);
        C10028c c10028cM62183d0 = C10028c.m62183d0(this.f47904a);
        try {
            try {
                C9453i c9453iM7268d = C1164a.m7265f().m7268d("ChannelsStopTask");
                if (c9453iM7268d == null) {
                    C11839m.m70687e("ChannelsStopTask", "syncV2 ChannelsStopTask get drive expand is null");
                    Iterator<String> it = this.f47905b.iterator();
                    while (it.hasNext()) {
                        c13007bM78205Y.m78266j(it.next());
                    }
                    return;
                }
                for (String str : this.f47905b) {
                    C11839m.m70688i("ChannelsStopTask", "syncV2 ChannelsStopTask syncType: " + str);
                    String strM17958C = DriveSyncUtil.m17958C(str);
                    if (TextUtils.isEmpty(strM17958C)) {
                        C11839m.m70687e("ChannelsStopTask", "syncV2 getDatabaseId is null, syncType: " + str);
                    } else if (m60513e(c10028cM62183d0, str)) {
                        C11839m.m70688i("ChannelsStopTask", "syncV2 switch on, no need stop, syncType: " + str);
                    } else if (!C0209d.m1208S0(this.f47904a)) {
                        C11839m.m70687e("ChannelsStopTask", "syncV2 channels stop no network, need retry");
                        c13007bM78205Y.m78291v0(str, true);
                        c10028cM62183d0.m62281U2("has_channels_stop_fail", true);
                    } else if (c13007bM78205Y.m78236P(str)) {
                        m60511c(c9453iM7268d, str, strM17958C, c13007bM78205Y, c10028cM62183d0);
                    } else {
                        C11839m.m70689w("ChannelsStopTask", "syncV2 never subscribe suc, no need stop, syncType: " + str);
                    }
                }
                Iterator<String> it2 = this.f47905b.iterator();
                while (it2.hasNext()) {
                    c13007bM78205Y.m78266j(it2.next());
                }
            } catch (Exception e11) {
                C11839m.m70687e("ChannelsStopTask", "syncV2 channels stop Exception: " + e11.toString());
                Iterator<String> it3 = this.f47905b.iterator();
                while (it3.hasNext()) {
                    c13007bM78205Y.m78266j(it3.next());
                }
            }
        } catch (Throwable th2) {
            Iterator<String> it4 = this.f47905b.iterator();
            while (it4.hasNext()) {
                c13007bM78205Y.m78266j(it4.next());
            }
            throw th2;
        }
    }

    /* renamed from: d */
    public boolean m60512d(Exception exc) {
        return DriveSyncUtil.m17975T(404, "4041", exc);
    }

    /* renamed from: e */
    public final boolean m60513e(C10028c c10028c, String str) {
        return "atlas".equals(str) ? C1006a.m5936k().m5975v(this.f47904a) : c10028c.m62388s(str);
    }

    /* renamed from: f */
    public final void m60514f() throws Exception {
        C13007b c13007bM78205Y = C13007b.m78205Y(this.f47904a);
        C10028c c10028cM62183d0 = C10028c.m62183d0(this.f47904a);
        C11839m.m70688i("ChannelsStopTask", "retry channels stop");
        C9453i c9453iM7268d = C1164a.m7265f().m7268d("ChannelsStopTask");
        if (c9453iM7268d == null) {
            C11839m.m70687e("ChannelsStopTask", "syncV2 ChannelsStopTask get drive expand is null");
            return;
        }
        if (c10028cM62183d0.m62324f0("has_channels_stop_fail")) {
            Iterator<String> it = SyncObserverServiceInvoker.getInstance().getAllSyncType().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (c13007bM78205Y.m78253c0(next)) {
                    String strM17958C = DriveSyncUtil.m17958C(next);
                    if (TextUtils.isEmpty(strM17958C)) {
                        C11839m.m70687e("ChannelsStopTask", "syncV2 getDatabaseId is null, syncType: " + next);
                        c13007bM78205Y.m78260g(next);
                    } else if (m60513e(c10028cM62183d0, next)) {
                        C11839m.m70688i("ChannelsStopTask", "syncV2 switch on, no need stop, syncType: " + next);
                        c13007bM78205Y.m78260g(next);
                    } else {
                        try {
                            try {
                                Channel channel = new Channel();
                                channel.setId(C9310c.m58618b(C13452e.m80781L().m80950o() + "10055832"));
                                c9453iM7268d.m59250i().stop(strM17958C, channel).execute();
                                C11839m.m70688i("ChannelsStopTask", "syncV2 channels.stop success");
                            } catch (Exception e10) {
                                C11839m.m70687e("ChannelsStopTask", "syncV2 channels.stop Exception: " + e10.toString());
                            }
                        } finally {
                            c13007bM78205Y.m78260g(next);
                        }
                    }
                }
            }
            c10028cM62183d0.m62353l("has_channels_stop_fail");
        }
    }
}
