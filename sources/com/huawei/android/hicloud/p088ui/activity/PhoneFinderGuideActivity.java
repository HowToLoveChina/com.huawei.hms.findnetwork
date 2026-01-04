package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.common.DisableSupportedRelativeLayout;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p037bp.C1270a;
import p232dp.InterfaceC9287f;
import p514o9.C11839m;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class PhoneFinderGuideActivity extends AuthCallbackActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: l */
    public NotchTopFitRelativeLayout f15792l;

    /* renamed from: m */
    public NotchFitRelativeLayout f15793m;

    /* renamed from: n */
    public NotchFitRelativeLayout f15794n;

    /* renamed from: o */
    public Button f15795o;

    /* renamed from: p */
    public UnionSwitch f15796p;

    /* renamed from: q */
    public UnionSwitch f15797q;

    /* renamed from: r */
    public DisableSupportedRelativeLayout f15798r;

    /* renamed from: s */
    public DisableSupportedRelativeLayout f15799s;

    /* renamed from: t */
    public Handler f15800t = new Handler();

    /* renamed from: u */
    public ResultReceiver f15801u = new PhoneFinderGuideFinishResultReceiver(this.f15800t);

    public class PhoneFinderGuideFinishResultReceiver extends ResultReceiver {
        public PhoneFinderGuideFinishResultReceiver(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i10, Bundle bundle) {
            if (1 == i10) {
                PhoneFinderGuideActivity.this.finish();
            }
        }
    }

    /* renamed from: c1 */
    private void m21949c1() {
        if (C0209d.m1166E1()) {
            this.f15796p.setCheckedProgrammatically(true);
            this.f15797q.setCheckedProgrammatically(true);
        } else {
            this.f15798r.m23909a();
            this.f15799s.m23909a();
        }
    }

    /* renamed from: d1 */
    private void m21950d1() {
        if (getResources().getConfiguration().orientation == 2) {
            C11842p.m70775V1(this, this.f15794n);
        } else {
            C11842p.m70791a2(this.f15794n);
        }
        C11842p.m70778W1(this, this.f15795o);
    }

    /* renamed from: e1 */
    private void m21951e1() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        this.f15792l = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f15793m = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.phonefinder_start_buttons);
        Button button = (Button) C12809f.m76829b(this, R$id.continue_button);
        this.f15795o = button;
        button.setOnClickListener(this);
        this.f15796p = (UnionSwitch) C12809f.m76829b(this, R$id.open_phonefinder_switch);
        this.f15797q = (UnionSwitch) C12809f.m76829b(this, R$id.switch_sendlastposition);
        this.f15794n = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.hisync_phonefinder_guide_main_frame);
        DisableSupportedRelativeLayout disableSupportedRelativeLayout = (DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.open_phonefinder);
        this.f15798r = disableSupportedRelativeLayout;
        disableSupportedRelativeLayout.setOnClickListener(this);
        DisableSupportedRelativeLayout disableSupportedRelativeLayout2 = (DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.oobeguide_sendlastposition);
        this.f15799s = disableSupportedRelativeLayout2;
        disableSupportedRelativeLayout2.setOnClickListener(this);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.start_phonefinder);
        if (textView != null) {
            textView.setText(C11842p.m70762R0() ? R$string.phone_findback_title_20160528_pad : R$string.phone_findback_title_20160528);
        }
        this.f15796p.setOnCheckedChangeListener(this);
        if (C11842p.m70771U0()) {
            m21950d1();
        }
        m18479Z0();
    }

    @Override // com.huawei.android.hicloud.p088ui.CommonActivity
    /* renamed from: X0 */
    public List<View> mo18477X0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15792l);
        arrayList.add(this.f15793m);
        arrayList.add(this.f15794n);
        return arrayList;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        if (compoundButton.getId() == R$id.open_phonefinder_switch) {
            this.f15799s.setVisibility(z10 ? 0 : 8);
            this.f15797q.setChecked(z10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R$id.continue_button) {
            if (view.getId() != R$id.open_phonefinder) {
                if (view.getId() == R$id.oobeguide_sendlastposition) {
                    this.f15797q.setChecked(!this.f15797q.isChecked());
                    return;
                } else {
                    setResult(0);
                    finish();
                    return;
                }
            }
            boolean zIsChecked = this.f15796p.isChecked();
            this.f15796p.setChecked(!zIsChecked);
            if (zIsChecked) {
                this.f15797q.setChecked(false);
            } else {
                this.f15797q.setChecked(true);
            }
            this.f15799s.setVisibility(zIsChecked ? 8 : 0);
            return;
        }
        try {
            InterfaceC9287f interfaceC9287f = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class);
            if (interfaceC9287f != null) {
                interfaceC9287f.mo58560c(this, this.f15797q.isChecked());
            } else {
                C11839m.m70688i("PhoneFinderGuideActivity", "phoneFinderRouterImpl is null");
            }
            SafeIntent safeIntent = new SafeIntent(getIntent());
            Bundle extras = safeIntent.getExtras();
            boolean booleanExtra = safeIntent.getBooleanExtra("intent_from_settings", false);
            Intent intent = new Intent(this, (Class<?>) MainActivity.class);
            if (extras != null) {
                extras.putBoolean("oobe_phonefinder", this.f15796p.isChecked());
                extras.putBoolean("guide_tag", true);
                extras.putParcelable("phonefinder_guide_finisher", this.f15801u);
                intent.putExtras(extras);
            }
            intent.putExtra("intent_from_settings", booleanExtra);
            startActivity(intent);
            C11839m.m70688i("PhoneFinderGuideActivity", "continue_button");
        } catch (Exception unused) {
            C11839m.m70687e("PhoneFinderGuideActivity", "intent Serializable error.");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C11842p.m70771U0()) {
            m21950d1();
        }
        C11842p.m70780X0(this.f15795o, this);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.hisync_phonefinder_guide2);
        m21951e1();
        m21949c1();
        C11842p.m70780X0(this.f15795o, this);
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m21951e1();
    }
}
