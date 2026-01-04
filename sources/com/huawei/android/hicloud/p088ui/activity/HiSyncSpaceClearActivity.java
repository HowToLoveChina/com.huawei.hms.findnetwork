package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import com.huawei.android.hicloud.task.storage.C3104a;
import com.huawei.android.hicloud.task.storage.GetSpaceOptDataTask;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.secure.android.common.intent.SafeIntent;
import gl.C9961b;
import gp.C10028c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import je.C10810x;
import p015ak.C0209d;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p651t8.C12997e;
import p651t8.C12998f;
import p664u0.C13108a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class HiSyncSpaceClearActivity extends HMSTermsProcessBaseActivity {

    /* renamed from: p */
    public long f14948p;

    /* renamed from: q */
    public View f14949q;

    /* renamed from: r */
    public View f14950r;

    /* renamed from: s */
    public View f14951s;

    /* renamed from: t */
    public View f14952t;

    /* renamed from: u */
    public C3314a f14953u;

    /* renamed from: v */
    public String f14954v;

    /* renamed from: w */
    public boolean f14955w = false;

    /* renamed from: com.huawei.android.hicloud.ui.activity.HiSyncSpaceClearActivity$a */
    public class C3314a implements GetSpaceOptDataTask.Callback {

        /* renamed from: a */
        public final Handler f14956a;

        public C3314a(Handler handler) {
            this.f14956a = handler;
        }

        @Override // com.huawei.android.hicloud.task.storage.GetSpaceOptDataTask.Callback
        /* renamed from: a */
        public void mo18457a() {
            C11839m.m70688i("HiSyncSpaceClearActivity", "GetSpaceOptData getSpaceDataTaskStart");
        }

        @Override // com.huawei.android.hicloud.task.storage.GetSpaceOptDataTask.Callback
        /* renamed from: b */
        public void mo18458b(int i10) {
            C11839m.m70688i("HiSyncSpaceClearActivity", "GetSpaceOptData getSpaceDataTaskEnd");
            if (HiSyncSpaceClearActivity.this.isFinishing() || HiSyncSpaceClearActivity.this.isDestroyed()) {
                C11839m.m70689w("HiSyncSpaceClearActivity", "HisyncSpaceDetailActivity is null");
            } else {
                Message.obtain(this.f14956a, 1000, i10, 0).sendToTarget();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.HiSyncSpaceClearActivity$b */
    public static class HandlerC3315b extends Handler {

        /* renamed from: a */
        public final WeakReference<HiSyncSpaceClearActivity> f14958a;

        public HandlerC3315b(HiSyncSpaceClearActivity hiSyncSpaceClearActivity) {
            super(Looper.getMainLooper());
            this.f14958a = new WeakReference<>(hiSyncSpaceClearActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            HiSyncSpaceClearActivity hiSyncSpaceClearActivity = this.f14958a.get();
            if (hiSyncSpaceClearActivity == null) {
                C11839m.m70689w("HiSyncSpaceClearActivity", "activity null");
                return;
            }
            C11839m.m70688i("HiSyncSpaceClearActivity", "handleMessage: " + message.what);
            if (message.what == 1000) {
                hiSyncSpaceClearActivity.f14955w = false;
                if (message.arg1 == 1) {
                    hiSyncSpaceClearActivity.m20638Z1();
                    hiSyncSpaceClearActivity.m20637Y1();
                }
            }
        }
    }

    /* renamed from: R1 */
    private void m20628R1() {
        String stringExtra = new SafeIntent(getIntent()).getStringExtra(RemoteMessageConst.FROM);
        this.f14954v = stringExtra;
        if ("campaign_center".equals(stringExtra)) {
            m20633Q1();
        }
    }

    /* renamed from: S1 */
    private void m20629S1() {
    }

    /* renamed from: T1 */
    private void m20630T1() {
        this.f14949q = C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f14950r = C12809f.m76829b(this, R$id.scroll_notch_fit_layout);
        this.f14951s = C12809f.m76829b(this, R$id.large_file_fragment);
        this.f14952t = C12809f.m76829b(this, R$id.repeat_file_fragment);
        m20638Z1();
    }

    /* renamed from: W1 */
    private void m20631W1() {
        if ("campaign_center".equals(this.f14954v)) {
            C12998f.m78034R().m78136y(C12997e.m78019l(), true, null);
            m20635V1(C13230i.m79497A(C13452e.m80781L().m80971t0()));
        }
    }

    /* renamed from: P1 */
    public final void m20632P1() {
        if (this.f14948p != C9961b.m61788i().m61805s()) {
            C11839m.m70688i("HiSyncSpaceClearActivity", "refresh backup space");
            m20636X1();
        }
    }

    /* renamed from: Q1 */
    public final void m20633Q1() {
        if (this.f14955w) {
            return;
        }
        this.f14955w = true;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (C3104a.m18459f().m18465g()) {
            C11839m.m70686d("HiSyncSpaceClearActivity", "GetSpaceOptDataTask isGetSpaceOptDataRunning");
            C3104a.m18459f().m18472n(this.f14953u);
        } else {
            C11839m.m70686d("HiSyncSpaceClearActivity", "GetSpaceOptDataTask start");
            C3104a.m18459f().m18461b(this.f14953u, jCurrentTimeMillis);
        }
    }

    /* renamed from: U1 */
    public final boolean m20634U1() {
        boolean zM1269j1 = C0209d.m1269j1();
        C11839m.m70688i("HiSyncSpaceClearActivity", "HonorProduct:" + zM1269j1);
        if (zM1269j1) {
            C11839m.m70686d("HiSyncSpaceClearActivity", "hide card view");
            return false;
        }
        boolean zM65814j = C10810x.m65814j();
        C11839m.m70688i("HiSyncSpaceClearActivity", "isSupportSpaceCleanUser:" + zM65814j);
        if (!zM65814j) {
            C11839m.m70686d("HiSyncSpaceClearActivity", "hide card view");
            return false;
        }
        boolean zM62395t1 = C10028c.m62182c0().m62395t1("funcfg_huawei_drive");
        C11839m.m70688i("HiSyncSpaceClearActivity", "isSupport:" + zM62395t1);
        if (zM62395t1) {
            C11839m.m70688i("HiSyncSpaceClearActivity", "isShowCardView true");
            return true;
        }
        C11839m.m70686d("HiSyncSpaceClearActivity", "hide card view");
        return false;
    }

    /* renamed from: V1 */
    public final void m20635V1(LinkedHashMap<String, String> linkedHashMap) {
        C13227f.m79492i1().m79567R("ENTER_SPACE_CLEAR", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "ENTER_SPACE_CLEAR", linkedHashMap);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b(""), "HiSyncSpaceClearActivity", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        C13622a.m81969o(this, c11060cM66626a, linkedHashMap);
    }

    /* renamed from: X1 */
    public final void m20636X1() {
        setResult(10046, new Intent());
    }

    /* renamed from: Y1 */
    public final void m20637Y1() {
        Intent intent = new Intent();
        intent.setAction("com.huawei.hicloud.action.ACTION_SPACE_CLEAR_DATA_REFRESH");
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        C13108a.m78878b(this).m78881d(intent);
    }

    /* renamed from: Z1 */
    public final void m20638Z1() {
        if (m20634U1()) {
            View view = this.f14951s;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.f14952t;
            if (view2 != null) {
                view2.setVisibility(0);
                return;
            }
            return;
        }
        View view3 = this.f14951s;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.f14952t;
        if (view4 != null) {
            view4.setVisibility(8);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14949q);
        arrayList.add(this.f14950r);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_cloud_space_clear);
        m22365E1(R$string.cloud_spatial_optimization);
        mo19982C1();
        this.f14953u = new C3314a(new HandlerC3315b(this));
        this.f14948p = C9961b.m61788i().m61805s();
        m20630T1();
        mo19005p1();
        m20629S1();
        m20628R1();
        m20631W1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        m20632P1();
        finish();
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        m20632P1();
        return super.mo13429v1(i10, keyEvent);
    }
}
