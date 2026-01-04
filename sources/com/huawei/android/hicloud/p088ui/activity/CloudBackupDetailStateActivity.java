package com.huawei.android.hicloud.p088ui.activity;

import ae.C0147m0;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.cloudbackup.bean.RuleConfig;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.notification.BackupNotification;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupCheckActivity;
import com.huawei.android.hicloud.p088ui.uiadapter.CloudBackupDetailAdapter;
import com.huawei.android.hicloud.p088ui.views.CheckMarkView;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.cloudbackup.p104v3.model.BackupItem;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import om.C11963c;
import om.C11965e;
import p015ak.C0209d;
import p514o9.C11839m;
import p514o9.C11842p;
import p618rm.C12580p;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p742wj.C13612b;
import sk.C12809f;
import tl.C13029h;

/* loaded from: classes3.dex */
public class CloudBackupDetailStateActivity extends CloudBackupStateActivity implements CloudBackupDetailAdapter.IRecyclerViewOnListener {

    /* renamed from: a0 */
    public long f13912a0;

    /* renamed from: b0 */
    public C13029h f13913b0;

    /* renamed from: c0 */
    public HiCloudExceptionView f13914c0;

    /* renamed from: d0 */
    public NotchTopFitRelativeLayout f13915d0;

    /* renamed from: e0 */
    public NotchFitRelativeLayout f13916e0;

    /* renamed from: f0 */
    public RelativeLayout f13917f0;

    /* renamed from: g0 */
    public NotchFitLinearLayout f13918g0;

    /* renamed from: h0 */
    public List<Object> f13919h0;

    /* renamed from: i0 */
    public RecyclerView f13920i0;

    /* renamed from: j0 */
    public CloudBackupDetailAdapter f13921j0;

    /* renamed from: k0 */
    public RelativeLayout f13922k0;

    /* renamed from: l0 */
    public CheckMarkView f13923l0;

    /* renamed from: q0 */
    public TextView f13928q0;

    /* renamed from: r0 */
    public TextView f13929r0;

    /* renamed from: s0 */
    public TextView f13930s0;

    /* renamed from: t0 */
    public ImageView f13931t0;

    /* renamed from: u0 */
    public ImageView f13932u0;

    /* renamed from: y0 */
    public CopyOnWriteArrayList<BackupItem> f13936y0;

    /* renamed from: m0 */
    public int f13924m0 = 305;

    /* renamed from: n0 */
    public int f13925n0 = 0;

    /* renamed from: o0 */
    public boolean f13926o0 = false;

    /* renamed from: p0 */
    public int f13927p0 = 0;

    /* renamed from: v0 */
    public boolean f13933v0 = true;

    /* renamed from: w0 */
    public boolean f13934w0 = false;

    /* renamed from: x0 */
    public final Object f13935x0 = new Object();

    /* renamed from: z0 */
    public Map<String, BackupItem> f13937z0 = new HashMap();

    /* renamed from: A0 */
    public Handler f13908A0 = new Handler(Looper.getMainLooper());

    /* renamed from: B0 */
    public boolean f13909B0 = true;

    /* renamed from: C0 */
    public final Handler.Callback f13910C0 = new C3171a();

    /* renamed from: D0 */
    public final Runnable f13911D0 = new RunnableC3172b();

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupDetailStateActivity$a */
    public class C3171a implements Handler.Callback {
        public C3171a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 32999:
                    if (message.arg2 == 1036) {
                        CloudBackupDetailStateActivity.this.finish();
                        break;
                    }
                    break;
                case 33023:
                    CloudBackupDetailStateActivity.this.m19620n2(message.arg1);
                    break;
                case 33025:
                    CloudBackupDetailStateActivity.this.m19609S2();
                    break;
                case 34011:
                    if (!CloudBackupDetailStateActivity.this.mo18836w2()) {
                        CloudBackupDetailStateActivity.this.m19293S3(message);
                        break;
                    }
                    break;
                case 34012:
                    C11839m.m70686d("CloudBackupDetailStateActivity", "detail refresh initBackupItemList");
                    CloudBackupDetailStateActivity.this.m19288L3();
                    break;
                case 34013:
                    if (CloudBackupDetailStateActivity.this.mo18836w2()) {
                        CloudBackupDetailStateActivity.this.m19293S3(message);
                        break;
                    }
                    break;
            }
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupDetailStateActivity$b */
    public class RunnableC3172b implements Runnable {
        public RunnableC3172b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CloudBackupDetailStateActivity.this.f13937z0.isEmpty()) {
                return;
            }
            C11839m.m70686d("CloudBackupDetailStateActivity", "refreshMap size:" + CloudBackupDetailStateActivity.this.f13937z0.size());
            for (int i10 = 0; i10 < CloudBackupDetailStateActivity.this.f13919h0.size(); i10++) {
                Object obj = CloudBackupDetailStateActivity.this.f13919h0.get(i10);
                if (obj instanceof BackupItem) {
                    BackupItem backupItem = (BackupItem) obj;
                    BackupItem backupItem2 = (BackupItem) CloudBackupDetailStateActivity.this.f13937z0.getOrDefault(backupItem.m29870d() + backupItem.m29861N(), null);
                    if (backupItem2 != null) {
                        C11839m.m70686d("CloudBackupDetailStateActivity", "handle msg item is:" + backupItem2.toString());
                        CloudBackupDetailStateActivity.this.m19301b4(backupItem2, i10);
                    }
                }
            }
            CloudBackupDetailStateActivity.this.f13937z0.clear();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupDetailStateActivity$c */
    public class C3173c extends RecyclerView.AbstractC0850t {
        public C3173c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            if (i10 == 0) {
                CloudBackupDetailStateActivity cloudBackupDetailStateActivity = CloudBackupDetailStateActivity.this;
                cloudBackupDetailStateActivity.f13927p0 = cloudBackupDetailStateActivity.f13925n0;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            super.onScrolled(recyclerView, i10, i11);
            CloudBackupDetailStateActivity.m19277w3(CloudBackupDetailStateActivity.this, i11);
            if (CloudBackupDetailStateActivity.this.mo18836w2()) {
                if (CloudBackupDetailStateActivity.this.f13925n0 >= CloudBackupDetailStateActivity.this.f13924m0) {
                    CloudBackupDetailStateActivity.this.f13922k0.setVisibility(0);
                    CloudBackupDetailStateActivity.this.f13926o0 = true;
                } else if (CloudBackupDetailStateActivity.this.f13925n0 < CloudBackupDetailStateActivity.this.f13924m0) {
                    CloudBackupDetailStateActivity.this.f13922k0.setVisibility(8);
                    CloudBackupDetailStateActivity.this.f13926o0 = false;
                }
            }
        }
    }

    /* renamed from: B3 */
    private void m19258B3() {
        if (!(!C10028c.m62182c0().m62395t1("is_already_configed_NV4"))) {
            C13612b.m81829B().m81876o();
            return;
        }
        Intent intent = new Intent(this, (Class<?>) NewHiSyncSettingActivity.class);
        C13230i.m79525e1(intent, this.f16165h, this.f16166i);
        startActivity(intent);
        finish();
    }

    /* renamed from: C3 */
    private List<Object> m19259C3(List<Object> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list);
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof BackupItem) {
                BackupItem backupItem = (BackupItem) next;
                if (SplitAppUtil.hasSplitAppSuffix(backupItem.m29870d())) {
                    String splitAppType = SplitAppUtil.getSplitAppType(backupItem.m29870d());
                    backupItem.mo29413k0(SplitAppUtil.getSplitOriAppId(backupItem.m29870d()));
                    backupItem.mo29452y0(splitAppType);
                    List arrayList2 = map.get(backupItem.mo29421n()) != null ? (List) map.get(backupItem.mo29421n()) : new ArrayList();
                    if (arrayList2 != null) {
                        arrayList2.add(backupItem);
                        map.put(backupItem.mo29421n(), arrayList2);
                    }
                    it.remove();
                }
            }
        }
        if (!map.isEmpty()) {
            for (final String str : map.keySet()) {
                Optional optionalFindFirst = arrayList.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.c2
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return CloudBackupDetailStateActivity.m19262O3(str, obj);
                    }
                }).findFirst();
                if (optionalFindFirst.isPresent()) {
                    Object obj = optionalFindFirst.get();
                    List list2 = (List) map.get(str);
                    if (list2 != null) {
                        list2.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.d2
                            @Override // java.util.Comparator
                            public final int compare(Object obj2, Object obj3) {
                                return CloudBackupDetailStateActivity.m19263P3((BackupItem) obj2, (BackupItem) obj3);
                            }
                        });
                        list.removeAll(list2);
                        list.addAll(list.indexOf(obj) + 1, list2);
                    }
                }
            }
        }
        return list;
    }

    /* renamed from: E3 */
    private void m19260E3() {
        C11842p.m70760Q1(this, this.f13917f0);
    }

    /* renamed from: K3 */
    private void m19261K3() {
        if (this.f13921j0 == null) {
            CloudBackupDetailAdapter cloudBackupDetailAdapter = new CloudBackupDetailAdapter(this);
            this.f13921j0 = cloudBackupDetailAdapter;
            cloudBackupDetailAdapter.m24891P(this);
            this.f13921j0.m24889N(m19616j2());
            this.f13921j0.m24892Q(this.f14151U);
            this.f13920i0.setAdapter(this.f13921j0);
            this.f13920i0.setLayoutManager(new LinearLayoutManager(this));
            this.f13920i0.setFocusableInTouchMode(false);
            this.f13920i0.setItemAnimator(null);
            this.f13924m0 = C11842p.m70840n(this, this.f13924m0);
            this.f13920i0.addOnScrollListener(new C3173c());
            this.f13922k0.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.b2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f16482a.m19291Q3(view);
                }
            });
        }
    }

    /* renamed from: O3 */
    public static /* synthetic */ boolean m19262O3(String str, Object obj) {
        if (obj instanceof BackupItem) {
            return str.equalsIgnoreCase(((BackupItem) obj).m29870d());
        }
        return false;
    }

    /* renamed from: P3 */
    public static /* synthetic */ int m19263P3(BackupItem backupItem, BackupItem backupItem2) {
        return C12580p.m75586t(backupItem.m29870d(), backupItem2.m29870d());
    }

    /* renamed from: W3 */
    private void m19264W3() {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        String strM29113i = hiCloudSafeIntent.m29113i("entry_source", "entry_undefined");
        LinkedHashMap<String, String> linkedHashMapM19287J3 = m19287J3();
        linkedHashMapM19287J3.put("entry_source", strM29113i);
        C13225d.m79490f1().m79591l0("mecloud_backupmain_click_backup_detail", linkedHashMapM19287J3);
        UBAAnalyze.m29958S("PVC", "mecloud_backupmain_click_backup_detail", "1", "77", linkedHashMapM19287J3);
        if ("entry_backup_notify".equals(strM29113i)) {
            String strM29113i2 = hiCloudSafeIntent.m29113i("notify_type", "");
            if (TextUtils.isEmpty(strM29113i2)) {
                return;
            }
            C13225d.m79490f1().m79591l0(strM29113i2, linkedHashMapM19287J3);
            UBAAnalyze.m29958S("PVC", strM29113i2, "4", "78", linkedHashMapM19287J3);
        }
    }

    /* renamed from: Z3 */
    private void m19265Z3() {
        this.f13916e0.setVisibility(0);
        this.f13918g0.setVisibility(8);
    }

    /* renamed from: w3 */
    public static /* synthetic */ int m19277w3(CloudBackupDetailStateActivity cloudBackupDetailStateActivity, int i10) {
        int i11 = cloudBackupDetailStateActivity.f13925n0 + i10;
        cloudBackupDetailStateActivity.f13925n0 = i11;
        return i11;
    }

    /* renamed from: A3 */
    public final void m19281A3(String str, List<BackupItem> list) {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= this.f13919h0.size()) {
                break;
            }
            Object obj = this.f13919h0.get(i11);
            if ((obj instanceof BackupItem) && str.equals(((BackupItem) obj).m29870d())) {
                i10 = i11;
                break;
            }
            i11++;
        }
        int i12 = i10 + 1;
        if (!"thirdApp".equals(str)) {
            this.f13919h0.addAll(i12, list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<BackupItem> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.f13919h0.addAll(i12, arrayList);
    }

    /* renamed from: D3 */
    public final boolean m19282D3() {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        boolean booleanExtra = hiCloudSafeIntent.getBooleanExtra(BackupNotification.FROM_NOTIFICATION, false);
        boolean booleanExtra2 = hiCloudSafeIntent.getBooleanExtra(BackupNotification.NEED_CHECK_GRADE, false);
        boolean zM80791C0 = C13452e.m80781L().m80791C0();
        if (booleanExtra && booleanExtra2 && zM80791C0) {
            try {
                C11839m.m70688i("CloudBackupDetailStateActivity", "finishAndJumpBackupMain");
                startActivity(new Intent(this, (Class<?>) BackupMainActivity.class));
                finish();
                return true;
            } catch (Exception e10) {
                C11839m.m70687e("CloudBackupDetailStateActivity", "finishAndJumpBackupMain :" + e10);
            }
        }
        return false;
    }

    /* renamed from: F3 */
    public final int m19283F3(String str) {
        List<Object> list = this.f13919h0;
        if (list == null) {
            return 0;
        }
        for (Object obj : list) {
            if ((obj instanceof BackupItem) && str.equals(m19285H3((BackupItem) obj))) {
                return this.f13919h0.indexOf(obj);
            }
        }
        return 0;
    }

    /* renamed from: G3 */
    public final int m19284G3(String str) {
        boolean z10 = false;
        if (this.f13919h0 == null) {
            C11839m.m70689w("CloudBackupDetailStateActivity", "getCurrentBackupModulePos backupItemListAll is empty");
            return 0;
        }
        if ("chatSms".equals(str)) {
            str = NavigationUtils.SMS_SCHEMA_PREF;
        }
        if ("callRecorder".equals(str)) {
            str = "soundrecorder";
        }
        BackupItem backupItem = null;
        for (int size = this.f13919h0.size() - 1; size >= 0; size--) {
            Object obj = this.f13919h0.get(size);
            if (obj instanceof BackupItem) {
                BackupItem backupItem2 = (BackupItem) obj;
                if (str.equals(m19285H3(backupItem2))) {
                    return size;
                }
                if ("thirdApp".equals(backupItem2.m29870d())) {
                    backupItem = backupItem2;
                }
            }
        }
        if (backupItem != null) {
            Iterator<BackupItem> it = backupItem.m29824I0().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (str.equals(it.next().m29871e())) {
                    z10 = true;
                    str = "thirdApp";
                    break;
                }
            }
        }
        if (z10 && !this.f13934w0) {
            this.f13934w0 = true;
            m19288L3();
            this.f13920i0.requestLayout();
        }
        int iM19283F3 = m19283F3(str);
        C11839m.m70688i("CloudBackupDetailStateActivity", "getScanModulePos appId = " + str + ", pos = " + iM19283F3);
        return iM19283F3;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: H2 */
    public void mo18731H2(boolean z10) {
        super.mo18731H2(z10);
        C13225d.m79490f1().m79587h0("action_code_backup_detail_click_button", "3", "", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29971c0("PVC", "action_code_backup_detail_click_button", "1", "77", "3", "");
    }

    /* renamed from: H3 */
    public final String m19285H3(BackupItem backupItem) {
        return ((!backupItem.m29863P() || "thirdApp".equals(backupItem.m29870d())) && !backupItem.m29867U()) ? backupItem.m29870d() : backupItem.m29871e();
    }

    /* renamed from: I3 */
    public final String m19286I3(String str, CloudBackupState cloudBackupState) {
        C11839m.m70688i("CloudBackupDetailStateActivity", "getModuleName moduleName = " + str + " uid = " + cloudBackupState.getUid());
        return str;
    }

    /* renamed from: J3 */
    public final LinkedHashMap<String, String> m19287J3() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        C13029h c13029h = this.f13913b0;
        if (c13029h != null) {
            if (!TextUtils.isEmpty(c13029h.m78436B())) {
                linkedHashMapM79497A.put("id", this.f13913b0.m78436B());
            }
            if (!TextUtils.isEmpty(this.f13913b0.m78444J())) {
                linkedHashMapM79497A.put("traceId", this.f13913b0.m78444J());
            }
        }
        return linkedHashMapM79497A;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: K2 */
    public void mo18741K2(boolean z10) {
        super.mo18741K2(z10);
        if (C13452e.m80781L().m80791C0()) {
            try {
                C11839m.m70688i("CloudBackupDetailStateActivity", "refreshLayoutWithSpaceChange :Basic services do not support viewing details. Return to the cloud backup home page.");
                startActivity(new Intent(this, (Class<?>) BackupMainActivity.class));
                finish();
            } catch (Exception e10) {
                C11839m.m70687e("CloudBackupDetailStateActivity", "refreshLayoutWithSpaceChange :" + e10);
            }
        }
    }

    /* renamed from: L3 */
    public final void m19288L3() {
        synchronized (this.f13935x0) {
            try {
                List<BackupItem> listM71959n = C11963c.m71959n(m19616j2());
                if (this.f13919h0 == null) {
                    this.f13919h0 = new ArrayList();
                }
                this.f13919h0.clear();
                CloudBackupState cloudBackupState = this.f14158q;
                if (cloudBackupState != null) {
                    this.f13919h0.add(cloudBackupState);
                }
                boolean zM62303a1 = C10028c.m62182c0().m62303a1();
                C11839m.m70688i("CloudBackupDetailStateActivity", "initBackupItemList isBaseBackupOn: " + zM62303a1);
                boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
                C11839m.m70688i("CloudBackupDetailStateActivity", "refreshBackupItemView backupOn: " + zM62388s);
                if (!zM62303a1 && zM62388s) {
                    Iterator<BackupItem> it = listM71959n.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        BackupItem next = it.next();
                        if (TextUtils.equals("thirdApp", next.m29870d())) {
                            listM71959n.remove(next);
                            break;
                        }
                    }
                }
                if (listM71959n.isEmpty()) {
                    CopyOnWriteArrayList<BackupItem> copyOnWriteArrayList = this.f13936y0;
                    if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                        C11839m.m70689w("CloudBackupDetailStateActivity", "initBackupItemList empty");
                    } else {
                        this.f13919h0.addAll(this.f13936y0);
                        m19290N3(this.f13936y0);
                        C11839m.m70688i("CloudBackupDetailStateActivity", "initBackupItemList backupItemCopyOnWriteArrayList !empty");
                    }
                } else {
                    this.f13936y0 = new CopyOnWriteArrayList<>(listM71959n);
                    this.f13919h0.addAll(listM71959n);
                    m19290N3(listM71959n);
                    C11839m.m70688i("CloudBackupDetailStateActivity", "initBackupItemList itemList !empty");
                }
                List<Object> listM19259C3 = m19259C3(this.f13919h0);
                this.f13919h0 = listM19259C3;
                this.f13921j0.m24890O(listM19259C3);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: M3 */
    public final void m19289M3(List<BackupItem> list, String str, int i10, boolean z10) {
        for (BackupItem backupItem : list) {
            backupItem.m29842a1(i10);
            backupItem.m29850i1(z10);
            backupItem.m29845d1(str);
        }
    }

    /* renamed from: N3 */
    public final void m19290N3(List<BackupItem> list) {
        for (BackupItem backupItem : list) {
            List<BackupItem> listM29824I0 = backupItem.m29824I0();
            String strM29870d = backupItem.m29870d();
            if (listM29824I0 != null && listM29824I0.size() > 0) {
                if ("baseData".equals(strM29870d)) {
                    m19289M3(listM29824I0, strM29870d, 2, this.f13933v0);
                    backupItem.m29841Z0(this.f13933v0);
                    if (this.f13933v0) {
                        m19281A3("baseData", listM29824I0);
                        m19290N3(listM29824I0);
                    }
                } else if ("thirdAppData".equals(strM29870d)) {
                    Iterator<Object> it = this.f13919h0.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if ((next instanceof BackupItem) && "thirdAppData".equals(((BackupItem) next).m29870d())) {
                            it.remove();
                            break;
                        }
                    }
                    this.f13919h0.addAll(listM29824I0);
                }
            }
        }
    }

    /* renamed from: Q3 */
    public final /* synthetic */ void m19291Q3(View view) {
        if (this.f13926o0) {
            this.f13920i0.scrollToPosition(0);
            ((LinearLayoutManager) this.f13920i0.getLayoutManager()).scrollToPositionWithOffset(0, 0);
            this.f13925n0 = 0;
            this.f13926o0 = false;
            this.f13922k0.setVisibility(8);
        }
    }

    /* renamed from: R3 */
    public final /* synthetic */ void m19292R3(int i10) {
        this.f13920i0.smoothScrollToPosition(i10);
    }

    /* renamed from: S3 */
    public final void m19293S3(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof ArrayList)) {
            C11839m.m70689w("CloudBackupDetailStateActivity", "moduleUpdateMsgHandle obj not instanceof ArrayList");
            return;
        }
        List<BackupItem> list = (List) obj;
        if (list.isEmpty()) {
            C11839m.m70689w("CloudBackupDetailStateActivity", "moduleUpdateMsgHandle objects.isEmpty()");
        } else if (!(list.get(0) instanceof BackupItem)) {
            C11839m.m70689w("CloudBackupDetailStateActivity", "moduleUpdateMsgHandle objects.get(0) not instanceof BackupItem");
        } else {
            m19302c4(list);
            m19303d4();
        }
    }

    /* renamed from: T3 */
    public final void m19294T3(boolean z10) {
        synchronized (this.f13935x0) {
            try {
                List<Object> list = this.f13919h0;
                if (list != null && this.f13921j0 != null) {
                    if (list.size() <= 0 || !(this.f13919h0.get(0) instanceof CloudBackupState)) {
                        this.f13919h0.add(0, this.f14158q);
                        this.f13921j0.m24890O(this.f13919h0);
                    } else {
                        this.f13919h0.set(0, this.f14158q);
                        if (z10) {
                            this.f13921j0.m5213j();
                        } else {
                            this.f13921j0.m5214k(0);
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: U3 */
    public final void m19295U3(List<BackupItem> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (BackupItem backupItem : list) {
            int iM29860M = backupItem.m29860M();
            List<BackupItem> listM29824I0 = backupItem.m29824I0();
            if (listM29824I0 != null) {
                m19295U3(listM29824I0);
            } else if (iM29860M != 7 && iM29860M != -1) {
                backupItem.mo29289A0(0);
            }
        }
    }

    /* renamed from: V3 */
    public final void m19296V3() {
        LinkedHashMap<String, String> linkedHashMapM19287J3 = m19287J3();
        linkedHashMapM19287J3.put("time", String.valueOf(System.currentTimeMillis() - this.f13912a0));
        C13225d.m79490f1().m79591l0("action_code_backup_detail_time", linkedHashMapM19287J3);
        UBAAnalyze.m29958S("PVC", "action_code_backup_detail_time", "1", "77", linkedHashMapM19287J3);
    }

    /* renamed from: X3 */
    public void m19297X3(float f10) throws Resources.NotFoundException {
        if (f10 > 100.0f) {
            return;
        }
        this.f13928q0.setText(C11965e.m71974f().m71980i(f10, getResources().getDimensionPixelSize(R$dimen.backup_frequency_marging_6)));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: Y2 */
    public void mo19298Y2() {
        this.f13916e0.setVisibility(8);
        this.f13918g0.setVisibility(0);
    }

    /* renamed from: Y3 */
    public final void m19299Y3() {
        mo19298Y2();
        m19294T3(false);
        mo18767U2(2);
    }

    /* renamed from: a4 */
    public final void m19300a4() {
        if (new HiCloudSafeIntent(getIntent()).getBooleanExtra(BackupNotification.KEY_IS_FOREGROUND, true)) {
            return;
        }
        BackupNotification.getInstance().stopNotificationService();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: b2 */
    public void mo18781b2(boolean z10) {
        super.mo18781b2(z10);
        if (z10) {
            return;
        }
        C13225d.m79490f1().m79587h0("action_code_backup_detail_click_button", "4", "", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29971c0("PVC", "action_code_backup_detail_click_button", "1", "77", "4", "");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: b3 */
    public void mo18782b3(int i10) {
        C11839m.m70688i("CloudBackupDetailStateActivity", "showDoneState");
        mo19298Y2();
        mo18767U2(4);
        this.f13932u0.setVisibility(8);
        this.f13931t0.setVisibility(0);
        if (this.f14151U) {
            this.f13929r0.setText(getString(R$string.backup_complete_new));
        } else {
            this.f13929r0.setText(getString(R$string.backup_completed_notification_title));
        }
        this.f13930s0.setVisibility(8);
        this.f13929r0.setVisibility(0);
        this.f13928q0.setVisibility(8);
        this.f13923l0.setVisibility(0);
        this.f13923l0.m25691f();
        this.f13923l0.m25692g();
        m19288L3();
    }

    /* renamed from: b4 */
    public final void m19301b4(BackupItem backupItem, int i10) {
        synchronized (this.f13935x0) {
            try {
                Object obj = this.f13919h0.get(i10);
                if (obj instanceof BackupItem) {
                    ((BackupItem) obj).m29822G0(backupItem);
                    this.f13921j0.m5214k(i10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: c3 */
    public void mo18784c3() throws Resources.NotFoundException {
        int i10;
        super.mo18784c3();
        C11839m.m70686d("CloudBackupDetailStateActivity", "showModuleProcessing");
        m19299Y3();
        C11839m.m70688i("CloudBackupDetailStateActivity", " is backup module");
        String displayModule = this.f14158q.getDisplayModule();
        String string = getString(R$string.module_progress_tips_no_num_new, m19286I3(C2783d.m16142g0(displayModule) ? C2783d.m16153k(this, displayModule) : C2783d.m16079E(this, displayModule), this.f14158q));
        this.f13932u0.setVisibility(8);
        this.f13931t0.setVisibility(0);
        this.f13929r0.setText(string);
        this.f13929r0.setVisibility(0);
        this.f13930s0.setVisibility(8);
        m19297X3(this.f14158q.getProgress());
        CloudBackupState cloudBackupState = this.f14158q;
        if (cloudBackupState == null) {
            C11839m.m70688i("CloudBackupDetailStateActivity", "showModuleProcessing showCloudBackupState is null");
            return;
        }
        String currentMoudle = cloudBackupState.getCurrentMoudle();
        if (TextUtils.isEmpty(currentMoudle)) {
            C11839m.m70689w("CloudBackupDetailStateActivity", "showModuleProcessing showModuleProcessing module name is null");
            return;
        }
        if (this.f13909B0) {
            final int iM19284G3 = m19284G3(currentMoudle);
            if (iM19284G3 < this.f13919h0.size() && (i10 = iM19284G3 + 2) < this.f13919h0.size()) {
                iM19284G3 = i10;
            }
            this.f13909B0 = false;
            C11839m.m70688i("CloudBackupDetailStateActivity", "finalScrollPos: " + iM19284G3);
            this.f13920i0.post(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.e2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17593a.m19292R3(iM19284G3);
                }
            });
        }
    }

    /* renamed from: c4 */
    public final void m19302c4(List<BackupItem> list) {
        C11839m.m70688i("CloudBackupDetailStateActivity", "updateModulesItemView = " + list);
        for (BackupItem backupItem : list) {
            String strM29870d = backupItem.m29870d();
            int iM29861N = backupItem.m29861N();
            if (backupItem.m29860M() == -1) {
                backupItem.m29846e1(-1.0f);
            }
            this.f13937z0.put(strM29870d + iM29861N, backupItem);
        }
        this.f13911D0.run();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13915d0);
        arrayList.add(this.f13918g0);
        arrayList.add(this.f13916e0);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: d3 */
    public void mo18787d3() {
        super.mo18801h3();
        m19299Y3();
    }

    /* renamed from: d4 */
    public final void m19303d4() {
        if (this.f14158q == null) {
            return;
        }
        try {
            C11839m.m70688i("CloudBackupDetailStateActivity", "cloudBackupState.getState() = " + this.f14158q.getState());
            m19297X3(this.f14158q.getProgress());
            if (this.f14158q.getState().intValue() == 8) {
                String displayModule = this.f14158q.getDisplayModule();
                String string = getString(R$string.module_progress_tips_no_num_new, m19286I3(C2783d.m16142g0(displayModule) ? C2783d.m16153k(this, displayModule) : C2783d.m16079E(this, displayModule), this.f14158q));
                this.f13932u0.setVisibility(8);
                this.f13931t0.setVisibility(0);
                this.f13929r0.setText(string);
                this.f13929r0.setVisibility(0);
                this.f13930s0.setVisibility(8);
            }
        } catch (Exception e10) {
            C11839m.m70688i("CloudBackupDetailStateActivity", "Exception is " + e10);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: e1 */
    public int mo19304e1() {
        return R$id.cloud_backup_recyclerview;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: e2 */
    public void mo18790e2() {
        super.mo18790e2();
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: e3 */
    public void mo18791e3() throws Resources.NotFoundException {
        mo19298Y2();
        m19294T3(true);
        int intProgress = this.f14158q.getIntProgress();
        int returnCode = this.f14158q.getReturnCode();
        if (intProgress == 100 && returnCode == 0) {
            mo18767U2(4);
            this.f13932u0.setVisibility(8);
            this.f13931t0.setVisibility(0);
            if (this.f14151U) {
                this.f13929r0.setText(getString(R$string.backup_complete_new));
            } else {
                this.f13929r0.setText(getString(R$string.backup_completed_notification_title));
            }
            this.f13930s0.setVisibility(8);
            this.f13929r0.setVisibility(0);
            this.f13928q0.setVisibility(8);
            this.f13923l0.setVisibility(0);
            this.f13923l0.m25691f();
            this.f13923l0.m25692g();
        } else {
            C11839m.m70688i("CloudBackupDetailStateActivity", "backup is pause");
            this.f13932u0.setVisibility(0);
            this.f13931t0.setVisibility(8);
            this.f13930s0.setText(getString(R$string.backup_suspended));
            this.f13930s0.setVisibility(0);
            this.f13929r0.setVisibility(8);
            m19297X3(this.f14158q.getProgress());
            mo18767U2(3);
        }
        m19288L3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: f3 */
    public void mo18794f3() throws Resources.NotFoundException {
        super.mo18794f3();
        C11839m.m70686d("CloudBackupDetailStateActivity", "showPauseState");
        mo19298Y2();
        m19294T3(true);
        m19288L3();
        C11839m.m70688i("CloudBackupDetailStateActivity", "backup is pause");
        this.f13932u0.setVisibility(0);
        this.f13931t0.setVisibility(8);
        this.f13930s0.setText(getString(R$string.backup_suspended));
        this.f13930s0.setVisibility(0);
        this.f13929r0.setVisibility(8);
        m19297X3(this.f14158q.getProgress());
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.CloudBackupDetailAdapter.IRecyclerViewOnListener
    /* renamed from: g0 */
    public void mo19305g0(int i10, BackupItem backupItem, boolean z10) {
        C11839m.m70686d("CloudBackupDetailStateActivity", "onItemClick isShow:" + z10 + " AppName:" + backupItem.m29871e() + " size:" + this.f13919h0.size());
        String strM29870d = backupItem.m29870d();
        strM29870d.hashCode();
        if (strM29870d.equals("baseData")) {
            this.f13933v0 = z10;
        } else if (strM29870d.equals("thirdApp")) {
            this.f13934w0 = z10;
        }
        m19288L3();
        C11839m.m70686d("CloudBackupDetailStateActivity", "onItemClick refresh backupItemListAll size:" + this.f13919h0.size());
        this.f13920i0.requestLayout();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: g3 */
    public void mo18798g3() throws Resources.NotFoundException {
        super.mo18798g3();
        m19295U3(C11963c.m71959n(m19616j2()));
        m19294T3(false);
        C11839m.m70688i("CloudBackupDetailStateActivity", "is prepareData");
        this.f13932u0.setVisibility(8);
        this.f13931t0.setVisibility(0);
        this.f13929r0.setText(getString(R$string.backup_preparing_notification_content));
        this.f13930s0.setVisibility(8);
        this.f13929r0.setVisibility(0);
        m19297X3(this.f14158q.getProgress());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: h3 */
    public void mo18801h3() throws Resources.NotFoundException {
        C11839m.m70686d("CloudBackupDetailStateActivity", "showProcess initBackupItemList");
        super.mo18801h3();
        m19299Y3();
        m19288L3();
        C11839m.m70688i("CloudBackupDetailStateActivity", " is backuping");
        String displayModule = this.f14158q.getDisplayModule();
        String string = getString(R$string.module_progress_tips_no_num_new, m19286I3(C2783d.m16142g0(displayModule) ? C2783d.m16153k(this, displayModule) : C2783d.m16079E(this, displayModule), this.f14158q));
        this.f13932u0.setVisibility(8);
        this.f13931t0.setVisibility(0);
        this.f13929r0.setText(string);
        this.f13929r0.setVisibility(0);
        this.f13930s0.setVisibility(8);
        m19297X3(this.f14158q.getProgress());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: o2 */
    public void mo18817o2() {
        super.mo18817o2();
        CloudBackupService.getInstance().register(this.f13910C0);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(RuleConfig.DEFAULT_BACKUP_RESTORE_TAR_COUNT);
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setRepeatCount(-1);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m19260E3();
        RecyclerView recyclerView = this.f13920i0;
        if (recyclerView == null || !this.f14151U) {
            return;
        }
        RecyclerView.AbstractC0833c0 abstractC0833c0FindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(0);
        if (abstractC0833c0FindViewHolderForAdapterPosition instanceof C0147m0) {
            C0147m0 c0147m0 = (C0147m0) abstractC0833c0FindViewHolderForAdapterPosition;
            CloudBackupDetailAdapter cloudBackupDetailAdapter = this.f13921j0;
            if (cloudBackupDetailAdapter != null) {
                cloudBackupDetailAdapter.m24894S(c0147m0, 0);
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14149S = C12591s1.m75931a().m75941k();
        m19258B3();
        setContentView(R$layout.activity_cloud_backup_detail_state);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        this.f14151U = hiCloudSafeIntent.getBooleanExtra("isTempBackup", false);
        boolean booleanExtra = hiCloudSafeIntent.getBooleanExtra(BackupNotification.IS_COMPLETE, false);
        String strM29113i = hiCloudSafeIntent.m29113i("entry_source", "entry_undefined");
        C11839m.m70688i("CloudBackupDetailStateActivity", "onCreate isTempBackup: " + this.f14151U + "， isComplete: " + booleanExtra + "， entrySource: " + strM29113i);
        if (!booleanExtra && TextUtils.equals(strM29113i, "entry_backup_notify") && this.f14151U && !CBAccess.hasValidTempBackup()) {
            startActivity(new Intent(this, (Class<?>) TempBackupCheckActivity.class));
            finish();
        }
        if (m19282D3()) {
            return;
        }
        mo18823q2();
        mo19982C1();
        mo19005p1();
        mo18817o2();
        this.f13912a0 = System.currentTimeMillis();
        this.f13913b0 = C12590s0.m75902s2();
        m19300a4();
        m19264W3();
        m22371Z0();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        m19296V3();
        CloudBackupService.getInstance().unregister(this.f13910C0);
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m19300a4();
        m19264W3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        m19258B3();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f13925n0 = bundle.getInt("totalScrollY");
        this.f13926o0 = bundle.getBoolean("cardIsVisible");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        mo18820p2();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("totalScrollY", this.f13925n0);
        bundle.putBoolean("cardIsVisible", this.f13926o0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        RecyclerView recyclerView = this.f13920i0;
        if (recyclerView == null || !this.f14151U) {
            return;
        }
        RecyclerView.AbstractC0833c0 abstractC0833c0FindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(0);
        if (abstractC0833c0FindViewHolderForAdapterPosition instanceof C0147m0) {
            C0147m0 c0147m0 = (C0147m0) abstractC0833c0FindViewHolderForAdapterPosition;
            c0147m0.m834Q();
            CloudBackupDetailAdapter cloudBackupDetailAdapter = this.f13921j0;
            if (cloudBackupDetailAdapter != null) {
                cloudBackupDetailAdapter.m24894S(c0147m0, 0);
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: p2 */
    public void mo18820p2() {
        super.mo18820p2();
        if (this.f13914c0 != null) {
            if (C0209d.m1333z1(this) || CBAccess.isAppDataPreparing()) {
                this.f13914c0.m23914a();
                return;
            }
            this.f13914c0.m23919i();
            C13225d.m79490f1().m79585f0("action_code_backup_detail_wait_wlan", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "action_code_backup_detail_wait_wlan", "4", "78");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: q2 */
    public void mo18823q2() {
        super.mo18823q2();
        this.f13914c0 = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        this.f13916e0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.rl_loading);
        this.f13915d0 = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f13917f0 = (RelativeLayout) C12809f.m76829b(this, R$id.rl_fit_loading);
        this.f13918g0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.rl_detail_state);
        m19260E3();
        this.f13920i0 = (RecyclerView) C12809f.m76829b(this, R$id.cloud_backup_recyclerview);
        this.f13922k0 = (RelativeLayout) C12809f.m76829b(this, R$id.hidden_Card);
        this.f13928q0 = (TextView) C12809f.m76829b(this, R$id.tv_inside_progress);
        this.f13929r0 = (TextView) C12809f.m76829b(this, R$id.tv_title);
        this.f13930s0 = (TextView) C12809f.m76829b(this, R$id.tv_title1);
        this.f13923l0 = (CheckMarkView) C12809f.m76829b(this, R$id.backup_complete_new);
        this.f13931t0 = (ImageView) C12809f.m76829b(this, R$id.img_outer_ring1);
        this.f13932u0 = (ImageView) C12809f.m76829b(this, R$id.img_outer_ring2);
        this.f13919h0 = new ArrayList();
        m19261K3();
        m19288L3();
        m22365E1(this.f14151U ? R$string.temp_backup_action_bar_title : R$string.cloudbackup_detail);
        m19265Z3();
    }
}
