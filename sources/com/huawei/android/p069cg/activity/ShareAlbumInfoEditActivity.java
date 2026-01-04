package com.huawei.android.p069cg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.BabyInfo;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hms.p148ui.SafeIntent;
import com.huawei.uikit.hwdatepicker.widget.HwDatePicker;
import com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0224k0;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1140u;
import p471m6.C11415a;
import p486n6.ViewOnClickListenerC11639d;
import p514o9.C11829c;
import p546p6.C12091d;
import p581qk.AbstractC12367d;
import p604r7.C12469b;
import p616rk.C12515a;
import p664u0.C13108a;
import sk.C12809f;

/* loaded from: classes2.dex */
public class ShareAlbumInfoEditActivity extends UIActivity implements View.OnClickListener, HwDatePickerDialog.OnButtonClickCallback, ViewOnClickListenerC11639d.b {

    /* renamed from: A */
    public LinearLayout f10472A;

    /* renamed from: B */
    public ImageView f10473B;

    /* renamed from: C */
    public ImageView f10474C;

    /* renamed from: D */
    public String f10475D;

    /* renamed from: E */
    public int f10476E;

    /* renamed from: F */
    public View f10477F;

    /* renamed from: G */
    public View f10478G;

    /* renamed from: H */
    public ImageView f10479H;

    /* renamed from: I */
    public TextView f10480I;

    /* renamed from: J */
    public Album f10481J;

    /* renamed from: K */
    public BabyInfo f10482K;

    /* renamed from: L */
    public TextView f10483L;

    /* renamed from: r */
    public TextView f10487r;

    /* renamed from: s */
    public TextView f10488s;

    /* renamed from: t */
    public TextView f10489t;

    /* renamed from: u */
    public TextView f10490u;

    /* renamed from: v */
    public TextView f10491v;

    /* renamed from: w */
    public RelativeLayout f10492w;

    /* renamed from: x */
    public LinearLayout f10493x;

    /* renamed from: y */
    public LinearLayout f10494y;

    /* renamed from: z */
    public LinearLayout f10495z;

    /* renamed from: p */
    public NotchTopFitRelativeLayout f10485p = null;

    /* renamed from: q */
    public NotchFitRelativeLayout f10486q = null;

    /* renamed from: M */
    public Handler f10484M = new HandlerC2236a();

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumInfoEditActivity$a */
    public class HandlerC2236a extends Handler {
        public HandlerC2236a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1009) {
                ShareAlbumInfoEditActivity.this.m13871S1(((C11415a) message.obj).m68362a());
            } else if (4946 == i10) {
                C12091d.m72280a0().m72359i1(ShareAlbumInfoEditActivity.this);
            } else {
                C12091d.m72280a0().m72361j1(ShareAlbumInfoEditActivity.this, message.what, "");
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumInfoEditActivity$b */
    public class C2237b extends AbstractC12367d {
        public C2237b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C1120a.m6677i("ShareAlbumInfoEditActivity", "doSaveOperation call");
            try {
                C12469b.m74746l().m74765u(ShareAlbumInfoEditActivity.this.f10481J);
                Intent intent = new Intent("album_background_change_action");
                intent.putExtra("param_album_id", ShareAlbumInfoEditActivity.this.f10475D);
                C13108a.m78878b(ShareAlbumInfoEditActivity.this).m78881d(intent);
            } catch (C4616s e10) {
                C1120a.m6676e("ShareAlbumInfoEditActivity", "doSaveOperation HttpResponseException " + e10.getMessage());
                C12091d.m72280a0().m72309H0(ShareAlbumInfoEditActivity.this.f10484M, e10);
                C12091d.m72280a0().m72307G0(e10, ShareAlbumInfoEditActivity.this.f10484M);
                C1122c.m6682B(e10, ShareAlbumInfoEditActivity.this.f10484M, ShareAlbumInfoEditActivity.this);
            } catch (Exception e11) {
                C1120a.m6676e("ShareAlbumInfoEditActivity", "doSaveOperation Exception " + e11.getMessage());
            }
        }
    }

    /* renamed from: P1 */
    private void m13867P1() {
        C12515a.m75110o().m75175e(new C2237b(), false);
    }

    /* renamed from: Q1 */
    private void m13868Q1() {
        this.f10475D = new SafeIntent(getIntent()).getStringExtra("param_album_id");
        C12091d.m72280a0().m72320O(this.f10475D, this.f10484M);
    }

    @Override // p486n6.ViewOnClickListenerC11639d.b
    /* renamed from: D */
    public void mo13869D(int i10) {
        if (i10 == 0) {
            this.f10489t.setText(R$string.baby_boy);
            this.f10482K.setSex("male");
            this.f10481J.setBabyInfo(this.f10482K);
            m13867P1();
            return;
        }
        if (i10 == 1) {
            this.f10489t.setText(R$string.baby_girl);
            this.f10482K.setSex("female");
            this.f10481J.setBabyInfo(this.f10482K);
            m13867P1();
            return;
        }
        if (i10 != 2) {
            return;
        }
        this.f10489t.setText(R$string.baby_unborn);
        this.f10482K.setSex("other");
        this.f10481J.setBabyInfo(this.f10482K);
        m13867P1();
    }

    /* renamed from: R1 */
    public final void m13870R1(int i10) {
        this.f10494y.setVisibility(i10);
        this.f10495z.setVisibility(i10);
        this.f10477F.setVisibility(i10);
        this.f10478G.setVisibility(i10);
    }

    /* renamed from: S1 */
    public final void m13871S1(Album album) {
        if (album == null) {
            C1120a.m6676e("ShareAlbumInfoEditActivity", "album is null");
            return;
        }
        this.f10481J = album;
        this.f10482K = album.getBabyInfo();
        this.f10491v.setText(album.getAlbumName());
        String backgroundImage = album.getBackgroundImage();
        C1120a.m6675d("ShareAlbumInfoEditActivity", "showAlbumInfo bgPath " + backgroundImage);
        if (!TextUtils.isEmpty(backgroundImage)) {
            C12091d.m72280a0().m72398y(backgroundImage, this.f10479H);
        }
        int iIntValue = album.getShareType().intValue();
        this.f10476E = iIntValue;
        if (iIntValue == 1) {
            this.f10480I.setText(getString(R$string.album_baby_head));
            m13870R1(0);
            this.f10473B.setVisibility(8);
            this.f10474C.setVisibility(0);
            BabyInfo babyInfo = album.getBabyInfo();
            if (babyInfo != null) {
                C1120a.m6675d("ShareAlbumInfoEditActivity", "birthday " + babyInfo.getBirthday().toString() + " sex " + babyInfo.getSex());
                this.f10487r.setText(m13874V1(new Date(babyInfo.getBirthday().m28458c())));
                this.f10489t.setText(m13875W1(babyInfo.getSex()));
            }
            TextView textView = this.f10483L;
            if (textView != null) {
                textView.setText(getString(R$string.hicloud_share_album_invite_avater_tip));
            }
        } else {
            this.f10473B.setVisibility(0);
            this.f10474C.setVisibility(8);
            this.f10477F.setVisibility(8);
            TextView textView2 = this.f10483L;
            if (textView2 != null) {
                textView2.setText(getString(R$string.hicloud_share_album_invite_cover_tip));
            }
        }
        String coverImage = album.getCoverImage();
        if (this.f10481J.getShareType().intValue() == 1) {
            C1140u.m7201m(this, album, this.f10474C);
        } else {
            C1140u.m7204p(this, album, this.f10473B);
        }
        C1120a.m6675d("ShareAlbumInfoEditActivity", "showAlbumInfo baby avatar " + coverImage);
        if (C12091d.m72280a0().m72311I0(this.f10481J)) {
            C12091d.m72280a0().m72398y(this.f10481J.getBackgroundImage(), this.f10479H);
        } else if (this.f10481J.getShareType().intValue() == 1) {
            this.f10479H.setImageDrawable(getDrawable(R$drawable.baby_album_bg));
        } else {
            this.f10479H.setImageDrawable(getDrawable(R$drawable.normal_album_bg));
        }
    }

    /* renamed from: T1 */
    public final void m13872T1() {
        HwDatePickerDialog hwDatePickerDialog = new HwDatePickerDialog(this, this);
        hwDatePickerDialog.setLunarSwitch(false);
        hwDatePickerDialog.setWestern(true);
        hwDatePickerDialog.setDialogTitle(getString(R$string.baby_brithday));
        hwDatePickerDialog.setCanceledOnTouchOutside(false);
        hwDatePickerDialog.show();
    }

    /* renamed from: U1 */
    public final void m13873U1() {
        new ViewOnClickListenerC11639d(this, this, 3).show();
    }

    /* renamed from: V1 */
    public final String m13874V1(Date date) {
        return new SimpleDateFormat(C11829c.m70590k0() ? "yyyy/MM/dd" : "dd/MM/yyyy").format(date);
    }

    /* renamed from: W1 */
    public final String m13875W1(String str) {
        return "male".equals(str) ? getString(R$string.baby_boy) : "female".equals(str) ? getString(R$string.baby_girl) : "other".equals(str) ? getString(R$string.baby_unborn) : "";
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10486q);
        arrayList.add(this.f10485p);
        return arrayList;
    }

    @Override // p486n6.ViewOnClickListenerC11639d.b
    /* renamed from: h0 */
    public void mo13876h0() {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        C1120a.m6677i("ShareAlbumInfoEditActivity", "onActivityResult requestCode：" + i10 + "resultCode:" + i11);
        super.onActivityResult(i10, i11, intent);
        try {
            if (i10 == 101 && i11 == -1) {
                String stringExtra = intent.getStringExtra("update_album_name");
                this.f10491v.setText(stringExtra);
                this.f10481J.setAlbumName(stringExtra);
            } else if (i10 == 104) {
                if (intent == null) {
                    return;
                }
                String stringExtra2 = intent.getStringExtra("param_media_id");
                if (!TextUtils.isEmpty(stringExtra2)) {
                    C1120a.m6675d("ShareAlbumInfoEditActivity", "onActivityResult setCoverImage: " + stringExtra2);
                    this.f10481J.setCoverImage(stringExtra2);
                    m13867P1();
                    m13871S1(this.f10481J);
                }
            } else {
                if (i10 != 105 || intent == null) {
                    return;
                }
                String stringExtra3 = intent.getStringExtra("param_media_id");
                if (!TextUtils.isEmpty(stringExtra3)) {
                    C1120a.m6675d("ShareAlbumInfoEditActivity", "onActivityResult setBackgroundImage: " + stringExtra3);
                    this.f10481J.setBackgroundImage(stringExtra3);
                    m13871S1(this.f10481J);
                    m13867P1();
                }
            }
        } catch (Exception e10) {
            C1120a.m6676e("ShareAlbumInfoEditActivity", "onActivityResult exception: " + e10.toString());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (C1140u.m7195g(this)) {
            return;
        }
        if (C0209d.m1226Y0()) {
            C1120a.m6678w("ShareAlbumInfoEditActivity", "do not fast click");
            return;
        }
        if (id2 == R$id.ll_sexes) {
            m13873U1();
            return;
        }
        if (id2 == R$id.ll_name) {
            Intent intent = new Intent(this, (Class<?>) ShareAlbumInfoTypingctivity.class);
            intent.putExtra("param_album_type", this.f10476E);
            intent.putExtra("param_album_id", this.f10475D);
            intent.putExtra("typing_source", 101);
            TextView textView = this.f10491v;
            if (textView != null) {
                intent.putExtra("param_album_name", textView.getText());
            }
            startActivityForResult(intent, 101);
            return;
        }
        if (id2 != R$id.ll_head) {
            if (id2 == R$id.ll_birthday) {
                m13872T1();
                return;
            }
            if (id2 == R$id.album_background_frm) {
                Intent intent2 = new Intent(this, (Class<?>) ShareAlbumBackGroundViewActivity.class);
                Album album = this.f10481J;
                if (album != null && album.containsKey("id")) {
                    intent2.putExtra("param_album_id", this.f10481J.getId());
                }
                C0224k0.m1544N(this, intent2, 105);
                return;
            }
            return;
        }
        Intent intent3 = new Intent(this, (Class<?>) SelectCoverBackgroundActivity.class);
        Album album2 = this.f10481J;
        if (album2 != null && album2.containsKey("id")) {
            intent3.putExtra("param_album_id", this.f10481J.getId());
        }
        Album album3 = this.f10481J;
        if (album3 != null && album3.containsKey("shareType")) {
            intent3.putExtra("param_album_type", this.f10481J.getShareType());
        }
        Album album4 = this.f10481J;
        if (album4 != null) {
            if (1 == album4.getShareType().intValue()) {
                intent3.putExtra("param_album_name", getString(R$string.title_custom_baby_avatar));
                intent3.putExtra("select_type", "child_cover");
            } else {
                intent3.putExtra("param_album_name", getString(R$string.title_custom_album_cover));
                intent3.putExtra("select_type", "share_cover");
            }
        }
        C0224k0.m1544N(this, intent3, 104);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_album_info_edit);
        this.f10485p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.top_notch_fit_layout);
        this.f10486q = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f10490u = (TextView) C12809f.m76829b(this, R$id.tv_album_name);
        this.f10488s = (TextView) C12809f.m76829b(this, R$id.tv_sexes);
        this.f10491v = (TextView) C12809f.m76829b(this, R$id.tv_album_name_value);
        this.f10489t = (TextView) C12809f.m76829b(this, R$id.tv_sexes_values);
        this.f10487r = (TextView) C12809f.m76829b(this, R$id.tv_birthday_value);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.ll_name);
        this.f10492w = relativeLayout;
        relativeLayout.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.ll_head);
        this.f10493x = linearLayout;
        linearLayout.setOnClickListener(this);
        this.f10473B = (ImageView) C12809f.m76829b(this, R$id.ic_album_cover);
        this.f10474C = (ImageView) C12809f.m76829b(this, R$id.ic_baby_cover);
        this.f10488s.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) C12809f.m76829b(this, R$id.ll_birthday);
        this.f10494y = linearLayout2;
        linearLayout2.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) C12809f.m76829b(this, R$id.ll_sexes);
        this.f10495z = linearLayout3;
        linearLayout3.setOnClickListener(this);
        LinearLayout linearLayout4 = (LinearLayout) C12809f.m76829b(this, R$id.album_background_frm);
        this.f10472A = linearLayout4;
        linearLayout4.setOnClickListener(this);
        this.f10477F = C12809f.m76829b(this, R$id.underline_above_birthday);
        this.f10478G = C12809f.m76829b(this, R$id.underline_above_sex);
        this.f10479H = (ImageView) C12809f.m76829b(this, R$id.ic_album_background);
        this.f10480I = (TextView) C12809f.m76829b(this, R$id.tv_head);
        this.f10483L = (TextView) C12809f.m76829b(this, R$id.edit_info_tv_invite_tip);
        mo19005p1();
        getActionBar().setTitle(R$string.album_edit);
        mo19982C1();
        m13868Q1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyDown(i10, keyEvent);
        }
        C1120a.m6677i("ShareAlbumInfoEditActivity", "onBack Pressed");
        setResult(101);
        finish();
        return mo13429v1(i10, keyEvent);
    }

    @Override // com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog.OnButtonClickCallback
    public void onNegativeButtonClick(HwDatePicker hwDatePicker) {
        C1120a.m6676e("ShareAlbumInfoEditActivity", "ShareAlbumInfoEditActivity onNegativeButtonClick");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            setResult(101);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog.OnButtonClickCallback
    public void onPositiveButtonClick(HwDatePicker hwDatePicker) {
        if (hwDatePicker == null) {
            C1120a.m6676e("ShareAlbumInfoEditActivity", "hwDatePicker is null");
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(hwDatePicker.getYear(), hwDatePicker.getMonth(), hwDatePicker.getDayOfMonth());
        String strM13874V1 = m13874V1(calendar.getTime());
        C1120a.m6675d("ShareAlbumInfoEditActivity", "onDateSet dateStr " + strM13874V1);
        this.f10487r.setText(strM13874V1);
        this.f10482K.setBirthday(new C4644l(calendar.getTime()));
        this.f10481J.setBabyInfo(this.f10482K);
        m13867P1();
    }
}
