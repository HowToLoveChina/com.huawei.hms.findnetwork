package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.extend.HiCloudItemCheckedChangeListener;
import com.huawei.android.hicloud.p088ui.extend.HiCloudItemView;
import com.huawei.android.hicloud.p088ui.manager.CloudAlbumRouterSpanClick;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.base.bean.SyncItemInfo;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.bean.HiCloudSysParamMapCache;
import com.huawei.hicloud.bean.NewBusinessModelConfigBean;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import p015ak.C0209d;
import p020ap.C1008c;
import p292fn.C9733f;
import p336he.C10155f;
import p371ik.C10527a;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11839m;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class SyncItemRecyclerAdapter extends RecyclerView.AbstractC0838h<C4079e> {

    /* renamed from: d */
    public View f18910d;

    /* renamed from: e */
    public final Context f18911e;

    /* renamed from: g */
    public LinkedHashMap<String, SyncItemInfo> f18913g;

    /* renamed from: h */
    public OnCheckedChangedListener f18914h;

    /* renamed from: i */
    public OnItemClickListener f18915i;

    /* renamed from: j */
    public String f18916j;

    /* renamed from: k */
    public String f18917k;

    /* renamed from: n */
    public GridLayoutManager f18920n;

    /* renamed from: m */
    public int f18919m = -1;

    /* renamed from: f */
    public final ArrayList<SyncItemInfo> f18912f = new ArrayList<>();

    /* renamed from: l */
    public final int f18918l = m25268N();

    public interface OnCheckedChangedListener {
        /* renamed from: j */
        void mo21399j(SyncItemInfo syncItemInfo, HiCloudItemView hiCloudItemView, boolean z10);
    }

    public interface OnItemClickListener {
        /* renamed from: k */
        void mo21407k(SyncItemInfo syncItemInfo, HiCloudItemView hiCloudItemView);
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.SyncItemRecyclerAdapter$a */
    public class C4075a implements HiCloudItemCheckedChangeListener {

        /* renamed from: a */
        public final /* synthetic */ SyncItemInfo f18921a;

        public C4075a(SyncItemInfo syncItemInfo) {
            this.f18921a = syncItemInfo;
        }

        @Override // com.huawei.android.hicloud.p088ui.extend.HiCloudItemCheckedChangeListener
        /* renamed from: d0 */
        public void mo21351d0(HiCloudItemView hiCloudItemView, boolean z10) {
            if (SyncItemRecyclerAdapter.this.f18914h != null) {
                SyncItemRecyclerAdapter.this.f18914h.mo21399j(this.f18921a, hiCloudItemView, z10);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.SyncItemRecyclerAdapter$b */
    public class ViewOnClickListenerC4076b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ SyncItemInfo f18923a;

        /* renamed from: b */
        public final /* synthetic */ C4079e f18924b;

        public ViewOnClickListenerC4076b(SyncItemInfo syncItemInfo, C4079e c4079e) {
            this.f18923a = syncItemInfo;
            this.f18924b = c4079e;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SyncItemRecyclerAdapter.this.f18915i != null) {
                SyncItemRecyclerAdapter.this.f18915i.mo21407k(this.f18923a, this.f18924b.f18932u);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.SyncItemRecyclerAdapter$c */
    public class ViewOnClickListenerC4077c implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ SyncItemInfo f18926a;

        /* renamed from: b */
        public final /* synthetic */ C4079e f18927b;

        public ViewOnClickListenerC4077c(SyncItemInfo syncItemInfo, C4079e c4079e) {
            this.f18926a = syncItemInfo;
            this.f18927b = c4079e;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SyncItemRecyclerAdapter.this.f18915i != null) {
                SyncItemRecyclerAdapter.this.f18915i.mo21407k(this.f18926a, this.f18927b.f18932u);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.SyncItemRecyclerAdapter$d */
    public class ViewOnClickListenerC4078d implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ SyncItemInfo f18929a;

        /* renamed from: b */
        public final /* synthetic */ C4079e f18930b;

        public ViewOnClickListenerC4078d(SyncItemInfo syncItemInfo, C4079e c4079e) {
            this.f18929a = syncItemInfo;
            this.f18930b = c4079e;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SyncItemRecyclerAdapter.this.f18915i != null) {
                SyncItemRecyclerAdapter.this.f18915i.mo21407k(this.f18929a, this.f18930b.f18932u);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.SyncItemRecyclerAdapter$e */
    public class C4079e extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public HiCloudItemView f18932u;

        /* renamed from: v */
        public View f18933v;

        public C4079e(View view) {
            super(view);
            this.f18932u = (HiCloudItemView) view.findViewById(R$id.sync_normal_item_view);
            View viewFindViewById = view.findViewById(R$id.sync_item_divider);
            this.f18933v = viewFindViewById;
            this.f18932u.setOutsideDivider(viewFindViewById);
        }
    }

    public SyncItemRecyclerAdapter(Context context, GridLayoutManager gridLayoutManager) {
        this.f18911e = context;
        this.f18920n = gridLayoutManager;
    }

    /* renamed from: N */
    public static int m25268N() {
        NewBusinessModelConfigBean newBusinessModelConfigBean;
        Integer syncCardItemsNumber;
        try {
            String newBusinessModelConfig = HiCloudSysParamMapCache.getNewBusinessModelConfig();
            if (newBusinessModelConfig == null || TextUtils.isEmpty(newBusinessModelConfig)) {
                HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
                if (hiCloudSysParamMapM60757p == null) {
                    return 2;
                }
                newBusinessModelConfig = hiCloudSysParamMapM60757p.getNewBusinessModelConfig();
            }
            if (newBusinessModelConfig == null || TextUtils.isEmpty(newBusinessModelConfig) || (newBusinessModelConfigBean = (NewBusinessModelConfigBean) C10527a.m64629g(newBusinessModelConfig, NewBusinessModelConfigBean.class)) == null || (syncCardItemsNumber = newBusinessModelConfigBean.getSyncCardItemsNumber()) == null) {
                return 2;
            }
            return syncCardItemsNumber.intValue();
        } catch (Exception e10) {
            C11839m.m70687e("SyncItemRecyclerAdapter", "getSyncCardItemsNumber err:" + e10.getMessage());
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public /* synthetic */ void m25269Q(LinkedHashMap linkedHashMap, ArrayList arrayList, String str) {
        if (!linkedHashMap.containsKey(str) || mo24840R(str)) {
            return;
        }
        SyncItemInfo syncItemInfo = (SyncItemInfo) linkedHashMap.get(str);
        if (syncItemInfo != null && !TextUtils.isEmpty(syncItemInfo.getTitle())) {
            arrayList.add(syncItemInfo);
            return;
        }
        C11839m.m70686d("SyncItemRecyclerAdapter", "addSyncItemInfoArrayList appName title null: " + str);
    }

    /* renamed from: G */
    public void mo24837G(final LinkedHashMap<String, SyncItemInfo> linkedHashMap) {
        if (linkedHashMap == null) {
            this.f18912f.clear();
            m5213j();
            return;
        }
        final ArrayList arrayList = new ArrayList();
        if (C13452e.m80781L().m80887a1()) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(C1008c.m6035v().m6036A(this.f18911e));
            arrayList2.addAll(C1008c.m6035v().m6037B(this.f18911e));
            if (!C13452e.m80781L().m80791C0() && !mo24840R(HNConstants.DataType.MEDIA)) {
                arrayList.add(linkedHashMap.get(HNConstants.DataType.MEDIA));
            }
            arrayList2.forEach(new Consumer() { // from class: ae.h2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f483a.m25269Q(linkedHashMap, arrayList, (String) obj);
                }
            });
        } else {
            Iterator<Map.Entry<String, SyncItemInfo>> it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                SyncItemInfo value = it.next().getValue();
                if (value != null && !mo24840R(value.getId())) {
                    arrayList.add(value);
                }
            }
        }
        C11839m.m70686d("SyncItemRecyclerAdapter", "addSyncItemInfoArrayList tempSyncItems: " + arrayList.size());
        this.f18912f.clear();
        this.f18912f.addAll(arrayList);
        m5213j();
    }

    /* renamed from: H */
    public void m25270H() {
        if (this.f18913g != null) {
            Iterator<SyncItemInfo> it = this.f18912f.iterator();
            if (it.hasNext()) {
                SyncItemInfo next = it.next();
                if (next.isDriveConfig() || next.isSyncConfig()) {
                    this.f18913g.remove(next.getId());
                }
            }
            m25290f0(this.f18913g);
        }
    }

    /* renamed from: I */
    public boolean mo24838I(String str) {
        boolean zM80791C0 = C13452e.m80781L().m80791C0();
        List<String> listM6036A = C1008c.m6035v().m6036A(this.f18911e);
        List<String> listM6037B = C1008c.m6035v().m6037B(this.f18911e);
        if (TextUtils.equals(str, "wlan")) {
            if (C10028c.m62183d0(this.f18911e).m62395t1("funcfg_wlan")) {
                return zM80791C0 && !listM6036A.contains(str);
            }
            return true;
        }
        if (TextUtils.equals(str, "addressbook")) {
            if (C10155f.m63302z() && C11019b.m66371t().m66401U("funcfg_contacts")) {
                return zM80791C0 && !listM6036A.contains(str);
            }
            return true;
        }
        if (TextUtils.equals(str, "notepad")) {
            if (C10155f.m63252E() && C11019b.m66371t().m66401U("funcfg_notes") && C0209d.m1215U1(this.f18911e)) {
                return zM80791C0 && !listM6036A.contains(str);
            }
            return true;
        }
        if (TextUtils.equals(str, "browser")) {
            if (!C10155f.m63296t(this.f18911e) || C0209d.m1293p1()) {
                return true;
            }
            return zM80791C0 && !listM6036A.contains(str);
        }
        if (TextUtils.equals(str, "calendar")) {
            if (C10155f.m63297u() && C11019b.m66371t().m66401U("funcfg_calendar")) {
                return zM80791C0 && !listM6036A.contains(str);
            }
            return true;
        }
        if (TextUtils.equals(str, HNConstants.DataType.MEDIA)) {
            if (!C10028c.m62183d0(this.f18911e).m62395t1("funcfg_gallery") || C0209d.m1293p1()) {
                return true;
            }
            return zM80791C0 && !listM6036A.contains(str);
        }
        if (!zM80791C0 || listM6036A.contains(str)) {
            return (zM80791C0 || listM6037B.contains(str) || listM6036A.contains(str)) ? false : true;
        }
        return true;
    }

    /* renamed from: J */
    public final boolean m25271J(String str) {
        if (TextUtils.equals(str, "wlan")) {
            return !C10028c.m62183d0(this.f18911e).m62395t1("funcfg_wlan");
        }
        if (TextUtils.equals(str, "addressbook")) {
            return (C10155f.m63302z() && C11019b.m66371t().m66401U("funcfg_contacts")) ? false : true;
        }
        if (TextUtils.equals(str, "notepad")) {
            return (C10155f.m63252E() && C11019b.m66371t().m66401U("funcfg_notes") && C0209d.m1215U1(this.f18911e)) ? false : true;
        }
        if (TextUtils.equals(str, "browser")) {
            return !C10155f.m63296t(this.f18911e) || C0209d.m1293p1();
        }
        if (TextUtils.equals(str, "calendar")) {
            return (C10155f.m63297u() && C11019b.m66371t().m66401U("funcfg_calendar")) ? false : true;
        }
        if (TextUtils.equals(str, HNConstants.DataType.MEDIA)) {
            return !C10028c.m62183d0(this.f18911e).m62395t1("funcfg_gallery") || C0209d.m1293p1();
        }
        return false;
    }

    /* renamed from: K */
    public ArrayList<SyncItemInfo> m25272K(LinkedHashMap<String, SyncItemInfo> linkedHashMap) {
        Iterator<SyncItemInfo> it = this.f18912f.iterator();
        ArrayList<SyncItemInfo> arrayList = new ArrayList<>();
        if (it.hasNext()) {
            while (it.hasNext()) {
                SyncItemInfo next = it.next();
                if (next.isDriveConfig()) {
                    arrayList.add(next);
                }
            }
        } else if (linkedHashMap != null) {
            Iterator<Map.Entry<String, SyncItemInfo>> it2 = linkedHashMap.entrySet().iterator();
            while (it2.hasNext()) {
                SyncItemInfo value = it2.next().getValue();
                if (value != null && value.isDriveConfig()) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: L */
    public final SyncItemInfo m25273L(int i10) {
        ArrayList<SyncItemInfo> arrayList = this.f18912f;
        if (arrayList == null || arrayList.isEmpty() || i10 >= this.f18912f.size()) {
            return null;
        }
        return this.f18912f.get(i10);
    }

    /* renamed from: M */
    public SyncItemInfo m25274M(String str) {
        Iterator<SyncItemInfo> it = this.f18912f.iterator();
        while (it.hasNext()) {
            SyncItemInfo next = it.next();
            if (next.isSyncConfig()) {
                if (next.getId().equals(str)) {
                    return next;
                }
            } else if (next.isDriveConfig() && next.getId().equals(str)) {
                return next;
            }
        }
        C11839m.m70687e("SyncItemRecyclerAdapter", "no module, moduleName = " + str);
        return null;
    }

    /* renamed from: O */
    public SyncItemInfo m25275O(String str) {
        LinkedHashMap<String, SyncItemInfo> linkedHashMap;
        if (TextUtils.isEmpty(str) || (linkedHashMap = this.f18913g) == null) {
            return null;
        }
        return linkedHashMap.get(str);
    }

    /* renamed from: P */
    public ArrayList<SyncItemInfo> m25276P(LinkedHashMap<String, SyncItemInfo> linkedHashMap) {
        Iterator<SyncItemInfo> it = this.f18912f.iterator();
        ArrayList<SyncItemInfo> arrayList = new ArrayList<>();
        if (it.hasNext()) {
            while (it.hasNext()) {
                SyncItemInfo next = it.next();
                if (next.isSyncConfig() || next.isDriveConfig()) {
                    arrayList.add(next);
                }
            }
        } else if (linkedHashMap != null) {
            Iterator<Map.Entry<String, SyncItemInfo>> it2 = linkedHashMap.entrySet().iterator();
            while (it2.hasNext()) {
                SyncItemInfo value = it2.next().getValue();
                if (value != null && (value.isSyncConfig() || value.isDriveConfig())) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: R */
    public boolean mo24840R(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return C13452e.m80781L().m80887a1() ? mo24838I(str) : m25271J(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public void mo723s(C4079e c4079e, int i10) throws Resources.NotFoundException {
        SyncItemInfo syncItemInfoM25273L = m25273L(i10);
        if (syncItemInfoM25273L == null) {
            c4079e.f4327a.setVisibility(8);
            return;
        }
        c4079e.f4327a.setVisibility(0);
        String title = syncItemInfoM25273L.getTitle();
        String id2 = syncItemInfoM25273L.getId();
        Drawable image = syncItemInfoM25273L.getImage();
        String statusText = syncItemInfoM25273L.getStatusText();
        boolean zIsShowSwitch = syncItemInfoM25273L.isShowSwitch();
        boolean zIsCheckedProgrammatically = syncItemInfoM25273L.isCheckedProgrammatically();
        String subTitleLoadingText = syncItemInfoM25273L.getSubTitleLoadingText();
        c4079e.f18932u.setSyncItemView(true);
        c4079e.f18932u.setShowSwitch(zIsShowSwitch);
        if (syncItemInfoM25273L.isShowLoading()) {
            c4079e.f18932u.m23978i();
            c4079e.f18932u.m23963C();
        } else {
            c4079e.f18932u.m23976g();
            if (zIsShowSwitch) {
                c4079e.f18932u.m23969I();
            }
            if (syncItemInfoM25273L.isShowSwitchLayout()) {
                c4079e.f18932u.m23968H();
            }
            if (syncItemInfoM25273L.isShowStatusLayout()) {
                c4079e.f18932u.m23965E();
            }
        }
        c4079e.f18932u.setTitle(title);
        if (image != null) {
            c4079e.f18932u.setImage(image);
        } else {
            c4079e.f18932u.m23974e();
        }
        if (!TextUtils.isEmpty(statusText)) {
            c4079e.f18932u.setStatusText(statusText);
        }
        if (!TextUtils.isEmpty(subTitleLoadingText)) {
            c4079e.f18932u.setSubTitleLoadingText(subTitleLoadingText);
        }
        if (syncItemInfoM25273L.isNoSubTitle()) {
            c4079e.f18932u.m23990w();
        }
        String linkClickText = syncItemInfoM25273L.getLinkClickText();
        String subTitleSpanClickText = syncItemInfoM25273L.getSubTitleSpanClickText();
        if (!TextUtils.isEmpty(linkClickText) && !TextUtils.isEmpty(subTitleSpanClickText)) {
            c4079e.f18932u.m23991x(subTitleSpanClickText, linkClickText, new CloudAlbumRouterSpanClick(this.f18911e));
        }
        boolean zIsShowSubTitle = syncItemInfoM25273L.isShowSubTitle();
        String subTitleText = syncItemInfoM25273L.getSubTitleText();
        if (zIsShowSubTitle) {
            c4079e.f18932u.m23966F();
            if (!TextUtils.isEmpty(subTitleText)) {
                c4079e.f18932u.setSubTitleText(subTitleText);
            }
        } else {
            c4079e.f18932u.m23977h();
        }
        if (syncItemInfoM25273L.isHideTip()) {
            c4079e.f18932u.m23979j();
        }
        m25282X(id2, c4079e, zIsCheckedProgrammatically);
        if (!syncItemInfoM25273L.isSubUserDisable() || C0209d.m1166E1()) {
            c4079e.f18932u.m23972c();
        } else {
            c4079e.f18932u.m23970a();
        }
        m25285a0(c4079e, syncItemInfoM25273L);
        m25291g0(c4079e, i10, image, syncItemInfoM25273L);
        c4079e.f18932u.setOnClickListener(null);
        c4079e.f18932u.m23989v();
        c4079e.f18932u.m23987t();
        c4079e.f18932u.setItemOnCheckedChangeListener(new C4075a(syncItemInfoM25273L));
        if (TextUtils.isEmpty(id2) && syncItemInfoM25273L.isDiskItem()) {
            c4079e.f18932u.setOnClickListener(new ViewOnClickListenerC4076b(syncItemInfoM25273L, c4079e));
            c4079e.f18932u.setBackground(this.f18911e.getDrawable(R$drawable.storage_manage_cardview_list_selector));
        }
        if (!TextUtils.isEmpty(id2) && id2.equals(HNConstants.DataType.MEDIA)) {
            c4079e.f18932u.setOnClickListener(new ViewOnClickListenerC4077c(syncItemInfoM25273L, c4079e));
            c4079e.f18932u.setBackground(this.f18911e.getDrawable(R$drawable.storage_manage_cardview_list_selector));
        }
        if (TextUtils.isEmpty(id2) || !id2.equals("notepad")) {
            return;
        }
        if (syncItemInfoM25273L.isOnClick()) {
            c4079e.f18932u.setOnClickListener(new ViewOnClickListenerC4078d(syncItemInfoM25273L, c4079e));
            c4079e.f18932u.setBackground(this.f18911e.getDrawable(R$drawable.storage_manage_cardview_list_selector));
        } else {
            c4079e.f18932u.setOnClickListener(null);
            c4079e.f18932u.setBackground(null);
            c4079e.f18932u.setClickable(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public C4079e mo724u(ViewGroup viewGroup, int i10) {
        this.f18910d = LayoutInflater.from(this.f18911e).inflate(R$layout.sync_hicloud_item, (ViewGroup) null, false);
        return new C4079e(this.f18910d);
    }

    /* renamed from: U */
    public void m25279U(SyncItemInfo syncItemInfo) {
        if (this.f18913g == null) {
            C11839m.m70688i("SyncItemRecyclerAdapter", "refreshSyncItemInfo currentMap null");
            return;
        }
        if (syncItemInfo == null) {
            C11839m.m70688i("SyncItemRecyclerAdapter", "refreshSyncItemInfo syncItemInfo null");
            return;
        }
        String id2 = syncItemInfo.getId();
        if (TextUtils.isEmpty(id2)) {
            C11839m.m70688i("SyncItemRecyclerAdapter", "refreshSyncItemInfo id null");
        } else {
            this.f18913g.put(id2, syncItemInfo);
            m25290f0(this.f18913g);
        }
    }

    /* renamed from: V */
    public final void m25280V(String str, C4079e c4079e) {
        Bitmap bitmapM70501B = C11829c.m70501B(str);
        if (bitmapM70501B == null) {
            c4079e.f18932u.m23974e();
        } else {
            c4079e.f18932u.setImage(new BitmapDrawable((Resources) null, bitmapM70501B));
        }
    }

    /* renamed from: W */
    public final void m25281W(SyncItemInfo syncItemInfo, C4079e c4079e) {
        if (NotifyUtil.HI_NOTE_SYNC_TYPE.equals(syncItemInfo.getId()) && C0209d.m1293p1()) {
            c4079e.f18932u.setImage(ResourcesCompat.getDrawable(this.f18911e.getResources(), R$drawable.hinote_sync_icon, null));
        } else {
            m25280V(syncItemInfo.getIconPath(), c4079e);
        }
    }

    /* renamed from: X */
    public final void m25282X(String str, C4079e c4079e, boolean z10) {
        if ((!TextUtils.isEmpty(this.f18916j) && this.f18916j.equals(str)) || (!TextUtils.isEmpty(this.f18917k) && this.f18917k.equals(str))) {
            c4079e.f18932u.setCheckedProgrammatically(true);
            return;
        }
        c4079e.f18932u.setCheckedProgrammatically(z10);
        if (z10 || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals(this.f18917k)) {
            this.f18917k = "";
        }
        if (str.equals(this.f18916j)) {
            this.f18916j = "";
        }
    }

    /* renamed from: Y */
    public void m25283Y(OnCheckedChangedListener onCheckedChangedListener) {
        this.f18914h = onCheckedChangedListener;
    }

    /* renamed from: Z */
    public void m25284Z(OnItemClickListener onItemClickListener) {
        this.f18915i = onItemClickListener;
    }

    /* renamed from: a0 */
    public final void m25285a0(C4079e c4079e, SyncItemInfo syncItemInfo) throws Resources.NotFoundException {
        if (syncItemInfo.isSyncConfig() || syncItemInfo.isDriveConfig()) {
            c4079e.f18932u.m23989v();
            c4079e.f18932u.m23971b();
            c4079e.f18932u.m23969I();
            c4079e.f18932u.m23962B();
            if (!syncItemInfo.isSyncConfig()) {
                if (syncItemInfo.isDriveConfig()) {
                    if (!C0209d.m1166E1() && !syncItemInfo.isSubUser()) {
                        c4079e.f18932u.m23970a();
                    }
                    c4079e.f18932u.setTag(syncItemInfo.getId());
                    c4079e.f18932u.setTitle(syncItemInfo.getTitle());
                    c4079e.f18932u.m23990w();
                    m25289e0(syncItemInfo, c4079e);
                    m25280V(syncItemInfo.getIconPath(), c4079e);
                    return;
                }
                return;
            }
            c4079e.f18932u.m23969I();
            c4079e.f18932u.setShowSwitch(true);
            if (!C0209d.m1166E1() && !syncItemInfo.isSubUser()) {
                c4079e.f18932u.m23970a();
            }
            String id2 = syncItemInfo.getId();
            c4079e.f18932u.setTag(id2);
            c4079e.f18932u.setTitle(syncItemInfo.getTitle());
            m25282X(id2, c4079e, syncItemInfo.isSwitchStatus());
            m25288d0(syncItemInfo, c4079e);
            m25281W(syncItemInfo, c4079e);
        }
    }

    /* renamed from: b0 */
    public void m25286b0(String str) {
        this.f18917k = str;
        if (TextUtils.isEmpty(str)) {
            m5213j();
        }
    }

    /* renamed from: c0 */
    public void m25287c0(String str) {
        this.f18916j = str;
        if (TextUtils.isEmpty(str)) {
            m5213j();
        }
    }

    /* renamed from: d0 */
    public final void m25288d0(SyncItemInfo syncItemInfo, C4079e c4079e) throws Resources.NotFoundException {
        if (syncItemInfo.getSyncItemSubtitleStatus() == 0) {
            c4079e.f18932u.m23990w();
            return;
        }
        if (syncItemInfo.getSyncItemSubtitleStatus() == 1) {
            if (TextUtils.isEmpty(syncItemInfo.getSubStringText())) {
                return;
            }
            c4079e.f18932u.setSubTitleLoadingText(syncItemInfo.getSubStringText());
        } else {
            if (syncItemInfo.getSyncItemSubtitleStatus() != 2 || TextUtils.isEmpty(syncItemInfo.getSubStringText())) {
                return;
            }
            c4079e.f18932u.setSubTitleText(syncItemInfo.getSubStringText());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        if (MainActivity.f15169x5 || this.f18912f.size() <= this.f18918l) {
            return this.f18912f.size();
        }
        C11839m.m70689w("SyncItemRecyclerAdapter", "syncCardItemsNumber: " + this.f18918l);
        return this.f18918l;
    }

    /* renamed from: e0 */
    public final void m25289e0(SyncItemInfo syncItemInfo, C4079e c4079e) {
        c4079e.f18932u.m23969I();
        m25282X(syncItemInfo.getId(), c4079e, syncItemInfo.isSwitchStatus());
    }

    /* renamed from: f0 */
    public void m25290f0(LinkedHashMap<String, SyncItemInfo> linkedHashMap) {
        GridLayoutManager gridLayoutManager = this.f18920n;
        if (gridLayoutManager != null) {
            int spanCount = gridLayoutManager.getSpanCount();
            if (mo721e() <= 1 || !C11829c.m70511E0(this.f18911e)) {
                if (spanCount == 2) {
                    this.f18920n.setSpanCount(1);
                }
            } else if (spanCount == 1) {
                this.f18920n.setSpanCount(2);
            }
        }
        m25292h0(linkedHashMap);
        C11839m.m70688i("SyncItemRecyclerAdapter", "setSyncItemInfosNotify notify");
    }

    /* renamed from: g0 */
    public final void m25291g0(C4079e c4079e, int i10, Drawable drawable, SyncItemInfo syncItemInfo) {
        if (i10 >= mo721e() - this.f18919m) {
            c4079e.f18932u.m23973d();
            return;
        }
        boolean z10 = false;
        boolean z11 = drawable != null;
        if ((syncItemInfo.isDriveConfig() || syncItemInfo.isSyncConfig()) && syncItemInfo.isShowDivider()) {
            z10 = true;
        }
        if (z11 || z10) {
            c4079e.f18932u.m23964D();
        } else {
            c4079e.f18932u.m23973d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: h0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m25292h0(java.util.LinkedHashMap<java.lang.String, com.huawei.hicloud.base.bean.SyncItemInfo> r3) {
        /*
            r2 = this;
            android.content.Context r0 = r2.f18911e
            boolean r0 = p514o9.C11829c.m70511E0(r0)
            if (r0 == 0) goto L13
            java.util.ArrayList<com.huawei.hicloud.base.bean.SyncItemInfo> r0 = r2.f18912f
            int r0 = r0.size()
            r1 = 2
            int r0 = r0 % r1
            if (r0 != 0) goto L13
            goto L14
        L13:
            r1 = 1
        L14:
            r2.f18919m = r1
            r2.f18913g = r3
            r2.mo24837G(r3)
            java.lang.String r2 = "SyncItemRecyclerAdapter"
            java.lang.String r3 = "setSyncItemInfo notify"
            p514o9.C11839m.m70688i(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.uiadapter.SyncItemRecyclerAdapter.m25292h0(java.util.LinkedHashMap):void");
    }

    public SyncItemRecyclerAdapter(Context context) {
        this.f18911e = context;
    }
}
