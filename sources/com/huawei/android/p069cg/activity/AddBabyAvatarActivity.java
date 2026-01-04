package com.huawei.android.p069cg.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.BabyInfo;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.p148ui.SafeIntent;
import com.huawei.uikit.hwprogressbar.widget.HwProgressBar;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0224k0;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1135p;
import p031b7.C1140u;
import p546p6.C12091d;
import p581qk.AbstractC12367d;
import p604r7.C12469b;
import p616rk.C12515a;
import p684un.C13224c;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes2.dex */
public class AddBabyAvatarActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: p */
    public NotchTopFitRelativeLayout f9904p;

    /* renamed from: q */
    public NotchFitRelativeLayout f9905q;

    /* renamed from: r */
    public ImageView f9906r;

    /* renamed from: s */
    public Album f9907s;

    /* renamed from: t */
    public TextView f9908t;

    /* renamed from: u */
    public TextView f9909u;

    /* renamed from: v */
    public TextView f9910v;

    /* renamed from: w */
    public HwProgressBar f9911w;

    /* renamed from: x */
    public RelativeLayout f9912x;

    /* renamed from: y */
    public final Handler f9913y = new HandlerC2170a();

    /* renamed from: com.huawei.android.cg.activity.AddBabyAvatarActivity$a */
    public class HandlerC2170a extends Handler {
        public HandlerC2170a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1014) {
                AddBabyAvatarActivity.this.m13285R1();
                C12091d.m72280a0().m72321O0(AddBabyAvatarActivity.this);
                C0212e0.m1365o(AddBabyAvatarActivity.this, "sp_have_show_cloud_photo", "key_have_set_baby_avatar", false);
                Album album = (Album) message.obj;
                Intent intent = new Intent(AddBabyAvatarActivity.this, (Class<?>) ShareAlbumHomePageActivity.class);
                intent.putExtra("param_album_id", album.getId());
                intent.putExtra("param_album_type", album.getShareType());
                C0224k0.m1542L(AddBabyAvatarActivity.this, intent);
                AddBabyAvatarActivity.this.finish();
            }
            if (message.what == 1016) {
                C4616s c4616s = (C4616s) message.obj;
                if (c4616s != null) {
                    C12091d.m72280a0().m72307G0(c4616s, this);
                }
                AddBabyAvatarActivity.this.m13287T1();
            }
            if (message.what == 1015) {
                AddBabyAvatarActivity.this.m13287T1();
            }
            C12091d.m72280a0().m72361j1(AddBabyAvatarActivity.this, message.what, "");
        }
    }

    /* renamed from: com.huawei.android.cg.activity.AddBabyAvatarActivity$b */
    public static class C2171b extends AbstractC12367d {

        /* renamed from: a */
        public Handler f9915a;

        /* renamed from: b */
        public Album f9916b;

        /* renamed from: c */
        public AddBabyAvatarActivity f9917c;

        public C2171b(Handler handler, Album album, AddBabyAvatarActivity addBabyAvatarActivity) {
            this.f9915a = handler;
            this.f9916b = album;
            this.f9917c = addBabyAvatarActivity;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                Album albumM74750d = C12469b.m74746l().m74750d(this.f9916b);
                if (albumM74750d != null) {
                    C1120a.m6677i("AddBabyAvatarActivity", "CreateShareAlbumTask " + albumM74750d.getId());
                    Message messageObtain = Message.obtain();
                    messageObtain.obj = albumM74750d;
                    messageObtain.what = FamilyShareConstants.StatusCode.SHARE_UNUSED_SPACE_NOT_ENOUGH;
                    this.f9915a.sendMessage(messageObtain);
                }
            } catch (C4616s e10) {
                C1120a.m6676e("AddBabyAvatarActivity", "CreateShareAlbumTask HttpResponseException " + e10.getMessage());
                C1122c.m6682B(e10, this.f9915a, this.f9917c);
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED;
                messageObtain2.obj = e10;
                this.f9915a.sendMessage(messageObtain2);
            } catch (Exception e11) {
                C1120a.m6676e("AddBabyAvatarActivity", "CreateShareAlbumTask Exception " + e11.getMessage());
                Message messageObtain3 = Message.obtain();
                messageObtain3.what = FamilyShareConstants.StatusCode.USER_HAS_JOINED_SHARE_SPACE;
                this.f9915a.sendMessage(messageObtain3);
            }
        }
    }

    /* renamed from: P1 */
    private void m13281P1() {
        this.f9904p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f9905q = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_all);
        ((RelativeLayout) C12809f.m76829b(this, R$id.rlay_click_set_avatar)).setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.layout_finish);
        this.f9912x = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.f9906r = (ImageView) C12809f.m76829b(this, R$id.iv_baby_avatar);
        this.f9908t = (TextView) C12809f.m76829b(this, R$id.tv_sub_title);
        this.f9909u = (TextView) C12809f.m76829b(this, R$id.tv_touch_change_avatar);
        this.f9910v = (TextView) C12809f.m76829b(this, R$id.tv_finish);
        this.f9911w = (HwProgressBar) C12809f.m76829b(this, R$id.hpb_loading);
    }

    /* renamed from: N1 */
    public final void m13282N1() {
        this.f9907s = new Album();
        SafeIntent safeIntent = new SafeIntent(getIntent());
        long longExtra = safeIntent.getLongExtra("baby_birthday", System.currentTimeMillis());
        String stringExtra = safeIntent.getStringExtra("baby_nickname");
        String stringExtra2 = safeIntent.getStringExtra("baby_sex_type");
        String stringExtra3 = safeIntent.getStringExtra("baby_relation");
        BabyInfo babyInfo = new BabyInfo();
        babyInfo.setBirthday(new C4644l(longExtra));
        babyInfo.setSex(stringExtra2);
        babyInfo.setRemark(stringExtra);
        this.f9907s.setBabyInfo(babyInfo);
        this.f9907s.setAlbumName(stringExtra);
        this.f9907s.setKinship(stringExtra3);
        this.f9907s.setCreatedTime(new C4644l(System.currentTimeMillis()));
        this.f9907s.setShareType(1);
        this.f9908t.setText(getString(R$string.add_baby_avatar_subtitle, stringExtra));
        this.f9909u.setText(getString(R$string.click_set_avatar));
        m13288U1();
    }

    /* renamed from: O1 */
    public final void m13283O1() {
        C1135p.m6939b(this, 273);
    }

    /* renamed from: Q1 */
    public final void m13284Q1() {
        C1120a.m6675d("AddBabyAvatarActivity", "jumpToAlbumActivity");
        if (!NetworkUtil.isNetworkAvailable(this)) {
            C1140u.m7197i(this);
            return;
        }
        this.f9911w.setVisibility(0);
        this.f9910v.setVisibility(8);
        this.f9912x.setAlpha(0.5f);
        this.f9912x.setEnabled(false);
        this.f9912x.setClickable(false);
        C12515a.m75110o().m75175e(new C2171b(this.f9913y, this.f9907s, this), false);
    }

    /* renamed from: R1 */
    public final void m13285R1() {
        C1120a.m6675d("AddBabyAvatarActivity", "reportCreateBabyAlbumSuccess");
        C13224c.m79487f1().m79585f0("action_code_create_baby_success", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "action_code_create_baby_success", "1", "AddBabyAvatarActivity");
    }

    /* renamed from: S1 */
    public final void m13286S1() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle("");
        }
    }

    /* renamed from: T1 */
    public final void m13287T1() {
        this.f9910v.setVisibility(0);
        this.f9911w.setVisibility(8);
        this.f9912x.setAlpha(1.0f);
        this.f9912x.setEnabled(true);
        this.f9912x.setClickable(true);
    }

    /* renamed from: U1 */
    public final void m13288U1() {
        boolean zM1354d = C0212e0.m1354d(this, "sp_have_show_cloud_photo", "key_have_set_baby_avatar", false);
        C1120a.m6675d("AddBabyAvatarActivity", "setSelectedAvatar haveSetAvatar " + zM1354d);
        if (zM1354d) {
            C1135p.m6942e(this, this.f9906r, 71.0f);
            this.f9907s.setHeadPicPath(C1135p.m6940c(this));
            this.f9909u.setText(getString(R$string.click_modify_avatar));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f9904p);
        arrayList.add(this.f9905q);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        C1120a.m6677i("AddBabyAvatarActivity", "requestCode " + i10);
        if (intent == null) {
            C1120a.m6678w("AddBabyAvatarActivity", "intent is null.");
            return;
        }
        if (i11 == -1) {
            try {
                if (i10 == 273) {
                    C1135p.m6938a(intent.getData(), this, 107);
                } else {
                    if (i10 != 107) {
                        return;
                    }
                    C1120a.m6675d("AddBabyAvatarActivity", "uri: " + intent.getData());
                    C0212e0.m1365o(this, "sp_have_show_cloud_photo", "key_have_set_baby_avatar", true);
                    m13288U1();
                }
            } catch (Exception e10) {
                C1120a.m6676e("AddBabyAvatarActivity", "onActivityResult exception: " + e10.toString());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C1120a.m6676e("AddBabyAvatarActivity", "do not fast click");
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.rlay_click_set_avatar) {
            m13283O1();
        } else if (id2 == R$id.layout_finish) {
            m13284Q1();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.layout_add_baby_avatar);
        m13281P1();
        mo19005p1();
        mo19982C1();
        m13282N1();
        m13286S1();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        m13288U1();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }
}
