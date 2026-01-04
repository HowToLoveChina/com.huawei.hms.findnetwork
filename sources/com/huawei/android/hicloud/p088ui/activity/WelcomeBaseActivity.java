package com.huawei.android.hicloud.p088ui.activity;

import android.accounts.OperationCanceledException;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Movie;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import au.C1026a;
import co.AbstractHandlerC1512a;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.commonlib.receiver.LocalOpenPhoneFinderReceiver;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.complexutil.C2784e;
import com.huawei.android.hicloud.oobe.p086ui.activity.SimplifyOOBEQueryinfoActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoStyleButtonAnnotation;
import com.huawei.android.hicloud.p088ui.uiextend.GifImageView;
import com.huawei.android.hicloud.p088ui.uiextend.bean.DecodeGifResult;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.NewMergeAlertDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.UnspportPrivateSpaceDialog;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.hicloud.task.simple.C3017c;
import com.huawei.android.hicloud.task.simple.C3052k2;
import com.huawei.android.hicloud.task.simple.C3067o1;
import com.huawei.android.hicloud.task.simple.C3076q2;
import com.huawei.android.hicloud.task.simple.C3079r1;
import com.huawei.android.hicloud.task.simple.C3091v1;
import com.huawei.android.hicloud.task.simple.FullReportSwitchStatusTask;
import com.huawei.android.os.BuildEx;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.android.p073ds.R$anim;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.banner.manager.FrontAppDownloadManager;
import com.huawei.cloud.pay.p098ui.InactiveUserActivity;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.dnskpr.DnsKprUtil;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.RestoreNotifyUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import com.huawei.hicloud.notification.manager.CommonReportUtil;
import com.huawei.hicloud.notification.manager.HiCloudForceUpgradeConfigManager;
import com.huawei.hicloud.notification.manager.LocalMsgProcessor;
import com.huawei.hicloud.notification.manager.UnReadNumManager;
import com.huawei.hicloud.notification.util.ForcedUpgradeUtil;
import com.huawei.hicloud.notification.util.ModuleConfigUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.notificationv2.bean.C4972b;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.agreement.request.SignInfo;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import fk.C9721b;
import gn.InterfaceC10020c;
import gp.C10028c;
import hu.C10344c;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import je.C10806t;
import je.C10807u;
import mc.C11436a;
import mk.C11476b;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0226l0;
import p015ak.C0236u;
import p015ak.C0239x;
import p020ap.C1006a;
import p020ap.C1008c;
import p020ap.C1009d;
import p020ap.C1010e;
import p051c9.C1396a;
import p223db.C9062b;
import p229di.C9142g;
import p252e9.C9434k;
import p252e9.C9437n;
import p258ei.C9494c;
import p292fn.C9733f;
import p335hd.C10140c;
import p336he.C10155f;
import p387j7.C10731n;
import p422k9.C11019b;
import p429kk.C11058a;
import p429kk.C11060c;
import p446l7.C11253a;
import p446l7.C11257e;
import p474m9.C11432a;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p572qb.C12300b0;
import p572qb.C12332x;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p664u0.C13108a;
import p676ud.AlertDialogC13157d;
import p681uj.C13192i;
import p681uj.C13195l;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p709vj.InterfaceC13456i;
import p711vl.C13466f;
import p711vl.C13467g;
import p742wj.C13612b;
import p746wn.C13622a;
import p766x8.C13731j;
import p783xp.C13843a;
import p807yd.C13946b;
import p837z9.C14163d;
import p846zj.C14303a;
import p846zj.C14306d;
import sk.C12808e;
import sk.C12809f;
import tm.C13040c;
import vn.C13469a;
import vn.C13470b;
import vn.C13471c;

@AutoStyleButtonAnnotation
/* loaded from: classes3.dex */
public class WelcomeBaseActivity extends AuthCallbackActivity implements View.OnClickListener, DialogCallback {

    /* renamed from: A */
    public LinearLayout f16335A;

    /* renamed from: A0 */
    public boolean f16336A0;

    /* renamed from: B */
    public TextView f16337B;

    /* renamed from: B0 */
    public boolean f16338B0;

    /* renamed from: C0 */
    public int f16340C0;

    /* renamed from: E0 */
    public boolean f16344E0;

    /* renamed from: G */
    public ProgressDialog f16347G;

    /* renamed from: H */
    public ImageView f16349H;

    /* renamed from: I */
    public LinearLayout f16351I;

    /* renamed from: J */
    public SpanClickText f16353J;

    /* renamed from: K */
    public SpanClickText f16355K;

    /* renamed from: L */
    public SpanClickText f16357L;

    /* renamed from: M */
    public SpanClickText f16359M;

    /* renamed from: M0 */
    public ArrayList<String> f16360M0;

    /* renamed from: N */
    public HwButton f16361N;

    /* renamed from: O */
    public HwButton f16363O;

    /* renamed from: O0 */
    public String f16364O0;

    /* renamed from: P */
    public LinearLayout f16365P;

    /* renamed from: P0 */
    public String f16366P0;

    /* renamed from: Q */
    public LinearLayout f16367Q;

    /* renamed from: Q0 */
    public String f16368Q0;

    /* renamed from: R */
    public LinearLayout f16369R;

    /* renamed from: S */
    public LinearLayout f16371S;

    /* renamed from: T */
    public boolean f16373T;

    /* renamed from: U */
    public boolean f16375U;

    /* renamed from: V */
    public LinearLayout f16377V;

    /* renamed from: W */
    public LinearLayout f16379W;

    /* renamed from: X */
    public RelativeLayout f16381X;

    /* renamed from: Y */
    public RelativeLayout f16383Y;

    /* renamed from: Z */
    public RelativeLayout f16385Z;

    /* renamed from: a0 */
    public HwButton f16387a0;

    /* renamed from: b0 */
    public HwButton f16389b0;

    /* renamed from: c0 */
    public AlertDialogC13157d f16391c0;

    /* renamed from: d0 */
    public NewMergeAlertDialog f16393d0;

    /* renamed from: e0 */
    public C10028c f16395e0;

    /* renamed from: f0 */
    public CheckBox f16397f0;

    /* renamed from: g1 */
    public TextView f16400g1;

    /* renamed from: h0 */
    public RelativeLayout f16401h0;

    /* renamed from: i0 */
    public View f16403i0;

    /* renamed from: j0 */
    public TextView f16404j0;

    /* renamed from: k0 */
    public TextView f16405k0;

    /* renamed from: m0 */
    public LinearLayout f16409m0;

    /* renamed from: o0 */
    public boolean f16413o0;

    /* renamed from: q */
    public boolean f16416q;

    /* renamed from: r */
    public HwButton f16418r;

    /* renamed from: r0 */
    public Bundle f16419r0;

    /* renamed from: s */
    public View f16420s;

    /* renamed from: s0 */
    public UnspportPrivateSpaceDialog f16421s0;

    /* renamed from: u */
    public RelativeLayout f16424u;

    /* renamed from: v */
    public boolean f16426v;

    /* renamed from: w */
    public boolean f16428w;

    /* renamed from: x0 */
    public int f16431x0;

    /* renamed from: y */
    public int f16432y;

    /* renamed from: y0 */
    public String f16433y0;

    /* renamed from: z */
    public int f16434z;

    /* renamed from: z0 */
    public boolean f16435z0;

    /* renamed from: l */
    public boolean f16406l = false;

    /* renamed from: m */
    public boolean f16408m = false;

    /* renamed from: n */
    public boolean f16410n = false;

    /* renamed from: o */
    public boolean f16412o = false;

    /* renamed from: p */
    public boolean f16414p = false;

    /* renamed from: t */
    public SpanClickText f16422t = null;

    /* renamed from: x */
    public long f16430x = 0;

    /* renamed from: C */
    public boolean f16339C = false;

    /* renamed from: D */
    public boolean f16341D = false;

    /* renamed from: E */
    public boolean f16343E = false;

    /* renamed from: F */
    public boolean f16345F = false;

    /* renamed from: g0 */
    public boolean f16399g0 = true;

    /* renamed from: l0 */
    public boolean f16407l0 = false;

    /* renamed from: n0 */
    public ResultReceiver f16411n0 = null;

    /* renamed from: p0 */
    public boolean f16415p0 = false;

    /* renamed from: q0 */
    public int f16417q0 = 0;

    /* renamed from: t0 */
    public int f16423t0 = 2;

    /* renamed from: u0 */
    public String f16425u0 = "100";

    /* renamed from: v0 */
    public String f16427v0 = "1";

    /* renamed from: w0 */
    public boolean f16429w0 = false;

    /* renamed from: D0 */
    public int f16342D0 = 0;

    /* renamed from: F0 */
    public ProgressDialog f16346F0 = null;

    /* renamed from: G0 */
    public LocalReceiver f16348G0 = null;

    /* renamed from: H0 */
    public C3535h f16350H0 = null;

    /* renamed from: I0 */
    public C3091v1 f16352I0 = null;

    /* renamed from: J0 */
    public String f16354J0 = "";

    /* renamed from: K0 */
    public C2784e f16356K0 = new C2784e();

    /* renamed from: L0 */
    public ArrayList<String> f16358L0 = new ArrayList<>();

    /* renamed from: N0 */
    public boolean f16362N0 = false;

    /* renamed from: R0 */
    public boolean f16370R0 = false;

    /* renamed from: S0 */
    public C3079r1 f16372S0 = null;

    /* renamed from: T0 */
    public boolean f16374T0 = false;

    /* renamed from: U0 */
    public boolean f16376U0 = false;

    /* renamed from: V0 */
    public Bundle f16378V0 = null;

    /* renamed from: W0 */
    public boolean f16380W0 = false;

    /* renamed from: X0 */
    public boolean f16382X0 = false;

    /* renamed from: Y0 */
    public boolean f16384Y0 = false;

    /* renamed from: Z0 */
    public boolean f16386Z0 = false;

    /* renamed from: a1 */
    public boolean f16388a1 = false;

    /* renamed from: b1 */
    public boolean f16390b1 = false;

    /* renamed from: c1 */
    public boolean f16392c1 = false;

    /* renamed from: d1 */
    public boolean f16394d1 = false;

    /* renamed from: e1 */
    public int f16396e1 = 0;

    /* renamed from: f1 */
    public Handler f16398f1 = new HandlerC3528a();

    /* renamed from: h1 */
    public Handler f16402h1 = new HandlerC3529b();

    public class LocalReceiver extends BroadcastReceiver {
        public LocalReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ProgressDialog progressDialog;
            if (intent == null || (progressDialog = WelcomeBaseActivity.this.f16346F0) == null) {
                return;
            }
            try {
                progressDialog.dismiss();
                WelcomeBaseActivity.this.mo21667E2();
            } catch (Exception unused) {
                C11839m.m70688i("WelcomeBaseActivity", "loading dialog dismiss exception");
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.WelcomeBaseActivity$a */
    public class HandlerC3528a extends Handler {
        public HandlerC3528a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (WelcomeBaseActivity.this.m22581x1(message)) {
            }
            switch (message.what) {
                case 1:
                    C11839m.m70686d("WelcomeBaseActivity", "queryModuleInfo fail endtime =" + System.currentTimeMillis());
                    WelcomeBaseActivity.this.f16398f1.removeMessages(1);
                    WelcomeBaseActivity.this.m22603M2(0);
                    if (!C0209d.m1333z1(WelcomeBaseActivity.this.getApplicationContext())) {
                        WelcomeBaseActivity.this.f16398f1.sendEmptyMessage(3);
                        break;
                    } else {
                        WelcomeBaseActivity.this.m22635a2();
                        WelcomeBaseActivity.this.mo21955C2(8, 8, 0, 8);
                        WelcomeBaseActivity.this.f16417q0 = 1;
                        break;
                    }
                case 2:
                    C11839m.m70686d("WelcomeBaseActivity", "queryModuleInfo success endtime =" + System.currentTimeMillis());
                    if (!WelcomeBaseActivity.this.m22669t1() && !WelcomeBaseActivity.this.f16386Z0) {
                        C11839m.m70689w("WelcomeBaseActivity", "not support hwid guide, finish self");
                        WelcomeBaseActivity.this.m22681z1();
                        break;
                    } else {
                        WelcomeBaseActivity.this.m22603M2(1);
                        WelcomeBaseActivity.this.m22585B1();
                        UnReadNumManager.getInstance().refreshLauncherIconInTask();
                        WelcomeBaseActivity.this.f16398f1.removeMessages(1);
                        if (4098 == message.arg2 && (message.obj instanceof HashMap)) {
                            C11839m.m70688i("WelcomeBaseActivity", "user inactive jumpToInactiveActivity from QUERY_CONFIG_SUCCESS");
                            if (InactiveUserActivity.m28535s2(WelcomeBaseActivity.this, (HashMap) message.obj)) {
                            }
                        }
                        WelcomeBaseActivity.this.mo22676w2();
                        break;
                    }
                    break;
                case 3:
                    WelcomeBaseActivity.this.f16398f1.removeMessages(1);
                    WelcomeBaseActivity.this.f16398f1.removeMessages(12);
                    WelcomeBaseActivity.this.m22635a2();
                    WelcomeBaseActivity.this.mo21955C2(0, 8, 8, 8);
                    WelcomeBaseActivity.this.f16417q0 = 3;
                    break;
                case 4:
                    WelcomeBaseActivity.this.m22635a2();
                    WelcomeBaseActivity.this.m22603M2(0);
                    WelcomeBaseActivity.this.f16398f1.removeMessages(1);
                    WelcomeBaseActivity.this.f16398f1.removeMessages(12);
                    C10028c.m62183d0(WelcomeBaseActivity.this.getApplicationContext()).m62377p3("is_all_guide_over", true);
                    WelcomeBaseActivity.this.mo21955C2(8, 0, 8, 8);
                    WelcomeBaseActivity.this.f16417q0 = 4;
                    break;
                case 5:
                    WelcomeBaseActivity.this.m22635a2();
                    WelcomeBaseActivity.this.f16398f1.removeMessages(1);
                    WelcomeBaseActivity.this.setResult(702);
                    WelcomeBaseActivity.this.m22587C3();
                    break;
                case 6:
                    if (!WelcomeBaseActivity.this.isDestroyed()) {
                        WelcomeBaseActivity.this.f16398f1.removeMessages(1);
                        WelcomeBaseActivity.this.f16398f1.removeMessages(12);
                        WelcomeBaseActivity welcomeBaseActivity = WelcomeBaseActivity.this;
                        welcomeBaseActivity.f16417q0 = 6;
                        welcomeBaseActivity.mo21955C2(8, 8, 0, 8);
                        C13192i c13192iM79258g = C13192i.m79258g();
                        WelcomeBaseActivity welcomeBaseActivity2 = WelcomeBaseActivity.this;
                        c13192iM79258g.m79265k(welcomeBaseActivity2, 10019, 2, welcomeBaseActivity2.f16432y);
                        break;
                    }
                    break;
                default:
                    WelcomeBaseActivity.this.m22613Q3(message);
                    break;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.WelcomeBaseActivity$b */
    public class HandlerC3529b extends Handler {
        public HandlerC3529b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
            if (WelcomeBaseActivity.this.isFinishing() || WelcomeBaseActivity.this.isDestroyed()) {
                C11839m.m70686d("WelcomeBaseActivity", "activity is finished");
                return;
            }
            C11839m.m70688i("WelcomeBaseActivity", "mHandler, msg.what: " + message.what);
            int i10 = message.what;
            if (i10 == 0) {
                C11839m.m70686d("WelcomeBaseActivity", "SERVER_QUERY_SUCCESS");
                WelcomeBaseActivity.this.mo22676w2();
                return;
            }
            if (5 == i10) {
                C11839m.m70688i("WelcomeBaseActivity", "AUTHTOKEN_SUCCESS");
                WelcomeBaseActivity.this.m22592F1();
                return;
            }
            if (7 == i10) {
                C11839m.m70686d("WelcomeBaseActivity", "SERVICETOKEN_INVALID");
                C13612b c13612bM81829B = C13612b.m81829B();
                WelcomeBaseActivity welcomeBaseActivity = WelcomeBaseActivity.this;
                c13612bM81829B.m81858X(welcomeBaseActivity, welcomeBaseActivity);
                return;
            }
            if (1046 == i10 || 1047 == i10) {
                WelcomeBaseActivity.this.m22561U1(message);
                return;
            }
            if (8 == i10) {
                C11839m.m70686d("WelcomeBaseActivity", "GIF_DECODE_STREAM");
                Object obj = message.obj;
                if (obj instanceof DecodeGifResult) {
                    WelcomeBaseActivity.this.m22578t3((DecodeGifResult) obj);
                    return;
                }
                return;
            }
            if (9 == i10) {
                C11839m.m70688i("WelcomeBaseActivity", "receive result finish");
                WelcomeBaseActivity.this.mo20569M1();
                return;
            }
            if (10 == i10 || 1004 == i10) {
                C11839m.m70688i("WelcomeBaseActivity", "receive open phone finder time out");
                HiCloudForceUpgradeConfigManager.getInstance().saveForcedUpgradeConfig(null);
                WelcomeBaseActivity.this.finish();
            } else if (11 == i10) {
                C11839m.m70688i("WelcomeBaseActivity", "receive open hwid phone finder time out");
                WelcomeBaseActivity.this.m22677x2();
            } else if (12 != i10) {
                C11839m.m70686d("WelcomeBaseActivity", "showConfigErrorView");
                WelcomeBaseActivity.this.m22591E3();
            } else {
                RelativeLayout relativeLayout = WelcomeBaseActivity.this.f16401h0;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.WelcomeBaseActivity$c */
    public class DialogInterfaceOnClickListenerC3530c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3530c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            if (i10 == -1) {
                WelcomeBaseActivity welcomeBaseActivity = WelcomeBaseActivity.this;
                AlertDialogC13157d.m79148d(welcomeBaseActivity, welcomeBaseActivity.f16423t0);
                WelcomeBaseActivity.this.m22589D3();
            } else if (i10 == -2) {
                WelcomeBaseActivity.this.finish();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.WelcomeBaseActivity$d */
    public class C3531d implements InterfaceC13456i {
        public C3531d() {
        }

        /* renamed from: b */
        public final /* synthetic */ void m22684b(boolean z10) {
            if (z10) {
                WelcomeBaseActivity.this.mo21667E2();
            } else {
                WelcomeBaseActivity.this.m22630X3();
            }
        }

        @Override // p709vj.InterfaceC13456i
        public void loginResult(final boolean z10) {
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.e9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17601a.m22684b(z10);
                }
            });
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.WelcomeBaseActivity$e */
    public class C3532e implements SpanClickText.ISpanClickListener {

        /* renamed from: a */
        public final /* synthetic */ SpanClickText f16441a;

        public C3532e(SpanClickText spanClickText) {
            this.f16441a = spanClickText;
        }

        @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
        public void onClick() {
            if (this.f16441a != null) {
                C11839m.m70688i("WelcomeBaseActivity", "MyClickableSpan email on click");
                WelcomeBaseActivity.this.m22659o3();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.WelcomeBaseActivity$f */
    public class C3533f extends AbstractC12367d {
        public C3533f() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            C12515a.m75110o().m75172d(new C11257e(C0213f.m1377a(), false, true, true, true, countDownLatch));
            WelcomeBaseActivity.this.m22648i3();
            try {
                if (!countDownLatch.await(30L, TimeUnit.SECONDS)) {
                    C11839m.m70686d("WelcomeBaseActivity", "signCancelAgreement, wait not finish");
                }
            } catch (InterruptedException unused) {
                C11839m.m70689w("WelcomeBaseActivity", "signCancelAgreement wait latch catch InterruptedException.");
            }
            C13452e.m80781L().m80885a();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.WelcomeBaseActivity$g */
    public class HandlerC3534g extends Handler {
        public HandlerC3534g() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (WelcomeBaseActivity.this.isFinishing() || WelcomeBaseActivity.this.isDestroyed()) {
                C11839m.m70687e("WelcomeBaseActivity", "grshandler,the activity is not avaiable");
                return;
            }
            int i10 = message.what;
            if (8 == i10) {
                C11839m.m70688i("WelcomeBaseActivity", "check grs urls success");
                WelcomeBaseActivity.this.mo20683W3();
                return;
            }
            if (9 == i10) {
                C11839m.m70688i("WelcomeBaseActivity", "check grs urls fail");
                WelcomeBaseActivity.this.f16398f1.sendEmptyMessage(1);
                return;
            }
            if (10 == i10) {
                C11839m.m70688i("WelcomeBaseActivity", "check grs urls fail, server not support");
                WelcomeBaseActivity.this.f16398f1.sendEmptyMessage(4);
            } else if (11 == i10) {
                C11839m.m70688i("WelcomeBaseActivity", "check grs urls fail, hms service not available");
                WelcomeBaseActivity.this.f16398f1.sendEmptyMessage(6);
            } else if (12 == i10) {
                C11839m.m70688i("WelcomeBaseActivity", "check grs urls fail, network not available");
                WelcomeBaseActivity.this.f16398f1.sendEmptyMessage(3);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.WelcomeBaseActivity$h */
    public class C3535h extends BroadcastReceiver {
        public C3535h() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i10 = WelcomeBaseActivity.this.f16432y;
            if (i10 == 2 || i10 == 4 || i10 == 0) {
                C11839m.m70688i("WelcomeBaseActivity", "get config completed");
                C12515a.m75110o().m75175e(new C3052k2(WelcomeBaseActivity.this.getApplicationContext(), 2), false);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.WelcomeBaseActivity$i */
    public class HandlerC3536i extends AbstractHandlerC1512a {
        public HandlerC3536i(Activity activity) {
            super(activity);
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: d */
        public void mo8607d() {
            C11839m.m70688i("WelcomeBaseActivity", "Terms query failed, show error!");
            if (C0209d.m1333z1(WelcomeBaseActivity.this)) {
                WelcomeBaseActivity.this.f16398f1.sendEmptyMessage(1);
            } else {
                WelcomeBaseActivity.this.f16398f1.sendEmptyMessage(3);
            }
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: e */
        public void mo8608e(String str) {
            C11839m.m70686d("WelcomeBaseActivity", "doHmsAgreementUpdate");
            m22686l(str);
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: g */
        public void mo8610g() {
            C11839m.m70686d("WelcomeBaseActivity", "doHmsQueryNext");
            WelcomeBaseActivity.this.f16395e0.m62197C2("hms_agr_query_time", 0L);
            WelcomeBaseActivity.this.f16395e0.m62377p3("is_hicloud_terms_confirm", true);
            WelcomeBaseActivity.this.m22627W2();
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: h */
        public void mo8611h(List<SignInfo> list) {
            boolean zIsAgree;
            boolean zIsAgree2;
            boolean zIsAgree3;
            C11839m.m70686d("WelcomeBaseActivity", "doNext");
            if (list != null) {
                zIsAgree = false;
                zIsAgree2 = false;
                zIsAgree3 = false;
                for (SignInfo signInfo : list) {
                    short agrType = signInfo.getAgrType();
                    if (agrType == 125) {
                        zIsAgree = signInfo.isAgree();
                    } else if (agrType == 10000) {
                        zIsAgree3 = signInfo.isAgree();
                    } else if (agrType == 10013) {
                        zIsAgree2 = signInfo.isAgree();
                    }
                }
            } else {
                zIsAgree = false;
                zIsAgree2 = false;
                zIsAgree3 = false;
            }
            boolean z10 = zIsAgree3 || !"CN".equalsIgnoreCase(C11829c.m70533N());
            C11839m.m70688i("WelcomeBaseActivity", "doCheckSigned result:" + zIsAgree + '|' + zIsAgree2 + '|' + z10);
            m22685k(zIsAgree, zIsAgree2, z10);
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: i */
        public void mo8612i() {
            C11839m.m70688i("WelcomeBaseActivity", "doNoSign, Terms need to show.");
            WelcomeBaseActivity.this.m22604M3();
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: j */
        public int mo8613j() {
            return WelcomeBaseActivity.this.m22605N1();
        }

        /* renamed from: k */
        public void m22685k(boolean z10, boolean z11, boolean z12) {
            C11839m.m70686d("WelcomeBaseActivity", "processTermsQueryResult");
            if (!z10 || !z11 || !z12) {
                WelcomeBaseActivity.this.m22604M3();
                return;
            }
            C11839m.m70688i("WelcomeBaseActivity", "All signed, Terms no need to show.");
            WelcomeBaseActivity.this.f16395e0.m62197C2("agr_query_time", 0L);
            WelcomeBaseActivity.this.f16395e0.m62377p3("is_hicloud_terms_confirm", true);
            WelcomeBaseActivity.this.m22627W2();
        }

        /* renamed from: l */
        public void m22686l(String str) {
            if (TextUtils.isEmpty(str)) {
                mo8607d();
                return;
            }
            try {
                Intent intentM79271I = C13195l.m79271I(WelcomeBaseActivity.this, str);
                if (intentM79271I == null) {
                    C11839m.m70687e("WelcomeBaseActivity", "hmsPackage is invalid!");
                } else {
                    WelcomeBaseActivity.this.startActivityForResult(intentM79271I, 10028);
                }
            } catch (Exception e10) {
                C11839m.m70688i("WelcomeBaseActivity", "startActivityForResult Exception" + e10.getMessage());
                mo8607d();
            }
        }
    }

    /* renamed from: A1 */
    private void m22553A1() {
        ProgressDialog progressDialog = this.f16347G;
        if (progressDialog != null) {
            try {
                progressDialog.dismiss();
                this.f16347G = null;
            } catch (IllegalArgumentException unused) {
                C11839m.m70687e("WelcomeBaseActivity", "waitdialog dismiss IllegalArgumentException");
            }
        }
    }

    /* renamed from: D1 */
    private void m22554D1(int i10, Intent intent) {
        ErrorStatus errorStatus;
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07009"), "termProcessHMSResult", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        HashMap map = new HashMap();
        map.put("hms_agreement_result_code", String.valueOf(i10));
        map.put("hms_current_activity", getClass().getName());
        if (i10 == 0) {
            C11839m.m70687e("WelcomeBaseActivity", "agreement update result cancel");
            if (intent != null) {
                try {
                    errorStatus = (ErrorStatus) intent.getParcelableExtra("parce");
                } catch (Exception e10) {
                    C11839m.m70687e("WelcomeBaseActivity", "class ErrorStatus pkg path hms apk sdk not match  " + e10.getMessage());
                    errorStatus = null;
                }
                if (errorStatus != null) {
                    int errorCode = errorStatus.getErrorCode();
                    C11839m.m70687e("WelcomeBaseActivity", "error code = " + errorCode + ", error reason = " + errorStatus.getErrorReason());
                    map.put("hms_agreement_result_error_code", String.valueOf(errorCode));
                    if (errorCode == 10005) {
                        C11839m.m70687e("WelcomeBaseActivity", "disagree agreement by hand, exit.");
                        if (!C11842p.m70774V0(this)) {
                            finish();
                            return;
                        }
                    }
                }
            }
        } else {
            C11839m.m70688i("WelcomeBaseActivity", "agreement update success");
            C11829c.m70604p();
        }
        C13622a.m81969o(this, c11060cM66626a, map);
        this.f16395e0.m62377p3("is_hicloud_terms_confirm", true);
        m22627W2();
    }

    /* renamed from: G1 */
    private void m22555G1() {
        Iterator<String> it = this.f16360M0.iterator();
        while (it.hasNext()) {
            String next = it.next();
            Iterator<String> it2 = this.f16358L0.iterator();
            while (it2.hasNext()) {
                if (next.equals(it2.next())) {
                    it2.remove();
                }
            }
        }
    }

    /* renamed from: H2 */
    private void m22556H2() {
        if (this.f16410n) {
            C11839m.m70687e("WelcomeBaseActivity", "page isRecreated no Need Jump");
            return;
        }
        Intent intent = new Intent();
        boolean z10 = C13452e.m80781L().m80803F0().booleanValue() && m22662q2();
        C11839m.m70688i("WelcomeBaseActivity", "navToSwitchConfirmPage, isFront: " + z10 + ",isFromGalleryLogin:" + this.f16414p);
        if (z10) {
            intent.setClass(this, UniformGuideFrontActivity.class);
        } else {
            intent.setClass(this, UniformGuideActivity.class);
        }
        intent.putExtra(FamilyShareConstants.IS_FROM_GALLERY_LOGIN, this.f16414p);
        intent.putExtra("start_to_open_cloud_album_source", this.f16396e1);
        intent.putExtra("gallery_start_to_open_cloud_album", this.f16394d1);
        intent.putExtra(FamilyShareConstants.OPEN_FAMILY_SPACE_SHARE, this.f16370R0);
        if (this.f16370R0) {
            intent.putExtra(FamilyShareConstants.EXTRA_KEY, this.f16340C0);
            intent.putExtra("space_share_entry_type", this.f16434z);
        }
        intent.putExtra("is_password_verify_finished", this.f16366P0);
        intent.putExtra("is_phone_finder_already_open", this.f16416q);
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 2);
        intent.putExtra("is_from_phonefinder_guide", this.f16426v);
        intent.putExtra("is_from_phonefinder_guide_slave", this.f16428w);
        intent.putExtra("is_from_hwid_open_guide", m22658o2());
        intent.putExtra("is_from_stock_active", this.f16386Z0);
        intent.putExtra("is_from_stock_active_notify", this.f16390b1);
        startActivityForResult(intent, 10027);
        if (!z10 && !this.f16412o) {
            overridePendingTransition(R$anim.activity_fade_in, R$anim.activity_fade_out);
        }
        this.f16408m = true;
        this.f16362N0 = false;
    }

    /* renamed from: K2 */
    private void m22557K2(C10028c c10028c) {
        ArrayList<DriveConfigService> shownDriveServiceItems = NotifyUtil.getShownDriveServiceItems(this);
        if (shownDriveServiceItems.size() > 0) {
            Iterator<DriveConfigService> it = shownDriveServiceItems.iterator();
            while (it.hasNext()) {
                DriveConfigService next = it.next();
                if (next != null) {
                    String id2 = next.getId();
                    if (!TextUtils.isEmpty(id2)) {
                        if (c10028c.m62395t1("funcfg_" + id2) && this.f16356K0.m16195b(this, id2, false)) {
                            this.f16358L0.add(id2);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: L1 */
    private void m22558L1(String str, int i10) {
        String strM81958d = C13622a.m81958d("03003");
        C11839m.m70688i("WelcomeBaseActivity", "executeSync, syncModuleName:" + str + ", traceId: " + strM81958d);
        if ("addressbook".equals(str)) {
            C1008c.m6035v().m6050O(this, "addressbook", true);
            C10155f.m63272Y(this, strM81958d, SyncType.OPEN_SWITCH_FROM_GUIDE, i10);
            return;
        }
        if ("calendar".equals(str)) {
            C10155f.m63271X(this, strM81958d, i10);
            return;
        }
        if ("notepad".equals(str)) {
            C10155f.m63275a0(this, strM81958d, i10);
            return;
        }
        if ("wlan".equals(str)) {
            C1008c.m6035v().m6050O(this, "wlan", true);
            C10155f.m63279c0(this, strM81958d, i10);
        } else if ("browser".equals(str)) {
            C10155f.m63270W(this, strM81958d, i10);
        } else if (HNConstants.DataType.MEDIA.equals(str)) {
            C2783d.m16175r0(getApplicationContext());
        } else {
            C10155f.m63277b0(this, str, strM81958d, i10);
        }
    }

    /* renamed from: L2 */
    private void m22559L2(C10028c c10028c) {
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(this);
        if (shownSyncServiceItems.size() > 0) {
            Iterator<SyncConfigService> it = shownSyncServiceItems.iterator();
            while (it.hasNext()) {
                SyncConfigService next = it.next();
                if (next != null) {
                    String id2 = next.getId();
                    if (!TextUtils.isEmpty(id2)) {
                        if (c10028c.m62395t1("funcfg_" + id2) && this.f16356K0.m16195b(this, id2, false)) {
                            this.f16358L0.add(id2);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: N3 */
    private void m22560N3() {
        C10028c.m62183d0(this).m62377p3("is_hicloud_terms_confirm", true);
        C12515a.m75110o().m75172d(new C11257e(C0213f.m1377a(), true, true, true, true));
    }

    /* renamed from: U1 */
    public void m22561U1(Message message) {
        C11839m.m70688i("WelcomeBaseActivity", "handleLocalDataCheckMsg");
        boolean zM62403v = this.f16395e0.m62403v("quick_migrate_flag", false);
        boolean zM65778e = C10806t.m65778e();
        int i10 = message.arg1;
        if (zM62403v || zM65778e) {
            C11839m.m70688i("WelcomeBaseActivity", "quik migrate ,no login entry");
            C10806t.m65777d(this);
            C10806t.m65781h();
            RestoreNotifyUtil.getInstance().saveOOBEState(this);
            C0209d.m1318v2(this);
            C10806t.m65783j(this);
            C10806t.m65784k(false);
            m22619S3(i10);
            this.f16395e0.m62377p3("quick_migrate_flag", false);
            return;
        }
        int i11 = message.what;
        if (i11 != 1046) {
            if (i11 == 1047) {
                this.f16356K0.m16200g(this);
                if (!C1006a.m5936k().m5975v(this) && C10028c.m62182c0().m62395t1("funcfg_gallery")) {
                    this.f16356K0.m16203j(this);
                }
                m22562V3(this.f16358L0, i10);
                CommonReportUtil.reportLocalDataCheckResult("0", null);
                m22619S3(i10);
                return;
            }
            return;
        }
        if (this.f16393d0 == null) {
            this.f16393d0 = new NewMergeAlertDialog(this, this, i10);
        }
        this.f16360M0 = (ArrayList) message.obj;
        C11839m.m70688i("WelcomeBaseActivity", "MSG_SYNC_LOCAL_DATA_EXIST, module size = " + this.f16360M0.size());
        this.f16393d0.show(this.f16360M0, "");
        m22555G1();
        Iterator<String> it = this.f16358L0.iterator();
        while (it.hasNext()) {
            this.f16356K0.m16204k(this, it.next());
        }
        m22562V3(this.f16358L0, i10);
        CommonReportUtil.reportLocalDataCheckResult("1", this.f16358L0);
    }

    /* renamed from: V3 */
    private void m22562V3(ArrayList<String> arrayList, int i10) {
        C11839m.m70688i("WelcomeBaseActivity", "sync4LocalDataCheck");
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            m22558L1(it.next(), i10);
        }
    }

    /* renamed from: o1 */
    private void m22575o1() {
        boolean zM16195b = this.f16356K0.m16195b(this, HNConstants.DataType.MEDIA, false);
        C10028c c10028cM62183d0 = C10028c.m62183d0(this);
        if (c10028cM62183d0 != null && c10028cM62183d0.m62395t1("gallery_login_key")) {
            C11839m.m70688i("WelcomeBaseActivity", "GalleryAlreadyLogin");
        } else if (zM16195b) {
            this.f16358L0.add(HNConstants.DataType.MEDIA);
        }
    }

    /* renamed from: p1 */
    private void m22576p1() {
        boolean zM16195b = this.f16356K0.m16195b(this, "notepad", false);
        if (C10028c.m62182c0().m62395t1("funcfg_notes") && zM16195b && C0209d.m1215U1(this)) {
            this.f16358L0.add("notepad");
        }
    }

    /* renamed from: p3 */
    private void m22577p3(String str) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(str);
        }
    }

    /* renamed from: t3 */
    public void m22578t3(DecodeGifResult decodeGifResult) throws IOException {
        C11839m.m70688i("WelcomeBaseActivity", "setGifConfig");
        Movie movie = decodeGifResult.movie;
        GifImageView gifImageView = decodeGifResult.gifImageView;
        int i10 = decodeGifResult.resourceId;
        if (movie == null || gifImageView == null) {
            C11839m.m70687e("WelcomeBaseActivity", "setGifConfig error, movie or view is null");
        } else {
            gifImageView.setImageResourceAndStart(movie, i10);
            gifImageView.setLayerType(1, null);
        }
    }

    /* renamed from: v3 */
    private void m22579v3() {
        if (this.f16422t == null) {
            C11839m.m70689w("WelcomeBaseActivity", "setLearnMoreSpan emailRegion is null");
        } else {
            String string = getString(R$string.contact_email_value);
            m22582z3(this.f16422t, getString(R$string.set_get_info_not_avi, string), string);
        }
    }

    /* renamed from: w3 */
    private void m22580w3() {
        int iM70731H = C11842p.m70731H(this, (int) C11842p.m70844o(this, 36));
        int iM70731H2 = C11842p.m70731H(this, (int) C11842p.m70844o(this, 60));
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.set_network_not_connect);
        RelativeLayout relativeLayout2 = (RelativeLayout) C12809f.m76829b(this, R$id.set_service_timeout);
        C11842p.m70763R1(this, this.f16379W, iM70731H);
        C11842p.m70763R1(this, relativeLayout, iM70731H2);
        C11842p.m70763R1(this, relativeLayout2, iM70731H2);
    }

    /* renamed from: x1 */
    public boolean m22581x1(Message message) {
        if (isFinishing() || isDestroyed()) {
            C11839m.m70687e("WelcomeBaseActivity", "queryhandler,the activity is not avaiable");
            return true;
        }
        C11839m.m70688i("WelcomeBaseActivity", "Receive msg=" + message.what);
        int i10 = message.arg1;
        if (i10 == this.f16342D0 || i10 < 1) {
            return false;
        }
        C11839m.m70689w("WelcomeBaseActivity", "the callback is invalid, queryTime = " + i10 + ", queryServerTime = " + this.f16342D0);
        return true;
    }

    /* renamed from: z3 */
    private void m22582z3(SpanClickText spanClickText, String str, String str2) {
        spanClickText.m15931c(str2, new C3532e(spanClickText));
        spanClickText.m15934g(str, false);
    }

    /* renamed from: A3 */
    public void m22584A3(int i10) {
        Iterator<String> it = this.f16360M0.iterator();
        while (it.hasNext()) {
            C10155f.m63268U(this, it.next(), i10);
        }
    }

    /* renamed from: B1 */
    public final void m22585B1() {
        CheckBox checkBox;
        if (!C11829c.m70509D1() || this.f16407l0 || (checkBox = this.f16397f0) == null || checkBox.isChecked()) {
            return;
        }
        C11839m.m70688i("WelcomeBaseActivity", "configSpaceExperienceParticipate hw refresh no red point");
        UnReadNumManager.getInstance().refreshLauncherIconInTask(0);
        C0236u.m1658i();
    }

    /* renamed from: B2 */
    public final /* synthetic */ void m22586B2(Boolean bool) {
        m22682z2(true, bool.booleanValue());
    }

    /* renamed from: B3 */
    public void mo21954B3() {
    }

    /* renamed from: C1 */
    public void mo21666C1() {
        HwButton hwButton = this.f16418r;
        if (hwButton != null) {
            hwButton.setVisibility(8);
        }
    }

    /* renamed from: C2 */
    public void mo21955C2(int i10, int i11, int i12, int i13) {
        RelativeLayout relativeLayout;
        int i14 = this.f16432y;
        if (2 == i14 || i14 == 0 || 4 == i14) {
            LinearLayout linearLayout = this.f16367Q;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.f16369R;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            LinearLayout linearLayout3 = this.f16371S;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = this.f16383Y;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(i12);
            }
            RelativeLayout relativeLayout3 = this.f16381X;
            if (relativeLayout3 != null) {
                relativeLayout3.setVisibility(i10);
            }
            View view = this.f16420s;
            if (view != null) {
                view.setVisibility(i11);
            }
            if (i12 == 0 && (relativeLayout = this.f16401h0) != null) {
                relativeLayout.setVisibility(8);
            }
            m22680y3(i13);
            if (i11 == 0) {
                C11842p.m70827j2(this.f16420s, this.f13504j + this.f13505k);
                m22579v3();
                getPackageManager().setComponentEnabledSetting(new ComponentName(this, (Class<?>) BackupMainforSettingActivity.class), 2, 1);
            }
        }
    }

    /* renamed from: C3 */
    public final void m22587C3() {
        startActivity(new Intent(this, (Class<?>) AccountMismatchAlertActivity.class));
    }

    /* renamed from: D2 */
    public final void m22588D2() {
        if (C11842p.m70753O0(this) && !C11842p.m70747M0(this)) {
            m22639d2();
        } else {
            ((WindowManager) getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(new DisplayMetrics());
        }
    }

    /* renamed from: D3 */
    public void m22589D3() {
        if (C0209d.m1269j1()) {
            C13612b.m81829B().mo80999a(this, new C3531d());
        } else if (1 == C13612b.m81829B().m81843F(this)) {
            mo21667E2();
        } else {
            m22630X3();
        }
    }

    /* renamed from: E1 */
    public final void m22590E1(int i10, Intent intent) {
        if (i10 == 1) {
            C11839m.m70688i("WelcomeBaseActivity", "dealAuthorizationResult, AUTH_AGREE");
            m22560N3();
            C10028c.m62182c0().m62276T1(true);
            m22627W2();
            return;
        }
        if (i10 != 2) {
            if (C11842p.m70774V0(this)) {
                return;
            }
            finish();
        } else {
            C11839m.m70688i("WelcomeBaseActivity", "dealAuthorizationResult, AUTH_DISAGREE");
            m22608O3();
            if (C11842p.m70774V0(this)) {
                return;
            }
            finish();
        }
    }

    /* renamed from: E2 */
    public void mo21667E2() {
        mo21956I3();
        C13612b.m81829B().m81856U(this, this);
    }

    /* renamed from: E3 */
    public void m22591E3() {
        if (this.f16420s == null || this.f16377V == null || this.f16418r == null) {
            return;
        }
        C10028c.m62182c0().m62377p3("is_all_guide_over", true);
        m22579v3();
        this.f16420s.setVisibility(0);
        mo20574x3();
        if (m22662q2()) {
            LinearLayout linearLayout = this.f16379W;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        } else {
            this.f16377V.setVisibility(8);
            RelativeLayout relativeLayout = this.f16401h0;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.f16409m0;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        this.f16418r.setVisibility(8);
        this.f16415p0 = true;
    }

    /* renamed from: F1 */
    public final void m22592F1() {
        boolean z10 = this.f16395e0.m62403v("quick_migrate_flag", false) && !m22658o2();
        C11839m.m70688i("WelcomeBaseActivity", "quikMigrateFlow: " + z10);
        if (!C13452e.m80781L().m80803F0().booleanValue() || z10) {
            m22614R1();
            return;
        }
        if (m22662q2()) {
            C1008c.m6035v().m6051P(this, null, false);
            m22556H2();
        } else if (this.f16345F) {
            mo20682O2();
        } else if (m22654m2()) {
            mo20682O2();
        } else {
            this.f16341D = true;
            m22595H1();
        }
    }

    /* renamed from: F2 */
    public void mo20568F2() {
        Intent intent;
        C11839m.m70688i("WelcomeBaseActivity", "NavToMainPage");
        if (C2783d.m16111U(this)) {
            C11839m.m70688i("WelcomeBaseActivity", "NavToMainPage, isFirstEnterAfterLogin");
            boolean zM62221H1 = C10028c.m62182c0().m62221H1();
            if (C0209d.m1202Q0() && !zM62221H1 && C11829c.m70509D1()) {
                C11829c.m70561a1();
            }
            if (!C2783d.m16115W(this) && !ModuleConfigUtil.isAllModuleDisabled(this)) {
                Intent intent2 = new Intent(this, (Class<?>) SimplifyOOBEQueryinfoActivity.class);
                intent2.putExtra(FamilyShareConstants.ENTRY_TYPE, this.f16432y);
                intent2.putExtra("welcome_finisher", this.f16411n0);
                intent2.putExtra("intent_from_settings", this.f16373T);
                startActivityForResult(intent2, 10014);
                return;
            }
            intent = new Intent(this, (Class<?>) MainActivity.class);
        } else {
            intent = new Intent(this, (Class<?>) MainActivity.class);
        }
        intent.putExtra("welcome_finisher", this.f16411n0);
        intent.putExtra("intent_from_settings", this.f16373T);
        if (!TextUtils.isEmpty(this.f16354J0)) {
            intent.putExtra("channel_of_open_switch", this.f16354J0);
        }
        C13230i.m79525e1(intent, this.f16427v0, this.f16425u0);
        startActivity(intent);
    }

    /* renamed from: F3 */
    public void m22593F3() {
        if (this.f16346F0 == null) {
            this.f16346F0 = new ProgressDialog(this);
        }
        this.f16346F0.setMessage(getResources().getString(R$string.deleting_data));
        this.f16346F0.setCancelable(false);
        this.f16346F0.show();
    }

    /* renamed from: G2 */
    public void mo20680G2() {
        finish();
    }

    /* renamed from: G3 */
    public void m22594G3() {
        int i10 = this.f16417q0;
        if (i10 == 1 || i10 == 6 || i10 == 12) {
            mo21955C2(8, 8, 0, 8);
        } else if (i10 == 3) {
            mo21955C2(0, 8, 8, 8);
        } else {
            if (i10 != 4) {
                return;
            }
            mo21955C2(8, 0, 8, 8);
        }
    }

    /* renamed from: H1 */
    public final void m22595H1() {
        TextView textView = this.f16337B;
        if (textView == null || this.f16349H == null || this.f16365P == null) {
            return;
        }
        textView.setVisibility(8);
        C11842p.m70846o1(this, this.f16353J, this.f16355K, this.f16357L, this.f16359M, false, false);
        this.f16349H.setVisibility(0);
        this.f16365P.setVisibility(0);
    }

    /* renamed from: H3 */
    public final void m22596H3() {
        if (m22662q2()) {
            this.f16377V.setVisibility(8);
            LinearLayout linearLayout = this.f16379W;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
                return;
            }
            return;
        }
        boolean z10 = C11829c.m70509D1() && !this.f16407l0;
        C11839m.m70688i("WelcomeBaseActivity", "showQueryLayoutByStartSource  needShowSpaceExperience: " + z10);
        C11839m.m70688i("WelcomeBaseActivity", "showQueryLayoutByStartSource  isSpaceExperienceFromFamilyShare: " + this.f16407l0);
        if (z10) {
            C11842p.m70712A2(this.f16401h0, false);
            if (!this.f16392c1) {
                this.f16392c1 = true;
                this.f16402h1.sendEmptyMessageDelayed(12, 3000L);
            }
            C9437n.m59190e().m59202o(true);
            UnReadNumManager.getInstance().refreshLauncherIconInTask(1);
            m22597J1();
        } else {
            C11842p.m70712A2(this.f16409m0, false);
            C11842p.m70712A2(this.f16377V, !this.f16343E);
            boolean zM85192h = C14303a.m85185a().m85192h();
            C11839m.m70688i("WelcomeBaseActivity", "showQueryLayoutByStartSource isOverseasRedPointShowing: " + zM85192h);
            if (zM85192h && this.f16401h0 != null) {
                if (C0209d.m1250e2(this)) {
                    C14303a.m85185a().m85194j(false);
                    UnReadNumManager.getInstance().refreshLauncherIconInTask(0);
                } else {
                    UnReadNumManager.getInstance().refreshLauncherIconInTask(0);
                    C14303a.m85185a().m85194j(false);
                    C9437n.m59190e().m59202o(true);
                    m22600K1();
                }
            }
            if (!this.f16392c1) {
                this.f16392c1 = true;
                this.f16402h1.sendEmptyMessageDelayed(12, 3000L);
            }
        }
        LinearLayout linearLayout2 = this.f16379W;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    /* renamed from: I1 */
    public void mo21669I1() {
        finish();
    }

    /* renamed from: I2 */
    public boolean mo20681I2() {
        return false;
    }

    /* renamed from: I3 */
    public void mo21956I3() {
        if (this.f16418r == null || this.f16339C) {
            return;
        }
        m22601K3();
        this.f16339C = true;
    }

    /* renamed from: J1 */
    public final void m22597J1() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        C13230i.m79507N0(linkedHashMapM79497A);
        C13469a.m81112f().m81113a("enter_gift_page", linkedHashMapM79497A);
        C13469a.m81112f().m81114b("PVC", "enter_gift_page", "1", "100", linkedHashMapM79497A);
    }

    /* renamed from: J2 */
    public boolean m22598J2() {
        if (C10028c.m62182c0().m62395t1("is_already_configed_NV4")) {
            return !r1.m62395t1("funcfg_cloud_backup");
        }
        return false;
    }

    /* renamed from: J3 */
    public void m22599J3() {
        if (this.f16339C) {
            m22601K3();
        } else {
            LinearLayout linearLayout = this.f16335A;
            if (linearLayout != null) {
                linearLayout.setVisibility(4);
            }
        }
        if (this.f16341D) {
            m22595H1();
        }
    }

    /* renamed from: K1 */
    public final void m22600K1() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        C13230i.m79507N0(linkedHashMapM79497A);
        C13469a.m81112f().m81113a("enter_gift_page_overseas", linkedHashMapM79497A);
        C13469a.m81112f().m81114b("PVC", "enter_gift_page_overseas", "1", "100", linkedHashMapM79497A);
    }

    /* renamed from: K3 */
    public final void m22601K3() {
        LinearLayout linearLayout = this.f16335A;
        if (linearLayout == null || this.f16337B == null) {
            C11839m.m70688i("WelcomeBaseActivity", "showQueryingTextSetString view is null");
            return;
        }
        linearLayout.setVisibility(0);
        this.f16337B.setText(getString(R$string.query_server_info));
        this.f16337B.append(getString(R$string.general_append_handling));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, p709vj.InterfaceC13449b
    /* renamed from: L */
    public void mo13808L(Exception exc) {
        if (C0209d.m1333z1(this)) {
            this.f16398f1.sendEmptyMessage(1);
        } else {
            this.f16398f1.sendEmptyMessage(3);
        }
    }

    /* renamed from: L3 */
    public void m22602L3() {
        UnspportPrivateSpaceDialog unspportPrivateSpaceDialog = this.f16421s0;
        if (unspportPrivateSpaceDialog == null) {
            UnspportPrivateSpaceDialog unspportPrivateSpaceDialog2 = new UnspportPrivateSpaceDialog(this, this);
            this.f16421s0 = unspportPrivateSpaceDialog2;
            unspportPrivateSpaceDialog2.show();
        } else {
            if (unspportPrivateSpaceDialog.isShowing()) {
                return;
            }
            this.f16421s0.show();
        }
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity
    /* renamed from: M0 */
    public void mo21218M0() {
        m22655m3();
    }

    /* renamed from: M1 */
    public void mo20569M1() {
    }

    /* renamed from: M2 */
    public void m22603M2(int i10) {
        boolean zIsAllModuleDisabledIncludePhonefinder;
        int i11;
        boolean z10;
        C11839m.m70688i("WelcomeBaseActivity", "notifyFileManagerConfigFinish: " + i10);
        if (i10 == 1) {
            boolean zM62395t1 = C10028c.m62182c0().m62395t1("funcfg_huawei_drive");
            z10 = zM62395t1;
            zIsAllModuleDisabledIncludePhonefinder = ModuleConfigUtil.getInstance().isAllModuleDisabledIncludePhonefinder(this);
            i11 = zM62395t1 ? 2 : 3;
        } else {
            zIsAllModuleDisabledIncludePhonefinder = true;
            i11 = 1;
            z10 = false;
        }
        C12515a.m75110o().m75175e(new C3067o1(this, i10, z10, C10028c.m62182c0().m62373p(), zIsAllModuleDisabledIncludePhonefinder, C10028c.m62182c0().m62329g0(), i11), true);
    }

    /* renamed from: M3 */
    public void m22604M3() {
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            m22682z2(true, false);
        } else {
            new C10731n(getApplicationContext(), new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.c9
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f16496a.m22586B2((Boolean) obj);
                }
            }).m65465o();
        }
    }

    /* renamed from: N1 */
    public int m22605N1() {
        return this.f16432y;
    }

    /* renamed from: N2 */
    public final void m22606N2(int i10, int i11, HiCloudSafeIntent hiCloudSafeIntent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (i10 != 10027) {
            if (i10 == 10037) {
                mo20687c3(i11, hiCloudSafeIntent);
                return;
            }
            if (i10 == 100048) {
                mo21670Z2(i11);
                return;
            }
            if (i10 == 10049) {
                this.f16412o = true;
                TextView textView = this.f16400g1;
                if (textView != null) {
                    textView.setText(R$string.cloudpay_loading);
                }
                mo22676w2();
                return;
            }
            return;
        }
        if (m22662q2() && C13452e.m80781L().m80803F0().booleanValue()) {
            if (i11 == -1) {
                this.f16378V0 = hiCloudSafeIntent.getBundleExtra("tempKeyBundle");
                m22614R1();
                return;
            }
            C13612b.m81829B().m81888u();
            C13452e.m80781L().m80885a();
            C10028c.m62182c0().m62338i();
            if (this.f16386Z0) {
                finish();
                return;
            }
        }
        if (this.f16434z == 1 && i11 == 1) {
            setResult(i11);
        } else {
            setResult(-1);
        }
        if (this.f16426v) {
            C11839m.m70688i("WelcomeBaseActivity", "from PhoneFinderGuide, jumpToPhoneFinderActivity");
            m22677x2();
            return;
        }
        if (this.f16428w) {
            C11839m.m70688i("WelcomeBaseActivity", "from SlavePhoneFinderGuide, jumpToWapFinderActivity");
            m22679y2();
        } else if (this.f16380W0) {
            C11839m.m70688i("WelcomeBaseActivity", "NewHisyncSetting, jump main");
            mo20568F2();
        } else if (!this.f16336A0) {
            finish();
        } else {
            m22619S3(6);
            C11839m.m70688i("WelcomeBaseActivity", "mIsFromDBank, jumpToMainActivity");
        }
    }

    /* renamed from: O1 */
    public final void m22607O1() {
        this.f16416q = C1010e.m6125b().m6138d(this);
    }

    /* renamed from: O2 */
    public void mo20682O2() {
        C11839m.m70688i("WelcomeBaseActivity", "onAgreeNetBtnClick");
        if (C13612b.m81829B().isLogin() && C10028c.m62182c0().m62395t1("is_all_guide_over") && C10028c.m62182c0().m62395t1("is_already_configed_NV4")) {
            mo21669I1();
            return;
        }
        C13040c.m78609F().m78656k0();
        C10028c.m62182c0().m62377p3("confirm_permission_tips", true);
        m22614R1();
        C13230i.m79548x0(getClass().getCanonicalName());
        this.f16398f1.postDelayed(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.d9
            @Override // java.lang.Runnable
            public final void run() {
                this.f17591a.m22583A2();
            }
        }, 5000L);
    }

    /* renamed from: O3 */
    public final void m22608O3() {
        C10028c.m62183d0(this).m62377p3("is_hicloud_terms_confirm", false);
        C12515a.m75110o().m75172d(new C3533f());
    }

    /* renamed from: P1 */
    public final void m22609P1(HiCloudSafeIntent hiCloudSafeIntent) {
        try {
            String strM63704b = C10344c.m63704b(hiCloudSafeIntent.getData(), "srcChannel");
            String strM63704b2 = C10344c.m63704b(hiCloudSafeIntent.getData(), "activityCode");
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("srcChannel", strM63704b);
            jsonObject.addProperty("activityCode", strM63704b2);
            jsonObject.addProperty(FaqConstants.FAQ_MODEL, Build.MODEL);
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("x-hw-extend-fields", jsonObject.toString());
            C11839m.m70688i("WelcomeBaseActivity", "reportOmExtendHeader is: " + jsonObject2.toString());
            C13452e.m80781L().m80793C2(jsonObject2.toString());
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("WelcomeBaseActivity", "getReportMessage json exception:" + e10.toString());
        }
    }

    /* renamed from: P2 */
    public final void m22610P2() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (!C13452e.m80781L().m80803F0().booleanValue() || !m22662q2()) {
            m22663q3();
            m22616R3(C10028c.m62182c0().m62403v("backup_key", false));
            if (C0209d.m1166E1() && c10028cM62182c0.m62395t1("funcfg_find_my_phone_globe")) {
                c10028cM62182c0.m62336h2("oobe_phonefinder", true);
                return;
            }
            return;
        }
        if (c10028cM62182c0.m62395t1("funcfg_cloud_backup")) {
            C11839m.m70686d("WelcomeBaseActivity", "openPhoneFinderAndBackup cloudbackup enable, set cloudbackup switch.");
            if (c10028cM62182c0.m62388s("backup_key")) {
                return;
            }
            if (TextUtils.isEmpty(this.f16354J0)) {
                m22621T2();
            }
            C13227f.m79492i1().m79558J0(this.f16354J0);
        }
    }

    /* renamed from: P3 */
    public final void m22611P3(LinkedHashMap linkedHashMap) {
        if (!C11829c.m70509D1() || this.f16407l0) {
            return;
        }
        boolean z10 = !m22662q2();
        CheckBox checkBox = this.f16397f0;
        if (checkBox != null && checkBox.isChecked() && z10) {
            C9437n.m59190e().m59199l(true);
        }
        LinearLayout linearLayout = this.f16409m0;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        m22585B1();
        m22661q1("cloud_gift_agree_and_receive", linkedHashMap);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, p709vj.InterfaceC13449b
    /* renamed from: Q */
    public boolean mo13814Q(Bundle bundle) {
        return false;
    }

    /* renamed from: Q1 */
    public final void m22612Q1() {
        C11839m.m70688i("WelcomeBaseActivity", "getServerInfo");
        if (C13612b.m81829B().isLogin()) {
            m22644g3();
        } else {
            this.f16398f1.sendEmptyMessage(1);
        }
    }

    /* renamed from: Q2 */
    public void mo20570Q2() {
    }

    /* renamed from: Q3 */
    public final void m22613Q3(Message message) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        switch (message.what) {
            case 7:
                C11839m.m70686d("WelcomeBaseActivity", "queryDevConfInitTask success endtime =" + System.currentTimeMillis() + " guideSwitch false");
                this.f16398f1.removeMessages(12);
                m22681z1();
                break;
            case 8:
                C11839m.m70686d("WelcomeBaseActivity", "queryDevConfInitTask success endtime =" + System.currentTimeMillis());
                m22603M2(1);
                this.f16398f1.removeMessages(12);
                if (4098 == message.arg2 && (message.obj instanceof HashMap)) {
                    C11839m.m70688i("WelcomeBaseActivity", "user inactive jumpToInactiveActivity from QUERY_DEV_CONF_INIT_SUCCESS");
                    if (InactiveUserActivity.m28535s2(this, (HashMap) message.obj)) {
                    }
                }
                mo22676w2();
                break;
            case 9:
                C11839m.m70688i("WelcomeBaseActivity", "terms agreed");
                this.f16398f1.removeMessages(12);
                m22627W2();
                break;
            case 10:
                C11839m.m70688i("WelcomeBaseActivity", "terms show agree view");
                this.f16398f1.removeMessages(12);
                this.f16374T0 = true;
                m22604M3();
                break;
            case 11:
                C11839m.m70688i("WelcomeBaseActivity", "terms no sign");
                this.f16398f1.removeMessages(12);
                this.f16374T0 = true;
                m22604M3();
                break;
            case 12:
                C11839m.m70686d("WelcomeBaseActivity", "queryDevConfInitTask fail endtime =" + System.currentTimeMillis());
                this.f16398f1.removeMessages(12);
                m22603M2(0);
                if (!C0209d.m1333z1(getApplicationContext())) {
                    this.f16398f1.sendEmptyMessage(3);
                    break;
                } else {
                    m22635a2();
                    mo21955C2(8, 8, 0, 8);
                    this.f16417q0 = 12;
                    break;
                }
        }
    }

    /* renamed from: R1 */
    public void m22614R1() {
        if (!m22662q2()) {
            C12515a.m75110o().m75175e(new C10140c(new HandlerC3534g(), false), false);
            return;
        }
        boolean zM22674v1 = m22674v1();
        C11839m.m70688i("WelcomeBaseActivity", "grsUrlsVerifyProcess,checkIsSupportUnify:" + zM22674v1);
        if (!zM22674v1) {
            m22643f3(false);
        } else if (m22664r1()) {
            m22627W2();
        } else {
            m22641e3();
        }
    }

    /* renamed from: R2 */
    public void m22615R2() {
        C11839m.m70688i("WelcomeBaseActivity", "openPhoneFinder: ");
        if (isFinishing()) {
            C11839m.m70687e("WelcomeBaseActivity", "OpenPhoneFinder is finishing");
        } else {
            C1010e.m6125b().m6135J(C0213f.m1377a());
            C12300b0.m73940b().m73943e(14);
        }
    }

    /* renamed from: R3 */
    public void m22616R3(boolean z10) {
        if (z10) {
            C11839m.m70688i("WelcomeBaseActivity", "startCloudBackup");
            if (C13452e.m80781L().m80887a1()) {
                m22650j3("CLOUDBACKUP_OPEN_FULL_CLOUDBACKUP");
                m22650j3("CLOUDBACKUP_OPEN_BASE_CLOUDBACKUP");
            } else {
                C13223b.m79476d(this, "backup_key", true);
                UBAAnalyze.m29954O("PVC", C13471c.m81132e().get("backup_key"), "1", "16");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add("backup_key");
            C12515a.m75110o().m75172d(new C3017c((ArrayList<String>) arrayList));
            CloudBackupService.getInstance().cloudbackupOpr(true);
        }
    }

    /* renamed from: S1 */
    public final void m22617S1(int i10) {
        C11839m.m70688i("WelcomeBaseActivity", "guideProcess");
        Intent intent = getIntent();
        if (intent != null) {
            try {
                if (new SafeIntent(intent).getBooleanExtra("intent_from_settings", false)) {
                    C13227f.m79492i1().m79600y("CLOUDBACKUP_HICLOUD_FROM_SETTING", "1");
                    UBAAnalyze.m29954O("PVC", "CLOUDBACKUP_HICLOUD_FROM_SETTING", "1", "4");
                }
                boolean zM62403v = C10028c.m62182c0().m62403v("guide_tag", false);
                C11839m.m70688i("WelcomeBaseActivity", "isFromGuide: " + zM62403v);
                if (!zM62403v) {
                    m22619S3(i10);
                    return;
                }
                this.f16362N0 = true;
                m22673u3(true, i10);
                C10028c.m62182c0().m62336h2("guide_tag", false);
                mo20570Q2();
            } catch (RuntimeException e10) {
                C11839m.m70688i("WelcomeBaseActivity", "initData:" + e10.toString());
            }
        }
    }

    /* renamed from: S2 */
    public final void m22618S2() {
        boolean z10 = FaqConstants.DISABLE_HA_REPORT.equals(this.f16366P0) || C0209d.m1193N0();
        if (C11829c.m70536O0() && C0209d.m1166E1() && z10) {
            if (C13452e.m80781L().m80803F0().booleanValue() && m22658o2()) {
                return;
            }
            C11839m.m70688i("WelcomeBaseActivity", "FromGuide:open finder");
            C12300b0.m73940b().m73943e(14);
        }
    }

    /* renamed from: S3 */
    public final void m22619S3(int i10) {
        if (m22660p2()) {
            m22622T3(i10);
            try {
                startActivity(new Intent(this, (Class<?>) MainActivity.class));
            } catch (Exception e10) {
                C11839m.m70687e("WelcomeBaseActivity", "start MainAcitity error: " + e10.toString());
            }
            finish();
            return;
        }
        if (m22665r2() && C13452e.m80781L().m80803F0().booleanValue()) {
            C11839m.m70688i("WelcomeBaseActivity", "china account, isFromHwidOpenGuide");
            if (m22622T3(i10)) {
                HiCloudForceUpgradeConfigManager.getInstance().saveForcedUpgradeConfig(null);
                finish();
                return;
            }
            return;
        }
        boolean z10 = this.f16395e0.m62403v("quick_migrate_flag", false) || C10806t.m65778e();
        if ((mo20573v2() && !z10) || m22658o2()) {
            C11839m.m70688i("WelcomeBaseActivity", "navToSwitchConfirmPage");
            if (!this.f16410n) {
                C11839m.m70687e("WelcomeBaseActivity", "page isRecreated no Need refreshSyncDataListFromServer");
                C1008c.m6035v().m6051P(this, null, false);
            }
            m22556H2();
            return;
        }
        C12515a.m75110o().m75172d(new FullReportSwitchStatusTask(this));
        if (C13946b.m83729e().m83752W(this, new SafeIntent(getIntent()))) {
            C11839m.m70688i("WelcomeBaseActivity", "EntranceTransUtil transfer");
            C10028c.m62182c0().m62377p3("is_all_guide_over", true);
            finish();
            return;
        }
        Bundle bundle = new Bundle();
        Intent intent = new Intent();
        intent.putExtra("intent_from_settings", this.f16373T);
        bundle.putParcelable("welcome_finisher", this.f16411n0);
        intent.putExtras(bundle);
        intent.setClass(this, MainActivity.class);
        if (!TextUtils.isEmpty(this.f16354J0)) {
            intent.putExtra("channel_of_open_switch", this.f16354J0);
        }
        intent.putExtra("file_clean_gallery", this.f16435z0);
        C13230i.m79525e1(intent, this.f16427v0, this.f16425u0);
        if (mo20681I2()) {
            C10028c.m62182c0().m62377p3("is_all_guide_over", true);
            finish();
        } else {
            startActivity(intent);
            C10028c.m62182c0().m62377p3("is_all_guide_over", true);
        }
    }

    /* renamed from: T1 */
    public final void m22620T1(int i10, Intent intent) {
        int intExtra = -1;
        if (i10 != -1 || intent == null) {
            return;
        }
        try {
            intExtra = intent.getIntExtra(BridgeActivity.EXTRA_RESULT, -1);
        } catch (RuntimeException unused) {
            C11839m.m70687e("WelcomeBaseActivity", "get hwid install result exception");
        }
        C11839m.m70688i("WelcomeBaseActivity", "installResult = " + intExtra);
        if (intExtra == 0) {
            C13612b.m81829B().m81856U(this, this);
        } else {
            finish();
        }
    }

    /* renamed from: T2 */
    public final void m22621T2() {
        if (C13222a.m79465g(this).equals("5")) {
            try {
                Intent intent = getIntent();
                if (intent == null || TextUtils.isEmpty(intent.getStringExtra(NotifyConstants.CloudStorageConstants.AD_NAME_KEY))) {
                    C11839m.m70688i("WelcomeBaseActivity", "parseChannelOfOpenSwitch parseAdId intent by AD_NAME_KEY error");
                } else {
                    this.f16425u0 = intent.getStringExtra(NotifyConstants.CloudStorageConstants.AD_NAME_KEY);
                }
            } catch (Exception unused) {
                C11839m.m70688i("WelcomeBaseActivity", "parseChannelOfOpenSwitch parseAdId intent exception");
            }
        }
        if (TextUtils.isEmpty(this.f16425u0)) {
            this.f16425u0 = "100";
        }
        String str = this.f16425u0;
        str.hashCode();
        switch (str) {
            case "1":
            case "4":
                this.f16354J0 = "3";
                break;
            case "3":
                this.f16354J0 = "7";
                break;
            case "5":
                this.f16354J0 = "5";
                break;
            case "9":
                this.f16354J0 = "11";
                break;
            default:
                this.f16354J0 = "3";
                break;
        }
        if (C10028c.m62182c0().m62325f1()) {
            this.f16354J0 = DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN;
        }
        C11839m.m70688i("WelcomeBaseActivity", "parseChannelOfOpenSwitch: clickFromWhere= " + this.f16425u0 + ",channelOfOpenSwitch= " + this.f16354J0);
    }

    /* renamed from: T3 */
    public boolean m22622T3(int i10) {
        Bundle bundle = this.f16378V0;
        boolean z10 = true;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object obj = this.f16378V0.get(str);
                boolean zBooleanValue = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false;
                C11839m.m70688i("WelcomeBaseActivity", "startModuleBusiness: " + str + "-" + zBooleanValue);
                if (str.equals("cloudbackup")) {
                    m22629X2(zBooleanValue);
                } else if (str.equals("phoneFinder")) {
                    m22632Y2(zBooleanValue);
                    z10 = !zBooleanValue;
                } else {
                    m22638b3(str, zBooleanValue, i10);
                }
            }
            if (!TextUtils.isEmpty(this.f16354J0)) {
                this.f16378V0.putString("channel_of_open_switch", this.f16354J0);
            }
        }
        C11019b.m66371t().m66416e0(this);
        C12515a.m75110o().m75172d(new C3076q2(getApplicationContext(), this.f16378V0, i10));
        C12515a.m75110o().m75172d(new FullReportSwitchStatusTask(this));
        return z10;
    }

    /* renamed from: U2 */
    public void m22623U2() {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        this.f16426v = hiCloudSafeIntent.getBooleanExtra("is_from_phonefinder_guide", false);
        this.f16428w = hiCloudSafeIntent.getBooleanExtra("is_from_phonefinder_guide_slave", false);
        this.f16364O0 = hiCloudSafeIntent.getStringExtra("is_trust_ring_finished");
        this.f16366P0 = FaqConstants.DISABLE_HA_REPORT;
        this.f16368Q0 = hiCloudSafeIntent.getStringExtra("start_source");
        C11839m.m70688i("WelcomeBaseActivity", "parseHwIdParam: isHwidTrustRingFinished = " + this.f16364O0 + ", isHwidPasswordVerifyFinished = " + this.f16366P0 + ", mStartSrc = " + this.f16368Q0);
        this.f16386Z0 = hiCloudSafeIntent.getBooleanExtra("is_from_stock_active", false);
        this.f16390b1 = hiCloudSafeIntent.getBooleanExtra("is_from_stock_active_notify", false);
        if ("hwid_login".equals(this.f16368Q0)) {
            C11839m.m70688i("WelcomeBaseActivity", "startup by hwid login");
            if (!C13452e.m80781L().m80842P0() || this.f16410n) {
                return;
            }
            C11839m.m70688i("WelcomeBaseActivity", "has old uid! set IS_EXIT_FINISH false.");
            C10028c.m62183d0(this).m62377p3("is_exit_finish", false);
        }
    }

    /* renamed from: U3 */
    public final void m22624U3(int i10) {
        m22675w1(i10);
    }

    /* renamed from: V1 */
    public final void m22625V1(int i10, Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (i10 != -1) {
            if (i10 == 2) {
                finish();
                return;
            }
            return;
        }
        String stringExtra = new HiCloudSafeIntent(intent).getStringExtra("jump_where");
        if ("jump_next".equals(stringExtra)) {
            mo22676w2();
            return;
        }
        if ("nav_main".equals(stringExtra)) {
            mo20568F2();
        } else if ("nav_module".equals(stringExtra)) {
            mo20680G2();
        } else {
            finish();
        }
    }

    /* renamed from: V2 */
    public void mo21957V2() {
        if (!m22665r2()) {
            m22612Q1();
        }
        if (m22662q2() && m22674v1() && m22664r1()) {
            C11839m.m70686d("WelcomeBaseActivity", "isFromHwidOpenGuide and issupportunify and agreedcloudterms");
            m22643f3(true);
        }
        if (m22662q2() && !m22674v1() && this.f16374T0) {
            this.f16374T0 = false;
            C11839m.m70686d("WelcomeBaseActivity", "isFromHwidOpenGuide and !checkIsSupportUnify,mNeedRequestAgain");
            m22643f3(false);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, p709vj.InterfaceC13449b
    /* renamed from: W */
    public void mo13820W(Bundle bundle) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 5;
        this.f16402h1.sendMessage(messageObtain);
    }

    /* renamed from: W1 */
    public boolean mo22626W1() {
        return this.f16395e0.m62369o0() == 0;
    }

    /* renamed from: W2 */
    public void m22627W2() {
        C11839m.m70688i("WelcomeBaseActivity", "processAfterSignAgreement");
        C13227f.m79492i1().m79560L(getApplicationContext(), C13452e.m80781L().m80971t0());
        ForcedUpgradeUtil.getInstance().initReceiver(getApplicationContext());
        C11436a.m68492d().m68497f(getApplicationContext());
        ICBBroadcastManager.registerBroadcastReceiver(getApplicationContext());
        C13731j.m82512b();
        C9494c.m59390r().m59397J();
        FrontAppDownloadManager.m28137j().m28145l();
        C12332x.m74156a().m74157b();
        if (C0209d.m1277l1() || BuildEx.VERSION.EMUI_SDK_INT >= 12) {
            this.f16395e0.m62336h2("support_push_notify_control", true);
            C2783d.m16189x0();
        }
        mo21957V2();
        AlertDialogC13157d.m79148d(this, this.f16423t0);
        DnsKprUtil.m29896e(getApplicationContext());
        m22678y1();
    }

    /* renamed from: W3 */
    public void mo20683W3() {
        C11839m.m70686d("WelcomeBaseActivity", "termsProcess");
        if (C10028c.m62182c0().m62221H1()) {
            m22627W2();
        } else {
            m22641e3();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.CommonActivity
    /* renamed from: X0 */
    public List<View> mo18477X0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f16381X);
        arrayList.add(this.f16420s);
        arrayList.add(this.f16385Z);
        return arrayList;
    }

    /* renamed from: X1 */
    public boolean mo22628X1() {
        return this.f16395e0.m62395t1("is_already_configed_NV4");
    }

    /* renamed from: X2 */
    public final void m22629X2(boolean z10) {
        boolean z11 = this.f16378V0.getBoolean("is_agree_to_basic_user");
        C11839m.m70688i("WelcomeBaseActivity", "processCloudBackupSwitch, switch status = " + z10 + " isBackupBasic: " + z11);
        if (!z11 || z10) {
            CloudBackupService.getInstance().cloudbackupOpr(z10);
        } else {
            C11019b.m66371t().m66431m();
        }
    }

    /* renamed from: X3 */
    public void m22630X3() {
        String strM1328y0 = C0209d.m1328y0(this);
        C11839m.m70686d("WelcomeBaseActivity", "unloginCountryCode: " + strM1328y0);
        if (!"CN".equals(strM1328y0) || this.f16386Z0 || m22654m2()) {
            mo21667E2();
            return;
        }
        this.f16341D = true;
        this.f16345F = true;
        m22595H1();
    }

    /* renamed from: Y1 */
    public final void m22631Y1() {
        String strM79502E;
        try {
            String action = new SafeIntent(getIntent()).getAction();
            if (TextUtils.isEmpty(action)) {
                strM79502E = C13230i.m79502E(this);
            } else {
                strM79502E = action.equals("com.huawei.android.intent.action.otherapp.HICLOUD_ENTTRANCE") ? "1" : "";
                if (action.equals("com.huawei.android.intent.action.settings.HICLOUD_ENTTRANCE")) {
                    strM79502E = "4";
                }
            }
            ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                if (!"1".equals(strM79502E) && !"4".equals(strM79502E)) {
                    actionBar.hide();
                    return;
                }
                if (!C13452e.m80781L().m80803F0().booleanValue()) {
                    actionBar.hide();
                } else if (C11829c.m70509D1()) {
                    actionBar.hide();
                } else {
                    actionBar.show();
                }
            }
        } catch (Exception e10) {
            C11839m.m70688i("WelcomeBaseActivity", "hideActionBar exception: " + e10.toString());
            ActionBar actionBar2 = getActionBar();
            if (actionBar2 != null) {
                actionBar2.hide();
            }
        }
    }

    /* renamed from: Y2 */
    public final void m22632Y2(boolean z10) {
        C11839m.m70688i("WelcomeBaseActivity", "processPhoneFinderSwitch, switch status = " + z10);
        if (z10) {
            LocalOpenPhoneFinderReceiver.m15903a().m15905c(this.f16402h1, 10);
            m22615R2();
            Handler handler = this.f16402h1;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(10, 40000L);
            }
        } else {
            C11839m.m70688i("WelcomeBaseActivity", "closePhoneFinder: ");
            C1010e.m6125b().m6156v(getApplicationContext());
        }
        C11019b.m66371t().m66436o0(this, "phonefinderNormal", z10);
    }

    /* renamed from: Y3 */
    public final void m22633Y3() {
        if (this.f16417q0 == 6) {
            finish();
        }
    }

    /* renamed from: Z1 */
    public final void m22634Z1() {
        if (this.f16349H != null && this.f16353J != null && this.f16355K != null && this.f16357L != null && this.f16359M != null && this.f16365P != null) {
            this.f16337B.setVisibility(0);
            this.f16349H.setVisibility(8);
            this.f16353J.setVisibility(8);
            this.f16355K.setVisibility(8);
            this.f16357L.setVisibility(8);
            this.f16359M.setVisibility(8);
            this.f16365P.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.f16401h0;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        LinearLayout linearLayout = this.f16409m0;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* renamed from: Z2 */
    public void mo21670Z2(int i10) {
    }

    /* renamed from: a2 */
    public void m22635a2() {
        m22553A1();
        if (this.f16418r == null) {
            return;
        }
        this.f16335A.setVisibility(4);
        this.f16339C = false;
    }

    /* renamed from: a3 */
    public final void m22636a3(int i10, Intent intent) {
        int intExtra;
        C11839m.m70688i("WelcomeBaseActivity", "requestCode is oobequery and resltcode = " + i10);
        if (i10 == -1) {
            this.f16402h1.sendEmptyMessage(0);
            return;
        }
        if (i10 == 702) {
            m22635a2();
            m22587C3();
            return;
        }
        if (i10 == 0) {
            finish();
            return;
        }
        if (i10 != 3 || intent == null) {
            return;
        }
        try {
            intExtra = intent.getIntExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, -1);
        } catch (RuntimeException e10) {
            C11839m.m70688i("WelcomeBaseActivity", "onActivityResult:" + e10.toString());
            intExtra = -1;
        }
        C11839m.m70688i("WelcomeBaseActivity", "errorCode:" + intExtra);
        if (intExtra != -1) {
            C13192i.m79258g().m79265k(this, 10019, intExtra, 2);
        }
    }

    /* renamed from: b2 */
    public void m22637b2() {
        m22651k2();
        m22645h2();
        if (this.f16344E0) {
            C11839m.m70686d("WelcomeBaseActivity", "logout is processing");
            m22593F3();
        } else {
            m29130D0();
        }
        m22642f2();
    }

    /* renamed from: b3 */
    public final void m22638b3(String str, boolean z10, int i10) {
        if (HNConstants.DataType.MEDIA.equals(str)) {
            if (C0209d.m1166E1()) {
                C1006a.m5936k().m5951O(z10, this);
                this.f16395e0.m62336h2("uploadphotokey", z10);
            }
        } else if (!"wlan".equals(str) || C0209d.m1166E1()) {
            this.f16395e0.m62336h2(str, z10);
        }
        if (z10) {
            m22558L1(str, i10);
        } else {
            C10155f.m63268U(this, str, i10);
        }
    }

    /* renamed from: c2 */
    public void mo21959c2() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C11842p.m70889z0(this);
    }

    /* renamed from: c3 */
    public void mo20687c3(int i10, Intent intent) {
    }

    /* renamed from: d2 */
    public void m22639d2() {
        ((WindowManager) getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        if (C11842p.m70771U0()) {
            return;
        }
        C11842p.m70827j2(this.f16424u, C11842p.m70852q(this));
    }

    /* renamed from: d3 */
    public void m22640d3() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (C13612b.m81829B().isLogin() && c10028cM62182c0.m62395t1("is_all_guide_over") && !c10028cM62182c0.m62395t1("is_already_configed_NV4") && C10155f.m63291o(this)) {
            c10028cM62182c0.m62281U2("need_inheritant_switch_status", true);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
        C11839m.m70689w("WelcomeBaseActivity", "authCanceled");
    }

    /* renamed from: e2 */
    public void mo21960e2() {
        if (C11842p.m70771U0()) {
            setContentView(R$layout.welcom_layout_pad);
        } else if (C11842p.m70747M0(this)) {
            setContentView(R$layout.welcom_layout_folder_screen);
        } else {
            setContentView(R$layout.welcom_layout);
        }
    }

    /* renamed from: e3 */
    public void m22641e3() {
        C11839m.m70686d("WelcomeBaseActivity", "queryAgreement");
        C12515a.m75110o().m75172d(new C11253a(this, new HandlerC3536i(this)));
    }

    /* renamed from: f2 */
    public void m22642f2() {
        this.f16348G0 = new LocalReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.android.hicloud.backup.EXITEND");
        C13108a.m78878b(this).m78880c(this.f16348G0, intentFilter);
        this.f16350H0 = new C3535h();
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(NotifyConstants.GET_CONFIG_COMPLETE_ACTION);
        C13108a.m78878b(this).m78880c(this.f16350H0, intentFilter2);
    }

    /* renamed from: f3 */
    public final void m22643f3(boolean z10) {
        C11839m.m70688i("WelcomeBaseActivity", "queryDevConfInitTask");
        mo21955C2(8, 8, 8, 0);
        C3079r1 c3079r1 = this.f16372S0;
        if (c3079r1 != null) {
            c3079r1.setAbort(true);
        }
        this.f16398f1.sendEmptyMessageDelayed(12, 60000L);
        this.f16342D0++;
        C11839m.m70688i("WelcomeBaseActivity", "queryDevConfInitTask queryServerTime =" + this.f16342D0);
        C11839m.m70686d("WelcomeBaseActivity", "queryDevConfInitTask starttime =" + System.currentTimeMillis());
        C11839m.m70688i("WelcomeBaseActivity", "queryDevConfInitTask,notNeedRequestTermsInfo:" + z10);
        this.f16372S0 = new C3079r1(this, this.f16398f1, z10, this.f16342D0);
        C12515a.m75110o().m75175e(this.f16372S0, false);
    }

    /* renamed from: g2 */
    public void mo21961g2() {
        m22588D2();
    }

    /* renamed from: g3 */
    public void m22644g3() {
        C11839m.m70688i("WelcomeBaseActivity", "queryModuleInfo");
        mo21955C2(8, 8, 8, 0);
        C3091v1 c3091v1 = this.f16352I0;
        if (c3091v1 != null) {
            c3091v1.setAbort(true);
        }
        this.f16398f1.sendEmptyMessageDelayed(1, 60000L);
        this.f16342D0++;
        C11839m.m70688i("WelcomeBaseActivity", "queryServerTime =" + this.f16342D0);
        C11839m.m70686d("WelcomeBaseActivity", "queryModuleInfo starttime =" + System.currentTimeMillis());
        this.f16352I0 = new C3091v1(this, this.f16398f1, this.f16342D0, false);
        C12515a.m75110o().m75175e(this.f16352I0, false);
    }

    /* renamed from: h2 */
    public void m22645h2() {
        getWindowManager().getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        this.f16367Q = (LinearLayout) C12809f.m76829b(this, R$id.query_server_info_nonet);
        this.f16369R = (LinearLayout) C12809f.m76829b(this, R$id.server_not_avaiable_layout);
        this.f16371S = (LinearLayout) C12809f.m76829b(this, R$id.getserver_info_timeout_layout);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.set_the_net);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.retry_getinfo);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.set_server_not_avaiable_layout);
        this.f16381X = (RelativeLayout) C12809f.m76829b(this, R$id.set_query_server_info_nonet);
        this.f16383Y = (RelativeLayout) C12809f.m76829b(this, R$id.set_getserver_info_timeout_layout);
        HwButton hwButton = (HwButton) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f16387a0 = hwButton;
        C11842p.m70874v1(this, hwButton);
        HwButton hwButton2 = (HwButton) C12809f.m76829b(this, R$id.set_retry_getinfo);
        this.f16389b0 = hwButton2;
        C11842p.m70874v1(this, hwButton2);
        ((TextView) C12809f.m76829b(this, R$id.oobe_server_not_avaiable_tips)).setText(getString(R$string.set_get_info_not_avi, getString(R$string.contact_email_value)));
        mo21954B3();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, (int) (this.f13503i * 0.2d), 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        this.f16387a0.setOnClickListener(this);
        this.f16383Y.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.set_network_not_connect);
        LinearLayout linearLayout2 = (LinearLayout) C12809f.m76829b(this, R$id.network_not_connect);
        relativeLayout.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        m18479Z0();
        m22580w3();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: h3 */
    public final void m22646h3() {
        boolean zM62395t1 = this.f16395e0.m62395t1("is_already_configed_NV4");
        boolean z10 = zM62395t1;
        if (this.f16395e0.m62395t1("is_all_guide_over")) {
            z10 = (zM62395t1 ? 1 : 0) | 2;
        }
        boolean z11 = z10;
        if (this.f16395e0.m62369o0() == 0) {
            z11 = (z10 ? 1 : 0) | 4;
        }
        int i10 = z11;
        if (C13612b.m81829B().isLogin()) {
            i10 = (z11 ? 1 : 0) | 8;
        }
        C0209d.m1294p2(this, "nav_to_main_status", i10);
    }

    /* renamed from: i2 */
    public void m22647i2() {
        try {
            SafeIntent safeIntent = new SafeIntent(getIntent());
            this.f16373T = safeIntent.getBooleanExtra("intent_from_settings", false);
            this.f16375U = safeIntent.getBooleanExtra("intent_from_settings_storage", false);
            String action = safeIntent.getAction();
            if (TextUtils.isEmpty(action)) {
                C11839m.m70688i("WelcomeBaseActivity", "initSettingParam set clickFromWhere by getActivityTypeValue.");
                this.f16425u0 = C13230i.m79502E(this);
                this.f16427v0 = C13230i.m79501D(this);
                return;
            }
            if (action.equals("com.huawei.android.intent.action.otherapp.HICLOUD_ENTTRANCE")) {
                this.f16425u0 = "1";
                this.f16427v0 = "1";
            }
            if (action.equals("com.huawei.android.intent.action.settings.HICLOUD_ENTTRANCE")) {
                this.f16425u0 = "4";
                this.f16427v0 = "1";
            }
        } catch (Exception unused) {
            C11839m.m70688i("WelcomeBaseActivity", "intent Serializable error.");
        }
    }

    /* renamed from: i3 */
    public void m22648i3() {
        C13227f.m79492i1().m79591l0("mecloud_agrenment_cancel", C13230i.m79499C(C13452e.m80781L().m80971t0()));
        UBAAnalyze.m29954O("PVC", "mecloud_agrenment_cancel", "1", "34");
    }

    /* renamed from: j2 */
    public final void m22649j2() {
        CheckBox checkBox = (CheckBox) C12809f.m76829b(this, R$id.chk_space_experience_main);
        this.f16397f0 = checkBox;
        checkBox.setChecked(this.f16399g0);
        this.f16401h0 = (RelativeLayout) C12809f.m76829b(this, R$id.space_experience_container_splash);
        View viewM76829b = C12809f.m76829b(this, R$id.iv_back_splash);
        this.f16403i0 = viewM76829b;
        viewM76829b.setOnClickListener(this);
        this.f16405k0 = (TextView) C12809f.m76829b(this, R$id.space_experience_chk_tip);
        this.f16404j0 = (TextView) C12809f.m76829b(this, R$id.space_experience_splash_tip_overseas);
        this.f16409m0 = (LinearLayout) C12809f.m76829b(this, R$id.ll_space_experience_chk_container);
        String strM70551W = C11829c.m70551W(53687091200L);
        TextView textView = this.f16405k0;
        if (textView != null) {
            textView.setText(getString(R$string.space_experience_tips_chk_main, strM70551W));
        }
        String string = getString(R$string.space_experience_tips_splash_overseas, strM70551W);
        int iIndexOf = string.indexOf("」");
        C11839m.m70688i("WelcomeBaseActivity", "startIndex: " + iIndexOf);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new StyleSpan(1), iIndexOf + 1, string.length(), 33);
        TextView textView2 = this.f16404j0;
        if (textView2 != null) {
            textView2.setText(spannableString);
        }
    }

    /* renamed from: j3 */
    public final void m22650j3(String str) {
        C13227f.m79492i1().m79600y(str, "1");
        UBAAnalyze.m29954O("PVC", str, "1", "16");
    }

    /* renamed from: k2 */
    public void m22651k2() {
        mo21960e2();
        mo21962l2();
        mo21666C1();
        mo21961g2();
    }

    /* renamed from: k3 */
    public void m22652k3(String str) {
        C10028c c10028c = this.f16395e0;
        if (c10028c != null) {
            boolean zM62395t1 = c10028c.m62395t1("is_already_configed_NV4");
            boolean zM62221H1 = this.f16395e0.m62221H1();
            if (zM62395t1 && zM62221H1) {
                C0209d.m1318v2(this);
                if (C13470b.m81125a().m81126b()) {
                    C13227f.m79492i1().m79561L0(str);
                    return;
                }
                C11839m.m70688i("WelcomeBaseActivity", "dataanalyze switch need init");
                C11432a.m68479d();
                C11432a.m68483i(str);
                C11432a.m68479d();
                C11432a.m68484j(true);
                C11432a.m68479d().m68486c();
            }
        }
    }

    /* renamed from: l2 */
    public void mo21962l2() {
        ImageView imageView;
        this.f16385Z = (RelativeLayout) C12809f.m76829b(this, R$id.welcome_main_layout);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.queryinfo_loading_txt);
        this.f16337B = textView;
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.f16335A = (LinearLayout) C12809f.m76829b(this, R$id.query_info_layout);
        this.f16418r = (HwButton) C12809f.m76829b(this, R$id.start_button);
        this.f16420s = C12809f.m76829b(this, R$id.query_failed_frame);
        this.f16377V = (LinearLayout) C12809f.m76829b(this, R$id.welcome_frame);
        this.f16379W = (LinearLayout) C12809f.m76829b(this, R$id.quering_layout);
        this.f16400g1 = (TextView) C12809f.m76829b(this, R$id.is_query_server_info);
        m22649j2();
        m22596H3();
        this.f16418r.setOnClickListener(this);
        this.f16424u = (RelativeLayout) C12809f.m76829b(this, R$id.welcome_button);
        this.f16422t = (SpanClickText) C12809f.m76829b(this, R$id.query_failed_email);
        this.f16365P = (LinearLayout) C12809f.m76829b(this, R$id.welcome_agree_layout);
        this.f16349H = (ImageView) C12809f.m76829b(this, R$id.welcome_icon_privacy);
        this.f16351I = (LinearLayout) C12809f.m76829b(this, R$id.welcome_privacy_content_ll);
        this.f16353J = (SpanClickText) C12809f.m76829b(this, R$id.welcome_privacy_content_first);
        this.f16355K = (SpanClickText) C12809f.m76829b(this, R$id.welcome_privacy_content_second);
        this.f16357L = (SpanClickText) C12809f.m76829b(this, R$id.welcome_privacy_content_third);
        this.f16359M = (SpanClickText) C12809f.m76829b(this, R$id.welcome_privacy_content_fourth);
        m22668s3();
        HwButton hwButton = (HwButton) C12809f.m76829b(this, R$id.welcome_agree_button);
        this.f16361N = hwButton;
        if (hwButton != null) {
            hwButton.setOnClickListener(this);
        }
        HwButton hwButton2 = (HwButton) C12809f.m76829b(this, R$id.welcome_cancel_button);
        this.f16363O = hwButton2;
        if (hwButton2 != null) {
            hwButton2.setOnClickListener(this);
        }
        getWindowManager().getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.welcome_tips_auto);
        if (textView2 != null) {
            textView2.setMovementMethod(new ScrollingMovementMethod());
        }
        TextView textView3 = (TextView) C12809f.m76829b(this, R$id.welcome_tips_sync);
        if (textView3 != null) {
            textView3.setMovementMethod(new ScrollingMovementMethod());
        }
        if (!C0209d.m1293p1() || (imageView = (ImageView) C12809f.m76829b(this, R$id.welcome_icon)) == null) {
            return;
        }
        imageView.setBackground(getDrawable(R$drawable.welcom_gif_bg_ink));
    }

    /* renamed from: l3 */
    public final void m22583A2() {
        boolean zM1354d = C0212e0.m1354d(this, "sp_stop_use_cloud_services", "key_stop_use_cloud_services", false);
        C11839m.m70688i("WelcomeBaseActivity", "isReUseCloudService" + zM1354d);
        if (zM1354d) {
            C0212e0.m1365o(this, "sp_stop_use_cloud_services", "key_stop_use_cloud_services", false);
            C13227f.m79492i1().m79585f0("re_use_cloud_services", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "re_use_cloud_services", "1", "100");
        }
    }

    /* renamed from: m2 */
    public boolean m22654m2() {
        if (C0209d.m1269j1()) {
            return false;
        }
        if (m22656n2()) {
            return true;
        }
        return C14303a.m85185a().m85191g();
    }

    /* renamed from: m3 */
    public void m22655m3() {
        C11839m.m70686d("WelcomeBaseActivity", "rootProcess");
        this.f16413o0 = false;
        if (!AlertDialogC13157d.m79147c(this, this.f16423t0)) {
            this.f16413o0 = C10807u.m65793i(this);
        }
        if (!this.f16413o0) {
            m22589D3();
            return;
        }
        if (this.f16391c0 == null) {
            this.f16391c0 = new AlertDialogC13157d(this, new DialogInterfaceOnClickListenerC3530c(), this.f16423t0);
        }
        if (isFinishing() || isDestroyed()) {
            C11839m.m70687e("WelcomeBaseActivity", "showdialog,the activity is not avaiable");
        } else {
            C11842p.m70883x2(this.f16391c0);
        }
    }

    /* renamed from: n2 */
    public final boolean m22656n2() {
        String strM57475a = C9142g.b.m57475a(CountryCodeBean.VENDOR_SYSTEMPROP, "");
        String strM57475a2 = C9142g.b.m57475a(CountryCodeBean.VENDORCOUNTRY_SYSTEMPROP, "");
        boolean zEqualsIgnoreCase = "demo".equalsIgnoreCase(strM57475a);
        boolean zEqualsIgnoreCase2 = "demo".equalsIgnoreCase(strM57475a2);
        C11839m.m70688i("WelcomeBaseActivity", "isDemoVersion isVendor ：" + zEqualsIgnoreCase + "; isCountry" + zEqualsIgnoreCase2);
        return zEqualsIgnoreCase || zEqualsIgnoreCase2;
    }

    /* renamed from: n3 */
    public final void m22657n3() {
        if (C2783d.m16099O()) {
            C11839m.m70688i("WelcomeBaseActivity", "CONFIG_TAG_OLD true");
        } else {
            C11839m.m70688i("WelcomeBaseActivity", "saveStatusToSP set guide_tag : true");
            this.f16395e0.m62336h2("guide_tag", true);
        }
    }

    /* renamed from: o2 */
    public boolean m22658o2() {
        return "hwid_login".equals(this.f16368Q0);
    }

    /* renamed from: o3 */
    public void m22659o3() {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", getString(R$string.hidisk_hwcloud_email_address_for_feedback), null));
        intent.putExtra("android.intent.extra.SUBJECT", "Subject");
        intent.putExtra("android.intent.extra.TEXT", "Body");
        startActivity(Intent.createChooser(intent, ""));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        C11839m.m70688i("WelcomeBaseActivity", "onActivityResult requestCode=" + i10 + ", resultCode=" + i11);
        if (i10 == 8701 && C13195l.m79272J().m79305U(this, this, hiCloudSafeIntent)) {
            this.f16384Y0 = true;
            return;
        }
        super.onActivityResult(i10, i11, hiCloudSafeIntent);
        if (i10 == 10001) {
            m22590E1(i11, hiCloudSafeIntent);
            return;
        }
        if (i10 == 10014) {
            m22636a3(i11, hiCloudSafeIntent);
            return;
        }
        if (i10 == 10019) {
            if (i11 == -1) {
                C11839m.m70688i("WelcomeBaseActivity", "hms update success");
                return;
            } else {
                if (i11 == 1) {
                    C11839m.m70689w("WelcomeBaseActivity", "hms update fail.");
                    m22633Y3();
                    return;
                }
                return;
            }
        }
        if (i10 == 10028) {
            m22554D1(i11, hiCloudSafeIntent);
            return;
        }
        if (i10 == 10021) {
            m22620T1(i11, hiCloudSafeIntent);
            return;
        }
        if (i10 != 10022) {
            if (i10 == 10023) {
                m22625V1(i11, hiCloudSafeIntent);
                return;
            } else {
                m22606N2(i10, i11, hiCloudSafeIntent);
                return;
            }
        }
        if (i11 == -1) {
            C13612b.m81829B().m81871l(this.f16419r0, this);
        } else if (i11 == 0) {
            finish();
        }
        this.f16419r0 = null;
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback
    public void onCanceled(String str, int i10) {
        if ("all_module".equals(str)) {
            m22584A3(i10);
            C2783d.m16114V0(str, "1", "2", i10);
        }
        m22619S3(i10);
    }

    public void onClick(View view) {
        RelativeLayout relativeLayout;
        int id2 = view.getId();
        boolean z10 = C11829c.m70512E1() && !this.f16407l0;
        boolean z11 = C11829c.m70509D1() && !this.f16407l0;
        boolean z12 = (this.f16397f0 == null || !z11) ? false : !r4.isChecked();
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        if (z11) {
            linkedHashMapM79499C.put("do_not_participate_event", Boolean.valueOf(z12));
            C13230i.m79507N0(linkedHashMapM79499C);
        }
        if (id2 == R$id.query_failed_email) {
            m22659o3();
            return;
        }
        if (id2 == R$id.set_the_net || id2 == R$id.set_no_net_btn) {
            C11829c.m70612r1(this);
            return;
        }
        if (id2 == R$id.retry_getinfo || id2 == R$id.set_getserver_info_timeout_layout || id2 == R$id.set_network_not_connect || id2 == R$id.network_not_connect) {
            this.f16417q0 = 0;
            mo21956I3();
            mo21955C2(8, 8, 8, 0);
            if (!C13452e.m80781L().m80842P0() || C13452e.m80781L().m80803F0().booleanValue()) {
                mo21667E2();
                return;
            } else {
                m22614R1();
                return;
            }
        }
        if (id2 == R$id.welcome_agree_button) {
            C11839m.m70688i("WelcomeBaseActivity", "click agree button");
            C10028c.m62182c0().m62395t1("confirm_permission_tips");
            this.f16341D = false;
            m22634Z1();
            m22611P3(linkedHashMapM79499C);
            if (C13452e.m80781L().m80850R0()) {
                mo20682O2();
            } else {
                mo21667E2();
            }
            C14303a.m85185a().m85193i(true);
            AdSwitchManager.getInstance().saveAdSwitch();
            InterfaceC10020c.get().mo62163b(new C4972b(0, ""));
            return;
        }
        if (id2 != R$id.welcome_cancel_button) {
            if (id2 != R$id.iv_back_splash || (relativeLayout = this.f16401h0) == null) {
                return;
            }
            relativeLayout.setVisibility(8);
            return;
        }
        C11839m.m70688i("WelcomeBaseActivity", "click cancel button");
        m22585B1();
        if (z10) {
            m22661q1("cloud_gift_exit", linkedHashMapM79499C);
        }
        m22666s1();
        C13452e.m80781L().m80885a();
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        HwButton hwButton;
        super.onConfigurationChanged(configuration);
        C11842p.m70874v1(this, this.f16387a0);
        C11842p.m70874v1(this, this.f16389b0);
        m22668s3();
        if (this.f16339C && (hwButton = this.f16418r) != null) {
            hwButton.setVisibility(8);
        }
        if (this.f16341D) {
            m22595H1();
        }
        mo21954B3();
        m22580w3();
        CheckBox checkBox = this.f16397f0;
        if (checkBox != null) {
            this.f16399g0 = checkBox.isChecked();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback
    public void onConfirmed(String str, String str2, int i10) {
        if ("all_module".equals(str)) {
            Iterator<String> it = this.f16360M0.iterator();
            while (it.hasNext()) {
                this.f16356K0.m16204k(this, it.next());
            }
            m22562V3(this.f16360M0, i10);
        }
        m22619S3(i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("WelcomeBaseActivity", "onCreate");
        this.f16343E = false;
        C13192i.m79258g().m79267m(true);
        if (bundle != null) {
            this.f16406l = bundle.getBoolean("is_recreate");
            this.f16410n = bundle.getBoolean("isInitCompleted");
            C11839m.m70688i("WelcomeBaseActivity", "isRecreated: " + this.f16406l + " isInitCompleted " + this.f16410n);
        }
        mo21959c2();
        C0239x.m1671c().m1675e();
        C11842p.m70800d(getIntent(), 8);
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        this.f16344E0 = C13612b.m81829B().m81855T();
        C11839m.m70688i("WelcomeBaseActivity", "processExit flag is: " + this.f16344E0);
        this.f16432y = 2;
        this.f16395e0 = C10028c.m62182c0();
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle("");
        }
        C12808e.m76822a(this);
        Intent intent = getIntent();
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        this.f16396e1 = hiCloudSafeIntent.getIntExtra("start_to_open_cloud_album_source", 0);
        this.f16394d1 = hiCloudSafeIntent.getBooleanExtra("gallery_start_to_open_cloud_album", false);
        if ("com.huawei.hicloud.action.FAMILY_CLOUD_SPACE_SHARE".equalsIgnoreCase(hiCloudSafeIntent.getAction())) {
            this.f16407l0 = true;
        }
        C11839m.m70688i("WelcomeBaseActivity", "isSpaceExperienceFromFamilyShare: " + this.f16407l0);
        C10028c.m62182c0().m62323f(hiCloudSafeIntent);
        if (intent != null) {
            try {
                if (intent.hasExtra("channel_of_open_switch")) {
                    this.f16354J0 = intent.getStringExtra("channel_of_open_switch");
                }
            } catch (Exception unused) {
                C11839m.m70687e("WelcomeBaseActivity", "parseOpenSwitchChannel get extra error");
            }
        }
        if (!C1026a.m6220d()) {
            C11839m.m70688i("WelcomeBaseActivity", "showRestrictionRunDialog");
            startActivity(new Intent(this, (Class<?>) RestrictedOperationActivity.class));
            return;
        }
        m22623U2();
        C11839m.m70686d("WelcomeBaseActivity", "parseOpenSwitchChannel channel: " + this.f16354J0);
        C1009d.m6109e().m6111b();
        m22607O1();
        if (!C9733f.m60705z().m60722Q()) {
            C9733f.m60705z().m60744g0(true);
            C9733f.m60705z().m60748i0(false);
        }
        MessageCenterManager.getInstance().processNotifyClickEvent(intent);
        m22609P1(hiCloudSafeIntent);
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C11839m.m70688i("WelcomeBaseActivity", "onDestroy");
        if (this.f16348G0 != null) {
            C13108a.m78878b(this).m78883f(this.f16348G0);
            this.f16348G0 = null;
        }
        if (this.f16350H0 != null) {
            C13108a.m78878b(this).m78883f(this.f16350H0);
            this.f16350H0 = null;
        }
        this.f16392c1 = false;
        this.f16407l0 = false;
        this.f16343E = false;
        ProgressDialog progressDialog = this.f16346F0;
        if (progressDialog != null) {
            try {
                progressDialog.dismiss();
            } catch (IllegalArgumentException unused) {
                C11839m.m70687e("WelcomeBaseActivity", "loading dialog dismiss IllegalArgumentException");
            } catch (Exception unused2) {
                C11839m.m70687e("WelcomeBaseActivity", "loading dialog dismiss exception");
            }
        }
        C11842p.m70836m(this);
        C13192i.m79258g().m79267m(false);
        try {
            ProgressDialog progressDialog2 = this.f16347G;
            if (progressDialog2 != null) {
                progressDialog2.dismiss();
            }
        } catch (IllegalArgumentException unused3) {
            C11839m.m70687e("WelcomeBaseActivity", "loading dialog dismiss IllegalArgumentException");
        } catch (Exception unused4) {
            C11839m.m70687e("WelcomeBaseActivity", "loading dialog dismiss exception");
        }
        try {
            UnspportPrivateSpaceDialog unspportPrivateSpaceDialog = this.f16421s0;
            if (unspportPrivateSpaceDialog != null) {
                unspportPrivateSpaceDialog.dismiss();
                this.f16421s0 = null;
            }
            AlertDialogC13157d alertDialogC13157d = this.f16391c0;
            if (alertDialogC13157d != null) {
                alertDialogC13157d.dismiss();
                this.f16391c0 = null;
            }
            NewMergeAlertDialog newMergeAlertDialog = this.f16393d0;
            if (newMergeAlertDialog != null) {
                newMergeAlertDialog.dismiss();
                this.f16393d0 = null;
            }
        } catch (IllegalArgumentException unused5) {
            C11839m.m70687e("WelcomeBaseActivity", "P.S. dialog dismiss IllegalArgumentException");
        } catch (Exception unused6) {
            C11839m.m70687e("WelcomeBaseActivity", "P.S. dialog dismiss exception");
        }
        m22635a2();
        this.f16380W0 = false;
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C11839m.m70688i("WelcomeBaseActivity", "welcomebaseAcitivity onNewIntent");
        this.f16417q0 = 0;
        this.f16382X0 = true;
        MessageCenterManager.getInstance().processNotifyClickEvent(intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C13227f.m79492i1().m79577X(this);
        UBAAnalyze.m29964Y("PVC", getClass().getCanonicalName(), "1", "100", super.mo18593F0());
        C13227f.m79492i1().m79581a0(0);
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        C13192i.m79258g().m79267m(true);
        super.onResume();
        C13227f.m79492i1().m79582b0(this);
        UBAAnalyze.m29967a0("PVC", getClass().getCanonicalName(), "1", "100");
        if (!this.f16382X0 && this.f16384Y0) {
            mo13808L(null);
        }
        this.f16382X0 = false;
        this.f16384Y0 = false;
        m22631Y1();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_recreate", this.f16408m);
        bundle.putBoolean("isInitCompleted", true);
    }

    @Override // android.app.Activity
    public void onStart() {
        C11839m.m70686d("WelcomeBaseActivity", "onStart");
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* renamed from: p2 */
    public boolean m22660p2() {
        return C0209d.m1269j1() ? this.f16386Z0 : this.f16386Z0 && this.f16388a1;
    }

    /* renamed from: q1 */
    public final void m22661q1(String str, LinkedHashMap linkedHashMap) {
        C13469a.m81112f().m81113a(str, linkedHashMap);
        C13469a.m81112f().m81114b("CKC", str, "1", "100", linkedHashMap);
    }

    /* renamed from: q2 */
    public boolean m22662q2() {
        boolean zM22658o2 = m22658o2();
        C11839m.m70688i("WelcomeBaseActivity", "grsUrlsVerifyProcess,isFromHwidOpenGuide:" + zM22658o2);
        if (!C0209d.m1269j1()) {
            return (zM22658o2 || this.f16386Z0) && this.f16388a1;
        }
        C11839m.m70688i("WelcomeBaseActivity", "isHwidLoginOrStockActiveProcess, isFromStockActive:" + this.f16386Z0);
        return zM22658o2 || this.f16386Z0;
    }

    /* renamed from: q3 */
    public void m22663q3() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (c10028cM62182c0.m62395t1("funcfg_cloud_backup")) {
            C11839m.m70686d("WelcomeBaseActivity", "cloudbackup enable, set cloudbackup switch.");
            if (!c10028cM62182c0.m62388s("backup_key")) {
                if (TextUtils.isEmpty(this.f16354J0)) {
                    m22621T2();
                }
                C13227f.m79492i1().m79558J0(this.f16354J0);
            }
            this.f16356K0.m16201h(this);
        }
    }

    /* renamed from: r1 */
    public final boolean m22664r1() {
        boolean zM62221H1 = C10028c.m62182c0().m62221H1();
        C11839m.m70688i("WelcomeBaseActivity", "isAgreedHiCloudTerms:" + zM62221H1);
        return zM62221H1;
    }

    /* renamed from: r2 */
    public boolean m22665r2() {
        return C0209d.m1269j1() ? m22658o2() : m22658o2() && this.f16388a1;
    }

    /* renamed from: r3 */
    public void mo20698r3() {
    }

    /* renamed from: s1 */
    public final void m22666s1() {
        CheckBox checkBox;
        if (!C0209d.m1285n1() || (checkBox = this.f16397f0) == null || checkBox.isChecked()) {
            return;
        }
        new LocalMsgProcessor().deleteLocalTextMessage(C13452e.m80781L().m80861U());
    }

    /* renamed from: s2 */
    public boolean m22667s2() {
        if (C13612b.m81829B().m81855T() || !C13612b.m81829B().isLogin()) {
            return false;
        }
        C11839m.m70686d("WelcomeBaseActivity", "enter isLogin");
        if (!C1009d.m6109e().m6117i()) {
            Bundle extras = new SafeIntent(getIntent()).getExtras();
            if (extras == null || !"dbank".equals(extras.getString(FaqConstants.FAQ_MODULE))) {
                C13612b.m81829B().m81878p(this);
            } else {
                C13612b.m81829B().m81876o();
            }
        }
        C10028c c10028c = this.f16395e0;
        if (c10028c == null) {
            C11839m.m70689w("WelcomeBaseActivity", "isJumptoNext backupSetting is null");
            return false;
        }
        if (!c10028c.m62221H1()) {
            return false;
        }
        C11839m.m70688i("WelcomeBaseActivity", "CONFIG_TAG=" + this.f16395e0.m62395t1("is_already_configed_NV4"));
        if (!mo22628X1()) {
            C11839m.m70689w("WelcomeBaseActivity", "hasSetConfigTag return false");
            return false;
        }
        if (!mo22626W1()) {
            return true;
        }
        C11839m.m70689w("WelcomeBaseActivity", "backupSetting getLastQueryV3ConfigTime return false");
        return false;
    }

    /* renamed from: s3 */
    public final void m22668s3() {
        if (C11842p.m70771U0() || C11842p.m70747M0(this)) {
            LinearLayout linearLayout = this.f16365P;
            if (linearLayout != null) {
                C11842p.m70733H1(linearLayout, C11842p.m70864t(this));
            }
            LinearLayout linearLayout2 = this.f16351I;
            if (linearLayout2 != null) {
                C11842p.m70733H1(linearLayout2, C11842p.m70864t(this));
            }
            LinearLayout linearLayout3 = this.f16409m0;
            if (linearLayout3 != null) {
                C11842p.m70733H1(linearLayout3, C11842p.m70864t(this));
            }
        }
    }

    /* renamed from: t1 */
    public boolean m22669t1() {
        boolean zM22658o2 = m22658o2();
        C11839m.m70688i("WelcomeBaseActivity", "fromHwidOpenGuide: " + zM22658o2);
        if (!zM22658o2) {
            return true;
        }
        if (!C0209d.m1166E1()) {
            C11839m.m70688i("WelcomeBaseActivity", "not owner user");
            return false;
        }
        C10028c c10028c = this.f16395e0;
        if (c10028c != null && (c10028c.m62226I1() || this.f16395e0.m62320e1())) {
            C11839m.m70688i("WelcomeBaseActivity", "force upgrade");
            return false;
        }
        boolean zM59168c = C9434k.m59168c();
        C11839m.m70688i("WelcomeBaseActivity", "recommendedOpen: " + zM59168c);
        return zM59168c;
    }

    /* renamed from: t2 */
    public boolean m22670t2() {
        if (C13612b.m81829B().m81855T()) {
            return false;
        }
        if (this.f16395e0 == null) {
            C11839m.m70689w("WelcomeBaseActivity", "isNavToMainPage backupSetting is null");
            return false;
        }
        C11839m.m70688i("WelcomeBaseActivity", "CONFIG_TAG=" + this.f16395e0.m62395t1("is_already_configed_NV4") + ",IS_ALL_GUIDE_OVER=" + this.f16395e0.m62395t1("is_all_guide_over"));
        m22646h3();
        if (C13612b.m81829B().isLogin()) {
            C11839m.m70686d("WelcomeBaseActivity", "enter isLogin");
            C13612b.m81829B().m81876o();
            return this.f16395e0.m62221H1() && this.f16395e0.m62395t1("is_already_configed_NV4") && this.f16395e0.m62395t1("is_all_guide_over") && this.f16395e0.m62369o0() != 0;
        }
        return false;
    }

    /* renamed from: u1 */
    public void m22671u1() {
        C10028c c10028c = this.f16395e0;
        if (c10028c == null || c10028c.m62403v("is_exit_finish", true)) {
            return;
        }
        C11839m.m70689w("WelcomeBaseActivity", "The last exit progress hasn't finished, clear persistent data");
        C1008c.m6035v().m6041F(getApplicationContext());
        C9062b.m57146k().m57152d();
    }

    /* renamed from: u2 */
    public boolean m22672u2() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (c10028cM62182c0 != null) {
            return C13612b.m81829B().isLogin() && c10028cM62182c0.m62221H1() && c10028cM62182c0.m62395t1("is_already_configed_NV4") && c10028cM62182c0.m62395t1("is_all_guide_over") && c10028cM62182c0.m62369o0() != 0;
        }
        C11839m.m70689w("WelcomeBaseActivity", "isNavToMainPage backupSetting is null");
        return false;
    }

    /* renamed from: u3 */
    public final void m22673u3(boolean z10, int i10) {
        C11839m.m70686d("WelcomeBaseActivity", "setGuideSwitch");
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        boolean zM62388s = c10028cM62182c0.m62388s("recovery by backup");
        boolean zM62324f0 = c10028cM62182c0.m62324f0("need_inheritant_switch_status");
        if (zM62388s || zM62324f0) {
            if (zM62388s && C11829c.m70536O0()) {
                c10028cM62182c0.m62336h2("oobe_phonefinder", true);
            }
            m22619S3(i10);
            return;
        }
        m22610P2();
        if (!mo20573v2() && !m22658o2()) {
            C11839m.m70688i("WelcomeBaseActivity", "checkguideconfig,startModuleSync");
            m22618S2();
            m22624U3(i10);
        } else {
            if (!ModuleConfigUtil.getInstance().isAllModuleDisabledIncludePhonefinder(this)) {
                m22619S3(i10);
                return;
            }
            C11839m.m70688i("WelcomeBaseActivity", "cloud all module disable");
            if (m22662q2()) {
                finish();
            } else {
                C10028c.m62183d0(getApplicationContext()).m62377p3("is_all_guide_over", true);
                mo21955C2(8, 0, 8, 8);
            }
        }
    }

    /* renamed from: v1 */
    public final boolean m22674v1() {
        return C11829c.m70534N0(this, C13452e.m80781L().m80942m()) && C13452e.m80781L().m80803F0().booleanValue();
    }

    /* renamed from: v2 */
    public boolean mo20573v2() {
        return this.f16362N0;
    }

    /* renamed from: w1 */
    public final void m22675w1(int i10) {
        C10028c c10028cM62183d0 = C10028c.m62183d0(this);
        if (c10028cM62183d0.m62395t1("funcfg_contacts") && this.f16356K0.m16195b(this, "addressbook", true)) {
            this.f16358L0.add("addressbook");
        }
        if (c10028cM62183d0.m62395t1("funcfg_calendar") && this.f16356K0.m16195b(this, "calendar", false)) {
            this.f16358L0.add("calendar");
        }
        if (c10028cM62183d0.m62395t1("funcfg_wlan") && C0209d.m1166E1() && this.f16356K0.m16195b(this, "wlan", false)) {
            this.f16358L0.add("wlan");
        }
        if (c10028cM62183d0.m62395t1("funcfg_browser") && C10155f.m63285i(this) && this.f16356K0.m16195b(this, "browser", false) && !C0209d.m1293p1()) {
            this.f16358L0.add("browser");
        }
        if (c10028cM62183d0.m62395t1("funcfg_notes")) {
            m22576p1();
        }
        if (C10155f.m63249B() && !C0209d.m1293p1()) {
            m22575o1();
        }
        m22559L2(c10028cM62183d0);
        m22557K2(c10028cM62183d0);
        new C1396a(this.f16402h1).m7988b(this, this.f16358L0, i10);
        CommonReportUtil.reportLocalDataCheck(this.f16358L0);
    }

    /* renamed from: w2 */
    public void mo22676w2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i10 = this.f16432y;
        if (i10 == 3) {
            m22677x2();
            return;
        }
        if (i10 != 2 && i10 != 4 && i10 != 0) {
            finish();
            return;
        }
        try {
            if (C13946b.m83729e().m83761j(new SafeIntent(getIntent()))) {
                this.f16395e0.m62336h2("guide_tag", true);
                m22617S1(6);
                C11839m.m70688i("WelcomeBaseActivity", "jumpToNextActivity set guide_tag: true");
                return;
            }
            m22657n3();
            if (C14163d.m84990g().m85009o()) {
                Intent intent = new Intent();
                intent.setClass(this, DataMigrationAuthActivity.class);
                intent.putExtra("jump_where", "jump_next");
                startActivityForResult(intent, 10023);
            } else {
                m22617S1(6);
            }
            m22635a2();
        } catch (Exception e10) {
            C11839m.m70687e("WelcomeBaseActivity", "jumpToNextActivity from webTrans failed " + e10.toString());
        }
    }

    /* renamed from: x2 */
    public final void m22677x2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("WelcomeBaseActivity", "jumpToPhoneFinderActivity");
        SafeIntent safeIntent = new SafeIntent(new Intent());
        C0209d.m1302r2(safeIntent, getPackageName());
        safeIntent.setAction("com.huawei.android.remotecontrol.PHONEFINDER_ENTTRANCE");
        safeIntent.putExtra(RemoteMessageConst.FROM, getPackageName());
        C13230i.m79525e1(safeIntent, "1", this.f16425u0);
        startActivity(safeIntent);
        new HwAnimationReflection(this).m15927c(2);
        finish();
    }

    /* renamed from: x3 */
    public void mo20574x3() {
    }

    /* renamed from: y1 */
    public final void m22678y1() {
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (C13466f.m81073d().m81078f("first_record_into_backup_time", -1L) <= 0) {
            C13466f.m81073d().m81083k("first_record_into_backup_time", System.currentTimeMillis());
        }
        if (TextUtils.isEmpty(strM80971t0) || C11476b.m68626h(strM80971t0).equals(C13467g.m81086c().m81090e("backup_sha_id", ""))) {
            return;
        }
        C13467g.m81086c().m81096k("backup_frequency");
        C13467g.m81086c().m81096k("backup_sha_id");
        C13467g.m81086c().m81096k("isFirstQueryTrans");
        C13467g.m81086c().m81096k("current_device_cloud_name");
        C11839m.m70688i("WelcomeBaseActivity", "remove user frequency info");
    }

    /* renamed from: y2 */
    public void m22679y2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("WelcomeBaseActivity", "jumpToWapFinderActivity");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(getPackageName(), "com.huawei.android.remotecontrol.ui.webview.WapFindPhoneActivity"));
        C0209d.m1302r2(intent, getPackageName());
        intent.putExtra(RemoteMessageConst.FROM, "fromPFClick");
        intent.putExtra("isEnableJs", true);
        intent.putExtra("isSystemAcc", true);
        intent.putExtra("needShowLoading", true);
        intent.putExtra("isAutoLogin", true);
        intent.putExtra("isSupportPicker", true);
        startActivity(intent);
        new HwAnimationReflection(this).m15927c(2);
        finish();
    }

    /* renamed from: y3 */
    public final void m22680y3(int i10) {
        LinearLayout linearLayout;
        if (this.f16377V != null) {
            if (m22662q2()) {
                LinearLayout linearLayout2 = this.f16379W;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(i10);
                }
            } else {
                this.f16377V.setVisibility(i10);
                if (i10 == 8 && (linearLayout = this.f16409m0) != null) {
                    linearLayout.setVisibility(8);
                }
            }
        }
        if (i10 == 0) {
            m22577p3("");
        } else {
            m22577p3(getString(R$string.hisync_name));
        }
    }

    /* renamed from: z1 */
    public final void m22681z1() {
        C10028c c10028c = this.f16395e0;
        if (c10028c != null) {
            c10028c.m62377p3("is_already_configed_NV4", false);
            this.f16395e0.m62254O1();
            C11829c.m70589k();
            C13452e.m80781L().m80885a();
        }
        m22603M2(0);
        finish();
    }

    /* renamed from: z2 */
    public void m22682z2(boolean z10, boolean z11) {
        if (C14306d.m85208i()) {
            C11839m.m70688i("WelcomeBaseActivity", "showUserAgreeView, second data center country,isNeedShowPushProtocol:" + z11);
            Intent intent = new Intent();
            intent.setClass(this, SecondCenterAuthorizationActivity.class);
            intent.putExtra("is_show_push_protocol", z11);
            startActivityForResult(intent, z10 ? 10001 : 100048);
            return;
        }
        if ("CN".equalsIgnoreCase(C13452e.m80781L().m80942m())) {
            C11839m.m70688i("WelcomeBaseActivity", "showUserAgreeView, china");
            Intent intent2 = new Intent();
            intent2.setClass(this, AuthorizationAlertActitivty.class);
            intent2.putExtra("startSource", "newhisync");
            startActivityForResult(intent2, 10001);
            return;
        }
        C11839m.m70688i("WelcomeBaseActivity", "showUserAgreeView, oversea other country,isNeedShowPushProtocol:" + z11);
        if (C10028c.m62182c0().m62221H1() && !z11) {
            C11839m.m70688i("WelcomeBaseActivity", "not need show push protocol");
            return;
        }
        Intent intent3 = new Intent();
        intent3.setClass(this, AuthPrivacyAlertActivity.class);
        intent3.putExtra("is_show_push_protocol", z11);
        startActivityForResult(intent3, z10 ? 10001 : 100048);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback
    public void onConfirmed(String str, String str2, ArrayList<String> arrayList, int i10) {
        if ("all_module".equals(str)) {
            Iterator<String> it = this.f16360M0.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!arrayList.contains(next)) {
                    C10155f.m63268U(this, next, i10);
                }
            }
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.f16356K0.m16204k(this, it2.next());
            }
            m22562V3(arrayList, i10);
        }
        m22619S3(i10);
    }
}
