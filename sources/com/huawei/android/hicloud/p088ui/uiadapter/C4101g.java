package com.huawei.android.hicloud.p088ui.uiadapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackSpaceHeaderBean;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupSpaceDetailAdapter;
import com.huawei.android.hicloud.p088ui.uiadapter.C4101g;
import com.huawei.android.hicloud.p088ui.views.ManagerBackupDataBasicView;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.UnaryOperator;
import p015ak.C0209d;
import p015ak.C0226l0;
import p015ak.C0241z;
import p336he.C10155f;
import p514o9.C11839m;
import p550pb.C12126b;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p815ym.AbstractC14026a;
import p848zl.C14333b;
import sk.C12809f;

/* renamed from: com.huawei.android.hicloud.ui.uiadapter.g */
/* loaded from: classes3.dex */
public class C4101g extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: d */
    public BackupSpaceDetailAdapter.DeleteBackupModuleListener f19148d;

    /* renamed from: e */
    public View.OnClickListener f19149e;

    /* renamed from: f */
    public final boolean f19150f;

    /* renamed from: g */
    public Integer f19151g = 0;

    /* renamed from: h */
    public final List<Object> f19152h = new ArrayList();

    /* renamed from: i */
    public final Context f19153i;

    /* renamed from: j */
    public SpanClickText f19154j;

    /* renamed from: k */
    public ManagerBackupDataBasicView f19155k;

    public C4101g(Context context, View.OnClickListener onClickListener, boolean z10) {
        this.f19153i = context;
        this.f19149e = onClickListener;
        this.f19150f = z10;
    }

    /* renamed from: N */
    public static /* synthetic */ AppDetailsInfo m25500N(AppDetailsInfo appDetailsInfo, AppDetailsInfo appDetailsInfo2) {
        return TextUtils.equals(appDetailsInfo.getBackupAppName(), appDetailsInfo2.getBackupAppName()) ? appDetailsInfo : appDetailsInfo2;
    }

    /* renamed from: O */
    public static /* synthetic */ void m25501O() {
        if (C0209d.m1226Y0()) {
            C11839m.m70688i("BackupSpaceDetailRecyclerViewAdapter", "link click to fast");
            return;
        }
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "upgrade membership services");
        C13225d.m79490f1().m79567R("action_detail_notification_delete_data_remind", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "action_detail_notification_delete_data_remind", "1", "30", linkedHashMapM79497A);
        Bundle bundle = new Bundle();
        bundle.putInt("from_where", 16);
        C13230i.m79522d1(bundle, "1", "action_detail_notification_delete_data_remind");
        C12126b.m72707c("2", bundle);
    }

    /* renamed from: P */
    public static /* synthetic */ Integer m25502P() throws Exception {
        try {
            int iM1685c = C0241z.m1685c(C10155f.m63283g("bs.userdata.remain.dwnldDays"));
            C11839m.m70688i("BackupSpaceDetailRecyclerViewAdapter", "getParamValue key = remainDays, value = " + iM1685c);
            return Integer.valueOf(iM1685c);
        } catch (Exception e10) {
            C11839m.m70688i("BackupSpaceDetailRecyclerViewAdapter", "getParamValue failed, error = " + e10.getMessage());
            return -1;
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    /* renamed from: G */
    public void m25503G(List<Object> list) {
        this.f19152h.clear();
        this.f19152h.addAll(list);
        m5213j();
    }

    /* renamed from: H */
    public void m25504H() {
        this.f19152h.clear();
    }

    /* renamed from: I */
    public AppDetailsInfo m25505I(String str) {
        if ("chatSms".equals(str)) {
            str = NavigationUtils.SMS_SCHEMA_PREF;
        }
        if ("callRecorder".equals(str)) {
            str = "soundrecorder";
        }
        if (AbstractC14026a.m84159a(this.f19152h)) {
            return null;
        }
        Object obj = this.f19152h.get(0);
        List arrayList = new ArrayList();
        if (obj instanceof CloudBackSpaceHeaderBean) {
            arrayList = ((CloudBackSpaceHeaderBean) obj).basicItemList;
        }
        if (AbstractC14026a.m84159a(arrayList)) {
            return null;
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            AppDetailsInfo appDetailsInfo = (AppDetailsInfo) arrayList.get(i10);
            if (appDetailsInfo.getBackupAppName().equals(str)) {
                return appDetailsInfo;
            }
        }
        return null;
    }

    /* renamed from: J */
    public int m25506J(String str) {
        if ("chatSms".equals(str)) {
            str = NavigationUtils.SMS_SCHEMA_PREF;
        }
        if ("callRecorder".equals(str)) {
            str = "soundrecorder";
        }
        if (AbstractC14026a.m84159a(this.f19152h)) {
            return -1;
        }
        Object obj = this.f19152h.get(0);
        List arrayList = new ArrayList();
        if (obj instanceof CloudBackSpaceHeaderBean) {
            arrayList = ((CloudBackSpaceHeaderBean) obj).basicItemList;
        }
        if (arrayList == null) {
            return -1;
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            if (((AppDetailsInfo) arrayList.get(i10)).getBackupAppName().equals(str)) {
                return i10;
            }
        }
        return -1;
    }

    /* renamed from: K */
    public AppDetailsInfo m25507K(int i10) {
        return i10 >= this.f19152h.size() ? new AppDetailsInfo() : (AppDetailsInfo) this.f19152h.get(i10);
    }

    /* renamed from: L */
    public List<AppDetailsInfo> m25508L() {
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f19152h) {
            if (obj instanceof AppDetailsInfo) {
                arrayList.add((AppDetailsInfo) obj);
            }
        }
        return arrayList;
    }

    /* renamed from: M */
    public int m25509M(String str) {
        if ("chatSms".equals(str)) {
            str = NavigationUtils.SMS_SCHEMA_PREF;
        }
        if ("callRecorder".equals(str)) {
            str = "soundrecorder";
        }
        for (int i10 = 0; i10 < this.f19152h.size(); i10++) {
            Object obj = this.f19152h.get(i10);
            if ((obj instanceof AppDetailsInfo) && ((AppDetailsInfo) obj).getBackupAppName().equals(str)) {
                return i10;
            }
        }
        return -1;
    }

    /* renamed from: Q */
    public void m25510Q(final AppDetailsInfo appDetailsInfo) {
        ManagerBackupDataBasicView managerBackupDataBasicView = this.f19155k;
        if (managerBackupDataBasicView == null) {
            return;
        }
        List<AppDetailsInfo> basicItemList = managerBackupDataBasicView.getBasicItemList();
        if (AbstractC14026a.m84159a(basicItemList)) {
            return;
        }
        basicItemList.replaceAll(new UnaryOperator() { // from class: ae.h0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C4101g.m25500N(appDetailsInfo, (AppDetailsInfo) obj);
            }
        });
        this.f19155k.m25780e(basicItemList, this.f19152h.size() > 1);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    /* renamed from: R */
    public final void m25511R(C4082b c4082b, int i10) {
        if (i10 == 1) {
            if (mo721e() == 2) {
                c4082b.m25357W(this.f19153i.getDrawable(R$drawable.storage_manage_cardview_list_shape_white));
                return;
            } else {
                c4082b.m25357W(this.f19153i.getDrawable(R$drawable.cardview_list_top_shape_white));
                return;
            }
        }
        if (i10 == mo721e() - 1) {
            c4082b.m25357W(this.f19153i.getDrawable(R$drawable.cardview_list_bottom_shape_white));
        } else {
            c4082b.m25358X(this.f19153i.getColor(R$color.storage_manager_card_bg));
        }
    }

    /* renamed from: S */
    public void m25512S(BackupSpaceDetailAdapter.DeleteBackupModuleListener deleteBackupModuleListener) {
        this.f19148d = deleteBackupModuleListener;
    }

    /* renamed from: T */
    public final void m25513T() throws Resources.NotFoundException {
        SpanClickText.ISpanClickListener iSpanClickListener = new SpanClickText.ISpanClickListener() { // from class: ae.f0
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() {
                C4101g.m25501O();
            }
        };
        boolean zM80815I0 = C13452e.m80781L().m80815I0();
        boolean zM80819J0 = C13452e.m80781L().m80819J0();
        boolean zM80823K0 = C13452e.m80781L().m80823K0();
        if (!zM80815I0 && !zM80819J0 && !zM80823K0) {
            this.f19154j.setVisibility(8);
            return;
        }
        this.f19154j.setVisibility(0);
        String string = this.f19153i.getString(R$string.subscribe_to_premium);
        this.f19154j.m15931c(string, iSpanClickListener);
        Integer num = (Integer) C0226l0.m1582b(new Callable() { // from class: ae.g0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C4101g.m25502P();
            }
        }, 300L, -1);
        int iIntValue = num.intValue();
        if (iIntValue <= 0 || zM80823K0) {
            this.f19154j.m15934g(this.f19153i.getResources().getString(R$string.backup_full_data_card_tip1, string), false);
        } else {
            this.f19154j.m15934g(this.f19153i.getResources().getQuantityString(R$plurals.backup_full_data_card_tip, iIntValue, num, string), false);
        }
    }

    /* renamed from: U */
    public void m25514U(RecyclerView recyclerView, boolean z10) {
        RecyclerView.AbstractC0833c0 abstractC0833c0FindViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(0);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setHeaderLoadingGone:hasData,start ");
        sb2.append(z10);
        sb2.append(",");
        boolean z11 = abstractC0833c0FindViewHolderForLayoutPosition instanceof C4081a;
        sb2.append(z11);
        C11839m.m70688i("BackupSpaceDetailRecyclerViewAdapter", sb2.toString());
        if (z11) {
            C11839m.m70688i("BackupSpaceDetailRecyclerViewAdapter", "setHeaderLoadingGone:hasData,ok " + z10);
            ((C4081a) abstractC0833c0FindViewHolderForLayoutPosition).m25339l0(z10);
        }
    }

    /* renamed from: V */
    public void m25515V(RecyclerView recyclerView, boolean z10) {
        RecyclerView.AbstractC0833c0 abstractC0833c0FindViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(0);
        if (abstractC0833c0FindViewHolderForLayoutPosition instanceof C4081a) {
            C4081a c4081a = (C4081a) abstractC0833c0FindViewHolderForLayoutPosition;
            if (z10) {
                c4081a.f18949E.setVisibility(0);
            } else {
                c4081a.f18949E.setVisibility(8);
            }
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    /* renamed from: W */
    public final void m25516W(int i10) throws Resources.NotFoundException {
        boolean zM80815I0 = C13452e.m80781L().m80815I0();
        boolean zM80819J0 = C13452e.m80781L().m80819J0();
        boolean zM80823K0 = C13452e.m80781L().m80823K0();
        if (i10 != 1 || (!zM80815I0 && !zM80819J0 && !zM80823K0)) {
            this.f19154j.setVisibility(8);
        } else if (this.f19150f && this.f19151g.intValue() != 1) {
            this.f19154j.setVisibility(8);
        } else {
            m25513T();
            this.f19154j.setVisibility(0);
        }
    }

    /* renamed from: X */
    public void m25517X(RecyclerView recyclerView, String str) {
        int iM25509M = m25509M(str);
        RecyclerView.AbstractC0833c0 abstractC0833c0FindViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(iM25509M);
        if (abstractC0833c0FindViewHolderForLayoutPosition instanceof C4082b) {
            C4082b c4082b = (C4082b) abstractC0833c0FindViewHolderForLayoutPosition;
            if (SplitAppUtil.hasSplitAppSuffix(str)) {
                c4082b.f18997x.setVisibility(0);
            } else {
                c4082b.f18997x.setVisibility(8);
            }
            AppDetailsInfo appDetailsInfo = (AppDetailsInfo) this.f19152h.get(iM25509M);
            if (SplitAppUtil.hasSplitAppSuffix(str)) {
                str = SplitAppUtil.getSplitOriAppId(str);
            }
            if (appDetailsInfo.isVirtualApp()) {
                c4082b.f18996w.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(str, null));
            } else if (C14333b.m85483r().containsKey(str)) {
                c4082b.f18996w.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(str));
            } else {
                c4082b.f18996w.setImageDrawable(CloudBackup3rdIconUtil.get3rdDrawable(str));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f19152h.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        if (this.f19152h.get(i10) == null) {
            return 0;
        }
        Object obj = this.f19152h.get(i10);
        return (!(obj instanceof CloudBackSpaceHeaderBean) && (obj instanceof AppDetailsInfo)) ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) throws Resources.NotFoundException {
        AppDetailsInfo appDetailsInfo;
        if (i10 >= this.f19152h.size()) {
            return;
        }
        Object obj = this.f19152h.get(i10);
        if (!(abstractC0833c0 instanceof C4081a)) {
            if (!(abstractC0833c0 instanceof C4082b) || (appDetailsInfo = (AppDetailsInfo) obj) == null || TextUtils.isEmpty(appDetailsInfo.getBackupAppName())) {
                return;
            }
            C4082b c4082b = (C4082b) abstractC0833c0;
            c4082b.m25359Y(this.f19148d);
            c4082b.m25354T(c4082b, appDetailsInfo, i10, this.f19152h.size());
            c4082b.m25362b0(c4082b, appDetailsInfo);
            m25511R(c4082b, i10);
            m25516W(i10);
            return;
        }
        C4081a c4081a = (C4081a) abstractC0833c0;
        c4081a.m25342o0(this.f19152h.size() > 1);
        c4081a.m25341n0(this.f19148d);
        c4081a.m25344q0(this.f19149e);
        this.f19155k = c4081a.m25328a0();
        if (obj instanceof CloudBackSpaceHeaderBean) {
            CloudBackSpaceHeaderBean cloudBackSpaceHeaderBean = (CloudBackSpaceHeaderBean) obj;
            c4081a.m25349v0(cloudBackSpaceHeaderBean, this.f19152h);
            Integer num = cloudBackSpaceHeaderBean.occupySpaceType;
            if (num != null) {
                this.f19151g = num;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        if (i10 == 0) {
            return new C4081a(C0209d.m1195O(this.f19153i) >= 1.75f ? LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.backup_space_item_header_font_scale, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.backup_space_item_header, viewGroup, false), this.f19152h);
        }
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.backup_space_app_detail_list_item, viewGroup, false);
        this.f19154j = (SpanClickText) C12809f.m76831d(viewInflate, R$id.full_data_card_tips);
        return new C4082b(viewInflate, this.f19150f, this.f19149e);
    }
}
