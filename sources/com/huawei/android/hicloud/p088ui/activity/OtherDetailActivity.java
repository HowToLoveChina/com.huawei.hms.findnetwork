package com.huawei.android.hicloud.p088ui.activity;

import ae.C0175v1;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.huawei.android.hicloud.cloudspace.manager.StorageManageOtherItem;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.p103ui.uiextend.ScrollDisabledListView;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.secure.android.common.intent.SafeIntent;
import gp.C10028c;
import hu.C10343b;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0223k;
import p514o9.C11839m;
import p664u0.C13108a;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13227f;
import p703v8.C13380q;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class OtherDetailActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: p */
    public C0175v1 f15717p = null;

    /* renamed from: q */
    public ScrollDisabledListView f15718q = null;

    /* renamed from: r */
    public NotchTopFitRelativeLayout f15719r;

    /* renamed from: s */
    public NotchFitRelativeLayout f15720s;

    /* renamed from: t */
    public StorageReceiver f15721t;

    /* renamed from: u */
    public String f15722u;

    public class StorageReceiver extends BroadcastReceiver {
        public StorageReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            if (!"com.huawei.hicloud.DELETE_STORAGE_FINISHED".equals(safeIntent.getAction()) || (stringExtra = safeIntent.getStringExtra("moduleName")) == null) {
                return;
            }
            OtherDetailActivity.this.f15717p.m967c(stringExtra);
            OtherDetailActivity otherDetailActivity = OtherDetailActivity.this;
            otherDetailActivity.m21864a2(otherDetailActivity.f15718q, OtherDetailActivity.this.f15717p);
        }
    }

    /* renamed from: Y1 */
    private void m21862Y1() {
        if (this.f15721t == null) {
            this.f15721t = new StorageReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.hicloud.DELETE_STORAGE_FINISHED");
            C13108a.m78878b(this).m78880c(this.f15721t, intentFilter);
        }
    }

    /* renamed from: Z1 */
    private void m21863Z1() {
        this.f15719r = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f15720s = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_other_detail);
        this.f15718q = (ScrollDisabledListView) C12809f.m76829b(this, R$id.other_detail_data_list);
        C0175v1 c0175v1 = new C0175v1(this, this);
        this.f15717p = c0175v1;
        this.f15718q.setAdapter((ListAdapter) c0175v1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a2 */
    public synchronized void m21864a2(ScrollDisabledListView scrollDisabledListView, BaseAdapter baseAdapter) {
        try {
            if (baseAdapter.isEmpty()) {
                scrollDisabledListView.setVisibility(8);
            } else {
                scrollDisabledListView.setVisibility(0);
            }
            baseAdapter.notifyDataSetChanged();
            C2783d.m16170p1(scrollDisabledListView, baseAdapter);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: c2 */
    private void m21865c2(int i10) {
        if (i10 == -1 || !C10028c.m62182c0().m62315d1()) {
            C11839m.m70687e("OtherDetailActivity", "MSG_QUERY_CALLLOG_COUNT_FINISH failed");
        } else {
            m21881g2(i10);
        }
    }

    /* renamed from: f2 */
    private void m21866f2(int i10) {
        if (i10 == -1 || !C10028c.m62182c0().m62390s1()) {
            C11839m.m70687e("OtherDetailActivity", "MSG_QUERY_SMS_COUNT_FINISH failed");
        } else {
            m21867i2(i10);
        }
    }

    /* renamed from: i2 */
    private void m21867i2(int i10) {
        if (i10 == 0) {
            C11839m.m70688i("OtherDetailActivity", "refreshSmsNum num=" + i10);
            return;
        }
        C13380q c13380qM966b = this.f15717p.m966b(NavigationUtils.SMS_SCHEMA_PREF);
        if (c13380qM966b == null) {
            c13380qM966b = m21872S1();
        }
        Resources resources = getResources();
        if (resources == null) {
            C11839m.m70687e("OtherDetailActivity", "getResources() is null");
            return;
        }
        c13380qM966b.m80354y(C2783d.m16095M(resources.getQuantityString(R$plurals.backup_detail_gallery_num1, i10, Integer.valueOf(i10)), Integer.valueOf(i10)));
        c13380qM966b.m80344o(i10);
        this.f15717p.m965a(c13380qM966b);
    }

    /* renamed from: O1 */
    public final void m21868O1(String str) {
        if ("record".equals(str)) {
            C13223b.m79475c(this, "manage_recording", "1", C13452e.m80781L().m80971t0(), this.f15722u);
            UBAAnalyze.m29959T("PVC", "manage_recording", "1", "26", "1", this.f15722u);
            C13227f.m79492i1().m79585f0("mecloud_cloudspace_click_record", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_cloudspace_click_record", "1", "26");
            return;
        }
        if ("phonemanager".equals(str)) {
            C13223b.m79475c(this, "manage_phonemanager", "1", C13452e.m80781L().m80971t0(), this.f15722u);
            UBAAnalyze.m29959T("PVC", "manage_phonemanager", "1", "6", "1", this.f15722u);
            C13227f.m79492i1().m79585f0("mecloud_cloudspace_click_phonemanage", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_cloudspace_click_phonemanage", "1", "6");
            return;
        }
        if ("calllog".equals(str)) {
            C13223b.m79475c(this, "manage_calllog", "1", C13452e.m80781L().m80971t0(), this.f15722u);
            UBAAnalyze.m29959T("PVC", "manage_calllog", "1", "25", "1", this.f15722u);
            C13227f.m79492i1().m79585f0("mecloud_cloudspace_click_calllogs", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_cloudspace_click_calllogs", "1", "25");
            return;
        }
        if (NavigationUtils.SMS_SCHEMA_PREF.equals(str)) {
            C13223b.m79475c(this, "manage_sms", "1", C13452e.m80781L().m80971t0(), this.f15722u);
            UBAAnalyze.m29959T("PVC", "manage_sms", "1", "12", "1", this.f15722u);
            C13227f.m79492i1().m79585f0("mecloud_cloudspace_click_messages", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_cloudspace_click_messages", "1", "12");
        }
    }

    /* renamed from: P1 */
    public final C13380q m21869P1() {
        C13380q c13380q = new C13380q();
        c13380q.m80352w("calllog");
        c13380q.m80349t(C0209d.m1269j1() ? getDrawable(R$drawable.icon_call_log_honor) : getDrawable(R$drawable.icon_call_log));
        c13380q.m80326I(getString(R$string.cloudbackup_Calllog));
        c13380q.m80350u(m21874U1("calllog"));
        return c13380q;
    }

    /* renamed from: Q1 */
    public final C13380q m21870Q1() {
        C13380q c13380q = new C13380q();
        c13380q.m80352w("phonemanager");
        c13380q.m80349t(getDrawable(R$drawable.icon_section_ba_detail));
        c13380q.m80326I(getString(R$string.cloudbackup_back_item_phonemanager));
        c13380q.m80350u(m21874U1("phonemanager"));
        return c13380q;
    }

    /* renamed from: R1 */
    public final C13380q m21871R1() {
        C13380q c13380q = new C13380q();
        c13380q.m80352w("record");
        c13380q.m80349t(C0209d.m1269j1() ? getDrawable(R$drawable.icon_record_detail_honor) : getDrawable(R$drawable.icon_record_detail));
        c13380q.m80326I(getString(R$string.cloudbackup_back_item_record));
        c13380q.m80350u(m21874U1("record"));
        return c13380q;
    }

    /* renamed from: S1 */
    public final C13380q m21872S1() {
        C13380q c13380q = new C13380q();
        c13380q.m80352w(NavigationUtils.SMS_SCHEMA_PREF);
        c13380q.m80349t(C0209d.m1269j1() ? getDrawable(R$drawable.icon_message_honor) : getDrawable(R$drawable.icon_message));
        c13380q.m80326I(getString(R$string.cloudbackup_back_item_sms));
        c13380q.m80350u(m21874U1(NavigationUtils.SMS_SCHEMA_PREF));
        return c13380q;
    }

    /* renamed from: T1 */
    public final Intent m21873T1() {
        Intent intent = new Intent();
        intent.setClass(this, CallLogDetailActivity.class);
        return intent;
    }

    /* renamed from: U1 */
    public final Intent m21874U1(String str) {
        if (str == null) {
            C11839m.m70688i("OtherDetailActivity", "getModuleIntent null");
            return null;
        }
        switch (str) {
            case "phonemanager":
                return m21875V1();
            case "record":
                return m21876W1();
            case "sms":
                return m21877X1();
            case "calllog":
                return m21873T1();
            default:
                return null;
        }
    }

    /* renamed from: V1 */
    public final Intent m21875V1() {
        Intent intent = new Intent();
        intent.setClass(this, HarassmentInterceptDetailActivity.class);
        return intent;
    }

    /* renamed from: W1 */
    public final Intent m21876W1() {
        Intent intent = new Intent();
        intent.setClass(this, SoundRecordDetailActivity.class);
        return intent;
    }

    /* renamed from: X1 */
    public final Intent m21877X1() {
        Intent intent = new Intent();
        intent.setClass(this, MessageDetailActivity.class);
        return intent;
    }

    /* renamed from: b2 */
    public final void m21878b2(View view, C13380q c13380q) {
        if (view == null) {
            C11839m.m70687e("OtherDetailActivity", "onItemClick view null");
        } else {
            c13380q.m80351v();
            startActivity(c13380q.m80332c());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15719r);
        arrayList.add(this.f15720s);
        return arrayList;
    }

    /* renamed from: d2 */
    public final void m21879d2(Long l10) {
        if (C10028c.m62182c0().m62311c1()) {
            m21883j2(l10);
        } else {
            C11839m.m70687e("OtherDetailActivity", "MSG_QUERY_PHONEMANAGER_COUNT_FINISH failed");
        }
    }

    /* renamed from: e2 */
    public final void m21880e2(Long l10, Integer num) {
        if (num.intValue() == -1 || !C10028c.m62182c0().m62201D1()) {
            C11839m.m70687e("OtherDetailActivity", "MSG_QUERY_RECORD_COUNT_FINISH failed");
        } else {
            m21882h2(l10, num);
        }
    }

    /* renamed from: g2 */
    public final void m21881g2(int i10) {
        if (i10 == 0) {
            C11839m.m70688i("OtherDetailActivity", "refreshCalllogNum num=" + i10);
            return;
        }
        C13380q c13380qM966b = this.f15717p.m966b("calllog");
        if (c13380qM966b == null) {
            c13380qM966b = m21869P1();
        }
        if (getResources() == null) {
            C11839m.m70687e("OtherDetailActivity", "getResources() is null");
            return;
        }
        c13380qM966b.m80354y(C2783d.m16095M(getResources().getQuantityString(R$plurals.backup_detail_gallery_num1, i10, Integer.valueOf(i10)), Integer.valueOf(i10)));
        c13380qM966b.m80344o(i10);
        this.f15717p.m965a(c13380qM966b);
    }

    /* renamed from: h2 */
    public final void m21882h2(Long l10, Integer num) {
        if (l10.longValue() == 0 && num.intValue() == 0) {
            C11839m.m70688i("OtherDetailActivity", "refreshyPhonemanagerSizeAmount size=" + l10 + ", amount=" + num);
            return;
        }
        C13380q c13380qM966b = this.f15717p.m966b("record");
        if (c13380qM966b == null) {
            c13380qM966b = m21871R1();
        }
        Resources resources = getResources();
        if (resources == null) {
            C11839m.m70687e("OtherDetailActivity", "getResources() is null");
            return;
        }
        c13380qM966b.m80354y(C2783d.m16095M(resources.getQuantityString(R$plurals.backup_detail_gallery_num1, num.intValue(), num), num));
        c13380qM966b.m80344o(num.intValue());
        c13380qM966b.m80323F(C0223k.m1524g(this, l10.longValue()));
        c13380qM966b.m80324G(l10.longValue());
        this.f15717p.m965a(c13380qM966b);
    }

    /* renamed from: j2 */
    public final void m21883j2(Long l10) {
        if (l10.longValue() == 0) {
            C11839m.m70688i("OtherDetailActivity", "refreshyPhonemanagerSizeAmount size=" + l10);
            return;
        }
        C13380q c13380qM966b = this.f15717p.m966b("phonemanager");
        if (c13380qM966b == null) {
            c13380qM966b = m21870Q1();
        }
        c13380qM966b.m80323F(C0223k.m1524g(this, l10.longValue()));
        c13380qM966b.m80324G(l10.longValue());
        this.f15717p.m965a(c13380qM966b);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        int iM969b = ((C0175v1.a) view.getTag()).m969b();
        C11839m.m70688i("OtherDetailActivity", "onDetailClick position=" + iM969b);
        C13380q c13380q = (C13380q) this.f15717p.getItem(iM969b);
        if (c13380q == null) {
            C11839m.m70687e("OtherDetailActivity", "onDetailClick item null");
        } else {
            m21878b2(view, c13380q);
            m21868O1(c13380q.m80333d());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.other_detail);
        m21863Z1();
        mo19005p1();
        m21862Y1();
        m22365E1(R$string.setting_other);
        mo19982C1();
        this.f15722u = C13222a.m79465g(this);
        Bundle extras = new SafeIntent(getIntent()).getExtras();
        if (extras == null) {
            C11839m.m70687e("OtherDetailActivity", "bundle is null");
            return;
        }
        StorageManageOtherItem storageManageOtherItem = (StorageManageOtherItem) new C10343b(extras).m63690l("other_app_data_details");
        if (storageManageOtherItem == null) {
            C11839m.m70687e("OtherDetailActivity", "storageManageOtherItem is null");
            return;
        }
        int iM15498f = storageManageOtherItem.m15498f();
        int iM15494a = storageManageOtherItem.m15494a();
        Long lValueOf = Long.valueOf(storageManageOtherItem.m15495c());
        Long lValueOf2 = Long.valueOf(storageManageOtherItem.m15497e());
        Integer numValueOf = Integer.valueOf(storageManageOtherItem.m15496d());
        m21866f2(iM15498f);
        m21865c2(iM15494a);
        m21879d2(lValueOf);
        m21880e2(lValueOf2, numValueOf);
        m21864a2(this.f15718q, this.f15717p);
    }
}
