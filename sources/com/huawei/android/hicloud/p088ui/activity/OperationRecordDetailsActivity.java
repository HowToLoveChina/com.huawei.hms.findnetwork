package com.huawei.android.hicloud.p088ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.android.app.ActionBarEx;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupRecordsAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.PullUpListView;
import com.huawei.android.hicloud.task.simple.C3036g2;
import com.huawei.android.hicloud.task.simple.C3075q1;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.request.basic.bean.CBSAllDevicesRsp;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordDeviceInfo;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordOperation;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordsRsp;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.phone.hwspinner.widget.HwSpinner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import ne.C11667a;
import p015ak.C0209d;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p616rk.C12515a;
import p684un.C13225d;
import p684un.C13230i;
import sk.C12809f;

/* loaded from: classes3.dex */
public class OperationRecordDetailsActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: A */
    public LinearLayout f15655A;

    /* renamed from: B */
    public AutoSizeButton f15656B;

    /* renamed from: C */
    public NotchFitRelativeLayout f15657C;

    /* renamed from: D */
    public BackupRecordsAdapter f15658D;

    /* renamed from: E */
    public boolean f15659E;

    /* renamed from: F */
    public boolean f15660F;

    /* renamed from: G */
    public List<CBSSyncRecordDeviceInfo> f15661G;

    /* renamed from: H */
    public String f15662H;

    /* renamed from: I */
    public List<CBSSyncRecordOperation> f15663I;

    /* renamed from: J */
    public CBSSyncRecordDeviceInfo f15664J;

    /* renamed from: K */
    public String f15665K;

    /* renamed from: L */
    public int f15666L;

    /* renamed from: M */
    public AlertDialog f15667M;

    /* renamed from: N */
    public volatile boolean f15668N = false;

    /* renamed from: O */
    public volatile boolean f15669O = false;

    /* renamed from: P */
    public int f15670P = -1;

    /* renamed from: Q */
    public Handler f15671Q = new HandlerC3422a();

    /* renamed from: R */
    public Handler f15672R = new HandlerC3423b();

    /* renamed from: p */
    public Context f15673p;

    /* renamed from: q */
    public NotchTopFitRelativeLayout f15674q;

    /* renamed from: r */
    public NotchFitRelativeLayout f15675r;

    /* renamed from: s */
    public HwSpinner f15676s;

    /* renamed from: t */
    public PullUpListView f15677t;

    /* renamed from: u */
    public NotchFitRelativeLayout f15678u;

    /* renamed from: v */
    public LinearLayout f15679v;

    /* renamed from: w */
    public TextView f15680w;

    /* renamed from: x */
    public NotchFitRelativeLayout f15681x;

    /* renamed from: y */
    public NotchFitRelativeLayout f15682y;

    /* renamed from: z */
    public LinearLayout f15683z;

    /* renamed from: com.huawei.android.hicloud.ui.activity.OperationRecordDetailsActivity$a */
    public class HandlerC3422a extends Handler {
        public HandlerC3422a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0) {
                C11839m.m70688i("OperationRecordDetailsActivity", "query devices failed");
                return;
            }
            CBSAllDevicesRsp cBSAllDevicesRsp = (CBSAllDevicesRsp) message.obj;
            if (cBSAllDevicesRsp == null) {
                C11839m.m70688i("OperationRecordDetailsActivity", "recordsRsp == null no devices");
                return;
            }
            OperationRecordDetailsActivity.this.f15661G = cBSAllDevicesRsp.getDeviceList();
            if (OperationRecordDetailsActivity.this.f15661G == null || OperationRecordDetailsActivity.this.f15661G.size() <= 0) {
                C11839m.m70688i("OperationRecordDetailsActivity", "no devices");
                return;
            }
            OperationRecordDetailsActivity.this.m21782u2();
            C11839m.m70688i("OperationRecordDetailsActivity", "query devices size=" + OperationRecordDetailsActivity.this.f15661G.size());
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.OperationRecordDetailsActivity$b */
    public class HandlerC3423b extends Handler {
        public HandlerC3423b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            OperationRecordDetailsActivity.this.f15657C.setVisibility(8);
            if (message.what != 0) {
                OperationRecordDetailsActivity.this.m21778H2();
                C11839m.m70688i("OperationRecordDetailsActivity", "query records failed");
                return;
            }
            CBSSyncRecordsRsp cBSSyncRecordsRsp = (CBSSyncRecordsRsp) message.obj;
            if (cBSSyncRecordsRsp == null) {
                C11839m.m70688i("OperationRecordDetailsActivity", "recordsRsp == null no records");
                OperationRecordDetailsActivity.this.m21778H2();
                return;
            }
            OperationRecordDetailsActivity.this.f15663I = cBSSyncRecordsRsp.getOpRecordList();
            OperationRecordDetailsActivity operationRecordDetailsActivity = OperationRecordDetailsActivity.this;
            operationRecordDetailsActivity.m21779p2(operationRecordDetailsActivity.f15663I);
            if (OperationRecordDetailsActivity.this.f15663I == null || OperationRecordDetailsActivity.this.f15663I.size() <= 0) {
                C11839m.m70688i("OperationRecordDetailsActivity", "no records");
                OperationRecordDetailsActivity.this.m21785z2();
                return;
            }
            C11839m.m70688i("OperationRecordDetailsActivity", "query records size=" + OperationRecordDetailsActivity.this.f15663I.size());
            OperationRecordDetailsActivity.this.f15662H = cBSSyncRecordsRsp.getUserTimeZone();
            OperationRecordDetailsActivity.this.f15665K = cBSSyncRecordsRsp.getOpTimeTag();
            OperationRecordDetailsActivity.this.f15666L = cBSSyncRecordsRsp.getOpStoreDays();
            if (OperationRecordDetailsActivity.this.f15659E) {
                C11839m.m70688i("OperationRecordDetailsActivity", "load more data");
                OperationRecordDetailsActivity.this.f15658D.m24803c(OperationRecordDetailsActivity.this.f15663I, !TextUtils.isEmpty(OperationRecordDetailsActivity.this.f15665K));
                return;
            }
            C11839m.m70688i("OperationRecordDetailsActivity", "load data");
            OperationRecordDetailsActivity.this.f15658D.m24813m(OperationRecordDetailsActivity.this.f15662H);
            if (!OperationRecordDetailsActivity.this.f15668N) {
                OperationRecordDetailsActivity.this.f15668N = true;
                OperationRecordDetailsActivity operationRecordDetailsActivity2 = OperationRecordDetailsActivity.this;
                operationRecordDetailsActivity2.m21781r2(true, operationRecordDetailsActivity2.getDrawable(R$drawable.hicloud_new_backup));
            }
            if (OperationRecordDetailsActivity.this.f15669O && OperationRecordDetailsActivity.this.f15668N) {
                OperationRecordDetailsActivity.this.f15675r.setVisibility(0);
            }
            OperationRecordDetailsActivity.this.m21776F2(8, 0, 8, 8);
            OperationRecordDetailsActivity.this.f15658D.m24802b(OperationRecordDetailsActivity.this.f15663I, !TextUtils.isEmpty(OperationRecordDetailsActivity.this.f15665K));
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.OperationRecordDetailsActivity$c */
    public class RunnableC3424c implements Runnable {

        /* renamed from: com.huawei.android.hicloud.ui.activity.OperationRecordDetailsActivity$c$a */
        public class a implements AdapterView.OnItemSelectedListener {
            public a() {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
                C11839m.m70688i("OperationRecordDetailsActivity", "spinner positon:" + i10);
                OperationRecordDetailsActivity.this.m21784y2();
                OperationRecordDetailsActivity.this.f15657C.setVisibility(0);
                OperationRecordDetailsActivity.this.f15658D.m24809i(false);
                OperationRecordDetailsActivity.this.f15658D.m24804d();
                if (OperationRecordDetailsActivity.this.f15663I != null) {
                    OperationRecordDetailsActivity.this.f15663I.clear();
                }
                OperationRecordDetailsActivity.this.m21776F2(8, 8, 8, 8);
                OperationRecordDetailsActivity.this.f15659E = false;
                OperationRecordDetailsActivity.this.f15665K = null;
                if (i10 == 0) {
                    OperationRecordDetailsActivity.this.f15660F = false;
                    OperationRecordDetailsActivity operationRecordDetailsActivity = OperationRecordDetailsActivity.this;
                    operationRecordDetailsActivity.m21773B2(operationRecordDetailsActivity.f15665K);
                } else {
                    OperationRecordDetailsActivity.this.f15660F = true;
                    OperationRecordDetailsActivity operationRecordDetailsActivity2 = OperationRecordDetailsActivity.this;
                    operationRecordDetailsActivity2.f15664J = (CBSSyncRecordDeviceInfo) operationRecordDetailsActivity2.f15661G.get(i10 - 1);
                    OperationRecordDetailsActivity operationRecordDetailsActivity3 = OperationRecordDetailsActivity.this;
                    operationRecordDetailsActivity3.m21774C2(operationRecordDetailsActivity3.f15665K);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        }

        public RunnableC3424c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (OperationRecordDetailsActivity.this.f15676s == null) {
                C11839m.m70687e("OperationRecordDetailsActivity", "mHwSpinner is null in post");
            } else {
                OperationRecordDetailsActivity.this.f15676s.setOnItemSelectedListener(new a());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.OperationRecordDetailsActivity$d */
    public class C3425d implements PullUpListView.OnLoadingListener {
        public C3425d() {
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.PullUpListView.OnLoadingListener
        public void onLoadingMore() {
            OperationRecordDetailsActivity.this.f15659E = true;
            if (!C0209d.m1333z1(OperationRecordDetailsActivity.this.f15673p)) {
                Toast.makeText(OperationRecordDetailsActivity.this.f15673p, OperationRecordDetailsActivity.this.getString(R$string.alert_net_disconnect_20160420), 0).show();
                OperationRecordDetailsActivity.this.f15677t.loadingFailed();
            } else if (OperationRecordDetailsActivity.this.f15660F) {
                OperationRecordDetailsActivity operationRecordDetailsActivity = OperationRecordDetailsActivity.this;
                operationRecordDetailsActivity.m21774C2(operationRecordDetailsActivity.f15665K);
            } else {
                OperationRecordDetailsActivity operationRecordDetailsActivity2 = OperationRecordDetailsActivity.this;
                operationRecordDetailsActivity2.m21773B2(operationRecordDetailsActivity2.f15665K);
            }
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.PullUpListView.OnLoadingListener
        public void onLoadingRetry() {
            if (!C0209d.m1226Y0() && OperationRecordDetailsActivity.this.f15659E) {
                if (!C0209d.m1333z1(OperationRecordDetailsActivity.this.f15673p)) {
                    Toast.makeText(OperationRecordDetailsActivity.this.f15673p, OperationRecordDetailsActivity.this.getString(R$string.alert_net_disconnect_20160420), 0).show();
                    OperationRecordDetailsActivity.this.f15677t.loadingFailed();
                } else if (OperationRecordDetailsActivity.this.f15660F) {
                    OperationRecordDetailsActivity operationRecordDetailsActivity = OperationRecordDetailsActivity.this;
                    operationRecordDetailsActivity.m21774C2(operationRecordDetailsActivity.f15665K);
                } else {
                    OperationRecordDetailsActivity operationRecordDetailsActivity2 = OperationRecordDetailsActivity.this;
                    operationRecordDetailsActivity2.m21773B2(operationRecordDetailsActivity2.f15665K);
                }
            }
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.PullUpListView.OnLoadingListener
        public void onRefresh() {
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.OperationRecordDetailsActivity$e */
    public static class DialogInterfaceOnClickListenerC3426e implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (dialogInterface != null) {
                dialogInterface.cancel();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.OperationRecordDetailsActivity$f */
    public static class C3427f implements AbsListView.OnScrollListener {
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
        }
    }

    /* renamed from: D2 */
    private void m21737D2() {
        View viewM76829b = C12809f.m76829b(this, R$id.layout_nonet_icon);
        View viewM76829b2 = C12809f.m76829b(this, R$id.layout_no_service_icon);
        C11842p.m70760Q1(this, this.f15679v);
        C11842p.m70760Q1(this, viewM76829b);
        C11842p.m70760Q1(this, this.f15657C);
        C11842p.m70760Q1(this, viewM76829b2);
    }

    /* renamed from: s2 */
    private void m21768s2() {
        m22365E1(R$string.synchronous_recording_actionbar);
        mo19982C1();
        Intent intent = getIntent();
        if (intent != null) {
            this.f15670P = new SafeIntent(intent).getIntExtra("operation_record_data_type", -1);
        }
        BackupRecordsAdapter backupRecordsAdapter = new BackupRecordsAdapter(this);
        this.f15658D = backupRecordsAdapter;
        this.f15677t.setAdapter((ListAdapter) backupRecordsAdapter);
        m21775E2();
    }

    /* renamed from: t2 */
    private void m21769t2() {
        this.f15677t.setLoadingListener(new C3425d());
        this.f15677t.setOnScrollListener(new C3427f());
    }

    /* renamed from: v2 */
    private void m21770v2() {
        this.f15674q = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.operation_record_datails);
        this.f15675r = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.operation_record_devices_frame);
        this.f15676s = (HwSpinner) C12809f.m76829b(this, R$id.all_devices_spinner);
        this.f15677t = (PullUpListView) C12809f.m76829b(this, R$id.backup_records);
        this.f15657C = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.backups_loading);
        this.f15678u = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.no_operation_record_text_frame);
        this.f15679v = (LinearLayout) C12809f.m76829b(this, R$id.nodata_image_frame);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.no_operation_record_text);
        this.f15680w = textView;
        textView.setText(getString(R$string.no_synchronous_recording_for_time, 30));
        this.f15681x = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_no_net);
        this.f15682y = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_unable_link_server);
        this.f15683z = (LinearLayout) C12809f.m76829b(this, R$id.layout_nonetwork);
        this.f15655A = (LinearLayout) C12809f.m76829b(this, R$id.layout_nodata);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f15656B = autoSizeButton;
        C11842p.m70874v1(this, autoSizeButton);
        this.f15656B.setOnClickListener(this);
        this.f15683z.setOnClickListener(this);
        this.f15655A.setOnClickListener(this);
        m21737D2();
    }

    /* renamed from: w2 */
    private boolean m21771w2(CBSSyncRecordOperation cBSSyncRecordOperation) {
        return TextUtils.isEmpty(cBSSyncRecordOperation.getOpDesc()) || (TextUtils.isEmpty(cBSSyncRecordOperation.getDevDisplayName()) && TextUtils.isEmpty(cBSSyncRecordOperation.getAliasName())) || TextUtils.isEmpty(cBSSyncRecordOperation.getLastUpdateTime());
    }

    /* renamed from: A2 */
    public void m21772A2() {
        this.f15659E = false;
        this.f15660F = false;
        this.f15668N = false;
        this.f15669O = false;
        this.f15665K = null;
        C12515a.m75110o().m75172d(new C3075q1(this.f15671Q, this.f15670P));
        m21773B2(this.f15665K);
    }

    /* renamed from: B2 */
    public final void m21773B2(String str) {
        if (this.f15659E || C0209d.m1333z1(this)) {
            C12515a.m75110o().m75172d(new C3036g2(this.f15672R, this.f15670P, str));
        } else {
            this.f15657C.setVisibility(8);
            m21776F2(8, 8, 0, 8);
        }
    }

    /* renamed from: C2 */
    public final void m21774C2(String str) {
        if (this.f15659E || C0209d.m1333z1(this)) {
            C12515a.m75110o().m75172d(new C3036g2(this.f15672R, this.f15670P, str, this.f15664J));
        } else {
            this.f15657C.setVisibility(8);
            m21776F2(8, 8, 0, 8);
        }
    }

    /* renamed from: E2 */
    public void m21775E2() {
        if (!C0209d.m1333z1(this)) {
            this.f15657C.setVisibility(8);
            m21776F2(8, 8, 0, 8);
        } else {
            this.f15657C.setVisibility(0);
            m21776F2(8, 8, 8, 8);
            m21772A2();
        }
    }

    /* renamed from: F2 */
    public final void m21776F2(int i10, int i11, int i12, int i13) {
        this.f15678u.setVisibility(i10);
        this.f15677t.setVisibility(i11);
        this.f15683z.setVisibility(i12);
        this.f15681x.setVisibility(i12);
        this.f15655A.setVisibility(i13);
        this.f15682y.setVisibility(i13);
    }

    /* renamed from: G2 */
    public final void m21777G2() throws IllegalAccessException, IllegalArgumentException {
        Resources resources;
        Context context = this.f15673p;
        if (context == null || (resources = context.getResources()) == null) {
            return;
        }
        if (this.f15667M == null) {
            if (TextUtils.isEmpty(this.f15662H)) {
                return;
            }
            String strM16093L = C2783d.m16093L(this.f15662H);
            if (TextUtils.isEmpty(strM16093L)) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f15673p);
            int i10 = R$plurals.operation_record_synchronizing_records;
            int i11 = this.f15666L;
            builder.setMessage(resources.getQuantityString(i10, i11, Integer.valueOf(i11), strM16093L)).setNeutralButton(resources.getString(R$string.cloudbackup_btn_ok_new), new DialogInterfaceOnClickListenerC3426e());
            AlertDialog alertDialogCreate = builder.create();
            this.f15667M = alertDialogCreate;
            C11829c.m70594l1(this, alertDialogCreate);
        }
        this.f15667M.show();
    }

    /* renamed from: H2 */
    public final void m21778H2() {
        this.f15658D.m24809i(false);
        this.f15658D.notifyDataSetChanged();
        if (this.f15659E) {
            return;
        }
        m21776F2(8, 8, 8, 0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: b1 */
    public C13230i mo18601b1() {
        return C13225d.m79490f1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15674q);
        arrayList.add(this.f15675r);
        arrayList.add(this.f15678u);
        arrayList.add(this.f15681x);
        arrayList.add(this.f15682y);
        arrayList.add(this.f15657C);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException {
        if (C0209d.m1308t0("icon2") == view.getId()) {
            m21777G2();
            return;
        }
        if (view.getId() == R$id.layout_nonetwork) {
            this.f15683z.setVisibility(8);
            this.f15681x.setVisibility(8);
            this.f15657C.setVisibility(0);
            m21783x2();
            return;
        }
        if (view.getId() != R$id.layout_nodata) {
            if (view.getId() == R$id.set_no_net_btn) {
                C11829c.m70612r1(this);
            }
        } else {
            this.f15655A.setVisibility(8);
            this.f15682y.setVisibility(8);
            this.f15657C.setVisibility(0);
            m21783x2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m21737D2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_operation_record_details);
        this.f15673p = this;
        m21770v2();
        m21769t2();
        mo19005p1();
        m21768s2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f15672R != null) {
            this.f15672R = null;
        }
        if (this.f15671Q != null) {
            this.f15671Q = null;
        }
        AlertDialog alertDialog = this.f15667M;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f15667M = null;
        }
        if (this.f15676s != null) {
            this.f15676s = null;
        }
    }

    /* renamed from: p2 */
    public final void m21779p2(List<CBSSyncRecordOperation> list) {
        String str;
        if (list == null) {
            C11839m.m70688i("OperationRecordDetailsActivity", "opRecordList is null");
            return;
        }
        Iterator<CBSSyncRecordOperation> it = list.iterator();
        while (it.hasNext()) {
            CBSSyncRecordOperation next = it.next();
            if (m21771w2(next)) {
                it.remove();
            } else {
                String lastUpdateTime = next.getLastUpdateTime();
                if (TextUtils.isEmpty(lastUpdateTime)) {
                    C11839m.m70688i("OperationRecordDetailsActivity", "lastUpdateTime is null");
                } else {
                    long jM69660b = C11667a.m69660b(lastUpdateTime, "yyyy-MM-dd'T'HH:mm:sszzz");
                    if (jM69660b == 0) {
                        if (lastUpdateTime.toLowerCase(Locale.ENGLISH).endsWith("z")) {
                            str = lastUpdateTime.substring(0, lastUpdateTime.length() - 1) + "+00:00";
                        } else {
                            str = "";
                        }
                        if (TextUtils.isEmpty(str)) {
                            next.setOperateTime(jM69660b);
                        } else {
                            next.setOperateTime(C11667a.m69660b(str, "yyyy-MM-dd'T'HH:mm:sszzz"));
                        }
                    } else {
                        next.setOperateTime(jM69660b);
                    }
                }
            }
        }
        this.f15663I = list;
    }

    /* renamed from: q2 */
    public final void m21780q2(ArrayList<String> arrayList) {
        List<CBSSyncRecordDeviceInfo> list = this.f15661G;
        Iterator<CBSSyncRecordDeviceInfo> it = list.iterator();
        while (it.hasNext()) {
            CBSSyncRecordDeviceInfo next = it.next();
            String devDisplayName = next.getDevDisplayName();
            if (TextUtils.isEmpty(devDisplayName)) {
                devDisplayName = next.getDeviceAliasName();
            }
            if (TextUtils.isEmpty(devDisplayName)) {
                it.remove();
            } else {
                arrayList.add(devDisplayName);
            }
        }
        this.f15661G = list;
    }

    /* renamed from: r2 */
    public void m21781r2(boolean z10, Drawable drawable) {
        if (C0209d.m1212T1()) {
            ActionBarEx.setEndIcon(getActionBar(), z10, drawable, this);
            ((ImageView) C12809f.m76829b(this, C0209d.m1308t0("icon2"))).setContentDescription(getString(R$string.pay_price_description));
        }
        m22365E1(R$string.synchronous_recording_actionbar);
    }

    /* renamed from: u2 */
    public void m21782u2() {
        List<CBSSyncRecordDeviceInfo> list = this.f15661G;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(getString(R$string.backup_all_equipment));
        m21780q2(arrayList);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R$layout.custom_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(R$layout.custom_hwspinner_dropdown_item);
        HwSpinner hwSpinner = this.f15676s;
        if (hwSpinner == null) {
            C11839m.m70687e("OperationRecordDetailsActivity", "mHwSpinner is null");
            return;
        }
        hwSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
        this.f15676s.setSelection(0, true);
        m21784y2();
        this.f15676s.post(new RunnableC3424c());
        this.f15669O = true;
        if (this.f15669O && this.f15668N) {
            this.f15675r.setVisibility(0);
        }
    }

    /* renamed from: x2 */
    public final void m21783x2() {
        NotchFitRelativeLayout notchFitRelativeLayout = this.f15675r;
        if (notchFitRelativeLayout == null || notchFitRelativeLayout.getVisibility() != 0) {
            m21775E2();
        } else if (this.f15660F) {
            m21774C2(this.f15665K);
        } else {
            m21773B2(this.f15665K);
        }
    }

    /* renamed from: y2 */
    public final void m21784y2() {
        HwSpinner hwSpinner = this.f15676s;
        if (hwSpinner == null) {
            C11839m.m70687e("OperationRecordDetailsActivity", "spinner is null");
            return;
        }
        View selectedView = hwSpinner.getSelectedView();
        if (selectedView == null) {
            C11839m.m70687e("OperationRecordDetailsActivity", "selectedView is null");
            return;
        }
        selectedView.measure(0, 0);
        int measuredWidth = selectedView.getMeasuredWidth();
        ViewGroup.LayoutParams layoutParams = this.f15676s.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (measuredWidth > 0) {
                layoutParams2.width = measuredWidth + this.f15676s.getPaddingStart() + this.f15676s.getPaddingEnd();
            }
            this.f15676s.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: z2 */
    public final void m21785z2() {
        this.f15658D.m24809i(false);
        this.f15658D.notifyDataSetChanged();
        if (this.f15659E) {
            return;
        }
        m21776F2(0, 8, 8, 8);
    }
}
