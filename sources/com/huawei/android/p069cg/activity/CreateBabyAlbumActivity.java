package com.huawei.android.p069cg.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.receiver.CreateAlbumSuccessReceiver;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.uikit.hwdatepicker.widget.HwDatePicker;
import com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import p015ak.C0209d;
import p031b7.C1120a;
import p031b7.C1130k;
import p031b7.C1140u;
import p486n6.ViewOnClickListenerC11648m;
import p514o9.C11829c;
import p546p6.C12091d;
import p664u0.C13108a;
import sk.C12809f;

/* loaded from: classes2.dex */
public class CreateBabyAlbumActivity extends UIActivity implements View.OnClickListener, TextWatcher, HwDatePickerDialog.OnButtonClickCallback {

    /* renamed from: A */
    public TextView f10015A;

    /* renamed from: B */
    public TextView f10016B;

    /* renamed from: C */
    public RelativeLayout f10017C;

    /* renamed from: D */
    public RelativeLayout f10018D;

    /* renamed from: E */
    public RelativeLayout f10019E;

    /* renamed from: F */
    public RelativeLayout f10020F;

    /* renamed from: G */
    public RelativeLayout f10021G;

    /* renamed from: H */
    public RelativeLayout f10022H;

    /* renamed from: I */
    public TextView f10023I;

    /* renamed from: J */
    public TextView f10024J;

    /* renamed from: K */
    public TextView f10025K;

    /* renamed from: L */
    public TextView f10026L;

    /* renamed from: M */
    public TextView f10027M;

    /* renamed from: N */
    public TextView f10028N;

    /* renamed from: O */
    public String f10029O;

    /* renamed from: P */
    public String f10030P;

    /* renamed from: Q */
    public String f10031Q;

    /* renamed from: R */
    public boolean f10032R = false;

    /* renamed from: S */
    public long f10033S;

    /* renamed from: T */
    public EditText f10034T;

    /* renamed from: U */
    public ImageView f10035U;

    /* renamed from: V */
    public CreateAlbumSuccessReceiver f10036V;

    /* renamed from: p */
    public NotchTopFitRelativeLayout f10037p;

    /* renamed from: q */
    public NotchFitLinearLayout f10038q;

    /* renamed from: r */
    public Button f10039r;

    /* renamed from: s */
    public LinearLayout f10040s;

    /* renamed from: t */
    public ImageView f10041t;

    /* renamed from: u */
    public TextView f10042u;

    /* renamed from: v */
    public LinearLayout f10043v;

    /* renamed from: w */
    public ImageView f10044w;

    /* renamed from: x */
    public TextView f10045x;

    /* renamed from: y */
    public LinearLayout f10046y;

    /* renamed from: z */
    public ImageView f10047z;

    /* renamed from: M1 */
    private void m13391M1() {
        mo19005p1();
        mo19982C1();
        m22365E1(R$string.creat_baby_album_new);
        this.f10036V = new CreateAlbumSuccessReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.intent.action.create.album.success");
        C13108a.m78878b(this).m78880c(this.f10036V, intentFilter);
        this.f10030P = "mother";
        m13405Z1();
        this.f10029O = "male";
        m13408c2();
        m13398S1(false, 0.5f);
    }

    /* renamed from: N1 */
    private void m13392N1() {
        this.f10037p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f10038q = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.main_all);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.llay_male_baby);
        this.f10040s = linearLayout;
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) C12809f.m76829b(this, R$id.llay_female_baby);
        this.f10043v = linearLayout2;
        linearLayout2.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) C12809f.m76829b(this, R$id.llay_unborn_baby);
        this.f10046y = linearLayout3;
        linearLayout3.setOnClickListener(this);
        this.f10041t = (ImageView) C12809f.m76829b(this, R$id.iv_type_boy);
        this.f10044w = (ImageView) C12809f.m76829b(this, R$id.iv_type_girl);
        this.f10047z = (ImageView) C12809f.m76829b(this, R$id.iv_type_unborn);
        this.f10042u = (TextView) C12809f.m76829b(this, R$id.tv_type_boy);
        this.f10045x = (TextView) C12809f.m76829b(this, R$id.tv_type_girl);
        this.f10015A = (TextView) C12809f.m76829b(this, R$id.tv_type_unborn);
        EditText editText = (EditText) C12809f.m76829b(this, R$id.et_input_name);
        this.f10034T = editText;
        editText.addTextChangedListener(this);
        this.f10034T.setFilters(new InputFilter[]{C1130k.m6918c(), C1130k.m6917b()});
        TextView textView = (TextView) C12809f.m76829b(this, R$id.tv_baby_birthday);
        this.f10016B = textView;
        textView.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_relation_mom);
        this.f10017C = relativeLayout;
        relativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_relation_dad);
        this.f10018D = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        RelativeLayout relativeLayout3 = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_relation_grandpa);
        this.f10019E = relativeLayout3;
        relativeLayout3.setOnClickListener(this);
        RelativeLayout relativeLayout4 = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_relation_grandma);
        this.f10020F = relativeLayout4;
        relativeLayout4.setOnClickListener(this);
        RelativeLayout relativeLayout5 = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_relation_grandpaa);
        this.f10021G = relativeLayout5;
        relativeLayout5.setOnClickListener(this);
        RelativeLayout relativeLayout6 = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_relation_grandmaa);
        this.f10022H = relativeLayout6;
        relativeLayout6.setOnClickListener(this);
        this.f10024J = (TextView) C12809f.m76829b(this, R$id.tv_relation_dad);
        this.f10023I = (TextView) C12809f.m76829b(this, R$id.tv_relation_mom);
        this.f10025K = (TextView) C12809f.m76829b(this, R$id.tv_relation_grandpa);
        this.f10026L = (TextView) C12809f.m76829b(this, R$id.tv_relation_grandma);
        this.f10027M = (TextView) C12809f.m76829b(this, R$id.tv_relation_grandpaa);
        this.f10028N = (TextView) C12809f.m76829b(this, R$id.tv_relation_grandmaa);
        Button button = (Button) C12809f.m76829b(this, R$id.btn_next_step);
        this.f10039r = button;
        button.setOnClickListener(this);
        ImageView imageView = (ImageView) C12809f.m76829b(this, R$id.iv_cancel_input);
        this.f10035U = imageView;
        imageView.setOnClickListener(this);
        ((TextView) C12809f.m76829b(this, R$id.tv_invite_by_code)).setOnClickListener(this);
    }

    /* renamed from: L1 */
    public final void m13393L1() {
        this.f10034T.setText("");
        this.f10035U.setVisibility(8);
        m13398S1(false, 0.5f);
    }

    /* renamed from: O1 */
    public final void m13394O1() {
        C1120a.m6675d("CreateBabyAlbumActivity", "jumpToAddBabyAvatar");
        if (!NetworkUtil.isNetworkAvailable(this)) {
            C1140u.m7197i(this);
            return;
        }
        if (C0209d.m1226Y0()) {
            C1120a.m6676e("CreateBabyAlbumActivity", "fast click");
            return;
        }
        Intent intent = new Intent(this, (Class<?>) AddBabyAvatarActivity.class);
        intent.putExtra("baby_sex_type", this.f10029O);
        intent.putExtra("baby_nickname", this.f10031Q);
        intent.putExtra("baby_birthday", this.f10033S);
        intent.putExtra("baby_relation", this.f10030P);
        startActivity(intent);
    }

    /* renamed from: P1 */
    public final void m13395P1() {
        m13399T1(false);
        m13404Y1(false);
        m13402W1(false);
        m13400U1(false);
        m13403X1(false);
        m13401V1(false);
    }

    /* renamed from: Q1 */
    public final void m13396Q1() {
        m13406a2(false);
        m13407b2(false);
        m13409d2(false);
    }

    /* renamed from: R1 */
    public final void m13397R1(Date date) {
        String str = new SimpleDateFormat(C11829c.m70590k0() ? "yyyy/MM/dd" : "dd/MM/yyyy").format(date);
        C1120a.m6675d("CreateBabyAlbumActivity", "onDateSet dateStr " + str);
        this.f10016B.setText(str);
        this.f10032R = true;
        if (TextUtils.isEmpty(this.f10031Q)) {
            m13398S1(false, 0.5f);
        } else {
            m13398S1(true, 1.0f);
        }
    }

    /* renamed from: S1 */
    public final void m13398S1(boolean z10, float f10) {
        this.f10039r.setClickable(z10);
        this.f10039r.setSelected(z10);
        this.f10039r.setAlpha(f10);
    }

    /* renamed from: T1 */
    public final void m13399T1(boolean z10) {
        this.f10018D.setSelected(z10);
        this.f10024J.setSelected(z10);
    }

    /* renamed from: U1 */
    public final void m13400U1(boolean z10) {
        this.f10020F.setSelected(z10);
        this.f10026L.setSelected(z10);
    }

    /* renamed from: V1 */
    public final void m13401V1(boolean z10) {
        this.f10022H.setSelected(z10);
        this.f10028N.setSelected(z10);
    }

    /* renamed from: W1 */
    public final void m13402W1(boolean z10) {
        this.f10019E.setSelected(z10);
        this.f10025K.setSelected(z10);
    }

    /* renamed from: X1 */
    public final void m13403X1(boolean z10) {
        this.f10021G.setSelected(z10);
        this.f10027M.setSelected(z10);
    }

    /* renamed from: Y1 */
    public final void m13404Y1(boolean z10) {
        this.f10017C.setSelected(z10);
        this.f10023I.setSelected(z10);
    }

    /* renamed from: Z1 */
    public final void m13405Z1() {
        m13395P1();
        if ("father".equals(this.f10030P)) {
            m13399T1(true);
            return;
        }
        if ("mother".equals(this.f10030P)) {
            m13404Y1(true);
            return;
        }
        if ("grandpa".equals(this.f10030P)) {
            m13402W1(true);
            return;
        }
        if ("grandma".equals(this.f10030P)) {
            m13400U1(true);
        } else if ("grandfather".equals(this.f10030P)) {
            m13403X1(true);
        } else if ("grandmother".equals(this.f10030P)) {
            m13401V1(true);
        }
    }

    /* renamed from: a2 */
    public final void m13406a2(boolean z10) {
        this.f10040s.setSelected(z10);
        this.f10041t.setSelected(z10);
        this.f10042u.setSelected(z10);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    /* renamed from: b2 */
    public final void m13407b2(boolean z10) {
        this.f10043v.setSelected(z10);
        this.f10044w.setSelected(z10);
        this.f10045x.setSelected(z10);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    /* renamed from: c2 */
    public final void m13408c2() {
        m13396Q1();
        if ("male".equals(this.f10029O)) {
            m13406a2(true);
        } else if ("female".equals(this.f10029O)) {
            m13407b2(true);
        } else if ("other".equals(this.f10029O)) {
            m13409d2(true);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10037p);
        arrayList.add(this.f10038q);
        return arrayList;
    }

    /* renamed from: d2 */
    public final void m13409d2(boolean z10) {
        this.f10046y.setSelected(z10);
        this.f10047z.setSelected(z10);
        this.f10015A.setSelected(z10);
    }

    /* renamed from: e2 */
    public final void m13410e2() {
        if (C0209d.m1226Y0()) {
            C1120a.m6676e("CreateBabyAlbumActivity", "fast click");
            return;
        }
        ViewOnClickListenerC11648m viewOnClickListenerC11648m = new ViewOnClickListenerC11648m(this);
        viewOnClickListenerC11648m.show();
        viewOnClickListenerC11648m.m69570p();
        C12091d.m72280a0().m72341Y0("action_code_click_join_share_album", "CreateBabyAlbumActivity");
    }

    /* renamed from: f2 */
    public final void m13411f2() {
        if (C0209d.m1226Y0()) {
            C1120a.m6675d("CreateBabyAlbumActivity", "showSelectDateDialog do not fast click");
            return;
        }
        HwDatePickerDialog hwDatePickerDialog = new HwDatePickerDialog(this, this);
        hwDatePickerDialog.setLunarSwitch(false);
        hwDatePickerDialog.setWestern(true);
        hwDatePickerDialog.setDialogTitle(getString(R$string.baby_brithday));
        hwDatePickerDialog.setCanceledOnTouchOutside(false);
        hwDatePickerDialog.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.btn_next_step) {
            m13394O1();
            return;
        }
        if (id2 == R$id.llay_male_baby) {
            this.f10029O = "male";
            m13408c2();
            return;
        }
        if (id2 == R$id.llay_female_baby) {
            this.f10029O = "female";
            m13408c2();
            return;
        }
        if (id2 == R$id.llay_unborn_baby) {
            this.f10029O = "other";
            m13408c2();
            return;
        }
        if (id2 == R$id.tv_baby_birthday) {
            m13411f2();
            return;
        }
        if (id2 == R$id.rlay_relation_mom) {
            this.f10030P = "mother";
            m13405Z1();
            return;
        }
        if (id2 == R$id.rlay_relation_dad) {
            this.f10030P = "father";
            m13405Z1();
            return;
        }
        if (id2 == R$id.rlay_relation_grandpa) {
            this.f10030P = "grandpa";
            m13405Z1();
            return;
        }
        if (id2 == R$id.rlay_relation_grandma) {
            this.f10030P = "grandma";
            m13405Z1();
            return;
        }
        if (id2 == R$id.rlay_relation_grandpaa) {
            this.f10030P = "grandfather";
            m13405Z1();
        } else if (id2 == R$id.rlay_relation_grandmaa) {
            this.f10030P = "grandmother";
            m13405Z1();
        } else if (id2 == R$id.tv_invite_by_code) {
            m13410e2();
        } else if (id2 == R$id.iv_cancel_input) {
            m13393L1();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.layout_create_baby_album);
        m13392N1();
        m13391M1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f10036V != null) {
            C13108a.m78878b(this).m78883f(this.f10036V);
        }
    }

    @Override // com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog.OnButtonClickCallback
    public void onNegativeButtonClick(HwDatePicker hwDatePicker) {
        C1120a.m6675d("CreateBabyAlbumActivity", "onNegativeButtonClick");
    }

    @Override // com.huawei.uikit.hwdatepicker.widget.HwDatePickerDialog.OnButtonClickCallback
    public void onPositiveButtonClick(HwDatePicker hwDatePicker) {
        if (hwDatePicker == null) {
            C1120a.m6676e("CreateBabyAlbumActivity", "hwDatePicker is null");
            return;
        }
        C1140u.m7194f(this, this.f10034T);
        Calendar calendar = Calendar.getInstance();
        calendar.set(hwDatePicker.getYear(), hwDatePicker.getMonth(), hwDatePicker.getDayOfMonth());
        String str = new SimpleDateFormat(C11829c.m70590k0() ? "yyyy/MM/dd" : "dd/MM/yyyy").format(calendar.getTime());
        this.f10033S = calendar.getTimeInMillis();
        C1120a.m6675d("CreateBabyAlbumActivity", "onDateSet dateStr " + str);
        this.f10016B.setText(str);
        this.f10032R = true;
        if (TextUtils.isEmpty(this.f10031Q)) {
            m13398S1(false, 0.5f);
        } else {
            m13398S1(true, 1.0f);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f10029O = bundle.getString("baby_sex_type");
        m13408c2();
        this.f10031Q = bundle.getString("baby_nickname");
        long j10 = bundle.getLong("baby_birthday", 0L);
        this.f10033S = j10;
        if (j10 >= 0) {
            m13397R1(new Date(this.f10033S));
        }
        this.f10030P = bundle.getString("baby_relation");
        m13405Z1();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("baby_sex_type", this.f10029O);
        bundle.putString("baby_nickname", this.f10031Q);
        bundle.putLong("baby_birthday", this.f10033S);
        bundle.putString("baby_relation", this.f10030P);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        String string = charSequence.toString();
        this.f10031Q = string;
        this.f10035U.setVisibility(TextUtils.isEmpty(string) ? 8 : 0);
        if (TextUtils.isEmpty(this.f10031Q) || !this.f10032R) {
            m13398S1(false, 0.5f);
        } else {
            m13398S1(true, 1.0f);
        }
        C1120a.m6675d("CreateBabyAlbumActivity", " mBabyName " + this.f10031Q);
    }
}
