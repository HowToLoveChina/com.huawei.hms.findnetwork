package com.huawei.android.hicloud.p088ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.report.MobileTrafficReport;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudbackup.util.BackupNewBmTypeUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.notification.BackupNotification;
import com.huawei.android.hicloud.p088ui.temporarybackup.C4012a;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupCheckActivity;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.MobileNetTipDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.TempDoubleBtnDialog;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$string;
import com.huawei.feedback.FeedbackMailProcessor;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.base.view.widget.HiCloudAutoSizeButton;
import com.huawei.hicloud.notification.spacelanguage.util.SpaceMultLanguageUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwprogressbar.widget.HwProgressBar;
import fk.C9721b;
import gp.C10028c;
import id.C10469c;
import id.C10470d;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import je.C10782d;
import om.C11963c;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p211d.C8968a;
import p514o9.C11839m;
import p514o9.C11842p;
import p618rm.C12591s1;
import p618rm.C12600v1;
import p664u0.C13108a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p711vl.C13467g;
import p847zk.C14317j;
import sk.C12809f;
import tl.C13029h;
import tl.C13030i;

/* loaded from: classes3.dex */
public class CloudBackupStateActivity extends HMSTermsProcessBaseActivity {

    /* renamed from: A */
    public HiCloudAutoSizeButton f14131A;

    /* renamed from: B */
    public ProgressDialog f14132B;

    /* renamed from: C */
    public AlertDialog f14133C;

    /* renamed from: D */
    public HiCloudAutoSizeButton f14134D;

    /* renamed from: E */
    public RelativeLayout f14135E;

    /* renamed from: F */
    public LinearLayout f14136F;

    /* renamed from: G */
    public HiCloudAutoSizeButton f14137G;

    /* renamed from: H */
    public HiCloudAutoSizeButton f14138H;

    /* renamed from: I */
    public HiCloudAutoSizeButton f14139I;

    /* renamed from: J */
    public HiCloudAutoSizeButton f14140J;

    /* renamed from: K */
    public HiCloudAutoSizeButton f14141K;

    /* renamed from: L */
    public HiCloudAutoSizeButton f14142L;

    /* renamed from: M */
    public NetWorkChangeReceiver f14143M;

    /* renamed from: P */
    public boolean f14146P;

    /* renamed from: R */
    public long f14148R;

    /* renamed from: T */
    public String f14150T;

    /* renamed from: U */
    public boolean f14151U;

    /* renamed from: W */
    public AlertDialog f14153W;

    /* renamed from: q */
    public CloudBackupState f14158q;

    /* renamed from: r */
    public CloudBackupState f14159r;

    /* renamed from: s */
    public MobileNetTipDialog f14160s;

    /* renamed from: t */
    public boolean f14161t;

    /* renamed from: u */
    public TextView f14162u;

    /* renamed from: v */
    public RelativeLayout f14163v;

    /* renamed from: w */
    public HwProgressBar f14164w;

    /* renamed from: x */
    public HwProgressBar f14165x;

    /* renamed from: y */
    public LinearLayout f14166y;

    /* renamed from: z */
    public LinearLayout f14167z;

    /* renamed from: p */
    public final Handler f14157p = new HandlerC3199d(this, null);

    /* renamed from: N */
    public LocalReceiver f14144N = null;

    /* renamed from: O */
    public boolean f14145O = false;

    /* renamed from: Q */
    public boolean f14147Q = false;

    /* renamed from: S */
    public boolean f14149S = false;

    /* renamed from: V */
    public boolean f14152V = false;

    /* renamed from: X */
    public MobileNetTipDialog.MobileNetTipClickListener f14154X = new MobileNetTipDialog.MobileNetTipClickListener() { // from class: com.huawei.android.hicloud.ui.activity.x2
        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.MobileNetTipDialog.MobileNetTipClickListener, android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i10) {
            this.f17798a.m19626y2(dialogInterface, i10);
        }
    };

    /* renamed from: Y */
    public View.OnClickListener f14155Y = new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.y2
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f17816a.m19597B2(view);
        }
    };

    /* renamed from: Z */
    public final Handler.Callback f14156Z = new C3197b();

    public class LocalReceiver extends BroadcastReceiver {
        public LocalReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C11839m.m70688i("CloudBackupStateActivity", "LocalReceiver intent null");
                return;
            }
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            String action = hiCloudSafeIntent.getAction();
            C11839m.m70686d("CloudBackupStateActivity", "onReceive: " + action);
            if ("com.huawei.android.hicloud.sendmessage".equals(action)) {
                FeedbackMailProcessor.getInstance().jumpToMailView(context, hiCloudSafeIntent.getStringExtra("accessoryName"), C10028c.m62182c0().m62237L());
                return;
            }
            if (!"com.huawei.hicloud.intent.action.ACTION_PAY_SUCCESS".equals(action)) {
                if (TextUtils.equals("com.huawei.hicloud.intent.action.ACTION_GRADE_CODE_PUSH", action)) {
                    C11839m.m70688i("CloudBackupStateActivity", "receive grade change");
                    CloudBackupStateActivity.this.mo18741K2(false);
                    return;
                }
                return;
            }
            C11839m.m70688i("CloudBackupStateActivity", "receive action pay success");
            CloudBackupStateActivity.this.m19603L2("paySuccess");
            CloudBackupStateActivity.this.m19613d2();
            CloudBackupState cloudBackupState = CloudBackupStateActivity.this.f14158q;
            if (cloudBackupState != null && 3001 == cloudBackupState.getReturnCode()) {
                CloudBackupStateActivity.this.f14147Q = true;
            }
            CloudBackupStateActivity.this.mo18741K2(false);
            Bundle bundleExtra = hiCloudSafeIntent.getBundleExtra("pay_success_backup_freq_bundle_key");
            if (bundleExtra == null) {
                if ("com.huawei.hicloud.intent.action.ACTION_SPACE_ENOUGH".equals(action)) {
                    C11839m.m70688i("CloudBackupStateActivity", "receive space enough");
                    CloudBackupState cloudBackupState2 = CloudBackupStateActivity.this.f14158q;
                    if (cloudBackupState2 == null || 3001 != cloudBackupState2.getReturnCode()) {
                        return;
                    }
                    CloudBackupStateActivity.this.f14158q.setReturnCode(1001);
                    CloudBackupStateActivity.this.mo18794f3();
                    return;
                }
                return;
            }
            int i10 = bundleExtra.getInt("pay_success_chosen_backup_frequency", 0);
            String string = bundleExtra.getString("pay_success_current_grade_code");
            C11839m.m70688i("CloudBackupStateActivity", "targetFrequency: " + i10 + ", currentGradeCode: " + string);
            if (i10 == 0 || TextUtils.isEmpty(string) || CloudBackupUtil.getGradeMinFrequency(string) != i10) {
                return;
            }
            C11839m.m70688i("CloudBackupStateActivity", "pay success, save chosen frequency: " + i10);
            C13467g.m81086c().m81098m(i10);
            Message message = new Message();
            message.what = 33016;
            CBCallBack.getInstance().sendMessage(message);
            LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C.put("gradeCode", string);
            linkedHashMapM79499C.put("backup_frequency", Integer.valueOf(i10));
            C13225d.m79490f1().m79567R("auto_backup_frequency_selected", linkedHashMapM79499C);
            UBAAnalyze.m29947H("CKC", "auto_backup_frequency_selected", linkedHashMapM79499C);
        }
    }

    public class NetWorkChangeReceiver extends BroadcastReceiver {
        public NetWorkChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            TextView textView;
            if (intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(new SafeIntent(intent).getAction())) {
                CloudBackupStateActivity.this.mo18820p2();
                if (!C0209d.m1254f2(context) && CBAccess.isAppDataPreparing()) {
                    C11839m.m70688i("CloudBackupStateActivity", "receive netword disconnect while prepare data");
                    return;
                }
                if (C10782d.m65634a().m65645l() && (textView = CloudBackupStateActivity.this.f14162u) != null) {
                    textView.setVisibility(8);
                    return;
                }
                boolean zM65642i = C10782d.m65634a().m65642i(context);
                boolean zM19624v2 = CloudBackupStateActivity.this.m19624v2();
                if (zM65642i) {
                    CloudBackupStateActivity.this.f14162u.setVisibility(8);
                    return;
                }
                TextView textView2 = CloudBackupStateActivity.this.f14162u;
                if (textView2 != null) {
                    textView2.setVisibility(zM19624v2 ? 0 : 8);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupStateActivity$a */
    public class C3196a implements TempDoubleBtnDialog.BtnCallBack {
        public C3196a() {
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.TempDoubleBtnDialog.BtnCallBack
        public void btnLeftCallBack() {
            if (CloudBackupService.getInstance().cancelTempBackup("delete_single_from_view_user_cancel")) {
                if (CBAccess.hasValidTempBackup()) {
                    C11839m.m70689w("CloudBackupStateActivity", "cancel failed, has valid temp backup");
                    C4012a.m24631O("event_id_cancel_temp_backup_dialog", "cancel temp backup failed", "CloudBackupStateActivity");
                    CloudBackupStateActivity.this.finish();
                    return;
                }
                C4012a.m24631O("event_id_cancel_temp_backup_dialog", "cancel temp backup", "CloudBackupStateActivity");
                try {
                    SafeIntent safeIntent = new SafeIntent(new Intent());
                    safeIntent.setClass(CloudBackupStateActivity.this, TempBackupCheckActivity.class);
                    CloudBackupStateActivity.this.startActivity(safeIntent);
                    CloudBackupStateActivity.this.finish();
                } catch (Exception e10) {
                    C11839m.m70687e("CloudBackupStateActivity", "start TempBackupCheckActivity exception: " + e10.getMessage());
                }
            }
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.TempDoubleBtnDialog.BtnCallBack
        public void btnRightCallBack() {
            CloudBackupStateActivity.this.m19615i2();
            super.btnRightCallBack();
            C4012a.m24631O("event_id_cancel_temp_backup_dialog", "dismiss dialog", "CloudBackupStateActivity");
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupStateActivity$b */
    public class C3197b implements Handler.Callback {
        public C3197b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 33031) {
                C11839m.m70686d("CloudBackupStateActivity", "cancel refurbish response.");
                CloudBackupStateActivity.this.f14132B.dismiss();
                CloudBackupStateActivity.this.mo18790e2();
                return false;
            }
            if (i10 == 33032 && CloudBackupStateActivity.this.f14149S) {
                C11839m.m70686d("CloudBackupStateActivity", "refurbish finish detail response.");
                CloudBackupStateActivity.this.finish();
                return false;
            }
            if (i10 != 33046 || !CloudBackupStateActivity.this.mo18836w2()) {
                return false;
            }
            C11839m.m70686d("CloudBackupStateActivity", "temp backup cancel finish detail.");
            CloudBackupStateActivity.this.finish();
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupStateActivity$c */
    public class DialogInterfaceOnClickListenerC3198c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3198c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -2) {
                C11839m.m70688i("CloudBackupStateActivity", "cancel backup click negative button.");
                CloudBackupStateActivity.this.f14133C.dismiss();
            } else if (i10 == -1) {
                C11839m.m70688i("CloudBackupStateActivity", "cancel backup click positive button.");
                CloudBackupStateActivity cloudBackupStateActivity = CloudBackupStateActivity.this;
                cloudBackupStateActivity.f14132B = ProgressDialog.show(cloudBackupStateActivity, "", cloudBackupStateActivity.getString(R$string.canceling_cloudbackup), true, false);
                CloudBackupStateActivity.this.f14132B.show();
                CloudBackupService.getInstance().cancelRefurbish();
            }
        }

        public /* synthetic */ DialogInterfaceOnClickListenerC3198c(CloudBackupStateActivity cloudBackupStateActivity, C3196a c3196a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupStateActivity$d */
    public static class HandlerC3199d extends Handler {

        /* renamed from: a */
        public final WeakReference<CloudBackupStateActivity> f14173a;

        public /* synthetic */ HandlerC3199d(CloudBackupStateActivity cloudBackupStateActivity, C3196a c3196a) {
            this(cloudBackupStateActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CloudBackupStateActivity cloudBackupStateActivity = this.f14173a.get();
            if (CloudBackupStateActivity.m19593f2(cloudBackupStateActivity)) {
                return;
            }
            int i10 = message.what;
            if (i10 == 33428) {
                if (cloudBackupStateActivity.mo18836w2()) {
                    return;
                }
                cloudBackupStateActivity.m19611X2(message);
            } else if (i10 == 33429) {
                if (cloudBackupStateActivity.mo18836w2()) {
                    cloudBackupStateActivity.m19611X2(message);
                }
            } else {
                C11839m.m70687e("CloudBackupStateActivity", "cloudBackupHandler invalid message :" + message.what);
            }
        }

        public HandlerC3199d(CloudBackupStateActivity cloudBackupStateActivity) {
            this.f14173a = new WeakReference<>(cloudBackupStateActivity);
        }
    }

    /* renamed from: A2 */
    public static /* synthetic */ void m19575A2() {
        BackupNotification.getInstance().sendTempPauseNotification(true);
    }

    /* renamed from: E2 */
    public static /* synthetic */ void m19576E2(DialogInterface dialogInterface) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("datacompatibility", "show dialog");
        C13225d.m79490f1().m79567R("event_id_data_compatibility_temp_backup_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_data_compatibility_temp_backup_dialog", "4", "43", linkedHashMapM79497A);
    }

    /* renamed from: N2 */
    private void m19579N2() {
        this.f14143M = new NetWorkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.f14143M, intentFilter, "com.huawei.cg.permission.SERVICE", null);
    }

    /* renamed from: f2 */
    public static boolean m19593f2(Activity activity) {
        return activity == null || activity.isFinishing();
    }

    /* renamed from: j3 */
    private void m19594j3() {
        NetWorkChangeReceiver netWorkChangeReceiver = this.f14143M;
        if (netWorkChangeReceiver != null) {
            unregisterReceiver(netWorkChangeReceiver);
            this.f14143M = null;
        }
    }

    /* renamed from: k3 */
    private void m19595k3() {
        if (this.f14144N != null) {
            try {
                C13108a.m78878b(this).m78883f(this.f14144N);
                this.f14144N = null;
            } catch (Exception unused) {
                C11839m.m70687e("CloudBackupStateActivity", "unregisterBroadcastReceiver mLocalReceiver");
            }
        }
    }

    /* renamed from: B2 */
    public final /* synthetic */ void m19597B2(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.rl_backup_now) {
            if (mo18831u2()) {
                Toast.makeText(this, getString(R$string.cloud_backup_basic_data_toast), 0).show();
                return;
            } else {
                mo18797g2(true, false);
                return;
            }
        }
        if (id2 == R$id.bt_backup_pause) {
            this.f14134D.setEnabled(false);
            this.f14134D.setAlpha(0.62f);
            mo18731H2(false);
            return;
        }
        if (id2 == R$id.bt_backup_cancle) {
            m19610V2();
            return;
        }
        if (id2 == R$id.rl_backup_continue) {
            if (mo18831u2()) {
                Toast.makeText(this, getString(R$string.cloud_backup_basic_data_toast), 0).show();
                return;
            } else {
                mo18797g2(false, false);
                return;
            }
        }
        if (id2 == R$id.bt_backup_complete) {
            BackupNotification.getInstance().cancelBackupNotification();
            C13225d.m79490f1().m79587h0("action_code_backup_detail_click_button", "5", "", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29971c0("PVC", "action_code_backup_detail_click_button", "1", "77", "5", "");
            HiCloudAutoSizeButton hiCloudAutoSizeButton = this.f14140J;
            if (hiCloudAutoSizeButton == null || hiCloudAutoSizeButton.getText() == null || !TextUtils.equals(getString(R$string.gallery_shelve_confirm), this.f14140J.getText().toString())) {
                finish();
                return;
            } else {
                m19612a3();
                return;
            }
        }
        if (id2 == R$id.temp_cancel_btn) {
            TempDoubleBtnDialog tempDoubleBtnDialog = new TempDoubleBtnDialog(this, new C3196a());
            tempDoubleBtnDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.huawei.android.hicloud.ui.activity.z2
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    C4012a.m24631O("event_id_cancel_temp_backup_dialog", "show dialog", "CloudBackupStateActivity");
                }
            });
            tempDoubleBtnDialog.showCommonView(getString(R$string.temp_backup_dialog_cancel_title), getString(R$string.temp_backup_cancel_dialog_content), getString(R$string.backup_continue_backup), getString(R$string.cancel_backup), 0);
        } else if (id2 == R$id.temp_pause_btn) {
            mo18731H2(false);
            this.f14157p.postDelayed(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.a3
                @Override // java.lang.Runnable
                public final void run() {
                    CloudBackupStateActivity.m19575A2();
                }
            }, 600L);
        } else if (id2 == R$id.temp_continue_btn) {
            m19615i2();
        }
    }

    /* renamed from: C2 */
    public final /* synthetic */ void m19598C2() {
        this.f14163v.setEnabled(true);
    }

    /* renamed from: D2 */
    public final /* synthetic */ void m19599D2(DialogInterface dialogInterface, int i10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("datacompatibility", "already known");
        C13225d.m79490f1().m79567R("event_id_data_compatibility_temp_backup_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_data_compatibility_temp_backup_dialog", "4", "43", linkedHashMapM79497A);
        C12600v1.m76047c().m76052a();
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        finish();
    }

    /* renamed from: F2 */
    public void mo18724F2() {
        C11839m.m70686d("CloudBackupStateActivity", "onNetworkConnected");
        if (C10782d.m65634a().m65652s(this)) {
            m19607Q2();
        } else {
            m19608R2();
        }
    }

    /* renamed from: G2 */
    public void m19600G2() {
        C11839m.m70686d("CloudBackupStateActivity", "onNetworkDisconnected");
        m19608R2();
    }

    /* renamed from: H2 */
    public void mo18731H2(boolean z10) {
        CloudBackupService.getInstance().abort(z10 ? PlayerConstants.ErrorCode.SWITCH_PLAYMODE_NORMAL_FAILED : 1001);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is_system_retread", String.valueOf(m19622s2()));
        linkedHashMap.put("is_refurbish", Boolean.valueOf(C10028c.m62182c0().m62325f1()));
        C13225d.m79490f1().m79590k0("mecloud_backupmain_click_now", "2", "", C13452e.m80781L().m80971t0(), linkedHashMap);
        UBAAnalyze.m29979g0("PVC", "mecloud_backupmain_click_now", "1", "43", "2", "", linkedHashMap);
    }

    /* renamed from: I2 */
    public void m19601I2(Context context, String str) {
        if (TextUtils.isEmpty(this.f14150T)) {
            this.f14150T = str;
        }
        if (TextUtils.equals(this.f14150T, str)) {
            return;
        }
        this.f14150T = str;
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getApplicationContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
            accessibilityEventObtain.setEventType(16384);
            accessibilityEventObtain.setClassName(context.getClass().getName());
            accessibilityEventObtain.setPackageName(context.getApplicationContext().getPackageName());
            accessibilityEventObtain.getText().add(str);
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
        }
    }

    /* renamed from: J2 */
    public C13029h m19602J2() {
        C13029h c13029hM78495f;
        C13030i c13030i = new C13030i();
        try {
            c13029hM78495f = c13030i.m78495f(2);
            if (c13029hM78495f != null) {
                return c13029hM78495f;
            }
            try {
                return c13030i.m78495f(1);
            } catch (C9721b unused) {
                C11839m.m70689w("CloudBackupStateActivity", "");
                return c13029hM78495f;
            }
        } catch (C9721b unused2) {
            c13029hM78495f = null;
        }
    }

    /* renamed from: K2 */
    public void mo18741K2(boolean z10) {
    }

    /* renamed from: L2 */
    public final void m19603L2(String str) {
        if (this instanceof BackupMainActivity) {
            ((BackupMainActivity) this).m18816n6(str);
        }
    }

    /* renamed from: M2 */
    public final void m19604M2(boolean z10) {
        this.f14144N = new LocalReceiver();
        IntentFilter intentFilter = new IntentFilter();
        if (z10) {
            intentFilter.addAction("com.huawei.android.hicloud.sendmessage");
        }
        intentFilter.addAction("com.huawei.hicloud.intent.action.ACTION_PAY_SUCCESS");
        intentFilter.addAction("com.huawei.hicloud.intent.action.ACTION_SPACE_ENOUGH");
        intentFilter.addAction("com.huawei.hicloud.intent.action.ACTION_GRADE_CODE_PUSH");
        C13108a.m78878b(this).m78880c(this.f14144N, intentFilter);
    }

    /* renamed from: O2 */
    public void m19605O2(boolean z10) {
        this.f14152V = z10;
    }

    /* renamed from: P2 */
    public void m19606P2() {
        C11839m.m70688i("CloudBackupStateActivity", "setBtBackupNow,isBackupOptionShow:" + this.f14152V);
        RelativeLayout relativeLayout = this.f14163v;
        if (relativeLayout != null) {
            relativeLayout.post(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.d3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17584a.m19598C2();
                }
            });
        } else {
            C11839m.m70687e("CloudBackupStateActivity", "btBackupNow is null!");
        }
    }

    /* renamed from: Q2 */
    public void m19607Q2() {
        C11839m.m70688i("CloudBackupStateActivity", "setButtonEnabled,isBackupOptionShow:" + this.f14152V);
        m19621r2();
        if (this.f14152V) {
            this.f14163v.setEnabled(true);
        } else {
            this.f14163v.setEnabled(false);
        }
        this.f14135E.setEnabled(true);
        this.f14135E.setAlpha(1.0f);
        this.f14135E.requestLayout();
        this.f14131A.setEnabled(true);
        this.f14131A.setAlpha(1.0f);
        if (this.f14151U) {
            HiCloudAutoSizeButton hiCloudAutoSizeButton = this.f14139I;
            if (hiCloudAutoSizeButton != null) {
                hiCloudAutoSizeButton.setClickable(true);
                this.f14139I.setBackground(C8968a.m56743b(this, R$drawable.hwbutton_emphasize_emui));
            }
            HiCloudAutoSizeButton hiCloudAutoSizeButton2 = this.f14138H;
            if (hiCloudAutoSizeButton2 != null) {
                hiCloudAutoSizeButton2.setEnabled(true);
                this.f14138H.setClickable(true);
                this.f14138H.setAlpha(1.0f);
            }
        }
    }

    /* renamed from: R2 */
    public void m19608R2() {
        this.f14163v.setEnabled(false);
        this.f14135E.setEnabled(false);
        this.f14135E.setAlpha(0.62f);
        this.f14135E.requestLayout();
        this.f14131A.setEnabled(false);
        this.f14131A.setAlpha(0.62f);
        if (this.f14151U) {
            HiCloudAutoSizeButton hiCloudAutoSizeButton = this.f14139I;
            if (hiCloudAutoSizeButton != null) {
                hiCloudAutoSizeButton.setClickable(false);
                this.f14139I.setBackground(C8968a.m56743b(this, R$drawable.hwbutton_emphasize_emui_disable_drawable));
            }
            HiCloudAutoSizeButton hiCloudAutoSizeButton2 = this.f14138H;
            if (hiCloudAutoSizeButton2 != null) {
                hiCloudAutoSizeButton2.setEnabled(false);
                this.f14138H.setClickable(false);
                this.f14138H.setAlpha(0.4f);
            }
        }
    }

    /* renamed from: S2 */
    public void m19609S2() {
        if ((this instanceof BackupMainActivity) && this.f14149S) {
            return;
        }
        RelativeLayout relativeLayout = this.f14163v;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.f14164w.setVisibility(0);
        }
        RelativeLayout relativeLayout2 = this.f14135E;
        if (relativeLayout2 == null || relativeLayout2.getVisibility() != 0) {
            return;
        }
        this.f14165x.setVisibility(0);
    }

    /* renamed from: T2 */
    public void mo18764T2() {
        C11839m.m70688i("CloudBackupStateActivity", "showBackupingView");
        mo18767U2(2);
    }

    /* renamed from: U2 */
    public void mo18767U2(int i10) {
        C11839m.m70688i("CloudBackupStateActivity", "showButttonState state = " + i10);
        if (this.f14151U) {
            this.f14163v.setVisibility(8);
            this.f14134D.setVisibility(8);
            this.f14135E.setVisibility(8);
            this.f14140J.setText(R$string.gallery_shelve_confirm);
            this.f14137G.setVisibility((i10 == 2 || i10 == 3) ? 0 : 8);
            this.f14138H.setVisibility(i10 == 2 ? 0 : 8);
            this.f14139I.setVisibility(i10 == 3 ? 0 : 8);
            this.f14136F.setVisibility((i10 == 2 || i10 == 3) ? 0 : 8);
            if (this.f14151U) {
                this.f14138H.setEnabled(true);
                this.f14138H.setClickable(true);
                this.f14138H.setAlpha(1.0f);
            }
        } else {
            this.f14136F.setVisibility(8);
            this.f14140J.setText(R$string.family_finish_button1);
            this.f14163v.setVisibility(i10 == 1 ? 0 : 8);
            this.f14134D.setVisibility(i10 == 2 ? 0 : 8);
            this.f14135E.setVisibility(i10 == 3 ? 0 : 8);
            if (i10 == 2) {
                this.f14134D.setEnabled(true);
                this.f14134D.setAlpha(1.0f);
            }
            m19614h2();
            this.f14166y.setVisibility((i10 == 2 || i10 == 3) ? 0 : 8);
            this.f14131A.setVisibility(((i10 == 2 || i10 == 3) && this.f14149S) ? 0 : 8);
        }
        this.f14140J.setVisibility(i10 == 4 ? 0 : 8);
        this.f14167z.setVisibility(i10 != 4 ? 8 : 0);
    }

    /* renamed from: V2 */
    public void m19610V2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        try {
            builder.setMessage(R$string.cloudbackup_refurbishing_cancel_tips);
            C3196a c3196a = null;
            builder.setNegativeButton(R$string.cloudpay_exit_cancel_continuous_monthly_second, new DialogInterfaceOnClickListenerC3198c(this, c3196a));
            builder.setPositiveButton(R$string.cloudbackup_refurbishing_cancel_backup, new DialogInterfaceOnClickListenerC3198c(this, c3196a));
            AlertDialog alertDialog = this.f14133C;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f14133C = null;
            }
            AlertDialog alertDialogCreate = builder.create();
            this.f14133C = alertDialogCreate;
            alertDialogCreate.show();
            this.f14133C.getButton(-1).setTextColor(ContextCompat.getColor(this, R$color.enui50_red_color));
        } catch (RuntimeException e10) {
            C11839m.m70687e("CloudBackupStateActivity", "show cancel backup dialog error: " + e10.getMessage());
        }
    }

    /* renamed from: W2 */
    public void mo18771W2() {
    }

    /* renamed from: X2 */
    public void m19611X2(Message message) {
        CloudBackupState cloudBackupState = (CloudBackupState) message.obj;
        this.f14158q = cloudBackupState;
        if (cloudBackupState == null) {
            C11839m.m70688i("CloudBackupStateActivity", "showCloudBackupState is null");
            return;
        }
        if (m19623t2()) {
            C11839m.m70688i("CloudBackupStateActivity", "showCloudBackupState equals old");
            return;
        }
        this.f14159r = this.f14158q.copy();
        int iIntValue = this.f14158q.getState().intValue();
        if (this.f14158q.getId() != 1) {
            if (this.f14158q.getId() == 2) {
                C11839m.m70689w("CloudBackupStateActivity", "restore state ");
                return;
            }
            C11839m.m70689w("CloudBackupStateActivity", "unknown state " + iIntValue);
            return;
        }
        C11839m.m70688i("CloudBackupStateActivity", "backup state = " + this.f14158q.toString() + "  msg:" + message);
        mo19298Y2();
        if ((this instanceof BackupMainActivity) && this.f14149S) {
            return;
        }
        if ((!this.f14149S && !m19624v2()) || iIntValue == 0) {
            mo18771W2();
            return;
        }
        if (iIntValue == 1) {
            mo18798g3();
            return;
        }
        if (iIntValue == 2) {
            mo18794f3();
            m19603L2("backupPaused");
            return;
        }
        if (iIntValue == 3) {
            mo18782b3(message.arg1);
            m19603L2("backupSuccess");
            return;
        }
        if (iIntValue == 4) {
            mo18791e3();
            return;
        }
        if (iIntValue == 5) {
            mo18798g3();
            m19603L2("prepareBackupData");
            return;
        }
        if (iIntValue == 6) {
            mo18801h3();
            return;
        }
        if (iIntValue == 7) {
            mo18787d3();
        } else if (iIntValue == 8) {
            mo18784c3();
        } else if (iIntValue == 9) {
            mo18777Z2();
        }
    }

    /* renamed from: Y2 */
    public void mo19298Y2() {
    }

    /* renamed from: Z2 */
    public void mo18777Z2() {
        mo18767U2(2);
    }

    /* renamed from: a3 */
    public final void m19612a3() {
        AlertDialog alertDialog = this.f14153W;
        if (alertDialog == null) {
            String spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_data_compatibility_title");
            String spaceMultLanguage2 = SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_data_compatibility_desc");
            if (TextUtils.isEmpty(spaceMultLanguage) || TextUtils.isEmpty(spaceMultLanguage2)) {
                C12600v1.m76047c().m76052a();
                startActivity(new Intent(this, (Class<?>) MainActivity.class));
                finish();
                return;
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(spaceMultLanguage).setMessage(spaceMultLanguage2).setNeutralButton(getString(R$string.cloud_space_dialog_know), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.b3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        this.f16483a.m19599D2(dialogInterface, i10);
                    }
                }).setCancelable(false);
                AlertDialog alertDialogCreate = builder.create();
                this.f14153W = alertDialogCreate;
                alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.huawei.android.hicloud.ui.activity.c3
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        CloudBackupStateActivity.m19576E2(dialogInterface);
                    }
                });
            }
        } else if (alertDialog.isShowing()) {
            C11839m.m70688i("CloudBackupStateActivity", "dataCompatibilityDialog is showing");
            return;
        }
        if (isFinishing() || isDestroyed()) {
            C11839m.m70689w("CloudBackupStateActivity", "activity is finishing");
        } else {
            this.f14153W.show();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: b1 */
    public C13230i mo18601b1() {
        return C13225d.m79490f1();
    }

    /* renamed from: b2 */
    public void mo18781b2(boolean z10) {
    }

    /* renamed from: b3 */
    public void mo18782b3(int i10) {
    }

    /* renamed from: c2 */
    public void mo18783c2(boolean z10) {
        CloudBackupService.getInstance().backup(false, z10);
    }

    /* renamed from: c3 */
    public void mo18784c3() {
        mo18767U2(2);
    }

    /* renamed from: d2 */
    public final void m19613d2() {
        C11839m.m70688i("CloudBackupStateActivity", "cancel backup fail timer");
        C10469c.m64350p(this).m64349m(true);
        C10469c.m64350p(this).cancel();
        C10470d.m64355p(this).m64349m(true);
        C10470d.m64355p(this).cancel();
        ScreenListener.m18023c(this).m18028g();
    }

    /* renamed from: d3 */
    public void mo18787d3() {
        mo18767U2(2);
    }

    /* renamed from: e2 */
    public void mo18790e2() {
    }

    /* renamed from: e3 */
    public void mo18791e3() {
    }

    /* renamed from: f3 */
    public void mo18794f3() {
        mo18767U2(3);
        m19621r2();
        mo18820p2();
    }

    /* renamed from: g2 */
    public void mo18797g2(boolean z10, boolean z11) {
        mo18804i3(z10, z11);
    }

    /* renamed from: g3 */
    public void mo18798g3() {
        mo18767U2(2);
        if (this.f14151U) {
            this.f14138H.setEnabled(false);
            this.f14138H.setClickable(false);
            this.f14138H.setAlpha(0.4f);
        }
    }

    /* renamed from: h2 */
    public final void m19614h2() {
        if ((this instanceof BackupMainActivity) && this.f14149S) {
            return;
        }
        RelativeLayout relativeLayout = this.f14163v;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.f14164w.setVisibility(CBAccess.isBackupAbout() ? 0 : 8);
        }
        RelativeLayout relativeLayout2 = this.f14135E;
        if (relativeLayout2 == null || relativeLayout2.getVisibility() != 0) {
            return;
        }
        this.f14165x.setVisibility(CBAccess.isBackupAbout() ? 0 : 8);
    }

    /* renamed from: h3 */
    public void mo18801h3() {
        mo18767U2(2);
    }

    /* renamed from: i2 */
    public final void m19615i2() {
        MobileNetTipDialog mobileNetTipDialog;
        if (!C10782d.m65634a().m65644k(this) || C12591s1.m75931a().m75941k()) {
            int iM24616e = C13452e.m80781L().m80907e1() ? C12600v1.m76047c().m76053d().m24616e() : 0;
            C11839m.m70688i("CloudBackupStateActivity", "clickTempContinue: set key_backup_start_or_resume false");
            C0212e0.m1365o(C0213f.m1377a(), "tempBackupSpFile", "key_backup_start_or_resume", false);
            CloudBackupService.getInstance().doTempBackup(false, iM24616e);
            MobileTrafficReport.getInstance().setMobile(false);
            return;
        }
        if (CBAccess.isBackupAbout() || (mobileNetTipDialog = this.f14160s) == null) {
            return;
        }
        mobileNetTipDialog.show();
        MobileTrafficReport.getInstance().reportNetworkDialogShow();
        MobileTrafficReport.getInstance().setMobile(true);
    }

    /* renamed from: i3 */
    public void mo18804i3(boolean z10, boolean z11) {
        MobileNetTipDialog mobileNetTipDialog;
        boolean z12 = C10782d.m65634a().m65644k(this) && !C12591s1.m75931a().m75941k();
        this.f14161t = z10;
        if (!z12) {
            mo18783c2(z11);
            MobileTrafficReport.getInstance().setMobile(false);
        } else {
            if (CBAccess.isBackupAbout() || (mobileNetTipDialog = this.f14160s) == null) {
                return;
            }
            mobileNetTipDialog.show();
            MobileTrafficReport.getInstance().reportNetworkDialogShow();
            MobileTrafficReport.getInstance().setMobile(true);
        }
    }

    /* renamed from: j2 */
    public String m19616j2() {
        return mo18836w2() ? "interim" : "auto";
    }

    /* renamed from: k2 */
    public void m19617k2() {
        C14317j.m85301e(m19616j2()).m85319t();
    }

    /* renamed from: l2 */
    public float m19618l2() {
        CloudBackupState cloudBackupState = this.f14158q;
        if (cloudBackupState != null) {
            return cloudBackupState.getProgress();
        }
        return 0.0f;
    }

    /* renamed from: m2 */
    public void m19619m2() {
        RelativeLayout relativeLayout = this.f14163v;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        this.f14164w.setVisibility(8);
    }

    /* renamed from: n2 */
    public void m19620n2(int i10) {
        RelativeLayout relativeLayout = this.f14163v;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.f14164w.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.f14135E;
        if (relativeLayout2 != null && relativeLayout2.getVisibility() == 0) {
            this.f14165x.setVisibility(8);
        }
        if (i10 == 1) {
            this.f14145O = true;
            ScreenListener.m18023c(this).m18028g();
            RelativeLayout relativeLayout3 = this.f14163v;
            mo18781b2(relativeLayout3 != null && relativeLayout3.getVisibility() == 0);
        }
    }

    /* renamed from: o2 */
    public void mo18817o2() {
        CBCallBack.getInstance().registerCallback(this.f14156Z);
        C14317j.m85301e(m19616j2()).m85311l(this.f14157p);
        m19617k2();
        m19579N2();
        m19604M2(C10028c.m62182c0().m62340i1());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70874v1(this, this.f14163v);
        C11842p.m70874v1(this, this.f14167z);
        if (!this.f14149S) {
            C11842p.m70874v1(this, this.f14166y);
        } else {
            this.f14131A.setMinimumWidth((C11842p.m70876w(this).widthPixels - C11842p.m70840n(this, 60)) / 2);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CBCallBack.getInstance().unregisterCallback(this.f14156Z);
        C14317j.m85301e(m19616j2()).m85322w(this.f14157p);
        m19595k3();
        m19594j3();
        MobileNetTipDialog mobileNetTipDialog = this.f14160s;
        if (mobileNetTipDialog != null) {
            mobileNetTipDialog.dismiss();
            this.f14160s = null;
        }
        AlertDialog alertDialog = this.f14133C;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f14133C = null;
        }
        AlertDialog alertDialog2 = this.f14153W;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
            this.f14153W = null;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!CBAccess.inBackup()) {
            if (this.f14148R - jCurrentTimeMillis > 86400000) {
                m19617k2();
            }
            if (this.f14147Q) {
                m19617k2();
                this.f14147Q = false;
            }
        }
        this.f14148R = jCurrentTimeMillis;
    }

    /* renamed from: p2 */
    public void mo18820p2() {
        if (C0209d.m1333z1(this)) {
            mo18724F2();
        } else {
            m19600G2();
        }
    }

    /* renamed from: q2 */
    public void mo18823q2() {
        this.f14160s = new MobileNetTipDialog(this, this.f14154X, true);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.tv_net_tip);
        this.f14162u = textView;
        textView.setText(C2783d.m16179s1(R$string.backup_no_wlan_tips, R$string.backup_no_wifi_tips));
        this.f14163v = (RelativeLayout) C12809f.m76829b(this, R$id.rl_backup_now);
        this.f14164w = (HwProgressBar) C12809f.m76829b(this, R$id.click_backup_loading);
        this.f14165x = (HwProgressBar) C12809f.m76829b(this, R$id.click_backup_continue_loading);
        this.f14163v.setOnClickListener(this.f14155Y);
        int i10 = R$id.bt_backup_pause;
        HiCloudAutoSizeButton hiCloudAutoSizeButton = (HiCloudAutoSizeButton) C12809f.m76829b(this, i10);
        this.f14134D = hiCloudAutoSizeButton;
        hiCloudAutoSizeButton.setOnClickListener(this.f14155Y);
        this.f14166y = (LinearLayout) C12809f.m76829b(this, R$id.ll_backup_cancle_pause_continue);
        this.f14167z = (LinearLayout) C12809f.m76829b(this, R$id.ll_backup_complete);
        HiCloudAutoSizeButton hiCloudAutoSizeButton2 = (HiCloudAutoSizeButton) C12809f.m76829b(this, R$id.bt_backup_cancle);
        this.f14131A = hiCloudAutoSizeButton2;
        hiCloudAutoSizeButton2.setOnClickListener(this.f14155Y);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.rl_backup_continue);
        this.f14135E = relativeLayout;
        relativeLayout.setOnClickListener(this.f14155Y);
        HiCloudAutoSizeButton hiCloudAutoSizeButton3 = (HiCloudAutoSizeButton) C12809f.m76829b(this, R$id.bt_backup_complete);
        this.f14140J = hiCloudAutoSizeButton3;
        hiCloudAutoSizeButton3.setOnClickListener(this.f14155Y);
        this.f14132B = new ProgressDialog(this);
        C11842p.m70874v1(this, this.f14163v);
        C11842p.m70874v1(this, this.f14167z);
        if (this.f14149S) {
            HiCloudAutoSizeButton hiCloudAutoSizeButton4 = (HiCloudAutoSizeButton) C12809f.m76829b(this, i10);
            this.f14141K = hiCloudAutoSizeButton4;
            hiCloudAutoSizeButton4.setText(R$string.cloudbackup_refurbishing_pause_backup);
            HiCloudAutoSizeButton hiCloudAutoSizeButton5 = (HiCloudAutoSizeButton) C12809f.m76829b(this, R$id.backup_continue_backup);
            this.f14142L = hiCloudAutoSizeButton5;
            hiCloudAutoSizeButton5.setText(R$string.cloudbackup_refurbishing_continue_backup);
            this.f14164w.setVisibility(8);
            this.f14131A.setMinimumWidth((C11842p.m70876w(this).widthPixels - C11842p.m70840n(this, 60)) / 2);
        } else {
            C11842p.m70874v1(this, this.f14166y);
        }
        this.f14136F = (LinearLayout) C12809f.m76829b(this, R$id.temp_btn_layout);
        HiCloudAutoSizeButton hiCloudAutoSizeButton6 = (HiCloudAutoSizeButton) C12809f.m76829b(this, R$id.temp_cancel_btn);
        this.f14137G = hiCloudAutoSizeButton6;
        hiCloudAutoSizeButton6.setOnClickListener(this.f14155Y);
        HiCloudAutoSizeButton hiCloudAutoSizeButton7 = (HiCloudAutoSizeButton) C12809f.m76829b(this, R$id.temp_pause_btn);
        this.f14138H = hiCloudAutoSizeButton7;
        hiCloudAutoSizeButton7.setOnClickListener(this.f14155Y);
        HiCloudAutoSizeButton hiCloudAutoSizeButton8 = (HiCloudAutoSizeButton) C12809f.m76829b(this, R$id.temp_continue_btn);
        this.f14139I = hiCloudAutoSizeButton8;
        hiCloudAutoSizeButton8.setOnClickListener(this.f14155Y);
        this.f14136F.setVisibility(8);
        this.f14137G.setText(C4012a.m24663t(this, 1, mo18836w2()));
        this.f14138H.setText(C4012a.m24663t(this, 2, mo18836w2()));
        this.f14139I.setText(C4012a.m24663t(this, 3, mo18836w2()));
    }

    /* renamed from: r2 */
    public void m19621r2() {
        boolean zM65642i = C10782d.m65634a().m65642i(this);
        boolean zM1254f2 = C0209d.m1254f2(this);
        C11839m.m70686d("CloudBackupStateActivity", "initWifiTip netWorkConnected =" + zM65642i + " wifiActive =" + zM1254f2);
        boolean zM19624v2 = m19624v2();
        if (C10782d.m65634a().m65645l()) {
            this.f14162u.setVisibility(8);
            return;
        }
        if (zM65642i || CBAccess.isAppDataPreparing() || !zM19624v2) {
            this.f14162u.setVisibility(8);
        } else {
            this.f14162u.setVisibility(0);
        }
        if (!zM65642i) {
            if (CBAccess.isAppDataPreparing()) {
                return;
            }
            this.f14162u.setVisibility(zM19624v2 ? 0 : 8);
        } else if (zM1254f2 || CBAccess.isAppDataPreparing() || !zM19624v2) {
            this.f14162u.setVisibility(8);
        } else {
            this.f14162u.setVisibility(0);
        }
    }

    /* renamed from: s2 */
    public boolean m19622s2() {
        if (C10028c.m62182c0().m62325f1()) {
            return true;
        }
        C13029h c13029hM19602J2 = m19602J2();
        return c13029hM19602J2 != null && CloudBackupStateUtil.checkBroadcastId(1, c13029hM19602J2.m78465h());
    }

    /* renamed from: t2 */
    public final boolean m19623t2() {
        boolean zM19624v2 = m19624v2();
        if (this.f14146P == zM19624v2) {
            return this.f14158q.equals(this.f14159r);
        }
        this.f14146P = zM19624v2;
        return false;
    }

    /* renamed from: u2 */
    public boolean mo18831u2() {
        return BackupNewBmTypeUtil.isBaseBusinessAndNotRef(Boolean.valueOf(this.f14149S));
    }

    /* renamed from: v2 */
    public boolean m19624v2() {
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        if (this.f14151U) {
            return true;
        }
        return zM62388s;
    }

    /* renamed from: w2 */
    public boolean mo18836w2() {
        return this.f14151U;
    }

    /* renamed from: x2 */
    public boolean m19625x2() {
        CloudBackupState cloudBackupState = this.f14158q;
        if (cloudBackupState != null && CBSBaseReq.CURRENT_API_VERSION.equalsIgnoreCase(cloudBackupState.getVersion())) {
            z = C11963c.m71959n(m19616j2()).size() > 0;
            C11839m.m70686d("CloudBackupStateActivity", "isV3BackupAndHasPre pre = " + z);
        }
        return z;
    }

    /* renamed from: y2 */
    public final /* synthetic */ void m19626y2(DialogInterface dialogInterface, int i10) {
        if (i10 == -2) {
            dialogInterface.dismiss();
            MobileTrafficReport.getInstance().reportNetworkBackup("1");
        } else {
            if (i10 != -1) {
                return;
            }
            if (this.f14151U) {
                int iM24616e = C13452e.m80781L().m80907e1() ? C12600v1.m76047c().m76053d().m24616e() : 0;
                C11839m.m70688i("CloudBackupStateActivity", "mobileNetTipClick: set key_backup_start_or_resume false");
                C0212e0.m1365o(C0213f.m1377a(), "tempBackupSpFile", "key_backup_start_or_resume", false);
                CloudBackupService.getInstance().doTempBackup(false, iM24616e);
            } else {
                mo18783c2(false);
            }
            dialogInterface.dismiss();
            MobileTrafficReport.getInstance().reportNetworkBackup("0");
        }
    }
}
