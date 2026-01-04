package com.huawei.android.remotecontrol.tag.p092ui;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import com.huawei.android.hicloud.p088ui.activity.BaseActivity;
import com.huawei.android.os.VibratorEx;
import com.huawei.android.remotecontrol.sdk.R$anim;
import com.huawei.android.remotecontrol.sdk.R$color;
import com.huawei.android.remotecontrol.sdk.R$drawable;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$plurals;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.tag.p092ui.PrecisionNavigationActivity;
import com.huawei.android.remotecontrol.tag.p092ui.view.ArrowDotView;
import com.huawei.android.remotecontrol.tag.p092ui.view.CircleRing;
import com.huawei.android.remotecontrol.tag.p092ui.view.SearchingRippleView;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.findnetwork.FindNetwork;
import com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback;
import com.huawei.hms.findnetwork.comm.request.bean.NavigationInfo;
import com.huawei.hms.findnetwork.comm.request.bean.SoundRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.TagStatus;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkConfigResult;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.ErrorCode;
import com.huawei.hms.p148ui.SafeIntent;
import eg.AbstractC9478g;
import huawei.android.widget.ImageView;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.function.Consumer;
import nf.C11690w;
import p015ak.C0209d;
import p015ak.C0225l;
import p227dg.C9097b;
import p227dg.C9120m0;
import p514o9.C11829c;
import p514o9.C11842p;
import p521og.C11880m;
import p616rk.C12515a;
import p655te.C13009a;
import p684un.C13222a;
import p684un.C13230i;
import p694v.C13299a;
import p709vj.C13452e;
import p809yg.C13981a;
import p851zp.InterfaceC14356c;
import p851zp.InterfaceC14358e;
import sg.C12797b;
import sk.C12809f;

/* loaded from: classes4.dex */
public class PrecisionNavigationActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: l0 */
    public static final Set<Integer> f20259l0 = new C4422a();

    /* renamed from: A */
    public ImageView f20260A;

    /* renamed from: B */
    public TextView f20261B;

    /* renamed from: C */
    public TextView f20262C;

    /* renamed from: D */
    public TextView f20263D;

    /* renamed from: E */
    public ImageView f20264E;

    /* renamed from: F */
    public String f20265F;

    /* renamed from: G */
    public String f20266G;

    /* renamed from: H */
    public String f20267H;

    /* renamed from: I */
    public int f20268I;

    /* renamed from: J */
    public String f20269J;

    /* renamed from: K */
    public String f20270K;

    /* renamed from: L */
    public long f20271L;

    /* renamed from: a0 */
    public Vibrator f20286a0;

    /* renamed from: b0 */
    public VibratorEx f20287b0;

    /* renamed from: g0 */
    public AlertDialog f20292g0;

    /* renamed from: i0 */
    public int f20294i0;

    /* renamed from: p */
    public Context f20297p;

    /* renamed from: q */
    public SearchingRippleView f20298q;

    /* renamed from: r */
    public ArrowDotView f20299r;

    /* renamed from: s */
    public CircleRing f20300s;

    /* renamed from: t */
    public View f20301t;

    /* renamed from: u */
    public View f20302u;

    /* renamed from: v */
    public View f20303v;

    /* renamed from: w */
    public TextView f20304w;

    /* renamed from: x */
    public TextView f20305x;

    /* renamed from: y */
    public View f20306y;

    /* renamed from: z */
    public ImageView f20307z;

    /* renamed from: M */
    public int f20272M = 0;

    /* renamed from: N */
    public boolean f20273N = true;

    /* renamed from: O */
    public boolean f20274O = true;

    /* renamed from: P */
    public boolean f20275P = false;

    /* renamed from: Q */
    public boolean f20276Q = false;

    /* renamed from: R */
    public boolean f20277R = false;

    /* renamed from: S */
    public boolean f20278S = false;

    /* renamed from: T */
    public boolean f20279T = false;

    /* renamed from: U */
    public boolean f20280U = false;

    /* renamed from: V */
    public boolean f20281V = false;

    /* renamed from: W */
    public volatile boolean f20282W = false;

    /* renamed from: X */
    public volatile float f20283X = 0.0f;

    /* renamed from: Y */
    public volatile int f20284Y = 0;

    /* renamed from: Z */
    public volatile int f20285Z = 1;

    /* renamed from: c0 */
    public int f20288c0 = 600;

    /* renamed from: d0 */
    public boolean f20289d0 = false;

    /* renamed from: e0 */
    public Handler f20290e0 = new Handler(Looper.myLooper());

    /* renamed from: f0 */
    public BluetoothStatueReceiver f20291f0 = null;

    /* renamed from: h0 */
    public boolean f20293h0 = false;

    /* renamed from: j0 */
    public final Runnable f20295j0 = new Runnable() { // from class: bg.y0
        @Override // java.lang.Runnable
        public final void run() {
            this.f5657a.m26780l3();
        }
    };

    /* renamed from: k0 */
    public Handler f20296k0 = new HandlerC4423b();

    public class BluetoothStatueReceiver extends BroadcastReceiver {
        public BluetoothStatueReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C13981a.m83988e("PrecisionNavigationActivity", "onReceive, intent is null");
            } else if (10 == new SafeIntent(intent).getIntExtra("android.bluetooth.adapter.extra.STATE", 0)) {
                C13981a.m83989i("PrecisionNavigationActivity", "onReceive, receiver bluetooth close");
                PrecisionNavigationActivity.this.f20272M = 11;
                PrecisionNavigationActivity.this.finish();
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.tag.ui.PrecisionNavigationActivity$a */
    public class C4422a extends HashSet<Integer> {
        public C4422a() {
            add(Integer.valueOf(ErrorCode.CODE_TAG_COMMAND_EXECUTE_FAIL));
            add(Integer.valueOf(ErrorCode.STATUS_ERROR_NOT_HAVE_PERMISSION_RECORD_AUDIO));
            add(Integer.valueOf(ErrorCode.STATUS_ERROR_NOT_SUPPORT_TAG_CURRENT_VERSION));
            add(Integer.valueOf(ErrorCode.CODE_DEVICE_BUSY));
            add(Integer.valueOf(ErrorCode.CODE_OTA));
            add(Integer.valueOf(ErrorCode.CODE_DECLINE_TAG_BLE_MEASURE));
            add(Integer.valueOf(ErrorCode.CODE_BLUETOOTH_PERMISSION_FAILED));
            add(Integer.valueOf(ErrorCode.CODE_LOCATION_PERMISSION_FAILED));
            add(Integer.valueOf(ErrorCode.STATUS_ERROR_MEASURERESULT_RUNING));
            add(Integer.valueOf(ErrorCode.STATUS_ERROR_START_AUDIO_RECORD_FAILED));
            add(Integer.valueOf(ErrorCode.CODE_DECLINE_TAG_SOUND));
            add(Integer.valueOf(ErrorCode.CODE_TAG_NOT_EXISTS));
            add(Integer.valueOf(ErrorCode.CODE_FIND_SDK_VERSION_LOW));
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.tag.ui.PrecisionNavigationActivity$b */
    public class HandlerC4423b extends Handler {
        public HandlerC4423b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C13981a.m83989i("PrecisionNavigationActivity", "handleMessage, msg.what: " + message.what);
            if (message.what == 1001) {
                if (TextUtils.equals("showDialog", (String) message.obj)) {
                    PrecisionNavigationActivity.this.f20272M = 0;
                }
                PrecisionNavigationActivity.this.finish();
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.tag.ui.PrecisionNavigationActivity$c */
    public class C4424c extends AbstractC9478g {
        public C4424c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void m26836d(Bitmap bitmap) {
            PrecisionNavigationActivity.this.f20264E.setImageBitmap(bitmap);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                final Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new URL(PrecisionNavigationActivity.this.f20270K).openStream());
                PrecisionNavigationActivity.this.runOnUiThread(new Runnable() { // from class: bg.e1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f5623a.m26836d(bitmapDecodeStream);
                    }
                });
            } catch (Exception e10) {
                C13981a.m83988e("PrecisionNavigationActivity", "invalid icon url:" + PrecisionNavigationActivity.this.f20270K + " " + e10.getMessage());
                PrecisionNavigationActivity.this.f20264E.setImageResource(R$drawable.nearlink_default);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.tag.ui.PrecisionNavigationActivity$d */
    public class C4425d extends FindNetworkCallback<TagStatus> {
        public C4425d() {
        }

        /* renamed from: f */
        public final /* synthetic */ void m26842f() {
            PrecisionNavigationActivity.this.finish();
        }

        /* renamed from: g */
        public final /* synthetic */ void m26843g() {
            PrecisionNavigationActivity.this.finish();
        }

        /* renamed from: h */
        public final /* synthetic */ void m26844h() {
            PrecisionNavigationActivity.this.finish();
        }

        /* renamed from: i */
        public final /* synthetic */ void m26845i() {
            PrecisionNavigationActivity.this.finish();
        }

        /* renamed from: j */
        public final /* synthetic */ void m26846j() {
            PrecisionNavigationActivity.this.finish();
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onFail(FindNetworkResult<TagStatus> findNetworkResult) {
            super.onFail(findNetworkResult);
            int respCode = findNetworkResult.getRespCode();
            PrecisionNavigationActivity.this.f20290e0.removeCallbacks(PrecisionNavigationActivity.this.f20295j0);
            C9120m0.m57422r1(PrecisionNavigationActivity.this.f20297p, respCode, PrecisionNavigationActivity.this.getString(R$string.precision_navigate_exception));
            C13981a.m83988e("PrecisionNavigationActivity", "checkTagStatus onFail：" + findNetworkResult.getDescription() + ",Code:" + findNetworkResult.getRespCode());
            if (respCode == 907201165) {
                C13981a.m83989i("PrecisionNavigationActivity", "tag connecting: " + findNetworkResult.getDescription());
                return;
            }
            if (respCode == 907201121 || respCode == 907201132 || respCode == 907201161) {
                PrecisionNavigationActivity.this.f20272M = respCode;
                PrecisionNavigationActivity.this.m26812S2(false);
            } else if (respCode == 907201137) {
                PrecisionNavigationActivity.this.m26812S2(true);
            } else if (!PrecisionNavigationActivity.f20259l0.contains(Integer.valueOf(respCode))) {
                PrecisionNavigationActivity.this.f20290e0.postDelayed(new Runnable() { // from class: bg.g1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f5628a.m26843g();
                    }
                }, 2200L);
            } else {
                PrecisionNavigationActivity.this.f20272M = respCode;
                PrecisionNavigationActivity.this.f20290e0.postDelayed(new Runnable() { // from class: bg.f1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f5625a.m26842f();
                    }
                }, 2200L);
            }
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onSuccess(FindNetworkResult<TagStatus> findNetworkResult) {
            super.onSuccess(findNetworkResult);
            if (findNetworkResult == null || findNetworkResult.getData() == null) {
                C13981a.m83988e("PrecisionNavigationActivity", "checkTagStatus onSuccess null");
                return;
            }
            PrecisionNavigationActivity.this.f20290e0.removeCallbacks(PrecisionNavigationActivity.this.f20295j0);
            PrecisionNavigationActivity.this.f20272M = 0;
            int status = findNetworkResult.getData().getStatus();
            C13981a.m83989i("PrecisionNavigationActivity", "checkTagStatus getStatus：" + status);
            if (status != 1) {
                if (status == 5) {
                    PrecisionNavigationActivity.this.f20272M = ErrorCode.CODE_OTA;
                    PrecisionNavigationActivity.this.f20290e0.postDelayed(new Runnable() { // from class: bg.j1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f5636a.m26846j();
                        }
                    }, 2200L);
                    return;
                } else if (status != 7) {
                    if (status == 8) {
                        PrecisionNavigationActivity.this.f20272M = ErrorCode.STATUS_ERROR_MEASURERESULT_RUNING;
                        PrecisionNavigationActivity.this.f20290e0.postDelayed(new Runnable() { // from class: bg.h1
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f5630a.m26844h();
                            }
                        }, 2200L);
                        return;
                    } else if (status != 9) {
                        PrecisionNavigationActivity.this.m26812S2(true);
                        return;
                    } else {
                        PrecisionNavigationActivity.this.f20272M = ErrorCode.CODE_DEVICE_BUSY;
                        PrecisionNavigationActivity.this.f20290e0.postDelayed(new Runnable() { // from class: bg.i1
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f5633a.m26845i();
                            }
                        }, 2200L);
                        return;
                    }
                }
            }
            PrecisionNavigationActivity.this.f20275P = true;
            PrecisionNavigationActivity.this.m26823Z3(1);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.tag.ui.PrecisionNavigationActivity$e */
    public class C4426e extends FindNetworkCallback<NavigationInfo> {
        public C4426e() {
        }

        /* renamed from: c */
        public final /* synthetic */ void m26849c() {
            PrecisionNavigationActivity.this.finish();
        }

        /* renamed from: d */
        public final /* synthetic */ void m26850d() {
            PrecisionNavigationActivity.this.m26823Z3(0);
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onFail(FindNetworkResult<NavigationInfo> findNetworkResult) {
            int respCode = findNetworkResult.getRespCode();
            C13981a.m83988e("PrecisionNavigationActivity", "startNavigate onFail：" + findNetworkResult.getDescription() + ",Code:" + respCode);
            PrecisionNavigationActivity.this.f20276Q = true;
            PrecisionNavigationActivity.this.m26813S3();
            C9120m0.m57422r1(PrecisionNavigationActivity.this.f20297p, respCode, PrecisionNavigationActivity.this.getString(R$string.precision_navigate_exception));
            PrecisionNavigationActivity.this.f20290e0.removeCallbacks(PrecisionNavigationActivity.this.f20295j0);
            if (PrecisionNavigationActivity.this.f20268I == 1 && respCode == 907201166) {
                PrecisionNavigationActivity.this.f20272M = respCode;
                C9120m0.m57407m1(PrecisionNavigationActivity.this.f20297p, PrecisionNavigationActivity.this.f20265F, PrecisionNavigationActivity.this.f20296k0);
                return;
            }
            if (PrecisionNavigationActivity.f20259l0.contains(Integer.valueOf(respCode))) {
                PrecisionNavigationActivity.this.f20272M = respCode;
                PrecisionNavigationActivity.this.finish();
            } else if (respCode == 907201011) {
                PrecisionNavigationActivity.this.f20290e0.postDelayed(new Runnable() { // from class: bg.k1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f5638a.m26849c();
                    }
                }, 2200L);
            } else {
                if (respCode == 0 || PrecisionNavigationActivity.this.isFinishing()) {
                    return;
                }
                PrecisionNavigationActivity.this.f20290e0.postDelayed(new Runnable() { // from class: bg.l1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f5642a.m26850d();
                    }
                }, 3000L);
            }
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onSuccess(FindNetworkResult<NavigationInfo> findNetworkResult) {
            C13981a.m83989i("PrecisionNavigationActivity", "startNavigate onSuccess");
            PrecisionNavigationActivity.this.f20276Q = false;
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onUpdate(FindNetworkResult<NavigationInfo> findNetworkResult) {
            PrecisionNavigationActivity.this.f20290e0.removeCallbacks(PrecisionNavigationActivity.this.f20295j0);
            if (!PrecisionNavigationActivity.this.m26751U2(findNetworkResult)) {
                C13981a.m83990w("PrecisionNavigationActivity", "startNavigate onUpdate result is not valid!");
                return;
            }
            NavigationInfo data = findNetworkResult.getData();
            int flag = data.getFlag();
            C13981a.m83989i("PrecisionNavigationActivity", "startNavigate onUpdate getFlag：" + flag);
            PrecisionNavigationActivity.this.f20279T = false;
            switch (flag) {
                case 1:
                    PrecisionNavigationActivity precisionNavigationActivity = PrecisionNavigationActivity.this;
                    precisionNavigationActivity.m26806H3(data, precisionNavigationActivity.getString(R$string.connected_swivel_phone_direction));
                    break;
                case 2:
                    PrecisionNavigationActivity precisionNavigationActivity2 = PrecisionNavigationActivity.this;
                    precisionNavigationActivity2.m26803E3(precisionNavigationActivity2.getString(R$string.connected_weak_signal_move_location));
                    break;
                case 3:
                    PrecisionNavigationActivity precisionNavigationActivity3 = PrecisionNavigationActivity.this;
                    precisionNavigationActivity3.m26803E3(precisionNavigationActivity3.getString(precisionNavigationActivity3.m26820Y2(R$string.connected_item_moving_cant_confirms_location, R$string.connected_device_moving_cant_confirms_location)));
                    break;
                case 4:
                    PrecisionNavigationActivity.this.m26804F3(data, true);
                    break;
                case 5:
                    PrecisionNavigationActivity.this.m26804F3(data, false);
                    break;
                case 7:
                    int iM26820Y2 = PrecisionNavigationActivity.this.m26820Y2(R$string.connected_signal_exist_interference, R$string.connected_signal_exist_interference_device);
                    PrecisionNavigationActivity precisionNavigationActivity4 = PrecisionNavigationActivity.this;
                    precisionNavigationActivity4.m26803E3(precisionNavigationActivity4.getString(iM26820Y2));
                    break;
                case 8:
                    PrecisionNavigationActivity precisionNavigationActivity5 = PrecisionNavigationActivity.this;
                    precisionNavigationActivity5.m26806H3(data, precisionNavigationActivity5.getString(R$string.connected_weak_signal_move_location));
                    break;
                case 9:
                    PrecisionNavigationActivity precisionNavigationActivity6 = PrecisionNavigationActivity.this;
                    precisionNavigationActivity6.m26806H3(data, precisionNavigationActivity6.getString(R$string.connected_microphone_blocked));
                    break;
            }
            if (PrecisionNavigationActivity.this.f20279T && PrecisionNavigationActivity.this.f20280U) {
                PrecisionNavigationActivity.this.m26741P3();
            } else if (!PrecisionNavigationActivity.this.f20277R) {
                PrecisionNavigationActivity.this.m26731L3();
            }
            PrecisionNavigationActivity.this.f20290e0.postDelayed(PrecisionNavigationActivity.this.f20295j0, 20000L);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.tag.ui.PrecisionNavigationActivity$f */
    public class C4427f implements FindNetworkSoundCallback {
        public C4427f() {
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onFail(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            int respCode = findNetworkConfigResult.getRespCode();
            C13981a.m83988e("PrecisionNavigationActivity", "startSound onFail:" + findNetworkConfigResult.getDescription() + ",Code:" + respCode);
            if (PrecisionNavigationActivity.this.f20277R) {
                PrecisionNavigationActivity.this.f20300s.stop();
            }
            PrecisionNavigationActivity.this.f20277R = false;
            if (respCode == 907201165 || respCode == 0 || PrecisionNavigationActivity.f20259l0.contains(Integer.valueOf(respCode))) {
                return;
            }
            C11880m.m71337d(PrecisionNavigationActivity.this.f20297p, PrecisionNavigationActivity.this.getString(R$string.sound_failed));
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onFinished(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("PrecisionNavigationActivity", "startSound onFinished");
            if (PrecisionNavigationActivity.this.f20277R) {
                PrecisionNavigationActivity.this.f20300s.stop();
            }
            PrecisionNavigationActivity.this.f20277R = false;
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onSuccess(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("PrecisionNavigationActivity", "startSound onSuccess:" + findNetworkConfigResult.getRespCode());
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onUpdate(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("PrecisionNavigationActivity", "startSound onUpdate");
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.tag.ui.PrecisionNavigationActivity$g */
    public class C4428g implements FindNetworkSoundCallback {

        /* renamed from: a */
        public final InterfaceC14358e f20314a;

        public C4428g(InterfaceC14358e interfaceC14358e) {
            this.f20314a = interfaceC14358e;
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onFail(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C9120m0.m57422r1(PrecisionNavigationActivity.this.f20297p, findNetworkConfigResult.getRespCode(), PrecisionNavigationActivity.this.getString(R$string.precision_navigate_exception));
            C13981a.m83988e("PrecisionNavigationActivity", "stopSound onFail:" + findNetworkConfigResult.getDescription() + ",Code:" + findNetworkConfigResult.getRespCode());
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onFinished(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("PrecisionNavigationActivity", "stopSound onFinished");
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onSuccess(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            PrecisionNavigationActivity.this.f20277R = false;
            this.f20314a.execute();
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onUpdate(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("PrecisionNavigationActivity", "stopSound onUpdate");
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.tag.ui.PrecisionNavigationActivity$h */
    public static class C4429h extends FindNetworkCallback<String> {

        /* renamed from: b */
        public final InterfaceC14358e f20316b;

        public C4429h(InterfaceC14358e interfaceC14358e) {
            this.f20316b = interfaceC14358e;
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onSuccess(FindNetworkResult<String> findNetworkResult) {
            this.f20316b.execute();
        }
    }

    /* renamed from: B3 */
    private void m26718B3() {
        this.f20291f0 = new BluetoothStatueReceiver();
        registerReceiver(this.f20291f0, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
    }

    /* renamed from: D3 */
    private void m26721D3(Drawable drawable) {
        this.f20302u.setBackground(drawable);
        this.f20303v.setBackground(drawable);
    }

    /* renamed from: I3 */
    private void m26727I3(boolean z10) {
        if (z10) {
            this.f20301t.setEnabled(true);
            this.f20301t.setAlpha(1.0f);
            m26731L3();
        } else {
            this.f20301t.setEnabled(false);
            this.f20301t.setAlpha(0.3f);
            m26741P3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L3 */
    public void m26731L3() {
        if (this.f20278S) {
            return;
        }
        this.f20278S = true;
        this.f20301t.startAnimation(m26756X2());
    }

    /* renamed from: N3 */
    private void m26736N3() {
        C13981a.m83989i("PrecisionNavigationActivity", "to startSound");
        this.f20277R = true;
        C0225l.m1577a(new InterfaceC14356c() { // from class: bg.g0
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return this.f5627a.m26832u3();
            }
        }, new Consumer() { // from class: bg.h0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                PrecisionNavigationActivity.m26795v3((Exception) obj);
            }
        });
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: P2 */
    private void m26740P2(int i10, int i11, int i12, int i13) {
        ValueAnimator valueAnimatorOfArgb = ValueAnimator.ofArgb(getResources().getColor(i10), getResources().getColor(i11));
        valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: bg.q0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f5646a.m26764c3(valueAnimator);
            }
        });
        valueAnimatorOfArgb.setDuration(1000L);
        ValueAnimator valueAnimatorOfArgb2 = ValueAnimator.ofArgb(getResources().getColor(i12), getResources().getColor(i13));
        valueAnimatorOfArgb2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: bg.r0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f5648a.m26766d3(valueAnimator);
            }
        });
        valueAnimatorOfArgb2.setDuration(1000L);
        valueAnimatorOfArgb2.start();
        valueAnimatorOfArgb.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P3 */
    public void m26741P3() {
        if (this.f20278S) {
            this.f20278S = false;
            this.f20301t.clearAnimation();
        }
    }

    /* renamed from: Q2 */
    private void m26743Q2() {
        if (this.f20274O) {
            return;
        }
        m26740P2(R$color.blue_out_precision, R$color.black_out_precision, R$color.green_inside_precision, R$color.black_inside_precision);
        this.f20274O = true;
        m26721D3(getDrawable(R$drawable.precicion_navigation_imbu_bg));
    }

    /* renamed from: R2 */
    private void m26745R2() {
        if (this.f20274O) {
            m26740P2(R$color.black_out_precision, R$color.blue_out_precision, R$color.black_inside_precision, R$color.green_inside_precision);
            this.f20274O = false;
            m26721D3(getDrawable(R$drawable.precicion_navigation_imbu_bg_black));
        }
    }

    /* renamed from: R3 */
    private void m26746R3(final InterfaceC14358e interfaceC14358e) {
        C13981a.m83989i("PrecisionNavigationActivity", "to stopSound");
        C0225l.m1577a(new InterfaceC14356c() { // from class: bg.l0
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return this.f5640a.m26834y3(interfaceC14358e);
            }
        }, new Consumer() { // from class: bg.m0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                PrecisionNavigationActivity.m26801z3((Exception) obj);
            }
        });
    }

    /* renamed from: T3 */
    private void m26749T3() {
        if ((C11829c.m70502B0(this) || C11829c.m70499A0(this)) && this.f20292g0 == null) {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setMessage(R$string.suggest_use_in_fullscreen).setPositiveButton(R$string.phonefinder_dialog_know, new DialogInterface.OnClickListener() { // from class: bg.f0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    dialogInterface.dismiss();
                }
            }).setCancelable(true).create();
            this.f20292g0 = alertDialogCreate;
            alertDialogCreate.setCanceledOnTouchOutside(false);
            this.f20292g0.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U2 */
    public boolean m26751U2(FindNetworkResult<NavigationInfo> findNetworkResult) {
        if (isFinishing()) {
            m26811Q3(new InterfaceC14358e() { // from class: bg.t0
                @Override // p851zp.InterfaceC14358e
                public final void execute() {
                    C13981a.m83989i("PrecisionNavigationActivity", "checkValid stopNavigate success");
                }
            });
            return false;
        }
        if (this.f20275P && !this.f20276Q && (this.f20284Y == 1 || this.f20284Y == 3 || this.f20284Y == 4)) {
            if (findNetworkResult != null && findNetworkResult.getData() != null) {
                return true;
            }
            C13981a.m83989i("PrecisionNavigationActivity", "startNavigate onUpdate null");
        }
        return false;
    }

    /* renamed from: W3 */
    private void m26754W3() {
        this.f20284Y = 0;
        this.f20306y.setVisibility(4);
        m26807J3(this.f20304w, getString(R$string.not_connected_move_location));
        this.f20304w.setVisibility(0);
        this.f20298q.start();
        this.f20300s.stop();
        m26727I3(false);
        m26743Q2();
        m26814T2();
    }

    /* renamed from: X2 */
    private AnimationSet m26756X2() {
        return (AnimationSet) AnimationUtils.loadAnimation(this, R$anim.heart_beat_anim);
    }

    /* renamed from: a4 */
    private void m26760a4() {
        BluetoothStatueReceiver bluetoothStatueReceiver = this.f20291f0;
        if (bluetoothStatueReceiver != null) {
            unregisterReceiver(bluetoothStatueReceiver);
        }
    }

    /* renamed from: b3 */
    private void m26762b3() {
        this.f20284Y = 0;
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f20265F = safeIntent.getStringExtra("TagSN");
        this.f20266G = safeIntent.getStringExtra("itemName");
        this.f20269J = safeIntent.getStringExtra("subModelId");
        this.f20270K = safeIntent.getStringExtra("iconUrl");
        this.f20267H = safeIntent.getStringExtra("modelId");
        this.f20268I = safeIntent.getIntExtra("componentType", 0);
        View viewM76829b = C12809f.m76829b(this, R$id.sounding_im_bu);
        this.f20301t = viewM76829b;
        viewM76829b.setOnClickListener(this);
        this.f20302u = C12809f.m76829b(this, R$id.sounding_im_bu_bg);
        m26727I3(true);
        C12809f.m76829b(this, R$id.cancel_im_bu).setOnClickListener(this);
        this.f20303v = C12809f.m76829b(this, R$id.cancel_im_bu_bg);
        this.f20304w = (TextView) C12809f.m76829b(this, R$id.connection_status_tv);
        this.f20305x = (TextView) C12809f.m76829b(this, R$id.tv_operate);
        this.f20306y = C12809f.m76829b(this, R$id.navigate_arrow_bell);
        this.f20307z = C12809f.m76829b(this, R$id.relat_outside);
        this.f20260A = C12809f.m76829b(this, R$id.relat_inside);
        this.f20261B = (TextView) C12809f.m76829b(this, R$id.tv_nearby);
        this.f20262C = (TextView) C12809f.m76829b(this, R$id.tv_directions);
        this.f20263D = (TextView) C12809f.m76829b(this, R$id.distances_tx);
        ((TextView) C12809f.m76829b(this, R$id.tv_user_item_name)).setText(this.f20266G);
        this.f20299r = (ArrowDotView) C12809f.m76829b(this, R$id.arrowhead_im);
        SearchingRippleView searchingRippleView = (SearchingRippleView) C12809f.m76829b(this, R$id.searching_ripple_view);
        this.f20298q = searchingRippleView;
        searchingRippleView.start();
        this.f20264E = C12809f.m76829b(this, R$id.tag_detail);
        m26824a3();
        this.f20300s = (CircleRing) C12809f.m76829b(this, R$id.circle_ring);
        this.f20294i0 = C9097b.m57301k(this.f20267H);
        m26807J3(this.f20304w, getString(m26820Y2(R$string.connected_stay_and_wait_the_direction, R$string.connected_stay_and_wait_the_direction_device)));
        if (C11690w.m69742w(this.f20265F)) {
            m26746R3(new InterfaceC14358e() { // from class: bg.a1
                @Override // p851zp.InterfaceC14358e
                public final void execute() {
                    C13981a.m83989i("PrecisionNavigationActivity", "stopSound onSuccess");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c3 */
    public /* synthetic */ void m26764c3(ValueAnimator valueAnimator) {
        this.f20307z.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d3 */
    public /* synthetic */ void m26766d3(ValueAnimator valueAnimator) {
        this.f20260A.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    /* renamed from: f3 */
    public static /* synthetic */ void m26769f3(Exception exc) {
        C13981a.m83988e("PrecisionNavigationActivity", "checkTagStatus error：" + exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l3 */
    public /* synthetic */ void m26780l3() {
        if (this.f20293h0) {
            C13981a.m83989i("PrecisionNavigationActivity", "noResponse finish");
            C11880m.m71337d(this, getString(R$string.precision_navigate_exception));
            this.f20290e0.postDelayed(new Runnable() { // from class: bg.i0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5632a.finish();
                }
            }, 2200L);
        } else {
            C13981a.m83989i("PrecisionNavigationActivity", "noResponse retry");
            this.f20293h0 = true;
            m26823Z3(0);
        }
    }

    /* renamed from: t3 */
    public static /* synthetic */ void m26792t3(Exception exc) {
        C13981a.m83988e("PrecisionNavigationActivity", "startNavigate error：" + exc.getMessage());
    }

    /* renamed from: v3 */
    public static /* synthetic */ void m26795v3(Exception exc) {
        C13981a.m83988e("PrecisionNavigationActivity", "startSound error：" + exc.getMessage());
    }

    /* renamed from: x3 */
    public static /* synthetic */ void m26798x3(Exception exc) {
        C13981a.m83988e("PrecisionNavigationActivity", "stopNavigate error：" + exc.getMessage());
    }

    /* renamed from: z3 */
    public static /* synthetic */ void m26801z3(Exception exc) {
        C13981a.m83988e("PrecisionNavigationActivity", "stopSound error：" + exc.getMessage());
    }

    /* renamed from: C3 */
    public void m26802C3(float f10) {
        this.f20279T = true;
        this.f20262C.setVisibility(0);
        if (f10 < -160.0f) {
            this.f20262C.setText(getString(R$string.tv_rear));
        } else if (f10 < -110.0f) {
            this.f20262C.setText(getString(R$string.left_rear));
        } else if (f10 < -70.0f) {
            this.f20262C.setText(getString(R$string.tv_left));
        } else if (f10 < -20.0f) {
            this.f20262C.setText(getString(R$string.left_front));
        } else {
            if (f10 < 20.0f) {
                this.f20262C.setText(getString(R$string.front));
                m26810O3();
                this.f20299r.start();
                m26745R2();
                return;
            }
            if (f10 < 70.0f) {
                this.f20262C.setText(getString(R$string.right_front));
            } else if (f10 < 110.0f) {
                this.f20262C.setText(getString(R$string.tv_right));
            } else if (f10 < 160.0f) {
                this.f20262C.setText(getString(R$string.right_rear));
            } else {
                this.f20262C.setText(getString(R$string.tv_rear));
            }
        }
        m26813S3();
        this.f20299r.stop();
        m26743Q2();
    }

    /* renamed from: E3 */
    public final void m26803E3(String str) {
        this.f20285Z = 1;
        this.f20284Y = 1;
        m26813S3();
        this.f20306y.clearAnimation();
        this.f20306y.setVisibility(4);
        this.f20262C.setVisibility(4);
        this.f20263D.setVisibility(4);
        this.f20264E.setVisibility(4);
        this.f20298q.start();
        this.f20261B.setVisibility(4);
        this.f20304w.setVisibility(0);
        m26807J3(this.f20304w, str);
        this.f20299r.stop();
        m26743Q2();
    }

    /* renamed from: F3 */
    public final void m26804F3(NavigationInfo navigationInfo, boolean z10) {
        float[] values = navigationInfo.getValues();
        boolean z11 = false;
        float f10 = values[0];
        float f11 = values[1];
        if (f11 >= 10.0f) {
            this.f20288c0 = 600;
        } else if (f11 >= 5.0f) {
            this.f20288c0 = 400;
        } else if (f11 >= 0.0f) {
            this.f20288c0 = 200;
        }
        if (this.f20285Z == 3) {
            if (f11 > 2.0f) {
                m26819X3();
                m26805G3(f11);
                m26802C3(f10);
                m26816V2(f10, true);
                return;
            }
            return;
        }
        if (z10 && f11 >= 0.0f && f11 <= 1.5f) {
            m26821Y3();
            return;
        }
        if (this.f20285Z != 4) {
            m26819X3();
            z11 = true;
        }
        if (f11 >= 0.0f) {
            m26805G3(f11);
        }
        m26802C3(f10);
        m26816V2(f10, z11);
    }

    /* renamed from: G3 */
    public final void m26805G3(float f10) {
        this.f20280U = true;
        String str = new DecimalFormat("#.#").format(f10);
        if (f10 <= 1.0f || f10 >= 2.0f) {
            this.f20263D.setText(getResources().getQuantityString(R$plurals.great_distance, (int) f10, str));
        } else {
            this.f20263D.setText(getResources().getQuantityString(R$plurals.great_distance, 2, str));
        }
    }

    /* renamed from: H3 */
    public final void m26806H3(NavigationInfo navigationInfo, String str) {
        this.f20284Y = 1;
        float f10 = navigationInfo.getValues()[1];
        if (this.f20285Z != 3 || f10 < 0.0f || f10 > 2.0f) {
            if (f10 >= 0.0f && f10 <= 1.5f) {
                m26821Y3();
                return;
            }
            if (this.f20285Z != 1) {
                this.f20285Z = 1;
                m26813S3();
                this.f20306y.clearAnimation();
                this.f20306y.setVisibility(4);
                this.f20298q.start();
                this.f20264E.setVisibility(4);
                this.f20261B.setVisibility(4);
                this.f20304w.setVisibility(0);
                this.f20299r.stop();
            }
            m26807J3(this.f20304w, str);
            if (f10 >= 0.0f) {
                this.f20262C.setVisibility(0);
                this.f20262C.setText(R$string.direction_finding);
                this.f20263D.setVisibility(0);
                m26805G3(f10);
            } else if (this.f20280U) {
                this.f20262C.setVisibility(0);
                this.f20262C.setText(R$string.direction_finding);
            } else {
                this.f20262C.setVisibility(4);
                this.f20263D.setVisibility(4);
            }
            m26743Q2();
        }
    }

    /* renamed from: J3 */
    public final void m26807J3(TextView textView, String str) {
        if (str.isEmpty() || textView == null) {
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        int iIndexOf = str.indexOf("\n");
        int length = str.length();
        spannableString.setSpan(new AbsoluteSizeSpan(20, true), iIndexOf, length, 34);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")), iIndexOf, length, 34);
        textView.setText(spannableString);
    }

    /* renamed from: K3 */
    public void m26808K3() {
        C13981a.m83989i("PrecisionNavigationActivity", "show permission dialog");
        int iM26820Y2 = m26820Y2(R$string.microphone_permission_information, R$string.microphone_permission_information_device);
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.pf_layout_show_permission_dialog, (ViewGroup) null);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.permission_title);
        if (textView == null) {
            C13981a.m83988e("PrecisionNavigationActivity", "showPermissionDialog titleView or messageView is null");
            return;
        }
        textView.setText(getString(iM26820Y2));
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setView(viewInflate).setPositiveButton(R$string.permission_btn_go_setting, new DialogInterface.OnClickListener() { // from class: bg.b1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f5616a.m26828p3(dialogInterface, i10);
            }
        }).setNegativeButton(R$string.permission_btn_cancel, new DialogInterface.OnClickListener() { // from class: bg.c1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f5619a.m26829q3(dialogInterface, i10);
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: bg.d1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f5620a.m26830r3(dialogInterface);
            }
        }).create();
        try {
            alertDialogCreate.setCanceledOnTouchOutside(false);
            alertDialogCreate.show();
        } catch (Exception unused) {
            C13981a.m83988e("PrecisionNavigationActivity", "showPermissionDialog exception");
            finish();
        }
    }

    /* renamed from: M3 */
    public final void m26809M3() {
        if (isFinishing()) {
            return;
        }
        m26727I3(true);
        C13981a.m83989i("PrecisionNavigationActivity", "to startNavigate");
        C0225l.m1577a(new InterfaceC14356c() { // from class: bg.o0
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return this.f5644a.m26831s3();
            }
        }, new Consumer() { // from class: bg.p0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                PrecisionNavigationActivity.m26792t3((Exception) obj);
            }
        });
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: O3 */
    public final void m26810O3() {
        if (this.f20281V) {
            return;
        }
        this.f20281V = true;
        if (this.f20289d0) {
            m26822Z2();
            return;
        }
        long[] jArr = {100, 300, 1200};
        if (this.f20286a0 == null) {
            this.f20286a0 = (Vibrator) getSystemService("vibrator");
        }
        this.f20286a0.vibrate(jArr, 0);
    }

    /* renamed from: Q3 */
    public void m26811Q3(final InterfaceC14358e interfaceC14358e) {
        C13981a.m83989i("PrecisionNavigationActivity", "to stopNavigate");
        this.f20290e0.removeCallbacks(this.f20295j0);
        C0225l.m1577a(new InterfaceC14356c() { // from class: bg.j0
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return this.f5634a.m26833w3(interfaceC14358e);
            }
        }, new Consumer() { // from class: bg.k0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                PrecisionNavigationActivity.m26798x3((Exception) obj);
            }
        });
    }

    /* renamed from: S2 */
    public final void m26812S2(boolean z10) {
        C13981a.m83989i("PrecisionNavigationActivity", "checkTagDelay: " + z10);
        if (z10) {
            m26807J3(this.f20304w, getString(m26820Y2(R$string.connected_stay_and_wait_the_direction, R$string.connected_stay_and_wait_the_direction_device)));
            m26727I3(true);
        } else {
            m26807J3(this.f20304w, getString(R$string.not_connected_move_location));
            m26727I3(false);
        }
        this.f20290e0.postDelayed(new Runnable() { // from class: bg.s0
            @Override // java.lang.Runnable
            public final void run() {
                this.f5651a.m26814T2();
            }
        }, 7000L);
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: S3 */
    public final void m26813S3() {
        if (this.f20289d0) {
            this.f20287b0.stopHwVibrator("haptic.common.click");
            this.f20281V = false;
            return;
        }
        Vibrator vibrator = this.f20286a0;
        if (vibrator == null || !this.f20281V) {
            return;
        }
        this.f20281V = false;
        vibrator.cancel();
    }

    /* renamed from: T2 */
    public final void m26814T2() {
        if (isFinishing()) {
            return;
        }
        this.f20275P = false;
        C13981a.m83989i("PrecisionNavigationActivity", "to checkTagStatus");
        this.f20290e0.postDelayed(this.f20295j0, 20000L);
        C0225l.m1577a(new InterfaceC14356c() { // from class: bg.w0
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return this.f5656a.m26826e3();
            }
        }, new Consumer() { // from class: bg.x0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                PrecisionNavigationActivity.m26769f3((Exception) obj);
            }
        });
    }

    /* renamed from: U3 */
    public final void m26815U3() {
        m26813S3();
        this.f20299r.stop();
        this.f20306y.clearAnimation();
        this.f20264E.setVisibility(4);
        this.f20262C.setVisibility(4);
        this.f20263D.setVisibility(4);
        this.f20261B.setVisibility(4);
        this.f20298q.stop();
    }

    /* renamed from: V2 */
    public final void m26816V2(float f10, boolean z10) {
        C13981a.m83987d("PrecisionNavigationActivity", "isRotating: " + this.f20282W);
        C13981a.m83987d("PrecisionNavigationActivity", "finalToDegreesL：" + f10 + " | fromDegrees: " + this.f20283X);
        if (this.f20282W) {
            return;
        }
        if (Math.abs(f10 - this.f20283X) > 1.0f || z10) {
            this.f20282W = true;
            RotateAnimation rotateAnimation = new RotateAnimation(this.f20283X, this.f20283X > f10 + 270.0f ? 360.0f + f10 : f10 > this.f20283X + 270.0f ? f10 - 360.0f : f10, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            long jAbs = (long) (Math.abs(r2 - this.f20283X) / 0.3d);
            if (jAbs < 200) {
                jAbs = 200;
            }
            rotateAnimation.setDuration(jAbs);
            this.f20290e0.postDelayed(new Runnable() { // from class: bg.v0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5655a.m26827h3();
                }
            }, rotateAnimation.getDuration());
            rotateAnimation.setFillAfter(true);
            this.f20306y.startAnimation(rotateAnimation);
            this.f20283X = f10;
        }
    }

    /* renamed from: V3 */
    public final void m26817V3() {
        this.f20285Z = 1;
        this.f20284Y = 1;
        this.f20280U = false;
        this.f20304w.setVisibility(0);
        m26807J3(this.f20304w, getString(m26820Y2(R$string.connected_stay_and_wait_the_direction, R$string.connected_stay_and_wait_the_direction_device)));
        this.f20305x.setText(R$string.is_looking_for);
        this.f20263D.setText(R$string.ranging_in_progress);
        m26743Q2();
        m26809M3();
    }

    /* renamed from: W2 */
    public final void m26818W2() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("TagSN", C9120m0.m57351R(this.f20265F));
        if (!TextUtils.isEmpty(this.f20267H)) {
            linkedHashMap.put("modelId", this.f20267H);
        }
        String strM80950o = C13452e.m80781L().m80950o();
        if (!TextUtils.isEmpty(strM80950o)) {
            linkedHashMap.put("deviceId", strM80950o);
        }
        linkedHashMap.put("current_ui_mode", String.valueOf(this.f20284Y == 1 ? this.f20285Z : this.f20284Y));
        linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
        C13230i.m79504I().m79590k0("mecloud_findmyphone_exit_precision_navigate", "2", "", C13452e.m80781L().m80971t0(), linkedHashMap);
        UBAAnalyze.m29979g0("CKP", "mecloud_findmyphone_exit_precision_navigate", "1", "76", "2", "", linkedHashMap);
        linkedHashMap.put("itemName", this.f20266G);
        new C12797b().m76785k(this.f20297p, "PrecisionNavigationActivity", "", "PrecisionNavigationActivity exit", "", "tag_local_find", "", "mecloud_findmyphone_exit_precision_navigate", true, linkedHashMap);
    }

    /* renamed from: X3 */
    public final void m26819X3() {
        this.f20285Z = 4;
        this.f20264E.setVisibility(4);
        this.f20261B.setVisibility(4);
        this.f20298q.stop();
        this.f20304w.setVisibility(4);
        this.f20263D.setVisibility(0);
        this.f20306y.setVisibility(0);
    }

    /* renamed from: Y2 */
    public final int m26820Y2(int i10, int i11) {
        return 2 == this.f20294i0 ? i11 : i10;
    }

    /* renamed from: Y3 */
    public final void m26821Y3() {
        this.f20285Z = 3;
        m26813S3();
        this.f20304w.setVisibility(4);
        this.f20262C.setVisibility(4);
        this.f20263D.setVisibility(4);
        this.f20306y.clearAnimation();
        this.f20306y.setVisibility(4);
        this.f20299r.stop();
        this.f20261B.setVisibility(0);
        this.f20264E.setVisibility(0);
        this.f20298q.start();
        m26745R2();
        if (this.f20273N) {
            String strM80790C = C13452e.m80781L().m80790C();
            C13009a.m78309d("mecloud_findmyphone_precision_nearby_expose", "1", C13452e.m80781L().m80971t0(), C13222a.m79465g(this), strM80790C);
            UBAAnalyze.m29956Q("PVP", "mecloud_findmyphone_precision_nearby_expose", "1", "76", strM80790C);
            this.f20273N = false;
        }
    }

    /* renamed from: Z2 */
    public final void m26822Z2() {
        if (this.f20281V) {
            this.f20287b0.setHwVibrator("haptic.common.click");
            this.f20290e0.postDelayed(new Runnable() { // from class: bg.u0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5654a.m26822Z2();
                }
            }, this.f20288c0);
        }
    }

    /* renamed from: Z3 */
    public final void m26823Z3(int i10) {
        if (this.f20284Y == i10) {
            return;
        }
        C13981a.m83989i("PrecisionNavigationActivity", "switchUiMode: " + i10);
        if (this.f20284Y == 1) {
            m26815U3();
        }
        if (i10 == 0) {
            m26754W3();
        } else {
            if (i10 != 1) {
                return;
            }
            m26817V3();
        }
    }

    /* renamed from: a3 */
    public final void m26824a3() {
        C13981a.m83989i("PrecisionNavigationActivity", "mTagIcon：" + this.f20270K);
        if (TextUtils.isEmpty(this.f20270K)) {
            C13981a.m83988e("PrecisionNavigationActivity", "no icon url！");
        } else {
            C12515a.m75110o().m75172d(new C4424c());
        }
    }

    /* renamed from: b4 */
    public final void m26825b4() {
        C13981a.m83989i("PrecisionNavigationActivity", "to verifyAudioPermissions");
        if (ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") == 0) {
            m26814T2();
        } else if (!C13299a.m79752d(this, "android.permission.RECORD_AUDIO")) {
            C13299a.m79751c(this, new String[]{"android.permission.RECORD_AUDIO"}, 1);
        } else {
            C13981a.m83989i("PrecisionNavigationActivity", "to showPermissionDialog");
            m26808K3();
        }
    }

    /* renamed from: e3 */
    public final /* synthetic */ Task m26826e3() throws Exception {
        return FindNetwork.getFindNetworkEngine(getApplicationContext()).checkTagStatus(this.f20265F, new C4425d());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void finish() {
        m26813S3();
        if (this.f20284Y == 1) {
            m26811Q3(new InterfaceC14358e() { // from class: bg.d0
                @Override // p851zp.InterfaceC14358e
                public final void execute() {
                    C13981a.m83989i("PrecisionNavigationActivity", "stopNavigate onSuccess");
                }
            });
        }
        if (this.f20277R) {
            m26746R3(new InterfaceC14358e() { // from class: bg.e0
                @Override // p851zp.InterfaceC14358e
                public final void execute() {
                    C13981a.m83989i("PrecisionNavigationActivity", "stopSound onSuccess");
                }
            });
        }
        this.f20298q.stop();
        this.f20299r.stop();
        m26741P3();
        this.f20300s.stop();
        this.f20290e0.removeCallbacksAndMessages(null);
        Intent intent = new Intent();
        intent.putExtra("tagSn", this.f20265F);
        setResult(this.f20272M, intent);
        m26818W2();
        super.finish();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = new Configuration();
        configuration.setToDefaults();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return resources;
    }

    /* renamed from: h3 */
    public final /* synthetic */ void m26827h3() {
        this.f20282W = false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (R$id.cancel_im_bu == id2) {
            finish();
            return;
        }
        if (R$id.sounding_im_bu != id2 || C0209d.m1226Y0()) {
            return;
        }
        if (this.f20277R) {
            C13981a.m83989i("PrecisionNavigationActivity", "Clicked stopSound");
            m26746R3(new InterfaceC14358e() { // from class: bg.z0
                @Override // p851zp.InterfaceC14358e
                public final void execute() {
                    C13981a.m83989i("PrecisionNavigationActivity", "stopSound onSuccess");
                }
            });
            this.f20300s.stop();
        } else {
            C13981a.m83989i("PrecisionNavigationActivity", "Clicked startSound");
            m26736N3();
            m26741P3();
            this.f20300s.start();
            C9120m0.m57383e1(this.f20297p, "mecloud_findmyphone_precision_sound", this.f20265F, this.f20266G, this.f20267H, 0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70717C0(this);
        m26749T3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f20297p = this;
        C11842p.m70717C0(this);
        setContentView(R$layout.activity_precision_navigation);
        C13981a.m83989i("PrecisionNavigationActivity", "WapFindPhoneActivity to PrecisionNavigationActivity onCreate");
        this.f20271L = System.currentTimeMillis();
        m26762b3();
        m26825b4();
        m26718B3();
        m26749T3();
        if (this.f20287b0 == null) {
            this.f20287b0 = new VibratorEx();
        }
        this.f20289d0 = this.f20287b0.isSupportHwVibrator("haptic.common.click");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m26760a4();
        this.f20290e0.removeCallbacksAndMessages(null);
        AlertDialog alertDialog = this.f20292g0;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f20292g0.dismiss();
            this.f20292g0 = null;
        }
        C9120m0.m57419q1(this.f20271L, "startNavigation");
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        C13981a.m83989i("PrecisionNavigationActivity", "onRequestPermissionsResult");
        if (i10 == 1) {
            if (PermissionChecker.checkSelfPermission(this, "android.permission.RECORD_AUDIO") == 0) {
                m26814T2();
            } else {
                C13981a.m83989i("PrecisionNavigationActivity", "to showPermissionDialog");
                m26808K3();
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        C13981a.m83989i("PrecisionNavigationActivity", "onStop");
        m26813S3();
        this.f20298q.stop();
        this.f20299r.stop();
        m26741P3();
        this.f20300s.stop();
        if (this.f20284Y == 1) {
            C13981a.m83989i("PrecisionNavigationActivity", "to stopNavigate");
            m26811Q3(new InterfaceC14358e() { // from class: bg.c0
                @Override // p851zp.InterfaceC14358e
                public final void execute() {
                    C13981a.m83989i("PrecisionNavigationActivity", "stopNavigate onSuccess");
                }
            });
        }
        if (this.f20277R) {
            C13981a.m83989i("PrecisionNavigationActivity", "to stopSound");
            m26746R3(new InterfaceC14358e() { // from class: bg.n0
                @Override // p851zp.InterfaceC14358e
                public final void execute() {
                    C13981a.m83989i("PrecisionNavigationActivity", "stopSound onSuccess");
                }
            });
        }
        finish();
    }

    /* renamed from: p3 */
    public final /* synthetic */ void m26828p3(DialogInterface dialogInterface, int i10) {
        C13981a.m83989i("PrecisionNavigationActivity", "dialog positive");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getPackageName(), null));
        startActivity(intent);
        finish();
    }

    /* renamed from: q3 */
    public final /* synthetic */ void m26829q3(DialogInterface dialogInterface, int i10) {
        C13981a.m83989i("PrecisionNavigationActivity", "dialog cancel");
        setResult(0);
        finish();
    }

    /* renamed from: r3 */
    public final /* synthetic */ void m26830r3(DialogInterface dialogInterface) {
        C13981a.m83989i("PrecisionNavigationActivity", "dialog dismiss");
        setResult(0);
        finish();
    }

    /* renamed from: s3 */
    public final /* synthetic */ Task m26831s3() throws Exception {
        return FindNetwork.getFindNetworkEngine(getApplicationContext()).startNavigate(getApplicationContext(), this.f20265F, new C4426e());
    }

    /* renamed from: u3 */
    public final /* synthetic */ Task m26832u3() throws Exception {
        return FindNetwork.getFindNetworkEngine((Activity) this).startSound(this.f20265F, true, new C4427f());
    }

    /* renamed from: w3 */
    public final /* synthetic */ Task m26833w3(InterfaceC14358e interfaceC14358e) throws Exception {
        return FindNetwork.getFindNetworkEngine((Activity) this).stopNavigate(this.f20265F, new C4429h(interfaceC14358e));
    }

    /* renamed from: y3 */
    public final /* synthetic */ Task m26834y3(InterfaceC14358e interfaceC14358e) throws Exception {
        return FindNetwork.getFindNetworkEngine((Activity) this).stopSound(this.f20265F, true, new C4428g(interfaceC14358e));
    }
}
