package com.huawei.android.remotecontrol.nearlink.p090ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.huawei.android.hicloud.p088ui.activity.BaseActivity;
import com.huawei.android.os.VibratorEx;
import com.huawei.android.remotecontrol.nearlink.p090ui.NearLinkNavigationActivity;
import com.huawei.android.remotecontrol.nearlink.p090ui.component.NearLinkCircle;
import com.huawei.android.remotecontrol.sdk.R$anim;
import com.huawei.android.remotecontrol.sdk.R$drawable;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$plurals;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.tag.p092ui.view.CircleRing;
import com.huawei.android.remotecontrol.tag.p092ui.view.CircularRippleView;
import com.huawei.android.remotecontrol.tag.p092ui.view.NearLinkBlueView;
import com.huawei.android.remotecontrol.tag.p092ui.view.SingleSearchingRippleView;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.findnetwork.FindNetwork;
import com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback;
import com.huawei.hms.findnetwork.comm.request.bean.NearLinkNavigationResult;
import com.huawei.hms.findnetwork.comm.request.bean.SoundRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.NearLinkNavigationCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkConfigResult;
import com.huawei.hms.findnetwork.comm.util.ErrorCode;
import com.huawei.hms.p148ui.SafeIntent;
import eg.AbstractC9478g;
import fk.C9721b;
import huawei.android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import nf.C11669b;
import nf.C11690w;
import nf.C11692y;
import nf.C11693z;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0225l;
import p015ak.C0226l0;
import p015ak.C0241z;
import p227dg.C9097b;
import p292fn.C9733f;
import p476mf.C11464r;
import p476mf.RunnableC11454h;
import p514o9.C11829c;
import p514o9.C11842p;
import p521og.C11880m;
import p616rk.C12515a;
import p664u0.C13108a;
import p677ue.C13168a;
import p694v.C13299a;
import p809yg.C13981a;
import p851zp.InterfaceC14356c;
import sk.C12809f;

/* loaded from: classes4.dex */
public class NearLinkNavigationActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: L0 */
    public static Map<Integer, Integer> f19857L0 = C11693z.m69752b();

    /* renamed from: M0 */
    public static int f19858M0 = 10;

    /* renamed from: N0 */
    public static int f19859N0 = 11;

    /* renamed from: O0 */
    public static int f19860O0 = 12;

    /* renamed from: P0 */
    public static boolean f19861P0 = false;

    /* renamed from: Q0 */
    public static long f19862Q0 = 10000;

    /* renamed from: R0 */
    public static long f19863R0 = new Date().getTime();

    /* renamed from: S0 */
    public static boolean f19864S0 = false;

    /* renamed from: T0 */
    public static boolean f19865T0 = false;

    /* renamed from: U0 */
    public static int f19866U0 = 0;

    /* renamed from: V0 */
    public static int f19867V0 = 1;

    /* renamed from: W0 */
    public static int f19868W0 = 2;

    /* renamed from: X0 */
    public static int f19869X0 = 3;

    /* renamed from: Y0 */
    public static float f19870Y0 = 5.0f;

    /* renamed from: Z0 */
    public static float f19871Z0 = 134.0f;

    /* renamed from: a1 */
    public static float f19872a1 = 97.5f;

    /* renamed from: b1 */
    public static float f19873b1 = 37.0f;

    /* renamed from: c1 */
    public static float f19874c1 = 28.0f;

    /* renamed from: d1 */
    public static List<Integer> f19875d1 = new ArrayList();

    /* renamed from: e1 */
    public static int f19876e1 = 500;

    /* renamed from: A */
    public ImageView f19877A;

    /* renamed from: A0 */
    public NearLinkBlueView f19878A0;

    /* renamed from: B */
    public ImageView f19879B;

    /* renamed from: B0 */
    public SingleSearchingRippleView f19880B0;

    /* renamed from: C */
    public ImageView f19881C;

    /* renamed from: C0 */
    public TextView f19882C0;

    /* renamed from: D */
    public TextView f19883D;

    /* renamed from: D0 */
    public ImageView f19884D0;

    /* renamed from: E */
    public TextView f19885E;

    /* renamed from: E0 */
    public TextView f19886E0;

    /* renamed from: F */
    public TextView f19887F;

    /* renamed from: G */
    public TextView f19889G;

    /* renamed from: H */
    public ImageView f19891H;

    /* renamed from: I */
    public ImageView f19893I;

    /* renamed from: I0 */
    public long f19894I0;

    /* renamed from: J */
    public ImageView f19895J;

    /* renamed from: J0 */
    public Timer f19896J0;

    /* renamed from: K */
    public TextView f19897K;

    /* renamed from: L */
    public ImageView f19899L;

    /* renamed from: M */
    public String f19900M;

    /* renamed from: N */
    public String f19901N;

    /* renamed from: O */
    public int f19902O;

    /* renamed from: P */
    public String f19903P;

    /* renamed from: Q */
    public String f19904Q;

    /* renamed from: T */
    public String f19907T;

    /* renamed from: U */
    public long f19908U;

    /* renamed from: h0 */
    public VibratorEx f19921h0;

    /* renamed from: k0 */
    public Handler f19924k0;

    /* renamed from: m0 */
    public AlertDialog f19926m0;

    /* renamed from: n0 */
    public AlertDialog f19927n0;

    /* renamed from: o0 */
    public int f19928o0;

    /* renamed from: p */
    public Context f19929p;

    /* renamed from: p0 */
    public NearLinkCircle f19930p0;

    /* renamed from: r */
    public CircularRippleView f19933r;

    /* renamed from: s */
    public CircleRing f19935s;

    /* renamed from: s0 */
    public AlertDialog f19936s0;

    /* renamed from: t */
    public View f19937t;

    /* renamed from: u */
    public View f19939u;

    /* renamed from: v */
    public View f19941v;

    /* renamed from: w */
    public TextView f19943w;

    /* renamed from: x */
    public ImageView f19945x;

    /* renamed from: y */
    public View f19947y;

    /* renamed from: z */
    public View f19949z;

    /* renamed from: q */
    public long f19931q = 0;

    /* renamed from: R */
    public boolean f19905R = false;

    /* renamed from: S */
    public boolean f19906S = false;

    /* renamed from: V */
    public int f19909V = 0;

    /* renamed from: W */
    public boolean f19910W = true;

    /* renamed from: X */
    public boolean f19911X = false;

    /* renamed from: Y */
    public boolean f19912Y = false;

    /* renamed from: Z */
    public boolean f19913Z = false;

    /* renamed from: a0 */
    public boolean f19914a0 = false;

    /* renamed from: b0 */
    public boolean f19915b0 = false;

    /* renamed from: c0 */
    public volatile boolean f19916c0 = false;

    /* renamed from: d0 */
    public volatile float f19917d0 = 0.0f;

    /* renamed from: e0 */
    public volatile float f19918e0 = 0.0f;

    /* renamed from: f0 */
    public volatile int f19919f0 = 0;

    /* renamed from: g0 */
    public volatile int f19920g0 = 1;

    /* renamed from: i0 */
    public int f19922i0 = 600;

    /* renamed from: j0 */
    public boolean f19923j0 = false;

    /* renamed from: l0 */
    public Handler f19925l0 = new Handler(Looper.myLooper());

    /* renamed from: q0 */
    public BluetoothStatueReceiver f19932q0 = null;

    /* renamed from: r0 */
    public boolean f19934r0 = false;

    /* renamed from: t0 */
    public String f19938t0 = "";

    /* renamed from: u0 */
    public String f19940u0 = "";

    /* renamed from: v0 */
    public boolean f19942v0 = false;

    /* renamed from: w0 */
    public float f19944w0 = 2.0f;

    /* renamed from: x0 */
    public float f19946x0 = 2.5f;

    /* renamed from: y0 */
    public float f19948y0 = -1.0f;

    /* renamed from: z0 */
    public float f19950z0 = -1.0f;

    /* renamed from: F0 */
    public Timer f19888F0 = new Timer();

    /* renamed from: G0 */
    public Timer f19890G0 = new Timer();

    /* renamed from: H0 */
    public long f19892H0 = new Date().getTime();

    /* renamed from: K0 */
    public BroadcastReceiver f19898K0 = new C4356g();

    public class BluetoothStatueReceiver extends BroadcastReceiver {
        public BluetoothStatueReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C13981a.m83988e("NearLinkNavigationActivity", "onReceive, intent is null");
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            if (!"android.bluetooth.adapter.action.STATE_CHANGED".equals(safeIntent.getAction())) {
                if (!"huawei.sle.adapter.action.SLE_STATE_CHANGED".equals(safeIntent.getAction()) || C13168a.m79185n()) {
                    return;
                }
                C13981a.m83989i("NearLinkNavigationActivity", "onReceive, receiver nearlink close");
                NearLinkNavigationActivity.this.f19909V = 0;
                return;
            }
            C13981a.m83989i("NearLinkNavigationActivity", "onReceive, receiver bluetooth close, bluetoothState: " + safeIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0));
            NearLinkNavigationActivity.this.m26300B3();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.nearlink.ui.NearLinkNavigationActivity$a */
    public class C4350a extends AbstractC9478g {
        public C4350a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                final Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new URL(NearLinkNavigationActivity.this.f19907T).openStream());
                NearLinkNavigationActivity.this.runOnUiThread(new Runnable() { // from class: mf.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f53333a.m26363d(bitmapDecodeStream);
                    }
                });
                C11690w.m69700W(NearLinkNavigationActivity.this.f19900M, "nearLinkOperation", "nearLinkBusiness", "init DeviceIcon success", "0", null);
            } catch (Exception e10) {
                NearLinkNavigationActivity.this.f19891H.setImageResource(R$drawable.nearlink_default);
                C13981a.m83988e("NearLinkNavigationActivity", "initDeviceIconDetail invalid icon error url" + e10.getMessage());
                C11690w.m69700W(NearLinkNavigationActivity.this.f19900M, "nearLinkOperation", "nearLinkBusiness", "init DeviceIcon fail", "0", null);
            }
        }

        /* renamed from: d */
        public final /* synthetic */ void m26363d(Bitmap bitmap) {
            NearLinkNavigationActivity.this.f19891H.setImageBitmap(bitmap);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.nearlink.ui.NearLinkNavigationActivity$b */
    public class C4351b extends AbstractC9478g {
        public C4351b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                FindNetwork.getFindNetworkEngine(NearLinkNavigationActivity.this.f19929p).stopNearLinkNavigation(NearLinkNavigationActivity.this.f19900M);
            } catch (Exception e10) {
                C13981a.m83989i("NearLinkNavigationActivity", "stopNavigate onFail String:" + e10);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.nearlink.ui.NearLinkNavigationActivity$c */
    public class C4352c implements FindNetworkSoundCallback {
        public C4352c() {
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onFail(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83988e("NearLinkNavigationActivity", "startSound onFail:" + findNetworkConfigResult.getDescription() + ",Code:" + findNetworkConfigResult.getRespCode());
            NearLinkNavigationActivity.this.f19935s.stop();
            NearLinkNavigationActivity.this.m26341n3();
            NearLinkNavigationActivity.this.f19911X = false;
            if (C13168a.m79182k()) {
                C11880m.m71337d(NearLinkNavigationActivity.this.f19929p, NearLinkNavigationActivity.this.getString(R$string.sound_failed));
            } else {
                C11669b.m69677d(NearLinkNavigationActivity.this.f19929p, NearLinkNavigationActivity.this.f19900M);
            }
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onFinished(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("NearLinkNavigationActivity", "startSound onFinished");
            NearLinkNavigationActivity.this.f19935s.stop();
            NearLinkNavigationActivity.this.m26341n3();
            NearLinkNavigationActivity.this.f19911X = false;
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onSuccess(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("NearLinkNavigationActivity", "startSound onSuccess:" + findNetworkConfigResult.getRespCode());
            NearLinkNavigationActivity.this.f19911X = true;
            NearLinkNavigationActivity.this.m26357x3();
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onUpdate(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("NearLinkNavigationActivity", "startSound onUpdate");
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.nearlink.ui.NearLinkNavigationActivity$d */
    public class C4353d implements FindNetworkSoundCallback {
        public C4353d() {
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onFail(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83988e("NearLinkNavigationActivity", "stopSound onFail:" + findNetworkConfigResult.getDescription() + ",Code:" + findNetworkConfigResult.getRespCode());
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onFinished(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("NearLinkNavigationActivity", "stopSound onFinished");
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onSuccess(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("NearLinkNavigationActivity", "stopSound onSuccess");
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onUpdate(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("NearLinkNavigationActivity", "stopSound onUpdate");
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.nearlink.ui.NearLinkNavigationActivity$e */
    public class CountDownTimerC4354e extends CountDownTimer {

        /* renamed from: a */
        public final /* synthetic */ Button f19956a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CountDownTimerC4354e(long j10, long j11, Button button) {
            super(j10, j11);
            this.f19956a = button;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            C13981a.m83989i("NearLinkNavigationActivity", "showLongTimeDialog finish");
            NearLinkNavigationActivity.this.finish();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            int seconds = ((int) TimeUnit.MILLISECONDS.toSeconds(j10)) + 1;
            this.f19956a.setText(NearLinkNavigationActivity.this.getResources().getQuantityString(R$plurals.precision_navigate_too_long_exit, seconds, Integer.valueOf(seconds)));
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.nearlink.ui.NearLinkNavigationActivity$f */
    public class C4355f extends AbstractC9478g {

        /* renamed from: com.huawei.android.remotecontrol.nearlink.ui.NearLinkNavigationActivity$f$a */
        public class a implements NearLinkNavigationCallback {
            public a() {
            }

            /* renamed from: b */
            public final /* synthetic */ void m26365b(NearLinkNavigationResult nearLinkNavigationResult, int i10) {
                NearLinkNavigationActivity.this.f19892H0 = new Date().getTime();
                NearLinkNavigationActivity.this.f19942v0 = true;
                if (nearLinkNavigationResult != null) {
                    NearLinkNavigationActivity.this.m26347s3(nearLinkNavigationResult, i10);
                    NearLinkNavigationActivity.this.m26326Y2(nearLinkNavigationResult);
                } else {
                    C13981a.m83989i("NearLinkNavigationActivity", "startNearLinkNavigation nearLinkNavigationResult is null");
                    NearLinkNavigationActivity.this.f19909V = 0;
                    NearLinkNavigationActivity.this.m26336i3(0, i10);
                }
            }

            @Override // com.huawei.hms.findnetwork.comm.request.callback.NearLinkNavigationCallback
            public void onFail(int i10, String str) {
                NearLinkNavigationActivity.this.f19942v0 = false;
                C13981a.m83989i("NearLinkNavigationActivity", "startNearLinkNavigation onFail errorCode:" + i10 + ", msg: " + str);
                NearLinkNavigationActivity.this.f19909V = 0;
            }

            @Override // com.huawei.hms.findnetwork.comm.request.callback.NearLinkNavigationCallback
            public void onRangingResult(final int i10, final NearLinkNavigationResult nearLinkNavigationResult) {
                C13981a.m83989i("NearLinkNavigationActivity", "startNearLinkNavigation errorCode:" + i10);
                C0226l0.m1584d(new Runnable() { // from class: mf.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f53335a.m26365b(nearLinkNavigationResult, i10);
                    }
                });
            }

            @Override // com.huawei.hms.findnetwork.comm.request.callback.NearLinkNavigationCallback
            public void onSuccess() {
                C13981a.m83989i("NearLinkNavigationActivity", "startNearLinkNavigation onSuccess");
                NearLinkNavigationActivity.this.f19909V = 0;
            }
        }

        public C4355f() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                FindNetwork.getFindNetworkEngine(NearLinkNavigationActivity.this.f19929p).startNearLinkNavigation(NearLinkNavigationActivity.this.f19929p, NearLinkNavigationActivity.this.f19900M, new a());
            } catch (Exception e10) {
                C13981a.m83989i("NearLinkNavigationActivity", "startNearLinkNavigation onFail String:" + e10);
                NearLinkNavigationActivity.this.f19942v0 = false;
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.nearlink.ui.NearLinkNavigationActivity$g */
    public class C4356g extends BroadcastReceiver {
        public C4356g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || context == null) {
                C13981a.m83988e("NearLinkNavigationActivity", "intent or context is empty");
                return;
            }
            C13981a.m83989i("NearLinkNavigationActivity", "process upgrade broadcast");
            if ("com.huawei.hicloud.intent.action.APP_FOREGROUND_TO_BACKGROUND".equals(intent.getAction())) {
                boolean unused = NearLinkNavigationActivity.f19865T0 = false;
                C4359j c4359j = new C4359j(NearLinkNavigationActivity.this, null);
                try {
                    if (NearLinkNavigationActivity.this.f19888F0 == null) {
                        NearLinkNavigationActivity.this.f19888F0 = new Timer();
                    }
                    NearLinkNavigationActivity.this.f19888F0.schedule(c4359j, 1L);
                } catch (Exception e10) {
                    C13981a.m83989i("NearLinkNavigationActivity", "pageTimer err:" + e10.getMessage());
                }
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.nearlink.ui.NearLinkNavigationActivity$h */
    public class C4357h extends TimerTask {
        public C4357h() {
        }

        /* renamed from: c */
        public final /* synthetic */ void m26367c() {
            NearLinkNavigationActivity.this.m26299B2();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C13981a.m83989i("NearLinkNavigationActivity", "delayConnectTask start");
            if (new Date().getTime() - NearLinkNavigationActivity.this.f19892H0 >= 5000) {
                C13981a.m83989i("NearLinkNavigationActivity", "delayConnectTask time out");
                C0226l0.m1584d(new Runnable() { // from class: mf.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f53338a.m26367c();
                    }
                });
            }
        }

        public /* synthetic */ C4357h(NearLinkNavigationActivity nearLinkNavigationActivity, C4350a c4350a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.nearlink.ui.NearLinkNavigationActivity$i */
    public static class C4358i extends TimerTask {

        /* renamed from: a */
        public final Handler f19962a;

        public C4358i(Handler handler) {
            this.f19962a = handler;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Handler handler = this.f19962a;
            if (handler != null) {
                handler.obtainMessage(1).sendToTarget();
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.nearlink.ui.NearLinkNavigationActivity$j */
    public class C4359j extends TimerTask {
        public C4359j() {
        }

        /* renamed from: c */
        public final /* synthetic */ void m26369c() {
            NearLinkNavigationActivity.this.m26346s2();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C13981a.m83989i("NearLinkNavigationActivity", "PageTimerOutTask run");
            C0226l0.m1584d(new Runnable() { // from class: mf.q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f53339a.m26369c();
                }
            });
        }

        public /* synthetic */ C4359j(NearLinkNavigationActivity nearLinkNavigationActivity, C4350a c4350a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.nearlink.ui.NearLinkNavigationActivity$k */
    public static class HandlerC4360k extends Handler {

        /* renamed from: a */
        public final WeakReference<NearLinkNavigationActivity> f19964a;

        public /* synthetic */ HandlerC4360k(NearLinkNavigationActivity nearLinkNavigationActivity, C4350a c4350a) {
            this(nearLinkNavigationActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            NearLinkNavigationActivity nearLinkNavigationActivity = this.f19964a.get();
            if (nearLinkNavigationActivity == null || nearLinkNavigationActivity.isFinishing()) {
                C13981a.m83990w("NearLinkNavigationActivity", "activity null or isFinishing");
                return;
            }
            C13981a.m83989i("NearLinkNavigationActivity", "handleMessage: " + message.what);
            if (1 == message.what) {
                nearLinkNavigationActivity.m26344q3();
            }
        }

        public HandlerC4360k(NearLinkNavigationActivity nearLinkNavigationActivity) {
            super(Looper.getMainLooper());
            this.f19964a = new WeakReference<>(nearLinkNavigationActivity);
        }
    }

    /* renamed from: L2 */
    private void m26261L2() {
        C13981a.m83989i("NearLinkNavigationActivity", "initView");
        f19861P0 = false;
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f19900M = safeIntent.getStringExtra("TagSN");
        this.f19901N = safeIntent.getStringExtra("itemName");
        this.f19904Q = safeIntent.getStringExtra("subModelId");
        this.f19907T = safeIntent.getStringExtra("iconUrl");
        this.f19903P = safeIntent.getStringExtra("modelId");
        this.f19905R = safeIntent.getBooleanExtra("mainDevice", false);
        this.f19906S = safeIntent.getBooleanExtra("mainDeviceOnline", false);
        this.f19902O = safeIntent.getIntExtra("componentType", 0);
        m26316K2(this);
        this.f19879B = C12809f.m76829b(this, R$id.relat_outside);
        this.f19881C = C12809f.m76829b(this, R$id.relat_inside);
        View viewM76829b = C12809f.m76829b(this, R$id.sounding_im_bu);
        this.f19937t = viewM76829b;
        viewM76829b.setOnClickListener(this);
        m26335h3(true);
        this.f19939u = C12809f.m76829b(this, R$id.sounding_im_bu_bg);
        C12809f.m76829b(this, R$id.cancel_im_bu).setOnClickListener(this);
        this.f19941v = C12809f.m76829b(this, R$id.cancel_im_bu_bg);
        this.f19943w = (TextView) C12809f.m76829b(this, R$id.tv_operate);
        this.f19945x = C12809f.m76829b(this, R$id.icon_near_link);
        this.f19878A0 = (NearLinkBlueView) C12809f.m76829b(this, R$id.blue_circle);
        this.f19880B0 = (SingleSearchingRippleView) C12809f.m76829b(this, R$id.ripple_view);
        this.f19947y = C12809f.m76829b(this, R$id.navigate_arrow_bell);
        this.f19893I = C12809f.m76829b(this, R$id.gif_img);
        this.f19933r = (CircularRippleView) C12809f.m76829b(this, R$id.arrowhead_im);
        m26315J2();
        this.f19883D = (TextView) C12809f.m76829b(this, R$id.first_basic_tv);
        this.f19885E = (TextView) C12809f.m76829b(this, R$id.second_basic_tv);
        this.f19887F = (TextView) C12809f.m76829b(this, R$id.second_change_tv);
        this.f19889G = (TextView) C12809f.m76829b(this, R$id.third_tv);
        this.f19882C0 = (TextView) C12809f.m76829b(this, R$id.tv_flash_light);
        this.f19884D0 = C12809f.m76829b(this, R$id.img_flash_light);
        this.f19886E0 = (TextView) C12809f.m76829b(this, R$id.tv_angle_computing);
        ((TextView) C12809f.m76829b(this, R$id.tv_user_item_name)).setText(this.f19901N);
        this.f19891H = C12809f.m76829b(this, R$id.tag_detail);
        m26313I2();
        this.f19949z = C12809f.m76829b(this, R$id.navigate_arrow_calibration);
        this.f19899L = C12809f.m76829b(this, R$id.near_link_small_arrow);
        this.f19877A = C12809f.m76829b(this, R$id.nearlink_back_circle);
        this.f19930p0 = (NearLinkCircle) C12809f.m76829b(this, R$id.nearlink_circle);
        this.f19935s = (CircleRing) C12809f.m76829b(this, R$id.circle_ring);
        this.f19928o0 = C9097b.m57301k(this.f19903P);
        this.f19895J = C12809f.m76829b(this, R$id.rotation_navigation);
        this.f19897K = (TextView) C12809f.m76829b(this, R$id.hints_text);
        this.f19945x.setVisibility(8);
        m26297A2();
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0) {
            C13981a.m83988e("NearLinkNavigationActivity", "PERMISSION_DENIED");
            this.f19894I0 = new Date().getTime();
            C13299a.m79751c(this, new String[]{"android.permission.CAMERA"}, 1);
        } else {
            C13981a.m83989i("NearLinkNavigationActivity", "PERMISSION_GRANTED");
            m26342o3();
        }
        this.f19880B0.setMaxOpacity(0.3d);
        if (C11690w.m69742w(this.f19900M)) {
            m26300B3();
        }
        C13981a.m83989i("NearLinkNavigationActivity", "initView End");
    }

    /* renamed from: U2 */
    public static /* synthetic */ void m26271U2(Exception exc) {
        C13981a.m83988e("NearLinkNavigationActivity", "startSound error：" + exc.getMessage());
    }

    /* renamed from: W2 */
    public static /* synthetic */ void m26274W2(Exception exc) {
        C13981a.m83988e("NearLinkNavigationActivity", "stopSound error：" + exc.getMessage());
    }

    /* renamed from: A2 */
    public final void m26297A2() {
        C13981a.m83989i("NearLinkNavigationActivity", "connecting");
        this.f19895J.setVisibility(0);
        C11692y.m69749d(this.f19895J);
        m26351u3();
        m26353v3();
        m26349t3();
        m26361z3();
        m26311H2();
        this.f19883D.setText(getString(R$string.device_connecting));
        this.f19885E.setVisibility(4);
        this.f19887F.setVisibility(8);
        this.f19889G.setVisibility(4);
        this.f19897K.setVisibility(0);
        this.f19943w.setText(getString(R$string.is_looking_for));
        this.f19945x.setVisibility(8);
        this.f19934r0 = true;
    }

    /* renamed from: A3 */
    public final void m26298A3() {
        this.f19895J.setVisibility(8);
        C11692y.m69750e(this.f19895J);
        this.f19934r0 = false;
    }

    /* renamed from: B2 */
    public final void m26299B2() {
        C13981a.m83989i("NearLinkNavigationActivity", "disconnected");
        m26351u3();
        m26353v3();
        m26311H2();
        this.f19878A0.setVisibility(8);
        this.f19878A0.stop();
        m26298A3();
        m26349t3();
        this.f19880B0.setVisibility(0);
        this.f19880B0.start();
        this.f19891H.setVisibility(8);
        this.f19883D.setText(getString(R$string.device_connecting));
        this.f19885E.setVisibility(4);
        this.f19887F.setVisibility(8);
        this.f19889G.setVisibility(4);
        this.f19897K.setVisibility(8);
        this.f19943w.setText(getString(R$string.is_looking_for));
        this.f19945x.setVisibility(8);
        C13981a.m83989i("NearLinkNavigationActivity", "disconnected end");
    }

    /* renamed from: B3 */
    public final void m26300B3() {
        this.f19911X = false;
        this.f19935s.stop();
        m26341n3();
        C13981a.m83989i("NearLinkNavigationActivity", "to stopSound");
        C0225l.m1577a(new InterfaceC14356c() { // from class: mf.k
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return this.f53331a.m26325V2();
            }
        }, new Consumer() { // from class: mf.l
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                NearLinkNavigationActivity.m26274W2((Exception) obj);
            }
        });
    }

    /* renamed from: C2 */
    public final void m26301C2(float f10) {
        C13981a.m83987d("NearLinkNavigationActivity", "isRotating: " + this.f19916c0);
        if (this.f19916c0) {
            return;
        }
        this.f19916c0 = true;
        float fM69756f = C11693z.m69756f(this.f19917d0, f10);
        RotateAnimation rotateAnimationM69755e = C11693z.m69755e(this.f19917d0, fM69756f);
        this.f19917d0 = fM69756f;
        this.f19925l0.postDelayed(new Runnable() { // from class: mf.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f53332a.m26317M2();
            }
        }, rotateAnimationM69755e.getDuration());
        rotateAnimationM69755e.setFillAfter(true);
        this.f19947y.startAnimation(rotateAnimationM69755e);
    }

    /* renamed from: C3 */
    public final void m26302C3() {
        if ((C11829c.m70502B0(this) || C11829c.m70499A0(this)) && this.f19926m0 == null) {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setMessage(R$string.suggest_use_in_fullscreen).setPositiveButton(R$string.phonefinder_dialog_know, new DialogInterface.OnClickListener() { // from class: mf.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    dialogInterface.dismiss();
                }
            }).setCancelable(true).create();
            this.f19926m0 = alertDialogCreate;
            alertDialogCreate.setCanceledOnTouchOutside(false);
            this.f19926m0.show();
        }
    }

    /* renamed from: D2 */
    public final AnimationSet m26303D2() {
        return (AnimationSet) AnimationUtils.loadAnimation(this, R$anim.heart_beat_anim);
    }

    /* renamed from: D3 */
    public final void m26304D3() {
        BluetoothStatueReceiver bluetoothStatueReceiver = this.f19932q0;
        if (bluetoothStatueReceiver != null) {
            unregisterReceiver(bluetoothStatueReceiver);
        }
    }

    /* renamed from: E2 */
    public final String m26305E2(String str) {
        return getResources().getQuantityString(R$plurals.great_distance, C0241z.m1685c(str), new DecimalFormat("#.#").format(Float.parseFloat(str)));
    }

    /* renamed from: E3 */
    public void m26306E3(Context context) {
        C13981a.m83989i("NearLinkNavigationActivity", "unregisterReceiver");
        if (this.f19898K0 != null) {
            C13108a.m78878b(context).m78883f(this.f19898K0);
        }
    }

    /* renamed from: F2 */
    public final void m26307F2() {
        C13981a.m83989i("NearLinkNavigationActivity", "IsBell: " + C11464r.m68568a());
        if (C11464r.m68568a()) {
            m26335h3(true);
            return;
        }
        this.f19937t.clearAnimation();
        this.f19937t.setVisibility(8);
        if (this.f19940u0.equals(getString(R$string.try_playing_ringtone))) {
            this.f19885E.setVisibility(4);
            this.f19887F.setVisibility(8);
        }
    }

    /* renamed from: F3 */
    public final void m26308F3() {
        C13981a.m83989i("NearLinkNavigationActivity", "updateExitBlueView");
        this.f19878A0.setVisibility(0);
        this.f19878A0.stop();
        this.f19878A0.initOuterAnimatorVanishedScreen();
        this.f19878A0.start();
    }

    /* renamed from: G2 */
    public final void m26309G2() {
        C13981a.m83989i("NearLinkNavigationActivity", "initBlackView");
        this.f19878A0.setVisibility(0);
        this.f19878A0.stop();
        this.f19878A0.initBlackScreen();
        this.f19878A0.start();
    }

    /* renamed from: G3 */
    public final void m26310G3() {
        C13981a.m83989i("NearLinkNavigationActivity", "updateFullBlueView");
        this.f19878A0.setVisibility(0);
        this.f19878A0.stop();
        this.f19878A0.initOuterAnimatorFullScreen();
        this.f19878A0.start();
    }

    /* renamed from: H2 */
    public final void m26311H2() {
        C13981a.m83989i("NearLinkNavigationActivity", "initDark");
        m26309G2();
        m26330c3(getDrawable(R$drawable.precicion_navigation_imbu_bg));
    }

    /* renamed from: H3 */
    public final void m26312H3(int i10, int i11) {
        if (i10 != 1) {
            this.f19884D0.setVisibility(8);
            this.f19882C0.setVisibility(8);
            return;
        }
        if (i11 == 907201306) {
            this.f19884D0.setVisibility(0);
            this.f19882C0.setVisibility(0);
            this.f19930p0.setVisibility(8);
            this.f19949z.setVisibility(8);
            this.f19877A.setVisibility(8);
            this.f19899L.setVisibility(8);
            this.f19931q = new Date().getTime();
        }
        if (new Date().getTime() - this.f19931q < 3000) {
            C13981a.m83989i("NearLinkNavigationActivity", "light show time < 3000, not need gone");
            return;
        }
        this.f19884D0.setVisibility(8);
        this.f19882C0.setVisibility(8);
        this.f19930p0.setVisibility(0);
        this.f19949z.setVisibility(0);
        this.f19877A.setVisibility(0);
        this.f19899L.setVisibility(0);
        this.f19931q = 0L;
    }

    /* renamed from: I2 */
    public final void m26313I2() {
        C13981a.m83989i("NearLinkNavigationActivity", "initDeviceIconDetail");
        C13981a.m83989i("NearLinkNavigationActivity", "mDeviceIcon：" + this.f19907T);
        if (!TextUtils.isEmpty(this.f19907T)) {
            C12515a.m75110o().m75172d(new C4350a());
        } else {
            this.f19891H.setImageResource(R$drawable.nearlink_default);
            C13981a.m83988e("NearLinkNavigationActivity", "initDeviceIconDetail no icon url！");
        }
    }

    /* renamed from: I3 */
    public final void m26314I3(float f10) {
        C13981a.m83989i("NearLinkNavigationActivity", "updateSingleBlueView");
        this.f19878A0.setVisibility(0);
        this.f19878A0.stop();
        this.f19878A0.initOuterAnimatorWithPercent(f10);
        this.f19878A0.start();
    }

    /* renamed from: J2 */
    public final void m26315J2() {
        if (C11842p.m70762R0()) {
            ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R$id.first_copywriting);
            constraintLayout.setPadding(constraintLayout.getPaddingLeft(), (int) TypedValue.applyDimension(1, f19871Z0, getResources().getDisplayMetrics()), constraintLayout.getPaddingRight(), constraintLayout.getPaddingBottom());
            ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById(R$id.constraint_icon);
            int iApplyDimension = (int) TypedValue.applyDimension(1, f19872a1, getResources().getDisplayMetrics());
            int iApplyDimension2 = (int) TypedValue.applyDimension(1, f19873b1, getResources().getDisplayMetrics());
            int iApplyDimension3 = (int) TypedValue.applyDimension(1, f19874c1, getResources().getDisplayMetrics());
            constraintLayout2.setPadding(iApplyDimension3, iApplyDimension, iApplyDimension3, iApplyDimension2);
        }
    }

    /* renamed from: K2 */
    public void m26316K2(Context context) {
        C13981a.m83989i("NearLinkNavigationActivity", "initReceiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.intent.action.APP_FOREGROUND_TO_BACKGROUND");
        if (this.f19898K0 != null) {
            C13108a.m78878b(context).m78880c(this.f19898K0, intentFilter);
        }
    }

    /* renamed from: M2 */
    public final /* synthetic */ void m26317M2() {
        this.f19916c0 = false;
    }

    /* renamed from: N2 */
    public final /* synthetic */ void m26318N2(CountDownTimer countDownTimer, View view) {
        C13981a.m83989i("NearLinkNavigationActivity", "showLongTimeDialog click continue");
        countDownTimer.cancel();
        this.f19936s0.dismiss();
        C11690w.m69700W(this.f19900M, "nearLinkOperation", "nearLinkBusiness", "showLongTimeDialog click continue", "0", null);
        this.f19925l0.postDelayed(new RunnableC11454h(this), 600000L);
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hidisk.remotecontrol.intent.REFRESH_PORTAL_LOGIN"));
    }

    /* renamed from: O2 */
    public final /* synthetic */ void m26319O2(DialogInterface dialogInterface) {
        Button button = this.f19936s0.getButton(-1);
        Button button2 = this.f19936s0.getButton(-2);
        final CountDownTimer countDownTimerStart = new CountDownTimerC4354e(5000L, 1000L, button).start();
        button2.setOnClickListener(new View.OnClickListener() { // from class: mf.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f53324a.m26318N2(countDownTimerStart, view);
            }
        });
    }

    /* renamed from: P2 */
    public final /* synthetic */ void m26320P2(DialogInterface dialogInterface, int i10) {
        C13981a.m83989i("NearLinkNavigationActivity", "showLongTimeDialog click cancel");
        C11690w.m69700W(this.f19900M, "nearLinkOperation", "nearLinkBusiness", "showLongTimeDialog click cancel", "0", null);
        finish();
    }

    /* renamed from: Q2 */
    public final /* synthetic */ void m26321Q2(DialogInterface dialogInterface, int i10) {
        C13981a.m83989i("NearLinkNavigationActivity", "dialog positive");
        f19861P0 = true;
        C11829c.m70570d1(this, 2);
    }

    /* renamed from: R2 */
    public final /* synthetic */ void m26322R2(DialogInterface dialogInterface, int i10) {
        C13981a.m83989i("NearLinkNavigationActivity", "dialog cancel");
        setResult(0);
        finish();
    }

    /* renamed from: S2 */
    public final /* synthetic */ void m26323S2(DialogInterface dialogInterface) {
        C13981a.m83989i("NearLinkNavigationActivity", "dialog dismiss");
        this.f19909V = 0;
        finish();
    }

    /* renamed from: T2 */
    public final /* synthetic */ Task m26324T2() throws Exception {
        return FindNetwork.getFindNetworkEngine((Activity) this).startSound(this.f19900M, true, new C4352c());
    }

    /* renamed from: V2 */
    public final /* synthetic */ Task m26325V2() throws Exception {
        return FindNetwork.getFindNetworkEngine((Activity) this).stopSound(this.f19900M, true, new C4353d());
    }

    /* renamed from: Y2 */
    public final void m26326Y2(NearLinkNavigationResult nearLinkNavigationResult) {
        try {
            C13981a.m83989i("NearLinkNavigationActivity", "startNearLinkNavigation result, stage: " + nearLinkNavigationResult.getStage() + ", distance: " + nearLinkNavigationResult.getDistance() + ", angle: " + nearLinkNavigationResult.getAngle() + ", angleAccuracy: " + nearLinkNavigationResult.getAngleAccuracy() + ", direction: " + nearLinkNavigationResult.getDirection() + ", duration: " + nearLinkNavigationResult.getDuration() + ", trackQuality: " + nearLinkNavigationResult.getTrackQuality());
        } catch (Exception unused) {
            C13981a.m83988e("NearLinkNavigationActivity", "startNearLinkNavigation exception");
        }
    }

    /* renamed from: Z2 */
    public final void m26327Z2(float f10) {
        RotateAnimation rotateAnimationM69755e = C11693z.m69755e(this.f19917d0, f10);
        this.f19917d0 = f10;
        rotateAnimationM69755e.setFillAfter(true);
        this.f19899L.startAnimation(rotateAnimationM69755e);
    }

    /* renamed from: a3 */
    public final void m26328a3() {
        try {
            this.f19932q0 = new BluetoothStatueReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("huawei.sle.adapter.action.SLE_STATE_CHANGED");
            registerReceiver(this.f19932q0, intentFilter);
        } catch (Exception e10) {
            C13981a.m83988e("NearLinkNavigationActivity", "registerBluetoothReceiver error:" + e10.getMessage());
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration.fontScale > 1.75f) {
            configuration.fontScale = 1.75f;
        }
        super.attachBaseContext(context.createConfigurationContext(configuration));
    }

    /* renamed from: b3 */
    public final void m26329b3(NearLinkNavigationResult nearLinkNavigationResult) {
        C13981a.m83989i("NearLinkNavigationActivity", "searchingState");
        m26353v3();
        m26356x2();
        m26298A3();
        m26349t3();
        if (Float.parseFloat(C11693z.m69751a(nearLinkNavigationResult.getDistance())) > this.f19948y0) {
            this.f19947y.setVisibility(0);
            this.f19933r.setVisibility(0);
            this.f19893I.setVisibility(0);
            this.f19933r.setVisibility(0);
            this.f19933r.start();
            m26301C2(nearLinkNavigationResult.getAngle());
            m26361z3();
        } else {
            m26351u3();
            this.f19880B0.setVisibility(0);
            this.f19880B0.start();
            this.f19891H.setVisibility(0);
        }
        C13981a.m83989i("NearLinkNavigationActivity", "searchingState end");
    }

    /* renamed from: c3 */
    public final void m26330c3(Drawable drawable) {
        this.f19939u.setBackground(drawable);
        this.f19941v.setBackground(drawable);
    }

    /* renamed from: d3 */
    public final void m26331d3(Context context) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        int i10 = resources.getDisplayMetrics().densityDpi;
        int i11 = DisplayMetrics.DENSITY_DEVICE_STABLE;
        if (i10 >= i11) {
            configuration.densityDpi = i11;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
    }

    /* renamed from: e3 */
    public void m26332e3(int i10, float f10, String str, int i11) throws NumberFormatException {
        C13981a.m83989i("NearLinkNavigationActivity", "setFirstTv state：" + i10 + " | distance: " + str);
        float f11 = Float.parseFloat(str);
        String string = i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? getString(R$string.device_connecting) : getString(R$string.device_connecting) : f11 > this.f19948y0 ? getString(f19857L0.get(Integer.valueOf(C11693z.m69753c(f10))).intValue(), getResources().getQuantityString(R$plurals.great_distance, C0241z.m1685c(str), new DecimalFormat("#.#").format(f11))) : getString(R$string.nearby_location) : m26305E2(str) : i11 == f19858M0 ? getString(R$string.nearby_location) : i11 == f19859N0 ? getString(R$string.strong_signal) : i11 == f19860O0 ? getString(R$string.weak_signal) : f11 < 0.0f ? getString(R$string.device_connecting) : (f11 < 0.0f || f11 > this.f19948y0) ? m26305E2(str) : getString(R$string.nearby_location);
        if (this.f19911X) {
            this.f19938t0 = getString(R$string.device_ringed);
        } else {
            this.f19938t0 = string;
        }
        C13981a.m83989i("NearLinkNavigationActivity", "firstLinePrompts：" + this.f19938t0);
        this.f19883D.setText(this.f19938t0);
    }

    /* renamed from: f3 */
    public void m26333f3(int i10, int i11, float f10) {
        if (this.f19911X) {
            this.f19897K.setVisibility(8);
            return;
        }
        if (i10 != 0) {
            this.f19897K.setVisibility(8);
            return;
        }
        if (i11 < 0 && f10 < 0.0f) {
            this.f19897K.setVisibility(0);
            return;
        }
        if (i11 == f19858M0 || i11 == f19859N0 || i11 == f19860O0 || f10 >= 0.0f) {
            this.f19897K.setVisibility(8);
        } else {
            this.f19897K.setVisibility(0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void finish() {
        C13981a.m83989i("NearLinkNavigationActivity", "finish isSetting=" + f19861P0);
        Timer timer = this.f19888F0;
        if (timer != null) {
            timer.cancel();
            this.f19888F0 = null;
        }
        Timer timer2 = this.f19890G0;
        if (timer2 != null) {
            timer2.cancel();
            this.f19890G0 = null;
        }
        if (f19861P0) {
            return;
        }
        m26359y3();
        if (this.f19911X) {
            m26300B3();
        }
        this.f19880B0.setVisibility(8);
        this.f19880B0.stop();
        this.f19933r.setVisibility(8);
        this.f19933r.stop();
        m26357x3();
        this.f19935s.stop();
        this.f19925l0.removeCallbacksAndMessages(null);
        Intent intent = new Intent();
        intent.putExtra("tagSn", this.f19900M);
        setResult(this.f19909V, intent);
        C11690w.m69700W(this.f19900M, "nearLinkOperation", "nearLinkBusiness", "nearLinkNavigation finish nearLinkNaviResultCode: " + this.f19909V + ", duringTime: " + (System.currentTimeMillis() - this.f19908U), String.valueOf(this.f19909V), null);
        super.finish();
    }

    /* renamed from: g3 */
    public void m26334g3(int i10, String str, int i11) throws NumberFormatException {
        C13981a.m83989i("NearLinkNavigationActivity", "setSecondTv state：" + i10 + " | distance: " + str + "direction:" + i11);
        int i12 = R$string.from_distance_text;
        String string = getString(i12);
        if (i10 != 0) {
            if (i10 == 1) {
                string = getString(R$string.lift_your_phone);
            } else if (i10 == 2 && Float.parseFloat(str) <= this.f19948y0) {
                string = getString(R$string.try_playing_ringtone);
            }
        } else if (i11 == f19859N0 || i11 == f19860O0) {
            string = getString(R$string.walk_around);
        } else if (i11 == f19858M0) {
            string = getString(R$string.try_playing_ringtone);
        } else {
            float f10 = Float.parseFloat(str);
            if (f10 < 0.0f) {
                string = getString(i12);
            } else if (f10 >= 0.0f && f10 <= f19870Y0) {
                string = getString(R$string.try_playing_ringtone);
            }
        }
        if (this.f19911X) {
            this.f19940u0 = getString(R$string.playing_ringtone);
        } else {
            this.f19940u0 = string;
        }
        C13981a.m83989i("NearLinkNavigationActivity", "secondLinePrompts：" + this.f19940u0);
        if (this.f19940u0.equals(getString(R$string.moving_current_direction)) || this.f19940u0.equals(getString(R$string.walk_around)) || this.f19940u0.equals(getString(R$string.lift_your_phone))) {
            this.f19885E.setVisibility(8);
            this.f19887F.setVisibility(0);
            this.f19887F.setText(this.f19940u0);
        } else if (this.f19940u0.equals(getString(i12))) {
            this.f19885E.setVisibility(4);
            this.f19887F.setVisibility(8);
        } else {
            this.f19887F.setVisibility(8);
            this.f19885E.setVisibility(0);
            this.f19885E.setText(this.f19940u0);
        }
    }

    /* renamed from: h3 */
    public final void m26335h3(boolean z10) {
        if (z10) {
            this.f19937t.setEnabled(true);
            this.f19937t.setAlpha(1.0f);
            m26341n3();
        } else {
            this.f19937t.setEnabled(false);
            this.f19937t.setAlpha(0.3f);
            m26357x3();
        }
    }

    /* renamed from: i3 */
    public void m26336i3(int i10, int i11) {
        if (this.f19911X) {
            this.f19889G.setVisibility(4);
            return;
        }
        this.f19889G.setVisibility(4);
        String string = getString(R$string.lift_your_phone);
        if (i11 == 907201306) {
            this.f19889G.setVisibility(8);
            string = getString(R$string.environment_not_requirements);
        }
        if (i11 == 907201157) {
            this.f19889G.setVisibility(0);
            this.f19909V = ErrorCode.CODE_DEVICE_BUSY;
            finish();
        } else {
            C13981a.m83989i("NearLinkNavigationActivity", "thirdTv：" + string);
            this.f19889G.setText(string);
        }
    }

    /* renamed from: j3 */
    public final void m26337j3(float f10) {
        this.f19910W = false;
        m26353v3();
        m26298A3();
        m26351u3();
        m26314I3(f10);
        this.f19880B0.setVisibility(0);
        this.f19880B0.start();
        this.f19891H.setVisibility(8);
    }

    /* renamed from: k3 */
    public final void m26338k3() throws Resources.NotFoundException {
        C13981a.m83989i("NearLinkNavigationActivity", "showLongTimeDialog");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(R$string.bluetooth_navigate_too_long_title).setMessage(getResources().getQuantityString(R$plurals.bluetooth_navigate_too_long_detail_device, 5, 5)).setPositiveButton(getResources().getQuantityString(R$plurals.precision_navigate_too_long_exit, 5, 5), new DialogInterface.OnClickListener() { // from class: mf.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f53322a.m26320P2(dialogInterface, i10);
            }
        }).setNegativeButton(R$string.precision_navigate_too_long_use, (DialogInterface.OnClickListener) null).create();
        this.f19936s0 = alertDialogCreate;
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: mf.c
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f53323a.m26319O2(dialogInterface);
            }
        });
        this.f19936s0.setCanceledOnTouchOutside(false);
        this.f19936s0.show();
        C11690w.m69700W(this.f19900M, "nearLinkOperation", "nearLinkBusiness", "showLongTimeDialog", "0", null);
    }

    /* renamed from: l3 */
    public void m26339l3() {
        C13981a.m83989i("NearLinkNavigationActivity", "show permission dialog");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(R$string.cloud_space_camera_permission).setMessage(R$string.camera_permissions).setPositiveButton(R$string.set_permission, new DialogInterface.OnClickListener() { // from class: mf.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f53326a.m26321Q2(dialogInterface, i10);
            }
        }).setNegativeButton(R$string.cancel, new DialogInterface.OnClickListener() { // from class: mf.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f53327a.m26322R2(dialogInterface, i10);
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: mf.g
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f53328a.m26323S2(dialogInterface);
            }
        }).create();
        this.f19927n0 = alertDialogCreate;
        alertDialogCreate.show();
    }

    /* renamed from: m3 */
    public final void m26340m3() {
        this.f19886E0.setVisibility(0);
    }

    /* renamed from: n3 */
    public final void m26341n3() {
        if (this.f19912Y) {
            return;
        }
        this.f19912Y = true;
        this.f19937t.startAnimation(m26303D2());
    }

    /* renamed from: o3 */
    public final void m26342o3() {
        C13981a.m83989i("NearLinkNavigationActivity", "startNearLinkNavigation start");
        m26307F2();
        try {
            if (this.f19890G0 == null) {
                this.f19890G0 = new Timer();
            }
            this.f19890G0.schedule(new C4357h(this, null), 0L, 5000L);
        } catch (Exception e10) {
            C13981a.m83989i("NearLinkNavigationActivity", "delayTimer err:" + e10.getMessage());
        }
        C12515a.m75110o().m75175e(new C4355f(), false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 == 2) {
            if (-1 != i11) {
                if (i11 == 0) {
                    C13981a.m83989i("NearLinkNavigationActivity", "onActivityResult: RESULT_CANCELED");
                    finish();
                    return;
                }
                return;
            }
            C13981a.m83989i("NearLinkNavigationActivity", "onActivityResult: RESULT_OK");
            if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
                m26342o3();
                C13981a.m83989i("NearLinkNavigationActivity", "onActivityResult: Permission is granted");
            } else {
                C13981a.m83989i("NearLinkNavigationActivity", "onActivityResult: Permission is still denied ");
                finish();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (R$id.cancel_im_bu == id2) {
            C13981a.m83989i("NearLinkNavigationActivity", "cancel_im_bu");
            finish();
            return;
        }
        if (R$id.sounding_im_bu != id2 || C0209d.m1226Y0()) {
            return;
        }
        if (this.f19905R && this.f19906S) {
            C13981a.m83989i("NearLinkNavigationActivity", "Clicked startSound");
            m26343p3();
            m26357x3();
            this.f19935s.start();
            m26345r3();
            C11690w.m69700W(this.f19900M, "nearLinkRing", "nearLinkBusiness", "Clicked startSound", "0", null);
            return;
        }
        if (this.f19911X) {
            C13981a.m83989i("NearLinkNavigationActivity", "ancDevice Clicked stopSound");
            m26300B3();
            this.f19935s.stop();
            m26341n3();
            C11690w.m69700W(this.f19900M, "nearLinkRing", "nearLinkBusiness", "ancDevice Clicked stopSound", "0", null);
            return;
        }
        C13981a.m83989i("NearLinkNavigationActivity", "ancDevice Clicked startSound");
        m26343p3();
        m26357x3();
        this.f19935s.start();
        C11690w.m69700W(this.f19900M, "nearLinkRing", "nearLinkBusiness", "ancDevice Clicked startSound", "0", null);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setRequestedOrientation(!C0209d.m1249e1() ? 1 : 0);
        C11842p.m70717C0(this);
        m26302C3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m26331d3(this);
        setRequestedOrientation(!C0209d.m1249e1() ? 1 : 0);
        this.f19929p = this;
        this.f19950z0 = -1.0f;
        f19863R0 = new Date().getTime();
        C11842p.m70717C0(this);
        setContentView(R$layout.activity_nearlink_navigation);
        C13981a.m83989i("NearLinkNavigationActivity", "onCreate");
        this.f19908U = System.currentTimeMillis();
        this.f19924k0 = new HandlerC4360k(this, null);
        m26261L2();
        m26302C3();
        if (this.f19921h0 == null) {
            this.f19921h0 = new VibratorEx();
        }
        this.f19923j0 = this.f19921h0.isSupportHwVibrator("haptic.common.click");
        m26328a3();
        this.f19925l0.postDelayed(new RunnableC11454h(this), 600000L);
        if (C9733f.m60705z().m60758q() != null) {
            f19862Q0 = r3.getNearLinkMinIgnoreBleTime() * 1000;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        String str = "onDestroy, NearLinkNavigation during time: " + (System.currentTimeMillis() - this.f19908U);
        C13981a.m83989i("NearLinkNavigationActivity", str);
        super.onDestroy();
        m26352v2();
        m26304D3();
        m26306E3(this);
        AlertDialog alertDialog = this.f19927n0;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f19927n0.dismiss();
            this.f19927n0 = null;
        }
        AlertDialog alertDialog2 = this.f19936s0;
        if (alertDialog2 != null && alertDialog2.isShowing()) {
            this.f19936s0.dismiss();
            this.f19936s0 = null;
        }
        C11669b.m69675b();
        AlertDialog alertDialog3 = this.f19926m0;
        if (alertDialog3 != null && alertDialog3.isShowing()) {
            this.f19926m0.dismiss();
            this.f19926m0 = null;
        }
        C11690w.m69700W(this.f19900M, "nearLinkOperation", "nearLinkBusiness", str, "0", null);
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        C13981a.m83989i("NearLinkNavigationActivity", "onRequestPermissionsResult");
        if (i10 == 1) {
            if (iArr.length > 0 && iArr[0] == 0) {
                m26342o3();
            } else if (new Date().getTime() - this.f19894I0 > f19876e1) {
                finish();
            } else {
                m26339l3();
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C13981a.m83989i("NearLinkNavigationActivity", "onResume");
        f19861P0 = false;
        this.f19950z0 = -1.0f;
        f19863R0 = new Date().getTime();
        f19865T0 = true;
        f19864S0 = false;
    }

    /* renamed from: p3 */
    public final void m26343p3() {
        C13981a.m83989i("NearLinkNavigationActivity", "to startSound");
        m26357x3();
        this.f19935s.start();
        C0225l.m1577a(new InterfaceC14356c() { // from class: mf.i
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return this.f53330a.m26324T2();
            }
        }, new Consumer() { // from class: mf.j
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                NearLinkNavigationActivity.m26271U2((Exception) obj);
            }
        });
    }

    /* renamed from: q3 */
    public void m26344q3() {
        CircleRing circleRing = this.f19935s;
        if (circleRing != null) {
            circleRing.stop();
        }
        m26341n3();
    }

    /* renamed from: r3 */
    public void m26345r3() {
        m26352v2();
        Timer timer = new Timer();
        this.f19896J0 = timer;
        timer.schedule(new C4358i(this.f19924k0), 5000L);
    }

    /* renamed from: s2 */
    public final void m26346s2() {
        C13981a.m83989i("NearLinkNavigationActivity", "process isCurrent" + f19865T0);
        if (f19865T0) {
            return;
        }
        C13981a.m83989i("NearLinkNavigationActivity", "process isStop" + f19864S0);
        try {
            if (f19864S0) {
                return;
            }
            f19864S0 = true;
            C13981a.m83989i("NearLinkNavigationActivity", "process backGround");
            this.f19880B0.setVisibility(8);
            this.f19880B0.stop();
            this.f19933r.setVisibility(8);
            this.f19933r.stop();
            m26357x3();
            this.f19935s.stop();
            finish();
        } catch (Exception e10) {
            C13981a.m83988e("NearLinkNavigationActivity", "backGround error" + e10.getMessage());
            finish();
        }
    }

    /* renamed from: s3 */
    public void m26347s3(NearLinkNavigationResult nearLinkNavigationResult, int i10) {
        try {
            int stage = (int) nearLinkNavigationResult.getStage();
            float distance = nearLinkNavigationResult.getDistance();
            if (distance <= f19870Y0) {
                stage = 0;
            }
            C13981a.m83989i("NearLinkNavigationActivity", "stateChange stage：" + stage + " resultDistance：" + distance);
            if (stage < 0) {
                C13981a.m83989i("NearLinkNavigationActivity", "stateChange stage：" + stage);
                return;
            }
            if (stage == 0 && new Date().getTime() - f19863R0 < f19862Q0) {
                C13981a.m83989i("NearLinkNavigationActivity", "blue time inner");
                return;
            }
            float f10 = this.f19950z0;
            if (f10 == -1.0f || distance < f10) {
                this.f19948y0 = this.f19944w0;
            } else {
                this.f19948y0 = this.f19946x0;
            }
            String strM69751a = C11693z.m69751a(distance);
            float angleAccuracy = nearLinkNavigationResult.getAngleAccuracy();
            int direction = (int) nearLinkNavigationResult.getDirection();
            float angle = nearLinkNavigationResult.getAngle();
            Float fValueOf = Float.valueOf(angle);
            C13981a.m83989i("NearLinkNavigationActivity", "stateChange angle：" + fValueOf);
            m26332e3(stage, angle, strM69751a, direction);
            m26334g3(stage, strM69751a, direction);
            m26336i3(stage, i10);
            m26333f3(stage, direction, distance);
            m26360z2(stage, direction);
            this.f19913Z = true;
            f19875d1.add(Integer.valueOf(stage));
            this.f19950z0 = Float.parseFloat(strM69751a);
            if (stage == 0) {
                m26348t2(direction, angleAccuracy, distance);
                return;
            }
            if (stage == 1) {
                m26350u2(fValueOf, angleAccuracy, i10);
            } else if (stage == 2) {
                m26329b3(nearLinkNavigationResult);
            } else {
                if (stage != 3) {
                    return;
                }
                m26299B2();
            }
        } catch (Exception e10) {
            C13981a.m83988e("NearLinkNavigationActivity", "stateChange error：" + e10.getMessage());
        }
    }

    /* renamed from: t2 */
    public final void m26348t2(int i10, float f10, float f11) {
        C13981a.m83989i("NearLinkNavigationActivity", "direction:" + i10);
        if (i10 == f19859N0 || i10 == f19860O0) {
            m26337j3(f10);
            return;
        }
        if (i10 == f19858M0) {
            m26353v3();
            m26298A3();
            m26349t3();
            m26351u3();
            m26356x2();
            m26358y2();
            this.f19910W = false;
            return;
        }
        if (f11 < 0.0f) {
            C13981a.m83989i("NearLinkNavigationActivity", "isConnecting:" + this.f19934r0);
            if (this.f19934r0) {
                return;
            }
            m26297A2();
            return;
        }
        float fM69754d = C11693z.m69754d(f11);
        C13981a.m83989i("NearLinkNavigationActivity", "percent:" + fM69754d);
        this.f19910W = false;
        m26353v3();
        m26298A3();
        m26351u3();
        this.f19880B0.setVisibility(0);
        m26340m3();
        this.f19880B0.start();
        if (((int) fM69754d) != 1) {
            m26337j3(fM69754d);
            return;
        }
        this.f19891H.setVisibility(0);
        m26356x2();
        m26349t3();
        m26355w3();
    }

    /* renamed from: t3 */
    public final void m26349t3() {
        this.f19886E0.setVisibility(8);
    }

    /* renamed from: u2 */
    public final void m26350u2(Float f10, float f11, int i10) {
        C13981a.m83989i("NearLinkNavigationActivity", "calibration");
        List<Integer> list = f19875d1;
        int iIntValue = list.get(list.size() - 2).intValue();
        if (!this.f19910W) {
            m26354w2();
        }
        if (iIntValue == 0 || iIntValue == 2) {
            f19875d1.clear();
            f19875d1.add(1);
            return;
        }
        m26361z3();
        m26351u3();
        m26298A3();
        m26349t3();
        m26312H3(iIntValue, i10);
        BigDecimal bigDecimal = new BigDecimal(f11 / 2.0f);
        float fM69756f = C11693z.m69756f(this.f19917d0, f10.floatValue());
        m26327Z2(fM69756f);
        this.f19930p0.m26373d(new BigDecimal(fM69756f).subtract(bigDecimal).floatValue(), f11);
        C13981a.m83989i("NearLinkNavigationActivity", "calibration end");
    }

    /* renamed from: u3 */
    public final void m26351u3() {
        this.f19947y.setVisibility(8);
        this.f19893I.setVisibility(8);
        this.f19933r.setVisibility(8);
        this.f19933r.stop();
    }

    /* renamed from: v2 */
    public void m26352v2() {
        Timer timer = this.f19896J0;
        if (timer != null) {
            timer.cancel();
            this.f19896J0 = null;
        }
    }

    /* renamed from: v3 */
    public final void m26353v3() {
        this.f19949z.setVisibility(8);
        this.f19899L.setVisibility(8);
        this.f19877A.setVisibility(8);
        this.f19930p0.setVisibility(8);
    }

    /* renamed from: w2 */
    public final void m26354w2() {
        C13981a.m83989i("NearLinkNavigationActivity", "changeBgToDark");
        m26308F3();
        this.f19910W = true;
        m26330c3(getDrawable(R$drawable.precicion_navigation_imbu_bg));
    }

    /* renamed from: w3 */
    public final void m26355w3() {
        this.f19884D0.setVisibility(8);
        this.f19882C0.setVisibility(8);
    }

    /* renamed from: x2 */
    public final void m26356x2() {
        C13981a.m83989i("NearLinkNavigationActivity", "changeBgToLight");
        m26310G3();
        this.f19910W = false;
        m26330c3(getDrawable(R$drawable.precicion_navigation_imbu_bg_black));
    }

    /* renamed from: x3 */
    public final void m26357x3() {
        if (this.f19912Y) {
            this.f19912Y = false;
            this.f19937t.clearAnimation();
        }
    }

    /* renamed from: y2 */
    public final void m26358y2() {
        m26353v3();
        m26351u3();
        this.f19880B0.setVisibility(0);
        this.f19880B0.start();
        this.f19891H.setVisibility(0);
        m26298A3();
    }

    /* renamed from: y3 */
    public void m26359y3() {
        C13981a.m83989i("NearLinkNavigationActivity", "to stopNavigate");
        C12515a.m75110o().m75175e(new C4351b(), false);
    }

    /* renamed from: z2 */
    public final void m26360z2(int i10, int i11) {
        if (i10 != f19866U0) {
            this.f19943w.setText(getString(R$string.nearlink_find_device));
            this.f19945x.setVisibility(0);
        } else if (i11 == f19858M0 || i11 == f19859N0 || i11 == f19860O0) {
            this.f19943w.setText(getString(R$string.is_looking_for));
            this.f19945x.setVisibility(8);
        } else {
            this.f19943w.setText(getString(R$string.nearlink_find_device));
            this.f19945x.setVisibility(0);
        }
    }

    /* renamed from: z3 */
    public final void m26361z3() {
        this.f19880B0.setVisibility(8);
        this.f19880B0.stop();
        this.f19891H.setVisibility(8);
    }
}
