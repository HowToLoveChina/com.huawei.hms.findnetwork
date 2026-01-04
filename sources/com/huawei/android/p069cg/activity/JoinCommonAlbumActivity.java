package com.huawei.android.p069cg.activity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.drive.cloudphoto.model.Inviter;
import com.huawei.android.hicloud.drive.cloudphoto.model.Member;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiextend.CustomRoundImageView;
import com.huawei.android.p069cg.R$color;
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
import p031b7.C1130k;
import p031b7.C1140u;
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
public class JoinCommonAlbumActivity extends UIActivity implements View.OnClickListener, TextWatcher {

    /* renamed from: A */
    public TextView f10192A;

    /* renamed from: B */
    public TextView f10193B;

    /* renamed from: C */
    public CustomRoundImageView f10194C;

    /* renamed from: D */
    public Handler f10195D = new HandlerC2203b();

    /* renamed from: p */
    public NotchTopFitRelativeLayout f10196p;

    /* renamed from: q */
    public NotchFitRelativeLayout f10197q;

    /* renamed from: r */
    public EditText f10198r;

    /* renamed from: s */
    public String f10199s;

    /* renamed from: t */
    public Button f10200t;

    /* renamed from: u */
    public LinearLayout f10201u;

    /* renamed from: v */
    public RelativeLayout f10202v;

    /* renamed from: w */
    public Inviter f10203w;

    /* renamed from: x */
    public View f10204x;

    /* renamed from: y */
    public TextView f10205y;

    /* renamed from: z */
    public TextView f10206z;

    /* renamed from: com.huawei.android.cg.activity.JoinCommonAlbumActivity$a */
    public class C2202a extends AbstractC12367d {
        public C2202a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (JoinCommonAlbumActivity.this.f10203w == null) {
                C1120a.m6676e("JoinCommonAlbumActivity", "doApplyJoinRequst mInviter is null");
                return;
            }
            try {
                JoinCommonAlbumActivity.this.f10203w.setRemark(JoinCommonAlbumActivity.this.f10198r.getText().toString());
                JoinCommonAlbumActivity.this.f10203w.setKinship("other");
                JoinCommonAlbumActivity.this.f10203w.setPrivilege("upload");
                C12469b.m74746l().m74748b(JoinCommonAlbumActivity.this.f10203w, null);
                Message messageObtainMessage = JoinCommonAlbumActivity.this.f10195D.obtainMessage();
                messageObtainMessage.what = 819;
                JoinCommonAlbumActivity.this.f10195D.sendMessage(messageObtainMessage);
            } catch (C4616s e10) {
                C12091d.m72280a0().m72309H0(JoinCommonAlbumActivity.this.f10195D, e10);
                C12091d.m72280a0().m72307G0(e10, JoinCommonAlbumActivity.this.f10195D);
            } catch (Exception e11) {
                C1120a.m6676e("JoinCommonAlbumActivity", "doApplyJoinRequst error:" + e11.getMessage());
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.JoinCommonAlbumActivity$b */
    public class HandlerC2203b extends Handler {
        public HandlerC2203b() {
        }

        @Override // android.os.Handler
        @SuppressLint({"HandlerLeak"})
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 819) {
                JoinCommonAlbumActivity.this.f10201u.setVisibility(0);
                JoinCommonAlbumActivity.this.f10202v.setVisibility(8);
            } else {
                if (i10 == 4956) {
                    JoinCommonAlbumActivity.this.m13606Z1(true);
                    return;
                }
                if (4031 == i10) {
                    JoinCommonAlbumActivity.this.m13602V1();
                }
                C12091d c12091dM72280a0 = C12091d.m72280a0();
                JoinCommonAlbumActivity joinCommonAlbumActivity = JoinCommonAlbumActivity.this;
                c12091dM72280a0.m72361j1(joinCommonAlbumActivity, message.what, joinCommonAlbumActivity.f10203w.getRemark());
            }
        }
    }

    /* renamed from: S1 */
    private void m13599S1() {
        if (!NetworkUtil.isNetworkAvailable(this)) {
            C1140u.m7197i(this);
            return;
        }
        m13603W1();
        C12515a.m75110o().m75175e(new C2202a(), false);
    }

    /* renamed from: T1 */
    private void m13600T1() {
        try {
            String stringExtra = new SafeIntent(getIntent()).getStringExtra("key_inviter_string");
            if (TextUtils.isEmpty(stringExtra)) {
                C1120a.m6676e("JoinCommonAlbumActivity", "getIntentData inviterString is null");
            } else {
                this.f10203w = (Inviter) C11903a.m71435l().mo69832e(stringExtra).m69886u(Inviter.class);
                m13605Y1();
            }
        } catch (Exception e10) {
            C1120a.m6676e("JoinCommonAlbumActivity", "getIntentData " + e10.getMessage());
        }
    }

    /* renamed from: U1 */
    private void m13601U1() {
        this.f10196p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f10197q = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_all);
        this.f10206z = (TextView) C12809f.m76829b(this, R$id.tv_joined_member);
        this.f10192A = (TextView) C12809f.m76829b(this, R$id.tv_album_name);
        this.f10193B = (TextView) C12809f.m76829b(this, R$id.tv_album_desc);
        CustomRoundImageView customRoundImageView = (CustomRoundImageView) C12809f.m76829b(this, R$id.iv_album_cover);
        this.f10194C = customRoundImageView;
        customRoundImageView.setVisibility(0);
        EditText editText = (EditText) C12809f.m76829b(this, R$id.et_input_name);
        this.f10198r = editText;
        editText.addTextChangedListener(this);
        this.f10198r.setFilters(new InputFilter[]{C1130k.m6918c(), C1130k.m6917b()});
        Button button = (Button) C12809f.m76829b(this, R$id.btn_apply_join);
        this.f10200t = button;
        button.setOnClickListener(this);
        this.f10201u = (LinearLayout) C12809f.m76829b(this, R$id.llay_apply_finish);
        ((Button) C12809f.m76829b(this, R$id.btn_go_back)).setOnClickListener(this);
        ((RelativeLayout) C12809f.m76829b(this, R$id.ic_back_hot_space)).setOnClickListener(this);
        this.f10202v = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_common_container);
        this.f10204x = C12809f.m76829b(this, R$id.view_input_underline);
        this.f10205y = (TextView) C12809f.m76829b(this, R$id.tv_input_check_hint);
        m13606Z1(false);
        m13604X1(0.5f, false);
    }

    /* renamed from: V1 */
    public final void m13602V1() {
        C1120a.m6675d("JoinCommonAlbumActivity", "reportMigrateAccount eventCode action_code_migrate_account");
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("share_type", String.valueOf(0));
        C13224c.m79487f1().m79592m0("action_code_migrate_account", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "action_code_migrate_account", "1", "action_code_migrate_account", linkedHashMapM79497A);
    }

    /* renamed from: W1 */
    public final void m13603W1() {
        C1120a.m6675d("JoinCommonAlbumActivity", "reportJoinCommonAlbum eventCode action_code_click_join_common");
        C13224c.m79487f1().m79585f0("action_code_click_join_common", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "action_code_click_join_common", "1", "from_join_share_album");
    }

    /* renamed from: X1 */
    public final void m13604X1(float f10, boolean z10) {
        this.f10200t.setAlpha(f10);
        this.f10200t.setSelected(z10);
        this.f10200t.setEnabled(z10);
        this.f10200t.setClickable(z10);
    }

    /* renamed from: Y1 */
    public final void m13605Y1() throws Resources.NotFoundException {
        Inviter inviter = this.f10203w;
        if (inviter == null) {
            C1120a.m6676e("JoinCommonAlbumActivity", "mInviter is null");
            return;
        }
        this.f10192A.setText(getString(R$string.someone_share_album, inviter.getRemark()));
        this.f10193B.setText(this.f10203w.getAlbumName());
        List<String> showImages = this.f10203w.getShowImages();
        if (showImages == null || showImages.size() <= 0) {
            C1120a.m6675d("JoinCommonAlbumActivity", "imagesList is null ");
        } else {
            String str = showImages.get(0);
            C1120a.m6675d("JoinCommonAlbumActivity", " coverUrl " + str);
            if (TextUtils.isEmpty(str)) {
                C1120a.m6675d("JoinCommonAlbumActivity", "coverUrl is null");
            } else {
                C12096i.m72418I().m72437F(str, this.f10194C);
            }
        }
        Member members = this.f10203w.getMembers();
        if (members == null) {
            C1120a.m6675d("JoinCommonAlbumActivity", "showAlbumInfo memberInfo is null ");
            return;
        }
        Integer number = members.getNumber();
        int iIntValue = number.intValue();
        C1120a.m6675d("JoinCommonAlbumActivity", "showAlbumInfo memberSize " + iIntValue);
        String quantityString = getResources().getQuantityString(R$plurals.joined_member_desc, iIntValue, number);
        C1120a.m6675d("JoinCommonAlbumActivity", "showAlbumInfo joinedMemberStr " + quantityString);
        this.f10206z.setText(quantityString);
    }

    /* renamed from: Z1 */
    public final void m13606Z1(boolean z10) {
        this.f10204x.setBackgroundColor(getColor(z10 ? R$color.color_FB374E : R$color.CS_black));
        this.f10205y.setText(z10 ? getString(R$string.sensitive_word) : "");
        this.f10205y.setTextColor(getColor(z10 ? R$color.color_FB374E : R$color.color_input_hint));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10196p);
        arrayList.add(this.f10197q);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C1120a.m6676e("JoinCommonAlbumActivity", "fast click");
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.btn_apply_join) {
            m13599S1();
        } else if (id2 == R$id.btn_go_back) {
            finish();
        } else if (id2 == R$id.ic_back_hot_space) {
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.layout_join_common_album);
        m13601U1();
        m13600T1();
        mo19005p1();
        C11842p.m70889z0(this);
        m22369I1();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.f10199s = charSequence.toString();
        C1120a.m6675d("JoinCommonAlbumActivity", "mInputResult " + this.f10199s);
        m13604X1(TextUtils.isEmpty(this.f10199s) ? 0.5f : 1.0f, !TextUtils.isEmpty(this.f10199s));
        if (TextUtils.isEmpty(this.f10199s)) {
            m13606Z1(false);
        }
    }
}
