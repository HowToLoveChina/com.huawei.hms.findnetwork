package p366if;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.android.remotecontrol.http.C4347e;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import p015ak.C0209d;
import p015ak.C0219i;
import p638sf.C12795b;
import p774xg.C13811a;
import p774xg.C13812b;
import p809yg.C13981a;
import pg.AbstractC12139d;

/* renamed from: if.f */
/* loaded from: classes4.dex */
public class C10481f {

    /* renamed from: a */
    public static ArrayList<AbstractC10482g> f50512a = new ArrayList<>();

    /* renamed from: b */
    public static ArrayList<AbstractC10482g> f50513b = new ArrayList<>();

    /* renamed from: b */
    public static void m64426b(AbstractC10482g abstractC10482g) {
        if (abstractC10482g != null) {
            f50512a.add(abstractC10482g);
        }
    }

    /* renamed from: c */
    public static void m64427c(AbstractC10482g abstractC10482g) {
        if (abstractC10482g != null) {
            f50513b.add(abstractC10482g);
        }
    }

    /* renamed from: d */
    public static void m64428d() {
        m64429e();
        m64430f();
    }

    /* renamed from: e */
    public static void m64429e() {
        ArrayList<AbstractC10482g> arrayList = f50512a;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<AbstractC10482g> it = f50512a.iterator();
        while (it.hasNext()) {
            it.next().m64477x0();
        }
        f50512a.clear();
    }

    /* renamed from: f */
    public static void m64430f() {
        ArrayList<AbstractC10482g> arrayList = f50513b;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<AbstractC10482g> it = f50513b.iterator();
        while (it.hasNext()) {
            it.next().m64477x0();
        }
        f50513b.clear();
    }

    /* renamed from: g */
    public static AbstractC10482g m64431g(Context context, PushCmdParser pushCmdParser, boolean z10, String str) {
        return m64432h(context, pushCmdParser, z10, null, false, str);
    }

    /* renamed from: h */
    public static AbstractC10482g m64432h(Context context, PushCmdParser pushCmdParser, boolean z10, Consumer<Location> consumer, boolean z11, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("LocateFactory", "getLocate");
        if (z10 && m64435k()) {
            C13981a.m83989i("LocateFactory", "there still locate task running");
            return new C10478c(pushCmdParser, context);
        }
        C10484i c10484i = new C10484i();
        C13811a.m82785C(context, z10, str);
        boolean zM82847r = C13812b.m82847r(context, "network");
        boolean zM82846q = C13812b.m82846q(context);
        if (AbstractC12139d.m72769h(context)) {
            m64438n(context, pushCmdParser, c10484i, consumer, z11);
        }
        m64441q(context);
        AbstractC10482g abstractC10482gM64433i = z10 ? m64433i(context, pushCmdParser, zM82847r, zM82846q) : new C10490o(pushCmdParser, context);
        abstractC10482gM64433i.m64455G0(c10484i);
        abstractC10482gM64433i.m64476w0(consumer);
        m64426b(abstractC10482gM64433i);
        return abstractC10482gM64433i;
    }

    /* renamed from: i */
    public static AbstractC10482g m64433i(Context context, PushCmdParser pushCmdParser, boolean z10, boolean z11) {
        if (!AbstractC12139d.m72769h(context)) {
            C13981a.m83989i("LocateFactory", "Receive PushCmd and executeCmd, G_Locate");
            return new C10479d(pushCmdParser, context);
        }
        if (!z10 && !z11) {
            C13981a.m83989i("LocateFactory", "Receive PushCmd and executeCmd, BaiduLocate");
            return new C10477b(pushCmdParser, context, true);
        }
        boolean zM26239j = C4347e.m26239j(context);
        boolean zM1333z1 = C0209d.m1333z1(context);
        C13981a.m83989i("LocateFactory", "hasNetWorkCapacity:" + z10 + ", locationEnabled:" + z11 + ", isNetWorkConnected:" + zM1333z1 + ", isRebootLocked:" + zM26239j);
        if (C0219i.m1463a() < 16 && zM1333z1 && zM26239j) {
            C13981a.m83989i("LocateFactory", "Receive PushCmd and executeCmd,hasNetWork BaiduLocate");
            return new C10477b(pushCmdParser, context, true);
        }
        C13981a.m83989i("LocateFactory", "Receive PushCmd and executeCmd,hasNetWork G_Locate");
        return new C10479d(pushCmdParser, context);
    }

    /* renamed from: j */
    public static AbstractC10482g m64434j(Context context, PushCmdParser pushCmdParser) {
        if (m64436l()) {
            C13981a.m83989i("LocateFactory", "there still share locate task running");
            return new C10478c(pushCmdParser, context);
        }
        C13811a.m82801S(context);
        C10494s c10494s = new C10494s(pushCmdParser, context);
        c10494s.m7421I();
        m64427c(c10494s);
        return c10494s;
    }

    /* renamed from: k */
    public static boolean m64435k() {
        return f50512a.size() != 0;
    }

    /* renamed from: l */
    public static boolean m64436l() {
        return f50513b.size() != 0;
    }

    /* renamed from: m */
    public static /* synthetic */ void m64437m(Context context, PushCmdParser pushCmdParser, boolean z10, C10484i c10484i, Consumer consumer) {
        if (C13812b.m82847r(context, "network")) {
            return;
        }
        C13981a.m83988e("LocateFactory", "lbs provider off -> bd loc.");
        C10477b c10477b = new C10477b(pushCmdParser, context, false);
        c10477b.m64453E0(z10);
        c10477b.m64455G0(c10484i);
        c10477b.m64476w0(consumer);
        c10477b.mo7440z();
        m64426b(c10477b);
    }

    /* renamed from: n */
    public static void m64438n(final Context context, final PushCmdParser pushCmdParser, final C10484i c10484i, final Consumer<Location> consumer, final boolean z10) {
        new Handler().postDelayed(new Runnable() { // from class: if.e
            @Override // java.lang.Runnable
            public final void run() {
                C10481f.m64437m(context, pushCmdParser, z10, c10484i, consumer);
            }
        }, 3000L);
    }

    /* renamed from: o */
    public static void m64439o(Context context, AbstractC10482g abstractC10482g, boolean z10) {
        C13981a.m83989i("LocateFactory", "removeLocateTask,needResetLocConfig :" + z10);
        if (abstractC10482g != null && f50512a.size() > 0) {
            f50512a.remove(abstractC10482g);
            if (f50512a.size() == 0) {
                C13981a.m83989i("LocateFactory", "taskList is empty");
                if (z10) {
                    C13811a.m82793K(context);
                    C13811a.m82795M(context);
                }
                C13811a.m82790H();
                C13811a.m82809f(context, false, abstractC10482g.mo64471r0());
            }
        }
        C13811a.m82798P(context, false);
    }

    /* renamed from: p */
    public static void m64440p(Context context, AbstractC10482g abstractC10482g) {
        C13981a.m83989i("LocateFactory", "removeShareLocateTask.");
        if (abstractC10482g != null && f50513b.size() > 0) {
            f50513b.remove(abstractC10482g);
            if (f50513b.size() == 0) {
                C13981a.m83989i("LocateFactory", "shareLocateTaskList is empty");
                C13811a.m82790H();
                C13811a.m82809f(context, false, true);
            }
        }
        C13811a.m82798P(context, false);
    }

    /* renamed from: q */
    public static void m64441q(Context context) {
        C12795b.m76767c(context);
    }
}
