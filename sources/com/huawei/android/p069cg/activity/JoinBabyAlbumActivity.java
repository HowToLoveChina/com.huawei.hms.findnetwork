package com.huawei.android.p069cg.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.drive.cloudphoto.model.Inviter;
import com.huawei.android.hicloud.drive.cloudphoto.model.Member;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiextend.CustomRoundImageView;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$plurals;
import com.huawei.android.p069cg.R$string;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.p148ui.SafeIntent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p031b7.C1120a;
import p031b7.C1140u;
import p514o9.C11839m;
import p514o9.C11842p;
import p523oi.C11903a;
import p546p6.C12091d;
import p546p6.C12096i;
import p581qk.AbstractC12367d;
import p604r7.C12469b;
import p616rk.C12515a;
import p684un.C13224c;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes2.dex */
public class JoinBabyAlbumActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: A */
    public RelativeLayout f10160A;

    /* renamed from: B */
    public RelativeLayout f10161B;

    /* renamed from: C */
    public TextView f10162C;

    /* renamed from: D */
    public TextView f10163D;

    /* renamed from: E */
    public TextView f10164E;

    /* renamed from: F */
    public TextView f10165F;

    /* renamed from: G */
    public TextView f10166G;

    /* renamed from: H */
    public TextView f10167H;

    /* renamed from: I */
    public TextView f10168I;

    /* renamed from: J */
    public TextView f10169J;

    /* renamed from: K */
    public TextView f10170K;

    /* renamed from: L */
    public TextView f10171L;

    /* renamed from: M */
    public CustomRoundImageView f10172M;

    /* renamed from: O */
    public Button f10174O;

    /* renamed from: P */
    public String f10175P;

    /* renamed from: Q */
    public String f10176Q;

    /* renamed from: R */
    public String f10177R;

    /* renamed from: p */
    public NotchTopFitRelativeLayout f10179p;

    /* renamed from: q */
    public NotchFitLinearLayout f10180q;

    /* renamed from: r */
    public LinearLayout f10181r;

    /* renamed from: s */
    public RelativeLayout f10182s;

    /* renamed from: t */
    public Inviter f10183t;

    /* renamed from: u */
    public RelativeLayout f10184u;

    /* renamed from: v */
    public RelativeLayout f10185v;

    /* renamed from: w */
    public RelativeLayout f10186w;

    /* renamed from: x */
    public RelativeLayout f10187x;

    /* renamed from: y */
    public RelativeLayout f10188y;

    /* renamed from: z */
    public RelativeLayout f10189z;

    /* renamed from: N */
    public String f10173N = "";

    /* renamed from: S */
    public Handler f10178S = new HandlerC2201b();

    /* renamed from: com.huawei.android.cg.activity.JoinBabyAlbumActivity$a */
    public class C2200a extends AbstractC12367d {
        public C2200a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (JoinBabyAlbumActivity.this.f10183t == null) {
                C1120a.m6676e("JoinBabyAlbumActivity", "doApplyJoinRequst mInviter is null");
                return;
            }
            try {
                JoinBabyAlbumActivity.this.f10183t.setKinship(JoinBabyAlbumActivity.this.f10177R);
                JoinBabyAlbumActivity.this.f10183t.setRemark(JoinBabyAlbumActivity.this.f10176Q);
                JoinBabyAlbumActivity.this.f10183t.setPrivilege("upload");
                C12469b.m74746l().m74748b(JoinBabyAlbumActivity.this.f10183t, null);
                Message messageObtainMessage = JoinBabyAlbumActivity.this.f10178S.obtainMessage();
                messageObtainMessage.what = 546;
                JoinBabyAlbumActivity.this.f10178S.sendMessage(messageObtainMessage);
            } catch (C4616s e10) {
                C12091d.m72280a0().m72307G0(e10, JoinBabyAlbumActivity.this.f10178S);
            } catch (Exception e11) {
                C11839m.m70687e("JoinBabyAlbumActivity", "doApplyJoinRequst error:" + e11.getMessage());
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.JoinBabyAlbumActivity$b */
    public class HandlerC2201b extends Handler {
        public HandlerC2201b() {
        }

        @Override // android.os.Handler
        @SuppressLint({"HandlerLeak"})
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 546) {
                JoinBabyAlbumActivity.this.f10181r.setVisibility(0);
                JoinBabyAlbumActivity.this.f10182s.setVisibility(8);
                return;
            }
            if (4031 == i10) {
                JoinBabyAlbumActivity.this.m13587X1();
            }
            C12091d c12091dM72280a0 = C12091d.m72280a0();
            JoinBabyAlbumActivity joinBabyAlbumActivity = JoinBabyAlbumActivity.this;
            c12091dM72280a0.m72361j1(joinBabyAlbumActivity, message.what, joinBabyAlbumActivity.f10176Q);
        }
    }

    /* renamed from: U1 */
    private void m13574U1() {
        m13589a2(false);
        try {
            String stringExtra = new SafeIntent(getIntent()).getStringExtra("key_inviter_string");
            if (TextUtils.isEmpty(stringExtra)) {
                C1120a.m6676e("JoinBabyAlbumActivity", "initData inviterString is null");
            } else {
                this.f10183t = (Inviter) C11903a.m71435l().mo69832e(stringExtra).m69886u(Inviter.class);
                m13591j2();
            }
        } catch (Exception e10) {
            C1120a.m6676e("JoinBabyAlbumActivity", "getIntentData " + e10.getMessage());
        }
    }

    /* renamed from: V1 */
    private void m13575V1() {
        this.f10179p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f10180q = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.main_all);
        this.f10181r = (LinearLayout) C12809f.m76829b(this, R$id.llay_apply_finish);
        this.f10169J = (TextView) C12809f.m76829b(this, R$id.tv_joined_member);
        this.f10170K = (TextView) C12809f.m76829b(this, R$id.tv_album_name);
        this.f10171L = (TextView) C12809f.m76829b(this, R$id.tv_album_desc);
        CustomRoundImageView customRoundImageView = (CustomRoundImageView) C12809f.m76829b(this, R$id.iv_album_cover_baby);
        this.f10172M = customRoundImageView;
        customRoundImageView.setVisibility(0);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_relation_mom);
        this.f10184u = relativeLayout;
        relativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_relation_dad);
        this.f10185v = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        RelativeLayout relativeLayout3 = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_relation_grandpa);
        this.f10186w = relativeLayout3;
        relativeLayout3.setOnClickListener(this);
        RelativeLayout relativeLayout4 = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_relation_grandma);
        this.f10187x = relativeLayout4;
        relativeLayout4.setOnClickListener(this);
        RelativeLayout relativeLayout5 = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_relation_grandpaa);
        this.f10188y = relativeLayout5;
        relativeLayout5.setOnClickListener(this);
        RelativeLayout relativeLayout6 = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_relation_grandmaa);
        this.f10189z = relativeLayout6;
        relativeLayout6.setOnClickListener(this);
        RelativeLayout relativeLayout7 = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_relation_other);
        this.f10160A = relativeLayout7;
        relativeLayout7.setOnClickListener(this);
        RelativeLayout relativeLayout8 = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_relation_other_last);
        this.f10161B = relativeLayout8;
        relativeLayout8.setOnClickListener(this);
        this.f10163D = (TextView) C12809f.m76829b(this, R$id.tv_relation_dad);
        this.f10162C = (TextView) C12809f.m76829b(this, R$id.tv_relation_mom);
        this.f10164E = (TextView) C12809f.m76829b(this, R$id.tv_relation_grandpa);
        this.f10165F = (TextView) C12809f.m76829b(this, R$id.tv_relation_grandma);
        this.f10166G = (TextView) C12809f.m76829b(this, R$id.tv_relation_grandpaa);
        this.f10167H = (TextView) C12809f.m76829b(this, R$id.tv_relation_grandmaa);
        this.f10168I = (TextView) C12809f.m76829b(this, R$id.tv_input_relation);
        Button button = (Button) C12809f.m76829b(this, R$id.btn_apply_join);
        this.f10174O = button;
        button.setOnClickListener(this);
        ((Button) C12809f.m76829b(this, R$id.btn_go_back)).setOnClickListener(this);
        ((RelativeLayout) C12809f.m76829b(this, R$id.ic_back_hot_space)).setOnClickListener(this);
        this.f10182s = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_baby_container);
    }

    /* renamed from: Z1 */
    private void m13576Z1() {
        m13577b2(false);
        m13582g2(false);
        m13580e2(false);
        m13578c2(false);
        m13581f2(false);
        m13579d2(false);
        m13590h2(false);
    }

    /* renamed from: b2 */
    private void m13577b2(boolean z10) {
        if (this.f10173N.contains("father")) {
            m13584S1(this.f10185v, this.f10163D);
            return;
        }
        m13589a2(z10);
        this.f10185v.setSelected(z10);
        this.f10163D.setSelected(z10);
        if (z10) {
            this.f10176Q = this.f10163D.getText().toString();
            this.f10177R = "father";
        }
    }

    /* renamed from: c2 */
    private void m13578c2(boolean z10) {
        if (this.f10173N.contains("grandma")) {
            m13584S1(this.f10187x, this.f10165F);
            return;
        }
        m13589a2(z10);
        this.f10187x.setSelected(z10);
        this.f10165F.setSelected(z10);
        if (z10) {
            this.f10176Q = this.f10165F.getText().toString();
            this.f10177R = "grandma";
        }
    }

    /* renamed from: d2 */
    private void m13579d2(boolean z10) {
        if (this.f10173N.contains("grandmother")) {
            m13584S1(this.f10189z, this.f10167H);
            return;
        }
        m13589a2(z10);
        this.f10189z.setSelected(z10);
        this.f10167H.setSelected(z10);
        if (z10) {
            this.f10176Q = this.f10167H.getText().toString();
            this.f10177R = "grandmother";
        }
    }

    /* renamed from: e2 */
    private void m13580e2(boolean z10) {
        if (this.f10173N.contains("grandpa")) {
            m13584S1(this.f10186w, this.f10164E);
            return;
        }
        m13589a2(z10);
        this.f10186w.setSelected(z10);
        this.f10164E.setSelected(z10);
        if (z10) {
            this.f10176Q = this.f10164E.getText().toString();
            this.f10177R = "grandpa";
        }
    }

    /* renamed from: f2 */
    private void m13581f2(boolean z10) {
        if (this.f10173N.contains("grandfather")) {
            m13584S1(this.f10188y, this.f10166G);
            return;
        }
        m13589a2(z10);
        this.f10188y.setSelected(z10);
        this.f10166G.setSelected(z10);
        if (z10) {
            this.f10176Q = this.f10166G.getText().toString();
            this.f10177R = "grandfather";
        }
    }

    /* renamed from: g2 */
    private void m13582g2(boolean z10) {
        if (this.f10173N.contains("mother")) {
            m13584S1(this.f10184u, this.f10162C);
            return;
        }
        m13589a2(z10);
        this.f10184u.setSelected(z10);
        this.f10162C.setSelected(z10);
        if (z10) {
            this.f10176Q = this.f10162C.getText().toString();
            this.f10177R = "mother";
        }
    }

    /* renamed from: i2 */
    private void m13583i2() {
        m13576Z1();
        if ("father".equals(this.f10175P)) {
            m13577b2(true);
            return;
        }
        if ("mother".equals(this.f10175P)) {
            m13582g2(true);
            return;
        }
        if ("grandpa".equals(this.f10175P)) {
            m13580e2(true);
            return;
        }
        if ("grandma".equals(this.f10175P)) {
            m13578c2(true);
            return;
        }
        if ("grandfather".equals(this.f10175P)) {
            m13581f2(true);
        } else if ("grandmother".equals(this.f10175P)) {
            m13579d2(true);
        } else if ("other".equals(this.f10175P)) {
            m13590h2(true);
        }
    }

    /* renamed from: S1 */
    public final void m13584S1(RelativeLayout relativeLayout, TextView textView) {
        relativeLayout.setSelected(false);
        textView.setSelected(false);
        relativeLayout.setAlpha(0.5f);
        relativeLayout.setClickable(false);
        relativeLayout.setEnabled(false);
    }

    /* renamed from: T1 */
    public final void m13585T1() {
        if (C0209d.m1226Y0()) {
            C1120a.m6675d("JoinBabyAlbumActivity", "doApplyJoinRequst fast click");
        } else {
            if (!NetworkUtil.isNetworkAvailable(this)) {
                C1140u.m7197i(this);
                return;
            }
            m13588Y1();
            C12515a.m75110o().m75175e(new C2200a(), false);
        }
    }

    /* renamed from: W1 */
    public final void m13586W1() {
        startActivityForResult(new Intent(this, (Class<?>) InputOtherRelatioinActivity.class), 11001);
    }

    /* renamed from: X1 */
    public final void m13587X1() {
        C1120a.m6675d("JoinBabyAlbumActivity", "reportMigrateAccount eventCode action_code_migrate_account");
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("share_type", String.valueOf(1));
        C13224c.m79487f1().m79592m0("action_code_migrate_account", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "action_code_migrate_account", "1", "action_code_migrate_account", linkedHashMapM79497A);
    }

    /* renamed from: Y1 */
    public final void m13588Y1() {
        C1120a.m6675d("JoinBabyAlbumActivity", "reportJoinBabyAlbum eventCode action_code_click_join_baby");
        C13224c.m79487f1().m79585f0("action_code_click_join_baby", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "action_code_click_join_baby", "1", "from_join_share_album");
    }

    /* renamed from: a2 */
    public final void m13589a2(boolean z10) {
        this.f10174O.setAlpha(z10 ? 1.0f : 0.5f);
        this.f10174O.setSelected(z10);
        this.f10174O.setEnabled(z10);
        this.f10174O.setClickable(z10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10179p);
        arrayList.add(this.f10180q);
        return arrayList;
    }

    /* renamed from: h2 */
    public final void m13590h2(boolean z10) {
        m13589a2(z10);
        this.f10160A.setSelected(z10);
        this.f10168I.setSelected(z10);
        if (z10) {
            this.f10176Q = this.f10168I.getText().toString();
            this.f10177R = "other";
        }
    }

    /* renamed from: j2 */
    public final void m13591j2() throws Resources.NotFoundException {
        this.f10170K.setText(getString(R$string.baby_album_new));
        this.f10171L.setText(this.f10183t.getAlbumName());
        Member members = this.f10183t.getMembers();
        if (members != null) {
            Integer number = members.getNumber();
            int iIntValue = number.intValue();
            C1120a.m6675d("JoinBabyAlbumActivity", "showAlbumInfo memberSize " + iIntValue);
            String quantityString = getResources().getQuantityString(R$plurals.joined_member_desc, iIntValue, number);
            C1120a.m6675d("JoinBabyAlbumActivity", "showAlbumInfo joinedMemberStr " + quantityString);
            this.f10169J.setText(quantityString);
            List<String> kinships = members.getKinships();
            if (kinships == null || kinships.size() <= 0) {
                C1120a.m6675d("JoinBabyAlbumActivity", "showAlbumInfo joinedList is null ");
            } else {
                this.f10173N = kinships.toString();
                C1120a.m6675d("JoinBabyAlbumActivity", "mJoinedKinshipStr " + this.f10173N);
                m13583i2();
            }
        } else {
            C1120a.m6675d("JoinBabyAlbumActivity", "showAlbumInfo memberInfo is null ");
        }
        String babySex = this.f10183t.getBabySex();
        int i10 = R$drawable.ic_default_unborn;
        if ("female".equals(babySex)) {
            i10 = R$drawable.ic_default_girl;
        } else if ("male".equals(babySex)) {
            i10 = R$drawable.ic_default_boy;
        }
        this.f10172M.setImageDrawable(getDrawable(i10));
        String babyAvatar = this.f10183t.getBabyAvatar();
        C1120a.m6675d("JoinBabyAlbumActivity", "babyAvatar " + babyAvatar);
        if (TextUtils.isEmpty(babyAvatar)) {
            C1120a.m6675d("JoinBabyAlbumActivity", "coverUrl is null");
        } else {
            C12096i.m72418I().m72437F(babyAvatar, this.f10172M);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 11001) {
            String stringExtra = new SafeIntent(intent).getStringExtra("type_other_relation");
            C1120a.m6675d("JoinBabyAlbumActivity", "defineRleationStr " + stringExtra);
            if (TextUtils.isEmpty(stringExtra)) {
                C1120a.m6675d("JoinBabyAlbumActivity", "defineRleationStr " + stringExtra);
                return;
            }
            this.f10168I.setText(stringExtra);
            this.f10175P = "other";
            m13583i2();
            this.f10161B.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.btn_apply_join) {
            m13585T1();
            return;
        }
        if (id2 == R$id.btn_go_back) {
            finish();
            return;
        }
        if (id2 == R$id.ic_back_hot_space) {
            finish();
            return;
        }
        if (id2 == R$id.rlay_relation_mom) {
            this.f10175P = "mother";
            m13583i2();
            return;
        }
        if (id2 == R$id.rlay_relation_dad) {
            this.f10175P = "father";
            m13583i2();
            return;
        }
        if (id2 == R$id.rlay_relation_grandpa) {
            this.f10175P = "grandpa";
            m13583i2();
            return;
        }
        if (id2 == R$id.rlay_relation_grandma) {
            this.f10175P = "grandma";
            m13583i2();
            return;
        }
        if (id2 == R$id.rlay_relation_grandpaa) {
            this.f10175P = "grandfather";
            m13583i2();
            return;
        }
        if (id2 == R$id.rlay_relation_grandmaa) {
            this.f10175P = "grandmother";
            m13583i2();
        } else if (id2 != R$id.rlay_relation_other) {
            if (id2 == R$id.rlay_relation_other_last) {
                m13586W1();
            }
        } else if (this.f10161B.getVisibility() != 0) {
            m13586W1();
        } else {
            this.f10175P = "other";
            m13583i2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.layout_join_baby_album);
        m13575V1();
        m13574U1();
        mo19005p1();
        C11842p.m70889z0(this);
        m22369I1();
    }
}
