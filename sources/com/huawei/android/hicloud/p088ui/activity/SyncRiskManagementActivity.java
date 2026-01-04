package com.huawei.android.hicloud.p088ui.activity;

import android.accounts.OperationCanceledException;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.p088ui.notification.BackupNotificationManager;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.RiskConfirmDialog;
import com.huawei.android.hicloud.sync.syncutil.C2987p;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.manager.HNCloudConfig;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.operator.SpaceNotifyContentOperator;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import p015ak.C0209d;
import p015ak.C0213f;
import p020ap.C1008c;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p335hd.C10148k;
import p514o9.C11836j;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12368e;
import p616rk.C12515a;
import p681uj.C13195l;
import p684un.C13223b;
import p709vj.C13452e;
import p709vj.InterfaceC13449b;
import p709vj.InterfaceC13450c;
import p742wj.C13612b;
import p783xp.C13843a;
import sk.C12809f;
import tj.C13019a;

/* loaded from: classes3.dex */
public class SyncRiskManagementActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: A */
    public HwButton f16126A;

    /* renamed from: B */
    public HwButton f16127B;

    /* renamed from: p */
    public NoticeContent f16128p;

    /* renamed from: q */
    public NoticeContent f16129q;

    /* renamed from: r */
    public NoticeContent f16130r;

    /* renamed from: s */
    public ProgressDialog f16131s;

    /* renamed from: t */
    public RiskConfirmDialog f16132t;

    /* renamed from: u */
    public String f16133u;

    /* renamed from: v */
    public String f16134v;

    /* renamed from: w */
    public Context f16135w;

    /* renamed from: x */
    public C3503l f16136x = new C3503l();

    /* renamed from: y */
    public Handler f16137y = new HandlerC3492a();

    /* renamed from: z */
    public Handler f16138z = new HandlerC3493b();

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncRiskManagementActivity$a */
    public class HandlerC3492a extends Handler {
        public HandlerC3492a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (SyncRiskManagementActivity.this.isFinishing()) {
                C11839m.m70686d("SyncRiskManagementActivity", "mSyncHandler, is finished");
                return;
            }
            SyncRiskManagementActivity.this.m22341c2();
            if (message.what == 0) {
                SyncRiskManagementActivity.this.m22342f2();
            } else {
                C11839m.m70687e("SyncRiskManagementActivity", "RiskDataProcessTask failed, finish");
                SyncRiskManagementActivity.this.finish();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncRiskManagementActivity$b */
    public class HandlerC3493b extends Handler {
        public HandlerC3493b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (SyncRiskManagementActivity.this.isFinishing()) {
                C11839m.m70686d("SyncRiskManagementActivity", "mHandler, activity is finished");
                return;
            }
            int i10 = message.what;
            if (i10 == 2) {
                SyncRiskManagementActivity.this.m22346b2();
                return;
            }
            if (i10 == 3) {
                C13612b c13612bM81829B = C13612b.m81829B();
                SyncRiskManagementActivity syncRiskManagementActivity = SyncRiskManagementActivity.this;
                c13612bM81829B.m81858X(syncRiskManagementActivity, new C3499h(syncRiskManagementActivity, null));
            } else {
                if (i10 == 4) {
                    SyncRiskManagementActivity.this.m22352l2();
                    return;
                }
                if (i10 != 5) {
                    if (i10 == 6) {
                        SyncRiskManagementActivity.this.m22341c2();
                        return;
                    }
                    C11839m.m70689w("SyncRiskManagementActivity", "msg:" + message.what);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncRiskManagementActivity$c */
    public class RunnableC3494c implements Runnable {
        public RunnableC3494c() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            SyncRiskManagementActivity.this.finish();
            new HwAnimationReflection(SyncRiskManagementActivity.this.f16135w).m15927c(2);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncRiskManagementActivity$d */
    public class C3495d extends AbstractC12368e {
        public C3495d() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13612b c13612bM81829B = C13612b.m81829B();
            SyncRiskManagementActivity syncRiskManagementActivity = SyncRiskManagementActivity.this;
            c13612bM81829B.m81856U(syncRiskManagementActivity, new C3502k(syncRiskManagementActivity, null));
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncRiskManagementActivity$e */
    public class RunnableC3496e implements Runnable {
        public RunnableC3496e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int measuredWidth = SyncRiskManagementActivity.this.f16126A.getMeasuredWidth();
            int measuredWidth2 = SyncRiskManagementActivity.this.f16127B.getMeasuredWidth();
            if (measuredWidth <= 0 || measuredWidth2 <= 0) {
                return;
            }
            if (measuredWidth > measuredWidth2) {
                ViewGroup.LayoutParams layoutParams = SyncRiskManagementActivity.this.f16127B.getLayoutParams();
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams2.width = measuredWidth;
                    SyncRiskManagementActivity.this.f16127B.setLayoutParams(layoutParams2);
                    return;
                }
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = SyncRiskManagementActivity.this.f16126A.getLayoutParams();
            if (layoutParams3 instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                layoutParams4.width = measuredWidth2;
                SyncRiskManagementActivity.this.f16126A.setLayoutParams(layoutParams4);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncRiskManagementActivity$f */
    public class DialogInterfaceOnClickListenerC3497f implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3497f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C11839m.m70688i("SyncRiskManagementActivity", "NotMyAccount clicked");
            dialogInterface.cancel();
            if (i10 != -1) {
                C11839m.m70688i("SyncRiskManagementActivity", "NotMyAccount later");
                SyncRiskManagementActivity.this.finish();
                return;
            }
            C11839m.m70688i("SyncRiskManagementActivity", "NotMyAccount jumpToAccount");
            if (new Intent("com.huawei.hwid.ACTION_MAIN_SETTINGS").resolveActivity(SyncRiskManagementActivity.this.getPackageManager()) != null) {
                SyncRiskManagementActivity syncRiskManagementActivity = SyncRiskManagementActivity.this;
                syncRiskManagementActivity.m22343g2(syncRiskManagementActivity);
            } else {
                SyncRiskManagementActivity syncRiskManagementActivity2 = SyncRiskManagementActivity.this;
                Toast.makeText(syncRiskManagementActivity2, syncRiskManagementActivity2.getString(R$string.unable_enter_account_tips_20160202), 0).show();
            }
        }

        public /* synthetic */ DialogInterfaceOnClickListenerC3497f(SyncRiskManagementActivity syncRiskManagementActivity, HandlerC3492a handlerC3492a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncRiskManagementActivity$g */
    public static class C3498g extends AbstractC12368e {
        public C3498g() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70688i("SyncRiskManagementActivity", "NotifyLoginSuccessProcessTask run...");
            if (C0213f.m1377a() == null) {
                C11839m.m70687e("SyncRiskManagementActivity", "AppConfig.getContext() is null");
                return;
            }
            Bundle bundleM81840C = C13612b.m81829B().m81840C();
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a == null) {
                C11839m.m70688i("SyncRiskManagementActivity", "cloudAlbumRouterImpl is null");
            } else {
                interfaceC9282a.mo58448p0(C0213f.m1377a(), bundleM81840C);
                C12515a.m75110o().m75175e(new C10148k(C0213f.m1377a(), "login"), true);
            }
        }

        public /* synthetic */ C3498g(HandlerC3492a handlerC3492a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncRiskManagementActivity$h */
    public class C3499h implements InterfaceC13449b {
        public C3499h() {
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: L */
        public void mo13808L(Exception exc) {
            C11839m.m70686d("SyncRiskManagementActivity", "PWDCheckHandler, authFailed");
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: Q */
        public boolean mo13814Q(Bundle bundle) {
            C11839m.m70686d("SyncRiskManagementActivity", "PWDCheckHandler, activatePhoneFinder");
            return false;
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: W */
        public void mo13820W(Bundle bundle) {
            C11839m.m70688i("SyncRiskManagementActivity", "PWDCheckHandler, authTokenSuccess");
            SyncRiskManagementActivity.this.f16138z.sendEmptyMessage(4);
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: e */
        public void mo13829e(OperationCanceledException operationCanceledException) {
            C11839m.m70686d("SyncRiskManagementActivity", "PWDCheckHandler, authCanceled");
            SyncRiskManagementActivity.this.f16138z.sendEmptyMessage(5);
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: m0 */
        public void mo13838m0(Bundle bundle) {
        }

        public /* synthetic */ C3499h(SyncRiskManagementActivity syncRiskManagementActivity, HandlerC3492a handlerC3492a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncRiskManagementActivity$i */
    public class DialogInterfaceOnClickListenerC3500i implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3500i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C11839m.m70688i("SyncRiskManagementActivity", "Reconfirm clicked");
            dialogInterface.cancel();
            if (i10 == -1) {
                C13223b.m79473a(SyncRiskManagementActivity.this, "risk_click_stop_sync", "1");
                UBAAnalyze.m29954O("PVC", "risk_click_stop_sync", "1", "29");
                SyncRiskManagementActivity.this.m22347d2(2);
            } else {
                C13223b.m79473a(SyncRiskManagementActivity.this, "risk_click_continue_sync", "1");
                UBAAnalyze.m29954O("PVC", "risk_click_continue_sync", "1", "29");
                SyncRiskManagementActivity.this.m22347d2(1);
            }
        }

        public /* synthetic */ DialogInterfaceOnClickListenerC3500i(SyncRiskManagementActivity syncRiskManagementActivity, HandlerC3492a handlerC3492a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncRiskManagementActivity$j */
    public class C3501j extends AbstractC12368e {
        public C3501j() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70688i("SyncRiskManagementActivity", "RiskDataProcessTask run...");
            SyncRiskManagementActivity.this.f16128p = C2987p.m17952b(4);
            SyncRiskManagementActivity.this.f16129q = C2987p.m17952b(5);
            SyncRiskManagementActivity.this.f16130r = C2987p.m17952b(6);
            if (SyncRiskManagementActivity.this.f16129q == null || SyncRiskManagementActivity.this.f16128p == null || SyncRiskManagementActivity.this.f16130r == null) {
                SyncRiskManagementActivity.this.m22350i2();
                SyncRiskManagementActivity.this.f16128p = C2987p.m17952b(4);
                SyncRiskManagementActivity.this.f16129q = C2987p.m17952b(5);
                SyncRiskManagementActivity.this.f16130r = C2987p.m17952b(6);
            }
            if (SyncRiskManagementActivity.this.f16129q != null && SyncRiskManagementActivity.this.f16128p != null && SyncRiskManagementActivity.this.f16130r != null) {
                SyncRiskManagementActivity.this.f16137y.sendEmptyMessage(0);
            } else {
                C11839m.m70687e("SyncRiskManagementActivity", "RiskDataProcessTask getNoticeContent null.");
                SyncRiskManagementActivity.this.f16137y.sendEmptyMessage(1);
            }
        }

        public /* synthetic */ C3501j(SyncRiskManagementActivity syncRiskManagementActivity, HandlerC3492a handlerC3492a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncRiskManagementActivity$k */
    public class C3502k implements InterfaceC13449b {
        public C3502k() {
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: L */
        public void mo13808L(Exception exc) {
            C11839m.m70686d("SyncRiskManagementActivity", "authFailed");
            SyncRiskManagementActivity.this.f16138z.sendEmptyMessage(6);
            SyncRiskManagementActivity.this.f16138z.sendEmptyMessage(3);
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: Q */
        public boolean mo13814Q(Bundle bundle) {
            C11839m.m70686d("SyncRiskManagementActivity", "activatePhoneFinder");
            return false;
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: W */
        public void mo13820W(Bundle bundle) {
            C11839m.m70686d("SyncRiskManagementActivity", "authTokenSuccess");
            SyncRiskManagementActivity.this.f16138z.sendEmptyMessage(6);
            SyncRiskManagementActivity.this.f16138z.sendEmptyMessage(2);
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: e */
        public void mo13829e(OperationCanceledException operationCanceledException) {
            C11839m.m70686d("SyncRiskManagementActivity", "authCanceled");
            SyncRiskManagementActivity.this.f16138z.sendEmptyMessage(6);
            SyncRiskManagementActivity.this.f16138z.sendEmptyMessage(2);
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: m0 */
        public void mo13838m0(Bundle bundle) {
        }

        public /* synthetic */ C3502k(SyncRiskManagementActivity syncRiskManagementActivity, HandlerC3492a handlerC3492a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncRiskManagementActivity$l */
    public class C3503l implements InterfaceC13450c {
        public C3503l() {
        }

        @Override // p709vj.InterfaceC13450c
        /* renamed from: a */
        public void mo20330a(ErrorStatus errorStatus) {
            C11839m.m70687e("SyncRiskManagementActivity", "check password onError");
            SyncRiskManagementActivity.this.f16138z.sendEmptyMessage(5);
        }

        @Override // p709vj.InterfaceC13450c
        /* renamed from: b */
        public void mo20331b() {
            C11839m.m70688i("SyncRiskManagementActivity", "check password onFinish");
            SyncRiskManagementActivity.this.f16138z.sendEmptyMessage(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c2 */
    public void m22341c2() {
        ProgressDialog progressDialog = this.f16131s;
        if (progressDialog != null) {
            progressDialog.cancel();
            this.f16131s = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f2 */
    public void m22342f2() {
        C11839m.m70686d("SyncRiskManagementActivity", "initView");
        TextView textView = (TextView) C12809f.m76829b(this, R$id.sync_confirm_text);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.sync_confirm_des);
        HwButton hwButton = (HwButton) C12809f.m76829b(this, R$id.sync_btn);
        this.f16126A = hwButton;
        hwButton.setOnClickListener(this);
        C11842p.m70874v1(this, this.f16126A);
        HwButton hwButton2 = (HwButton) C12809f.m76829b(this, R$id.cancel_btn);
        this.f16127B = hwButton2;
        hwButton2.setOnClickListener(this);
        C11842p.m70874v1(this, this.f16127B);
        NoticeContent noticeContent = this.f16128p;
        if (noticeContent != null && !TextUtils.isEmpty(noticeContent.getTitle()) && !TextUtils.isEmpty(this.f16128p.getMainText()) && !TextUtils.isEmpty(this.f16128p.getSubTitle())) {
            String strM80841P = C13452e.m80781L().m80841P();
            String mainText = this.f16128p.getMainText();
            m22344k2(this.f16128p.getTitle());
            textView.setText(mainText.replace("%1$s", strM80841P));
            textView2.setText(this.f16128p.getSubTitle());
        }
        m22349h2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g2 */
    public void m22343g2(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("com.huawei.hwid.ACTION_MAIN_SETTINGS");
        C0209d.m1302r2(intent, "com.huawei.hwid");
        intent.putExtra(FaqConstants.FAQ_CHANNEL, 15000000);
        try {
            activity.startActivity(intent);
            finish();
        } catch (Exception unused) {
            C11839m.m70687e("SyncRiskManagementActivity", "jumpToAccount fail");
        }
    }

    /* renamed from: k2 */
    private void m22344k2(String str) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            if (TextUtils.isEmpty(str)) {
                actionBar.setTitle(R$string.hisync_name);
            } else {
                actionBar.setTitle(str);
            }
        }
    }

    /* renamed from: m2 */
    private void m22345m2() {
        if (this.f16131s == null) {
            this.f16131s = new ProgressDialog(this);
        }
        this.f16131s.setMessage(getResources().getString(R$string.wait_loging));
        this.f16131s.setCancelable(false);
        this.f16131s.show();
    }

    /* renamed from: b2 */
    public final void m22346b2() {
        C11839m.m70688i("SyncRiskManagementActivity", "checkPwd");
        C13195l.m79272J().m79324o(this, C13452e.m80781L().m80905e(), 8901, this.f16136x);
    }

    /* renamed from: d2 */
    public final void m22347d2(int i10) {
        C11839m.m70688i("SyncRiskManagementActivity", "endProcess, jumpType:" + i10 + " syncType: " + this.f16133u);
        C1008c.m6035v().m6080j(this, this.f16133u, "", i10);
        m22351j2();
        C12515a.m75110o().m75172d(new C3498g(null));
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.putExtra("risk_jump_type_key", i10);
        intent.putExtra("risk_sync_type_key", this.f16133u);
        startActivity(intent);
        finish();
    }

    /* renamed from: e2 */
    public void m22348e2() {
        C11839m.m70686d("SyncRiskManagementActivity", "exitAPP");
        C13019a.m78347n().m78354q(this);
        new Handler().postDelayed(new RunnableC3494c(), 200L);
        C13019a.m78347n().m78355r();
    }

    /* renamed from: h2 */
    public final void m22349h2() {
        this.f16126A.post(new RunnableC3496e());
    }

    /* renamed from: i2 */
    public final void m22350i2() {
        C11839m.m70688i("SyncRiskManagementActivity", "RiskDataProcessTask parseSyncRiskTwice");
        HNCloudConfig hNCloudConfig = new HNCloudConfig();
        NotificationConfig configFromFile = hNCloudConfig.getConfigFromFile();
        if (configFromFile == null) {
            C11839m.m70687e("SyncRiskManagementActivity", "extractConfig failed, fullConfig is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        hNCloudConfig.parseRiskCfg(configFromFile.getHiCloudRiskRule(), arrayList);
        new SpaceNotifyContentOperator().insertContent(arrayList);
    }

    /* renamed from: j2 */
    public final void m22351j2() {
        if (C0213f.m1377a() == null) {
            C11839m.m70687e("SyncRiskManagementActivity", "removeSyncRiskFlag AppConfig.getContext() is null");
            return;
        }
        C10028c.m62183d0(C0213f.m1377a()).m62197C2("sync_risk_notify_time", 0L);
        C10028c.m62183d0(C0213f.m1377a()).m62197C2("sync_risk_desktop_notify_time", 0L);
        new BackupNotificationManager(C0213f.m1377a()).cancelNotification(277);
        C11839m.m70688i("SyncRiskManagementActivity", "Storage syncRiskFixed");
    }

    /* renamed from: l2 */
    public final void m22352l2() {
        C11839m.m70686d("SyncRiskManagementActivity", "showReconfirmDialog");
        NoticeContent noticeContent = this.f16130r;
        if (noticeContent == null || TextUtils.isEmpty(noticeContent.getMainText()) || TextUtils.isEmpty(this.f16130r.getButtonFirst()) || TextUtils.isEmpty(this.f16130r.getButtonSecond())) {
            C11839m.m70687e("SyncRiskManagementActivity", "ncReconfirm null");
            return;
        }
        if (this.f16132t == null) {
            this.f16132t = new RiskConfirmDialog(this);
        }
        this.f16132t.show("", this.f16130r.getMainText(), this.f16130r.getButtonFirst(), this.f16130r.getButtonSecond(), new DialogInterfaceOnClickListenerC3500i(this, null));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 8701) {
            C13195l.m79272J().m79299O(this, new C3502k(this, null), i10, i11, intent);
        } else if (i10 == 8901) {
            C13195l.m79272J().m79297M(this, this.f16136x, i11, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        C11839m.m70686d("SyncRiskManagementActivity", "onBackPressed");
        m22348e2();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.sync_btn) {
            C11839m.m70688i("SyncRiskManagementActivity", "onClick sync_btn");
            m22345m2();
            C13223b.m79473a(this, "risk_click_verify", "1");
            UBAAnalyze.m29954O("PVC", "risk_click_verify", "1", "38");
            C12515a.m75110o().m75172d(new C3495d());
            return;
        }
        if (view.getId() == R$id.cancel_btn) {
            C11839m.m70688i("SyncRiskManagementActivity", "onClick cancel_btn");
            C13223b.m79473a(this, "risk_click_not_my_account", "1");
            UBAAnalyze.m29954O("PVC", "risk_click_not_my_account", "1", "38");
            NoticeContent noticeContent = this.f16129q;
            if (noticeContent == null || TextUtils.isEmpty(noticeContent.getMainText())) {
                C11839m.m70687e("SyncRiskManagementActivity", "ncNotMyAccount null");
                return;
            }
            String strM80841P = C13452e.m80781L().m80841P();
            if (this.f16132t == null) {
                this.f16132t = new RiskConfirmDialog(this);
            }
            this.f16132t.show(this.f16129q.getTitle(), this.f16129q.getMainText().replace("%1$s", strM80841P), getString(R$string.risk_sync_later), getString(R$string.risk_sync_jump_hwid), new DialogInterfaceOnClickListenerC3497f(this, null));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setContentView(R$layout.sync_risk_management);
        m22342f2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        setContentView(R$layout.sync_risk_management);
        this.f16135w = this;
        String[] strArrSplit = C13452e.m80781L().m80967s0().split("_");
        if (strArrSplit.length == 1) {
            this.f16133u = strArrSplit[0];
            this.f16134v = "";
        } else if (strArrSplit.length > 1) {
            this.f16133u = strArrSplit[0];
            this.f16134v = strArrSplit[1];
        }
        if (TextUtils.isEmpty(this.f16133u)) {
            C11839m.m70689w("SyncRiskManagementActivity", "syncType null, go to MainActivity");
            m22347d2(0);
        } else {
            C12515a.m75110o().m75172d(new C3501j(this, null));
            m22345m2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C11842p.m70836m(this);
        super.onDestroy();
        C11836j.m70658k().m70663e();
        m22341c2();
        RiskConfirmDialog riskConfirmDialog = this.f16132t;
        if (riskConfirmDialog != null) {
            riskConfirmDialog.cancel();
            this.f16132t = null;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            m22348e2();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
