package com.huawei.android.remotecontrol.p093ui.webview;

import af.C0189b;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;
import bf.C1175a;
import ck.C1443a;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceManager;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.android.remotecontrol.nearlink.p090ui.NearLinkNavigationActivity;
import com.huawei.android.remotecontrol.offlinelocate.C4366a;
import com.huawei.android.remotecontrol.offlinelocate.C4375j;
import com.huawei.android.remotecontrol.offlinelocate.C4376k;
import com.huawei.android.remotecontrol.offlinelocate.PhoneFinderTrustCircleManager;
import com.huawei.android.remotecontrol.offlinelocate.bean.OfflineLocateInfo;
import com.huawei.android.remotecontrol.offlinelocate.bean.OfflinePublicKeyInfoBean;
import com.huawei.android.remotecontrol.offlinelocate.bean.TrustCircleInfo;
import com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneActivity;
import com.huawei.android.remotecontrol.p093ui.webview.client.WebWapChromeClient;
import com.huawei.android.remotecontrol.provider.PhoneFinderProvider;
import com.huawei.android.remotecontrol.sdk.R$color;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.tag.bean.TagLocalFindResult;
import com.huawei.android.remotecontrol.tag.p092ui.BluetoothNavigationActivity;
import com.huawei.android.remotecontrol.tag.p092ui.PrecisionNavigationActivity;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.android.remotecontrol.util.NewHiSyncUtil;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.fastengine.fastview.RouterEventReceiver;
import com.huawei.feedback.FeedbackSdkProcessor;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.findnetwork.FindNetwork;
import com.huawei.hms.findnetwork.FindNetworkEngine;
import com.huawei.hms.findnetwork.comm.request.bean.DeviceDetail;
import com.huawei.hms.findnetwork.comm.request.bean.SuspectStalkingAccessoryBean;
import com.huawei.hms.findnetwork.comm.request.bean.TagDerivedKey;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkStatusResult;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.picker.AccountPickerManager;
import com.huawei.hms.support.picker.result.AuthAccountPicker;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.webview.SafeWebView;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import eg.AbstractC9478g;
import fk.C9721b;
import gp.C10028c;
import iq.C10588b;
import iq.C10591e;
import iq.C10593g;
import iq.InterfaceC10595i;
import iq.InterfaceC10596j;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import kg.C11052c;
import kg.InterfaceC11053d;
import mg.C11465a;
import mg.C11466b;
import mk.C11476b;
import nf.C11690w;
import ng.C11697d;
import ng.C11701h;
import ng.C11702i;
import ng.C11703j;
import ng.C11704k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p015ak.C0224k0;
import p015ak.C0225l;
import p015ak.C0226l0;
import p015ak.C0227m;
import p015ak.C0241z;
import p020ap.C1009d;
import p020ap.C1010e;
import p208cq.InterfaceC8937e;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p227dg.C9097b;
import p227dg.C9120m0;
import p237du.C9310c;
import p366if.C10487l;
import p422k9.C11018a;
import p452lg.C11275a;
import p514o9.C11829c;
import p514o9.C11842p;
import p520of.C11860j;
import p520of.C11866p;
import p521og.C11868a;
import p521og.C11877j;
import p521og.C11880m;
import p521og.C11881n;
import p575qe.C12347f;
import p611rf.C12498f;
import p616rk.C12515a;
import p655te.C13009a;
import p664u0.C13108a;
import p677ue.C13168a;
import p681uj.C13195l;
import p684un.C13230i;
import p709vj.C13452e;
import p709vj.InterfaceC13449b;
import p772xe.C13788m;
import p774xg.C13811a;
import p774xg.C13812b;
import p809yg.C13981a;
import p809yg.C13982b;
import p842zf.C14298f;
import p842zf.C14299g;
import p851zp.InterfaceC14356c;
import pg.AbstractC12139d;
import sg.C12797b;
import sk.C12809f;
import vg.C13442i;

/* loaded from: classes4.dex */
public class WapFindPhoneActivity extends BaseWebViewActivity implements InterfaceC11053d {

    /* renamed from: G0 */
    public static long f20793G0 = 0;

    /* renamed from: H0 */
    public static long f20794H0 = 0;

    /* renamed from: I0 */
    public static boolean f20795I0 = false;

    /* renamed from: J0 */
    public static String f20796J0;

    /* renamed from: D0 */
    public final Map<String, Boolean> f20800D0;

    /* renamed from: E0 */
    public C14298f f20801E0;

    /* renamed from: F0 */
    public AlertDialog f20802F0;

    /* renamed from: L */
    public NewHiSyncUtil f20805L;

    /* renamed from: M */
    public TextView f20806M;

    /* renamed from: N */
    public boolean f20807N;

    /* renamed from: Y */
    public String f20818Y;

    /* renamed from: a0 */
    public boolean f20820a0;

    /* renamed from: c0 */
    public C11052c f20822c0;

    /* renamed from: d0 */
    public C11466b f20823d0;

    /* renamed from: i0 */
    public HandlerC4536g f20828i0;

    /* renamed from: j0 */
    public AlertDialog f20829j0;

    /* renamed from: k0 */
    public AlertDialog f20830k0;

    /* renamed from: n0 */
    public String f20833n0;

    /* renamed from: o0 */
    public String f20834o0;

    /* renamed from: p0 */
    public String f20835p0;

    /* renamed from: q0 */
    public String f20836q0;

    /* renamed from: s0 */
    public int f20838s0;

    /* renamed from: J */
    public int f20803J = 0;

    /* renamed from: K */
    public Activity f20804K = null;

    /* renamed from: O */
    public boolean f20808O = false;

    /* renamed from: P */
    public boolean f20809P = false;

    /* renamed from: Q */
    public boolean f20810Q = true;

    /* renamed from: R */
    public boolean f20811R = false;

    /* renamed from: S */
    public boolean f20812S = false;

    /* renamed from: T */
    public int f20813T = 0;

    /* renamed from: U */
    public boolean f20814U = false;

    /* renamed from: V */
    public boolean f20815V = false;

    /* renamed from: W */
    public boolean f20816W = false;

    /* renamed from: X */
    public boolean f20817X = false;

    /* renamed from: Z */
    public String f20819Z = "";

    /* renamed from: b0 */
    public String f20821b0 = null;

    /* renamed from: e0 */
    public PhoneFinderReceiver f20824e0 = null;

    /* renamed from: f0 */
    public BluetoothStatueReceiver f20825f0 = null;

    /* renamed from: g0 */
    public TagLocalFindReceiver f20826g0 = null;

    /* renamed from: h0 */
    public long f20827h0 = 0;

    /* renamed from: l0 */
    public boolean f20831l0 = false;

    /* renamed from: m0 */
    public boolean f20832m0 = false;

    /* renamed from: r0 */
    public boolean f20837r0 = false;

    /* renamed from: t0 */
    public volatile boolean f20839t0 = false;

    /* renamed from: u0 */
    public int f20840u0 = -3;

    /* renamed from: v0 */
    public boolean f20841v0 = false;

    /* renamed from: w0 */
    public boolean f20842w0 = false;

    /* renamed from: x0 */
    public boolean f20843x0 = false;

    /* renamed from: y0 */
    public String f20844y0 = "";

    /* renamed from: z0 */
    public long f20845z0 = 0;

    /* renamed from: A0 */
    public long f20797A0 = 0;

    /* renamed from: B0 */
    public String f20798B0 = "";

    /* renamed from: C0 */
    public BluetoothStatueReceiver f20799C0 = null;

    public class BluetoothStatueReceiver extends BroadcastReceiver {
        public BluetoothStatueReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            if (WapFindPhoneActivity.this.f20782s == null) {
                C13981a.m83988e("WapFindPhoneActivity", "receiver bluetooth, webView is null");
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            int intExtra = safeIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
            if (12 == intExtra) {
                C13981a.m83989i("WapFindPhoneActivity", "receiver bluetooth open");
                C11690w.m69705a0(WapFindPhoneActivity.this.f20828i0);
            } else if (10 == intExtra) {
                C13981a.m83989i("WapFindPhoneActivity", "receiver bluetooth close");
                C11690w.m69705a0(WapFindPhoneActivity.this.f20828i0);
                C13788m.m82779c().m82780a();
            } else if ("huawei.sle.adapter.action.SLE_STATE_CHANGED".equals(safeIntent.getAction())) {
                C13981a.m83989i("WapFindPhoneActivity", "receiver nearLink change");
                C11690w.m69705a0(WapFindPhoneActivity.this.f20828i0);
            }
        }
    }

    public class PhoneFinderReceiver extends BroadcastReceiver {
        public PhoneFinderReceiver() {
        }

        /* renamed from: b */
        public final /* synthetic */ void m27874b() {
            C11880m.m71336c(WapFindPhoneActivity.this.f20804K, R$string.phonefinder_active_lock_not_supprted_toast);
        }

        /* renamed from: c */
        public final void m27875c(Context context) {
            String str;
            try {
                if (C1175a.m7389k(context)) {
                    str = "isPhoneFinderOpen:true";
                } else {
                    String strM80950o = C13452e.m80781L().m80950o();
                    String str2 = C0209d.m1170F1() ? "tablet" : "phone";
                    str = "isPhoneFinderOpen:false;deviceID:" + strM80950o + ";deviceType:" + str2 + ";displayName:" + C0224k0.a.m1573b("ro.config.marketing_name", Build.MODEL);
                }
                WapFindPhoneActivity.this.f20782s.loadUrl("javascript:phoneFinderStatusCallback(\"" + str + "\")");
            } catch (Exception e10) {
                C13981a.m83988e("WapFindPhoneActivity", "finish phoneFinder delete, " + e10.getMessage());
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws Resources.NotFoundException {
            if (intent == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if (!"com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT".equals(action)) {
                if ("com.huawei.android.hicloud.intent.PHONEFINDER_DEVICE_DEL".equals(action)) {
                    C13981a.m83989i("WapFindPhoneActivity", "finish phoneFinder delete");
                    m27875c(context);
                    return;
                }
                return;
            }
            boolean booleanExtra = safeIntent.getBooleanExtra("phonefinder_result", false);
            C13981a.m83989i("WapFindPhoneActivity", "finish open phoneFinder: " + booleanExtra);
            if (C0209d.m1166E1()) {
                WapFindPhoneActivity.this.f20782s.loadUrl("javascript:openPhoneFinderResult(\"" + booleanExtra + "\")");
            } else {
                WapFindPhoneActivity.this.f20782s.loadUrl("javascript:openPhoneFinderResult(\"" + booleanExtra + "\",\"21001\")");
            }
            if (booleanExtra && !C0209d.m1301r1(WapFindPhoneActivity.this.f20804K) && C11860j.m71031Y()) {
                WapFindPhoneActivity.this.m27857q5();
            }
            if (booleanExtra) {
                return;
            }
            int intExtra = safeIntent.hasExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE) ? safeIntent.getIntExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 0) : 0;
            if (intExtra == 3210 || intExtra == 3212) {
                C0226l0.m1584d(new Runnable() { // from class: jg.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f51622a.m27874b();
                    }
                });
            }
            if (intExtra == 3201) {
                C11860j.m71046d1(WapFindPhoneActivity.this.f20804K);
            }
        }
    }

    public class TagLocalFindReceiver extends BroadcastReceiver {
        public TagLocalFindReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || intent == null) {
                C13981a.m83988e("WapFindPhoneActivity", "onReceive context or intent is null");
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            C13981a.m83989i("WapFindPhoneActivity", "TagLocalFindReceiver, action: " + action);
            if ("com.huawei.hidisk.remotecontrol.intent.TAG_LOCAL_COMMAND_RESULT".equals(action)) {
                String stringExtra = safeIntent.getStringExtra("arg");
                String stringExtra2 = safeIntent.getStringExtra("operation");
                String stringExtra3 = safeIntent.getStringExtra("exeResult");
                String stringExtra4 = safeIntent.getStringExtra("tagSn");
                long longExtra = safeIntent.getLongExtra("executeTime", -1L);
                if (TextUtils.isEmpty(stringExtra)) {
                    C13981a.m83988e("WapFindPhoneActivity", "onReceive arg is empty");
                    return;
                }
                C12797b c12797b = new C12797b();
                String str = "receive tag device local command result, operation:" + stringExtra2 + ", exeResult:" + stringExtra3 + ", exeTime:" + longExtra + ", sn" + C9120m0.m57351R(stringExtra4);
                c12797b.m76784j(WapFindPhoneActivity.this.f20804K, "WapFindPhoneActivity", "", str, "exeResult:" + stringExtra3, "tag_local_find", "", stringExtra2, true);
                C13981a.m83989i("WapFindPhoneActivity", str);
                String strReplace = stringExtra.replace("\\\"", "\\\\\"").replace("\"", "\\\"");
                C13981a.m83987d("WapFindPhoneActivity", "receive tag device local command result, arg:" + strReplace);
                WapFindPhoneActivity.this.f20782s.loadUrl("javascript:pairedTagExeCmdResult(\"" + strReplace + "\")");
                return;
            }
            if (!"com.huawei.hidisk.remotecontrol.intent.TAG_FASTSCAN_RESULT".equals(action)) {
                if (!"com.huawei.hidisk.remotecontrol.intent.TRUST_CIRCLE_RESULT".equals(action)) {
                    if ("com.huawei.hidisk.remotecontrol.intent.REFRESH_PORTAL_LOGIN".equals(action)) {
                        C13981a.m83989i("WapFindPhoneActivity", "TagLocalFindReceiver refreshExpireForLogin");
                        WapFindPhoneActivity.this.f20782s.loadUrl("javascript:refreshExpireForLogin(\"\")");
                        return;
                    }
                    return;
                }
                int intExtra = safeIntent.getIntExtra("exeResult", -1);
                WapFindPhoneActivity.this.f20782s.loadUrl("javascript:joinCircleResult(\"" + intExtra + "\")");
                return;
            }
            String stringExtra5 = safeIntent.getStringExtra("tagSn");
            int intExtra2 = safeIntent.getIntExtra("exeResult", 1);
            String strReplace2 = safeIntent.m53581f("standbyDevice").replace("\"", "\\\"");
            WapFindPhoneActivity.this.f20782s.loadUrl("javascript:setTagConnectState(\"" + stringExtra5 + "\"," + intExtra2 + ",\"" + strReplace2 + "\")");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("TagLocalFindReceiver, deviceId: ");
            sb2.append(C9120m0.m57351R(stringExtra5));
            sb2.append(", status");
            sb2.append(intExtra2);
            sb2.append(" standbyDevice: ");
            sb2.append(C9120m0.m57355T(strReplace2));
            C13981a.m83989i("WapFindPhoneActivity", sb2.toString());
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.webview.WapFindPhoneActivity$a */
    public class C4530a implements NewHiSyncUtil.InterfaceC4549c {
        public C4530a() {
        }

        @Override // com.huawei.android.remotecontrol.util.NewHiSyncUtil.InterfaceC4549c
        /* renamed from: a */
        public void mo27197a() {
            String message;
            try {
                Intent intent = new Intent(C0209d.m1165E0(WapFindPhoneActivity.this.f20804K) ? "com.android.settings.PHONE_FINDER_LOCK_SCREEN" : "android.app.action.SET_NEW_PASSWORD");
                intent.addCategory("android.intent.category.DEFAULT");
                C0209d.m1302r2(intent, "com.android.settings");
                WapFindPhoneActivity.this.f20804K.startActivityForResult(intent, 4);
                message = "success";
            } catch (Exception e10) {
                C13981a.m83988e("WapFindPhoneActivity", "Start set new password activity error." + e10.getMessage());
                message = e10.getMessage();
            }
            C13230i.m79504I().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", "WapFindPhoneActivity", message);
        }

        @Override // com.huawei.android.remotecontrol.util.NewHiSyncUtil.InterfaceC4549c
        /* renamed from: b */
        public void mo27198b() {
            C13230i.m79504I().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", "WapFindPhoneActivity", "cancel");
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.webview.WapFindPhoneActivity$b */
    public class C4531b implements InterfaceC13449b {

        /* renamed from: a */
        public final /* synthetic */ boolean f20850a;

        public C4531b(boolean z10) {
            this.f20850a = z10;
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: L */
        public void mo13808L(Exception exc) {
            C13981a.m83989i("WapFindPhoneActivity", "authFailed");
            WapFindPhoneActivity.this.m27844i4(this.f20850a);
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: Q */
        public boolean mo13814Q(Bundle bundle) {
            return false;
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: W */
        public void mo13820W(Bundle bundle) {
            C13981a.m83989i("WapFindPhoneActivity", "onLogin");
            WapFindPhoneActivity.this.f20820a0 = false;
            WapFindPhoneActivity.this.f20807N = true;
            WapFindPhoneActivity.this.f20819Z = bundle.getString("serverAuthCode", "");
            WapFindPhoneActivity.this.f20797A0 = System.currentTimeMillis();
            if (TextUtils.isEmpty(WapFindPhoneActivity.this.f20819Z)) {
                WapFindPhoneActivity.this.m27844i4(this.f20850a);
            } else {
                C13981a.m83989i("WapFindPhoneActivity", "authCode is empty");
                WapFindPhoneActivity.this.m27798H4();
            }
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: e */
        public void mo13829e(OperationCanceledException operationCanceledException) {
            C13981a.m83989i("WapFindPhoneActivity", "authCanceled");
            WapFindPhoneActivity.this.m27844i4(this.f20850a);
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: m0 */
        public void mo13838m0(Bundle bundle) {
            C13981a.m83989i("WapFindPhoneActivity", "getUserInfoSuccess");
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.webview.WapFindPhoneActivity$c */
    public class C4532c extends AbstractC9478g {
        public C4532c() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C13981a.m83989i("WapFindPhoneActivity", "setCurrentDevicePk");
            if (!C0209d.m1285n1()) {
                C13981a.m83988e("WapFindPhoneActivity", "setCurrentDevicePk not HuaWei product");
                return;
            }
            if (!C1175a.m7389k(WapFindPhoneActivity.this.f20804K)) {
                C13981a.m83988e("WapFindPhoneActivity", "setCurrentDevicePk phoneFinder switch off");
            } else if (C4375j.m26387A()) {
                C4375j.m26397K(WapFindPhoneActivity.this.f20804K);
            } else {
                C13981a.m83988e("WapFindPhoneActivity", "setCurrentDevicePk no china");
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.webview.WapFindPhoneActivity$d */
    public static class C4533d extends AbstractC9478g {

        /* renamed from: a */
        public Context f20853a;

        /* renamed from: b */
        public Handler f20854b;

        public C4533d(Context context, Handler handler) {
            this.f20853a = context;
            this.f20854b = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            if (C0209d.m1277l1()) {
                return;
            }
            new PhoneFinderTrustCircleManager(this.f20853a).checkTrustCircleStatus(false, new Consumer() { // from class: jg.a0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f51618a.m27877d((TrustCircleInfo) obj);
                }
            });
        }

        /* renamed from: d */
        public final /* synthetic */ void m27877d(TrustCircleInfo trustCircleInfo) {
            C13981a.m83989i("WapFindPhoneActivity", "checkTrustCircleStatus:" + trustCircleInfo.isJoinTrustCircle());
            if (trustCircleInfo.isJoinTrustCircle()) {
                C4366a.m26382b().m26386e(4);
            } else {
                C4366a.m26382b().m26386e(0);
            }
            Handler handler = this.f20854b;
            if (handler != null) {
                handler.sendEmptyMessage(1020);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.webview.WapFindPhoneActivity$e */
    public class C4534e {

        /* renamed from: a */
        public int f20855a = 0;

        /* renamed from: com.huawei.android.remotecontrol.ui.webview.WapFindPhoneActivity$e$a */
        public class a extends TimerTask {
            public a() {
            }

            /* renamed from: c */
            public final /* synthetic */ void m27942c(String str) {
                WapFindPhoneActivity.this.f20782s.loadUrl("javascript:findTagBluetoothState(\"" + str + "\")");
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                final String str = C13168a.m79182k() ? FaqConstants.DISABLE_HA_REPORT : "false";
                C13981a.m83989i("WapExternal", "openCurrentDeviceSwitch openResult: " + str);
                WapFindPhoneActivity.this.f20782s.post(new Runnable() { // from class: jg.g1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f51649a.m27942c(str);
                    }
                });
            }
        }

        /* renamed from: com.huawei.android.remotecontrol.ui.webview.WapFindPhoneActivity$e$b */
        public class b extends AbstractC9478g {

            /* renamed from: a */
            public final /* synthetic */ String f20858a;

            public b(String str) {
                this.f20858a = str;
            }

            /* renamed from: k */
            public static /* synthetic */ void m27947k(Exception exc) {
                C13981a.m83988e("WapExternal", "sendSoundCmd exception:" + exc.getMessage());
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                final String str = this.f20858a;
                C0225l.m1577a(new InterfaceC14356c() { // from class: jg.h1
                    @Override // p851zp.InterfaceC14356c
                    public final Object execute() {
                        return this.f51653a.m27950j(str);
                    }
                }, new Consumer() { // from class: jg.i1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        WapFindPhoneActivity.C4534e.b.m27947k((Exception) obj);
                    }
                });
            }

            /* renamed from: g */
            public final /* synthetic */ void m27948g(Integer num, String str) {
                WapFindPhoneActivity.this.f20782s.loadUrl("javascript:sendSoundCmdResult(\"" + num + "\",\"" + str + "\")");
            }

            /* renamed from: h */
            public final /* synthetic */ void m27949h(final String str, final Integer num) {
                C13981a.m83989i("WapExternal", "sendSoundCmd result:" + num);
                WapFindPhoneActivity.this.f20782s.post(new Runnable() { // from class: jg.k1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f51665a.m27948g(num, str);
                    }
                });
            }

            /* renamed from: j */
            public final /* synthetic */ Boolean m27950j(final String str) throws Exception {
                FindNetwork.getFindNetworkEngine(WapFindPhoneActivity.this.getApplicationContext()).startSound(str, false, new C14299g(str, new Consumer() { // from class: jg.j1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f51661a.m27949h(str, (Integer) obj);
                    }
                }));
                return Boolean.TRUE;
            }
        }

        /* renamed from: com.huawei.android.remotecontrol.ui.webview.WapFindPhoneActivity$e$c */
        public class c extends AbstractC9478g {

            /* renamed from: a */
            public final /* synthetic */ String f20860a;

            public c(String str) {
                this.f20860a = str;
            }

            /* renamed from: g */
            public /* synthetic */ void m27955g(Integer num, String str) {
                WapFindPhoneActivity.this.f20782s.loadUrl("javascript:sendStopSoundCmdResult(\"" + num + "\",\"" + str + "\")");
            }

            /* renamed from: h */
            public /* synthetic */ void m27956h(final String str, final Integer num) {
                C13981a.m83989i("WapExternal", "sendStopSoundCmd result:" + num);
                WapFindPhoneActivity.this.f20782s.post(new Runnable() { // from class: jg.o1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f51682a.m27955g(num, str);
                    }
                });
            }

            /* renamed from: j */
            public /* synthetic */ Boolean m27957j(final String str) throws Exception {
                FindNetwork.getFindNetworkEngine(WapFindPhoneActivity.this.getApplicationContext()).stopSound(str, false, new C14299g(str, new Consumer() { // from class: jg.n1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f51679a.m27956h(str, (Integer) obj);
                    }
                }));
                return Boolean.TRUE;
            }

            /* renamed from: k */
            public static /* synthetic */ void m27958k(Exception exc) {
                C13981a.m83988e("WapExternal", "sendStopSoundCmd exception:" + exc.getMessage());
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                final String str = this.f20860a;
                C0225l.m1577a(new InterfaceC14356c() { // from class: jg.l1
                    @Override // p851zp.InterfaceC14356c
                    public final Object execute() {
                        return this.f51671a.m27957j(str);
                    }
                }, new Consumer() { // from class: jg.m1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        WapFindPhoneActivity.C4534e.c.m27958k((Exception) obj);
                    }
                });
            }
        }

        /* renamed from: com.huawei.android.remotecontrol.ui.webview.WapFindPhoneActivity$e$d */
        public class d extends AbstractC9478g {

            /* renamed from: a */
            public final /* synthetic */ PhoneFinderTrustCircleManager f20862a;

            /* renamed from: b */
            public final /* synthetic */ boolean f20863b;

            public d(PhoneFinderTrustCircleManager phoneFinderTrustCircleManager, boolean z10) {
                this.f20862a = phoneFinderTrustCircleManager;
                this.f20863b = z10;
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                PhoneFinderTrustCircleManager phoneFinderTrustCircleManager = this.f20862a;
                final boolean z10 = this.f20863b;
                phoneFinderTrustCircleManager.checkTrustCircleStatus(false, new Consumer() { // from class: jg.p1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f51687a.m27964h(z10, (TrustCircleInfo) obj);
                    }
                });
            }

            /* renamed from: h */
            public final /* synthetic */ void m27964h(boolean z10, TrustCircleInfo trustCircleInfo) {
                C13981a.m83989i("WapExternal", "checkTrustCircleStatus:" + trustCircleInfo.isJoinTrustCircle());
                if (trustCircleInfo.isJoinTrustCircle()) {
                    C4366a.m26382b().m26386e(4);
                    C4366a.m26382b().m26385d(4);
                    return;
                }
                C4366a.m26382b().m26386e(0);
                if (!WapFindPhoneActivity.this.f20807N) {
                    C13981a.m83990w("WapExternal", "joinCircle is not system account");
                } else if (z10) {
                    final WapFindPhoneActivity wapFindPhoneActivity = WapFindPhoneActivity.this;
                    C0226l0.m1584d(new Runnable() { // from class: jg.q1
                        @Override // java.lang.Runnable
                        public final void run() {
                            WapFindPhoneActivity.m27769p3(wapFindPhoneActivity);
                        }
                    });
                } else {
                    final WapFindPhoneActivity wapFindPhoneActivity2 = WapFindPhoneActivity.this;
                    C0226l0.m1584d(new Runnable() { // from class: jg.r1
                        @Override // java.lang.Runnable
                        public final void run() {
                            WapFindPhoneActivity.m27768o3(wapFindPhoneActivity2);
                        }
                    });
                }
            }
        }

        public C4534e() {
        }

        /* renamed from: J */
        public static /* synthetic */ void m27884J(CountDownLatch countDownLatch, Task task) {
            C13981a.m83989i("WapExternal", "getIsTrustTag complete");
            countDownLatch.countDown();
        }

        /* renamed from: P */
        public static /* synthetic */ void m27885P(Exception exc) {
            C13981a.m83988e("WapExternal", "queryStalkingTagRecords exception:" + exc.getMessage());
        }

        /* renamed from: Y */
        public static /* synthetic */ void m27887Y(Exception exc) {
            C13981a.m83988e("WapExternal", "requestTagPublicKeyAsync Exception " + exc.getMessage());
        }

        /* renamed from: a0 */
        public static /* synthetic */ void m27889a0(CountDownLatch countDownLatch, Void r22) {
            C13981a.m83989i("WapExternal", "setTrustTag success");
            countDownLatch.countDown();
        }

        /* renamed from: b0 */
        public static /* synthetic */ void m27891b0(CountDownLatch countDownLatch, Exception exc) {
            C13981a.m83989i("WapExternal", "setTrustTag fail");
            countDownLatch.countDown();
        }

        /* renamed from: c0 */
        public static /* synthetic */ void m27893c0(CountDownLatch countDownLatch, FindNetworkResult findNetworkResult) {
            C13981a.m83989i("WapExternal", "success result: " + findNetworkResult.getRespCode());
            countDownLatch.countDown();
        }

        /* renamed from: i0 */
        public static /* synthetic */ void m27901i0(Exception exc) {
            C13981a.m83988e("WapExternal", "userOperation exception:" + exc.getMessage());
        }

        /* renamed from: E */
        public final void m27920E() {
            if (System.currentTimeMillis() > WapFindPhoneActivity.f20793G0 + RippleView.SINGLE_RIPPLE_TIME) {
                C11880m.m71337d(WapFindPhoneActivity.this.f20804K, WapFindPhoneActivity.this.getString(R$string.click_fast));
                long unused = WapFindPhoneActivity.f20793G0 = System.currentTimeMillis();
            }
        }

        /* renamed from: F */
        public final boolean m27921F(boolean z10) {
            C13981a.m83989i("WapExternal", "joinCircleNow isNeedShowNote：" + z10);
            if (C0209d.m1277l1()) {
                return false;
            }
            WapFindPhoneActivity.this.m27820U4();
            PhoneFinderTrustCircleManager phoneFinderTrustCircleManager = new PhoneFinderTrustCircleManager(WapFindPhoneActivity.this.f20804K);
            if (!phoneFinderTrustCircleManager.isSupportTrustCircle()) {
                C4366a.m26382b().m26386e(-1);
                return false;
            }
            C4366a.m26382b().m26386e(1);
            WapFindPhoneActivity.this.f20840u0 = 1;
            C12515a.m75110o().m75172d(new d(phoneFinderTrustCircleManager, z10));
            return true;
        }

        /* renamed from: H */
        public final /* synthetic */ void m27922H(String str, FindNetworkResult findNetworkResult) {
            String str2 = "enableGoodsDisconnectNotifyEnhanced result return, respCode = " + findNetworkResult.getRespCode() + ",sn=" + C9120m0.m57351R(str);
            C13981a.m83989i("WapExternal", str2);
            new C12797b().m76784j(WapFindPhoneActivity.this.f20804K, "WapExternal", "", str2, "", "tag_local_find", "", "enableGoodsDisconnectNotifyEnhanced", false);
            C9120m0.m57358U0(str, "enableGoodsDisconnectNotifyEnhanced", findNetworkResult);
        }

        /* renamed from: K */
        public final /* synthetic */ void m27923K() {
            WapFindPhoneActivity wapFindPhoneActivity = WapFindPhoneActivity.this;
            wapFindPhoneActivity.m27701n2(wapFindPhoneActivity.getString(R$string.net_err_tip_no_net), 0);
        }

        /* renamed from: L */
        public final /* synthetic */ void m27924L() {
            WapFindPhoneActivity.this.m27721G4(true);
        }

        /* renamed from: M */
        public final /* synthetic */ void m27925M() {
            WapFindPhoneActivity.this.m27850m5(false);
        }

        /* renamed from: N */
        public final /* synthetic */ void m27926N(String str) {
            WapFindPhoneActivity.this.f20782s.loadUrl("javascript:setCurrentLocation(\"" + str + "\")");
        }

        /* renamed from: O */
        public final /* synthetic */ void m27927O(Location location) throws JSONException {
            if (location == null) {
                C13981a.m83988e("WapExternal", "queryCurrentLocation null");
                return;
            }
            double[] dArrM64544k = C10487l.m64544k(location.getLatitude(), location.getLongitude());
            JSONObject jSONObject = new JSONObject();
            if (dArrM64544k != null) {
                try {
                    if (dArrM64544k.length > 1) {
                        jSONObject.put(JsbMapKeyNames.H5_LOC_LAT, dArrM64544k[0]);
                        jSONObject.put(JsbMapKeyNames.H5_LOC_LON, dArrM64544k[1]);
                    }
                } catch (JSONException unused) {
                    C13981a.m83988e("WapExternal", "queryCurrentLocation json error");
                }
            }
            jSONObject.put("latitude_WGS", location.getLatitude());
            jSONObject.put("longitude_WGS", location.getLongitude());
            jSONObject.put("code", "0");
            final String strReplace = jSONObject.toString().replace("\"", "\\\"");
            WapFindPhoneActivity.this.f20782s.post(new Runnable() { // from class: jg.r0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f51693a.m27926N(strReplace);
                }
            });
        }

        /* renamed from: Q */
        public final /* synthetic */ void m27928Q(final Task task) {
            C0225l.m1577a(new InterfaceC14356c() { // from class: jg.u0
                @Override // p851zp.InterfaceC14356c
                public final Object execute() {
                    return this.f51707a.m27930S(task);
                }
            }, new Consumer() { // from class: jg.v0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    WapFindPhoneActivity.C4534e.m27885P((Exception) obj);
                }
            });
        }

        /* renamed from: R */
        public final /* synthetic */ void m27929R(String str) {
            WapFindPhoneActivity.this.f20782s.loadUrl("javascript:queryStalkingTagRecordsResult(\"" + str + "\")");
        }

        /* renamed from: S */
        public final /* synthetic */ Boolean m27930S(Task task) throws Exception {
            C13981a.m83989i("WapExternal", "queryStalkingTagRecords complete");
            if (task == null || task.getResult() == null) {
                C13981a.m83988e("WapExternal", "querySuspectStalkingTags result is null");
                return Boolean.TRUE;
            }
            FindNetworkResult findNetworkResult = (FindNetworkResult) task.getResult();
            C13981a.m83989i("WapExternal", "queryStalkingTagRecords respCode:" + findNetworkResult.getRespCode());
            if (findNetworkResult.getData() == null) {
                C13981a.m83988e("WapExternal", "queryStalkingTagRecords data is null");
                return Boolean.TRUE;
            }
            final String strM82840k = C13812b.m82840k(findNetworkResult.getData());
            C13981a.m83987d("WapExternal", "queryStalkingTagRecords arg:" + strM82840k);
            WapFindPhoneActivity.this.f20782s.post(new Runnable() { // from class: jg.w0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f51713a.m27929R(strM82840k);
                }
            });
            return Boolean.TRUE;
        }

        /* renamed from: T */
        public final /* synthetic */ void m27931T(String str) {
            WapFindPhoneActivity.this.f20782s.loadUrl("javascript:querySuspectStalkingTagsResult(\"" + str + "\")");
        }

        /* renamed from: U */
        public final /* synthetic */ void m27932U(Task task) {
            try {
                C13981a.m83989i("WapExternal", "querySuspectStalkingTags complete");
                if (task != null && task.getResult() != null) {
                    FindNetworkResult findNetworkResult = (FindNetworkResult) task.getResult();
                    C13981a.m83989i("WapExternal", "querySuspectStalkingTags respCode:" + findNetworkResult.getRespCode());
                    if (findNetworkResult.getData() == null) {
                        C13981a.m83988e("WapExternal", "querySuspectStalkingTags data is null");
                        return;
                    }
                    final String strReplace = findNetworkResult.getData().toString().replace("\\\"", "\\\\\"").replace("\"", "\\\"");
                    C13981a.m83987d("WapExternal", "querySuspectStalkingTags arg:" + strReplace);
                    WapFindPhoneActivity.this.f20782s.post(new Runnable() { // from class: jg.q0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f51690a.m27931T(strReplace);
                        }
                    });
                    return;
                }
                C13981a.m83988e("WapExternal", "querySuspectStalkingTags result is null");
            } catch (Exception e10) {
                C13981a.m83988e("WapExternal", "querySuspectStalkingTags exception:" + e10.getMessage());
            }
        }

        /* renamed from: W */
        public final /* synthetic */ void m27933W(String str, String str2, String str3) {
            WapFindPhoneActivity.this.f20782s.loadUrl("javascript:requestTagPublicKeyResult(\"" + str + "\",\"" + str2 + "\",\"" + str3 + "\")");
        }

        /* renamed from: X */
        public final /* synthetic */ Boolean m27934X(Task task, final String str, final String str2) throws Exception {
            if (task == null || task.getResult() == null) {
                C13981a.m83988e("WapExternal", "requestTagPublicKeyAsync result is null");
                return Boolean.TRUE;
            }
            FindNetworkResult findNetworkResult = (FindNetworkResult) task.getResult();
            C13981a.m83989i("WapExternal", "requestTagPublicKeyAsync respCode:" + findNetworkResult.getRespCode());
            new C12797b().m76784j(WapFindPhoneActivity.this.getApplicationContext(), "WapExternal", "", "requestTagPublicKeyAsync respCode:" + findNetworkResult.getRespCode(), "", "call_nearby_api_result", "", "call_nearby_api_result", true);
            final String strReplace = new Gson().toJson(findNetworkResult.getData()).replace("\"", "\\\"");
            WapFindPhoneActivity.this.f20782s.post(new Runnable() { // from class: jg.x0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f51715a.m27933W(str, str2, strReplace);
                }
            });
            return Boolean.TRUE;
        }

        /* renamed from: Z */
        public final /* synthetic */ void m27935Z(final String str, final String str2, final Task task) {
            C0225l.m1577a(new InterfaceC14356c() { // from class: jg.s0
                @Override // p851zp.InterfaceC14356c
                public final Object execute() {
                    return this.f51697a.m27934X(task, str, str2);
                }
            }, new Consumer() { // from class: jg.t0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    WapFindPhoneActivity.C4534e.m27887Y((Exception) obj);
                }
            });
        }

        @JavascriptInterface
        public void activateLock() {
            C13981a.m83989i("WapExternal", "activateLock");
            C11860j.m71046d1(WapFindPhoneActivity.this.f20804K);
        }

        @JavascriptInterface
        public void batchQueryOfflineLocation(String[] strArr) {
            C13981a.m83989i("WapExternal", "batchQueryOfflineLocation");
            C9120m0.m57357U(WapFindPhoneActivity.this.f20804K, Arrays.asList(strArr), WapFindPhoneActivity.this.f20828i0);
        }

        @JavascriptInterface
        public void callPhone(String str) {
            C13981a.m83989i("WapExternal", "callPhone");
            if (WapFindPhoneActivity.this.m27684U1("android.permission.CALL_PHONE")) {
                WapFindPhoneActivity.this.m27723H3(str);
            } else {
                WapFindPhoneActivity.this.f20821b0 = str;
                WapFindPhoneActivity.this.requestPermissions(C11275a.m67669b(), 3);
            }
        }

        @JavascriptInterface
        public void checkGoodsList() {
            C13981a.m83989i("WapExternal", "checkGoodsList");
            AncillaryDeviceManager.m26080y().m26081A();
        }

        @JavascriptInterface
        public void createLongConnection(String str) {
            C13981a.m83989i("WapExternal", "createLongConnection, tagSn: " + C9120m0.m57351R(str));
            WapFindPhoneActivity.this.f20835p0 = str;
            C11690w.m69745z(str, WapFindPhoneActivity.this.f20828i0);
        }

        @JavascriptInterface
        public void currentDeviceRingStatus(String str, boolean z10) {
            C13981a.m83989i("WapExternal", "currentDeviceRingStatus");
            C11690w.m69725k0(str, z10);
        }

        /* renamed from: d0 */
        public final /* synthetic */ void m27936d0(CountDownLatch countDownLatch, Exception exc) {
            C13981a.m83989i("WapExternal", "fail result: " + exc.getMessage());
            if (exc instanceof ApiException) {
                WapFindPhoneActivity.this.f20838s0 = ((ApiException) exc).getStatusCode();
            }
            countDownLatch.countDown();
        }

        /* renamed from: e0 */
        public final /* synthetic */ Task m27937e0(String str) throws Exception {
            return FindNetwork.getFindNetworkEngine(WapFindPhoneActivity.this.f20804K).unPair(str, WapFindPhoneActivity.this.new C4535f(str));
        }

        @JavascriptInterface
        public int enableFoundNotification(String str, String str2, boolean z10) throws InterruptedException {
            C13981a.m83989i("WapExternal", "enableFoundNotification, status: " + z10 + ", deviceId: " + C9120m0.m57351R(str));
            try {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                Task<FindNetworkResult<String>> taskAddOnCompleteListener = FindNetwork.getFindNetworkEngine(WapFindPhoneActivity.this.f20804K).enableFoundNotification(str, str2, z10).addOnCompleteListener(new InterfaceC8937e() { // from class: jg.i0
                    @Override // p208cq.InterfaceC8937e
                    public final void onComplete(Task task) {
                        countDownLatch.countDown();
                    }
                });
                C13981a.m83989i("WapExternal", "countDownLatch wait:" + countDownLatch.await(5L, TimeUnit.SECONDS));
                if (taskAddOnCompleteListener.getResult() == null) {
                    C13981a.m83988e("WapExternal", "enableFoundNotification fail");
                    return -1;
                }
                int respCode = taskAddOnCompleteListener.getResult().getRespCode();
                C13981a.m83989i("WapExternal", "enableFoundNotification, respCode result: " + respCode);
                return respCode;
            } catch (Exception unused) {
                C13981a.m83988e("WapExternal", "enableFoundNotification exception");
                return -1;
            }
        }

        @JavascriptInterface
        public void enableGoodsDisconnectNotify(String str, boolean z10) {
            try {
                FindNetwork.getFindNetworkEngine(WapFindPhoneActivity.this.f20804K).enableDisconnectNotification(str, z10);
            } catch (Exception unused) {
                C13981a.m83988e("WapExternal", "enableGoodsDisconnectNotify exception");
            }
        }

        @JavascriptInterface
        public void enableGoodsDisconnectNotifyEnhanced(final String str, int i10, String str2) {
            C13981a.m83989i("WapExternal", "enableGoodsDisconnectNotifyEnhanced");
            if (WapFindPhoneActivity.this.f20804K == null) {
                C13981a.m83988e("WapExternal", "enableGoodsDisconnectNotifyEnhanced mContext is null");
            } else {
                C9120m0.m57367Z(WapFindPhoneActivity.this.f20804K, str, i10, str2, new Consumer() { // from class: jg.m0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f51675a.m27922H(str, (FindNetworkResult) obj);
                    }
                });
            }
        }

        @JavascriptInterface
        public void enableGoodsLostBell(String str, boolean z10, boolean z11) {
            C13981a.m83989i("WapExternal", "enableGoodsLostBell, status: " + z10 + ", enable: " + z11 + ", deviceId: " + C9120m0.m57351R(str));
            C9097b.m57314x(C9310c.m58618b(str), z10);
            C9097b.m57314x("tagLostBellOMConfig", z11);
            if (z10) {
                return;
            }
            C9097b.m57313w(C9310c.m58618b(str), true);
        }

        @JavascriptInterface
        public void enableReFoundNotification(String str, boolean z10) {
            try {
                FindNetwork.getFindNetworkEngine(WapFindPhoneActivity.this.f20804K).enableReFoundNotification(str, z10);
                C13981a.m83989i("WapExternal", "enableReFoundNotification, status: " + z10);
            } catch (Exception unused) {
                C13981a.m83988e("WapExternal", "enableReFoundNotification exception");
            }
        }

        @JavascriptInterface
        public boolean foldedScreenState() {
            if (WapFindPhoneActivity.this.f20804K != null) {
                return C11842p.m70750N0() || C11842p.m70735I0();
            }
            C13981a.m83988e("WapExternal", "isFoldedScreenExpand context is null");
            return false;
        }

        /* renamed from: g0 */
        public final /* synthetic */ void m27938g0(boolean z10) {
            C11703j.m69826v(WapFindPhoneActivity.this.getWindow(), z10);
            C11703j.m69805a(WapFindPhoneActivity.this, z10);
        }

        @JavascriptInterface
        public boolean getCurrentIsContainTeeDevice() throws InterruptedException {
            try {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                Task<FindNetworkStatusResult> taskAddOnCompleteListener = FindNetwork.getFindNetworkEngine(WapFindPhoneActivity.this.f20804K).queryFindNetworkStatus().addOnCompleteListener(new InterfaceC8937e() { // from class: jg.y0
                    @Override // p208cq.InterfaceC8937e
                    public final void onComplete(Task task) {
                        countDownLatch.countDown();
                    }
                });
                C13981a.m83989i("WapExternal", "countDownLatch wait:" + countDownLatch.await(5L, TimeUnit.SECONDS));
                return taskAddOnCompleteListener.getResult().isSupportCrossDevices();
            } catch (Exception e10) {
                C13981a.m83988e("WapExternal", "queryFindNetworkStatus error: " + e10.getMessage());
                return false;
            }
        }

        @JavascriptInterface
        public String getCurrentTagSn() {
            return WapFindPhoneActivity.this.f20834o0;
        }

        @JavascriptInterface
        public float getFontScale() {
            return C0209d.m1195O(WapFindPhoneActivity.this.f20804K);
        }

        @JavascriptInterface
        public boolean getIsTrustTag(String str) throws JSONException, InterruptedException {
            FindNetworkResult result;
            C13981a.m83989i("WapExternal", "getIsTrustTag");
            if (TextUtils.isEmpty(str)) {
                C13981a.m83988e("WapExternal", "tagSN is empty");
                return false;
            }
            try {
                FindNetworkEngine findNetworkEngine = FindNetwork.getFindNetworkEngine(WapFindPhoneActivity.this.getApplicationContext());
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                Task<FindNetworkResult> taskAddOnCompleteListener = findNetworkEngine.getTrustTags().addOnCompleteListener(new InterfaceC8937e() { // from class: jg.e0
                    @Override // p208cq.InterfaceC8937e
                    public final void onComplete(Task task) {
                        WapFindPhoneActivity.C4534e.m27884J(countDownLatch, task);
                    }
                });
                C13981a.m83989i("WapExternal", "countDownLatch wait:" + countDownLatch.await(5L, TimeUnit.SECONDS));
                result = taskAddOnCompleteListener.getResult();
            } catch (Exception e10) {
                C13981a.m83988e("WapExternal", "getIsTrustTag error" + e10.getMessage());
            }
            if (result == null) {
                C13981a.m83988e("WapExternal", "getIsTrustTag result is null");
                return false;
            }
            C13981a.m83989i("WapExternal", "getIsTrustTag respCode:" + result.getRespCode());
            JSONArray jSONArray = new JSONArray(result.getData().toString());
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                SuspectStalkingAccessoryBean suspectStalkingAccessoryBean = (SuspectStalkingAccessoryBean) new Gson().fromJson(jSONArray.getJSONObject(i10).toString(), SuspectStalkingAccessoryBean.class);
                if (suspectStalkingAccessoryBean != null && str.equals(suspectStalkingAccessoryBean.getSn())) {
                    C13981a.m83989i("WapExternal", "getIsTrustTag:true");
                    return true;
                }
            }
            C13981a.m83989i("WapExternal", "getIsTrustTag:false");
            return false;
        }

        @JavascriptInterface
        public String getLocalDeviceId() {
            return C13452e.m80781L().m80950o();
        }

        @JavascriptInterface
        public int getMasterVersionCode() {
            C13981a.m83989i("WapExternal", "getMasterVersionCode");
            return C0241z.m1685c(C1443a.f6213a);
        }

        @JavascriptInterface
        public String getNetWorkStatus() {
            String strM1228Z = C0209d.m1228Z(C0209d.m1225Y(WapFindPhoneActivity.this.f20804K));
            C13981a.m83989i("WapExternal", "getNetWorkStatus, netType: " + strM1228Z);
            return strM1228Z;
        }

        @JavascriptInterface
        public int getNotchWidth() {
            return 0;
        }

        @JavascriptInterface
        public String getProductBrandInfo() {
            C13981a.m83989i("WapExternal", "getBrand");
            return C11703j.m69812h();
        }

        @JavascriptInterface
        public String getSupportedMapNavList(String str) {
            C13981a.m83989i("WapExternal", "getSupportedMapNavList:" + str);
            if (TextUtils.isEmpty(str)) {
                C13981a.m83988e("WapExternal", "packageNameList is empty");
                return "";
            }
            String[] strArrSplit = str.split(",");
            StringBuilder sb2 = new StringBuilder();
            if (strArrSplit.length > 0) {
                Context contextM74301m = C12347f.m74285n().m74301m();
                for (String str2 : strArrSplit) {
                    if (C11703j.m69815k(contextM74301m, str2)) {
                        sb2.append(str2);
                        sb2.append(",");
                    }
                }
            }
            String string = sb2.toString();
            return TextUtils.isEmpty(string) ? "" : string.substring(0, string.length() - 1);
        }

        @JavascriptInterface
        public String getSystemLanguage() {
            return C11703j.m69814j();
        }

        @JavascriptInterface
        public String getSystemLoginInfo() throws JSONException {
            C13981a.m83989i("WapExternal", "getSystemLoginInfo lastPortalTime:" + WapFindPhoneActivity.this.f20845z0);
            C12797b c12797b = new C12797b();
            long jAbs = Math.abs(System.currentTimeMillis() - WapFindPhoneActivity.this.f20845z0) / 1000;
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("portalSpaceTimeKey", jAbs + "");
            linkedHashMap.put("portalAuthCodeTime", WapFindPhoneActivity.this.f20797A0 + "");
            linkedHashMap.put("portalAuthCodeEmpty", TextUtils.isEmpty(WapFindPhoneActivity.this.f20819Z) + "");
            linkedHashMap.put("portalCurrent", System.currentTimeMillis() + "");
            linkedHashMap.put("portalEqual", TextUtils.equals(WapFindPhoneActivity.this.f20798B0, WapFindPhoneActivity.this.f20819Z) + "");
            long j10 = jAbs >= 250 ? jAbs : 0L;
            c12797b.m76785k(WapFindPhoneActivity.this.getApplicationContext(), "WapExternal", j10 + "", "getSystemLoginInfo space time: " + jAbs, null, "PortalSpaceTime", null, "PortalSpaceTime", true, linkedHashMap);
            C13981a.m83989i("WapExternal", "getSystemLoginInfo spaceTime:" + jAbs);
            WapFindPhoneActivity.this.f20845z0 = System.currentTimeMillis();
            WapFindPhoneActivity wapFindPhoneActivity = WapFindPhoneActivity.this;
            wapFindPhoneActivity.f20798B0 = wapFindPhoneActivity.f20819Z;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("authCode", WapFindPhoneActivity.this.f20819Z);
                jSONObject.put("clientOS", WapFindPhoneActivity.this.f20844y0);
                int iM80947n0 = C13452e.m80781L().m80947n0();
                if (iM80947n0 != 0) {
                    jSONObject.put("siteID", String.valueOf(iM80947n0));
                } else {
                    jSONObject.put("siteID", String.valueOf(1));
                }
            } catch (Exception e10) {
                C13981a.m83988e("WapExternal", "getSystemLoginInfo exception:" + e10.getMessage());
            }
            return jSONObject.toString();
        }

        @JavascriptInterface
        public String getThirdMapNavList() {
            return "false";
        }

        /* renamed from: h0 */
        public final /* synthetic */ Task m27939h0(int i10, String str) throws Exception {
            return FindNetwork.getFindNetworkEngine(WapFindPhoneActivity.this.f20804K).userOperation(i10, str);
        }

        @JavascriptInterface
        public boolean hasLocationPermission() {
            return WapFindPhoneActivity.this.m27684U1(C11275a.m67670c());
        }

        @JavascriptInterface
        public boolean isCloudOpen() {
            boolean zM62355l1 = C10028c.m62182c0().m62355l1();
            boolean zM80842P0 = C13452e.m80781L().m80842P0();
            boolean zM62221H1 = C10028c.m62182c0().m62221H1();
            C13981a.m83989i("WapExternal", "isCloudLogin isFinderEnable:" + zM62355l1 + ", isLogin:" + zM80842P0 + ", isTermAgreed:" + zM62221H1);
            return zM80842P0 && zM62221H1 && zM62355l1;
        }

        @JavascriptInterface
        public boolean isDarkMode() {
            C13981a.m83989i("WapExternal", "isDarkMode");
            if (WapFindPhoneActivity.this.f20804K == null) {
                C13981a.m83990w("WapExternal", "context null");
                return false;
            }
            WapFindPhoneActivity wapFindPhoneActivity = WapFindPhoneActivity.this;
            return wapFindPhoneActivity.f20779H == 1 && C11703j.m69816l(wapFindPhoneActivity.f20804K);
        }

        @JavascriptInterface
        public boolean isEuropeDevice() {
            return C0209d.m1220W0();
        }

        @JavascriptInterface
        public boolean isInMultiWindowMode() {
            if (WapFindPhoneActivity.this.f20804K != null) {
                return WapFindPhoneActivity.this.f20804K.isInMultiWindowMode();
            }
            C13981a.m83988e("WapExternal", "isInMultiWindowMode context is null");
            return false;
        }

        @JavascriptInterface
        public boolean isNeedActivateLock() {
            C13981a.m83989i("WapExternal", "isNeedActivateLock");
            if (!C0209d.m1166E1()) {
                C13981a.m83989i("WapExternal", "is not owner user");
                return false;
            }
            String strM80971t0 = C13452e.m80781L().m80971t0();
            String userID = AbstractC12139d.m72766e(WapFindPhoneActivity.this.f20804K).getUserID();
            if (!TextUtils.isEmpty(strM80971t0) && !TextUtils.isEmpty(userID) && !strM80971t0.equals(userID)) {
                C13981a.m83990w("WapExternal", "userId not match");
                return true;
            }
            if (!C11877j.m71224O(WapFindPhoneActivity.this.f20804K)) {
                return false;
            }
            C13981a.m83988e("WapExternal", "isNeedActivateLock, cloud has lock");
            return true;
        }

        @JavascriptInterface
        public boolean isNeedOpenBluetooth(String str) {
            if (WapFindPhoneActivity.this.f20825f0 == null) {
                WapFindPhoneActivity.this.f20825f0 = WapFindPhoneActivity.this.new BluetoothStatueReceiver();
                IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
                intentFilter.addAction("huawei.sle.adapter.action.SLE_STATE_CHANGED");
                WapFindPhoneActivity.this.f20804K.registerReceiver(WapFindPhoneActivity.this.f20825f0, intentFilter);
            }
            Bundle bundle = new Bundle();
            PhoneFinderProvider.m26457a(WapFindPhoneActivity.this.f20804K, str, bundle);
            return bundle.getBoolean("isNeedOpenBluetooth");
        }

        @JavascriptInterface
        public boolean isNotificationEnabled() {
            return C1009d.m6109e().m6118j(WapFindPhoneActivity.this.f20804K);
        }

        @JavascriptInterface
        public boolean isOpenLocation() {
            boolean zM82829z = C13811a.m82829z(WapFindPhoneActivity.this.f20804K);
            C13981a.m83989i("WapExternal", "isOpenLocation: " + zM82829z);
            String strM82822s = C13811a.m82822s();
            if (WapFindPhoneActivity.m27740U3()) {
                C13981a.m83989i("WapExternal", "isOpenLocation, getLocationStatus is true");
                return true;
            }
            if (strM82822s == null || strM82822s.isEmpty()) {
                return zM82829z;
            }
            C13981a.m83989i("WapExternal", "isOpenLocation, userLocateConf: " + strM82822s);
            return strM82822s.contains(FaqConstants.DISABLE_HA_REPORT);
        }

        @JavascriptInterface
        public boolean isOwnerUser() {
            return C0209d.m1166E1();
        }

        @JavascriptInterface
        public boolean isSystemAccount() {
            boolean z10 = WapFindPhoneActivity.this.f20807N;
            C13981a.m83987d("WapExternal", "isSystemAccount: " + z10);
            return z10;
        }

        @JavascriptInterface
        public boolean isWifiOnly() {
            TelephonyManager telephonyManager;
            C13981a.m83989i("WapExternal", "isWifiOnly");
            return (WapFindPhoneActivity.this.f20804K == null || (telephonyManager = (TelephonyManager) WapFindPhoneActivity.this.f20804K.getSystemService("phone")) == null || telephonyManager.getPhoneType() != 0) ? false : true;
        }

        @JavascriptInterface
        public boolean joinCircle() {
            C13981a.m83989i("WapExternal", "joinCircle");
            return m27921F(true);
        }

        @JavascriptInterface
        public boolean joinCircleWithoutDialog() {
            C13981a.m83989i("WapExternal", "joinCircleWithoutDialog");
            return m27921F(false);
        }

        @JavascriptInterface
        public void jumpMarketDownloadApp(String str) {
            C13981a.m83989i("WapExternal", "jumpMarketDownloadApp, packageName: " + str);
            C11703j.m69819o(WapFindPhoneActivity.this.f20804K, str);
        }

        @JavascriptInterface
        public void jumpToAccountCenter() {
            C13981a.m83989i("WapExternal", "jumpToAccountCenter");
            if (!C0209d.m1333z1(WapFindPhoneActivity.this)) {
                C13981a.m83989i("WapExternal", "network disconnect");
                WapFindPhoneActivity.this.f20828i0.post(new Runnable() { // from class: jg.p0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f51686a.m27923K();
                    }
                });
            } else {
                WapFindPhoneActivity wapFindPhoneActivity = WapFindPhoneActivity.this;
                wapFindPhoneActivity.m27815R3(wapFindPhoneActivity);
                C13009a.m78310e(WapFindPhoneActivity.this, "app_findphone_setting_click_account", "findphone_account", C13452e.m80781L().m80790C());
            }
        }

        @JavascriptInterface
        public void jumpToSetting() {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", WapFindPhoneActivity.this.getPackageName(), null));
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            try {
                WapFindPhoneActivity.this.startActivity(intent);
            } catch (Exception unused) {
                C13981a.m83988e("WapExternal", "jumpToSetting error");
            }
        }

        /* renamed from: k0 */
        public final void m27940k0(String str, String str2) {
            if ("com.huawei.android.findmyphone".equals(WapFindPhoneActivity.this.f20818Y)) {
                C13981a.m83989i("WapExternal", "sendBroadcastToSlave");
                HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent("com.huawei.android.findmyphone.action.MASTER_WAP_LOGIN"));
                C0209d.m1302r2(hiCloudSafeIntent, "com.huawei.android.findmyphone");
                hiCloudSafeIntent.putExtra(JsbMapKeyNames.H5_USER_ID, str);
                hiCloudSafeIntent.putExtra("countryCode", str2);
                hiCloudSafeIntent.putExtra("isSystemAccount", WapFindPhoneActivity.this.f20807N);
                WapFindPhoneActivity.this.sendBroadcast(hiCloudSafeIntent, "com.huawei.android.findmyphone.permission.bussiness");
            }
        }

        @JavascriptInterface
        public void logWap(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            str.hashCode();
            switch (str) {
                case "INFO":
                    C13982b.m83993i("WapExtLog", str2);
                    break;
                case "WARN":
                    C13982b.m83994w("WapExtLog", str2);
                    break;
                case "DEBUG":
                    C13982b.m83991d("WapExtLog", str2);
                    break;
                case "ERROR":
                    C13982b.m83992e("WapExtLog", str2);
                    break;
            }
        }

        @JavascriptInterface
        public void onLoadPageHome(String str) {
            C13981a.m83989i("WapExternal", "onLoadPageHome homeUrl is :" + C11703j.m69807c(str));
            WapFindPhoneActivity.this.f20817X = true;
            WapFindPhoneActivity.this.f20810Q = false;
            WapFindPhoneActivity.this.f20828i0.post(new Runnable() { // from class: jg.f0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f51642a.m27924L();
                }
            });
            if (WapFindPhoneActivity.this.f20823d0 != null) {
                WapFindPhoneActivity.this.f20823d0.m68588l(C13452e.m80781L().m80971t0());
            }
            C11702i.m69800p(str);
        }

        @JavascriptInterface
        public void onLoginSuccess(String str, String str2) {
            C13981a.m83989i("WapExternal", "onLoginSuccess");
            C11702i.m69804t(str);
            C11702i.m69801q(WapFindPhoneActivity.this, str2);
            C11702i.m69802r(WapFindPhoneActivity.this, true);
            m27940k0(str, str2);
            WapFindPhoneActivity.this.f20828i0.post(new Runnable() { // from class: jg.j0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f51660a.m27925M();
                }
            });
            C12797b.m76777l(WapFindPhoneActivity.this.f20804K, "portal_login", null, WapFindPhoneActivity.this.m27821V3(), 1, "0", C13009a.m78312g(WapFindPhoneActivity.this.f20807N), str, C13009a.m78313h(WapFindPhoneActivity.this.f20807N));
        }

        @JavascriptInterface
        public void onWebPageEvent(String str, String str2, String str3, String str4, String str5) {
            C12797b c12797b = new C12797b();
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("portalExtra", str5);
            c12797b.m76785k(WapFindPhoneActivity.this.getApplicationContext(), "WapExternal", "0", str, null, str2, str3, str4, true, linkedHashMap);
        }

        @JavascriptInterface
        public void openBluetooth() {
            C13981a.m83989i("WapExternal", "open bluetooth");
            C13168a.m79187p();
            try {
                new Timer().schedule(new a(), 300L);
            } catch (Exception e10) {
                C13981a.m83988e("WapExternal", "openCurrentDeviceSwitch error: " + e10.getMessage());
            }
        }

        @JavascriptInterface
        public void openLocalDeviceSwitch() {
            C13981a.m83989i("WapExternal", "openLocalDeviceSwitch");
            C11690w.m69699V(WapFindPhoneActivity.this.f20828i0);
        }

        @JavascriptInterface
        public void openLocation() {
            C13981a.m83989i("WapExternal", "click openLocation");
            C13811a.m82788F(WapFindPhoneActivity.this.f20804K);
            WapFindPhoneActivity.m27760j5(true);
            WapFindPhoneActivity.m27758i5(C13811a.m82806c(WapFindPhoneActivity.this.f20804K));
        }

        @JavascriptInterface
        public void openPhoneFinder() {
            C13981a.m83989i("WapExternal", "openPhoneFinder");
            C11860j.m71037a1(1);
            C11860j.m71030X0(501);
            C11877j.m71307t1(C0213f.m1377a());
            C11860j.m71051f0(WapFindPhoneActivity.this.f20804K, 7, false);
        }

        @JavascriptInterface
        public void queryCapability(String str) {
            C13981a.m83989i("WapExternal", "queryCapability deviceId:" + C9120m0.m57351R(str));
            C11690w.m69709c0(WapFindPhoneActivity.this.f20804K, str, WapFindPhoneActivity.this.f20828i0);
        }

        @JavascriptInterface
        public void queryCurrentLocation() {
            if (C11702i.m69795k() == null || !C11702i.m69795k().equals(C13452e.m80781L().m80971t0())) {
                C13981a.m83988e("WapExternal", "user unavailable");
            } else {
                C13811a.m82802T(new Consumer() { // from class: jg.o0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) throws JSONException {
                        this.f51681a.m27927O((Location) obj);
                    }
                }, WapFindPhoneActivity.this.getApplicationContext());
            }
        }

        @JavascriptInterface
        public void queryDeviceCapabilities(String str) {
            C13981a.m83989i("WapExternal", "queryDeviceCapabilities deviceId: " + C9120m0.m57351R(str));
            C9120m0.m57364X0(WapFindPhoneActivity.this.f20804K, str, WapFindPhoneActivity.this.f20828i0);
        }

        @JavascriptInterface
        public String queryDeviceInfo() {
            String str = "deviceSn:" + C12498f.m75015b(WapFindPhoneActivity.this.f20804K) + ";deviceType:" + C13452e.m80781L().m80966s() + ";deviceAliasName:" + C0224k0.a.m1573b("ro.config.marketing_name", Build.MODEL);
            C13981a.m83989i("WapExternal", "queryDeviceInfo success");
            return str;
        }

        @JavascriptInterface
        public void queryLocalCapability() {
            C13981a.m83989i("WapExternal", "queryLocalCapability");
            if (WapFindPhoneActivity.this.f20825f0 == null) {
                WapFindPhoneActivity.this.f20825f0 = WapFindPhoneActivity.this.new BluetoothStatueReceiver();
                IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
                if (C13168a.m79184m()) {
                    intentFilter.addAction("huawei.sle.adapter.action.SLE_STATE_CHANGED");
                }
                WapFindPhoneActivity.this.f20804K.registerReceiver(WapFindPhoneActivity.this.f20825f0, intentFilter);
            }
            C11690w.m69705a0(WapFindPhoneActivity.this.f20828i0);
        }

        @JavascriptInterface
        public String queryPhoneFinderStatus() {
            C13981a.m83989i("WapExternal", "queryPhoneFinderStatus");
            StringBuilder sb2 = new StringBuilder();
            Bundle bundle = new Bundle();
            PhoneFinderProvider.m26458b(WapFindPhoneActivity.this.f20804K, C11702i.m69795k(), bundle);
            boolean z10 = bundle.getBoolean("isPhoneFinderOpen");
            sb2.append("isPhoneFinderOpen:");
            sb2.append(z10);
            if (!z10) {
                if (bundle.getBoolean("isPhoneFinderCanOpen")) {
                    sb2.append(";deviceID:");
                    sb2.append(C13452e.m80781L().m80950o());
                    sb2.append(";deviceType:");
                    sb2.append(C0209d.m1170F1() ? "pad" : "phone");
                    sb2.append(";displayName:");
                    sb2.append(C0224k0.a.m1573b("ro.config.marketing_name", Build.MODEL));
                } else {
                    C13981a.m83989i("WapExternal", "can't to open phoneFinder");
                }
            }
            return sb2.toString();
        }

        @JavascriptInterface
        public String queryStalkingTagRecords(String str) {
            C13981a.m83989i("WapExternal", "queryStalkingTagRecords");
            if (TextUtils.isEmpty(str)) {
                C13981a.m83988e("WapExternal", "macAddress is empty");
                return "";
            }
            try {
                FindNetwork.getFindNetworkEngine(WapFindPhoneActivity.this.getApplicationContext()).getAntiStalkingRecords(str).addOnCompleteListener(new InterfaceC8937e() { // from class: jg.h0
                    @Override // p208cq.InterfaceC8937e
                    public final void onComplete(Task task) {
                        this.f51652a.m27928Q(task);
                    }
                });
            } catch (Exception e10) {
                C13981a.m83988e("WapExternal", "queryStalkingTagRecords exception:" + e10.getMessage());
            }
            return "";
        }

        @JavascriptInterface
        public String querySuspectStalkingTags() {
            C13981a.m83989i("WapExternal", "querySuspectStalkingTags");
            try {
                FindNetwork.getFindNetworkEngine(WapFindPhoneActivity.this.getApplicationContext()).getSuspectStalkingTags().addOnCompleteListener(new InterfaceC8937e() { // from class: jg.d1
                    @Override // p208cq.InterfaceC8937e
                    public final void onComplete(Task task) {
                        this.f51632a.m27932U(task);
                    }
                });
                return "asyncWaiting";
            } catch (Exception e10) {
                C13981a.m83988e("WapExternal", "querySuspectStalkingTags exception:" + e10.getMessage());
                return "asyncWaiting";
            }
        }

        @JavascriptInterface
        public boolean releaseBleConnection(String str) {
            C13981a.m83989i("WapExternal", "releaseBleConnection deviceId:" + C9120m0.m57351R(str));
            updateLongConnection(str);
            return true;
        }

        @JavascriptInterface
        public int requestCircleState() {
            if (C0209d.m1277l1() || !C4375j.m26423y()) {
                C13981a.m83988e("WapExternal", "requestCircleState not support circle");
                return -1;
            }
            if (!C4366a.m26382b().m26384c()) {
                C4366a.m26382b().m26386e(-1);
            }
            int iM26383a = C4366a.m26382b().m26383a();
            int i10 = iM26383a == -2 ? 4 : iM26383a;
            C13981a.m83989i("WapExternal", "circleState: " + iM26383a);
            if (WapFindPhoneActivity.this.f20840u0 != -3) {
                i10 = WapFindPhoneActivity.this.f20840u0;
            }
            C13981a.m83989i("WapExternal", "requestCircleState: " + i10);
            return i10;
        }

        @JavascriptInterface
        public boolean requestLocationPermission() {
            C13981a.m83989i("WapExternal", "requestLocationPermission");
            if (WapFindPhoneActivity.this.m27684U1(C11275a.m67668a()) || !WapFindPhoneActivity.this.m27841g4()) {
                return false;
            }
            WapFindPhoneActivity.this.requestPermissions(C11275a.m67670c(), 4);
            return true;
        }

        @JavascriptInterface
        public String requestPublicKey(String str, String str2, String str3, long j10) throws NumberFormatException {
            int i10;
            long j11;
            C4534e c4534e = this;
            C13981a.m83989i("WapExternal", "requestPublicKey");
            if (C0209d.m1277l1()) {
                return "";
            }
            C12797b c12797b = new C12797b();
            byte[] bArrM26409k = C4375j.m26409k(str);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || bArrM26409k.length == 0) {
                C13981a.m83988e("WapExternal", "requestPublicKey params is empty");
                return "";
            }
            if (!C4375j.m26423y()) {
                C13981a.m83990w("WapExternal", "requestPublicKey huks not support");
                c12797b.m76784j(WapFindPhoneActivity.this.getApplicationContext(), "WapExternal", "", "requestPublicKey huks not support", "", "call_asset_api_result", "", "call_asset_api_result", true);
                return "";
            }
            if (!C4376k.m26426b(WapFindPhoneActivity.this.f20804K, C4375j.m26409k(str), str3.getBytes(StandardCharsets.ISO_8859_1), "FindPhoneSlaveKey")) {
                C13981a.m83988e("WapExternal", "requestPublicKey assetUnwrapPrivateKey failed");
                c12797b.m76784j(WapFindPhoneActivity.this.getApplicationContext(), "WapExternal", "", "requestPublicKey assetUnwrapPrivateKey failed", "", "call_asset_api_result", "", "call_asset_api_result", true);
                return "";
            }
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            while (i11 < 7) {
                String strM26416r = C4375j.m26416r(j10 - (i11 * 86400000));
                byte[] bArrM26431g = C4376k.m26431g(WapFindPhoneActivity.this.getApplicationContext(), str2 + strM26416r, "FindPhoneSlaveKey");
                if (bArrM26431g.length <= 0) {
                    i10 = i11;
                    c12797b.m76784j(WapFindPhoneActivity.this.getApplicationContext(), "WapExternal", "", "requestPublicKey failed generatePublicKey is empty", "", "call_asset_api_result", "", "call_asset_api_result", true);
                    C13981a.m83988e("WapExternal", "generatePublicKey is empty");
                } else {
                    i10 = i11;
                    String upperCase = C11476b.m68619a(C0227m.m1594g(bArrM26431g)).toUpperCase(Locale.ENGLISH);
                    try {
                        j11 = Long.parseLong(strM26416r);
                    } catch (Exception e10) {
                        C13981a.m83988e("WapExternal", "parseLong failed:" + e10.getMessage());
                        j11 = 0;
                    }
                    long j12 = j11;
                    c12797b.m76784j(WapFindPhoneActivity.this.getApplicationContext(), "WapExternal", "", "requestPublicKey publicKey:" + upperCase + ",dataTime:" + j12, "", "call_asset_api_result", "", "call_asset_api_result", true);
                    arrayList.add(new OfflinePublicKeyInfoBean(upperCase, Long.valueOf(j12)));
                }
                i11 = i10 + 1;
                c4534e = this;
            }
            return new Gson().toJson(arrayList);
        }

        @JavascriptInterface
        public String requestTagPublicKey(String str) throws InterruptedException {
            C13981a.m83989i("WapExternal", "requestTagPublicKey");
            if (TextUtils.isEmpty(str)) {
                C13981a.m83988e("WapExternal", "tagSN is empty");
                return "";
            }
            try {
                FindNetworkEngine findNetworkEngine = FindNetwork.getFindNetworkEngine(WapFindPhoneActivity.this.getApplicationContext());
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                Task<FindNetworkResult<TagDerivedKey>> taskAddOnCompleteListener = findNetworkEngine.queryTagDerivedKey(str, 7).addOnCompleteListener(new InterfaceC8937e() { // from class: jg.g0
                    @Override // p208cq.InterfaceC8937e
                    public final void onComplete(Task task) {
                        countDownLatch.countDown();
                    }
                });
                C13981a.m83989i("WapExternal", "countDownLatch wait:" + countDownLatch.await(5L, TimeUnit.SECONDS));
                FindNetworkResult<TagDerivedKey> result = taskAddOnCompleteListener.getResult();
                if (result == null) {
                    C13981a.m83988e("WapExternal", "requestTagPublicKey result is null");
                    return "";
                }
                C13981a.m83989i("WapExternal", "requestTagPublicKey respCode:" + result.getRespCode());
                new C12797b().m76784j(WapFindPhoneActivity.this.getApplicationContext(), "WapExternal", "", "requestTagPublicKey respCode:" + result.getRespCode(), "", "call_nearby_api_result", "", "call_nearby_api_result", true);
                return new Gson().toJson(result.getData());
            } catch (Exception e10) {
                C13981a.m83988e("WapExternal", "requestTagPublicKey Exception " + e10.getMessage());
                return "";
            }
        }

        @JavascriptInterface
        public void requestTagPublicKeyAsync(final String str, final String str2) {
            C13981a.m83989i("WapExternal", "requestTagPublicKeyAsync");
            if (TextUtils.isEmpty(str)) {
                C13981a.m83988e("WapExternal", "tagSN is empty");
                return;
            }
            try {
                FindNetwork.getFindNetworkEngine(WapFindPhoneActivity.this.getApplicationContext()).queryTagDerivedKey(str, 7).addOnCompleteListener(new InterfaceC8937e() { // from class: jg.e1
                    @Override // p208cq.InterfaceC8937e
                    public final void onComplete(Task task) {
                        this.f51637a.m27935Z(str2, str, task);
                    }
                });
            } catch (Exception e10) {
                C13981a.m83988e("WapExternal", "requestTagPublicKeyAsync Exception " + e10.getMessage());
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x001e, code lost:
        
            p809yg.C13981a.m83988e("WapExternal", "deviceId is empty");
         */
        @android.webkit.JavascriptInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String requestUnwrapLocation(java.lang.String r7, java.lang.String r8) throws org.json.JSONException {
            /*
                r6 = this;
                java.lang.String r0 = "requestUnwrapLocation"
                java.lang.String r1 = "WapExternal"
                p809yg.C13981a.m83989i(r1, r0)
                org.json.JSONArray r0 = new org.json.JSONArray
                r0.<init>()
                org.json.JSONArray r2 = new org.json.JSONArray     // Catch: java.lang.Exception -> L25
                r2.<init>(r7)     // Catch: java.lang.Exception -> L25
                r7 = 0
            L12:
                int r3 = r2.length()     // Catch: java.lang.Exception -> L25
                if (r7 >= r3) goto Lb3
                boolean r3 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Exception -> L25
                if (r3 == 0) goto L28
                java.lang.String r6 = "deviceId is empty"
                p809yg.C13981a.m83988e(r1, r6)     // Catch: java.lang.Exception -> L25
                goto Lb3
            L25:
                r6 = move-exception
                goto L9b
            L28:
                org.json.JSONObject r3 = r2.getJSONObject(r7)     // Catch: java.lang.Exception -> L25
                com.google.gson.Gson r4 = new com.google.gson.Gson     // Catch: java.lang.Exception -> L25
                r4.<init>()     // Catch: java.lang.Exception -> L25
                java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L25
                java.lang.Class<com.huawei.android.remotecontrol.offlinelocate.bean.OfflineLocateInfo> r5 = com.huawei.android.remotecontrol.offlinelocate.bean.OfflineLocateInfo.class
                java.lang.Object r3 = r4.fromJson(r3, r5)     // Catch: java.lang.Exception -> L25
                com.huawei.android.remotecontrol.offlinelocate.bean.OfflineLocateInfo r3 = (com.huawei.android.remotecontrol.offlinelocate.bean.OfflineLocateInfo) r3     // Catch: java.lang.Exception -> L25
                if (r3 == 0) goto L92
                java.lang.String r4 = r3.getEncLocation()     // Catch: java.lang.Exception -> L25
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L25
                if (r4 != 0) goto L92
                java.lang.String r4 = r3.getTag()     // Catch: java.lang.Exception -> L25
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L25
                if (r4 != 0) goto L92
                java.lang.String r4 = r3.getTmpPublicKey()     // Catch: java.lang.Exception -> L25
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L25
                if (r4 == 0) goto L5e
                goto L92
            L5e:
                java.lang.String r4 = "0"
                java.lang.String r5 = r3.getPerDeviceType()     // Catch: java.lang.Exception -> L25
                boolean r4 = r4.equals(r5)     // Catch: java.lang.Exception -> L25
                if (r4 == 0) goto L78
                com.huawei.android.remotecontrol.ui.webview.WapFindPhoneActivity r4 = com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneActivity.this     // Catch: java.lang.Exception -> L25
                android.app.Activity r4 = com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneActivity.m27719F3(r4)     // Catch: java.lang.Exception -> L25
                java.lang.String r3 = p227dg.C9120m0.m57373b0(r4, r3, r8)     // Catch: java.lang.Exception -> L25
                r0.put(r3)     // Catch: java.lang.Exception -> L25
                goto L97
            L78:
                java.lang.String r4 = "3"
                java.lang.String r5 = r3.getPerDeviceType()     // Catch: java.lang.Exception -> L25
                boolean r4 = r4.equals(r5)     // Catch: java.lang.Exception -> L25
                if (r4 == 0) goto L97
                com.huawei.android.remotecontrol.ui.webview.WapFindPhoneActivity r4 = com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneActivity.this     // Catch: java.lang.Exception -> L25
                android.content.Context r4 = r4.getApplicationContext()     // Catch: java.lang.Exception -> L25
                java.lang.String r3 = p227dg.C9120m0.m57388g0(r4, r3, r8)     // Catch: java.lang.Exception -> L25
                r0.put(r3)     // Catch: java.lang.Exception -> L25
                goto L97
            L92:
                java.lang.String r3 = "encryptData is empty"
                p809yg.C13981a.m83988e(r1, r3)     // Catch: java.lang.Exception -> L25
            L97:
                int r7 = r7 + 1
                goto L12
            L9b:
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = "requestUnwrapLocation error"
                r7.append(r8)
                java.lang.String r6 = r6.getMessage()
                r7.append(r6)
                java.lang.String r6 = r7.toString()
                p809yg.C13981a.m83988e(r1, r6)
            Lb3:
                java.lang.String r6 = r0.toString()
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneActivity.C4534e.requestUnwrapLocation(java.lang.String, java.lang.String):java.lang.String");
        }

        @JavascriptInterface
        public void requestUnwrapLocationList(String str, String str2) {
            C13981a.m83989i("WapExternal", "requestUnwrapLocationList");
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                C13981a.m83988e("WapExternal", "deviceId or locations is empty");
                return;
            }
            Gson gson = new Gson();
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    OfflineLocateInfo offlineLocateInfo = (OfflineLocateInfo) gson.fromJson(jSONArray.getJSONObject(i10).toString(), OfflineLocateInfo.class);
                    if (offlineLocateInfo == null || TextUtils.isEmpty(offlineLocateInfo.getEncLocation()) || TextUtils.isEmpty(offlineLocateInfo.getTag()) || TextUtils.isEmpty(offlineLocateInfo.getTmpPublicKey())) {
                        C13981a.m83988e("WapExternal", "encryptData is empty");
                    } else if ("0".equals(offlineLocateInfo.getPerDeviceType())) {
                        arrayList.add(offlineLocateInfo);
                    }
                }
                C9120m0.m57376c0(WapFindPhoneActivity.this.f20804K, arrayList, str2, WapFindPhoneActivity.this.f20828i0);
            } catch (Exception e10) {
                C13981a.m83988e("WapExternal", "requestUnwrapLocation error" + e10.getMessage());
            }
        }

        @JavascriptInterface
        public boolean sendPairedTagCmd(String str, String str2) {
            String str3 = "sendPairedTagCmd:" + str2 + " , sn" + C9120m0.m57351R(str);
            C13981a.m83989i("WapExternal", str3);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                C13981a.m83988e("WapExternal", "sendPairedTagCmd tagSn or operation is empty");
                return false;
            }
            if (WapFindPhoneActivity.this.f20804K == null) {
                C13981a.m83988e("WapExternal", "mContext is null");
                return false;
            }
            new C12797b().m76784j(WapFindPhoneActivity.this.f20804K, "WapExternal", "", str3, "", "tag_local_find", "", str2, false);
            WapFindPhoneActivity.this.m27820U4();
            C9120m0.m57370a0(WapFindPhoneActivity.this.f20804K, str, str2, WapFindPhoneActivity.this.f20828i0);
            return true;
        }

        @JavascriptInterface
        public int sendSoundCmd(String str) {
            C13981a.m83989i("WapExternal", "sendSoundCmd");
            if (TextUtils.isEmpty(str)) {
                C13981a.m83988e("WapExternal", "tagSN is empty");
                return 1;
            }
            C12515a.m75110o().m75172d(new b(str));
            return -1;
        }

        @JavascriptInterface
        public int sendStopSoundCmd(String str) {
            C13981a.m83989i("WapExternal", "sendStopSoundCmd");
            if (TextUtils.isEmpty(str)) {
                C13981a.m83988e("WapExternal", "tagSN is empty");
                return 1;
            }
            C12515a.m75110o().m75172d(new c(str));
            return -1;
        }

        @JavascriptInterface
        public void setDeviceOnlineStatus(int i10) {
            C13981a.m83988e("WapExternal", "setDeviceOnlineStatus =" + i10);
            this.f20855a = i10;
        }

        @JavascriptInterface
        public void setDevicesPublicKey(String str, String str2, String str3, long j10) {
            C13981a.m83989i("WapExternal", "setDevicesPublicKey, deviceId: " + C9120m0.m57351R(str2));
            C9120m0.m57404l1(WapFindPhoneActivity.this.f20804K, str, str2, str3, j10);
        }

        @JavascriptInterface
        public boolean setTrustTag(String str, boolean z10) throws InterruptedException {
            C13981a.m83989i("WapExternal", "setTrustTag");
            if (TextUtils.isEmpty(str)) {
                C13981a.m83988e("WapExternal", "tagSN is empty");
                return false;
            }
            try {
                FindNetworkEngine findNetworkEngine = FindNetwork.getFindNetworkEngine(WapFindPhoneActivity.this.getApplicationContext());
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                Task<Void> taskAddOnFailureListener = findNetworkEngine.setTrustTag(str, z10).addOnSuccessListener(new InterfaceC8939g() { // from class: jg.z0
                    @Override // p208cq.InterfaceC8939g
                    public final void onSuccess(Object obj) {
                        WapFindPhoneActivity.C4534e.m27889a0(countDownLatch, (Void) obj);
                    }
                }).addOnFailureListener(new InterfaceC8938f() { // from class: jg.a1
                    @Override // p208cq.InterfaceC8938f
                    public final void onFailure(Exception exc) {
                        WapFindPhoneActivity.C4534e.m27891b0(countDownLatch, exc);
                    }
                });
                C13981a.m83989i("WapExternal", "countDownLatch wait:" + countDownLatch.await(5L, TimeUnit.SECONDS));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("setTrustTag:");
                sb2.append(taskAddOnFailureListener.isComplete() && taskAddOnFailureListener.isSuccessful());
                C13981a.m83989i("WapExternal", sb2.toString());
                if (taskAddOnFailureListener.isComplete()) {
                    return taskAddOnFailureListener.isSuccessful();
                }
                return false;
            } catch (Exception e10) {
                C13981a.m83988e("WapExternal", "setTrustTag exception:" + e10.getMessage());
                return false;
            }
        }

        @JavascriptInterface
        public void startBluetoothNavigation(String str, String str2) {
            C13981a.m83987d("WapExternal", "startBluetoothNavigation(String deviceId, String itemName) is Deprecated");
            startMultiArgsBluetoothNavigation(str, str2, null, null, null);
        }

        @JavascriptInterface
        public void startFastDiscovery(String str) {
            C13981a.m83989i("WapExternal", "startFastDiscovery deviceId:" + C9120m0.m57351R(str));
            if (C0209d.m1226Y0()) {
                C13981a.m83989i("WapExternal", "fastClick");
            } else {
                C11690w.m69727l0(str, WapFindPhoneActivity.this.f20828i0);
            }
        }

        @JavascriptInterface
        public boolean startFastPair() {
            return startFastPairExt() == 0;
        }

        @JavascriptInterface
        public int startFastPairExt() throws InterruptedException {
            Task<FindNetworkResult<Void>> taskAddOnFailureListener;
            WapFindPhoneActivity.this.f20838s0 = -1;
            if (!C11877j.m71246Z(WapFindPhoneActivity.this.getApplicationContext())) {
                return WapFindPhoneActivity.this.f20838s0;
            }
            try {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                taskAddOnFailureListener = FindNetwork.getFindNetworkEngine(WapFindPhoneActivity.this.f20804K).startFastPair().addOnSuccessListener(new InterfaceC8939g() { // from class: jg.k0
                    @Override // p208cq.InterfaceC8939g
                    public final void onSuccess(Object obj) {
                        WapFindPhoneActivity.C4534e.m27893c0(countDownLatch, (FindNetworkResult) obj);
                    }
                }).addOnFailureListener(new InterfaceC8938f() { // from class: jg.l0
                    @Override // p208cq.InterfaceC8938f
                    public final void onFailure(Exception exc) {
                        this.f51669a.m27936d0(countDownLatch, exc);
                    }
                });
                C13981a.m83987d("WapExternal", "countDownLatch wait:" + countDownLatch.await(5L, TimeUnit.SECONDS));
            } catch (Exception e10) {
                C13981a.m83988e("WapExternal", "startFastPair exception: " + e10.getMessage());
            }
            if (taskAddOnFailureListener.getResult() == null) {
                return WapFindPhoneActivity.this.f20838s0;
            }
            WapFindPhoneActivity.this.f20838s0 = taskAddOnFailureListener.getResult().getRespCode();
            C13981a.m83989i("WapExternal", "startFastPair result: " + WapFindPhoneActivity.this.f20838s0);
            return WapFindPhoneActivity.this.f20838s0;
        }

        @JavascriptInterface
        public void startMultiArgsBluetoothNavigation(String str, String str2, String str3, String str4, String str5) {
            if (C0209d.m1226Y0()) {
                C13981a.m83990w("WapExternal", "startMultiArgsBluetoothNavigation isFastClick");
                m27920E();
                return;
            }
            if (str == null || str2 == null) {
                C13981a.m83988e("WapExternal", "deviceId or itemName is null");
                return;
            }
            boolean zIsEmpty = TextUtils.isEmpty(str3);
            DeviceDetail deviceDetailM80764i = C13442i.m80758j().m80764i();
            if (str3 == null) {
                str3 = deviceDetailM80764i == null ? "" : deviceDetailM80764i.getProductId();
            }
            String str6 = str3;
            int componentType = deviceDetailM80764i == null ? 0 : deviceDetailM80764i.getComponentType();
            try {
                C13981a.m83989i("WapExternal", "to BluetoothNavigationActivity, modeId: " + str6 + ", subModelId: " + str4);
                WapFindPhoneActivity.this.m27820U4();
                Intent intent = new Intent(WapFindPhoneActivity.this.f20804K, (Class<?>) BluetoothNavigationActivity.class);
                intent.putExtra("TagSN", str);
                intent.putExtra("itemName", str2);
                intent.putExtra("subModelId", str4);
                intent.putExtra("iconUrl", str5);
                intent.putExtra("modelId", str6);
                intent.putExtra("mainDevice", zIsEmpty);
                intent.putExtra("componentType", componentType);
                WapFindPhoneActivity.this.startActivityForResult(intent, 6);
            } catch (Exception unused) {
                C13981a.m83988e("WapExternal", "to Exact search error");
            }
            C9120m0.m57383e1(WapFindPhoneActivity.this.f20804K, "mecloud_findmyphone_bluetooth_navigate_show", str, str2, str6, 0);
        }

        @JavascriptInterface
        public void startMultiArgsNavigation(String str, String str2, String str3, String str4, String str5) {
            if (C0209d.m1226Y0()) {
                C13981a.m83990w("WapExternal", "startMultiArgsNavigation isFastClick");
                m27920E();
                return;
            }
            if (str == null || str2 == null) {
                C13981a.m83988e("WapExternal", "deviceId or itemName is null");
                return;
            }
            DeviceDetail deviceDetailM80764i = C13442i.m80758j().m80764i();
            if (str3 == null) {
                str3 = deviceDetailM80764i == null ? "" : deviceDetailM80764i.getProductId();
            }
            String str6 = str3;
            int componentType = deviceDetailM80764i == null ? 0 : deviceDetailM80764i.getComponentType();
            try {
                C13981a.m83989i("WapExternal", "to PrecisionNavigationActivity, modelId: " + str6 + ", subModelId: " + str4);
                WapFindPhoneActivity.this.m27820U4();
                Intent intent = new Intent(WapFindPhoneActivity.this.f20804K, (Class<?>) PrecisionNavigationActivity.class);
                intent.putExtra("TagSN", str);
                intent.putExtra("itemName", str2);
                intent.putExtra("subModelId", str4);
                intent.putExtra("iconUrl", str5);
                intent.putExtra("modelId", str6);
                intent.putExtra("componentType", componentType);
                WapFindPhoneActivity.this.startActivityForResult(intent, 5);
            } catch (Exception unused) {
                C13981a.m83988e("WapExternal", "to Exact search error");
            }
            C9120m0.m57383e1(WapFindPhoneActivity.this.f20804K, "mecloud_findmyphone_precision_navigate_show", str, str2, str6, 0);
        }

        @JavascriptInterface
        public void startNavigation(String str, String str2) {
            C13981a.m83987d("WapExternal", "startNavigation(String deviceId, String itemName) is Deprecated");
            startMultiArgsNavigation(str, str2, null, null, null);
        }

        @JavascriptInterface
        public void startNearLink(String str, String str2, String str3, String str4, String str5) {
            C13981a.m83989i("WapExternal", "startNearLink, deviceId: " + C9120m0.m57351R(str));
            if (C0209d.m1226Y0()) {
                C13981a.m83990w("WapExternal", "startNearLink isFastClick");
                m27920E();
                return;
            }
            if (str == null || str2 == null) {
                C13981a.m83988e("WapExternal", "deviceId or itemName is null");
                return;
            }
            boolean zIsEmpty = TextUtils.isEmpty(str3);
            DeviceDetail deviceDetailM80764i = C13442i.m80758j().m80764i();
            if (str3 == null) {
                str3 = deviceDetailM80764i == null ? "" : deviceDetailM80764i.getProductId();
            }
            int componentType = deviceDetailM80764i == null ? 0 : deviceDetailM80764i.getComponentType();
            try {
                C13981a.m83989i("WapExternal", "startNearLink to NearLinkNavigationActivity, modelId: " + str3 + ", subModelId: " + str4);
                WapFindPhoneActivity.this.m27820U4();
                Intent intent = new Intent(WapFindPhoneActivity.this.f20804K, (Class<?>) NearLinkNavigationActivity.class);
                intent.putExtra("TagSN", str);
                intent.putExtra("itemName", str2);
                intent.putExtra("subModelId", str4);
                intent.putExtra("iconUrl", str5);
                intent.putExtra("modelId", str3);
                intent.putExtra("mainDevice", zIsEmpty);
                intent.putExtra("mainDeviceOnline", this.f20855a == 1);
                intent.putExtra("componentType", componentType);
                WapFindPhoneActivity.this.startActivityForResult(intent, 8);
                WapFindPhoneActivity.this.f20841v0 = true;
                C11690w.m69700W(str, "nearLinkOperation", "nearLinkBusiness", "startNearLink", "0", null);
            } catch (Exception unused) {
                C13981a.m83988e("WapExternal", "to Exact search error");
            }
        }

        @JavascriptInterface
        public void startRingOffline(String str) {
            C13981a.m83989i("WapExternal", "startRingOffline deviceId:" + C9120m0.m57351R(str));
            C11690w.m69731n0(WapFindPhoneActivity.this.f20804K, str, WapFindPhoneActivity.this.f20828i0);
        }

        @JavascriptInterface
        public void stopRingOffline(String str) {
            C13981a.m83989i("WapExternal", "stopRingOffline deviceId:" + C9120m0.m57351R(str));
            C11690w.m69733o0(WapFindPhoneActivity.this.f20804K, str, WapFindPhoneActivity.this.f20828i0);
        }

        @JavascriptInterface
        public void tagRemove(final String str) {
            C13981a.m83989i("WapExternal", "tagRemove");
            C0225l.m1577a(new InterfaceC14356c() { // from class: jg.f1
                @Override // p851zp.InterfaceC14356c
                public final Object execute() {
                    return this.f51643a.m27937e0(str);
                }
            }, new Consumer() { // from class: jg.d0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C13981a.m83988e("WapExternal", "unpair error");
                }
            });
            C9097b.m57313w(C9310c.m58618b(str), true);
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            C12797b c12797b = new C12797b();
            linkedHashMap.put("perDeviceId", C9120m0.m57351R(str));
            c12797b.m76785k(WapFindPhoneActivity.this.getApplicationContext(), "WapExternal", "0", "tagRemove", null, "01058", null, "finderTagUnpair", true, linkedHashMap);
        }

        @JavascriptInterface
        public void updateLongConnection(String str) {
            C13981a.m83989i("WapExternal", "updateLongConnection, deviceId: " + C9120m0.m57351R(str) + ", isNearLinkPage: " + WapFindPhoneActivity.this.f20841v0);
            WapFindPhoneActivity.this.f20835p0 = null;
            WapFindPhoneActivity wapFindPhoneActivity = WapFindPhoneActivity.this;
            if (wapFindPhoneActivity.f20841v0) {
                return;
            }
            C11690w.m69735p0(wapFindPhoneActivity.f20804K, str);
        }

        @JavascriptInterface
        public void updateWindowFlag(final boolean z10) {
            C13981a.m83989i("WapExternal", "updateWindowFlag:" + z10);
            WapFindPhoneActivity.this.f20828i0.post(new Runnable() { // from class: jg.c0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f51627a.m27938g0(z10);
                }
            });
        }

        @JavascriptInterface
        public void userOperation(final int i10, final String str) {
            C13981a.m83989i("WapExternal", "userOperation, operationCode:" + i10);
            C0225l.m1577a(new InterfaceC14356c() { // from class: jg.b1
                @Override // p851zp.InterfaceC14356c
                public final Object execute() {
                    return this.f51623a.m27939h0(i10, str);
                }
            }, new Consumer() { // from class: jg.c1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    WapFindPhoneActivity.C4534e.m27901i0((Exception) obj);
                }
            });
        }

        @JavascriptInterface
        public void wapLoginExpired() {
            C13981a.m83989i("WapExternal", "wapLoginExpired retryCount = " + WapFindPhoneActivity.this.f20803J);
            if (WapFindPhoneActivity.this.f20803J >= 3) {
                WapFindPhoneActivity.this.f20828i0.obtainMessage(1001, Boolean.TRUE).sendToTarget();
                return;
            }
            if (WapFindPhoneActivity.this.m27816R4()) {
                C13981a.m83990w("WapExternal", "fast reLogin callback");
                return;
            }
            WapFindPhoneActivity.m27711C3(WapFindPhoneActivity.this);
            HandlerC4536g handlerC4536g = WapFindPhoneActivity.this.f20828i0;
            final WapFindPhoneActivity wapFindPhoneActivity = WapFindPhoneActivity.this;
            handlerC4536g.post(new Runnable() { // from class: jg.n0
                @Override // java.lang.Runnable
                public final void run() {
                    WapFindPhoneActivity.m27780u3(wapFindPhoneActivity);
                }
            });
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.webview.WapFindPhoneActivity$f */
    public class C4535f extends FindNetworkCallback<FindNetworkResult<Void>> {

        /* renamed from: b */
        public String f20865b;

        public C4535f(String str) {
            this.f20865b = str;
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onFail(FindNetworkResult<FindNetworkResult<Void>> findNetworkResult) {
            C13981a.m83989i("WapFindPhoneActivity", "unpair tag fail:" + findNetworkResult.getRespCode());
            WapFindPhoneActivity.this.f20782s.loadUrl("javascript:tagRemoveResult(\"" + this.f20865b + "\"," + findNetworkResult.getRespCode() + ")");
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onSuccess(FindNetworkResult<FindNetworkResult<Void>> findNetworkResult) {
            C13981a.m83989i("WapFindPhoneActivity", "unpair tag success");
            WapFindPhoneActivity.this.f20782s.loadUrl("javascript:tagRemoveResult(\"" + this.f20865b + "\"," + findNetworkResult.getRespCode() + ")");
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.webview.WapFindPhoneActivity$g */
    public static class HandlerC4536g extends Handler {

        /* renamed from: a */
        public final WeakReference<WapFindPhoneActivity> f20867a;

        public HandlerC4536g(WapFindPhoneActivity wapFindPhoneActivity) {
            this.f20867a = new WeakReference<>(wapFindPhoneActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            WapFindPhoneActivity wapFindPhoneActivity = this.f20867a.get();
            if (wapFindPhoneActivity == null) {
                return;
            }
            wapFindPhoneActivity.m27746Y3(message);
        }
    }

    public WapFindPhoneActivity() {
        HashMap map = new HashMap();
        this.f20800D0 = map;
        Boolean bool = Boolean.TRUE;
        map.put("goods", bool);
        map.put("share", bool);
        map.put("trackedTag", bool);
        this.f20801E0 = new C14298f();
    }

    /* renamed from: C3 */
    public static /* synthetic */ int m27711C3(WapFindPhoneActivity wapFindPhoneActivity) {
        int i10 = wapFindPhoneActivity.f20803J;
        wapFindPhoneActivity.f20803J = i10 + 1;
        return i10;
    }

    /* renamed from: C4 */
    public /* synthetic */ void m27712C4(DialogInterface dialogInterface, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m27809N3();
        C13981a.m83989i("WapFindPhoneActivity", "finish");
        finish();
    }

    /* renamed from: D4 */
    public static /* synthetic */ void m27715D4(Boolean bool) {
        C13981a.m83989i("WapFindPhoneActivity", "showOfflineLocateDialog report pk response: " + bool);
        C11690w.m69700W("", "trustCircleOperation", "trustCircleBusiness", "showOfflineLocateDialog report pk response: " + bool, "0", null);
    }

    /* renamed from: G4 */
    public void m27721G4(boolean z10) {
        if (z10) {
            C13981a.m83989i("WapFindPhoneActivity", "hide loading");
            SafeWebView safeWebView = this.f20782s;
            if (safeWebView != null) {
                safeWebView.setVisibility(0);
            }
            View view = this.f20789z;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        C13981a.m83989i("WapFindPhoneActivity", "show loading");
        SafeWebView safeWebView2 = this.f20782s;
        if (safeWebView2 != null) {
            safeWebView2.setVisibility(8);
        }
        View view2 = this.f20789z;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    /* renamed from: H3 */
    public void m27723H3(String str) {
        if (str == null) {
            C13981a.m83988e("WapFindPhoneActivity", "phoneNumber is null");
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(NavigationUtils.TEL_SCHEMA_PREF + str));
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            startActivity(intent);
        } catch (Exception unused) {
            C13981a.m83988e("WapFindPhoneActivity", "call telephone error ");
        }
    }

    /* renamed from: P4 */
    private void m27732P4() {
        boolean zM6139e = C1010e.m6125b().m6139e(this);
        C13981a.m83989i("WapFindPhoneActivity", "queryActiveState:" + this.f20839t0 + "; phonefinderStatus: " + zM6139e);
        if (this.f20839t0 || !zM6139e) {
            return;
        }
        if (!C0209d.m1333z1(this)) {
            C13981a.m83989i("WapFindPhoneActivity", "network disconnect, do query delay");
        } else {
            C11866p.m71115n(false, AbstractC12139d.m72766e(this.f20804K).getSiteID(), 2).m75045o();
            this.f20839t0 = true;
        }
    }

    /* renamed from: Q3 */
    private void m27734Q3() {
        AlertDialog alertDialog = this.f20830k0;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f20830k0 = null;
        }
    }

    /* renamed from: T3 */
    public static String m27738T3() {
        return f20796J0;
    }

    /* renamed from: U3 */
    public static boolean m27740U3() {
        return f20795I0;
    }

    /* renamed from: X4 */
    private void m27744X4() {
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("callFrom", this.f20818Y);
        String strM80790C = C13452e.m80781L().m80790C();
        linkedHashMapM79499C.put("gradeCode", strM80790C);
        C13230i.m79504I().m79591l0("mecloud_findmyphone_portal_show", linkedHashMapM79499C);
        UBAAnalyze.m29956Q("PVP", "mecloud_findmyphone_portal_show", "1", this.f20818Y, strM80790C);
    }

    /* renamed from: Y3 */
    public void m27746Y3(Message message) {
        C13981a.m83989i("WapFindPhoneActivity", "Handle message, id = " + message.what);
        if (isFinishing() || isDestroyed()) {
            C13981a.m83989i("WapFindPhoneActivity", "WapWebViewActivity is destroyed, not handle message");
            return;
        }
        int i10 = message.what;
        if (i10 == 1001) {
            m27851n5(message);
            return;
        }
        if (i10 == 1002) {
            m27756h5(getString(R$string.getting_file_please_wait));
            return;
        }
        if (i10 == 1003) {
            m27756h5(getString(R$string.loading_tips_map_page_slow));
            return;
        }
        if (i10 == 1004) {
            m27810N4(message.obj);
            return;
        }
        if (i10 == 1005) {
            m27812O4();
            return;
        }
        if (i10 == 1006) {
            m27721G4(true);
            return;
        }
        if (i10 == 1007) {
            m27796F4(message);
            return;
        }
        if (i10 == 1009) {
            m27832b5(message);
            return;
        }
        if (i10 == 1008) {
            m27826Y4(message);
            return;
        }
        if (i10 == 1011) {
            m27828Z4(message);
            return;
        }
        if (i10 == 1010) {
            m27830a5(message);
            return;
        }
        if (i10 == 1013) {
            m27834c5(message);
            return;
        }
        if (i10 == 1014) {
            m27836d5(message);
            return;
        }
        if (i10 == 1016) {
            m27813P3(message);
            return;
        }
        if (i10 == 1017) {
            m27814Q4(message);
            return;
        }
        if (i10 == 1018) {
            m27804K4(message);
        } else if (i10 == 1019) {
            m27797G3(message);
        } else if (i10 == 1020) {
            m27840f5();
        }
    }

    /* renamed from: h5 */
    private void m27756h5(String str) {
        TextView textView = this.f20806M;
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* renamed from: i5 */
    public static synchronized void m27758i5(String str) {
        f20796J0 = str;
    }

    /* renamed from: j5 */
    public static synchronized void m27760j5(boolean z10) {
        f20795I0 = z10;
    }

    /* renamed from: k4 */
    public static /* synthetic */ void m27762k4(C10588b c10588b) {
        C13981a.m83989i("WapFindPhoneActivity", "clear picker result:" + c10588b.m64964a().m64997c());
    }

    /* renamed from: m4 */
    public /* synthetic */ void m27765m4(View view) {
        C11703j.m69825u(this, true);
    }

    /* renamed from: n4 */
    public /* synthetic */ void m27767n4(View view) {
        this.f20782s.clearHistory();
        m27696g2("");
        this.f20817X = false;
        this.f20810Q = true;
        if (!TextUtils.isEmpty(this.f20819Z) || this.f20820a0) {
            C13981a.m83989i("WapFindPhoneActivity", "picker login fail, retry");
            C11697d.m69760e().m69768l(false);
            m27721G4(false);
            m27827Z3();
            m27817S3(true);
            return;
        }
        C13981a.m83989i("WapFindPhoneActivity", "login fail, retry");
        String strM69790f = C11702i.m69790f();
        if (TextUtils.isEmpty(strM69790f)) {
            strM69790f = this.f20776E;
        }
        m27838e5();
        m27819T4(strM69790f);
        m27721G4(false);
        m27827Z3();
        this.f20782s.loadUrl(strM69790f);
    }

    /* renamed from: o3 */
    public static /* synthetic */ void m27768o3(WapFindPhoneActivity wapFindPhoneActivity) {
        wapFindPhoneActivity.m27862t5();
    }

    /* renamed from: p3 */
    public static /* synthetic */ void m27769p3(WapFindPhoneActivity wapFindPhoneActivity) {
        wapFindPhoneActivity.m27853o5();
    }

    /* renamed from: r5 */
    private void m27774r5() {
        C13981a.m83989i("WapFindPhoneActivity", "check supper privacy mode");
        AlertDialog alertDialog = this.f20830k0;
        if (alertDialog != null && alertDialog.isShowing()) {
            C13981a.m83989i("WapFindPhoneActivity", "supper privacy dialog isShowing");
            return;
        }
        try {
            if (this.f20830k0 == null) {
                this.f20830k0 = new AlertDialog.Builder(this).setTitle(getString(R$string.supper_privacy_dialog_title)).setMessage(getString(R$string.supper_privacy_dialog_msg)).setPositiveButton(getString(R$string.supper_privacy_dialog_positive), new DialogInterface.OnClickListener() { // from class: jg.s
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                        this.f51696a.m27793B4(dialogInterface, i10);
                    }
                }).setNegativeButton(getString(R$string.supper_privacy_dialog_negitive), new DialogInterface.OnClickListener() { // from class: jg.t
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        this.f51704a.m27712C4(dialogInterface, i10);
                    }
                }).create();
            }
            this.f20830k0.show();
        } catch (Exception unused) {
            C13981a.m83988e("WapFindPhoneActivity", "show supper privacy dialog exception");
        }
    }

    /* renamed from: u3 */
    public static /* synthetic */ void m27780u3(WapFindPhoneActivity wapFindPhoneActivity) {
        wapFindPhoneActivity.m27818S4();
    }

    /* renamed from: y4 */
    public static /* synthetic */ void m27789y4(Boolean bool) {
        C13981a.m83989i("WapFindPhoneActivity", "set web cook result:" + bool);
    }

    /* renamed from: A4 */
    public final /* synthetic */ void m27792A4(DialogInterface dialogInterface) {
        C4366a.m26382b().m26386e(3);
        C4366a.m26382b().m26385d(3);
        this.f20840u0 = -3;
        C11690w.m69700W("", "trustCircleOperation", "trustCircleBusiness", "showOfflineLocateDialog click cancel", "0", null);
    }

    /* renamed from: B4 */
    public final /* synthetic */ void m27793B4(DialogInterface dialogInterface, int i10) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("WapFindPhoneActivity", "set supper privacy mode OFF, needLoadWapUrl=" + this.f20832m0);
        C11881n.m71349L();
        if (this.f20832m0) {
            m27800I4();
        }
    }

    @Override // kg.InterfaceC11053d
    /* renamed from: E */
    public void mo27794E(WebView webView, int i10) {
        C13981a.m83989i("WapFindPhoneActivity", "onProgressChanged,progress:" + i10);
        if (!this.f20810Q) {
            C13981a.m83987d("WapFindPhoneActivity", "do not needShowLoading");
            m27721G4(true);
            m27682S1();
            return;
        }
        if (!this.f20807N) {
            m27721G4(i10 == 100);
        } else if (i10 == 100) {
            C13981a.m83987d("WapFindPhoneActivity", "system account return!");
        } else {
            m27721G4(false);
        }
        C13981a.m83989i("WapFindPhoneActivity", "checkNetWorkState");
        m27682S1();
    }

    /* renamed from: E4 */
    public final /* synthetic */ void m27795E4(TrustCircleInfo trustCircleInfo) {
        if (trustCircleInfo.isJoinTrustCircle()) {
            C4366a.m26382b().m26386e(4);
            C4366a.m26382b().m26385d(4);
            if (!C4375j.m26387A()) {
                C13981a.m83988e("WapFindPhoneActivity", "showOfflineLocateDialog no support offline locate");
                return;
            } else {
                C4375j.m26419u(this.f20804K.getApplicationContext(), String.valueOf(trustCircleInfo.getMkVersion()), new Consumer() { // from class: jg.r
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        WapFindPhoneActivity.m27715D4((Boolean) obj);
                    }
                });
            }
        } else {
            C4366a.m26382b().m26386e(2);
            C4366a.m26382b().m26385d(2);
        }
        this.f20840u0 = -3;
        C11690w.m69700W("", "trustCircleOperation", "trustCircleBusiness", "showOfflineLocateDialog join result: " + trustCircleInfo.isJoinTrustCircle(), "0", null);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: F1 */
    public void mo22366F1() throws IllegalAccessException, IllegalArgumentException {
        if (C0219i.m1463a() < 17 || !C11829c.m70563b0(this)) {
            return;
        }
        C11829c.m70591k1(this);
    }

    /* renamed from: F4 */
    public final void m27796F4(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            C13981a.m83988e("WapFindPhoneActivity", "loadOfflineLocation loadUrl fail");
            return;
        }
        final String string = ((Bundle) obj).getString("keyUrl");
        final String string2 = ((Bundle) message.obj).getString("TagSN");
        this.f20782s.post(new Runnable() { // from class: jg.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f51633a.m27852o4(string, string2);
            }
        });
        C13981a.m83989i("WapFindPhoneActivity", "loadOfflineLocation loadUrl success");
    }

    /* renamed from: G3 */
    public final void m27797G3(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            C13981a.m83988e("WapFindPhoneActivity", "batchQueryOfflineLocationResult loadUrl fail");
            return;
        }
        final String string = ((Bundle) obj).getString("keyUrl");
        C13981a.m83989i("WapFindPhoneActivity", "batchQueryOfflineLocationResult loadUrl success");
        this.f20782s.post(new Runnable() { // from class: jg.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f51705a.m27845j4(string);
            }
        });
    }

    /* renamed from: H4 */
    public final void m27798H4() {
        C13981a.m83989i("WapFindPhoneActivity", "loadWapUrl: " + this.f20818Y);
        if (this.f20815V || this.f20816W) {
            this.f20815V = false;
            this.f20816W = false;
            if (this.f20807N) {
                C13981a.m83989i("WapFindPhoneActivity", "page restore need picker login");
                m27817S3(false);
                return;
            } else {
                this.f20819Z = "";
                this.f20797A0 = System.currentTimeMillis();
            }
        }
        if (!"com.huawei.android.findmyphone".equals(this.f20818Y) && !"fromPFClick".equals(this.f20818Y) && !"fromFAClick".equals(this.f20818Y) && !"fromNotificationClick".equals(this.f20818Y) && !NotifyConstants.TYPE_DEEPLINK.equals(this.f20818Y) && !"fromMainActivityFindPhoneBanner".equals(this.f20818Y)) {
            m27860s5();
            return;
        }
        m27721G4(false);
        m27825X3();
        m27809N3();
    }

    /* renamed from: I3 */
    public boolean m27799I3() {
        if (C13452e.m80781L().m80842P0()) {
            return true;
        }
        C13981a.m83989i("WapFindPhoneActivity", "hicloud not login, finish");
        return false;
    }

    /* renamed from: I4 */
    public final void m27800I4() {
        C13981a.m83989i("WapFindPhoneActivity", "onSupperPrivacyModeDisable");
        m27798H4();
    }

    /* renamed from: J3 */
    public final void m27801J3() {
        C13981a.m83989i("WapFindPhoneActivity", "checkCircleStatus");
        if (C0209d.m1277l1()) {
            return;
        }
        if (!C13452e.m80781L().m80803F0().booleanValue()) {
            C13981a.m83990w("WapFindPhoneActivity", "not china region");
            return;
        }
        C4366a.m26382b().m26386e(-2);
        Activity activity = this.f20804K;
        if (activity == null) {
            return;
        }
        if (new PhoneFinderTrustCircleManager(activity).isSupportTrustCircle()) {
            C12515a.m75110o().m75172d(new C4533d(this.f20804K, this.f20828i0));
        } else {
            C4366a.m26382b().m26386e(-1);
        }
    }

    /* renamed from: J4 */
    public final void m27802J4(String str, String str2, int i10) throws JsonIOException {
        C13981a.m83989i("WapFindPhoneActivity", "onTagNavigationReturn respCode = " + i10);
        if (i10 == 11) {
            m27701n2(getString(R$string.bluetooth_disconnect_retry), 0);
        }
        if (TextUtils.isEmpty(str2)) {
            C13981a.m83988e("WapFindPhoneActivity", "onTagNavigationReturn sn is empty");
            return;
        }
        TagLocalFindResult tagLocalFindResult = new TagLocalFindResult(str2, str, String.valueOf(i10), i10 == 0 ? "success" : "fail");
        tagLocalFindResult.setCurrentTime(System.currentTimeMillis());
        String json = new Gson().toJson(tagLocalFindResult, TagLocalFindResult.class);
        C14298f c14298f = this.f20801E0;
        if (c14298f == null) {
            this.f20801E0 = new C14298f(str);
        } else {
            c14298f.m85164h(str);
        }
        this.f20801E0.m85163g(C12347f.m74285n().m74301m(), tagLocalFindResult, json);
    }

    /* renamed from: K3 */
    public final void m27803K3() {
        boolean z10 = C11842p.m70750N0() || C11842p.m70735I0();
        if (this.f20782s == null || this.f20837r0 == z10) {
            return;
        }
        this.f20837r0 = z10;
        C13981a.m83989i("WapFindPhoneActivity", "checkFoldedScreenState notify:" + z10);
        this.f20782s.loadUrl("javascript:isFoldedScreenExpand(\"" + z10 + "\")");
    }

    /* renamed from: K4 */
    public final void m27804K4(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            C13981a.m83988e("WapFindPhoneActivity", "openLocalDeviceSwitchResult loadUrl fail");
            return;
        }
        final int i10 = ((Bundle) obj).getInt(RouterEventReceiver.KEY_PARAMS);
        C13981a.m83989i("WapFindPhoneActivity", "openLocalDeviceSwitchResult loadUrl success, openResult: " + i10);
        this.f20782s.post(new Runnable() { // from class: jg.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f51709a.m27854p4(i10);
            }
        });
        new C12797b().m76785k(getApplicationContext(), "WapFindPhoneActivity", "0", "queryLocalCapabilityResult: " + i10, null, "openCurrentDeviceSwitch", null, "openCurrentDeviceSwitch", true, null);
    }

    /* renamed from: L3 */
    public final void m27805L3() {
        if (this.f20782s != null) {
            C13981a.m83989i("WapFindPhoneActivity", "checkMultiWindowModeChanged change:" + this.f20842w0);
            this.f20782s.loadUrl("javascript:onMultiWindowModeChanged(\"" + this.f20842w0 + "\")");
        }
    }

    /* renamed from: L4 */
    public final void m27806L4(Intent intent) {
        int statusCode;
        C13981a.m83989i("WapFindPhoneActivity", "process PICKER SDK login, accountAttr is system:" + this.f20807N);
        Task<AuthAccountPicker> authResultFromIntent = AccountPickerManager.parseAuthResultFromIntent(intent);
        if (authResultFromIntent.isSuccessful()) {
            statusCode = 0;
            this.f20820a0 = false;
            AuthAccountPicker result = authResultFromIntent.getResult();
            String authorizationCode = result.getAuthorizationCode();
            this.f20807N = result.getAccountAttr() == 0;
            this.f20819Z = authorizationCode;
            this.f20797A0 = System.currentTimeMillis();
            C13981a.m83989i("WapFindPhoneActivity", "retry accountAttr is system:" + this.f20807N);
            m27798H4();
        } else {
            this.f20820a0 = true;
            m27812O4();
            statusCode = ((ApiException) authResultFromIntent.getException()).getStatusCode();
            C13981a.m83988e("WapFindPhoneActivity", "retry sign in failed : " + statusCode);
        }
        int i10 = statusCode;
        new C12797b().m76782h(this, "WapFindPhoneActivity", String.valueOf(i10), i10, "master portal picker login result", "001_3017", null, null, "picker login", true);
    }

    /* renamed from: M3 */
    public final void m27807M3() {
        C13981a.m83989i("WapFindPhoneActivity", "checkSupperPrivacyMode");
        m27721G4(false);
        if (C11881n.m71342E(this)) {
            this.f20832m0 = true;
            m27774r5();
        } else {
            m27734Q3();
            m27800I4();
        }
    }

    /* renamed from: M4 */
    public final void m27808M4() {
        if (!this.f20831l0) {
            this.f20831l0 = true;
            return;
        }
        if (C11881n.m71342E(this)) {
            if (this.f20817X) {
                this.f20832m0 = false;
                m27774r5();
                return;
            }
            return;
        }
        AlertDialog alertDialog = this.f20830k0;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        m27734Q3();
        if (this.f20817X) {
            return;
        }
        m27800I4();
    }

    /* renamed from: N3 */
    public final void m27809N3() {
        C13981a.m83989i("WapFindPhoneActivity", "clear account cache");
        if (this.f20807N || TextUtils.isEmpty(this.f20819Z)) {
            return;
        }
        m27811O3();
    }

    /* renamed from: N4 */
    public final void m27810N4(Object obj) {
        if (obj instanceof String) {
            this.f20776E = ((String) obj) + m27823W3(this.f20807N);
        }
        C13981a.m83987d("WapFindPhoneActivity", "loading is:" + C11703j.m69807c(this.f20776E));
        m27860s5();
    }

    /* renamed from: O3 */
    public final void m27811O3() {
        C13981a.m83989i("WapFindPhoneActivity", "clear PICKER SDK third account cache");
        try {
            C10591e.m64990h(this, new InterfaceC10596j() { // from class: jg.x
                @Override // iq.InterfaceC10596j
                public final void onResult(InterfaceC10595i interfaceC10595i) {
                    WapFindPhoneActivity.m27762k4((C10588b) interfaceC10595i);
                }
            });
        } catch (C10593g e10) {
            C13981a.m83988e("WapFindPhoneActivity", "clear picker cache exception:" + e10.getMessage());
        }
    }

    /* renamed from: O4 */
    public final void m27812O4() {
        HandlerC4536g handlerC4536g = this.f20828i0;
        if (handlerC4536g != null) {
            handlerC4536g.obtainMessage(1001).sendToTarget();
        }
    }

    /* renamed from: P3 */
    public final void m27813P3(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            C13981a.m83988e("WapFindPhoneActivity", "createLongConnectionResult loadUrl fail");
            return;
        }
        final int i10 = ((Bundle) obj).getInt(RouterEventReceiver.KEY_PARAMS);
        final String string = ((Bundle) message.obj).getString("deviceId");
        if (907201121 == i10) {
            C13788m.m82779c().m82781b(string);
        }
        this.f20782s.post(new Runnable() { // from class: jg.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f51629a.m27848l4(string, i10);
            }
        });
        C12797b c12797b = new C12797b();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("perDeviceId", C9120m0.m57351R(string));
        c12797b.m76785k(getApplicationContext(), "WapFindPhoneActivity", "0", "createLongConnectionResult: " + i10, null, "01057", null, "finderTagLongConnection", true, linkedHashMap);
    }

    /* renamed from: Q4 */
    public final void m27814Q4(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            C13981a.m83988e("WapFindPhoneActivity", "queryLocalCapabilityResult loadUrl fail");
            return;
        }
        final String string = ((Bundle) obj).getString(RouterEventReceiver.KEY_PARAMS);
        C13981a.m83989i("WapFindPhoneActivity", "queryLocalCapabilityResult loadUrl success, capResult: " + string);
        this.f20782s.post(new Runnable() { // from class: jg.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f51711a.m27856q4(string);
            }
        });
        String str = C13168a.m79182k() ? FaqConstants.DISABLE_HA_REPORT : "false";
        C13981a.m83989i("WapFindPhoneActivity", "openCurrentDeviceSwitch openResult: " + str);
        this.f20782s.loadUrl("javascript:findTagBluetoothState(\"" + str + "\")");
        new C12797b().m76785k(getApplicationContext(), "WapFindPhoneActivity", "0", "queryLocalCapabilityResult: " + string, null, "finderQueryLocalCapability", null, "finderQueryLocalCapability", true, null);
    }

    /* renamed from: R3 */
    public final void m27815R3(Activity activity) {
        if (activity == null || !this.f20807N) {
            return;
        }
        C13981a.m83989i("WapFindPhoneActivity", "enterAccountCenter: system account");
        SafeIntent safeIntent = new SafeIntent(new Intent());
        safeIntent.setAction("com.huawei.hwid.ACTION_MAIN_SETTINGS");
        C0209d.m1302r2(safeIntent, "com.huawei.hwid");
        safeIntent.putExtra("showLogout", true);
        if (C0209d.m1205R0(activity.getPackageManager().queryIntentActivities(safeIntent, 0))) {
            return;
        }
        try {
            activity.startActivity(safeIntent);
        } catch (Exception unused) {
            C13981a.m83988e("WapFindPhoneActivity", "start HwId activity error");
        }
    }

    /* renamed from: R4 */
    public final boolean m27816R4() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z10 = jCurrentTimeMillis - f20794H0 <= 600;
        f20794H0 = jCurrentTimeMillis;
        return z10;
    }

    /* renamed from: S3 */
    public final void m27817S3(boolean z10) {
        C4531b c4531b = new C4531b(z10);
        this.f20820a0 = false;
        C13195l.m79272J().m79337u0(c4531b, false);
    }

    /* renamed from: S4 */
    public final void m27818S4() {
        try {
            this.f20782s.clearHistory();
            m27696g2("");
            this.f20817X = false;
            this.f20810Q = true;
            if (TextUtils.isEmpty(this.f20819Z) && !this.f20820a0) {
                C13981a.m83989i("WapFindPhoneActivity", "login fail, retry");
                String strM69790f = C11702i.m69790f();
                if (TextUtils.isEmpty(strM69790f)) {
                    strM69790f = this.f20776E;
                }
                m27838e5();
                m27819T4(strM69790f);
                m27721G4(false);
                m27827Z3();
                this.f20782s.loadUrl(strM69790f);
                return;
            }
            C13981a.m83989i("WapFindPhoneActivity", "picker login fail, retry");
            C11697d.m69760e().m69768l(false);
            m27721G4(false);
            m27827Z3();
            m27817S3(true);
        } catch (Exception e10) {
            C13981a.m83988e("WapFindPhoneActivity", "reLoginWapPortal exception:" + e10.getMessage());
        }
    }

    /* renamed from: T4 */
    public final void m27819T4(String str) {
        C11465a c11465a = new C11465a(C11466b.c.LOAD_START);
        c11465a.m68576g(str);
        c11465a.m68575f(System.currentTimeMillis());
        C11466b c11466b = this.f20823d0;
        if (c11466b != null) {
            c11466b.mo68581b(c11465a);
        }
    }

    /* renamed from: U4 */
    public final void m27820U4() {
        if (this.f20826g0 == null) {
            this.f20826g0 = new TagLocalFindReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.hidisk.remotecontrol.intent.TAG_LOCAL_COMMAND_RESULT");
            intentFilter.addAction("com.huawei.hidisk.remotecontrol.intent.TAG_FASTSCAN_RESULT");
            intentFilter.addAction("com.huawei.hidisk.remotecontrol.intent.TRUST_CIRCLE_RESULT");
            intentFilter.addAction("com.huawei.hidisk.remotecontrol.intent.REFRESH_PORTAL_LOGIN");
            C13108a.m78878b(this.f20804K).m78880c(this.f20826g0, intentFilter);
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.webview.BaseWebViewActivity
    /* renamed from: V1 */
    public void mo27685V1() {
        this.f20787x.setVisibility(8);
        m27702o2();
        if (!this.f20817X) {
            this.f20810Q = true;
        }
        String strM69790f = C11702i.m69790f();
        if (TextUtils.isEmpty(strM69790f)) {
            strM69790f = this.f20776E;
        }
        m27838e5();
        m27819T4(strM69790f);
        m27721G4(false);
        SafeWebView safeWebView = this.f20782s;
        if (safeWebView != null) {
            safeWebView.loadUrl(strM69790f);
        }
    }

    /* renamed from: V3 */
    public final String m27821V3() {
        return this.f20807N ? "01019" : !TextUtils.isEmpty(C13452e.m80781L().m80971t0()) ? "01018" : "01021";
    }

    /* renamed from: V4 */
    public void m27822V4() {
        C13981a.m83989i("WapFindPhoneActivity", "reloadPortal");
        m27721G4(false);
        m27825X3();
    }

    /* renamed from: W3 */
    public final String m27823W3(boolean z10) {
        String str;
        String str2;
        String str3;
        String str4;
        C13981a.m83989i("WapFindPhoneActivity", "getUrlParam, tabLocation : " + this.f20813T + ",system:" + z10);
        if (TextUtils.isEmpty(this.f20819Z) || !C0189b.m1071a().m1073c()) {
            if (z10) {
                int iM80947n0 = C13452e.m80781L().m80947n0();
                str = "?sysLogin=true&authType=at";
                if (iM80947n0 != 0) {
                    str = "?sysLogin=true&authType=at&siteID=" + iM80947n0;
                }
            } else if (C11842p.m70732H0(this)) {
                str = "?sysLogin=false&themeName=dark";
            } else {
                str = "?sysLogin=false&themeName=huawei";
            }
            str2 = str + "&relogin=true";
            if (!TextUtils.isEmpty(this.f20819Z)) {
                str2 = str2 + "&authCode=" + m27871x5(this.f20819Z);
            }
            C13981a.m83989i("WapFindPhoneActivity", "need reLogin");
        } else if (z10) {
            str2 = "?loginVersion=v2";
        } else {
            if (C11842p.m70732H0(this)) {
                str4 = "?sysLogin=false&themeName=dark";
            } else {
                str4 = "?sysLogin=false&themeName=huawei";
            }
            C13981a.m83989i("WapFindPhoneActivity", "need reLogin");
            str2 = str4 + "&relogin=true";
            if (!TextUtils.isEmpty(this.f20819Z)) {
                str2 = str2 + "&authCode=" + m27871x5(this.f20819Z);
            }
        }
        if (z10) {
            if (this.f20808O) {
                str2 = str2 + "&tab=share";
                this.f20808O = false;
                C13981a.m83989i("WapFindPhoneActivity", "need jump to share page");
            } else if (this.f20809P) {
                int i10 = this.f20813T;
                if (i10 == 0 || i10 == 1) {
                    str2 = str2 + "&tab=trackedTag";
                    C13981a.m83989i("WapFindPhoneActivity", "need jump to tracked tags page");
                } else if (i10 == 2) {
                    str2 = str2 + "&tab=trackedTws";
                    C13981a.m83989i("WapFindPhoneActivity", "need jump to tracked tws page");
                }
                this.f20809P = false;
                C9120m0.m57380d1(this.f20804K, "mecloud_findmyphone_click_tag_tracked_notification", "", "", 0);
            } else if (this.f20811R) {
                int i11 = this.f20813T;
                if (i11 == 0 || i11 == 1) {
                    str3 = str2 + "&extendParams=" + C11703j.m69827w(C11703j.m69808d(2, 1, this.f20833n0));
                    C13981a.m83989i("WapFindPhoneActivity", "need jump to goods detail");
                } else if (i11 != 2) {
                    str3 = str2 + "&extendParams=" + C11703j.m69827w(C11703j.m69809e(2, this.f20833n0));
                } else {
                    str3 = str2 + "&extendParams=" + C11703j.m69827w(C11703j.m69808d(2, 2, this.f20833n0));
                    C13981a.m83989i("WapFindPhoneActivity", "need jump to tws detail");
                }
                str2 = str3;
                this.f20811R = false;
                C9120m0.m57380d1(this.f20804K, "mecloud_findmyphone_click_find_lost_notification", this.f20833n0, "", 0);
            } else if (this.f20812S) {
                int i12 = this.f20813T;
                if (i12 == 0 || i12 == 1) {
                    str2 = str2 + "&extendParams=" + C11703j.m69827w(C11703j.m69808d(1, 1, null));
                    C13981a.m83989i("WapFindPhoneActivity", "need jump to goods detail(disconnect)");
                } else if (i12 == 2) {
                    str2 = str2 + "&extendParams=" + C11703j.m69827w(C11703j.m69808d(1, 2, null));
                    C13981a.m83989i("WapFindPhoneActivity", "need jump to goods detail(tws disconnect)");
                }
                this.f20812S = false;
                C9120m0.m57380d1(this.f20804K, "mecloud_findmyphone_click_disconnect_notification", this.f20834o0, "", 0);
            } else if (NotifyConstants.TYPE_DEEPLINK.equals(this.f20818Y) && Boolean.TRUE.equals(this.f20800D0.get(this.f20836q0))) {
                str2 = str2 + "&tab=" + this.f20836q0;
                C13981a.m83989i("WapFindPhoneActivity", "need jump to " + this.f20836q0 + " detail");
            }
        }
        return str2 + "&timestamp=" + System.currentTimeMillis();
    }

    /* renamed from: W4 */
    public final void m27824W4() {
        if (this.f20814U && !this.f20807N && C11702i.m69793i(this)) {
            C13981a.m83989i("WapFindPhoneActivity", "remove reLogin");
            this.f20776E = C11702i.m69798n(this.f20776E);
        }
        this.f20814U = false;
    }

    @Override // com.huawei.android.remotecontrol.p093ui.webview.BaseWebViewActivity
    /* renamed from: X1 */
    public void mo27687X1() {
        super.mo27687X1();
        this.f20828i0 = new HandlerC4536g(this);
    }

    /* renamed from: X3 */
    public final void m27825X3() {
        C13981a.m83989i("WapFindPhoneActivity", "get WapFindPhone url");
        C12515a.m75110o().m75175e(new C11704k(this.f20828i0, this.f20807N && !TextUtils.isEmpty(this.f20819Z) && C0189b.m1071a().m1073c()), false);
    }

    @Override // com.huawei.android.remotecontrol.p093ui.webview.BaseWebViewActivity
    /* renamed from: Y1 */
    public void mo27688Y1() {
        C13981a.m83989i("WapFindPhoneActivity", "initParams");
        super.mo27688Y1();
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f20818Y = safeIntent.getStringExtra(RemoteMessageConst.FROM);
        this.f20816W = safeIntent.getBooleanExtra("isFromInner", false);
        this.f20819Z = safeIntent.getStringExtra("authCode");
        this.f20797A0 = System.currentTimeMillis();
        this.f20807N = safeIntent.getBooleanExtra("isSystemAcc", false);
        this.f20810Q = safeIntent.getBooleanExtra("needShowLoading", true);
        this.f20809P = safeIntent.getBooleanExtra("isTrackedTag", false);
        this.f20808O = safeIntent.getBooleanExtra("isAddShare", false);
        this.f20813T = safeIntent.getIntExtra("tabLocation", 0);
        boolean booleanExtra = safeIntent.getBooleanExtra("FIND_LOST_NOTIFICATION", false);
        this.f20811R = booleanExtra;
        if (booleanExtra) {
            this.f20833n0 = safeIntent.getStringExtra("deviceId");
        }
        boolean booleanExtra2 = safeIntent.getBooleanExtra("DISCONNECT_NOTIFICATION", false);
        this.f20812S = booleanExtra2;
        if (booleanExtra2) {
            this.f20834o0 = safeIntent.getStringExtra("deviceId");
        }
        this.f20836q0 = safeIntent.getStringExtra("tab");
        m27850m5(true);
        m27842g5();
    }

    /* renamed from: Y4 */
    public final void m27826Y4(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            C13981a.m83988e("WapFindPhoneActivity", "reportCapabilities loadUrl fail");
            return;
        }
        final String string = ((Bundle) obj).getString(RouterEventReceiver.KEY_PARAMS);
        this.f20782s.post(new Runnable() { // from class: jg.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f51658a.m27858r4(string);
            }
        });
        C13981a.m83989i("WapFindPhoneActivity", "reportCapabilities loadUrl success");
    }

    @Override // com.huawei.android.remotecontrol.p093ui.webview.BaseWebViewActivity
    /* renamed from: Z1 */
    public void mo27689Z1() {
        super.mo27689Z1();
        m27833c4();
        this.f20783t.setVisibility(8);
        this.f20806M = (TextView) C12809f.m76829b(this, R$id.loading_view_text);
        HwButton hwButton = this.f20785v;
        if (hwButton != null) {
            hwButton.setOnClickListener(new View.OnClickListener() { // from class: jg.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f51663a.m27765m4(view);
                }
            });
        }
        View view = this.f20788y;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: jg.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f51668a.m27767n4(view2);
                }
            });
        }
        this.f20837r0 = C11842p.m70750N0() || C11842p.m70735I0();
    }

    /* renamed from: Z3 */
    public final void m27827Z3() {
        C13981a.m83989i("WapFindPhoneActivity", "hide error");
        View view = this.f20788y;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* renamed from: Z4 */
    public final void m27828Z4(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            C13981a.m83988e("WapFindPhoneActivity", "reportDeviceCapabilities loadUrl fail");
            return;
        }
        final String string = ((Bundle) obj).getString(RouterEventReceiver.KEY_PARAMS);
        this.f20782s.post(new Runnable() { // from class: jg.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f51640a.m27859s4(string);
            }
        });
        C13981a.m83989i("WapFindPhoneActivity", "reportDeviceCapabilities loadUrl success");
    }

    /* renamed from: a4 */
    public final void m27829a4() {
        View view = this.f20781r;
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, 0);
            this.f20781r.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: a5 */
    public final void m27830a5(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            C13981a.m83988e("WapFindPhoneActivity", "reportFastDiscoveryResul loadUrl fail");
            return;
        }
        final int i10 = ((Bundle) obj).getInt("exeResult");
        final String string = ((Bundle) message.obj).getString("tagSn");
        this.f20782s.post(new Runnable() { // from class: jg.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f51645a.m27861t4(i10, string);
            }
        });
        C13981a.m83989i("WapFindPhoneActivity", "reportFastDiscoveryResul loadUrl success");
    }

    /* renamed from: b4 */
    public final void m27831b4(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (!this.f20807N) {
            C13981a.m83989i("WapFindPhoneActivity", "from page restore");
            this.f20814U = bundle.getBoolean("key_from_page_restore");
        }
        if (TextUtils.isEmpty(this.f20819Z)) {
            return;
        }
        C13981a.m83989i("WapFindPhoneActivity", "from picker restore");
        this.f20815V = bundle.getBoolean("key_from_page_restore_picker", true);
    }

    /* renamed from: b5 */
    public final void m27832b5(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            C13981a.m83988e("WapFindPhoneActivity", "reportMainOfflineLocation loadUrl fail");
            return;
        }
        final String string = ((Bundle) obj).getString(RouterEventReceiver.KEY_PARAMS);
        this.f20782s.post(new Runnable() { // from class: jg.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f51722a.m27863u4(string);
            }
        });
        C13981a.m83989i("WapFindPhoneActivity", "reportMainOfflineLocation loadUrl success");
    }

    /* renamed from: c4 */
    public final void m27833c4() {
        Window window = getWindow();
        if (window != null) {
            C13981a.m83989i("WapFindPhoneActivity", "initViewBackground");
            window.addFlags(Integer.MIN_VALUE);
            int i10 = R$color.hicloud_hmos_bg;
            window.setStatusBarColor(getColor(i10));
            window.setNavigationBarColor(getColor(i10));
            window.getDecorView().setBackgroundResource(i10);
        }
    }

    /* renamed from: c5 */
    public final void m27834c5(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            C13981a.m83988e("WapFindPhoneActivity", "reportStartRingOffline loadUrl fail");
            return;
        }
        final int i10 = ((Bundle) obj).getInt(RouterEventReceiver.KEY_PARAMS);
        this.f20782s.post(new Runnable() { // from class: jg.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f51655a.m27866v4(i10);
            }
        });
        C13981a.m83989i("WapFindPhoneActivity", "reportStartRingOffline loadUrl success");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f20781r);
        return arrayList;
    }

    /* renamed from: d4 */
    public final void m27835d4() {
        Window window = getWindow();
        if (window != null) {
            try {
                C13981a.m83989i("WapFindPhoneActivity", "initViewBackgroundDark");
                window.addFlags(Integer.MIN_VALUE);
                int i10 = R$color.cus_dark;
                window.setStatusBarColor(getColor(i10));
                window.setNavigationBarColor(getColor(i10));
                window.getDecorView().setBackgroundResource(i10);
                window.getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() & (-8209));
            } catch (Exception e10) {
                C13981a.m83988e("WapFindPhoneActivity", "initViewBackgroundDark error:" + e10.getMessage());
            }
        }
    }

    /* renamed from: d5 */
    public final void m27836d5(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            C13981a.m83988e("WapFindPhoneActivity", "reportStopRingOffline loadUrl fail");
            return;
        }
        final int i10 = ((Bundle) obj).getInt(RouterEventReceiver.KEY_PARAMS);
        this.f20782s.post(new Runnable() { // from class: jg.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f51673a.m27868w4(i10);
            }
        });
        C13981a.m83989i("WapFindPhoneActivity", "reportStopRingOffline loadUrl success");
    }

    /* renamed from: e4 */
    public final void m27837e4() {
        Window window = getWindow();
        if (window != null) {
            try {
                C13981a.m83989i("WapFindPhoneActivity", "initViewBackgroundLight");
                window.addFlags(Integer.MIN_VALUE);
                int i10 = R$color.cus_light;
                window.setStatusBarColor(getColor(i10));
                window.setNavigationBarColor(getColor(i10));
                window.getDecorView().setBackgroundResource(i10);
                window.getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 8208);
            } catch (Exception e10) {
                C13981a.m83988e("WapFindPhoneActivity", "initViewBackgroundLight error:" + e10.getMessage());
            }
        }
    }

    /* renamed from: e5 */
    public final void m27838e5() {
        C11052c c11052c = this.f20822c0;
        if (c11052c != null) {
            c11052c.m66618k();
        }
    }

    /* renamed from: f4 */
    public final boolean m27839f4() {
        SafeWebView safeWebView;
        return (this.f20807N || (safeWebView = this.f20782s) == null || safeWebView.getUrl() == null || !this.f20782s.getUrl().equals(this.f20776E)) ? false : true;
    }

    /* renamed from: f5 */
    public final void m27840f5() {
        final int iM26383a = C4366a.m26382b().m26383a();
        C13981a.m83989i("WapFindPhoneActivity", "sendTrustCircleResult: " + iM26383a);
        try {
            SafeWebView safeWebView = this.f20782s;
            if (safeWebView != null) {
                safeWebView.post(new Runnable() { // from class: jg.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f51719a.m27870x4(iM26383a);
                    }
                });
            }
        } catch (Exception unused) {
            C13981a.m83988e("WapFindPhoneActivity", "sendTrustCircleResult error");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void finish() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("WapFindPhoneActivity", "finish");
        super.finish();
        this.f20841v0 = false;
        new HwAnimationReflection(this).m15927c(2);
    }

    /* renamed from: g4 */
    public final boolean m27841g4() {
        return System.currentTimeMillis() - C11877j.m71313w(getApplicationContext()) > 172800000;
    }

    /* renamed from: g5 */
    public final void m27842g5() {
        C12515a.m75110o().m75175e(new C4532c(), true);
    }

    /* renamed from: h4 */
    public boolean m27843h4() {
        return this.f20807N;
    }

    /* renamed from: i4 */
    public final void m27844i4(boolean z10) {
        C13981a.m83989i("WapFindPhoneActivity", "picker Sdk Login");
        this.f20820a0 = false;
        if (z10 && C11697d.m69760e().m69762f()) {
            C13981a.m83990w("WapFindPhoneActivity", "picker Sdk is Signing in");
            C11697d.m69760e().m69768l(false);
            return;
        }
        if (!C0209d.m1333z1(this)) {
            C13981a.m83988e("WapFindPhoneActivity", "picker Login, net is not connected");
            C11697d.m69760e().m69768l(false);
            m27806L4(null);
        } else if (C11697d.m69760e().m69766j(this, this.f20807N)) {
            if (z10) {
                C11697d.m69760e().m69768l(true);
            }
        } else {
            C13981a.m83988e("WapFindPhoneActivity", "picker Login failed");
            C11697d.m69760e().m69768l(false);
            m27806L4(null);
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.webview.BaseWebViewActivity
    /* renamed from: j2 */
    public void mo27697j2(boolean z10) {
        super.mo27697j2(z10);
        WebSettings settings = this.f20782s.getSettings();
        if (settings == null) {
            C13981a.m83988e("WapFindPhoneActivity", "WebSettings is null.");
            return;
        }
        if ("com.huawei.android.findmyphone".equals(this.f20818Y)) {
            settings.setUserAgentString(C11701h.m69780b(settings.getUserAgentString(), this));
        } else {
            settings.setUserAgentString(C11701h.m69779a(settings.getUserAgentString(), this));
        }
        C13981a.m83987d("WapFindPhoneActivity", "userAgent is :" + settings.getUserAgentString());
        settings.setDomStorageEnabled(true);
        settings.setTextZoom(100);
        settings.setCacheMode(-1);
        settings.setGeolocationEnabled(true);
        this.f20823d0 = new C11466b(new C11465a(C11466b.c.LOAD_START, this.f20776E, this.f20807N, null, System.currentTimeMillis()), this, this.f20828i0);
        C11052c c11052c = new C11052c(this, this.f20807N, this.f20818Y);
        this.f20822c0 = c11052c;
        C11466b c11466b = this.f20823d0;
        if (c11466b != null) {
            c11052c.m66617j(c11466b);
        }
        this.f20782s.setBackgroundColor(0);
        this.f20782s.m53596e(this.f20822c0, false);
        if (z10) {
            this.f20782s.addJavascriptInterface(new C4534e(), "PhoneFinderWapExternal");
        }
        this.f20782s.setWebChromeClient(new WebWapChromeClient(this));
    }

    /* renamed from: j4 */
    public final /* synthetic */ void m27845j4(String str) {
        this.f20782s.loadUrl("javascript:responseBatchOfflineLocation(\"" + str + "\")");
    }

    /* renamed from: k5 */
    public final void m27846k5() {
        try {
            int iM80947n0 = C13452e.m80781L().m80947n0();
            C13981a.m83989i("WapFindPhoneActivity", "set web site:" + iM80947n0);
            CookieManager.getInstance().setCookie(this.f20776E, "siteID=" + iM80947n0, new ValueCallback() { // from class: jg.o
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    WapFindPhoneActivity.m27789y4((Boolean) obj);
                }
            });
        } catch (Exception e10) {
            C13981a.m83988e("WapFindPhoneActivity", "set web siteId error:" + e10.getMessage());
        }
    }

    @Override // kg.InterfaceC11053d
    /* renamed from: l */
    public void mo27847l(WebView webView, String str) {
        String url = webView.getUrl();
        C13981a.m83987d("WapFindPhoneActivity", "onReceivedTitle url is " + C11703j.m69807c(url));
        if (this.f20807N || TextUtils.isEmpty(url) || url.equals(str)) {
            return;
        }
        m27703p2(C11703j.m69823s(url, str));
    }

    /* renamed from: l4 */
    public final /* synthetic */ void m27848l4(String str, int i10) {
        this.f20782s.loadUrl("javascript:createLongConnectionResult(\"" + str + "\"," + i10 + ")");
    }

    /* renamed from: l5 */
    public void m27849l5(String str) {
        if (this.f20807N || C11702i.m69793i(this) || this.f20788y.getVisibility() == 0) {
            return;
        }
        m27696g2(str);
    }

    /* renamed from: m5 */
    public final void m27850m5(boolean z10) {
        if (this.f20807N) {
            return;
        }
        C13981a.m83989i("WapFindPhoneActivity", "setWindowScreenShotFlag isLoadStart=" + z10);
        C11703j.m69826v(getWindow(), z10);
        C11703j.m69805a(this, z10);
    }

    /* renamed from: n5 */
    public void m27851n5(Message message) {
        C13981a.m83989i("WapFindPhoneActivity", "showErrorPage");
        Object obj = message.obj;
        if (obj instanceof Boolean) {
            this.f20810Q = false;
            if (((Boolean) obj).booleanValue()) {
                C13981a.m83989i("WapFindPhoneActivity", "stop loading");
                this.f20782s.stopLoading();
            }
        }
        this.f20782s.setVisibility(8);
        this.f20789z.setVisibility(8);
        this.f20788y.setVisibility(0);
        m27696g2("");
    }

    /* renamed from: o4 */
    public final /* synthetic */ void m27852o4(String str, String str2) {
        this.f20782s.loadUrl("javascript:responseTagOfflineLocation(\"" + str + "\",\"" + str2 + "\")");
    }

    /* renamed from: o5 */
    public final void m27853o5() {
        C13981a.m83989i("WapFindPhoneActivity", "showOfflineLocateDialog");
        if (C0209d.m1277l1()) {
            return;
        }
        m27855p5(new DialogInterface.OnClickListener() { // from class: jg.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f51677a.m27872z4(dialogInterface, i10);
            }
        }, new DialogInterface.OnCancelListener() { // from class: jg.p
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f51685a.m27792A4(dialogInterface);
            }
        });
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws JsonIOException {
        C13981a.m83989i("WapFindPhoneActivity", "onActivityResult, requestCode: " + i10);
        if (i10 == 1) {
            C13981a.m83989i("WapFindPhoneActivity", "onActivityResult: callback");
        }
        if (i10 == 5) {
            C13981a.m83989i("WapFindPhoneActivity", "onActivityResult:startNavigation, resultCode:" + i11);
            m27802J4("startNavigation", new SafeIntent(intent).getStringExtra("tagSn"), i11);
        }
        if (i10 == 8) {
            C13981a.m83989i("WapFindPhoneActivity", "onActivityResult:startNearLinkNavigation, resultCode:" + i11);
            this.f20841v0 = false;
            new SafeIntent(intent).getStringExtra("tagSn");
            this.f20782s.loadUrl("javascript:stopNearLinkNavigationResult('')");
            if (i11 == 907201157) {
                C11880m.m71337d(this.f20804K, getString(R$string.device_finding));
            }
        }
        if (i10 == 6) {
            C13981a.m83989i("WapFindPhoneActivity", "onActivityResult:startBluetoothNavigation, resultCode:" + i11);
            m27802J4("startBluetoothNavigation", new SafeIntent(intent).getStringExtra("tagSn"), i11);
        }
        if (i10 == 8911) {
            C11697d.m69760e().m69768l(false);
            m27806L4(intent);
        }
        if (i10 == 7) {
            C13981a.m83989i("WapFindPhoneActivity", "onActivityResult:startActivateLock, resultCode:" + i11);
            SafeWebView safeWebView = this.f20782s;
            if (safeWebView != null) {
                safeWebView.loadUrl("javascript:onLoackActivated()");
            }
        }
        if (i10 == 4) {
            C13981a.m83989i("WapFindPhoneActivity", "onActivityResult:startLockScreen, resultCode:" + i11);
            boolean zM1301r1 = C0209d.m1301r1(this.f20804K);
            C13981a.m83987d("WapFindPhoneActivity", "isLock:" + C0209d.m1301r1(this.f20804K));
            C13230i.m79504I().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", "WapFindPhoneActivity", "isLock:" + zM1301r1);
            if (zM1301r1) {
                C11860j.m71058h1(1, null);
            } else {
                C13981a.m83990w("WapFindPhoneActivity", "onActivityResult:startLockScreen, not lock");
            }
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.webview.BaseWebViewActivity, android.app.Activity
    public void onBackPressed() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("WapFindPhoneActivity", "onBackPressed");
        if (this.f20787x.getVisibility() == 0 || this.f20788y.getVisibility() == 0) {
            this.f20789z.setVisibility(8);
            this.f20782s.setVisibility(8);
            C13981a.m83989i("WapFindPhoneActivity", "onBackPressed: errorPageView visible");
            finish();
            return;
        }
        C11052c c11052c = this.f20822c0;
        if (c11052c != null && c11052c.m66613f()) {
            C13981a.m83989i("WapFindPhoneActivity", "onBackPressed: toHomeScreen");
            m27864u5();
        } else if (m27839f4()) {
            C13981a.m83989i("WapFindPhoneActivity", "onBackPressed: is login page");
            finish();
        } else {
            super.onBackPressed();
            C13981a.m83989i("WapFindPhoneActivity", "onBackPressed finish");
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.webview.BaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AlertDialog alertDialog;
        super.onConfigurationChanged(configuration);
        this.f20842w0 = isInMultiWindowMode();
        m27829a4();
        m27803K3();
        m27805L3();
        boolean zM70732H0 = C11842p.m70732H0(this);
        m27869w5(zM70732H0);
        if (this.f20843x0 != zM70732H0 && !this.f20807N && !C11702i.m69793i(this)) {
            finish();
        }
        C13981a.m83989i("WapFindPhoneActivity", "onConfigurationChanged isDarkMode:" + this.f20843x0 + " isDarkM:" + zM70732H0);
        if (this.f20843x0 != zM70732H0 && (alertDialog = this.f20829j0) != null && alertDialog.isShowing()) {
            this.f20829j0.dismiss();
            this.f20829j0 = null;
            C0226l0.m1584d(new Runnable() { // from class: jg.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f51651a.m27853o5();
                }
            });
        }
        this.f20843x0 = zM70732H0;
    }

    @Override // com.huawei.android.remotecontrol.p093ui.webview.BaseWebViewActivity, com.huawei.android.remotecontrol.p093ui.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11868a.m71128d().m71130b(WapFindPhoneActivity.class);
        super.onCreate(bundle);
        C13981a.m83989i("WapFindPhoneActivity", "onCreate");
        C9097b.m57310t(this);
        this.f20804K = this;
        this.f20805L = new NewHiSyncUtil(this);
        m27696g2("");
        if (!m27799I3()) {
            C13981a.m83989i("WapFindPhoneActivity", "check permission false, finish");
            finish();
            return;
        }
        mo27687X1();
        m27801J3();
        try {
            mo27689Z1();
            mo19005p1();
            mo27688Y1();
            m27744X4();
            m27831b4(bundle);
            m27807M3();
            FeedbackSdkProcessor.getInstance(this, new C11018a()).jumpToSdkView(this, 0, false);
            C13788m.m82779c().m82780a();
            this.f20844y0 = C4347e.m26236g();
            if (this.f20824e0 == null) {
                this.f20824e0 = new PhoneFinderReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT");
                intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_DEVICE_DEL");
                C13108a.m78878b(this.f20804K).m78880c(this.f20824e0, intentFilter);
            }
            this.f20843x0 = C11842p.m70732H0(this);
        } catch (RuntimeException e10) {
            C13981a.m83988e("WapFindPhoneActivity", "can not find webView:" + e10.getMessage());
            finish();
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.webview.BaseWebViewActivity, com.huawei.android.remotecontrol.p093ui.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() throws JSONException {
        C13981a.m83989i("WapFindPhoneActivity", "onDestroy");
        C11466b c11466b = this.f20823d0;
        if (c11466b != null) {
            c11466b.m68583g();
        }
        PhoneFinderReceiver phoneFinderReceiver = this.f20824e0;
        if (phoneFinderReceiver != null) {
            try {
                unregisterReceiver(phoneFinderReceiver);
                this.f20824e0 = null;
            } catch (Exception unused) {
                C13981a.m83988e("WapFindPhoneActivity", "mPhoneFinderReceiver unregister error");
            }
        }
        BluetoothStatueReceiver bluetoothStatueReceiver = this.f20825f0;
        if (bluetoothStatueReceiver != null) {
            try {
                unregisterReceiver(bluetoothStatueReceiver);
                this.f20825f0 = null;
            } catch (Exception unused2) {
                C13981a.m83988e("WapFindPhoneActivity", "mBluetoothReceiver unregister error");
            }
        }
        String str = this.f20835p0;
        if (str != null) {
            C11690w.m69735p0(this.f20804K, str);
        }
        m27867v5();
        C11702i.m69804t("");
        C11702i.m69800p("");
        C11702i.m69803s("");
        AlertDialog alertDialog = this.f20829j0;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f20829j0 = null;
        }
        AlertDialog alertDialog2 = this.f20802F0;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
            this.f20802F0 = null;
        }
        NewHiSyncUtil newHiSyncUtil = this.f20805L;
        if (newHiSyncUtil != null) {
            newHiSyncUtil.m27970a();
            this.f20805L = null;
        }
        C11052c c11052c = this.f20822c0;
        if (c11052c != null) {
            c11052c.m66610c();
        }
        FeedbackSdkProcessor.getInstance(this, new C11018a()).jumpToSdkView(this, 0, true);
        C11703j.m69826v(getWindow(), false);
        m27734Q3();
        C13981a.m83989i("WapFindPhoneActivity", "onDestroy, callFrom: " + this.f20818Y);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(RemoteMessageConst.FROM, this.f20818Y);
            C9120m0.m57389g1(this.f20804K, RemoteMessageConst.FROM, "", jSONObject, 0);
        } catch (JSONException unused3) {
            C13981a.m83988e("WapFindPhoneActivity", "onDestroy, callFrom report fail, jsonException");
        }
        super.onDestroy();
        C11697d.m69760e().m69768l(false);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10, Configuration configuration) {
        super.onMultiWindowModeChanged(z10, configuration);
        if (this.f20782s != null) {
            this.f20842w0 = z10;
            C13981a.m83989i("WapFindPhoneActivity", "onMultiWindowModeChanged notify:" + z10);
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.webview.BaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (menuItem.getItemId() == 16908332) {
            if (this.f20787x.getVisibility() == 0 || this.f20788y.getVisibility() == 0) {
                this.f20789z.setVisibility(8);
                this.f20782s.setVisibility(8);
                finish();
                return true;
            }
            if (m27839f4()) {
                C13981a.m83989i("WapFindPhoneActivity", "onBackPressed: is login page");
                finish();
                return true;
            }
            SafeWebView safeWebView = this.f20782s;
            if (safeWebView != null && safeWebView.canGoBack()) {
                this.f20782s.goBack();
                return true;
            }
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        C13981a.m83989i("WapFindPhoneActivity", "onPause");
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (iArr.length < 1) {
            C13981a.m83988e("WapFindPhoneActivity", "request storage permissions error");
            return;
        }
        if (i10 == 3) {
            if (strArr[0].equals("android.permission.CALL_PHONE") && iArr[0] != 0) {
                if (shouldShowRequestPermissionRationale(strArr[0])) {
                    return;
                }
                C13981a.m83989i("WapFindPhoneActivity", "user choose reject and not notice");
                m27700m2(R$string.permission_callphone_ask, R$string.call_phone_permission_explain, false);
                return;
            }
            m27723H3(this.f20821b0);
        }
        if (i10 == 4) {
            if (!m27684U1("android.permission.ACCESS_FINE_LOCATION")) {
                C13981a.m83989i("WapFindPhoneActivity", "location permission not granted");
            }
            C11877j.m71210H(getApplicationContext(), System.currentTimeMillis());
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.webview.BaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C13981a.m83989i("WapFindPhoneActivity", "onResume");
        SafeWebView safeWebView = this.f20782s;
        if (safeWebView != null) {
            safeWebView.onResume();
        }
        if (this.f20787x.getVisibility() == 0 && C0209d.m1333z1(this)) {
            C13981a.m83989i("WapFindPhoneActivity", "network is connected but net error view show,so hide it and reload");
            this.f20787x.setVisibility(8);
            this.f20782s.reload();
        }
        m27808M4();
        if (!"com.huawei.android.findmyphone".equals(this.f20818Y)) {
            m27732P4();
        }
        if (TextUtils.isEmpty(this.f20835p0) || !C13442i.m80758j().m80765k()) {
            return;
        }
        C13981a.m83989i("WapFindPhoneActivity", "onResume queryDeviceDetail");
        C11690w.m69709c0(this.f20804K, this.f20835p0, this.f20828i0);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!this.f20807N) {
            C13981a.m83989i("WapFindPhoneActivity", "onSaveInstanceState");
            bundle.putBoolean("key_from_page_restore", true);
        }
        if (TextUtils.isEmpty(this.f20819Z)) {
            return;
        }
        bundle.putBoolean("key_from_page_restore_picker", true);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        C13981a.m83989i("WapFindPhoneActivity", "onStart");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        C13981a.m83989i("WapFindPhoneActivity", "onStop");
        if (this.f20782s != null) {
            C13981a.m83989i("WapFindPhoneActivity", "mWebView onPause");
            this.f20782s.onPause();
        }
    }

    /* renamed from: p4 */
    public final /* synthetic */ void m27854p4(int i10) {
        this.f20782s.loadUrl("javascript:openLocalDeviceSwitchResult(\"" + i10 + "\")");
    }

    /* renamed from: p5 */
    public void m27855p5(DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialog = this.f20829j0;
        if (alertDialog != null && alertDialog.isShowing()) {
            C13981a.m83989i("WapFindPhoneActivity", "join circle dialog is showing");
            return;
        }
        C13981a.m83989i("WapFindPhoneActivity", "show join circle dialog");
        try {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(getString(R$string.text_offline_trust_dialog_title)).setMessage(getString(R$string.trust_circle_dialog_comtent)).setPositiveButton(getString(R$string.text_pf_offline_dialog_positive), onClickListener).setNegativeButton(getString(R$string.cancel), onClickListener).setOnCancelListener(onCancelListener).create();
            this.f20829j0 = alertDialogCreate;
            alertDialogCreate.setCanceledOnTouchOutside(false);
            this.f20829j0.show();
        } catch (Exception e10) {
            C13981a.m83988e("WapFindPhoneActivity", "showOpenExceptionDialog exception:" + e10.getMessage());
        }
    }

    /* renamed from: q4 */
    public final /* synthetic */ void m27856q4(String str) {
        this.f20782s.loadUrl("javascript:queryLocalCapabilityResult(\"" + str + "\")");
    }

    /* renamed from: q5 */
    public void m27857q5() throws Resources.NotFoundException {
        String string = getResources().getString(R$string.phonefinder_title_lockscreen_password);
        String string2 = getResources().getString(R$string.phonefinder_content_set_lockscreen_update);
        if (this.f20805L == null) {
            C13981a.m83988e("WapFindPhoneActivity", "newHiSyncActivityUtil is null");
        } else {
            C13230i.m79504I().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", "WapFindPhoneActivity", "showDialog");
            this.f20805L.m27971b(this, string, string2, getResources().getString(R$string.phonefinder_set_lockscreen_now), getResources().getString(R$string.phonefinder_set_lockscreen_later), new C4530a());
        }
    }

    /* renamed from: r4 */
    public final /* synthetic */ void m27858r4(String str) {
        this.f20782s.loadUrl("javascript:getItemCapabilities(\"" + str + "\")");
    }

    /* renamed from: s4 */
    public final /* synthetic */ void m27859s4(String str) {
        this.f20782s.loadUrl("javascript:queryCapabilityResult(\"" + str + "\")");
    }

    /* renamed from: s5 */
    public void m27860s5() {
        C13981a.m83989i("WapFindPhoneActivity", "showWebView");
        m27696g2("");
        mo27697j2(this.f20778G);
        if (!C0209d.m1333z1(this)) {
            C13981a.m83988e("WapFindPhoneActivity", "net is not connected");
            m27699l2();
            return;
        }
        if (!m27683T1(this.f20776E)) {
            C13981a.m83988e("WapFindPhoneActivity", "url is invalid");
            m27698k2();
            return;
        }
        m27721G4(false);
        m27824W4();
        m27838e5();
        m27819T4(this.f20776E);
        if (this.f20776E.contains("?loginVersion=v2")) {
            m27846k5();
        }
        SafeWebView safeWebView = this.f20782s;
        if (safeWebView != null) {
            safeWebView.loadUrl(this.f20776E);
        }
    }

    /* renamed from: t4 */
    public final /* synthetic */ void m27861t4(int i10, String str) {
        this.f20782s.loadUrl("javascript:startFastDiscoveryResult(\"" + i10 + "\",\"" + str + "\")");
    }

    /* renamed from: t5 */
    public final void m27862t5() {
        new PhoneFinderTrustCircleManager(this.f20804K).joinTrustCircle(new Consumer() { // from class: jg.q
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f51689a.m27795E4((TrustCircleInfo) obj);
            }
        });
        C11690w.m69700W("", "trustCircleOperation", "trustCircleBusiness", "showOfflineLocateDialog click join", "0", null);
    }

    /* renamed from: u4 */
    public final /* synthetic */ void m27863u4(String str) {
        this.f20782s.loadUrl("javascript:batchDeviceUnwrapLocationResult(" + str + ")");
    }

    /* renamed from: u5 */
    public final void m27864u5() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f20827h0 >= RippleView.SINGLE_RIPPLE_TIME) {
            this.f20827h0 = jCurrentTimeMillis;
            m27701n2(getString(R$string.quit_confirm_logout), 0);
        } else {
            this.f20827h0 = 0L;
            C13981a.m83989i("WapFindPhoneActivity", "toHomeScreen");
            C11702i.m69785a();
            finish();
        }
    }

    @Override // kg.InterfaceC11053d
    /* renamed from: v */
    public void mo27865v(String str, GeolocationPermissions.Callback callback) {
        C13981a.m83989i("WapFindPhoneActivity", "onGeolocationPermissionsShowPrompt:" + C11703j.m69807c(str));
        if (m27684U1(C11275a.m67670c())) {
            callback.invoke(str, true, true);
        } else {
            C13981a.m83989i("WapFindPhoneActivity", "user does not agree location permission");
            callback.invoke(str, false, false);
        }
    }

    /* renamed from: v4 */
    public final /* synthetic */ void m27866v4(int i10) {
        this.f20782s.loadUrl("javascript:startRingOfflineResult(\"" + i10 + "\")");
    }

    /* renamed from: v5 */
    public final void m27867v5() {
        if (this.f20826g0 != null) {
            try {
                C13108a.m78878b(this.f20804K).m78883f(this.f20826g0);
                this.f20826g0 = null;
            } catch (Exception unused) {
                C13981a.m83988e("WapFindPhoneActivity", "mTagLocalFindReceiver unregister error");
            }
        }
    }

    /* renamed from: w4 */
    public final /* synthetic */ void m27868w4(int i10) {
        this.f20782s.loadUrl("javascript:stopRingOfflineResult(\"" + i10 + "\")");
    }

    /* renamed from: w5 */
    public final void m27869w5(boolean z10) {
        WebSettings settings;
        try {
            SafeWebView safeWebView = this.f20782s;
            if (safeWebView != null && (settings = safeWebView.getSettings()) != null) {
                m27686W1(settings);
            }
            if (z10) {
                m27835d4();
            } else {
                m27837e4();
            }
        } catch (Exception e10) {
            C13981a.m83988e("WapFindPhoneActivity", "updateDarkMode exception:" + e10.getMessage());
        }
    }

    /* renamed from: x4 */
    public final /* synthetic */ void m27870x4(int i10) {
        this.f20782s.loadUrl("javascript:requestCircleStateResult(" + i10 + ")");
    }

    /* renamed from: x5 */
    public final String m27871x5(String str) {
        try {
            return URLEncoder.encode(str, Constants.UTF_8);
        } catch (UnsupportedEncodingException e10) {
            C13981a.m83990w("WapFindPhoneActivity", "auth encode error:" + e10.getMessage());
            return str;
        }
    }

    /* renamed from: z4 */
    public final /* synthetic */ void m27872z4(DialogInterface dialogInterface, int i10) {
        if (-1 == i10) {
            m27862t5();
        } else if (-2 == i10) {
            C4366a.m26382b().m26386e(3);
            C4366a.m26382b().m26385d(3);
            this.f20840u0 = -3;
            C11690w.m69700W("", "trustCircleOperation", "trustCircleBusiness", "showOfflineLocateDialog join cancel", "0", null);
        }
    }
}
