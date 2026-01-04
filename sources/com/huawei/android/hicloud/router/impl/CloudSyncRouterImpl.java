package com.huawei.android.hicloud.router.impl;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import bd.C1164a;
import com.huawei.android.hicloud.complexutil.C2782c;
import com.huawei.android.hicloud.complexutil.C2786g;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.p088ui.activity.CloudDiskMainActivity;
import com.huawei.android.hicloud.p088ui.activity.DriveAppMainActivity;
import com.huawei.android.hicloud.p088ui.activity.NotepadMainActivity;
import com.huawei.android.hicloud.sync.protocol.PIMOperation;
import com.huawei.android.hicloud.sync.service.aidl.ICDServiceProtocol;
import com.huawei.android.hicloud.sync.service.aidl.ICSServiceProtocol;
import com.huawei.android.hicloud.sync.service.aidl.ServiceSyncLogicUtil;
import com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.hicloud.sync.syncutil.C2973b;
import com.huawei.android.hicloud.sync.syncutil.C2974c;
import com.huawei.android.hicloud.sync.syncutil.C2982k;
import com.huawei.android.hicloud.sync.syncutil.C2985n;
import com.huawei.android.hicloud.sync.syncutil.C2986o;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.hicloud.base.bean.ExiterSyncData;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import gp.C10028c;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import je.C10812z;
import md.C11440c;
import p232dp.InterfaceC9284c;
import p286fd.C9683a;
import p286fd.C9684b;
import p426kd.AsyncTaskC11035i;
import p426kd.AsyncTaskC11037k;
import p426kd.C11032f;
import p514o9.C11839m;
import p516ob.C11845a;
import p572qb.C12303d;
import p573qc.C12338d;
import p574qd.C12341a;
import p581qk.AbstractC12367d;
import p608rb.C12486b;
import p609rc.C12487a;
import p616rk.C12515a;
import p732w8.AsyncTaskC13548a;
import p732w8.AsyncTaskC13550b;
import p732w8.AsyncTaskC13558i;
import p732w8.AsyncTaskC13563n;
import p732w8.AsyncTaskC13565p;
import p732w8.AsyncTaskC13567r;
import p732w8.AsyncTaskC13568s;
import p770xc.C13744g;
import sc.C12772e;
import tc.C13007b;

/* loaded from: classes3.dex */
public class CloudSyncRouterImpl implements InterfaceC9284c {

    /* renamed from: a */
    public ServiceSyncLogicUtil f12719a;

    public static class ClearCloudSyncInfoTask extends AbstractC12367d {

        /* renamed from: a */
        public Context f12720a;

        public ClearCloudSyncInfoTask(Context context) {
            this.f12720a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70688i("CloudSyncRouterImpl", "processOnLogin clearCloudSyncInfo.");
            C1164a.m7265f().m7273j();
            C13007b c13007bM78205Y = C13007b.m78205Y(this.f12720a);
            for (String str : SyncObserverServiceInvoker.getInstance().getAllSyncType()) {
                c13007bM78205Y.m78262h(str);
                c13007bM78205Y.m78264i(str);
            }
        }
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: A */
    public void mo17079A(Context context, Messenger messenger) {
        AsyncTaskC13568s asyncTaskC13568sM81549b = AsyncTaskC13568s.m81549b(context, messenger, null);
        if (AsyncTask.Status.RUNNING.equals(asyncTaskC13568sM81549b.getStatus())) {
            return;
        }
        asyncTaskC13568sM81549b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: A0 */
    public String mo17080A0(String str) {
        try {
            return DriveSyncUtil.m17958C(str);
        } catch (Exception e10) {
            C11839m.m70687e("CloudSyncRouterImpl", "getSyncTypeDataBaseId exception:" + e10.toString());
            return "";
        }
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: B */
    public void mo17081B(Context context, Handler handler, boolean z10) {
        C12515a.m75110o().m75172d(new C11032f(context, handler, z10));
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: B0 */
    public void mo17082B0(int i10, int i11) {
        ICSServiceProtocol.getInstance().doSyncContact(new SyncType(16, i10, i11));
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: C */
    public void mo17083C(Context context, String str) {
        CloudSyncUtil.m16033o(context, str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: C0 */
    public boolean mo17084C0(Context context) {
        return SyncObserverServiceInvoker.getInstance().hasSyncSwitchOn(context);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: D */
    public int mo17085D(Context context, Messenger messenger) {
        return AsyncTaskC13567r.m81544c(context, messenger, null).m81545a();
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: D0 */
    public Map<String, Integer> mo17086D0() {
        return SyncObserverServiceInvoker.getInstance().getSyncSwitchStatus();
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: E */
    public void mo17087E(Context context, String str, int i10) throws Throwable {
        SyncObserverServiceInvoker.getInstance().notifyDriveConfigSwitchChanged(context, str, i10);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: E0 */
    public void mo17088E0(int i10) {
        SyncObserverServiceInvoker.getInstance().startContactSync(i10);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: F */
    public void mo17089F(Context context, String str, int i10) {
        C13007b.m78205Y(context).m78223I0(str, i10);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: F0 */
    public void mo17090F0(Context context, String str) throws InterruptedException {
        SyncObserverServiceInvoker.getInstance().retainSyncData(context, str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: G */
    public void mo17091G(String str) {
        C12338d.m74195s().m74229g0(str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: G0 */
    public void mo17092G0(Context context, String str, int i10, int i11, String str2) {
        SyncObserverServiceInvoker.getInstance().stopCalendarSync(context, str, i10, i11, str2);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: H */
    public int mo17093H(Context context, Messenger messenger) {
        return AsyncTaskC13565p.m81536c(context, messenger, null, null).m81537a();
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: I */
    public void mo17094I(Context context, String str, int i10, int i11, String str2) {
        SyncObserverServiceInvoker.getInstance().stopWlanSync(context, str, i10, i11, str2);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: J */
    public void mo17095J() {
        C11845a.m70916c();
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: K */
    public List<String> mo17096K(Context context) {
        return SyncObserverServiceInvoker.getInstance().getAllOpenSyncTypes(context);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: L */
    public void mo17097L(String str) {
        new C12772e().m76658l(str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: M */
    public void mo17098M(Context context, String str) {
        SyncObserverServiceInvoker.getInstance().startService(context, str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: N */
    public void mo17099N(Context context, String str, int i10, String str2) {
        SyncObserverServiceInvoker.getInstance().startFrameworkSync(context, str, i10, str2);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: O */
    public void mo17100O(Context context, String str, int i10, int i11, String str2) {
        SyncObserverServiceInvoker.getInstance().stopContactSyncWithAIDL(context, str, i10, i11, str2);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: P */
    public void mo17101P(Context context, boolean z10) {
        C12515a.m75110o().m75175e(new C9684b(context, null, z10), false);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: Q */
    public boolean mo17102Q(String str, int i10) {
        C11839m.m70688i("CloudSyncRouterImpl", "stopSync: " + str + ", syncErrorCode: " + i10);
        return C11440c.m68542u(str, i10);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: R */
    public int mo17103R(Context context, String str, String str2) {
        return new PIMOperation(context, str, str2).m17702b("pimds.drop.note", "notepad");
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: S */
    public void mo17104S(Context context, String str) {
        C11839m.m70688i("CloudSyncRouterImpl", "resetLostRefund");
        C2985n.m17940j(context, str);
        C2985n.m17941k(context, str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: T */
    public boolean mo17105T(Context context) {
        return SyncObserverServiceInvoker.getInstance().isCloudSyncSwitchOpen(context);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: U */
    public void mo17106U(Context context, String str, String str2) {
        C2974c.m17828d(context, str, str2);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: V */
    public boolean mo17107V(String str) {
        return C2982k.m17899d().m17901e(str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: W */
    public void mo17108W(Context context) {
        C12487a.m74966b(context);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: X */
    public void mo17109X(Context context, boolean z10) {
        SyncObserverServiceInvoker.getInstance().registerGalleryAtlasSwitch(context, z10);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: Y */
    public void mo17110Y(Context context) {
        SyncObserverServiceInvoker.getInstance().startWlanSync(context);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: Z */
    public void mo17111Z(Context context, String str) {
        SyncObserverServiceInvoker.getInstance().stopService(context, str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: a */
    public void mo17112a(Context context, String str, boolean z10) {
        SyncObserverServiceInvoker.getInstance().notifySyncSwitchChanged(context, str, z10);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: a0 */
    public void mo17113a0(Context context, int i10, String str) {
        SyncObserverServiceInvoker.getInstance().startBrowserSync(context, i10, str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: b */
    public void mo17114b(Context context, String str, String str2, int i10) {
        C2974c.m17829e(context, str, str2, i10);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: b0 */
    public int mo17115b0(String str, int i10, String str2) {
        return SyncObserverServiceInvoker.getInstance().setSyncSwitchStatus(str, i10, str2);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: c */
    public void mo17116c(String str) throws InterruptedException {
        CloudSyncUtil.m16042r(str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: c0 */
    public int mo17117c0() {
        C11839m.m70688i("CloudSyncRouterImpl", "getQuotaNormalContactNum");
        return CloudSyncUtil.m15963M();
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: d */
    public void mo17118d(Context context) {
        SyncObserverServiceInvoker.getInstance().stopService(context);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: d0 */
    public void mo17119d0(Context context, Messenger messenger) throws RemoteException {
        AsyncTaskC13548a asyncTaskC13548aM81474c = AsyncTaskC13548a.m81474c(context, messenger);
        if (!AsyncTask.Status.RUNNING.equals(asyncTaskC13548aM81474c.getStatus())) {
            asyncTaskC13548aM81474c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 1041;
        try {
            messenger.send(messageObtain);
        } catch (RemoteException e10) {
            C11839m.m70687e("CloudSyncRouterImpl", "deleteCalllogRecord RemoteException:" + e10.toString());
        }
    }

    @Override // p232dp.InterfaceC9284c
    public void doBackupPhoneManager() {
        ICDServiceProtocol.getInstance().doBackupPhoneManager();
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: e */
    public void mo17120e(Context context) {
        ICSServiceProtocol.getInstance().init(context);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: e0 */
    public boolean mo17121e0() {
        return SyncObserverServiceInvoker.getInstance().hasContactLocalData();
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: f */
    public void mo17122f(Context context, String str, int i10) {
        try {
            if (this.f12719a == null) {
                this.f12719a = new ServiceSyncLogicUtil(context);
            }
            this.f12719a.processPushMsg(i10, str);
        } catch (Exception e10) {
            C11839m.m70687e("CloudSyncRouterImpl", "pushReceiveMsg error: " + e10.getMessage());
        }
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: f0 */
    public void mo17123f0(Context context, String str) {
        C2986o.m17946c(context, str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: g */
    public void mo17124g(Context context, Handler handler, List<ExiterSyncData> list, String str) {
        C12515a.m75110o().m75172d(new C12341a(context, handler, list, str));
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: g0 */
    public boolean mo17125g0(String str) {
        return C11440c.m68533k(str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: h */
    public List<String> mo17126h(Context context) {
        return C2782c.m16068f(context);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: h0 */
    public void mo17127h0(Context context, String str, int i10, int i11, String str2) {
        SyncObserverServiceInvoker.getInstance().stopContactSync(context, str, i10, i11, str2);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: i */
    public void mo17128i(Context context) {
        C12515a.m75110o().m75175e(new ClearCloudSyncInfoTask(context), true);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: i0 */
    public void mo17129i0(int i10, int i11) {
        ICSServiceProtocol.getInstance().doSyncWlan(new SyncType(SyncType.WLAN_CHANGE, i10, i11));
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: j */
    public void mo17130j(Context context, String str) {
        C12515a.m75110o().m75175e(new C9683a(context, str), false);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: j0 */
    public void mo17131j0(boolean z10, int i10) {
        C11440c.m68526b(z10, i10);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: k */
    public void mo17132k(Context context, Bundle bundle) {
        Intent intent = new Intent(context, (Class<?>) CloudDiskMainActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: k0 */
    public void mo17133k0(Context context, String str) {
        SyncObserverServiceInvoker.getInstance().stopService(context, str);
        C10028c.m62182c0().m62336h2(str, false);
        C12338d.m74195s().m74229g0("dsswitch");
        C11440c.m68528e(str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: l */
    public void mo17134l(Context context, String str, int i10, String str2, String str3, String str4, String str5, LinkedHashMap<String, String> linkedHashMap) {
        C10812z.m65846o(context, str, i10, str2, str3, str4, str5, linkedHashMap, false);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: l0 */
    public void mo17135l0(Context context, Handler handler, String str, String str2, int i10) {
        C12515a.m75110o().m75172d(new C13744g(context, handler, str, str2, i10));
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: m */
    public void mo17136m(Context context, int i10, String str) {
        SyncObserverServiceInvoker.getInstance().startSync(context, i10, str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: m0 */
    public void mo17137m0(Context context, String str, String str2) {
        CloudSyncUtil.m16001d0(context, str, str2);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: n */
    public int mo17138n(Context context, Messenger messenger) {
        return AsyncTaskC13558i.m81505c(context, messenger, null).m81506a();
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: n0 */
    public void mo17139n0(Context context, String str, boolean z10) {
        CloudSyncUtil.m15984W0(context, str, z10);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: o */
    public void mo17140o(Context context, Handler handler) {
        AsyncTaskC11035i asyncTaskC11035iM66534e = AsyncTaskC11035i.m66534e(context, handler);
        if (AsyncTask.Status.RUNNING.equals(asyncTaskC11035iM66534e.getStatus())) {
            return;
        }
        asyncTaskC11035iM66534e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: o0 */
    public void mo17141o0(Context context, String str, int i10, int i11, String str2) {
        SyncObserverServiceInvoker.getInstance().stopFrameworkSync(context, str, i10, i11, str2);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: p */
    public boolean mo17142p(Context context, Messenger messenger) {
        AsyncTaskC11037k asyncTaskC11037kM66546f = AsyncTaskC11037k.m66546f(context, messenger);
        long jCurrentTimeMillis = System.currentTimeMillis() - C10028c.m62183d0(context).m62247N("get_notepad_history_time");
        if (AsyncTask.Status.RUNNING.equals(asyncTaskC11037kM66546f.getStatus()) || jCurrentTimeMillis <= 86400000) {
            return false;
        }
        asyncTaskC11037kM66546f.execute(new Void[0]);
        return true;
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: p0 */
    public int mo17143p0(Context context, String str) {
        return C13007b.m78205Y(context).m78238Q(str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: q */
    public boolean mo17144q(Context context, CountDownLatch countDownLatch) {
        return C2782c.m16067e(context, countDownLatch);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: q0 */
    public void mo17145q0(Context context, int i10, String str) {
        SyncObserverServiceInvoker.getInstance().startNotepadSync(context, i10, str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: r */
    public void mo17146r(Context context, String str) {
        C2973b.m17814b(context, str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: r0 */
    public List<String> mo17147r0(Context context) {
        return C2782c.m16066d(context);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: s */
    public List<String> mo17148s() {
        return SyncObserverServiceInvoker.getInstance().getAllSyncType();
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: s0 */
    public void mo17149s0() {
        C11845a.m70915b();
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: t */
    public void mo17150t(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) DriveAppMainActivity.class);
        intent.putExtra("entry_service_id", str);
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        context.startActivity(intent);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: t0 */
    public void mo17151t0() {
        C11839m.m70688i("CloudSyncRouterImpl", "applySyncPowerKit");
        C12303d.m73958f().m73959d("user-contact_sync_apply", new C12486b());
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: u */
    public void mo17152u(int i10) {
        C11440c.m68541t(SyncObserverServiceInvoker.getInstance().getAllSyncType(), i10);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: u0 */
    public void mo17153u0(Context context) {
        SyncObserverServiceInvoker.getInstance().startSync(context);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: v */
    public void mo17154v(Context context, int i10, String str) {
        SyncObserverServiceInvoker.getInstance().startCalendarSync(context, i10, str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: v0 */
    public void mo17155v0(Context context) {
        SyncObserverServiceInvoker.getInstance().startService(context);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: w */
    public void mo17156w(String str) {
        C2786g.m16221j(str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: w0 */
    public void mo17157w0(Context context, String str, int i10, int i11, String str2) {
        SyncObserverServiceInvoker.getInstance().stopNotepadSync(context, str, i10, i11, str2);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: x */
    public void mo17158x(Context context, String str, int i10, int i11, String str2) {
        SyncObserverServiceInvoker.getInstance().stopBrowserSync(context, str, i10, i11, str2);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: x0 */
    public void mo17159x0(Context context, int i10, String str) {
        SyncObserverServiceInvoker.getInstance().startContactSyncWithAIDL(context, i10, str);
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: y */
    public void mo17160y(Context context) {
        context.startActivity(new Intent(context, (Class<?>) NotepadMainActivity.class));
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: y0 */
    public void mo17161y0(Context context, Messenger messenger) throws RemoteException {
        AsyncTaskC13550b asyncTaskC13550bM81489c = AsyncTaskC13550b.m81489c(context, messenger);
        if (!AsyncTask.Status.RUNNING.equals(asyncTaskC13550bM81489c.getStatus())) {
            asyncTaskC13550bM81489c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 1041;
        try {
            messenger.send(messageObtain);
        } catch (RemoteException e10) {
            C11839m.m70687e("CloudSyncRouterImpl", "deleteSmsRecord RemoteException:" + e10.toString());
        }
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: z */
    public int mo17162z(Context context, Messenger messenger, String str) {
        return AsyncTaskC13563n.m81517c(context, messenger, null, str).m81518a();
    }

    @Override // p232dp.InterfaceC9284c
    /* renamed from: z0 */
    public void mo17163z0(Context context, String str) {
        C2973b.m17822j(context, str);
    }
}
