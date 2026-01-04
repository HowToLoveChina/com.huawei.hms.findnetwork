package com.huawei.android.p069cg.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import hu.C10343b;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0224k0;
import p031b7.C1120a;
import p031b7.C1122c;
import p471m6.C11415a;
import p514o9.C11839m;
import p546p6.C12091d;
import p581qk.AbstractC12367d;
import p604r7.C12469b;
import p616rk.C12515a;
import sk.C12809f;

/* loaded from: classes2.dex */
public class ShareAlbumBackGroundViewActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: p */
    public Button f10354p;

    /* renamed from: q */
    public ImageView f10355q;

    /* renamed from: r */
    public ImageView f10356r;

    /* renamed from: u */
    public String f10359u;

    /* renamed from: v */
    public C11415a f10360v;

    /* renamed from: s */
    public NotchTopFitRelativeLayout f10357s = null;

    /* renamed from: t */
    public RelativeLayout f10358t = null;

    /* renamed from: w */
    public Handler f10361w = new HandlerC2219a();

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumBackGroundViewActivity$a */
    public class HandlerC2219a extends Handler {
        public HandlerC2219a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1009) {
                ShareAlbumBackGroundViewActivity.this.f10360v = (C11415a) message.obj;
                if (C12091d.m72280a0().m72311I0(ShareAlbumBackGroundViewActivity.this.f10360v.m68362a())) {
                    C12091d.m72280a0().m72398y(ShareAlbumBackGroundViewActivity.this.f10360v.m68362a().getBackgroundImage(), ShareAlbumBackGroundViewActivity.this.f10355q);
                } else if (ShareAlbumBackGroundViewActivity.this.f10360v.m68362a().getShareType().intValue() == 1) {
                    ShareAlbumBackGroundViewActivity.this.f10355q.setImageDrawable(ShareAlbumBackGroundViewActivity.this.getDrawable(R$drawable.baby_album_bg));
                } else {
                    ShareAlbumBackGroundViewActivity.this.f10355q.setImageDrawable(ShareAlbumBackGroundViewActivity.this.getDrawable(R$drawable.normal_album_bg));
                }
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumBackGroundViewActivity$b */
    public class C2220b extends AbstractC12367d {
        public C2220b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                C12469b.m74746l().m74765u(ShareAlbumBackGroundViewActivity.this.f10360v.m68362a());
            } catch (C4616s e10) {
                C1120a.m6676e("ShareAlbumBackGroundViewActivity", "doSaveOperation HttpResponseException " + e10.getMessage());
                C12091d.m72280a0().m72309H0(ShareAlbumBackGroundViewActivity.this.f10361w, e10);
                C12091d.m72280a0().m72307G0(e10, ShareAlbumBackGroundViewActivity.this.f10361w);
                C1122c.m6682B(e10, ShareAlbumBackGroundViewActivity.this.f10361w, ShareAlbumBackGroundViewActivity.this);
            } catch (Exception e11) {
                C1120a.m6676e("ShareAlbumBackGroundViewActivity", "doSaveOperation Exception " + e11.getMessage());
            }
        }
    }

    /* renamed from: Q1 */
    private void m13750Q1() {
        C12091d.m72280a0().m72320O(this.f10359u, this.f10361w);
    }

    /* renamed from: P1 */
    public final void m13751P1() {
        C12515a.m75110o().m75175e(new C2220b(), false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10358t);
        arrayList.add(this.f10357s);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 != 105 || intent == null) {
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("param_media_id");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            this.f10360v.m68362a().setBackgroundImage(stringExtra);
            m13751P1();
            C12091d.m72280a0().m72398y(this.f10360v.m68362a().getBackgroundImage(), this.f10355q);
            onBackPressed();
        } catch (Exception e10) {
            C1120a.m6676e("ShareAlbumBackGroundViewActivity", "onActivityResult exception: " + e10.toString());
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        C11839m.m70688i("ShareAlbumBackGroundViewActivity", "onBackPressed");
        if (this.f10360v != null) {
            Intent intent = new Intent();
            intent.putExtra("param_media_id", this.f10360v.m68362a().getBackgroundImage());
            setResult(103, intent);
        }
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.background_set_button) {
            Intent intent = new Intent(this, (Class<?>) SelectCoverBackgroundActivity.class);
            intent.putExtra("param_album_id", this.f10359u);
            intent.putExtra("param_album_name", getString(R$string.album_set_background));
            intent.putExtra("select_type", "background");
            C0224k0.m1544N(this, intent, 105);
            return;
        }
        if (id2 == R$id.close_button_pic) {
            Intent intent2 = new Intent();
            intent2.putExtra("param_media_id", this.f10360v.m68362a().getBackgroundImage());
            setResult(103, intent2);
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setNavigationBarColor(getColor(R$color.black));
        getWindow().setStatusBarColor(getColor(R$color.transparent));
        getWindow().setNavigationBarContrastEnforced(false);
        this.f10359u = new C10343b(new SafeIntent(getIntent()).getExtras()).m63694p("param_album_id");
        setContentView(R$layout.activity_album_background_view);
        this.f10357s = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.top_notch_fit_layout);
        this.f10358t = (RelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f10354p = (Button) C12809f.m76829b(this, R$id.background_set_button);
        this.f10355q = (ImageView) C12809f.m76829b(this, R$id.image_background);
        this.f10356r = (ImageView) C12809f.m76829b(this, R$id.close_button_pic);
        this.f10354p.setOnClickListener(this);
        this.f10356r.setOnClickListener(this);
        C11839m.m70688i("ShareAlbumBackGroundViewActivity", "onCreate: " + this.f10359u);
        mo19005p1();
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        m13750Q1();
    }
}
