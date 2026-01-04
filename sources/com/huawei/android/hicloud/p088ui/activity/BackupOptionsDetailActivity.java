package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.process.task.GetOptionsInfoFromCloneTask;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.AutoStyleButtonAnnotation;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiadapter.RecyclerViewBackupOptionAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupThirdAppOpenNotEnoughDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.CloseOptionStatusDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.SpaceSwitchOpenTipsDialog;
import com.huawei.android.hicloud.p088ui.uiutil.NewHiSyncUtil;
import com.huawei.android.hicloud.task.simple.C3048j2;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p015ak.C0226l0;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p550pb.C12126b;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p617rl.C12526j;
import p618rm.C12580p;
import p618rm.C12590s0;
import p674ub.C13149f;
import p684un.C13222a;
import p684un.C13225d;
import p684un.C13230i;
import p703v8.C13367d;
import p703v8.C13368e;
import p709vj.C13452e;
import p711vl.C13465e;
import p783xp.C13843a;
import sk.C12806c;
import sk.C12809f;
import tl.C13026e;

@AutoStyleButtonAnnotation
/* loaded from: classes3.dex */
public class BackupOptionsDetailActivity extends CloudBackupBaseUiActivity implements View.OnClickListener, AdapterView.OnItemClickListener, SearchView.OnQueryTextListener, CompoundButton.OnCheckedChangeListener, RecyclerViewBackupOptionAdapter.UpdateOptionStatusListener {

    /* renamed from: C */
    public RecyclerView f13759C;

    /* renamed from: D */
    public NotchTopFitRelativeLayout f13760D;

    /* renamed from: E */
    public NotchFitLinearLayout f13761E;

    /* renamed from: F */
    public C13026e f13762F;

    /* renamed from: G */
    public CloseOptionStatusDialog f13763G;

    /* renamed from: H */
    public SearchView f13764H;

    /* renamed from: I */
    public UnionSwitch f13765I;

    /* renamed from: J */
    public LinearLayout f13766J;

    /* renamed from: K */
    public LinearLayout f13767K;

    /* renamed from: L */
    public RelativeLayout f13768L;

    /* renamed from: M */
    public View f13769M;

    /* renamed from: R */
    public int f13774R;

    /* renamed from: S */
    public boolean f13775S;

    /* renamed from: V */
    public SpaceSwitchOpenTipsDialog f13778V;

    /* renamed from: W */
    public CloudSpace f13779W;

    /* renamed from: Y */
    public boolean f13781Y;

    /* renamed from: Z */
    public boolean f13782Z;

    /* renamed from: b0 */
    public String f13784b0;

    /* renamed from: c0 */
    public boolean f13785c0;

    /* renamed from: d0 */
    public QuotaSpaceInfo f13786d0;

    /* renamed from: g0 */
    public RecyclerViewBackupOptionAdapter f13789g0;

    /* renamed from: h0 */
    public LinearLayoutManager f13790h0;

    /* renamed from: N */
    public List<BackupOptionItem> f13770N = new ArrayList();

    /* renamed from: O */
    public final List<BackupOptionItem> f13771O = new ArrayList();

    /* renamed from: P */
    public boolean f13772P = false;

    /* renamed from: Q */
    public boolean f13773Q = false;

    /* renamed from: T */
    public boolean f13776T = false;

    /* renamed from: U */
    public BackupThirdAppOpenNotEnoughDialog f13777U = null;

    /* renamed from: X */
    public boolean f13780X = false;

    /* renamed from: a0 */
    public C13149f f13783a0 = new C13149f();

    /* renamed from: e0 */
    public boolean f13787e0 = false;

    /* renamed from: f0 */
    public boolean f13788f0 = false;

    /* renamed from: i0 */
    public boolean f13791i0 = false;

    /* renamed from: j0 */
    public boolean f13792j0 = false;

    /* renamed from: k0 */
    public Handler.Callback f13793k0 = new Handler.Callback() { // from class: com.huawei.android.hicloud.ui.activity.i1
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f17634a.m19033K2(message);
        }
    };

    /* renamed from: l0 */
    public AbstractC12367d f13794l0 = new C3152b();

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsDetailActivity$a */
    public class C3151a extends RecyclerView.AbstractC0850t {
        public C3151a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            super.onScrolled(recyclerView, i10, i11);
            if (BackupOptionsDetailActivity.this.f13782Z) {
                int iFindFirstVisibleItemPosition = BackupOptionsDetailActivity.this.f13790h0.findFirstVisibleItemPosition();
                C11839m.m70688i("BackupOptionsDetailActivity", "onScrolled newState = firstVisibleItem" + iFindFirstVisibleItemPosition + " isSearchEmptyData = " + BackupOptionsDetailActivity.this.f13775S);
                if (BackupOptionsDetailActivity.this.f13775S || iFindFirstVisibleItemPosition == 0) {
                    BackupOptionsDetailActivity.this.f13766J.setVisibility(4);
                } else {
                    BackupOptionsDetailActivity.this.f13766J.setVisibility(0);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsDetailActivity$b */
    public class C3152b extends AbstractC12367d {
        public C3152b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f */
        public /* synthetic */ void m19089f() {
            BackupOptionsDetailActivity.this.f13782Z = true;
            BackupOptionsDetailActivity.this.mo19236O1();
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            boolean z10;
            List<BackupOptionItem> listM78399w = BackupOptionsDetailActivity.this.f13762F.m78399w("thirdAppData");
            if (listM78399w == null || listM78399w.isEmpty()) {
                return;
            }
            listM78399w.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.l1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C12580p.m75575i((BackupOptionItem) obj, (BackupOptionItem) obj2);
                }
            });
            BackupOptionsDetailActivity.this.f13770N = listM78399w;
            Iterator it = BackupOptionsDetailActivity.this.f13770N.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z10 = true;
                    break;
                } else if (!((BackupOptionItem) it.next()).getBackupSwitch()) {
                    z10 = false;
                    break;
                }
            }
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.m1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17670a.m19089f();
                }
            });
            if (!BackupOptionsDetailActivity.this.f13776T) {
                BackupOptionsDetailActivity.this.m19037S2(33012, Boolean.valueOf(z10));
            }
            C11839m.m70688i("BackupOptionsDetailActivity", "initThirdAppList: " + new Gson().toJson(listM78399w));
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsDetailActivity$c */
    public class C3153c implements BackupThirdAppOpenNotEnoughDialog.NotEnoughDialogClickCallback {
        public C3153c() {
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.BackupThirdAppOpenNotEnoughDialog.NotEnoughDialogClickCallback
        public void onCancel() {
            BackupOptionsDetailActivity.this.m19036R2("param_cancel_click");
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.BackupThirdAppOpenNotEnoughDialog.NotEnoughDialogClickCallback
        public void onJumpManagerSpacePage() {
            BackupOptionsDetailActivity.this.startActivity(new Intent(BackupOptionsDetailActivity.this, (Class<?>) HisyncSpaceDetailActivity.class));
            if (BackupOptionsDetailActivity.this.f13777U != null) {
                BackupOptionsDetailActivity.this.f13777U.dismiss();
            }
            BackupOptionsDetailActivity.this.m19036R2("param_manager_click");
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.BackupThirdAppOpenNotEnoughDialog.NotEnoughDialogClickCallback
        public void onJumpUpgradeCloudSpace() {
            Bundle bundle = new Bundle();
            bundle.putInt("nav_source", 15);
            C12126b.m72707c("2", bundle);
            if (BackupOptionsDetailActivity.this.f13777U != null) {
                BackupOptionsDetailActivity.this.f13777U.dismiss();
            }
            BackupOptionsDetailActivity.this.m19036R2("param_upgrade_click");
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsDetailActivity$d */
    public class C3154d implements SpaceSwitchOpenTipsDialog.DialogClickCallback {
        public C3154d() {
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.SpaceSwitchOpenTipsDialog.DialogClickCallback
        public void onSpaceRunningOutCancel() {
            BackupOptionsDetailActivity.this.f13765I.setCheckedProgrammatically(false);
            BackupOptionsDetailActivity.this.f13789g0.m25085K(false);
            C13225d.m79490f1().m79585f0("action_code_backup_switch_open_tips_cancel", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "action_code_backup_switch_open_tips_cancel", "1", "17");
            BackupOptionsDetailActivity.this.f13778V.dismiss();
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.SpaceSwitchOpenTipsDialog.DialogClickCallback
        public void onSpaceRunningOutOpen() {
            BackupOptionsDetailActivity.this.m19067M2(true);
            C13225d.m79490f1().m79585f0("action_code_backup_switch_open_tips_ok", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "action_code_backup_switch_open_tips_ok", "1", "17");
            BackupOptionsDetailActivity.this.f13778V.dismiss();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsDetailActivity$e */
    public class C3155e implements SpaceSwitchOpenTipsDialog.DialogClickCallback {

        /* renamed from: a */
        public final /* synthetic */ String f13799a;

        public C3155e(String str) {
            this.f13799a = str;
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.SpaceSwitchOpenTipsDialog.DialogClickCallback
        public void onSpaceRunningOutCancel() {
            BackupOptionsDetailActivity.this.f13789g0.m25095U(this.f13799a, false);
            C13225d.m79490f1().m79585f0("action_code_backup_switch_open_tips_cancel", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "action_code_backup_switch_open_tips_cancel", "1", "17");
            BackupOptionsDetailActivity.this.f13778V.dismiss();
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.SpaceSwitchOpenTipsDialog.DialogClickCallback
        public void onSpaceRunningOutOpen() {
            if (!TextUtils.isEmpty(this.f13799a)) {
                BackupOptionsDetailActivity.this.m19058n2(this.f13799a);
            }
            C13225d.m79490f1().m79585f0("action_code_backup_switch_open_tips_ok", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "action_code_backup_switch_open_tips_ok", "1", "17");
            BackupOptionsDetailActivity.this.f13778V.dismiss();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsDetailActivity$f */
    public class C3156f extends AbstractC12367d {
        public C3156f() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            BackupOptionsDetailActivity.this.f13779W = C13367d.m80180e().m80181d();
            C11839m.m70688i("BackupOptionsDetailActivity", "initCloudSpace , cloudSpace = " + BackupOptionsDetailActivity.this.f13779W);
        }
    }

    /* renamed from: A2 */
    private void m19028A2() {
        this.f13786d0 = C13368e.m80184F().m80224M();
        C11839m.m70688i("BackupOptionsDetailActivity", "initCloudSpace , cahcedSpaceInfo = " + this.f13786d0);
        if (C0209d.m1333z1(this)) {
            C12515a.m75110o().m75175e(new C3156f(), true);
        }
    }

    /* renamed from: B2 */
    private void m19029B2() {
        m19030C2();
        mo22385x1();
        m19085z2();
    }

    /* renamed from: C2 */
    private void m19030C2() {
        if (this.f13781Y) {
            C11839m.m70688i("BackupOptionsDetailActivity", "isDirectEnter: isDirectEnter");
            C12515a.m75110o().m75172d(new GetOptionsInfoFromCloneTask(false));
        }
        this.f13762F = new C13026e();
        this.f13773Q = new C12526j().m75369W0();
        C11839m.m70688i("BackupOptionsDetailActivity", "switch3rdDefault: " + this.f13773Q);
        if (C10028c.m62182c0().m62325f1() && C13465e.m81052f().m81055c("is_can_show_options_detail_guide", true) && C12590s0.m75791R0()) {
            m19061D2();
        }
        C12515a.m75110o().m75172d(this.f13794l0);
    }

    /* renamed from: F2 */
    private void m19031F2() {
        LayoutInflater.from(this).inflate(R$layout.activity_backup_option_detail, (ViewGroup) this.f13894y, true);
        this.f13760D = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f13761E = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.record_detail_list);
        this.f13766J = (LinearLayout) C12809f.m76829b(this, R$id.rl_cb_all_main);
        this.f13759C = (RecyclerView) C12809f.m76829b(this, R$id.rc_third_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.f13790h0 = linearLayoutManager;
        this.f13759C.setLayoutManager(linearLayoutManager);
        RecyclerViewBackupOptionAdapter recyclerViewBackupOptionAdapter = new RecyclerViewBackupOptionAdapter(this);
        this.f13789g0 = recyclerViewBackupOptionAdapter;
        recyclerViewBackupOptionAdapter.m25089O(this);
        this.f13759C.setAdapter(this.f13789g0);
        this.f13759C.setItemAnimator(null);
        this.f13765I = (UnionSwitch) C12809f.m76829b(this, R$id.backup_main_switch_btn);
        this.f13764H = (SearchView) C12809f.m76829b(this, R$id.searchview);
        this.f13767K = (LinearLayout) C12809f.m76829b(this, R$id.linear_search_view);
        this.f13768L = (RelativeLayout) C12809f.m76829b(this, R$id.rl_cb_all_main_layout);
        this.f13769M = C12809f.m76829b(this, R$id.backup_option_item_divider_main);
        this.f13766J.setVisibility(8);
        this.f13764H.setOnQueryTextListener(this);
        this.f13765I.setOnCheckedChangeListener(this);
        this.f13888s.setOnClickListener(this);
        this.f13895z.setOnClickListener(this);
        this.f13763G = new CloseOptionStatusDialog(this);
        this.f13759C.addOnScrollListener(new C3151a());
    }

    /* renamed from: J2 */
    public static /* synthetic */ void m19032J2(View view, View view2) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K2 */
    public /* synthetic */ boolean m19033K2(Message message) {
        if (this.f13787e0) {
            m19081u2(message);
            return false;
        }
        int i10 = message.what;
        if (i10 == 33024) {
            m19082v2(message.arg1);
            return false;
        }
        if (i10 != 33043) {
            return false;
        }
        this.f13779W = (CloudSpace) message.obj;
        m19080t2(message.arg1);
        return false;
    }

    /* renamed from: O2 */
    private void m19034O2() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f13774R = safeIntent.getIntExtra("source", -1);
        this.f13792j0 = safeIntent.getBooleanExtra("showDeleteFlag", false);
        this.f13781Y = safeIntent.getBooleanExtra("direct_enter", false);
    }

    /* renamed from: Q2 */
    private void m19035Q2() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("key_backup_appdata_open_switch_dialog_show", String.valueOf(true));
        C13225d.m79490f1().m79567R("action_code_backup_appdata_open_switch_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "action_code_backup_appdata_open_switch_dialog", linkedHashMapM79497A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R2 */
    public void m19036R2(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("backup_records_click_type", str);
        C13225d.m79490f1().m79567R("action_code_backup_appdata_open_switch_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "action_code_backup_appdata_open_switch_dialog", linkedHashMapM79497A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S2 */
    public void m19037S2(int i10, Object obj) {
        Message message = new Message();
        message.what = i10;
        if (obj != null) {
            message.obj = obj;
        }
        CBCallBack.getInstance().sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n2 */
    public void m19058n2(String str) {
        this.f13772P = true;
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, false);
        if (backupOptionItemQueryItem == null) {
            m19083w2("thirdAppData", str);
        }
        this.f13762F.m78376K(true, str);
        this.f13789g0.m25095U(str, true);
        m19063G2();
        C12515a.m75110o().m75172d(new C3048j2(str, true, this.f13774R, false, backupOptionItemQueryItem != null ? backupOptionItemQueryItem.getDataBytes() : 0L, false, this.f13789g0.m25082H()));
        C11839m.m70688i("BackupOptionsDetailActivity", "onCheckChanged appId: " + str + ", switch: true");
    }

    /* renamed from: o2 */
    private void m19059o2() {
        Intent intent = new Intent();
        intent.putExtra("isNeedReportSwitchState", this.f13772P);
        setResult(0, intent);
        finish();
    }

    /* renamed from: y2 */
    private void m19060y2() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        m22365E1(R$string.frag_app_data_title);
        if (C0219i.m1463a() < 14 || C0219i.m1463a() >= 17) {
            ActionBar actionBar = getActionBar();
            int i10 = R$color.hicloud_hmos_bg;
            C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
            actionBar.setBackgroundDrawable(new ColorDrawable(getColor(i10)));
            Window window = getWindow();
            if (window != null) {
                window.setStatusBarColor(getColor(i10));
            }
        }
    }

    /* renamed from: D2 */
    public final void m19061D2() {
        final View viewM76829b = C12809f.m76829b(this, R$id.option_detail_header_guide_layout);
        C12809f.m76829b(this, R$id.option_detail_header_guide_close).setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.k1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BackupOptionsDetailActivity.m19032J2(viewM76829b, view);
            }
        });
        viewM76829b.setVisibility(0);
        C13465e.m81052f().m81064m("is_can_show_options_detail_guide", false);
    }

    /* renamed from: E2 */
    public void m19062E2() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        m19060y2();
        m19031F2();
        mo19005p1();
        m19034O2();
    }

    /* renamed from: G2 */
    public final void m19063G2() {
        boolean z10 = false;
        if (!this.f13789g0.m25082H().isEmpty()) {
            Iterator<BackupOptionItem> it = this.f13789g0.m25082H().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z10 = true;
                    break;
                } else if (!it.next().getBackupSwitch()) {
                    break;
                }
            }
        }
        this.f13765I.setCheckedProgrammatically(z10);
        this.f13789g0.m25085K(z10);
    }

    /* renamed from: H2 */
    public final boolean m19064H2(long j10, long j11) {
        long used;
        long total;
        CloudSpace cloudSpace = this.f13779W;
        if (cloudSpace == null) {
            QuotaSpaceInfo quotaSpaceInfo = this.f13786d0;
            if (quotaSpaceInfo == null) {
                C11839m.m70688i("BackupOptionsDetailActivity", "isSpaceEnough , bakSize == null || cloudSpace == null");
                return true;
            }
            used = quotaSpaceInfo.getUsed();
            total = this.f13786d0.getTotal();
        } else {
            used = cloudSpace.getUsed();
            total = this.f13779W.getTotal();
        }
        C11839m.m70688i("BackupOptionsDetailActivity", "isSpaceEnough , used  = " + used + " , total = " + total + " , getIncrease = " + j10 + " , incrementSize " + j11);
        return total - used >= j11 + j10;
    }

    /* renamed from: I2 */
    public final boolean m19065I2(String str, long j10) {
        long used;
        long total;
        CloudSpace cloudSpace = this.f13779W;
        if (cloudSpace == null) {
            QuotaSpaceInfo quotaSpaceInfo = this.f13786d0;
            if (quotaSpaceInfo == null) {
                C11839m.m70688i("BackupOptionsDetailActivity", "isSpaceEnough , bakSize == null || cloudSpace == null");
                return true;
            }
            used = quotaSpaceInfo.getUsed();
            total = this.f13786d0.getTotal();
        } else {
            used = cloudSpace.getUsed();
            total = this.f13779W.getTotal();
        }
        BackupOptionItem backupOptionItemQueryMergeTwinItem = TransferedUtil.queryMergeTwinItem(str, false);
        long totalIncrease = backupOptionItemQueryMergeTwinItem != null ? backupOptionItemQueryMergeTwinItem.getTotalIncrease() : 0L;
        C11839m.m70688i("BackupOptionsDetailActivity", "isSpaceEnough , used  = " + used + " , total = " + total + " , getIncrease = " + j10 + " , checkSize " + totalIncrease);
        return total - used >= j10 + totalIncrease;
    }

    /* renamed from: L2 */
    public final void m19066L2() {
        if (this.f13781Y) {
            CloudBackupService.getInstance().refreshSwitchStatusAsync(false);
        } else {
            m19069P2();
        }
        m19238R1();
    }

    /* renamed from: M2 */
    public void m19067M2(boolean z10) {
        this.f13789g0.m25085K(z10);
        this.f13765I.setCheckedProgrammatically(z10);
        Iterator<BackupOptionItem> it = this.f13789g0.m25082H().iterator();
        while (it.hasNext()) {
            String appId = it.next().getAppId();
            if (TransferedUtil.queryItem(appId, false) == null) {
                m19083w2("thirdApp", appId);
            }
            this.f13762F.m78376K(z10, appId);
            this.f13789g0.m25095U(appId, z10);
        }
        C11839m.m70688i("BackupOptionsDetailActivity", "onAllItemCheckChange");
    }

    /* renamed from: N2 */
    public void m19068N2(String str, boolean z10, boolean z11) {
        this.f13765I.setCheckedProgrammatically(z10);
        this.f13789g0.m25085K(z10);
        this.f13772P = true;
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, false);
        if (backupOptionItemQueryItem == null) {
            m19083w2("thirdAppData", str);
        }
        this.f13762F.m78376K(z10, str);
        this.f13789g0.m25095U(str, z10);
        C12515a.m75110o().m75172d(new C3048j2(str, z10, this.f13774R, z11, backupOptionItemQueryItem != null ? backupOptionItemQueryItem.getDataBytes() : 0L, false, this.f13789g0.m25082H()));
        C11839m.m70688i("BackupOptionsDetailActivity", "onThirdAppItemChanged appId: " + str + ", switch: " + z10);
    }

    /* renamed from: P2 */
    public final void m19069P2() {
        this.f13791i0 = true;
        this.f13786d0 = C13368e.m80184F().m80224M();
        CloudBackupService.getInstance().queryCloudSpaceByServer();
    }

    /* renamed from: T2 */
    public final void m19070T2(boolean z10) {
        if (this.f13759C == null) {
            return;
        }
        if (z10) {
            this.f13768L.setBackground(getDrawable(R$drawable.cardview_list_top_shape_white));
            this.f13769M.setVisibility(0);
        } else {
            this.f13768L.setBackground(getDrawable(R$drawable.storage_manage_cardview_list_shape_white));
            this.f13769M.setVisibility(8);
        }
    }

    /* renamed from: U2 */
    public final void m19071U2(String str) {
        if (str.isEmpty()) {
            this.f13775S = false;
            this.f13776T = false;
            this.f13770N.sort(new C3765j1());
            this.f13789g0.m25082H().clear();
            this.f13789g0.m25082H().addAll(this.f13770N);
            this.f13789g0.m25088N(this.f13770N, R$string.backup_option_detail_tip);
        } else {
            this.f13776T = true;
            this.f13771O.clear();
            for (BackupOptionItem backupOptionItem : this.f13770N) {
                String appName = backupOptionItem.getAppName();
                Locale locale = Locale.ENGLISH;
                if (appName.toLowerCase(locale).contains(str.toLowerCase(locale))) {
                    this.f13771O.add(backupOptionItem);
                }
            }
            if (this.f13771O.size() <= 0) {
                this.f13789g0.m25088N(null, R$string.app_not_install);
                this.f13775S = true;
            } else {
                this.f13771O.sort(new C3765j1());
                this.f13789g0.m25088N(this.f13771O, R$string.backup_option_detail_tip);
                this.f13775S = false;
            }
        }
        List<BackupOptionItem> listM25082H = this.f13789g0.m25082H();
        m19070T2((listM25082H == null || listM25082H.isEmpty()) ? false : true);
        m19063G2();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004d  */
    /* renamed from: V2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m19072V2(long r14, long r16) {
        /*
            r13 = this;
            r0 = r13
            com.huawei.hicloud.base.bean.CloudSpace r1 = r0.f13779W
            if (r1 != 0) goto L1b
            com.huawei.hicloud.base.bean.QuotaSpaceInfo r1 = r0.f13786d0
            if (r1 == 0) goto L16
            long r1 = r1.getAvailable()
            com.huawei.hicloud.base.bean.QuotaSpaceInfo r3 = r0.f13786d0
            long r3 = r3.getTotal()
        L13:
            r5 = r1
            r7 = r3
            goto L2d
        L16:
            r1 = 0
            r5 = r1
            r7 = r5
            goto L2d
        L1b:
            long r1 = r1.getTotal()
            com.huawei.hicloud.base.bean.CloudSpace r3 = r0.f13779W
            long r3 = r3.getUsed()
            long r1 = r1 - r3
            com.huawei.hicloud.base.bean.CloudSpace r3 = r0.f13779W
            long r3 = r3.getTotal()
            goto L13
        L2d:
            r9 = r14
            r11 = r16
            boolean r1 = com.huawei.android.hicloud.cloudbackup.process.util.BackupAppEstimateUtil.isSpaceRunningOut(r5, r7, r9, r11)
            r2 = 1
            if (r1 == 0) goto L4d
            com.huawei.android.hicloud.ui.common.UnionSwitch r1 = r0.f13765I
            r3 = 0
            r1.setCheckedProgrammatically(r3)
            com.huawei.android.hicloud.ui.uiextend.dialog.SpaceSwitchOpenTipsDialog r1 = new com.huawei.android.hicloud.ui.uiextend.dialog.SpaceSwitchOpenTipsDialog
            com.huawei.android.hicloud.ui.activity.BackupOptionsDetailActivity$d r3 = new com.huawei.android.hicloud.ui.activity.BackupOptionsDetailActivity$d
            r3.<init>()
            r1.<init>(r13, r2, r3)
            r0.f13778V = r1
            r1.show()
            goto L50
        L4d:
            r13.m19067M2(r2)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.BackupOptionsDetailActivity.m19072V2(long, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* renamed from: W2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m19073W2(java.lang.String r13, long r14) {
        /*
            r12 = this;
            com.huawei.hicloud.base.bean.CloudSpace r0 = r12.f13779W
            if (r0 != 0) goto L1a
            com.huawei.hicloud.base.bean.QuotaSpaceInfo r0 = r12.f13786d0
            if (r0 == 0) goto L15
            long r0 = r0.getAvailable()
            com.huawei.hicloud.base.bean.QuotaSpaceInfo r2 = r12.f13786d0
            long r2 = r2.getTotal()
        L12:
            r4 = r0
            r6 = r2
            goto L2c
        L15:
            r0 = 0
            r4 = r0
            r6 = r4
            goto L2c
        L1a:
            long r0 = r0.getTotal()
            com.huawei.hicloud.base.bean.CloudSpace r2 = r12.f13779W
            long r2 = r2.getUsed()
            long r0 = r0 - r2
            com.huawei.hicloud.base.bean.CloudSpace r2 = r12.f13779W
            long r2 = r2.getTotal()
            goto L12
        L2c:
            r0 = 0
            com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem r1 = com.huawei.android.hicloud.cloudbackup.util.TransferedUtil.queryMergeTwinItem(r13, r0)
            if (r1 != 0) goto L34
            return
        L34:
            long r10 = r1.getTotalIncrease()
            r8 = r14
            boolean r14 = com.huawei.android.hicloud.cloudbackup.process.util.BackupAppEstimateUtil.isSpaceRunningOut(r4, r6, r8, r10)
            if (r14 == 0) goto L58
            com.huawei.android.hicloud.ui.uiadapter.RecyclerViewBackupOptionAdapter r14 = r12.f13789g0
            r14.m25095U(r13, r0)
            com.huawei.android.hicloud.ui.uiextend.dialog.SpaceSwitchOpenTipsDialog r14 = new com.huawei.android.hicloud.ui.uiextend.dialog.SpaceSwitchOpenTipsDialog
            java.lang.String r15 = r1.getAppName()
            com.huawei.android.hicloud.ui.activity.BackupOptionsDetailActivity$e r0 = new com.huawei.android.hicloud.ui.activity.BackupOptionsDetailActivity$e
            r0.<init>(r13)
            r14.<init>(r12, r15, r0)
            r12.f13778V = r14
            r14.show()
            goto L5b
        L58:
            r12.m19058n2(r13)
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.BackupOptionsDetailActivity.m19073W2(java.lang.String, long):void");
    }

    /* renamed from: X2 */
    public final void m19074X2(BackupOptionItem backupOptionItem) {
        if (backupOptionItem != null) {
            C11839m.m70688i("BackupOptionsDetailActivity", "updateOneModule: " + new Gson().toJson(backupOptionItem));
            this.f13789g0.m25096V(backupOptionItem);
        }
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.RecyclerViewBackupOptionAdapter.UpdateOptionStatusListener
    /* renamed from: c */
    public void mo19075c(int i10, String str, boolean z10) {
        if (z10) {
            if (!this.f13780X) {
                this.f13784b0 = str;
                m19078r2(str, false);
                return;
            } else {
                C11839m.m70688i("BackupOptionsDetailActivity", "onCheckChanged , isOpenSwitchCalculate = true , return");
                this.f13789g0.m25095U(str, false);
                C11841o.m70708d(this, getString(R$string.backup_check_no_enough_loading), 0);
                return;
            }
        }
        if (this.f13780X && TextUtils.equals(this.f13784b0, str)) {
            this.f13785c0 = true;
        }
        if (this.f13792j0 && !C0209d.m1333z1(this)) {
            m19077q2(str, false);
            C11829c.m70612r1(this);
        } else {
            this.f13763G.show(NewHiSyncUtil.m25632b(str), str, z10, this.f13792j0);
            if (C0209d.m1220W0()) {
                return;
            }
            this.f13763G.getButton(-1).setTextColor(getResources().getColor(R$color.enui50_red_color));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13760D);
        arrayList.add(this.f13761E);
        arrayList.add(this.f13767K);
        return arrayList;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m19059o2();
        super.onBackPressed();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        if (compoundButton.getId() == R$id.backup_main_switch_btn) {
            if (z10) {
                if (!this.f13780X) {
                    this.f13784b0 = "all";
                    m19078r2(null, true);
                    return;
                } else {
                    C11839m.m70688i("BackupOptionsDetailActivity", "onCheckChanged , isOpenSwitchCalculate = true , return");
                    this.f13789g0.m25085K(false);
                    this.f13765I.setCheckedProgrammatically(false);
                    C11841o.m70708d(this, getString(R$string.backup_check_no_enough_loading), 0);
                    return;
                }
            }
            if (this.f13780X && TextUtils.equals(this.f13784b0, "all")) {
                this.f13785c0 = true;
            }
            if (this.f13792j0 && !C0209d.m1333z1(this)) {
                m19077q2(null, false);
                C11829c.m70612r1(this);
                return;
            }
            this.f13789g0.m25085K(z10);
            this.f13765I.setCheckedProgrammatically(z10);
            this.f13763G.showAllDialog(z10, this.f13792j0);
            if (C0209d.m1220W0()) {
                return;
            }
            this.f13763G.getButton(-1).setTextColor(getResources().getColor(R$color.enui50_red_color));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (R$id.bt_no_net == view.getId()) {
            C11829c.m70612r1(this);
        } else if (R$id.rl_network_not_connect == view.getId()) {
            m19066L2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        m19062E2();
        CBCallBack.getInstance().registerCallback(this.f13793k0);
        C11839m.m70688i("BackupOptionsDetailActivity", "activity created");
        this.f13783a0.m79065c(this, getIntent(), C13222a.m79465g(this));
        m19066L2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f13777U = null;
        SpaceSwitchOpenTipsDialog spaceSwitchOpenTipsDialog = this.f13778V;
        if (spaceSwitchOpenTipsDialog != null) {
            spaceSwitchOpenTipsDialog.dismiss();
        }
        CBCallBack.getInstance().unregisterCallback(this.f13793k0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 == menuItem.getItemId()) {
            m19059o2();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        m19071U2(str);
        return false;
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        m19071U2(str);
        return false;
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.f13788f0) {
            this.f13788f0 = true;
        } else {
            C11839m.m70688i("BackupOptionsDetailActivity", "onResume ，mResumeRequest : initCloudSpace ");
            m19028A2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: p1 */
    public void mo19005p1() {
        List<View> listMo13289d1 = mo13289d1();
        List<List<View>> listM70887y2 = C11842p.m70887y2(listMo13289d1);
        if (C0219i.m1463a() >= 17 && C11829c.m70563b0(this)) {
            C12806c.m76821l(this, listMo13289d1);
            C12806c.m76820k(this, listM70887y2.get(1));
        }
        m22387z1(listM70887y2.get(0));
        C12806c.m76820k(this, listM70887y2.get(0));
    }

    /* renamed from: p2 */
    public long m19076p2() {
        List<BackupOptionItem> listM78397u = this.f13762F.m78397u();
        if (listM78397u == null || listM78397u.isEmpty()) {
            return 0L;
        }
        long totalIncrease = 0;
        for (BackupOptionItem backupOptionItem : listM78397u) {
            if (backupOptionItem.getBackupSwitch() && (!HNConstants.DataType.MEDIA.equals(backupOptionItem.getAppId()) || ICBUtil.isSupportGallery(C0213f.m1377a()))) {
                if (backupOptionItem.getTotalIncrease() > 0) {
                    totalIncrease += backupOptionItem.getTotalIncrease();
                }
            }
        }
        return totalIncrease;
    }

    /* renamed from: q2 */
    public void m19077q2(String str, boolean z10) {
        if (str == null) {
            m19063G2();
            return;
        }
        this.f13762F.m78378M(!z10, str, null);
        this.f13789g0.m25095U(str, !z10);
        this.f13763G.dismiss();
    }

    /* renamed from: r2 */
    public final void m19078r2(String str, boolean z10) {
        this.f13780X = true;
        C11839m.m70688i("BackupOptionsDetailActivity", "checkCanBackupCurrentApp , isOpenSwitchCalculate = true ,  appId = " + str + " , isAll = " + z10);
        if (this.f13779W == null && C0209d.m1333z1(this)) {
            m19028A2();
        }
        m19079s2(str, z10);
    }

    /* renamed from: s2 */
    public final void m19079s2(String str, boolean z10) {
        if (z10) {
            long jM19076p2 = m19076p2();
            long jM19084x2 = m19084x2();
            if (m19064H2(jM19076p2, jM19084x2)) {
                this.f13780X = false;
                if (this.f13785c0) {
                    this.f13785c0 = false;
                    return;
                } else {
                    m19072V2(jM19076p2, jM19084x2);
                    return;
                }
            }
            this.f13780X = false;
            this.f13789g0.m25085K(false);
            this.f13765I.setCheckedProgrammatically(false);
        } else {
            long jM19076p22 = m19076p2();
            if (m19065I2(str, jM19076p22)) {
                this.f13780X = false;
                if (this.f13785c0) {
                    this.f13785c0 = false;
                    return;
                } else {
                    m19073W2(str, jM19076p22);
                    return;
                }
            }
            this.f13780X = false;
            this.f13789g0.m25095U(str, false);
            m19063G2();
        }
        this.f13780X = false;
        this.f13777U = new BackupThirdAppOpenNotEnoughDialog(this, new C3153c());
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, false);
        this.f13777U.setTipContent(z10 ? getString(R$string.app_data_all) : backupOptionItemQueryItem != null ? backupOptionItemQueryItem.getAppName() : "");
        this.f13777U.show();
        m19035Q2();
    }

    /* renamed from: t2 */
    public final void m19080t2(int i10) {
        if (i10 == 4) {
            m19239S1();
            return;
        }
        if (i10 == 5) {
            m19237Q1(R$string.recovery_no_data_server_error);
            return;
        }
        if (i10 != 6) {
            C11839m.m70689w("BackupOptionsDetailActivity", "dispatchCloudSpaceShowType default");
        } else if (!this.f13791i0) {
            C11839m.m70688i("BackupOptionsDetailActivity", "dispatchCloudSpaceShowType switch not loadsuccess");
        } else {
            this.f13787e0 = true;
            m19029B2();
        }
    }

    /* renamed from: u2 */
    public final void m19081u2(Message message) {
        switch (message.what) {
            case 33005:
                Object obj = message.obj;
                if (obj != null && ((BackupOptionItem) obj).getAppId().equals("thirdAppData")) {
                    C11839m.m70686d("BackupOptionsDetailActivity", "complete calculating size of third apps, resort");
                    C12515a.m75110o().m75172d(this.f13794l0);
                    break;
                }
                break;
            case 33006:
                m19074X2((BackupOptionItem) message.obj);
                break;
            case 33012:
                this.f13782Z = true;
                mo19236O1();
                this.f13764H.setVisibility(0);
                this.f13767K.setVisibility(0);
                CloseOptionStatusDialog closeOptionStatusDialog = this.f13763G;
                if (closeOptionStatusDialog != null && !closeOptionStatusDialog.isShowing()) {
                    this.f13765I.setCheckedProgrammatically(((Boolean) message.obj).booleanValue());
                    this.f13789g0.m25085K(((Boolean) message.obj).booleanValue());
                }
                List<BackupOptionItem> list = this.f13770N;
                if (list == null || list.isEmpty()) {
                    finish();
                }
                this.f13789g0.m25087M(this.f13770N);
                this.f13759C.setVisibility(0);
                break;
            case 33017:
                if (message.arg1 == 1) {
                    C12515a.m75110o().m75172d(this.f13794l0);
                    break;
                }
                break;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        m19059o2();
        return true;
    }

    /* renamed from: v2 */
    public final void m19082v2(int i10) {
        if (i10 == 1) {
            m19239S1();
            return;
        }
        if (i10 == 2) {
            m19237Q1(R$string.recovery_no_data_server_error);
        } else if (i10 != 3) {
            C11839m.m70689w("BackupOptionsDetailActivity", "dispatchSwitchShowType default");
        } else {
            m19069P2();
        }
    }

    /* renamed from: w2 */
    public final void m19083w2(String str, String str2) {
        BackupOptionItem backupOptionItem = new BackupOptionItem(str2, str);
        backupOptionItem.setBackupSwitch(this.f13773Q);
        try {
            this.f13762F.m78370E(backupOptionItem);
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionsDetailActivity", "onCheckChanged: " + e10.getMessage());
        }
    }

    /* renamed from: x2 */
    public final long m19084x2() {
        List<BackupOptionItem> listM25082H = this.f13789g0.m25082H();
        if (listM25082H == null || listM25082H.isEmpty()) {
            return 0L;
        }
        long totalIncrease = 0;
        for (BackupOptionItem backupOptionItem : listM25082H) {
            if (!backupOptionItem.getBackupSwitch() && backupOptionItem.getTotalIncrease() > 0) {
                totalIncrease += backupOptionItem.getTotalIncrease();
            }
        }
        return totalIncrease;
    }

    /* renamed from: z2 */
    public final void m19085z2() {
        int iM75409o = new C12526j().m75409o();
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        String strM62282V = C10028c.m62182c0().m62282V();
        if (iM75409o == 0 && StringUtil.equals(strM62282V, "myHuawei")) {
            c10028cM62182c0.m62331g2(true);
        } else if (iM75409o == -1) {
            c10028cM62182c0.m62331g2(true);
        }
    }
}
