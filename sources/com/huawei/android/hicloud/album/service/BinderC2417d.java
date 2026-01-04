package com.huawei.android.hicloud.album.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.SQLException;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.TransactionTooLargeException;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.ICloudAlbumSdkService;
import com.huawei.android.hicloud.album.service.logic.CloudAlbumSdkLogic;
import com.huawei.android.hicloud.album.service.logic.callable.QueryDeviceInfoListCallable;
import com.huawei.android.hicloud.album.service.logic.callable.ReportRisksCallable;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.AlbumUpdatedResult;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.FileDownloadStatus;
import com.huawei.android.hicloud.album.service.p075vo.GeneralAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.GroupMemberInfo;
import com.huawei.android.hicloud.album.service.p075vo.RiskInform;
import com.huawei.android.hicloud.album.service.p075vo.SettingParams;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.ShareReceiverData;
import com.huawei.android.hicloud.album.service.p075vo.SimplifyInfo;
import com.huawei.android.hicloud.album.service.p075vo.SmartAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.SmartTagData;
import com.huawei.android.hicloud.album.service.p075vo.Stat;
import com.huawei.android.hicloud.album.service.p075vo.SyncPrompt;
import com.huawei.android.hicloud.album.service.p075vo.UserSpace;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import com.huawei.android.hicloud.album.service.report.CommonOpsReport;
import com.huawei.android.hicloud.album.service.report.LocalDataReport;
import com.huawei.android.hicloud.album.service.report.OpsReport;
import com.huawei.android.hicloud.constant.CommonConstants;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.logic.DownloadPhotoBase;
import com.huawei.android.p069cg.logic.app.HmsSnsApp;
import com.huawei.android.p069cg.logic.manager.C2306b;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;
import com.huawei.android.p069cg.manager.CloudAlbumReFoundManager;
import com.huawei.android.p069cg.p072vo.SettingsProp;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.support.api.entity.sns.Group;
import com.huawei.hms.support.api.entity.sns.GroupMem;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import gp.C10028c;
import hk.C10278a;
import hu.C10343b;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import p009a8.C0063a;
import p009a8.C0064b;
import p009a8.C0067e;
import p009a8.C0068f;
import p009a8.C0070h;
import p009a8.C0074l;
import p009a8.C0076n;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p015ak.C0225l;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1124e;
import p031b7.C1136q;
import p032b8.C1143a;
import p032b8.C1144b;
import p032b8.C1145c;
import p037bp.C1270a;
import p220d8.C9049c;
import p232dp.InterfaceC9283b;
import p281f8.C9665b;
import p281f8.C9674k;
import p312g8.C9890a;
import p312g8.C9891b;
import p312g8.C9892c;
import p312g8.C9894e;
import p431ko.C11079e;
import p489n9.C11654a;
import p546p6.C12106s;
import p546p6.C12110w;
import p546p6.EnumC12107t;
import p568q6.C12289b;
import p572qb.C12297a;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p635s7.C12749o0;
import p664u0.C13108a;
import p681uj.C13195l;
import p684un.C13224c;
import p684un.C13230i;
import p709vj.C13452e;
import p765x7.C13719a;
import p801y7.C13916d;
import p837z9.C14163d;

/* renamed from: com.huawei.android.hicloud.album.service.d */
/* loaded from: classes2.dex */
public class BinderC2417d extends ICloudAlbumSdkService.Stub implements CallbackHandler {

    /* renamed from: a */
    public RemoteCallbackList<ICloudAlbumSdkServiceCallback> f11528a;

    /* renamed from: b */
    @SuppressLint({"HandlerLeak"})
    public Handler f11529b;

    /* renamed from: c */
    public HandlerThread f11530c;

    /* renamed from: d */
    public Context f11531d;

    /* renamed from: e */
    public CloudAlbumSdkLogic f11532e;

    /* renamed from: f */
    public e f11533f;

    /* renamed from: g */
    public HandlerThread f11534g;

    /* renamed from: h */
    public C9674k f11535h;

    /* renamed from: i */
    public C0063a f11536i;

    /* renamed from: j */
    public Handler f11537j;

    /* renamed from: k */
    public HandlerThread f11538k;

    /* renamed from: l */
    public boolean f11539l;

    /* renamed from: m */
    public volatile int f11540m = 0;

    /* renamed from: n */
    public volatile long f11541n = 0;

    /* renamed from: o */
    public volatile boolean f11542o = false;

    /* renamed from: com.huawei.android.hicloud.album.service.d$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Stat f11543a;

        /* renamed from: b */
        public final /* synthetic */ String f11544b;

        /* renamed from: c */
        public final /* synthetic */ int f11545c;

        /* renamed from: d */
        public final /* synthetic */ String f11546d;

        public a(Stat stat, String str, int i10, String str2) {
            this.f11543a = stat;
            this.f11544b = str;
            this.f11545c = i10;
            this.f11546d = str2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            new CommonOpsReport(BinderC2417d.this.f11531d).m15211E(this.f11543a.getSessionId(), this.f11544b, 0, "", this.f11545c, this.f11546d, false);
        }
    }

    /* renamed from: com.huawei.android.hicloud.album.service.d$b */
    public class b extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f11548a;

        public b(String str) {
            this.f11548a = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            new CommonOpsReport(BinderC2417d.this.f11531d).m15211E(OpsReport.m15254d(), "FuncCallHandlerTimeOut", 0, "", 0, this.f11548a, false);
        }
    }

    /* renamed from: com.huawei.android.hicloud.album.service.d$c */
    public class c extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f11550a;

        public c(String str) {
            this.f11550a = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            StringBuilder sb2 = new StringBuilder();
            try {
                Set<Thread> setKeySet = Thread.getAllStackTraces().keySet();
                C1120a.m6677i("CloudAlbumSdkServiceImpl", "funcCallHandlerThread allStackTraces size: " + setKeySet.size());
                int i10 = 0;
                for (Thread thread : setKeySet) {
                    if (Thread.State.BLOCKED == thread.getState()) {
                        StackTraceElement[] stackTrace = thread.getStackTrace();
                        ArrayList arrayList = new ArrayList(stackTrace.length);
                        Collections.addAll(arrayList, stackTrace);
                        String str = "blocked thread: " + thread.getId() + ", " + StringUtil.join(System.lineSeparator(), (List<String>) C0225l.m1579c(arrayList, new C2415b()));
                        C1120a.m6678w("CloudAlbumSdkServiceImpl", str);
                        sb2.append(System.lineSeparator());
                        sb2.append(str);
                        i10++;
                    }
                }
                C1120a.m6677i("CloudAlbumSdkServiceImpl", "funcCallHandlerThread blockSize: " + i10);
                sb2.append(System.lineSeparator());
                sb2.append("blockSize: ");
                sb2.append(i10);
            } catch (Exception e10) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "funcCallHandlerThread error: " + e10);
                sb2.append(System.lineSeparator());
                sb2.append("funcCallHandlerThread error: ");
                sb2.append(e10);
            }
            new CommonOpsReport(BinderC2417d.this.f11531d).m15211E(OpsReport.m15254d(), "FuncCallHandlerTimeOut", 0, "", 0, this.f11550a + ((Object) sb2), false);
        }
    }

    /* renamed from: com.huawei.android.hicloud.album.service.d$d */
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i10 = message.what;
            if (i10 < 9000 || i10 > 10000) {
                C1120a.m6678w("CloudAlbumSdkServiceImpl", "Not support msg id: " + i10);
                return;
            }
            int i11 = message.arg1;
            Bundle bundle = (Bundle) message.obj;
            int iBeginBroadcast = BinderC2417d.this.f11528a.beginBroadcast();
            if (CommonConstants.f12114a) {
                C1120a.m6675d("CloudAlbumSdkServiceImpl", "handleMessage count: " + iBeginBroadcast + ", content: " + BinderC2417d.this.m15083F(message));
            }
            for (int i12 = 0; i12 < iBeginBroadcast; i12++) {
                ICloudAlbumSdkServiceCallback iCloudAlbumSdkServiceCallback = (ICloudAlbumSdkServiceCallback) BinderC2417d.this.f11528a.getBroadcastItem(i12);
                if (i11 != 9202) {
                    try {
                        iCloudAlbumSdkServiceCallback.onResult(i10, bundle);
                    } catch (TransactionTooLargeException unused) {
                        BinderC2417d.this.m15088K(message);
                    } catch (RemoteException e10) {
                        if (BinderC2417d.this.f11539l && bundle != null) {
                            if (SyncSessionManager.m15153t().m15160G(bundle.getString("sessionId"))) {
                                SystemClock.sleep(3000L);
                                BinderC2417d.this.f11529b.sendMessage(Message.obtain(message));
                            }
                        }
                        C1120a.m6676e("CloudAlbumSdkServiceImpl", "handleMessage error,msg:" + i10 + ", " + e10.toString());
                    }
                } else {
                    C1120a.m6675d("CloudAlbumSdkServiceImpl", "applyBatch count: " + iBeginBroadcast + ", content: " + BinderC2417d.this.m15083F(message));
                    iCloudAlbumSdkServiceCallback.onApplyBatch(i10, bundle);
                }
            }
            BinderC2417d.this.f11528a.finishBroadcast();
        }
    }

    /* renamed from: com.huawei.android.hicloud.album.service.d$e */
    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i10 = message.what;
            C1120a.m6677i("CloudAlbumSdkServiceImpl", "funcCallHandlerThread start funcId = " + i10);
            BinderC2417d.this.f11540m = i10;
            BinderC2417d.this.f11541n = SystemClock.elapsedRealtime();
            if (i10 < 0 || i10 > 1000) {
                C1120a.m6678w("CloudAlbumSdkServiceImpl", "Not support function id: " + i10);
                BinderC2417d.this.f11541n = 0L;
                return;
            }
            try {
                C9891b.m61371d(BinderC2417d.this.f11532e, CloudAlbumSdkLogic.class, i10, (Bundle) message.obj);
            } catch (Exception e10) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "funcCallHandlerThread Exception " + e10);
            }
            BinderC2417d.this.f11541n = 0L;
            C1120a.m6677i("CloudAlbumSdkServiceImpl", "funcCallHandlerThread end funcId = " + i10);
        }
    }

    /* renamed from: com.huawei.android.hicloud.album.service.d$f */
    public class f extends Handler {
        public f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1120a.m6677i("CloudAlbumSdkServiceImpl", "PowerBackHandler msg: " + message.what);
            try {
                BinderC2417d.this.m15134w(message.what, (Bundle) message.obj);
            } catch (Exception e10) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "PowerBackHandler dealPowerControlMessage error: " + e10);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.album.service.d$g */
    public class g extends AbstractC12367d {
        public g() {
        }

        /* renamed from: c */
        public final void m15140c() {
            if (CloudAlbumSettings.m14363h().m14376l()) {
                C12106s.m72509c().m72519k();
                return;
            }
            String strM15201z = SyncSessionManager.m15153t().m15201z();
            String strM15192p = SyncSessionManager.m15153t().m15192p();
            C1120a.m6677i("CloudAlbumSdkServiceImpl", "stopAllSync sessionId: " + strM15201z + ", cacheLockToken: " + strM15192p);
            if (TextUtils.isEmpty(strM15201z) || TextUtils.isEmpty(strM15192p)) {
                C1120a.m6678w("CloudAlbumSdkServiceImpl", "stopAllSync sessionId or cacheLockToken is null");
                return;
            }
            try {
                C1120a.m6677i("CloudAlbumSdkServiceImpl", "stopAllSync releaseSyncLock");
                C12749o0 c12749o0 = new C12749o0(BinderC2417d.this.f11531d, "", strM15192p);
                Bundle bundleM76583s = c12749o0.m76583s(c12749o0.mo76565p());
                new CommonOpsReport(BinderC2417d.this.f11531d).m15209C(strM15201z, c12749o0.m76584t(), bundleM76583s.getInt("code"), bundleM76583s.getString("info"));
            } catch (Exception e10) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "stopAllSync Unlock error: " + e10.toString());
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            BinderC2417d.this.m15128t(true);
            BinderC2417d.this.f11535h.m60405K(true);
            BinderC2417d.this.f11532e.stopAllTask(109);
            m15140c();
            BinderC2417d.this.syncOpsReport(SyncSessionManager.m15153t().m15201z(), 0, 109, null);
            SyncSessionManager.m15153t().m15184h();
            C0074l.m603c().m604a();
            C0067e.m443e().m455m();
            BinderC2417d.this.f11536i.m420m();
        }

        public /* synthetic */ g(BinderC2417d binderC2417d, a aVar) {
            this();
        }
    }

    public BinderC2417d(Context context, RemoteCallbackList<ICloudAlbumSdkServiceCallback> remoteCallbackList) {
        this.f11528a = null;
        this.f11529b = null;
        this.f11533f = null;
        this.f11537j = null;
        this.f11528a = remoteCallbackList;
        this.f11531d = context;
        HandlerThread handlerThread = new HandlerThread("AIDL_CALL", 10);
        this.f11534g = handlerThread;
        handlerThread.start();
        this.f11533f = new e(this.f11534g.getLooper());
        HandlerThread handlerThread2 = new HandlerThread("CALLBACK", 10);
        this.f11530c = handlerThread2;
        handlerThread2.start();
        this.f11529b = new d(this.f11530c.getLooper());
        HandlerThread handlerThread3 = new HandlerThread("POWER_CALL", 10);
        this.f11538k = handlerThread3;
        handlerThread3.start();
        this.f11537j = new f(this.f11538k.getLooper());
        C9674k c9674k = new C9674k(context, this);
        this.f11535h = c9674k;
        this.f11532e = new CloudAlbumSdkLogic(context, this, c9674k);
        this.f11535h.m60425o();
        C0068f.m459d().m467k();
        C0068f.m459d().m462f();
        this.f11536i = new C0063a(context, this);
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "funcCallHandlerThread " + this.f11534g.getThreadId() + ", callbackHandlerThread " + this.f11530c.getThreadId() + ", powerHandlerThread " + this.f11538k.getThreadId());
    }

    /* renamed from: A */
    public final int m15078A(int i10, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("k2", str2);
        bundle.putString("k1", str);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(i10, bundle));
        return 0;
    }

    /* renamed from: B */
    public final int m15079B(int i10, List<FileData> list, String str, String str2) {
        Bundle bundle = new Bundle();
        if (list == null) {
            bundle.putParcelableArrayList("k1", null);
        } else {
            bundle.putParcelableArrayList("k1", new ArrayList<>(list));
        }
        bundle.putString("k2", str);
        bundle.putString("k3", str2);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(i10, bundle));
        return 0;
    }

    /* renamed from: C */
    public final LinkedHashMap m15080C(String str, int i10, int i11, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uid", C13452e.m80781L().m80971t0());
        linkedHashMap.put("prepareTraceId", SyncSessionManager.m15153t().m15199x());
        linkedHashMap.put("traceId", str);
        linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
        linkedHashMap.put("startPlugged", m15133v0(SyncSessionManager.m15153t().m15188l().get("startPlugged")));
        linkedHashMap.put("endPlugged", m15135w0(C1122c.m6787h1(C0213f.m1377a())));
        linkedHashMap.put("startNetworkType", SyncSessionManager.m15153t().m15188l().get("startNetworkType"));
        linkedHashMap.put("endNetworkType", String.valueOf(C0209d.m1225Y(C0213f.m1377a())));
        linkedHashMap.put("startForgound", m15133v0(SyncSessionManager.m15153t().m15188l().get("startForgound")));
        linkedHashMap.put("endForeground", m15135w0(!C0070h.m527v().m542O()));
        String strValueOf = String.valueOf(i11);
        if (!"0".equals(strValueOf)) {
            strValueOf = "001_" + strValueOf;
        }
        linkedHashMap.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, strValueOf);
        linkedHashMap.put("errorReason", str2);
        if (SyncSessionManager.m15153t().m15188l().get("uploadSize") != null) {
            linkedHashMap.put("uploadSize", SyncSessionManager.m15153t().m15188l().get("uploadSize"));
        } else {
            linkedHashMap.put("uploadSize", "0");
        }
        if (SyncSessionManager.m15153t().m15188l().get("uploadCount") != null) {
            linkedHashMap.put("uploadCount", SyncSessionManager.m15153t().m15188l().get("uploadCount"));
            linkedHashMap.put("hasAssets", "1");
        } else {
            linkedHashMap.put("uploadCount", "0");
            linkedHashMap.put("hasAssets", "0");
        }
        linkedHashMap.put("incFlag", SyncSessionManager.m15153t().m15188l().get("incFlag"));
        linkedHashMap.put("startTime", SyncSessionManager.m15153t().m15188l().get("startTime"));
        linkedHashMap.put("endTime", String.valueOf(System.currentTimeMillis()));
        linkedHashMap.put("thirdAppVersion", C1122c.m6833t0(C0213f.m1377a()));
        linkedHashMap.put("source", String.valueOf(i10));
        linkedHashMap.put("prepareTimes", SyncSessionManager.m15153t().m15188l().get("prepareTimes"));
        linkedHashMap.put("firstStartTime", SyncSessionManager.m15153t().m15188l().get("firstStartTime"));
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "report end dots is：" + linkedHashMap.toString());
        return linkedHashMap;
    }

    /* renamed from: D */
    public final int m15081D(int i10) {
        String str = C9892c.m61373a().get(Integer.valueOf(i10));
        int iM60413c = this.f11535h.m60413c();
        C1120a.m6676e("CloudAlbumSdkServiceImpl", str + " failed to call because of a sync error! download ErrorCode: " + iM60413c + ", Error Message: " + this.f11535h.m60416f(iM60413c));
        return iM60413c;
    }

    /* renamed from: E */
    public final Integer m15082E(SmartTagData smartTagData, int i10) {
        if (smartTagData == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getChangeTagFilesInvalid params!");
            return 102;
        }
        if (m15120p(false, 3)) {
            return null;
        }
        return Integer.valueOf(m15086I(i10));
    }

    /* renamed from: F */
    public final String m15083F(Message message) {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("msg.what=");
        sb2.append(message.what);
        sb2.append(", bundle=");
        Object obj = message.obj;
        if (obj != null) {
            Bundle bundle = (Bundle) obj;
            for (String str : bundle.keySet()) {
                sb2.append(str);
                sb2.append("=");
                sb2.append(bundle.get(str));
                sb2.append(";");
            }
        }
        return sb2.toString();
    }

    /* renamed from: G */
    public final int m15084G(int i10) {
        String str = C9892c.m61373a().get(Integer.valueOf(i10));
        int iM60417g = this.f11535h.m60417g();
        C1120a.m6676e("CloudAlbumSdkServiceImpl", str + "callFunc ErrorCode: " + iM60417g + ", Error Message: " + this.f11535h.m60416f(iM60417g));
        return iM60417g;
    }

    /* renamed from: H */
    public String m15085H(int i10, int i11, String str) {
        if (i10 == 0) {
            C0070h.m527v().m572l0(this.f11532e);
            C0070h.m527v().m576n0(System.currentTimeMillis());
            C0070h.m527v().m582q0(false, 0);
            SyncSessionManager.m15153t().m15174U(i11);
            SyncSessionManager.m15153t().m15188l().put("startPlugged", String.valueOf(C1122c.m6787h1(C0213f.m1377a())));
            SyncSessionManager.m15153t().m15188l().put("startNetworkType", String.valueOf(C0209d.m1225Y(C0213f.m1377a())));
            SyncSessionManager.m15153t().m15188l().put("startTime", String.valueOf(System.currentTimeMillis()));
        } else if (i10 == 1) {
            C0074l.m603c().m613k(i11);
        }
        if (!m15120p(true, 2)) {
            int iM60414d = this.f11535h.m60414d();
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "cannot start sync" + iM60414d);
            if ((iM60414d != 107 && iM60414d != 1007) || i11 != 6) {
                return str;
            }
            this.f11535h.m60404J(!C0209d.m1254f2(this.f11531d));
            this.f11535h.m60403I(!C0209d.m1333z1(this.f11531d));
        }
        if (i10 == 0) {
            CloudAlbumSettings.m14363h().m14390z(1);
            str = OpsReport.m15254d();
            if (C0219i.f814b) {
                C1120a.m6677i("CloudAlbumSdkServiceImpl", "start apply SyncApply");
                if (C0070h.m527v().m539L()) {
                    C12297a.m73908c().m73909a("auto-album-sync_apply", new C1143a());
                } else {
                    C12297a.m73908c().m73909a("user-sync_apply", new C1145c());
                }
            }
            SyncSessionManager.m15153t().m15172S(str);
            SyncSessionManager.m15153t().m15174U(i11);
            SyncSessionManager.m15153t().m15173T(false);
            LocalDataReport.m15248g(this.f11531d);
        } else if (i10 == 1) {
            C0074l.m603c().m613k(i11);
            CloudAlbumSettings.m14363h().m14390z(2);
            str = OpsReport.m15257h();
            C0074l.m603c().m612j(str);
        } else if (i10 == 2) {
            str = OpsReport.m15258i();
        } else {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "Not support sessionType: " + i10);
        }
        if (!TextUtils.isEmpty(str)) {
            new CommonOpsReport(this.f11531d).m15212F(str, "startsync", i11, this.f11535h.m60412b(), false);
        }
        C0076n.m619a().m621c(i11);
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "Call AIDL: getSessionId, sessionType: " + i10 + ", syncType: " + i11 + ", traceId: " + str);
        return str;
    }

    /* renamed from: I */
    public final int m15086I(int i10) {
        String str = C9892c.m61373a().get(Integer.valueOf(i10));
        int iM60414d = this.f11535h.m60414d();
        C1120a.m6676e("CloudAlbumSdkServiceImpl", str + " failed to call because of a sync error! Sync ErrorCode: " + iM60414d + ", Error Message: " + this.f11535h.m60416f(iM60414d));
        return iM60414d;
    }

    /* renamed from: J */
    public void m15087J(int i10, boolean z10) {
        switch (i10) {
            case 1001:
                this.f11535h.m60399E(z10);
                break;
            case 1002:
                this.f11535h.m60407M(z10);
                break;
            case 1003:
            case 1006:
            default:
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "not support cmdId: " + i10);
                break;
            case 1004:
                this.f11535h.m60406L(z10);
                break;
            case 1005:
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "not support cmdId: " + i10);
                this.f11535h.m60401G(z10);
                break;
            case 1007:
                this.f11532e.stopUpload(165, true);
                break;
        }
    }

    /* renamed from: K */
    public final void m15088K(Message message) {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "handleTransactionTooLargeException");
        Message[] messageArrM61366d = C9890a.m61366d(message);
        if (messageArrM61366d.length <= 0) {
            return;
        }
        long j10 = 0;
        for (Message message2 : messageArrM61366d) {
            this.f11529b.sendMessageDelayed(message2, j10);
            j10 += 200;
        }
    }

    /* renamed from: L */
    public boolean m15089L() {
        if (!C13195l.m79272J().m79309Y()) {
            m15126s();
            return m15092O() || m15097T();
        }
        C1120a.m6678w("CloudAlbumSdkServiceImpl", "isCloudSyncNotAllowed for userId changed.");
        C1122c.m6768c2();
        return true;
    }

    /* renamed from: M */
    public final boolean m15090M() {
        return this.f11535h.m60431u();
    }

    /* renamed from: N */
    public boolean m15091N() {
        return C10028c.m62182c0().m62206E1();
    }

    /* renamed from: O */
    public final boolean m15092O() {
        return this.f11535h.m60432v();
    }

    /* renamed from: P */
    public final boolean m15093P(int i10, int i11) {
        if ((i10 != 107 && i10 != 1007) || i11 != 0 || !C0209d.m1254f2(this.f11531d)) {
            return true;
        }
        this.f11535h.m60404J(!C0209d.m1254f2(this.f11531d));
        this.f11535h.m60403I(!C0209d.m1333z1(this.f11531d));
        return false;
    }

    /* renamed from: Q */
    public final boolean m15094Q() {
        return this.f11535h.m60433w();
    }

    /* renamed from: R */
    public final boolean m15095R(List<FileData> list, int i10, int i11) {
        return list == null || list.isEmpty() || i10 < 0 || i10 > 2 || i11 < 0 || i11 > 2;
    }

    /* renamed from: S */
    public final boolean m15096S() {
        return Version.isSupportShareAlbumQuery() ? m15090M() || m15098U() : m15090M() || m15098U() || m15094Q();
    }

    /* renamed from: T */
    public final boolean m15097T() {
        return this.f11535h.m60434x();
    }

    /* renamed from: U */
    public final boolean m15098U() {
        return this.f11535h.m60435y();
    }

    /* renamed from: V */
    public final boolean m15099V() {
        return (SyncSessionManager.m15153t().m15162I() || C0074l.m603c().m609g()) ? false : true;
    }

    /* renamed from: W */
    public final /* synthetic */ void m15100W(int i10, int i11, String str, CompletableFuture completableFuture, UserDataStateInfo userDataStateInfo) {
        if (userDataStateInfo != null && userDataStateInfo.getBmType() != -1) {
            if (!TextUtils.isEmpty(userDataStateInfo.getBsGrade())) {
                C1120a.m6677i("CloudAlbumSdkServiceImpl", "bs grade:" + userDataStateInfo.getBsGrade());
                C13452e.m80781L().m80940l1(userDataStateInfo.getBsGrade());
            }
            if (userDataStateInfo.getBmType() == 1) {
                C13452e.m80781L().m80985w2(true);
                C1120a.m6677i("CloudAlbumSdkServiceImpl", "new bm type:true");
            } else if (userDataStateInfo.getBmType() == 0) {
                C1120a.m6677i("CloudAlbumSdkServiceImpl", "new bm type:false");
                C13452e.m80781L().m80985w2(false);
            }
            C1120a.m6677i("CloudAlbumSdkServiceImpl", "bm grade state and period: " + userDataStateInfo.getBmGradeState() + ", " + userDataStateInfo.getDataPeriod());
            C1136q.m6954L(userDataStateInfo.getBmGradeState());
            C1136q.m6953K(userDataStateInfo.getDataPeriod());
            C1136q.m6955M(System.currentTimeMillis());
        }
        completableFuture.complete(m15131u0(i10, i11, str));
    }

    /* renamed from: X */
    public final void m15101X(Bundle bundle) {
        if (bundle == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "notifyBatteryChanged bundle is null");
            return;
        }
        Intent intent = (Intent) new C10343b(bundle).m63690l("Intent");
        if (intent == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "notifyBatteryChanged intent is null");
        } else {
            intent.setAction("com.huawei.cg.action.SDK_BATTERY_CHANGE");
            C13108a.m78878b(this.f11531d).m78881d(intent);
        }
    }

    /* renamed from: Y */
    public final void m15102Y() {
        C13108a.m78878b(this.f11531d).m78881d(new Intent("com.huawei.cg.action.SDK_NET_CHANGE"));
    }

    /* renamed from: Z */
    public final boolean m15103Z() {
        boolean zM6791i1 = C1122c.m6791i1(C1136q.b.m7077m(this.f11531d));
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "powerUsage isCharging: " + zM6791i1);
        if (zM6791i1) {
            return false;
        }
        boolean zM542O = C0070h.m527v().m542O();
        long jM577o = C0070h.m527v().m577o();
        int iM583r = C0070h.m527v().m583r();
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "powerUsage needControl: " + zM542O + ", availablePower: " + jM577o + " controlType:" + iM583r);
        return Version.isSupportPowerControl() && zM542O && iM583r == 1 && jM577o == 0;
    }

    /* renamed from: a0 */
    public final void m15104a0(int i10, String str) {
        m15106c0(C9892c.m61373a().get(Integer.valueOf(i10)), str);
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int addShareReceiver(ShareAlbumData shareAlbumData, List<ShareReceiverData> list) throws RemoteException {
        m15104a0(42, null);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "addShareReceiver version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (shareAlbumData == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "addShareReceiver Invalid params!");
            return 102;
        }
        if (m15090M() || m15098U()) {
            return m15084G(42);
        }
        if (m15089L()) {
            return m15084G(42);
        }
        if (m15091N()) {
            m15108e0(42);
            return 138;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("k1", shareAlbumData);
        if (list == null) {
            bundle.putParcelableArrayList("k2", null);
        } else {
            bundle.putParcelableArrayList("k2", new ArrayList<>(list));
        }
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(42, bundle));
        return 0;
    }

    /* renamed from: b0 */
    public final void m15105b0(int i10, String str, String str2) {
        m15107d0(C9892c.m61373a().get(Integer.valueOf(i10)), str, str2);
    }

    /* renamed from: c0 */
    public final void m15106c0(String str, String str2) {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "Call AIDL: " + str + ", traceId: " + StringUtil.emptyIfBlank(str2));
    }

    @Override // com.huawei.android.hicloud.album.service.CallbackHandler
    public boolean canStartDownloading(boolean z10, int i10) {
        m15126s();
        if (z10) {
            if (i10 == 0) {
                return this.f11535h.m60423m() == C9674k.c.CAN_START_SYNC;
            }
            if ((Version.isSupportMobileData() && CloudAlbumSettings.m14363h().m14380p()) || CloudAlbumSettings.m14363h().m14379o()) {
                return this.f11535h.m60423m() == C9674k.c.CAN_START_SYNC;
            }
        }
        return this.f11535h.m60422l() == C9674k.c.CAN_START_SYNC;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int cancelDownload(List<FileData> list) throws RemoteException {
        m15104a0(73, null);
        if (list == null || list.isEmpty()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "cancelDownload: Invalid params!");
            return 102;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("k1", new ArrayList<>(list));
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(73, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int cancelDownloadAll() throws RemoteException {
        m15104a0(76, null);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(76));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int cancelReceivedShare(ShareAlbumData shareAlbumData) throws RemoteException {
        m15104a0(45, null);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "cancelReceivedShare version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (shareAlbumData == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "cancelReceivedShare Invalid params!");
            return 102;
        }
        if (!m15089L() && !m15089L()) {
            if (m15091N()) {
                m15108e0(45);
                return 138;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("k1", shareAlbumData);
            m15124r();
            e eVar = this.f11533f;
            eVar.sendMessage(eVar.obtainMessage(45, bundle));
            return 0;
        }
        return m15084G(45);
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int cancelUploadTask(String str) throws RemoteException {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "cancelUploadTask relativePath: " + str);
        if (!m15120p(false, 3)) {
            return m15086I(90);
        }
        C13916d.m83403m(this.f11531d, str, this, SyncType.OPEN_SWITCH_FROM_GUIDE);
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int checkAccount(List<String> list) throws RemoteException {
        m15104a0(10, null);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "checkAccount version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (list == null || list.isEmpty()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "checkAccount Invalid params!");
            return 102;
        }
        if (m15090M() || m15098U()) {
            return m15084G(10);
        }
        if (m15089L()) {
            return m15084G(10);
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("k1", new ArrayList<>(list));
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(10, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public void closeAlbumSwitch() throws RemoteException, SQLException {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "Call AIDL: closeAlbumSwitch");
        C0064b.m422c().m423a(this.f11531d, 1);
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int copyGeneralFiles(List<FileData> list, String str, String str2, long j10, long j11) throws RemoteException {
        m15105b0(36, "totalSpaceSize: " + j10 + ", useSpaceSize: " + j11, str2);
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "copyGeneralFiles: Invalid params!, lockToken: " + str);
            m15118o(str2, "copyGeneralFiles invalid params");
            return 102;
        }
        Iterator<FileData> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "copyGeneralFiles fileData is null");
                m15118o(str2, "copyGeneralFiles fileData is null");
                return 102;
            }
        }
        if (C12110w.m72533a().m72535c(list)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "downloadGeneralFiles restart sync");
            return 102;
        }
        if (!m15120p(false, 1)) {
            return m15086I(36);
        }
        if (m15091N()) {
            m15108e0(36);
            return 138;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("k1", new ArrayList<>(list));
        bundle.putString("k2", str);
        bundle.putString("k3", str2);
        bundle.putLong("k4", j10);
        bundle.putLong("k5", j11);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(36, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int createBatch(String str, String str2, String str3) throws RemoteException {
        m15104a0(82, str3);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "createBatch version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "createBatch: Invalid params!");
            return 102;
        }
        if (!m15120p(false, 0)) {
            return m15086I(82);
        }
        Bundle bundle = new Bundle();
        if (m15091N()) {
            m15108e0(82);
            return 138;
        }
        bundle.putString("k1", str);
        bundle.putString("k2", str2);
        bundle.putString("k3", str3);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(82, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int createGeneralAlbums(List<GeneralAlbumData> list, String str, String str2) throws RemoteException {
        m15104a0(17, str2);
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "createGeneralAlbums albums or lockToken is empty! Invalid params!");
            m15118o(str2, "createGeneralAlbums albums or lockToken is empty");
            return 102;
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        for (GeneralAlbumData generalAlbumData : list) {
            if (generalAlbumData == null || TextUtils.isEmpty(generalAlbumData.getAlbumId()) || TextUtils.isEmpty(generalAlbumData.getAlbumName())) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "createGeneralAlbums generalAlbumData is null or albumId / albumName is empty");
                m15118o(str2, "createGeneralAlbums generalAlbumData is null or albumId / albumName is empty");
                return 102;
            }
            if (SyncSessionManager.m15153t().m15155B("cloudphoto.album.batchcreate", str2, generalAlbumData.getAlbumId())) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "createGeneralAlbums: " + generalAlbumData.getAlbumId() + " too much error " + generalAlbumData.getLpath());
                arrayList2.add(generalAlbumData);
            } else {
                arrayList.add(generalAlbumData);
            }
        }
        if (!arrayList2.isEmpty()) {
            new CommonOpsReport(this.f11531d).m15209C(str2, "syncstate", 102, "createGeneralAlbums lpath exist too much" + ((GeneralAlbumData) arrayList2.get(0)).getLpath());
        }
        if (arrayList.isEmpty()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "createGeneralAlbums too much error");
            m15118o(str2, "createGeneralAlbums too much error");
            return 102;
        }
        if (!m15120p(false, 1)) {
            return m15086I(17);
        }
        if (m15091N()) {
            m15108e0(17);
            return 138;
        }
        Bundle bundle = new Bundle();
        bundle.putString("k2", str);
        bundle.putString("k3", str2);
        bundle.putParcelableArrayList("k1", arrayList);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(17, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int createGeneralFiles(List<FileData> list, String str, boolean z10, String str2) throws JSONException, RemoteException {
        int iM14513b;
        m15104a0(21, str2);
        if (C13452e.m80781L().m80791C0()) {
            C1120a.m6677i("CloudAlbumSdkServiceImpl", "sync permission:The basic data service user cannot createGeneralFiles.");
            C12289b.m73837b().m73841e();
            return FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED;
        }
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "createGeneralFiles: Invalid params!");
            m15118o(str2, "createGeneralFiles: Invalid params!");
            return 102;
        }
        int size = list.size();
        long size2 = 0;
        for (FileData fileData : list) {
            if (fileData == null) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "createGeneralFiles fileData is null");
                m15118o(str2, "createGeneralFiles fileData is null");
                return 102;
            }
            size2 += fileData.getSize();
        }
        try {
            String str3 = SyncSessionManager.m15153t().m15188l().get("uploadSize");
            String str4 = SyncSessionManager.m15153t().m15188l().get("uploadCount");
            if (str3 == null || str4 == null) {
                SyncSessionManager.m15153t().m15188l().put("uploadSize", String.valueOf(size2));
                SyncSessionManager.m15153t().m15188l().put("uploadCount", String.valueOf(size));
            } else {
                SyncSessionManager.m15153t().m15188l().put("uploadSize", String.valueOf(Long.parseLong(str3) + size2));
                SyncSessionManager.m15153t().m15188l().put("uploadCount", String.valueOf(Long.parseLong(str4) + size));
            }
        } catch (Exception unused) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "data type conversion exception.");
        }
        C0070h.m527v().m553Z(str2, list.size());
        C0070h.m527v().m550W();
        if (C0070h.m527v().m545R()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "createGeneralFiles, weak network");
            return 107;
        }
        C0070h.m527v().m551X();
        if (!m15120p(false, 1)) {
            return m15086I(21);
        }
        if (m15091N()) {
            m15108e0(21);
            return 138;
        }
        if (m15103Z()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "createGeneralFiles powerUsage");
            return 37;
        }
        C0070h.m527v().m549V();
        C1120a.m6675d("CloudAlbumSdkServiceImpl", "createGeneralFiles, files count: " + list.size());
        if (CloudAlbumSettings.m14363h().m14376l() && ((iM14513b = C2306b.m14512a().m14513b(str2)) == 50321 || iM14513b == 5032)) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "createGeneralFiles obs flow control: " + iM14513b);
            return iM14513b;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("k1", new ArrayList<>(list));
        bundle.putString("k2", str);
        bundle.putBoolean("k3", z10);
        bundle.putString("k4", str2);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(21, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int createShareAlbum(ShareAlbumData shareAlbumData) throws RemoteException {
        m15104a0(41, null);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "createShareAlbum version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (shareAlbumData == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "createShareAlbum Invalid params!");
            return 102;
        }
        if (m15090M() || m15098U()) {
            return m15084G(41);
        }
        if (m15089L()) {
            return m15084G(41);
        }
        if (m15091N()) {
            m15108e0(41);
            return 138;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("k1", shareAlbumData);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(41, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int createShareFiles(List<FileData> list, boolean z10, String str) throws JSONException, RemoteException {
        m15104a0(23, str);
        if (C13452e.m80781L().m80791C0()) {
            C1120a.m6677i("CloudAlbumSdkServiceImpl", "sync permission:The basic data service user cannot createShareFiles.");
            C12289b.m73837b().m73841e();
            return FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED;
        }
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "createShareFiles version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (list == null || list.isEmpty()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "createShareFiles: Invalid params!");
            return 102;
        }
        C0070h.m527v().m553Z(str, list.size());
        C0070h.m527v().m550W();
        if (C0070h.m527v().m545R()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "createShareFiles, weak network");
            return 107;
        }
        C0070h.m527v().m551X();
        if (!m15120p(false, 0)) {
            return m15086I(23);
        }
        C1120a.m6675d("CloudAlbumSdkServiceImpl", "createShareFiles, files count: " + list.size());
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("k1", new ArrayList<>(list));
        bundle.putBoolean("k2", z10);
        bundle.putString("k3", str);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(23, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int createShortLink(String str) throws RemoteException {
        m15104a0(46, null);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "createShortLink version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "createShortLink Invalid params!");
            return 102;
        }
        if (m15090M() || m15098U()) {
            return m15084G(46);
        }
        if (m15089L()) {
            return m15084G(46);
        }
        if (m15091N()) {
            m15108e0(46);
            return 138;
        }
        Bundle bundle = new Bundle();
        bundle.putString("k1", str);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(46, bundle));
        return 0;
    }

    /* renamed from: d0 */
    public final void m15107d0(String str, String str2, String str3) {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "Call AIDL: " + str + ", params: (" + str2 + "), traceId: " + StringUtil.emptyIfBlank(str3));
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int deleteDownloadHistory(List<FileData> list) {
        m15104a0(80, null);
        if (list != null && !list.isEmpty()) {
            return new C9049c(this.f11531d, this).m57064i(C9894e.m61401d(list, false, true));
        }
        C1120a.m6676e("CloudAlbumSdkServiceImpl", "Invalid params!");
        return 102;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int deleteDownloadHistoryAll(int i10) {
        m15104a0(81, null);
        if (i10 <= 0 || i10 >= 64) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "Invalid params!");
            return 102;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("k1", i10);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(81, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int deleteGeneralAlbums(List<String> list, String str, String str2) throws RemoteException {
        m15104a0(20, str2);
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "deleteGeneralAlbums albums is empty or lockToken isEmpty: " + TextUtils.isEmpty(str) + "Invalid params!");
            m15118o(str2, "deleteGeneralAlbums albums is null");
            return 102;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(it.next())) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "deleteGeneralAlbums albumId is null");
                m15118o(str2, "deleteGeneralAlbums albumId is null");
                return 102;
            }
        }
        if (!m15120p(false, 1)) {
            return m15086I(20);
        }
        if (m15091N()) {
            m15108e0(20);
            return 138;
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : list) {
            SyncSessionManager.m15153t().m15177a("cloudphoto.album.batchdelete", str2, str3);
            if (SyncSessionManager.m15153t().m15155B("cloudphoto.album.batchdelete", str2, str3)) {
                arrayList.add(str3);
            }
        }
        if (arrayList.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("k1", new ArrayList<>(list));
            bundle.putString("k2", str);
            bundle.putString("k3", str2);
            m15124r();
            e eVar = this.f11533f;
            eVar.sendMessage(eVar.obtainMessage(20, bundle));
            return 0;
        }
        C1120a.m6676e("CloudAlbumSdkServiceImpl", "deleteGeneralAlbums too frequently, albumIds: " + arrayList.toString());
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(new AlbumUpdatedResult(null, (String) it2.next(), 139, "delete the same albums."));
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("sessionId", str2);
        bundle2.putParcelableArrayList("AlbumUpdatedResultList", arrayList2);
        bundle2.putInt("code", 139);
        bundle2.putString("info", VastAttribute.ERROR);
        sendMessage(9123, bundle2);
        new CommonOpsReport(this.f11531d).m15209C(str2, "syncstate", 102, "deleteGeneralAlbums too frequently, albumIds:" + arrayList.toString());
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int deleteGeneralFiles(List<FileData> list, String str, String str2) throws RemoteException {
        m15104a0(24, str2);
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "deleteGeneralFiles files is null or empty, Invalid params!");
            m15118o(str2, "deleteGeneralFiles invalid params");
            return 102;
        }
        ArrayList arrayList = new ArrayList();
        for (FileData fileData : list) {
            if (fileData == null) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "deleteGeneralFiles fileData is null");
                m15118o(str2, "deleteGeneralFiles fileData is null");
                return 102;
            }
            if (TextUtils.isEmpty(fileData.getAlbumId()) || TextUtils.isEmpty(fileData.getUniqueId())) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "deleteGeneralFiles albumId or uniqueId is null, Invalid params!");
                m15118o(str2, "deleteGeneralFiles albumId or uniqueId is null");
                return 102;
            }
            String uniqueId = fileData.getUniqueId() != null ? fileData.getUniqueId() : fileData.getFileId();
            if (C1122c.m6815o1(uniqueId)) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "deleteGeneralFiles mediaId is invalid: " + uniqueId);
            } else {
                arrayList.add(fileData);
            }
        }
        if (arrayList.isEmpty()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "deleteGeneralFiles too much error and cause param error");
            m15118o(str2, "deleteGeneralFiles too much error and cause param error");
            return 102;
        }
        if (!m15120p(false, 1)) {
            return m15086I(24);
        }
        if (!m15091N()) {
            return m15079B(24, arrayList, str, str2);
        }
        m15108e0(24);
        return 138;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int deleteShareAlbum(ShareAlbumData shareAlbumData, String str) throws RemoteException {
        m15104a0(28, str);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "deleteShareAlbum version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (shareAlbumData == null || TextUtils.isEmpty(shareAlbumData.getShareId())) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "deleteShareAlbumInvalid params!");
            return 102;
        }
        if (!m15120p(false, 0)) {
            return m15086I(28);
        }
        if (m15091N()) {
            m15108e0(28);
            return 138;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("k1", shareAlbumData);
        bundle.putString("k2", str);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(28, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int deleteShareFiles(String str, String str2, List<FileData> list, String str3) throws RemoteException {
        m15104a0(29, str3);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "deleteShareFiles version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || list == null || list.isEmpty()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "deleteShareFiles: Invalid params!");
            return 102;
        }
        if (!m15120p(false, 0)) {
            return m15086I(29);
        }
        if (m15091N()) {
            m15108e0(29);
            return 138;
        }
        Bundle bundle = new Bundle();
        bundle.putString("k1", str);
        bundle.putString("k2", str2);
        bundle.putParcelableArrayList("k3", new ArrayList<>(list));
        bundle.putString("k4", str3);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(29, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int destroyGeneralTasks(int i10, int i11) {
        return m15138y(66, i10, i11);
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int destroyShareTasks(int i10, int i11) {
        return m15138y(67, i10, i11);
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int downloadAvatar(List<ShareReceiverData> list) throws RemoteException {
        m15104a0(49, null);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "downloadAvatar version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (list == null || list.isEmpty()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "downloadAvatar Invalid params!");
            return 102;
        }
        SettingsProp settingsPropM7118a = C1136q.c.m7118a(this.f11531d);
        String thumbCachePath = settingsPropM7118a.getThumbCachePath() != null ? settingsPropM7118a.getThumbCachePath() : C1124e.m6870n(this.f11531d);
        if (thumbCachePath == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "downloadAvatar saveConfigPath is null");
            return SyncType.AUTO_SYNC_CALLLOG;
        }
        File fileM63442h = C10278a.m63442h(thumbCachePath);
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "downloadAvatar mkdir error");
            return SyncType.AUTO_SYNC_RECORD;
        }
        File parentFile = fileM63442h.getParentFile();
        if (parentFile == null) {
            return SyncType.AUTO_SYNC_RECORD;
        }
        if (m15090M() || m15098U() || m15094Q()) {
            return m15084G(49);
        }
        if (m15089L()) {
            return m15084G(49);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("k1", new ArrayList<>(list));
        bundle.putString("k2", parentFile.toString());
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(49, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int downloadGeneralFiles(List<FileData> list, int i10, int i11, boolean z10, boolean z11, String str) throws RemoteException {
        m15104a0(15, str);
        if (m15095R(list, i10, i11)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "files is empty or thumbType/operationType is invalid! thumbType: " + i10 + ", operationType: " + i11 + " Invalid params!");
            return 102;
        }
        if (C13195l.m79272J().m79309Y()) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "can not download for userId changed.");
            C1122c.m6768c2();
            return 101;
        }
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "downloadGeneralFiles, files count: " + list.size() + ", thumbType: " + i10 + ", operationType" + i11 + ", forceDownload: " + z10 + ", needProgressEvent: " + z11 + ", sessionId: " + str);
        if (C12110w.m72533a().m72535c(list)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "downloadGeneralFiles restart sync");
            return 102;
        }
        for (FileData fileData : list) {
            if (fileData == null) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "A file is null! Invalid params!");
                return 102;
            }
            C1120a.m6675d("CloudAlbumSdkServiceImpl", "downloadGeneralFiles fileName: " + fileData.getFileName() + ", uniqueId: " + fileData.getUniqueId());
        }
        if (!canStartDownloading(z10, i10)) {
            int iM15081D = m15081D(15);
            if (m15093P(iM15081D, i10)) {
                return iM15081D;
            }
        }
        if (i10 == 0 && C1136q.b.m7054e0(this.f11531d)) {
            C1136q.b.m7093r0(this.f11531d, false);
        }
        m15122q(i10);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("k1", new ArrayList<>(list));
        bundle.putInt("k2", i10);
        bundle.putBoolean("k4", z10);
        bundle.putInt("k3", i11);
        bundle.putBoolean("k5", z11);
        bundle.putString("k6", str);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(15, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int downloadShareFiles(List<FileData> list, int i10, int i11, boolean z10, boolean z11, String str) throws RemoteException {
        m15104a0(16, str);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "downloadShareFiles version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (m15095R(list, i10, i11)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "files is empty or thumbType/operationType is invalid! thumbType: " + i10 + ", operationType: " + i11 + " Invalid params!");
            return 102;
        }
        if (C13195l.m79272J().m79309Y()) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "can not download for userId changed.");
            C1122c.m6768c2();
            return 101;
        }
        for (FileData fileData : list) {
            if (fileData == null) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "A file is null! Invalid params!");
                return 102;
            }
            C1120a.m6675d("CloudAlbumSdkServiceImpl", "downloadShareFiles fileName: " + fileData.getFileName() + ", uniqueId: " + fileData.getUniqueId());
        }
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "downloadShareFiles, files count: " + list.size() + ", thumbType: " + i10 + ", operationType :" + i11 + ", forceDownload: " + z10 + ", needProgressEvent: " + z11 + ", sessionId: " + str);
        if (!canStartDownloading(z10, i10)) {
            int iM15081D = m15081D(16);
            if (m15093P(iM15081D, i10)) {
                return iM15081D;
            }
        }
        if (i10 == 0 && C1136q.b.m7054e0(this.f11531d)) {
            C1136q.b.m7093r0(this.f11531d, false);
        }
        m15122q(i10);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("k1", new ArrayList<>(list));
        bundle.putInt("k2", i10);
        bundle.putInt("k3", i11);
        bundle.putBoolean("k4", z10);
        bundle.putBoolean("k5", z11);
        bundle.putString("k6", str);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(16, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int dropDownloadFileInfo() {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "Call AIDL: dropDownloadFileInfo");
        return 0;
    }

    /* renamed from: e0 */
    public final void m15108e0(int i10) {
        C1120a.m6676e("CloudAlbumSdkServiceImpl", C9892c.m61373a().get(Integer.valueOf(i10)) + "  Migrating");
    }

    /* renamed from: f0 */
    public final void m15109f0(String str, int i10) {
        if (!TextUtils.isEmpty(str) && str.startsWith("04007")) {
            C1120a.m6677i("CloudAlbumSdkServiceImpl", "release lock share sync sdk");
            C12106s.m72509c().m72520l(EnumC12107t.SHARE_SYNC_SDK);
            if (109 != i10) {
                CloudAlbumSettings.m14363h().m14389y(2);
                return;
            }
            return;
        }
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "release lock general sync sdk");
        C12106s.m72509c().m72520l(EnumC12107t.GENERAL_SYNC_SDK);
        CloudAlbumReFoundManager.m14515b().m14523i();
        this.f11536i.m420m();
        if (109 != i10) {
            CloudAlbumSettings.m14363h().m14389y(1);
        }
        if (i10 == 0) {
            C1136q.m6946D(SyncSessionManager.m15153t().m15194r());
            C1120a.m6677i("CloudAlbumSdkServiceImpl", "check guide switch notify");
            InterfaceC9283b interfaceC9283b = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
            if (interfaceC9283b != null) {
                interfaceC9283b.mo58522n0(this.f11531d);
            }
        }
        if (C0070h.m527v().m544Q()) {
            C1122c.m6756Z1();
        }
    }

    /* renamed from: g0 */
    public final void m15110g0(Stat stat) {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "uploadStat is :" + stat.toString());
        String strM80942m = C13452e.m80781L().m80942m();
        boolean zEqualsIgnoreCase = !TextUtils.isEmpty(strM80942m) ? "CN".equalsIgnoreCase(strM80942m) : false;
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "isChinaAccount :" + zEqualsIgnoreCase);
        if (zEqualsIgnoreCase) {
            boolean zM7066i0 = C1136q.b.m7066i0(this.f11531d);
            boolean zM7060g0 = C1136q.b.m7060g0(this.f11531d);
            boolean zM7063h0 = C1136q.b.m7063h0(this.f11531d);
            C1120a.m6677i("CloudAlbumSdkServiceImpl", "isIncrementalSync is :" + zM7063h0 + " localUpdated is :" + stat.getLocalAdded() + " isSyncCompleted :" + zM7066i0 + " isFirstSync :" + zM7060g0);
            if (zM7063h0 && stat.getLocalAdded() <= 0) {
                if (stat.getCloudNormal() + stat.getCloudRecycle() > 0) {
                    HiCloudSysParamMap hiCloudSysParamMapM6839v0 = C1122c.m6839v0();
                    long galleryReportFrequency = 86400000;
                    if (hiCloudSysParamMapM6839v0 == null || hiCloudSysParamMapM6839v0.getGalleryReportFrequency() == 0) {
                        C1120a.m6678w("CloudAlbumSdkServiceImpl", "configMap is null, getGalleryReportFrequency fail");
                    } else {
                        galleryReportFrequency = 86400000 * hiCloudSysParamMapM6839v0.getGalleryReportFrequency();
                    }
                    long jM7086p = C1136q.b.m7086p(this.f11531d);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    C1120a.m6677i("CloudAlbumSdkServiceImpl", "currentTime is: " + jCurrentTimeMillis + " lastReportTime is: " + jM7086p + " galleryReportFrequency is: " + galleryReportFrequency);
                    if (jCurrentTimeMillis - jM7086p > galleryReportFrequency) {
                        C1122c.m6711K1("GallerySynchronized");
                        C1120a.m6677i("CloudAlbumSdkServiceImpl", "notify report : GallerySynchronized");
                        C1136q.b.m7111x0(this.f11531d, false);
                        C1136q.b.m7114y0(C0213f.m1377a(), jCurrentTimeMillis);
                    } else {
                        C1120a.m6677i("CloudAlbumSdkServiceImpl", "report less than frequency days");
                    }
                } else {
                    C1136q.b.m7111x0(this.f11531d, false);
                }
            }
            if (!zM7060g0 || stat.getLocalAdded() > 0 || !zM7066i0 || stat.getCloudNormal() + stat.getCloudRecycle() <= 0) {
                return;
            }
            C1122c.m6711K1("GalleryFirstSynchronized");
            C1120a.m6677i("CloudAlbumSdkServiceImpl", "notify report : GalleryFirstSynchronized");
            C1136q.b.m7108w0(this.f11531d, false);
        }
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getAllGeneralFiles(List<String> list, int i10, int i11, String str) throws RemoteException {
        m15104a0(13, str);
        if (i10 <= 0 || i10 > 1000 || i11 < 0) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "limit is too many! Invalid params!");
            m15118o(str, "getAllGeneralFiles limit invalid");
            return 102;
        }
        if (!m15120p(true, 1)) {
            return m15086I(13);
        }
        Bundle bundle = new Bundle();
        if (list == null) {
            bundle.putStringArrayList("k1", null);
        } else {
            bundle.putStringArrayList("k1", new ArrayList<>(list));
        }
        bundle.putInt("k2", i10);
        bundle.putInt("k3", i11);
        bundle.putString("k4", str);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(13, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getAllShareFiles(ShareAlbumData shareAlbumData, int i10, String str) throws RemoteException {
        m15104a0(26, str);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getAllShareFiles version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (shareAlbumData == null || TextUtils.isEmpty(shareAlbumData.getShareId()) || TextUtils.isEmpty(shareAlbumData.getOwnerId()) || TextUtils.isEmpty(shareAlbumData.getResource())) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getAllShareFilesInvalid params!");
            return 102;
        }
        if (!m15120p(true, 0)) {
            return m15086I(26);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("k1", shareAlbumData);
        bundle.putInt("k2", i10);
        bundle.putString("k3", str);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(26, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getAllSimplifyInfo(String str, List<String> list, int i10, int i11, String str2) throws RemoteException {
        m15104a0(95, str);
        if (list == null || list.isEmpty()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getAllSimplifyInfo albumIds is null or empty");
            return 2;
        }
        if (!m15120p(false, 3)) {
            return m15086I(95);
        }
        Bundle bundle = new Bundle();
        bundle.putString("k1", str);
        bundle.putStringArrayList("k2", new ArrayList<>(list));
        bundle.putInt("k3", i10);
        bundle.putInt("k4", i11);
        bundle.putString("k5", str2);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(95, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getAllTagFiles(SmartTagData smartTagData, String str, String str2) throws RemoteException {
        m15104a0(33, str2);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getAllTagFiles version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (smartTagData == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getAllTagFilesInvalid params!");
            return 102;
        }
        if (!m15120p(false, 3)) {
            return m15086I(33);
        }
        m15117n0(smartTagData, str, str2, 33);
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getAvatarInfo(List<String> list) throws RemoteException {
        m15104a0(48, null);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getAvatarInfo version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (list == null || list.isEmpty()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getAvatarInfo Invalid params!");
            return 102;
        }
        if (m15090M() || m15098U() || m15094Q()) {
            return m15084G(48);
        }
        if (m15089L()) {
            return m15084G(48);
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("k1", new ArrayList<>(list));
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(48, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getCategoryInfoList(String str) throws RemoteException {
        m15104a0(31, str);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getCategoryInfoList version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (!m15120p(false, 3)) {
            return m15086I(31);
        }
        Bundle bundle = new Bundle();
        bundle.putString("k1", str);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(31, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getChangeTagFiles(SmartTagData smartTagData, String str, String str2) throws RemoteException {
        m15104a0(34, str2);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getChangeTagFiles version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        Integer numM15082E = m15082E(smartTagData, 34);
        if (numM15082E != null) {
            return numM15082E.intValue();
        }
        m15117n0(smartTagData, str, str2, 34);
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getChangedGeneralFiles(List<String> list, long j10, int i10, String str, String str2) throws RemoteException {
        m15104a0(14, str2);
        if (i10 <= 0 || i10 > 500 || j10 < 0) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "limit too many! Invalid params!");
            m15118o(str2, "getChangedGeneralFiles limit invalid");
            return 102;
        }
        if (!m15120p(true, 1)) {
            return m15086I(14);
        }
        Bundle bundle = new Bundle();
        if (list == null) {
            bundle.putStringArrayList("k1", null);
        } else {
            bundle.putStringArrayList("k1", new ArrayList<>(list));
        }
        bundle.putLong("k2", j10);
        bundle.putInt("k3", i10);
        bundle.putString("k4", str);
        bundle.putString("k5", str2);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(14, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getChangedShareFiles(ShareAlbumData shareAlbumData, String str, String str2) throws RemoteException {
        m15104a0(27, str2);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getChangedShareFiles version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (shareAlbumData == null || TextUtils.isEmpty(shareAlbumData.getShareId())) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getChangedShareFilesInvalid params!");
            return 102;
        }
        if (!m15120p(true, 0)) {
            return m15086I(27);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("k1", shareAlbumData);
        bundle.putString("k2", str);
        bundle.putString("k3", str2);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(27, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getDetailedInfo(String str, List<SimplifyInfo> list, boolean z10) throws RemoteException {
        m15104a0(96, str);
        if (!m15120p(false, 3)) {
            return m15086I(96);
        }
        if (list == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getDetailedInfo simplifyInfoList is null");
            return 2;
        }
        Bundle bundle = new Bundle();
        bundle.putString("k1", str);
        bundle.putParcelableArrayList("k2", new ArrayList<>(list));
        bundle.putBoolean("k3", z10);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(96, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getDeviceInfoListAsync() {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "Call AIDL: getDeviceInfoListAsync");
        if (!C13452e.m80781L().m80803F0().booleanValue()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getDeviceInfoListAsync version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (m15090M()) {
            return 103;
        }
        if (m15097T()) {
            return 114;
        }
        if (m15091N()) {
            return 138;
        }
        if (C13195l.m79272J().m79309Y()) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "can not get device info for userId changed.");
            C1122c.m6768c2();
            return 101;
        }
        C12515a.m75110o().m75172d(new QueryDeviceInfoListCallable(this));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getDownloadFileCount(int i10) throws RemoteException {
        m15104a0(77, null);
        if (i10 > 0 && i10 < 64) {
            return this.f11532e.getDownloadFileCount(i10);
        }
        C1120a.m6676e("CloudAlbumSdkServiceImpl", "Invalid params!");
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public List<FileDownloadStatus> getDownloadFileStatus(List<FileData> list) throws RemoteException {
        m15104a0(78, null);
        if (list != null && !list.isEmpty()) {
            return this.f11532e.getDownloadFileStatus(list);
        }
        C1120a.m6676e("CloudAlbumSdkServiceImpl", "getDownloadFileStatus: Invalid params!");
        return null;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public List<FileDownloadStatus> getDownloadFileStatusLimit(int i10, int i11, int i12) throws RemoteException {
        m15104a0(79, null);
        if (i10 > 0 && i10 < 64) {
            return this.f11532e.getDownloadFileStatusLimit(i10, i11, i12);
        }
        C1120a.m6676e("CloudAlbumSdkServiceImpl", "Invalid params!");
        return null;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getFileTransferStatus(String str) {
        m15104a0(7, str);
        if (!m15120p(true, 2)) {
            return m15086I(7);
        }
        if (!C14163d.m84990g().m85009o()) {
            return m15139z(7, str);
        }
        C1120a.m6676e("CloudAlbumSdkServiceImpl", "getFileTransferStatus: 137");
        return SyncType.DELAY_START_SYNC;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getGeneralAlbumVersion(String str) throws RemoteException {
        m15104a0(1, str);
        if (!m15120p(true, 1)) {
            return m15086I(1);
        }
        if (C1136q.b.m7057f0(this.f11531d)) {
            C1136q.b.m7096s0(this.f11531d, false);
        }
        return m15139z(1, str);
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getGeneralAlbums(String str) throws RemoteException {
        m15104a0(11, str);
        return !m15120p(true, 1) ? m15086I(11) : m15139z(11, str);
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getGroupAlbums(String str) throws RemoteException {
        m15104a0(25, str);
        if (!CloudAlbumSettings.m14363h().m14378n()) {
            return !m15120p(true, 0) ? m15086I(25) : m15139z(25, str);
        }
        C1120a.m6676e("CloudAlbumSdkServiceImpl", "getGroupAlbums version error");
        return SyncType.OPEN_SWITCH_MANUALLY;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public List<GroupMemberInfo> getGroupMemberInfoList(String str) throws InterruptedException {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "Call AIDL: getGroupMemRespList");
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getGroupMemberInfoList version error");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getGroupMemberInfoList Invalid params!");
            return null;
        }
        if (m15090M() || m15098U()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getGroupMemberInfoList isLogoff or isSwitchOff!");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            List<GroupMem> listM14426f = HmsSnsApp.m14419h().m14426f(Long.parseLong(str));
            if (listM14426f != null) {
                for (GroupMem groupMem : listM14426f) {
                    if (groupMem == null) {
                        C1120a.m6676e("CloudAlbumSdkServiceImpl", "getGroupMemberInfoList groupMemInfo is null");
                    } else {
                        arrayList.add(new GroupMemberInfo(groupMem.getUserId(), groupMem.getDisplayName(), groupMem.getImagePath(), groupMem.getJoinTime()));
                    }
                }
            }
        } catch (NumberFormatException e10) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getGroupMemberInfoList err: " + e10.toString());
        }
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getServerTime() throws RemoteException {
        m15104a0(5, null);
        if (m15090M() || m15098U()) {
            return m15084G(5);
        }
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(5));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public String getSessionId(final int i10, final int i11) throws InterruptedException, SQLException {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "Call AIDL: getSessionId, sessionType: " + i10 + ", syncType: " + i11);
        final String str = null;
        if (C13195l.m79272J().m79309Y()) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "can not getSessionId for userId changed.");
            C1122c.m6768c2();
            return null;
        }
        if (C0209d.m1293p1()) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "ink screen not support");
            Bundle bundle = new Bundle();
            bundle.putBoolean("GeneralAblum", false);
            CloudAlbumManager.m14456v().m14470O(this.f11531d, bundle, 41);
            C1122c.m6764b2(41, false);
            return null;
        }
        this.f11535h.m60405K(false);
        C1122c.m6809n();
        if (!C1136q.m6980u(System.currentTimeMillis())) {
            return m15131u0(i10, i11, null);
        }
        final CompletableFuture completableFuture = new CompletableFuture();
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.bm.type");
        arrayList.add("bs.bm.usergrade.info");
        C12515a.m75110o().m75175e(new C11079e(new C11079e.a() { // from class: com.huawei.android.hicloud.album.service.c
            @Override // p431ko.C11079e.a
            /* renamed from: a */
            public final void mo14511a(UserDataStateInfo userDataStateInfo) {
                this.f11523a.m15100W(i10, i11, str, completableFuture, userDataStateInfo);
            }
        }, false, arrayList, "getSessionId"), false);
        try {
            return (String) completableFuture.get(30L, TimeUnit.SECONDS);
        } catch (Exception e10) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getSessionId fail:" + e10.toString());
            return null;
        }
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getShareAlbumVersion(String str) throws RemoteException {
        m15104a0(6, str);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getShareAlbumVersion version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (!m15120p(true, 0)) {
            return m15086I(6);
        }
        if (!C14163d.m84990g().m85009o()) {
            return m15139z(6, str);
        }
        C1120a.m6676e("CloudAlbumSdkServiceImpl", "getShareAlbumVersion: 137");
        return SyncType.DELAY_START_SYNC;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getShareAlbums(String str) throws RemoteException {
        m15104a0(12, str);
        if (!CloudAlbumSettings.m14363h().m14378n()) {
            return !m15120p(true, 0) ? m15086I(12) : m15139z(12, str);
        }
        C1120a.m6676e("CloudAlbumSdkServiceImpl", "getShareAlbums version error");
        return SyncType.OPEN_SWITCH_MANUALLY;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public List<ShareAlbumData> getShareGroupList() throws InterruptedException, PackageManager.NameNotFoundException, RemoteException {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "Call AIDL: getShareGroupList");
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getShareGroupList version error");
            return new ArrayList();
        }
        if (m15090M() || m15098U()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getShareGroupList condition error");
            return new ArrayList();
        }
        boolean zM14428i = HmsSnsApp.m14419h().m14428i(this.f11531d);
        List<Group> listM14427g = HmsSnsApp.m14419h().m14427g();
        ArrayList arrayList = new ArrayList();
        if (!zM14428i || listM14427g == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getShareGroupList groupList is null or isSupport: " + zM14428i);
            return arrayList;
        }
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "getGroupList size is:" + listM14427g.size());
        for (Group group : listM14427g) {
            if (group == null) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "getShareGroupList group is null");
            } else {
                ShareAlbumData shareAlbumData = new ShareAlbumData();
                shareAlbumData.setShareId(String.valueOf(group.getGroupId()));
                shareAlbumData.setShareName(group.getName());
                shareAlbumData.setOwnerId(String.valueOf(group.getManagerUid()));
                arrayList.add(shareAlbumData);
            }
        }
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public String[] getSnsGroups() throws RemoteException {
        m15104a0(50, null);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getSnsGroups version error");
            return new String[0];
        }
        if (!m15090M() && !m15098U() && !m15094Q()) {
            return HmsSnsApp.m14419h().m14425e();
        }
        C1120a.m6676e("CloudAlbumSdkServiceImpl", "getSnsGroups isLogoff or isSwitchOff!");
        return new String[0];
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getSyncLock(String str) throws RemoteException {
        m15104a0(2, str);
        if (!m15120p(false, 3)) {
            return m15086I(2);
        }
        if (m15091N()) {
            m15108e0(2);
            return 138;
        }
        if (Version.isSupportUniversalInterface()) {
            this.f11536i.m419l();
        }
        return m15139z(2, str);
    }

    @Override // com.huawei.android.hicloud.album.service.CallbackHandler
    public C9674k getSyncStrategy() {
        return this.f11535h;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getSyncStrategyState() throws RemoteException {
        m15126s();
        int iM60418h = this.f11535h.m60418h();
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "getSyncStrategyState, state: " + iM60418h);
        return iM60418h;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getTagInfo(SmartAlbumData smartAlbumData, String str, String str2) throws RemoteException {
        m15104a0(32, str2);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getTagInfo version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (smartAlbumData == null || TextUtils.isEmpty(smartAlbumData.getCategoryId())) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getTagInfoInvalid params!");
            return 102;
        }
        if (!m15120p(false, 3)) {
            return m15086I(32);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("k1", smartAlbumData);
        bundle.putString("k2", str);
        bundle.putString("k3", str2);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(32, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getTagTransferStatus() throws RemoteException {
        m15104a0(92, null);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "reportTagTransferStatus version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (!m15120p(false, 3)) {
            return m15086I(92);
        }
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(92));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getTagVersion(String str) throws RemoteException {
        m15104a0(30, str);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getTagVersion version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (!m15120p(false, 3)) {
            return m15086I(30);
        }
        if (C14163d.m84990g().m85009o()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getShareAlbumVersion: 137");
            return SyncType.DELAY_START_SYNC;
        }
        Bundle bundle = new Bundle();
        bundle.putString("k1", str);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(30, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public Bundle getUsedPower() throws RemoteException {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "AIDL call: getUsedPower");
        return C1122c.m6767c1();
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int getVideoPlayUrlAsync(FileData fileData) throws RemoteException {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "Call AIDL: getVideoPlayUrlAsync");
        if (fileData == null) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "getVideoPlayUrlAsync params error");
            return 2;
        }
        if (TextUtils.isEmpty(fileData.getAlbumId())) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "getVideoPlayUrlAsync album params error");
            return 2;
        }
        if (TextUtils.isEmpty(fileData.getUniqueId()) && (TextUtils.isEmpty(fileData.getHash()) || TextUtils.isEmpty(fileData.getUserID()))) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "getVideoPlayUrlAsync file params error");
            return 2;
        }
        if (m15090M() || m15098U() || m15089L()) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "getVideoPlayUrlAsync status not allowed");
            return 1;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("k1", fileData);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(97, bundle));
        return 0;
    }

    /* renamed from: h0 */
    public final void m15111h0(String str, Stat stat) {
        if (stat == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "reportSdkEvent stat is null");
            return;
        }
        if (TextUtils.isEmpty(stat.getSessionId())) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "session id is empty");
            return;
        }
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        if (stat.getLocalAdded() > 0) {
            linkedHashMapM79497A.put("New", String.valueOf(stat.getLocalAdded()));
            linkedHashMapM79497A.put("SpaceFull", String.valueOf(SyncSessionManager.m15153t().m15161H()));
        }
        C13224c.m79487f1().m79567R(str, linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", str, linkedHashMapM79497A);
    }

    /* renamed from: i0 */
    public final void m15112i0(String str, Stat stat) {
        if (stat == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "reportSdkOMEvent stat is null");
            return;
        }
        if (TextUtils.isEmpty(stat.getSessionId())) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "session id is empty");
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        if (stat.getLocalAdded() > 0) {
            sb2.append(" New:");
            sb2.append(stat.getLocalAdded());
        }
        if (stat.getLocalUpdated() > 0) {
            sb2.append(" Update:");
            sb2.append(stat.getLocalUpdated());
        }
        if (stat.getLocalRecycleUpdated() > 0) {
            sb2.append(" UpdateRecycle:");
            sb2.append(stat.getLocalRecycleUpdated());
        }
        if (stat.getCloudNormal() > 0) {
            sb2.append(" Cloud:");
            sb2.append(stat.getCloudNormal());
        }
        if (stat.getCloudRecycle() > 0) {
            sb2.append(" CloudRecycle:");
            sb2.append(stat.getCloudRecycle());
        }
        if (stat.getDisconnectedTime() > 0) {
            sb2.append(" Disconnected:");
            sb2.append(C1122c.m6721O(stat.getDisconnectedTime()));
        }
        String string = sb2.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        int i10 = "stopsync".equals(str) ? 156 : 0;
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "reportSdkOMEvent sessionId: " + stat.getSessionId() + ", cmd: " + str + ", code: " + i10 + ", msg: " + string);
        C12515a.m75110o().m75168b1(new a(stat, str, i10, string));
    }

    @Override // com.huawei.android.hicloud.album.service.CallbackHandler
    public boolean invokeEvent(int i10, Bundle bundle) {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "invokeEvent funcId: " + i10);
        m15124r();
        if (!this.f11534g.isAlive()) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "invokeEvent error service has destroyed");
            return true;
        }
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(i10, bundle));
        return true;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public boolean isSupportSns() {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "Call AIDL: isSupportSns");
        if (!CloudAlbumSettings.m14363h().m14378n()) {
            return HmsSnsApp.m14419h().m14428i(this.f11531d);
        }
        C1120a.m6676e("CloudAlbumSdkServiceImpl", "isSupportSns version error");
        return false;
    }

    /* renamed from: j0 */
    public final void m15113j0(Bundle bundle) {
        if (bundle == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "saveAlbumDotFirstStartTime bundle is null");
        } else {
            SyncSessionManager.m15153t().m15188l().put("firstStartTime", bundle.getString("firstStartTime"));
            SyncSessionManager.m15153t().m15188l().put("prepareTimes", bundle.getString("prepareTimes"));
        }
    }

    /* renamed from: k0 */
    public final void m15114k0(Bundle bundle) {
        if (bundle == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "saveAlbumDotIncFlag bundle is null");
        } else {
            SyncSessionManager.m15153t().m15188l().put("incFlag", bundle.getString("incFlag"));
        }
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int keepSyncLock(String str, String str2) throws RemoteException {
        m15104a0(3, str2);
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "keepSyncLockInvalid params!");
            m15118o(str2, "keepSyncLock lockToken is empty");
            return 102;
        }
        if (!m15120p(false, 3)) {
            return m15086I(3);
        }
        if (!m15091N()) {
            return m15078A(3, str, str2);
        }
        m15108e0(3);
        return 138;
    }

    /* renamed from: l0 */
    public final void m15115l0(Bundle bundle) {
        if (bundle == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "saveAlbumDotParameter bundle is null");
        } else {
            SyncSessionManager.m15153t().m15171R(bundle.getString("prepareTraceId"));
        }
    }

    /* renamed from: m0 */
    public final void m15116m0(Bundle bundle) {
        if (bundle == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "saveAlbumDotStartForeground bundle is null");
        } else {
            SyncSessionManager.m15153t().m15188l().put("startForgound", bundle.getString("startForgound"));
        }
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int modifyGeneralAlbums(List<GeneralAlbumData> list, String str, String str2) throws RemoteException {
        m15104a0(18, str2);
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "modifyGeneralAlbums albums or lockToken is empty");
            m15118o(str2, "modifyGeneralAlbums albums or lockToken is empty");
            return 102;
        }
        ArrayList arrayList = new ArrayList();
        for (GeneralAlbumData generalAlbumData : list) {
            if (generalAlbumData == null || TextUtils.isEmpty(generalAlbumData.getAlbumId())) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "modifyGeneralAlbums An generalAlbumData is null or albumId is empty");
                m15118o(str2, "modifyGeneralAlbums generalAlbumData invalid");
                return 102;
            }
            String albumId = generalAlbumData.getAlbumId();
            SyncSessionManager.m15153t().m15177a("cloudphoto.album.batchupdate", str2, albumId);
            if (SyncSessionManager.m15153t().m15155B("cloudphoto.album.batchupdate", str2, albumId)) {
                arrayList.add(albumId);
            }
        }
        if (arrayList.isEmpty()) {
            if (!m15120p(false, 1)) {
                return m15086I(18);
            }
            if (m15091N()) {
                m15108e0(18);
                return 138;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("k1", new ArrayList<>(list));
            bundle.putString("k3", str2);
            bundle.putString("k2", str);
            m15124r();
            e eVar = this.f11533f;
            eVar.sendMessage(eVar.obtainMessage(18, bundle));
            return 0;
        }
        C1120a.m6676e("CloudAlbumSdkServiceImpl", "modifyGeneralAlbums too frequently, albumIds: " + arrayList.toString());
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new AlbumUpdatedResult(null, (String) it.next(), RecommendCardConstants.Num.PICTURE_SECOND_HEIGHT, "modify the same albums."));
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("sessionId", str2);
        bundle2.putParcelableArrayList("AlbumUpdatedResultList", arrayList2);
        bundle2.putInt("code", RecommendCardConstants.Num.PICTURE_SECOND_HEIGHT);
        bundle2.putString("info", VastAttribute.ERROR);
        sendMessage(9122, bundle2);
        new CommonOpsReport(this.f11531d).m15209C(str2, "syncstate", 102, "modifyGeneralAlbums too frequently, albumIds:" + arrayList.toString());
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int modifyGeneralFiles(List<FileData> list, String str, String str2) throws RemoteException {
        m15104a0(22, str2);
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "modifyGeneralFiles: Invalid params!");
            m15118o(str2, "modifyGeneralFiles: Invalid params!");
            return 102;
        }
        if (C12110w.m72533a().m72535c(list)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "downloadGeneralFiles restart sync");
            return 102;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        for (FileData fileData : list) {
            if (fileData == null) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "modifyGeneralFiles fileData is null");
                m15118o(str2, "modifyGeneralFiles fileData is null");
                return 102;
            }
            if (SyncSessionManager.m15153t().m15157D("cloudphoto.file.batchupdate", str2, fileData.getAlbumId())) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "modifyGeneralFiles albumId not exist: " + fileData.getAlbumId() + " " + fileData.getUniqueId());
                arrayList2.add(fileData);
                sb2.append(fileData.getAlbumId());
                sb2.append("_");
                sb2.append("not exist");
                sb2.append(";");
            } else {
                String uniqueId = fileData.getUniqueId() != null ? fileData.getUniqueId() : fileData.getFileId();
                if (C1122c.m6815o1(uniqueId)) {
                    C1120a.m6676e("CloudAlbumSdkServiceImpl", "modifyGeneralFiles mediaId is invalid: " + uniqueId);
                    arrayList2.add(fileData);
                    sb2.append(uniqueId);
                    sb2.append("_");
                    sb2.append("mediaId invalid");
                    sb2.append(";");
                } else {
                    if ("default-album-3".equals(fileData.getAlbumId())) {
                        SyncSessionManager.m15153t().m15169P(true);
                    }
                    arrayList.add(fileData);
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            new CommonOpsReport(this.f11531d).m15209C(str2, "repeat_update", 1003, sb2.toString());
        }
        if (arrayList.isEmpty()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "modifyGeneralFiles too much error and cause param error");
            m15118o(str2, "modifyGeneralFiles too much error and cause param error");
            return 102;
        }
        if (!m15120p(false, 1)) {
            return m15086I(22);
        }
        if (!m15091N()) {
            return m15079B(22, arrayList, str, str2);
        }
        m15108e0(22);
        return 138;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int modifyShareAlbum(ShareAlbumData shareAlbumData, String str) throws RemoteException {
        m15104a0(19, str);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "modifyShareAlbum version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (shareAlbumData == null || TextUtils.isEmpty(shareAlbumData.getShareId()) || TextUtils.isEmpty(shareAlbumData.getShareName())) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "modifyAlbums shareAlbumData, shareId or shareName is empty! Invalid params!");
            return 102;
        }
        if (!m15120p(false, 0)) {
            return m15086I(19);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("k1", shareAlbumData);
        bundle.putString("k2", str);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(19, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int modifyShareAlbumData(ShareAlbumData shareAlbumData) throws RemoteException {
        m15104a0(99, null);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "modifyShareAlbum version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (shareAlbumData == null || TextUtils.isEmpty(shareAlbumData.getShareId()) || TextUtils.isEmpty(shareAlbumData.getShareName())) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "modifyAlbums shareAlbumData, shareId or shareName is empty! Invalid params!");
            return 102;
        }
        if (C13195l.m79272J().m79309Y()) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "can not modify share album for userId changed.");
            C1122c.m6768c2();
            return 101;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("k1", shareAlbumData);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(99, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int modifyShareAlbumPrivilege(String str, int i10) throws RemoteException {
        m15104a0(47, null);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "modifyShareAlbumPrivilege version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "modifyShareAlbumPrivilege Invalid params!");
            return 102;
        }
        if (m15090M() || m15098U()) {
            return m15084G(47);
        }
        if (m15089L()) {
            return m15084G(47);
        }
        if (m15091N()) {
            m15108e0(47);
            return 138;
        }
        Bundle bundle = new Bundle();
        bundle.putString("k1", str);
        bundle.putInt("k2", i10);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(47, bundle));
        return 0;
    }

    /* renamed from: n0 */
    public final void m15117n0(SmartTagData smartTagData, String str, String str2, int i10) {
        if (smartTagData == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getChangeTagFilesInvalid params!");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("k3", str2);
        bundle.putParcelable("k1", smartTagData);
        bundle.putString("k2", str);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(i10, bundle));
    }

    /* renamed from: o */
    public final void m15118o(String str, String str2) {
        SyncSessionManager.m15153t().m15178b(str, str2);
    }

    /* renamed from: o0 */
    public final void m15119o0(int i10, Bundle bundle) {
        if (bundle == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "sendPowerControlMessage bundle is null");
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = i10;
        messageObtain.obj = bundle;
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "sendPowerControlMessage cmd:" + i10);
        if (i10 != 6) {
            if (i10 == 7) {
                this.f11537j.sendMessageDelayed(messageObtain, 200L);
                return;
            } else if (i10 != 8) {
                return;
            }
        }
        this.f11537j.sendMessage(messageObtain);
    }

    /* renamed from: p */
    public boolean m15120p(boolean z10, int i10) {
        if (!C13195l.m79272J().m79309Y()) {
            m15126s();
            return this.f11535h.m60421k(z10, i10) == C9674k.c.CAN_START_SYNC;
        }
        C1120a.m6678w("CloudAlbumSdkServiceImpl", "can not start sync for userId changed.");
        C1122c.m6768c2();
        return false;
    }

    /* renamed from: p0 */
    public void m15121p0(boolean z10) {
        this.f11539l = z10;
        CloudAlbumSettings.m14363h().m14368E(z10);
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int pauseDownload(List<FileData> list) throws RemoteException {
        m15104a0(72, null);
        if (list == null || list.isEmpty()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "pauseDownload: Invalid params!");
            return 102;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("k1", new ArrayList<>(list));
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(72, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int pauseDownloadAll() throws RemoteException {
        m15104a0(75, null);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(75));
        return 0;
    }

    /* renamed from: q */
    public final void m15122q(int i10) {
        if (i10 == 0 && C0219i.f814b) {
            C1144b c1144b = new C1144b();
            C1120a.m6677i("CloudAlbumSdkServiceImpl", "start DownloadApply");
            C12297a.m73908c().m73909a("user-download_apply", c1144b);
        }
    }

    /* renamed from: q0 */
    public final void m15123q0(Bundle bundle) {
        if (bundle == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "setGalleryProperties bundle is null");
            return;
        }
        int i10 = bundle.getInt("galleryPid");
        int i11 = bundle.getInt("galleryBusinessVersion");
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "galleryPid: " + i10 + ", businessVersion: " + i11);
        if (i11 < 0) {
            i11 = 0;
        }
        if (i11 < 2) {
            CloudAlbumSettings.m14363h().m14367D(false);
        }
        Version.setGalleryVersion(i11);
        CloudAlbumSettings.m14363h().m14366C(i10);
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int queryDisableState(int i10, String str) throws RemoteException {
        m15104a0(68, str);
        if (m15090M()) {
            return m15086I(68);
        }
        if (C13195l.m79272J().m79309Y()) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "can not queryDisableState for userId changed.");
            C1122c.m6768c2();
            return 101;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("k1", i10);
        bundle.putString("k2", str);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(68, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int queryDisuseState() throws RemoteException {
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int queryUserSpace(String str, int i10, String str2, String str3, String str4) {
        m15104a0(37, str);
        if (i10 < 0 || i10 > 4) {
            String str5 = "queryUserSpace type invalid: " + i10;
            C1120a.m6676e("CloudAlbumSdkServiceImpl", str5);
            m15118o(str, str5);
            return 102;
        }
        if (!m15120p(false, 3)) {
            return m15086I(37);
        }
        if (m15091N()) {
            m15108e0(37);
            return 138;
        }
        Bundle bundle = new Bundle();
        bundle.putString("k1", str);
        bundle.putInt("k2", i10);
        bundle.putString("k3", str2);
        bundle.putString("k4", str3);
        bundle.putString("k5", str4);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(37, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public UserSpace queryUserSpaceSync(String str, int i10, String str2, String str3, String str4) {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "Call AIDL: queryUserSpaceSync, traceId: " + str);
        if (!m15090M() && !m15098U() && !m15089L()) {
            return this.f11532e.queryUserSpaceSync(str, i10, str2, str3, str4);
        }
        C1120a.m6676e("CloudAlbumSdkServiceImpl", "queryUserSpaceSync can not start sync");
        return null;
    }

    /* renamed from: r */
    public final synchronized void m15124r() {
        long j10 = this.f11541n;
        if (j10 == 0) {
            C1120a.m6677i("CloudAlbumSdkServiceImpl", "funcCallHandlerThread executingStartTime 0");
            return;
        }
        if (SystemClock.elapsedRealtime() - j10 < 600000) {
            C1120a.m6677i("CloudAlbumSdkServiceImpl", "funcCallHandlerThread interval");
            return;
        }
        if (!this.f11542o) {
            this.f11542o = true;
            this.f11541n = SystemClock.elapsedRealtime();
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "funcCallHandlerThread reset executingStartTime");
            return;
        }
        C1120a.m6678w("CloudAlbumSdkServiceImpl", "funcCallHandlerThread invoke time out");
        HandlerThread handlerThread = this.f11534g;
        if (handlerThread == null || !handlerThread.isAlive()) {
            String str = "funcCallHandlerThread null or not alive, funcId = " + this.f11540m;
            C1120a.m6676e("CloudAlbumSdkServiceImpl", str);
            HandlerThread handlerThread2 = new HandlerThread("AIDL_CALL", 10);
            this.f11534g = handlerThread2;
            handlerThread2.start();
            this.f11533f = new e(this.f11534g.getLooper());
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "renew funcCallHandlerThread " + this.f11534g.getThreadId());
            this.f11541n = 0L;
            this.f11542o = false;
            C12515a.m75110o().m75168b1(new b(str));
            return;
        }
        try {
            StackTraceElement[] stackTrace = this.f11534g.getStackTrace();
            ArrayList arrayList = new ArrayList(stackTrace.length);
            Collections.addAll(arrayList, stackTrace);
            String str2 = "funcCallHandlerThread funcId = " + this.f11540m + ", invoke = " + StringUtil.join(System.lineSeparator(), (List<String>) C0225l.m1579c(arrayList, new C2415b()));
            C1120a.m6678w("CloudAlbumSdkServiceImpl", str2);
            C12515a.m75110o().m75168b1(new c(str2));
        } catch (Exception unused) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "funcCallHandlerThread getStackTrace Exception just happened");
        }
        this.f11534g.quitSafely();
        HandlerThread handlerThread3 = new HandlerThread("AIDL_CALL", 10);
        this.f11534g = handlerThread3;
        handlerThread3.start();
        this.f11533f = new e(this.f11534g.getLooper());
        C1120a.m6678w("CloudAlbumSdkServiceImpl", "renew funcCallHandlerThread " + this.f11534g.getThreadId());
        this.f11541n = 0L;
        this.f11542o = false;
    }

    /* renamed from: r0 */
    public final void m15125r0(Bundle bundle, StringBuilder sb2) {
        int i10 = bundle.getInt("controlType");
        long j10 = bundle.getLong("availablePower");
        double d10 = bundle.getDouble("discountWifi");
        double d11 = bundle.getDouble("discountMobile");
        int i11 = bundle.containsKey("availableTime") ? bundle.getInt("availableTime") : -1;
        boolean z10 = bundle.containsKey("needControl") ? bundle.getBoolean("needControl") : false;
        C0070h.m527v().m568j0(z10);
        C0068f.m459d().m466j();
        C0070h.m527v().m557d0(j10);
        C0070h.m527v().m558e0(i11);
        C0070h.m527v().m560f0(i10);
        C0070h.m527v().m564h0(d10);
        C0070h.m527v().m562g0(d11);
        sb2.append("controlType: ");
        sb2.append(i10);
        sb2.append(", availablePower: ");
        sb2.append(j10);
        sb2.append(", discountWifi: ");
        sb2.append(d10);
        sb2.append(", discountMobile: ");
        sb2.append(d11);
        sb2.append(", availableTime: ");
        sb2.append(i11);
        sb2.append(", needControl: ");
        sb2.append(z10);
        C0070h.m527v().m548U("set_power_control_policy", "power control policy");
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int reLogin() {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "reLogin on state: " + this.f11535h.m60418h());
        C13108a.m78878b(this.f11531d).m78881d(new Intent("com.huawei.hicloud.intent.action.RE_LOGIN"));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public boolean registerCallback(ICloudAlbumSdkServiceCallback iCloudAlbumSdkServiceCallback) throws RemoteException {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "registerCallback");
        try {
            if (iCloudAlbumSdkServiceCallback == null) {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "registerCallback fail");
                return false;
            }
            C1120a.m6677i("CloudAlbumSdkServiceImpl", "register callback success");
            this.f11535h.m60405K(false);
            return this.f11528a.register(iCloudAlbumSdkServiceCallback);
        } catch (Exception e10) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "registerCallback error: " + e10);
            return false;
        }
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int releaseSyncLock(String str, String str2) throws RemoteException {
        String strM15192p = SyncSessionManager.m15153t().m15192p();
        SyncSessionManager.m15153t().m15185i();
        this.f11536i.m420m();
        m15104a0(4, str2);
        if (TextUtils.isEmpty(strM15192p)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "lock token is null! Invalid params!");
            m15118o(str2, "releaseSyncLock lockToken is empty");
            return 102;
        }
        if (!m15094Q()) {
            return m15078A(4, strM15192p, str2);
        }
        if (CloudAlbumSettings.m14363h().m14376l()) {
            m15078A(4, strM15192p, str2);
        }
        return m15086I(4);
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int removeShareReceiver(ShareAlbumData shareAlbumData, List<ShareReceiverData> list) throws RemoteException {
        m15104a0(43, null);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "removeShareReceiver version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (shareAlbumData == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "removeShareReceiver Invalid params!");
            return 102;
        }
        if (m15090M() || m15098U()) {
            return m15084G(43);
        }
        if (m15089L()) {
            return m15084G(43);
        }
        if (m15091N()) {
            m15108e0(43);
            return 138;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("k1", shareAlbumData);
        if (list == null) {
            bundle.putParcelableArrayList("k2", null);
        } else {
            bundle.putParcelableArrayList("k2", new ArrayList<>(list));
        }
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(43, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int report(String str, Stat stat) throws RemoteException {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "Call AIDL: report, cmd:" + str + " stat:" + stat.toString());
        if ("syncstate".equals(str)) {
            SyncSessionManager.m15153t().m15168O(stat);
            return 0;
        }
        m15112i0(str, stat);
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int reportRisks(List<RiskInform> list) {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "Call AIDL: reportRisks");
        if (!C13452e.m80781L().m80803F0().booleanValue()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "getDeviceInfoListAsync version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (m15090M()) {
            return 103;
        }
        if (m15097T()) {
            return 114;
        }
        if (m15091N()) {
            return 138;
        }
        if (C13195l.m79272J().m79309Y()) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "can not report risk for userId changed.");
            C1122c.m6768c2();
            return 101;
        }
        C12515a.m75110o().m75172d(new ReportRisksCallable(this, list));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int reportTagTransferStatus(String str) throws RemoteException {
        m15104a0(91, null);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "reportTagTransferStatus version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (!m15120p(false, 3)) {
            return m15086I(91);
        }
        Bundle bundle = new Bundle();
        bundle.putString("k1", str);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(91, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int request(int i10, Bundle bundle) throws RemoteException {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "Call AIDL: request cmd: " + i10);
        if (i10 == 1) {
            m15123q0(bundle);
        } else if (i10 == 2) {
            m15137x0(bundle);
        } else if (i10 == 3) {
            C0070h.m527v().m548U("power_network_change", "other_no_stop_report");
            m15102Y();
        } else if (i10 == 4) {
            m15101X(bundle);
        } else if (i10 == 5) {
            this.f11535h.m60411a();
        } else if (i10 != 100) {
            switch (i10) {
                case 9:
                    m15115l0(bundle);
                    break;
                case 10:
                    m15116m0(bundle);
                    break;
                case 11:
                    m15113j0(bundle);
                    break;
                case 12:
                    m15114k0(bundle);
                    break;
            }
        } else {
            m15124r();
            e eVar = this.f11533f;
            eVar.sendMessage(eVar.obtainMessage(98));
        }
        m15119o0(i10, bundle);
        return 0;
    }

    /* renamed from: s */
    public final void m15126s() {
        if (this.f11535h.m60432v() && !C10028c.m62182c0().m62375p1()) {
            C1120a.m6677i("CloudAlbumSdkServiceImpl", " clear isForceUpgrade flag!");
            this.f11535h.m60401G(false);
        }
        if (this.f11535h.m60434x()) {
            if (this.f11535h.m60431u() || this.f11535h.m60435y() || C11654a.m69601b() == null) {
                C1120a.m6678w("CloudAlbumSdkServiceImpl", "Unstable ST invalid status!");
                return;
            }
            if (!C13452e.m80781L().m80927i1() && !C11654a.m69601b().m15910a(this.f11531d)) {
                C1120a.m6677i("CloudAlbumSdkServiceImpl", "Hms has login, clear st invalid flag!");
                this.f11535h.m60406L(false);
            } else {
                C1120a.m6677i("CloudAlbumSdkServiceImpl", "sync risk effective or stInvalid, auth fail, sendBroadCast");
                Intent intent = new Intent("com.huawei.hicloud.intent.action.CLOUDALBUM_AUTHFAILED");
                intent.putExtra("is_sure_st_invalid", true);
                C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
            }
        }
    }

    /* renamed from: s0 */
    public void m15127s0() {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "stopAllSync");
        C0070h.m527v().m568j0(true);
        C0068f.m459d().m466j();
        C12515a.m75110o().m75175e(new g(this, null), true);
    }

    @Override // com.huawei.android.hicloud.album.service.CallbackHandler
    public void sendMessage(int i10, Bundle bundle) {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "sendCallbackMsg msgId: " + i10);
        Message messageObtainMessage = this.f11529b.obtainMessage();
        messageObtainMessage.what = i10;
        if (bundle != null) {
            messageObtainMessage.obj = bundle;
        }
        try {
            if (this.f11530c.isAlive()) {
                this.f11529b.sendMessage(messageObtainMessage);
            } else {
                C1120a.m6678w("CloudAlbumSdkServiceImpl", "sendMessage error service has destroyed");
            }
        } catch (Exception e10) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "callbackHandler exception:" + e10.getMessage());
        }
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int setAidlVersion(int i10) {
        m15106c0("setAidlVersion, version: " + i10, null);
        if (i10 < 0) {
            i10 = 0;
        }
        Version.setAidlVersion(i10);
        this.f11535h.m60426p();
        return 16;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int setAlbumProperties(SettingParams settingParams) throws RemoteException {
        if (settingParams == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "settingParams is null, Invalid params!");
            return 102;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("k1", settingParams);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(8, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int shareResultConfirm(String str, String str2, int i10) throws RemoteException {
        m15104a0(44, null);
        if (CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "shareResultConfirm version error");
            return SyncType.OPEN_SWITCH_MANUALLY;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "shareResultConfirm Invalid params!");
            return 102;
        }
        if (!m15096S() && !m15089L()) {
            if (m15091N()) {
                m15108e0(44);
                return 138;
            }
            Bundle bundle = new Bundle();
            bundle.putString("k1", str);
            bundle.putString("k2", str2);
            bundle.putInt("k3", i10);
            m15124r();
            e eVar = this.f11533f;
            eVar.sendMessage(eVar.obtainMessage(44, bundle));
            return 0;
        }
        return m15084G(44);
    }

    @Override // com.huawei.android.hicloud.album.service.CallbackHandler
    public void stInvalid(boolean z10) {
        this.f11532e.stInvalid(z10);
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int startDownload(List<FileData> list) throws RemoteException {
        m15104a0(71, null);
        if (list == null || list.isEmpty()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "startDownloadInvalid params!");
            return 102;
        }
        if (C13195l.m79272J().m79309Y()) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "can not download for userId changed.");
            C1122c.m6768c2();
            return 101;
        }
        if (!canStartDownloading(false, 0)) {
            int iM15081D = m15081D(71);
            if (m15093P(iM15081D, 0)) {
                return iM15081D;
            }
        }
        if (C1136q.b.m7054e0(this.f11531d)) {
            C1136q.b.m7093r0(this.f11531d, false);
        }
        m15122q(0);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("k1", new ArrayList<>(list));
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(71, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int startDownloadAll() throws RemoteException {
        m15104a0(74, null);
        if (C13195l.m79272J().m79309Y()) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "can not download for userId changed.");
            C1122c.m6768c2();
            return 101;
        }
        if (!canStartDownloading(false, 0)) {
            int iM15081D = m15081D(74);
            if (m15093P(iM15081D, 0)) {
                return iM15081D;
            }
        }
        m15122q(0);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(74));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int startDownloadFile(List<FileData> list, boolean z10) throws RemoteException {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "Call AIDL: startDownloadFile");
        if (list == null || list.isEmpty()) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "startDownloadFileInvalid params!");
            return 102;
        }
        if (C13195l.m79272J().m79309Y()) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "can not download for userId changed.");
            C1122c.m6768c2();
            return 101;
        }
        if (!canStartDownloading(z10, 0)) {
            return m15086I(70);
        }
        if (C1136q.b.m7054e0(this.f11531d)) {
            C1136q.b.m7093r0(this.f11531d, false);
        }
        m15122q(0);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("k1", new ArrayList<>(list));
        bundle.putBoolean("k2", z10);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(70, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int syncOpsReport(String str, int i10, int i11, String str2) {
        String strM15200y;
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "Call AIDL: syncOpsReport, traceId: " + str + ", syncType:" + i10 + ", errCode: " + i11 + ", errMsg: " + str2);
        m15109f0(str, i11);
        if (i11 == 102) {
            strM15200y = SyncSessionManager.m15153t().m15198w(str);
        } else if (i11 == 160) {
            m15124r();
            e eVar = this.f11533f;
            eVar.sendMessage(eVar.obtainMessage(94));
            strM15200y = "album version reset";
        } else if (i11 == 5032 || i11 == 50321) {
            strM15200y = "obs flow control";
        } else {
            strM15200y = SyncSessionManager.m15153t().m15200y(str);
            if (this.f11535h.m60421k(false, 3) != C9674k.c.CAN_START_SYNC) {
                i11 = this.f11535h.m60414d();
                strM15200y = this.f11535h.m60416f(i11);
            }
        }
        C1120a.m6675d("CloudAlbumSdkServiceImpl", "syncOpsReport reportCode: " + i11 + ", reportMsg: " + strM15200y);
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("04001")) {
                if (i11 != 152 && i11 != 109 && i11 != 104) {
                    if (C0076n.m619a().m623e()) {
                        new CommonOpsReport(this.f11531d).m15210D(str, "space_not_enough", i10, this.f11535h.m60412b(), i11, strM15200y, C0076n.m619a().m620b());
                    }
                    C1122c.m6777f(this.f11531d, C0076n.m619a().m620b(), C0076n.m619a().m623e(), C0076n.m619a().m622d(i10));
                }
                UBAAnalyze.m29947H("CKC", "cloudphoto_sync_end", m15080C(str, i10, i11, strM15200y));
                SyncSessionManager.m15153t().m15188l().clear();
            }
            Stat statM15195s = SyncSessionManager.m15153t().m15195s();
            if (statM15195s != null) {
                String sessionId = statM15195s.getSessionId();
                if (!TextUtils.isEmpty(sessionId) && sessionId.equals(str)) {
                    m15112i0("syncstate", SyncSessionManager.m15153t().m15195s());
                    m15111h0("syncstate", SyncSessionManager.m15153t().m15195s());
                    m15110g0(statM15195s);
                }
            }
            m15130u(str);
            new CommonOpsReport(this.f11531d).m15211E(str, "stopsync", i10, this.f11535h.m60412b(), i11, strM15200y, true);
            SyncSessionManager.m15153t().m15183g(str);
            if (str.startsWith("04001")) {
                SyncSessionManager.m15153t().m15175V(false);
                SyncSessionManager.m15153t().m15173T(false);
            }
            m15132v(str);
            if (str.startsWith("04001")) {
                m15128t(false);
            }
            m15129t0(str);
            C0070h.m527v().m567j(str);
            if (m15099V()) {
                C0070h.m527v().m588t0();
            }
        }
        return 0;
    }

    /* renamed from: t */
    public final void m15128t(boolean z10) {
        if (C0219i.f814b) {
            C12297a.m73908c().m73915h("auto-album-sync_apply");
            C12297a.m73908c().m73915h("user-sync_apply");
            if (!DownloadPhotoBase.m14411f() || z10) {
                C12297a.m73908c().m73915h("user-download_apply");
            }
        }
    }

    /* renamed from: t0 */
    public final void m15129t0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("04007")) {
            C13719a.m82479g(C1136q.d.m7153q(), str);
        } else if (str.startsWith("04001")) {
            C13719a.m82479g(C1136q.d.m7140d(), str);
        }
    }

    /* renamed from: u */
    public final void m15130u(String str) {
        if (str.startsWith("04001") && SyncSessionManager.m15153t().m15156C()) {
            C9665b.m60345b();
            SyncSessionManager.m15153t().m15169P(false);
        }
        if (str.startsWith("04007") && C0074l.m603c().m607e()) {
            C9665b.m60345b();
            C0074l.m603c().m611i(false);
        }
    }

    /* renamed from: u0 */
    public String m15131u0(int i10, int i11, String str) throws SQLException {
        if (!C13452e.m80781L().m80791C0()) {
            C1120a.m6677i("CloudAlbumSdkServiceImpl", "sync permission:user is paid service.");
            return m15085H(i10, i11, str);
        }
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "sync permission:user is basic service.");
        if (C1136q.m6977r() != 1 && (C1136q.m6977r() != 0 || (C1136q.m6976q() != 1 && C1136q.m6976q() != 2))) {
            if (C1136q.m6977r() == 0) {
                C1120a.m6677i("CloudAlbumSdkServiceImpl", "sync permission:basic service and not expires,cannot upload and copy.");
                return m15085H(i10, i11, str);
            }
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "sync permission:need to query data status from service fail.");
            return null;
        }
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "sync permission:basic service and expires,to close switch.");
        Bundle bundle = new Bundle();
        bundle.putBoolean("GeneralAblum", false);
        CloudAlbumManager.m14456v().m14470O(this.f11531d, bundle, 22);
        C1122c.m6764b2(22, false);
        return null;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public void unregisterCallback(ICloudAlbumSdkServiceCallback iCloudAlbumSdkServiceCallback) throws RemoteException {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "unregisterCallback");
        try {
            if (iCloudAlbumSdkServiceCallback != null) {
                C1120a.m6677i("CloudAlbumSdkServiceImpl", "unregister callback");
                this.f11535h.m60405K(true);
                this.f11528a.unregister(iCloudAlbumSdkServiceCallback);
            } else {
                C1120a.m6676e("CloudAlbumSdkServiceImpl", "unregisterCallback fail");
            }
        } catch (Exception e10) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "unregisterCallback error: " + e10);
        }
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int updateDownloadStatus(int i10, boolean z10) throws RemoteException {
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int updateSaveOriginalStatus(int i10, int i11, int i12) throws RemoteException {
        m15104a0(69, null);
        if (m15090M() || m15098U()) {
            return m15086I(69);
        }
        if (C13195l.m79272J().m79309Y()) {
            C1120a.m6678w("CloudAlbumSdkServiceImpl", "can not updateSaveOriginalStatus for userId changed.");
            C1122c.m6768c2();
            return 101;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("k1", i10);
        bundle.putInt("k3", i12);
        bundle.putInt("k2", i11);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(69, bundle));
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkService.Stub
    public int updateSyncPrompt(SyncPrompt syncPrompt) throws RemoteException {
        if (syncPrompt == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "syncPrompt is null, Invalid params!");
            return 102;
        }
        m15105b0(9, syncPrompt.toString(), null);
        if (m15090M() || m15098U()) {
            return m15086I(9);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("k1", syncPrompt);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(9, bundle));
        return 0;
    }

    /* renamed from: v */
    public final void m15132v(String str) {
        if (str.startsWith("04007")) {
            C0074l.m603c().m604a();
        }
    }

    /* renamed from: v0 */
    public final String m15133v0(String str) {
        if (str == null) {
            return null;
        }
        return Boolean.parseBoolean(str) ? "1" : "0";
    }

    /* renamed from: w */
    public final void m15134w(int i10, Bundle bundle) {
        if (bundle == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "dealPowerControlMessage bundle is null");
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        if (i10 == 6) {
            m15125r0(bundle, sb2);
            C1120a.m6677i("CloudAlbumSdkServiceImpl", "set control strategies: " + sb2.toString());
            return;
        }
        if (i10 != 7) {
            if (i10 != 8) {
                return;
            }
            int i11 = bundle.getInt("powerType");
            C1120a.m6677i("CloudAlbumSdkServiceImpl", "global setting: powerType=" + i11);
            C0070h.m527v().m570k0(i11);
            return;
        }
        boolean z10 = bundle.getBoolean("needControl");
        int i12 = bundle.getInt("policyType");
        sb2.append("needControl: ");
        sb2.append(z10);
        sb2.append(", policyType: ");
        sb2.append(i12);
        boolean zM542O = C0070h.m527v().m542O();
        C0070h.m527v().m568j0(z10);
        C0068f.m459d().m466j();
        if (C0070h.m527v().m583r() == 2 && !zM542O && z10) {
            C0070h.m527v().m582q0(false, C1136q.b.m7042a0(this.f11531d));
        }
        C0070h.m527v().m548U("update_control_policy", "set update control policy");
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "update control policy: " + sb2.toString());
    }

    /* renamed from: w0 */
    public final String m15135w0(boolean z10) {
        return z10 ? "1" : "0";
    }

    /* renamed from: x */
    public void m15136x() {
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "destroy");
        C12515a.m75110o().m75175e(new g(this, null), true);
        this.f11532e.destroy();
        this.f11535h.m60411a();
        this.f11534g.quitSafely();
        this.f11530c.quitSafely();
        this.f11538k.quitSafely();
        C0068f.m459d().m470n();
    }

    /* renamed from: x0 */
    public final void m15137x0(Bundle bundle) {
        if (bundle == null) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "updateReceivedTime bundle is null");
            return;
        }
        long j10 = bundle.getLong("detectReceiveTime");
        C1120a.m6677i("CloudAlbumSdkServiceImpl", "updateReceivedTime: " + j10);
        this.f11536i.m421n(j10);
    }

    /* renamed from: y */
    public final int m15138y(int i10, int i11, int i12) {
        m15105b0(i10, i11 + ", " + i12, null);
        if (i11 < 1 || i11 > 3 || i12 < 1 || i12 > 7) {
            C1120a.m6676e("CloudAlbumSdkServiceImpl", "transType: " + i11 + ", or thumbType: " + i12 + " is invalid! Invalid params!");
            return 102;
        }
        if (m15090M() || m15098U()) {
            return m15086I(i10);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("k1", i11);
        bundle.putInt("k2", i12);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(i10, bundle));
        return 0;
    }

    /* renamed from: z */
    public final int m15139z(int i10, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("k1", str);
        m15124r();
        e eVar = this.f11533f;
        eVar.sendMessage(eVar.obtainMessage(i10, bundle));
        return 0;
    }
}
