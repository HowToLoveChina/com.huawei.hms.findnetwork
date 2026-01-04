package com.huawei.android.hicloud.p088ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.dialog.CloseSyncDialogCallback;
import com.huawei.android.hicloud.p088ui.dialog.DialogCallback;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker;
import com.huawei.android.sync.R$id;
import com.huawei.android.sync.R$layout;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import gp.C10028c;
import java.util.ArrayList;
import java.util.List;
import p336he.C10155f;
import p514o9.C11839m;
import p514o9.C11842p;
import p616rk.C12515a;
import p684un.C13223b;
import p684un.C13226e;
import p709vj.C13452e;
import p737wd.AlertDialogC13590c;
import p742wj.C13612b;
import p746wn.C13622a;
import p770xc.C13744g;
import sk.C12809f;
import vn.C13471c;

/* loaded from: classes3.dex */
public class NotepadMainActivity extends UIActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, CloseSyncDialogCallback, DialogCallback {

    /* renamed from: p */
    public NotchTopFitLinearLayout f15617p;

    /* renamed from: q */
    public RelativeLayout f15618q;

    /* renamed from: r */
    public RelativeLayout f15619r;

    /* renamed from: s */
    public RelativeLayout f15620s;

    /* renamed from: t */
    public UnionSwitch f15621t;

    /* renamed from: u */
    public ProgressDialog f15622u;

    /* renamed from: v */
    public AlertDialogC13590c f15623v;

    /* renamed from: x */
    public RelativeLayout f15625x;

    /* renamed from: w */
    public C10028c f15624w = null;

    /* renamed from: y */
    public Handler f15626y = new HandlerC3417a();

    /* renamed from: com.huawei.android.hicloud.ui.activity.NotepadMainActivity$a */
    public class HandlerC3417a extends Handler {
        public HandlerC3417a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            if (NotepadMainActivity.this.isFinishing() || NotepadMainActivity.this.isDestroyed()) {
                C11839m.m70687e("NotepadMainActivity", "the activity is not avaiable");
            } else {
                NotepadMainActivity.this.m21685N1(message);
            }
        }
    }

    /* renamed from: O1 */
    private void m21681O1() {
        if (getResources().getConfiguration().orientation != 2) {
            C11842p.m70791a2(this.f15625x);
        } else {
            if (C11842p.m70774V0(this)) {
                return;
            }
            C11842p.m70775V1(this, this.f15625x);
        }
    }

    /* renamed from: P1 */
    private void m21682P1() {
        this.f15617p = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f15619r = (RelativeLayout) C12809f.m76829b(this, R$id.notch_fit_divider1);
        this.f15621t = (UnionSwitch) C12809f.m76829b(this, R$id.notepad_auto_switch);
        this.f15621t.setChecked(this.f15624w.m62388s("notepad"));
        this.f15621t.setOnCheckedChangeListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.notepad_main_switch);
        this.f15618q = relativeLayout;
        relativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) C12809f.m76829b(this, R$id.history_data);
        this.f15620s = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        this.f15622u = new ProgressDialog(this);
        this.f15623v = new AlertDialogC13590c(this, this);
        this.f15625x = (RelativeLayout) C12809f.m76829b(this, R$id.notepad_main_layout);
        if (C11842p.m70771U0()) {
            m21681O1();
        }
    }

    /* renamed from: L1 */
    public void m21683L1(int i10) {
        this.f15621t.setCheckedProgrammatically(false);
        this.f15624w.m62336h2("notepad", false);
        C13223b.m79477e(this, "notepad", false, i10);
        UBAAnalyze.m29955P("PVC", C13471c.m81131d().get("notepad"), "1", "10", i10);
    }

    /* renamed from: M1 */
    public void m21684M1(String str, String str2) {
        m21683L1(7);
        SyncObserverServiceInvoker.getInstance().stopNotepadSync(this, str, 101, 2012, str2);
    }

    /* renamed from: N1 */
    public boolean m21685N1(Message message) throws Throwable {
        if (message.what == 1000007) {
            Bundle data = message.getData();
            if (data == null) {
                C11839m.m70687e("NotepadMainActivity", "queryLocalDataFinish, bundle data is null");
                return false;
            }
            String string = data.getString("sync_type_key", "");
            int i10 = data.getInt("sync_operation_type", 7);
            if ("notepad".equals(string)) {
                boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
                C11839m.m70688i("NotepadMainActivity", "Query local data finish, result = " + zBooleanValue);
                ProgressDialog progressDialog = this.f15622u;
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                String string2 = data.getString("trace_id_key", "");
                if (zBooleanValue) {
                    C11839m.m70688i("NotepadMainActivity", "Query local data finish, hasLocalData = true");
                    AlertDialogC13590c alertDialogC13590c = this.f15623v;
                    if (alertDialogC13590c != null) {
                        alertDialogC13590c.show("notepad", string2);
                    }
                } else {
                    m21686Q1(string2, i10);
                }
                C13226e.m79491f1().m79588i0("mecloud_notepadmain_click_switch", "1", "1", C13452e.m80781L().m80971t0(), i10);
                UBAAnalyze.m29973d0("PVC", "mecloud_notepadmain_click_switch", "1", "10", "1", "1", i10);
            }
        }
        return false;
    }

    /* renamed from: Q1 */
    public void m21686Q1(String str, int i10) {
        C13223b.m79477e(this, "notepad", true, i10);
        UBAAnalyze.m29955P("PVC", C13471c.m81132e().get("notepad"), "1", "10", i10);
        this.f15624w.m62336h2("notepad", true);
        C10155f.m63262O(this, true);
        C13612b.m81829B().m81870k0(getApplicationContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add("notepad");
        CloudSyncUtil.m15996b1(getApplicationContext(), arrayList, "03004", str);
        SyncObserverServiceInvoker.getInstance().startNotepadSync(this, 1, "");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15617p);
        arrayList.add(this.f15625x);
        return arrayList;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        AlertDialogC13590c alertDialogC13590c = this.f15623v;
        if (alertDialogC13590c != null) {
            alertDialogC13590c.dismiss();
        }
        if (!z10) {
            C13226e.m79491f1().m79588i0("mecloud_notepadmain_click_switch", "2", "2", C13452e.m80781L().m80971t0(), 7);
            UBAAnalyze.m29971c0("PVC", "mecloud_notepadmain_click_switch", "1", "10", "2", "2");
            m21684M1("notepad", "local_close_switch");
            return;
        }
        String strM81958d = C13622a.m81958d("03003");
        C11839m.m70688i("NotepadMainActivity", "Query notepad local data, traceId: " + strM81958d);
        C12515a.m75110o().m75172d(new C13744g(this, this.f15626y, "notepad", strM81958d, 7));
        ProgressDialog progressDialog = this.f15622u;
        if (progressDialog != null) {
            progressDialog.setMessage(getResources().getString(R$string.opening));
            this.f15622u.setCancelable(false);
            this.f15622u.show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (R$id.history_data == view.getId()) {
            C13226e.m79491f1().m79585f0("mecloud_notepadmain_click_old", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_notepadmain_click_old", "1", "10");
            startActivity(new Intent(this, (Class<?>) CloudDiskNotepadActivity.class));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C11842p.m70771U0()) {
            m21681O1();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.notepad_main);
        this.f15624w = C10028c.m62182c0();
        m21682P1();
        mo19005p1();
        m22365E1(R$string.cloudbackup_back_item_notepad);
        mo19982C1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        ProgressDialog progressDialog = this.f15622u;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.f15622u = null;
        }
        AlertDialogC13590c alertDialogC13590c = this.f15623v;
        if (alertDialogC13590c != null) {
            alertDialogC13590c.dismiss();
            this.f15623v = null;
        }
        C11842p.m70836m(this);
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.p088ui.dialog.DialogCallback
    /* renamed from: p0 */
    public void mo21687p0(String str) {
        m21683L1(7);
    }

    @Override // com.huawei.android.hicloud.p088ui.dialog.DialogCallback
    /* renamed from: s */
    public void mo21688s(String str, String str2) {
        m21686Q1(str2, 7);
    }
}
