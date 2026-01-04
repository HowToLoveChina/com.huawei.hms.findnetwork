package com.huawei.android.hicloud.p088ui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CouponCenterActivity;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.notification.BackupNotification;
import com.huawei.android.hicloud.p088ui.notification.RestoreNotification;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.CleanCacheDialog;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.cloud.pay.model.Response;
import com.huawei.hicloud.bean.EntryQuestBean;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.util.CampaignCheckUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import fj.C9718g;
import fk.C9721b;
import ge.C9908c;
import ge.C9913h;
import gp.C10028c;
import io.C10582a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0226l0;
import p015ak.C0241z;
import p292fn.C9733f;
import p336he.C10155f;
import p341hj.C10271w0;
import p472m7.C11427b;
import p514o9.C11827a;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12540b1;
import p618rm.C12571m;
import p618rm.C12591s1;
import p618rm.C12598v;
import p664u0.C13108a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p782xo.C13842a;
import p847zk.C14311d;
import p847zk.C14317j;
import sk.C12809f;
import tm.C13040c;

/* loaded from: classes3.dex */
public class MoreSettingActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: A */
    public LinearLayout f15526A;

    /* renamed from: B */
    public LinearLayout f15527B;

    /* renamed from: C */
    public LinearLayout f15528C;

    /* renamed from: D */
    public LinearLayout f15529D;

    /* renamed from: E */
    public TextView f15530E;

    /* renamed from: F */
    public ImageView f15531F;

    /* renamed from: G */
    public HwProgressBar f15532G;

    /* renamed from: H */
    public LinearLayout f15533H;

    /* renamed from: I */
    public ImageView f15534I;

    /* renamed from: J */
    public HwProgressBar f15535J;

    /* renamed from: K */
    public LinearLayout f15536K;

    /* renamed from: L */
    public LinearLayout f15537L;

    /* renamed from: M */
    public LinearLayout f15538M;

    /* renamed from: N */
    public UnionSwitch f15539N;

    /* renamed from: O */
    public LinearLayout f15540O;

    /* renamed from: P */
    public LinearLayout f15541P;

    /* renamed from: Q */
    public LinearLayout f15542Q;

    /* renamed from: R */
    public LinearLayout f15543R;

    /* renamed from: S */
    public LinearLayout f15544S;

    /* renamed from: T */
    public LinearLayout f15545T;

    /* renamed from: U */
    public LinearLayout f15546U;

    /* renamed from: V */
    public View f15547V;

    /* renamed from: W */
    public CleanCacheDialog f15548W;

    /* renamed from: d0 */
    public String f15555d0;

    /* renamed from: e0 */
    public boolean f15556e0;

    /* renamed from: f0 */
    public SpanClickText f15557f0;

    /* renamed from: p */
    public NotchTopFitRelativeLayout f15560p;

    /* renamed from: q */
    public NotchFitRelativeLayout f15561q;

    /* renamed from: r */
    public NotchFitRelativeLayout f15562r;

    /* renamed from: s */
    public HiCloudExceptionView f15563s;

    /* renamed from: t */
    public LinearLayout f15564t;

    /* renamed from: u */
    public LinearLayout f15565u;

    /* renamed from: v */
    public LinearLayout f15566v;

    /* renamed from: w */
    public ImageView f15567w;

    /* renamed from: x */
    public TextView f15568x;

    /* renamed from: y */
    public ImageView f15569y;

    /* renamed from: z */
    public HwProgressBar f15570z;

    /* renamed from: X */
    public Handler f15549X = new HandlerC3411j(this);

    /* renamed from: Y */
    public SettingReceiver f15550Y = null;

    /* renamed from: Z */
    public NetWorkChangeReceiver f15551Z = null;

    /* renamed from: a0 */
    public boolean f15552a0 = false;

    /* renamed from: b0 */
    public boolean f15553b0 = false;

    /* renamed from: c0 */
    public boolean f15554c0 = false;

    /* renamed from: g0 */
    public CompoundButton.OnCheckedChangeListener f15558g0 = new C3402a();

    /* renamed from: h0 */
    public Handler f15559h0 = new HandlerC3403b();

    public class NetWorkChangeReceiver extends BroadcastReceiver {
        public NetWorkChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(new SafeIntent(intent).getAction())) {
                MoreSettingActivity.this.m21602i2();
            }
        }
    }

    public class SettingReceiver extends BroadcastReceiver {
        public SettingReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if ("checkFinish".equals(action)) {
                boolean booleanExtra = safeIntent.getBooleanExtra("visibility", false);
                C11839m.m70688i("MoreSettingActivity", "receive CHECK_UPDATE_ACTION, is need to show: " + booleanExtra);
                MoreSettingActivity.this.m21613J2(booleanExtra ^ true, booleanExtra);
                return;
            }
            if ("com.huawei.hicloud.backup.end.refresh.clear.cache".equals(action)) {
                if (MoreSettingActivity.this.f15566v == null) {
                    C11839m.m70686d("MoreSettingActivity", "onReceive cleanCacheItem  is null");
                } else {
                    MoreSettingActivity.this.f15566v.setAlpha(1.0f);
                    MoreSettingActivity.this.f15566v.setEnabled(true);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MoreSettingActivity$a */
    public class C3402a implements CompoundButton.OnCheckedChangeListener {
        public C3402a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (!MoreSettingActivity.this.m21602i2()) {
                MoreSettingActivity.this.m21612I2(String.valueOf(z10));
                MoreSettingActivity.this.f15539N.setChecked(z10);
                MoreSettingActivity.this.m21611G2(z10);
            } else {
                C11839m.m70688i("MoreSettingActivity", "no network");
                MoreSettingActivity.this.f15539N.setOnCheckedChangeListener(null);
                MoreSettingActivity.this.f15539N.setChecked(!z10);
                MoreSettingActivity.this.f15539N.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.huawei.android.hicloud.ui.activity.f7
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton2, boolean z11) {
                        this.f17611a.onCheckedChanged(compoundButton2, z11);
                    }
                });
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MoreSettingActivity$b */
    public class HandlerC3403b extends Handler {
        public HandlerC3403b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1003) {
                MoreSettingActivity.this.m21621l2(message.obj.toString());
            } else {
                if (i10 != 1004) {
                    return;
                }
                MoreSettingActivity.this.m21620k2(message.obj.toString());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MoreSettingActivity$c */
    public class C3404c extends AbstractC12367d {
        public C3404c() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String strM78669v;
            try {
                strM78669v = C13040c.m78609F().m78669v();
            } catch (C9721b e10) {
                C11839m.m70687e("MoreSettingActivity", "getConsumerUrl exception:" + e10.toString());
                strM78669v = "";
            }
            if (TextUtils.isEmpty(strM78669v)) {
                return;
            }
            String str = strM78669v + C11827a.m70483h("cloud_service_agreement") + "&contenttag=di";
            Message messageObtain = Message.obtain();
            messageObtain.what = 1004;
            messageObtain.obj = str;
            MoreSettingActivity.this.f15559h0.sendMessage(messageObtain);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MoreSettingActivity$d */
    public class C3405d extends AbstractC12367d {
        public C3405d() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String strM78669v;
            try {
                strM78669v = C13040c.m78609F().m78669v();
            } catch (C9721b e10) {
                C11839m.m70687e("MoreSettingActivity", "getConsumerUrl exception:" + e10.toString());
                strM78669v = "";
            }
            if (TextUtils.isEmpty(strM78669v)) {
                return;
            }
            String str = strM78669v + C11827a.m70483h("cloud_service_agreement") + "&contenttag=3rdsdk";
            Message messageObtain = Message.obtain();
            messageObtain.what = 1003;
            messageObtain.obj = str;
            MoreSettingActivity.this.f15559h0.sendMessage(messageObtain);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MoreSettingActivity$e */
    public class C3406e implements C10271w0.a {
        public C3406e() {
        }

        @Override // p341hj.C10271w0.a
        /* renamed from: a */
        public void mo21634a(Response response) {
            if (response == null || response.getResultCode() != 0) {
                return;
            }
            C11839m.m70686d("MoreSettingActivity", "permissionUpdateTask success");
            MoreSettingActivity.this.m21609E2();
        }

        /* renamed from: c */
        public final /* synthetic */ void m21635c() {
            C12809f.m76843p(MoreSettingActivity.this.f15531F, true);
            C12809f.m76843p(MoreSettingActivity.this.f15532G, false);
            MoreSettingActivity moreSettingActivity = MoreSettingActivity.this;
            C11841o.m70706b(moreSettingActivity, moreSettingActivity.getResources().getString(R$string.share_location_network_error_toast), 0);
        }

        @Override // p341hj.C10271w0.a
        public void onError(String str) {
            C11839m.m70687e("MoreSettingActivity", "permissionUpdateTask error");
            C0226l0.m1586f(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.g7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17621a.m21635c();
                }
            });
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MoreSettingActivity$f */
    public class C3407f extends AbstractC12367d {
        public C3407f() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!C12591s1.m75931a().m75942l()) {
                C14311d.m85230g().m85236f(MoreSettingActivity.this, true);
            }
            ICBBroadcastManager.sendCancelRestoreBroadcast(MoreSettingActivity.this);
            C12571m.m75543e("");
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            Message messageObtain = Message.obtain();
            messageObtain.what = 9008;
            messageObtain.obj = Long.valueOf(jCurrentTimeMillis2);
            if (jCurrentTimeMillis2 > RippleView.SINGLE_RIPPLE_TIME) {
                MoreSettingActivity.this.f15549X.sendMessage(messageObtain);
            } else {
                MoreSettingActivity.this.f15549X.sendMessageDelayed(messageObtain, RippleView.SINGLE_RIPPLE_TIME - jCurrentTimeMillis2);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MoreSettingActivity$g */
    public class C3408g extends AbstractC12367d {
        public C3408g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$call$0() {
            MoreSettingActivity.this.f15539N.setOnCheckedChangeListener(null);
            MoreSettingActivity.this.f15539N.setChecked(!String.valueOf(0).equals(MoreSettingActivity.this.f15555d0));
            MoreSettingActivity moreSettingActivity = MoreSettingActivity.this;
            C0212e0.m1368r(moreSettingActivity, "hicloud_persona_marketing_sp", "persona_marketing_status", moreSettingActivity.f15555d0 != null ? Integer.valueOf(MoreSettingActivity.this.f15555d0).intValue() : 1);
            MoreSettingActivity.this.f15539N.setOnCheckedChangeListener(MoreSettingActivity.this.f15558g0);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                if (!MoreSettingActivity.this.m21602i2()) {
                    MoreSettingActivity.this.f15555d0 = new C10582a(null).m64925Z().getSwitchInfo("personalizedMarketingSwitch");
                    C11839m.m70688i("MoreSettingActivity", "getUserProperties from protocol is:" + MoreSettingActivity.this.f15555d0);
                }
                C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.h7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f17630a.lambda$call$0();
                    }
                });
            } catch (C9721b e10) {
                C11839m.m70687e("MoreSettingActivity", "QueryUserProperties failed: " + e10.getMessage());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MoreSettingActivity$h */
    public class C3409h extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ boolean f15580a;

        public C3409h(boolean z10) {
            this.f15580a = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            HashMap map = new HashMap();
            map.put("personalizedMarketingSwitch", String.valueOf(this.f15580a ? 1 : 0));
            new C10582a(null).m64916Q(map);
            C11839m.m70688i("MoreSettingActivity", "postUserProperties personalizedMarketingSwitch:" + this.f15580a);
            C0212e0.m1368r(MoreSettingActivity.this, "hicloud_persona_marketing_sp", "persona_marketing_status", this.f15580a ? 1 : 0);
            C11839m.m70688i("MoreSettingActivity", "postUserProperties personalizedMarketingSwitch to SP:" + this.f15580a);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MoreSettingActivity$i */
    public class C3410i extends AbstractC12367d {
        public C3410i() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$call$0(String str) {
            Intent intent = new Intent(MoreSettingActivity.this, (Class<?>) OperationWebViewActivity.class);
            intent.putExtra("url", str);
            intent.putExtra("title", MoreSettingActivity.this.getString(R$string.setting_app_center));
            intent.putExtra("isEnableJs", true);
            intent.putExtra("title_priority", true);
            intent.putExtra("is_support_orientation", true);
            intent.putExtra("is_support_dark_mode", true);
            MoreSettingActivity.this.startActivity(intent);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException, C9721b {
            final String strM60754m = C9733f.m60705z().m60754m();
            C0226l0.m1586f(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.i7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17639a.lambda$call$0(strM60754m);
                }
            });
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MoreSettingActivity$j */
    public static class HandlerC3411j extends Handler {

        /* renamed from: a */
        public final WeakReference<MoreSettingActivity> f15583a;

        public HandlerC3411j(MoreSettingActivity moreSettingActivity) {
            this.f15583a = new WeakReference<>(moreSettingActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MoreSettingActivity moreSettingActivity = this.f15583a.get();
            if (moreSettingActivity == null || moreSettingActivity.isFinishing() || moreSettingActivity.isDestroyed()) {
                C11839m.m70687e("MoreSettingActivity", "the activity is not available");
            } else if (message.what == 9008) {
                C11839m.m70686d("MoreSettingActivity", "MSG_CLEAN_CACHE");
                moreSettingActivity.m21616f2(message);
            }
        }
    }

    /* renamed from: A2 */
    public static boolean m21578A2() {
        if (C0209d.m1293p1()) {
            C11839m.m70689w("MoreSettingActivity", "isShowAppCenter, InkScreen");
            return false;
        }
        if (!C0209d.m1202Q0()) {
            C11839m.m70689w("MoreSettingActivity", "isShowAppCenter, oversea rom!");
            return false;
        }
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            return true;
        }
        C11839m.m70689w("MoreSettingActivity", "isShowAppCenter, oversea account!");
        return false;
    }

    /* renamed from: H2 */
    private void m21579H2() {
        this.f15551Z = new NetWorkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.f15551Z, intentFilter, "com.huawei.cg.permission.SERVICE", null);
    }

    /* renamed from: M2 */
    private void m21582M2() {
        NetWorkChangeReceiver netWorkChangeReceiver = this.f15551Z;
        if (netWorkChangeReceiver != null) {
            unregisterReceiver(netWorkChangeReceiver);
            this.f15551Z = null;
        }
    }

    /* renamed from: N2 */
    private void m21584N2() {
        if (this.f15550Y != null) {
            try {
                C13108a.m78878b(this).m78883f(this.f15550Y);
                this.f15550Y = null;
            } catch (Exception unused) {
                C11839m.m70687e("MoreSettingActivity", "unregisterBroadcastReceiver mLocalReceiver");
            }
        }
    }

    /* renamed from: e2 */
    private void m21601e2() {
        C11839m.m70688i("MoreSettingActivity", "cleanBackupCache");
        C13842a.m83010i().m83027e();
        m21608D2(this, true, true);
        C13227f.m79492i1().m79585f0("action_code_backup_clean_cache", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "action_code_backup_clean_cache", "1", "79");
        C12598v.m76039g(CloudBackupConstant.REPORT_TYPE_BASE_CLEAR_CACHE);
        CleanCacheDialog cleanCacheDialog = new CleanCacheDialog(this);
        this.f15548W = cleanCacheDialog;
        cleanCacheDialog.show();
        C12515a.m75110o().m75172d(new C3407f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i2 */
    public boolean m21602i2() {
        if (this.f15563s == null) {
            C11839m.m70686d("MoreSettingActivity", "processExceptionView exceptionView is null");
            return false;
        }
        if (C0209d.m1333z1(this)) {
            this.f15563s.m23914a();
            return false;
        }
        this.f15563s.m23919i();
        return true;
    }

    /* renamed from: n2 */
    private void m21603n2() {
        C11839m.m70688i("MoreSettingActivity", "initBroadcastReceiver");
        if (this.f15550Y == null) {
            this.f15550Y = new SettingReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("checkFinish");
            intentFilter.addAction("com.huawei.hicloud.backup.end.refresh.clear.cache");
            C13108a.m78878b(this).m78880c(this.f15550Y, intentFilter);
        }
    }

    /* renamed from: s2 */
    private void m21604s2() {
        m21602i2();
        m21579H2();
        m21603n2();
        m21631x2();
        m21626r2();
        m21630w2();
        m21623o2();
        m21624p2();
        m21625q2();
        m21627t2();
        m21629v2();
        m21628u2();
        m21622m2();
    }

    /* renamed from: y2 */
    private void m21605y2() {
        this.f15546U = (LinearLayout) C12809f.m76829b(this, R$id.app_center_item);
        this.f15547V = C12809f.m76829b(this, R$id.app_center_divider);
        this.f15563s = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        this.f15560p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.notch_top_fit_frame);
        this.f15561q = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_center_fit_frame);
        this.f15562r = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_bottom_fit_frame);
        this.f15564t = (LinearLayout) C12809f.m76829b(this, R$id.card_center_item);
        this.f15565u = (LinearLayout) C12809f.m76829b(this, R$id.card_center_divider);
        this.f15566v = (LinearLayout) C12809f.m76829b(this, R$id.clean_cache_item);
        this.f15567w = (ImageView) C12809f.m76829b(this, R$id.clean_cache_item_icon);
        this.f15568x = (TextView) C12809f.m76829b(this, R$id.clean_cache_title);
        this.f15569y = (ImageView) C12809f.m76829b(this, R$id.clean_cache_right_arrow);
        this.f15570z = (HwProgressBar) C12809f.m76829b(this, R$id.clean_cache_progress);
        this.f15526A = (LinearLayout) C12809f.m76829b(this, R$id.clean_cache_divider);
        this.f15527B = (LinearLayout) C12809f.m76829b(this, R$id.push_item);
        this.f15528C = (LinearLayout) C12809f.m76829b(this, R$id.push_item_divider);
        this.f15529D = (LinearLayout) C12809f.m76829b(this, R$id.campaign_item);
        this.f15530E = (TextView) C12809f.m76829b(this, R$id.campaign_item_title);
        this.f15531F = (ImageView) C12809f.m76829b(this, R$id.campaign_item_arrow);
        this.f15532G = (HwProgressBar) C12809f.m76829b(this, R$id.campaign_item_progress);
        this.f15533H = (LinearLayout) C12809f.m76829b(this, R$id.check_update_item);
        this.f15534I = (ImageView) C12809f.m76829b(this, R$id.check_update_right_arrow);
        this.f15535J = (HwProgressBar) C12809f.m76829b(this, R$id.check_update_progress);
        this.f15536K = (LinearLayout) C12809f.m76829b(this, R$id.individualization_item);
        this.f15537L = (LinearLayout) C12809f.m76829b(this, R$id.personalized_marketing_item);
        this.f15539N = (UnionSwitch) C12809f.m76829b(this, R$id.personalized_marketing_switch);
        this.f15538M = (LinearLayout) C12809f.m76829b(this, R$id.personalized_marketing_divider);
        this.f15540O = (LinearLayout) C12809f.m76829b(this, R$id.individualization_divider);
        this.f15541P = (LinearLayout) C12809f.m76829b(this, R$id.collection_info_item);
        this.f15542Q = (LinearLayout) C12809f.m76829b(this, R$id.collection_info_divider);
        this.f15543R = (LinearLayout) C12809f.m76829b(this, R$id.hicloud_sdk_item);
        this.f15544S = (LinearLayout) C12809f.m76829b(this, R$id.sdk_divider);
        this.f15545T = (LinearLayout) C12809f.m76829b(this, R$id.about_item);
        this.f15564t.setOnClickListener(this);
        this.f15566v.setOnClickListener(this);
        this.f15527B.setOnClickListener(this);
        this.f15529D.setOnClickListener(this);
        this.f15533H.setOnClickListener(this);
        this.f15536K.setOnClickListener(this);
        this.f15541P.setOnClickListener(this);
        this.f15543R.setOnClickListener(this);
        m21619j2();
        this.f15545T.setOnClickListener(this);
        this.f15546U.setOnClickListener(this);
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            this.f15541P.setVisibility(0);
            this.f15542Q.setVisibility(0);
            this.f15543R.setVisibility(0);
            this.f15544S.setVisibility(0);
        }
    }

    /* renamed from: B2 */
    public final /* synthetic */ void m21606B2() {
        Toast.makeText(this, getString(R$string.cache_cleaned), 0).show();
    }

    /* renamed from: C2 */
    public final /* synthetic */ void m21607C2() {
        C12809f.m76843p(this.f15531F, true);
        C12809f.m76843p(this.f15532G, false);
        if (this.f15556e0) {
            C11841o.m70706b(this, getResources().getString(R$string.close_campaign_switch_toast), 0);
            this.f15530E.setText(R$string.open_campaign_switch);
            this.f15556e0 = false;
        } else {
            C11841o.m70706b(this, getResources().getString(R$string.settings_hicloud_open), 0);
            this.f15530E.setText(R$string.close_campaign_switch);
            this.f15556e0 = true;
        }
    }

    /* renamed from: D2 */
    public final void m21608D2(Context context, boolean z10, boolean z11) {
        if (context == null) {
            C11839m.m70688i("MoreSettingActivity", "notifyClearCache context is null");
            return;
        }
        C11839m.m70688i("MoreSettingActivity", "notifyClearCache");
        SafeIntent safeIntent = new SafeIntent(new Intent());
        safeIntent.setAction("com.huawei.hicloud.more.setting.clear.cache");
        safeIntent.putExtra("reportDeleteFile", z10);
        safeIntent.putExtra("clearWebViewCache", z11);
        C13108a.m78878b(context).m78881d(safeIntent);
    }

    /* renamed from: E2 */
    public final void m21609E2() {
        C11839m.m70686d("MoreSettingActivity", "permissionUpdateFinish");
        if (this.f15530E == null) {
            return;
        }
        C0212e0.m1368r(this, "hicloud_campaign_activity_entry_sp", "displayEntryFlag", !this.f15556e0 ? 1 : 0);
        C0212e0.m1368r(this, "hicloud_campaign_activity_entry_sp", "settingStatus", !this.f15556e0 ? 1 : 0);
        C0226l0.m1586f(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.e7
            @Override // java.lang.Runnable
            public final void run() {
                this.f17599a.m21607C2();
            }
        });
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.action.updateCampaign"));
    }

    /* renamed from: F2 */
    public final void m21610F2(int i10) {
        HashMap map = new HashMap();
        map.put("item", 3);
        map.put("value", Integer.valueOf(i10));
        new C10271w0(C12540b1.m75485c(map), new C3406e()).m63381g();
    }

    /* renamed from: G2 */
    public final void m21611G2(boolean z10) {
        C12515a.m75110o().m75172d(new C3409h(z10));
    }

    /* renamed from: I2 */
    public final void m21612I2(String str) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        C13452e c13452eM80781L = C13452e.m80781L();
        linkedHashMap.put("UPID", c13452eM80781L.m80971t0());
        linkedHashMap.put("UDID", c13452eM80781L.m80950o());
        linkedHashMap.put("minor_tag", C13452e.m80781L().m80910f());
        if (!TextUtils.isEmpty(str)) {
            linkedHashMap.put("persona_marketing_status", str);
        }
        linkedHashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
        linkedHashMap.put(MapKeyNames.PACKAGE_NAME, getPackageName());
        C13227f.m79492i1().m79567R("user_consent", linkedHashMap);
        UBAAnalyze.m29958S("PVC", "mecloud_setting_click_personalized_marketing", "1", "4", linkedHashMap);
    }

    /* renamed from: J2 */
    public final void m21613J2(boolean z10, boolean z11) {
        ImageView imageView = this.f15534I;
        if (imageView == null || this.f15535J == null) {
            C11839m.m70686d("MoreSettingActivity", "checkUpdateRightArrow or checkUpdateProgress is null");
        } else {
            imageView.setVisibility(z10 ? 0 : 8);
            this.f15535J.setVisibility(z11 ? 0 : 8);
        }
    }

    /* renamed from: K2 */
    public final void m21614K2(boolean z10, boolean z11) {
        ImageView imageView = this.f15569y;
        if (imageView == null || this.f15570z == null) {
            C11839m.m70686d("MoreSettingActivity", "cleanCacheRightArrow or cleanCacheProgress is null");
        } else {
            imageView.setVisibility(z10 ? 0 : 8);
            this.f15570z.setVisibility(z11 ? 0 : 8);
        }
    }

    /* renamed from: L2 */
    public final void m21615L2() {
        this.f15557f0 = (SpanClickText) C12809f.m76829b(this, R$id.personalization_marketing_content);
        String string = getString(R$string.personalization_marketing_here);
        String string2 = getString(R$string.setting_personalization_marketing_tip, string);
        this.f15557f0.m15931c(string, new C11427b(this, "privacy_statement"));
        this.f15557f0.m15934g(string2, false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15560p);
        arrayList.add(this.f15561q);
        arrayList.add(this.f15562r);
        arrayList.add(this.f15563s);
        return arrayList;
    }

    /* renamed from: f2 */
    public final void m21616f2(Message message) {
        CleanCacheDialog cleanCacheDialog = this.f15548W;
        if (cleanCacheDialog != null) {
            cleanCacheDialog.dismiss();
        }
        C0226l0.m1586f(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.d7
            @Override // java.lang.Runnable
            public final void run() {
                this.f17590a.m21606B2();
            }
        });
        C14317j.m85300d().m85319t();
        BackupNotification.getInstance().cancelBackupNotification();
        RestoreNotification.getInstance().cancelNotification();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        Object obj = message.obj;
        long jM1688f = obj == null ? 0L : C0241z.m1688f(obj.toString());
        if (jM1688f != 0) {
            linkedHashMap.put("deletionTime", String.valueOf(jM1688f));
        }
        C13227f.m79492i1().m79567R("action_code_backup_clean_cache_completed", linkedHashMap);
        UBAAnalyze.m29954O("PVC", "action_code_backup_clean_cache_completed", "1", "79");
        m21608D2(this, false, false);
        m21614K2(true, false);
    }

    /* renamed from: g2 */
    public final void m21617g2() {
        C12515a.m75110o().m75175e(new C3404c(), false);
    }

    /* renamed from: h2 */
    public final void m21618h2() {
        C12515a.m75110o().m75175e(new C3405d(), false);
    }

    /* renamed from: j2 */
    public final void m21619j2() {
        int iM1357g = C0212e0.m1357g(this, "hicloud_persona_marketing_sp", "persona_marketing_status", 1);
        C11839m.m70688i("MoreSettingActivity", "getUserProperties from sp,personalizedMarketingSwitch:" + iM1357g);
        this.f15555d0 = String.valueOf(iM1357g);
        this.f15539N.setChecked(String.valueOf(0).equals(this.f15555d0) ^ true);
        this.f15539N.setOnCheckedChangeListener(this.f15558g0);
        C12515a.m75110o().m75172d(new C3408g());
    }

    /* renamed from: k2 */
    public final void m21620k2(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        try {
            startActivity(intent);
        } catch (Exception unused) {
            C11839m.m70687e("MoreSettingActivity", "handleCollectSites handle intent exception");
        }
    }

    /* renamed from: l2 */
    public final void m21621l2(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        try {
            startActivity(intent);
        } catch (Exception unused) {
            C11839m.m70687e("MoreSettingActivity", "handleSDKSites handle intent exception");
        }
    }

    /* renamed from: m2 */
    public final void m21622m2() {
        if (m21578A2()) {
            this.f15546U.setVisibility(0);
            this.f15547V.setVisibility(0);
        } else {
            this.f15546U.setVisibility(8);
            this.f15547V.setVisibility(8);
        }
    }

    /* renamed from: o2 */
    public final void m21623o2() {
        C11839m.m70688i("MoreSettingActivity", "initCampaignItem");
        if (m21632z2()) {
            C12809f.m76843p(this.f15528C, false);
            C12809f.m76843p(this.f15529D, false);
            return;
        }
        C12809f.m76843p(this.f15528C, true);
        C12809f.m76843p(this.f15529D, true);
        this.f15556e0 = C9718g.m60602t().m60613K(this);
        C11839m.m70688i("MoreSettingActivity", "initCampaignItem isCampaignCenterOpen：" + this.f15556e0);
        if (this.f15556e0) {
            C12809f.m76841n(this.f15530E, getString(R$string.close_campaign_switch));
        } else {
            C12809f.m76841n(this.f15530E, getString(R$string.open_campaign_switch));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        if (C0209d.m1226Y0()) {
            C11839m.m70687e("MoreSettingActivity", "fast click");
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.card_center_item) {
            C13227f.m79492i1().m79585f0("mecloud_voucher_center_click", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_voucher_center_click", "1", "4");
            try {
                SafeIntent safeIntent = new SafeIntent(new Intent());
                safeIntent.setClass(this, CouponCenterActivity.class);
                startActivity(safeIntent);
                return;
            } catch (Exception e10) {
                C11839m.m70687e("MoreSettingActivity", "start CouponCenterActivity exception: " + e10.toString());
                return;
            }
        }
        if (id2 == R$id.clean_cache_item) {
            m21614K2(false, true);
            m21601e2();
            return;
        }
        if (id2 == R$id.push_item) {
            C13227f.m79492i1().m79585f0("mecloud_setting_click_push", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_setting_click_push", "1", "4");
            try {
                SafeIntent safeIntent2 = new SafeIntent(new Intent());
                safeIntent2.setClass(this, PushMarketingNoticeActivity.class);
                startActivity(safeIntent2);
                return;
            } catch (Exception e11) {
                C11839m.m70687e("MoreSettingActivity", "start PushMarketingNoticeActivity exception: " + e11.toString());
                return;
            }
        }
        if (id2 == R$id.check_update_item) {
            if (m21602i2()) {
                return;
            }
            C13227f.m79492i1().m79585f0("mecloud_setting_click_check_upgrade", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_setting_click_check_upgrade", "1", "4");
            C9913h.m61574q().m61600x(this);
            if (C0209d.m1269j1() && C9733f.m60705z().m60721P()) {
                C9908c.m61499D().m61522H(true);
                return;
            } else {
                C9913h.m61574q().m61589P(false);
                return;
            }
        }
        if (id2 == R$id.individualization_item) {
            C13227f.m79492i1().m79585f0("mecloud_setting_click_personalization", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_setting_click_personalization", "1", "4");
            try {
                SafeIntent safeIntent3 = new SafeIntent(new Intent());
                safeIntent3.setClass(this, PersonalizationDetailActivity.class);
                startActivity(safeIntent3);
                return;
            } catch (Exception e12) {
                C11839m.m70687e("MoreSettingActivity", "start personalization exception: " + e12.toString());
                return;
            }
        }
        if (id2 == R$id.about_item) {
            C13227f.m79492i1().m79585f0("mecloud_setting_click_about", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_setting_click_about", "1", "4");
            try {
                SafeIntent safeIntent4 = new SafeIntent(new Intent());
                safeIntent4.setClass(this, AboutActivity.class);
                startActivity(safeIntent4);
                return;
            } catch (Exception e13) {
                C11839m.m70687e("MoreSettingActivity", "start AboutActivity exception: " + e13.toString());
                return;
            }
        }
        if (id2 != R$id.campaign_item) {
            if (id2 == R$id.app_center_item) {
                C13227f.m79492i1().m79591l0("app_center_item_click", new LinkedHashMap());
                UBAAnalyze.m29943D("PVC", "app_center_item_click");
                C12515a.m75110o().m75172d(new C3410i());
                return;
            } else if (id2 == R$id.collection_info_item) {
                C13227f.m79492i1().m79585f0("click_collect_info", C13452e.m80781L().m80971t0());
                UBAAnalyze.m29954O("PVC", "click_collect_info", "1", "100");
                m21617g2();
                return;
            } else {
                if (view.getId() == R$id.hicloud_sdk_item) {
                    C13227f.m79492i1().m79585f0("third_sdk_click_about", C13452e.m80781L().m80971t0());
                    UBAAnalyze.m29954O("PVC", "third_sdk_click_about", "1", "100");
                    m21618h2();
                    return;
                }
                return;
            }
        }
        if (C0209d.m1333z1(this)) {
            C11839m.m70686d("MoreSettingActivity", "click campaign item");
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            List<EntryQuestBean> listM60638r = C9718g.m60602t().m60638r(this);
            int iM60637q = C9718g.m60602t().m60637q(this, listM60638r);
            linkedHashMapM79497A.put("finishedTaskNumber", String.valueOf(listM60638r == null ? 0 : listM60638r.size()));
            linkedHashMapM79497A.put("fragmentNumber", String.valueOf(iM60637q));
            if (this.f15556e0) {
                C13227f.m79492i1().m79567R("mecloud_setting_campaign_close", linkedHashMapM79497A);
                UBAAnalyze.m29954O("PVC", "mecloud_setting_campaign_close", "1", "87");
            } else {
                C13227f.m79492i1().m79567R("mecloud_setting_campaign_open", linkedHashMapM79497A);
                UBAAnalyze.m29954O("PVC", "mecloud_setting_campaign_open", "1", "86");
            }
            C12809f.m76843p(this.f15532G, true);
            C12809f.m76843p(this.f15531F, false);
            m21610F2(!this.f15556e0 ? 1 : 0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        mo13327n1();
        m22365E1(R$string.more_setting_title);
        setContentView(R$layout.activity_more_setting);
        C11829c.m70609q1(this, getWindow());
        m21605y2();
        mo19005p1();
        m21604s2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CleanCacheDialog cleanCacheDialog = this.f15548W;
        if (cleanCacheDialog != null) {
            cleanCacheDialog.dismiss();
            this.f15548W = null;
        }
        Handler handler = this.f15549X;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        m21582M2();
        m21584N2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            C11841o.m70705a();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (C10028c.m62182c0().m62413x()) {
            return;
        }
        finish();
    }

    /* renamed from: p2 */
    public final void m21624p2() {
        LinearLayout linearLayout = this.f15565u;
        if (linearLayout == null) {
            C11839m.m70686d("MoreSettingActivity", "cardCenterDivider is null");
        } else if (this.f15552a0 && (this.f15553b0 || this.f15554c0)) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
    }

    /* renamed from: q2 */
    public final void m21625q2() {
        LinearLayout linearLayout = this.f15526A;
        if (linearLayout == null) {
            C11839m.m70686d("MoreSettingActivity", "cleanCacheDivider is null");
        } else if (this.f15553b0 && this.f15554c0) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
    }

    /* renamed from: r2 */
    public final void m21626r2() {
        if (this.f15566v == null) {
            C11839m.m70686d("MoreSettingActivity", "cleanCacheItem is null");
            return;
        }
        if (CBAccess.isCloudBackupTaskRunning()) {
            this.f15566v.setAlpha(0.62f);
            this.f15566v.setEnabled(false);
        } else {
            this.f15566v.setAlpha(1.0f);
            this.f15566v.setEnabled(true);
        }
        if (C0209d.m1166E1() && C10155f.m63301y() && C10028c.m62182c0().m62413x() && !C0209d.m1293p1()) {
            this.f15553b0 = true;
            this.f15566v.setVisibility(0);
        } else {
            C11839m.m70688i("MoreSettingActivity", "setCleanCacheMenuItem item is dissatisfaction.");
            this.f15553b0 = false;
            this.f15566v.setVisibility(8);
        }
    }

    /* renamed from: t2 */
    public final void m21627t2() {
        if (this.f15564t.getVisibility() == 8 && this.f15566v.getVisibility() == 8 && this.f15527B.getVisibility() == 8) {
            this.f15561q.setVisibility(8);
        } else {
            this.f15561q.setVisibility(0);
        }
    }

    /* renamed from: u2 */
    public final void m21628u2() {
        if (this.f15537L == null || this.f15540O == null) {
            C11839m.m70686d("MoreSettingActivity", "personaMarketingStatus or individualizationMarketingDivider is null");
            return;
        }
        if (!C11829c.m70620u0(this) || C13452e.m80781L().m80795D0()) {
            this.f15537L.setVisibility(8);
            this.f15538M.setVisibility(8);
        } else {
            m21615L2();
            this.f15537L.setVisibility(0);
            this.f15538M.setVisibility(0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        C11841o.m70705a();
        return super.mo13429v1(i10, keyEvent);
    }

    /* renamed from: v2 */
    public final void m21629v2() {
        if (this.f15536K == null || this.f15540O == null) {
            C11839m.m70686d("MoreSettingActivity", "individualizationItem or individualizationDivider is null");
            return;
        }
        if (!C10028c.m62182c0().m62413x() || C0209d.m1293p1() || !C13452e.m80781L().m80803F0().booleanValue() || C13452e.m80781L().m80795D0()) {
            this.f15536K.setVisibility(8);
            this.f15540O.setVisibility(8);
        } else {
            this.f15536K.setVisibility(0);
            this.f15540O.setVisibility(0);
        }
    }

    /* renamed from: w2 */
    public final void m21630w2() {
        if (this.f15527B == null) {
            C11839m.m70686d("MoreSettingActivity", "pushItem is null");
            return;
        }
        if (!C13452e.m80781L().m80803F0().booleanValue() && C0209d.m1166E1()) {
            this.f15554c0 = true;
            this.f15527B.setVisibility(0);
        } else {
            C11839m.m70688i("MoreSettingActivity", "initPushMenuItem item is dissatisfaction.");
            this.f15554c0 = false;
            this.f15527B.setVisibility(8);
        }
    }

    /* renamed from: x2 */
    public final void m21631x2() {
        if (this.f15564t == null) {
            C11839m.m70686d("MoreSettingActivity", "cardCenterItem is null");
        } else if (C2783d.m16139f0()) {
            this.f15552a0 = true;
            this.f15564t.setVisibility(0);
        } else {
            this.f15552a0 = false;
            this.f15564t.setVisibility(8);
        }
    }

    /* renamed from: z2 */
    public boolean m21632z2() {
        if (C0209d.m1293p1()) {
            NotifyLogger.m29916w("MoreSettingActivity", "isHideCampaignItem is InkScreen!");
            return true;
        }
        if (!C0209d.m1166E1()) {
            NotifyLogger.m29916w("MoreSettingActivity", "isHideCampaignItem is not owner user!");
            return true;
        }
        if (CampaignCheckUtil.isSilenceUser()) {
            NotifyLogger.m29916w("MoreSettingActivity", "isHideCampaignItem is silent user!");
            return true;
        }
        if (!C9718g.m60602t().m60611I(this)) {
            C11839m.m70688i("MoreSettingActivity", "isHideCampaignItem showSettingFlag is no or child account, not show campaign");
            return true;
        }
        if (!C10028c.m62182c0().m62413x()) {
            NotifyLogger.m29916w("MoreSettingActivity", "isHideCampaignItem function switch is false!");
            return true;
        }
        if (!C9718g.m60602t().m60606D(this)) {
            return false;
        }
        NotifyLogger.m29916w("MoreSettingActivity", "isHideCampaignItem activity finished!");
        return true;
    }
}
