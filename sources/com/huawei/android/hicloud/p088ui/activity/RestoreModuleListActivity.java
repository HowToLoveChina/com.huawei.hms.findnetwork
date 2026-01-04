package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.util.RestoreAggregatedAppUtil;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiadapter.RestoreModuleListAdapter;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.secure.android.common.intent.SafeIntent;
import hu.C10343b;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import p514o9.C11839m;
import p514o9.C11842p;
import p618rm.C12590s0;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class RestoreModuleListActivity extends UIActivity implements AdapterView.OnItemClickListener {

    /* renamed from: p */
    public NotchTopFitRelativeLayout f15942p;

    /* renamed from: q */
    public ListView f15943q;

    /* renamed from: s */
    public RestoreModuleListAdapter f15945s;

    /* renamed from: t */
    public String f15946t;

    /* renamed from: u */
    public boolean f15947u;

    /* renamed from: v */
    public BottomSheetDialog f15948v;

    /* renamed from: r */
    public List<CloudRestoreItem> f15944r = new ArrayList();

    /* renamed from: w */
    public Handler.Callback f15949w = new C3464a();

    /* renamed from: com.huawei.android.hicloud.ui.activity.RestoreModuleListActivity$a */
    public class C3464a implements Handler.Callback {
        public C3464a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws Resources.NotFoundException {
            int i10 = message.what;
            if (i10 == 3205) {
                RestoreModuleListActivity.this.m22120T1(message);
                return false;
            }
            if (i10 == 32310) {
                RestoreModuleListActivity.this.m22119S1(message.getData());
                return false;
            }
            if (i10 != 33001) {
                return false;
            }
            RestoreModuleListActivity.this.m22121U1((String) message.obj);
            return false;
        }
    }

    /* renamed from: P1 */
    private void m22117P1() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Bundle extras;
        String str;
        CloudBackupService.getInstance().register(this.f15949w);
        Intent intent = getIntent();
        if (intent == null || (extras = new SafeIntent(intent).getExtras()) == null) {
            return;
        }
        C10343b c10343b = new C10343b(extras);
        this.f15946t = c10343b.m63694p("current_app_id");
        this.f15947u = c10343b.m63682d("isFromBaseView", false);
        this.f15944r.clear();
        this.f15944r.addAll(RestoreProgress.getStatusList(this.f15946t));
        Collections.sort(this.f15944r);
        ActionBar actionBar = getActionBar();
        if (actionBar != null && (str = this.f15946t) != null) {
            if ("sysdata".equals(str)) {
                actionBar.setTitle(getString(R$string.system_data));
            } else if ("thirdAppData".equals(this.f15946t)) {
                actionBar.setTitle(getString(R$string.frag_app_data_title));
                m22125W1();
            } else if ("thirdApp".equals(this.f15946t)) {
                actionBar.setTitle(getString(R$string.cloud_restore_applist));
            }
        }
        mo19982C1();
        if (!CBAccess.inRestoreTask()) {
            this.f15944r.sort(new C3710d8());
        }
        RestoreModuleListAdapter restoreModuleListAdapterMo19768O1 = mo19768O1();
        this.f15945s = restoreModuleListAdapterMo19768O1;
        restoreModuleListAdapterMo19768O1.m25174C(this.f15947u);
        this.f15945s.m25175D(this.f15944r);
        this.f15943q.setAdapter((ListAdapter) this.f15945s);
    }

    /* renamed from: Q1 */
    private void m22118Q1() {
        this.f15942p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        ListView listView = (ListView) C12809f.m76829b(this, R$id.restore_module_list);
        this.f15943q = listView;
        listView.setOnItemClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S1 */
    public void m22119S1(Bundle bundle) throws Resources.NotFoundException {
        Resources resources = getResources();
        if (bundle == null || resources == null) {
            C11839m.m70689w("RestoreModuleListActivity", "onOneModuleUpdate resources or bundle is null");
            return;
        }
        String string = bundle.getString("appId");
        CloudRestoreItem cloudRestoreItem = (CloudRestoreItem) bundle.getParcelable("item");
        if (string == null || cloudRestoreItem == null || this.f15944r == null || !cloudRestoreItem.getAppId().equals(this.f15946t)) {
            return;
        }
        Iterator<CloudRestoreItem> it = this.f15944r.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (string.equals(it.next().getAppId())) {
                m22122X1(i10, false);
            }
            i10++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T1 */
    public void m22120T1(Message message) {
        int i10 = message.arg1;
        C11839m.m70688i("RestoreModuleListActivity", "onRestoreStatusHandle status = " + i10);
        if (i10 == 1) {
            m22124V1();
            RestoreAggregatedAppUtil.dismissAggregatedAppsDetailDialog(this.f15948v);
        } else if (i10 != 0) {
            List<CloudRestoreItem> statusList = RestoreProgress.getStatusList(this.f15946t);
            this.f15944r = statusList;
            statusList.sort(new C3710d8());
            this.f15945s.m25175D(this.f15944r);
            this.f15945s.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U1 */
    public void m22121U1(String str) throws Resources.NotFoundException {
        List<CloudRestoreItem> list;
        if (str == null || (list = this.f15944r) == null) {
            return;
        }
        Iterator<CloudRestoreItem> it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (str.equals(it.next().getAppId())) {
                m22122X1(i10, true);
                return;
            }
            i10++;
        }
    }

    /* renamed from: X1 */
    private void m22122X1(int i10, boolean z10) throws Resources.NotFoundException {
        ListView listView = this.f15943q;
        if (listView == null) {
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int lastVisiblePosition = this.f15943q.getLastVisiblePosition();
        if (i10 < firstVisiblePosition || i10 > lastVisiblePosition) {
            return;
        }
        C11839m.m70686d("RestoreModuleListActivity", "refresh view, position = " + i10);
        View childAt = this.f15943q.getChildAt(i10 - firstVisiblePosition);
        if (z10) {
            this.f15945s.m25180I(childAt, i10);
        } else {
            this.f15945s.m25179H(childAt, i10);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: C1 */
    public void mo19982C1() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            int i10 = R$color.hicloud_hmos_bg;
            C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
            actionBar.setBackgroundDrawable(new ColorDrawable(getColor(i10)));
            Window window = getWindow();
            if (window != null) {
                window.setStatusBarColor(getColor(i10));
            }
        }
    }

    /* renamed from: O1 */
    public RestoreModuleListAdapter mo19768O1() {
        return new RestoreModuleListAdapter(this);
    }

    /* renamed from: R1 */
    public final boolean m22123R1(CloudRestoreItem cloudRestoreItem) {
        return "thirdApp".equals(cloudRestoreItem.getAppId()) || "appList".equals(cloudRestoreItem.getAppId());
    }

    /* renamed from: V1 */
    public final void m22124V1() {
        if (this.f15945s == null) {
            C11839m.m70689w("RestoreModuleListActivity", "refreshModuleList adapter is null");
            return;
        }
        List<CloudRestoreItem> statusList = RestoreProgress.getStatusList(this.f15946t);
        this.f15944r = statusList;
        this.f15945s.m25175D(statusList);
        this.f15945s.notifyDataSetChanged();
    }

    /* renamed from: W1 */
    public final void m22125W1() {
        Iterator<CloudRestoreItem> it = this.f15944r.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().isUnSupport()) {
                i10++;
            }
        }
        String strM80987x0 = C13452e.m80781L().m80987x0();
        if (TextUtils.isEmpty(strM80987x0)) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("userType", strM80987x0);
        linkedHashMapM79499C.put("gradeCode", C12590s0.m75747G0());
        linkedHashMapM79499C.put("deviceId", C13452e.m80781L().m80954p());
        linkedHashMapM79499C.put("blackNum", String.valueOf(i10));
        C11839m.m70688i("RestoreModuleListActivity", "report black app num");
        C13225d.m79490f1().m79567R("cloudbackup_restore_thirdapp", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "cloudbackup_restore_thirdapp", "1", "9", linkedHashMapM79499C);
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
        arrayList.add(this.f15942p);
        return arrayList;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.restore_module_list);
        m22118Q1();
        mo19005p1();
        m22117P1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f15949w != null) {
            CloudBackupService.getInstance().unregister(this.f15949w);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) throws IllegalAccessException, IllegalArgumentException {
        CloudRestoreItem cloudRestoreItem = (CloudRestoreItem) this.f15945s.getItem(i10);
        if (cloudRestoreItem == null) {
            return;
        }
        boolean z10 = false;
        boolean z11 = this.f15947u && cloudRestoreItem.getCurrent() < cloudRestoreItem.getCount() && cloudRestoreItem.isShowChildList();
        if (!this.f15947u && cloudRestoreItem.isShowChildList()) {
            z10 = true;
        }
        if (z11 || z10) {
            Intent intent = new Intent(this, (Class<?>) CloudRestoreApkListActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("current_app_id", cloudRestoreItem.getAppId());
            intent.putExtras(bundle);
            startActivity(intent);
            return;
        }
        if (m22123R1(cloudRestoreItem) || !RestoreAggregatedAppUtil.isShowAggregatedDialog(cloudRestoreItem)) {
            return;
        }
        BottomSheetDialog bottomSheetDialogBuildAggregatedAppsDetailDialog = RestoreAggregatedAppUtil.buildAggregatedAppsDetailDialog(this, cloudRestoreItem);
        this.f15948v = bottomSheetDialogBuildAggregatedAppsDetailDialog;
        if (bottomSheetDialogBuildAggregatedAppsDetailDialog != null) {
            bottomSheetDialogBuildAggregatedAppsDetailDialog.show();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 == menuItem.getItemId()) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        finish();
        return true;
    }
}
