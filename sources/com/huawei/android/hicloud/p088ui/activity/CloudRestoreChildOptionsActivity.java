package com.huawei.android.hicloud.p088ui.activity;

import ae.C0171u0;
import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.model.RestoreCache;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.progress.C2661b;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.p103ui.uiextend.SidePaddingRelativeLayout;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwalphaindexerlistview.widget.HwAlphaIndexerListView;
import com.huawei.uikit.phone.hwalphaindexerlistview.widget.HwAlphaIndexerListView;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import hu.C10343b;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import p015ak.C0209d;
import p514o9.C11839m;
import p514o9.C11842p;
import p618rm.C12580p;
import p684un.C13225d;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudRestoreChildOptionsActivity extends CloudBaseRestoreOptionsActivity implements View.OnClickListener, AdapterView.OnItemClickListener, View.OnTouchListener {

    /* renamed from: L */
    public NotchFitLinearLayout f14312L;

    /* renamed from: M */
    public LinearLayout f14313M;

    /* renamed from: N */
    public TextView f14314N;

    /* renamed from: O */
    public ListView f14315O;

    /* renamed from: P */
    public NotchTopFitRelativeLayout f14316P;

    /* renamed from: Q */
    public NotchFitLinearLayout f14317Q;

    /* renamed from: R */
    public CheckBox f14318R;

    /* renamed from: S */
    public C0171u0 f14319S;

    /* renamed from: T */
    public HwAlphaIndexerListView f14320T;

    /* renamed from: U */
    public SidePaddingRelativeLayout f14321U;

    /* renamed from: V */
    public CloudRestoreItem f14322V;

    /* renamed from: W */
    public String f14323W;

    /* renamed from: X */
    public TextView f14324X;

    /* renamed from: Y */
    public RelativeLayout f14325Y;

    /* renamed from: Z */
    public Handler f14326Z = new Handler(new C3223a());

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudRestoreChildOptionsActivity$a */
    public class C3223a implements Handler.Callback {
        public C3223a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws Resources.NotFoundException {
            C11839m.m70688i("CloudRestoreChildOptionsActivity", "msg " + message.what);
            int i10 = message.what;
            if (i10 == 330001) {
                if (CloudRestoreChildOptionsActivity.this.f14315O == null || CloudRestoreChildOptionsActivity.this.f14320T == null) {
                    C11839m.m70687e("CloudRestoreChildOptionsActivity", "CALLBACK_ALPHA_VIEW，view is null");
                    return false;
                }
                Object obj = message.obj;
                if (obj instanceof List) {
                    CloudRestoreChildOptionsActivity.this.m19791F2();
                    CloudRestoreChildOptionsActivity.this.f14319S.m923u(CloudRestoreChildOptionsActivity.this.m19783m2((List) obj));
                }
            } else if (i10 == 330000) {
                CloudRestoreChildOptionsActivity.this.m19792H2();
            }
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudRestoreChildOptionsActivity$b */
    public class C3224b implements AbsListView.OnScrollListener {
        public C3224b() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) throws Resources.NotFoundException {
            String[] strArrM19784o2 = CloudRestoreChildOptionsActivity.this.m19784o2();
            if (CloudRestoreChildOptionsActivity.this.f14319S == null || strArrM19784o2 == null || strArrM19784o2.length == 0) {
                return;
            }
            CloudRestoreChildOptionsActivity.this.f14320T.invalidate();
            int iM918o = CloudRestoreChildOptionsActivity.this.f14319S.m918o(i10);
            if (iM918o == -1 || iM918o >= strArrM19784o2.length) {
                return;
            }
            CloudRestoreChildOptionsActivity.this.f14320T.setOverLayInfo((String) CloudRestoreChildOptionsActivity.this.f14319S.m920q()[iM918o]);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (CloudRestoreChildOptionsActivity.this.f14319S == null || CloudRestoreChildOptionsActivity.this.f14319S.m920q() == null || CloudRestoreChildOptionsActivity.this.f14315O == null) {
                return;
            }
            if (i10 == 0) {
                CloudRestoreChildOptionsActivity.this.f14320T.dismissPopup();
            } else {
                if (i10 != 1) {
                    return;
                }
                CloudRestoreChildOptionsActivity.this.f14315O.clearFocus();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudRestoreChildOptionsActivity$c */
    public class C3225c implements HwAlphaIndexerListView.OnItemClickListener {

        /* renamed from: a */
        public final /* synthetic */ ListView f14329a;

        public C3225c(ListView listView) {
            this.f14329a = listView;
        }

        @Override // com.huawei.uikit.hwalphaindexerlistview.widget.HwAlphaIndexerListView.OnItemClickListener
        public void onItemClick(String str, int i10) throws Resources.NotFoundException {
            String[] strArrM19784o2;
            String str2;
            if (str == null || (strArrM19784o2 = CloudRestoreChildOptionsActivity.this.m19784o2()) == null || strArrM19784o2.length == 0 || this.f14329a.getCount() == 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                if (i11 >= strArrM19784o2.length) {
                    str2 = null;
                    i11 = i10;
                    break;
                } else {
                    if (CloudRestoreChildOptionsActivity.this.f14320T.equalsChar(str, strArrM19784o2[i11], i10)) {
                        str2 = strArrM19784o2[i11];
                        break;
                    }
                    i11++;
                }
            }
            if (str2 == null) {
                if (CloudRestoreChildOptionsActivity.this.f14320T.needSwitchIndexer(i10)) {
                    if (CloudRestoreChildOptionsActivity.this.f14320T.isNativeIndexerShow()) {
                        this.f14329a.setSelection(r6.getCount() - 1);
                    } else {
                        this.f14329a.setSelection(0);
                    }
                }
                CloudRestoreChildOptionsActivity.this.m19772G2(i10, this.f14329a);
                return;
            }
            CloudRestoreChildOptionsActivity.this.f14320T.showPopup(str2);
            int iM917n = CloudRestoreChildOptionsActivity.this.f14319S.m917n(i11);
            if (iM917n >= 0 && iM917n < this.f14329a.getCount()) {
                this.f14329a.setSelection(iM917n);
            }
            int lastVisiblePosition = (this.f14329a.getLastVisiblePosition() - this.f14329a.getFirstVisiblePosition()) + 1;
            if (iM917n + lastVisiblePosition > CloudRestoreChildOptionsActivity.this.f14319S.getCount()) {
                str2 = (String) CloudRestoreChildOptionsActivity.this.f14319S.m919p(this.f14329a.getCount() - lastVisiblePosition);
            }
            CloudRestoreChildOptionsActivity.this.f14320T.setOverLayInfo(i10, str2);
        }
    }

    /* renamed from: A2 */
    private void m19769A2() {
        List<CloudRestoreItem> listM29202r;
        CloudRestoreItem cloudRestoreItem = this.f14322V;
        if (cloudRestoreItem == null || (listM29202r = cloudRestoreItem.m29202r()) == null || listM29202r.isEmpty()) {
            return;
        }
        boolean zAnyMatch = listM29202r.stream().anyMatch(new C2661b());
        this.f14318R.setEnabled(zAnyMatch);
        this.f14318R.setAlpha((float) (!zAnyMatch ? 0.4d : 1.0d));
        boolean z10 = true;
        boolean z11 = true;
        boolean z12 = false;
        for (CloudRestoreItem cloudRestoreItem2 : listM29202r) {
            if (cloudRestoreItem2.isCompatible()) {
                z11 = cloudRestoreItem2.getAction() == 0 && z11;
                z12 = cloudRestoreItem2.getAction() != 2 || z12;
                z10 = false;
            }
        }
        if (z10) {
            this.f14318R.setEnabled(false);
            z11 = false;
        }
        if (z11) {
            this.f14322V.setAction(0);
        } else {
            this.f14322V.setAction(z12 ? 1 : 2);
        }
        this.f14322V.m29182J0();
        this.f14318R.setChecked(z11);
    }

    /* renamed from: D2 */
    private void m19770D2(ListView listView) {
        this.f14320T.setOnItemClickListener(new C3225c(listView));
    }

    /* renamed from: E2 */
    private void m19771E2(ListView listView) {
        listView.setOnScrollListener(new C3224b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G2 */
    public void m19772G2(int i10, ListView listView) throws Resources.NotFoundException {
        C11839m.m70686d("CloudRestoreChildOptionsActivity", "setOverLayInfoWhenNoMatchItem");
        this.f14320T.setOverLayInfo(i10, (String) this.f14319S.m919p(listView.getFirstVisiblePosition()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m2 */
    public List<CloudRestoreItem> m19783m2(List<CloudRestoreItem> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list);
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            CloudRestoreItem cloudRestoreItem = (CloudRestoreItem) it.next();
            if (SplitAppUtil.isTwinApp(cloudRestoreItem.getSplitApkType(), cloudRestoreItem.getOriBackupAppName())) {
                List arrayList2 = map.get(cloudRestoreItem.getOriBackupAppName()) != null ? (List) map.get(cloudRestoreItem.getOriBackupAppName()) : new ArrayList();
                if (arrayList2 != null) {
                    arrayList2.add(cloudRestoreItem);
                    map.put(cloudRestoreItem.getOriBackupAppName(), arrayList2);
                }
                it.remove();
            }
        }
        if (!map.isEmpty()) {
            for (final String str : map.keySet()) {
                Optional optionalFindFirst = arrayList.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.g3
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return CloudRestoreChildOptionsActivity.m19785u2(str, (CloudRestoreItem) obj);
                    }
                }).findFirst();
                if (optionalFindFirst.isPresent()) {
                    CloudRestoreItem cloudRestoreItem2 = (CloudRestoreItem) optionalFindFirst.get();
                    List<CloudRestoreItem> list2 = (List) map.get(str);
                    if (list2 != null) {
                        list2.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.h3
                            @Override // java.util.Comparator
                            public final int compare(Object obj, Object obj2) {
                                return CloudRestoreChildOptionsActivity.m19786v2((CloudRestoreItem) obj, (CloudRestoreItem) obj2);
                            }
                        });
                        cloudRestoreItem2.m29177E0(list2);
                        list.removeAll(list2);
                        list.addAll(list.indexOf(cloudRestoreItem2) + 1, list2);
                    }
                }
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o2 */
    public String[] m19784o2() {
        try {
            return (String[]) this.f14319S.m920q();
        } catch (ClassCastException e10) {
            C11839m.m70687e("CloudRestoreChildOptionsActivity", "ClassCastException e: " + e10.toString());
            return null;
        }
    }

    /* renamed from: u2 */
    public static /* synthetic */ boolean m19785u2(String str, CloudRestoreItem cloudRestoreItem) {
        return str.equalsIgnoreCase(cloudRestoreItem.getAppId());
    }

    /* renamed from: v2 */
    public static /* synthetic */ int m19786v2(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
        return C12580p.m75586t(cloudRestoreItem.getAppId(), cloudRestoreItem2.getAppId());
    }

    /* renamed from: y2 */
    private void m19788y2() throws Resources.NotFoundException {
        int i10 = this.f14318R.isChecked() ? 0 : 2;
        CloudRestoreItem cloudRestoreItem = this.f14322V;
        if (cloudRestoreItem == null) {
            return;
        }
        m19794J2(cloudRestoreItem, i10);
        List<CloudRestoreItem> listM29202r = this.f14322V.m29202r();
        if (listM29202r != null && !listM29202r.isEmpty()) {
            for (int i11 = 0; i11 < listM29202r.size(); i11++) {
                m19796L2(i11, false);
            }
        }
        m19789B2(this.f14318R.isChecked());
    }

    /* renamed from: B2 */
    public void m19789B2(boolean z10) {
        LinkedHashMap linkedHashMapM19630V1 = m19630V1(z10);
        linkedHashMapM19630V1.put("appId", this.f14323W);
        C13225d.m79490f1().m79591l0("cloudbackup_restore_second_all", linkedHashMapM19630V1);
        UBAAnalyze.m29947H("CKC", "cloudbackup_restore_second_all", linkedHashMapM19630V1);
    }

    /* renamed from: C2 */
    public void m19790C2(String str, boolean z10) {
        LinkedHashMap linkedHashMapM19630V1 = m19630V1(z10);
        linkedHashMapM19630V1.put("appId", str);
        C13225d.m79490f1().m79591l0("cloudbackup_restore_second_module", linkedHashMapM19630V1);
        UBAAnalyze.m29947H("CKC", "cloudbackup_restore_second_module", linkedHashMapM19630V1);
    }

    /* renamed from: F2 */
    public void m19791F2() throws Resources.NotFoundException {
        this.f14315O.setFastScrollEnabled(false);
        this.f14315O.setVerticalScrollBarEnabled(false);
        this.f14320T.setListViewAttachTo(this.f14315O);
        this.f14320T.setOverLayInfo((String) this.f14319S.m920q()[this.f14319S.m918o(this.f14315O.getFirstVisiblePosition())]);
        m19771E2(this.f14315O);
        m19770D2(this.f14315O);
    }

    /* renamed from: H2 */
    public final void m19792H2() {
        CloudRestoreItem item = RestoreCache.getInstance().getItem(this.f14323W);
        this.f14322V = item;
        if (item == null) {
            return;
        }
        m19769A2();
        List<CloudRestoreItem> listM29202r = this.f14322V.m29202r();
        if (listM29202r != null && !listM29202r.isEmpty() && "sysdata".equals(this.f14323W)) {
            listM29202r.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.i3
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C12580p.m75580n((CloudRestoreItem) obj, (CloudRestoreItem) obj2);
                }
            });
            listM29202r.sort(new C12580p.a());
            m19633Z1(listM29202r);
        }
        this.f13886q.setVisibility(8);
        this.f14312L.setVisibility(0);
        C0171u0 c0171u0 = new C0171u0(this, this.f14326Z, this.f14323W, listM29202r);
        this.f14319S = c0171u0;
        c0171u0.m924v(this);
        this.f14319S.m925w(this);
        this.f14315O.setAdapter((ListAdapter) this.f14319S);
        if ("thirdAppData".equals(this.f14323W)) {
            this.f14324X.setVisibility(0);
            this.f14324X.setText(R$string.backup_application_tip);
        }
    }

    /* renamed from: I2 */
    public final void m19793I2(CloudRestoreItem cloudRestoreItem, int i10) {
        ArrayList<CloudRestoreItem> itemList;
        if (cloudRestoreItem == null || i10 == 0 || (itemList = RestoreCache.getInstance().getItemList()) == null || itemList.isEmpty()) {
            return;
        }
        for (CloudRestoreItem cloudRestoreItem2 : itemList) {
            if (cloudRestoreItem.getAppId().equals(cloudRestoreItem2.getAppId())) {
                cloudRestoreItem2.setAction(i10);
                return;
            }
        }
    }

    /* renamed from: J2 */
    public final void m19794J2(CloudRestoreItem cloudRestoreItem, int i10) {
        CloudRestoreItem cloudRestoreItemM19797n2;
        cloudRestoreItem.setAction(i10);
        List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
        if (listM29202r != null && !listM29202r.isEmpty()) {
            Iterator<CloudRestoreItem> it = listM29202r.iterator();
            while (it.hasNext()) {
                m19794J2(it.next(), i10);
            }
            cloudRestoreItem.m29182J0();
            m19795K2(cloudRestoreItem, i10);
        } else if ("thirdApp".equals(this.f14323W)) {
            m19793I2(cloudRestoreItem, i10);
        }
        String oriBackupAppName = cloudRestoreItem.getOriBackupAppName();
        if (i10 == 0 && SplitAppUtil.isTwinApp(cloudRestoreItem.getSplitApkType(), oriBackupAppName) && (cloudRestoreItemM19797n2 = m19797n2(oriBackupAppName)) != null) {
            cloudRestoreItemM19797n2.setAction(i10);
            this.f14319S.notifyDataSetChanged();
        }
        List<CloudRestoreItem> listM29172A = cloudRestoreItem.m29172A();
        if (i10 != 2 || listM29172A.isEmpty()) {
            return;
        }
        Iterator<CloudRestoreItem> it2 = listM29172A.iterator();
        while (it2.hasNext()) {
            CloudRestoreItem cloudRestoreItemM19797n22 = m19797n2(it2.next().getAppId());
            if (cloudRestoreItemM19797n22 != null) {
                cloudRestoreItemM19797n22.setAction(i10);
                m19793I2(cloudRestoreItemM19797n22, i10);
            }
        }
        this.f14319S.notifyDataSetChanged();
    }

    /* renamed from: K2 */
    public final void m19795K2(CloudRestoreItem cloudRestoreItem, int i10) {
        List<CloudRestoreItem> listM29202r;
        ArrayList<CloudRestoreItem> itemList;
        if (cloudRestoreItem == null || (listM29202r = cloudRestoreItem.m29202r()) == null || listM29202r.isEmpty() || !"thirdApp".equals(cloudRestoreItem.getAppId()) || i10 == 0 || (itemList = RestoreCache.getInstance().getItemList()) == null || itemList.isEmpty()) {
            return;
        }
        for (CloudRestoreItem cloudRestoreItem2 : listM29202r) {
            Iterator<CloudRestoreItem> it = itemList.iterator();
            while (true) {
                if (it.hasNext()) {
                    CloudRestoreItem next = it.next();
                    if (cloudRestoreItem2.getAppId().equals(next.getAppId())) {
                        next.setAction(i10);
                        break;
                    }
                }
            }
        }
    }

    /* renamed from: L2 */
    public final void m19796L2(int i10, boolean z10) throws Resources.NotFoundException {
        ListView listView = this.f14315O;
        if (listView == null) {
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int lastVisiblePosition = this.f14315O.getLastVisiblePosition();
        if (i10 < firstVisiblePosition || i10 > lastVisiblePosition) {
            return;
        }
        C11839m.m70686d("CloudRestoreChildOptionsActivity", "refresh view, position = " + i10);
        View childAt = this.f14315O.getChildAt(i10 - firstVisiblePosition);
        if (z10) {
            this.f14319S.m908A(childAt, i10);
        } else {
            this.f14319S.m928z(childAt, i10);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBaseRestoreOptionsActivity
    /* renamed from: a2 */
    public void mo19634a2(String str) throws Resources.NotFoundException {
        CloudRestoreItem cloudRestoreItem;
        List<CloudRestoreItem> listM29202r;
        if (str == null || (cloudRestoreItem = this.f14322V) == null || (listM29202r = cloudRestoreItem.m29202r()) == null) {
            return;
        }
        Iterator<CloudRestoreItem> it = listM29202r.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (str.equals(it.next().getAppId())) {
                m19796L2(i10, true);
                return;
            }
            i10++;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14316P);
        arrayList.add(this.f14317Q);
        arrayList.add(this.f14312L);
        return arrayList;
    }

    /* renamed from: n2 */
    public CloudRestoreItem m19797n2(String str) {
        List<CloudRestoreItem> listM914k;
        if (this.f14319S == null || TextUtils.isEmpty(str) || (listM914k = this.f14319S.m914k()) == null) {
            return null;
        }
        for (CloudRestoreItem cloudRestoreItem : listM914k) {
            if (str.equals(cloudRestoreItem.getAppId())) {
                return cloudRestoreItem;
            }
        }
        return null;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        CloudRestoreItem cloudRestoreItem;
        List<CloudRestoreItem> listM29202r;
        C11839m.m70686d("CloudRestoreChildOptionsActivity", "onActivityResult: requestCode: " + i10 + " resultCode: " + i11);
        super.onActivityResult(i10, i11, intent);
        if (i10 != 10000 || (cloudRestoreItem = this.f14322V) == null || (listM29202r = cloudRestoreItem.m29202r()) == null || listM29202r.isEmpty()) {
            return;
        }
        m19769A2();
        C0171u0 c0171u0 = new C0171u0(this, this.f14326Z, this.f14323W, listM29202r);
        this.f14319S = c0171u0;
        c0171u0.m924v(this);
        this.f14319S.m925w(this);
        this.f14315O.setAdapter((ListAdapter) this.f14319S);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        int id2 = view.getId();
        if (id2 == R$id.cb_all) {
            m19788y2();
        } else if (id2 == R$id.rl_content) {
            m19803x2(view);
        } else if (id2 == R$id.bt_recovery) {
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBaseRestoreOptionsActivity, com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m19801s2();
        mo19005p1();
        m19798p2();
        mo22385x1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBaseRestoreOptionsActivity, com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) throws Resources.NotFoundException {
        m19804z2(i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 == menuItem.getItemId()) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f14176E == 1) {
            C11842p.m70751N1(this, getWindow());
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        CloudRestoreItem item = this.f14319S.getItem(((Integer) view.getTag()).intValue());
        if (item != null && "thirdApp".equals(item.getAppId())) {
            if (motionEvent.getAction() == 0) {
                ((ViewGroup) view.getParent()).setBackground(getDrawable(R$drawable.hmos_pressed_shape));
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                ((ViewGroup) view.getParent()).setBackground(null);
            }
        }
        return false;
    }

    /* renamed from: p2 */
    public void m19798p2() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent == null || (extras = new SafeIntent(intent).getExtras()) == null) {
            return;
        }
        CloudRecoveryItem cloudRecoveryItem = (CloudRecoveryItem) extras.getParcelable("backup_content_detail_list");
        this.f14175D = cloudRecoveryItem;
        if (cloudRecoveryItem == null) {
            return;
        }
        String strM63694p = new C10343b(extras).m63694p("current_app_id");
        this.f14323W = strM63694p;
        if (strM63694p == null) {
            return;
        }
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            if ("sysdata".equals(this.f14323W)) {
                actionBar.setTitle(getString(R$string.system_data));
            } else if ("thirdAppData".equals(this.f14323W)) {
                actionBar.setTitle(getString(R$string.frag_app_data_title));
            } else if ("thirdApp".equals(this.f14323W)) {
                actionBar.setTitle(getString(R$string.cloud_restore_applist));
            } else if ("bmBaseData".equals(this.f14323W)) {
                actionBar.setTitle(getString(R$string.all_basic_data));
            }
        }
        this.f13886q.setVisibility(0);
        this.f14312L.setVisibility(8);
        this.f14326Z.sendEmptyMessageDelayed(330000, 50L);
        if (m19802t2()) {
            this.f14321U.setVisibility(0);
        }
        if (!"bmBaseData".equals(this.f14323W)) {
            this.f14313M.setVisibility(8);
            this.f14318R.setVisibility(0);
            return;
        }
        this.f14313M.setVisibility(0);
        this.f14318R.setVisibility(8);
        CloudRestoreItem item = RestoreCache.getInstance().getItem(this.f14323W);
        this.f14322V = item;
        if (item == null) {
            this.f14314N.setText(getString(R$string.base_service_data));
        } else {
            int size = item.m29202r() != null ? this.f14322V.m29202r().size() : 0;
            this.f14314N.setText(getResources().getQuantityString(R$plurals.backup_basic_data_count_tips_new, size, Integer.valueOf(size)));
        }
    }

    /* renamed from: q2 */
    public final void m19799q2() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent == null || (extras = new SafeIntent(intent).getExtras()) == null) {
            return;
        }
        this.f14176E = extras.getInt(FamilyShareConstants.ENTRY_TYPE, 2);
    }

    /* renamed from: r2 */
    public final void m19800r2(String str) {
        if (C0209d.m1226Y0()) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) CloudRestoreChildOptionsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(FamilyShareConstants.ENTRY_TYPE, this.f14176E);
        bundle.putString("current_app_id", str);
        bundle.putParcelable("backup_content_detail_list", this.f14175D);
        intent.putExtras(bundle);
        startActivityForResult(intent, 10000);
    }

    /* renamed from: s2 */
    public void m19801s2() {
        LayoutInflater.from(this).inflate(R$layout.activity_recovery_option_child, (ViewGroup) this.f13894y, true);
        this.f14320T = (com.huawei.uikit.phone.hwalphaindexerlistview.widget.HwAlphaIndexerListView) C12809f.m76829b(this, R$id.app_record_letters);
        this.f14325Y = (RelativeLayout) C12809f.m76829b(this, R$id.checkbox_column);
        this.f14321U = (SidePaddingRelativeLayout) C12809f.m76829b(this, R$id.rl_app_record_letters);
        ((TextView) C12809f.m76829b(this, R$id.tv_recovery_data)).setVisibility(8);
        this.f14317Q = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.notch_fit_checkbox);
        this.f14312L = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.restore_child_detail_layout);
        this.f14313M = (LinearLayout) C12809f.m76829b(this, R$id.basic_data_tips_layout);
        this.f14314N = (TextView) C12809f.m76829b(this, R$id.basic_data_count);
        CheckBox checkBox = (CheckBox) C12809f.m76829b(this, R$id.cb_all);
        this.f14318R = checkBox;
        checkBox.setOnClickListener(this);
        this.f14316P = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f14324X = (TextView) C12809f.m76829b(this, R$id.cloudbackup_more_detail_tips);
        ListView listView = (ListView) C12809f.m76829b(this, R$id.record_detail_list);
        this.f14315O = listView;
        listView.setOnItemClickListener(this);
        HwButton hwButton = (HwButton) C12809f.m76829b(this, R$id.bt_recovery);
        hwButton.setOnClickListener(this);
        C11842p.m70874v1(this, hwButton);
        m19799q2();
        if (this.f14176E == 1) {
            C11842p.m70745L1(this.f14312L, this);
            C11842p.m70745L1(this.f13886q, this);
        }
        hwButton.setText(R$string.cloudbackup_btn_ok);
    }

    /* renamed from: t2 */
    public final boolean m19802t2() {
        List<CloudRestoreItem> listM29202r;
        CloudRestoreItem item = RestoreCache.getInstance().getItem(this.f14323W);
        this.f14322V = item;
        if (item == null || (listM29202r = item.m29202r()) == null || listM29202r.isEmpty()) {
            return false;
        }
        if ("bmBaseData".equals(this.f14323W) || "thirdAppData".equals(this.f14323W) || "thirdApp".equals(this.f14323W)) {
            return !this.f14322V.m29183K();
        }
        return false;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        finish();
        return true;
    }

    /* renamed from: x2 */
    public final void m19803x2(View view) throws Resources.NotFoundException {
        int iIntValue;
        CloudRestoreItem item;
        if (this.f14175D == null || (item = this.f14319S.getItem((iIntValue = ((Integer) view.getTag()).intValue()))) == null) {
            return;
        }
        String appId = item.getAppId();
        appId.hashCode();
        if (appId.equals("thirdApp")) {
            m19800r2(appId);
        } else {
            m19804z2(iIntValue);
        }
    }

    /* renamed from: z2 */
    public final void m19804z2(int i10) throws Resources.NotFoundException {
        CloudRestoreItem item;
        C0171u0 c0171u0 = this.f14319S;
        if (c0171u0 == null || (item = c0171u0.getItem(i10)) == null || "bmBaseData".equals(this.f14323W) || !item.isCompatible()) {
            return;
        }
        int i11 = item.getAction() == 2 ? 0 : 2;
        m19794J2(item, i11);
        m19769A2();
        m19796L2(i10, false);
        m19790C2(item.getAppId(), i11 == 0);
    }
}
