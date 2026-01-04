package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiadapter.SmartClearAppAdapter;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.p103ui.uiextend.ScrollDisabledListView;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0223k;
import p015ak.C0226l0;
import p344hp.C10332a;
import p344hp.C10333b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p684un.C13227f;
import p709vj.C13452e;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class SmartClearAppActivity extends UIActivity implements View.OnClickListener, SmartClearAppAdapter.CheckedCallback {

    /* renamed from: A */
    public NotchFitLinearLayout f16009A;

    /* renamed from: B */
    public TextView f16010B;

    /* renamed from: C */
    public ImageView f16011C;

    /* renamed from: E */
    public NotchFitRelativeLayout f16013E;

    /* renamed from: F */
    public ScrollDisabledListView f16014F;

    /* renamed from: G */
    public CheckBox f16015G;

    /* renamed from: H */
    public LinearLayout f16016H;

    /* renamed from: I */
    public LinearLayout f16017I;

    /* renamed from: J */
    public AutoSizeButton f16018J;

    /* renamed from: K */
    public SmartClearAppAdapter f16019K;

    /* renamed from: L */
    public SmartClearAppAdapter f16020L;

    /* renamed from: P */
    public long f16024P;

    /* renamed from: p */
    public NotchTopFitRelativeLayout f16025p;

    /* renamed from: q */
    public NotchFitRelativeLayout f16026q;

    /* renamed from: r */
    public NotchFitLinearLayout f16027r;

    /* renamed from: s */
    public TextView f16028s;

    /* renamed from: t */
    public ImageView f16029t;

    /* renamed from: v */
    public NotchFitRelativeLayout f16031v;

    /* renamed from: w */
    public ScrollDisabledListView f16032w;

    /* renamed from: x */
    public CheckBox f16033x;

    /* renamed from: y */
    public LinearLayout f16034y;

    /* renamed from: z */
    public LinearLayout f16035z;

    /* renamed from: u */
    public boolean f16030u = true;

    /* renamed from: D */
    public boolean f16012D = true;

    /* renamed from: M */
    public ArrayList<String> f16021M = new ArrayList<>();

    /* renamed from: N */
    public BroadcastReceiver f16022N = null;

    /* renamed from: O */
    public boolean f16023O = false;

    /* renamed from: com.huawei.android.hicloud.ui.activity.SmartClearAppActivity$a */
    public class C3477a extends BroadcastReceiver {
        public C3477a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C11839m.m70688i("SmartClearAppActivity", "PackagesReceiver intent is null");
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            if ("android.intent.action.PACKAGE_REMOVED".equals(safeIntent.getAction())) {
                if (safeIntent.getData() == null) {
                    C11839m.m70688i("SmartClearAppActivity", "PackagesReceiver data is null");
                    return;
                }
                String schemeSpecificPart = safeIntent.getData().getSchemeSpecificPart();
                if (TextUtils.isEmpty(schemeSpecificPart)) {
                    C11839m.m70688i("SmartClearAppActivity", "PackagesReceiver packageName is null");
                    return;
                }
                C11839m.m70686d("SmartClearAppActivity", "receiver removeItemByAppName: " + schemeSpecificPart);
                SmartClearAppActivity.this.f16019K.m25205f(schemeSpecificPart);
                SmartClearAppActivity.this.f16020L.m25205f(schemeSpecificPart);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SmartClearAppActivity$b */
    public class C3478b extends AbstractC12367d {
        public C3478b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70688i("SmartClearAppActivity", "SmartClearAppQueryTask start");
            List<C10332a> listM63640k = C10333b.m63630c().m63640k();
            final ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            for (C10332a c10332a : listM63640k) {
                if (c10332a != null) {
                    c10332a.m63626w(false);
                    if (c10332a.m63621r()) {
                        arrayList2.add(c10332a);
                    } else {
                        arrayList.add(c10332a);
                    }
                }
            }
            Collections.sort(arrayList);
            Collections.sort(arrayList2);
            C11839m.m70688i("SmartClearAppActivity", "unusedList: " + arrayList.size() + ", invalidList: " + arrayList2.size());
            C0226l0.m1585e(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.o8
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    this.f17694a.m22192d(arrayList, arrayList2);
                }
            }, 500L);
        }

        /* renamed from: d */
        public final /* synthetic */ void m22192d(List list, List list2) throws Resources.NotFoundException {
            SmartClearAppActivity.this.f16019K.m25212m(list);
            SmartClearAppActivity.this.f16032w.setAdapter((ListAdapter) SmartClearAppActivity.this.f16019K);
            SmartClearAppActivity.this.f16020L.m25212m(list2);
            SmartClearAppActivity.this.f16014F.setAdapter((ListAdapter) SmartClearAppActivity.this.f16020L);
            SmartClearAppActivity.this.m22187i2();
            SmartClearAppActivity.this.m22186h2();
            SmartClearAppActivity.this.f16035z.setVisibility(8);
            SmartClearAppActivity.this.m22189k2();
            SmartClearAppActivity.this.f16017I.setVisibility(8);
            SmartClearAppActivity.this.m22188j2();
            SmartClearAppActivity.this.m22184e2();
            SmartClearAppActivity.this.f16023O = true;
            C11839m.m70688i("SmartClearAppActivity", "SmartClearAppQueryTask end");
        }
    }

    /* renamed from: B1 */
    private void m22160B1() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R$string.smart_clear_app_title);
            int i10 = R$color.hicloud_hmos_bg;
            C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
            actionBar.setBackgroundDrawable(new ColorDrawable(getColor(i10)));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        getWindow().setStatusBarColor(getColor(R$color.hicloud_hmos_bg));
    }

    /* renamed from: Z1 */
    private void m22175Z1() {
        long jM25202c = this.f16019K.m25202c() + this.f16020L.m25202c();
        this.f16018J.setEnabled(jM25202c != 0);
        this.f16018J.setText(getResources().getString(R$string.smart_clear_app_button_tip, C0223k.m1524g(this, jM25202c)));
    }

    /* renamed from: a2 */
    private void m22176a2() {
        this.f16025p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.sca_main_layout);
        this.f16026q = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.sca_tip_layout);
        this.f16027r = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.sca_unused_title);
        this.f16028s = (TextView) C12809f.m76829b(this, R$id.sca_unused_sub_title_down);
        ImageView imageView = (ImageView) C12809f.m76829b(this, R$id.sca_unused_expand);
        this.f16029t = imageView;
        imageView.setOnClickListener(this);
        this.f16031v = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.sca_unused_layout);
        this.f16032w = (ScrollDisabledListView) C12809f.m76829b(this, R$id.sca_unused_list);
        LayoutInflater layoutInflater = getLayoutInflater();
        int i10 = R$layout.smart_clear_app_list_head_view;
        View viewInflate = layoutInflater.inflate(i10, (ViewGroup) this.f16032w, false);
        int i11 = R$id.sca_check_all;
        CheckBox checkBox = (CheckBox) C12809f.m76831d(viewInflate, i11);
        this.f16033x = checkBox;
        checkBox.setChecked(false);
        this.f16033x.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.m8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                this.f17678a.m22178c2(view);
            }
        });
        this.f16032w.addHeaderView(viewInflate);
        this.f16034y = (LinearLayout) C12809f.m76829b(this, R$id.sca_unused_no_data);
        this.f16035z = (LinearLayout) C12809f.m76829b(this, R$id.sca_unused_loading_progress);
        this.f16009A = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.sca_invalid_title);
        this.f16010B = (TextView) C12809f.m76829b(this, R$id.sca_invalid_sub_title_down);
        ImageView imageView2 = (ImageView) C12809f.m76829b(this, R$id.sca_invalid_expand);
        this.f16011C = imageView2;
        imageView2.setOnClickListener(this);
        this.f16013E = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.sca_invalid_layout);
        this.f16014F = (ScrollDisabledListView) C12809f.m76829b(this, R$id.sca_invalid_list);
        View viewInflate2 = getLayoutInflater().inflate(i10, (ViewGroup) this.f16014F, false);
        CheckBox checkBox2 = (CheckBox) C12809f.m76831d(viewInflate2, i11);
        this.f16015G = checkBox2;
        checkBox2.setChecked(false);
        this.f16015G.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.n8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                this.f17684a.m22179d2(view);
            }
        });
        this.f16014F.addHeaderView(viewInflate2);
        this.f16016H = (LinearLayout) C12809f.m76829b(this, R$id.sca_invalid_no_data);
        this.f16017I = (LinearLayout) C12809f.m76829b(this, R$id.sca_invalid_loading_progress);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.sca_uninstall_button);
        this.f16018J = autoSizeButton;
        autoSizeButton.setOnClickListener(this);
        C11842p.m70866t1(this, this.f16018J);
        this.f16019K = new SmartClearAppAdapter(this, this, true);
        this.f16020L = new SmartClearAppAdapter(this, this, false);
        this.f16029t.setVisibility(8);
        this.f16009A.setVisibility(8);
        this.f16013E.setVisibility(8);
    }

    /* renamed from: b2 */
    private boolean m22177b2() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z10 = jCurrentTimeMillis - this.f16024P <= 1000;
        this.f16024P = jCurrentTimeMillis;
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c2 */
    public /* synthetic */ void m22178c2(View view) throws Resources.NotFoundException {
        this.f16019K.m25206g(this.f16033x.isChecked());
        this.f16019K.notifyDataSetChanged();
        m22175Z1();
        m22187i2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d2 */
    public /* synthetic */ void m22179d2(View view) throws Resources.NotFoundException {
        this.f16020L.m25206g(this.f16015G.isChecked());
        this.f16020L.notifyDataSetChanged();
        m22175Z1();
        m22186h2();
    }

    /* renamed from: f2 */
    private void m22180f2() {
        C13227f.m79492i1().m79585f0("mecloud_smart_clear_app_clear", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_smart_clear_app_clear", "1", "80");
    }

    /* renamed from: m2 */
    private void m22181m2() {
        BroadcastReceiver broadcastReceiver = this.f16022N;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.SmartClearAppAdapter.CheckedCallback
    /* renamed from: G */
    public void mo22182G(boolean z10, boolean z11) {
        if (z11) {
            this.f16033x.setChecked(z10);
        } else {
            this.f16015G.setChecked(z10);
        }
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.SmartClearAppAdapter.CheckedCallback
    /* renamed from: Z */
    public void mo22183Z(boolean z10) throws Resources.NotFoundException {
        m22175Z1();
        if (z10) {
            m22187i2();
        } else {
            m22186h2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f16025p);
        arrayList.add(this.f16026q);
        arrayList.add(this.f16027r);
        arrayList.add(this.f16031v);
        arrayList.add(this.f16009A);
        arrayList.add(this.f16013E);
        return arrayList;
    }

    /* renamed from: e2 */
    public final void m22184e2() {
        if (this.f16022N == null) {
            this.f16022N = new C3477a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            registerReceiver(this.f16022N, intentFilter);
        }
    }

    /* renamed from: g2 */
    public final void m22185g2(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("reportType", str);
        C13227f.m79492i1().m79591l0("mecloud_smart_clear_batch_uninstall", linkedHashMap);
        UBAAnalyze.m29958S("PVC", "mecloud_smart_clear_batch_uninstall", "1", "80", linkedHashMap);
    }

    /* renamed from: h2 */
    public final void m22186h2() throws Resources.NotFoundException {
        NumberFormat numberFormat = NumberFormat.getInstance();
        this.f16010B.setText(getResources().getString(R$string.smart_clear_app_count, getResources().getString(R$string.cloudbackup_backupmedia_tip, numberFormat.format(this.f16020L.m25201b()), numberFormat.format(this.f16020L.m25203d().size())), C0223k.m1524g(this, this.f16020L.m25202c())));
    }

    /* renamed from: i2 */
    public final void m22187i2() throws Resources.NotFoundException {
        NumberFormat numberFormat = NumberFormat.getInstance();
        this.f16028s.setText(getResources().getString(R$string.smart_clear_app_count, getResources().getString(R$string.cloudbackup_backupmedia_tip, numberFormat.format(this.f16019K.m25201b()), numberFormat.format(this.f16019K.m25203d().size())), C0223k.m1524g(this, this.f16019K.m25202c())));
    }

    /* renamed from: j2 */
    public final void m22188j2() {
        if (this.f16020L.m25203d().isEmpty()) {
            this.f16014F.setVisibility(8);
            this.f16016H.setVisibility(0);
        } else {
            this.f16014F.setVisibility(0);
            this.f16016H.setVisibility(8);
        }
    }

    /* renamed from: k2 */
    public final void m22189k2() {
        if (this.f16019K.m25203d().isEmpty()) {
            this.f16032w.setVisibility(8);
            this.f16034y.setVisibility(0);
        } else {
            this.f16032w.setVisibility(0);
            this.f16034y.setVisibility(8);
        }
    }

    /* renamed from: l2 */
    public final void m22190l2() {
        C11839m.m70688i("SmartClearAppActivity", "startBatchUninstall");
        this.f16021M.clear();
        for (C10332a c10332a : this.f16019K.m25203d()) {
            if (c10332a.m63620q()) {
                this.f16021M.add(c10332a.m63615f());
            }
        }
        for (C10332a c10332a2 : this.f16020L.m25203d()) {
            if (c10332a2.m63620q()) {
                this.f16021M.add(c10332a2.m63615f());
            }
        }
        C11839m.m70688i("SmartClearAppActivity", "uninstallPackages: " + this.f16021M.size());
        if (this.f16021M.isEmpty()) {
            return;
        }
        try {
            String[] strArr = (String[]) this.f16021M.toArray(new String[0]);
            Intent intent = new Intent("com.android.packageinstaller.intent.action.DELETE_PACKAGES");
            intent.putExtra("com.android.packageinstaller.extra.EXTRA_REQUEST_UNINSTALL_PKGS", strArr);
            C0209d.m1302r2(intent, Constants.SYSTEM_PKG_INSTALLER);
            startActivityForResult(intent, 10000);
            m22185g2("uninstallBegin");
        } catch (Exception e10) {
            C11839m.m70687e("SmartClearAppActivity", "startBatchUninstall error: " + e10.toString());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        C11839m.m70688i("SmartClearAppActivity", "onActivityResult requestCode: " + i10 + ", resultCode:" + i11);
        super.onActivityResult(i10, i11, intent);
        if (10000 == i10) {
            if (i11 != -1 || intent == null) {
                C11839m.m70687e("SmartClearAppActivity", "uninstallPackagesResult error: " + i11);
                m22185g2("uninstallCancel");
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            String[] stringArrayExtra = safeIntent.getStringArrayExtra("com.android.packageinstaller.extra.EXTRA_RESULT_UNINSTALL_PKGS");
            int[] intArrayExtra = safeIntent.getIntArrayExtra("com.android.packageinstaller.extra.EXTRA_RESULT_UNINSTALL_RESULT");
            if (stringArrayExtra == null || stringArrayExtra.length == 0) {
                C11839m.m70687e("SmartClearAppActivity", "stringArrayPackages error");
                return;
            }
            if (intArrayExtra == null || intArrayExtra.length == 0) {
                C11839m.m70687e("SmartClearAppActivity", "intArrayResult error");
                return;
            }
            if (stringArrayExtra.length != intArrayExtra.length) {
                C11839m.m70687e("SmartClearAppActivity", "result length error");
                return;
            }
            for (int i12 = 0; i12 < stringArrayExtra.length; i12++) {
                C11839m.m70686d("SmartClearAppActivity", "uninstall result: " + stringArrayExtra[i12] + ", success: " + (intArrayExtra[i12] == 0));
            }
            Iterator<String> it = this.f16021M.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    C11839m.m70686d("SmartClearAppActivity", "result removeItemByAppName: " + next);
                    this.f16019K.m25205f(next);
                    this.f16020L.m25205f(next);
                }
            }
            m22185g2("uninstallFinish");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (R$id.sca_unused_expand == id2) {
            if (this.f16030u) {
                this.f16030u = false;
                this.f16031v.setVisibility(8);
                this.f16029t.setImageDrawable(getDrawable(R$drawable.manage_data_list_expand));
                return;
            } else {
                this.f16030u = true;
                this.f16031v.setVisibility(0);
                this.f16029t.setImageDrawable(getDrawable(R$drawable.manage_data_list_retract));
                return;
            }
        }
        if (R$id.sca_invalid_expand != id2) {
            if (R$id.sca_uninstall_button != id2) {
                finish();
                return;
            } else if (m22177b2()) {
                C11839m.m70689w("SmartClearAppActivity", "click too fast");
                return;
            } else {
                m22190l2();
                return;
            }
        }
        if (this.f16012D) {
            this.f16012D = false;
            this.f16013E.setVisibility(8);
            this.f16011C.setImageDrawable(getDrawable(R$drawable.manage_data_list_expand));
        } else {
            this.f16012D = true;
            this.f16013E.setVisibility(0);
            this.f16011C.setImageDrawable(getDrawable(R$drawable.manage_data_list_retract));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70866t1(this, this.f16018J);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("SmartClearAppActivity", "onCreate");
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        m22160B1();
        C11829c.m70609q1(this, getWindow());
        setContentView(R$layout.smart_clear_app_layout);
        m22176a2();
        this.f16018J.setEnabled(false);
        this.f16018J.setText(getResources().getString(R$string.smart_clear_app_button_tip, C0223k.m1524g(this, 0L)));
        mo19005p1();
        C12515a.m75110o().m75175e(new C3478b(), false);
        m22180f2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C11839m.m70688i("SmartClearAppActivity", "onDestroy");
        super.onDestroy();
        m22181m2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() throws Resources.NotFoundException {
        C11839m.m70688i("SmartClearAppActivity", "onResume");
        super.onResume();
        if (this.f16023O) {
            m22189k2();
            m22188j2();
            m22175Z1();
            m22187i2();
            m22186h2();
            this.f16019K.notifyDataSetChanged();
            this.f16020L.notifyDataSetChanged();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        finish();
        return true;
    }
}
