package com.huawei.android.p069cg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.PermissionUpdateRequest;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import p015ak.C0209d;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1130k;
import p031b7.C1140u;
import p471m6.C11415a;
import p514o9.C11839m;
import p546p6.C12091d;
import p581qk.AbstractC12367d;
import p604r7.C12469b;
import p616rk.C12515a;
import sk.C12809f;

/* loaded from: classes2.dex */
public class ShareAlbumInfoTypingctivity extends UIActivity implements View.OnClickListener, TextWatcher {

    /* renamed from: A */
    public String f10498A;

    /* renamed from: B */
    public String f10499B;

    /* renamed from: C */
    public Album f10500C;

    /* renamed from: D */
    public int f10501D;

    /* renamed from: E */
    public String f10502E;

    /* renamed from: F */
    public boolean f10503F;

    /* renamed from: G */
    public String f10504G;

    /* renamed from: H */
    public String f10505H;

    /* renamed from: I */
    public String f10506I;

    /* renamed from: J */
    public String f10507J;

    /* renamed from: K */
    public Handler f10508K = new HandlerC2238a();

    /* renamed from: p */
    public NotchTopFitRelativeLayout f10509p;

    /* renamed from: q */
    public NotchFitRelativeLayout f10510q;

    /* renamed from: r */
    public TextView f10511r;

    /* renamed from: s */
    public ImageView f10512s;

    /* renamed from: t */
    public TextView f10513t;

    /* renamed from: u */
    public View f10514u;

    /* renamed from: v */
    public EditText f10515v;

    /* renamed from: w */
    public ImageView f10516w;

    /* renamed from: x */
    public TextView f10517x;

    /* renamed from: y */
    public int f10518y;

    /* renamed from: z */
    public String f10519z;

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumInfoTypingctivity$a */
    public class HandlerC2238a extends Handler {
        public HandlerC2238a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1009) {
                C11415a c11415a = (C11415a) message.obj;
                ShareAlbumInfoTypingctivity.this.f10500C = c11415a.m68362a();
            } else if (i10 == 513) {
                Intent intent = new Intent();
                intent.putExtra("update_album_name", ShareAlbumInfoTypingctivity.this.f10507J);
                ShareAlbumInfoTypingctivity.this.setResult(-1, intent);
                ShareAlbumInfoTypingctivity.this.finish();
            } else if (i10 == 1018) {
                Intent intent2 = new Intent();
                intent2.putExtra("result", ShareAlbumInfoTypingctivity.this.f10507J);
                ShareAlbumInfoTypingctivity.this.setResult(-1, intent2);
                ShareAlbumInfoTypingctivity.this.finish();
            }
            int i11 = message.what;
            if (i11 == 4956) {
                ShareAlbumInfoTypingctivity.this.m13883W1(true);
            } else if (4946 == i11) {
                C12091d.m72280a0().m72359i1(ShareAlbumInfoTypingctivity.this);
            } else {
                C12091d.m72280a0().m72361j1(ShareAlbumInfoTypingctivity.this, message.what, "");
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumInfoTypingctivity$b */
    public class C2239b extends AbstractC12367d {
        public C2239b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                ShareAlbumInfoTypingctivity.this.f10500C.setAlbumName(ShareAlbumInfoTypingctivity.this.f10507J);
                C12469b.m74746l().m74765u(ShareAlbumInfoTypingctivity.this.f10500C);
                Message messageObtain = Message.obtain();
                messageObtain.what = 513;
                ShareAlbumInfoTypingctivity.this.f10508K.sendMessage(messageObtain);
            } catch (C4616s e10) {
                C1120a.m6676e("ShareAlbumInfoEditActivity", "doSaveOperation HttpResponseException " + e10.getMessage());
                C12091d.m72280a0().m72309H0(ShareAlbumInfoTypingctivity.this.f10508K, e10);
                C12091d.m72280a0().m72307G0(e10, ShareAlbumInfoTypingctivity.this.f10508K);
                C1122c.m6682B(e10, ShareAlbumInfoTypingctivity.this.f10508K, ShareAlbumInfoTypingctivity.this);
            } catch (Exception e11) {
                C1120a.m6676e("ShareAlbumInfoEditActivity", "doSaveOperation Exception " + e11.getMessage());
            }
        }
    }

    /* renamed from: S1 */
    private void m13882S1() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f10519z = safeIntent.getStringExtra("param_album_id");
        this.f10498A = safeIntent.getStringExtra("param_owner_id");
        this.f10499B = safeIntent.getStringExtra("param_permission_user_id");
        this.f10518y = safeIntent.getIntExtra("param_album_type", -1);
        this.f10501D = safeIntent.getIntExtra("typing_source", 0);
        this.f10502E = safeIntent.getStringExtra("param_album_name");
        this.f10504G = safeIntent.getStringExtra("param_approval_id");
        this.f10505H = safeIntent.getStringExtra("param_applicant_status");
        this.f10506I = safeIntent.getStringExtra("param_applicant_remark");
        this.f10503F = safeIntent.getBooleanExtra("param_modify_applicant", false);
        C1120a.m6677i("ShareAlbumInfoEditActivity", "getIntentData albumType " + this.f10518y + " albumId " + this.f10519z);
        C12091d.m72280a0().m72320O(this.f10519z, this.f10508K);
    }

    /* renamed from: W1 */
    public void m13883W1(boolean z10) {
        this.f10514u.setBackgroundColor(getColor(z10 ? R$color.color_FB374E : R$color.color_input_underline));
        if (z10) {
            this.f10517x.setText(getString(R$string.sensitive_word));
        } else if (m13886T1()) {
            this.f10517x.setText(getString(R$string.nickname_example));
        } else {
            this.f10517x.setText(getString(R$string.normal_album_name_example));
        }
        this.f10517x.setTextColor(getColor(z10 ? R$color.color_FB374E : R$color.color_input_hint));
    }

    /* renamed from: Q1 */
    public final void m13884Q1() {
        this.f10515v.setText("");
        this.f10516w.setVisibility(8);
        m13883W1(false);
        m13887U1(0.5f, false);
        m13888V1();
    }

    /* renamed from: R1 */
    public final void m13885R1() {
        switch (this.f10501D) {
            case 101:
                m13889X1();
                break;
            case 102:
                if (!this.f10503F) {
                    PermissionUpdateRequest permissionUpdateRequest = new PermissionUpdateRequest();
                    permissionUpdateRequest.setKinship("other");
                    permissionUpdateRequest.setRemark(this.f10507J);
                    C12091d.m72280a0().m72370n1(this.f10519z, this.f10498A, this.f10499B, permissionUpdateRequest, this.f10508K);
                    break;
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("result", this.f10507J);
                    setResult(-1, intent);
                    finish();
                    break;
                }
            case 103:
                if (!this.f10503F) {
                    PermissionUpdateRequest permissionUpdateRequest2 = new PermissionUpdateRequest();
                    permissionUpdateRequest2.setRemark(this.f10507J);
                    C12091d.m72280a0().m72370n1(this.f10519z, this.f10498A, this.f10499B, permissionUpdateRequest2, this.f10508K);
                    break;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("result", this.f10507J);
                    setResult(-1, intent2);
                    finish();
                    break;
                }
        }
    }

    /* renamed from: T1 */
    public final boolean m13886T1() {
        return this.f10518y == 1;
    }

    /* renamed from: U1 */
    public final void m13887U1(float f10, boolean z10) {
        this.f10513t.setAlpha(f10);
        this.f10513t.setEnabled(z10);
        this.f10513t.setClickable(z10);
    }

    /* renamed from: V1 */
    public final void m13888V1() {
        switch (this.f10501D) {
            case 101:
                if (m13886T1()) {
                    this.f10515v.setHint(getString(R$string.baby_nickname));
                } else {
                    this.f10515v.setHint(getString(R$string.normal_album_name_hint, new SimpleDateFormat("yyyy-MMdd").format(new Date(System.currentTimeMillis())).split("-")[1]));
                }
                if (!TextUtils.isEmpty(this.f10502E)) {
                    this.f10515v.setHint(this.f10502E);
                    break;
                }
                break;
            case 102:
                this.f10511r.setText(R$string.other_relationships);
                this.f10517x.setText(R$string.other_relation_example);
                this.f10515v.setHint("");
                break;
            case 103:
                if (TextUtils.equals(this.f10498A, this.f10499B)) {
                    this.f10511r.setText(R$string.album_my_remark);
                } else {
                    this.f10511r.setText(R$string.album_member_remarks);
                }
                if (this.f10503F) {
                    this.f10511r.setText(R$string.album_member_remarks);
                }
                if (TextUtils.isEmpty(this.f10506I)) {
                    this.f10515v.setHint("");
                } else {
                    this.f10515v.setHint(this.f10506I);
                }
                this.f10517x.setText("");
                break;
        }
    }

    /* renamed from: X1 */
    public final void m13889X1() {
        C1140u.m7194f(this, this.f10515v);
        if (C0209d.m1226Y0()) {
            C1120a.m6675d("ShareAlbumInfoEditActivity", " doSaveOperation do not fast click");
        } else {
            C12515a.m75110o().m75175e(new C2239b(), false);
        }
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
        arrayList.add(this.f10510q);
        arrayList.add(this.f10509p);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.close_button) {
            super.onBackPressed();
        } else if (id2 == R$id.typing_confirm) {
            m13885R1();
        } else if (id2 == R$id.iv_cancel_input) {
            m13884Q1();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_album_info_typing);
        this.f10509p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.top_notch_fit_layout);
        this.f10510q = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f10513t = (TextView) C12809f.m76829b(this, R$id.typing_confirm);
        this.f10511r = (TextView) C12809f.m76829b(this, R$id.album_title);
        ImageView imageView = (ImageView) C12809f.m76829b(this, R$id.close_button);
        this.f10512s = imageView;
        imageView.setOnClickListener(this);
        this.f10513t.setOnClickListener(this);
        m13882S1();
        EditText editText = (EditText) C12809f.m76829b(this, R$id.et_input_name);
        this.f10515v = editText;
        editText.addTextChangedListener(this);
        this.f10515v.setFilters(new InputFilter[]{C1130k.m6918c(), C1130k.m6917b()});
        ImageView imageView2 = (ImageView) C12809f.m76829b(this, R$id.iv_cancel_input);
        this.f10516w = imageView2;
        imageView2.setOnClickListener(this);
        this.f10514u = C12809f.m76829b(this, R$id.custom_input_underline);
        this.f10517x = (TextView) C12809f.m76829b(this, R$id.tv_name_check__hint);
        m13883W1(false);
        m13887U1(0.5f, false);
        m13888V1();
        C11839m.m70688i("ShareAlbumInfoEditActivity", "onCreate");
        mo19005p1();
        m22368H1();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.f10507J = charSequence.toString();
        C1120a.m6675d("ShareAlbumInfoEditActivity", "albumName " + this.f10507J);
        this.f10516w.setVisibility(TextUtils.isEmpty(this.f10507J) ? 8 : 0);
        m13887U1(TextUtils.isEmpty(this.f10507J) ? 0.5f : 1.0f, !TextUtils.isEmpty(this.f10507J));
        if (TextUtils.isEmpty(this.f10507J)) {
            m13883W1(false);
            m13888V1();
        }
    }
}
