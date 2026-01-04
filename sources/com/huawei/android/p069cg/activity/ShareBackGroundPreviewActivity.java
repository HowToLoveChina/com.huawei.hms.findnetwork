package com.huawei.android.p069cg.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiextend.CustomRoundImageView;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p031b7.C1120a;
import p514o9.C11839m;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes2.dex */
public class ShareBackGroundPreviewActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: p */
    public NotchTopFitRelativeLayout f10616p = null;

    /* renamed from: q */
    public RelativeLayout f10617q = null;

    /* renamed from: r */
    public TextView f10618r;

    /* renamed from: s */
    public String f10619s;

    /* renamed from: t */
    public String f10620t;

    /* renamed from: u */
    public ImageView f10621u;

    /* renamed from: v */
    public CustomRoundImageView f10622v;

    /* renamed from: w */
    public CustomRoundImageView f10623w;

    /* renamed from: x */
    public SafeIntent f10624x;

    /* renamed from: L1 */
    private void m13956L1() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f10624x = safeIntent;
        this.f10619s = safeIntent.getStringExtra("param_media_id");
        String stringExtra = this.f10624x.getStringExtra("param_album_name");
        this.f10620t = this.f10624x.getStringExtra("select_type");
        String stringExtra2 = this.f10624x.getStringExtra("image_path");
        this.f10618r.setText(stringExtra);
        C1120a.m6675d("ShareAlbumBackGroundViewActivity", "initData filePath: " + stringExtra2);
        if (TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        if ("background".equals(this.f10620t)) {
            this.f10621u.setVisibility(0);
            this.f10622v.setVisibility(4);
            this.f10623w.setVisibility(4);
            this.f10621u.setImageBitmap(C0209d.m1311u(stringExtra2));
            return;
        }
        if ("share_cover".equals(this.f10620t)) {
            this.f10621u.setVisibility(4);
            this.f10622v.setVisibility(4);
            this.f10623w.setVisibility(0);
            this.f10623w.setImageBitmap(C0209d.m1311u(stringExtra2));
            return;
        }
        if ("child_cover".equals(this.f10620t)) {
            this.f10621u.setVisibility(4);
            this.f10622v.setVisibility(0);
            this.f10623w.setVisibility(4);
            this.f10622v.setImageBitmap(C0209d.m1311u(stringExtra2));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10617q);
        arrayList.add(this.f10616p);
        return arrayList;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        C11839m.m70688i("ShareAlbumBackGroundViewActivity", "onBackPressed");
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.close_button_pic) {
            finish();
        } else if (id2 == R$id.confirm_button_pic) {
            setResult(103, this.f10624x);
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(9);
        super.onCreate(bundle);
        Window window = getWindow();
        int i10 = R$color.transparent;
        window.setNavigationBarColor(getColor(i10));
        getWindow().setStatusBarColor(getColor(i10));
        getWindow().setNavigationBarContrastEnforced(false);
        getWindow().getDecorView().setSystemUiVisibility(1792);
        setContentView(R$layout.activity_album_background_preview);
        this.f10616p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.top_notch_fit_layout);
        this.f10617q = (RelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        ((ImageView) C12809f.m76829b(this, R$id.close_button_pic)).setOnClickListener(this);
        ((ImageView) C12809f.m76829b(this, R$id.confirm_button_pic)).setOnClickListener(this);
        this.f10618r = (TextView) C12809f.m76829b(this, R$id.action_bar_title);
        this.f10621u = (ImageView) C12809f.m76829b(this, R$id.iv_background);
        this.f10622v = (CustomRoundImageView) C12809f.m76829b(this, R$id.civ_child_head_pic);
        CustomRoundImageView customRoundImageView = (CustomRoundImageView) C12809f.m76829b(this, R$id.civ_share_head_pic);
        this.f10623w = customRoundImageView;
        ViewGroup.LayoutParams layoutParams = customRoundImageView.getLayoutParams();
        int iM70758Q = C11842p.m70758Q(this);
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = iM70758Q;
            layoutParams2.height = iM70758Q;
            this.f10623w.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.f10622v.getLayoutParams();
        if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            layoutParams4.width = iM70758Q;
            layoutParams4.height = iM70758Q;
            this.f10622v.setCornerRadius(iM70758Q / 2);
            this.f10622v.setLayoutParams(layoutParams4);
        }
        mo19005p1();
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        m13956L1();
    }
}
