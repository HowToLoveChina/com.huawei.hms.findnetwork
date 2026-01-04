package com.huawei.android.p069cg.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.hms.p148ui.SafeIntent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import p031b7.C1120a;
import p336he.C10159j;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes2.dex */
public class AppealDetailActivity extends UIActivity {

    /* renamed from: p */
    public NotchTopFitRelativeLayout f9979p;

    /* renamed from: q */
    public NotchFitLinearLayout f9980q;

    /* renamed from: r */
    public LinearLayout f9981r;

    /* renamed from: s */
    public TextView f9982s;

    /* renamed from: t */
    public TextView f9983t;

    /* renamed from: u */
    public TextView f9984u;

    /* renamed from: v */
    public TextView f9985v;

    /* renamed from: w */
    public TextView f9986w;

    /* renamed from: L1 */
    private void m13354L1() throws ParseException {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f9983t.setText(getString(R$string.appeal_reason_desc, safeIntent.getStringExtra("appeal_reason")));
        String stringExtra = safeIntent.getStringExtra("appeal_type");
        if (CloudBackupConstant.Command.PMS_OPTION_ONE_FILE.equals(stringExtra)) {
            this.f9984u.setText(getString(R$string.appeal_file, safeIntent.getStringExtra("appeal_file")));
        } else {
            this.f9984u.setText(getString(R$string.appeal_account, C13452e.m80781L().m80900d()));
        }
        String stringExtra2 = safeIntent.getStringExtra("appeal_time");
        String stringExtra3 = safeIntent.getStringExtra("appeal_edit_time");
        C1120a.m6675d("AppealDetailActivity", "createTime " + stringExtra2 + " editTime " + stringExtra3);
        if (!TextUtils.isEmpty(stringExtra3)) {
            stringExtra2 = stringExtra3;
        }
        if (stringExtra2 != null && !TextUtils.isEmpty(stringExtra2)) {
            stringExtra2 = C10159j.m63336l(stringExtra2, "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm");
        }
        C1120a.m6675d("AppealDetailActivity", "createTime1 " + stringExtra2);
        this.f9985v.setText(getString(R$string.appeal_time, stringExtra2));
        String stringExtra4 = safeIntent.getStringExtra("appeal_done_time");
        C1120a.m6675d("AppealDetailActivity", "dTime " + stringExtra4);
        if (stringExtra4 != null && !TextUtils.isEmpty(stringExtra4)) {
            stringExtra4 = C10159j.m63336l(stringExtra4, "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm");
        }
        C1120a.m6675d("AppealDetailActivity", "dTime1 " + stringExtra4);
        this.f9986w.setText(stringExtra4);
        int intExtra = safeIntent.getIntExtra("appeal_done_status", -1);
        if (intExtra != -1) {
            if (intExtra == 0) {
                m13357M1();
            } else if (intExtra == 1) {
                m13358P1(stringExtra, true);
            } else if (intExtra == 2) {
                m13358P1(stringExtra, false);
            }
        }
    }

    /* renamed from: N1 */
    private void m13355N1() throws ParseException {
        m22365E1(R$string.appeal_detail);
        mo19005p1();
        mo19982C1();
        m13354L1();
    }

    /* renamed from: O1 */
    private void m13356O1() {
        this.f9979p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f9980q = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.main_all);
        this.f9981r = (LinearLayout) C12809f.m76829b(this, R$id.llay_reply);
        this.f9982s = (TextView) C12809f.m76829b(this, R$id.tv_reply_content);
        this.f9983t = (TextView) C12809f.m76829b(this, R$id.tv_appeal_reason);
        this.f9984u = (TextView) C12809f.m76829b(this, R$id.tv_appeal_file);
        this.f9985v = (TextView) C12809f.m76829b(this, R$id.tv_appeal_time);
        this.f9986w = (TextView) C12809f.m76829b(this, R$id.tv_done_time);
    }

    /* renamed from: M1 */
    public final void m13357M1() {
        this.f9981r.setVisibility(8);
        this.f9982s.setVisibility(8);
    }

    /* renamed from: P1 */
    public final void m13358P1(String str, boolean z10) {
        String string;
        C1120a.m6675d("AppealDetailActivity", "type " + str + " isAccept " + z10);
        this.f9981r.setVisibility(0);
        this.f9982s.setVisibility(0);
        if ("account".equals(str)) {
            string = getString(z10 ? R$string.appeal_account_success : R$string.appeal_fail);
        } else if (CloudBackupConstant.Command.PMS_OPTION_ONE_FILE.equals(str)) {
            string = getString(z10 ? R$string.appeal_content_success : R$string.appeal_fail);
        } else {
            string = "";
        }
        this.f9982s.setText(string);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f9979p);
        arrayList.add(this.f9980q);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws ParseException {
        super.onCreate(bundle);
        setContentView(R$layout.layout_appeal_detail);
        m13356O1();
        m13355N1();
    }
}
