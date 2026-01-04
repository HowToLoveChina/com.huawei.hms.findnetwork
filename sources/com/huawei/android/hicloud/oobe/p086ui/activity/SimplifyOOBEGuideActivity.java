package com.huawei.android.hicloud.oobe.p086ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.oobe.R$dimen;
import com.huawei.android.hicloud.oobe.R$drawable;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import com.huawei.android.hicloud.oobe.R$plurals;
import com.huawei.android.hicloud.oobe.R$string;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBEMarginRelativeLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBETopView;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.UnionSwitch;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.util.ModuleConfigUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import fk.C9721b;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0219i;
import p020ap.C1006a;
import p020ap.C1007b;
import p034bc.C1162b;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12368e;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import p684un.C13227f;
import p709vj.C13452e;
import p709vj.InterfaceC13456i;
import sk.C12809f;
import to.C13049a;

/* loaded from: classes3.dex */
public class SimplifyOOBEGuideActivity extends OOBEBaseAuthActivity implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: B0 */
    public TextView f12475B0;

    /* renamed from: C0 */
    public LinearLayout f12476C0;

    /* renamed from: D0 */
    public OOBEMarginRelativeLayout f12477D0;

    /* renamed from: M */
    public ScrollView f12479M;

    /* renamed from: N */
    public TextView f12480N;

    /* renamed from: O */
    public TextView f12481O;

    /* renamed from: P */
    public TextView f12482P;

    /* renamed from: Q */
    public TextView f12483Q;

    /* renamed from: R */
    public TextView f12484R;

    /* renamed from: S */
    public TextView f12485S;

    /* renamed from: T */
    public UnionSwitch f12486T;

    /* renamed from: U */
    public RelativeLayout f12487U;

    /* renamed from: V */
    public View f12488V;

    /* renamed from: W */
    public UnionSwitch f12489W;

    /* renamed from: X */
    public UnionSwitch f12490X;

    /* renamed from: Y */
    public UnionSwitch f12491Y;

    /* renamed from: Z */
    public UnionSwitch f12492Z;

    /* renamed from: a0 */
    public UnionSwitch f12493a0;

    /* renamed from: b0 */
    public UnionSwitch f12494b0;

    /* renamed from: c0 */
    public RelativeLayout f12495c0;

    /* renamed from: d0 */
    public RelativeLayout f12496d0;

    /* renamed from: e0 */
    public RelativeLayout f12497e0;

    /* renamed from: f0 */
    public RelativeLayout f12498f0;

    /* renamed from: g0 */
    public RelativeLayout f12499g0;

    /* renamed from: h0 */
    public RelativeLayout f12500h0;

    /* renamed from: i0 */
    public AlertDialog f12501i0;

    /* renamed from: r0 */
    public View f12510r0;

    /* renamed from: t0 */
    public ImageView f12512t0;

    /* renamed from: u0 */
    public Drawable f12513u0;

    /* renamed from: v0 */
    public Drawable f12514v0;

    /* renamed from: w0 */
    public View f12515w0;

    /* renamed from: x0 */
    public ArrayList<String> f12516x0;

    /* renamed from: y0 */
    public View f12517y0;

    /* renamed from: j0 */
    public Bundle f12502j0 = new Bundle();

    /* renamed from: k0 */
    public int f12503k0 = 0;

    /* renamed from: l0 */
    public boolean f12504l0 = false;

    /* renamed from: m0 */
    public boolean f12505m0 = false;

    /* renamed from: n0 */
    public boolean f12506n0 = false;

    /* renamed from: o0 */
    public boolean f12507o0 = false;

    /* renamed from: p0 */
    public boolean f12508p0 = false;

    /* renamed from: q0 */
    public boolean f12509q0 = false;

    /* renamed from: s0 */
    public boolean f12511s0 = true;

    /* renamed from: z0 */
    public String f12518z0 = "";

    /* renamed from: A0 */
    public C10028c f12474A0 = C10028c.m62182c0();

    /* renamed from: E0 */
    public boolean f12478E0 = false;

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.SimplifyOOBEGuideActivity$a */
    public class ViewOnTouchListenerC2837a implements View.OnTouchListener {
        public ViewOnTouchListenerC2837a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                SimplifyOOBEGuideActivity.this.f12479M.requestDisallowInterceptTouchEvent(false);
            } else {
                SimplifyOOBEGuideActivity.this.f12479M.requestDisallowInterceptTouchEvent(true);
            }
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.SimplifyOOBEGuideActivity$b */
    public class DialogInterfaceOnClickListenerC2838b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2838b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            SimplifyOOBEGuideActivity.this.f12486T.setChecked(!SimplifyOOBEGuideActivity.this.f12486T.isChecked());
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.SimplifyOOBEGuideActivity$c */
    public class DialogInterfaceOnKeyListenerC2839c implements DialogInterface.OnKeyListener {
        public DialogInterfaceOnKeyListenerC2839c() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            if (i10 != 4) {
                return false;
            }
            SimplifyOOBEGuideActivity.this.f12486T.setChecked(true);
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.SimplifyOOBEGuideActivity$d */
    public class DialogInterfaceOnClickListenerC2840d implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2840d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            SimplifyOOBEGuideActivity.this.mo16628I0();
            SimplifyOOBEGuideActivity.this.m16748I1();
            SimplifyOOBEGuideActivity.this.m16773B1();
            SimplifyOOBEGuideActivity.this.setResult(-1);
            SimplifyOOBEGuideActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.SimplifyOOBEGuideActivity$e */
    public class DialogInterfaceOnClickListenerC2841e implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2841e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            SimplifyOOBEGuideActivity.this.f12501i0.dismiss();
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.SimplifyOOBEGuideActivity$f */
    public class C2842f implements InterfaceC13456i {
        public C2842f() {
        }

        @Override // p709vj.InterfaceC13456i
        public void loginResult(boolean z10) {
            boolean zM66400T = C11019b.m66371t().m66400T();
            if (!C0209d.m1333z1(SimplifyOOBEGuideActivity.this) || !z10 || !zM66400T) {
                C11019b.m66371t().m66420g0(SimplifyOOBEGuideActivity.this);
                C11019b.m66371t().m66427k(SimplifyOOBEGuideActivity.this, "phonefinderOOBE", "0");
                UBAAnalyze.m29949J("CKC", "phonefinderOOBE", "value", "0");
                SimplifyOOBEGuideActivity.this.setResult(-1);
                SimplifyOOBEGuideActivity.this.finish();
                return;
            }
            Class clsM66441r = C11019b.m66371t().m66441r("OOBEPhoneFinderActivity");
            if (clsM66441r != null) {
                Intent intent = new Intent(SimplifyOOBEGuideActivity.this, (Class<?>) clsM66441r);
                intent.putExtra(RemoteMessageConst.FROM, SimplifyOOBEGuideActivity.this.getPackageName());
                Bundle bundle = new Bundle();
                bundle.putBoolean("is_from_mr_guide", SimplifyOOBEGuideActivity.this.f12358r);
                intent.putExtras(bundle);
                SimplifyOOBEGuideActivity.this.startActivityForResult(intent, 10005);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.SimplifyOOBEGuideActivity$g */
    public static class C2843g extends AbstractC12368e {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                C13227f.m79492i1().m79601y0(C1007b.m5980s().m6027r().longValue(), new C13049a(EnumC12999a.CLOUD_BACKUP, null).m78754r());
            } catch (C9721b e10) {
                C11839m.m70688i("SimplifyOOBEGuideActivity", "reportCloseCloudBackup error: " + e10.toString());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.SimplifyOOBEGuideActivity$h */
    public static class DialogInterfaceOnClickListenerC2844h implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
        }
    }

    /* renamed from: A1 */
    private void m16743A1() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        this.f12502j0.putBoolean("oobe_contact", c10028cM62182c0.m62388s("addressbook"));
        this.f12502j0.putBoolean("oobe_calendar", c10028cM62182c0.m62388s("calendar"));
        this.f12502j0.putBoolean("oobe_gellery", c10028cM62182c0.m62388s("uploadphotokey"));
        this.f12502j0.putBoolean("oobe_notepad", c10028cM62182c0.m62388s("notepad"));
        this.f12502j0.putBoolean("oobe_wlan", c10028cM62182c0.m62388s("wlan"));
        if (!this.f12486T.isChecked() && c10028cM62182c0.m62388s("backup_key")) {
            C11839m.m70688i("SimplifyOOBEGuideActivity", "satisfy report close cloudbackup switch condition.");
            C12515a.m75110o().m75172d(new C2843g());
        }
        C11019b.m66371t().m66425j(this.f12486T.isChecked());
        this.f12502j0.putBoolean("oobe_backup", this.f12486T.isChecked());
        if (c10028cM62182c0.m62388s("uploadphotokey")) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("GeneralAblum", true);
            bundle.putBoolean("ShareAlbum", true);
            C11019b.m66371t().m66411c(this, bundle);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("GeneralAblum", false);
        bundle2.putBoolean("ShareAlbum", false);
        C11019b.m66371t().m66411c(this, bundle2);
    }

    /* renamed from: C1 */
    private void m16744C1() {
        if (C0219i.m1463a() <= 14) {
            if (C11842p.m70771U0() && C11842p.m70774V0(this)) {
                this.f12483Q.setMaxWidth(C11842p.m70785Z() - ((int) C11842p.m70844o(this, 16)));
                this.f12484R.setMaxWidth(C11842p.m70785Z() - ((int) C11842p.m70844o(this, 16)));
                return;
            } else {
                this.f12483Q.setMaxWidth(C11842p.m70813g0() - ((int) C11842p.m70844o(this, 16)));
                this.f12484R.setMaxWidth(C11842p.m70813g0() - ((int) C11842p.m70844o(this, 16)));
                return;
            }
        }
        if (C0219i.m1463a() > 14) {
            if (C11842p.m70771U0() && C11842p.m70774V0(this)) {
                this.f12483Q.setMaxWidth(C11842p.m70785Z() - ((int) C11842p.m70844o(this, 20)));
                this.f12484R.setMaxWidth(C11842p.m70785Z() - ((int) C11842p.m70844o(this, 20)));
            } else {
                this.f12483Q.setMaxWidth(C11842p.m70813g0() - ((int) C11842p.m70844o(this, 20)));
                this.f12484R.setMaxWidth(C11842p.m70813g0() - ((int) C11842p.m70844o(this, 20)));
            }
        }
    }

    /* renamed from: D1 */
    private void m16745D1() {
        int iM70731H = C11842p.m70731H(this, (int) C11842p.m70844o(this, 60));
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.oobe_net_error_icon);
        RelativeLayout relativeLayout2 = (RelativeLayout) C12809f.m76829b(this, R$id.oobe_server_error_icon);
        C11842p.m70763R1(this, relativeLayout, iM70731H);
        C11842p.m70763R1(this, relativeLayout2, iM70731H);
    }

    /* renamed from: F1 */
    private void m16746F1() {
        OOBETopView oOBETopView = this.f12350j;
        if (oOBETopView == null) {
            C11839m.m70689w("SimplifyOOBEGuideActivity", "setTitleTextTipsTouchListener topLayout is null");
            return;
        }
        TextView subTitleView = oOBETopView.getSubTitleView();
        if (subTitleView == null) {
            return;
        }
        subTitleView.setOnTouchListener(new ViewOnTouchListenerC2837a());
        subTitleView.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    /* renamed from: G1 */
    private void m16747G1() {
        if (this.f12486T.isChecked()) {
            return;
        }
        if (this.f12478E0) {
            C11839m.m70688i("SimplifyOOBEGuideActivity", "backupSwitchView close directly: ");
            this.f12486T.setChecked(false);
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton(getString(R$string.common_btn_close), new DialogInterfaceOnClickListenerC2844h());
        builder.setNegativeButton(getString(R$string.cloudbackup_btn_cancel), new DialogInterfaceOnClickListenerC2838b());
        builder.setOnKeyListener(new DialogInterfaceOnKeyListenerC2839c());
        AlertDialog alertDialog = this.f12501i0;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f12501i0 = null;
        }
        AlertDialog alertDialogCreate = builder.create();
        this.f12501i0 = alertDialogCreate;
        alertDialogCreate.setMessage(getResources().getString(R$string.close_backup_alert_message));
        m16607r0(this.f12501i0);
        this.f12501i0.setTitle(R$string.close_cloudbackup);
        this.f12501i0.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I1 */
    public void m16748I1() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        c10028cM62182c0.m62377p3("is_all_guide_over", false);
        c10028cM62182c0.m62377p3("is_already_configed_NV4", false);
        C11019b.m66371t().m66444s0(getApplicationContext());
        C11019b.m66371t().m66425j(false);
        C13452e.m80781L().m80885a();
        C10028c.m62182c0().m62343j();
    }

    /* renamed from: Z0 */
    private int m16754Z0() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        int i10 = this.f12503k0;
        boolean zM62388s = c10028cM62182c0.m62388s("addressbook");
        boolean zM62388s2 = c10028cM62182c0.m62388s("calendar");
        boolean zM62388s3 = c10028cM62182c0.m62388s("uploadphotokey");
        boolean zM62388s4 = c10028cM62182c0.m62388s("notepad");
        boolean zM62388s5 = c10028cM62182c0.m62388s("wlan");
        boolean zM62388s6 = c10028cM62182c0.m62388s("browser");
        if (zM62388s && this.f12504l0) {
            i10--;
        }
        if (zM62388s2 && this.f12507o0) {
            i10--;
        }
        if (zM62388s3 && this.f12505m0) {
            i10--;
        }
        if (zM62388s4 && this.f12506n0) {
            i10--;
        }
        if (zM62388s5 && this.f12509q0) {
            i10--;
        }
        return (zM62388s6 && this.f12508p0) ? i10 - 1 : i10;
    }

    /* renamed from: c1 */
    private void m16755c1() {
        RelativeLayout relativeLayout;
        m16756d1(C10028c.m62182c0());
        if ((!C11019b.m66371t().m66399S() || C0209d.m1293p1()) && (relativeLayout = this.f12496d0) != null) {
            relativeLayout.setVisibility(8);
        }
    }

    /* renamed from: d1 */
    private void m16756d1(C10028c c10028c) {
        RelativeLayout relativeLayout;
        if (this.f12495c0 != null && (!c10028c.m62395t1("funcfg_contacts") || C0209d.m1293p1())) {
            this.f12495c0.setVisibility(8);
        }
        if (this.f12497e0 != null && !c10028c.m62395t1("funcfg_calendar")) {
            this.f12497e0.setVisibility(8);
        }
        if (this.f12499g0 != null && !c10028c.m62395t1("funcfg_wlan")) {
            this.f12499g0.setVisibility(8);
        }
        if ((!c10028c.m62395t1("funcfg_notes") || !C0209d.m1215U1(this)) && (relativeLayout = this.f12498f0) != null) {
            relativeLayout.setVisibility(8);
        }
        if (this.f12500h0 != null) {
            if (!c10028c.m62395t1("funcfg_browser") || C0209d.m1293p1()) {
                this.f12500h0.setVisibility(8);
            }
        }
    }

    /* renamed from: e1 */
    private void m16757e1() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        if (hiCloudSafeIntent.getExtras() == null) {
            return;
        }
        this.f12518z0 = hiCloudSafeIntent.getStringExtra("channel_of_open_switch");
    }

    /* renamed from: g1 */
    private void m16758g1() {
        if (C0219i.m1463a() < 27) {
            this.f12513u0 = getDrawable(R$drawable.list_spread_gray);
            this.f12514v0 = getDrawable(R$drawable.list_spreadoff_gray);
        } else {
            this.f12513u0 = getDrawable(R$drawable.list_spread_gray_harmony);
            Drawable drawable = getDrawable(R$drawable.list_spreadoff_gray_harmony);
            this.f12514v0 = drawable;
            this.f12512t0.setImageDrawable(drawable);
        }
    }

    /* renamed from: j1 */
    private int m16759j1(int i10, boolean z10) {
        return !z10 ? i10 + 1 : i10;
    }

    /* renamed from: k1 */
    private void m16760k1() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        boolean zM62388s = c10028cM62182c0.m62388s("addressbook");
        boolean zM62388s2 = c10028cM62182c0.m62388s("calendar");
        boolean zM62388s3 = c10028cM62182c0.m62388s("uploadphotokey");
        boolean zM62388s4 = c10028cM62182c0.m62388s("notepad");
        boolean zM62388s5 = c10028cM62182c0.m62388s("wlan");
        boolean zM62388s6 = c10028cM62182c0.m62388s("browser");
        this.f12489W.setChecked(zM62388s);
        this.f12492Z.setChecked(zM62388s4);
        this.f12491Y.setChecked(zM62388s);
        this.f12493a0.setChecked(zM62388s5);
        this.f12491Y.setChecked(zM62388s2);
        this.f12490X.setChecked(zM62388s3);
        this.f12494b0.setChecked(zM62388s6);
        if (this.f12478E0) {
            return;
        }
        m16783u1();
    }

    /* renamed from: l1 */
    private void m16761l1() {
        this.f12510r0 = C12809f.m76829b(this, R$id.sync_items);
        UnionSwitch unionSwitch = (UnionSwitch) C12809f.m76829b(this, R$id.open_contact_switch);
        this.f12489W = unionSwitch;
        unionSwitch.setOnCheckedChangeListener(this);
        UnionSwitch unionSwitch2 = (UnionSwitch) C12809f.m76829b(this, R$id.open_gellery_switch);
        this.f12490X = unionSwitch2;
        unionSwitch2.setOnCheckedChangeListener(this);
        UnionSwitch unionSwitch3 = (UnionSwitch) C12809f.m76829b(this, R$id.open_calendar_switch);
        this.f12491Y = unionSwitch3;
        unionSwitch3.setOnCheckedChangeListener(this);
        UnionSwitch unionSwitch4 = (UnionSwitch) C12809f.m76829b(this, R$id.open_notepad_switch);
        this.f12492Z = unionSwitch4;
        unionSwitch4.setOnCheckedChangeListener(this);
        UnionSwitch unionSwitch5 = (UnionSwitch) C12809f.m76829b(this, R$id.open_wlan_switch);
        this.f12493a0 = unionSwitch5;
        unionSwitch5.setOnCheckedChangeListener(this);
        UnionSwitch unionSwitch6 = (UnionSwitch) C12809f.m76829b(this, R$id.open_browser_switch);
        this.f12494b0 = unionSwitch6;
        unionSwitch6.setOnCheckedChangeListener(this);
        this.f12495c0 = (RelativeLayout) C12809f.m76829b(this, R$id.open_contact);
        this.f12496d0 = (RelativeLayout) C12809f.m76829b(this, R$id.open_gellery);
        this.f12497e0 = (RelativeLayout) C12809f.m76829b(this, R$id.open_calendar);
        this.f12498f0 = (RelativeLayout) C12809f.m76829b(this, R$id.open_notepad);
        this.f12499g0 = (RelativeLayout) C12809f.m76829b(this, R$id.open_wlan);
        this.f12500h0 = (RelativeLayout) C12809f.m76829b(this, R$id.open_browser);
        if (C11019b.m66371t().m66391K(this)) {
            this.f12500h0.setVisibility(0);
        } else {
            this.f12500h0.setVisibility(8);
        }
        this.f12512t0 = (ImageView) C12809f.m76829b(this, R$id.right_arrow1);
        m16758g1();
        TextView textView = (TextView) C12809f.m76829b(this, R$id.open_wlan_title);
        if (C0209d.m1262h2()) {
            textView.setText(getResources().getString(R$string.wlan_sync));
        } else {
            textView.setText(getResources().getString(R$string.wifi_sync));
        }
    }

    /* renamed from: m1 */
    private void m16762m1() {
        UnionSwitch unionSwitch = (UnionSwitch) C12809f.m76829b(this, R$id.open_backup_switch);
        this.f12486T = unionSwitch;
        unionSwitch.setOnClickListener(this);
        this.f12486T.setOnCheckedChangeListener(this);
        this.f12487U = (RelativeLayout) C12809f.m76829b(this, R$id.open_cloud_backup);
        this.f12488V = C12809f.m76829b(this, R$id.cloud_backup_below_interval);
        ((RelativeLayout) C12809f.m76829b(this, R$id.cloud_sync)).setOnClickListener(this);
        this.f12482P = (TextView) C12809f.m76829b(this, R$id.oobe_guide_title);
        this.f12479M = (ScrollView) C12809f.m76829b(this, R$id.oobe_guide_scrollView);
        this.f12483Q = (TextView) C12809f.m76829b(this, R$id.cloud_sync_titel);
        this.f12484R = (TextView) C12809f.m76829b(this, R$id.cloud_sync_detail);
        this.f12485S = (TextView) C12809f.m76829b(this, R$id.open_feature_num);
        this.f12476C0 = (LinearLayout) C12809f.m76829b(this, R$id.oobe_error_tips);
        this.f12477D0 = (OOBEMarginRelativeLayout) C12809f.m76829b(this, R$id.oobe_start_main_frame);
        if (this.f12341a == 1) {
            C11842p.m70827j2(this.f12476C0, C11842p.m70789a0(this));
        }
        String string = getString(R$string.set_get_info_not_avi, getString(R$string.contact_email_value));
        TextView textView = (TextView) C12809f.m76829b(this, R$id.oobe_error_tips_text);
        if (textView != null) {
            textView.setText(string);
        }
        m16746F1();
        m16744C1();
    }

    /* renamed from: n1 */
    private void m16763n1() {
        this.f12515w0 = C12809f.m76829b(this, R$id.line_interval_slide);
        View viewM76829b = C12809f.m76829b(this, R$id.interval_wlan);
        this.f12517y0 = viewM76829b;
        if (viewM76829b != null) {
            viewM76829b.setVisibility(8);
        }
    }

    /* renamed from: p1 */
    private boolean m16764p1(int i10) {
        return i10 == 20004 || i10 == 20005 || i10 == 20003 || i10 == 20006;
    }

    /* renamed from: r1 */
    private void m16765r1() {
        C1162b.m7257a().m7258b(this, new C2842f());
    }

    /* renamed from: s1 */
    private void m16766s1(View view) {
        if (view.getId() == R$id.open_cloud_backup) {
            this.f12486T.setChecked(!r1.isChecked());
        }
    }

    /* renamed from: t1 */
    private void m16767t1(View view) {
        if (view.getId() == R$id.cloud_sync) {
            if (this.f12511s0) {
                this.f12510r0.setVisibility(8);
                Drawable drawable = this.f12513u0;
                if (drawable != null) {
                    this.f12512t0.setImageDrawable(drawable);
                }
                View view2 = this.f12515w0;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                this.f12511s0 = false;
                return;
            }
            this.f12510r0.setVisibility(0);
            Drawable drawable2 = this.f12514v0;
            if (drawable2 != null) {
                this.f12512t0.setImageDrawable(drawable2);
            }
            if (this.f12515w0 != null && C0219i.m1463a() < 27) {
                this.f12515w0.setVisibility(0);
            }
            this.f12511s0 = true;
            return;
        }
        if (view.getId() == R$id.open_contact) {
            this.f12489W.setChecked(!r3.isChecked());
            return;
        }
        if (view.getId() == R$id.open_gellery) {
            this.f12490X.setChecked(!r3.isChecked());
            return;
        }
        if (view.getId() == R$id.open_calendar) {
            this.f12491Y.setChecked(!r3.isChecked());
            return;
        }
        if (view.getId() == R$id.open_notepad) {
            this.f12492Z.setChecked(!r3.isChecked());
        } else if (view.getId() == R$id.open_wlan) {
            this.f12493a0.setChecked(!r3.isChecked());
        } else if (view.getId() == R$id.open_browser) {
            this.f12494b0.setChecked(!r3.isChecked());
        }
    }

    /* renamed from: v1 */
    private void m16768v1() {
        ArrayList<String> arrayList = this.f12516x0;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<String> it = this.f12516x0.iterator();
        while (it.hasNext()) {
            m16772z1(it.next());
        }
    }

    /* renamed from: w1 */
    private void m16769w1() {
        C11019b.m66371t().m66424i0(this, true, true, true, true);
    }

    /* renamed from: x1 */
    private void m16770x1(int i10) {
        C11839m.m70688i("SimplifyOOBEGuideActivity", "processSwitchOpenPermissionResult");
        if (i10 == 20004) {
            List<String> listM69911k = this.f12374A.m69911k("sync_contact");
            C11839m.m70688i("SimplifyOOBEGuideActivity", "contact need permissions size: " + listM69911k.size());
            List<String> listM69903b = this.f12374A.m69903b(this, listM69911k);
            if (this.f12489W == null) {
                this.f12489W = (UnionSwitch) C12809f.m76829b(this, R$id.open_contact_switch);
            }
            if (this.f12489W == null || listM69903b.size() <= 0) {
                return;
            }
            this.f12489W.setChecked(false);
            return;
        }
        if (i10 == 20005) {
            List<String> listM69911k2 = this.f12374A.m69911k("sync_calendar");
            C11839m.m70688i("SimplifyOOBEGuideActivity", "calendar need permissions size: " + listM69911k2.size());
            List<String> listM69903b2 = this.f12374A.m69903b(this, listM69911k2);
            if (this.f12491Y == null) {
                this.f12491Y = (UnionSwitch) C12809f.m76829b(this, R$id.open_calendar_switch);
            }
            if (this.f12491Y == null || listM69903b2.size() <= 0) {
                return;
            }
            this.f12491Y.setChecked(false);
            return;
        }
        if (i10 == 20003) {
            List<String> listM69911k3 = this.f12374A.m69911k("sync_ablum");
            C11839m.m70688i("SimplifyOOBEGuideActivity", "ablum need permissions size: " + listM69911k3.size());
            List<String> listM69903b3 = this.f12374A.m69903b(this, listM69911k3);
            if (this.f12490X == null) {
                this.f12490X = (UnionSwitch) C12809f.m76829b(this, R$id.open_gellery_switch);
            }
            if (this.f12490X == null || listM69903b3.size() <= 0) {
                return;
            }
            this.f12490X.setChecked(false);
            return;
        }
        if (i10 == 20006) {
            List<String> listM69911k4 = this.f12374A.m69911k(CloudBackupConstant.Command.PMS_CMD_BACKUP);
            C11839m.m70688i("SimplifyOOBEGuideActivity", "backup need permissions size: " + listM69911k4.size());
            List<String> listM69903b4 = this.f12374A.m69903b(this, listM69911k4);
            if (this.f12486T == null) {
                this.f12486T = (UnionSwitch) C12809f.m76829b(this, R$id.open_backup_switch);
            }
            if (this.f12486T == null || listM69903b4.size() <= 0) {
                return;
            }
            this.f12486T.setCheckedProgrammatically(false);
        }
    }

    /* renamed from: y1 */
    private void m16771y1() {
        int iM16754Z0 = m16754Z0();
        if (iM16754Z0 == 0) {
            this.f12485S.setText(getString(R$string.settings_hicloud_open));
        } else {
            this.f12485S.setText(getResources().getQuantityString(R$plurals.item_num_not_open1, iM16754Z0, Integer.valueOf(iM16754Z0)));
        }
    }

    /* renamed from: z1 */
    private void m16772z1(String str) {
        this.f12489W.setOnCheckedChangeListener(this);
        UnionSwitch unionSwitch = (UnionSwitch) C12809f.m76829b(this, R$id.open_gellery_switch);
        this.f12490X = unionSwitch;
        unionSwitch.setOnCheckedChangeListener(this);
        this.f12491Y = (UnionSwitch) C12809f.m76829b(this, R$id.open_calendar_switch);
        str.hashCode();
        switch (str) {
            case "sync_ablum":
                List<String> listM69903b = this.f12374A.m69903b(this, this.f12374A.m69911k("sync_ablum"));
                if (this.f12490X != null && listM69903b != null && listM69903b.size() > 0) {
                    this.f12490X.setChecked(false);
                    break;
                }
                break;
            case "backup":
                List<String> listM69903b2 = this.f12374A.m69903b(this, this.f12374A.m69911k(CloudBackupConstant.Command.PMS_CMD_BACKUP));
                if (this.f12486T != null && listM69903b2 != null && listM69903b2.size() > 0) {
                    this.f12486T.setCheckedProgrammatically(false);
                    break;
                }
                break;
            case "sync_contact":
                List<String> listM69903b3 = this.f12374A.m69903b(this, this.f12374A.m69911k("sync_contact"));
                if (this.f12489W != null && listM69903b3 != null && listM69903b3.size() > 0) {
                    C11839m.m70688i("SimplifyOOBEGuideActivity", "no permission close contact automatically");
                    this.f12489W.setChecked(false);
                    break;
                }
                break;
            case "sync_calendar":
                List<String> listM69903b4 = this.f12374A.m69903b(this, this.f12374A.m69911k("sync_calendar"));
                if (this.f12491Y != null && listM69903b4 != null && listM69903b4.size() > 0) {
                    this.f12491Y.setChecked(false);
                    break;
                }
                break;
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: A */
    public void mo16550A() {
        m16760k1();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: B */
    public void mo16552B() {
        m16760k1();
    }

    /* renamed from: B1 */
    public final void m16773B1() {
        if (C0209d.m1200P1(this)) {
            C0209d.m1318v2(this);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: C */
    public void mo16554C() {
        mo16552B();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: C0 */
    public void mo16555C0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: D */
    public void mo16556D() {
        super.mo16556D();
        HwButton hwButton = this.f12364x;
        if (hwButton != null) {
            hwButton.setVisibility(4);
        }
        HwButton hwButton2 = this.f12365y;
        if (hwButton2 != null) {
            hwButton2.setText(R$string.cloud_oobe_continue_btn);
        }
    }

    /* renamed from: E1 */
    public final void m16774E1() {
        int iM16780i1 = m16780i1(0);
        if (!this.f12474A0.m62395t1("funcfg_cloud_backup") || C0209d.m1293p1()) {
            this.f12487U.setVisibility(8);
            View view = this.f12488V;
            if (view != null) {
                view.setVisibility(8);
            }
            this.f12486T.setCheckedProgrammatically(false);
        } else {
            C11019b.m66371t().m66388I(this, "cloudbackup", this.f12486T, true);
        }
        if (this.f12474A0.m62395t1("funcfg_gallery") && !C0209d.m1293p1()) {
            this.f12503k0++;
            this.f12505m0 = true;
            iM16780i1 = m16759j1(iM16780i1, m16779h1(this, "cloudphoto_toogle", false));
            C11019b.m66371t().m66445t0(this);
        }
        this.f12485S.setText(getResources().getQuantityString(R$plurals.item_num_not_open1, iM16780i1, Integer.valueOf(iM16780i1)));
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: G */
    public void mo16559G() throws Resources.NotFoundException {
        super.mo16559G();
        this.f12480N = (TextView) C12809f.m76829b(this, R$id.oobe_guide_tips);
        this.f12481O = (TextView) C12809f.m76829b(this, R$id.oobe_start_tips_sencond);
        m16745D1();
    }

    /* renamed from: H1 */
    public final void m16775H1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton(getString(R$string.oobe_skip), new DialogInterfaceOnClickListenerC2840d());
        builder.setNegativeButton(getString(R$string.oobe_cancel), new DialogInterfaceOnClickListenerC2841e());
        mo16628I0();
        builder.setMessage(getString(R$string.skip_cloud_alert_message));
        AlertDialog alertDialogCreate = builder.create();
        this.f12501i0 = alertDialogCreate;
        m16607r0(alertDialogCreate);
        this.f12501i0.setTitle(getString(R$string.skip_cloud_alert_title));
        this.f12501i0.show();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: I */
    public void mo16561I() {
        m16762m1();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity
    /* renamed from: I0 */
    public void mo16628I0() {
        super.mo16628I0();
        try {
            AlertDialog alertDialog = this.f12501i0;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f12501i0 = null;
            }
        } catch (IllegalArgumentException unused) {
            C11839m.m70687e("SimplifyOOBEGuideActivity", "dialog dismiss IllegalArgumentException");
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: J */
    public void mo16562J() {
        m16762m1();
        m16761l1();
        this.f12511s0 = false;
        Drawable drawable = this.f12513u0;
        if (drawable != null) {
            this.f12512t0.setImageDrawable(drawable);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity
    /* renamed from: J0 */
    public void mo16629J0(int i10) {
        C11839m.m70688i("SimplifyOOBEGuideActivity", "finishPermissionSet requestCode: " + i10);
        if (m16764p1(i10)) {
            m16770x1(i10);
        }
        if (i10 == 20001 || i10 == 20002) {
            m16768v1();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: K */
    public void mo16563K() {
        m16762m1();
        m16763n1();
        m16761l1();
        this.f12511s0 = true;
        if (this.f12480N == null || this.f12481O == null) {
            return;
        }
        if (C11842p.m70747M0(this) || C11842p.m70771U0()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12480N.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.addRule(14, -1);
            this.f12480N.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f12481O.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.addRule(14, -1);
            this.f12481O.setLayoutParams(layoutParams2);
            return;
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f12480N.getLayoutParams();
        layoutParams3.width = -1;
        layoutParams3.removeRule(14);
        this.f12480N.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f12481O.getLayoutParams();
        layoutParams4.width = -1;
        layoutParams4.removeRule(14);
        this.f12481O.setLayoutParams(layoutParams4);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: M */
    public void mo16564M() {
        mo16563K();
        TextView textView = (TextView) C12809f.m76829b(this, R$id.open_later);
        this.f12475B0 = textView;
        m16611t0(textView, "", getString(R$string.oobe_open_cloud_later));
        super.mo16564M();
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.oobe_start_main_frame);
        if (C0219i.m1463a() >= 27 && relativeLayout != null) {
            C11842p.m70811f2(relativeLayout, C11842p.m70864t(this));
        }
        if (m16581d0()) {
            C11842p.m70736I1(this.f12480N, getResources().getDimensionPixelSize(R$dimen.oobe_title_margin_bottom));
            this.f12480N.setText(R$string.cloud_oobe_tips);
            C11842p.m70733H1(this.f12480N, getResources().getDimensionPixelSize(R$dimen.cs_24_dp));
            C12809f.m76843p(this.f12481O, false);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity
    /* renamed from: M0 */
    public void mo16632M0() {
        m16769w1();
        C11829c.m70582h1(this, this.f12518z0);
        C11019b.m66371t().m66419g(this);
        C13227f.m79492i1().m79560L(this, C13452e.m80781L().m80971t0());
        m16558F();
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        c10028cM62182c0.m62377p3("is_all_guide_over", true);
        C11019b.m66371t().m66381E0(this);
        boolean zM62395t1 = c10028cM62182c0.m62395t1("funcfg_find_my_phone_globe");
        C0209d.m1318v2(this);
        if (zM62395t1) {
            m16765r1();
        } else {
            setResult(-1);
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: S */
    public void mo16569S() {
        if (!ModuleConfigUtil.getInstance().isAllModuleDisabledIncludePhonefinder(this) || C0219i.m1463a() < 23) {
            m16748I1();
            setResult(0);
            finish();
        } else {
            C10028c.m62182c0().m62377p3("is_all_guide_over", true);
            setResult(0);
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: T */
    public void mo16570T() {
        m16775H1();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: U */
    public void mo16571U() {
        m16775H1();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: V */
    public void mo16572V() {
        m16775H1();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Y */
    public void mo16574Y() {
        mo16577b0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Z */
    public void mo16575Z() {
        m16782q1();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: a0 */
    public void mo16576a0() {
        m16782q1();
    }

    /* renamed from: a1 */
    public boolean m16776a1(boolean z10, String str) {
        return z10 && !m16626G0(str);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: b0 */
    public void mo16577b0() {
        m16782q1();
    }

    /* renamed from: b1 */
    public final void m16777b1() {
        C11839m.m70688i("SimplifyOOBEGuideActivity", "disableModuleFromLocalModuleConfig");
        if (!ModuleConfigUtil.getInstance().isAllModuleDisabledIncludePhonefinder(this)) {
            m16774E1();
            return;
        }
        C11839m.m70688i("SimplifyOOBEGuideActivity", "OOBE guide all module disabled");
        if (C0219i.m1463a() < 23) {
            setResult(-1);
            finish();
            return;
        }
        LinearLayout linearLayout = this.f12476C0;
        if (linearLayout == null || this.f12477D0 == null) {
            return;
        }
        linearLayout.setVisibility(0);
        this.f12477D0.setVisibility(8);
        C12809f.m76843p(this.f12366z, false);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: c */
    public int mo16578c() {
        return R$layout.simplify_oobe_guide;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: c0 */
    public boolean mo16579c0() {
        return true;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: f */
    public int mo16583f() {
        return R$layout.simplify_oobe_guide_emui10;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: f0 */
    public void mo16584f0(View view) {
        mo16590i0(view);
    }

    /* renamed from: f1 */
    public final boolean m16778f1(Context context, String str) {
        if (context == null) {
            return false;
        }
        return this.f12474A0.m62395t1(str);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: g */
    public int mo16585g() {
        return R$layout.simplify_oobe_guide_emui1101;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: g0 */
    public void mo16586g0(View view) {
        m16766s1(view);
        if (view.getId() == R$id.cloud_sync) {
            startActivityForResult(new Intent(this, (Class<?>) SimplifyOOBECloudItemActivity.class), 0);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: h */
    public int mo16587h() {
        return R$layout.simplify_oobe_guide_emui8;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: h0 */
    public void mo16588h0(View view) {
        m16766s1(view);
        m16767t1(view);
    }

    /* renamed from: h1 */
    public boolean m16779h1(Context context, String str, boolean z10) {
        return !m16781o1(context) ? z10 : m16778f1(context, str);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i */
    public int mo16589i() {
        return R$layout.simplify_oobe_guide_emui81;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i0 */
    public void mo16590i0(View view) {
        m16766s1(view);
        m16767t1(view);
    }

    /* renamed from: i1 */
    public final int m16780i1(int i10) {
        if (this.f12474A0.m62395t1("funcfg_contacts") && !C0209d.m1293p1()) {
            this.f12503k0++;
            this.f12504l0 = true;
            if (!C11019b.m66371t().m66372A(this, "addressbook", true)) {
                i10++;
            }
            this.f12474A0.m62336h2("addressbook", C11019b.m66371t().m66372A(this, "addressbook", true));
        }
        if (this.f12474A0.m62395t1("funcfg_calendar")) {
            this.f12503k0++;
            this.f12507o0 = true;
            boolean zM16779h1 = m16779h1(this, "calendar_toogle", false);
            i10 = m16759j1(i10, zM16779h1);
            this.f12474A0.m62336h2("calendar", zM16779h1);
        }
        if (this.f12474A0.m62395t1("funcfg_wlan")) {
            this.f12503k0++;
            this.f12509q0 = true;
            boolean zM16779h12 = C0209d.m1166E1() ? m16779h1(this, "wlan_toogle", false) : false;
            if (!zM16779h12) {
                i10++;
            }
            this.f12474A0.m62336h2("wlan", zM16779h12);
        }
        if (this.f12474A0.m62395t1("funcfg_browser") && C11019b.m66371t().m66391K(this) && !C0209d.m1293p1()) {
            this.f12503k0++;
            this.f12508p0 = true;
            boolean zM16779h13 = m16779h1(this, "browser_toogle", false);
            i10 = m16759j1(i10, zM16779h13);
            this.f12474A0.m62336h2("browser", zM16779h13);
        }
        if (!this.f12474A0.m62395t1("funcfg_notes") || !C0209d.m1215U1(this)) {
            return i10;
        }
        this.f12503k0++;
        this.f12506n0 = true;
        boolean zM16779h14 = m16779h1(this, "notepad_toogle", false);
        int iM16759j1 = m16759j1(i10, zM16779h14);
        this.f12474A0.m62336h2("notepad", zM16779h14);
        return iM16759j1;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: j */
    public int mo16591j() {
        return R$layout.simplify_oobe_guide_emui9;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: j0 */
    public void mo16592j0(TextView textView) {
        if (textView.getId() == R$id.open_later) {
            m16775H1();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: l0 */
    public void mo16596l0() {
    }

    /* renamed from: o1 */
    public boolean m16781o1(Context context) {
        if (context != null) {
            return C10028c.m62183d0(context).m62395t1("toggle_default");
        }
        return false;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (-1 == i11 || 603 == i11) {
            setResult(-1);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (m16581d0()) {
            C11839m.m70686d("SimplifyOOBEGuideActivity", "moveBack();");
            mo16568R();
        } else {
            C11839m.m70686d("SimplifyOOBEGuideActivity", "super.onBackPressed();");
            super.onBackPressed();
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        int id2 = compoundButton.getId();
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (id2 == R$id.open_contact_switch) {
            c10028cM62182c0.m62336h2("addressbook", z10);
            m16776a1(z10, "addressbook");
        } else if (id2 == R$id.open_gellery_switch) {
            c10028cM62182c0.m62336h2("uploadphotokey", z10);
            m16776a1(z10, HNConstants.DataType.MEDIA);
        } else if (id2 == R$id.open_calendar_switch) {
            c10028cM62182c0.m62336h2("calendar", z10);
            m16776a1(z10, "calendar");
        } else if (id2 == R$id.open_notepad_switch) {
            c10028cM62182c0.m62336h2("notepad", z10);
        } else if (id2 == R$id.open_wlan_switch) {
            c10028cM62182c0.m62336h2("wlan", z10);
        } else if (id2 == R$id.open_browser_switch) {
            c10028cM62182c0.m62336h2("browser", z10);
        } else if (id2 == R$id.open_backup_switch) {
            if (m16776a1(z10, CloudBackupConstant.Command.PMS_CMD_BACKUP)) {
                return;
            } else {
                m16747G1();
            }
        }
        m16771y1();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C0219i.m1463a() >= 17 && C0219i.m1463a() < 21) {
            mo16563K();
        } else if (C0219i.m1463a() >= 21) {
            mo16564M();
        }
        m16745D1();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f12478E0 = bundle.getBoolean("is_recreate");
            this.f12516x0 = bundle.getStringArrayList("page_service");
            C11839m.m70688i("SimplifyOOBEGuideActivity", "isRecreated: " + this.f12478E0);
        }
        m16757e1();
        m16777b1();
        m16755c1();
        super.mo16619y();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C13227f.m79492i1().m79577X(this);
        UBAAnalyze.m29964Y("PVC", getClass().getCanonicalName(), "1", "18", super.m16612u());
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f12478E0 = false;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C13227f.m79492i1().m79582b0(this);
        UBAAnalyze.m29967a0("PVC", getClass().getCanonicalName(), "1", "18");
        m16771y1();
        if (C0209d.m1198P(this) && !this.f12358r && C0209d.m1200P1(this)) {
            C11839m.m70688i("SimplifyOOBEGuideActivity", "setLaterStatus auto close ");
            setResult(-1);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_recreate", true);
        bundle.putStringArrayList("page_service", this.f12516x0);
    }

    /* renamed from: q1 */
    public void m16782q1() {
        if (ModuleConfigUtil.getInstance().isAllModuleDisabledIncludePhonefinder(this) && C0219i.m1463a() >= 23) {
            C10028c.m62182c0().m62377p3("is_all_guide_over", true);
            C0209d.m1318v2(this);
            setResult(-1);
            finish();
            return;
        }
        m16743A1();
        C1006a.m5936k().m5940D(getApplicationContext());
        if (!"CN".equalsIgnoreCase(C13452e.m80781L().m80942m())) {
            m16638S0();
            return;
        }
        if (C11829c.m70534N0(this, C13452e.m80781L().m80942m())) {
            mo16632M0();
            return;
        }
        Intent intent = new Intent(this, (Class<?>) SimplifyOOBETermsActivity.class);
        if (!TextUtils.isEmpty(this.f12518z0)) {
            intent.putExtra("channel_of_open_switch", this.f12518z0);
        }
        startActivityForResult(intent, 0);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: u0 */
    public void mo16613u0() {
        m16603p0();
    }

    /* renamed from: u1 */
    public void m16783u1() {
        this.f12516x0 = new ArrayList<>();
        if (this.f12486T.isChecked()) {
            this.f12516x0.add(CloudBackupConstant.Command.PMS_CMD_BACKUP);
            this.f12516x0.add("backup_calendar");
            this.f12516x0.add("backup_calllog");
            this.f12516x0.add("backup_contact");
            this.f12516x0.add("backup_sms");
        }
        if (this.f12489W.isChecked()) {
            this.f12516x0.add("sync_contact");
        }
        if (this.f12491Y.isChecked()) {
            this.f12516x0.add("sync_calendar");
        }
        if (this.f12490X.isChecked()) {
            this.f12516x0.add("sync_ablum");
        }
        if (this.f12516x0.size() > 0) {
            List<String> listM69907f = this.f12374A.m69907f(this.f12516x0);
            C11839m.m70688i("SimplifyOOBEGuideActivity", "Need Permissions Size:" + listM69907f.size());
            m16627H0(listM69907f);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: y */
    public void mo16619y() {
    }
}
