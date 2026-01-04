package com.huawei.android.hicloud.p088ui.temporarybackup;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupAppEstimateUtil;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupDetailStateActivity;
import com.huawei.android.hicloud.p088ui.activity.HisyncSpaceDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.common.VerticalBtnAlertDialog;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.fragment.TempMainPageRecordFragment;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupCheckActivity;
import com.huawei.android.hicloud.task.backup.GetTempBackupInfoTask;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.bean.TempBackupPolicy;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.About;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import com.huawei.hicloud.router.data.ExtraDeviceInfo;
import com.huawei.hicloud.router.data.UserBackupInfo;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwprogressbar.widget.HwProgressBar;
import fk.C9721b;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import je.C10782d;
import p015ak.C0209d;
import p015ak.C0219i;
import p015ak.C0223k;
import p015ak.C0226l0;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p292fn.C9733f;
import p399jk.AbstractC10896a;
import p431ko.C11079e;
import p450le.C11273b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p550pb.C12126b;
import p572qb.C12312h0;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p617rl.C12526j;
import p618rm.C12590s0;
import p618rm.C12600v1;
import p676ud.AlertDialogC13156c;
import p684un.C13222a;
import p684un.C13225d;
import p684un.C13227f;
import p684un.C13230i;
import p703v8.C13368e;
import p709vj.C13452e;
import p711vl.C13466f;
import p836z8.C14157f;
import pm.C12175b0;
import pm.C12199z;
import sk.C12806c;
import sk.C12808e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class TempBackupCheckActivity extends UIActivity {

    /* renamed from: A */
    public AlertDialog f18355A;

    /* renamed from: D */
    public AlertDialogC13156c f18358D;

    /* renamed from: E */
    public UserBackupInfo.UserDeviceInfo f18359E;

    /* renamed from: H */
    public TempMainPageRecordFragment f18362H;

    /* renamed from: p */
    public Context f18366p;

    /* renamed from: q */
    public FrameLayout f18367q;

    /* renamed from: r */
    public ScrollView f18368r;

    /* renamed from: t */
    public RelativeLayout f18370t;

    /* renamed from: u */
    public HwProgressBar f18371u;

    /* renamed from: v */
    public HwProgressBar f18372v;

    /* renamed from: w */
    public AutoSizeButton f18373w;

    /* renamed from: x */
    public AlertDialog f18374x;

    /* renamed from: y */
    public AlertDialog f18375y;

    /* renamed from: z */
    public AlertDialog f18376z;

    /* renamed from: s */
    public boolean f18369s = true;

    /* renamed from: B */
    public boolean f18356B = false;

    /* renamed from: C */
    public List<View> f18357C = new ArrayList();

    /* renamed from: F */
    public boolean f18360F = true;

    /* renamed from: G */
    public TempBackupPolicy f18361G = new TempBackupPolicy();

    /* renamed from: I */
    public final Handler f18363I = new Handler(new Handler.Callback() { // from class: zd.i0
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f63408a.m24426z2(message);
        }
    });

    /* renamed from: J */
    public BroadcastReceiver f18364J = new C3998a();

    /* renamed from: K */
    public final Handler.Callback f18365K = new Handler.Callback() { // from class: zd.j0
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f63411a.m24427A2(message);
        }
    };

    /* renamed from: com.huawei.android.hicloud.ui.temporarybackup.TempBackupCheckActivity$a */
    public class C3998a extends BroadcastReceiver {
        public C3998a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"android.net.conn.CONNECTIVITY_CHANGE".equals(new SafeIntent(intent).getAction()) || TempBackupCheckActivity.this.f18356B) {
                return;
            }
            TempBackupCheckActivity.this.m24442V2();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.temporarybackup.TempBackupCheckActivity$b */
    public class C3999b extends AbstractC12367d {
        public C3999b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$call$0() {
            TempBackupCheckActivity.this.m24466w2();
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            TempBackupCheckActivity.this.m24458m3();
            boolean zM80887a1 = C13452e.m80781L().m80887a1();
            C11839m.m70688i("TempBackUpCheckActivity", "updateBmAndGrade newBmType " + zM80887a1);
            if (!zM80887a1) {
                TempBackupCheckActivity.this.runOnUiThread(new Runnable() { // from class: zd.q0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f63455a.lambda$call$0();
                    }
                });
                return;
            }
            About aboutM75735D0 = C12590s0.m75735D0();
            C10782d.m65634a().m65641h(C9733f.m60705z().m60717L());
            TempBackupCheckActivity.this.m24443W2(aboutM75735D0);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.TEMP_BACKUP;
        }
    }

    /* renamed from: J2 */
    public static /* synthetic */ void m24389J2(DialogInterface dialogInterface) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "show dialog");
        C13225d.m79490f1().m79567R("event_id_limit_times", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_limit_times", "4", "66", linkedHashMapM79497A);
    }

    /* renamed from: L2 */
    public static /* synthetic */ void m24391L2(DialogInterface dialogInterface) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "show dialog");
        C13225d.m79490f1().m79567R("event_id_server_error_retry", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_server_error_retry", "4", "66", linkedHashMapM79497A);
    }

    /* renamed from: M2 */
    public static /* synthetic */ void m24393M2(DialogInterface dialogInterface) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "show dialog");
        C13225d.m79490f1().m79567R("event_id_temp_backup_save_no_enough_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_temp_backup_save_no_enough_dialog", "4", "is_temp_backup", linkedHashMapM79497A);
    }

    /* renamed from: N2 */
    public static /* synthetic */ void m24395N2(DialogInterface dialogInterface, int i10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "cancel");
        C13225d.m79490f1().m79567R("event_id_temp_backup_save_no_enough_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_temp_backup_save_no_enough_dialog", "4", "is_temp_backup", linkedHashMapM79497A);
    }

    /* renamed from: Q2 */
    public static /* synthetic */ void m24399Q2(DialogInterface dialogInterface, int i10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "negative");
        C13225d.m79490f1().m79567R("event_id_guide_temp_backup_save_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_guide_temp_backup_save_dialog", "4", "is_temp_backup", linkedHashMapM79497A);
    }

    /* renamed from: U2 */
    public static /* synthetic */ void m24404U2(DialogInterface dialogInterface) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "show dialog");
        C13225d.m79490f1().m79567R("event_id_too_many_people", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_too_many_people", "4", "66", linkedHashMapM79497A);
    }

    /* renamed from: f3 */
    private void m24416f3() {
        if (isInMultiWindowMode()) {
            C11842p.m70736I1(this.f18367q, C11842p.m70852q(this));
            return;
        }
        if (C11842p.m70771U0() || !C11842p.m70753O0(this)) {
            getWindow().clearFlags(1024);
            C11842p.m70736I1(this.f18367q, C11842p.m70789a0(this) + C11842p.m70852q(this));
        } else {
            getWindow().addFlags(1024);
            C11842p.m70736I1(this.f18367q, C11842p.m70852q(this));
        }
    }

    /* renamed from: q2 */
    public static void m24425q2() {
        Message messageObtain = Message.obtain();
        messageObtain.what = 33056;
        CBCallBack.getInstance().sendMessageDelayed(messageObtain, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z2 */
    public /* synthetic */ boolean m24426z2(Message message) {
        C11839m.m70688i("TempBackUpCheckActivity", "saveTempBackupToUserCloud saveResultHandler " + message.what);
        int i10 = message.what;
        if (2001 == i10) {
            this.f18359E = null;
            m24445Y2(false);
            C11841o.m70706b(this, getString(R$string.temp_backup_save_space_succeed), 0);
        } else if (2002 == i10) {
            C11841o.m70706b(this, getString(R$string.temp_backup_save_space_failed), 0);
        }
        return false;
    }

    /* renamed from: A2 */
    public final /* synthetic */ boolean m24427A2(Message message) {
        int i10;
        if (message == null) {
            return true;
        }
        C11839m.m70688i("TempBackUpCheckActivity", "Callback  what " + message.what + " arg1:" + message.arg1);
        int i11 = message.what;
        if (i11 != 33038 && i11 != 33056 && (i10 = message.arg1) != 2 && i10 != 3) {
            return false;
        }
        CBCallBack.getInstance().removeMessage(33056);
        m24445Y2(this.f18360F);
        this.f18360F = false;
        return true;
    }

    /* renamed from: B2 */
    public final /* synthetic */ void m24428B2() throws IllegalAccessException, IllegalArgumentException {
        C4012a.m24642Z(this);
    }

    /* renamed from: C2 */
    public final /* synthetic */ void m24429C2(DialogInterface dialogInterface, int i10) {
        if (i10 == -1) {
            C11829c.m70612r1(this.f18366p);
        } else if (i10 == -2) {
            C11839m.m70688i("TempBackUpCheckActivity", "noNetDialog cancel");
            finish();
        }
    }

    /* renamed from: D2 */
    public final /* synthetic */ void m24430D2(View view) {
        C11839m.m70688i("TempBackUpCheckActivity", "isSwitchOpen: " + C10028c.m62182c0().m62388s("backup_key"));
        m24462s2();
    }

    /* renamed from: E2 */
    public final /* synthetic */ void m24431E2(About about) throws Resources.NotFoundException {
        C11839m.m70688i("TempBackUpCheckActivity", "queryComplete refresh UI");
        m24447a3(true);
        m24446Z2(true);
        m24449c3();
        this.f18370t.setOnClickListener(new View.OnClickListener() { // from class: zd.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f63494a.m24430D2(view);
            }
        });
        if (about != null) {
            int iIntValue = about.getDisableInterimReason() == null ? 0 : about.getDisableInterimReason().intValue();
            int iIntValue2 = about.getCountLeftInInterim() != null ? about.getCountLeftInInterim().intValue() : 0;
            if (iIntValue == 1) {
                m24457l3();
            } else if (iIntValue2 <= 0) {
                m24453h3();
            } else {
                this.f18356B = true;
                m24459o2(this.f18359E);
            }
        }
        this.f18356B = true;
        if (about == null) {
            m24454i3();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: F1 */
    public void mo22366F1() throws IllegalAccessException, IllegalArgumentException {
        if (C0219i.m1463a() < 17 || !C11829c.m70563b0(this)) {
            return;
        }
        C11829c.m70591k1(this);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 1024);
    }

    /* renamed from: F2 */
    public final /* synthetic */ void m24432F2() {
        this.f18368r.smoothScrollTo(0, C12809f.m76829b(this, R$id.tv_check_title).getTop());
    }

    /* renamed from: G2 */
    public final /* synthetic */ void m24433G2(boolean z10, List list) {
        int size = list.size();
        C11839m.m70688i("TempBackUpCheckActivity", "refreshFragment size " + size);
        this.f18362H.m24335h(list.subList(0, Math.min(3, size)), size);
        if (this.f18369s && size > 0) {
            this.f18368r.post(new Runnable() { // from class: zd.x
                @Override // java.lang.Runnable
                public final void run() {
                    this.f63501a.m24432F2();
                }
            });
            this.f18369s = false;
        }
        if (z10) {
            m24461r2(list);
        }
    }

    /* renamed from: H2 */
    public final /* synthetic */ void m24434H2(DialogInterface dialogInterface, int i10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "know");
        C13225d.m79490f1().m79567R("event_id_limit_times", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_limit_times", "4", "66", linkedHashMapM79497A);
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        finish();
    }

    /* renamed from: I2 */
    public final /* synthetic */ void m24435I2(DialogInterface dialogInterface, int i10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "upgrade now");
        C13225d.m79490f1().m79567R("event_id_limit_times", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_limit_times", "4", "66", linkedHashMapM79497A);
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 13);
        bundle.putString("page_detail", TempBackupCheckActivity.class.getName());
        C12126b.m72706b(this, C13222a.m79465g(this), bundle, true, 1003);
    }

    /* renamed from: K2 */
    public final /* synthetic */ void m24436K2(DialogInterface dialogInterface, int i10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "know");
        C13225d.m79490f1().m79567R("event_id_server_error_retry", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_server_error_retry", "4", "66", linkedHashMapM79497A);
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        finish();
    }

    /* renamed from: O2 */
    public final /* synthetic */ void m24437O2(DialogInterface dialogInterface, int i10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "manager space");
        C13225d.m79490f1().m79567R("event_id_temp_backup_save_no_enough_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_temp_backup_save_no_enough_dialog", "4", "is_temp_backup", linkedHashMapM79497A);
        Intent intent = new Intent(this, (Class<?>) HisyncSpaceDetailActivity.class);
        C13230i.m79525e1(intent, "4", "43");
        intent.putExtra("is_from_main_activity", false);
        startActivity(intent);
    }

    /* renamed from: P2 */
    public final /* synthetic */ void m24438P2(UserBackupInfo.UserDeviceInfo userDeviceInfo, DialogInterface dialogInterface, int i10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "go upgrade");
        C13225d.m79490f1().m79567R("event_id_temp_backup_save_no_enough_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_temp_backup_save_no_enough_dialog", "4", "is_temp_backup", linkedHashMapM79497A);
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 13);
        bundle.putString("page_detail", TempBackupCheckActivity.class.getName());
        bundle.putLong("need_extra_space", userDeviceInfo.getSize());
        C12126b.m72706b(this, C13222a.m79465g(this), bundle, true, 1002);
    }

    /* renamed from: R2 */
    public final /* synthetic */ void m24439R2(boolean z10, UserBackupInfo.UserDeviceInfo userDeviceInfo, DialogInterface dialogInterface, int i10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "positive");
        C13225d.m79490f1().m79567R("event_id_guide_temp_backup_save_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_guide_temp_backup_save_dialog", "4", "is_temp_backup", linkedHashMapM79497A);
        if (!z10) {
            m24460p2(userDeviceInfo);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 13);
        bundle.putString("page_detail", TempBackupCheckActivity.class.getName());
        bundle.putLong("need_extra_space", userDeviceInfo.getSize());
        C12126b.m72706b(this, C13222a.m79465g(this), bundle, true, 1004);
    }

    /* renamed from: S2 */
    public final /* synthetic */ void m24440S2(DialogInterface dialogInterface) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "show dialog");
        C13225d.m79490f1().m79567R("event_id_guide_temp_backup_save_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_guide_temp_backup_save_dialog", "4", "is_temp_backup", linkedHashMapM79497A);
        m24451e3();
    }

    /* renamed from: T2 */
    public final /* synthetic */ void m24441T2(DialogInterface dialogInterface, int i10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "know");
        C13225d.m79490f1().m79567R("event_id_too_many_people", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_too_many_people", "4", "66", linkedHashMapM79497A);
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        finish();
    }

    /* renamed from: V2 */
    public final void m24442V2() {
        boolean zM1333z1 = C0209d.m1333z1(this.f18366p);
        C11839m.m70688i("TempBackUpCheckActivity", "queryAbout netWorkConnected " + zM1333z1);
        if (zM1333z1) {
            AlertDialogC13156c alertDialogC13156c = this.f18358D;
            if (alertDialogC13156c != null) {
                alertDialogC13156c.dismiss();
            }
            this.f18356B = false;
            C12515a.m75110o().m75172d(new C3999b());
            return;
        }
        if (this.f18358D == null) {
            AlertDialogC13156c alertDialogC13156c2 = new AlertDialogC13156c(this, new DialogInterface.OnClickListener() { // from class: zd.s
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.f63463a.m24429C2(dialogInterface, i10);
                }
            });
            this.f18358D = alertDialogC13156c2;
            alertDialogC13156c2.setCancelable(false);
            this.f18358D.setCanceledOnTouchOutside(false);
        }
        this.f18358D.show();
    }

    /* renamed from: W2 */
    public final void m24443W2(final About about) {
        C11839m.m70688i("TempBackUpCheckActivity", "queryComplete");
        runOnUiThread(new Runnable() { // from class: zd.v
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.f63483a.m24431E2(about);
            }
        });
    }

    /* renamed from: X2 */
    public final void m24444X2() {
        C12515a.m75110o().m75172d(new C12199z(1));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: Y0 */
    public boolean mo21832Y0() {
        return false;
    }

    /* renamed from: Y2 */
    public final void m24445Y2(final boolean z10) {
        C11839m.m70688i("TempBackUpCheckActivity", "refreshFragment isNeedTipDueData " + z10);
        C12515a.m75110o().m75172d(new GetTempBackupInfoTask(new GetTempBackupInfoTask.Callback() { // from class: zd.u
            @Override // com.huawei.android.hicloud.task.backup.GetTempBackupInfoTask.Callback
            /* renamed from: a */
            public final void mo18021a(List list) {
                this.f63478a.m24433G2(z10, list);
            }
        }));
    }

    /* renamed from: Z2 */
    public final void m24446Z2(boolean z10) {
        this.f18371u.setVisibility(z10 ? 8 : 0);
    }

    /* renamed from: a3 */
    public final synchronized void m24447a3(boolean z10) {
        int i10 = 0;
        this.f18372v.setVisibility(z10 ? 8 : 0);
        AutoSizeButton autoSizeButton = this.f18373w;
        if (!z10) {
            i10 = 8;
        }
        autoSizeButton.setVisibility(i10);
        this.f18373w.setEnabled(z10);
        this.f18370t.setClickable(z10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: b1 */
    public C13230i mo18601b1() {
        return C13225d.m79490f1();
    }

    /* renamed from: b3 */
    public final void m24448b3() throws Resources.NotFoundException {
        TextView textView = (TextView) C12809f.m76829b(this, R$id.tv_free_storage_title);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.tv_free_storage_desc);
        int i10 = C12600v1.f57994d + C12600v1.f57996f;
        String quantityString = this.f18366p.getResources().getQuantityString(R$plurals.temp_backup_check_free_storage_title, i10, Integer.valueOf(i10));
        try {
            quantityString = C4012a.m24662s("temp_backup_check_free_storage_title", quantityString, Integer.valueOf(i10));
        } catch (Exception e10) {
            C11839m.m70688i("TempBackUpCheckActivity", "om storage_title err " + e10.getMessage());
        }
        textView.setText(quantityString);
        Resources resources = this.f18366p.getResources();
        int i11 = R$plurals.temp_backup_check_free_storage_desc;
        int i12 = C12600v1.f57994d;
        String quantityString2 = resources.getQuantityString(i11, i12, Integer.valueOf(i12), "HarmonyOS 5", Integer.valueOf(C12600v1.f57996f), Integer.valueOf(i10));
        try {
            quantityString2 = C4012a.m24662s("temp_backup_check_free_storage_time_desc", quantityString2, Integer.valueOf(C12600v1.f57994d), Integer.valueOf(C12600v1.f57996f), Integer.valueOf(i10));
        } catch (Exception e11) {
            C11839m.m70688i("TempBackUpCheckActivity", "om storage_time err " + e11.getMessage());
        }
        textView2.setText(quantityString2);
    }

    /* renamed from: c3 */
    public final void m24449c3() throws Resources.NotFoundException {
        if (C12600v1.f57994d == -1 || C12600v1.f57996f == -1 || C12600v1.f57997g == -1) {
            C12809f.m76829b(this, R$id.item_storage).setVisibility(4);
            C12809f.m76829b(this, R$id.item_use).setVisibility(4);
            m24446Z2(false);
        } else {
            m24450d3();
            m24448b3();
            C12809f.m76829b(this, R$id.item_storage).setVisibility(0);
            C12809f.m76829b(this, R$id.item_use).setVisibility(0);
            m24446Z2(true);
        }
    }

    /* renamed from: d3 */
    public final void m24450d3() {
        TextView textView = (TextView) C12809f.m76829b(this, R$id.tv_free_use_title);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.tv_free_use_desc);
        Resources resources = this.f18366p.getResources();
        int i10 = R$plurals.temp_backup_check_use_peryear_title;
        int i11 = C12600v1.f57997g;
        textView.setText(C4012a.m24662s("temp_backup_check_use_peryear_title", resources.getQuantityString(i10, i11, Integer.valueOf(i11)), Integer.valueOf(C12600v1.f57997g)));
        Resources resources2 = this.f18366p.getResources();
        int i12 = R$plurals.temp_backup_check_use_peryear_desc;
        int i13 = C12600v1.f57997g;
        textView2.setText(C4012a.m24662s("temp_backup_check_use_peryear_desc", resources2.getQuantityString(i12, i13, Integer.valueOf(i13)), Integer.valueOf(C12600v1.f57997g)));
    }

    /* renamed from: e3 */
    public final void m24451e3() {
        long jM81078f = C13466f.m81073d().m81078f("temp_backup_latest_reminder_time", 0L);
        int iM81077e = C13466f.m81073d().m81077e("temp_backup_reminder_num", 0);
        long jM74028c = C12312h0.m74027b().m74028c() - jM81078f;
        TempBackupPolicy.SaveReminder saveReminder = this.f18361G.getSaveReminder();
        long jIntValue = saveReminder.getReminderInterval().intValue() * C5863b6.g.f26453g;
        C11839m.m70688i("TempBackUpCheckActivity", "reminderShowUpdate configInterval " + jIntValue + " interval= " + jM74028c + "and  alreadyRem " + iM81077e + "  configTimes " + saveReminder.getReminderTimes().intValue());
        if (jM74028c >= jIntValue) {
            C13466f.m81073d().m81083k("temp_backup_latest_reminder_time", C12312h0.m74027b().m74028c());
            C13466f.m81073d().m81082j("temp_backup_reminder_num", 1);
        } else {
            C13466f.m81073d().m81082j("temp_backup_reminder_num", iM81077e + 1);
        }
    }

    /* renamed from: g3 */
    public final void m24452g3(UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        if (userDeviceInfo == null) {
            C11839m.m70688i("TempBackUpCheckActivity", "saveTempBackupToUserCloud latestBackupInfo  is  null");
            return;
        }
        C11839m.m70688i("TempBackUpCheckActivity", "saveTempBackupToUserCloud latestBackupInfo dev " + userDeviceInfo.getDevDisplayName());
        C12515a.m75110o().m75175e(new C12175b0(this.f18363I, userDeviceInfo), false);
        C4012a.m24631O("event_id_save_temp_backup_dialog", "confirm save tempbackup data dialog", "TempBackUpCheckActivity");
    }

    /* renamed from: h3 */
    public final void m24453h3() {
        if (this.f18376z == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            AlertDialog.Builder title = builder.setTitle(getString(R$string.temp_backup_limit_times_title));
            Resources resources = getResources();
            int i10 = R$plurals.temp_backup_limit_times_content;
            int i11 = C12600v1.f57997g;
            title.setMessage(resources.getQuantityString(i10, i11, Integer.valueOf(i11))).setNeutralButton(getString(R$string.temp_backup_exit_button), new DialogInterface.OnClickListener() { // from class: zd.c0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i12) {
                    this.f63368a.m24434H2(dialogInterface, i12);
                }
            }).setPositiveButton(getString(R$string.get_premium_dialog_button), new DialogInterface.OnClickListener() { // from class: zd.e0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i12) {
                    this.f63387a.m24435I2(dialogInterface, i12);
                }
            }).setCancelable(false);
            AlertDialog alertDialogCreate = builder.create();
            this.f18376z = alertDialogCreate;
            alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: zd.f0
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    TempBackupCheckActivity.m24389J2(dialogInterface);
                }
            });
        }
        if (isFinishing() || isDestroyed() || this.f18376z.isShowing()) {
            return;
        }
        this.f18376z.show();
    }

    /* renamed from: i3 */
    public final void m24454i3() {
        AlertDialog alertDialog = this.f18375y;
        if (alertDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R$string.temp_backup_too_many_people_title)).setMessage(getString(R$string.server_error_retry)).setNeutralButton(getString(R$string.cloud_space_dialog_know), new DialogInterface.OnClickListener() { // from class: zd.a0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.f63354a.m24436K2(dialogInterface, i10);
                }
            }).setCancelable(false);
            AlertDialog alertDialogCreate = builder.create();
            this.f18375y = alertDialogCreate;
            alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: zd.b0
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    TempBackupCheckActivity.m24391L2(dialogInterface);
                }
            });
        } else if (alertDialog.isShowing()) {
            C11839m.m70688i("TempBackUpCheckActivity", "serverErrorDialog is showing");
            return;
        }
        if (isFinishing() || isDestroyed()) {
            return;
        }
        this.f18375y.show();
    }

    /* renamed from: j3 */
    public final void m24455j3(final UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        boolean zM80811H0 = C13452e.m80781L().m80811H0();
        C11839m.m70688i("TempBackUpCheckActivity", "showSpaceNotEnoughDialog isHighestGrade:" + zM80811H0);
        VerticalBtnAlertDialog verticalBtnAlertDialog = new VerticalBtnAlertDialog(this);
        verticalBtnAlertDialog.m23932m(getString(R$string.space_share_no_space_title));
        verticalBtnAlertDialog.m23926g(zM80811H0 ? getString(R$string.temp_backup_space_not_enough_deal_des) : getString(R$string.temp_backup_space_not_enough_upgrade_des));
        verticalBtnAlertDialog.m23930k(getString(R$string.cancel), new DialogInterface.OnClickListener() { // from class: zd.n0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                TempBackupCheckActivity.m24395N2(dialogInterface, i10);
            }
        });
        verticalBtnAlertDialog.m23928i(getString(R$string.managing_space), new DialogInterface.OnClickListener() { // from class: zd.o0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f63440a.m24437O2(dialogInterface, i10);
            }
        });
        if (zM80811H0) {
            verticalBtnAlertDialog.m23927h(R$drawable.hwbutton_emphasize_emui);
            verticalBtnAlertDialog.m23929j(R$color.hwbutton_selector_text_emphasize_emui);
        } else {
            verticalBtnAlertDialog.m23931l(getString(R$string.increase_cloud_space_btn), new DialogInterface.OnClickListener() { // from class: zd.p0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.f63447a.m24438P2(userDeviceInfo, dialogInterface, i10);
                }
            });
        }
        verticalBtnAlertDialog.setCancelable(false);
        verticalBtnAlertDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: zd.t
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                TempBackupCheckActivity.m24393M2(dialogInterface);
            }
        });
        if (isFinishing() || isDestroyed() || verticalBtnAlertDialog.isShowing()) {
            return;
        }
        verticalBtnAlertDialog.show();
    }

    /* renamed from: k3 */
    public final void m24456k3(final UserBackupInfo.UserDeviceInfo userDeviceInfo, int i10) {
        C11839m.m70688i("TempBackUpCheckActivity", "showTempBackupExpiryDialog ");
        final boolean zM80791C0 = C13452e.m80781L().m80791C0();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getQuantityString(R$plurals.temp_backup_will_delete_title, i10, Integer.valueOf(i10))).setMessage(zM80791C0 ? getResources().getQuantityString(R$plurals.temp_backup_will_delete_des, i10, userDeviceInfo.getDevDisplayName(), C0223k.m1524g(this, userDeviceInfo.getSize()), Integer.valueOf(i10)) : getResources().getQuantityString(R$plurals.temp_backup_will_delete_vip_des, i10, userDeviceInfo.getDevDisplayName(), C0223k.m1524g(this, userDeviceInfo.getSize()), Integer.valueOf(i10))).setNegativeButton(getString(R$string.save_later), new DialogInterface.OnClickListener() { // from class: zd.k0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                TempBackupCheckActivity.m24399Q2(dialogInterface, i11);
            }
        }).setPositiveButton(zM80791C0 ? getString(R$string.subscribe_for_save) : getString(R$string.temp_backup_save_to_user_space), new DialogInterface.OnClickListener() { // from class: zd.l0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                this.f63421a.m24439R2(zM80791C0, userDeviceInfo, dialogInterface, i11);
            }
        }).setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        this.f18355A = alertDialogCreate;
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: zd.m0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f63428a.m24440S2(dialogInterface);
            }
        });
        if (isFinishing() || isDestroyed()) {
            C11839m.m70688i("TempBackUpCheckActivity", "showTempBackupExpiryDialog isFinish or isDestroy");
        } else {
            if (m24465v2() || this.f18355A.isShowing()) {
                return;
            }
            this.f18355A.show();
        }
    }

    /* renamed from: l3 */
    public final void m24457l3() {
        AlertDialog alertDialog = this.f18374x;
        if (alertDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R$string.temp_backup_too_many_people_title)).setMessage(getString(R$string.temp_backup_too_many_people_content)).setNeutralButton(getString(R$string.cloud_space_dialog_know), new DialogInterface.OnClickListener() { // from class: zd.y
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.f63505a.m24441T2(dialogInterface, i10);
                }
            }).setCancelable(false);
            AlertDialog alertDialogCreate = builder.create();
            this.f18374x = alertDialogCreate;
            alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: zd.z
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    TempBackupCheckActivity.m24404U2(dialogInterface);
                }
            });
        } else if (alertDialog.isShowing()) {
            C11839m.m70688i("TempBackUpCheckActivity", "tooManyPeopleDialog is showing");
            return;
        }
        if (isFinishing() || isDestroyed()) {
            return;
        }
        this.f18374x.show();
    }

    /* renamed from: m3 */
    public final void m24458m3() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.bm.type");
        arrayList.add("bs.grade");
        List<C4987f> listM84949i = C14157f.m84942g().m84949i(null, arrayList, "tempBackup");
        if (listM84949i == null || listM84949i.isEmpty()) {
            return;
        }
        for (C4987f c4987f : listM84949i) {
            if (TextUtils.equals(c4987f.m30026b(), "bs.bm.type")) {
                try {
                    C13452e c13452eM80781L = C13452e.m80781L();
                    boolean z10 = true;
                    if (Integer.parseInt(c4987f.m30027c()) != 1) {
                        z10 = false;
                    }
                    c13452eM80781L.m80985w2(z10);
                } catch (NumberFormatException unused) {
                    C11839m.m70689w("TempBackUpCheckActivity", "updateBmAndGrade bm format err");
                }
            } else if (TextUtils.equals(c4987f.m30026b(), "bs.grade") && !TextUtils.isEmpty(c4987f.m30027c())) {
                C13452e.m80781L().m80940l1(c4987f.m30027c());
            }
        }
    }

    /* renamed from: o2 */
    public final void m24459o2(UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        C11839m.m70688i("TempBackUpCheckActivity", "checkTempBackUpDueDate");
        if (userDeviceInfo == null) {
            C11839m.m70688i("TempBackUpCheckActivity", "userDeviceInfo null");
            return;
        }
        if (m24465v2() || !this.f18356B) {
            C11839m.m70688i("TempBackUpCheckActivity", "checkTempBackUpDueDate limit " + this.f18356B);
            return;
        }
        long jM81078f = C13466f.m81073d().m81078f("temp_backup_latest_reminder_time", 0L);
        long jM81077e = C13466f.m81073d().m81077e("temp_backup_reminder_num", 0);
        long jM74028c = C12312h0.m74027b().m74028c() - jM81078f;
        TempBackupPolicy.SaveReminder saveReminder = this.f18361G.getSaveReminder();
        long jIntValue = saveReminder.getReminderInterval().intValue() * C5863b6.g.f26453g;
        long jIntValue2 = saveReminder.getReminderTimes().intValue();
        if (jM74028c <= jIntValue && jM81077e >= jIntValue2) {
            C11839m.m70689w("TempBackUpCheckActivity", "reminder dlg no match configInterval " + jIntValue + " less than interval= " + jM74028c + "and  alreadyRem " + jM81077e + " greater than configTimes " + jIntValue2);
            return;
        }
        Iterator it = ((ArrayList) Optional.ofNullable(userDeviceInfo.getExtraDeviceInfos()).orElse(new ArrayList())).iterator();
        int i10 = 1;
        while (it.hasNext()) {
            int expiratoryInDays = ((ExtraDeviceInfo) it.next()).getExpiratoryInDays();
            if (expiratoryInDays > 0) {
                i10 = expiratoryInDays;
            }
        }
        C11839m.m70688i("TempBackUpCheckActivity", "checkTempBackUpDueDate  expiratoryDays: " + i10);
        if (i10 <= saveReminder.getDeadlineReminder().intValue()) {
            m24456k3(userDeviceInfo, i10);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        AbstractC10896a.m65887i("TempBackUpCheckActivity", "onActivityResult, requestCode = " + i10 + ", resultCode = " + i11);
        boolean booleanExtra = intent != null ? new SafeIntent(intent).getBooleanExtra("is_upgrade_success", false) : false;
        if (i10 == 1002) {
            if (booleanExtra) {
                m24452g3(this.f18359E);
                return;
            }
            return;
        }
        if (i10 == 1003) {
            if (booleanExtra) {
                m24459o2(this.f18359E);
                return;
            } else {
                m24442V2();
                return;
            }
        }
        if (i10 == 1004) {
            if (booleanExtra) {
                m24452g3(this.f18359E);
            }
        } else {
            if (i10 != 1001 || i11 != 10001) {
                if (i10 == 10024 && i11 == 101) {
                    this.f18362H.m24336i(new SafeIntent(intent).getStringExtra("bak_id"));
                    return;
                }
                return;
            }
            Intent intent2 = new Intent(this, (Class<?>) CloudBackupDetailStateActivity.class);
            intent2.putExtra("entry_source", "entry_backup_temp_detail");
            intent2.putExtra("isTempBackup", true);
            startActivity(intent2);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        C4012a.m24631O("event_id_user_click_exit_page", "onBackPressed", "TempBackUpCheckActivity");
        super.onBackPressed();
        m22378l1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70874v1(this, this.f18370t);
        m24416f3();
        C12806c.m76820k(this, this.f18357C);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        getWindow().setFlags(16777216, 16777216);
        this.f18366p = this;
        m24464u2();
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "TempBackupCheckActivity oncreate");
        C13225d.m79490f1().m79567R("event_id_check_page", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_check_page", "4", "66", linkedHashMapM79497A);
        C12808e.m76824c(this);
        C11842p.m70889z0(this);
        setContentView(R$layout.activity_temp_back_up_check);
        C11839m.m70688i("TempBackUpCheckActivity", "start task");
        boolean zHasValidTempBackup = CBAccess.hasValidTempBackup();
        C11839m.m70688i("TempBackUpCheckActivity", "isExistTempBackup: " + zHasValidTempBackup);
        if (zHasValidTempBackup) {
            Intent intent = new Intent(this, (Class<?>) CloudBackupDetailStateActivity.class);
            intent.putExtra("entry_source", "entry_backup_temp_detail");
            intent.putExtra("isTempBackup", true);
            startActivity(intent);
            finish();
        }
        this.f18367q = (FrameLayout) C12809f.m76829b(this, R$id.fl_main);
        this.f18368r = (ScrollView) C12809f.m76829b(this, R$id.scroll);
        this.f18362H = (TempMainPageRecordFragment) C12809f.m76828a(getFragmentManager(), R$id.fragment_temp_backup_records);
        this.f18370t = (RelativeLayout) C12809f.m76829b(this, R$id.rl_btn);
        this.f18371u = (HwProgressBar) C12809f.m76829b(this, R$id.load_progress);
        this.f18372v = (HwProgressBar) C12809f.m76829b(this, R$id.progress);
        this.f18373w = (AutoSizeButton) C12809f.m76829b(this, R$id.btn_backup);
        SpanClickText spanClickText = (SpanClickText) C12809f.m76829b(this, R$id.sctv_special_links);
        String strM24662s = C4012a.m24662s("temp_backup_special_links", getString(R$string.temp_backup_special_links), new Object[0]);
        spanClickText.m15931c(strM24662s, new SpanClickText.ISpanClickListener() { // from class: zd.d0
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() throws IllegalAccessException, IllegalArgumentException {
                this.f63373a.m24428B2();
            }
        });
        spanClickText.m15934g(strM24662s, false);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.tv_check_title);
        textView.setVisibility(0);
        textView.setText(C4012a.m24662s("temp_backup_check_page_title_extra", getString(R$string.temp_backup_check_page_title_extra), new Object[0]));
        C11842p.m70874v1(this, this.f18370t);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.tv_check_tips);
        textView2.setVisibility(0);
        textView2.setText(C4012a.m24662s("temp_backup_check_page_tips", getString(R$string.temp_backup_check_page_tips), new Object[0]));
        m24416f3();
        mo19005p1();
        mo22366F1();
        m24463t2();
        m24449c3();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.f18364J, intentFilter, "com.huawei.cg.permission.SERVICE", null);
        C12600v1.m76049g(getIntent());
        CloudBackupService.getInstance().register(this.f18365K);
        m24442V2();
        m24444X2();
        m24425q2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.f18374x;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog alertDialog2 = this.f18375y;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        AlertDialog alertDialog3 = this.f18376z;
        if (alertDialog3 != null) {
            alertDialog3.dismiss();
        }
        AlertDialogC13156c alertDialogC13156c = this.f18358D;
        if (alertDialogC13156c != null) {
            alertDialogC13156c.dismiss();
        }
        BroadcastReceiver broadcastReceiver = this.f18364J;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.f18364J = null;
        }
        AlertDialog alertDialog4 = this.f18355A;
        if (alertDialog4 != null && alertDialog4.isShowing()) {
            this.f18355A.dismiss();
        }
        CloudBackupService.getInstance().unregister(this.f18365K);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C12600v1.m76049g(getIntent());
        m24442V2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: p1 */
    public void mo19005p1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(C12809f.m76829b(this, R$id.notch_rl_temp_backup_check));
        arrayList.add(this.f18370t);
        List<List<View>> listM70887y2 = C11842p.m70887y2(arrayList);
        if (C0219i.m1463a() >= 17 && C11829c.m70563b0(this)) {
            C12806c.m76821l(this, arrayList);
            C12806c.m76820k(this, listM70887y2.get(1));
        }
        List<View> list = listM70887y2.get(0);
        if (list != null && !list.isEmpty()) {
            this.f18357C.addAll(list);
        }
        C12806c.m76820k(this, list);
    }

    /* renamed from: p2 */
    public final void m24460p2(UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        if (userDeviceInfo == null) {
            C11839m.m70688i("TempBackUpCheckActivity", "checkUserSpaceEnough  latestBackupInfo: null ");
            return;
        }
        QuotaSpaceInfo quotaSpaceInfoM80224M = C13368e.m80184F().m80224M();
        if (BackupAppEstimateUtil.isSpaceEnoughForBackup(quotaSpaceInfoM80224M.getAvailable(), quotaSpaceInfoM80224M.getTotal(), userDeviceInfo.getSize(), 0L)) {
            m24452g3(userDeviceInfo);
        } else {
            m24455j3(userDeviceInfo);
        }
    }

    /* renamed from: r2 */
    public final void m24461r2(List<UserBackupInfo.UserDeviceInfo> list) {
        if (list != null && !list.isEmpty()) {
            int i10 = Integer.MAX_VALUE;
            for (UserBackupInfo.UserDeviceInfo userDeviceInfo : list) {
                ArrayList<ExtraDeviceInfo> extraDeviceInfos = userDeviceInfo.getExtraDeviceInfos();
                if (extraDeviceInfos != null) {
                    Iterator<ExtraDeviceInfo> it = extraDeviceInfos.iterator();
                    int i11 = 1;
                    while (true) {
                        if (it.hasNext()) {
                            ExtraDeviceInfo next = it.next();
                            Integer occupySpaceType = next.getOccupySpaceType();
                            C11839m.m70688i("TempBackUpCheckActivity", "spaceType " + occupySpaceType);
                            if (occupySpaceType == null || occupySpaceType.intValue() != 1) {
                                int expiratoryInDays = next.getExpiratoryInDays();
                                if (expiratoryInDays > 0) {
                                    i11 = expiratoryInDays + 1;
                                }
                            }
                        } else if (i11 < i10) {
                            this.f18359E = userDeviceInfo;
                            i10 = i11;
                        }
                    }
                }
            }
        }
        m24459o2(this.f18359E);
    }

    /* renamed from: s2 */
    public final void m24462s2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.bm.type");
        arrayList.add("bs.bm.usergrade.info");
        C12515a.m75110o().m75175e(new C11079e(new C11079e.a() { // from class: zd.g0
            @Override // p431ko.C11079e.a
            /* renamed from: a */
            public final void mo14511a(UserDataStateInfo userDataStateInfo) {
                this.f63398a.m24468y2(userDataStateInfo);
            }
        }, false, arrayList, "tempBackup"), false);
        m24447a3(false);
    }

    /* renamed from: t2 */
    public final void m24463t2() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R$string.temp_backup_action_bar_title);
        }
    }

    /* renamed from: u2 */
    public final void m24464u2() {
        TempBackupPolicy tempBackupPolicyM75361S0 = new C12526j().m75361S0();
        TempBackupPolicy.SaveReminder saveReminder = new TempBackupPolicy.SaveReminder();
        if (tempBackupPolicyM75361S0 == null) {
            this.f18361G.setSaveReminder(saveReminder);
            return;
        }
        this.f18361G.setBusinessModeChangePage(tempBackupPolicyM75361S0.getBusinessModeChangePage());
        TempBackupPolicy.SaveReminder saveReminder2 = tempBackupPolicyM75361S0.getSaveReminder();
        if (saveReminder2 != null) {
            if (saveReminder2.getReminderInterval() != null) {
                saveReminder.setReminderInterval(saveReminder2.getReminderInterval());
            }
            if (saveReminder2.getReminderTimes() != null) {
                saveReminder.setReminderTimes(saveReminder2.getReminderTimes());
            }
            if (saveReminder2.getDeadlineReminder() != null) {
                saveReminder.setDeadlineReminder(saveReminder2.getDeadlineReminder());
            }
        }
        this.f18361G.setSaveReminder(saveReminder);
    }

    /* renamed from: v2 */
    public final boolean m24465v2() {
        AlertDialog alertDialog = this.f18374x;
        if (alertDialog != null && alertDialog.isShowing()) {
            C11839m.m70688i("TempBackUpCheckActivity", "tooManyPeopleDialog showing ");
            return true;
        }
        AlertDialog alertDialog2 = this.f18375y;
        if (alertDialog2 != null && alertDialog2.isShowing()) {
            C11839m.m70688i("TempBackUpCheckActivity", "serverErrorDialog showing ");
            return true;
        }
        AlertDialog alertDialog3 = this.f18376z;
        if (alertDialog3 != null && alertDialog3.isShowing()) {
            C11839m.m70688i("TempBackUpCheckActivity", "limitTimesDialog showing ");
            return true;
        }
        AlertDialog alertDialog4 = this.f18355A;
        if (alertDialog4 != null && alertDialog4.isShowing()) {
            C11839m.m70688i("TempBackUpCheckActivity", "tempBackUpExpiryDialog showing ");
            return true;
        }
        AlertDialogC13156c alertDialogC13156c = this.f18358D;
        if (alertDialogC13156c == null || !alertDialogC13156c.isShowing()) {
            return false;
        }
        C11839m.m70688i("TempBackUpCheckActivity", "noNetDialog showing ");
        return true;
    }

    /* renamed from: w2 */
    public final void m24466w2() {
        if (TextUtils.isEmpty(this.f18361G.getBusinessModeChangePage())) {
            return;
        }
        C13227f.m79492i1().m79585f0("mecloud_cloud_temp_backup_click", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_cloud_temp_backup_click", "1", "4");
        SafeIntent safeIntent = new SafeIntent(new Intent());
        safeIntent.putExtra("srcChannel", "0");
        safeIntent.putExtra("salChannel", "0");
        C11273b.m67657l(this, this.f18361G.getBusinessModeChangePage(), safeIntent, "");
        finish();
    }

    /* renamed from: x2 */
    public final /* synthetic */ void m24467x2() {
        m24447a3(true);
        startActivityForResult(new Intent(this, (Class<?>) TempBackupMainActivity.class), 1001);
    }

    /* renamed from: y2 */
    public final /* synthetic */ void m24468y2(UserDataStateInfo userDataStateInfo) {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (userDataStateInfo != null && userDataStateInfo.getBmType() != -1) {
            if (!TextUtils.isEmpty(userDataStateInfo.getBsGrade())) {
                C11839m.m70688i("TempBackUpCheckActivity", "bs grade:" + userDataStateInfo.getBsGrade());
                C13452e.m80781L().m80940l1(userDataStateInfo.getBsGrade());
            }
            if (userDataStateInfo.getBmType() == 1) {
                C13452e.m80781L().m80985w2(true);
                C11839m.m70688i("TempBackUpCheckActivity", "new bm type:true");
            } else if (userDataStateInfo.getBmType() == 0) {
                C11839m.m70688i("TempBackUpCheckActivity", "new bm type:false");
                C13452e.m80781L().m80985w2(false);
            }
            if (interfaceC9282a != null) {
                C11839m.m70688i("TempBackUpCheckActivity", "bm grade state and period: " + userDataStateInfo.getBmGradeState() + ", " + userDataStateInfo.getDataPeriod());
                interfaceC9282a.mo58410a1(userDataStateInfo.getBmGradeState(), userDataStateInfo.getDataPeriod());
                interfaceC9282a.mo58399V0(System.currentTimeMillis());
            }
        }
        if (isFinishing() || isDestroyed()) {
            C11839m.m70689w("TempBackUpCheckActivity", "activity is finishing or destroy");
        } else {
            C4012a.m24632P();
            C0226l0.m1584d(new Runnable() { // from class: zd.h0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f63404a.m24467x2();
                }
            });
        }
    }
}
