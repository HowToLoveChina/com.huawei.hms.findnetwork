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
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import bg.RunnableC1182b;
import bg.RunnableC1217n;
import com.huawei.android.hicloud.p088ui.activity.BaseActivity;
import com.huawei.android.remotecontrol.sdk.R$anim;
import com.huawei.android.remotecontrol.sdk.R$color;
import com.huawei.android.remotecontrol.sdk.R$drawable;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$plurals;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.tag.p092ui.BluetoothNavigationActivity;
import com.huawei.android.remotecontrol.tag.p092ui.view.CircleRing;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.android.remotecontrol.tag.p092ui.view.SingleBlueView;
import com.huawei.android.remotecontrol.tag.p092ui.view.SingleSearchingRippleView;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.findnetwork.FindNetwork;
import com.huawei.hms.findnetwork.bean.BtMeasureResult;
import com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback;
import com.huawei.hms.findnetwork.comm.request.bean.SoundRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkConfigResult;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.ErrorCode;
import com.huawei.hms.p148ui.SafeIntent;
import eg.AbstractC9478g;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import nf.C11690w;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0225l;
import p227dg.C9097b;
import p227dg.C9120m0;
import p514o9.C11829c;
import p514o9.C11842p;
import p521og.C11880m;
import p616rk.C12515a;
import p664u0.C13108a;
import p774xg.C13811a;
import p809yg.C13981a;
import p851zp.InterfaceC14356c;
import p851zp.InterfaceC14358e;
import sk.C12809f;

/* loaded from: classes4.dex */
public class BluetoothNavigationActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: Z */
    public static AlertDialog f20205Z = null;

    /* renamed from: a0 */
    public static int f20206a0 = 216;

    /* renamed from: b0 */
    public static float f20207b0 = 97.5f;

    /* renamed from: c0 */
    public static float f20208c0 = 37.0f;

    /* renamed from: d0 */
    public static float f20209d0 = 28.0f;

    /* renamed from: e0 */
    public static final Set<Integer> f20210e0 = new C4413b();

    /* renamed from: A */
    public TextView f20211A;

    /* renamed from: B */
    public TextView f20212B;

    /* renamed from: C */
    public TextView f20213C;

    /* renamed from: D */
    public ImageView f20214D;

    /* renamed from: E */
    public String f20215E;

    /* renamed from: F */
    public String f20216F;

    /* renamed from: G */
    public String f20217G;

    /* renamed from: I */
    public int f20219I;

    /* renamed from: J */
    public String f20220J;

    /* renamed from: K */
    public String f20221K;

    /* renamed from: L */
    public Context f20222L;

    /* renamed from: M */
    public long f20223M;

    /* renamed from: S */
    public AlertDialog f20229S;

    /* renamed from: T */
    public AlertDialog f20230T;

    /* renamed from: V */
    public int f20232V;

    /* renamed from: Y */
    public C4419h f20235Y;

    /* renamed from: q */
    public long f20237q;

    /* renamed from: r */
    public SingleSearchingRippleView f20238r;

    /* renamed from: s */
    public SingleBlueView f20239s;

    /* renamed from: t */
    public CircleRing f20240t;

    /* renamed from: u */
    public View f20241u;

    /* renamed from: v */
    public View f20242v;

    /* renamed from: x */
    public View f20244x;

    /* renamed from: y */
    public ImageView f20245y;

    /* renamed from: z */
    public ImageView f20246z;

    /* renamed from: p */
    public volatile boolean f20236p = true;

    /* renamed from: w */
    public boolean f20243w = false;

    /* renamed from: H */
    public boolean f20218H = false;

    /* renamed from: N */
    public int f20224N = 0;

    /* renamed from: O */
    public boolean f20225O = true;

    /* renamed from: P */
    public boolean f20226P = false;

    /* renamed from: Q */
    public Handler f20227Q = new Handler(Looper.myLooper());

    /* renamed from: R */
    public BluetoothStatueReceiver f20228R = null;

    /* renamed from: U */
    public boolean f20231U = false;

    /* renamed from: W */
    public final Runnable f20233W = new Runnable() { // from class: bg.u
        @Override // java.lang.Runnable
        public final void run() {
            this.f5653a.m26637U2();
        }
    };

    /* renamed from: X */
    public Handler f20234X = new HandlerC4412a();

    public class BluetoothStatueReceiver extends BroadcastReceiver {
        public BluetoothStatueReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && 10 == new SafeIntent(intent).getIntExtra("android.bluetooth.adapter.extra.STATE", 0)) {
                C13981a.m83989i("BluetoothNavigationActivity", "receiver bluetooth close");
                BluetoothNavigationActivity.this.f20224N = 11;
                BluetoothNavigationActivity.this.finish();
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.tag.ui.BluetoothNavigationActivity$a */
    public class HandlerC4412a extends Handler {
        public HandlerC4412a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C13981a.m83989i("BluetoothNavigationActivity", "handleMessage, msg.what: " + message.what);
            if (message.what == 1001) {
                if (TextUtils.equals("showDialog", (String) message.obj)) {
                    BluetoothNavigationActivity.this.f20224N = 0;
                }
                BluetoothNavigationActivity.this.finish();
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.tag.ui.BluetoothNavigationActivity$b */
    public class C4413b extends HashSet<Integer> {
        public C4413b() {
            add(Integer.valueOf(ErrorCode.STATUS_ERROR_MEASURERESULT_RUNING));
            add(Integer.valueOf(ErrorCode.CODE_TAG_COMMAND_EXECUTE_FAIL));
            add(Integer.valueOf(ErrorCode.CODE_DEVICE_BUSY));
            add(Integer.valueOf(ErrorCode.CODE_OTA));
            add(Integer.valueOf(ErrorCode.CODE_DECLINE_TAG_BLE_MEASURE));
            add(Integer.valueOf(ErrorCode.CODE_BLUETOOTH_PERMISSION_FAILED));
            add(Integer.valueOf(ErrorCode.CODE_LOCATION_PERMISSION_FAILED));
            add(Integer.valueOf(ErrorCode.CODE_DECLINE_TAG_SOUND));
            add(Integer.valueOf(ErrorCode.CODE_TAG_NOT_EXISTS));
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.tag.ui.BluetoothNavigationActivity$c */
    public class C4414c extends AbstractC9478g {
        public C4414c() {
        }

        /* renamed from: d */
        public /* synthetic */ void m26714d(Bitmap bitmap) {
            BluetoothNavigationActivity.this.f20214D.setImageBitmap(bitmap);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                final Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new URL(BluetoothNavigationActivity.this.f20221K).openStream());
                BluetoothNavigationActivity.this.runOnUiThread(new Runnable() { // from class: bg.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f5614a.m26714d(bitmapDecodeStream);
                    }
                });
            } catch (Exception e10) {
                C13981a.m83988e("BluetoothNavigationActivity", "invalid icon url:" + BluetoothNavigationActivity.this.f20221K + " " + e10.getMessage());
                BluetoothNavigationActivity.this.f20214D.setImageResource(R$drawable.nearlink_default);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.tag.ui.BluetoothNavigationActivity$d */
    public class C4415d extends FindNetworkCallback<BtMeasureResult> {
        public C4415d() {
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onFail(FindNetworkResult<BtMeasureResult> findNetworkResult) throws JSONException {
            int respCode = findNetworkResult.getRespCode();
            C13981a.m83988e("BluetoothNavigationActivity", "startBTMeasure onFail：" + findNetworkResult.getDescription() + ", Code:" + respCode);
            if (BluetoothNavigationActivity.this.f20219I == 1 && respCode == 907201166) {
                BluetoothNavigationActivity.this.f20224N = respCode;
                C9120m0.m57407m1(BluetoothNavigationActivity.this.f20222L, BluetoothNavigationActivity.this.f20215E, BluetoothNavigationActivity.this.f20234X);
            } else {
                BluetoothNavigationActivity.this.f20227Q.removeCallbacks(BluetoothNavigationActivity.this.f20233W);
                BluetoothNavigationActivity.this.m26687E2(respCode);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("returnCode", respCode);
            } catch (JSONException e10) {
                C13981a.m83988e("BluetoothNavigationActivity", "reportTagEventBI exception:" + e10.getMessage());
            }
            C9120m0.m57389g1(BluetoothNavigationActivity.this.f20222L, "TAG_BLUETOOTH_NAVIGATE_FAIL", BluetoothNavigationActivity.this.f20216F, jSONObject, respCode);
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onSuccess(FindNetworkResult<BtMeasureResult> findNetworkResult) {
            C13981a.m83989i("BluetoothNavigationActivity", "startBTMeasure onSuccess");
            BluetoothNavigationActivity.this.m26672s3(true);
            BluetoothNavigationActivity.this.f20227Q.removeCallbacks(BluetoothNavigationActivity.this.f20233W);
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onUpdate(FindNetworkResult<BtMeasureResult> findNetworkResult) {
            C13981a.m83989i("BluetoothNavigationActivity", "startBTMeasure onUpdate");
            BluetoothNavigationActivity.this.f20227Q.removeCallbacks(BluetoothNavigationActivity.this.f20233W);
            if (BluetoothNavigationActivity.this.m26693J2(findNetworkResult)) {
                BluetoothNavigationActivity.this.m26689F2(findNetworkResult.getData());
                BluetoothNavigationActivity.this.f20227Q.postDelayed(BluetoothNavigationActivity.this.f20233W, 20000L);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.tag.ui.BluetoothNavigationActivity$e */
    public class C4416e implements FindNetworkSoundCallback {
        public C4416e() {
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onFail(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) throws JSONException {
            int respCode = findNetworkConfigResult.getRespCode();
            C13981a.m83988e("BluetoothNavigationActivity", "startSound onFail:" + findNetworkConfigResult.getDescription() + ", code:" + respCode);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("returnCode", respCode);
            } catch (JSONException e10) {
                C13981a.m83988e("BluetoothNavigationActivity", "reportTagEventBI exception:" + e10.getMessage());
            }
            C9120m0.m57389g1(BluetoothNavigationActivity.this.f20222L, "TAG_START_SOUND_FAIL", BluetoothNavigationActivity.this.f20216F, jSONObject, respCode);
            if (respCode == 907201165 || respCode == 0 || BluetoothNavigationActivity.f20210e0.contains(Integer.valueOf(respCode))) {
                return;
            }
            C11880m.m71337d(BluetoothNavigationActivity.this.f20222L, BluetoothNavigationActivity.this.getString(R$string.sound_failed));
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onFinished(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("BluetoothNavigationActivity", "startSound onFinished");
            BluetoothNavigationActivity.this.f20240t.stop();
            BluetoothNavigationActivity.this.f20226P = false;
            BluetoothNavigationActivity.this.m26678w3();
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onSuccess(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("BluetoothNavigationActivity", "startSound onSuccess:" + findNetworkConfigResult.getRespCode());
            BluetoothNavigationActivity.this.m26683z3();
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onUpdate(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("BluetoothNavigationActivity", "startSound onUpdate");
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.tag.ui.BluetoothNavigationActivity$f */
    public class RunnableC4417f implements Runnable {
        public RunnableC4417f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C13981a.m83989i("BluetoothNavigationActivity", "mainDevice Clicked startSound");
            BluetoothNavigationActivity.this.f20240t.stop();
            BluetoothNavigationActivity.this.m26678w3();
            BluetoothNavigationActivity.this.f20226P = false;
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.tag.ui.BluetoothNavigationActivity$g */
    public class CountDownTimerC4418g extends CountDownTimer {

        /* renamed from: a */
        public final /* synthetic */ Button f20253a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CountDownTimerC4418g(long j10, long j11, Button button) {
            super(j10, j11);
            this.f20253a = button;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            BluetoothNavigationActivity.this.finish();
            C13981a.m83989i("BluetoothNavigationActivity", "showLongTimeDialog click cancel");
            C11690w.m69700W(BluetoothNavigationActivity.this.f20215E, "bluetoothOperation", "bluetoothBusiness", "showLongTimeDialog click cancel", "0", null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            int seconds = ((int) TimeUnit.MILLISECONDS.toSeconds(j10)) + 1;
            this.f20253a.setText(BluetoothNavigationActivity.this.getResources().getQuantityString(R$plurals.precision_navigate_too_long_exit, seconds, Integer.valueOf(seconds)));
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.tag.ui.BluetoothNavigationActivity$h */
    public class C4419h extends BroadcastReceiver {
        public C4419h() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C13981a.m83988e("BluetoothNavigationActivity", "BluetoothLocationStatusReceiver error");
                return;
            }
            String action = new SafeIntent(intent).getAction();
            C13981a.m83989i("BluetoothNavigationActivity", "BluetoothLocationStatusReceiver, receiverMsg: " + action);
            if ((action.equals("android.location.MODE_CHANGED") || action.equals("android.location.PROVIDERS_CHANGED")) && C13811a.m82829z(context)) {
                BluetoothNavigationActivity.this.m26707n3();
            }
        }

        public /* synthetic */ C4419h(BluetoothNavigationActivity bluetoothNavigationActivity, HandlerC4412a handlerC4412a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.tag.ui.BluetoothNavigationActivity$i */
    public class C4420i implements FindNetworkSoundCallback {

        /* renamed from: a */
        public final InterfaceC14358e f20256a;

        public C4420i(InterfaceC14358e interfaceC14358e) {
            this.f20256a = interfaceC14358e;
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onFail(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) throws JSONException {
            int respCode = findNetworkConfigResult.getRespCode();
            C9120m0.m57422r1(BluetoothNavigationActivity.this.f20222L, respCode, BluetoothNavigationActivity.this.getString(R$string.bluetooth_navigate_exception));
            C13981a.m83988e("BluetoothNavigationActivity", "stopSound onFail:" + findNetworkConfigResult.getDescription() + ", code:" + respCode);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("returnCode", respCode);
            } catch (JSONException e10) {
                C13981a.m83988e("BluetoothNavigationActivity", "reportTagEventBI exception:" + e10.getMessage());
            }
            C9120m0.m57389g1(BluetoothNavigationActivity.this.f20222L, "TAG_START_SOUND_FAIL", BluetoothNavigationActivity.this.f20216F, jSONObject, respCode);
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onFinished(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("BluetoothNavigationActivity", "stopSound onFinished");
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onSuccess(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            this.f20256a.execute();
        }

        @Override // com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback
        public void onUpdate(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult) {
            C13981a.m83989i("BluetoothNavigationActivity", "stopSound onUpdate");
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.tag.ui.BluetoothNavigationActivity$j */
    public static class C4421j extends FindNetworkCallback<String> {

        /* renamed from: b */
        public final InterfaceC14358e f20258b;

        public C4421j(InterfaceC14358e interfaceC14358e) {
            this.f20258b = interfaceC14358e;
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onSuccess(FindNetworkResult<String> findNetworkResult) {
            this.f20258b.execute();
        }
    }

    /* renamed from: B3 */
    private void m26616B3() {
        if ((C11829c.m70502B0(this) || C11829c.m70499A0(this)) && this.f20229S == null) {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setMessage(R$string.suggest_use_in_fullscreen).setPositiveButton(R$string.phonefinder_dialog_know, new DialogInterface.OnClickListener() { // from class: bg.y
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    dialogInterface.dismiss();
                }
            }).setCancelable(true).create();
            this.f20229S = alertDialogCreate;
            alertDialogCreate.setCanceledOnTouchOutside(false);
            this.f20229S.show();
        }
    }

    /* renamed from: G3 */
    private void m26619G3(float f10) {
        this.f20239s.setVisibility(0);
        this.f20239s.stop();
        this.f20239s.initOuterAnimatorWithPercent(f10);
        this.f20239s.start();
    }

    /* renamed from: H2 */
    private void m26620H2() {
        if (this.f20225O) {
            return;
        }
        m26691G2(R$color.blue_out_precision, R$color.black_out_precision, R$color.green_inside_precision, R$color.black_inside_precision);
        this.f20225O = true;
        m26669q3(getDrawable(R$drawable.precicion_navigation_imbu_bg));
    }

    /* renamed from: K2 */
    private AnimationSet m26621K2() {
        return (AnimationSet) AnimationUtils.loadAnimation(this, R$anim.heart_beat_anim);
    }

    /* renamed from: L2 */
    private void m26622L2() {
        if (C11842p.m70762R0()) {
            View viewFindViewById = findViewById(R$id.tv_bluetooth_find_main);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewFindViewById.getLayoutParams();
            marginLayoutParams.topMargin = C11842p.m70840n(this, f20206a0);
            viewFindViewById.setLayoutParams(marginLayoutParams);
            ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R$id.constraint_icon);
            int iApplyDimension = (int) TypedValue.applyDimension(1, f20207b0, getResources().getDisplayMetrics());
            int iApplyDimension2 = (int) TypedValue.applyDimension(1, f20208c0, getResources().getDisplayMetrics());
            int iApplyDimension3 = (int) TypedValue.applyDimension(1, f20209d0, getResources().getDisplayMetrics());
            constraintLayout.setPadding(iApplyDimension3, iApplyDimension, iApplyDimension3, iApplyDimension2);
        }
    }

    /* renamed from: N2 */
    private void m26625N2() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f20215E = safeIntent.getStringExtra("TagSN");
        this.f20216F = safeIntent.getStringExtra("itemName");
        this.f20220J = safeIntent.getStringExtra("subModelId");
        this.f20221K = safeIntent.getStringExtra("iconUrl");
        this.f20217G = safeIntent.getStringExtra("modelId");
        this.f20218H = safeIntent.getBooleanExtra("mainDevice", false);
        this.f20219I = safeIntent.getIntExtra("componentType", 0);
        View viewM76829b = C12809f.m76829b(this, R$id.sounding_im_bu);
        this.f20241u = viewM76829b;
        viewM76829b.setOnClickListener(this);
        this.f20242v = C12809f.m76829b(this, R$id.sounding_im_bu_bg);
        this.f20240t = (CircleRing) C12809f.m76829b(this, R$id.circle_ring);
        m26672s3(true);
        m26622L2();
        C12809f.m76829b(this, R$id.cancel_im_bu).setOnClickListener(this);
        this.f20244x = C12809f.m76829b(this, R$id.cancel_im_bu_bg);
        this.f20239s = (SingleBlueView) C12809f.m76829b(this, R$id.blue_circle);
        this.f20245y = (ImageView) C12809f.m76829b(this, R$id.relat_outside);
        this.f20246z = (ImageView) C12809f.m76829b(this, R$id.relat_inside);
        this.f20211A = (TextView) C12809f.m76829b(this, R$id.tv_bluetooth_find_main);
        this.f20212B = (TextView) C12809f.m76829b(this, R$id.second_basic_tv);
        this.f20213C = (TextView) C12809f.m76829b(this, R$id.second_change_tv);
        ((TextView) C12809f.m76829b(this, R$id.tv_user_item_name)).setText(this.f20216F);
        this.f20214D = (ImageView) C12809f.m76829b(this, R$id.tag_icon);
        m26694M2();
        SingleSearchingRippleView singleSearchingRippleView = (SingleSearchingRippleView) C12809f.m76829b(this, R$id.searching_ripple_view);
        this.f20238r = singleSearchingRippleView;
        singleSearchingRippleView.start();
        this.f20232V = C9097b.m57301k(this.f20217G);
        if (C11690w.m69742w(this.f20215E)) {
            m26684A3(new InterfaceC14358e() { // from class: bg.o
                @Override // p851zp.InterfaceC14358e
                public final void execute() {
                    C13981a.m83989i("BluetoothNavigationActivity", "stopSound onSuccess");
                }
            });
        }
    }

    /* renamed from: U2 */
    public /* synthetic */ void m26637U2() {
        if (this.f20231U) {
            C13981a.m83989i("BluetoothNavigationActivity", "noResponse finish");
            C11880m.m71337d(this, getString(R$string.bluetooth_navigate_exception));
            this.f20227Q.postDelayed(new RunnableC1217n(this), 2200L);
        } else {
            C13981a.m83989i("BluetoothNavigationActivity", "noResponse retry");
            this.f20231U = true;
            m26685C3();
            m26711v3();
        }
    }

    /* renamed from: f3 */
    public static /* synthetic */ void m26652f3(Exception exc) {
        C13981a.m83988e("BluetoothNavigationActivity", "startBTMeasure error：" + exc.getMessage());
    }

    /* renamed from: h3 */
    public static /* synthetic */ void m26655h3(Exception exc) {
        C13981a.m83988e("BluetoothNavigationActivity", "startSound error：" + exc.getMessage());
    }

    /* renamed from: i3 */
    public static /* synthetic */ void m26657i3(Exception exc) {
        C13981a.m83988e("BluetoothNavigationActivity", "stopBTMeasure error：" + exc.getMessage());
    }

    /* renamed from: l3 */
    public static /* synthetic */ void m26661l3(Exception exc) {
        C13981a.m83988e("BluetoothNavigationActivity", "stopSound error：" + exc.getMessage());
    }

    /* renamed from: o3 */
    private void m26666o3() {
        this.f20228R = new BluetoothStatueReceiver();
        registerReceiver(this.f20228R, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
    }

    /* renamed from: q3 */
    private void m26669q3(Drawable drawable) {
        this.f20242v.setBackground(drawable);
        this.f20244x.setBackground(drawable);
    }

    /* renamed from: s3 */
    public void m26672s3(boolean z10) {
        if (z10) {
            this.f20241u.setEnabled(true);
            this.f20241u.setAlpha(1.0f);
            m26678w3();
        } else {
            if (this.f20226P) {
                this.f20226P = false;
                this.f20240t.stop();
            }
            this.f20241u.setEnabled(false);
            this.f20241u.setAlpha(0.3f);
            m26683z3();
        }
    }

    /* renamed from: u3 */
    public void m26675u3() {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(R$string.bluetooth_navigate_too_long_title).setMessage(2 == this.f20232V ? getResources().getQuantityString(R$plurals.bluetooth_navigate_too_long_detail_device, 5, 5) : getResources().getQuantityString(R$plurals.bluetooth_navigate_too_long_detail, 5, 5)).setPositiveButton(getResources().getQuantityString(R$plurals.precision_navigate_too_long_exit, 5, 5), new DialogInterface.OnClickListener() { // from class: bg.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f5626a.m26700b3(dialogInterface, i10);
            }
        }).setNegativeButton(R$string.precision_navigate_too_long_use, (DialogInterface.OnClickListener) null).create();
        this.f20230T = alertDialogCreate;
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: bg.h
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f5629a.m26702d3(dialogInterface);
            }
        });
        this.f20230T.setCanceledOnTouchOutside(false);
        this.f20230T.show();
        C11690w.m69700W(this.f20215E, "bluetoothOperation", "bluetoothBusiness", "showLongTimeDialog", "0", null);
    }

    /* renamed from: w3 */
    public void m26678w3() {
        if (this.f20243w || this.f20226P) {
            return;
        }
        this.f20243w = true;
        this.f20241u.startAnimation(m26621K2());
    }

    /* renamed from: x3 */
    private void m26680x3() {
        C13981a.m83989i("BluetoothNavigationActivity", "to startSound");
        this.f20226P = true;
        m26683z3();
        this.f20240t.start();
        C0225l.m1577a(new InterfaceC14356c() { // from class: bg.i
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return this.f5631a.m26704g3();
            }
        }, new Consumer() { // from class: bg.j
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                BluetoothNavigationActivity.m26655h3((Exception) obj);
            }
        });
    }

    /* renamed from: z3 */
    public void m26683z3() {
        if (this.f20243w) {
            this.f20243w = false;
            this.f20241u.clearAnimation();
        }
    }

    /* renamed from: A3 */
    public final void m26684A3(final InterfaceC14358e interfaceC14358e) {
        C13981a.m83989i("BluetoothNavigationActivity", "to stopSound");
        this.f20240t.stop();
        this.f20226P = false;
        m26678w3();
        C0225l.m1577a(new InterfaceC14356c() { // from class: bg.e
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return this.f5621a.m26706k3(interfaceC14358e);
            }
        }, new Consumer() { // from class: bg.f
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                BluetoothNavigationActivity.m26661l3((Exception) obj);
            }
        });
    }

    /* renamed from: C3 */
    public final void m26685C3() {
        m26672s3(false);
        if (this.f20236p) {
            this.f20236p = false;
            this.f20239s.stop();
            this.f20239s.setVisibility(4);
            this.f20211A.setText(getString(R$string.no_connect));
            this.f20213C.setVisibility(0);
            this.f20213C.setText(getString(R$string.try_moving_location));
            this.f20212B.setVisibility(8);
            this.f20238r.start();
            m26620H2();
        }
    }

    /* renamed from: D3 */
    public final void m26686D3() {
        BluetoothStatueReceiver bluetoothStatueReceiver = this.f20228R;
        if (bluetoothStatueReceiver != null) {
            unregisterReceiver(bluetoothStatueReceiver);
        }
    }

    /* renamed from: E2 */
    public final void m26687E2(int i10) {
        C9120m0.m57422r1(this, i10, getString(R$string.bluetooth_navigate_exception));
        if (i10 == 907201165) {
            C13981a.m83989i("BluetoothNavigationActivity", "tag connecting");
            return;
        }
        if (f20210e0.contains(Integer.valueOf(i10))) {
            this.f20224N = i10;
            this.f20227Q.postDelayed(new RunnableC1217n(this), 2200L);
        } else {
            if (i10 == 0 || isFinishing()) {
                return;
            }
            m26685C3();
            m26711v3();
        }
    }

    /* renamed from: E3 */
    public final void m26688E3() {
        if (this.f20235Y != null) {
            C13981a.m83989i("BluetoothNavigationActivity", "unregisterLocationReceiver");
            try {
                unregisterReceiver(this.f20235Y);
                this.f20235Y = null;
            } catch (Exception unused) {
                C13981a.m83988e("BluetoothNavigationActivity", "mLocationStatusReceiver unregister fail");
            }
        }
    }

    /* renamed from: F2 */
    public void m26689F2(BtMeasureResult btMeasureResult) {
        int flag = btMeasureResult.getFlag();
        float percentage = btMeasureResult.getPercentage();
        C13981a.m83989i("BluetoothNavigationActivity", "rssi: " + btMeasureResult.getRssi() + ", percentage: " + percentage + ", flag: " + flag);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f20237q >= RippleView.SINGLE_RIPPLE_TIME) {
            this.f20237q = jCurrentTimeMillis;
            if (flag == 1) {
                C13981a.m83989i("BluetoothNavigationActivity", "nearBy");
                m26690F3();
                m26709r3(getString(R$string.nearby_location), getString(R$string.try_playing_ringtone));
            } else {
                if (flag == 5) {
                    C13981a.m83989i("BluetoothNavigationActivity", "short distance");
                    m26619G3(percentage);
                    m26620H2();
                    m26709r3(getString(R$string.strong_signal), getString(R$string.walk_around));
                    return;
                }
                if (flag != 10) {
                    C13981a.m83989i("BluetoothNavigationActivity", "unknown flag");
                    return;
                }
                C13981a.m83989i("BluetoothNavigationActivity", "long distance");
                m26619G3(percentage);
                m26620H2();
                m26709r3(getString(R$string.weak_signal), getString(R$string.walk_around));
            }
        }
    }

    /* renamed from: F3 */
    public final void m26690F3() {
        this.f20239s.setVisibility(0);
        this.f20239s.stop();
        this.f20239s.initOuterAnimatorFullScreen();
        this.f20239s.start();
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: G2 */
    public final void m26691G2(int i10, int i11, int i12, int i13) {
        ValueAnimator valueAnimatorOfArgb = ValueAnimator.ofArgb(getResources().getColor(i10), getResources().getColor(i11));
        valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: bg.q
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f5645a.m26695O2(valueAnimator);
            }
        });
        valueAnimatorOfArgb.setDuration(1000L);
        ValueAnimator valueAnimatorOfArgb2 = ValueAnimator.ofArgb(getResources().getColor(i12), getResources().getColor(i13));
        valueAnimatorOfArgb2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: bg.r
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f5647a.m26696P2(valueAnimator);
            }
        });
        valueAnimatorOfArgb2.setDuration(1000L);
        valueAnimatorOfArgb2.start();
        valueAnimatorOfArgb.start();
    }

    /* renamed from: I2 */
    public final void m26692I2() {
        C13981a.m83989i("BluetoothNavigationActivity", "checkLocationStatus");
        if (C13811a.m82829z(this)) {
            m26707n3();
            return;
        }
        AlertDialog alertDialog = f20205Z;
        if (alertDialog == null || !alertDialog.isShowing()) {
            m26710t3();
        }
    }

    /* renamed from: J2 */
    public final boolean m26693J2(FindNetworkResult<BtMeasureResult> findNetworkResult) {
        if (isFinishing()) {
            C13981a.m83989i("BluetoothNavigationActivity", "activity isFinishing");
            m26712y3(new InterfaceC14358e() { // from class: bg.p
                @Override // p851zp.InterfaceC14358e
                public final void execute() {
                    C13981a.m83989i("BluetoothNavigationActivity", "stopBluetoothNavigate onSuccess");
                }
            });
            return false;
        }
        if (findNetworkResult != null && findNetworkResult.getData() != null) {
            return true;
        }
        C13981a.m83989i("BluetoothNavigationActivity", "startBluetoothNavigate onUpdate null");
        return false;
    }

    /* renamed from: M2 */
    public final void m26694M2() {
        C13981a.m83989i("BluetoothNavigationActivity", "mTagIcon：" + this.f20221K);
        if (TextUtils.isEmpty(this.f20221K)) {
            C13981a.m83988e("BluetoothNavigationActivity", "no icon url！");
        } else {
            C12515a.m75110o().m75172d(new C4414c());
        }
    }

    /* renamed from: O2 */
    public final /* synthetic */ void m26695O2(ValueAnimator valueAnimator) {
        this.f20245y.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    /* renamed from: P2 */
    public final /* synthetic */ void m26696P2(ValueAnimator valueAnimator) {
        this.f20246z.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    /* renamed from: Y2 */
    public final /* synthetic */ void m26697Y2(DialogInterface dialogInterface) {
        finish();
    }

    /* renamed from: Z2 */
    public final /* synthetic */ void m26698Z2(DialogInterface dialogInterface, int i10) {
        finish();
    }

    /* renamed from: a3 */
    public final /* synthetic */ void m26699a3(DialogInterface dialogInterface, int i10) {
        C13811a.m82788F(this);
        if (C13811a.m82829z(this)) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: b3 */
    public final /* synthetic */ void m26700b3(DialogInterface dialogInterface, int i10) {
        finish();
    }

    /* renamed from: c3 */
    public final /* synthetic */ void m26701c3(CountDownTimer countDownTimer, View view) {
        C13981a.m83989i("BluetoothNavigationActivity", "showLongTimeDialog click continue");
        countDownTimer.cancel();
        this.f20230T.dismiss();
        this.f20227Q.postDelayed(new RunnableC1182b(this), 600000L);
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hidisk.remotecontrol.intent.REFRESH_PORTAL_LOGIN"));
        C11690w.m69700W(this.f20215E, "bluetoothOperation", "bluetoothBusiness", "showLongTimeDialog click continue", "0", null);
    }

    /* renamed from: d3 */
    public final /* synthetic */ void m26702d3(DialogInterface dialogInterface) {
        Button button = this.f20230T.getButton(-1);
        Button button2 = this.f20230T.getButton(-2);
        final CountDownTimer countDownTimerStart = new CountDownTimerC4418g(5000L, 1000L, button).start();
        button2.setOnClickListener(new View.OnClickListener() { // from class: bg.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5649a.m26701c3(countDownTimerStart, view);
            }
        });
    }

    /* renamed from: e3 */
    public final /* synthetic */ Task m26703e3() throws Exception {
        return FindNetwork.getFindNetworkEngine(getApplicationContext()).startBTMeasure(this.f20215E, new C4415d());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void finish() {
        if (this.f20236p) {
            m26712y3(new InterfaceC14358e() { // from class: bg.z
                @Override // p851zp.InterfaceC14358e
                public final void execute() {
                    C13981a.m83989i("BluetoothNavigationActivity", "stopBluetoothNavigate onSuccess");
                }
            });
        }
        if (this.f20226P) {
            m26684A3(new InterfaceC14358e() { // from class: bg.a0
                @Override // p851zp.InterfaceC14358e
                public final void execute() {
                    C13981a.m83989i("BluetoothNavigationActivity", "stopSound onSuccess");
                }
            });
        }
        this.f20238r.stop();
        m26683z3();
        this.f20240t.stop();
        this.f20227Q.removeCallbacksAndMessages(null);
        Intent intent = new Intent();
        intent.putExtra("tagSn", this.f20215E);
        setResult(this.f20224N, intent);
        C9120m0.m57383e1(this.f20222L, "mecloud_findmyphone_bluetooth_navigate_exit", this.f20215E, this.f20216F, this.f20217G, this.f20224N);
        C11690w.m69700W(this.f20215E, "bluetoothOperation", "bluetoothBusiness", "BluetoothNavigationActivity finish tagNavigationResultCode: " + this.f20224N + ", duringTime: " + (System.currentTimeMillis() - this.f20223M), String.valueOf(this.f20224N), null);
        super.finish();
    }

    /* renamed from: g3 */
    public final /* synthetic */ Task m26704g3() throws Exception {
        return FindNetwork.getFindNetworkEngine((Activity) this).startSound(this.f20215E, true, new C4416e());
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = new Configuration();
        configuration.setToDefaults();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return resources;
    }

    /* renamed from: j3 */
    public final /* synthetic */ Task m26705j3(InterfaceC14358e interfaceC14358e) throws Exception {
        return FindNetwork.getFindNetworkEngine((Activity) this).stopBTMeasure(this.f20215E, new C4421j(interfaceC14358e));
    }

    /* renamed from: k3 */
    public final /* synthetic */ Task m26706k3(InterfaceC14358e interfaceC14358e) throws Exception {
        return FindNetwork.getFindNetworkEngine((Activity) this).stopSound(this.f20215E, true, new C4420i(interfaceC14358e));
    }

    /* renamed from: n3 */
    public void m26707n3() {
        AlertDialog alertDialog = f20205Z;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        C13981a.m83989i("BluetoothNavigationActivity", "locationDialogDismiss");
        f20205Z.dismiss();
        f20205Z = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (R$id.cancel_im_bu == id2) {
            C13981a.m83989i("BluetoothNavigationActivity", "Clicked finish");
            finish();
            return;
        }
        if (R$id.sounding_im_bu != id2 || C0209d.m1226Y0()) {
            return;
        }
        if (this.f20218H) {
            C13981a.m83989i("BluetoothNavigationActivity", "mainDevice Clicked startSound");
            m26680x3();
            m26683z3();
            this.f20240t.start();
            new Handler().postDelayed(new RunnableC4417f(), 5000L);
            C11690w.m69700W(this.f20215E, "bluetoothOperation", "bluetoothBusiness", "mainDevice Clicked startSound", "0", null);
            return;
        }
        if (this.f20226P) {
            C13981a.m83989i("BluetoothNavigationActivity", "ancDevice Clicked stopSound");
            m26684A3(new InterfaceC14358e() { // from class: bg.v
                @Override // p851zp.InterfaceC14358e
                public final void execute() {
                    C13981a.m83989i("BluetoothNavigationActivity", "stopSound onSuccess");
                }
            });
            this.f20240t.stop();
            m26678w3();
            C11690w.m69700W(this.f20215E, "bluetoothOperation", "bluetoothBusiness", "ancDevice Clicked stopSound", "0", null);
            return;
        }
        C13981a.m83989i("BluetoothNavigationActivity", "ancDevice Clicked startSound");
        m26680x3();
        m26683z3();
        this.f20240t.start();
        C11690w.m69700W(this.f20215E, "bluetoothOperation", "bluetoothBusiness", "ancDevice Clicked startSound", "0", null);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70717C0(this);
        m26616B3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f20222L = this;
        C11842p.m70717C0(this);
        setContentView(R$layout.activity_bluetooth_navigation);
        C13981a.m83989i("BluetoothNavigationActivity", "WapFindPhoneActivity to BluetoothNavigationActivity onCreate");
        this.f20223M = System.currentTimeMillis();
        m26625N2();
        m26708p3();
        m26692I2();
        m26711v3();
        m26666o3();
        m26616B3();
        this.f20227Q.postDelayed(new RunnableC1182b(this), 600000L);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        String str = "onDestroy, BluetoothNavigationActivity during time: " + (System.currentTimeMillis() - this.f20223M);
        super.onDestroy();
        m26686D3();
        AlertDialog alertDialog = this.f20230T;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f20230T.dismiss();
            this.f20230T = null;
        }
        m26707n3();
        m26688E3();
        C9120m0.m57419q1(this.f20223M, "startBluetoothNavigation");
        C11690w.m69700W(this.f20215E, "bluetoothOperation", "bluetoothBusiness", str, "0", null);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        C13981a.m83989i("BluetoothNavigationActivity", "onStop");
        this.f20238r.stop();
        m26683z3();
        this.f20240t.stop();
        if (this.f20236p) {
            C13981a.m83989i("BluetoothNavigationActivity", "to stopBluetoothNavigate");
            m26712y3(new InterfaceC14358e() { // from class: bg.w
                @Override // p851zp.InterfaceC14358e
                public final void execute() {
                    C13981a.m83989i("BluetoothNavigationActivity", "stopBluetoothNavigate onSuccess");
                }
            });
        }
        if (this.f20226P) {
            C13981a.m83989i("BluetoothNavigationActivity", "to stopSound");
            m26684A3(new InterfaceC14358e() { // from class: bg.x
                @Override // p851zp.InterfaceC14358e
                public final void execute() {
                    C13981a.m83989i("BluetoothNavigationActivity", "stopSound onSuccess");
                }
            });
        }
        finish();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        C13981a.m83989i("BluetoothNavigationActivity", "onWindowFocusChanged, focus: " + z10);
        if (z10) {
            m26692I2();
        }
    }

    /* renamed from: p3 */
    public final void m26708p3() {
        if (this.f20235Y == null) {
            C13981a.m83989i("BluetoothNavigationActivity", "registerLocationReceiver");
            this.f20235Y = new C4419h(this, null);
            IntentFilter intentFilter = new IntentFilter("android.location.MODE_CHANGED");
            intentFilter.addAction("android.location.PROVIDERS_CHANGED");
            registerReceiver(this.f20235Y, intentFilter);
        }
    }

    /* renamed from: r3 */
    public final void m26709r3(CharSequence charSequence, CharSequence charSequence2) {
        this.f20236p = true;
        this.f20238r.start();
        this.f20211A.setText(charSequence);
        if (charSequence2.equals(getString(R$string.try_playing_ringtone))) {
            this.f20212B.setText(charSequence2);
            this.f20212B.setVisibility(0);
            this.f20213C.setVisibility(8);
        } else {
            this.f20213C.setText(charSequence2);
            this.f20213C.setVisibility(0);
            this.f20212B.setVisibility(8);
        }
    }

    /* renamed from: t3 */
    public final void m26710t3() {
        C13981a.m83989i("BluetoothNavigationActivity", "showLocationDialog");
        String string = getString(R$string.location_disable_title);
        try {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(string).setMessage(getString(R$string.location_disable_message)).setCancelable(true).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: bg.a
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.f5612a.m26697Y2(dialogInterface);
                }
            }).setNegativeButton(R$string.cancel, new DialogInterface.OnClickListener() { // from class: bg.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.f5639a.m26698Z2(dialogInterface, i10);
                }
            }).setPositiveButton(R$string.pf_tips_start_now, new DialogInterface.OnClickListener() { // from class: bg.t
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.f5652a.m26699a3(dialogInterface, i10);
                }
            }).create();
            f20205Z = alertDialogCreate;
            alertDialogCreate.setCanceledOnTouchOutside(false);
            f20205Z.show();
        } catch (Exception unused) {
            C13981a.m83988e("BluetoothNavigationActivity", "showLocationDialog Exception");
        }
    }

    /* renamed from: v3 */
    public final void m26711v3() {
        C13981a.m83989i("BluetoothNavigationActivity", "to startBluetoothNavigate");
        this.f20227Q.postDelayed(this.f20233W, 20000L);
        C0225l.m1577a(new InterfaceC14356c() { // from class: bg.k
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return this.f5637a.m26703e3();
            }
        }, new Consumer() { // from class: bg.m
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                BluetoothNavigationActivity.m26652f3((Exception) obj);
            }
        });
    }

    /* renamed from: y3 */
    public final void m26712y3(final InterfaceC14358e interfaceC14358e) {
        C13981a.m83989i("BluetoothNavigationActivity", "to stopBluetoothNavigate");
        C0225l.m1577a(new InterfaceC14356c() { // from class: bg.c
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return this.f5617a.m26705j3(interfaceC14358e);
            }
        }, new Consumer() { // from class: bg.d
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                BluetoothNavigationActivity.m26657i3((Exception) obj);
            }
        });
    }
}
