package com.huawei.android.hicloud.router.impl;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.huawei.android.hicloud.common.push.C2760a;
import com.huawei.android.hicloud.common.receiver.AlarmNotifyReceiver;
import com.huawei.android.hicloud.commonlib.space.QuotaInfoRsp;
import com.huawei.android.hicloud.manager.C2810a;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import gp.C10028c;
import io.C10582a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import lc.C11268b;
import mc.C11436a;
import p015ak.C0209d;
import p015ak.C0213f;
import p223db.C9062b;
import p232dp.InterfaceC9285d;
import p258ei.C9494c;
import p330h8.C10128f;
import p335hd.C10145h;
import p335hd.C10147j;
import p387j7.C10718a;
import p429kk.C11058a;
import p448l9.C11262a;
import p454lj.C11296s;
import p514o9.C11839m;
import p572qb.C12302c0;
import p572qb.C12314i0;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p681uj.C13195l;
import p703v8.C13377n;
import p703v8.C13378o;
import p742wj.C13612b;
import p766x8.C13731j;
import p836z8.C14157f;

/* renamed from: com.huawei.android.hicloud.router.impl.a */
/* loaded from: classes3.dex */
public class C2873a implements InterfaceC9285d {

    /* renamed from: a */
    public C10718a f12721a;

    /* renamed from: com.huawei.android.hicloud.router.impl.a$a */
    public static class a extends AbstractC12367d {

        /* renamed from: a */
        public String f12722a;

        /* renamed from: b */
        public boolean f12723b;

        public a(String str, boolean z10) {
            this.f12722a = str;
            this.f12723b = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (C13612b.m81829B().isLogin()) {
                new C10582a(C11058a.m66627b("07006")).m64932d0(this.f12722a, this.f12723b);
                new C11262a().m67604h(C0213f.m1377a());
            }
        }
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: A */
    public int mo17164A(Context context, int i10, String str) {
        return C2810a.m16477m().m16501n(context, i10, str);
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: B */
    public void mo17165B(Context context, String str, int i10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent(context.getApplicationContext(), (Class<?>) AlarmNotifyReceiver.class);
        intent.setAction(str);
        alarmManager.cancel(PendingIntent.getBroadcast(context.getApplicationContext(), i10, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK));
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: C */
    public void mo17166C() {
        C10718a c10718a = this.f12721a;
        if (c10718a != null) {
            c10718a.m65430k();
        }
    }

    /* renamed from: D */
    public final void m17167D(String str, boolean z10) {
        C12515a.m75110o().m75172d(new a(str, z10));
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: a */
    public void mo17168a() {
        C10718a c10718a = this.f12721a;
        if (c10718a != null) {
            c10718a.m65431l();
        }
    }

    @Override // p232dp.InterfaceC9285d
    public void activeCloud(String str) {
        C12314i0.m74036h().activeCloud(str);
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: b */
    public void mo17169b(Context context, long j10, String str) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager != null) {
            long jCurrentTimeMillis = System.currentTimeMillis() + j10;
            C11839m.m70688i("CloudSyncRouterImplDeprecated", "need retry, alarm trigger at " + jCurrentTimeMillis);
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) AlarmNotifyReceiver.class);
            intent.setAction(str);
            alarmManager.set(0, jCurrentTimeMillis, PendingIntent.getBroadcast(context, 0, intent, 1073741824));
        }
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: c */
    public void mo17170c(String str) {
        C12515a.m75110o().m75175e(new C12302c0(str), false);
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: d */
    public void mo17171d(Context context) {
        C12515a.m75110o().m75172d(new C10145h(context, false));
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: e */
    public void mo17172e() {
        C11268b.m67619i().m67620e();
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: f */
    public void mo17173f(Context context) {
        C9062b.m57146k().m57155h(false, false);
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: g */
    public void mo17174g(Context context, String str, boolean z10) {
        C11839m.m70688i("CloudSyncRouterImplDeprecated", "processPushToken");
        C13612b.m81829B().m81869j0(context, str);
        C13612b.m81829B().m81868i0(context, System.currentTimeMillis());
        C10028c.m62182c0().m62332g3(System.currentTimeMillis());
        C10028c.m62182c0().m62327f3();
        C2760a.m15750M(context, str);
        C2760a.m15738A(context, str);
        m17167D(str, z10);
    }

    @Override // p232dp.InterfaceC9285d
    public String getParam(String str, String str2, String str3) {
        return C14157f.m84942g().m84948h(str, str2, str3);
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: h */
    public QuotaSpaceInfo mo17175h() {
        return new C13377n().m80306b();
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: i */
    public void mo17176i(String str) {
        C11268b.m67619i().m67627m(str);
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: j */
    public boolean mo17177j(List<String> list, List<String> list2, String str, int i10, LinkedHashMap<String, String> linkedHashMap) {
        return new C10128f().m63049i(list, list2, str, i10, linkedHashMap);
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: k */
    public void mo17178k(Context context, ArrayList<String> arrayList, String str, String str2) {
        C12515a.m75110o().m75172d(new C10147j(context, arrayList, str, str2));
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: l */
    public void mo17179l() {
        C12314i0.m74036h().finishActivity();
        C12314i0.m74036h().clearNotification();
        C12314i0.m74036h().m74050p();
        C12314i0.m74036h().m74051q(false);
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: m */
    public void mo17180m() {
        C12314i0.m74036h().m74050p();
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: n */
    public void mo17181n(Activity activity) {
        C10718a c10718a = new C10718a(activity);
        this.f12721a = c10718a;
        c10718a.m65432m("cloudSyncrouterImplDeprecated");
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: o */
    public QuotaInfoRsp mo17182o() {
        return new C13378o().m80309e();
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: p */
    public void mo17183p() {
        C11839m.m70688i("CloudSyncRouterImplDeprecated", "setExiterSyncDataLists null");
        C9062b.m57146k().m57162r(false, null);
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: q */
    public boolean mo17184q() {
        return C12314i0.m74036h().m74048n();
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: r */
    public void mo17185r(Activity activity) {
        C11436a.m68492d().m68499h(activity);
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: s */
    public void mo17186s(AppStatus appStatus) {
        C9494c.m59390r().m59395G(appStatus);
        C9494c.m59390r().m59400N(appStatus);
        if (C0209d.m1254f2(C0213f.m1377a())) {
            return;
        }
        C9494c.m59390r().m59405S(appStatus);
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: t */
    public void mo17187t(Activity activity, int i10, int i11, Intent intent) {
        if (i10 != 8903 || this.f12721a == null) {
            return;
        }
        C13195l.m79272J().m79297M(activity, this.f12721a.m65437v(), i11, intent);
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: u */
    public int mo17188u() {
        return C11296s.m67834r();
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: v */
    public int mo17189v() {
        return C11268b.m67619i().m67626l();
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: w */
    public int mo17190w() {
        return C11296s.m67842z();
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: x */
    public boolean mo17191x(Context context) {
        return C13731j.m82513c(context);
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: y */
    public void mo17192y(Context context, String str, int i10, long j10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent(context.getApplicationContext(), (Class<?>) AlarmNotifyReceiver.class);
        intent.setAction(str);
        alarmManager.setRepeating(0, System.currentTimeMillis() + j10, j10, PendingIntent.getBroadcast(context.getApplicationContext(), i10, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK));
    }

    @Override // p232dp.InterfaceC9285d
    /* renamed from: z */
    public void mo17193z(Context context, String str) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager != null) {
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) AlarmNotifyReceiver.class);
            intent.setAction(str);
            alarmManager.cancel(PendingIntent.getBroadcast(context, 0, intent, 1073741824));
        }
    }
}
