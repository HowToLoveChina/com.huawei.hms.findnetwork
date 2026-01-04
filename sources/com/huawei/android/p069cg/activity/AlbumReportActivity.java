package com.huawei.android.p069cg.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p031b7.C1120a;
import p604r7.C12469b;
import p684un.C13224c;
import sk.C12809f;

/* loaded from: classes2.dex */
public class AlbumReportActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: p */
    public RadioGroup f9945p;

    /* renamed from: q */
    public Button f9946q;

    /* renamed from: r */
    public String f9947r;

    /* renamed from: s */
    public String f9948s;

    /* renamed from: t */
    public boolean f9949t = false;

    /* renamed from: u */
    public NotchTopFitLinearLayout f9950u = null;

    /* renamed from: v */
    public NotchFitLinearLayout f9951v = null;

    /* renamed from: w */
    public Handler.Callback f9952w = new Handler.Callback() { // from class: k6.a
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f52055a.m13324O1(message);
        }
    };

    /* renamed from: x */
    public Handler f9953x = new Handler(this.f9952w);

    /* renamed from: N1 */
    private void m13323N1() {
        this.f9945p = (RadioGroup) C12809f.m76829b(this, R$id.report_rg);
        this.f9946q = (Button) C12809f.m76829b(this, R$id.report_submit_button);
        this.f9950u = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.top_notch_fit_layout);
        this.f9951v = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f9946q.setOnClickListener(this);
        Intent intent = getIntent();
        if (intent == null) {
            C1120a.m6678w("AlbumReportActivity", "intent is null.");
            return;
        }
        try {
            this.f9947r = intent.getStringExtra("fileId");
            this.f9948s = intent.getStringExtra("ownerId");
        } catch (Exception unused) {
            C1120a.m6676e("AlbumReportActivity", "fileId or mediaOwnerId  get is null");
        }
    }

    /* renamed from: O1 */
    public final /* synthetic */ boolean m13324O1(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            Toast.makeText(this, getString(R$string.toast_reported), 0).show();
            finish();
        } else if (i10 == 1) {
            Toast.makeText(this, getString(R$string.file_load_deleted), 0).show();
            finish();
        }
        return false;
    }

    /* renamed from: P1 */
    public final /* synthetic */ void m13325P1(List list) {
        try {
            if (this.f9949t) {
                return;
            }
            this.f9949t = true;
            C12469b.m74746l().m74763s(this.f9947r, list, this.f9948s, "");
            this.f9953x.sendEmptyMessage(0);
        } catch (Exception e10) {
            C1120a.m6677i("AlbumReportActivity", "riskInformCreate exception:" + e10);
            this.f9953x.sendEmptyMessage(1);
        }
    }

    /* renamed from: Q1 */
    public final void m13326Q1(String str) {
        C1120a.m6677i("AlbumReportActivity", "the choosen tag is :" + str);
        final ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (this.f9947r == null || this.f9948s == null) {
            this.f9953x.sendEmptyMessage(1);
        } else {
            new Thread(new Runnable() { // from class: k6.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f52056a.m13325P1(arrayList);
                }
            }).start();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f9951v);
        arrayList.add(this.f9950u);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: n1 */
    public void mo13327n1() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.mo13327n1();
        getActionBar().setTitle(R$string.album_detail_report);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        if (C0209d.m1226Y0()) {
            C1120a.m6678w("AlbumReportActivity", "AlbumReportActivity click too fast");
            return;
        }
        if (view.getId() == R$id.report_submit_button) {
            int checkedRadioButtonId = this.f9945p.getCheckedRadioButtonId();
            if (checkedRadioButtonId == R$id.report_sex_rb) {
                m13326Q1("PORN");
            } else if (checkedRadioButtonId == R$id.report_politics_rb) {
                m13326Q1("POLITICS");
            } else if (checkedRadioButtonId == R$id.report_violence_rb) {
                m13326Q1("TERRORISM");
            } else if (checkedRadioButtonId == R$id.report_cheat_rb) {
                m13326Q1("FRAUD");
            } else if (checkedRadioButtonId == R$id.report_drug_rb) {
                m13326Q1("PROHIBIT");
            } else if (checkedRadioButtonId == R$id.report_advertise_rb) {
                m13326Q1("AD");
            } else if (checkedRadioButtonId == R$id.report_other_rb) {
                m13326Q1("OTHERS");
            }
            C13224c.m79487f1().m79593q0("CLICK_REPORT_SUBMIT");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.album_report_activity_view);
        m13323N1();
        mo13327n1();
        mo19005p1();
    }
}
