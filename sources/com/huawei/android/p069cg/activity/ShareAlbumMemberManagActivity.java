package com.huawei.android.p069cg.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.drive.cloudphoto.model.PermissionUpdateRequest;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.secure.android.common.intent.SafeIntent;
import hu.C10343b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p015ak.C0209d;
import p031b7.C1122c;
import p031b7.C1140u;
import p336he.C10159j;
import p471m6.C11415a;
import p471m6.C11418d;
import p471m6.C11422h;
import p486n6.ViewOnClickListenerC11638c;
import p514o9.C11839m;
import p546p6.C12091d;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes2.dex */
public class ShareAlbumMemberManagActivity extends UIActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, ViewOnClickListenerC11638c.a {

    /* renamed from: A */
    public TextView f10581A;

    /* renamed from: B */
    public TextView f10582B;

    /* renamed from: C */
    public TextView f10583C;

    /* renamed from: D */
    public TextView f10584D;

    /* renamed from: E */
    public TextView f10585E;

    /* renamed from: F */
    public TextView f10586F;

    /* renamed from: G */
    public TextView f10587G;

    /* renamed from: H */
    public AlertDialog f10588H;

    /* renamed from: I */
    public UnionSwitch f10589I;

    /* renamed from: J */
    public UnionSwitch f10590J;

    /* renamed from: K */
    public RelativeLayout f10591K;

    /* renamed from: L */
    public RelativeLayout f10592L;

    /* renamed from: M */
    public ViewOnClickListenerC11638c f10593M;

    /* renamed from: N */
    public boolean f10594N;

    /* renamed from: O */
    public RelativeLayout f10595O;

    /* renamed from: P */
    public UnionSwitch f10596P;

    /* renamed from: r */
    public RelativeLayout f10600r;

    /* renamed from: s */
    public String f10601s;

    /* renamed from: t */
    public String f10602t;

    /* renamed from: u */
    public String f10603u;

    /* renamed from: v */
    public C11415a f10604v;

    /* renamed from: w */
    public C11422h f10605w;

    /* renamed from: x */
    public RelativeLayout f10606x;

    /* renamed from: y */
    public Button f10607y;

    /* renamed from: z */
    public ImageView f10608z;

    /* renamed from: p */
    public NotchTopFitRelativeLayout f10598p = null;

    /* renamed from: q */
    public NotchFitRelativeLayout f10599q = null;

    /* renamed from: Q */
    public Handler f10597Q = new HandlerC2243a();

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumMemberManagActivity$a */
    public class HandlerC2243a extends Handler {
        public HandlerC2243a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1008) {
                ShareAlbumMemberManagActivity.this.f10605w = (C11422h) message.obj;
                ShareAlbumMemberManagActivity.this.m13947b2();
                return;
            }
            if (i10 == 1009) {
                ShareAlbumMemberManagActivity.this.f10604v = (C11415a) message.obj;
                ShareAlbumMemberManagActivity shareAlbumMemberManagActivity = ShareAlbumMemberManagActivity.this;
                shareAlbumMemberManagActivity.f10594N = shareAlbumMemberManagActivity.f10604v.m68362a().getShareType().intValue() == 1;
                ShareAlbumMemberManagActivity.this.m13947b2();
                return;
            }
            if (i10 != 1007) {
                if (i10 == 1036) {
                    ShareAlbumMemberManagActivity.this.setResult(101);
                    ShareAlbumMemberManagActivity.this.finish();
                    return;
                }
                return;
            }
            List list = (List) message.obj;
            String kinship = ShareAlbumMemberManagActivity.this.f10604v.m68362a().getKinship();
            List listM13943W1 = ShareAlbumMemberManagActivity.this.m13943W1();
            listM13943W1.remove(kinship);
            String strM80971t0 = C13452e.m80781L().m80971t0();
            boolean zEquals = TextUtils.equals(strM80971t0, ShareAlbumMemberManagActivity.this.f10603u);
            boolean zEquals2 = TextUtils.equals(ShareAlbumMemberManagActivity.this.f10605w.m68436b().getUserId(), strM80971t0);
            if (zEquals && zEquals2) {
                listM13943W1.remove("other");
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((C11422h) it.next()).m68436b().getKinship());
            }
            ShareAlbumMemberManagActivity.this.f10593M = new ViewOnClickListenerC11638c(ShareAlbumMemberManagActivity.this, ShareAlbumMemberManagActivity.this.m13944X1(listM13943W1, arrayList));
            ShareAlbumMemberManagActivity.this.f10593M.show();
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumMemberManagActivity$b */
    public static class DialogInterfaceOnClickListenerC2244b implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public boolean f10610a;

        /* renamed from: b */
        public Activity f10611b;

        /* renamed from: c */
        public Handler f10612c;

        /* renamed from: d */
        public String f10613d;

        /* renamed from: e */
        public String f10614e;

        /* renamed from: f */
        public String f10615f;

        public DialogInterfaceOnClickListenerC2244b(Activity activity, boolean z10, String str, String str2, String str3, Handler handler) {
            this.f10610a = z10;
            this.f10611b = activity;
            this.f10613d = str;
            this.f10615f = str3;
            this.f10614e = str2;
            this.f10612c = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (this.f10611b == null) {
                C11839m.m70688i("ShareAlbumMemberManagActivity", "mActivity null");
            } else if (this.f10610a) {
                C12091d.m72280a0().m72392v(this.f10613d, this.f10614e, this.f10615f, this.f10612c);
            } else {
                C11839m.m70688i("ShareAlbumMemberManagActivity", "dialog cancel");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W1 */
    public List<String> m13943W1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("father");
        arrayList.add("mother");
        arrayList.add("grandpa");
        arrayList.add("grandma");
        arrayList.add("grandfather");
        arrayList.add("grandmother");
        arrayList.add("other");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X1 */
    public List<C11418d> m13944X1(List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            C11418d c11418d = new C11418d();
            c11418d.m68412c(str);
            if (str.equals("other") || !list2.contains(str)) {
                c11418d.m68413d(0);
            } else {
                c11418d.m68413d(1);
            }
            arrayList.add(c11418d);
        }
        return arrayList;
    }

    /* renamed from: Y1 */
    private void m13945Y1() {
        C12091d.m72280a0().m72320O(this.f10601s, this.f10597Q);
        C12091d.m72280a0().m72354g0(this.f10601s, this.f10603u, this.f10602t, this.f10597Q);
    }

    /* renamed from: Z1 */
    private boolean m13946Z1() {
        return (this.f10604v == null || this.f10605w == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b2 */
    public void m13947b2() {
        if (m13946Z1()) {
            this.f10600r.setVisibility(4);
            this.f10599q.setVisibility(0);
            String strM80971t0 = C13452e.m80781L().m80971t0();
            boolean zEquals = TextUtils.equals(strM80971t0, this.f10604v.m68362a().getAlbumOwnerId());
            boolean zEquals2 = TextUtils.equals(this.f10605w.m68436b().getUserId(), strM80971t0);
            C11839m.m70688i("ShareAlbumMemberManagActivity", "isUserOwner: " + zEquals);
            C11839m.m70688i("ShareAlbumMemberManagActivity", "isMemberOwner: " + zEquals2);
            C11839m.m70686d("ShareAlbumMemberManagActivity", "isBaby: " + this.f10594N);
            C11839m.m70686d("ShareAlbumMemberManagActivity", "member: " + this.f10605w.m68436b().toString());
            String userAccount = this.f10605w.m68436b().getUserAccount();
            String displayName = this.f10605w.m68436b().getDisplayName();
            if (TextUtils.equals(userAccount, displayName)) {
                displayName = C1140u.m7196h(userAccount);
            }
            this.f10581A.setText(displayName);
            String strM7196h = C1140u.m7196h(userAccount);
            TextView textView = this.f10582B;
            int i10 = R$string.album_member_id;
            textView.setText(getString(i10, strM7196h));
            Map<String, String> properties = this.f10605w.m68436b().getProperties();
            if (properties != null) {
                String str = properties.get("last_vist_time");
                if (TextUtils.isEmpty(str)) {
                    this.f10587G.setVisibility(8);
                } else {
                    this.f10587G.setText(getString(R$string.album_date_last_vist, C10159j.m63330f(this, new C4644l(str).m28458c(), false)));
                }
            } else {
                this.f10587G.setVisibility(8);
            }
            m13954h2();
            if (zEquals && zEquals2) {
                m13953g2(this.f10594N);
                this.f10582B.setText(getString(i10, userAccount));
                return;
            }
            if (zEquals && !zEquals2) {
                this.f10587G.setVisibility(0);
                m13952f2(this.f10594N);
            } else if (!zEquals && zEquals2) {
                m13951e2(this.f10594N);
            } else {
                if (zEquals || zEquals2) {
                    return;
                }
                m13950d2(this.f10594N);
            }
        }
    }

    @Override // p486n6.ViewOnClickListenerC11638c.a
    /* renamed from: N */
    public void mo13734N(String str) {
        if (!TextUtils.equals(str, "other")) {
            this.f10583C.setText(C1140u.m7193e(this, str));
            PermissionUpdateRequest permissionUpdateRequest = new PermissionUpdateRequest();
            permissionUpdateRequest.setKinship(str);
            C12091d.m72280a0().m72370n1(this.f10601s, this.f10604v.m68362a().getAlbumOwnerId(), this.f10605w.m68436b().getUserId(), permissionUpdateRequest, this.f10597Q);
            return;
        }
        Intent intent = new Intent(this, (Class<?>) ShareAlbumInfoTypingctivity.class);
        intent.putExtra("typing_source", 102);
        intent.putExtra("param_album_id", this.f10601s);
        intent.putExtra("param_owner_id", this.f10604v.m68362a().getAlbumOwnerId());
        intent.putExtra("param_permission_user_id", this.f10605w.m68436b().getUserId());
        startActivityForResult(intent, 102);
    }

    /* renamed from: a2 */
    public final void m13948a2(boolean z10, String str) {
        String privilege = this.f10605w.m68436b().getPrivilege();
        PermissionUpdateRequest permissionUpdateRequest = new PermissionUpdateRequest();
        if (z10) {
            permissionUpdateRequest.setPrivilege(C1122c.m6769d(privilege, str));
        } else {
            permissionUpdateRequest.setPrivilege(C1122c.m6726P1(privilege, str));
        }
        C12091d.m72280a0().m72370n1(this.f10601s, this.f10604v.m68362a().getAlbumOwnerId(), this.f10605w.m68436b().getUserId(), permissionUpdateRequest, this.f10597Q);
    }

    /* renamed from: c2 */
    public final void m13949c2() {
        ViewGroup.LayoutParams layoutParams = this.f10592L.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.removeRule(10);
            layoutParams2.addRule(15);
            this.f10592L.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10599q);
        arrayList.add(this.f10598p);
        return arrayList;
    }

    /* renamed from: d2 */
    public final void m13950d2(boolean z10) {
        this.f10606x.setVisibility(8);
        this.f10585E.setText(R$string.album_member_remarks);
        this.f10584D.setText(R$string.album_member_permission);
        if (z10) {
            this.f10585E.setText(R$string.album_other_baby_relationship);
        }
        this.f10591K.setVisibility(8);
        m13949c2();
        this.f10589I.setCheckedProgrammatically(this.f10605w.m68436b().canUpload());
        this.f10589I.setClickable(false);
        this.f10596P.setCheckedProgrammatically(this.f10605w.m68436b().canDownload());
        this.f10596P.setClickable(false);
    }

    /* renamed from: e2 */
    public final void m13951e2(boolean z10) {
        this.f10606x.setVisibility(8);
        this.f10585E.setText(R$string.album_my_remark);
        this.f10584D.setText(R$string.album_my_permission);
        if (z10) {
            this.f10585E.setText(R$string.album_baby_relationship);
        }
        this.f10591K.setVisibility(8);
        m13949c2();
        this.f10589I.setCheckedProgrammatically(this.f10605w.m68436b().canUpload());
        this.f10589I.setClickable(false);
        this.f10596P.setCheckedProgrammatically(this.f10605w.m68436b().canDownload());
        this.f10596P.setClickable(false);
    }

    /* renamed from: f2 */
    public final void m13952f2(boolean z10) {
        this.f10606x.setVisibility(0);
        this.f10585E.setText(R$string.album_member_remarks);
        this.f10584D.setText(R$string.album_member_permission);
        if (z10) {
            this.f10585E.setText(R$string.album_other_baby_relationship);
        }
        this.f10591K.setVisibility(8);
        m13949c2();
        this.f10589I.setCheckedProgrammatically(this.f10605w.m68436b().canUpload());
        this.f10589I.setClickable(true);
        this.f10589I.setOnCheckedChangeListener(this);
        this.f10596P.setCheckedProgrammatically(this.f10605w.m68436b().canDownload());
        this.f10596P.setClickable(true);
        this.f10596P.setOnCheckedChangeListener(this);
    }

    /* renamed from: g2 */
    public final void m13953g2(boolean z10) {
        this.f10606x.setVisibility(8);
        this.f10585E.setText(R$string.album_my_remark);
        this.f10584D.setText(R$string.album_my_permission);
        this.f10589I.setCheckedProgrammatically(true);
        this.f10590J.setCheckedProgrammatically(false);
        this.f10596P.setCheckedProgrammatically(true);
        this.f10589I.setClickable(false);
        this.f10590J.setClickable(false);
        this.f10596P.setClickable(false);
        this.f10589I.setAlpha(0.3f);
        this.f10590J.setAlpha(0.3f);
        this.f10596P.setAlpha(0.3f);
        this.f10587G.setVisibility(8);
        if (z10) {
            this.f10585E.setText(R$string.album_baby_relationship);
        }
    }

    /* renamed from: h2 */
    public final void m13954h2() {
        if (!this.f10594N) {
            if (TextUtils.isEmpty(this.f10605w.m68436b().getRemark())) {
                this.f10583C.setText(this.f10605w.m68436b().getDisplayName());
                return;
            } else {
                this.f10583C.setText(this.f10605w.m68436b().getRemark());
                return;
            }
        }
        String kinship = this.f10605w.m68436b().getKinship();
        this.f10583C.setText(C1140u.m7193e(this, kinship));
        if (TextUtils.equals(kinship, "other") || TextUtils.isEmpty(this.f10605w.m68436b().getKinship())) {
            if (TextUtils.isEmpty(this.f10605w.m68436b().getRemark())) {
                this.f10583C.setText(this.f10605w.m68436b().getDisplayName());
            } else {
                this.f10583C.setText(this.f10605w.m68436b().getRemark());
            }
        }
    }

    /* renamed from: i2 */
    public final void m13955i2() {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setMessage(getString(R$string.album_delete_member_notice)).setPositiveButton(R$string.album_delete_member, new DialogInterfaceOnClickListenerC2244b(this, true, this.f10601s, this.f10604v.m68362a().getAlbumOwnerId(), this.f10605w.m68436b().getUserId(), this.f10597Q)).setNegativeButton(R$string.cancel, new DialogInterfaceOnClickListenerC2244b(this, false, this.f10601s, this.f10604v.m68362a().getAlbumOwnerId(), this.f10605w.m68436b().getUserId(), this.f10597Q)).create();
        this.f10588H = alertDialogCreate;
        alertDialogCreate.show();
        this.f10588H.getButton(-1).setTextColor(getColor(R$color.album_delete_member_color));
        this.f10588H.getButton(-2).setTextColor(getColor(R$color.color_0091ff));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 103 && i11 == -1) {
            m13945Y1();
        } else if (i10 == 102 && i11 == -1) {
            m13945Y1();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        C11839m.m70688i("ShareAlbumMemberManagActivity", "onBackPressed");
        setResult(101);
        finish();
        super.onBackPressed();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        int id2 = compoundButton.getId();
        if (id2 == R$id.upload_permission_switch) {
            m13948a2(z10, "upload");
        } else if (id2 == R$id.download_permission_switch) {
            m13948a2(z10, "download");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.album_remove_button) {
            m13955i2();
            return;
        }
        if (id2 == R$id.tv_modify) {
            if (this.f10594N) {
                C12091d.m72280a0().m72324Q(this.f10601s, this.f10604v.m68362a().getAlbumOwnerId(), this.f10597Q);
                return;
            }
            Intent intent = new Intent(this, (Class<?>) ShareAlbumInfoTypingctivity.class);
            intent.putExtra("typing_source", 103);
            intent.putExtra("param_album_id", this.f10601s);
            intent.putExtra("param_owner_id", this.f10604v.m68362a().getAlbumOwnerId());
            intent.putExtra("param_applicant_remark", this.f10605w.m68436b().getRemark());
            intent.putExtra("param_permission_user_id", this.f10605w.m68436b().getUserId());
            startActivityForResult(intent, 103);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C10343b c10343b = new C10343b(new SafeIntent(getIntent()).getExtras());
        this.f10601s = c10343b.m63694p("param_album_id");
        this.f10602t = c10343b.m63694p("param_member_id");
        String strM63694p = c10343b.m63694p("param_user_id");
        this.f10603u = c10343b.m63694p("param_owner_id");
        setContentView(R$layout.activity_album_member_manager);
        this.f10598p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.top_notch_fit_layout);
        this.f10599q = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f10600r = (RelativeLayout) C12809f.m76829b(this, R$id.rl_loading);
        this.f10606x = (RelativeLayout) C12809f.m76829b(this, R$id.rl_remove_button);
        this.f10607y = (Button) C12809f.m76829b(this, R$id.album_remove_button);
        this.f10608z = (ImageView) C12809f.m76829b(this, R$id.ic_head);
        C12091d.m72280a0().m72296B(strM63694p, this.f10608z);
        this.f10607y.setOnClickListener(this);
        this.f10581A = (TextView) C12809f.m76829b(this, R$id.tv_accout_display_name);
        this.f10582B = (TextView) C12809f.m76829b(this, R$id.tv_accout_id);
        this.f10583C = (TextView) C12809f.m76829b(this, R$id.tv_remark);
        this.f10587G = (TextView) C12809f.m76829b(this, R$id.tv_recent);
        this.f10584D = (TextView) C12809f.m76829b(this, R$id.permission_label);
        this.f10585E = (TextView) C12809f.m76829b(this, R$id.tv_remark_label);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.tv_modify);
        this.f10586F = textView;
        textView.setOnClickListener(this);
        this.f10589I = (UnionSwitch) C12809f.m76829b(this, R$id.upload_permission_switch);
        this.f10590J = (UnionSwitch) C12809f.m76829b(this, R$id.invite_permission_switch);
        this.f10591K = (RelativeLayout) C12809f.m76829b(this, R$id.rl_invite);
        this.f10592L = (RelativeLayout) C12809f.m76829b(this, R$id.rl_upload);
        this.f10595O = (RelativeLayout) C12809f.m76829b(this, R$id.rl_download);
        this.f10596P = (UnionSwitch) C12809f.m76829b(this, R$id.download_permission_switch);
        C11839m.m70686d("ShareAlbumMemberManagActivity", "onCreate:" + this.f10602t);
        mo19005p1();
        mo19982C1();
        m13945Y1();
        getActionBar().setTitle(R$string.album_member_management);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ViewOnClickListenerC11638c viewOnClickListenerC11638c = this.f10593M;
        if (viewOnClickListenerC11638c == null || !viewOnClickListenerC11638c.isShowing()) {
            return;
        }
        this.f10593M.dismiss();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            C11839m.m70688i("ShareAlbumMemberManagActivity", "onHome Pressed");
            setResult(101);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
