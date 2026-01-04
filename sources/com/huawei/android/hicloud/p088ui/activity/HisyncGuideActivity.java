package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.common.DisableSupportedRelativeLayout;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import gp.C10028c;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p020ap.C1006a;
import p020ap.C1010e;
import p514o9.C11839m;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class HisyncGuideActivity extends AuthCallbackActivity implements View.OnClickListener {

    /* renamed from: A */
    public RelativeLayout f15008A;

    /* renamed from: B */
    public TextView f15009B;

    /* renamed from: C */
    public ScrollView f15010C;

    /* renamed from: D */
    public NotchFitLinearLayout f15011D;

    /* renamed from: I */
    public Intent f15016I;

    /* renamed from: l */
    public NotchTopFitRelativeLayout f15018l;

    /* renamed from: m */
    public NotchFitRelativeLayout f15019m;

    /* renamed from: n */
    public Button f15020n;

    /* renamed from: o */
    public UnionSwitch f15021o;

    /* renamed from: p */
    public UnionSwitch f15022p;

    /* renamed from: q */
    public UnionSwitch f15023q;

    /* renamed from: r */
    public UnionSwitch f15024r;

    /* renamed from: s */
    public UnionSwitch f15025s;

    /* renamed from: t */
    public UnionSwitch f15026t;

    /* renamed from: u */
    public RelativeLayout f15027u;

    /* renamed from: v */
    public DisableSupportedRelativeLayout f15028v;

    /* renamed from: w */
    public RelativeLayout f15029w;

    /* renamed from: x */
    public RelativeLayout f15030x;

    /* renamed from: y */
    public DisableSupportedRelativeLayout f15031y;

    /* renamed from: z */
    public DisableSupportedRelativeLayout f15032z;

    /* renamed from: E */
    public Bundle f15012E = new Bundle();

    /* renamed from: F */
    public Handler f15013F = new Handler();

    /* renamed from: G */
    public C10028c f15014G = null;

    /* renamed from: H */
    public boolean f15015H = true;

    /* renamed from: J */
    public ResultReceiver f15017J = new HisyncGuideFinishResultReceiver(this.f15013F);

    public class HisyncGuideFinishResultReceiver extends ResultReceiver {
        public HisyncGuideFinishResultReceiver(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i10, Bundle bundle) {
            if (1 == i10) {
                HisyncGuideActivity.this.finish();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.HisyncGuideActivity$a */
    public class ViewOnTouchListenerC3324a implements View.OnTouchListener {
        public ViewOnTouchListenerC3324a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent == null || motionEvent.getAction() != 1) {
                HisyncGuideActivity.this.f15010C.requestDisallowInterceptTouchEvent(true);
            } else {
                HisyncGuideActivity.this.f15010C.requestDisallowInterceptTouchEvent(false);
            }
            return false;
        }
    }

    /* renamed from: d1 */
    private void m20701d1() {
        C10028c c10028c = this.f15014G;
        if (c10028c != null) {
            if (!c10028c.m62395t1("funcfg_contacts")) {
                this.f15027u.setVisibility(8);
                this.f15021o.setChecked(false);
            }
            if (!this.f15014G.m62395t1("funcfg_calendar")) {
                this.f15029w.setVisibility(8);
                this.f15023q.setChecked(false);
            }
            if (!this.f15014G.m62395t1("funcfg_wlan")) {
                this.f15031y.setVisibility(8);
                this.f15025s.setChecked(false);
            }
            if (!this.f15014G.m62395t1("funcfg_notes")) {
                this.f15030x.setVisibility(8);
                this.f15024r.setChecked(false);
            }
            if (!this.f15014G.m62395t1("funcfg_cloud_backup")) {
                this.f15032z.setVisibility(8);
                this.f15026t.setChecked(false);
            }
            if (!this.f15014G.m62395t1("funcfg_find_my_phone_globe")) {
                this.f15015H = false;
            }
            if (this.f15014G.m62395t1("funcfg_gallery")) {
                return;
            }
            this.f15028v.setVisibility(8);
            this.f15022p.setChecked(false);
        }
    }

    /* renamed from: e1 */
    private void m20702e1() {
        if (C0209d.m1166E1()) {
            this.f15021o.setCheckedProgrammatically(true);
            this.f15026t.setCheckedProgrammatically(true);
        } else {
            this.f15028v.m23909a();
            this.f15031y.m23909a();
            this.f15032z.m23909a();
            this.f15021o.setCheckedProgrammatically(true);
        }
    }

    /* renamed from: f1 */
    private void m20703f1() {
        if (getResources().getConfiguration().orientation == 2) {
            DisplayMetrics displayMetricsM70876w = C11842p.m70876w(this);
            RelativeLayout relativeLayout = this.f15008A;
            if (relativeLayout != null) {
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                layoutParams.width = displayMetricsM70876w.widthPixels / 3;
                this.f15008A.setLayoutParams(layoutParams);
            }
            C11842p.m70775V1(this, this.f15011D);
        } else {
            C11842p.m70826j1(this, this.f15008A);
            C11842p.m70791a2(this.f15011D);
        }
        C11842p.m70778W1(this, this.f15020n);
        C11842p.m70815g2(this.f15009B, getResources().getDimension(R$dimen.pad_oobe_title_text_margin_bootom));
    }

    /* renamed from: g1 */
    private void m20704g1() {
        this.f15014G = C10028c.m62183d0(this);
        this.f15022p.setCheckedProgrammatically(C1006a.m5936k().m5970q(this).isGeneralAlbumOn());
        this.f15021o.setCheckedProgrammatically(this.f15014G.m62388s("addressbook"));
        this.f15023q.setCheckedProgrammatically(this.f15014G.m62388s("calendar"));
        this.f15024r.setCheckedProgrammatically(this.f15014G.m62388s("notepad"));
        this.f15025s.setCheckedProgrammatically(this.f15014G.m62388s("wlan"));
        this.f15026t.setCheckedProgrammatically(this.f15014G.m62388s("backup_key"));
        if (this.f15027u.getVisibility() != 8) {
            this.f15021o.setCheckedProgrammatically(true);
        } else {
            this.f15021o.setCheckedProgrammatically(false);
        }
        if (!C0209d.m1166E1()) {
            this.f15026t.setCheckedProgrammatically(false);
        } else if (this.f15032z.getVisibility() != 8) {
            this.f15026t.setCheckedProgrammatically(true);
        } else {
            this.f15026t.setCheckedProgrammatically(false);
        }
    }

    /* renamed from: h1 */
    private void m20705h1() {
        this.f15018l = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f15019m = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.hisync_start_buttons);
        Button button = (Button) C12809f.m76829b(this, R$id.continue_button);
        this.f15020n = button;
        button.setOnClickListener(this);
        m20710m1((TextView) C12809f.m76829b(this, R$id.open_wlan_title));
        this.f15021o = (UnionSwitch) C12809f.m76829b(this, R$id.open_contact_switch);
        this.f15023q = (UnionSwitch) C12809f.m76829b(this, R$id.open_calendar_switch);
        this.f15025s = (UnionSwitch) C12809f.m76829b(this, R$id.open_wlan_switch);
        this.f15022p = (UnionSwitch) C12809f.m76829b(this, R$id.open_gellery_switch);
        this.f15024r = (UnionSwitch) C12809f.m76829b(this, R$id.open_notepad_switch);
        this.f15026t = (UnionSwitch) C12809f.m76829b(this, R$id.open_backup_switch);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.open_contact);
        this.f15027u = relativeLayout;
        relativeLayout.setOnClickListener(this);
        DisableSupportedRelativeLayout disableSupportedRelativeLayout = (DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.open_gellery);
        this.f15028v = disableSupportedRelativeLayout;
        disableSupportedRelativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) C12809f.m76829b(this, R$id.open_calendar);
        this.f15029w = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        RelativeLayout relativeLayout3 = (RelativeLayout) C12809f.m76829b(this, R$id.open_notepad);
        this.f15030x = relativeLayout3;
        relativeLayout3.setOnClickListener(this);
        DisableSupportedRelativeLayout disableSupportedRelativeLayout2 = (DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.open_wlan);
        this.f15031y = disableSupportedRelativeLayout2;
        disableSupportedRelativeLayout2.setOnClickListener(this);
        DisableSupportedRelativeLayout disableSupportedRelativeLayout3 = (DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.open_backup);
        this.f15032z = disableSupportedRelativeLayout3;
        disableSupportedRelativeLayout3.setOnClickListener(this);
        this.f15008A = (RelativeLayout) C12809f.m76829b(this, R$id.hisync_guide_top_frame);
        this.f15009B = (TextView) C12809f.m76829b(this, R$id.hisync_guide_title);
        this.f15011D = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.hisync_guide_main_frame);
        this.f15010C = (ScrollView) C12809f.m76829b(this, R$id.guide_scroll_view);
        m20708k1();
        m20701d1();
        m20709l1();
        m20707i1();
        m18479Z0();
    }

    /* renamed from: j1 */
    private void m20706j1() {
        this.f15012E.putBoolean("oobe_contact", this.f15021o.isChecked());
        this.f15012E.putBoolean("oobe_calendar", this.f15023q.isChecked());
        this.f15012E.putBoolean("oobe_gellery", this.f15022p.isChecked());
        this.f15012E.putBoolean("oobe_notepad", this.f15024r.isChecked());
        this.f15012E.putBoolean("oobe_wlan", this.f15025s.isChecked());
        this.f15012E.putBoolean("oobe_backup", this.f15026t.isChecked());
    }

    @Override // com.huawei.android.hicloud.p088ui.CommonActivity
    /* renamed from: X0 */
    public List<View> mo18477X0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15018l);
        arrayList.add(this.f15019m);
        arrayList.add(this.f15011D);
        return arrayList;
    }

    /* renamed from: i1 */
    public final void m20707i1() {
        if (C11842p.m70771U0()) {
            m20703f1();
        } else {
            C11842p.m70830k1(this, this.f15008A, this.f15009B, this.f15011D);
        }
    }

    /* renamed from: k1 */
    public final void m20708k1() {
        TextView textView = (TextView) C12809f.m76829b(this, R$id.hisync_guide_tips);
        textView.setOnTouchListener(new ViewOnTouchListenerC3324a());
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    /* renamed from: l1 */
    public final void m20709l1() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /* renamed from: m1 */
    public final void m20710m1(TextView textView) {
        Resources resources = getResources();
        if (resources == null || textView == null) {
            return;
        }
        if (C0209d.m1262h2()) {
            textView.setText(resources.getString(R$string.wlan_sync));
        } else {
            textView.setText(resources.getString(R$string.wifi_sync));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.continue_button) {
            try {
                Intent intent = this.f15016I;
                boolean booleanExtra = false;
                if (intent != null) {
                    this.f15012E.putParcelable("welcome_finisher", intent.getParcelableExtra("welcome_finisher"));
                    booleanExtra = this.f15016I.getBooleanExtra("intent_from_settings", false);
                }
                m20706j1();
                Intent intent2 = (C1010e.m6125b().m6139e(this) || !this.f15015H) ? new Intent(this, (Class<?>) MainActivity.class) : new Intent(this, (Class<?>) PhoneFinderGuideActivity.class);
                intent2.putExtra("intent_from_settings", booleanExtra);
                this.f15012E.putBoolean("guide_tag", true);
                intent2.putExtras(this.f15012E);
                intent2.putExtra("hisync_guide_finisher", this.f15017J);
                startActivity(intent2);
                return;
            } catch (Exception unused) {
                C11839m.m70687e("HisyncGuideActivity", "intent Serializable error.");
                return;
            }
        }
        if (view.getId() == R$id.open_contact) {
            this.f15021o.setChecked(!r5.isChecked());
            return;
        }
        if (view.getId() == R$id.open_gellery) {
            this.f15022p.setChecked(!r5.isChecked());
            return;
        }
        if (view.getId() == R$id.open_calendar) {
            this.f15023q.setChecked(!r5.isChecked());
            return;
        }
        if (view.getId() == R$id.open_notepad) {
            this.f15024r.setChecked(!r5.isChecked());
        } else if (view.getId() == R$id.open_wlan) {
            this.f15025s.setChecked(!r5.isChecked());
        } else if (view.getId() == R$id.open_backup) {
            this.f15026t.setChecked(!r5.isChecked());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.hisync_guide);
        this.f15014G = C10028c.m62183d0(this);
        this.f15016I = getIntent();
        m20705h1();
        m20702e1();
        C11842p.m70780X0(this.f15020n, this);
        m20704g1();
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m20705h1();
    }
}
