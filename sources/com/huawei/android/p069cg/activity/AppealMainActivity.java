package com.huawei.android.p069cg.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aq.C1011a;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$plurals;
import com.huawei.android.p069cg.R$string;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.p148ui.SafeIntent;
import fk.C9721b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0224k0;
import p031b7.C1120a;
import p031b7.C1130k;
import p031b7.C1140u;
import p514o9.C11841o;
import p546p6.C12091d;
import p581qk.AbstractC12367d;
import p604r7.C12469b;
import p616rk.C12515a;
import p684un.C13224c;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes2.dex */
public class AppealMainActivity extends UIActivity implements View.OnClickListener, TextWatcher {

    /* renamed from: p */
    public NotchTopFitRelativeLayout f9987p;

    /* renamed from: q */
    public NotchFitLinearLayout f9988q;

    /* renamed from: r */
    public EditText f9989r;

    /* renamed from: s */
    public TextView f9990s;

    /* renamed from: t */
    public Button f9991t;

    /* renamed from: u */
    public String f9992u;

    /* renamed from: v */
    public String f9993v;

    /* renamed from: w */
    public String f9994w;

    /* renamed from: x */
    public String f9995x;

    /* renamed from: y */
    public Handler f9996y = new HandlerC2180c();

    /* renamed from: com.huawei.android.cg.activity.AppealMainActivity$a */
    public class C2178a extends AbstractC12367d {
        public C2178a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                C12469b.m74746l().m74763s(AppealMainActivity.this.f9994w, null, AppealMainActivity.this.f9995x, AppealMainActivity.this.f9989r.getText().toString());
                Message messageObtain = Message.obtain();
                messageObtain.what = 1009;
                AppealMainActivity.this.f9996y.sendMessage(messageObtain);
            } catch (C4616s e10) {
                C1120a.m6676e("AppealMainActivity", "doFileAppeal HttpResponseException  " + e10.getMessage());
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = FamilyShareConstants.StatusCode.FAMILY_SHARE_NOT_OPEN;
                messageObtain2.obj = e10;
                AppealMainActivity.this.f9996y.sendMessage(messageObtain2);
            } catch (Exception e11) {
                C1120a.m6676e("AppealMainActivity", "doFileAppeal Exception " + e11.getMessage());
                Message messageObtain3 = Message.obtain();
                messageObtain3.what = FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED;
                AppealMainActivity.this.f9996y.sendMessage(messageObtain3);
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.AppealMainActivity$b */
    public class C2179b extends AbstractC12367d {
        public C2179b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                C12469b.m74746l().m74764t(AppealMainActivity.this.f9989r.getText().toString());
                Message messageObtain = Message.obtain();
                messageObtain.what = 1009;
                AppealMainActivity.this.f9996y.sendMessage(messageObtain);
            } catch (C4616s e10) {
                C1120a.m6676e("AppealMainActivity", "doAccountAppeal HttpResponseException  " + e10.getMessage());
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = FamilyShareConstants.StatusCode.FAMILY_SHARE_NOT_OPEN;
                messageObtain2.obj = e10;
                AppealMainActivity.this.f9996y.sendMessage(messageObtain2);
            } catch (Exception e11) {
                C1120a.m6676e("AppealMainActivity", "doAccountAppeal Exception " + e11.getMessage());
                Message messageObtain3 = Message.obtain();
                messageObtain3.what = FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED;
                AppealMainActivity.this.f9996y.sendMessage(messageObtain3);
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.AppealMainActivity$c */
    public class HandlerC2180c extends Handler {
        public HandlerC2180c() {
        }

        @Override // android.os.Handler
        @SuppressLint({"HandlerLeak"})
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1009) {
                AppealMainActivity appealMainActivity = AppealMainActivity.this;
                C11841o.m70706b(appealMainActivity, appealMainActivity.getString(R$string.appeal_have_submit), 0);
                AppealMainActivity.this.finish();
            } else {
                if (i10 != 1010) {
                    if (i10 == 1011) {
                        AppealMainActivity.this.m13370U1();
                        return;
                    } else {
                        C12091d.m72280a0().m72361j1(AppealMainActivity.this, message.what, "");
                        return;
                    }
                }
                AppealMainActivity.this.m13370U1();
                C4616s c4616s = (C4616s) message.obj;
                if (c4616s != null) {
                    C12091d.m72280a0().m72307G0(c4616s, this);
                }
            }
        }
    }

    /* renamed from: W1 */
    private void m13364W1() {
        mo19005p1();
        mo19982C1();
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f9993v = safeIntent.getStringExtra("appeal_type");
        this.f9994w = safeIntent.getStringExtra("fileId");
        this.f9995x = safeIntent.getStringExtra("ownerId");
        C1120a.m6675d("AppealMainActivity", "appealType " + this.f9993v + " mediaId " + this.f9994w + " ownerId " + this.f9995x);
    }

    /* renamed from: X1 */
    private void m13365X1() {
        this.f9987p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f9988q = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.main_all);
        ((RelativeLayout) C12809f.m76829b(this, R$id.ic_back_hot_space)).setOnClickListener(this);
        EditText editText = (EditText) C12809f.m76829b(this, R$id.et_appeal_content);
        this.f9989r = editText;
        editText.setHint(getResources().getQuantityString(R$plurals.appeal_reason_hint, 5, 5));
        this.f9989r.setFilters(new InputFilter[]{C1130k.m6918c(), C1130k.m6916a()});
        this.f9989r.addTextChangedListener(this);
        this.f9990s = (TextView) C12809f.m76829b(this, R$id.tv_input_content_size);
        m13372Y1(0);
        Button button = (Button) C12809f.m76829b(this, R$id.btn_submit);
        this.f9991t = button;
        button.setOnClickListener(this);
        m13366Q1();
        ((ImageView) C12809f.m76829b(this, R$id.iv_appeal_record)).setOnClickListener(this);
    }

    /* renamed from: Q1 */
    public final void m13366Q1() {
        Button button = this.f9991t;
        if (button == null) {
            C1120a.m6676e("AppealMainActivity", "disableSubmit btnSubmit is null");
            return;
        }
        button.setClickable(false);
        this.f9991t.setEnabled(false);
        this.f9991t.setAlpha(0.4f);
    }

    /* renamed from: R1 */
    public final void m13367R1() {
        C12515a.m75110o().m75172d(new C2179b());
    }

    /* renamed from: S1 */
    public final void m13368S1() {
        C12515a.m75110o().m75172d(new C2178a());
    }

    /* renamed from: T1 */
    public final void m13369T1() {
        if (!NetworkUtil.isNetworkAvailable(this)) {
            C1140u.m7197i(this);
            return;
        }
        m13366Q1();
        m13373Z1();
        if ("account".equals(this.f9993v)) {
            m13367R1();
        } else if (CloudBackupConstant.Command.PMS_OPTION_ONE_FILE.equals(this.f9993v)) {
            m13368S1();
        }
    }

    /* renamed from: U1 */
    public final void m13370U1() {
        Button button = this.f9991t;
        if (button == null) {
            C1120a.m6676e("AppealMainActivity", "enableSubmit btnSubmit is null");
            return;
        }
        button.setClickable(true);
        this.f9991t.setEnabled(true);
        this.f9991t.setAlpha(1.0f);
    }

    /* renamed from: V1 */
    public final void m13371V1() {
        C0224k0.m1542L(this, new Intent(this, (Class<?>) AppealRecordActivity.class));
    }

    /* renamed from: Y1 */
    public final void m13372Y1(int i10) {
        if (this.f9990s == null) {
            C1120a.m6676e("AppealMainActivity", "inputContentSize is null");
            return;
        }
        this.f9990s.setText(getString(R$string.wish_list_input_count, C1011a.m6163c(Integer.valueOf(i10)), C1011a.m6163c(100)));
    }

    /* renamed from: Z1 */
    public final void m13373Z1() {
        C1120a.m6675d("AppealMainActivity", "reportClickAppealEvent eventCode action_code_click_submit_appeal");
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("fileId", TextUtils.isEmpty(this.f9994w) ? "" : this.f9994w);
        linkedHashMapM79497A.put("appeal_type", this.f9993v);
        C13224c.m79487f1().m79592m0("action_code_click_submit_appeal", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "action_code_click_submit_appeal", "1", "from_cloud_album_appeal_main", linkedHashMapM79497A);
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
        arrayList.add(this.f9987p);
        arrayList.add(this.f9988q);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C1120a.m6675d("AppealMainActivity", "do not fast click");
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.ic_back_hot_space) {
            finish();
        } else if (id2 == R$id.btn_submit) {
            m13369T1();
        } else if (id2 == R$id.iv_appeal_record) {
            m13371V1();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.layout_appeal_main);
        m13365X1();
        m13364W1();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        int length;
        String string = charSequence.toString();
        this.f9992u = string;
        if (TextUtils.isEmpty(string)) {
            EditText editText = this.f9989r;
            if (editText != null) {
                editText.setHint(getResources().getQuantityString(R$plurals.appeal_reason_hint, 5, 5));
            }
            length = 0;
        } else {
            length = this.f9992u.length();
            if (length > 5) {
                m13370U1();
            } else {
                m13366Q1();
            }
        }
        m13372Y1(length);
    }
}
