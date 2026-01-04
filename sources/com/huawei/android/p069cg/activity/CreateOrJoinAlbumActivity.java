package com.huawei.android.p069cg.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$anim;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.receiver.CreateAlbumSuccessReceiver;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0212e0;
import p031b7.C1120a;
import p031b7.C1135p;
import p486n6.ViewOnClickListenerC11643h;
import p486n6.ViewOnClickListenerC11648m;
import p546p6.C12091d;
import p664u0.C13108a;
import p684un.C13224c;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes2.dex */
public class CreateOrJoinAlbumActivity extends UIActivity implements Animation.AnimationListener, DialogInterface.OnDismissListener {

    /* renamed from: p */
    public CreateAlbumSuccessReceiver f10048p;

    /* renamed from: q */
    public RelativeLayout f10049q;

    /* renamed from: r */
    public NotchTopFitRelativeLayout f10050r;

    /* renamed from: s */
    public NotchFitRelativeLayout f10051s;

    /* renamed from: t */
    public ViewOnClickListenerC11643h f10052t;

    /* renamed from: u */
    public ViewOnClickListenerC11648m f10053u;

    /* renamed from: R1 */
    private void m13416R1() {
        this.f10048p = new CreateAlbumSuccessReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.intent.action.create.album.success");
        C13108a.m78878b(this).m78880c(this.f10048p, intentFilter);
    }

    /* renamed from: S1 */
    private void m13417S1() throws Resources.NotFoundException {
        this.f10050r = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f10051s = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_all);
        this.f10049q = (RelativeLayout) C12809f.m76829b(this, R$id.raly_container);
        ((ImageView) C12809f.m76829b(this, R$id.iv_close_dialog)).setOnClickListener(new View.OnClickListener() { // from class: k6.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f52060a.m13418W1(view);
            }
        });
        ((RelativeLayout) C12809f.m76829b(this, R$id.rlay_non_baby_album)).setOnClickListener(new View.OnClickListener() { // from class: k6.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f52061a.m13424X1(view);
            }
        });
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_baby_album);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: k6.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f52062a.m13425Y1(view);
            }
        });
        relativeLayout.setVisibility(CloudAlbumSettings.m14363h().m14373i() ? 0 : 8);
        ((TextView) C12809f.m76829b(this, R$id.tv_join_by_invite_code)).setOnClickListener(new View.OnClickListener() { // from class: k6.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f52063a.m13426Z1(view);
            }
        });
        m13428b2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W1 */
    public /* synthetic */ void m13418W1(View view) {
        m13419P1();
    }

    /* renamed from: P1 */
    public final void m13419P1() {
        C1120a.m6675d("CreateOrJoinAlbumActivity", "dismissShareAlbumDialog");
        m13420Q1();
    }

    /* renamed from: Q1 */
    public final void m13420Q1() {
        NotchTopFitRelativeLayout notchTopFitRelativeLayout = this.f10050r;
        if (notchTopFitRelativeLayout != null) {
            notchTopFitRelativeLayout.setBackgroundColor(getColor(R$color.transparent));
        }
        finish();
        overridePendingTransition(R$anim.anim_bottom_in, R$anim.anim_bottom_out);
    }

    /* renamed from: T1 */
    public final void m13421T1() {
        C1120a.m6675d("CreateOrJoinAlbumActivity", "joinAlbumByInviteCode");
        if (C0209d.m1226Y0()) {
            return;
        }
        ViewOnClickListenerC11648m viewOnClickListenerC11648m = new ViewOnClickListenerC11648m(this);
        this.f10053u = viewOnClickListenerC11648m;
        viewOnClickListenerC11648m.show();
        this.f10053u.m69570p();
        C12091d.m72280a0().m72341Y0("action_code_click_join_share_album", "CreateOrJoinAlbumActivity");
    }

    /* renamed from: U1 */
    public final void m13422U1() {
        C1120a.m6675d("CreateOrJoinAlbumActivity", "jumpToCreateBabyAlbum");
        if (C0209d.m1226Y0()) {
            return;
        }
        m13427a2("share_album_create_baby_album");
        C1120a.m6675d("CreateOrJoinAlbumActivity", "jumpToCreateBabyAlbum isDeleteSuccess " + C1135p.m6940c(this).delete());
        C0212e0.m1365o(this, "sp_have_show_cloud_photo", "key_have_set_baby_avatar", false);
        startActivity(new Intent(this, (Class<?>) CreateBabyAlbumActivity.class));
    }

    /* renamed from: V1 */
    public final void m13423V1() {
        C1120a.m6675d("CreateOrJoinAlbumActivity", "jumpToCreateNonBabyAlbum");
        if (C0209d.m1226Y0()) {
            return;
        }
        RelativeLayout relativeLayout = this.f10049q;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        m13427a2("action_code_click_normal_album");
        ViewOnClickListenerC11643h viewOnClickListenerC11643h = new ViewOnClickListenerC11643h(this);
        this.f10052t = viewOnClickListenerC11643h;
        viewOnClickListenerC11643h.show();
        this.f10052t.m69532m();
        this.f10052t.setOnDismissListener(this);
    }

    /* renamed from: X1 */
    public final /* synthetic */ void m13424X1(View view) {
        m13423V1();
    }

    /* renamed from: Y1 */
    public final /* synthetic */ void m13425Y1(View view) {
        m13422U1();
    }

    /* renamed from: Z1 */
    public final /* synthetic */ void m13426Z1(View view) {
        m13421T1();
    }

    /* renamed from: a2 */
    public final void m13427a2(String str) {
        C1120a.m6675d("CreateOrJoinAlbumActivity", "reportCreateAlbumEvent");
        C13224c.m79487f1().m79585f0(str, C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", str, "1", "cloud_space_home_page_dialog");
    }

    /* renamed from: b2 */
    public final void m13428b2() throws Resources.NotFoundException {
        if (this.f10049q != null) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R$anim.anim_bottom_in);
            animationLoadAnimation.setAnimationListener(this);
            this.f10049q.setAnimation(animationLoadAnimation);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10050r);
        arrayList.add(this.f10051s);
        return arrayList;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        NotchTopFitRelativeLayout notchTopFitRelativeLayout = this.f10050r;
        if (notchTopFitRelativeLayout != null) {
            notchTopFitRelativeLayout.setBackgroundColor(getColor(R$color.color_33000000));
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(R$layout.layout_create_or_join_album);
        C13224c.m79487f1().m79593q0("SHOW_ALBUM_CREATE_DIALOG");
        m13417S1();
        m13416R1();
        mo19005p1();
        m22369I1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C1120a.m6675d("CreateOrJoinAlbumActivity", "onDestroy");
        super.onDestroy();
        if (this.f10048p != null) {
            C1120a.m6675d("CreateOrJoinAlbumActivity", "onDestroy unregisterReceiver");
            C13108a.m78878b(this).m78883f(this.f10048p);
        }
        ViewOnClickListenerC11643h viewOnClickListenerC11643h = this.f10052t;
        if (viewOnClickListenerC11643h != null) {
            viewOnClickListenerC11643h.dismiss();
        }
        ViewOnClickListenerC11648m viewOnClickListenerC11648m = this.f10053u;
        if (viewOnClickListenerC11648m != null) {
            viewOnClickListenerC11648m.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        RelativeLayout relativeLayout = this.f10049q;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        m13420Q1();
        return true;
    }
}
