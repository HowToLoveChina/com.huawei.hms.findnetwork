package com.huawei.android.remotecontrol.p093ui.activation;

import ac.C0089a;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import bf.C1175a;
import com.huawei.android.hicloud.oobe.R$dimen;
import com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayoutPf;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBETopView;
import com.huawei.android.hicloud.p088ui.extend.NotchBottomFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitOOBENavLinearLayout;
import com.huawei.android.remotecontrol.p093ui.RequestPermissionsActivity;
import com.huawei.android.remotecontrol.p093ui.widget.BetaDialog;
import com.huawei.android.remotecontrol.p093ui.widget.ListItemPatterm;
import com.huawei.android.remotecontrol.sdk.R$color;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.request.cbs.bean.CBSBaseResp;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import gp.C10028c;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import p015ak.C0209d;
import p015ak.C0219i;
import p015ak.C0226l0;
import p020ap.C1007b;
import p020ap.C1010e;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p520of.C11860j;
import p521og.C11877j;
import p521og.C11881n;
import p575qe.C12347f;
import p664u0.C13108a;
import p681uj.C13195l;
import p684un.C13230i;
import p709vj.C13452e;
import p709vj.InterfaceC13450c;
import p709vj.InterfaceC13456i;
import p742wj.C13612b;
import p809yg.C13981a;
import sk.C12809f;

/* loaded from: classes4.dex */
public class OOBEPhoneFinderActivity extends OOBEPhoneFinderBaseActivity implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: C */
    public ListItemPatterm f20715C;

    /* renamed from: D */
    public ListItemPatterm f20716D;

    /* renamed from: E */
    public View f20717E;

    /* renamed from: F */
    public View f20718F;

    /* renamed from: G */
    public View f20719G;

    /* renamed from: H */
    public TextView f20720H;

    /* renamed from: I */
    public TextView f20721I;

    /* renamed from: J */
    public HwButton f20722J;

    /* renamed from: K */
    public HiSyncReceiver f20723K;

    /* renamed from: L */
    public AlertDialog f20724L;

    /* renamed from: M */
    public HandlerC4521g f20725M;

    /* renamed from: N */
    public AlertDialog f20726N;

    /* renamed from: O */
    public AlertDialog f20727O;

    /* renamed from: S */
    public NetStateListen f20731S;

    /* renamed from: P */
    public long f20728P = 0;

    /* renamed from: Q */
    public boolean f20729Q = false;

    /* renamed from: R */
    public String f20730R = null;

    /* renamed from: T */
    public String f20732T = "";

    /* renamed from: U */
    public EnumC4522h f20733U = EnumC4522h.NORMAL;

    /* renamed from: V */
    public EnumC4518d f20734V = EnumC4518d.NEXT;

    /* renamed from: W */
    public final C4517c f20735W = new C4517c(this, null);

    public static class HiSyncReceiver extends BroadcastReceiver {

        /* renamed from: a */
        public boolean f20736a = false;

        /* renamed from: b */
        public WeakReference<OOBEPhoneFinderActivity> f20737b;

        public HiSyncReceiver(OOBEPhoneFinderActivity oOBEPhoneFinderActivity) {
            this.f20737b = new WeakReference<>(oOBEPhoneFinderActivity);
        }

        /* renamed from: a */
        public void m27629a(Context context) {
            if (this.f20736a) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_OPEN_AUTH_FAILE");
            C13108a.m78878b(context.getApplicationContext()).m78880c(this, intentFilter);
            this.f20736a = true;
        }

        /* renamed from: b */
        public void m27630b(Context context) {
            if (this.f20736a) {
                C13108a.m78878b(context.getApplicationContext()).m78883f(this);
                this.f20736a = false;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws IllegalAccessException, IllegalArgumentException {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            if (hiCloudSafeIntent.getAction() == null) {
                C13981a.m83988e("OOBEPhoneFinderActivity", "HiSyncReceiver action is null");
                return;
            }
            OOBEPhoneFinderActivity oOBEPhoneFinderActivity = this.f20737b.get();
            if (oOBEPhoneFinderActivity != null && "com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT".equals(hiCloudSafeIntent.getAction())) {
                oOBEPhoneFinderActivity.m27601x1(hiCloudSafeIntent.getBooleanExtra("phonefinder_result", false), hiCloudSafeIntent.getIntExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 0));
            }
        }
    }

    public static class NetStateListen extends BroadcastReceiver {

        /* renamed from: a */
        public boolean f20738a = false;

        /* renamed from: b */
        public WeakReference<OOBEPhoneFinderActivity> f20739b;

        public NetStateListen(OOBEPhoneFinderActivity oOBEPhoneFinderActivity) {
            this.f20739b = new WeakReference<>(oOBEPhoneFinderActivity);
        }

        /* renamed from: a */
        public void m27631a(Context context) {
            if (this.f20738a) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.getApplicationContext().registerReceiver(this, intentFilter);
            this.f20738a = true;
        }

        /* renamed from: b */
        public void m27632b(Context context) {
            if (this.f20738a) {
                context.getApplicationContext().unregisterReceiver(this);
                this.f20738a = false;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            OOBEPhoneFinderActivity oOBEPhoneFinderActivity = this.f20739b.get();
            if (oOBEPhoneFinderActivity == null) {
                return;
            }
            oOBEPhoneFinderActivity.m27600v1();
        }
    }

    public static class ThirdAccoutnDialog extends DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.cancel();
            Activity activity = getActivity();
            if (activity != null) {
                activity.setResult(-1);
                activity.finish();
            }
        }

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(R$string.unbanding_help_2_title);
            builder.setMessage(R$string.third_account_notice);
            builder.setPositiveButton(R$string.unbanding_example_close, this);
            return builder.create();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.OOBEPhoneFinderActivity$a */
    public static /* synthetic */ class C4515a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f20740a;

        static {
            int[] iArr = new int[EnumC4522h.values().length];
            f20740a = iArr;
            try {
                iArr[EnumC4522h.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20740a[EnumC4522h.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20740a[EnumC4522h.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20740a[EnumC4522h.RETRY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20740a[EnumC4522h.NONET.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.OOBEPhoneFinderActivity$b */
    public static class C4516b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a */
        public TextView f20741a;

        /* renamed from: b */
        public TextView f20742b;

        public C4516b(TextView textView, TextView textView2) {
            this.f20741a = textView;
            this.f20742b = textView2;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            C13981a.m83989i("OOBEPhoneFinderActivity", "showLoginSuccessDialog cloudbackupFind.isChecked():" + compoundButton.isChecked());
            if (compoundButton.isChecked()) {
                this.f20741a.setVisibility(0);
                this.f20742b.setVisibility(8);
            } else {
                this.f20741a.setVisibility(8);
                this.f20742b.setVisibility(0);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.OOBEPhoneFinderActivity$c */
    public class C4517c implements InterfaceC13450c {
        public C4517c() {
        }

        @Override // p709vj.InterfaceC13450c
        /* renamed from: a */
        public void mo20330a(ErrorStatus errorStatus) {
            C11839m.m70687e("OOBEPhoneFinderActivity", "CheckPasswd error callback");
            if (errorStatus != null && !errorStatus.getErrorReason().isEmpty() && errorStatus.getErrorCode() != 3002) {
                String errorReason = errorStatus.getErrorReason();
                C11839m.m70687e("OOBEPhoneFinderActivity", "CheckPasswd error reason: " + errorReason);
                Toast.makeText(OOBEPhoneFinderActivity.this, errorReason, 0).show();
            }
            if (OOBEPhoneFinderActivity.this.f20715C != null) {
                OOBEPhoneFinderActivity.this.f20715C.setCheckedProgrammatically(true);
            }
        }

        @Override // p709vj.InterfaceC13450c
        /* renamed from: b */
        public void mo20331b() {
            C11839m.m70688i("OOBEPhoneFinderActivity", "CheckPasswd success callback");
            OOBEPhoneFinderActivity.this.f12344d = false;
            C1010e.m6125b().m6156v(OOBEPhoneFinderActivity.this.getApplicationContext());
            OOBEPhoneFinderActivity.this.m27614i1(true);
            OOBEPhoneFinderActivity.this.m27603D1(false);
        }

        public /* synthetic */ C4517c(OOBEPhoneFinderActivity oOBEPhoneFinderActivity, C4515a c4515a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.OOBEPhoneFinderActivity$d */
    public enum EnumC4518d {
        NEXT,
        SKIP
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.OOBEPhoneFinderActivity$e */
    public static class C4519e implements InterfaceC13456i {

        /* renamed from: a */
        public WeakReference<OOBEPhoneFinderActivity> f20747a;

        public C4519e(OOBEPhoneFinderActivity oOBEPhoneFinderActivity) {
            this.f20747a = new WeakReference<>(oOBEPhoneFinderActivity);
        }

        @Override // p709vj.InterfaceC13456i
        public void loginResult(boolean z10) {
            OOBEPhoneFinderActivity oOBEPhoneFinderActivity = this.f20747a.get();
            if (oOBEPhoneFinderActivity == null) {
                return;
            }
            oOBEPhoneFinderActivity.m27626w1(z10);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.OOBEPhoneFinderActivity$f */
    public static class C4520f extends TimerTask {

        /* renamed from: b */
        public static Timer f20748b;

        /* renamed from: c */
        public static TimerTask f20749c;

        /* renamed from: a */
        public WeakReference<OOBEPhoneFinderActivity> f20750a;

        public C4520f(OOBEPhoneFinderActivity oOBEPhoneFinderActivity) {
            this.f20750a = new WeakReference<>(oOBEPhoneFinderActivity);
        }

        /* renamed from: a */
        public static void m27633a(OOBEPhoneFinderActivity oOBEPhoneFinderActivity) {
            m27634c();
            f20748b = new Timer();
            C4520f c4520f = new C4520f(oOBEPhoneFinderActivity);
            f20749c = c4520f;
            f20748b.schedule(c4520f, 38000L);
        }

        /* renamed from: c */
        public static void m27634c() {
            Timer timer = f20748b;
            if (timer != null) {
                timer.cancel();
            }
            f20748b = null;
            TimerTask timerTask = f20749c;
            if (timerTask != null) {
                timerTask.cancel();
            }
            f20749c = null;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            OOBEPhoneFinderActivity oOBEPhoneFinderActivity = this.f20750a.get();
            if (oOBEPhoneFinderActivity == null) {
                return;
            }
            oOBEPhoneFinderActivity.m27590a();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.OOBEPhoneFinderActivity$g */
    public static class HandlerC4521g extends Handler {

        /* renamed from: a */
        public WeakReference<OOBEPhoneFinderActivity> f20751a;

        public HandlerC4521g(OOBEPhoneFinderActivity oOBEPhoneFinderActivity) {
            this.f20751a = new WeakReference<>(oOBEPhoneFinderActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            OOBEPhoneFinderActivity oOBEPhoneFinderActivity = this.f20751a.get();
            if (oOBEPhoneFinderActivity == null) {
                return;
            }
            int i10 = message.what;
            if (i10 == 0) {
                oOBEPhoneFinderActivity.m27609K1(false);
                return;
            }
            if (i10 == 1) {
                oOBEPhoneFinderActivity.m27609K1(true);
                return;
            }
            if (i10 == 2) {
                oOBEPhoneFinderActivity.m27608I1(1);
            } else if (i10 == 3) {
                oOBEPhoneFinderActivity.m27611N1();
            } else {
                if (i10 != 4) {
                    return;
                }
                oOBEPhoneFinderActivity.m27608I1(0);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.OOBEPhoneFinderActivity$h */
    public enum EnumC4522h {
        NORMAL,
        LOADING,
        ERROR,
        RETRY,
        NONET
    }

    /* renamed from: A1 */
    private void m27574A1() {
        if (isFinishing()) {
            C13981a.m83988e("OOBEPhoneFinderActivity", "OpenPhoneFinder is finishing");
            return;
        }
        C11877j.m71307t1(this);
        C11860j.m71037a1(1);
        C11860j.m71030X0(500);
        C11860j.m71051f0(this, 5, false);
    }

    /* renamed from: B1 */
    private void m27575B1() {
        m27602C1();
    }

    /* renamed from: J1 */
    private void m27576J1() throws IllegalAccessException, IllegalArgumentException {
        C13981a.m83989i("OOBEPhoneFinderActivity", "showLoginSuccessDialog");
        if (this.f20724L == null) {
            View viewInflate = LayoutInflater.from(this).inflate(R$layout.phone_finder_login, (ViewGroup) null);
            AlertDialog.Builder view = new AlertDialog.Builder(this).setView(viewInflate);
            m27617m1(viewInflate);
            view.setTitle(getResources().getString(R$string.popupwindow_opentitle_device)).setCancelable(false);
            if (this.f20729Q) {
                RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(viewInflate, R$id.sendlastpositions);
                final CompoundButton compoundButton = (CompoundButton) C12809f.m76831d(viewInflate, R$id.photo_switch_sendlastposition);
                TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.cloudbackupopen);
                TextView textView2 = (TextView) C12809f.m76831d(viewInflate, R$id.cloudbackuptip);
                if (C0209d.m1293p1()) {
                    relativeLayout.setVisibility(8);
                } else {
                    if (m27619o1()) {
                        relativeLayout.setVisibility(0);
                    } else {
                        relativeLayout.setVisibility(8);
                    }
                    compoundButton.setOnCheckedChangeListener(new C4516b(textView, textView2));
                }
                view.setPositiveButton(R$string.beta_ok, new DialogInterface.OnClickListener() { // from class: hg.m0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        this.f49499a.m27621q1(compoundButton, dialogInterface, i10);
                    }
                });
            } else {
                view.setPositiveButton(R$string.beta_ok, new DialogInterface.OnClickListener() { // from class: hg.n0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        this.f49502a.m27622r1(dialogInterface, i10);
                    }
                });
            }
            AlertDialog alertDialogCreate = view.create();
            this.f20724L = alertDialogCreate;
            alertDialogCreate.setCanceledOnTouchOutside(false);
            C11829c.m70594l1(this, this.f20724L);
            m16607r0(this.f20724L);
        }
        if (this.f20724L.isShowing()) {
            return;
        }
        this.f20724L.show();
    }

    /* renamed from: L1 */
    private void m27577L1(int i10) {
        C13981a.m83989i("OOBEPhoneFinderActivity", "showOpenFailedConfirmDialog, errorCode: " + i10);
        ListItemPatterm listItemPatterm = this.f20715C;
        if (listItemPatterm == null || !listItemPatterm.getSwitchStatus()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton(getString(R$string.beta_ok), new DialogInterface.OnClickListener() { // from class: hg.l0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                this.f49497a.m27623s1(dialogInterface, i11);
            }
        });
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.open_phone_finder_failed, (ViewGroup) null);
        builder.setView(viewInflate);
        AlertDialog alertDialog = this.f20727O;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f20727O = null;
        }
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.phonefinder_failure_retry);
        TextView textView2 = (TextView) C12809f.m76831d(viewInflate, R$id.phonefinder_failure_retry_later);
        if (i10 == 3201) {
            textView.setText(R$string.phonefinder_dialog_title_open_fail_device);
            textView2.setText(R$string.phonefinder_dialog_content_open_fail_device);
        } else {
            textView.setText(C11842p.m70762R0() ? R$string.open_phonefinder_failure_toast_pad : R$string.open_phonefinder_failure_toast);
            textView2.setText(R$string.open_phonefinder_failure_later);
        }
        AlertDialog alertDialogCreate = builder.create();
        this.f20727O = alertDialogCreate;
        m16607r0(alertDialogCreate);
        this.f20727O.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m27590a() {
        m27605F1(EnumC4522h.NORMAL);
        m27610M1();
    }

    /* renamed from: f1 */
    private void m27596f1() {
        try {
            AlertDialog alertDialog = this.f20726N;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f20726N = null;
            }
            AlertDialog alertDialog2 = this.f20727O;
            if (alertDialog2 != null) {
                alertDialog2.dismiss();
                this.f20727O = null;
            }
        } catch (IllegalArgumentException unused) {
            C13981a.m83988e("OOBEPhoneFinderActivity", "dialog dismiss IllegalArgumentException");
        }
    }

    /* renamed from: g1 */
    private void m27597g1() {
        C13981a.m83989i("OOBEPhoneFinderActivity", "closePhoneFinder");
        ListItemPatterm listItemPatterm = this.f20715C;
        if (listItemPatterm == null || listItemPatterm.getSwitchStatus() || !C1010e.m6125b().m6139e(this)) {
            m27614i1(true);
        } else {
            C13195l.m79272J().m79324o(this, C13452e.m80781L().m80905e(), 8913, this.f20735W);
        }
    }

    /* renamed from: h1 */
    private void m27598h1() {
        boolean switchStatus = this.f20716D.getSwitchStatus();
        C13981a.m83987d("OOBEPhoneFinderActivity", "doWithLastLocCheckedChange--getSwitchStatus=" + switchStatus);
        Intent intent = new Intent("com.huawei.android.remotecontrol.PHONEFINDER_LASTLOCATION_SWITCHER");
        intent.putExtra("phonefinder_lastlocation_switcher_result", switchStatus);
        C13108a.m78878b(this).m78881d(intent);
        C11877j.m71243X0(this, Boolean.valueOf(switchStatus));
    }

    /* renamed from: l1 */
    private void m27599l1() {
        NetStateListen netStateListen = this.f20731S;
        if (netStateListen != null) {
            netStateListen.m27632b(getApplicationContext());
            this.f20731S = null;
        }
        try {
            Intent intent = new Intent("com.android.net.wifi.SETUP_WIFI_NETWORK");
            C0209d.m1302r2(intent, "com.android.settings");
            intent.putExtra("extra_prefs_show_button_bar", true);
            intent.putExtra("extra_show_fake_status_bar", true);
            intent.putExtra("firstRun", true);
            intent.putExtra("hw_frp_token", this.f20730R);
            startActivityForResult(intent, 2);
        } catch (Exception unused) {
            C13981a.m83988e("OOBEPhoneFinderActivity", "startActivity: WIFI failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v1 */
    public void m27600v1() {
        if (C0209d.m1333z1(this)) {
            NetStateListen netStateListen = this.f20731S;
            if (netStateListen != null) {
                netStateListen.m27632b(getApplicationContext());
                this.f20731S = null;
            }
            m27627y1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x1 */
    public void m27601x1(boolean z10, int i10) throws IllegalAccessException, IllegalArgumentException {
        m27598h1();
        C4520f.m27634c();
        if (z10) {
            C13981a.m83987d("OOBEPhoneFinderActivity", "ACTION_PHONEFINDER_RESULT= true");
            m27605F1(EnumC4522h.NORMAL);
            m27576J1();
            return;
        }
        C13981a.m83987d("OOBEPhoneFinderActivity", "ACTION_PHONEFINDER_RESULT= false");
        m27605F1(EnumC4522h.NORMAL);
        if (i10 == 37 || i10 == 3201) {
            m27577L1(i10);
        } else {
            m27610M1();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: A0 */
    public void mo16551A0() {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        C0089a c0089a = this.f12348h;
        if (c0089a != null && (relativeLayout2 = this.f12349i) != null) {
            c0089a.mo700m(this, relativeLayout2);
        }
        super.mo16551A0();
        if (C0219i.m1463a() < 27 || (relativeLayout = this.f12349i) == null) {
            return;
        }
        C11842p.m70811f2(relativeLayout, C11842p.m70864t(this));
        RelativeLayout relativeLayout3 = this.f12349i;
        relativeLayout3.setPadding(0, relativeLayout3.getPaddingTop(), 0, this.f12349i.getPaddingBottom());
    }

    /* renamed from: C1 */
    public final void m27602C1() {
        if (C11881n.m71339B(this)) {
            m27614i1(true);
        } else {
            m27613b();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: D */
    public void mo16556D() {
        super.mo16556D();
        HwButton hwButton = this.f12364x;
        if (hwButton != null) {
            hwButton.setVisibility(4);
        }
        HwButton hwButton2 = this.f12365y;
        if (hwButton2 != null) {
            hwButton2.setText(com.huawei.android.hicloud.oobe.R$string.cloud_oobe_continue_btn);
        }
    }

    /* renamed from: D1 */
    public final void m27603D1(boolean z10) {
        HwButton hwButton = this.f12365y;
        if (hwButton != null) {
            hwButton.setWaitingEnable(z10, null);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: E0 */
    public void mo16659E0() {
        C13981a.m83987d("OOBEPhoneFinderActivity", "onCancle--mUiState=" + this.f20733U);
        EnumC4522h enumC4522h = EnumC4522h.NORMAL;
        if (enumC4522h == this.f20733U) {
            m27614i1(false);
        } else {
            m27605F1(enumC4522h);
        }
    }

    /* renamed from: E1 */
    public final void m27604E1() {
        C13981a.m83989i("OOBEPhoneFinderActivity", "setResult");
        setResult(CBSBaseResp.RESULTCODE_BACKUPRECORDS_INUSED);
        finish();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: F0 */
    public void mo16660F0() {
        BetaDialog betaDialog;
        if (SystemClock.elapsedRealtime() - this.f20728P < 1500) {
            C13981a.m83989i("OOBEPhoneFinderActivity", "click the next button twice too fast");
            return;
        }
        this.f20728P = SystemClock.elapsedRealtime();
        boolean zM27618n1 = m27618n1();
        C11019b.m66371t().m66420g0(this);
        C11019b.m66371t().m66436o0(this, "phonefinderOOBE", zM27618n1);
        C0209d.m1318v2(this);
        if (zM27618n1) {
            m27616k1();
            return;
        }
        if (!C0209d.m1193N0()) {
            m27597g1();
            return;
        }
        try {
            betaDialog = (BetaDialog) getFragmentManager().findFragmentByTag("beta");
        } catch (ClassCastException e10) {
            C13981a.m83988e("OOBEPhoneFinderActivity", "findFragmentByTag error:" + e10.getMessage());
            betaDialog = null;
        }
        if (betaDialog == null) {
            BetaDialog.newInstances(false).show(getFragmentManager(), "beta");
        }
    }

    /* renamed from: F1 */
    public final void m27605F1(final EnumC4522h enumC4522h) {
        if (this.f20725M == null) {
            return;
        }
        C0226l0.m1584d(new Runnable() { // from class: hg.k0
            @Override // java.lang.Runnable
            public final void run() {
                this.f49493a.m27620p1(enumC4522h);
            }
        });
        this.f20733U = enumC4522h;
        Message messageObtainMessage = this.f20725M.obtainMessage();
        int i10 = C4515a.f20740a[enumC4522h.ordinal()];
        if (i10 == 1) {
            messageObtainMessage.what = 0;
        } else if (i10 == 2) {
            messageObtainMessage.what = 1;
        } else if (i10 == 3) {
            messageObtainMessage.what = 2;
        } else if (i10 == 4) {
            messageObtainMessage.what = 3;
        } else if (i10 != 5) {
            return;
        } else {
            messageObtainMessage.what = 4;
        }
        this.f20725M.sendMessage(messageObtainMessage);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: G */
    public void mo16559G() throws Resources.NotFoundException {
        OOBENavLayoutPf oOBENavLayoutPf;
        super.mo16559G();
        if (this.f20729Q && (oOBENavLayoutPf = this.f12403A) != null) {
            oOBENavLayoutPf.m17039a();
        }
        this.f12353m = (NotchBottomFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_bottom_frame);
        this.f12352l = (NotchFitOOBENavLinearLayout) C12809f.m76829b(this, R$id.notch_fit_oobe_nav);
        this.f20717E = C12809f.m76829b(this, R$id.oobe_pf_content_normal);
        this.f20718F = C12809f.m76829b(this, R$id.oobe_pf_content_error);
        this.f20719G = C12809f.m76829b(this, R$id.oobe_pf_content_retry);
        this.f20715C = (ListItemPatterm) C12809f.m76829b(this, R$id.oobe_pf_patterm_open);
        this.f20716D = (ListItemPatterm) C12809f.m76829b(this, R$id.oobe_pf_patterm_lastposition);
        this.f20715C.setSwitchStatus(true);
        this.f20715C.setSwitchTag("switch_phone_finder");
        this.f20715C.setSwitchListen(this);
        this.f20715C.setText(getResources().getString(C11842p.m70762R0() ? R$string.phone_findback_title_20160528_pad : R$string.phone_findback_title_20160528));
        this.f20716D.setSwitchStatus(true);
        this.f20716D.setSwitchTag("switch_last_position");
        this.f20716D.setSwitchListen(this);
        this.f20721I = (TextView) C12809f.m76829b(this, R$id.oobe_phonefinder_tryagain);
        HwButton hwButton = (HwButton) C12809f.m76829b(this, R$id.oobe_set_net_btn);
        this.f20722J = hwButton;
        hwButton.setOnClickListener(this);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.phonefinder_tip);
        this.f20720H = textView;
        textView.setText(getString(R$string.phonefinder_use_send_tip_version_2_90_upd, ""));
        C11842p.m70715B1(this, this.f20717E);
        m16667M0((OOBETopView) C12809f.m76829b(this, R$id.oobe_start_top_frame));
        if (C1175a.m7395q(this, C13452e.m80781L().m80971t0())) {
            this.f20715C.setSwitchStatus(false);
        }
        m16557E();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: G0 */
    public void mo16661G0() {
        C0209d.m1318v2(this);
        m27614i1(true);
    }

    /* renamed from: G1 */
    public final void m27606G1() {
        if (isFinishing()) {
            C13981a.m83988e("OOBEPhoneFinderActivity", "OpenPhoneFinder is finishing");
            return;
        }
        if (C4515a.f20740a[this.f20733U.ordinal()] != 1) {
            m27605F1(EnumC4522h.RETRY);
        } else {
            m27605F1(EnumC4522h.LOADING);
        }
        C4520f.m27633a(this);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: H0 */
    public int mo16662H0() {
        return R$layout.oobe_phonefinder_100;
    }

    /* renamed from: H1 */
    public final void m27607H1() {
        BetaDialog betaDialog;
        try {
            betaDialog = (BetaDialog) getFragmentManager().findFragmentByTag("beta_pwd");
        } catch (ClassCastException e10) {
            C13981a.m83988e("OOBEPhoneFinderActivity", "findFragmentByTag error:" + e10.getMessage());
            betaDialog = null;
        }
        if (betaDialog == null) {
            BetaDialog.newInstances(true).show(getFragmentManager(), "beta");
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: I0 */
    public int mo16663I0() {
        return R$layout.oobe_phonefinder_80;
    }

    /* renamed from: I1 */
    public final void m27608I1(int i10) {
        this.f20717E.setVisibility(8);
        this.f20718F.setVisibility(0);
        this.f20719G.setVisibility(8);
        TextView textView = this.f20721I;
        if (textView != null && this.f20722J != null) {
            if (i10 == 0) {
                textView.setText(R$string.network_unavailable);
                this.f20721I.setOnClickListener(this);
                this.f20722J.setVisibility(0);
            } else {
                textView.setText(R$string.connect_server_fail_msg1);
                this.f20721I.setOnClickListener(this);
                this.f20722J.setVisibility(8);
            }
        }
        m16668N0(OOBENavLayoutPf.EnumC2866b.SKIP);
        this.f12403A.setEnabled(true);
        m16667M0((OOBETopView) C12809f.m76829b(this, R$id.oobe_pf_content_error_top));
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: J0 */
    public int mo16664J0() {
        return R$layout.oobe_phonefinder_90;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: K0 */
    public void mo16665K0() {
        if (this.f20723K == null) {
            this.f20723K = new HiSyncReceiver(this);
        }
        this.f20723K.m27629a(this);
        if (this.f20725M == null) {
            this.f20725M = new HandlerC4521g(this);
        }
    }

    /* renamed from: K1 */
    public final void m27609K1(boolean z10) {
        this.f20717E.setVisibility(0);
        this.f20718F.setVisibility(8);
        this.f20719G.setVisibility(8);
        this.f12403A.setEnabled(true);
        OOBENavLayoutPf.EnumC2866b enumC2866b = OOBENavLayoutPf.EnumC2866b.NEXT;
        m16668N0(enumC2866b);
        if (!this.f20729Q) {
            this.f12351k.m17046h();
        }
        if (z10) {
            this.f20715C.setEnabled(false);
            this.f20716D.setEnabled(false);
            m16668N0(OOBENavLayoutPf.EnumC2866b.LOADING);
        } else {
            this.f20715C.setEnabled(true);
            this.f20716D.setEnabled(true);
            m16668N0(enumC2866b);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, p709vj.InterfaceC13449b
    /* renamed from: L */
    public void mo13808L(Exception exc) {
        if (exc != null) {
            C13981a.m83988e("OOBEPhoneFinderActivity", "onError:" + exc.toString());
        }
        m27605F1(EnumC4522h.ERROR);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: L0 */
    public void mo16666L0() {
        HandlerC4521g handlerC4521g = this.f20725M;
        if (handlerC4521g != null) {
            handlerC4521g.removeCallbacksAndMessages(null);
            this.f20725M = null;
        }
        HiSyncReceiver hiSyncReceiver = this.f20723K;
        if (hiSyncReceiver != null) {
            hiSyncReceiver.m27630b(this);
        }
        C4520f.m27634c();
        AlertDialog alertDialog = this.f20724L;
        if (alertDialog != null) {
            alertDialog.cancel();
            this.f20724L = null;
        }
    }

    /* renamed from: M1 */
    public final void m27610M1() {
        C13981a.m83989i("OOBEPhoneFinderActivity", "showOpenFailedDialog");
        ListItemPatterm listItemPatterm = this.f20715C;
        if (listItemPatterm == null || !listItemPatterm.getSwitchStatus()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: hg.o0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f49504a.m27624t1(dialogInterface, i10);
            }
        };
        DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: hg.p0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f49506a.m27625u1(dialogInterface, i10);
            }
        };
        builder.setPositiveButton(getString(R$string.cloudbackup_retry), onClickListener);
        builder.setNegativeButton(getString(R$string.cloudbackup_btn_cancel), onClickListener2);
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.open_phone_finder_failed, (ViewGroup) null);
        builder.setView(viewInflate);
        AlertDialog alertDialog = this.f20726N;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f20726N = null;
        }
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.phonefinder_failure_retry);
        TextView textView2 = (TextView) C12809f.m76831d(viewInflate, R$id.phonefinder_failure_retry_later);
        textView.setText(C11842p.m70762R0() ? R$string.open_phonefinder_failure_retry_pad : R$string.open_phonefinder_failure_retry);
        textView2.setText(R$string.open_phonefinder_failure_retry_later);
        AlertDialog alertDialogCreate = builder.create();
        this.f20726N = alertDialogCreate;
        m16607r0(alertDialogCreate);
        this.f20726N.show();
        Button button = this.f20726N.getButton(-1);
        Resources resources = getResources();
        if (button == null || resources == null) {
            return;
        }
        button.setTextColor(resources.getColor(R$color.emui_functional_red));
    }

    /* renamed from: N1 */
    public final void m27611N1() {
        this.f20717E.setVisibility(8);
        this.f20718F.setVisibility(8);
        this.f20719G.setVisibility(0);
        m16668N0(OOBENavLayoutPf.EnumC2866b.SKIP);
        this.f12403A.setEnabled(false);
        m16667M0((OOBETopView) C12809f.m76829b(this, R$id.oobe_pf_content_retry_top));
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: O */
    public void mo16566O() {
        super.mo16566O();
        if (m16581d0()) {
            C11842p.m70736I1(C12809f.m76829b(this, R$id.oobe_pf_content_normal), getResources().getDimensionPixelSize(R$dimen.oobe_title_margin_bottom));
        }
    }

    /* renamed from: O1 */
    public final void m27612O1(Bundle bundle) {
        if (bundle == null) {
            C13981a.m83988e("OOBEPhoneFinderActivity", "writeAccount bundle is null");
            m27605F1(EnumC4522h.ERROR);
            return;
        }
        String string = bundle.getString("accountName");
        String string2 = bundle.getString(JsbMapKeyNames.H5_USER_ID);
        if (TextUtils.isEmpty(string)) {
            C13981a.m83988e("OOBEPhoneFinderActivity", "writeAccount have the invalid params name");
            m27605F1(EnumC4522h.ERROR);
            return;
        }
        if (TextUtils.isEmpty(string2)) {
            C13981a.m83988e("OOBEPhoneFinderActivity", "writeAccount have the invalid params userId");
            m27605F1(EnumC4522h.ERROR);
            return;
        }
        if (C1175a.m7395q(getApplicationContext(), string2)) {
            C13981a.m83989i("OOBEPhoneFinderActivity", "writeAccount: open phoneFinder fail, uid not match");
            m27605F1(EnumC4522h.NORMAL);
            m27577L1(0);
        } else {
            if (!C13195l.m79272J().m79306V(C13452e.m80781L().m80905e())) {
                m27574A1();
                return;
            }
            new ThirdAccoutnDialog().show(getFragmentManager(), "ThirdAccoutnDialog");
            ListItemPatterm listItemPatterm = this.f20715C;
            if (listItemPatterm != null) {
                listItemPatterm.setSwitchStatus(false);
            }
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, p709vj.InterfaceC13449b
    /* renamed from: W */
    public void mo13820W(Bundle bundle) {
        C13981a.m83989i("OOBEPhoneFinderActivity", "onLogin");
        m27612O1(bundle);
    }

    /* renamed from: b */
    public void m27613b() {
        String str;
        try {
            Intent intent = new Intent();
            intent.setAction("com.android.settings.SETUP_LOCK_SCREEN");
            C0209d.m1302r2(intent, "com.android.settings");
            intent.putExtra("useImmersiveMode", true);
            intent.putExtra("firstRun", true);
            intent.putExtra("hasMultipleUsers", false);
            intent.putExtra("oobe_phonefinder", true);
            startActivityForResult(intent, 1);
            str = "success";
        } catch (RuntimeException e10) {
            String message = e10.getMessage();
            C13981a.m83990w("OOBEPhoneFinderActivity", "intentToLockScreen activity not found" + message);
            m27614i1(true);
            str = message;
        }
        C13230i.m79504I().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", "OOBEPhoneFinderActivity", str);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: c */
    public int mo16578c() {
        return R$layout.oobe_phonefinder_111;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: c0 */
    public boolean mo16579c0() {
        return true;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: g */
    public int mo16585g() {
        return R$layout.oobe_phonefinder_101;
    }

    /* renamed from: i1 */
    public final void m27614i1(boolean z10) {
        C13981a.m83989i("OOBEPhoneFinderActivity", "finishWithResult--start=" + z10);
        setResult(z10 ? -1 : 0);
        finish();
    }

    /* renamed from: j1 */
    public final void m27615j1() {
        C13981a.m83989i("OOBEPhoneFinderActivity", "get account");
        C13195l.m79272J().m79337u0(this, false);
    }

    /* renamed from: k1 */
    public final void m27616k1() {
        m27603D1(true);
        C13981a.m83989i("OOBEPhoneFinderActivity", "getAccountInfo");
        if (!C0209d.m1333z1(this)) {
            m27605F1(EnumC4522h.NONET);
        } else if (!RequestPermissionsActivity.m27222j(this)) {
            RequestPermissionsActivity.m27224l(this);
        } else {
            m27606G1();
            m27615j1();
        }
    }

    /* renamed from: m1 */
    public final void m27617m1(View view) {
        TextView textView = (TextView) C12809f.m76831d(view, R$id.find_myphone);
        if (7 == C13452e.m80781L().m80947n0()) {
            textView.setText(getString(R$string.pf_tips_location_auto_sent));
        }
    }

    /* renamed from: n1 */
    public final boolean m27618n1() {
        ListItemPatterm listItemPatterm = this.f20715C;
        if (listItemPatterm == null) {
            return false;
        }
        return listItemPatterm.getSwitchStatus();
    }

    /* renamed from: o1 */
    public final boolean m27619o1() {
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        boolean zM62395t1 = C10028c.m62182c0().m62395t1("funcfg_cloud_backup");
        C13981a.m83989i("OOBEPhoneFinderActivity", "showLoginSuccessDialog isCloudBackupSwitchOpen:" + zM62388s);
        return !zM62388s && zM62395t1;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        C13981a.m83989i("OOBEPhoneFinderActivity", "onActivityResult, requestCode: " + i10 + ", resultCode: " + i11);
        super.onActivityResult(i10, i11, intent);
        if (2 == i10) {
            m27628z1(i11, intent);
            return;
        }
        if (i11 == 2) {
            if (C0209d.m1193N0()) {
                m27607H1();
                return;
            } else {
                m27614i1(true);
                return;
            }
        }
        if (i11 == 1) {
            C13230i.m79504I().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", "OOBEPhoneFinderActivity", "isLock:" + C0209d.m1301r1(this));
            m27614i1(true);
            return;
        }
        if (i11 == 0) {
            if (C0209d.m1193N0()) {
                m27607H1();
            }
        } else if (i10 == 8913) {
            C13195l.m79272J().m79297M(this, this.f20735W, i11, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f20729Q) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        if ("switch_phone_finder".equals((String) compoundButton.getTag())) {
            this.f20716D.setVisibility(z10 ? 0 : 8);
            this.f20715C.setDiliverBottomVisible(z10);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (R$id.oobe_phonefinder_tryagain == view.getId()) {
            m27627y1();
            return;
        }
        if (R$id.oobe_set_net_btn == view.getId()) {
            m27599l1();
        }
        super.onClick(view);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (getIntent() != null) {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
            this.f20729Q = hiCloudSafeIntent.getBooleanExtra("is_from_mr_guide", false);
            this.f20732T = hiCloudSafeIntent.getStringExtra("channel_of_open_switch");
        }
        super.onCreate(bundle);
        getWindow().setFlags(16777216, 16777216);
        RequestPermissionsActivity.m27224l(this);
        C13612b.m81829B().mo80999a(getApplicationContext(), new C4519e(this));
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onDestroy() {
        NetStateListen netStateListen = this.f20731S;
        if (netStateListen != null) {
            netStateListen.m27632b(getApplicationContext());
        }
        C12347f.m74285n().m74293G(false);
        m27596f1();
        super.onDestroy();
    }

    /* renamed from: p1 */
    public final /* synthetic */ void m27620p1(EnumC4522h enumC4522h) {
        m27603D1(enumC4522h == EnumC4522h.LOADING);
    }

    /* renamed from: q1 */
    public final /* synthetic */ void m27621q1(CompoundButton compoundButton, DialogInterface dialogInterface, int i10) {
        if (dialogInterface != null) {
            this.f20724L.dismiss();
            if (!C0209d.m1293p1() && compoundButton.isChecked()) {
                C13981a.m83989i("OOBEPhoneFinderActivity", "open cloud backup switch");
                C1007b.m5980s().m5988H();
                C11829c.m70582h1(this, this.f20732T);
                C13230i.m79504I().m79558J0("4");
            }
            m27604E1();
        }
    }

    /* renamed from: r1 */
    public final /* synthetic */ void m27622r1(DialogInterface dialogInterface, int i10) {
        if (dialogInterface != null) {
            this.f20724L.dismiss();
            if (C12347f.m74285n().m74308u()) {
                m27604E1();
            } else {
                m27575B1();
            }
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: s0 */
    public void mo16609s0() {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        C0089a c0089a = this.f12348h;
        if (c0089a != null && (relativeLayout2 = this.f12349i) != null) {
            c0089a.mo700m(this, relativeLayout2);
        }
        super.mo16609s0();
        if (C0219i.m1463a() < 27 || (relativeLayout = this.f12349i) == null) {
            return;
        }
        C11842p.m70811f2(relativeLayout, C11842p.m70864t(this));
        RelativeLayout relativeLayout3 = this.f12349i;
        relativeLayout3.setPadding(0, relativeLayout3.getPaddingTop(), 0, this.f12349i.getPaddingBottom());
    }

    /* renamed from: s1 */
    public final /* synthetic */ void m27623s1(DialogInterface dialogInterface, int i10) {
        C13981a.m83989i("OOBEPhoneFinderActivity", "open phonefinder failed, confirm");
        this.f20715C.setSwitchStatus(false);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: t */
    public List<View> mo16610t() {
        ArrayList arrayList = new ArrayList();
        NotchBottomFitRelativeLayout notchBottomFitRelativeLayout = this.f12353m;
        if (notchBottomFitRelativeLayout != null) {
            arrayList.add(notchBottomFitRelativeLayout);
        }
        NotchFitOOBENavLinearLayout notchFitOOBENavLinearLayout = this.f12352l;
        if (notchFitOOBENavLinearLayout != null) {
            arrayList.add(notchFitOOBENavLinearLayout);
        }
        return arrayList;
    }

    /* renamed from: t1 */
    public final /* synthetic */ void m27624t1(DialogInterface dialogInterface, int i10) {
        C13981a.m83989i("OOBEPhoneFinderActivity", "open phonefinder failed,retry");
        m27627y1();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: u0 */
    public void mo16613u0() {
        m16603p0();
    }

    /* renamed from: u1 */
    public final /* synthetic */ void m27625u1(DialogInterface dialogInterface, int i10) {
        C13981a.m83989i("OOBEPhoneFinderActivity", "open phonefinder failed, cancel");
        this.f20715C.setSwitchStatus(false);
    }

    /* renamed from: w1 */
    public final void m27626w1(boolean z10) {
        if (z10) {
            C13981a.m83989i("OOBEPhoneFinderActivity", "loginResult:" + z10);
        }
    }

    /* renamed from: y1 */
    public final void m27627y1() {
        C13981a.m83989i("OOBEPhoneFinderActivity", "on Retry");
        m27616k1();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: z0 */
    public void mo16622z0() {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        C0089a c0089a = this.f12348h;
        if (c0089a != null && (relativeLayout2 = this.f12349i) != null) {
            c0089a.mo700m(this, relativeLayout2);
        }
        super.mo16622z0();
        if (C0219i.m1463a() < 27 || (relativeLayout = this.f12349i) == null) {
            return;
        }
        C11842p.m70811f2(relativeLayout, C11842p.m70864t(this));
        RelativeLayout relativeLayout3 = this.f12349i;
        relativeLayout3.setPadding(0, relativeLayout3.getPaddingTop(), 0, this.f12349i.getPaddingBottom());
    }

    /* renamed from: z1 */
    public final void m27628z1(int i10, Intent intent) {
        C13981a.m83989i("OOBEPhoneFinderActivity", "onSetNetFinish:resultCode=" + i10);
        if (C0209d.m1333z1(this)) {
            m27627y1();
            return;
        }
        if (this.f20731S == null) {
            this.f20731S = new NetStateListen(this);
        }
        this.f20731S.m27631a(getApplicationContext());
    }
}
