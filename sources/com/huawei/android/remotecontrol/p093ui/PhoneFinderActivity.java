package com.huawei.android.remotecontrol.p093ui;

import af.C0190c;
import android.R;
import android.accounts.OperationCanceledException;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.BounceInterpolator;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import bf.C1175a;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.ScaleRoundRectImageView;
import com.huawei.android.remotecontrol.offlinelocate.C4375j;
import com.huawei.android.remotecontrol.offlinelocate.PhoneFinderTrustCircleManager;
import com.huawei.android.remotecontrol.offlinelocate.bean.TrustCircleInfo;
import com.huawei.android.remotecontrol.p093ui.PhoneFinderActivity;
import com.huawei.android.remotecontrol.p093ui.activation.ActivationNormalActivity;
import com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneActivity;
import com.huawei.android.remotecontrol.p093ui.widget.ListItemPatterm;
import com.huawei.android.remotecontrol.p093ui.widget.SpanClickText;
import com.huawei.android.remotecontrol.p093ui.widget.TipLinearLayout;
import com.huawei.android.remotecontrol.p093ui.widget.TopAnimatorView;
import com.huawei.android.remotecontrol.sdk.R$color;
import com.huawei.android.remotecontrol.sdk.R$drawable;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.sharing.p091ui.ShareManagerActivity;
import com.huawei.android.remotecontrol.util.NewHiSyncUtil;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.model.AccountConstant;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.network.p129ai.C5807k0;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import eg.AbstractC9478g;
import eg.C9476e;
import fk.C9721b;
import gg.C9916a;
import gp.C10028c;
import ie.C10474a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Timer;
import java.util.function.Consumer;
import nf.C11690w;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p015ak.C0224k0;
import p015ak.C0226l0;
import p020ap.C1007b;
import p037bp.C1270a;
import p232dp.InterfaceC9285d;
import p366if.C10487l;
import p367ig.C10496a;
import p367ig.C10497b;
import p367ig.C10501f;
import p514o9.C11828b;
import p514o9.C11829c;
import p514o9.C11838l;
import p514o9.C11842p;
import p520of.C11860j;
import p520of.C11866p;
import p520of.C11867q;
import p521og.C11868a;
import p521og.C11877j;
import p521og.C11880m;
import p521og.C11881n;
import p575qe.C12347f;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p655te.C13009a;
import p664u0.C13108a;
import p674ub.C13149f;
import p681uj.C13195l;
import p684un.C13222a;
import p684un.C13230i;
import p709vj.C13452e;
import p709vj.InterfaceC13449b;
import p742wj.C13612b;
import p774xg.C13811a;
import p783xp.C13843a;
import p809yg.C13981a;
import p846zj.C14306d;
import pg.AbstractC12139d;
import sk.C12809f;
import tj.C13019a;
import tm.C13040c;
import ug.C13171a;

/* loaded from: classes4.dex */
public class PhoneFinderActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, Consumer<Location> {

    /* renamed from: B */
    public ScaleRoundRectImageView f20427B;

    /* renamed from: C */
    public ScaleRoundRectImageView f20428C;

    /* renamed from: D */
    public ImageView f20429D;

    /* renamed from: E */
    public AutoSizeButton f20430E;

    /* renamed from: F */
    public Timer f20431F;

    /* renamed from: L */
    public boolean f20437L;

    /* renamed from: M */
    public String f20438M;

    /* renamed from: N */
    public String f20439N;

    /* renamed from: O */
    public AlertDialog f20440O;

    /* renamed from: P */
    public AlertDialog f20441P;

    /* renamed from: Q */
    public AlertDialog f20442Q;

    /* renamed from: R */
    public ListItemPatterm f20443R;

    /* renamed from: S */
    public ListItemPatterm f20444S;

    /* renamed from: T */
    public ListItemPatterm f20445T;

    /* renamed from: U */
    public TopAnimatorView f20446U;

    /* renamed from: V */
    public LinearLayout f20447V;

    /* renamed from: W */
    public LinearLayout f20448W;

    /* renamed from: X */
    public TextView f20449X;

    /* renamed from: Y */
    public TextView f20450Y;

    /* renamed from: Z */
    public TextView f20451Z;

    /* renamed from: a0 */
    public TextView f20452a0;

    /* renamed from: e0 */
    public HandlerC4468m f20456e0;

    /* renamed from: f0 */
    public C4464i f20457f0;

    /* renamed from: g0 */
    public InterfaceC9285d f20458g0;

    /* renamed from: i0 */
    public TipLinearLayout f20460i0;

    /* renamed from: j0 */
    public View f20461j0;

    /* renamed from: k0 */
    public HiCloudExceptionView f20462k0;

    /* renamed from: l0 */
    public C4467l f20463l0;

    /* renamed from: m0 */
    public AlertDialog f20464m0;

    /* renamed from: r0 */
    public AlertDialog f20470r0;

    /* renamed from: w */
    public NewHiSyncUtil f20475w;

    /* renamed from: z */
    public ActionBar f20478z;

    /* renamed from: r */
    public NotchTopFitRelativeLayout f20469r = null;

    /* renamed from: s */
    public ScrollView f20471s = null;

    /* renamed from: t */
    public TextView f20472t = null;

    /* renamed from: u */
    public View f20473u = null;

    /* renamed from: v */
    public View f20474v = null;

    /* renamed from: x */
    public Activity f20476x = null;

    /* renamed from: y */
    public HiSyncReceiver f20477y = null;

    /* renamed from: A */
    public boolean f20426A = false;

    /* renamed from: G */
    public volatile boolean f20432G = false;

    /* renamed from: H */
    public int f20433H = 4;

    /* renamed from: I */
    public boolean f20434I = false;

    /* renamed from: J */
    public boolean f20435J = true;

    /* renamed from: K */
    public boolean f20436K = false;

    /* renamed from: b0 */
    public boolean f20453b0 = false;

    /* renamed from: c0 */
    public Location f20454c0 = null;

    /* renamed from: d0 */
    public String f20455d0 = "";

    /* renamed from: h0 */
    public boolean f20459h0 = true;

    /* renamed from: n0 */
    public int f20465n0 = 0;

    /* renamed from: o0 */
    public final int f20466o0 = 2;

    /* renamed from: p0 */
    public boolean f20467p0 = true;

    /* renamed from: q0 */
    public C13149f f20468q0 = new C13149f();

    public class HiSyncReceiver extends BroadcastReceiver {
        public HiSyncReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws IllegalAccessException, IllegalArgumentException {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            if (hiCloudSafeIntent.getAction() == null) {
                C13981a.m83988e("PhoneFinderActivity", "HiSyncReceiver ation is null");
                return;
            }
            String action = hiCloudSafeIntent.getAction();
            C13981a.m83989i("PhoneFinderActivity", "Intent.action:" + action);
            if (PhoneFinderActivity.this.f20456e0 == null) {
                C13981a.m83990w("PhoneFinderActivity", "mUiHandler is null");
            } else {
                PhoneFinderActivity.this.m27135R2(context, hiCloudSafeIntent, action);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.PhoneFinderActivity$a */
    public class C4456a implements NewHiSyncUtil.InterfaceC4549c {
        public C4456a() {
        }

        @Override // com.huawei.android.remotecontrol.util.NewHiSyncUtil.InterfaceC4549c
        /* renamed from: a */
        public void mo27197a() {
            String message;
            try {
                Intent intent = new Intent(C0209d.m1165E0(PhoneFinderActivity.this.f20476x) ? "com.android.settings.PHONE_FINDER_LOCK_SCREEN" : "android.app.action.SET_NEW_PASSWORD");
                intent.addCategory("android.intent.category.DEFAULT");
                C0209d.m1302r2(intent, "com.android.settings");
                PhoneFinderActivity.this.f20476x.startActivityForResult(intent, PhoneFinderActivity.this.f20433H);
                message = "success";
            } catch (Exception e10) {
                C13981a.m83988e("PhoneFinderActivity", "Start set new password activity error." + e10.getMessage());
                message = e10.getMessage();
            }
            C13230i.m79504I().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", "PhoneFinderActivity", message);
        }

        @Override // com.huawei.android.remotecontrol.util.NewHiSyncUtil.InterfaceC4549c
        /* renamed from: b */
        public void mo27198b() {
            C13230i.m79504I().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", "PhoneFinderActivity", "cancel");
            PhoneFinderActivity.this.m27114G2();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.PhoneFinderActivity$b */
    public class DialogInterfaceOnClickListenerC4457b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC4457b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (dialogInterface != null) {
                PhoneFinderActivity.this.m27151Z3();
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.PhoneFinderActivity$c */
    public class DialogInterfaceOnClickListenerC4458c implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ CompoundButton f20482a;

        public DialogInterfaceOnClickListenerC4458c(CompoundButton compoundButton) {
            this.f20482a = compoundButton;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (dialogInterface != null) {
                PhoneFinderActivity.this.f20436K = false;
                C11877j.m71250a1(PhoneFinderActivity.this.f20476x, Boolean.FALSE);
                if (PhoneFinderActivity.this.f20440O != null) {
                    PhoneFinderActivity.this.f20440O.dismiss();
                    PhoneFinderActivity.this.f20440O = null;
                }
                if (PhoneFinderActivity.this.f20443R != null && PhoneFinderActivity.this.f20443R.getSwitchStatus()) {
                    PhoneFinderActivity.this.m27126N2();
                }
                if (this.f20482a.isChecked() && C10028c.m62182c0().m62395t1("funcfg_cloud_backup")) {
                    C13981a.m83989i("PhoneFinderActivity", "showLoginSuccessDialog isCloudbuakupSwitchOpen is false, onClick to open");
                    C1007b.m5980s().m5988H();
                    C13230i.m79504I().m79558J0("4");
                }
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.PhoneFinderActivity$d */
    public class C4459d extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ String f20484a;

        public C4459d(String str) {
            this.f20484a = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String strM78625Q;
            try {
                strM78625Q = C13040c.m78609F().m78625Q();
            } catch (C9721b e10) {
                C13981a.m83988e("PhoneFinderActivity", "jumpToInstructions error " + e10.toString());
                strM78625Q = "";
            }
            if (TextUtils.isEmpty(strM78625Q)) {
                C13981a.m83988e("PhoneFinderActivity", "get portal url from grs failed");
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 4024;
            Bundle bundle = new Bundle();
            bundle.putString("url", strM78625Q + "/phonefindguideV2?lang=" + C11881n.m71371u());
            bundle.putString("title", this.f20484a);
            messageObtain.setData(bundle);
            PhoneFinderActivity.this.f20456e0.sendMessage(messageObtain);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.PhoneFinderActivity$e */
    public class C4460e extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ String f20486a;

        public C4460e(String str) {
            this.f20486a = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String strM78625Q;
            try {
                strM78625Q = C13040c.m78609F().m78625Q();
            } catch (C9721b e10) {
                C13981a.m83988e("PhoneFinderActivity", "jumpToPhoneFinderUse error " + e10.toString());
                strM78625Q = "";
            }
            if (TextUtils.isEmpty(strM78625Q)) {
                C13981a.m83988e("PhoneFinderActivity", "get portal url from grs failed");
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 4024;
            Bundle bundle = new Bundle();
            bundle.putString("url", strM78625Q + "/findDeviceInfo?lang=" + C11881n.m71371u());
            bundle.putString("title", this.f20486a);
            messageObtain.setData(bundle);
            PhoneFinderActivity.this.f20456e0.sendMessage(messageObtain);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.PhoneFinderActivity$f */
    public class C4461f extends AbstractC12367d {
        public C4461f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void m27200d(Bitmap bitmap) {
            if (bitmap == null) {
                C13981a.m83989i("PhoneFinderActivity", "bitmap is null");
                PhoneFinderActivity.this.m27125M3(true);
                PhoneFinderActivity.this.m27064T2();
                return;
            }
            C13981a.m83989i("PhoneFinderActivity", "display map image.");
            PhoneFinderActivity.this.m27127N3();
            PhoneFinderActivity.this.f20427B.setImageBitmap(bitmap);
            int width = bitmap.getWidth() * bitmap.getHeight();
            Bundle bundle = new Bundle();
            bundle.putString("operationType", "mapCardShow");
            bundle.putString(C5807k0.f25949l, "mapCardShow");
            bundle.putString("errorReason", "PhoneFinderActivity map show success. size: " + width);
            C11881n.m71350M(bundle);
            C13981a.m83989i("PhoneFinderActivity", "MainActivity map show success. size: " + width);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            String strM70684b = C11838l.m70684b(PhoneFinderActivity.this);
            File file = new File(strM70684b);
            if (!file.exists() || file.length() >= 4194304) {
                C13981a.m83988e("PhoneFinderActivity", "get local map image error: file not exist or too large");
            } else {
                final Bitmap bitmapM1311u = C0209d.m1311u(strM70684b);
                C0226l0.m1584d(new Runnable() { // from class: gg.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f48684a.m27200d(bitmapM1311u);
                    }
                });
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.PhoneFinderActivity$g */
    public class C4462g extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Location f20489a;

        public C4462g(Location location) {
            this.f20489a = location;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void m27203e() {
            PhoneFinderActivity.this.m27122K3();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$call$0() {
            PhoneFinderActivity.this.f20427B.setImageDrawable(null);
            PhoneFinderActivity.this.m27125M3(true);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            if (C10487l.m64539f(this.f20489a)) {
                C13981a.m83989i("PhoneFinderActivity", "location is out of China.");
                C11838l.m70683a(PhoneFinderActivity.this.f20476x);
                C0226l0.m1584d(new Runnable() { // from class: gg.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f48686a.lambda$call$0();
                    }
                });
            } else if (PhoneFinderActivity.this.f20454c0 != null) {
                C13981a.m83989i("PhoneFinderActivity", "location done, start to load map image.");
                C0226l0.m1584d(new Runnable() { // from class: gg.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f48687a.m27203e();
                    }
                });
            } else {
                PhoneFinderActivity.this.f20454c0 = C10487l.m64545l(this.f20489a);
                PhoneFinderActivity.this.m27064T2();
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.PhoneFinderActivity$h */
    public static class C4463h implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a */
        public final TextView f20491a;

        /* renamed from: b */
        public final TextView f20492b;

        public C4463h(TextView textView, TextView textView2) {
            this.f20491a = textView;
            this.f20492b = textView2;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            C13981a.m83989i("PhoneFinderActivity", "showLoginSuccessDialog cloudbackupFind.isChecked():" + compoundButton.isChecked());
            if (compoundButton.isChecked()) {
                this.f20491a.setVisibility(0);
                this.f20492b.setVisibility(8);
            } else {
                this.f20491a.setVisibility(8);
                this.f20492b.setVisibility(0);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.PhoneFinderActivity$i */
    public static class C4464i implements InterfaceC13449b {

        /* renamed from: a */
        public final WeakReference<PhoneFinderActivity> f20493a;

        /* renamed from: b */
        public final boolean f20494b;

        public C4464i(PhoneFinderActivity phoneFinderActivity, boolean z10) {
            this.f20493a = new WeakReference<>(phoneFinderActivity);
            this.f20494b = z10;
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: L */
        public void mo13808L(Exception exc) {
            C13981a.m83988e("PhoneFinderActivity", "authFailed");
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: Q */
        public boolean mo13814Q(Bundle bundle) {
            C13981a.m83988e("PhoneFinderActivity", "activatePhoneFinder");
            return false;
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: W */
        public void mo13820W(Bundle bundle) {
            PhoneFinderActivity phoneFinderActivity;
            C13981a.m83989i("PhoneFinderActivity", "authTokenSuccess" + this.f20494b);
            if (!this.f20494b || (phoneFinderActivity = this.f20493a.get()) == null) {
                return;
            }
            phoneFinderActivity.m27124L3(4);
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: e */
        public void mo13829e(OperationCanceledException operationCanceledException) {
            C13981a.m83989i("PhoneFinderActivity", "authCanceled");
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: m0 */
        public void mo13838m0(Bundle bundle) {
            C13981a.m83989i("PhoneFinderActivity", "getUserInfoSuccess");
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.PhoneFinderActivity$j */
    public class C4465j extends ClickableSpan {

        /* renamed from: a */
        public boolean f20495a = false;

        /* renamed from: b */
        public final Context f20496b;

        public C4465j(Context context) {
            this.f20496b = context;
        }

        /* renamed from: a */
        public void m27204a(boolean z10) {
            this.f20495a = z10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            C13981a.m83987d("PhoneFinderActivity", "MyClickableSpan email on click");
            PhoneFinderActivity.this.m27083h4();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f20495a ? this.f20496b.getResources().getColor(R$color.oobe_btn_pressed) : this.f20496b.getResources().getColor(R$color.attention_color));
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.PhoneFinderActivity$k */
    public class C4466k extends LinkMovementMethod {

        /* renamed from: a */
        public C4465j f20498a;

        public C4466k() {
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            this.f20498a = PhoneFinderActivity.this.m27146X2(textView, spannable, motionEvent);
            if (motionEvent.getAction() == 0) {
                C13981a.m83987d("PhoneFinderActivity", "MyLinkMovementMethod email on click");
                if (this.f20498a != null) {
                    C13981a.m83987d("PhoneFinderActivity", "mClickSpan is not null");
                    this.f20498a.m27204a(true);
                }
            } else if (2 == motionEvent.getAction()) {
                C4465j c4465jM27146X2 = PhoneFinderActivity.this.m27146X2(textView, spannable, motionEvent);
                C4465j c4465j = this.f20498a;
                if (c4465j != null && c4465jM27146X2 != c4465j) {
                    c4465j.m27204a(false);
                    this.f20498a = null;
                    Selection.removeSelection(spannable);
                }
            } else {
                Selection.removeSelection(spannable);
                C4465j c4465j2 = this.f20498a;
                if (c4465j2 == null) {
                    return true;
                }
                c4465j2.m27204a(false);
                this.f20498a = null;
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }

        public /* synthetic */ C4466k(PhoneFinderActivity phoneFinderActivity, C4456a c4456a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.PhoneFinderActivity$l */
    public static class C4467l implements SpanClickText.ISpanClickListem {

        /* renamed from: a */
        public WeakReference<PhoneFinderActivity> f20500a;

        /* renamed from: b */
        public Handler f20501b;

        /* renamed from: com.huawei.android.remotecontrol.ui.PhoneFinderActivity$l$a */
        public class a extends AbstractC9478g {

            /* renamed from: a */
            public final /* synthetic */ String f20502a;

            public a(String str) {
                this.f20502a = str;
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                String strM78625Q;
                try {
                    strM78625Q = C13040c.m78609F().m78625Q();
                } catch (C9721b e10) {
                    C13981a.m83988e("PhoneFinderActivity", "jumpToOfflineLocatePrivacy error " + e10.toString());
                    strM78625Q = "";
                }
                if (TextUtils.isEmpty(strM78625Q)) {
                    C13981a.m83988e("PhoneFinderActivity", "get portal url from grs failed");
                    return;
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 4024;
                Bundle bundle = new Bundle();
                bundle.putString("url", strM78625Q + "/findPhone/devicesAndPrivacy.html?lang=" + C11881n.m71371u());
                bundle.putString("title", this.f20502a);
                messageObtain.setData(bundle);
                C4467l.this.f20501b.sendMessage(messageObtain);
            }
        }

        public C4467l(PhoneFinderActivity phoneFinderActivity, Handler handler) {
            this.f20500a = new WeakReference<>(phoneFinderActivity);
            this.f20501b = handler;
        }

        /* renamed from: a */
        public final void m27205a(String str) {
            String strM80790C = C13452e.m80781L().m80790C();
            C13230i.m79504I().m79586g0("mecloud_findmyphone_click_offline_locate_privacy", C13452e.m80781L().m80971t0(), strM80790C);
            UBAAnalyze.m29956Q("PVP", "mecloud_findmyphone_click_offline_locate_privacy", "1", "19", strM80790C);
            C12515a.m75110o().m75172d(new a(str));
        }

        @Override // com.huawei.android.remotecontrol.ui.widget.SpanClickText.ISpanClickListem
        public void onClick(int i10) {
            PhoneFinderActivity phoneFinderActivity = this.f20500a.get();
            if (phoneFinderActivity == null) {
                C13981a.m83988e("PhoneFinderActivity", "activity is null in onClick");
            } else if (C0209d.m1226Y0()) {
                C13981a.m83989i("PhoneFinderActivity", "privacy span fastClick");
            } else if (i10 == 2) {
                m27205a(phoneFinderActivity.getString(R$string.learn_more_backup));
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.PhoneFinderActivity$m */
    public static class HandlerC4468m extends Handler {

        /* renamed from: a */
        public WeakReference<PhoneFinderActivity> f20504a;

        public HandlerC4468m(PhoneFinderActivity phoneFinderActivity) {
            this.f20504a = new WeakReference<>(phoneFinderActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
            super.handleMessage(message);
            PhoneFinderActivity phoneFinderActivity = this.f20504a.get();
            if (phoneFinderActivity == null) {
                return;
            }
            phoneFinderActivity.m27072a3(message);
        }
    }

    /* renamed from: M2 */
    private boolean m27058M2() {
        if (this.f20462k0 == null) {
            C13981a.m83987d("PhoneFinderActivity", "processExceptionView exceptionView is null");
            return false;
        }
        if (C0209d.m1333z1(this)) {
            this.f20462k0.m23914a();
            return false;
        }
        this.f20462k0.m23919i();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T2 */
    public void m27064T2() {
        if (this.f20454c0 != null) {
            C13981a.m83989i("PhoneFinderActivity", "PhoneFinderActivity begin to download map.");
            try {
                new C10474a(this, this.f20454c0, this.f20427B, this.f20456e0).m64367e();
                LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
                linkedHashMapM79497A.put("download_map_from", "from_phoneFinderactivity_card");
                C13230i.m79504I().m79567R("mecloud_findmyphone_download_map", linkedHashMapM79497A);
                UBAAnalyze.m29947H("CKC", "mecloud_findmyphone_download_map", linkedHashMapM79497A);
                Bundle bundle = new Bundle();
                bundle.putString("operationType", "mapCardLoad");
                bundle.putString(C5807k0.f25949l, "from_phoneFinderactivity_card");
                bundle.putString("errorReason", "PhoneFinderActivity downloadMapImg");
                C11881n.m71350M(bundle);
            } catch (Exception e10) {
                C13981a.m83988e("PhoneFinderActivity", "PhoneFinderActivity downloadMapImg Exception: " + e10.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a3 */
    public void m27072a3(Message message) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        C13981a.m83989i("PhoneFinderActivity", "handleMessage msg id=" + message.what);
        int i10 = message.what;
        if (i10 == 4007) {
            Object obj = message.obj;
            if (obj instanceof String) {
                m27144W2((String) obj);
                return;
            }
            return;
        }
        if (i10 == 4008) {
            m27155d3();
            return;
        }
        if (i10 == 4024) {
            m27148Y2(message.getData(), this.f20476x);
            return;
        }
        if (i10 == 5001) {
            m27140U2(message.obj);
        } else if (i10 != 5002) {
            m27150Z2(i10);
        } else {
            C13981a.m83988e("PhoneFinderActivity", "download image failed.");
        }
    }

    /* renamed from: b3 */
    private void m27074b3() {
        if (this.f20477y == null) {
            this.f20477y = new HiSyncReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_DEVICE_DEL");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_OPEN_AUTH_FAILE");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_CLOSE_AUTH_FAILE");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_COMPLETED");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_FAIL");
            intentFilter.addAction("com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_READDEVICELIST_SUCCESS");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_READDEVICELIST_FAIL");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_QUERY_ACTIVE_AUTH_FAILE");
            intentFilter.addAction("com.huawei.hidisk.remotecontrol.intent.location.share.state");
            C13108a.m78878b(this).m78880c(this.f20477y, intentFilter);
        }
    }

    /* renamed from: c3 */
    private void m27076c3() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        this.f20475w = new NewHiSyncUtil(this);
        m27168k3();
        mo19005p1();
    }

    /* renamed from: h3 */
    private void m27082h3() {
        C13981a.m83989i("PhoneFinderActivity", "init pad layout");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h4 */
    public void m27083h4() {
        try {
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", getString(R$string.hidisk_hwcloud_email_address_for_feedback), null));
            intent.putExtra("android.intent.extra.SUBJECT", "Subject");
            intent.putExtra("android.intent.extra.TEXT", "Body");
            startActivity(Intent.createChooser(intent, ""));
        } catch (Exception unused) {
            C13981a.m83988e("PhoneFinderActivity", "start email activity error");
        }
    }

    /* renamed from: q3 */
    private void m27092q3() {
        if (C0209d.m1226Y0()) {
            C13981a.m83989i("PhoneFinderActivity", "fastClick");
            return;
        }
        if (!C0209d.m1333z1(this)) {
            C13981a.m83988e("PhoneFinderActivity", "net is not connected");
            C11880m.m71337d(this, getString(R$string.cloudpay_net_disconnect_alert));
            return;
        }
        m27112E4();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uid", C13452e.m80781L().m80971t0());
        linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
        C13230i.m79504I().m79591l0("mecloud_findmyphone_click_jump_slave", linkedHashMap);
        UBAAnalyze.m29958S("PVP", "mecloud_findmyphone_click_jump_slave", "1", "19", linkedHashMap);
    }

    /* renamed from: v4 */
    private void m27098v4(DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialog = this.f20441P;
        if (alertDialog != null && alertDialog.isShowing()) {
            C13981a.m83989i("PhoneFinderActivity", "join circle dialog is showing");
            return;
        }
        if (!C1175a.m7389k(this.f20476x)) {
            C13981a.m83990w("PhoneFinderActivity", "phone finder closed, not show join circle dialog");
            return;
        }
        C13981a.m83989i("PhoneFinderActivity", "show join circle dialog");
        try {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(getString(R$string.text_offline_trust_dialog_title)).setMessage(getString(R$string.trust_circle_dialog_comtent)).setPositiveButton(getString(R$string.text_pf_offline_dialog_positive), onClickListener).setNegativeButton(getString(R$string.cancel), onClickListener).setOnCancelListener(onCancelListener).create();
            this.f20441P = alertDialogCreate;
            alertDialogCreate.setCanceledOnTouchOutside(false);
            this.f20441P.show();
            C11690w.m69700W("", "trustCircleOperation", "trustCircleBusiness", "showOpenOfflineLocateDialog show", "0", null);
        } catch (Exception e10) {
            C13981a.m83988e("PhoneFinderActivity", "showOpenExceptionDialog exception:" + e10.getMessage());
        }
    }

    /* renamed from: x3 */
    public static /* synthetic */ void m27101x3(DialogInterface dialogInterface) {
        C13981a.m83989i("PhoneFinderActivity", "cancel join circle");
        C11690w.m69700W("", "trustCircleOperation", "trustCircleBusiness", "openOfflineLocateSwitch cancel", "0", null);
    }

    /* renamed from: A3 */
    public final /* synthetic */ void m27104A3() throws Resources.NotFoundException {
        m27181r3(false);
    }

    /* renamed from: A4 */
    public final void m27105A4() {
        m27177o4(false);
        m27179p4(false);
        this.f20443R.setSwitchLoading(true);
    }

    /* renamed from: B3 */
    public final /* synthetic */ void m27106B3() throws Resources.NotFoundException {
        m27181r3(true);
    }

    /* renamed from: B4 */
    public final void m27107B4() {
        C13981a.m83989i("PhoneFinderActivity", "show supper privacy mode");
        AlertDialog alertDialog = this.f20442Q;
        if (alertDialog != null && alertDialog.isShowing()) {
            C13981a.m83989i("PhoneFinderActivity", "supper privacy dialog isShowing");
            return;
        }
        try {
            if (this.f20442Q == null) {
                this.f20442Q = new AlertDialog.Builder(this).setTitle(getString(R$string.supper_privacy_dialog_title)).setMessage(getString(R$string.supper_privacy_dialog_msg)).setPositiveButton(getString(R$string.supper_privacy_dialog_positive), new DialogInterface.OnClickListener() { // from class: gg.r
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                        this.f48680a.m27117H3(dialogInterface, i10);
                    }
                }).setNegativeButton(getString(R$string.supper_privacy_dialog_negitive), new DialogInterface.OnClickListener() { // from class: gg.s
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        this.f48681a.m27119I3(dialogInterface, i10);
                    }
                }).create();
            }
            this.f20442Q.show();
        } catch (Exception unused) {
            C13981a.m83988e("PhoneFinderActivity", "show supper privacy dialog exception");
        }
    }

    /* renamed from: C3 */
    public final /* synthetic */ void m27108C3(Boolean bool) {
        if (bool.booleanValue()) {
            C0226l0.m1584d(new Runnable() { // from class: gg.l
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    this.f48677a.m27106B3();
                }
            });
        } else {
            C13981a.m83990w("PhoneFinderActivity", "offline locate open fail");
        }
    }

    /* renamed from: C4 */
    public final void m27109C4(Intent intent) {
        AlertDialog alertDialog = this.f20470r0;
        if (alertDialog == null || !alertDialog.isShowing()) {
            SafeIntent safeIntent = new SafeIntent(intent);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(C11842p.m70762R0() ? R$string.phonefinder_dialog_title_open_fail_pad : R$string.phonefinder_dialog_title_open_fail_phone);
            boolean zHasExtra = safeIntent.hasExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE);
            int intExtra = zHasExtra ? safeIntent.getIntExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 0) : 0;
            if (intExtra == 996) {
                builder.setMessage(getString(R$string.phonefinder_dialog_title_open_content_update));
                builder.setPositiveButton(R$string.beta_ok, (DialogInterface.OnClickListener) null);
            } else if (intExtra == 3005) {
                builder.setMessage(getString(R$string.pf_activation_tip_assistance_dialog));
                builder.setPositiveButton(R$string.beta_ok, new DialogInterface.OnClickListener() { // from class: gg.q
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        dialogInterface.dismiss();
                    }
                });
            } else if (intExtra == 38) {
                builder.setMessage(getString(R$string.pf_activation_tip_assistance_dialog));
                builder.setPositiveButton(R$string.beta_ok, (DialogInterface.OnClickListener) null);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(getString(R$string.text_oobedisabledreason));
                if (zHasExtra) {
                    sb2.append("(");
                    sb2.append(intExtra);
                    sb2.append(")");
                }
                builder.setMessage(sb2.toString());
                builder.setPositiveButton(R$string.stepbutton_ooberetry, new DialogInterfaceOnClickListenerC4457b());
                builder.setNegativeButton(R$string.cloudbackup_btn_cancel, (DialogInterface.OnClickListener) null);
            }
            AlertDialog alertDialogCreate = builder.create();
            this.f20470r0 = alertDialogCreate;
            try {
                alertDialogCreate.show();
            } catch (Exception unused) {
                C13981a.m83988e("PhoneFinderActivity", "showTimeOutDialog bad window");
            }
        }
    }

    /* renamed from: D4 */
    public final void m27110D4() {
        if (!C0209d.m1293p1() && C13452e.m80781L().m80803F0().booleanValue()) {
            if (C0209d.m1333z1(this)) {
                this.f20454c0 = null;
                C13811a.m82802T(this, this);
            } else {
                C13981a.m83989i("PhoneFinderActivity", "network is not connected. Register the network listening.");
                C11867q.m71126d().m71127e(this, this);
            }
        }
    }

    /* renamed from: E3 */
    public final /* synthetic */ void m27111E3(DialogInterface dialogInterface, int i10) {
        m27178p3();
    }

    /* renamed from: E4 */
    public final void m27112E4() {
        C13981a.m83989i("PhoneFinderActivity", "jumpToWapFindPhone");
        C11868a.m71128d().m71130b(WapFindPhoneActivity.class);
        Intent intent = new Intent(this, (Class<?>) WapFindPhoneActivity.class);
        C0209d.m1302r2(intent, getPackageName());
        intent.putExtra("isFromInner", true);
        intent.putExtra(RemoteMessageConst.FROM, "fromPFClick");
        intent.putExtra("isEnableJs", true);
        intent.putExtra("isSystemAcc", true);
        intent.putExtra("needShowLoading", true);
        startActivity(intent);
    }

    /* renamed from: F2 */
    public final void m27113F2() {
        C4375j.m26412n(this.f20476x, new Consumer() { // from class: gg.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f48667a.m27187u3((Boolean) obj);
            }
        });
    }

    /* renamed from: G2 */
    public final void m27114G2() {
        if (C4375j.m26387A()) {
            if (!C0209d.m1285n1()) {
                C13981a.m83989i("PhoneFinderActivity", "not huawei device");
                return;
            }
            C11877j.m71265f1(this.f20476x, true);
            C11877j.m71211H0(this.f20476x, System.currentTimeMillis());
            m27113F2();
        }
    }

    /* renamed from: G3 */
    public final /* synthetic */ void m27115G3(DialogInterface dialogInterface, int i10) {
        C11829c.m70612r1(this);
    }

    /* renamed from: H2 */
    public final boolean m27116H2() {
        return C13612b.m81829B().m81886t(this);
    }

    /* renamed from: H3 */
    public final /* synthetic */ void m27117H3(DialogInterface dialogInterface, int i10) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("PhoneFinderActivity", "set supper privacy mode OFF");
        C11881n.m71349L();
        m27153b4();
    }

    /* renamed from: I2 */
    public final void m27118I2() {
        C13981a.m83989i("PhoneFinderActivity", "choose goto activity");
        Intent intent = new Intent();
        String stringExtra = new HiCloudSafeIntent(getIntent()).getStringExtra(RemoteMessageConst.FROM);
        String packageName = getPackageName();
        if ("from_smart_suggest".equals(stringExtra)) {
            C0209d.m1302r2(intent, packageName);
            intent.setAction("com.huawei.android.intent.action.settings.HICLOUD_ENTTRANCE");
            startActivity(intent);
        } else {
            intent.setComponent(new ComponentName(packageName, "com.huawei.android.remotecontrol.ui.PhoneFinderTipsActivity"));
            intent.putExtra(RemoteMessageConst.FROM, this.f20438M);
            C13230i.m79525e1(intent, this.f16165h, this.f20455d0);
            startActivity(intent);
            this.f20459h0 = false;
        }
    }

    /* renamed from: I3 */
    public final /* synthetic */ void m27119I3(DialogInterface dialogInterface, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("PhoneFinderActivity", "finish");
        finish();
    }

    /* renamed from: J2 */
    public final void m27120J2() {
        AlertDialog alertDialog = this.f20441P;
        if (alertDialog == null) {
            return;
        }
        alertDialog.dismiss();
        this.f20441P = null;
    }

    /* renamed from: K2 */
    public final void m27121K2() {
        m27177o4(false);
        Bundle bundle = new Bundle();
        bundle.putInt("loginChannel", 15000000);
        bundle.putString("accountType", AbstractC12139d.m72766e(this.f20476x).getAccountType());
        String userID4RC = AbstractC12139d.m72766e(this.f20476x).getUserID4RC();
        if (userID4RC == null || userID4RC.isEmpty()) {
            C13981a.m83988e("PhoneFinderActivity", "user ID is empty");
        } else {
            C13195l.m79272J().m79326p(this, 8909, C13452e.m80781L().m80799E0(), "", new C9916a(this.f20456e0, getApplicationContext()));
        }
    }

    /* renamed from: K3 */
    public final void m27122K3() {
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (!this.f20467p0 || !C1175a.m7390l(this, strM80971t0)) {
            m27125M3(false);
            return;
        }
        ScaleRoundRectImageView scaleRoundRectImageView = this.f20427B;
        if (scaleRoundRectImageView == null || scaleRoundRectImageView.getDrawable() == null) {
            m27125M3(true);
        } else {
            m27127N3();
        }
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            C12515a.m75110o().m75172d(new C4461f());
        } else {
            C13981a.m83989i("PhoneFinderActivity", "overseas account need not load map image.");
        }
    }

    /* renamed from: L2 */
    public final void m27123L2(boolean z10) {
        m27173m4(z10);
        m27137S2(z10);
        m27166j3(z10);
        this.f20443R.setSwitchLoading(false);
        if (!z10) {
            m27179p4(false);
            return;
        }
        m27179p4(true);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f20452a0, "translationY", 0.0f, 35.0f, 0.0f, -30.0f);
        objectAnimatorOfFloat.setDuration(200L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f20452a0, "translationY", -30.0f, 0.0f);
        objectAnimatorOfFloat2.setInterpolator(new BounceInterpolator());
        objectAnimatorOfFloat2.setDuration(500L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfFloat2).after(objectAnimatorOfFloat);
        animatorSet.start();
    }

    /* renamed from: L3 */
    public final void m27124L3(int i10) {
        C13981a.m83989i("PhoneFinderActivity", "loginToPhonefinder with check type");
        if (!C13195l.m79272J().m79306V(C13452e.m80781L().m80905e())) {
            m27194y4(i10);
            return;
        }
        C13981a.m83989i("PhoneFinderActivity", "FAIL_BY_THIRD_ACCOUNT");
        C11880m.m71336c(getApplicationContext(), R$string.third_account_notice);
        m27173m4(false);
    }

    /* renamed from: M3 */
    public final void m27125M3(boolean z10) {
        this.f20427B.setVisibility(8);
        this.f20428C.setVisibility(0);
        this.f20429D.setVisibility(0);
        if (z10) {
            m27167j4();
        } else {
            this.f20429D.setImageDrawable(getDrawable(R$drawable.locate_close_icon));
        }
    }

    /* renamed from: N2 */
    public final void m27126N2() {
        C13981a.m83987d("PhoneFinderActivity", "ACTION_PHONEFINDER_RESULT= true");
        if (C13171a.m79199e()) {
            HandlerC4468m handlerC4468m = this.f20456e0;
            if (handlerC4468m != null) {
                handlerC4468m.sendEmptyMessage(AccountConstant.Err.SMS_SERVICE_FAILED_SESSION_TIME_OUT);
                return;
            }
            return;
        }
        HandlerC4468m handlerC4468m2 = this.f20456e0;
        if (handlerC4468m2 != null) {
            handlerC4468m2.sendEmptyMessage(4017);
        }
    }

    /* renamed from: N3 */
    public final void m27127N3() {
        this.f20427B.setVisibility(0);
        this.f20428C.setVisibility(8);
        this.f20429D.setVisibility(8);
    }

    /* renamed from: O1 */
    public final void m27128O1(Context context, Intent intent) {
        C13981a.m83987d("PhoneFinderActivity", "onReceiveLogoffSucess received");
        m27173m4(false);
        m27169k4(false);
        ListItemPatterm listItemPatterm = this.f20445T;
        if (listItemPatterm != null) {
            listItemPatterm.setListState(false);
        }
        m27179p4(false);
        m27156d4();
        m27123L2(false);
        m27120J2();
        C12515a.m75110o().m75172d(new C9476e(context, false));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
        C13230i.m79504I().m79590k0("mecloud_findmyphone_click_switch", "2", "2", C13452e.m80781L().m80971t0(), linkedHashMap);
        UBAAnalyze.m29979g0("PVP", "mecloud_findmyphone_click_switch", "1", "19", "2", "2", linkedHashMap);
    }

    /* renamed from: O2 */
    public final void m27129O2() {
        AlertDialog alertDialog = this.f20440O;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f20440O = null;
        }
    }

    /* renamed from: O3 */
    public final void m27130O3(boolean z10) {
        C13981a.m83989i("PhoneFinderActivity", "click last position switch");
        if (!this.f20444S.isEnabled()) {
            C13981a.m83989i("PhoneFinderActivity", "mLastPositionPattern not enable");
            return;
        }
        m27137S2(z10);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
        if (z10) {
            C13230i.m79504I().m79590k0("mecloud_findmyphone_click_last_position", "1", "1", C13452e.m80781L().m80971t0(), linkedHashMap);
            UBAAnalyze.m29979g0("PVP", "mecloud_findmyphone_click_last_position", "1", "19", "1", "1", linkedHashMap);
        } else {
            C13230i.m79504I().m79590k0("mecloud_findmyphone_click_last_position", "2", "2", C13452e.m80781L().m80971t0(), linkedHashMap);
            UBAAnalyze.m29979g0("PVP", "mecloud_findmyphone_click_last_position", "1", "19", "2", "2", linkedHashMap);
        }
    }

    /* renamed from: P2 */
    public final void m27131P2() {
        AlertDialog alertDialog = this.f20442Q;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f20442Q = null;
        }
    }

    /* renamed from: P3 */
    public final void m27132P3(boolean z10) throws JSONException {
        C13981a.m83989i("PhoneFinderActivity", "onPhoneFinderSwitch");
        if (!this.f20443R.isEnabled()) {
            C13981a.m83989i("PhoneFinderActivity", "mPhoneFinderPattern not enable");
        } else if (!z10) {
            m27121K2();
        } else {
            m27151Z3();
            m27162g4();
        }
    }

    /* renamed from: Q2 */
    public final void m27133Q2(int i10, int i11, Intent intent) {
        if (i10 == this.f20433H) {
            C13230i.m79504I().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", "PhoneFinderActivity", "isLock:" + C0209d.m1301r1(this));
        }
    }

    /* renamed from: Q3 */
    public final void m27134Q3(Context context, Intent intent) {
        C13981a.m83988e("PhoneFinderActivity", "onReceive close auth fail");
        this.f20457f0 = new C4464i(this, false);
        C13612b.m81829B().m81856U(this, this.f20457f0);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
        C13230i.m79504I().m79590k0("mecloud_findmyphone_click_switch", "2", "1", C13452e.m80781L().m80971t0(), linkedHashMap);
        UBAAnalyze.m29979g0("PVP", "mecloud_findmyphone_click_switch", "1", "19", "2", "1", linkedHashMap);
    }

    /* renamed from: R2 */
    public final void m27135R2(Context context, Intent intent, String str) throws IllegalAccessException, IllegalArgumentException {
        if ("com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT".equals(str)) {
            m27141U3(context, intent);
            return;
        }
        if ("com.huawei.android.hicloud.intent.PHONEFINDER_DEVICE_DEL".equals(str)) {
            m27136R3(context, intent);
            return;
        }
        if ("com.huawei.android.hicloud.intent.PHONEFINDER_OPEN_AUTH_FAILE".equals(str)) {
            m27139T3(context, intent);
            return;
        }
        if ("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_COMPLETED".equals(str)) {
            m27128O1(context, intent);
            return;
        }
        if ("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_FAIL".equals(str)) {
            m27138S3(context, intent);
            return;
        }
        if ("com.huawei.android.hicloud.intent.PHONEFINDER_CLOSE_AUTH_FAILE".equals(str)) {
            m27134Q3(context, intent);
        } else if ("com.huawei.android.hicloud.intent.PHONEFINDER_QUERY_ACTIVE_AUTH_FAILE".equals(str)) {
            m27143V3(context, intent);
        } else if ("com.huawei.hidisk.remotecontrol.intent.location.share.state".equals(str)) {
            m27145W3(intent);
        }
    }

    /* renamed from: R3 */
    public final void m27136R3(Context context, Intent intent) {
        C13981a.m83987d("PhoneFinderActivity", "onReceiveDevicedel");
        m27173m4(false);
        m27137S2(false);
        m27166j3(false);
        C4375j.m26396J(context, false, null);
    }

    /* renamed from: S2 */
    public final void m27137S2(boolean z10) {
        C13981a.m83987d("PhoneFinderActivity", "doWithLastLocCheckedChange");
        m27169k4(z10);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent("com.huawei.android.remotecontrol.PHONEFINDER_LASTLOCATION_SWITCHER"));
        hiCloudSafeIntent.putExtra("phonefinder_lastlocation_switcher_result", z10);
        C13108a.m78878b(this.f20476x).m78881d(hiCloudSafeIntent);
        C11877j.m71243X0(this, Boolean.valueOf(z10));
    }

    /* renamed from: S3 */
    public final void m27138S3(Context context, Intent intent) {
        if (intent == null) {
            C13981a.m83988e("PhoneFinderActivity", "onReceiveLogofffail  intent is null");
            return;
        }
        C13981a.m83988e("PhoneFinderActivity", "onReceiveLogofffail received");
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        boolean booleanExtra = hiCloudSafeIntent.getBooleanExtra("islocal", false);
        this.f20467p0 = true;
        m27173m4(true);
        m27177o4(true);
        m27179p4(true);
        m27156d4();
        if (booleanExtra) {
            C11880m.m71336c(getApplicationContext(), R$string.activate_error_timeout_please_retry);
        }
        int intExtra = hiCloudSafeIntent.getIntExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, -1);
        m27182r4(intExtra);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
        linkedHashMap.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, String.valueOf(intExtra));
        C13230i.m79504I().m79590k0("mecloud_findmyphone_click_switch", "2", "1", C13452e.m80781L().m80971t0(), linkedHashMap);
        UBAAnalyze.m29979g0("PVP", "mecloud_findmyphone_click_switch", "1", "19", "2", "1", linkedHashMap);
    }

    /* renamed from: T3 */
    public final void m27139T3(Context context, Intent intent) {
        C13981a.m83988e("PhoneFinderActivity", "onReceiveOpenAuthfail");
        C11877j.m71263f(context);
        m27173m4(false);
        m27156d4();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
        C13230i.m79504I().m79590k0("mecloud_findmyphone_click_switch", "1", "2", C13452e.m80781L().m80971t0(), linkedHashMap);
        UBAAnalyze.m29979g0("PVP", "mecloud_findmyphone_click_switch", "1", "19", "1", "2", linkedHashMap);
    }

    /* renamed from: U2 */
    public final void m27140U2(Object obj) {
        if (obj == null) {
            C13981a.m83989i("PhoneFinderActivity", "handle download success message, result is null");
            return;
        }
        if (obj instanceof C11828b.b) {
            if (((C11828b.b) obj).f54752c == null) {
                C13981a.m83989i("PhoneFinderActivity", "handle download success message, result bitmap is null");
            } else {
                C13981a.m83989i("PhoneFinderActivity", "handle download success message, begin to loadMapImg");
                m27122K3();
            }
        }
    }

    /* renamed from: U3 */
    public final void m27141U3(Context context, Intent intent) throws IllegalAccessException, IllegalArgumentException {
        C13981a.m83989i("PhoneFinderActivity", "onReceiveOpenFinder");
        if (intent == null) {
            return;
        }
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        if (hiCloudSafeIntent.getBooleanExtra("phonefinder_result", false)) {
            m27123L2(true);
            m27156d4();
            m27186t4();
            this.f20436K = true;
            C11877j.m71250a1(this.f20476x, Boolean.TRUE);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
            C13230i.m79504I().m79590k0("mecloud_findmyphone_click_switch", "1", "1", C13452e.m80781L().m80971t0(), linkedHashMap);
            UBAAnalyze.m29979g0("PVP", "mecloud_findmyphone_click_switch", "1", "19", "1", "1", linkedHashMap);
            this.f20467p0 = true;
            m27110D4();
            return;
        }
        m27123L2(false);
        m27156d4();
        C13981a.m83989i("PhoneFinderActivity", "ACTION_PHONEFINDER_RESULT= false");
        m27173m4(false);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("gradeCode", C13452e.m80781L().m80790C());
        C13230i.m79504I().m79590k0("mecloud_findmyphone_click_switch", "1", "2", C13452e.m80781L().m80971t0(), linkedHashMap2);
        UBAAnalyze.m29979g0("PVP", "mecloud_findmyphone_click_switch", "1", "19", "1", "2", linkedHashMap2);
        boolean booleanExtra = hiCloudSafeIntent.getBooleanExtra("socId_has_register", false);
        boolean booleanExtra2 = hiCloudSafeIntent.getBooleanExtra("lock_oversea_repeat", false);
        if (!booleanExtra && !booleanExtra2) {
            if (46 == hiCloudSafeIntent.getIntExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 0)) {
                C13981a.m83989i("PhoneFinderActivity", "not show error dialog");
                return;
            } else {
                m27109C4(hiCloudSafeIntent);
                return;
            }
        }
        C13981a.m83989i("PhoneFinderActivity", "start activation activity");
        C11877j.m71235T0(this.f20476x, Boolean.TRUE);
        Intent intent2 = new Intent();
        intent2.setComponent(new ComponentName(this, (Class<?>) ActivationNormalActivity.class));
        startActivity(intent2);
        if (booleanExtra && !C1175a.m7389k(C0213f.m1377a()) && C1175a.m7385g(true)) {
            C13981a.m83989i("PhoneFinderActivity", "v1 show error dialog");
            m27109C4(hiCloudSafeIntent);
        }
    }

    /* renamed from: V2 */
    public void m27142V2() {
        C13981a.m83989i("PhoneFinderActivity", "exitAPP");
        C13019a.m78347n().m78354q(this);
        new Handler().postDelayed(new Runnable() { // from class: gg.p
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.f48679a.m27189v3();
            }
        }, 200L);
        C13019a.m78347n().m78355r();
    }

    /* renamed from: V3 */
    public final void m27143V3(Context context, Intent intent) {
        C13981a.m83989i("PhoneFinderActivity", "onReceiveQueryActiveAuthfail");
        if (this.f20453b0) {
            this.f20453b0 = false;
            C13612b.m81829B().m81864e0(this.f20476x);
        }
    }

    /* renamed from: W2 */
    public final void m27144W2(String str) {
        if (isFinishing()) {
            C13981a.m83988e("PhoneFinderActivity", "exitPhoneFinder is finishing");
            return;
        }
        C11860j.m71037a1(1);
        C11860j.m71030X0(1);
        m27156d4();
        C11860j.m71018R0(this.f20476x, true, str);
        m27105A4();
        Timer timer = new Timer();
        this.f20431F = timer;
        timer.schedule(new C10497b(this.f20456e0), 38000L);
    }

    /* renamed from: W3 */
    public final void m27145W3(Intent intent) {
        if (intent == null) {
            return;
        }
        boolean booleanExtra = new SafeIntent(intent).getBooleanExtra(MapKeyNames.RESULT_CODE, false);
        C13981a.m83989i("PhoneFinderActivity", "onReceiverShareLocateState result" + booleanExtra);
        ListItemPatterm listItemPatterm = this.f20445T;
        if (listItemPatterm != null) {
            listItemPatterm.setListState(booleanExtra);
        }
    }

    /* renamed from: X2 */
    public final C4465j m27146X2(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        int totalPaddingLeft = x10 - textView.getTotalPaddingLeft();
        int totalPaddingTop = y10 - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        C4465j[] c4465jArr = (C4465j[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, C4465j.class);
        if (c4465jArr.length > 0) {
            return c4465jArr[0];
        }
        return null;
    }

    /* renamed from: X3 */
    public final void m27147X3(int i10, Intent intent) {
        if (-1 == i10) {
            this.f20456e0.obtainMessage(4007).sendToTarget();
        } else {
            this.f20456e0.obtainMessage(4008).sendToTarget();
        }
    }

    /* renamed from: Y2 */
    public final void m27148Y2(Bundle bundle, Activity activity) {
        if (bundle == null) {
            C13981a.m83988e("PhoneFinderActivity", "handleJumpToInstructions data is null");
            return;
        }
        String string = bundle.getString("title");
        String string2 = bundle.getString("url");
        if (TextUtils.isEmpty(string2)) {
            C13981a.m83988e("PhoneFinderActivity", "handleJumpToInstructions host is empty set default");
            string2 = "";
        }
        C11829c.m70550V0(activity, string2, string, true);
    }

    /* renamed from: Y3 */
    public final void m27149Y3() {
        C13981a.m83989i("PhoneFinderActivity", "openOfflineLocateSwitch");
        C4375j.m26414p(this.f20476x, false, new Consumer() { // from class: gg.e
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f48671a.m27195z3((TrustCircleInfo) obj);
            }
        });
    }

    /* renamed from: Z2 */
    public final void m27150Z2(int i10) {
        switch (i10) {
            case AccountConstant.Err.SMS_SERVICE_FAILED_SESSION_TIME_OUT /* 4016 */:
            case 4017:
                m27156d4();
                m27173m4(true);
                m27177o4(true);
                if (!C11881n.m71339B(this.f20476x)) {
                    m27196z4();
                    break;
                } else {
                    m27114G2();
                    break;
                }
            case AccountConstant.Err.SMS_SERVICE_SIGNATURE_EXPIRED /* 4018 */:
                m27156d4();
                m27123L2(true);
                m27109C4(null);
                break;
            case 4021:
                HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent("com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT"));
                hiCloudSafeIntent.putExtra("phonefinder_result", false);
                hiCloudSafeIntent.putExtra("islocal", true);
                C13108a.m78878b(this.f20476x).m78881d(hiCloudSafeIntent);
                m27156d4();
                m27173m4(false);
                break;
            case 4022:
                HiCloudSafeIntent hiCloudSafeIntent2 = new HiCloudSafeIntent(new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_FAIL"));
                hiCloudSafeIntent2.putExtra("islocal", true);
                C13108a.m78878b(this.f20476x).m78881d(hiCloudSafeIntent2);
                m27156d4();
                m27173m4(true);
                m27169k4(true);
                m27179p4(true);
                break;
            case 4023:
                m27113F2();
                break;
        }
    }

    /* renamed from: Z3 */
    public final void m27151Z3() {
        C13981a.m83989i("PhoneFinderActivity", "openPhoneFinderSwitch");
        m27129O2();
        m27177o4(false);
        if (C13452e.m80781L().m80842P0() && !C13195l.m79272J().m79306V(C13452e.m80781L().m80905e())) {
            m27124L3(3);
        } else {
            this.f20457f0 = new C4464i(this, true);
            C13612b.m81829B().m81856U(this, this.f20457f0);
        }
    }

    /* renamed from: a4 */
    public final void m27152a4(TrustCircleInfo trustCircleInfo) {
        if (!trustCircleInfo.isJoinTrustCircle()) {
            C13981a.m83990w("PhoneFinderActivity", "join circle fail");
        } else {
            C4375j.m26419u(this.f20476x.getApplicationContext(), String.valueOf(trustCircleInfo.getMkVersion()), new Consumer() { // from class: gg.h
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f48674a.m27108C3((Boolean) obj);
                }
            });
        }
    }

    /* renamed from: b4 */
    public final void m27153b4() {
        m27154c4();
        this.f20454c0 = null;
        m27122K3();
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (this.f20467p0 && C1175a.m7390l(this, strM80971t0)) {
            m27110D4();
        }
    }

    /* renamed from: c4 */
    public final void m27154c4() {
        C13981a.m83989i("PhoneFinderActivity", "queryActiveState:" + this.f20432G + ";" + this.f20434I);
        if (this.f20432G || !this.f20434I) {
            return;
        }
        if (!C0209d.m1333z1(this)) {
            C13981a.m83989i("PhoneFinderActivity", "network disconnect, do query delay");
            return;
        }
        C11866p.m71115n(false, AbstractC12139d.m72766e(this.f20476x).getSiteID(), 2).m75045o();
        if (!this.f20436K) {
            m27114G2();
        }
        this.f20432G = true;
        this.f20453b0 = true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f20469r);
        arrayList.add(this.f20473u);
        arrayList.add(this.f20474v);
        return arrayList;
    }

    /* renamed from: d3 */
    public final void m27155d3() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (C0209d.m1166E1()) {
            m27163i3();
        } else {
            m27157e3();
        }
    }

    /* renamed from: d4 */
    public final void m27156d4() {
        ListItemPatterm listItemPatterm = this.f20443R;
        if (listItemPatterm != null) {
            listItemPatterm.setSwitchLoading(false);
        }
        Timer timer = this.f20431F;
        if (timer != null) {
            timer.cancel();
            this.f20431F = null;
        }
    }

    /* renamed from: e3 */
    public final void m27157e3() {
        this.f20443R.setVisibility(8);
        this.f20444S.setVisibility(8);
        this.f20445T.setVisibility(8);
    }

    /* renamed from: e4 */
    public final void m27158e4() {
        NewHiSyncUtil newHiSyncUtil = this.f20475w;
        if (newHiSyncUtil != null) {
            newHiSyncUtil.m27970a();
            this.f20475w = null;
        }
        AlertDialog alertDialog = this.f20470r0;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f20470r0 = null;
        }
        AlertDialog alertDialog2 = this.f20440O;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
            this.f20440O = null;
        }
        AlertDialog alertDialog3 = this.f20464m0;
        if (alertDialog3 != null) {
            alertDialog3.dismiss();
            this.f20464m0 = null;
        }
        TipLinearLayout tipLinearLayout = this.f20460i0;
        if (tipLinearLayout != null) {
            tipLinearLayout.dismissAllPopWindow();
        }
        m27120J2();
        if (this.f20477y != null) {
            C13108a.m78878b(this).m78883f(this.f20477y);
        }
        m27156d4();
        C10496a.m64585a(this.f20476x);
        m27131P2();
    }

    /* renamed from: f3 */
    public final void m27159f3(Intent intent) throws JSONException {
        if (intent != null) {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            if (hiCloudSafeIntent.getAction() == null) {
                C13981a.m83990w("PhoneFinderActivity", "initIntentExtra action is null");
            }
            try {
                this.f20438M = hiCloudSafeIntent.getStringExtra(RemoteMessageConst.FROM);
            } catch (RuntimeException unused) {
                C13981a.m83989i("PhoneFinderActivity", "intent Serializable error.");
            }
            if (this.f20438M == null) {
                this.f20438M = "com.android.settings";
            }
            if (hiCloudSafeIntent.getBooleanExtra("is_from_cloud_notification", false)) {
                this.f20439N = "ENTRY_FROM_PHONE_FINDER_SWITCH_NOTIFY";
                m27160f4("19");
                return;
            }
            if ("com.huawei.hwid".equals(this.f20438M)) {
                this.f20439N = "ENTRY_FROM_ACCOUNT_CENTER";
                m27160f4("1");
                return;
            }
            if ("com.huawei.hidisk".equals(this.f20438M)) {
                this.f20439N = "ENTRY_FROM_MAIN";
                m27160f4("2");
            } else if ("com.android.settings".equals(this.f20438M)) {
                this.f20439N = "ENTRY_FROM_SETTING";
                m27160f4("4");
            } else if ("com.huawei.systemmanager".equals(this.f20438M)) {
                this.f20439N = "ENTRY_FROM_PHONE_MANAGER";
                m27160f4("6");
            } else {
                this.f20439N = "ENTRY_FROM_OTHERS";
                m27160f4("100");
            }
        }
    }

    /* renamed from: f4 */
    public final void m27160f4(String str) throws JSONException {
        JSONObject jSONObjectM79464f = C13222a.m79464f(this, "PHONE_FINDER_ACTICITY_SHOW", "1", C13452e.m80781L().m80971t0(), C13222a.m79465g(this));
        try {
            jSONObjectM79464f.put("entrySource", this.f20439N);
            jSONObjectM79464f.put("deviceID", C13452e.m80781L().m80954p());
            jSONObjectM79464f.put("gradeCode", C13452e.m80781L().m80790C());
        } catch (JSONException e10) {
            C13981a.m83988e("PhoneFinderActivity", "ERROR OCCUR:" + e10.getMessage());
        }
        C13222a.m79461c(this, jSONObjectM79464f);
        UBAAnalyze.m29963X("PVP", "PHONE_FINDER_ACTICITY_SHOW", "1", str, jSONObjectM79464f);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void finish() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.finish();
        new HwAnimationReflection(this).m15927c(2);
    }

    /* renamed from: g3 */
    public final View m27161g3() {
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.phone_finder_login, (ViewGroup) null);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(viewInflate, R$id.sendlastpositions);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.find_myphone);
        if (7 == C13452e.m80781L().m80947n0()) {
            textView.setText(getString(R$string.pf_tips_location_auto_sent_update));
        }
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        C13981a.m83989i("PhoneFinderActivity", "showLoginSuccessDialog isCloudbuakupSwitchOpen:" + zM62388s);
        if (zM62388s || !C10028c.m62182c0().m62395t1("funcfg_cloud_backup")) {
            relativeLayout.setVisibility(8);
        } else {
            relativeLayout.setVisibility(0);
        }
        return viewInflate;
    }

    /* renamed from: g4 */
    public final void m27162g4() throws JSONException {
        JSONObject jSONObjectM79464f = C13222a.m79464f(this, "CLOUDBACKUP_CLICK_FINDMYPHONE_SWTICH_ON", "1", C13452e.m80781L().m80971t0(), C13222a.m79465g(this));
        try {
            jSONObjectM79464f.put("entrySource", this.f20439N);
            jSONObjectM79464f.put("deviceID", C13452e.m80781L().m80954p());
            jSONObjectM79464f.put("gradeCode", C13452e.m80781L().m80790C());
        } catch (JSONException e10) {
            C13981a.m83988e("PhoneFinderActivity", "ERROR OCCUR:" + e10.getMessage());
        }
        C13222a.m79461c(this, jSONObjectM79464f);
        UBAAnalyze.m29963X("PVP", "CLOUDBACKUP_CLICK_FINDMYPHONE_SWTICH_ON", "1", "19", jSONObjectM79464f);
    }

    /* renamed from: i3 */
    public final void m27163i3() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (C0224k0.m1532B(this)) {
            boolean zM7390l = C1175a.m7390l(this, C13452e.m80781L().m80971t0());
            this.f20434I = zM7390l;
            if (zM7390l) {
                m27173m4(true);
                m27177o4(true);
            } else {
                m27173m4(false);
            }
            if (this.f20434I && C4375j.m26422x(this)) {
                m27181r3(C4375j.m26424z(this));
            }
            boolean zM71202D = C11877j.m71202D(this);
            this.f20435J = zM71202D;
            m27169k4(!((zM71202D && this.f20434I) ? false : true));
            m27166j3(this.f20434I);
            boolean zM71234T = C11877j.m71234T(this);
            this.f20436K = zM71234T;
            if (this.f20434I && zM71234T) {
                m27186t4();
                this.f20426A = true;
            }
        }
    }

    /* renamed from: i4 */
    public final void m27164i4(CompoundButton compoundButton) {
        if (compoundButton == null) {
            C13981a.m83988e("PhoneFinderActivity", "view is null");
            return;
        }
        TextView textView = (TextView) C12809f.m76831d(this.f20461j0, R$id.cloudbackupopen);
        TextView textView2 = (TextView) C12809f.m76831d(this.f20461j0, R$id.cloudbackuptip);
        if (textView == null || textView2 == null) {
            C13981a.m83988e("PhoneFinderActivity", "view is null");
        } else {
            compoundButton.setOnCheckedChangeListener(new C4463h(textView, textView2));
        }
    }

    @Override // java.util.function.Consumer
    /* renamed from: j2, reason: merged with bridge method [inline-methods] */
    public void accept(Location location) {
        if (!this.f20467p0) {
            C13981a.m83989i("PhoneFinderActivity", "accept but phoneFinder closed");
        } else {
            C13981a.m83989i("PhoneFinderActivity", "map locate callback.");
            C12515a.m75110o().m75172d(new C4462g(location));
        }
    }

    /* renamed from: j3 */
    public final void m27166j3(boolean z10) {
        boolean z11 = false;
        if (!C14306d.m85207h()) {
            this.f20445T.setVisibility(8);
            this.f20444S.setDiliverBottomVisible(false);
            return;
        }
        boolean zM71267g0 = C11877j.m71267g0(this);
        ListItemPatterm listItemPatterm = this.f20445T;
        if (z10 && zM71267g0) {
            z11 = true;
        }
        listItemPatterm.setListState(z11);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
        C13230i.m79504I().m79590k0("mecloud_findmyphone_show_location_share", "", "1", C13452e.m80781L().m80971t0(), linkedHashMap);
        UBAAnalyze.m29979g0("PVP", "mecloud_findmyphone_show_location_share", "1", "19", "", "1", linkedHashMap);
    }

    /* renamed from: j4 */
    public final void m27167j4() {
        if (C0209d.m1293p1()) {
            this.f20429D.setImageDrawable(getDrawable(R$drawable.pf_pad_ink));
        } else if (C0209d.m1333z1(this)) {
            this.f20429D.setImageDrawable(getDrawable(C11842p.m70762R0() ? R$drawable.pf_pad_online : R$drawable.pf_phone_online));
        } else {
            this.f20429D.setImageDrawable(getDrawable(C11842p.m70762R0() ? R$drawable.pf_pad_offline : R$drawable.pf_phone_offline));
        }
    }

    /* renamed from: k3 */
    public void m27168k3() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        ScaleRoundRectImageView scaleRoundRectImageView;
        ScaleRoundRectImageView scaleRoundRectImageView2;
        ActionBar actionBar = this.f20478z;
        if (actionBar != null) {
            actionBar.show();
        }
        this.f20471s = (ScrollView) C12809f.m76829b(this, R$id.pf_main_scrollview);
        this.f20469r = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f20473u = C12809f.m76829b(this, R$id.query_failed_frame);
        this.f20474v = C12809f.m76829b(this, R$id.mainregion);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.query_failed_email);
        this.f20472t = textView;
        textView.setOnClickListener(this);
        this.f20462k0 = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        ListItemPatterm listItemPatterm = (ListItemPatterm) C12809f.m76829b(this, R$id.pf_patterm_open);
        this.f20443R = listItemPatterm;
        listItemPatterm.setListMainTextFocusable();
        ListItemPatterm listItemPatterm2 = (ListItemPatterm) C12809f.m76829b(this, R$id.pf_patterm_lastposition);
        this.f20444S = listItemPatterm2;
        listItemPatterm2.setListMainTextFocusable();
        ListItemPatterm listItemPatterm3 = (ListItemPatterm) C12809f.m76829b(this, R$id.pf_pattern_share_location);
        this.f20445T = listItemPatterm3;
        listItemPatterm3.setOnClickListener(this);
        TipLinearLayout tipLinearLayout = (TipLinearLayout) C12809f.m76829b(this, R$id.ph_tip_content);
        this.f20460i0 = tipLinearLayout;
        tipLinearLayout.setClickListener(this);
        this.f20429D = (ImageView) C12809f.m76829b(this, R$id.locate_close_view);
        this.f20427B = (ScaleRoundRectImageView) C12809f.m76829b(this, R$id.map_img_view);
        ScaleRoundRectImageView scaleRoundRectImageView3 = (ScaleRoundRectImageView) C12809f.m76829b(this, R$id.map_bg_view);
        this.f20428C = scaleRoundRectImageView3;
        scaleRoundRectImageView3.setOnClickListener(this);
        this.f20430E = (AutoSizeButton) C12809f.m76829b(this, R$id.show_devices_btn);
        this.f20427B.setOnClickListener(this);
        this.f20430E.setOnClickListener(this);
        TopAnimatorView topAnimatorView = (TopAnimatorView) C12809f.m76829b(this, R$id.pf_top_animator_view);
        this.f20446U = topAnimatorView;
        topAnimatorView.setVisibility(8);
        this.f20450Y = (TextView) C12809f.m76829b(this, R$id.pf_explain);
        this.f20451Z = (TextView) C12809f.m76829b(this, R$id.pf_how_to_use_link);
        this.f20450Y.setOnClickListener(this);
        this.f20451Z.setOnClickListener(this);
        this.f20452a0 = (TextView) C12809f.m76829b(this, R$id.pf_tip_text_view);
        this.f20449X = (TextView) C12809f.m76829b(this, R$id.pf_text_switch_tip);
        this.f20452a0.setOnClickListener(this);
        this.f20447V = (LinearLayout) C12809f.m76829b(this, R$id.fit_column_center_divider);
        this.f20448W = (LinearLayout) C12809f.m76829b(this, R$id.fit_column_under_divider_background);
        if (C0209d.m1293p1() && (scaleRoundRectImageView2 = this.f20428C) != null && this.f20447V != null && this.f20448W != null) {
            scaleRoundRectImageView2.setBackground(getDrawable(R$drawable.item_map_bg_ink));
            this.f20447V.setBackground(getDrawable(R$drawable.item_single_bg_ink));
            this.f20448W.setBackground(getDrawable(R$drawable.ph_bottom_bg_ink));
        }
        if (!C0209d.m1293p1() && (scaleRoundRectImageView = this.f20428C) != null) {
            scaleRoundRectImageView.setImageResource(R$drawable.map_bg_new);
        }
        m27170l3();
        if (C11842p.m70771U0() || C11842p.m70735I0()) {
            m27082h3();
            this.f20427B.setCornerRadius(C11842p.m70840n(this, 14));
        }
        WindowManager windowManager = getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        C13981a.m83987d("PhoneFinderActivity", "screen height = " + displayMetrics.heightPixels + "  screen width = " + displayMetrics.widthPixels);
        int iM70725F = C11842p.m70725F(displayMetrics, this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, (int) (((double) iM70725F) * 0.1d), 0, 0);
        this.f20473u.setLayoutParams(layoutParams);
        m27155d3();
        if (C0209d.m1166E1()) {
            if (C13452e.m80781L().m80842P0() && !C10028c.m62183d0(getApplicationContext()).m62395t1("funcfg_find_my_phone_globe")) {
                if (C0219i.m1467e()) {
                    m27184s4(2);
                } else {
                    m27184s4(1);
                }
            }
            if (C0209d.m1293p1()) {
                C13981a.m83989i("PhoneFinderActivity", "isInkScreen");
                C12809f.m76843p(this.f20430E, false);
            }
        }
    }

    /* renamed from: k4 */
    public void m27169k4(boolean z10) {
        this.f20444S.setCheckedProgrammatically(z10);
    }

    /* renamed from: l3 */
    public final void m27170l3() {
        if (C0209d.m1166E1()) {
            this.f20443R.setText(getResources().getString(C11842p.m70762R0() ? R$string.phone_findback_title_20160528_pad : R$string.phone_findback_title_20160528));
        }
    }

    /* renamed from: l4 */
    public final void m27171l4(int i10) {
        if (i10 != 1) {
            if (i10 == 2) {
                this.f20472t.setText(getString(R$string.demo_machine_no_support));
                return;
            }
            return;
        }
        String string = getString(R$string.contact_email_value);
        SpannableString spannableString = new SpannableString(getString(R$string.set_get_info_not_avi, string));
        int iIndexOf = spannableString.toString().indexOf(string);
        spannableString.setSpan(new C4465j(this), iIndexOf, string.length() + iIndexOf, 33);
        this.f20472t.setMovementMethod(new C4466k(this, null));
        this.f20472t.setHighlightColor(getResources().getColor(R.color.transparent));
        this.f20472t.setText(spannableString);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: m1 */
    public void mo22379m1() {
        if (new HiCloudSafeIntent(getIntent()).getAction() == null || !(C11842p.m70762R0() || C11842p.m70735I0())) {
            super.mo22379m1();
        }
    }

    /* renamed from: m3 */
    public final void m27172m3(String str) {
        String strM80790C = C13452e.m80781L().m80790C();
        C13230i.m79504I().m79586g0("mecloud_findmyphone_click_usage", C13452e.m80781L().m80971t0(), strM80790C);
        UBAAnalyze.m29956Q("PVP", "mecloud_findmyphone_click_usage", "1", "19", strM80790C);
        C12515a.m75110o().m75172d(new C4459d(str));
    }

    /* renamed from: m4 */
    public void m27173m4(boolean z10) {
        m27177o4(false);
        this.f20443R.setCheckedProgrammatically(z10);
        this.f20449X.setText(z10 ? R$string.pf_switch_open_state_tip : R$string.pf_switch_close_state_tip);
        boolean z11 = true;
        if (z10) {
            m27122K3();
        } else {
            m27125M3(false);
            this.f20443R.initSubText(true, getString(R$string.sub_text_pf_switch));
        }
        if (z10 && C0209d.m1193N0()) {
            z11 = false;
        }
        m27177o4(z11);
        if (!z10) {
            m27179p4(false);
        }
        m27120J2();
    }

    /* renamed from: n3 */
    public final void m27174n3(String str) {
        String strM80790C = C13452e.m80781L().m80790C();
        C13230i.m79504I().m79586g0("mecloud_findmyphone_click_usage_finder", C13452e.m80781L().m80971t0(), strM80790C);
        UBAAnalyze.m29956Q("PVP", "mecloud_findmyphone_click_usage_finder", "1", "19", strM80790C);
        C12515a.m75110o().m75172d(new C4460e(str));
    }

    /* renamed from: n4, reason: merged with bridge method [inline-methods] */
    public final void m27181r3(boolean z10) throws Resources.NotFoundException {
        SpanClickText spanClickText;
        C13981a.m83989i("PhoneFinderActivity", "setPhoneFinderSpanSubText:" + z10);
        ListItemPatterm listItemPatterm = this.f20443R;
        if (listItemPatterm == null || (spanClickText = (SpanClickText) C12809f.m76831d(listItemPatterm, R$id.list_subtext)) == null) {
            return;
        }
        String string = getString(R$string.learn_more_backup);
        int i10 = R$string.sub_text_pf_switch_new;
        if (z10) {
            i10 = C11881n.m71343F() ? R$string.sub_text_pf_switch_new4 : R$string.sub_text_pf_switch_new3;
        }
        String string2 = getString(i10, string);
        HashMap map = new HashMap();
        map.put(2, string);
        C4467l c4467l = new C4467l(this, this.f20456e0);
        this.f20463l0 = c4467l;
        spanClickText.initText(string2, c4467l, map);
    }

    /* renamed from: o3 */
    public final void m27176o3() {
        if (C0209d.m1226Y0()) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
        C13230i.m79504I().m79590k0("mecloud_findmyphone_click_location_share", "", "", C13452e.m80781L().m80971t0(), linkedHashMap);
        UBAAnalyze.m29979g0("PVP", "mecloud_findmyphone_click_location_share", "1", "19", "", "", linkedHashMap);
        startActivity(new Intent(this, (Class<?>) ShareManagerActivity.class));
    }

    /* renamed from: o4 */
    public void m27177o4(boolean z10) {
        if (C0209d.m1193N0() && this.f20443R.getSwitchStatus()) {
            this.f20443R.setEnabled(false);
        } else {
            this.f20443R.setEnabled(z10);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        C13981a.m83987d("PhoneFinderActivity", "onActivityResult requestCode=" + i10 + ", resultCode=" + i11);
        super.onActivityResult(i10, i11, intent);
        if (1 == i10) {
            m27147X3(i11, intent);
        } else if (i10 == this.f20433H) {
            if (C0209d.m1301r1(this.f20476x)) {
                C11860j.m71058h1(1, null);
            }
            m27114G2();
        } else if (i10 == 8701) {
            C13195l.m79272J().m79299O(this, this.f20457f0, i10, i11, intent);
        } else if (i10 == 8903) {
            InterfaceC9285d interfaceC9285d = this.f20458g0;
            if (interfaceC9285d != null) {
                interfaceC9285d.mo17187t(this, i10, i11, intent);
            }
        } else if (i10 == 8909) {
            if (i11 == 0) {
                this.f20467p0 = true;
            } else if (i11 == -1) {
                this.f20467p0 = false;
            }
            C13195l.m79272J().m79298N(this, new C9916a(this.f20456e0, getApplicationContext()), i11, intent);
        }
        m27133Q2(i10, i11, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onBackPressed();
        if ("com.huawei.hwid".equals(this.f20438M)) {
            C13981a.m83989i("PhoneFinderActivity", "onBackPressed, from hwid");
            m27142V2();
            return;
        }
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        String stringExtra = hiCloudSafeIntent.getStringExtra(FamilyShareConstants.ENTRY_TYPE);
        boolean booleanExtra = hiCloudSafeIntent.getBooleanExtra("is_from_webview_filemanager", false);
        if (stringExtra == null || !stringExtra.equals("Browser") || booleanExtra) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(getPackageName(), NotifyConstants.Action.ACTION_MAIN_ACTIVITY));
        startActivity(intent);
        new HwAnimationReflection(this).m15927c(2);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) throws JSONException {
        C13981a.m83989i("PhoneFinderActivity", "onCheckedChanged=" + z10);
        if (m27058M2()) {
            compoundButton.setChecked(!z10);
            C13981a.m83988e("PhoneFinderActivity", "no network");
            return;
        }
        String str = (String) compoundButton.getTag();
        if ("switch_phonefinder".equals(str)) {
            m27132P3(z10);
        } else if ("switch_lastposition".equals(str)) {
            m27130O3(z10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (R$id.query_failed_email == id2) {
            m27083h4();
            return;
        }
        if (R$id.pf_explain == id2) {
            m27172m3(getString(R$string.text_pf_explain));
            return;
        }
        if (R$id.pf_how_to_use_link == id2) {
            m27174n3(getString(R$string.text_how_to_use));
            return;
        }
        if (R$id.map_img_view == id2 || R$id.show_devices_btn == id2) {
            m27092q3();
            return;
        }
        if (R$id.map_bg_view == id2) {
            if (C0209d.m1293p1()) {
                return;
            }
            m27092q3();
        } else if (R$id.pf_tip_text_view == id2) {
            C11881n.m71346I(this);
        } else if (R$id.pf_pattern_share_location == id2) {
            m27176o3();
        } else {
            this.f20460i0.onClick(view);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C13981a.m83989i("PhoneFinderActivity", "onConfigurationChanged");
        ScrollView scrollView = this.f20471s;
        if (scrollView != null) {
            scrollView.scrollTo(0, 0);
        }
        TipLinearLayout tipLinearLayout = this.f20460i0;
        if (tipLinearLayout != null) {
            tipLinearLayout.dismissAllPopWindow();
        }
        if (C11842p.m70771U0() || C11842p.m70735I0()) {
            m27082h3();
        }
        AlertDialog alertDialog = this.f20440O;
        if (alertDialog != null && alertDialog.isShowing()) {
            C11842p.m70890z1(this, this.f20440O);
        }
        if (C11881n.m71342E(this)) {
            m27122K3();
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, JSONException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        m29137U0();
        new HwAnimationReflection(this).m15927c(1);
        super.onCreate(bundle);
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f20468q0.m79065c(this, safeIntent, C13222a.m79465g(this));
        this.f20476x = this;
        this.f20456e0 = new HandlerC4468m(this);
        InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
        this.f20458g0 = interfaceC9285d;
        if (interfaceC9285d == null) {
            C13981a.m83988e("PhoneFinderActivity", "cloudSyncRouter is null in onCreate");
            return;
        }
        m27159f3(safeIntent);
        C13230i.m79504I().m79598v0(this, safeIntent, "PhoneFinderActivity");
        boolean z10 = (C10028c.m62183d0(getApplicationContext()).m62395t1("is_already_configed_NV4") && C0224k0.m1532B(this)) ? false : true;
        this.f20437L = z10;
        if (z10) {
            m27118I2();
            finish();
            return;
        }
        C13981a.m83987d("PhoneFinderActivity", "hasObtainConfig,not need to PhoneFinderWelcomeActivity");
        if (C13452e.m80781L().m80912f1()) {
            C13981a.m83988e("PhoneFinderActivity", "site not match");
            this.f20458g0.mo17185r(this);
            finish();
            return;
        }
        C13612b.m81829B().m81876o();
        this.f20459h0 = true;
        getWindow().setFlags(16777216, 16777216);
        setTheme(getResources().getIdentifier(C13843a.m83102x(), null, null));
        if (C0224k0.m1532B(this)) {
            RequestPermissionsActivity.m27223k(this);
        }
        ActionBar actionBar = getActionBar();
        this.f20478z = actionBar;
        if (actionBar != null) {
            actionBar.setTitle(R$string.start_finder_phone_new);
            ActionBar actionBar2 = this.f20478z;
            int i10 = R$color.hicloud_hmos_bg;
            C11842p.m70842n1(actionBar2, new ColorDrawable(getColor(i10)));
            this.f20478z.setBackgroundDrawable(new ColorDrawable(getColor(i10)));
            this.f20478z.setDisplayHomeAsUpEnabled(true);
        }
        Window window = getWindow();
        int i11 = R$color.hicloud_hmos_bg;
        window.setStatusBarColor(getColor(i11));
        getWindow().setNavigationBarColor(getColor(i11));
        setContentView(R$layout.pf_activity_main90);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        this.f20458g0.mo17181n(this);
        m27076c3();
        m27074b3();
        m27116H2();
        mo22385x1();
        if (!safeIntent.getBooleanExtra("openPhoneFinder", false) || C11881n.m71342E(this)) {
            return;
        }
        if (safeIntent.getBooleanExtra("fromMainActivityCard", false) && !C0209d.m1333z1(this)) {
            C13981a.m83987d("PhoneFinderActivity", "fromMainActivityCard, network not connect");
            m27188u4();
            return;
        }
        m27173m4(true);
        m27151Z3();
        Intent intent = getIntent();
        if (intent != null) {
            intent.removeExtra("openPhoneFinder");
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m27158e4();
        this.f20456e0.removeCallbacksAndMessages(null);
        this.f20456e0 = null;
        this.f20458g0.mo17166C();
        C11842p.m70836m(this);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) throws JSONException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onNewIntent(intent);
        m27159f3(intent);
        mo22385x1();
        new HwAnimationReflection(this).m15927c(1);
        this.f20468q0.m79065c(this, getIntent(), C13222a.m79465g(this));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (menuItem.getItemId() == 16908332) {
            if ("com.huawei.hwid".equals(this.f20438M)) {
                C13981a.m83989i("PhoneFinderActivity", "onBackPressed, from hwid");
                m27142V2();
                return true;
            }
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
            String stringExtra = hiCloudSafeIntent.getStringExtra(FamilyShareConstants.ENTRY_TYPE);
            boolean booleanExtra = hiCloudSafeIntent.getBooleanExtra("is_from_webview_filemanager", false);
            if (stringExtra == null || !stringExtra.equals("Browser") || booleanExtra) {
                finish();
                return true;
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(getPackageName(), NotifyConstants.Action.ACTION_MAIN_ACTIVITY));
            startActivity(intent);
            new HwAnimationReflection(this).m15927c(2);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        C13230i.m79504I().m79579Y(this, this.f16165h, this.f20455d0);
        UBAAnalyze.m29965Z("PVP", getClass().getCanonicalName(), "1", "19", this.f16165h, this.f16166i, super.mo18593F0());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z10) {
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        InterfaceC9285d interfaceC9285d = this.f20458g0;
        if (interfaceC9285d != null) {
            interfaceC9285d.mo17168a();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        C13981a.m83989i("PhoneFinderActivity", "onRestoreInstanceState");
        this.f20443R.setCheckedProgrammatically(this.f20434I);
        this.f20444S.setCheckedProgrammatically(this.f20434I && this.f20435J);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C13981a.m83989i("PhoneFinderActivity", "onResume");
        m27192x4();
        if (this.f20459h0) {
            m27170l3();
            C13230i.m79504I().m79583c0(this, this.f16165h, this.f20455d0);
            UBAAnalyze.m29969b0("PVP", getClass().getCanonicalName(), "1", "19", this.f16165h, this.f16166i);
        }
        m27058M2();
        m27180q4();
        if (C11881n.m71342E(this)) {
            m27107B4();
        } else {
            m27131P2();
            m27153b4();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        C13981a.m83989i("PhoneFinderActivity", "PhoneFinderActivity onUserLeaveHint");
    }

    /* renamed from: p3 */
    public final void m27178p3() {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent());
        C0209d.m1302r2(hiCloudSafeIntent, "com.huawei.android.findmyphone");
        hiCloudSafeIntent.setAction("android.intent.action.MAIN");
        hiCloudSafeIntent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        if (hiCloudSafeIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(hiCloudSafeIntent);
        } else {
            C13981a.m83988e("PhoneFinderActivity", "phoneFinder not installed");
            C11880m.m71336c(this, R$string.remand_download_slave);
        }
    }

    /* renamed from: p4 */
    public void m27179p4(boolean z10) {
        this.f20444S.setPatternEnabled(z10);
        this.f20445T.setPatternEnabled(z10);
    }

    /* renamed from: q4 */
    public final void m27180q4() {
        ListItemPatterm listItemPatterm = this.f20443R;
        if (listItemPatterm != null) {
            listItemPatterm.setSwitchTag("switch_phonefinder");
            this.f20443R.setSwitchListen(this);
        }
        ListItemPatterm listItemPatterm2 = this.f20444S;
        if (listItemPatterm2 != null) {
            listItemPatterm2.setSwitchTag("switch_lastposition");
            this.f20444S.setSwitchListen(this);
        }
    }

    /* renamed from: r4 */
    public final void m27182r4(int i10) {
        if (i10 == -100) {
            C11880m.m71337d(this, getString(R$string.activate_error_cannot_conn_server));
        }
        if (i10 == 3005) {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(R$string.check_vt_fail).setMessage(R$string.pf_activation_tip_assistance_dialog).setPositiveButton(R$string.beta_ok, new DialogInterface.OnClickListener() { // from class: gg.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    C13981a.m83989i("PhoneFinderActivity", "close dialog");
                }
            }).create();
            this.f20464m0 = alertDialogCreate;
            alertDialogCreate.show();
            return;
        }
        switch (i10) {
            case 3202:
                C11880m.m71337d(this, getString(R$string.activate_error_too_many_times_please_24_retry, 10, 24));
                break;
            case 3203:
                C11880m.m71336c(this, R$string.check_account_vt_fail);
                break;
            case 3204:
                AlertDialog alertDialogCreate2 = new AlertDialog.Builder(this).setTitle(R$string.check_vt_fail).setMessage(R$string.close_finder_fail_dialog_content_update).setPositiveButton(R$string.close_finder_fail_dialog_remove_device, new DialogInterface.OnClickListener() { // from class: gg.n
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i11) {
                        this.f48678a.m27111E3(dialogInterface, i11);
                    }
                }).setNegativeButton(R$string.dialog_cancel, new DialogInterface.OnClickListener() { // from class: gg.o
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i11) {
                        C13981a.m83989i("PhoneFinderActivity", "close dialog");
                    }
                }).create();
                this.f20464m0 = alertDialogCreate2;
                alertDialogCreate2.show();
                break;
            default:
                C11880m.m71337d(this, getString(R$string.activate_error_cannot_conn_server) + " (" + i10 + ")");
                break;
        }
    }

    /* renamed from: s3 */
    public final /* synthetic */ void m27183s3(Boolean bool) {
        if (bool.booleanValue()) {
            m27149Y3();
        } else {
            C13981a.m83989i("PhoneFinderActivity", "check offline locate state is limited");
        }
    }

    /* renamed from: s4 */
    public void m27184s4(int i10) {
        C13981a.m83989i("PhoneFinderActivity", "showErrorView: " + i10);
        m27171l4(i10);
        this.f20473u.setVisibility(0);
        this.f20474v.setVisibility(8);
    }

    /* renamed from: t3 */
    public final /* synthetic */ void m27185t3(Boolean bool) {
        if (bool.booleanValue()) {
            C11877j.m71239V0(this.f20476x, true);
            final boolean zM26424z = C4375j.m26424z(this.f20476x);
            C0226l0.m1584d(new Runnable() { // from class: gg.c
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    this.f48668a.m27181r3(zM26424z);
                }
            });
            if (!C0209d.m1277l1() && C4375j.m26423y()) {
                C0190c.m1075b(1, true, new Consumer() { // from class: gg.d
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f48670a.m27183s3((Boolean) obj);
                    }
                });
            }
        }
    }

    /* renamed from: t4 */
    public final void m27186t4() throws IllegalAccessException, IllegalArgumentException {
        View viewM27161g3 = m27161g3();
        this.f20461j0 = viewM27161g3;
        CompoundButton compoundButton = (CompoundButton) C12809f.m76831d(viewM27161g3, R$id.photo_switch_sendlastposition);
        boolean zM27192x4 = m27192x4();
        C13981a.m83989i("PhoneFinderActivity", "showLoginSuccessDialog AlertDialog begin");
        AlertDialog.Builder view = new AlertDialog.Builder(this).setView(this.f20461j0);
        view.setTitle(getResources().getString(R$string.popupwindow_opentitle_device));
        view.setPositiveButton(zM27192x4 ? R$string.cloudbackup_btn_ok : R$string.beta_ok, new DialogInterfaceOnClickListenerC4458c(compoundButton));
        AlertDialog alertDialog = this.f20440O;
        if (alertDialog == null || !alertDialog.isShowing()) {
            AlertDialog alertDialogCreate = view.create();
            this.f20440O = alertDialogCreate;
            C11829c.m70594l1(this, alertDialogCreate);
            C11842p.m70890z1(this, this.f20440O);
            this.f20440O.setCanceledOnTouchOutside(false);
            try {
                this.f20440O.show();
            } catch (Exception unused) {
                C13981a.m83988e("PhoneFinderActivity", "showLoginSuccessDialog bad window");
            }
        }
    }

    /* renamed from: u3 */
    public final /* synthetic */ void m27187u3(Boolean bool) {
        int i10;
        if (bool.booleanValue()) {
            C4375j.m26396J(this.f20476x, true, new Consumer() { // from class: gg.u
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f48683a.m27185t3((Boolean) obj);
                }
            });
            return;
        }
        HandlerC4468m handlerC4468m = this.f20456e0;
        if (handlerC4468m != null && (i10 = this.f20465n0) < 2) {
            this.f20465n0 = i10 + 1;
            handlerC4468m.sendEmptyMessageDelayed(4023, 30000L);
        }
        ListItemPatterm listItemPatterm = this.f20443R;
        if (listItemPatterm != null) {
            listItemPatterm.setSubText(getString(R$string.sub_text_pf_switch));
        }
        C11877j.m71239V0(C12347f.m74285n().m74301m(), false);
    }

    /* renamed from: u4 */
    public final void m27188u4() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R$string.open_failed_title));
            builder.setMessage(getString(R$string.cloudpay_net_disconnect_alert));
            builder.setPositiveButton(getString(R$string.set_network), new DialogInterface.OnClickListener() { // from class: gg.t
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.f48682a.m27115G3(dialogInterface, i10);
                }
            });
            builder.setNegativeButton(getString(R$string.cancel), (DialogInterface.OnClickListener) null);
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setCanceledOnTouchOutside(false);
            alertDialogCreate.show();
        } catch (Exception unused) {
            C13981a.m83988e("PhoneFinderActivity", "showNetNoConnectDialog bad window");
        }
    }

    /* renamed from: v3 */
    public final /* synthetic */ void m27189v3() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        finish();
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            new HwAnimationReflection(contextM1377a).m15927c(2);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: w1 */
    public void mo22384w1() {
        this.f16167j = new HiCloudSafeIntent(getIntent()).getStringExtra(NotifyConstants.CloudStorageConstants.AD_NAME_KEY);
    }

    /* renamed from: w3 */
    public final /* synthetic */ void m27190w3(DialogInterface dialogInterface, int i10) {
        if (-1 == i10) {
            C13981a.m83989i("PhoneFinderActivity", "apply join circle");
            new PhoneFinderTrustCircleManager(this.f20476x).joinTrustCircle(new Consumer() { // from class: gg.k
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f48676a.m27152a4((TrustCircleInfo) obj);
                }
            });
            C11690w.m69700W("", "trustCircleOperation", "trustCircleBusiness", "openOfflineLocateSwitch join", "0", null);
        } else if (-2 == i10) {
            C13981a.m83989i("PhoneFinderActivity", "cancel join circle");
            C11690w.m69700W("", "trustCircleOperation", "trustCircleBusiness", "openOfflineLocateSwitch join cancel", "0", null);
        }
    }

    /* renamed from: w4 */
    public final boolean m27191w4(RelativeLayout relativeLayout, CompoundButton compoundButton) {
        if (relativeLayout == null || compoundButton == null) {
            C13981a.m83988e("PhoneFinderActivity", "view is null");
            return false;
        }
        if (C10028c.m62182c0().m62388s("backup_key") || !C10028c.m62182c0().m62395t1("funcfg_cloud_backup")) {
            relativeLayout.setVisibility(8);
            compoundButton.setChecked(false);
            return false;
        }
        relativeLayout.setVisibility(0);
        compoundButton.setChecked(true);
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: x1 */
    public boolean mo22385x1() {
        String strM79465g = C13222a.m79465g(this);
        if (strM79465g.equals("0")) {
            this.f16165h = "2";
            this.f20455d0 = "";
            return true;
        }
        if (strM79465g.equals("5")) {
            mo22384w1();
            this.f16165h = "3";
            this.f20455d0 = this.f16167j;
            return true;
        }
        if (this.f20438M.equals("com.huawei.systemmanager")) {
            this.f16165h = "1";
            this.f20455d0 = "6";
            return true;
        }
        if (this.f20438M.equals("com.android.settings")) {
            this.f16165h = "1";
            this.f20455d0 = "4";
            return true;
        }
        if (this.f20438M.equals("com.android.settings_top")) {
            this.f16165h = "1";
            this.f20455d0 = "5";
            return true;
        }
        if ("com.huawei.hwid".equals(this.f20438M)) {
            this.f16165h = "1";
            this.f20455d0 = "1";
        }
        String strM79501D = C13230i.m79501D(this);
        String strM79502E = C13230i.m79502E(this);
        if (TextUtils.isEmpty(strM79501D)) {
            return false;
        }
        this.f16165h = strM79501D;
        this.f20455d0 = strM79502E;
        C13981a.m83989i("PhoneFinderActivity", "parseAnalyticsTypeValue type:" + this.f16165h + " value" + this.f20455d0);
        return true;
    }

    /* renamed from: x4 */
    public final boolean m27192x4() {
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(this.f20461j0, R$id.sendlastpositions);
        CompoundButton compoundButton = (CompoundButton) C12809f.m76831d(this.f20461j0, R$id.photo_switch_sendlastposition);
        boolean zM27191w4 = false;
        if (relativeLayout == null || compoundButton == null) {
            C13981a.m83990w("PhoneFinderActivity", "view is null");
            return false;
        }
        if (C0209d.m1293p1()) {
            relativeLayout.setVisibility(8);
            compoundButton.setChecked(false);
            return false;
        }
        if (C11829c.m70532M0() && !C10028c.m62182c0().m62413x()) {
            relativeLayout.setVisibility(8);
            compoundButton.setChecked(false);
        } else {
            zM27191w4 = m27191w4(relativeLayout, compoundButton);
        }
        m27164i4(compoundButton);
        return zM27191w4;
    }

    /* renamed from: y3 */
    public final /* synthetic */ void m27193y3() {
        m27098v4(new DialogInterface.OnClickListener() { // from class: gg.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f48675a.m27190w3(dialogInterface, i10);
            }
        }, new DialogInterface.OnCancelListener() { // from class: gg.j
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                PhoneFinderActivity.m27101x3(dialogInterface);
            }
        });
    }

    /* renamed from: y4 */
    public void m27194y4(int i10) {
        if (isFinishing()) {
            C13981a.m83988e("PhoneFinderActivity", "showPhoneFindbackUnCheckedAlertDialog is finishing");
            return;
        }
        C11877j.m71307t1(this.f20476x);
        m27177o4(false);
        m27156d4();
        m27129O2();
        this.f20426A = true;
        if (!C11860j.m71029X()) {
            C11860j.m71037a1(1);
            C11860j.m71030X0(500);
            C11860j.m71051f0(this.f20476x, i10, false);
        }
        m27105A4();
        String strM80790C = C13452e.m80781L().m80790C();
        C13009a.m78307b(this, "CLOUDBACKUP_OPEN_PHONEFINDER", this.f20438M + "|1", strM80790C);
        UBAAnalyze.m29946G("CKP", "HUAWEICLOUD", "CLOUDBACKUP_OPEN_PHONEFINDER", this.f20438M + "|1", strM80790C);
        Timer timer = new Timer();
        this.f20431F = timer;
        timer.schedule(new C10501f(this.f20456e0), 120000L);
    }

    /* renamed from: z3 */
    public final /* synthetic */ void m27195z3(TrustCircleInfo trustCircleInfo) {
        boolean zIsJoinTrustCircle = trustCircleInfo.isJoinTrustCircle();
        C13981a.m83989i("PhoneFinderActivity", "checkTrustCircleStatus:" + zIsJoinTrustCircle);
        if (!zIsJoinTrustCircle) {
            C0226l0.m1584d(new Runnable() { // from class: gg.f
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    this.f48672a.m27104A3();
                }
            });
            C0226l0.m1584d(new Runnable() { // from class: gg.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f48673a.m27193y3();
                }
            });
        } else if (!C4375j.m26424z(this.f20476x)) {
            m27152a4(trustCircleInfo);
        }
        C11690w.m69700W("", "trustCircleOperation", "trustCircleBusiness", "openOfflineLocateSwitch isJoin: " + zIsJoinTrustCircle, "0", null);
    }

    /* renamed from: z4 */
    public void m27196z4() {
        if (!this.f20426A) {
            C13981a.m83987d("PhoneFinderActivity", "SendPhoneFinderOn is not by this view so dismiss alert dialog");
            return;
        }
        NewHiSyncUtil newHiSyncUtil = this.f20475w;
        if (newHiSyncUtil == null) {
            C13981a.m83988e("PhoneFinderActivity", "newHiSyncActivityUtil is null");
        } else {
            newHiSyncUtil.m27971b(this, getResources().getString(R$string.phonefinder_title_lockscreen_password), getResources().getString(R$string.phonefinder_content_set_lockscreen_update), getResources().getString(R$string.phonefinder_set_lockscreen_now), getResources().getString(R$string.phonefinder_set_lockscreen_later), new C4456a());
            C13230i.m79504I().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", "PhoneFinderActivity", "showDialog");
        }
    }
}
