package com.huawei.android.p069cg.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Applicant;
import com.huawei.android.hicloud.drive.cloudphoto.model.Inviter;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$dimen;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.dialog.RejectApplicantConfirmDialog;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import hu.C10343b;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p015ak.C0209d;
import p031b7.C1122c;
import p031b7.C1140u;
import p336he.C10159j;
import p471m6.C11415a;
import p471m6.C11416b;
import p471m6.C11418d;
import p471m6.C11422h;
import p486n6.ViewOnClickListenerC11638c;
import p514o9.C11839m;
import p514o9.C11842p;
import p546p6.C12091d;
import p546p6.C12096i;
import sk.C12809f;

/* loaded from: classes2.dex */
public class ShareAlbumApplicationInfoActivity extends UIActivity implements View.OnClickListener, ViewOnClickListenerC11638c.a {

    /* renamed from: A */
    public RelativeLayout f10311A;

    /* renamed from: B */
    public String f10312B;

    /* renamed from: C */
    public String f10313C;

    /* renamed from: D */
    public ImageView f10314D;

    /* renamed from: E */
    public TextView f10315E;

    /* renamed from: F */
    public RelativeLayout f10316F;

    /* renamed from: G */
    public RelativeLayout f10317G;

    /* renamed from: H */
    public UnionSwitch f10318H;

    /* renamed from: I */
    public UnionSwitch f10319I;

    /* renamed from: K */
    public RelativeLayout f10321K;

    /* renamed from: M */
    public ImageView f10323M;

    /* renamed from: N */
    public TextView f10324N;

    /* renamed from: O */
    public TextView f10325O;

    /* renamed from: P */
    public TextView f10326P;

    /* renamed from: Q */
    public HwProgressBar f10327Q;

    /* renamed from: R */
    public HwProgressBar f10328R;

    /* renamed from: S */
    public String f10329S;

    /* renamed from: T */
    public C11415a f10330T;

    /* renamed from: U */
    public Applicant f10331U;

    /* renamed from: V */
    public ViewOnClickListenerC11638c f10332V;

    /* renamed from: p */
    public RecyclerView f10334p;

    /* renamed from: q */
    public String f10335q;

    /* renamed from: r */
    public Button f10336r;

    /* renamed from: s */
    public Button f10337s;

    /* renamed from: t */
    public TextView f10338t;

    /* renamed from: u */
    public TextView f10339u;

    /* renamed from: v */
    public TextView f10340v;

    /* renamed from: w */
    public ImageView f10341w;

    /* renamed from: x */
    public TextView f10342x;

    /* renamed from: y */
    public TextView f10343y;

    /* renamed from: z */
    public ImageView f10344z;

    /* renamed from: J */
    public NotchTopFitRelativeLayout f10320J = null;

    /* renamed from: L */
    public NotchFitRelativeLayout f10322L = null;

    /* renamed from: W */
    public Handler f10333W = new HandlerC2217a();

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumApplicationInfoActivity$a */
    public class HandlerC2217a extends Handler {
        public HandlerC2217a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1014) {
                C11416b c11416b = (C11416b) message.obj;
                ShareAlbumApplicationInfoActivity.this.f10331U = c11416b.m68379b();
                if (ShareAlbumApplicationInfoActivity.this.f10331U == null) {
                    return;
                }
                String privilege = ShareAlbumApplicationInfoActivity.this.f10331U.getPrivilege();
                if (!TextUtils.isEmpty(privilege)) {
                    if (ShareAlbumApplicationInfoActivity.this.f10318H != null) {
                        ShareAlbumApplicationInfoActivity.this.f10318H.setChecked(privilege.contains("upload"));
                    }
                    if (ShareAlbumApplicationInfoActivity.this.f10319I != null) {
                        ShareAlbumApplicationInfoActivity.this.f10319I.setChecked(privilege.contains("download"));
                    }
                }
                if (TextUtils.isEmpty(ShareAlbumApplicationInfoActivity.this.f10329S)) {
                    ShareAlbumApplicationInfoActivity shareAlbumApplicationInfoActivity = ShareAlbumApplicationInfoActivity.this;
                    shareAlbumApplicationInfoActivity.f10329S = shareAlbumApplicationInfoActivity.f10331U.getAlbumId();
                    C12091d.m72280a0().m72320O(ShareAlbumApplicationInfoActivity.this.f10329S, ShareAlbumApplicationInfoActivity.this.f10333W);
                }
                ShareAlbumApplicationInfoActivity.this.f10339u.setText(c11416b.m68378a());
                ShareAlbumApplicationInfoActivity.this.f10340v.setText(ShareAlbumApplicationInfoActivity.this.getString(R$string.album_member_id, c11416b.m68380c()));
                ShareAlbumApplicationInfoActivity shareAlbumApplicationInfoActivity2 = ShareAlbumApplicationInfoActivity.this;
                shareAlbumApplicationInfoActivity2.f10312B = shareAlbumApplicationInfoActivity2.f10331U.getRemark();
                if (TextUtils.isEmpty(ShareAlbumApplicationInfoActivity.this.f10331U.getKinship()) || TextUtils.equals(ShareAlbumApplicationInfoActivity.this.f10331U.getKinship(), "other")) {
                    ShareAlbumApplicationInfoActivity.this.f10315E.setText(ShareAlbumApplicationInfoActivity.this.f10312B);
                } else {
                    TextView textView = ShareAlbumApplicationInfoActivity.this.f10315E;
                    ShareAlbumApplicationInfoActivity shareAlbumApplicationInfoActivity3 = ShareAlbumApplicationInfoActivity.this;
                    textView.setText(C1140u.m7193e(shareAlbumApplicationInfoActivity3, shareAlbumApplicationInfoActivity3.f10331U.getKinship()));
                }
                long jM28458c = ShareAlbumApplicationInfoActivity.this.f10331U.getExpirationTime().m28458c();
                long jCurrentTimeMillis = System.currentTimeMillis();
                ShareAlbumApplicationInfoActivity shareAlbumApplicationInfoActivity4 = ShareAlbumApplicationInfoActivity.this;
                shareAlbumApplicationInfoActivity4.f10313C = shareAlbumApplicationInfoActivity4.f10331U.getKinship();
                ShareAlbumApplicationInfoActivity.this.m13742y2(ShareAlbumApplicationInfoActivity.this.f10331U.getSource());
                C12091d.m72280a0().m72296B(ShareAlbumApplicationInfoActivity.this.f10331U.getUserId(), ShareAlbumApplicationInfoActivity.this.f10314D);
                ShareAlbumApplicationInfoActivity.this.m13740w2(jCurrentTimeMillis > jM28458c, c11416b.m68379b().getStatus());
                if (TextUtils.equals(ShareAlbumApplicationInfoActivity.this.f10331U.getStatus(), "await")) {
                    ShareAlbumApplicationInfoActivity.this.f10326P.setVisibility(0);
                    ShareAlbumApplicationInfoActivity.this.f10341w.setVisibility(0);
                    ShareAlbumApplicationInfoActivity.this.f10319I.setClickable(true);
                    ShareAlbumApplicationInfoActivity.this.f10318H.setClickable(true);
                } else {
                    ShareAlbumApplicationInfoActivity.this.f10326P.setVisibility(8);
                    ShareAlbumApplicationInfoActivity.this.f10341w.setVisibility(8);
                    ShareAlbumApplicationInfoActivity.this.f10319I.setClickable(false);
                    ShareAlbumApplicationInfoActivity.this.f10318H.setClickable(false);
                }
                ShareAlbumApplicationInfoActivity.this.m13733A2();
            } else if (i10 == 1040) {
                ShareAlbumApplicationInfoActivity.this.m13732z2();
            } else if (i10 == 1009) {
                ShareAlbumApplicationInfoActivity.this.f10330T = (C11415a) message.obj;
                Album albumM68362a = ShareAlbumApplicationInfoActivity.this.f10330T.m68362a();
                ShareAlbumApplicationInfoActivity.this.m13741x2(albumM68362a, albumM68362a.getShareType().intValue() == 1);
                ShareAlbumApplicationInfoActivity.this.f10324N.setText(albumM68362a.getAlbumName());
                ShareAlbumApplicationInfoActivity.this.f10325O.setText(ShareAlbumApplicationInfoActivity.this.getString(R$string.album_create_time, C10159j.m63334j(new Date(albumM68362a.getCreatedTime().m28458c()))));
            } else if (i10 == 1007) {
                List list = (List) message.obj;
                List listM13737t2 = ShareAlbumApplicationInfoActivity.this.m13737t2();
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((C11422h) it.next()).m68436b().getKinship());
                }
                ShareAlbumApplicationInfoActivity.this.f10332V = new ViewOnClickListenerC11638c(ShareAlbumApplicationInfoActivity.this, ShareAlbumApplicationInfoActivity.this.m13738u2(listM13737t2, arrayList));
                ShareAlbumApplicationInfoActivity.this.f10332V.show();
            }
            if (message.what != 4946) {
                C12091d.m72280a0().m72361j1(ShareAlbumApplicationInfoActivity.this, message.what, ShareAlbumApplicationInfoActivity.this.m13739v2());
                return;
            }
            if (ShareAlbumApplicationInfoActivity.this.f10327Q != null) {
                ShareAlbumApplicationInfoActivity.this.f10327Q.setVisibility(8);
            }
            if (ShareAlbumApplicationInfoActivity.this.f10336r != null) {
                ShareAlbumApplicationInfoActivity.this.f10336r.setSelected(false);
            }
            C12091d.m72280a0().m72359i1(ShareAlbumApplicationInfoActivity.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z2 */
    public void m13732z2() {
        C12091d.m72280a0().m72330T(this.f10335q, this.f10333W);
        if (TextUtils.isEmpty(this.f10329S)) {
            return;
        }
        C12091d.m72280a0().m72320O(this.f10329S, this.f10333W);
    }

    /* renamed from: A2 */
    public final void m13733A2() {
        if (this.f10331U == null) {
            return;
        }
        int iM70752O = C11842p.m70753O0(this) ? C11842p.m70752O(this) : C11842p.m70758Q(this);
        int desiredWidth = (int) Layout.getDesiredWidth(this.f10326P.getText(), 0, this.f10326P.getText().length(), this.f10326P.getPaint());
        Resources resources = getResources();
        int i10 = R$dimen.cloud_space_16_dp;
        int dimensionPixelSize = iM70752O - (resources.getDimensionPixelSize(i10) * 2);
        Resources resources2 = getResources();
        int i11 = R$dimen.cloud_space_12_dp;
        int dimensionPixelSize2 = dimensionPixelSize - (resources2.getDimensionPixelSize(i11) * 2);
        if (TextUtils.equals(this.f10331U.getStatus(), "await")) {
            dimensionPixelSize2 = ((dimensionPixelSize2 - desiredWidth) - getResources().getDimensionPixelSize(i10)) - getResources().getDimensionPixelSize(i11);
        }
        this.f10315E.setMaxWidth(dimensionPixelSize2);
    }

    @Override // p486n6.ViewOnClickListenerC11638c.a
    /* renamed from: N */
    public void mo13734N(String str) {
        if (!TextUtils.equals(str, "other")) {
            String strM7193e = C1140u.m7193e(this, str);
            this.f10312B = strM7193e;
            this.f10313C = str;
            this.f10315E.setText(strM7193e);
            return;
        }
        Intent intent = new Intent(this, (Class<?>) ShareAlbumInfoTypingctivity.class);
        intent.putExtra("typing_source", 102);
        intent.putExtra("param_album_id", this.f10329S);
        intent.putExtra("param_owner_id", this.f10330T.m68362a().getAlbumOwnerId());
        intent.putExtra("param_modify_applicant", true);
        startActivityForResult(intent, 102);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10322L);
        arrayList.add(this.f10320J);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        SafeIntent safeIntent = new SafeIntent(intent);
        if (i10 == 103 && i11 == -1) {
            String stringExtra = safeIntent.getStringExtra("result");
            this.f10315E.setText(stringExtra);
            this.f10312B = stringExtra;
        } else if (i10 == 102 && i11 == -1) {
            String stringExtra2 = safeIntent.getStringExtra("result");
            this.f10315E.setText(stringExtra2);
            this.f10312B = stringExtra2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Applicant applicant;
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.album_agree_button) {
            if (this.f10330T == null) {
                return;
            }
            C11839m.m70688i("AlbumMemberManagActivity", "agree");
            String str = this.f10319I.isChecked() ? "download" : HNConstants.DataType.f22634NA;
            if (this.f10318H.isChecked()) {
                C12091d.m72280a0().m72319N0(this.f10330T.m68362a().getId(), this.f10330T.m68362a().getAlbumOwnerId(), this.f10335q, "accept", C1122c.m6769d(str, "upload"), this.f10312B, this.f10313C, this.f10333W);
            } else {
                C12091d.m72280a0().m72319N0(this.f10330T.m68362a().getId(), this.f10330T.m68362a().getAlbumOwnerId(), this.f10335q, "accept", C1122c.m6726P1(str, "upload"), this.f10312B, this.f10313C, this.f10333W);
            }
            this.f10336r.setSelected(true);
            this.f10327Q.setVisibility(0);
            this.f10338t.setClickable(false);
            return;
        }
        if (id2 == R$id.album_deny_button) {
            C11839m.m70688i("AlbumMemberManagActivity", "deny");
            new RejectApplicantConfirmDialog(this).show();
            return;
        }
        if ((id2 == R$id.tv_modify || id2 == R$id.modify_arrow) && this.f10330T != null && (applicant = this.f10331U) != null && TextUtils.equals(applicant.getStatus(), "await")) {
            if (this.f10330T.m68362a().getShareType().intValue() == 1) {
                C12091d.m72280a0().m72324Q(this.f10329S, this.f10330T.m68362a().getAlbumOwnerId(), this.f10333W);
                return;
            }
            Intent intent = new Intent(this, (Class<?>) ShareAlbumInfoTypingctivity.class);
            intent.putExtra("typing_source", 103);
            intent.putExtra("param_approval_id", this.f10335q);
            intent.putExtra("param_modify_applicant", true);
            intent.putExtra("param_applicant_remark", this.f10331U.getRemark());
            startActivityForResult(intent, 103);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m13733A2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C10343b c10343b = new C10343b(new SafeIntent(getIntent()).getExtras());
        this.f10335q = c10343b.m63694p("param_approval_id");
        this.f10329S = c10343b.m63694p("param_album_id");
        setContentView(R$layout.activity_album_approval_info);
        this.f10334p = (RecyclerView) C12809f.m76829b(this, R$id.rc_member_list);
        this.f10320J = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.top_notch_fit_layout);
        this.f10321K = (RelativeLayout) C12809f.m76829b(this, R$id.rl_loading);
        this.f10322L = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f10336r = (Button) C12809f.m76829b(this, R$id.album_agree_button);
        this.f10338t = (TextView) C12809f.m76829b(this, R$id.album_deny_button);
        this.f10337s = (Button) C12809f.m76829b(this, R$id.applicant_status);
        this.f10316F = (RelativeLayout) C12809f.m76829b(this, R$id.src_title);
        this.f10317G = (RelativeLayout) C12809f.m76829b(this, R$id.rl_src);
        this.f10314D = (ImageView) C12809f.m76829b(this, R$id.ic_head);
        this.f10342x = (TextView) C12809f.m76829b(this, R$id.tv_channel_name);
        this.f10343y = (TextView) C12809f.m76829b(this, R$id.tv_wechat_nickname);
        this.f10344z = (ImageView) C12809f.m76829b(this, R$id.ic_wechat_head);
        this.f10311A = (RelativeLayout) C12809f.m76829b(this, R$id.rl_wechat_head);
        this.f10340v = (TextView) C12809f.m76829b(this, R$id.tv_hw_id);
        this.f10339u = (TextView) C12809f.m76829b(this, R$id.tv_acount_name);
        this.f10315E = (TextView) C12809f.m76829b(this, R$id.member_remark);
        this.f10318H = (UnionSwitch) C12809f.m76829b(this, R$id.permission_switch);
        this.f10319I = (UnionSwitch) C12809f.m76829b(this, R$id.hicloud_item_switch_download);
        this.f10327Q = (HwProgressBar) C12809f.m76829b(this, R$id.agree_loading);
        this.f10328R = (HwProgressBar) C12809f.m76829b(this, R$id.reject_loading);
        this.f10341w = (ImageView) C12809f.m76829b(this, R$id.modify_arrow);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.tv_modify);
        this.f10326P = textView;
        textView.setOnClickListener(this);
        this.f10336r.setOnClickListener(new View.OnClickListener() { // from class: k6.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f52070a.onClick(view);
            }
        });
        this.f10338t.setOnClickListener(new View.OnClickListener() { // from class: k6.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f52070a.onClick(view);
            }
        });
        this.f10323M = (ImageView) C12809f.m76829b(this, R$id.ic_album_cover);
        this.f10324N = (TextView) C12809f.m76829b(this, R$id.tv_album_name);
        this.f10325O = (TextView) C12809f.m76829b(this, R$id.tv_album_create_time);
        C11839m.m70688i("AlbumMemberManagActivity", "onCreate: " + this.f10329S);
        C11839m.m70686d("AlbumMemberManagActivity", "applicationId" + this.f10335q);
        mo19005p1();
        mo19982C1();
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R$string.album_application_title);
        }
        m13732z2();
    }

    /* renamed from: r2 */
    public void m13735r2() {
        C12091d.m72280a0().m72394w(this.f10335q, this.f10333W);
        this.f10338t.setClickable(false);
        this.f10328R.setVisibility(0);
    }

    /* renamed from: s2 */
    public final void m13736s2(String str, ImageView imageView) {
        C12096i.m72418I().m72437F(str, imageView);
    }

    /* renamed from: t2 */
    public final List<String> m13737t2() {
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

    /* renamed from: u2 */
    public final List<C11418d> m13738u2(List<String> list, List<String> list2) {
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

    /* renamed from: v2 */
    public final String m13739v2() {
        Applicant applicant = this.f10331U;
        return applicant == null ? "" : (TextUtils.isEmpty(applicant.getKinship()) || TextUtils.equals(this.f10331U.getKinship(), "other")) ? this.f10312B : C1140u.m7193e(this, this.f10331U.getKinship());
    }

    /* renamed from: w2 */
    public final void m13740w2(boolean z10, String str) {
        this.f10321K.setVisibility(4);
        this.f10322L.setVisibility(0);
        this.f10328R.setVisibility(4);
        this.f10327Q.setVisibility(4);
        if (TextUtils.equals(str, "expire")) {
            this.f10336r.setVisibility(8);
            this.f10338t.setVisibility(8);
            this.f10337s.setVisibility(0);
            this.f10337s.setText(getString(R$string.album_expired));
            return;
        }
        if (TextUtils.equals(str, "await")) {
            this.f10336r.setVisibility(0);
            this.f10338t.setVisibility(0);
            this.f10337s.setVisibility(8);
        } else {
            if (TextUtils.equals(str, "accept")) {
                this.f10336r.setVisibility(8);
                this.f10338t.setVisibility(8);
                this.f10337s.setVisibility(0);
                this.f10337s.setText(getString(R$string.album_approved));
                return;
            }
            if (TextUtils.equals(str, "reject")) {
                this.f10336r.setVisibility(8);
                this.f10338t.setVisibility(8);
                this.f10337s.setVisibility(0);
                this.f10337s.setText(getString(R$string.album_rejected));
            }
        }
    }

    /* renamed from: x2 */
    public final void m13741x2(Album album, boolean z10) {
        if (z10) {
            C1140u.m7201m(this, album, this.f10323M);
        } else if (!TextUtils.isEmpty(album.getCoverImage())) {
            C12091d.m72280a0().m72396x(album, album.getCoverImage(), this.f10323M);
        } else {
            if (C12091d.m72280a0().m72400z(album, this.f10323M)) {
                return;
            }
            this.f10323M.setImageDrawable(getDrawable(R$drawable.album_default_bg));
        }
    }

    /* renamed from: y2 */
    public final void m13742y2(String str) {
        if (TextUtils.equals(str, Inviter.INVITE_CODE)) {
            this.f10316F.setVisibility(8);
            this.f10317G.setVisibility(8);
            return;
        }
        this.f10316F.setVisibility(0);
        this.f10317G.setVisibility(0);
        Map<String, String> properties = this.f10331U.getProperties();
        if (properties == null || !TextUtils.equals(properties.get("wxChatType"), "private")) {
            return;
        }
        this.f10342x.setText(getString(R$string.album_application_from_wechat_friend));
        String str2 = properties.get("wxNickname");
        String str3 = properties.get("wxHeadUri");
        if (!TextUtils.isEmpty(str2)) {
            this.f10343y.setText(str2);
            this.f10343y.setVisibility(0);
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.f10311A.setVisibility(0);
        m13736s2(str3, this.f10344z);
    }
}
