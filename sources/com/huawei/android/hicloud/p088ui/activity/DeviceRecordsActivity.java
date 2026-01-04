package com.huawei.android.hicloud.p088ui.activity;

import ae.C0186z0;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.task.simple.C3016b2;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordOperation;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordsRsp;
import com.huawei.hicloud.request.cbs.bean.CBSDeviceOperation;
import com.huawei.hicloud.request.cbs.bean.CBSOperation;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import ne.C11667a;
import p015ak.C0219i;
import p514o9.C11829c;
import p514o9.C11836j;
import p514o9.C11839m;
import p514o9.C11842p;
import p616rk.C12515a;
import p783xp.C13843a;
import sk.C12806c;
import sk.C12809f;

/* loaded from: classes3.dex */
public class DeviceRecordsActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: p */
    public NotchTopFitRelativeLayout f14687p;

    /* renamed from: q */
    public NotchFitRelativeLayout f14688q;

    /* renamed from: r */
    public RelativeLayout f14689r;

    /* renamed from: s */
    public ListView f14690s;

    /* renamed from: t */
    public View f14691t;

    /* renamed from: u */
    public RelativeLayout f14692u;

    /* renamed from: v */
    public RelativeLayout f14693v;

    /* renamed from: w */
    public boolean f14694w;

    /* renamed from: x */
    public C3269c f14695x = new C3269c();

    /* renamed from: y */
    public Handler f14696y = new HandlerC3267a();

    /* renamed from: com.huawei.android.hicloud.ui.activity.DeviceRecordsActivity$a */
    public class HandlerC3267a extends Handler {
        public HandlerC3267a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            if (message.what == 0) {
                DeviceRecordsActivity.this.m20340S1(message);
            } else {
                DeviceRecordsActivity.this.m20342V1();
                C11839m.m70687e("DeviceRecordsActivity", "no records when query");
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.DeviceRecordsActivity$b */
    public static class C3268b implements Comparator<CBSDeviceOperation>, Serializable {
        private static final long serialVersionUID = 5699171561950138319L;

        @Override // java.util.Comparator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(CBSDeviceOperation cBSDeviceOperation, CBSDeviceOperation cBSDeviceOperation2) {
            List<CBSOperation> oprations = cBSDeviceOperation.getOprations();
            CBSOperation cBSOperation = null;
            CBSOperation cBSOperation2 = (oprations == null || oprations.isEmpty()) ? null : oprations.get(0);
            long createTime = cBSOperation2 != null ? cBSOperation2.getCreateTime() : -1L;
            List<CBSOperation> oprations2 = cBSDeviceOperation2.getOprations();
            if (oprations2 != null && !oprations2.isEmpty()) {
                cBSOperation = oprations2.get(0);
            }
            return (int) (((cBSOperation != null ? cBSOperation.getCreateTime() : -1L) - createTime) / 1000);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.DeviceRecordsActivity$c */
    public static class C3269c implements Comparator<CBSSyncRecordOperation>, Serializable {
        private static final long serialVersionUID = 5699171561950138319L;

        @Override // java.util.Comparator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(CBSSyncRecordOperation cBSSyncRecordOperation, CBSSyncRecordOperation cBSSyncRecordOperation2) {
            return (int) (((cBSSyncRecordOperation2 != null ? C11667a.m69660b(cBSSyncRecordOperation2.getLastUpdateTime(), "yyyy-MM-dd'T'HH:mm:sszzz") : -1L) - (cBSSyncRecordOperation != null ? C11667a.m69660b(cBSSyncRecordOperation.getLastUpdateTime(), "yyyy-MM-dd'T'HH:mm:sszzz") : -1L)) / 1000);
        }
    }

    /* renamed from: O1 */
    private void m20334O1() {
        C11839m.m70688i("DeviceRecordsActivity", "initData isFromBasic " + this.f14694w);
        C12515a.m75110o().m75175e(new C3016b2(this.f14696y, this.f14694w), false);
    }

    /* renamed from: Q1 */
    private void m20335Q1() {
        this.f14690s = (ListView) C12809f.m76829b(this, R$id.device_records_list);
        this.f14692u = (RelativeLayout) C12809f.m76829b(this, R$id.records_nodata);
        m20338P1();
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76832e((LayoutInflater) getSystemService("layout_inflater"), R$layout.device_header_view);
        this.f14693v = relativeLayout;
        if (relativeLayout != null) {
            this.f14690s.addHeaderView(relativeLayout);
        }
        this.f14689r = (RelativeLayout) C12809f.m76829b(this, R$id.device_records_main_layout);
        this.f14687p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f14688q = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_other);
        m22380o1();
        Intent intent = getIntent();
        if (intent != null) {
            this.f14694w = new SafeIntent(intent).getBooleanExtra("isFromBasic", true);
        }
        m20336U1();
    }

    /* renamed from: U1 */
    private void m20336U1() {
        C11842p.m70763R1(this, this.f14691t, (C11842p.m70731H(this, (int) C11842p.m70844o(this, 36)) - C11842p.m70852q(this)) - (C11842p.m70753O0(this) ? 0 : C11842p.m70789a0(this)));
    }

    /* renamed from: N1 */
    public final void m20337N1(List<CBSSyncRecordOperation> list) {
        if (list == null) {
            m20342V1();
            C11839m.m70688i("DeviceRecordsActivity", "no records when deal data");
            return;
        }
        Iterator<CBSSyncRecordOperation> it = list.iterator();
        while (it.hasNext()) {
            if (m20339R1(it.next())) {
                it.remove();
            }
        }
        Collections.sort(list, this.f14695x);
        C11836j.m70658k().m70673p(list);
        m20341T1();
    }

    /* renamed from: P1 */
    public final void m20338P1() {
        this.f14691t = C12809f.m76829b(this, R$id.layout_loading);
    }

    /* renamed from: R1 */
    public final boolean m20339R1(CBSSyncRecordOperation cBSSyncRecordOperation) {
        return TextUtils.isEmpty(cBSSyncRecordOperation.getOpDesc()) || (TextUtils.isEmpty(cBSSyncRecordOperation.getAliasName()) && TextUtils.isEmpty(cBSSyncRecordOperation.getDevDisplayName())) || TextUtils.isEmpty(cBSSyncRecordOperation.getDeviceID()) || TextUtils.isEmpty(cBSSyncRecordOperation.getLastUpdateTime());
    }

    /* renamed from: S1 */
    public final void m20340S1(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof CBSSyncRecordsRsp)) {
            m20342V1();
            C11839m.m70688i("DeviceRecordsActivity", "records wrong");
            return;
        }
        List<CBSSyncRecordOperation> opRecordList = ((CBSSyncRecordsRsp) obj).getOpRecordList();
        if (opRecordList == null || opRecordList.size() <= 0) {
            m20342V1();
            C11839m.m70688i("DeviceRecordsActivity", "no records because list no data");
            return;
        }
        C11839m.m70688i("DeviceRecordsActivity", "queryBasicDeviceRecordSuccess size=" + opRecordList.size());
        m20337N1(opRecordList);
    }

    /* renamed from: T1 */
    public final void m20341T1() {
        C0186z0 c0186z0 = new C0186z0(this, this);
        this.f14690s.setAdapter((ListAdapter) c0186z0);
        List<CBSSyncRecordOperation> listM70667i = C11836j.m70658k().m70667i();
        if (listM70667i == null || listM70667i.size() <= 0) {
            m20342V1();
            C11839m.m70688i("DeviceRecordsActivity", "no records when set adapter");
        } else {
            this.f14691t.setVisibility(8);
            c0186z0.m1060a(listM70667i);
            c0186z0.notifyDataSetChanged();
        }
    }

    /* renamed from: V1 */
    public final void m20342V1() {
        this.f14692u.setVisibility(0);
        this.f14691t.setVisibility(8);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: c1 */
    public int mo20343c1() {
        return R$id.device_records_list;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14687p);
        arrayList.add(this.f14693v);
        arrayList.add(this.f14688q);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m20336U1();
        if (C0219i.m1463a() < 17 || !C11829c.m70563b0(this)) {
            return;
        }
        C12806c.m76820k(this, mo13289d1());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        setContentView(R$layout.hisync_device_records);
        m20335Q1();
        mo19005p1();
        m20334O1();
        m22365E1(R$string.mydevice);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C11842p.m70836m(this);
        super.onDestroy();
    }
}
