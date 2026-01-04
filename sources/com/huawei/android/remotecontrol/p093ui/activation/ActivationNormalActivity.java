package com.huawei.android.remotecontrol.p093ui.activation;

import android.R;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import bf.C1175a;
import com.huawei.android.hicloud.oobe.R$dimen;
import com.huawei.android.hicloud.oobe.R$drawable;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBETopView;
import com.huawei.android.hicloud.p088ui.extend.NotchBottomFitRelativeLayout;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity;
import com.huawei.android.remotecontrol.p093ui.activation.ActivationNormalActivity;
import com.huawei.android.remotecontrol.p093ui.activation.RemoteActivationUtil;
import com.huawei.android.remotecontrol.p093ui.widget.SpanClickText;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.util.account.bean.AccountInfo;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hms.framework.network.restclient.hwhttp.HttpClientGlobalInstance;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.hms.support.hwid.HuaweiIdAdvancedManager;
import com.huawei.hms.support.hwid.bean.CheckPasswordByUserIdReq;
import com.huawei.hms.support.hwid.common.cloudservice.CloudRequestHandler;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwprogressbar.widget.HwProgressBar;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import com.huawei.uikit.phone.hwedittext.widget.HwErrorTipTextLayout;
import eg.AbstractC9478g;
import eg.C9477f;
import fk.C9721b;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import ng.C11703j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p015ak.C0226l0;
import p015ak.C0241z;
import p394jf.C10817e;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p520of.C11853c;
import p520of.C11860j;
import p520of.C11866p;
import p521og.C11870c;
import p521og.C11871d;
import p521og.C11873f;
import p521og.C11875h;
import p521og.C11877j;
import p521og.C11880m;
import p521og.C11881n;
import p575qe.C12347f;
import p576qf.InterfaceC12348a;
import p611rf.C12500h;
import p616rk.C12515a;
import p664u0.C13108a;
import p681uj.C13195l;
import p709vj.C13452e;
import p709vj.InterfaceC13456i;
import p742wj.C13612b;
import p783xp.AbstractC13844b;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sg.C12796a;
import sg.C12797b;
import sk.C12809f;

/* loaded from: classes4.dex */
public class ActivationNormalActivity extends ActivationBaseActivity {

    /* renamed from: J */
    public View f20596J;

    /* renamed from: K */
    public HwButton f20597K;

    /* renamed from: M */
    public TextView f20599M;

    /* renamed from: N */
    public HwProgressBar f20600N;

    /* renamed from: O */
    public TextView f20601O;

    /* renamed from: P */
    public TextView f20602P;

    /* renamed from: Q */
    public TextView f20603Q;

    /* renamed from: R */
    public View f20604R;

    /* renamed from: S */
    public View f20605S;

    /* renamed from: T */
    public View f20606T;

    /* renamed from: U */
    public View f20607U;

    /* renamed from: V */
    public View f20608V;

    /* renamed from: W */
    public View f20609W;

    /* renamed from: X */
    public View f20610X;

    /* renamed from: Y */
    public View f20611Y;

    /* renamed from: Z */
    public TextView f20612Z;

    /* renamed from: a0 */
    public View f20613a0;

    /* renamed from: b0 */
    public View f20614b0;

    /* renamed from: c0 */
    public TextView f20615c0;

    /* renamed from: d0 */
    public HwButton f20616d0;

    /* renamed from: e0 */
    public C4497l f20617e0;

    /* renamed from: f0 */
    public SpanClickText f20618f0;

    /* renamed from: g0 */
    public HandlerC4498m f20619g0;

    /* renamed from: h0 */
    public C4493h f20620h0;

    /* renamed from: m0 */
    public C4491f f20625m0;

    /* renamed from: n0 */
    public ViewTreeObserverOnGlobalLayoutListenerC4496k f20626n0;

    /* renamed from: H */
    public boolean f20594H = false;

    /* renamed from: I */
    public int f20595I = 0;

    /* renamed from: L */
    public C4489d f20598L = null;

    /* renamed from: i0 */
    public boolean f20621i0 = false;

    /* renamed from: j0 */
    public boolean f20622j0 = false;

    /* renamed from: k0 */
    public String f20623k0 = "";

    /* renamed from: l0 */
    public Bundle f20624l0 = new Bundle();

    /* renamed from: o0 */
    public RemoteActivationUtil.InterfaceC4525c f20627o0 = new RemoteActivationUtil.InterfaceC4525c() { // from class: hg.f
        @Override // com.huawei.android.remotecontrol.p093ui.activation.RemoteActivationUtil.InterfaceC4525c
        public final void onFinish() {
            this.f49482a.m27345s2();
        }
    };

    /* renamed from: p0 */
    public boolean f20628p0 = false;

    /* renamed from: q0 */
    public boolean f20629q0 = false;

    /* renamed from: r0 */
    public boolean f20630r0 = false;

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationNormalActivity$a */
    public class ViewTreeObserverOnGlobalLayoutListenerC4486a implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserverOnGlobalLayoutListenerC4486a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ActivationNormalActivity.this.f20604R.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (ActivationNormalActivity.this.f20601O.getLineCount() > 1 || ActivationNormalActivity.this.f20602P.getLineCount() > 1) {
                C11842p.m70712A2(ActivationNormalActivity.this.f20607U, true);
                ActivationNormalActivity.this.f20606T.setVisibility(8);
                C11842p.m70712A2(ActivationNormalActivity.this.f20605S, false);
                ViewGroup.LayoutParams layoutParams = ActivationNormalActivity.this.f20601O.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
                }
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationNormalActivity$b */
    public class ViewOnSystemUiVisibilityChangeListenerC4487b implements View.OnSystemUiVisibilityChangeListener {
        public ViewOnSystemUiVisibilityChangeListenerC4487b() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i10) {
            C11829c.m70585i1(ActivationNormalActivity.this.getWindow());
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationNormalActivity$c */
    public class C4488c extends AbstractC9478g {
        public C4488c() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws IllegalAccessException, C9721b, IllegalArgumentException, InvocationTargetException {
            C1175a.m7384f();
            HiAnalyticsManager.disableDefaultInstanceReport();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationNormalActivity$d */
    public static class C4489d extends BroadcastReceiver {

        /* renamed from: a */
        public final WeakReference<ActivationNormalActivity> f20634a;

        public C4489d(ActivationNormalActivity activationNormalActivity) {
            this.f20634a = new WeakReference<>(activationNormalActivity);
        }

        /* renamed from: b */
        public static /* synthetic */ void m27412b(boolean z10) {
            if (z10) {
                return;
            }
            C11860j.m71010N0("updateAccountSiteId");
        }

        /* renamed from: c */
        public final void m27413c(ActivationNormalActivity activationNormalActivity) {
            if (!C11870c.m71157e(C1175a.m7394p())) {
                C13981a.m83989i("ActivationNormalActivity", "showTaError: socIdOrigin is empty");
                activationNormalActivity.m27383a3();
            } else {
                C13981a.m83989i("ActivationNormalActivity", "useSocIdOrigin retry");
                activationNormalActivity.f20628p0 = true;
                activationNormalActivity.m27384b2();
            }
        }

        /* renamed from: d */
        public final void m27414d(Context context, SafeIntent safeIntent) {
            try {
                Bundle bundleExtra = safeIntent.getBundleExtra(RemoteMessageConst.MessageBody.PARAM);
                if (bundleExtra == null) {
                    C13981a.m83988e("ActivationNormalActivity", "get data failed when in site error");
                    return;
                }
                ActivationNormalActivity activationNormalActivity = context instanceof ActivationNormalActivity ? (ActivationNormalActivity) context : null;
                String string = bundleExtra.getString(HwPayConstant.KEY_SITE_ID);
                C13981a.m83987d("ActivationNormalActivity", "update site id is:" + string);
                if (TextUtils.isEmpty(string) || activationNormalActivity == null || string.equals(AbstractC12139d.m72766e(context).getSiteID())) {
                    return;
                }
                C13981a.m83989i("ActivationNormalActivity", "site has switched so update teeAccount info");
                AbstractC12139d.m72766e(context).setSiteID(string);
                C11860j.m71000I0(AbstractC12139d.m72766e(context).getDeviceID(), "active lock page, updateAccountSiteId");
                AbstractC12139d.m72772k(context.getApplicationContext(), new InterfaceC12348a() { // from class: hg.h
                    @Override // p576qf.InterfaceC12348a
                    public final void onResult(boolean z10) {
                        ActivationNormalActivity.C4489d.m27412b(z10);
                    }
                });
            } catch (Exception e10) {
                C13981a.m83988e("ActivationNormalActivity", "updateAccountSiteId error " + e10);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws Resources.NotFoundException {
            if (intent == null) {
                C13981a.m83989i("ActivationNormalActivity", "ActivationReceiver intent is null.");
                return;
            }
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            if (hiCloudSafeIntent.getAction() == null) {
                C13981a.m83989i("ActivationNormalActivity", "ActivationReceiver action is null.");
                return;
            }
            ActivationNormalActivity activationNormalActivity = this.f20634a.get();
            if (activationNormalActivity == null) {
                C13981a.m83989i("ActivationNormalActivity", "activity is null.");
                return;
            }
            if (activationNormalActivity.f20619g0 != null) {
                activationNormalActivity.f20619g0.removeMessages(6);
            }
            if ("com.huawei.android.hicloud.intent.PHONEFINDER_DEVICE_DEL".equals(hiCloudSafeIntent.getAction())) {
                C13981a.m83989i("ActivationNormalActivity", "ActivationReceiver onReceive ACTION_PHONEFINDER_DEVICE_DEL");
                activationNormalActivity.m27360H2();
                return;
            }
            if ("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_ACCOUNTINFO_SUCCESS".equals(hiCloudSafeIntent.getAction())) {
                if (activationNormalActivity.f20628p0) {
                    C13981a.m83987d("ActivationNormalActivity", "mUseSocIdOrigin");
                    return;
                } else {
                    activationNormalActivity.m27359G2(hiCloudSafeIntent.getExtras());
                    return;
                }
            }
            if ("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_CONNET_FAIL".equals(hiCloudSafeIntent.getAction()) || "com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_DATA_MIGRATING".equals(hiCloudSafeIntent.getAction())) {
                activationNormalActivity.f20595I = 1;
                activationNormalActivity.m27373V2();
                return;
            }
            if ("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_SITE_ERROR".equals(hiCloudSafeIntent.getAction())) {
                activationNormalActivity.f20622j0 = true;
                activationNormalActivity.f20595I = 1;
                activationNormalActivity.m27373V2();
                m27414d(activationNormalActivity, hiCloudSafeIntent);
                return;
            }
            if ("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_APPEAL_SUCCESS".equals(hiCloudSafeIntent.getAction())) {
                RemoteActivationUtil.m27647r().m27654G();
                return;
            }
            if (!"com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_QUERY_INFO_SUCCESS".equals(hiCloudSafeIntent.getAction())) {
                if (!"com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_QUERY_RESULT_CODE".equals(hiCloudSafeIntent.getAction())) {
                    if ("com.huawei.android.remotecontrol.intent.LOST_PATTERN_MODE_CHANGED".equals(hiCloudSafeIntent.getAction())) {
                        boolean zM71236U = C11877j.m71236U(activationNormalActivity);
                        C13981a.m83989i("ActivationNormalActivity", "isLossMode = " + zM71236U);
                        if (!zM71236U || C1175a.m7385g(false)) {
                            return;
                        }
                        activationNormalActivity.f20629q0 = true;
                        activationNormalActivity.m27370T2(activationNormalActivity.f20630r0);
                        activationNormalActivity.m27369S2(true);
                        return;
                    }
                    return;
                }
                int intExtra = hiCloudSafeIntent.getIntExtra(MapKeyNames.RESULT_CODE, -1);
                C13981a.m83989i("ActivationNormalActivity", "onReceive socid error resultCode " + intExtra);
                new C12796a().m76773f(activationNormalActivity, "001_3008", "receive bad socid status, resultCode " + intExtra, "001_3008", "01012", null, "activeActivity", null);
                if (!activationNormalActivity.f20628p0) {
                    m27413c(activationNormalActivity);
                    return;
                } else {
                    C13981a.m83989i("ActivationNormalActivity", "showTaError: useSocIdOrigin");
                    activationNormalActivity.m27383a3();
                    return;
                }
            }
            String stringExtra = hiCloudSafeIntent.getStringExtra("params");
            if (TextUtils.isEmpty(stringExtra)) {
                C13981a.m83988e("ActivationNormalActivity", "onReceive params empty");
                activationNormalActivity.m27388d2();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                if (activationNormalActivity.f20628p0) {
                    int intExtra2 = hiCloudSafeIntent.getIntExtra(MapKeyNames.RESULT_CODE, -1);
                    if (intExtra2 == 0) {
                        activationNormalActivity.m27381Z2(false);
                        return;
                    }
                    C13981a.m83988e("ActivationNormalActivity", "onReceive success unknown resultCode " + intExtra2);
                    activationNormalActivity.m27383a3();
                    return;
                }
                activationNormalActivity.m27365O2(jSONObject);
                int intExtra3 = hiCloudSafeIntent.getIntExtra(MapKeyNames.RESULT_CODE, -1);
                if (intExtra3 == 0) {
                    activationNormalActivity.m27391f2(jSONObject);
                    return;
                }
                if (intExtra3 == 3001) {
                    activationNormalActivity.m27390e2(jSONObject);
                    return;
                }
                C13981a.m83988e("ActivationNormalActivity", "onReceive success unknown resultCode " + intExtra3);
                m27413c(activationNormalActivity);
            } catch (JSONException unused) {
                C13981a.m83988e("ActivationNormalActivity", "onReceive bad json");
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationNormalActivity$e */
    public static class C4490e extends TimerTask {

        /* renamed from: a */
        public volatile boolean f20635a;

        /* renamed from: b */
        public volatile int f20636b;

        /* renamed from: c */
        public Timer f20637c;

        /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationNormalActivity$e$a */
        public static class a {

            /* renamed from: a */
            public static final C4490e f20638a = new C4490e(null);
        }

        public /* synthetic */ C4490e(ViewTreeObserverOnGlobalLayoutListenerC4486a viewTreeObserverOnGlobalLayoutListenerC4486a) {
            this();
        }

        /* renamed from: a */
        public static void m27415a() {
            a.f20638a.m27416c();
        }

        /* renamed from: c */
        public final void m27416c() {
            if (!this.f20635a && this.f20636b <= 3) {
                m27417d();
                Timer timer = new Timer();
                this.f20637c = timer;
                timer.schedule(this, 0L, 30000L);
                this.f20635a = true;
            }
        }

        /* renamed from: d */
        public final void m27417d() {
            Timer timer = this.f20637c;
            if (timer != null) {
                timer.cancel();
                this.f20637c = null;
            }
            this.f20635a = false;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C13981a.m83987d("ActivationNormalActivity", "registerPush");
            this.f20636b++;
            if (this.f20636b <= 3 && C1175a.m7389k(C0213f.m1377a())) {
                C13981a.m83989i("ActivationNormalActivity", "GetPushToken time:" + this.f20636b);
                C11881n.m71368r(C12347f.m74285n().m74301m());
            }
            if (this.f20636b > 3) {
                m27417d();
            }
        }

        public C4490e() {
            this.f20635a = false;
            this.f20636b = 0;
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationNormalActivity$f */
    public class C4491f extends ActivationBaseActivity.LogOffReceive {

        /* renamed from: b */
        public WeakReference<ActivationNormalActivity> f20639b;

        /* renamed from: c */
        public AccountInfo f20640c;

        public C4491f(ActivationNormalActivity activationNormalActivity, AccountInfo accountInfo) {
            this.f20639b = new WeakReference<>(activationNormalActivity);
            this.f20640c = accountInfo;
        }

        /* renamed from: h */
        public final /* synthetic */ void m27424h() {
            C11880m.m71337d(ActivationNormalActivity.this.getApplicationContext(), ActivationNormalActivity.this.getString(R$string.activate_error_too_many_times_please_24_retry, 10, 24));
        }

        /* renamed from: i */
        public final /* synthetic */ void m27425i() {
            C11880m.m71336c(ActivationNormalActivity.this.getApplicationContext(), R$string.check_account_vt_fail);
        }

        /* renamed from: j */
        public final /* synthetic */ void m27426j() {
            C11880m.m71336c(ActivationNormalActivity.this.getApplicationContext(), R$string.activate_error_timeout);
        }

        /* renamed from: k */
        public final /* synthetic */ void m27427k(String str) {
            C11880m.m71337d(ActivationNormalActivity.this.getApplicationContext(), str);
        }

        /* renamed from: l */
        public final /* synthetic */ void m27428l() {
            C11880m.m71336c(ActivationNormalActivity.this.getApplicationContext(), R$string.activate_error_lockscreen_invalid);
        }

        @Override // com.huawei.android.remotecontrol.ui.activation.ActivationBaseActivity.LogOffReceive, android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C13981a.m83989i("ActivationNormalActivity", "LogoffVerifyReceiver onReceive");
            ActivationNormalActivity activationNormalActivity = this.f20639b.get();
            if (intent == null) {
                C13981a.m83988e("ActivationNormalActivity", "mLogoffReceiver intent is null");
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            if (safeIntent.getAction() == null) {
                C13981a.m83988e("ActivationNormalActivity", "mLogoffReceiver action is null");
                return;
            }
            m27268b(context);
            C13981a.m83989i("ActivationNormalActivity", "logoff action " + safeIntent.getAction());
            if (activationNormalActivity != null) {
                activationNormalActivity.m27254P0();
            }
            if ("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_COMPLETED".equals(safeIntent.getAction())) {
                C11860j.m70994F0(false, this.f20640c);
                AbstractC12139d.m72764c(C12347f.m74285n().m74301m());
                if (activationNormalActivity != null) {
                    activationNormalActivity.mo27259Y0(true);
                    return;
                }
                return;
            }
            if ("com.huawei.android.hicloud.intent.PHONEFINDER_CLOSE_AUTH_FAILE".equals(safeIntent.getAction())) {
                ActivationNormalActivity.this.m27373V2();
                return;
            }
            if ("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_FAIL".equals(safeIntent.getAction())) {
                int intExtra = safeIntent.getIntExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, -1);
                C13981a.m83989i("ActivationNormalActivity", "logoff failed errorCode " + intExtra);
                new C12796a().m76773f(activationNormalActivity, "001_3008", "logoff failed errorCode " + intExtra, "001_3008", "01012", null, "activeActivity", null);
                if (intExtra == 3209) {
                    ActivationNormalActivity.this.m27264f1(409, 1, 1);
                    return;
                }
                if (intExtra == 3213) {
                    C0226l0.m1584d(new Runnable() { // from class: hg.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f49498a.m27428l();
                        }
                    });
                    return;
                }
                switch (intExtra) {
                    case 3202:
                        C0226l0.m1584d(new Runnable() { // from class: hg.i
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f49488a.m27424h();
                            }
                        });
                        break;
                    case 3203:
                        C0226l0.m1584d(new Runnable() { // from class: hg.j
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f49490a.m27425i();
                            }
                        });
                        break;
                    case 3204:
                        ActivationNormalActivity.this.m27264f1(405, 1, 1);
                        break;
                    case 3205:
                        C0226l0.m1584d(new Runnable() { // from class: hg.k
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f49492a.m27426j();
                            }
                        });
                        break;
                    case 3206:
                        final String str = ActivationNormalActivity.this.getString(R$string.activate_error_cannot_conn_server) + " (" + intExtra + ")";
                        C0226l0.m1584d(new Runnable() { // from class: hg.l
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f49495a.m27427k(str);
                            }
                        });
                        break;
                    case 3207:
                        ActivationNormalActivity.this.m27264f1(408, 1, 1);
                        break;
                    default:
                        C13981a.m83988e("ActivationNormalActivity", "unknown resultCode " + intExtra);
                        break;
                }
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationNormalActivity$g */
    public static class C4492g implements CloudRequestHandler {

        /* renamed from: a */
        public final WeakReference<ActivationNormalActivity> f20642a;

        public C4492g(ActivationNormalActivity activationNormalActivity) {
            this.f20642a = new WeakReference<>(activationNormalActivity);
        }

        @Override // com.huawei.hms.support.hwid.common.cloudservice.CloudRequestHandler
        public void onError(ErrorStatus errorStatus) {
            String str;
            C13981a.m83988e("ActivationNormalActivity", "onError");
            ActivationNormalActivity activationNormalActivity = this.f20642a.get();
            if (activationNormalActivity == null) {
                C13981a.m83988e("ActivationNormalActivity", "onError activity null, return");
                return;
            }
            if (errorStatus == null) {
                C13981a.m83988e("ActivationNormalActivity", "onError ErrorStatus null");
            }
            if (errorStatus != null) {
                C13981a.m83988e("ActivationNormalActivity", "onError: " + errorStatus.getErrorCode());
                str = errorStatus.getErrorCode() + ",reason:" + errorStatus.getErrorReason();
            } else {
                str = "";
            }
            if (activationNormalActivity.f20619g0 != null) {
                activationNormalActivity.f20619g0.removeMessages(3);
            }
            activationNormalActivity.m27410z2(errorStatus);
            new C12796a().m76773f(this.f20642a.get(), "001_3008", "check password by hwid error:" + str, "001_3008", "01012", null, "check password by hwid", null);
        }

        @Override // com.huawei.hms.support.hwid.common.cloudservice.CloudRequestHandler
        public void onFinish(Bundle bundle) {
            ActivationNormalActivity activationNormalActivity = this.f20642a.get();
            if (activationNormalActivity == null) {
                C13981a.m83988e("ActivationNormalActivity", "onFinish activity null, return");
                return;
            }
            if (bundle == null) {
                C13981a.m83988e("ActivationNormalActivity", "onFinish bundle null, return");
                activationNormalActivity.m27254P0();
            } else {
                C13981a.m83989i("ActivationNormalActivity", "checkPassword finish");
                if (activationNormalActivity.f20619g0 != null) {
                    activationNormalActivity.f20619g0.removeMessages(3);
                }
                activationNormalActivity.m27355C2(bundle);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationNormalActivity$h */
    public static class C4493h implements InterfaceC13456i {

        /* renamed from: a */
        public final WeakReference<ActivationNormalActivity> f20643a;

        public C4493h(ActivationNormalActivity activationNormalActivity) {
            this.f20643a = new WeakReference<>(activationNormalActivity);
        }

        @Override // p709vj.InterfaceC13456i
        public void loginResult(boolean z10) {
            ActivationNormalActivity activationNormalActivity = this.f20643a.get();
            if (activationNormalActivity == null || activationNormalActivity.f20619g0 == null) {
                C13981a.m83988e("ActivationNormalActivity", "activity or mUiHandler null");
                return;
            }
            if (z10) {
                activationNormalActivity.f20619g0.sendEmptyMessage(2);
                return;
            }
            String strM79270H = C13195l.m79270H(activationNormalActivity);
            if (TextUtils.isEmpty(strM79270H)) {
                C11839m.m70687e("ActivationNormalActivity", "hmsPackage is invalid!");
                return;
            }
            C13981a.m83989i("ActivationNormalActivity", "packageName:" + strM79270H);
            if (C0209d.m1187L0(activationNormalActivity, strM79270H)) {
                activationNormalActivity.f20619g0.sendEmptyMessage(1);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationNormalActivity$i */
    public class C4494i implements TextWatcher {
        public C4494i() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            HwErrorTipTextLayout hwErrorTipTextLayout = (HwErrorTipTextLayout) C12809f.m76829b(ActivationNormalActivity.this, R$id.activation_password_layout);
            if (hwErrorTipTextLayout != null && !TextUtils.isEmpty(hwErrorTipTextLayout.getError())) {
                hwErrorTipTextLayout.setError(null);
            }
            TextView textView = (TextView) C12809f.m76829b(ActivationNormalActivity.this, R$id.activation_password_error);
            if (textView != null) {
                textView.setText("");
                textView.setVisibility(8);
            }
            if (ActivationNormalActivity.this.f20543F.getText().toString().isEmpty()) {
                ActivationNormalActivity.this.f20597K.setEnabled(false);
            } else {
                ActivationNormalActivity.this.f20597K.setEnabled(true);
            }
        }

        public /* synthetic */ C4494i(ActivationNormalActivity activationNormalActivity, ViewTreeObserverOnGlobalLayoutListenerC4486a viewTreeObserverOnGlobalLayoutListenerC4486a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationNormalActivity$j */
    public static class C4495j extends AbstractC9478g {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13981a.m83989i("ActivationNormalActivity", "readAntiTheftData");
            boolean zM7389k = C1175a.m7389k(C0213f.m1377a());
            AccountInfo accountInfoM72767f = AbstractC12139d.m72767f(C0213f.m1377a(), true);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("readAntiTheftData enable=");
            sb2.append(zM7389k);
            sb2.append(" , info=");
            sb2.append(accountInfoM72767f != null);
            C13981a.m83989i("ActivationNormalActivity", sb2.toString());
            Handler handlerM71180b = C11873f.m71178f().m71180b();
            if (handlerM71180b != null) {
                handlerM71180b.sendMessage(Message.obtain(handlerM71180b, 3110));
            }
            if (accountInfoM72767f != null) {
                C11860j.m71000I0(accountInfoM72767f.getDeviceID(), "activation page, read TA account info");
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationNormalActivity$k */
    public static class ViewTreeObserverOnGlobalLayoutListenerC4496k implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        public int f20645a;

        /* renamed from: b */
        public final WeakReference<ActivationNormalActivity> f20646b;

        /* renamed from: c */
        public ViewGroup.LayoutParams f20647c;

        public ViewTreeObserverOnGlobalLayoutListenerC4496k(ActivationNormalActivity activationNormalActivity) {
            this.f20646b = new WeakReference<>(activationNormalActivity);
        }

        /* renamed from: a */
        public final int m27429a(View view) {
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            return (rect.bottom - rect.top) + C11842p.m70789a0(this.f20646b.get());
        }

        /* renamed from: b */
        public final View m27430b() {
            FrameLayout frameLayout;
            ActivationNormalActivity activationNormalActivity = this.f20646b.get();
            if (activationNormalActivity == null || (frameLayout = (FrameLayout) C12809f.m76829b(activationNormalActivity, R.id.content)) == null) {
                return null;
            }
            View childAt = frameLayout.getChildAt(0);
            this.f20647c = childAt.getLayoutParams();
            return childAt;
        }

        /* renamed from: c */
        public final void m27431c() {
            int iM27429a;
            View viewM27430b = m27430b();
            if (viewM27430b == null || (iM27429a = m27429a(viewM27430b)) == this.f20645a) {
                return;
            }
            int height = viewM27430b.getRootView().getHeight();
            int i10 = height - iM27429a;
            ActivationNormalActivity activationNormalActivity = this.f20646b.get();
            if (activationNormalActivity == null) {
                return;
            }
            if (i10 > height / 4) {
                if (C0219i.m1463a() >= 21) {
                    this.f20647c.height = height - i10;
                }
                activationNormalActivity.m27318I2(true);
            } else {
                if (C0219i.m1463a() >= 21) {
                    this.f20647c.height = height;
                }
                activationNormalActivity.m27318I2(false);
            }
            viewM27430b.requestLayout();
            this.f20645a = iM27429a;
        }

        /* renamed from: d */
        public void m27432d() {
            ViewTreeObserver viewTreeObserver;
            View viewM27430b = m27430b();
            if (viewM27430b == null || (viewTreeObserver = viewM27430b.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }

        /* renamed from: e */
        public void m27433e() {
            ViewTreeObserver viewTreeObserver;
            View viewM27430b = m27430b();
            if (viewM27430b == null || (viewTreeObserver = viewM27430b.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            m27431c();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationNormalActivity$l */
    public static class C4497l implements SpanClickText.ISpanClickListem {

        /* renamed from: a */
        public WeakReference<ActivationNormalActivity> f20648a;

        public C4497l(ActivationNormalActivity activationNormalActivity) {
            this.f20648a = new WeakReference<>(activationNormalActivity);
        }

        @Override // com.huawei.android.remotecontrol.ui.widget.SpanClickText.ISpanClickListem
        public void onClick(int i10) {
            ActivationNormalActivity activationNormalActivity = this.f20648a.get();
            C13981a.m83987d("ActivationNormalActivity", "SpanClickList--onClick:activity=" + activationNormalActivity);
            if (activationNormalActivity == null) {
                return;
            }
            activationNormalActivity.m27399n2();
            Intent intent = new Intent(activationNormalActivity, (Class<?>) ActivationIntroduceActivity.class);
            intent.putExtra("hw_frp_token", activationNormalActivity.f12404B);
            activationNormalActivity.startActivityForResult(intent, 1);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationNormalActivity$m */
    public static class HandlerC4498m extends Handler {

        /* renamed from: a */
        public final WeakReference<ActivationNormalActivity> f20649a;

        public HandlerC4498m(ActivationNormalActivity activationNormalActivity) {
            super(Looper.getMainLooper());
            this.f20649a = new WeakReference<>(activationNormalActivity);
        }

        /* renamed from: a */
        public final void m27434a(ActivationNormalActivity activationNormalActivity, int i10) throws Resources.NotFoundException {
            if (activationNormalActivity == null) {
                return;
            }
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 37 && i10 != 401) {
                if (i10 == 2003) {
                    activationNormalActivity.m27262d1(2);
                    return;
                }
                if (i10 == 2005) {
                    activationNormalActivity.m27258X0();
                    return;
                }
                if (i10 != 3002 && i10 != 70001201) {
                    if (i10 == 70002003) {
                        activationNormalActivity.m27409y2(70002003);
                        return;
                    }
                    if (i10 == 70002076) {
                        activationNormalActivity.m27409y2(70002076);
                        return;
                    }
                    if (i10 != 3005 && i10 != 3006) {
                        switch (i10) {
                            case 70002057:
                                activationNormalActivity.m27409y2(70002057);
                                break;
                            case 70002058:
                                activationNormalActivity.m27409y2(70002058);
                                break;
                            default:
                                activationNormalActivity.m27263e1(3, i10);
                                break;
                        }
                        return;
                    }
                }
            }
            activationNormalActivity.m27263e1(402, i10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            ActivationNormalActivity activationNormalActivity = this.f20649a.get();
            if (activationNormalActivity == null) {
                C13981a.m83989i("ActivationNormalActivity", "handleMessage activity null");
                return;
            }
            int i10 = message.what;
            if (i10 == 0) {
                m27434a(activationNormalActivity, message.arg1);
                return;
            }
            if (i10 == 1) {
                activationNormalActivity.m27370T2(true);
                return;
            }
            if (i10 == 2) {
                activationNormalActivity.m27370T2(false);
                return;
            }
            if (i10 == 3) {
                C13981a.m83989i("ActivationNormalActivity", "check password timeout");
                activationNormalActivity.m27254P0();
                return;
            }
            if (i10 == 5) {
                activationNormalActivity.m27254P0();
                activationNormalActivity.m27262d1(401);
                return;
            }
            if (i10 == 6) {
                activationNormalActivity.f20595I = 1;
                activationNormalActivity.m27373V2();
            } else if (i10 != 3105) {
                if (i10 != 3110) {
                    return;
                }
                activationNormalActivity.m27362K2();
            } else {
                Object obj = message.obj;
                if (obj instanceof Boolean) {
                    activationNormalActivity.m27361J2(((Boolean) obj).booleanValue());
                }
            }
        }
    }

    /* renamed from: I2 */
    public void m27318I2(boolean z10) {
        OOBETopView oOBETopView = this.f12350j;
        if (oOBETopView == null) {
            return;
        }
        oOBETopView.setVisibility(z10 ? 8 : 0);
    }

    /* renamed from: M2 */
    private void m27323M2() {
        if (this.f20598L == null) {
            this.f20598L = new C4489d(this);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_DEVICE_DEL");
        intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_ACCOUNTINFO_SUCCESS");
        intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_CONNET_FAIL");
        intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_SITE_ERROR");
        intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_DATA_MIGRATING");
        intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_APPEAL_SUCCESS");
        intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_QUERY_INFO_SUCCESS");
        intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_QUERY_RESULT_CODE");
        intentFilter.addAction("com.huawei.android.remotecontrol.intent.LOST_PATTERN_MODE_CHANGED");
        C13108a.m78878b(this).m78880c(this.f20598L, intentFilter);
    }

    /* renamed from: V1 */
    private String m27331V1(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        } else if (!str.contains("*")) {
            C13981a.m83988e("ActivationNormalActivity", "accountName is not mask");
            str = C11871d.m71159b(str);
        }
        if (C11881n.m71341D()) {
            return str;
        }
        return "\u202d" + str + "\u202c";
    }

    /* renamed from: e3 */
    private void m27332e3() {
        if (this.f20598L != null) {
            C13108a.m78878b(this).m78883f(this.f20598L);
        }
    }

    /* renamed from: g2 */
    private void m27333g2() {
        Intent intent = new Intent(getApplicationContext(), (Class<?>) ActivationAppealActivity.class);
        intent.putExtra("hw_frp_token", this.f12404B);
        intent.putExtra("isCloudActivation", this.f20594H);
        startActivity(intent);
    }

    /* renamed from: s2 */
    public /* synthetic */ void m27345s2() {
        mo27259Y0(true);
    }

    /* renamed from: A2 */
    public final void m27353A2(Bundle bundle) {
        C13981a.m83989i("ActivationNormalActivity", "onFinish");
        if (isFinishing()) {
            return;
        }
        C11875h.m71194e(this, true);
        if (this.f20625m0 == null) {
            this.f20625m0 = new C4491f(this, AbstractC12139d.m72766e(this));
        }
        this.f20625m0.m27267a(getApplicationContext());
        C11860j.m71014P0(this);
    }

    /* renamed from: B2 */
    public final void m27354B2(boolean z10, String str) {
        C13981a.m83989i("ActivationNormalActivity", "onFinish");
        if (isFinishing()) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            C11875h.m71194e(this, true);
            if (this.f20625m0 == null) {
                this.f20625m0 = new C4491f(this, AbstractC12139d.m72766e(this));
            }
            this.f20625m0.m27267a(getApplicationContext());
            C11860j.m71018R0(getApplicationContext(), z10, str);
            return;
        }
        C13981a.m83988e("ActivationNormalActivity", "empty string isVt " + z10);
        new C12796a().m76773f(this, "001_3008", z10 ? "can not get verify token from HuaweiId" : "can not get signature from lock setting", "001_3008", "01012", null, "activeActivity", null);
        if (z10) {
            C0226l0.m1584d(new Runnable() { // from class: hg.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49474a.m27405u2();
                }
            });
        } else {
            C0226l0.m1584d(new Runnable() { // from class: hg.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49476a.m27406v2();
                }
            });
        }
        m27254P0();
    }

    /* renamed from: C2 */
    public final void m27355C2(Bundle bundle) {
        C13981a.m83989i("ActivationNormalActivity", "onVerifySuccess");
        C11860j.m71037a1(401);
        C11860j.m71030X0(401);
        m27354B2(true, bundle.getString(CommonConstant.KEY_ID_TOKEN, ""));
        new C12796a().m76773f(C12347f.m74285n().m74301m(), "0", "check pwd finish, inactive", null, "01012", null, "activeActivity", null);
    }

    /* renamed from: D2 */
    public final void m27356D2() {
        mo16660F0();
    }

    /* renamed from: E2 */
    public final void m27357E2() throws JSONException, InterruptedException {
        C13981a.m83989i("ActivationNormalActivity", "onLockScreenActive");
        if (!C0209d.m1333z1(this)) {
            m27258X0();
            return;
        }
        TextView textView = this.f20599M;
        if (textView != null) {
            textView.setEnabled(false);
        }
        if (!C11860j.m71031Y() || !m27403r2()) {
            m27387c3(null);
            return;
        }
        C13981a.m83989i("ActivationNormalActivity", "onLockScreenActive get challenge");
        m27408x2(true);
        String strM71110i = C11866p.m71110i();
        if (strM71110i != null) {
            m27387c3(strM71110i);
            return;
        }
        C13981a.m83989i("ActivationNormalActivity", "get challenge null");
        new C12796a().m76773f(this, "001_3008", "can not get challenge from cloud", "001_3008", "01012", null, "activeActivity", null);
        C0226l0.m1584d(new Runnable() { // from class: hg.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f49485a.m27407w2();
            }
        });
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: F0 */
    public void mo16660F0() {
        if (AbstractC12139d.m72766e(this) == null || this.f20594H) {
            C13981a.m83988e("ActivationNormalActivity", "onNext: mTEEAccountInfo is null");
        } else {
            this.f20623k0 = AbstractC12139d.m72766e(this).getAccountName();
        }
        String string = this.f20543F.getText().toString();
        if (!C0209d.m1333z1(this)) {
            m27258X0();
        } else {
            m27261c1();
            m27371U1(string);
        }
    }

    /* renamed from: F2 */
    public final void m27358F2() {
        m27396k2(false);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: G */
    public void mo16559G() throws Resources.NotFoundException {
        super.mo16559G();
        m27256U0();
        this.f20543F.addTextChangedListener(new C4494i(this, null));
        this.f20599M = (TextView) C12809f.m76829b(this, R$id.activation_lock_screen_pwd);
        this.f20600N = (HwProgressBar) C12809f.m76829b(this, R$id.activation_lock_screen_pwd_loading);
        this.f20614b0 = C12809f.m76829b(this, R$id.activation_password_contain);
        this.f20604R = C12809f.m76829b(this, R$id.activation_password_recovery_contain);
        this.f20601O = (TextView) C12809f.m76829b(this, R$id.activation_password_recovery);
        this.f20606T = C12809f.m76829b(this, R$id.activation_diliver);
        this.f20605S = C12809f.m76829b(this, R$id.activation_more_help_contain);
        this.f20602P = (TextView) C12809f.m76829b(this, R$id.activation_more_help);
        this.f20607U = C12809f.m76829b(this, R$id.appeal_activation_contain);
        this.f20603Q = (TextView) C12809f.m76829b(this, R$id.appeal_activation);
        this.f20601O.setOnClickListener(this);
        this.f20602P.setOnClickListener(this);
        this.f12353m = (NotchBottomFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_bottom_frame);
        TextView textView = this.f20603Q;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        this.f20608V = C12809f.m76829b(this, R$id.activation_findmyphone_scrollview);
        this.f20609W = C12809f.m76829b(this, R$id.activation_content_ta_error);
        this.f20610X = C12809f.m76829b(this, R$id.activation_content_error);
        this.f20611Y = C12809f.m76829b(this, R$id.activation_content_retry);
        this.f20612Z = (TextView) C12809f.m76829b(this, R$id.retry_text);
        this.f20616d0 = (HwButton) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f20613a0 = C12809f.m76829b(this, R$id.iv_no_wifi);
        this.f20615c0 = (TextView) C12809f.m76829b(this, R$id.activation_no_network);
        SpanClickText spanClickText = (SpanClickText) C12809f.m76829b(this, R$id.activation_info);
        this.f20618f0 = spanClickText;
        C11842p.m70715B1(this, spanClickText);
        m16667M0((OOBETopView) C12809f.m76829b(this, R$id.oobe_start_top_frame));
        ImageView imageView = (ImageView) C12809f.m76829b(this, com.huawei.android.hicloud.oobe.R$id.oobe_top_icon);
        if (imageView == null) {
            C13981a.m83988e("ActivationNormalActivity", "iconView is null");
        } else {
            m27368R2(imageView);
        }
        HwButton hwButton = this.f20616d0;
        if (hwButton != null) {
            hwButton.setOnClickListener(this);
        }
        View view = this.f20610X;
        if (view != null) {
            view.setOnClickListener(this);
        }
        HwButton hwButton2 = (HwButton) C12809f.m76829b(this, R$id.activation_do_activate);
        this.f20597K = hwButton2;
        hwButton2.setOnClickListener(this);
        this.f20597K.setEnabled(false);
        C11842p.m70766S1(this, this.f20597K);
        this.f20596J = C12809f.m76829b(this, R$id.normal_layout);
        OOBENavLayout oOBENavLayout = (OOBENavLayout) C12809f.m76829b(this, R$id.oobe_nav_layout);
        if (oOBENavLayout != null) {
            oOBENavLayout.m17042d();
            oOBENavLayout.setBackBtnClickListener(this);
        }
        m16557E();
        m27385b3(getString(R$string.activation_loading_title));
        C13981a.m83987d("ActivationNormalActivity", "initView end");
    }

    /* renamed from: G2 */
    public final void m27359G2(Bundle bundle) throws Resources.NotFoundException {
        if (bundle == null) {
            return;
        }
        if (m27400o2()) {
            C13981a.m83990w("ActivationNormalActivity", "account name is empty");
            return;
        }
        m27366P2();
        m27377X2();
        String string = bundle.getString("mobile", "");
        String string2 = bundle.getString("email", "");
        if (!TextUtils.isEmpty(string)) {
            m27392f3(string);
            return;
        }
        if (!TextUtils.isEmpty(string2)) {
            m27392f3(string2);
        } else if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && AbstractC12139d.m72766e(this) != null) {
            m27392f3(C11871d.m71159b(AbstractC12139d.m72766e(this).getAccountName()));
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: H0 */
    public int mo16662H0() {
        return R$layout.activation_normal_100;
    }

    /* renamed from: H2 */
    public final void m27360H2() {
        finishActivity(1);
        mo27259Y0(true);
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: I0 */
    public int mo16663I0() {
        return R$layout.activation_normal_80;
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: J0 */
    public int mo16664J0() {
        return R$layout.activation_normal_90;
    }

    /* renamed from: J2 */
    public final void m27361J2(boolean z10) {
        C13981a.m83989i("ActivationNormalActivity", "checkClientTaKeyResult:" + z10);
        if (!z10) {
            this.f20595I = 2;
            m27373V2();
        } else {
            C11860j.m70994F0(true, AbstractC12139d.m72766e(this));
            this.f20628p0 = false;
            m27384b2();
        }
    }

    /* renamed from: K2 */
    public final void m27362K2() {
        C13981a.m83989i("ActivationNormalActivity", "processReadAntiTheftDataResult");
        if (isFinishing() || isDestroyed()) {
            C13981a.m83990w("ActivationNormalActivity", "activity is finish!");
        } else {
            C11860j.m70994F0(true, AbstractC12139d.m72766e(C0213f.m1377a()));
            m27374W1();
        }
    }

    /* renamed from: L2 */
    public final void m27363L2() {
        if (!C0209d.m1333z1(this)) {
            m27379Y2();
        } else if (this.f20621i0) {
            m27385b3(getString(R$string.activation_loading_title));
            m27374W1();
        }
    }

    /* renamed from: N2 */
    public final void m27364N2(String str) {
        new C12796a().m76773f(this, "001_3008", str, "001_3008", "lockScreenVerify", null, "activeActivity", null);
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: O */
    public void mo16566O() {
        super.mo16566O();
        if (m16581d0()) {
            C11842p.m70724E1(findViewById(R$id.oobe_button), getResources().getDimensionPixelSize(R$dimen.oobe_button_margin_bottom));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0052  */
    /* renamed from: O2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m27365O2(org.json.JSONObject r15) {
        /*
            r14 = this;
            android.os.Bundle r2 = r14.f20624l0
            java.lang.String r3 = "parentUid"
            java.lang.String r4 = r15.optString(r3)
            r2.putString(r3, r4)
            android.os.Bundle r2 = r14.f20624l0
            java.lang.String r4 = "parentAccountName"
            java.lang.String r5 = r15.optString(r4)
            r2.putString(r4, r5)
            android.os.Bundle r2 = r14.f20624l0
            java.lang.String r5 = "deviceId"
            java.lang.String r6 = r15.optString(r5)
            r2.putString(r5, r6)
            java.lang.String r2 = "accountInfo"
            org.json.JSONObject r2 = r15.optJSONObject(r2)
            if (r2 == 0) goto L52
            java.lang.String r6 = "mobile"
            java.lang.String r6 = r2.optString(r6)
            java.lang.String r7 = "email"
            java.lang.String r7 = r2.optString(r7)
            java.lang.String r8 = "petalMail"
            java.lang.String r2 = r2.optString(r8)
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L42
            goto L54
        L42:
            boolean r6 = android.text.TextUtils.isEmpty(r7)
            if (r6 != 0) goto L4a
            r6 = r7
            goto L54
        L4a:
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 != 0) goto L52
            r6 = r2
            goto L54
        L52:
            java.lang.String r6 = ""
        L54:
            android.os.Bundle r2 = r14.f20624l0
            java.lang.String r7 = "accountName"
            r2.putString(r7, r6)
            android.os.Bundle r2 = r14.f20624l0
            java.lang.String r8 = "siteId"
            r9 = -1
            int r10 = r15.optInt(r8, r9)
            r2.putInt(r8, r10)
            android.os.Bundle r2 = r14.f20624l0
            java.lang.String r10 = "userId"
            java.lang.String r11 = r15.optString(r10)
            r2.putString(r10, r11)
            android.os.Bundle r2 = r14.f20624l0
            java.lang.String r11 = "deviceType"
            int r12 = r15.optInt(r11, r9)
            r2.putInt(r11, r12)
            sg.a r2 = new sg.a
            r2.<init>()
            java.util.LinkedHashMap r12 = new java.util.LinkedHashMap
            r12.<init>()
            java.lang.String r13 = r15.optString(r3)
            r12.put(r3, r13)
            java.lang.String r3 = r15.optString(r4)
            r12.put(r4, r3)
            java.lang.String r3 = r15.optString(r5)
            r12.put(r5, r3)
            r12.put(r7, r6)
            int r3 = r15.optInt(r8, r9)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r12.put(r8, r3)
            java.lang.String r3 = r15.optString(r10)
            r12.put(r10, r3)
            int r0 = r15.optInt(r11, r9)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r12.put(r11, r0)
            r7 = 0
            r8 = 0
            java.lang.String r3 = "ActivationNormalActivity"
            java.lang.String r4 = "0"
            java.lang.String r5 = "query account info success"
            r6 = 0
            java.lang.String r9 = "01012"
            r0 = r2
            r1 = r14
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r9
            r9 = r12
            r0.m76772e(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.remotecontrol.p093ui.activation.ActivationNormalActivity.m27365O2(org.json.JSONObject):void");
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: P */
    public void mo16567P(Configuration configuration) {
        if (m16581d0()) {
            C11842p.m70736I1(C12809f.m76829b(this, R$id.activation_info), getResources().getDimensionPixelSize(com.huawei.android.remotecontrol.sdk.R$dimen.oobe_title_margin_bottom));
        }
        super.mo16567P(configuration);
    }

    /* renamed from: P2 */
    public final void m27366P2() throws Resources.NotFoundException {
        String frpMessage;
        if (AbstractC12139d.m72766e(this) == null) {
            C13981a.m83990w("ActivationNormalActivity", "initViews: mTEEAccountInfo is null");
            frpMessage = "";
        } else {
            this.f20623k0 = AbstractC12139d.m72766e(this).getAccountName();
            frpMessage = AbstractC12139d.m72766e(this).getFrpMessage();
        }
        m27392f3(C11871d.m71159b(this.f20623k0));
        TextView textView = (TextView) C12809f.m76829b(this, R$id.activation_remote_info_title);
        String str = getString(R$string.activation_remote_info_title) + frpMessage;
        if (TextUtils.isEmpty(frpMessage)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
    }

    /* renamed from: Q2 */
    public final void m27367Q2() {
        this.f20604R.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC4486a());
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity
    /* renamed from: R0 */
    public String mo27240R0() {
        return "";
    }

    /* renamed from: R2 */
    public final void m27368R2(ImageView imageView) {
        if (C0209d.m1269j1() && this.f12341a == 1) {
            imageView.setImageResource(R$drawable.img_find_my_phone_100_honor);
        }
    }

    /* renamed from: S2 */
    public final void m27369S2(boolean z10) {
        String str;
        C13981a.m83989i("ActivationNormalActivity", "setLockScreenVerifyEntVisibility, lostPatternFlag: " + z10);
        TextView textView = this.f20599M;
        if (textView == null) {
            C13981a.m83988e("ActivationNormalActivity", "mLockPassword is null");
            return;
        }
        if (z10) {
            textView.setVisibility(8);
            return;
        }
        if (!m27398m2() || C13452e.m80781L().m80842P0() || C0209d.m1203Q1(C0213f.m1377a())) {
            this.f20599M.setVisibility(8);
            str = "setLockScreenVerifyEntVisibility, lock screen hide";
        } else {
            str = "setLockScreenVerifyEntVisibility, lock screen show";
            C13981a.m83989i("ActivationNormalActivity", "setLockScreenVerifyEntVisibility, lock screen show");
            this.f20599M.setVisibility(0);
            this.f20599M.setOnClickListener(this);
        }
        m27364N2(str);
    }

    /* renamed from: T2 */
    public final void m27370T2(boolean z10) {
        C13981a.m83989i("ActivationNormalActivity", "setPasswordRegretVisible:" + z10 + ", lostFlag:" + this.f20629q0);
        this.f20630r0 = z10;
        ViewGroup.LayoutParams layoutParams = this.f20601O.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        ViewGroup.LayoutParams layoutParams3 = this.f20602P.getLayoutParams();
        FrameLayout.LayoutParams layoutParams4 = layoutParams3 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams2 == null || layoutParams4 == null) {
            C13981a.m83988e("ActivationNormalActivity", "frameParams is null");
            return;
        }
        if (!z10) {
            if (this.f20629q0) {
                this.f20604R.setVisibility(8);
                this.f20606T.setVisibility(8);
                C11842p.m70712A2(this.f20605S, false);
                C11842p.m70712A2(this.f20607U, false);
                return;
            }
            layoutParams4.gravity = 17;
            this.f20604R.setVisibility(8);
            this.f20606T.setVisibility(8);
            C11842p.m70712A2(this.f20605S, true);
            C11842p.m70712A2(this.f20607U, false);
            return;
        }
        if (this.f20629q0) {
            layoutParams2.gravity = 17;
            this.f20604R.setVisibility(0);
            this.f20606T.setVisibility(8);
            C11842p.m70712A2(this.f20605S, false);
            C11842p.m70712A2(this.f20607U, false);
            return;
        }
        layoutParams2.gravity = 8388629;
        layoutParams4.gravity = 8388627;
        this.f20604R.setVisibility(0);
        this.f20606T.setVisibility(0);
        View view = this.f20607U;
        if (view == null || view.getVisibility() != 8) {
            return;
        }
        C11842p.m70712A2(this.f20607U, false);
        this.f20606T.setVisibility(0);
        C11842p.m70712A2(this.f20605S, true);
        m27367Q2();
    }

    /* renamed from: U1 */
    public final void m27371U1(String str) {
        if (!TextUtils.isEmpty(str)) {
            m27380Z1(str);
        } else {
            C13981a.m83990w("ActivationNormalActivity", "checkAccountAndPassword");
            m27410z2(new ErrorStatus(70002003, "checkAccountAndPassword onError"));
        }
    }

    /* renamed from: U2 */
    public final void m27372U2(JSONObject jSONObject) throws Resources.NotFoundException {
        boolean zM26232c = C4347e.m26232c(jSONObject);
        C13981a.m83989i("ActivationNormalActivity", "showCloudActivation,lostFlag:" + zM26232c);
        C11877j.m71306t0(this, 1);
        this.f20629q0 = zM26232c;
        this.f20594H = true;
        C11860j.m71032Y0(true);
        m27376X1(zM26232c);
        m27366P2();
        m27377X2();
        m27369S2(true);
        String string = m27393h2().getString("accountName", "");
        this.f20623k0 = string;
        m27392f3(string);
        AbstractC12139d.m72766e(this).setAccountName(this.f20623k0);
    }

    /* renamed from: V2 */
    public final void m27373V2() {
        m27399n2();
        this.f20621i0 = true;
        View view = this.f20608V;
        if (view == null || this.f20610X == null || this.f20611Y == null || this.f20616d0 == null || this.f20615c0 == null) {
            return;
        }
        view.setVisibility(8);
        this.f20597K.setVisibility(8);
        this.f20614b0.setVisibility(8);
        this.f20610X.setVisibility(0);
        this.f20616d0.setVisibility(8);
        this.f20611Y.setVisibility(8);
        this.f20615c0.setText(getString(R$string.connect_server_fail_msg1));
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity
    /* renamed from: W0 */
    public boolean mo27257W0() {
        return true;
    }

    /* renamed from: W1 */
    public final void m27374W1() {
        C13981a.m83989i("ActivationNormalActivity", "checkClientTaKey");
        if (!C0209d.m1333z1(this)) {
            C13981a.m83988e("ActivationNormalActivity", "network not connected");
            this.f20621i0 = true;
            m27379Y2();
        } else if (!C1175a.m7389k(this) || C11853c.m70968g().m70972h(this)) {
            this.f20628p0 = false;
            m27384b2();
        } else {
            C12515a.m75110o().m75172d(new C9477f(this.f20619g0));
        }
    }

    /* renamed from: W2 */
    public final void m27375W2(JSONObject jSONObject) throws Resources.NotFoundException {
        boolean zM26232c = C4347e.m26232c(jSONObject);
        C13981a.m83989i("ActivationNormalActivity", "showLocalActivation,lostFlag:" + zM26232c);
        this.f20629q0 = zM26232c;
        this.f20594H = false;
        C11860j.m71032Y0(false);
        C4490e.m27415a();
        m27376X1(zM26232c);
        m27366P2();
        m27377X2();
        m27369S2(m27402q2(zM26232c, jSONObject));
    }

    /* renamed from: X1 */
    public final void m27376X1(boolean z10) {
        this.f20629q0 = z10;
        m27370T2(false);
        C13612b.m81829B().mo80999a(getApplicationContext(), this.f20620h0);
    }

    /* renamed from: X2 */
    public final void m27377X2() {
        View view = this.f20608V;
        if (view == null || this.f20610X == null || this.f20611Y == null || this.f20616d0 == null) {
            return;
        }
        view.setVisibility(0);
        this.f20597K.setVisibility(0);
        this.f20614b0.setVisibility(0);
        this.f20610X.setVisibility(8);
        this.f20611Y.setVisibility(8);
        this.f20616d0.setVisibility(8);
        View view2 = this.f20609W;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity
    /* renamed from: Y0 */
    public void mo27259Y0(boolean z10) {
        m27399n2();
        if (z10) {
            C11860j.m71052f1();
            m27386c2();
            C12515a.m75110o().m75172d(new C4488c());
        }
        super.mo27259Y0(z10);
    }

    /* renamed from: Y1 */
    public final String m27378Y1(String str) {
        Bundle bundleM27393h2 = m27393h2();
        boolean z10 = !TextUtils.isEmpty(bundleM27393h2.getString("parentUid"));
        int i10 = R$string.findmyphone_activation_info_90_new;
        if (!z10) {
            C13981a.m83989i("ActivationNormalActivity", "not a child account");
            return getResources().getString(i10, str);
        }
        return getResources().getString(R$string.findmyphone_activation_info_90_new_parent, str, m27331V1(bundleM27393h2.getString("parentAccountName")));
    }

    /* renamed from: Y2 */
    public final void m27379Y2() {
        View view = this.f20608V;
        if (view == null || this.f20610X == null || this.f20611Y == null || this.f20616d0 == null) {
            return;
        }
        view.setVisibility(8);
        this.f20597K.setVisibility(8);
        this.f20614b0.setVisibility(8);
        this.f20610X.setVisibility(0);
        this.f20616d0.setVisibility(0);
        this.f20611Y.setVisibility(8);
    }

    /* renamed from: Z1 */
    public final void m27380Z1(String str) {
        C13981a.m83989i("ActivationNormalActivity", "checkPassword by hms sdk");
        Bundle bundleM27393h2 = m27393h2();
        if (AbstractC12139d.m72766e(this) == null && bundleM27393h2.isEmpty()) {
            C13981a.m83988e("ActivationNormalActivity", "activity.mTEEAccountInfo is null");
            m27254P0();
            return;
        }
        HttpClientGlobalInstance.getInstance().init(this);
        int iM1685c = bundleM27393h2.getInt(HwPayConstant.KEY_SITE_ID);
        if (iM1685c == -1) {
            iM1685c = C0241z.m1685c(AbstractC12139d.m72766e(this).getSiteID());
        }
        int i10 = iM1685c;
        int i11 = bundleM27393h2.getInt(JsbMapKeyNames.H5_DEVICE_TYPE);
        HuaweiIdAdvancedManager.getService(this).checkPasswordByUserId(this, new CheckPasswordByUserIdReq(getPackageName(), bundleM27393h2.getString(JsbMapKeyNames.H5_USER_ID), str, AbstractC12139d.m72766e(this).getAccountType(), i10, "10055832", bundleM27393h2.getString("parentUid"), bundleM27393h2.getString("deviceId"), "", i11 == -1 ? AbstractC12139d.m72766e(this).getDeviceType() : String.valueOf(i11)), new C4492g(this));
        HandlerC4498m handlerC4498m = this.f20619g0;
        if (handlerC4498m != null) {
            this.f20619g0.sendMessageDelayed(Message.obtain(handlerC4498m, 3), 120000L);
        }
    }

    /* renamed from: Z2 */
    public final void m27381Z2(boolean z10) {
        C13981a.m83989i("ActivationNormalActivity", "showSocIdOrinTips");
        View view = this.f20608V;
        if (view != null) {
            view.setVisibility(8);
        }
        HwButton hwButton = this.f20597K;
        if (hwButton != null) {
            hwButton.setVisibility(8);
        }
        View view2 = this.f20614b0;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.f20611Y;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.f20610X;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        HwButton hwButton2 = this.f20616d0;
        if (hwButton2 != null) {
            hwButton2.setVisibility(8);
        }
        View view5 = this.f20609W;
        if (view5 != null) {
            view5.setVisibility(0);
        }
        TextView textView = (TextView) C12809f.m76829b(this, R$id.ta_error_tip);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.ta_error_tip2);
        TextView textView3 = (TextView) C12809f.m76829b(this, R$id.ta_error_tip3);
        C12809f.m76843p(textView2, true);
        C12809f.m76843p(textView3, true);
        C12809f.m76841n(textView, getString(R$string.pf_activation_tip_delete1));
        C12809f.m76841n(textView2, getString(R$string.pf_activation_tip_delete2));
        if (z10) {
            C12809f.m76841n(textView3, getString(R$string.pf_activation_tip_account_empty));
        } else {
            C12809f.m76841n(textView3, getString(R$string.pf_activation_tip_delete3));
        }
        C11842p.m70715B1(this, textView);
        m16667M0((OOBETopView) C12809f.m76829b(this, R$id.ta_error_top_view));
    }

    /* renamed from: a2 */
    public String m27382a2(String str) {
        C13981a.m83989i("ActivationNormalActivity", "checkSocIdLocal, traceId: " + str);
        Context contextM74301m = C12347f.m74285n().m74301m();
        C12796a c12796a = new C12796a();
        if (C1175a.m7385g(false)) {
            C13981a.m83990w("ActivationNormalActivity", "has auth flag");
            c12796a.m76773f(contextM74301m, "001_3008", "has auth flag", "001_3008", "01012", str, "activeActivity", null);
            return "-2";
        }
        JSONArray jSONArrayM7393o = C1175a.m7393o();
        if (jSONArrayM7393o == null) {
            C13981a.m83990w("ActivationNormalActivity", "socId method not find");
            c12796a.m76773f(contextM74301m, "001_3008", "socId method not find", "001_3008", "01012", str, "activeActivity", null);
            return "-2";
        }
        if (jSONArrayM7393o.length() != 0 && !TextUtils.isEmpty(jSONArrayM7393o.toString())) {
            return "0";
        }
        C13981a.m83990w("ActivationNormalActivity", "socId is empty");
        c12796a.m76773f(contextM74301m, "001_3008", "socId is empty", "001_3008", "01012", str, "activeActivity", null);
        return "-1";
    }

    /* renamed from: a3 */
    public final void m27383a3() {
        C13981a.m83989i("ActivationNormalActivity", "showTAError");
        View view = this.f20608V;
        if (view != null) {
            view.setVisibility(8);
        }
        HwButton hwButton = this.f20597K;
        if (hwButton != null) {
            hwButton.setVisibility(8);
        }
        View view2 = this.f20614b0;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.f20611Y;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.f20610X;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        HwButton hwButton2 = this.f20616d0;
        if (hwButton2 != null) {
            hwButton2.setVisibility(8);
        }
        View view5 = this.f20609W;
        if (view5 != null) {
            view5.setVisibility(0);
        }
        TextView textView = (TextView) C12809f.m76829b(this, R$id.ta_error_tip);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.ta_error_tip2);
        TextView textView3 = (TextView) C12809f.m76829b(this, R$id.ta_error_tip3);
        C12809f.m76843p(textView2, false);
        C12809f.m76843p(textView3, false);
        C12809f.m76841n(textView, getString(R$string.pf_activation_tip_assistance_dialog));
        C11842p.m70715B1(this, textView);
        m16667M0((OOBETopView) C12809f.m76829b(this, R$id.ta_error_top_view));
    }

    /* renamed from: b2 */
    public final void m27384b2() {
        C13981a.m83989i("ActivationNormalActivity", "checkSocIdRelation");
        if (!C0209d.m1333z1(this)) {
            C13981a.m83988e("ActivationNormalActivity", "network not connected");
            this.f20621i0 = true;
            m27379Y2();
            return;
        }
        String strM27382a2 = m27382a2(C12797b.m76774a("01029"));
        C12796a c12796a = new C12796a();
        if ("-1".equals(strM27382a2)) {
            if (!C11870c.m71157e(C1175a.m7394p())) {
                m27383a3();
                c12796a.m76773f(this, "001_3008", "socId is empty, show error page", "001_3008", "01012", null, "activeActivity", null);
                return;
            } else {
                this.f20628p0 = true;
                C13981a.m83989i("ActivationNormalActivity", "mUseSocIdOrigin");
            }
        }
        if ("-2".equals(strM27382a2)) {
            if (!C1175a.m7389k(C0213f.m1377a())) {
                C11877j.m71306t0(this, 6);
                mo27259Y0(true);
                return;
            }
            if (!m27401p2(AbstractC12139d.m72766e(this))) {
                C1175a.m7398t(false, this);
                c12796a.m76773f(this, "001_3008", "TA error", "001_3008", "01012", null, "Inactive show TA error", null);
                mo27259Y0(true);
                return;
            }
            String deviceID = AbstractC12139d.m72766e(this).getDeviceID();
            if (!TextUtils.isEmpty(deviceID) && !C11870c.m71156d(deviceID)) {
                C13981a.m83988e("ActivationNormalActivity", "deviceId is not utf8");
                C1175a.m7398t(false, this);
                c12796a.m76773f(this, "001_3008", "deviceID is not valid", "001_3008", "01012", null, "Inactive show TA error", null);
                mo27259Y0(true);
                return;
            }
        }
        C13981a.m83989i("ActivationNormalActivity", "start query lock info for activation page");
        C12500h c12500hM71115n = C11866p.m71115n(false, AbstractC12139d.m72766e(this).getSiteID(), C1175a.m7389k(this) ? 9 : 5);
        if (this.f20628p0) {
            c12500hM71115n.m75049s(true);
        }
        c12500hM71115n.m75045o();
        HandlerC4498m handlerC4498m = this.f20619g0;
        if (handlerC4498m != null) {
            this.f20619g0.sendMessageDelayed(Message.obtain(handlerC4498m, 6), 120000L);
        }
    }

    /* renamed from: b3 */
    public final void m27385b3(String str) {
        if (this.f20608V == null || this.f20610X == null || this.f20611Y == null || this.f20616d0 == null || this.f20612Z == null) {
            C13981a.m83989i("ActivationNormalActivity", "showTryConnect view null");
            return;
        }
        C13981a.m83989i("ActivationNormalActivity", "showTryConnect");
        this.f20608V.setVisibility(8);
        this.f20597K.setVisibility(8);
        this.f20614b0.setVisibility(8);
        this.f20610X.setVisibility(8);
        this.f20611Y.setVisibility(0);
        this.f20612Z.setText(str);
        this.f20616d0.setVisibility(8);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: c */
    public int mo16578c() {
        return R$layout.activation_normal_111;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: c0 */
    public boolean mo16579c0() {
        return true;
    }

    /* renamed from: c2 */
    public final void m27386c2() {
        try {
            C10817e.m65873a(C0213f.m1377a(), this.f20629q0);
        } catch (Exception unused) {
            C13981a.m83988e("ActivationNormalActivity", "stopLostMode error");
        }
    }

    /* renamed from: c3 */
    public final void m27387c3(String str) {
        C13981a.m83989i("ActivationNormalActivity", "startLockScreenVerify");
        try {
            Intent intent = new Intent("android.app.action.CONFIRM_FRP_CREDENTIAL");
            C0209d.m1302r2(intent, "com.android.settings");
            intent.putExtra("android.app.extra.ALTERNATE_BUTTON_LABEL", getString(R$string.pf_lock_screen_btn_back2));
            intent.putExtra("hw_frp_token", this.f12404B);
            if (str != null) {
                intent.putExtra("has_challenge", true);
                intent.putExtra("frp_challenge", str);
            }
            startActivityForResult(intent, 3);
        } catch (ActivityNotFoundException unused) {
            C13981a.m83988e("ActivationNormalActivity", "startActivity: CONFIRM_FRP_CREDENTIAL failed");
            TextView textView = this.f20599M;
            if (textView != null) {
                textView.setEnabled(true);
            }
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: d */
    public int mo16580d() {
        return C0209d.m1281m1() ? R$layout.activation_normal_honor_t : super.mo16580d();
    }

    /* renamed from: d2 */
    public final void m27388d2() {
        this.f20595I = 0;
        m27373V2();
    }

    /* renamed from: d3 */
    public final void m27389d3() {
        C13981a.m83989i("ActivationNormalActivity", "startRetry");
        if (!C0209d.m1333z1(this)) {
            C13981a.m83987d("ActivationNormalActivity", "network not connected");
            return;
        }
        m27385b3(getString(R$string.text_connect_3));
        if (2 == this.f20595I) {
            m27374W1();
        } else {
            this.f20628p0 = false;
            m27384b2();
        }
    }

    /* renamed from: e2 */
    public final void m27390e2(JSONObject jSONObject) throws Resources.NotFoundException {
        if (!m27400o2()) {
            m27372U2(jSONObject);
        } else {
            m27381Z2(true);
            new C12796a().m76773f(this, "001_3008", "check account name is empty 3001", "001_3008", "01012", null, "activeActivity", null);
        }
    }

    /* renamed from: f2 */
    public final void m27391f2(JSONObject jSONObject) throws Resources.NotFoundException {
        if (m27400o2()) {
            m27381Z2(true);
            new C12796a().m76773f(this, "001_3008", "check account name is empty", "001_3008", "01012", null, "activeActivity", null);
        } else if (!C1175a.m7389k(C0213f.m1377a()) || !m27401p2(AbstractC12139d.m72766e(this))) {
            m27372U2(jSONObject);
        } else {
            m27375W2(jSONObject);
            C11877j.m71306t0(this, 3);
        }
    }

    /* renamed from: f3 */
    public final void m27392f3(String str) throws Resources.NotFoundException {
        C13981a.m83989i("ActivationNormalActivity", "updateAccountInfo");
        if (this.f20618f0 == null) {
            C13981a.m83988e("ActivationNormalActivity", "introductionSpan is null");
            return;
        }
        String strM27378Y1 = m27378Y1(m27331V1(str));
        String string = getResources().getString(R$string.activation_introduction);
        if (this.f20617e0 == null) {
            this.f20617e0 = new C4497l(this);
        }
        HashMap map = new HashMap();
        map.put(0, string);
        this.f20618f0.initText(strM27378Y1, this.f20617e0, map);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: g */
    public int mo16585g() {
        return R$layout.activation_normal_101;
    }

    /* renamed from: h2 */
    public Bundle m27393h2() {
        return this.f20624l0;
    }

    /* renamed from: i2 */
    public final byte[] m27394i2() {
        if (C1175a.m7385g(false)) {
            return null;
        }
        JSONArray jSONArrayM7393o = C1175a.m7393o();
        if (jSONArrayM7393o == null || jSONArrayM7393o.length() == 0) {
            C13981a.m83989i("ActivationNormalActivity", "socId method not find");
            return null;
        }
        byte[] bArrM7386h = C1175a.m7386h();
        if (bArrM7386h == null || bArrM7386h.length < 2) {
            C13981a.m83989i("ActivationNormalActivity", "isSupportV3, configs null");
            return null;
        }
        if (bArrM7386h[0] == 3) {
            return bArrM7386h;
        }
        C13981a.m83989i("ActivationNormalActivity", "isSupportV3, rom version not supported");
        return null;
    }

    /* renamed from: j2 */
    public final int m27395j2() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        try {
            Class<?> cls = Class.forName("com.android.internal.widget.LockPatternUtils");
            Method method = cls.getMethod("getKeyguardStoredPasswordQuality", Integer.TYPE);
            method.setAccessible(true);
            return ((Integer) method.invoke(cls.getConstructor(Context.class).newInstance(getApplicationContext()), -9999)).intValue();
        } catch (Exception e10) {
            C13981a.m83988e("ActivationNormalActivity", "get quality error: " + e10.getMessage());
            return 0;
        }
    }

    /* renamed from: k2 */
    public final void m27396k2(boolean z10) {
        C13195l.m79272J().m79342x(this, 1000005, true, 0, this.f12404B, z10 ? 5 : 2);
    }

    /* renamed from: l2 */
    public final void m27397l2() {
        C13981a.m83989i("ActivationNormalActivity", "goToSetNetWord");
        try {
            Intent intent = new Intent("com.android.net.wifi.SETUP_WIFI_NETWORK");
            C0209d.m1302r2(intent, "com.android.settings");
            intent.putExtra("extra_prefs_show_button_bar", true);
            intent.putExtra("extra_show_fake_status_bar", true);
            intent.putExtra("firstRun", true);
            intent.putExtra("hw_frp_token", this.f12404B);
            startActivityForResult(intent, 6);
        } catch (Exception unused) {
            C13981a.m83988e("ActivationNormalActivity", "startActivity: WIFI failed");
        }
    }

    /* renamed from: m2 */
    public final boolean m27398m2() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        boolean z10;
        C13981a.m83989i("ActivationNormalActivity", "hasLockScreenPassword");
        byte[] bArrM27394i2 = m27394i2();
        if (bArrM27394i2 != null) {
            z10 = bArrM27394i2[1] == 1;
            String str = "has bottom layer lock screen " + z10;
            C13981a.m83989i("ActivationNormalActivity", str);
            m27364N2(str);
            return z10;
        }
        int iM27395j2 = m27395j2();
        z10 = iM27395j2 == 65536 || iM27395j2 == 131072 || iM27395j2 == 196608 || iM27395j2 == 262144 || iM27395j2 == 327680 || iM27395j2 == 393216 || iM27395j2 == 524288;
        String str2 = "hasLockScreenPassword: " + z10;
        C13981a.m83989i("ActivationNormalActivity", str2);
        m27364N2(str2);
        return z10;
    }

    /* renamed from: n2 */
    public final void m27399n2() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    /* renamed from: o2 */
    public final boolean m27400o2() {
        try {
            Bundle bundleM27393h2 = m27393h2();
            if (!TextUtils.isEmpty(bundleM27393h2.getString("accountName")) || !TextUtils.isEmpty(bundleM27393h2.getString("parentUid")) || !TextUtils.isEmpty(bundleM27393h2.getString("parentAccountName")) || !TextUtils.isEmpty(AbstractC12139d.m72766e(this).getAccountName())) {
                return false;
            }
            C13981a.m83988e("ActivationNormalActivity", "check account name  is empty");
            return true;
        } catch (Exception unused) {
            C13981a.m83988e("ActivationNormalActivity", "check account name error");
            return false;
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        SafeIntent safeIntent = new SafeIntent(intent);
        C13981a.m83989i("ActivationNormalActivity", "onActivityResult requestCode = " + i10 + ", resultCode = " + i11);
        if (1 == i10 && -1 == i11) {
            mo27259Y0(true);
        }
        if (i10 == 3) {
            m27408x2(false);
            if (i11 == -1) {
                C13981a.m83989i("ActivationNormalActivity", "onActivityResult: check lock screen pwd success");
                m27261c1();
                C11860j.m71037a1(400);
                C11860j.m71030X0(400);
                if (C11860j.m71031Y() && m27403r2()) {
                    m27354B2(false, AbstractC13844b.m83105a(safeIntent.getByteArrayExtra("frp_signature")));
                } else {
                    m27353A2(null);
                }
                new C12796a().m76773f(C12347f.m74285n().m74301m(), "0", "check lock screen pwd finish, inactive", null, "01012", null, "success", null);
            }
            TextView textView = this.f20599M;
            if (textView != null) {
                textView.setEnabled(true);
                return;
            }
            return;
        }
        if (i10 != 5) {
            if (i10 == 2) {
                C13981a.m83989i("ActivationNormalActivity", "REGET_PSW_UNCHECKED_CODE");
                return;
            } else {
                if (i10 == 6) {
                    C13981a.m83989i("ActivationNormalActivity", "REQ_REFRESH_DATA");
                    m27389d3();
                    return;
                }
                return;
            }
        }
        if (i11 == -1) {
            HandlerC4498m handlerC4498m = this.f20619g0;
            if (handlerC4498m != null) {
                handlerC4498m.sendEmptyMessage(1);
                return;
            }
            return;
        }
        HandlerC4498m handlerC4498m2 = this.f20619g0;
        if (handlerC4498m2 != null) {
            handlerC4498m2.sendEmptyMessage(2);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (m16581d0()) {
            C13981a.m83987d("ActivationNormalActivity", "onBack(false)");
            mo27259Y0(false);
        } else {
            C13981a.m83987d("ActivationNormalActivity", "super.onBackPressed()");
            super.onBackPressed();
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) throws JSONException, InterruptedException {
        C13981a.m83989i("ActivationNormalActivity", "onClick");
        int id2 = view.getId();
        if (C0209d.m1226Y0()) {
            C13981a.m83987d("ActivationNormalActivity", "fast click, return.");
            if (id2 == R$id.activation_password_eye) {
                m27260Z0();
                return;
            }
            return;
        }
        if (id2 == R$id.activation_do_activate) {
            m27399n2();
            m27356D2();
        } else if (id2 == R$id.activation_lock_screen_pwd) {
            m27357E2();
        } else if (id2 == R$id.activation_password_recovery) {
            m27358F2();
        } else if (id2 == R$id.activation_more_help || id2 == R$id.appeal_activation) {
            m27333g2();
        } else if (id2 == R$id.oobe_nav_back_layout) {
            mo27259Y0(false);
        } else if (id2 == R$id.set_no_net_btn) {
            m27397l2();
        } else if (id2 == R$id.activation_content_error) {
            m27389d3();
        }
        super.onClick(view);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70766S1(this, this.f20597K);
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("ActivationNormalActivity", "onCreate");
        super.onCreate(bundle);
        if (!m16581d0() && getActionBar() != null) {
            getActionBar().hide();
        }
        m27323M2();
        RemoteActivationUtil.m27647r().m27656n(this.f20627o0);
        this.f20619g0 = new HandlerC4498m(this);
        C11873f.m71178f().m71185h(this.f20619g0);
        this.f20620h0 = new C4493h(this);
        if (this.f20626n0 == null) {
            ViewTreeObserverOnGlobalLayoutListenerC4496k viewTreeObserverOnGlobalLayoutListenerC4496k = new ViewTreeObserverOnGlobalLayoutListenerC4496k(this);
            this.f20626n0 = viewTreeObserverOnGlobalLayoutListenerC4496k;
            viewTreeObserverOnGlobalLayoutListenerC4496k.m27432d();
        }
        C12515a.m75110o().m75172d(new C4495j());
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onDestroy() {
        C13981a.m83989i("ActivationNormalActivity", "onDestroy");
        C11860j.m70994F0(false, AbstractC12139d.m72766e(this));
        RemoteActivationUtil.m27647r().m27650C(this.f20627o0);
        C11873f.m71178f().m71185h(null);
        HandlerC4498m handlerC4498m = this.f20619g0;
        if (handlerC4498m != null) {
            handlerC4498m.removeCallbacksAndMessages(null);
            this.f20619g0 = null;
        }
        m27332e3();
        m27399n2();
        if (this.f20620h0 != null) {
            this.f20620h0 = null;
        }
        ViewTreeObserverOnGlobalLayoutListenerC4496k viewTreeObserverOnGlobalLayoutListenerC4496k = this.f20626n0;
        if (viewTreeObserverOnGlobalLayoutListenerC4496k != null) {
            viewTreeObserverOnGlobalLayoutListenerC4496k.m27433e();
            this.f20626n0 = null;
        }
        C4491f c4491f = this.f20625m0;
        if (c4491f != null) {
            c4491f.m27268b(this);
        }
        this.f20594H = false;
        this.f20595I = 0;
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onResume() {
        C13981a.m83989i("ActivationNormalActivity", "onResume");
        super.onResume();
        m27363L2();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        C11703j.m69826v(getWindow(), true);
    }

    @Override // android.app.Activity
    public void onStop() {
        C11703j.m69826v(getWindow(), false);
        super.onStop();
    }

    /* renamed from: p2 */
    public final boolean m27401p2(AccountInfo accountInfo) {
        if (accountInfo == null) {
            C13981a.m83988e("ActivationNormalActivity", "accountInfo object in TEE is null");
            return false;
        }
        if (TextUtils.isEmpty(accountInfo.getUserID4RC())) {
            C13981a.m83990w("ActivationNormalActivity", "u***Id in TEE is null or empty");
            return false;
        }
        if (TextUtils.isEmpty(accountInfo.getDeviceID())) {
            C13981a.m83990w("ActivationNormalActivity", "d***Id in TEE is null or empty");
            return false;
        }
        if (!TextUtils.isEmpty(accountInfo.getDeviceTicket())) {
            return true;
        }
        C13981a.m83990w("ActivationNormalActivity", "d***T in TEE is null or empty");
        return false;
    }

    /* renamed from: q2 */
    public final boolean m27402q2(boolean z10, JSONObject jSONObject) {
        String strOptString = jSONObject.optString("parentUid");
        if (!C11860j.m71031Y()) {
            boolean z11 = z10 || !TextUtils.isEmpty(strOptString);
            m27364N2("client V2, isHide: " + z11);
            return z11;
        }
        C13981a.m83989i("ActivationNormalActivity", "client version 3");
        if (z10) {
            m27364N2("client V3, hide lockScreen verify : lostMode");
            C13981a.m83989i("ActivationNormalActivity", "client V3, hide lockScreen verify : lostMode");
            return true;
        }
        if (!TextUtils.isEmpty(strOptString)) {
            m27364N2("client V3, hide lockScreen verify : children account");
            C13981a.m83989i("ActivationNormalActivity", "client V3, hide lockScreen verify : children account");
            return true;
        }
        if (!m27403r2()) {
            m27364N2("client V3, show lockScreen verify : socid not support");
            C13981a.m83989i("ActivationNormalActivity", "client V3, show lockScreen verify : socid not support");
            return false;
        }
        if (jSONObject.optBoolean("pkExist")) {
            m27364N2("client V3, show lockScreen verify");
            return false;
        }
        m27364N2("client V3, hide lockScreen verify : pk not exist");
        C13981a.m83989i("ActivationNormalActivity", "client V3, hide lockScreen verify : pk not exist");
        return true;
    }

    /* renamed from: r2 */
    public final boolean m27403r2() {
        if (C1175a.m7385g(false)) {
            return false;
        }
        if (C1175a.m7393o() != null) {
            return true;
        }
        C13981a.m83989i("ActivationNormalActivity", "socId method not find");
        return false;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: t */
    public List<View> mo16610t() {
        ArrayList arrayList = new ArrayList();
        NotchBottomFitRelativeLayout notchBottomFitRelativeLayout = this.f12353m;
        if (notchBottomFitRelativeLayout != null) {
            arrayList.add(notchBottomFitRelativeLayout);
        }
        return arrayList;
    }

    /* renamed from: t2 */
    public final /* synthetic */ void m27404t2(int i10) {
        HwErrorTipTextLayout hwErrorTipTextLayout = (HwErrorTipTextLayout) C12809f.m76829b(this, R$id.activation_password_layout);
        if (hwErrorTipTextLayout != null) {
            if (i10 == 70002058) {
                hwErrorTipTextLayout.setError(getString(R$string.activate_password_error_over_ten));
            } else if (i10 != 70002076) {
                hwErrorTipTextLayout.setError(getString(R$string.activation_password_error_please_retry));
            } else {
                hwErrorTipTextLayout.setError(getString(R$string.activation_account_is_frozen_new));
            }
        }
        TextView textView = (TextView) C12809f.m76829b(this, R$id.activation_password_error);
        if (textView != null) {
            if (i10 != 70002076) {
                textView.setVisibility(0);
                textView.setText(getString(R$string.activation_password_error_please_retry));
            } else {
                textView.setVisibility(0);
                textView.setText(getString(R$string.activation_account_is_frozen_new));
            }
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: u0 */
    public void mo16613u0() {
        m16603p0();
        C11829c.m70585i1(getWindow());
        if (getWindow() != null) {
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new ViewOnSystemUiVisibilityChangeListenerC4487b());
        }
    }

    /* renamed from: u2 */
    public final /* synthetic */ void m27405u2() {
        C11880m.m71336c(getApplicationContext(), R$string.phonefinder_active_lock_not_supprted_toast);
    }

    /* renamed from: v2 */
    public final /* synthetic */ void m27406v2() {
        C11880m.m71336c(getApplicationContext(), R$string.activate_error_lockscreen_invalid);
    }

    /* renamed from: w2 */
    public final /* synthetic */ void m27407w2() {
        C11880m.m71336c(getApplicationContext(), R$string.activate_error_lockscreen_invalid);
        m27408x2(false);
        TextView textView = this.f20599M;
        if (textView != null) {
            textView.setEnabled(true);
        }
    }

    /* renamed from: x2 */
    public final void m27408x2(boolean z10) {
        HwProgressBar hwProgressBar;
        C13981a.m83989i("ActivationNormalActivity", "lockPasswordLoading, isLoading: " + z10);
        if (this.f20599M == null || (hwProgressBar = this.f20600N) == null) {
            C13981a.m83988e("ActivationNormalActivity", "lockPasswordLoading view null");
        } else if (z10) {
            hwProgressBar.setVisibility(0);
            this.f20599M.setVisibility(8);
        } else {
            hwProgressBar.setVisibility(8);
            this.f20599M.setVisibility(0);
        }
    }

    /* renamed from: y2 */
    public final void m27409y2(final int i10) {
        runOnUiThread(new Runnable() { // from class: hg.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f49478a.m27404t2(i10);
            }
        });
    }

    /* renamed from: z2 */
    public final void m27410z2(ErrorStatus errorStatus) {
        int errorCode = errorStatus == null ? -1 : errorStatus.getErrorCode();
        if (errorStatus != null) {
            C13981a.m83990w("ActivationNormalActivity", "onError " + errorCode + errorStatus.getErrorReason());
        }
        if (isFinishing()) {
            return;
        }
        if (2016 == errorCode) {
            errorCode = errorStatus.getSubErrCode();
        }
        C13981a.m83989i("ActivationNormalActivity", "onCheckPwdError, errorCode:" + errorCode);
        m27254P0();
        HandlerC4498m handlerC4498m = this.f20619g0;
        if (handlerC4498m != null) {
            Message messageObtainMessage = handlerC4498m.obtainMessage(0);
            messageObtainMessage.arg1 = errorCode;
            this.f20619g0.sendMessage(messageObtainMessage);
        }
    }
}
