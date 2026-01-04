package com.huawei.android.hicloud.oobe.p086ui.activity;

import ac.C0089a;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import cc.C1417a;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.oobe.R$color;
import com.huawei.android.hicloud.oobe.R$drawable;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import com.huawei.android.hicloud.oobe.R$plurals;
import com.huawei.android.hicloud.oobe.R$string;
import com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity;
import com.huawei.android.hicloud.oobe.p086ui.manager.IOpenTimeCallback;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.DisableSupportedRelativeLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBETopView;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.UnionSwitch;
import com.huawei.android.hicloud.p088ui.dialog.BetaDialog;
import com.huawei.android.hicloud.p088ui.dialog.BetaDialogInterface;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.AutoStyleButtonAnnotation;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.base.p103ui.uiextend.ScrollDisabledListView;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import fk.C9721b;
import gp.C10028c;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p015ak.C0226l0;
import p020ap.C1006a;
import p020ap.C1007b;
import p020ap.C1008c;
import p020ap.C1010e;
import p034bc.C1162b;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11840n;
import p514o9.C11841o;
import p514o9.C11842p;
import p572qb.C12300b0;
import p581qk.AbstractC12368e;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import p664u0.C13108a;
import p676ud.AlertDialogC13156c;
import p681uj.C13195l;
import p684un.C13227f;
import p709vj.C13452e;
import p709vj.InterfaceC13451d;
import p709vj.InterfaceC13456i;
import sk.C12809f;
import to.C13049a;
import vn.C13471c;

@AutoStyleButtonAnnotation
/* loaded from: classes3.dex */
public class UniformGuideBaseActivity extends OOBEBaseAuthActivity implements CompoundButton.OnCheckedChangeListener, IOpenTimeCallback, BetaDialogInterface {

    /* renamed from: B0 */
    public View f12562B0;

    /* renamed from: E0 */
    public ImageView f12565E0;

    /* renamed from: F0 */
    public Drawable f12566F0;

    /* renamed from: G0 */
    public Drawable f12567G0;

    /* renamed from: K0 */
    public OpenPhoneFinderReceiver f12571K0;

    /* renamed from: L0 */
    public AutoSizeButton f12572L0;

    /* renamed from: M */
    public ScrollView f12573M;

    /* renamed from: M0 */
    public HwProgressBar f12574M0;

    /* renamed from: N */
    public TextView f12575N;

    /* renamed from: N0 */
    public RelativeLayout f12576N0;

    /* renamed from: O */
    public TextView f12577O;

    /* renamed from: O0 */
    public Timer f12578O0;

    /* renamed from: P */
    public TextView f12579P;

    /* renamed from: P0 */
    public Context f12580P0;

    /* renamed from: Q */
    public TextView f12581Q;

    /* renamed from: Q0 */
    public AlertDialogC13156c f12582Q0;

    /* renamed from: R */
    public TextView f12583R;

    /* renamed from: S */
    public UnionSwitch f12585S;

    /* renamed from: T */
    public DisableSupportedRelativeLayout f12587T;

    /* renamed from: T0 */
    public ScrollDisabledListView f12588T0;

    /* renamed from: U */
    public DisableSupportedRelativeLayout f12589U;

    /* renamed from: U0 */
    public C1417a f12590U0;

    /* renamed from: V */
    public TextView f12591V;

    /* renamed from: V0 */
    public View f12592V0;

    /* renamed from: W */
    public View f12593W;

    /* renamed from: W0 */
    public View f12594W0;

    /* renamed from: X */
    public UnionSwitch f12595X;

    /* renamed from: Y */
    public UnionSwitch f12597Y;

    /* renamed from: Z */
    public UnionSwitch f12599Z;

    /* renamed from: a0 */
    public UnionSwitch f12601a0;

    /* renamed from: a1 */
    public boolean f12602a1;

    /* renamed from: b0 */
    public UnionSwitch f12603b0;

    /* renamed from: c0 */
    public UnionSwitch f12605c0;

    /* renamed from: d0 */
    public UnionSwitch f12607d0;

    /* renamed from: e0 */
    public UnionSwitch f12609e0;

    /* renamed from: f0 */
    public RelativeLayout f12611f0;

    /* renamed from: f1 */
    public ArrayList<String> f12612f1;

    /* renamed from: g0 */
    public DisableSupportedRelativeLayout f12613g0;

    /* renamed from: h0 */
    public RelativeLayout f12615h0;

    /* renamed from: i0 */
    public RelativeLayout f12617i0;

    /* renamed from: j0 */
    public DisableSupportedRelativeLayout f12619j0;

    /* renamed from: k0 */
    public RelativeLayout f12621k0;

    /* renamed from: l0 */
    public AlertDialog f12623l0;

    /* renamed from: m0 */
    public AlertDialog f12625m0;

    /* renamed from: n0 */
    public AlertDialog f12627n0;

    /* renamed from: o0 */
    public AlertDialog f12629o0;

    /* renamed from: p0 */
    public AlertDialog f12631p0;

    /* renamed from: q0 */
    public HwProgressBar f12633q0;

    /* renamed from: r0 */
    public AlertDialog f12635r0;

    /* renamed from: s0 */
    public Bundle f12636s0 = new Bundle();

    /* renamed from: t0 */
    public int f12637t0 = 0;

    /* renamed from: u0 */
    public boolean f12638u0 = false;

    /* renamed from: v0 */
    public boolean f12639v0 = false;

    /* renamed from: w0 */
    public boolean f12640w0 = false;

    /* renamed from: x0 */
    public boolean f12641x0 = false;

    /* renamed from: y0 */
    public boolean f12642y0 = false;

    /* renamed from: z0 */
    public boolean f12643z0 = false;

    /* renamed from: A0 */
    public boolean f12561A0 = false;

    /* renamed from: C0 */
    public boolean f12563C0 = true;

    /* renamed from: D0 */
    public boolean f12564D0 = true;

    /* renamed from: H0 */
    public String f12568H0 = "";

    /* renamed from: I0 */
    public C10028c f12569I0 = C10028c.m62182c0();

    /* renamed from: J0 */
    public long f12570J0 = 0;

    /* renamed from: R0 */
    public boolean f12584R0 = false;

    /* renamed from: S0 */
    public final C2859h f12586S0 = new C2859h();

    /* renamed from: X0 */
    public boolean f12596X0 = false;

    /* renamed from: Y0 */
    public HashMap<String, Boolean> f12598Y0 = new HashMap<>();

    /* renamed from: Z0 */
    public HashMap<String, Boolean> f12600Z0 = new HashMap<>();

    /* renamed from: b1 */
    public boolean f12604b1 = false;

    /* renamed from: c1 */
    public boolean f12606c1 = true;

    /* renamed from: d1 */
    public boolean f12608d1 = true;

    /* renamed from: e1 */
    public boolean f12610e1 = true;

    /* renamed from: g1 */
    public boolean f12614g1 = true;

    /* renamed from: h1 */
    public boolean f12616h1 = true;

    /* renamed from: i1 */
    public boolean f12618i1 = true;

    /* renamed from: j1 */
    public boolean f12620j1 = true;

    /* renamed from: k1 */
    public boolean f12622k1 = true;

    /* renamed from: l1 */
    public boolean f12624l1 = true;

    /* renamed from: m1 */
    public boolean f12626m1 = true;

    /* renamed from: n1 */
    public boolean f12628n1 = true;

    /* renamed from: o1 */
    public List<String> f12630o1 = new ArrayList();

    /* renamed from: p1 */
    public Handler f12632p1 = new HandlerC2852a();

    /* renamed from: q1 */
    public final Handler.Callback f12634q1 = new Handler.Callback() { // from class: zb.f
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f63331a.m16916r2(message);
        }
    };

    public class OpenPhoneFinderReceiver extends BroadcastReceiver {

        /* renamed from: a */
        public boolean f12644a = false;

        /* renamed from: b */
        public UniformGuideBaseActivity f12645b;

        public OpenPhoneFinderReceiver(UniformGuideBaseActivity uniformGuideBaseActivity) {
            this.f12645b = uniformGuideBaseActivity;
        }

        /* renamed from: a */
        public void m17019a(Context context) {
            if (this.f12644a) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_OPEN_AUTH_FAILE");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_COMPLETED");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_FAIL");
            C13108a.m78878b(context.getApplicationContext()).m78880c(this, intentFilter);
            this.f12644a = true;
        }

        /* renamed from: b */
        public void m17020b(Context context) {
            if (this.f12644a) {
                C13108a.m78878b(context.getApplicationContext()).m78883f(this);
                this.f12644a = false;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            if (hiCloudSafeIntent.getAction() == null) {
                C11839m.m70687e("UniformGuideBaseActivity", "HiSyncReceiver action is null");
                return;
            }
            if (this.f12645b == null) {
                return;
            }
            try {
                String action = hiCloudSafeIntent.getAction();
                C11839m.m70686d("UniformGuideBaseActivity", "onReceive ACTION=" + action);
                if ("com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT".equals(action)) {
                    boolean booleanExtra = hiCloudSafeIntent.getBooleanExtra("phonefinder_result", false);
                    int intExtra = hiCloudSafeIntent.getIntExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 0);
                    UniformGuideBaseActivity.this.mo16969c2();
                    if (UniformGuideBaseActivity.this.f12584R0) {
                        this.f12645b.m16939J2(booleanExtra, intExtra);
                    }
                } else if ("com.huawei.android.hicloud.intent.PHONEFINDER_OPEN_AUTH_FAILE".equals(action)) {
                    C11839m.m70688i("UniformGuideBaseActivity", "onReceive ACTION_PHONEFINDER_OPEN_AUTH_FAILE");
                } else if ("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_COMPLETED".equals(action)) {
                    this.f12645b.m16937I2(true);
                } else if ("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_FAIL".equals(action)) {
                    this.f12645b.m16937I2(false);
                }
            } catch (Exception unused) {
                C11839m.m70688i("UniformGuideBaseActivity", "onReceive intent getdata error");
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.UniformGuideBaseActivity$a */
    public class HandlerC2852a extends Handler {
        public HandlerC2852a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalAccessException, IllegalArgumentException {
            if (UniformGuideBaseActivity.this.isFinishing() || UniformGuideBaseActivity.this.isDestroyed()) {
                C11839m.m70688i("UniformGuideBaseActivity", "This Activity doesn't exist.");
                return;
            }
            int i10 = message.what;
            if (i10 == 1001) {
                C11839m.m70688i("UniformGuideBaseActivity", "close timeout");
                UniformGuideBaseActivity.this.m16937I2(false);
            } else if (i10 == 1002) {
                C11839m.m70688i("UniformGuideBaseActivity", "open timeout");
                C2862k.m17024c();
                UniformGuideBaseActivity.this.m16950Q1();
                UniformGuideBaseActivity.this.m16947O1();
                UniformGuideBaseActivity.this.m17018z3(1002);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.UniformGuideBaseActivity$b */
    public class ViewOnTouchListenerC2853b implements View.OnTouchListener {
        public ViewOnTouchListenerC2853b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                UniformGuideBaseActivity.this.f12573M.requestDisallowInterceptTouchEvent(false);
            } else {
                UniformGuideBaseActivity.this.f12573M.requestDisallowInterceptTouchEvent(true);
            }
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.UniformGuideBaseActivity$c */
    public class DialogInterfaceOnClickListenerC2854c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2854c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -1) {
                C11829c.m70615s1(UniformGuideBaseActivity.this.f12580P0, UniformGuideBaseActivity.this.f12341a);
            } else if (i10 == -2) {
                C11839m.m70688i("UniformGuideBaseActivity", "showNoNetDialog, cancel");
                UniformGuideBaseActivity uniformGuideBaseActivity = UniformGuideBaseActivity.this;
                uniformGuideBaseActivity.f12596X0 = true;
                uniformGuideBaseActivity.f12595X.setCheckedProgrammatically(false);
                UniformGuideBaseActivity.this.f12616h1 = false;
            }
            UniformGuideBaseActivity.this.f12582Q0.dismiss();
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.UniformGuideBaseActivity$d */
    public class DialogInterfaceOnClickListenerC2855d implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ boolean f12650a;

        public DialogInterfaceOnClickListenerC2855d(boolean z10) {
            this.f12650a = z10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -1) {
                UniformGuideBaseActivity.this.f12597Y.setCheckedProgrammatically(false);
                UniformGuideBaseActivity.this.mo16735z1();
                UniformGuideBaseActivity.this.m17009w1();
                UniformGuideBaseActivity.this.m16988n3(false);
                return;
            }
            if (i10 == -2) {
                UniformGuideBaseActivity.this.f12597Y.setCheckedProgrammatically(true);
                if (this.f12650a) {
                    return;
                }
                UniformGuideBaseActivity.this.mo16713P2();
                UniformGuideBaseActivity.this.m16945M2();
                UniformGuideBaseActivity.this.m16988n3(true);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.UniformGuideBaseActivity$e */
    public class DialogInterfaceOnKeyListenerC2856e implements DialogInterface.OnKeyListener {
        public DialogInterfaceOnKeyListenerC2856e() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            if (i10 != 4) {
                return false;
            }
            UniformGuideBaseActivity.this.f12597Y.setChecked(true);
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.UniformGuideBaseActivity$f */
    public class DialogInterfaceOnClickListenerC2857f implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2857f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C11839m.m70688i("UniformGuideBaseActivity", "close phonefinder failed,retry");
            UniformGuideBaseActivity.this.mo16700D2();
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.UniformGuideBaseActivity$g */
    public class C2858g implements InterfaceC13456i {
        public C2858g() {
        }

        @Override // p709vj.InterfaceC13456i
        public void loginResult(boolean z10) {
            boolean zM66400T = C11019b.m66371t().m66400T();
            if (!C0209d.m1333z1(UniformGuideBaseActivity.this) || !z10 || !zM66400T) {
                C11019b.m66371t().m66420g0(UniformGuideBaseActivity.this);
                C11019b.m66371t().m66427k(UniformGuideBaseActivity.this, "phonefinderOOBE", "0");
                UBAAnalyze.m29949J("CKC", "phonefinderOOBE", "value", "0");
                UniformGuideBaseActivity.this.setResult(-1);
                UniformGuideBaseActivity.this.finish();
                return;
            }
            Class clsM66441r = C11019b.m66371t().m66441r("OOBEPhoneFinderActivity");
            if (clsM66441r != null) {
                Intent intent = new Intent(UniformGuideBaseActivity.this, (Class<?>) clsM66441r);
                intent.putExtra(RemoteMessageConst.FROM, UniformGuideBaseActivity.this.getPackageName());
                UniformGuideBaseActivity.this.startActivityForResult(intent, 10005);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.UniformGuideBaseActivity$h */
    public class C2859h implements InterfaceC13451d {
        public C2859h() {
        }

        @Override // p709vj.InterfaceC13451d
        /* renamed from: a */
        public void mo17021a(ErrorStatus errorStatus) {
            C11839m.m70687e("UniformGuideBaseActivity", "CheckPasswd error callback");
            if (errorStatus != null && !errorStatus.getErrorReason().isEmpty() && errorStatus.getErrorCode() != 3002) {
                String errorReason = errorStatus.getErrorReason();
                C11839m.m70687e("UniformGuideBaseActivity", "CheckPasswd error reason: " + errorReason);
                Toast.makeText(UniformGuideBaseActivity.this, errorReason, 0).show();
            }
            UnionSwitch unionSwitch = UniformGuideBaseActivity.this.f12595X;
            if (unionSwitch != null) {
                unionSwitch.setCheckedProgrammatically(true);
            }
        }

        @Override // p709vj.InterfaceC13451d
        /* renamed from: b */
        public void mo17022b(String str) {
            C11839m.m70688i("UniformGuideBaseActivity", "CheckPasswd success callback");
            UniformGuideBaseActivity.this.f12344d = false;
            C1010e.m6125b().m6157w(UniformGuideBaseActivity.this.getApplicationContext(), str);
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.UniformGuideBaseActivity$i */
    public static class C2860i extends AbstractC12368e {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                C13227f.m79492i1().m79601y0(C1007b.m5980s().m6027r().longValue(), new C13049a(EnumC12999a.CLOUD_BACKUP, null).m78754r());
            } catch (C9721b e10) {
                C11839m.m70688i("UniformGuideBaseActivity", "reportCloseCloudBackup error: " + e10.toString());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.UniformGuideBaseActivity$j */
    public static class C2861j extends TimerTask {

        /* renamed from: a */
        public Handler f12656a;

        public C2861j(Handler handler) {
            this.f12656a = handler;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Handler handler = this.f12656a;
            if (handler != null) {
                handler.obtainMessage(1001).sendToTarget();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.UniformGuideBaseActivity$k */
    public static class C2862k extends TimerTask {

        /* renamed from: b */
        public static Timer f12657b;

        /* renamed from: c */
        public static TimerTask f12658c;

        /* renamed from: a */
        public WeakReference<IOpenTimeCallback> f12659a;

        public C2862k(IOpenTimeCallback iOpenTimeCallback) {
            this.f12659a = new WeakReference<>(iOpenTimeCallback);
        }

        /* renamed from: a */
        public static void m17023a(IOpenTimeCallback iOpenTimeCallback) {
            m17024c();
            f12657b = new Timer();
            C2862k c2862k = new C2862k(iOpenTimeCallback);
            f12658c = c2862k;
            f12657b.schedule(c2862k, 40000L);
        }

        /* renamed from: c */
        public static void m17024c() {
            Timer timer = f12657b;
            if (timer != null) {
                timer.cancel();
            }
            f12657b = null;
            TimerTask timerTask = f12658c;
            if (timerTask != null) {
                timerTask.cancel();
            }
            f12658c = null;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            IOpenTimeCallback iOpenTimeCallback = this.f12659a.get();
            if (iOpenTimeCallback == null) {
                return;
            }
            iOpenTimeCallback.mo16963a();
        }
    }

    /* renamed from: V2 */
    private void m16896V2() {
        ArrayList<String> arrayList = this.f12612f1;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<String> it = this.f12612f1.iterator();
        while (it.hasNext()) {
            m16905c3(it.next());
        }
    }

    /* renamed from: X2 */
    private void m16899X2(int i10) {
        C11839m.m70688i("UniformGuideBaseActivity", "processSwitchOpenPermissionResult");
        if (i10 == 20004) {
            List<String> listM69911k = this.f12374A.m69911k("sync_contact");
            C11839m.m70688i("UniformGuideBaseActivity", "contact need permissions size: " + listM69911k.size());
            List<String> listM69903b = this.f12374A.m69903b(this, listM69911k);
            if (this.f12599Z == null) {
                this.f12599Z = (UnionSwitch) C12809f.m76829b(this, R$id.open_contact_switch);
            }
            if (this.f12599Z == null || listM69903b.size() <= 0) {
                return;
            }
            this.f12599Z.setChecked(false);
            return;
        }
        if (i10 == 20005) {
            List<String> listM69911k2 = this.f12374A.m69911k("sync_calendar");
            C11839m.m70688i("UniformGuideBaseActivity", "calendar need permissions size: " + listM69911k2.size());
            List<String> listM69903b2 = this.f12374A.m69903b(this, listM69911k2);
            if (this.f12603b0 == null) {
                this.f12603b0 = (UnionSwitch) C12809f.m76829b(this, R$id.open_calendar_switch);
            }
            if (this.f12603b0 == null || listM69903b2.size() <= 0) {
                return;
            }
            this.f12603b0.setChecked(false);
            return;
        }
        if (i10 == 20003) {
            List<String> listM69911k3 = this.f12374A.m69911k("sync_ablum");
            C11839m.m70688i("UniformGuideBaseActivity", "ablum need permissions size: " + listM69911k3.size());
            List<String> listM69903b3 = this.f12374A.m69903b(this, listM69911k3);
            if (this.f12601a0 == null) {
                this.f12601a0 = (UnionSwitch) C12809f.m76829b(this, R$id.open_gellery_switch);
            }
            if (this.f12601a0 == null || listM69903b3.size() <= 0) {
                return;
            }
            this.f12601a0.setChecked(false);
            return;
        }
        if (i10 == 20006) {
            List<String> listM69911k4 = this.f12374A.m69911k(CloudBackupConstant.Command.PMS_CMD_BACKUP);
            C11839m.m70688i("UniformGuideBaseActivity", "backup need permissions size: " + listM69911k4.size());
            List<String> listM69903b4 = this.f12374A.m69903b(this, listM69911k4);
            if (this.f12585S == null) {
                this.f12585S = (UnionSwitch) C12809f.m76829b(this, R$id.open_backup_switch);
            }
            if (this.f12585S == null || listM69903b4.size() <= 0) {
                return;
            }
            this.f12585S.setCheckedProgrammatically(false);
        }
    }

    /* renamed from: c3 */
    private void m16905c3(String str) {
        str.hashCode();
        switch (str) {
            case "sync_ablum":
                List<String> listM69903b = this.f12374A.m69903b(this, this.f12374A.m69911k("sync_ablum"));
                if (this.f12601a0 == null) {
                    this.f12601a0 = (UnionSwitch) C12809f.m76829b(this, R$id.open_gellery_switch);
                }
                if (this.f12601a0 != null && listM69903b != null && listM69903b.size() > 0) {
                    this.f12601a0.setChecked(false);
                    break;
                }
                break;
            case "backup":
                List<String> listM69903b2 = this.f12374A.m69903b(this, this.f12374A.m69911k(CloudBackupConstant.Command.PMS_CMD_BACKUP));
                if (this.f12585S == null) {
                    this.f12585S = (UnionSwitch) C12809f.m76829b(this, R$id.open_backup_switch);
                }
                if (this.f12585S != null && listM69903b2 != null && listM69903b2.size() > 0) {
                    this.f12585S.setCheckedProgrammatically(false);
                    break;
                }
                break;
            case "sync_contact":
                List<String> listM69903b3 = this.f12374A.m69903b(this, this.f12374A.m69911k("sync_contact"));
                if (this.f12599Z == null) {
                    this.f12599Z = (UnionSwitch) C12809f.m76829b(this, R$id.open_contact_switch);
                }
                if (this.f12599Z != null && listM69903b3 != null && listM69903b3.size() > 0) {
                    C11839m.m70688i("UniformGuideBaseActivity", "no permission close contact automatically");
                    this.f12599Z.setChecked(false);
                    break;
                }
                break;
            case "sync_calendar":
                List<String> listM69903b4 = this.f12374A.m69903b(this, this.f12374A.m69911k("sync_calendar"));
                if (this.f12603b0 == null) {
                    this.f12603b0 = (UnionSwitch) C12809f.m76829b(this, R$id.open_calendar_switch);
                }
                if (this.f12603b0 != null && listM69903b4 != null && listM69903b4.size() > 0) {
                    this.f12603b0.setChecked(false);
                    break;
                }
                break;
        }
    }

    /* renamed from: i2 */
    private void m16912i2() {
        C1417a c1417a;
        C11839m.m70688i("UniformGuideBaseActivity", "initSyncItemView ");
        if (this.f12588T0 == null || (c1417a = this.f12590U0) == null) {
            return;
        }
        c1417a.m8152b();
        ArrayList<SyncConfigService> arrayListM66456z = C11019b.m66371t().m66456z(this);
        ArrayList<DriveConfigService> arrayListM66454y = C11019b.m66371t().m66454y(this);
        ArrayList<SyncConfigService> arrayList = new ArrayList<>();
        Iterator<SyncConfigService> it = arrayListM66456z.iterator();
        while (it.hasNext()) {
            SyncConfigService next = it.next();
            if (next != null && m16989o2(next.getId())) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty() && arrayListM66454y.isEmpty()) {
            C11839m.m70688i("UniformGuideBaseActivity", "initSyncItemView get OM services is null or empty ");
            this.f12588T0.setVisibility(8);
            this.f12561A0 = false;
            return;
        }
        C11839m.m70688i("UniformGuideBaseActivity", "initSyncItemView  syncConfigServices count =" + arrayList.size() + " driveConfigServices count =" + arrayListM66454y.size());
        this.f12590U0.m8151a(arrayList, arrayListM66454y);
        View view = this.f12594W0;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f12588T0.setVisibility(0);
        this.f12561A0 = true;
        this.f12590U0.notifyDataSetChanged();
    }

    /* renamed from: q2 */
    public static /* synthetic */ void m16915q2(String str) {
        C13227f.m79492i1().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", "UniformGuideBaseActivity", str);
    }

    /* renamed from: r2 */
    public /* synthetic */ boolean m16916r2(Message message) {
        if (33045 == message.what) {
            Integer numM66437p = C11019b.m66371t().m66437p(message.arg1);
            if (numM66437p == null) {
                C11019b.m66371t().m66440q0(null, this, this);
            } else if (message.what == 1) {
                C11841o.m70707c(this, numM66437p.intValue(), 0);
            }
        }
        return false;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: A */
    public void mo16550A() {
        mo16554C();
    }

    /* renamed from: A1 */
    public final void m16917A1() {
        m16920B1(C10028c.m62182c0());
        if (this.f12613g0 != null) {
            if (!C11019b.m66371t().m66399S() || C0209d.m1293p1() || m16985m2()) {
                this.f12613g0.setVisibility(8);
            }
        }
    }

    /* renamed from: A2 */
    public final /* synthetic */ void m16918A2(DialogInterface dialogInterface, int i10) {
        m16950Q1();
        this.f12595X.setCheckedProgrammatically(true);
        this.f12616h1 = this.f12595X.isChecked();
    }

    /* renamed from: A3 */
    public final void m16919A3() throws IllegalAccessException, IllegalArgumentException {
        C11839m.m70688i("UniformGuideBaseActivity", "showPhoneFinderAlert, frontPhoneFinderStatus: " + this.f12616h1 + "isRecreated:" + this.f12604b1);
        if (this.f12595X.isChecked()) {
            return;
        }
        if (this.f12604b1) {
            m17014y1();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton(getString(R$string.onfirmc_closure), new DialogInterface.OnClickListener() { // from class: zb.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f63341a.m17017z2(dialogInterface, i10);
            }
        });
        builder.setNegativeButton(getString(R$string.cloudbackup_btn_cancel), new DialogInterface.OnClickListener() { // from class: zb.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f63332a.m16918A2(dialogInterface, i10);
            }
        });
        AlertDialog alertDialog = this.f12625m0;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f12625m0 = null;
        }
        AlertDialog alertDialogCreate = builder.create();
        this.f12625m0 = alertDialogCreate;
        alertDialogCreate.setMessage(getResources().getString(R$string.oobe_phoneFinder_switch_close_tips));
        m16977i3(this.f12625m0);
        this.f12625m0.setTitle(R$string.data_security_tips);
        this.f12625m0.setCanceledOnTouchOutside(false);
        this.f12625m0.show();
        C11829c.m70594l1(this, this.f12625m0);
        Button button = this.f12625m0.getButton(-1);
        Resources resources = this.f12580P0.getResources();
        if (C0209d.m1220W0() || button == null || resources == null) {
            return;
        }
        button.setTextColor(resources.getColor(R$color.emui_functional_red));
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: B */
    public void mo16552B() {
        mo16554C();
    }

    /* renamed from: B1 */
    public final void m16920B1(C10028c c10028c) {
        if (this.f12611f0 != null && (!c10028c.m62395t1("funcfg_contacts") || C0209d.m1293p1() || !m16989o2("addressbook"))) {
            this.f12611f0.setVisibility(8);
        }
        if (this.f12615h0 != null && (!c10028c.m62395t1("funcfg_calendar") || !m16989o2("calendar"))) {
            this.f12615h0.setVisibility(8);
        }
        if (this.f12619j0 != null && (!c10028c.m62395t1("funcfg_wlan") || !m16989o2("wlan"))) {
            this.f12619j0.setVisibility(8);
        }
        if (this.f12617i0 != null && (!c10028c.m62395t1("funcfg_notes") || !C0209d.m1215U1(this) || !m16989o2("notepad"))) {
            this.f12617i0.setVisibility(8);
        }
        if (this.f12621k0 != null) {
            if (c10028c.m62395t1("funcfg_browser") && !C0209d.m1293p1() && m16989o2("browser")) {
                return;
            }
            this.f12621k0.setVisibility(8);
        }
    }

    /* renamed from: B2 */
    public final void m16921B2() {
        mo16703D3();
        setResult(0);
        finish();
    }

    /* renamed from: B3 */
    public void m16922B3() {
        this.f12633q0.setVisibility(0);
        this.f12595X.setVisibility(8);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: C */
    public void mo16554C() {
        mo16725X1();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: C0 */
    public void mo16555C0() {
    }

    /* renamed from: C1 */
    public void m16923C1() {
        if (this.f12341a != 1) {
            mo16704E1();
        } else {
            if (C0209d.m1301r1(this)) {
                mo16704E1();
                return;
            }
            C11839m.m70688i("UniformGuideBaseActivity", "doPhoneFinderNext not locked");
            mo16966b();
            m16947O1();
        }
    }

    /* renamed from: C2 */
    public void mo16699C2() {
    }

    /* renamed from: C3 */
    public void m16924C3() {
        this.f12562B0.setVisibility(0);
        Drawable drawable = this.f12567G0;
        if (drawable != null) {
            this.f12565E0.setImageDrawable(drawable);
        }
        mo16942L1(0);
    }

    /* renamed from: D1 */
    public void m16925D1() {
        Intent intent = new Intent("com.huawei.android.remotecontrol.PHONEFINDER_LASTLOCATION_SWITCHER");
        intent.putExtra("phonefinder_lastlocation_switcher_result", true);
        C13108a.m78878b(this).m78881d(intent);
        C1010e.m6125b().m6133H(this, true);
    }

    /* renamed from: D2 */
    public void mo16700D2() {
        C11839m.m70688i("UniformGuideBaseActivity", "moveToNext");
        if (!this.f12596X0 && !C0209d.m1333z1(this)) {
            m17013x3();
            return;
        }
        if (SystemClock.elapsedRealtime() - this.f12570J0 < 1500) {
            C11839m.m70688i("UniformGuideBaseActivity", "click the next button twice too fast");
            return;
        }
        C10028c.m62182c0().m62272S1(true);
        this.f12570J0 = SystemClock.elapsedRealtime();
        m17008v3();
        mo16729g3();
        C0209d.m1318v2(this);
        C1006a.m5936k().m5940D(getApplicationContext());
        C11019b.m66371t().m66381E0(this);
        if (!C13452e.m80781L().m80803F0().booleanValue() && this.f12341a == 1) {
            m16638S0();
            m16947O1();
            return;
        }
        if (!C11829c.m70534N0(getApplicationContext(), C13452e.m80781L().m80942m()) && this.f12341a == 1) {
            Intent intent = new Intent(this, (Class<?>) SimplifyOOBENoticeActivity.class);
            if (!TextUtils.isEmpty(this.f12568H0)) {
                intent = new Intent(this, (Class<?>) SimplifyOOBETermsActivity.class);
            }
            startActivityForResult(intent, 0);
            m16947O1();
            return;
        }
        m16959W2();
        if (!C11829c.m70536O0()) {
            m16947O1();
            mo16699C2();
            mo16704E1();
            return;
        }
        boolean zM16936I1 = m16936I1();
        C11839m.m70688i("UniformGuideBaseActivity", "phoneFinderSwitchView isOpen: " + zM16936I1);
        if (m16991p1(zM16936I1)) {
            if (this.f12341a == 1) {
                mo16715Q2(zM16936I1);
            } else {
                mo16952R2(zM16936I1);
            }
        }
    }

    /* renamed from: D3 */
    public void mo16703D3() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        c10028cM62182c0.m62377p3("is_all_guide_over", false);
        c10028cM62182c0.m62377p3("is_already_configed_NV4", false);
        C11019b.m66371t().m66444s0(getApplicationContext());
        C11019b.m66371t().m66425j(false);
        C13452e.m80781L().m80885a();
        C10028c.m62182c0().m62343j();
    }

    /* renamed from: E1 */
    public void mo16704E1() {
        setResult(-1);
        finish();
    }

    /* renamed from: E2 */
    public final void m16926E2() {
        C1162b.m7257a().m7258b(this, new C2858g());
    }

    /* renamed from: E3 */
    public final void m16927E3() {
        if (C0209d.m1166E1() || this.f12341a == 1) {
            return;
        }
        this.f12587T.m17033a();
        this.f12589U.m17033a();
        this.f12613g0.m17033a();
        this.f12619j0.m17033a();
    }

    /* renamed from: F1 */
    public final void m16928F1() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        if (hiCloudSafeIntent.getExtras() == null) {
            return;
        }
        this.f12568H0 = hiCloudSafeIntent.getStringExtra("channel_of_open_switch");
    }

    /* renamed from: F2 */
    public void mo16929F2(View view) {
        if (view.getId() == R$id.open_cloud_backup) {
            this.f12585S.setChecked(!r3.isChecked());
            this.f12614g1 = this.f12585S.isChecked();
        } else if (view.getId() == R$id.uniform_guide_continue_button) {
            m17003u1();
        }
    }

    /* renamed from: F3 */
    public boolean m16930F3() {
        AlertDialog alertDialog = this.f12635r0;
        return alertDialog == null || !(alertDialog == null || alertDialog.isShowing());
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: G */
    public void mo16559G() throws Resources.NotFoundException {
        super.mo16559G();
        this.f12575N = (TextView) C12809f.m76829b(this, R$id.oobe_guide_tips);
        this.f12577O = (TextView) C12809f.m76829b(this, R$id.oobe_start_tips_sencond);
        ImageView imageView = (ImageView) C12809f.m76829b(this, R$id.oobe_top_icon);
        if (imageView == null) {
            return;
        }
        boolean zM1269j1 = C0209d.m1269j1();
        if (this.f12341a == 1) {
            if (zM1269j1) {
                imageView.setImageResource(R$drawable.ic_oobe_cloud_10_honor);
            } else {
                imageView.setImageResource(R$drawable.ic_oobe_cloud_11);
            }
        }
    }

    /* renamed from: G1 */
    public boolean m16931G1(Context context) {
        return C1010e.m6125b().m6139e(context);
    }

    /* renamed from: G2 */
    public final void m16932G2(View view) {
        if (view.getId() == R$id.cloud_sync) {
            if (this.f12563C0) {
                this.f12563C0 = false;
                m16951R1();
                return;
            } else {
                this.f12563C0 = true;
                m16924C3();
                return;
            }
        }
        if (view.getId() == R$id.open_contact) {
            this.f12599Z.setChecked(!r3.isChecked());
            return;
        }
        if (view.getId() == R$id.open_gellery) {
            this.f12601a0.setChecked(!r3.isChecked());
            return;
        }
        if (view.getId() == R$id.open_calendar) {
            this.f12603b0.setChecked(!r3.isChecked());
            return;
        }
        if (view.getId() == R$id.open_notepad) {
            this.f12605c0.setChecked(!r3.isChecked());
        } else if (view.getId() == R$id.open_wlan) {
            this.f12607d0.setChecked(!r3.isChecked());
        } else if (view.getId() == R$id.open_browser) {
            this.f12609e0.setChecked(!r3.isChecked());
        }
    }

    /* renamed from: G3 */
    public void m16933G3() {
        OpenPhoneFinderReceiver openPhoneFinderReceiver = this.f12571K0;
        if (openPhoneFinderReceiver != null) {
            openPhoneFinderReceiver.m17020b(this);
        }
    }

    /* renamed from: H1 */
    public final boolean m16934H1() {
        UnionSwitch unionSwitch = this.f12595X;
        if (unionSwitch == null) {
            return false;
        }
        return unionSwitch.isChecked();
    }

    /* renamed from: H2 */
    public void m16935H2() {
        this.f12612f1 = new ArrayList<>();
        if (this.f12585S.isChecked()) {
            this.f12612f1.add(CloudBackupConstant.Command.PMS_CMD_BACKUP);
            this.f12612f1.add("backup_calendar");
            this.f12612f1.add("backup_calllog");
            this.f12612f1.add("backup_contact");
            this.f12612f1.add("backup_sms");
        }
        if (this.f12599Z.isChecked()) {
            this.f12612f1.add("sync_contact");
        }
        if (this.f12603b0.isChecked()) {
            this.f12612f1.add("sync_calendar");
        }
        if (this.f12601a0.isChecked()) {
            this.f12612f1.add("sync_ablum");
        }
        if (this.f12612f1.size() > 0) {
            List<String> listM69907f = this.f12374A.m69907f(this.f12612f1);
            C11839m.m70688i("UniformGuideBaseActivity", "Need Permissions Size:" + listM69907f.size());
            if (this.f12374A.m69903b(this, listM69907f).size() > 0) {
                C11839m.m70688i("UniformGuideBaseActivity", "checkPagePermmision");
                m16627H0(listM69907f);
            } else if (C0209d.m1269j1()) {
                C11839m.m70688i("UniformGuideBaseActivity", "clickNextButton");
                m17003u1();
            }
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: I */
    public void mo16561I() {
        mo16564M();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity
    /* renamed from: I0 */
    public void mo16628I0() {
        super.mo16628I0();
        try {
            AlertDialog alertDialog = this.f12623l0;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f12623l0 = null;
            }
            AlertDialog alertDialog2 = this.f12625m0;
            if (alertDialog2 != null) {
                alertDialog2.dismiss();
                this.f12625m0 = null;
            }
            AlertDialogC13156c alertDialogC13156c = this.f12582Q0;
            if (alertDialogC13156c != null) {
                alertDialogC13156c.dismiss();
                this.f12582Q0 = null;
            }
            AlertDialog alertDialog3 = this.f12627n0;
            if (alertDialog3 != null) {
                alertDialog3.dismiss();
                this.f12627n0 = null;
            }
            AlertDialog alertDialog4 = this.f12629o0;
            if (alertDialog4 != null) {
                alertDialog4.dismiss();
                this.f12629o0 = null;
            }
            AlertDialog alertDialog5 = this.f12631p0;
            if (alertDialog5 != null) {
                alertDialog5.dismiss();
                this.f12631p0 = null;
            }
            AlertDialog alertDialog6 = this.f12635r0;
            if (alertDialog6 != null) {
                alertDialog6.dismiss();
                this.f12635r0 = null;
            }
        } catch (IllegalArgumentException unused) {
            C11839m.m70687e("UniformGuideBaseActivity", "dialog dismiss IllegalArgumentException");
        }
    }

    /* renamed from: I1 */
    public boolean m16936I1() {
        return m16934H1();
    }

    /* renamed from: I2 */
    public void m16937I2(boolean z10) throws IllegalAccessException, IllegalArgumentException {
        C11839m.m70688i("UniformGuideBaseActivity", "phoneFinder open onReceivePhoneFinderOffResult: success=" + z10);
        m16925D1();
        Timer timer = this.f12578O0;
        if (timer != null) {
            timer.cancel();
        }
        m16950Q1();
        m16947O1();
        if (z10) {
            mo16941K2();
        } else {
            m16997r3();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: J */
    public void mo16562J() {
        mo16564M();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity
    /* renamed from: J0 */
    public void mo16629J0(int i10) {
        C11839m.m70688i("UniformGuideBaseActivity", "finishPermissionSet requestCode: " + i10);
        if (m16992p2(i10)) {
            m16899X2(i10);
        }
        if (i10 == 20001 || i10 == 20002) {
            m16896V2();
        }
        if (C0209d.m1269j1()) {
            C11839m.m70688i("UniformGuideBaseActivity", "auto merge");
            m17003u1();
        }
    }

    /* renamed from: J1 */
    public void mo16938J1() {
        if (C0219i.m1463a() < 27) {
            this.f12566F0 = getDrawable(R$drawable.list_spread_gray);
            this.f12567G0 = getDrawable(R$drawable.list_spreadoff_gray);
        } else {
            this.f12566F0 = getDrawable(R$drawable.list_spread_gray_harmony);
            Drawable drawable = getDrawable(R$drawable.list_spreadoff_gray_harmony);
            this.f12567G0 = drawable;
            this.f12565E0.setImageDrawable(drawable);
        }
    }

    /* renamed from: J2 */
    public void m16939J2(boolean z10, int i10) throws IllegalAccessException, IllegalArgumentException {
        C11839m.m70688i("UniformGuideBaseActivity", "phoneFinder open onReceiverResult: success=" + z10);
        m16925D1();
        C2862k.m17024c();
        m16950Q1();
        m16947O1();
        if (z10) {
            mo16941K2();
            return;
        }
        if (this.f12341a == 1) {
            if (3210 == i10 || 3212 == i10) {
                m17016y3(i10);
                return;
            } else {
                m17018z3(i10);
                return;
            }
        }
        if (3001 == i10 || 3201 == i10) {
            C1010e.m6125b().m6127B(this, 10044);
        } else if (37 == i10) {
            m17016y3(i10);
        } else {
            m17018z3(i10);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: K */
    public void mo16563K() {
        mo16564M();
    }

    /* renamed from: K1 */
    public final void m16940K1(C10028c c10028c) {
        if (!m16987n2() || this.f12585S.isChecked()) {
            if (!this.f12585S.isChecked() && c10028c.m62388s("backup_key")) {
                C11839m.m70688i("UniformGuideBaseActivity", "satisfy report close cloudbackup switch condition");
                C12515a.m75110o().m75172d(new C2860i());
            }
            C13227f.m79492i1().m79597u0(getClass().getSimpleName() + ":  change all switch from oobe", C13471c.f.ALL_SWITCH, this.f12585S.isChecked());
            C11019b.m66371t().m66425j(this.f12585S.isChecked());
        } else {
            C11019b.m66371t().m66431m();
        }
        this.f12636s0.putBoolean("oobe_backup", this.f12585S.isChecked());
    }

    /* renamed from: K2 */
    public void mo16941K2() {
        mo16699C2();
        m16923C1();
    }

    /* renamed from: L1 */
    public void mo16942L1(int i10) {
        if (this.f12592V0 != null) {
            if (C0219i.m1463a() < 27 || this.f12341a != 1) {
                this.f12592V0.setVisibility(i10);
            }
        }
    }

    /* renamed from: L2 */
    public void m16943L2(DriveConfigService driveConfigService) {
        C10028c.m62182c0().m62336h2(driveConfigService.getId(), true);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: M */
    public void mo16564M() {
        mo16702k2();
        mo16970d2();
        if (C0209d.m1269j1()) {
            C12809f.m76843p(C12809f.m76829b(this, R$id.honor_fill_space), true);
            C11839m.m70688i("UniformGuideBaseActivity", "honor product, hide some cards");
            View viewM76829b = C12809f.m76829b(this, R$id.backup_finder_card_layout);
            if (viewM76829b != null) {
                viewM76829b.setVisibility(4);
            }
            View viewM76829b2 = C12809f.m76829b(this, R$id.sync_card_layout);
            if (viewM76829b2 != null) {
                viewM76829b2.setVisibility(8);
            }
            AutoSizeButton autoSizeButton = this.f12572L0;
            if (autoSizeButton != null) {
                autoSizeButton.setVisibility(8);
            }
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity
    /* renamed from: M0 */
    public void mo16632M0() {
        m16959W2();
        C11829c.m70582h1(this, this.f12568H0);
        C11019b.m66371t().m66419g(this);
        C13227f.m79492i1().m79560L(this, C13452e.m80781L().m80971t0());
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        c10028cM62182c0.m62377p3("is_all_guide_over", true);
        C11019b.m66371t().m66381E0(this);
        if (c10028cM62182c0.m62395t1("funcfg_find_my_phone_globe")) {
            m16926E2();
        } else {
            setResult(-1);
            finish();
        }
    }

    /* renamed from: M1 */
    public void m16944M1() {
        LinearLayout linearLayout;
        View view = this.f12593W;
        if (view != null) {
            view.setVisibility(8);
        }
        if (this.f12569I0.m62395t1("funcfg_cloud_backup") || (linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.backup_finder_card_layout)) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* renamed from: M2 */
    public void m16945M2() {
        ArrayList<Object> arrayListM8154d = this.f12590U0.m8154d();
        if (arrayListM8154d == null || arrayListM8154d.size() <= 0) {
            return;
        }
        Iterator<Object> it = arrayListM8154d.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof SyncConfigService) {
                SyncConfigService syncConfigService = (SyncConfigService) next;
                syncConfigService.setSwitchStatus(Boolean.TRUE);
                syncConfigService.setSwitchEnable(true);
                mo16710N2(syncConfigService);
            } else if (next instanceof DriveConfigService) {
                DriveConfigService driveConfigService = (DriveConfigService) next;
                driveConfigService.setSwitchStatus(true);
                m16943L2(driveConfigService);
            }
        }
        this.f12590U0.notifyDataSetChanged();
    }

    /* renamed from: N1 */
    public void mo16946N1() {
        AutoSizeButton autoSizeButton;
        HwProgressBar hwProgressBar = this.f12574M0;
        if (hwProgressBar != null) {
            hwProgressBar.setVisibility(8);
        }
        if (C0209d.m1269j1() || (autoSizeButton = this.f12572L0) == null) {
            return;
        }
        autoSizeButton.setVisibility(0);
    }

    /* renamed from: N2 */
    public void mo16710N2(SyncConfigService syncConfigService) {
        C10028c.m62182c0().m62336h2(syncConfigService.getId(), true);
    }

    /* renamed from: O1 */
    public void m16947O1() {
        if (this.f12341a == 1) {
            mo16949P1();
        } else {
            mo16946N1();
        }
    }

    /* renamed from: O2 */
    public void m16948O2(int i10) {
        C11839m.m70688i("UniformGuideBaseActivity", "openPhoneFinder: " + i10);
        if (isFinishing()) {
            C11839m.m70687e("UniformGuideBaseActivity", "OpenPhoneFinder is finishing");
        } else {
            C1010e.m6125b().m6135J(C0213f.m1377a());
            C12300b0.m73940b().m73943e(i10);
        }
    }

    /* renamed from: P1 */
    public void mo16949P1() {
        OOBENavLayout oOBENavLayout = this.f12351k;
        if (oOBENavLayout != null) {
            oOBENavLayout.m17040b();
        }
    }

    /* renamed from: P2 */
    public void mo16713P2() {
        RelativeLayout relativeLayout = this.f12611f0;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            C10028c.m62182c0().m62336h2("addressbook", true);
        }
        DisableSupportedRelativeLayout disableSupportedRelativeLayout = this.f12613g0;
        if (disableSupportedRelativeLayout != null && disableSupportedRelativeLayout.getVisibility() == 0 && C0209d.m1166E1()) {
            C10028c.m62182c0().m62336h2("uploadphotokey", true);
        }
        RelativeLayout relativeLayout2 = this.f12615h0;
        if (relativeLayout2 != null && relativeLayout2.getVisibility() == 0) {
            C10028c.m62182c0().m62336h2("calendar", true);
        }
        RelativeLayout relativeLayout3 = this.f12617i0;
        if (relativeLayout3 != null && relativeLayout3.getVisibility() == 0) {
            C10028c.m62182c0().m62336h2("notepad", true);
        }
        DisableSupportedRelativeLayout disableSupportedRelativeLayout2 = this.f12619j0;
        if (disableSupportedRelativeLayout2 != null && disableSupportedRelativeLayout2.getVisibility() == 0 && C0209d.m1166E1()) {
            C10028c.m62182c0().m62336h2("wlan", true);
        }
        RelativeLayout relativeLayout4 = this.f12621k0;
        if (relativeLayout4 == null || relativeLayout4.getVisibility() != 0) {
            return;
        }
        C10028c.m62182c0().m62336h2("browser", true);
    }

    /* renamed from: Q1 */
    public final void m16950Q1() {
        this.f12633q0.setVisibility(8);
        this.f12595X.setVisibility(0);
    }

    /* renamed from: Q2 */
    public void mo16715Q2(boolean z10) {
        if (z10) {
            m16948O2(5);
            C2862k.m17023a(this);
            return;
        }
        C11839m.m70688i("UniformGuideBaseActivity", "oobe checkPhoneFinder: " + z10);
        m16947O1();
        mo16941K2();
    }

    /* renamed from: R1 */
    public void m16951R1() {
        ImageView imageView;
        View view = this.f12562B0;
        if (view != null) {
            view.setVisibility(8);
        }
        Drawable drawable = this.f12566F0;
        if (drawable != null && (imageView = this.f12565E0) != null) {
            imageView.setImageDrawable(drawable);
        }
        mo16942L1(8);
    }

    /* renamed from: R2 */
    public void mo16952R2(boolean z10) {
        boolean zM16931G1 = m16931G1(this);
        C11839m.m70688i("UniformGuideBaseActivity", "phoneFinderSwitchView isOpen: " + z10 + " ,get phonefinderswitchstatus: " + zM16931G1);
        if (!C0209d.m1166E1() || z10 == zM16931G1) {
            m16947O1();
            mo16941K2();
            return;
        }
        if (z10) {
            m16948O2(10);
            C2862k.m17023a(this);
            return;
        }
        C1010e.m6125b().m6156v(getApplicationContext());
        Timer timer = this.f12578O0;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = new Timer();
        this.f12578O0 = timer2;
        timer2.schedule(new C2861j(this.f12632p1), 40000L);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: S */
    public void mo16569S() {
        m16921B2();
    }

    /* renamed from: S1 */
    public int m16953S1(int i10, boolean z10) {
        return !z10 ? i10 + 1 : i10;
    }

    /* renamed from: S2 */
    public void m16954S2(boolean z10) throws IllegalAccessException, IllegalArgumentException {
        if (!z10) {
            m16919A3();
            return;
        }
        this.f12596X0 = false;
        this.f12595X.setCheckedProgrammatically(z10);
        this.f12616h1 = true;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: T */
    public void mo16570T() {
        mo16569S();
    }

    /* renamed from: T1 */
    public int m16955T1(int i10, boolean z10) {
        return z10 ? i10 + 1 : i10;
    }

    /* renamed from: T2 */
    public final void m16956T2(boolean z10, String str) {
        C11839m.m70688i("UniformGuideBaseActivity", "processCheckedChanged, syncType: " + str + ", isChecked = " + z10);
        if (z10) {
            C10028c.m62182c0().m62336h2(str, true);
        } else {
            C10028c.m62182c0().m62336h2(str, false);
        }
        m16980k3(str, Boolean.valueOf(z10));
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: U */
    public void mo16571U() {
        mo16569S();
    }

    /* renamed from: U1 */
    public int mo16720U1(int i10) {
        boolean zM62388s;
        ArrayList<Object> arrayListM8154d = this.f12590U0.m8154d();
        if (arrayListM8154d != null && arrayListM8154d.size() > 0) {
            Iterator<Object> it = arrayListM8154d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof SyncConfigService) {
                    this.f12637t0++;
                    zM62388s = C10028c.m62182c0().m62388s(((SyncConfigService) next).getId());
                } else if (next instanceof DriveConfigService) {
                    this.f12637t0++;
                    zM62388s = C10028c.m62182c0().m62388s(((DriveConfigService) next).getId());
                } else {
                    zM62388s = false;
                }
                i10 = m16953S1(i10, zM62388s);
            }
        }
        return i10;
    }

    /* renamed from: U2 */
    public void mo16957U2() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: V */
    public void mo16572V() {
        mo16569S();
    }

    /* renamed from: V1 */
    public int mo16722V1(int i10) {
        boolean zM62388s;
        ArrayList<Object> arrayListM8154d = this.f12590U0.m8154d();
        if (arrayListM8154d != null && arrayListM8154d.size() > 0) {
            Iterator<Object> it = arrayListM8154d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof SyncConfigService) {
                    this.f12637t0++;
                    zM62388s = C10028c.m62182c0().m62388s(((SyncConfigService) next).getId());
                    i10 = m16955T1(i10, zM62388s);
                } else if (next instanceof DriveConfigService) {
                    this.f12637t0++;
                    zM62388s = C10028c.m62182c0().m62388s(((DriveConfigService) next).getId());
                } else {
                    zM62388s = false;
                }
                i10 = m16955T1(i10, zM62388s);
            }
        }
        return i10;
    }

    /* renamed from: W1 */
    public final void m16958W1() {
        if (!this.f12569I0.m62395t1("funcfg_cloud_backup") || C0209d.m1293p1()) {
            this.f12587T.setVisibility(8);
            View view = this.f12593W;
            if (view != null) {
                view.setVisibility(8);
            }
            this.f12585S.setCheckedProgrammatically(false);
        }
    }

    /* renamed from: W2 */
    public final void m16959W2() {
        if (this.f12341a == 1) {
            C11019b.m66371t().m66424i0(this, true, true, true, true);
        }
    }

    /* renamed from: X1 */
    public void mo16725X1() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        boolean zM62388s = c10028cM62182c0.m62388s("addressbook");
        boolean zM62388s2 = c10028cM62182c0.m62388s("calendar");
        boolean zM62388s3 = c10028cM62182c0.m62388s("uploadphotokey");
        boolean zM62388s4 = c10028cM62182c0.m62388s("notepad");
        boolean zM62388s5 = c10028cM62182c0.m62388s("wlan");
        boolean zM62388s6 = c10028cM62182c0.m62388s("browser");
        this.f12585S.setCheckedProgrammatically(c10028cM62182c0.m62388s("backup_key"));
        this.f12599Z.setChecked(zM62388s);
        this.f12605c0.setChecked(zM62388s4);
        this.f12603b0.setChecked(zM62388s);
        this.f12607d0.setChecked(zM62388s5);
        this.f12603b0.setChecked(zM62388s2);
        this.f12601a0.setChecked(zM62388s3);
        this.f12609e0.setChecked(zM62388s6);
        if (C1010e.m6125b().m6146l(this, C13452e.m80781L().m80971t0())) {
            m17014y1();
        }
        if (!this.f12604b1) {
            m16935H2();
        }
        mo16727Y1();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Y */
    public void mo16574Y() {
        mo16700D2();
    }

    /* renamed from: Y1 */
    public void mo16727Y1() {
        ArrayList<Object> arrayListM8154d;
        C1417a c1417a = this.f12590U0;
        if (c1417a == null || (arrayListM8154d = c1417a.m8154d()) == null || arrayListM8154d.size() <= 0) {
            return;
        }
        Iterator<Object> it = arrayListM8154d.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof SyncConfigService) {
                SyncConfigService syncConfigService = (SyncConfigService) next;
                syncConfigService.setSwitchStatus(Boolean.valueOf(C10028c.m62182c0().m62388s(syncConfigService.getId())));
            } else if (next instanceof DriveConfigService) {
                DriveConfigService driveConfigService = (DriveConfigService) next;
                driveConfigService.setSwitchStatus(C10028c.m62182c0().m62388s(driveConfigService.getId()));
            }
        }
        this.f12590U0.notifyDataSetChanged();
    }

    /* renamed from: Y2 */
    public void m16960Y2(String str, boolean z10) {
        if (HNConstants.DataType.MEDIA.equals(str)) {
            if (m16985m2()) {
                C11839m.m70688i("UniformGuideBaseActivity", "basicUser set gallery switch to false");
                this.f12598Y0.put(str, Boolean.FALSE);
                return;
            } else {
                if (!C0209d.m1166E1() || C0209d.m1293p1()) {
                    C11839m.m70689w("UniformGuideBaseActivity", "not OwnerUser or isInkScreen");
                    this.f12598Y0.put(str, Boolean.FALSE);
                    return;
                }
                C11839m.m70688i("UniformGuideBaseActivity", "set gallery switch to : " + z10);
                this.f12598Y0.put(str, Boolean.valueOf(z10));
                return;
            }
        }
        if (!m16989o2(str)) {
            C11839m.m70688i("UniformGuideBaseActivity", "put2StatusMap not in list" + str + " : false");
            this.f12598Y0.put(str, Boolean.FALSE);
            return;
        }
        C11839m.m70688i("UniformGuideBaseActivity", "put2StatusMap in list" + str + " : " + z10);
        this.f12598Y0.put(str, Boolean.valueOf(z10));
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Z */
    public void mo16575Z() {
        mo16574Y();
    }

    /* renamed from: Z1 */
    public final void m16961Z1() {
        this.f12562B0 = C12809f.m76829b(this, R$id.sync_items);
        UnionSwitch unionSwitch = (UnionSwitch) C12809f.m76829b(this, R$id.open_contact_switch);
        this.f12599Z = unionSwitch;
        unionSwitch.setOnCheckedChangeListener(this);
        UnionSwitch unionSwitch2 = (UnionSwitch) C12809f.m76829b(this, R$id.open_gellery_switch);
        this.f12601a0 = unionSwitch2;
        unionSwitch2.setOnCheckedChangeListener(this);
        UnionSwitch unionSwitch3 = (UnionSwitch) C12809f.m76829b(this, R$id.open_calendar_switch);
        this.f12603b0 = unionSwitch3;
        unionSwitch3.setOnCheckedChangeListener(this);
        UnionSwitch unionSwitch4 = (UnionSwitch) C12809f.m76829b(this, R$id.open_notepad_switch);
        this.f12605c0 = unionSwitch4;
        unionSwitch4.setOnCheckedChangeListener(this);
        UnionSwitch unionSwitch5 = (UnionSwitch) C12809f.m76829b(this, R$id.open_wlan_switch);
        this.f12607d0 = unionSwitch5;
        unionSwitch5.setOnCheckedChangeListener(this);
        UnionSwitch unionSwitch6 = (UnionSwitch) C12809f.m76829b(this, R$id.open_browser_switch);
        this.f12609e0 = unionSwitch6;
        unionSwitch6.setOnCheckedChangeListener(this);
        this.f12611f0 = (RelativeLayout) C12809f.m76829b(this, R$id.open_contact);
        this.f12613g0 = (DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.open_gellery);
        this.f12615h0 = (RelativeLayout) C12809f.m76829b(this, R$id.open_calendar);
        this.f12617i0 = (RelativeLayout) C12809f.m76829b(this, R$id.open_notepad);
        this.f12619j0 = (DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.open_wlan);
        this.f12621k0 = (RelativeLayout) C12809f.m76829b(this, R$id.open_browser);
        if (C11019b.m66371t().m66391K(this)) {
            this.f12621k0.setVisibility(0);
        } else {
            this.f12621k0.setVisibility(8);
        }
        this.f12565E0 = (ImageView) C12809f.m76829b(this, R$id.right_arrow1);
        mo16938J1();
        TextView textView = (TextView) C12809f.m76829b(this, R$id.open_wlan_title);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.open_phonefinder_title);
        if (textView2 != null) {
            textView2.setText(C11842p.m70762R0() ? R$string.phone_findback_title_20160528_pad : R$string.phone_findback_title_20160528);
        }
        if (C0209d.m1262h2()) {
            textView.setText(getResources().getString(R$string.wlan_sync));
        } else {
            textView.setText(getResources().getString(R$string.wifi_sync));
        }
    }

    /* renamed from: Z2 */
    public void mo16962Z2() {
        mo16727Y1();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.manager.IOpenTimeCallback
    /* renamed from: a */
    public void mo16963a() {
        C11839m.m70688i("UniformGuideBaseActivity", "phonefinder open timeout");
        C12300b0.m73940b().m73942d();
        Handler handler = this.f12632p1;
        if (handler != null) {
            handler.sendEmptyMessage(1002);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: a0 */
    public void mo16576a0() {
        mo16574Y();
    }

    /* renamed from: a2 */
    public final int m16964a2(int i10) {
        if (this.f12569I0.m62395t1("funcfg_contacts") && !C0209d.m1293p1()) {
            this.f12637t0++;
            this.f12638u0 = true;
            if (!this.f12569I0.m62388s("addressbook")) {
                i10++;
            }
        }
        if (this.f12569I0.m62395t1("funcfg_calendar")) {
            this.f12637t0++;
            this.f12641x0 = true;
            i10 = m16953S1(i10, this.f12569I0.m62388s("calendar"));
        }
        if (this.f12569I0.m62395t1("funcfg_wlan")) {
            this.f12637t0++;
            this.f12643z0 = true;
            if (!C0209d.m1166E1() || !this.f12569I0.m62388s("wlan")) {
                i10++;
            }
        }
        if (this.f12569I0.m62395t1("funcfg_browser") && C11019b.m66371t().m66391K(this) && !C0209d.m1293p1()) {
            this.f12637t0++;
            this.f12642y0 = true;
            i10 = m16953S1(i10, this.f12569I0.m62388s("browser"));
        }
        if (!this.f12569I0.m62395t1("funcfg_notes") || !C0209d.m1215U1(this)) {
            return i10;
        }
        this.f12637t0++;
        this.f12640w0 = true;
        return m16953S1(i10, this.f12569I0.m62388s("notepad"));
    }

    /* renamed from: a3 */
    public void m16965a3() {
        int iMo16731n1 = mo16731n1();
        if (iMo16731n1 == 0) {
            this.f12583R.setText(getString(R$string.settings_hicloud_open));
        } else {
            this.f12583R.setText(getResources().getQuantityString(R$plurals.item_num_not_open1, iMo16731n1, Integer.valueOf(iMo16731n1)));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.dialog.BetaDialogInterface
    /* renamed from: b */
    public void mo16966b() {
        final String message;
        C11839m.m70688i("UniformGuideBaseActivity", "intentToLockScreen");
        Intent intent = new Intent();
        intent.setAction("com.android.settings.SETUP_LOCK_SCREEN");
        C0209d.m1302r2(intent, "com.android.settings");
        intent.putExtra("useImmersiveMode", true);
        intent.putExtra("firstRun", true);
        intent.putExtra("hasMultipleUsers", false);
        intent.putExtra("oobe_phonefinder", true);
        try {
            startActivityForResult(intent, 10025);
            message = "success";
        } catch (RuntimeException e10) {
            C11839m.m70689w("UniformGuideBaseActivity", "intentToLockScreen activity not found" + e10.getMessage());
            message = e10.getMessage();
        }
        C0226l0.m1585e(new Runnable() { // from class: zb.m
            @Override // java.lang.Runnable
            public final void run() {
                UniformGuideBaseActivity.m16915q2(message);
            }
        }, 60000L);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: b0 */
    public void mo16577b0() {
        mo16574Y();
    }

    /* renamed from: b2 */
    public final int m16967b2(int i10) {
        if (this.f12569I0.m62395t1("funcfg_contacts") && !C0209d.m1293p1()) {
            this.f12637t0++;
            this.f12638u0 = true;
            if (this.f12569I0.m62388s("addressbook")) {
                i10++;
            }
        }
        if (this.f12569I0.m62395t1("funcfg_calendar")) {
            this.f12637t0++;
            this.f12641x0 = true;
            i10 = m16955T1(i10, this.f12569I0.m62388s("calendar"));
        }
        if (this.f12569I0.m62395t1("funcfg_wlan")) {
            this.f12637t0++;
            this.f12643z0 = true;
            if (C0209d.m1166E1() && this.f12569I0.m62388s("wlan")) {
                i10++;
            }
        }
        if (this.f12569I0.m62395t1("funcfg_browser") && C11019b.m66371t().m66391K(this) && !C0209d.m1293p1()) {
            this.f12637t0++;
            this.f12642y0 = true;
            i10 = m16955T1(i10, this.f12569I0.m62388s("browser"));
        }
        if (!this.f12569I0.m62395t1("funcfg_notes") || !C0209d.m1215U1(this)) {
            return i10;
        }
        this.f12637t0++;
        this.f12640w0 = true;
        return m16955T1(i10, this.f12569I0.m62388s("notepad"));
    }

    /* renamed from: b3 */
    public void mo16968b3() {
        int iMo16732o1 = mo16732o1();
        TextView textView = this.f12583R;
        if (textView != null) {
            textView.setText(getResources().getQuantityString(R$plurals.uniform_sync_item_num, iMo16732o1, Integer.valueOf(iMo16732o1)));
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: c */
    public int mo16578c() {
        if (C0209d.m1269j1()) {
            C11839m.m70688i("UniformGuideBaseActivity", "use honor layout");
            this.f12602a1 = false;
            return R$layout.uniform_guide_honor;
        }
        C11839m.m70688i("UniformGuideBaseActivity", "use content layout");
        this.f12602a1 = true;
        return R$layout.uniform_guide;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: c0 */
    public boolean mo16579c0() {
        return true;
    }

    /* renamed from: c2 */
    public void mo16969c2() {
    }

    /* renamed from: d2 */
    public void mo16970d2() {
        if (C11829c.m70536O0()) {
            C11839m.m70688i("UniformGuideBaseActivity", "initPhoneFinderSwitch supportPhoneFinder");
            if (C0209d.m1166E1()) {
                this.f12595X.setCheckedProgrammatically(this.f12616h1);
                return;
            } else {
                m17014y1();
                return;
            }
        }
        C11839m.m70688i("UniformGuideBaseActivity", "initPhoneFinderSwitch not support");
        this.f12589U.setVisibility(8);
        m16944M1();
        this.f12595X.setCheckedProgrammatically(false);
        this.f12616h1 = false;
    }

    /* renamed from: d3 */
    public void m16971d3() {
        if (this.f12571K0 == null) {
            this.f12571K0 = new OpenPhoneFinderReceiver(this);
        }
        this.f12571K0.m17019a(this);
    }

    /* renamed from: e2 */
    public void m16972e2() {
        m16950Q1();
        if (this.f12341a == 1) {
            this.f12595X.setCheckedProgrammatically(true);
        } else {
            m16986m3();
        }
    }

    /* renamed from: e3 */
    public void m16973e3() {
        if (this.f12341a == 1) {
            C11019b.m66371t().m66420g0(this);
        } else {
            C11019b.m66371t().m66416e0(this);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: f */
    public int mo16583f() {
        return R$layout.uniform_guide_emui10;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: f0 */
    public void mo16584f0(View view) {
        mo16929F2(view);
        m16932G2(view);
    }

    /* renamed from: f2 */
    public void m16974f2() {
        this.f12588T0 = (ScrollDisabledListView) C12809f.m76829b(this, R$id.guide_sync_func_items);
        this.f12590U0 = new C1417a(this, this);
        if (C0219i.m1463a() >= 27 && this.f12341a == 1 && C0209d.m1269j1()) {
            this.f12590U0.m8155e(true);
        }
        this.f12588T0.setAdapter((ListAdapter) this.f12590U0);
        this.f12588T0.setFocusable(false);
        this.f12588T0.setEnabled(false);
        this.f12588T0.setDivider(null);
        this.f12588T0.setDividerHeight(0);
        this.f12588T0.setHeaderDividersEnabled(false);
        this.f12588T0.setFooterDividersEnabled(false);
        m16912i2();
        mo16962Z2();
    }

    /* renamed from: f3 */
    public void m16975f3() {
        if (C11829c.m70536O0()) {
            boolean zM16936I1 = m16936I1();
            if (this.f12341a == 1) {
                C11019b.m66371t().m66436o0(this, "phonefinderOOBE", zM16936I1);
            } else {
                C11019b.m66371t().m66436o0(this, "phonefinderNormal", zM16936I1);
            }
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: g */
    public int mo16585g() {
        C11839m.m70688i("UniformGuideBaseActivity", "use 1101 layout");
        this.f12602a1 = false;
        return R$layout.uniform_guide_emui1101;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: g0 */
    public void mo16586g0(View view) {
        mo16584f0(view);
    }

    /* renamed from: g2 */
    public void mo16728g2() {
        C11839m.m70688i("UniformGuideBaseActivity", "initSyncItemNotOpenNum");
        int iM16964a2 = m16964a2(0);
        m16958W1();
        if (this.f12569I0.m62395t1("funcfg_gallery") && !C0209d.m1293p1()) {
            this.f12637t0++;
            this.f12639v0 = true;
            iM16964a2 = m16953S1(iM16964a2, this.f12569I0.m62388s("uploadphotokey"));
        }
        if (this.f12561A0 && this.f12590U0 != null) {
            iM16964a2 = mo16720U1(iM16964a2);
        }
        this.f12583R.setText(getResources().getQuantityString(R$plurals.item_num_not_open1, iM16964a2, Integer.valueOf(iM16964a2)));
    }

    /* renamed from: g3 */
    public void mo16729g3() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        this.f12636s0.putBoolean("oobe_contact", c10028cM62182c0.m62388s("addressbook"));
        this.f12636s0.putBoolean("oobe_calendar", c10028cM62182c0.m62388s("calendar"));
        this.f12636s0.putBoolean("oobe_gellery", c10028cM62182c0.m62388s("uploadphotokey"));
        this.f12636s0.putBoolean("oobe_notepad", c10028cM62182c0.m62388s("notepad"));
        this.f12636s0.putBoolean("oobe_wlan", c10028cM62182c0.m62388s("wlan"));
        m16940K1(c10028cM62182c0);
        if (c10028cM62182c0.m62388s("uploadphotokey")) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("GeneralAblum", true);
            bundle.putBoolean("ShareAlbum", true);
            C11019b.m66371t().m66411c(this, bundle);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("GeneralAblum", false);
        bundle2.putBoolean("ShareAlbum", false);
        C11019b.m66371t().m66411c(this, bundle2);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: h */
    public int mo16587h() {
        return mo16583f();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: h0 */
    public void mo16588h0(View view) {
        mo16584f0(view);
    }

    /* renamed from: h2 */
    public void mo16730h2() {
        C11839m.m70688i("UniformGuideBaseActivity", "initSyncItemOpenNum");
        int iM16967b2 = m16967b2(0);
        m16958W1();
        if (this.f12569I0.m62395t1("funcfg_gallery") && !C0209d.m1293p1()) {
            this.f12637t0++;
            this.f12639v0 = true;
            iM16967b2 = m16955T1(iM16967b2, this.f12569I0.m62388s("uploadphotokey"));
        }
        if (this.f12561A0 && this.f12590U0 != null) {
            iM16967b2 = mo16722V1(iM16967b2);
        }
        this.f12583R.setText(getResources().getQuantityString(R$plurals.uniform_sync_item_num, iM16967b2, Integer.valueOf(iM16967b2)));
    }

    /* renamed from: h3 */
    public void m16976h3(boolean z10) {
        C11842p.m70846o1(this, (SpanClickText) C12809f.m76829b(this, R$id.unifrom_privacy_content_first), (SpanClickText) C12809f.m76829b(this, R$id.unifrom_privacy_content_second), (SpanClickText) C12809f.m76829b(this, R$id.unifrom_privacy_content_third), (SpanClickText) C12809f.m76829b(this, R$id.unifrom_privacy_content_fourth), z10, false);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i */
    public int mo16589i() {
        return mo16583f();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i0 */
    public void mo16590i0(View view) {
        mo16584f0(view);
    }

    /* renamed from: i3 */
    public final void m16977i3(AlertDialog alertDialog) {
        if (alertDialog == null || this.f12341a != 1) {
            return;
        }
        C11829c.m70585i1(alertDialog.getWindow());
        C11829c.m70572e0(alertDialog);
        C11840n.m70694e(alertDialog);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: j */
    public int mo16591j() {
        return mo16583f();
    }

    /* renamed from: j2 */
    public final void m16978j2() {
        UnionSwitch unionSwitch = (UnionSwitch) C12809f.m76829b(this, R$id.open_backup_switch);
        this.f12585S = unionSwitch;
        unionSwitch.setOnClickListener(this);
        this.f12585S.setOnCheckedChangeListener(this);
        this.f12587T = (DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.open_cloud_backup);
        this.f12591V = (TextView) C12809f.m76829b(this, R$id.open_contact_sub_title);
        if (!C13452e.m80781L().m80887a1()) {
            this.f12591V.setText(R$string.uniform_backup_subtitle_new_new);
        } else if (m16985m2()) {
            this.f12591V.setText(R$string.uniform_guide_basic_service_tips_new);
        } else {
            this.f12591V.setText(R$string.uniform_guide_membership_service_tips);
        }
        UnionSwitch unionSwitch2 = (UnionSwitch) C12809f.m76829b(this, R$id.open_phonefinder_switch);
        this.f12595X = unionSwitch2;
        unionSwitch2.setOnCheckedChangeListener(this);
        this.f12589U = (DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.open_phonefinder);
        this.f12593W = C12809f.m76829b(this, R$id.backup_finder_divider);
        this.f12633q0 = (HwProgressBar) C12809f.m76829b(this, R$id.phone_finder_loading);
        UnionSwitch unionSwitch3 = (UnionSwitch) C12809f.m76829b(this, R$id.open_sync_switch);
        this.f12597Y = unionSwitch3;
        if (unionSwitch3 != null) {
            unionSwitch3.setOnCheckedChangeListener(this);
        }
        ((RelativeLayout) C12809f.m76829b(this, R$id.cloud_sync)).setOnClickListener(this);
        this.f12573M = (ScrollView) C12809f.m76829b(this, R$id.oobe_guide_scrollView);
        this.f12579P = (TextView) C12809f.m76829b(this, R$id.cloud_sync_titel);
        this.f12581Q = (TextView) C12809f.m76829b(this, R$id.cloud_sync_detail);
        this.f12583R = (TextView) C12809f.m76829b(this, R$id.open_feature_num);
        m16990o3();
        m16979j3();
    }

    /* renamed from: j3 */
    public final void m16979j3() {
        if (C0219i.m1463a() <= 14) {
            if (C11842p.m70771U0() && C11842p.m70774V0(this)) {
                this.f12579P.setMaxWidth(C11842p.m70785Z() - ((int) C11842p.m70844o(this, 16)));
                this.f12581Q.setMaxWidth(C11842p.m70785Z() - ((int) C11842p.m70844o(this, 16)));
                return;
            } else {
                this.f12579P.setMaxWidth(C11842p.m70813g0() - ((int) C11842p.m70844o(this, 16)));
                this.f12581Q.setMaxWidth(C11842p.m70813g0() - ((int) C11842p.m70844o(this, 16)));
                return;
            }
        }
        if (C0219i.m1463a() > 14) {
            if (C11842p.m70771U0() && C11842p.m70774V0(this)) {
                this.f12579P.setMaxWidth(C11842p.m70785Z() - ((int) C11842p.m70844o(this, 20)));
                this.f12581Q.setMaxWidth(C11842p.m70785Z() - ((int) C11842p.m70844o(this, 20)));
            } else {
                this.f12579P.setMaxWidth(C11842p.m70813g0() - ((int) C11842p.m70844o(this, 20)));
                this.f12581Q.setMaxWidth(C11842p.m70813g0() - ((int) C11842p.m70844o(this, 20)));
            }
        }
    }

    /* renamed from: k2 */
    public void mo16702k2() {
        m16978j2();
        m16982l2();
        m16961Z1();
        this.f12630o1 = C1008c.m6035v().m6036A(this.f12580P0);
        boolean zM62395t1 = C10028c.m62182c0().m62395t1("confirm_permission_tips");
        C11839m.m70686d("UniformGuideBaseActivity", "tipsConfirmed:" + zM62395t1);
        if (this.f12602a1 && !zM62395t1 && C13452e.m80781L().m80803F0().booleanValue() && this.f12564D0) {
            this.f12563C0 = false;
            this.f12564D0 = false;
        }
        if (this.f12563C0) {
            m16924C3();
        } else {
            m16951R1();
        }
        TextView textView = this.f12575N;
        if (textView != null && this.f12577O != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.addRule(14, -1);
            this.f12575N.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f12577O.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.addRule(14, -1);
            this.f12577O.setLayoutParams(layoutParams2);
            C11842p.m70839m2(this.f12575N, 15);
            C11842p.m70839m2(this.f12577O, 15);
        }
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.uniform_guide_continue_button);
        this.f12572L0 = autoSizeButton;
        C11842p.m70766S1(this, autoSizeButton);
        this.f12574M0 = (HwProgressBar) C12809f.m76829b(this, R$id.continue_progress);
        this.f12576N0 = (RelativeLayout) C12809f.m76829b(this, R$id.oobe_nav_buttons);
        mo17002t3();
        if (this.f12341a != 1) {
            this.f12351k.m17039a();
        }
        if (C13452e.m80781L().m80803F0().booleanValue() && !zM62395t1 && this.f12341a != 1) {
            m16976h3(false);
        }
        m16974f2();
    }

    /* renamed from: k3 */
    public void m16980k3(String str, Boolean bool) {
        C1417a c1417a;
        if (this.f12588T0 == null || (c1417a = this.f12590U0) == null) {
            C11839m.m70687e("UniformGuideBaseActivity", "setModuleSubTitle is null, moduleName = " + str);
            return;
        }
        Object objM8153c = c1417a.m8153c(str);
        if (objM8153c instanceof SyncConfigService) {
            ((SyncConfigService) objM8153c).setSwitchStatus(bool);
            return;
        }
        if (objM8153c instanceof DriveConfigService) {
            ((DriveConfigService) objM8153c).setSwitchStatus(bool.booleanValue());
            return;
        }
        C11839m.m70687e("UniformGuideBaseActivity", "setModuleToggleStatus, object is null, moduleName = " + str);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: l0 */
    public void mo16596l0() {
    }

    /* renamed from: l1 */
    public final void m16981l1() {
        TextView textView;
        if (this.f12580P0 == null || !C0209d.m1293p1() || (textView = this.f12575N) == null || this.f12577O == null) {
            return;
        }
        textView.setVisibility(8);
        this.f12577O.setText(this.f12580P0.getString(R$string.find_and_locate_emui90));
    }

    /* renamed from: l2 */
    public final void m16982l2() {
        this.f12592V0 = C12809f.m76829b(this, R$id.line_interval_slide);
        View viewM76829b = C12809f.m76829b(this, R$id.interval_wlan);
        this.f12594W0 = viewM76829b;
        if (viewM76829b != null) {
            viewM76829b.setVisibility(8);
        }
    }

    /* renamed from: l3 */
    public final void m16983l3() {
        if (this.f12341a == 1) {
            this.f12584R0 = true;
        }
    }

    /* renamed from: m1 */
    public final void m16984m1(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnKeyListener onKeyListener, boolean z10) {
        if (z10) {
            this.f12623l0 = C11019b.m66371t().m66413d(this.f12580P0, onClickListener, onClickListener2, onKeyListener);
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton(getString(R$string.onfirmc_closure), onClickListener);
        builder.setNegativeButton(getString(R$string.cloudbackup_btn_cancel), onClickListener2);
        builder.setOnKeyListener(onKeyListener);
        AlertDialog alertDialogCreate = builder.create();
        this.f12623l0 = alertDialogCreate;
        alertDialogCreate.setMessage(getResources().getString(R$string.oobe_cloudbackup_switch_close_tips));
        this.f12623l0.setTitle(R$string.data_security_tips);
        this.f12623l0.setCanceledOnTouchOutside(false);
    }

    /* renamed from: m2 */
    public boolean m16985m2() {
        return C13452e.m80781L().m80791C0();
    }

    /* renamed from: m3 */
    public final void m16986m3() {
        boolean z10 = false;
        boolean zM16931G1 = C0209d.m1166E1() ? m16931G1(this) : false;
        if (this.f12606c1) {
            z10 = zM16931G1;
        } else {
            this.f12606c1 = true;
        }
        C11839m.m70688i("UniformGuideBaseActivity", "setPhoneFinderSwitch phoneStatus=" + z10);
        this.f12595X.setCheckedProgrammatically(z10);
        this.f12616h1 = z10;
    }

    /* renamed from: n1 */
    public int mo16731n1() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        int i10 = this.f12637t0;
        boolean zM62388s = c10028cM62182c0.m62388s("addressbook");
        boolean zM62388s2 = c10028cM62182c0.m62388s("calendar");
        boolean zM62388s3 = c10028cM62182c0.m62388s("uploadphotokey");
        boolean zM62388s4 = c10028cM62182c0.m62388s("notepad");
        boolean zM62388s5 = c10028cM62182c0.m62388s("wlan");
        boolean zM62388s6 = c10028cM62182c0.m62388s("browser");
        if (zM62388s && this.f12638u0) {
            i10--;
        }
        if (zM62388s2 && this.f12641x0) {
            i10--;
        }
        if (zM62388s3 && this.f12639v0) {
            i10--;
        }
        if (zM62388s4 && this.f12640w0) {
            i10--;
        }
        if (zM62388s5 && this.f12643z0) {
            i10--;
        }
        if (zM62388s6 && this.f12642y0) {
            i10--;
        }
        return (!this.f12561A0 || this.f12590U0 == null) ? i10 : m16996r1(i10);
    }

    /* renamed from: n2 */
    public boolean m16987n2() {
        Object tag = this.f12585S.getTag();
        boolean zBooleanValue = tag instanceof Boolean ? ((Boolean) tag).booleanValue() : false;
        C11839m.m70688i("UniformGuideBaseActivity", "isAgreeToBasicUserFromViewTag : " + zBooleanValue);
        return zBooleanValue;
    }

    /* renamed from: n3 */
    public void m16988n3(boolean z10) {
        RelativeLayout relativeLayout = this.f12611f0;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.f12599Z.setChecked(z10);
        }
        UnionSwitch unionSwitch = this.f12603b0;
        if (unionSwitch != null && unionSwitch.getVisibility() == 0) {
            this.f12603b0.setChecked(z10);
        }
        UnionSwitch unionSwitch2 = this.f12601a0;
        if (unionSwitch2 != null && unionSwitch2.getVisibility() == 0 && C0209d.m1166E1()) {
            this.f12601a0.setChecked(z10);
        }
        RelativeLayout relativeLayout2 = this.f12617i0;
        if (relativeLayout2 != null && relativeLayout2.getVisibility() == 0) {
            this.f12605c0.setChecked(z10);
        }
        DisableSupportedRelativeLayout disableSupportedRelativeLayout = this.f12619j0;
        if (disableSupportedRelativeLayout != null && disableSupportedRelativeLayout.getVisibility() == 0 && C0209d.m1166E1()) {
            this.f12607d0.setChecked(z10);
        }
        RelativeLayout relativeLayout3 = this.f12621k0;
        if (relativeLayout3 == null || relativeLayout3.getVisibility() != 0) {
            return;
        }
        this.f12609e0.setChecked(z10);
    }

    /* renamed from: o1 */
    public int mo16732o1() {
        RelativeLayout relativeLayout;
        DisableSupportedRelativeLayout disableSupportedRelativeLayout;
        RelativeLayout relativeLayout2;
        DisableSupportedRelativeLayout disableSupportedRelativeLayout2;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        int i10 = this.f12637t0;
        C11839m.m70688i("UniformGuideBaseActivity", "calculateOpenItemNum supportFeatureNum: " + this.f12637t0);
        boolean zM62388s = c10028cM62182c0.m62388s("addressbook");
        boolean zM62388s2 = c10028cM62182c0.m62388s("calendar");
        boolean zM62388s3 = c10028cM62182c0.m62388s("uploadphotokey");
        boolean zM62388s4 = c10028cM62182c0.m62388s("notepad");
        boolean zM62388s5 = c10028cM62182c0.m62388s("wlan");
        boolean zM62388s6 = c10028cM62182c0.m62388s("browser");
        if (!zM62388s && this.f12638u0 && (relativeLayout4 = this.f12611f0) != null && relativeLayout4.getVisibility() == 0) {
            i10--;
        }
        if (!zM62388s2 && this.f12641x0 && (relativeLayout3 = this.f12615h0) != null && relativeLayout3.getVisibility() == 0) {
            i10--;
        }
        if (!zM62388s3 && this.f12639v0 && (disableSupportedRelativeLayout2 = this.f12613g0) != null && disableSupportedRelativeLayout2.getVisibility() == 0) {
            i10--;
        }
        if (!zM62388s4 && this.f12640w0 && (relativeLayout2 = this.f12617i0) != null && relativeLayout2.getVisibility() == 0) {
            i10--;
        }
        if (!zM62388s5 && this.f12643z0 && (disableSupportedRelativeLayout = this.f12619j0) != null && disableSupportedRelativeLayout.getVisibility() == 0) {
            i10--;
        }
        if (!zM62388s6 && this.f12642y0 && (relativeLayout = this.f12621k0) != null && relativeLayout.getVisibility() == 0) {
            i10--;
        }
        return (!this.f12561A0 || this.f12590U0 == null) ? i10 : mo16733s1(i10);
    }

    /* renamed from: o2 */
    public boolean m16989o2(String str) {
        return C1008c.m6035v().m6045J(this.f12630o1, str);
    }

    /* renamed from: o3 */
    public final void m16990o3() {
        OOBETopView oOBETopView = this.f12350j;
        if (oOBETopView == null) {
            C11839m.m70689w("UniformGuideBaseActivity", "setTitleTextTipsTouchListener topLayout is null");
            return;
        }
        TextView subTitleView = oOBETopView.getSubTitleView();
        if (subTitleView == null) {
            return;
        }
        subTitleView.setOnTouchListener(new ViewOnTouchListenerC2853b());
        subTitleView.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        BetaDialog betaDialog;
        C11839m.m70688i("UniformGuideBaseActivity", "onActivityResult requestCode: " + i10);
        super.onActivityResult(i10, i11, intent);
        if (i10 != 10025) {
            if (i10 == 10044) {
                if (i11 == 0) {
                    m17014y1();
                }
                if (C0209d.m1269j1()) {
                    C11839m.m70688i("UniformGuideBaseActivity", "show merge dialog");
                    mo16957U2();
                    return;
                }
                return;
            }
            if (i10 == 8908) {
                C13195l.m79272J().m79298N(this, this.f12586S0, i11, intent);
                return;
            } else {
                if (-1 == i11) {
                    mo16704E1();
                    return;
                }
                return;
            }
        }
        C11839m.m70688i("UniformGuideBaseActivity", "onActivityResult requestCode: 10025");
        C0226l0.m1585e(new Runnable() { // from class: zb.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f63337a.m16998s2();
            }
        }, 60000L);
        if (C0209d.m1301r1(this)) {
            C11839m.m70688i("UniformGuideBaseActivity", "update public key");
            C1010e.m6125b().m6131F(this);
        }
        if (!C0209d.m1193N0() || C0209d.m1301r1(this)) {
            mo16704E1();
            return;
        }
        C11839m.m70688i("UniformGuideBaseActivity", "onActivityResult requestCode, is beta and not locked");
        try {
            betaDialog = (BetaDialog) getFragmentManager().findFragmentByTag("beta_pwd");
        } catch (ClassCastException e10) {
            C11839m.m70687e("UniformGuideBaseActivity", "findFragmentByTag error:" + e10.getMessage());
            betaDialog = null;
        }
        if (betaDialog == null) {
            BetaDialog.m23933a(true).show(getFragmentManager(), "beta_pwd");
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) throws IllegalAccessException, IllegalArgumentException {
        UnionSwitch unionSwitch;
        int id2 = compoundButton.getId();
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (id2 == R$id.open_contact_switch) {
            c10028cM62182c0.m62336h2("addressbook", z10);
            m16994q1(z10, "addressbook");
        } else if (id2 == R$id.open_gellery_switch) {
            c10028cM62182c0.m62336h2("uploadphotokey", z10);
            m16994q1(z10, HNConstants.DataType.MEDIA);
        } else if (id2 == R$id.open_calendar_switch) {
            c10028cM62182c0.m62336h2("calendar", z10);
            m16994q1(z10, "calendar");
        } else if (id2 == R$id.open_notepad_switch) {
            c10028cM62182c0.m62336h2("notepad", z10);
        } else if (id2 == R$id.open_wlan_switch) {
            c10028cM62182c0.m62336h2("wlan", z10);
        } else if (id2 == R$id.open_browser_switch) {
            c10028cM62182c0.m62336h2("browser", z10);
        } else if (id2 == R$id.open_backup_switch) {
            if (m16994q1(z10, CloudBackupConstant.Command.PMS_CMD_BACKUP)) {
                return;
            } else {
                m16995q3();
            }
        } else if (id2 == R$id.open_phonefinder_switch) {
            m16954S2(z10);
        } else if (id2 == R$id.open_sync_item_switch) {
            Object tag = compoundButton.getTag();
            if (tag != null && (tag instanceof String)) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    m16956T2(z10, str);
                }
            }
        } else if (id2 == R$id.open_sync_switch) {
            m16999s3(false);
        }
        if (!z10 && this.f12602a1) {
            m17000t1();
        }
        if (z10 && this.f12602a1 && (unionSwitch = this.f12597Y) != null && !unionSwitch.isChecked() && m16930F3() && id2 != R$id.open_sync_switch && id2 != R$id.open_backup_switch && id2 != R$id.open_phonefinder_switch) {
            this.f12610e1 = false;
            this.f12597Y.setChecked(true);
        }
        if (this.f12602a1) {
            mo16968b3();
        } else {
            m16965a3();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70766S1(this, this.f12572L0);
        mo16702k2();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C11839m.m70688i("UniformGuideBaseActivity", "onCreate");
        if (bundle != null) {
            this.f12604b1 = bundle.getBoolean("is_recreate");
            this.f12612f1 = bundle.getStringArrayList("page_service");
            this.f12606c1 = bundle.getBoolean("state_pf_switch");
            try {
                this.f12600Z0 = (HashMap) bundle.getSerializable("userSelectedSwitchStatus");
            } catch (Exception e10) {
                C11839m.m70688i("UniformGuideBaseActivity", "onCreate:" + e10.toString());
            }
            C11839m.m70688i("UniformGuideBaseActivity", "isRecreated: " + this.f12604b1);
        }
        this.f12580P0 = this;
        m16983l3();
        m16928F1();
        m16917A1();
        m16927E3();
        m16971d3();
        if (m16985m2()) {
            C11019b.m66371t().m66428k0(this.f12634q1);
        }
        super.mo16619y();
        if (this.f12602a1) {
            mo16730h2();
        } else {
            mo16728g2();
        }
        m16981l1();
        getWindow().setFlags(16777216, 16777216);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C11019b.m66371t().m66379D0(this.f12634q1);
        m16933G3();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C13227f.m79492i1().m79577X(this);
        UBAAnalyze.m29964Y("PVC", getClass().getCanonicalName(), "1", "18", super.m16612u());
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        try {
            this.f12600Z0 = (HashMap) bundle.getSerializable("userSelectedSwitchStatus");
        } catch (Exception e10) {
            C11839m.m70688i("UniformGuideBaseActivity", "onRestoreInstanceState:" + e10.toString());
        }
        this.f12604b1 = false;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C13227f.m79492i1().m79582b0(this);
        UBAAnalyze.m29967a0("PVC", getClass().getCanonicalName(), "1", "18");
        if (this.f12602a1) {
            mo16968b3();
        } else {
            m16965a3();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_recreate", true);
        bundle.putStringArrayList("page_service", this.f12612f1);
        bundle.putBoolean("state_pf_switch", this.f12616h1);
        bundle.putSerializable("userSelectedSwitchStatus", this.f12598Y0);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: p */
    public C0089a mo16602p() {
        return m16606r();
    }

    /* renamed from: p1 */
    public boolean m16991p1(boolean z10) {
        BetaDialog betaDialog;
        if (z10) {
            if (C0209d.m1333z1(this)) {
                return true;
            }
            m16947O1();
            return false;
        }
        if (!C0209d.m1193N0() || this.f12596X0 || !C0209d.m1166E1()) {
            return true;
        }
        try {
            betaDialog = (BetaDialog) getFragmentManager().findFragmentByTag("beta");
        } catch (ClassCastException e10) {
            C11839m.m70687e("UniformGuideBaseActivity", "findFragmentByTag error:" + e10.getMessage());
            betaDialog = null;
        }
        if (betaDialog == null) {
            BetaDialog.m23934b(false, this.f12341a).show(getFragmentManager(), "beta");
        }
        m16947O1();
        return false;
    }

    /* renamed from: p2 */
    public final boolean m16992p2(int i10) {
        return i10 == 20004 || i10 == 20005 || i10 == 20003 || i10 == 20006;
    }

    /* renamed from: p3 */
    public final void m16993p3(boolean z10) {
        if (z10) {
            C11019b.m66371t().m66453x0(this.f12623l0);
        } else {
            this.f12623l0.show();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: q */
    public C0089a mo16604q() {
        return m16606r();
    }

    /* renamed from: q1 */
    public boolean m16994q1(boolean z10, String str) {
        return z10 && !m16626G0(str);
    }

    /* renamed from: q3 */
    public void m16995q3() throws IllegalAccessException, IllegalArgumentException {
        if (this.f12585S.isChecked()) {
            this.f12614g1 = true;
            return;
        }
        if (this.f12604b1) {
            C11839m.m70688i("UniformGuideBaseActivity", "backupSwitchView close directly: ");
            this.f12585S.setChecked(false);
            return;
        }
        boolean zM16985m2 = m16985m2();
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: zb.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f63333a.m17001t2(dialogInterface, i10);
            }
        };
        this.f12585S.setTag(Boolean.valueOf(zM16985m2));
        DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: zb.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f63334a.m17004u2(dialogInterface, i10);
            }
        };
        DialogInterface.OnKeyListener onKeyListener = new DialogInterface.OnKeyListener() { // from class: zb.j
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                return this.f63335a.m17007v2(dialogInterface, i10, keyEvent);
            }
        };
        AlertDialog alertDialog = this.f12623l0;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f12623l0 = null;
        }
        m16984m1(onClickListener, onClickListener2, onKeyListener, zM16985m2);
        AlertDialog alertDialog2 = this.f12623l0;
        if (alertDialog2 == null) {
            C11839m.m70687e("UniformGuideBaseActivity", "buildBackupDialog dialog is null");
            return;
        }
        m16977i3(alertDialog2);
        m16993p3(zM16985m2);
        C11829c.m70594l1(this, this.f12623l0);
        Button button = this.f12623l0.getButton(-1);
        Resources resources = this.f12580P0.getResources();
        if (C0209d.m1220W0() || button == null || resources == null) {
            return;
        }
        button.setTextColor(resources.getColor(R$color.emui_functional_red));
    }

    /* renamed from: r1 */
    public int m16996r1(int i10) {
        ArrayList<Object> arrayListM8154d = this.f12590U0.m8154d();
        if (arrayListM8154d != null && arrayListM8154d.size() > 0) {
            Iterator<Object> it = arrayListM8154d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof SyncConfigService) {
                    if (C10028c.m62182c0().m62388s(((SyncConfigService) next).getId())) {
                        i10--;
                    }
                } else if ((next instanceof DriveConfigService) && C10028c.m62182c0().m62388s(((DriveConfigService) next).getId())) {
                    i10--;
                }
            }
        }
        return i10;
    }

    /* renamed from: r3 */
    public final void m16997r3() throws IllegalAccessException, IllegalArgumentException {
        if (this.f12595X.isChecked()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton(getString(R$string.cloudbackup_retry), new DialogInterfaceOnClickListenerC2857f());
        builder.setNegativeButton(getString(R$string.cloudbackup_btn_cancel), (DialogInterface.OnClickListener) null);
        AlertDialog alertDialog = this.f12631p0;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f12631p0 = null;
        }
        AlertDialog alertDialogCreate = builder.create();
        this.f12631p0 = alertDialogCreate;
        alertDialogCreate.setMessage(getResources().getString(C11842p.m70762R0() ? R$string.close_phonefinder_failure_retry_pad : R$string.close_phonefinder_failure_retry));
        m16977i3(this.f12631p0);
        this.f12631p0.show();
        C11829c.m70594l1(this, this.f12631p0);
    }

    /* renamed from: s1 */
    public int mo16733s1(int i10) {
        ArrayList<Object> arrayListM8154d = this.f12590U0.m8154d();
        if (arrayListM8154d != null && arrayListM8154d.size() > 0) {
            Iterator<Object> it = arrayListM8154d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof SyncConfigService) {
                    if (!C10028c.m62182c0().m62388s(((SyncConfigService) next).getId())) {
                        i10--;
                    }
                } else if ((next instanceof DriveConfigService) && !C10028c.m62182c0().m62388s(((DriveConfigService) next).getId())) {
                    i10--;
                }
            }
        }
        return i10;
    }

    /* renamed from: s2 */
    public final /* synthetic */ void m16998s2() {
        C13227f.m79492i1().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", "UniformGuideBaseActivity", "isLock:" + C0209d.m1301r1(this));
    }

    /* renamed from: s3 */
    public void m16999s3(boolean z10) throws IllegalAccessException, IllegalArgumentException {
        UnionSwitch unionSwitch = this.f12597Y;
        if (unionSwitch != null) {
            if (unionSwitch.isChecked()) {
                if (!this.f12610e1) {
                    this.f12610e1 = true;
                    C11839m.m70688i("UniformGuideBaseActivity", "no need open all switch");
                    return;
                } else {
                    mo16713P2();
                    m16945M2();
                    m16988n3(true);
                    return;
                }
            }
            if (!this.f12608d1 || this.f12604b1) {
                this.f12608d1 = true;
                mo16735z1();
                if (!this.f12604b1) {
                    m17009w1();
                }
                m16988n3(false);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            DialogInterfaceOnClickListenerC2855d dialogInterfaceOnClickListenerC2855d = new DialogInterfaceOnClickListenerC2855d(z10);
            builder.setPositiveButton(getString(R$string.onfirmc_closure), dialogInterfaceOnClickListenerC2855d);
            builder.setNegativeButton(getString(R$string.cancel), dialogInterfaceOnClickListenerC2855d);
            builder.setOnKeyListener(new DialogInterfaceOnKeyListenerC2856e());
            AlertDialog alertDialog = this.f12635r0;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f12635r0 = null;
            }
            AlertDialog alertDialogCreate = builder.create();
            this.f12635r0 = alertDialogCreate;
            alertDialogCreate.setMessage(getResources().getString(R$string.uniform_sync_switch_close_tip_new_bm));
            m16977i3(this.f12635r0);
            this.f12635r0.setCanceledOnTouchOutside(false);
            this.f12635r0.show();
            C11829c.m70594l1(this, this.f12635r0);
            Button button = this.f12635r0.getButton(-1);
            Resources resources = this.f12580P0.getResources();
            if (C0209d.m1220W0() || button == null || resources == null) {
                return;
            }
            button.setTextColor(resources.getColor(R$color.emui_functional_red));
        }
    }

    /* renamed from: t1 */
    public void m17000t1() {
        C11839m.m70688i("UniformGuideBaseActivity", "checkSyncSwitchStatus");
        RelativeLayout relativeLayout = this.f12611f0;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0 && this.f12599Z.isChecked()) {
            return;
        }
        RelativeLayout relativeLayout2 = this.f12615h0;
        if (relativeLayout2 != null && relativeLayout2.getVisibility() == 0 && this.f12603b0.isChecked()) {
            return;
        }
        DisableSupportedRelativeLayout disableSupportedRelativeLayout = this.f12613g0;
        if (disableSupportedRelativeLayout != null && disableSupportedRelativeLayout.getVisibility() == 0 && this.f12601a0.isChecked()) {
            return;
        }
        RelativeLayout relativeLayout3 = this.f12617i0;
        if (relativeLayout3 != null && relativeLayout3.getVisibility() == 0 && this.f12605c0.isChecked()) {
            return;
        }
        DisableSupportedRelativeLayout disableSupportedRelativeLayout2 = this.f12619j0;
        if (disableSupportedRelativeLayout2 != null && disableSupportedRelativeLayout2.getVisibility() == 0 && this.f12607d0.isChecked()) {
            return;
        }
        RelativeLayout relativeLayout4 = this.f12621k0;
        if (relativeLayout4 != null && relativeLayout4.getVisibility() == 0 && this.f12609e0.isChecked()) {
            return;
        }
        ArrayList<Object> arrayListM8154d = this.f12590U0.m8154d();
        if (arrayListM8154d != null && arrayListM8154d.size() > 0) {
            Iterator<Object> it = arrayListM8154d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof SyncConfigService) {
                    if (((SyncConfigService) next).getSwitchStatus()) {
                        return;
                    }
                } else if ((next instanceof DriveConfigService) && ((DriveConfigService) next).isSwitchStatus()) {
                    return;
                }
            }
        }
        this.f12597Y.setCheckedProgrammatically(false);
    }

    /* renamed from: t2 */
    public final /* synthetic */ void m17001t2(DialogInterface dialogInterface, int i10) {
        this.f12585S.setCheckedProgrammatically(false);
        this.f12614g1 = false;
    }

    /* renamed from: t3 */
    public void mo17002t3() {
        RelativeLayout relativeLayout;
        if (this.f12341a != 2 || (relativeLayout = this.f12576N0) == null) {
            return;
        }
        relativeLayout.setVisibility(0);
        this.f12572L0.setOnClickListener(this);
    }

    /* renamed from: u1 */
    public void m17003u1() {
        C11839m.m70688i("UniformGuideBaseActivity", "clickNextButton");
        this.f12584R0 = true;
        mo16700D2();
    }

    /* renamed from: u2 */
    public final /* synthetic */ void m17004u2(DialogInterface dialogInterface, int i10) {
        this.f12585S.setChecked(!r1.isChecked());
        this.f12614g1 = this.f12585S.isChecked();
    }

    /* renamed from: u3 */
    public void mo17005u3() {
        HwProgressBar hwProgressBar = this.f12574M0;
        if (hwProgressBar != null) {
            hwProgressBar.setVisibility(0);
        }
        AutoSizeButton autoSizeButton = this.f12572L0;
        if (autoSizeButton != null) {
            autoSizeButton.setVisibility(8);
        }
    }

    /* renamed from: v1 */
    public void m17006v1(DriveConfigService driveConfigService) {
        C10028c.m62182c0().m62336h2(driveConfigService.getId(), false);
    }

    /* renamed from: v2 */
    public final /* synthetic */ boolean m17007v2(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return false;
        }
        this.f12585S.setChecked(true);
        this.f12614g1 = true;
        return false;
    }

    /* renamed from: v3 */
    public void m17008v3() {
        if (this.f12341a == 1) {
            m17011w3();
        } else {
            mo17005u3();
        }
    }

    /* renamed from: w1 */
    public void m17009w1() {
        ArrayList<Object> arrayListM8154d = this.f12590U0.m8154d();
        if (arrayListM8154d == null || arrayListM8154d.size() <= 0) {
            return;
        }
        Iterator<Object> it = arrayListM8154d.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof SyncConfigService) {
                SyncConfigService syncConfigService = (SyncConfigService) next;
                syncConfigService.setSwitchStatus(Boolean.FALSE);
                mo16734x1(syncConfigService);
            } else if (next instanceof DriveConfigService) {
                DriveConfigService driveConfigService = (DriveConfigService) next;
                driveConfigService.setSwitchStatus(false);
                m17006v1(driveConfigService);
            }
        }
        this.f12590U0.notifyDataSetChanged();
    }

    /* renamed from: w2 */
    public final /* synthetic */ void m17010w2(DialogInterface dialogInterface, int i10) {
        C11839m.m70688i("UniformGuideBaseActivity", "open phonefinder failed, confirm");
        this.f12596X0 = true;
        this.f12595X.setCheckedProgrammatically(false);
        this.f12616h1 = false;
    }

    /* renamed from: w3 */
    public void m17011w3() {
        OOBENavLayout oOBENavLayout = this.f12351k;
        if (oOBENavLayout != null) {
            oOBENavLayout.m17047i();
        }
    }

    /* renamed from: x1 */
    public void mo16734x1(SyncConfigService syncConfigService) {
        C10028c.m62182c0().m62336h2(syncConfigService.getId(), false);
    }

    /* renamed from: x2 */
    public final /* synthetic */ void m17012x2(DialogInterface dialogInterface, int i10) {
        C11839m.m70688i("UniformGuideBaseActivity", "open phonefinder failed,retry");
        this.f12595X.setCheckedProgrammatically(true);
        mo16700D2();
    }

    /* renamed from: x3 */
    public void m17013x3() {
        if (this.f12582Q0 == null) {
            this.f12582Q0 = new AlertDialogC13156c(this, new DialogInterfaceOnClickListenerC2854c());
        }
        m16977i3(this.f12582Q0);
        this.f12582Q0.show();
        Button button = this.f12582Q0.getButton(-1);
        Resources resources = this.f12580P0.getResources();
        if (button == null || resources == null) {
            return;
        }
        button.setTextColor(resources.getColor(R$color.emui_functional_red));
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: y */
    public void mo16619y() {
    }

    /* renamed from: y1 */
    public void m17014y1() {
        UnionSwitch unionSwitch = this.f12595X;
        if (unionSwitch != null) {
            unionSwitch.setCheckedProgrammatically(false);
            this.f12616h1 = false;
        }
    }

    /* renamed from: y2 */
    public final /* synthetic */ void m17015y2(DialogInterface dialogInterface, int i10) {
        C11839m.m70688i("UniformGuideBaseActivity", "open phonefinder failed, cancel");
        this.f12596X0 = true;
        this.f12595X.setCheckedProgrammatically(false);
        this.f12616h1 = false;
    }

    /* renamed from: y3 */
    public final void m17016y3(int i10) throws IllegalAccessException, IllegalArgumentException {
        if (this.f12595X.isChecked()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setPositiveButton(getString(R$string.conform), new DialogInterface.OnClickListener() { // from class: zb.k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    this.f63336a.m17010w2(dialogInterface, i11);
                }
            });
            AlertDialog alertDialog = this.f12629o0;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f12629o0 = null;
            }
            if (3210 == i10 || 3212 == i10) {
                builder.setTitle(C11842p.m70762R0() ? R$string.phonefinder_dialog_title_open_fail_pad : R$string.phonefinder_dialog_title_open_fail_phone);
                builder.setMessage(R$string.phonefinder_active_lock_not_supprted_toast);
            } else {
                builder.setTitle(C11842p.m70762R0() ? R$string.open_phonefinder_failure_toast_pad : R$string.open_phonefinder_failure_toast);
                builder.setMessage(R$string.open_phonefinder_failure_later);
            }
            AlertDialog alertDialogCreate = builder.create();
            this.f12629o0 = alertDialogCreate;
            m16977i3(alertDialogCreate);
            this.f12629o0.show();
            C11829c.m70594l1(this, this.f12629o0);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: z */
    public void mo16621z() {
        mo16554C();
    }

    /* renamed from: z1 */
    public void mo16735z1() {
        RelativeLayout relativeLayout = this.f12611f0;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            C10028c.m62182c0().m62336h2("addressbook", false);
        }
        DisableSupportedRelativeLayout disableSupportedRelativeLayout = this.f12613g0;
        if (disableSupportedRelativeLayout != null && disableSupportedRelativeLayout.getVisibility() == 0 && C0209d.m1166E1()) {
            C10028c.m62182c0().m62336h2("uploadphotokey", false);
        }
        RelativeLayout relativeLayout2 = this.f12615h0;
        if (relativeLayout2 != null && relativeLayout2.getVisibility() == 0) {
            C10028c.m62182c0().m62336h2("calendar", false);
        }
        RelativeLayout relativeLayout3 = this.f12617i0;
        if (relativeLayout3 != null && relativeLayout3.getVisibility() == 0) {
            C10028c.m62182c0().m62336h2("notepad", false);
        }
        DisableSupportedRelativeLayout disableSupportedRelativeLayout2 = this.f12619j0;
        if (disableSupportedRelativeLayout2 != null && disableSupportedRelativeLayout2.getVisibility() == 0 && C0209d.m1166E1()) {
            C10028c.m62182c0().m62336h2("wlan", false);
        }
        RelativeLayout relativeLayout4 = this.f12621k0;
        if (relativeLayout4 == null || relativeLayout4.getVisibility() != 0) {
            return;
        }
        C10028c.m62182c0().m62336h2("browser", false);
    }

    /* renamed from: z2 */
    public final /* synthetic */ void m17017z2(DialogInterface dialogInterface, int i10) {
        this.f12595X.setCheckedProgrammatically(false);
        this.f12616h1 = false;
    }

    /* renamed from: z3 */
    public final void m17018z3(int i10) throws IllegalAccessException, IllegalArgumentException {
        if (this.f12595X.isChecked()) {
            this.f12595X.setCheckedProgrammatically(false);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: zb.n
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    this.f63339a.m17012x2(dialogInterface, i11);
                }
            };
            DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: zb.o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    this.f63340a.m17015y2(dialogInterface, i11);
                }
            };
            builder.setPositiveButton(getString(R$string.cloudbackup_retry), onClickListener);
            builder.setNegativeButton(getString(R$string.cloudbackup_btn_cancel), onClickListener2);
            builder.setTitle(C11842p.m70762R0() ? R$string.phonefinder_dialog_title_open_fail_pad : R$string.phonefinder_dialog_title_open_fail_phone);
            AlertDialog alertDialog = this.f12627n0;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f12627n0 = null;
            }
            if (3210 == i10 || 3212 == i10) {
                builder.setMessage(getString(R$string.text_oobedisabledreason) + "(" + i10 + ")");
            } else {
                builder.setMessage(R$string.open_phonefinder_failure_retry_later);
            }
            AlertDialog alertDialogCreate = builder.create();
            this.f12627n0 = alertDialogCreate;
            m16977i3(alertDialogCreate);
            this.f12627n0.show();
            C11829c.m70594l1(this, this.f12627n0);
        }
    }
}
