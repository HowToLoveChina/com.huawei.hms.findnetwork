package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.RestoreAggregatedAppUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.cloudbackup.util.ModuleRestoreResultUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.uiadapter.RestoreModuleListAdapter;
import com.huawei.android.hicloud.p088ui.views.CheckMarkView;
import com.huawei.android.hicloud.p088ui.views.CircleProgressView;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.cloudbackup.model.RestoreStatus;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import p514o9.C11839m;
import p514o9.C11842p;
import p618rm.C12580p;
import p709vj.C13452e;
import p783xp.C13843a;
import p848zl.C14333b;
import sk.C12809f;

/* loaded from: classes3.dex */
public class RestoreModuleListAdapter extends BaseAdapter {

    /* renamed from: a */
    public Context f18835a;

    /* renamed from: b */
    public Resources f18836b;

    /* renamed from: c */
    public LayoutInflater f18837c;

    /* renamed from: d */
    public List<CloudRestoreItem> f18838d = new ArrayList();

    /* renamed from: e */
    public boolean f18839e;

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.RestoreModuleListAdapter$a */
    public static class C4065a {

        /* renamed from: a */
        public ImageView f18840a;

        /* renamed from: b */
        public ImageView f18841b;

        /* renamed from: c */
        public ImageView f18842c;

        /* renamed from: d */
        public TextView f18843d;

        /* renamed from: e */
        public TextView f18844e;

        /* renamed from: f */
        public TextView f18845f;

        /* renamed from: g */
        public RelativeLayout f18846g;

        /* renamed from: h */
        public CircleProgressView f18847h;

        /* renamed from: i */
        public CheckMarkView f18848i;

        /* renamed from: j */
        public HwProgressBar f18849j;

        /* renamed from: k */
        public View f18850k;

        /* renamed from: l */
        public View f18851l;

        /* renamed from: m */
        public View f18852m;

        /* renamed from: n */
        public RelativeLayout f18853n;
    }

    public RestoreModuleListAdapter(Context context) {
        this.f18835a = context;
        if (context != null) {
            this.f18836b = context.getResources();
            this.f18837c = (LayoutInflater) this.f18835a.getSystemService("layout_inflater");
        }
    }

    /* renamed from: m */
    public static /* synthetic */ boolean m25170m(String str, CloudRestoreItem cloudRestoreItem) {
        return str.equalsIgnoreCase(cloudRestoreItem.getAppId());
    }

    /* renamed from: n */
    public static /* synthetic */ int m25171n(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
        return C12580p.m75586t(cloudRestoreItem.getAppId(), cloudRestoreItem2.getAppId());
    }

    /* renamed from: A */
    public final void m25172A(C4065a c4065a, RestoreStatus restoreStatus) {
        int current = restoreStatus.getCurrent();
        int count = restoreStatus.getCount();
        long asize = restoreStatus.getAsize();
        long jMin = Math.min(asize, restoreStatus.getBytesDownloadedApp());
        if (restoreStatus.getAppType() == -1 && count == 0) {
            count = 1;
        }
        if (C14333b.m85486u().containsKey(restoreStatus.getAppId())) {
            if (current <= 0 || count <= 0) {
                c4065a.f18844e.setText(this.f18835a.getString(R$string.main_cloudrestoring));
                return;
            } else {
                c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_import_data, this.f18835a.getString(R$string.cloudbackup_backupmedia_tip, C13843a.m83104z(Integer.valueOf(current)), C13843a.m83104z(Integer.valueOf(count)))));
                return;
            }
        }
        if (asize > 0) {
            TextView textView = c4065a.f18844e;
            Context context = this.f18835a;
            textView.setText(context.getString(R$string.cloudbackup_restore_downloading_data_size, RestoreProgress.formatData(context, jMin), RestoreProgress.formatData(this.f18835a, asize)));
        } else if (current <= 0 || count <= 0) {
            c4065a.f18844e.setText(this.f18835a.getString(R$string.main_cloudrestoring));
        } else {
            c4065a.f18844e.setText(this.f18835a.getString(R$string.cloudbackup_downloading, C2783d.m16075C(current)));
        }
    }

    /* renamed from: B */
    public final void m25173B(C4065a c4065a, RestoreStatus restoreStatus, boolean z10) {
        CloudRestoreItem cloudRestoreItem = (CloudRestoreItem) restoreStatus;
        if (cloudRestoreItem == null || cloudRestoreItem.m29202r() == null || cloudRestoreItem.m29202r().size() <= 1) {
            if (z10) {
                c4065a.f18851l.setVisibility(0);
                c4065a.f18842c.setVisibility(0);
                c4065a.f18850k.setVisibility(8);
                return;
            }
            return;
        }
        int iM80916g0 = C13452e.m80781L().m80916g0();
        if (iM80916g0 == 0 || iM80916g0 == 1) {
            return;
        }
        c4065a.f18851l.setVisibility(8);
        c4065a.f18842c.setVisibility(8);
        c4065a.f18850k.setVisibility(0);
    }

    /* renamed from: C */
    public void m25174C(boolean z10) {
        this.f18839e = z10;
    }

    /* renamed from: D */
    public void m25175D(List<CloudRestoreItem> list) {
        this.f18838d = list;
        m25185g(list);
    }

    /* renamed from: E */
    public final void m25176E(C4065a c4065a, RestoreStatus restoreStatus) throws Resources.NotFoundException {
        switch (restoreStatus.getStatus()) {
            case -8:
                m25195t(c4065a, this.f18835a.getString(R$string.restoring_failed_by_module_deleted), restoreStatus);
                break;
            case -6:
                m25195t(c4065a, this.f18835a.getString(R$string.item_app_not_compatible), restoreStatus);
                break;
            case -5:
                m25195t(c4065a, this.f18835a.getString(R$string.item_app_no_exist), restoreStatus);
                break;
            case -4:
                m25195t(c4065a, this.f18835a.getString(R$string.item_hm_un_support_tip), restoreStatus);
                break;
            case -3:
                if (!RestoreUtil.isHiCreatePromptNotSupportRestore(restoreStatus)) {
                    m25195t(c4065a, this.f18835a.getString(R$string.item_clone_un_support_tip), restoreStatus);
                    break;
                } else {
                    m25195t(c4065a, this.f18835a.getString(R$string.restore_new_recovery_not_supported), restoreStatus);
                    break;
                }
            case -2:
                m25195t(c4065a, this.f18835a.getString(R$string.item_app_foreground_tip), restoreStatus);
                break;
            case -1:
                m25195t(c4065a, this.f18835a.getString(R$string.restore_new_recovery_not_supported), restoreStatus);
                break;
            case 0:
                m25194r(c4065a, restoreStatus);
                break;
            case 1:
                m25191o(c4065a);
                break;
            case 2:
                m25196v(c4065a, restoreStatus);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                m25198y(c4065a, restoreStatus);
                break;
            case 8:
                if (restoreStatus.getType() != 1) {
                    int iM80916g0 = C13452e.m80781L().m80916g0();
                    C11839m.m70688i("RestoreModuleListAdapter", "buildView appId :restoreStatus" + iM80916g0);
                    if (iM80916g0 != 5 && iM80916g0 != 8) {
                        mo24916u(c4065a, restoreStatus);
                        break;
                    } else {
                        m25197w(c4065a, restoreStatus);
                        break;
                    }
                } else {
                    mo24917x(c4065a, restoreStatus);
                    break;
                }
                break;
        }
    }

    /* renamed from: F */
    public final void m25177F(C4065a c4065a, int i10) {
        if (i10 == getCount() - 1) {
            if (i10 == 0) {
                c4065a.f18853n.setBackground(this.f18835a.getDrawable(R$drawable.storage_manage_cardview_list_shape_white));
                return;
            } else {
                c4065a.f18853n.setBackground(this.f18835a.getDrawable(R$drawable.cardview_list_bottom_shape_white));
                return;
            }
        }
        if (i10 == 0) {
            c4065a.f18853n.setBackground(this.f18835a.getDrawable(R$drawable.cardview_list_top_shape_white));
        } else {
            c4065a.f18853n.setBackground(this.f18835a.getDrawable(R$color.storage_manager_card_bg));
        }
    }

    /* renamed from: G */
    public void m25178G(C4065a c4065a) {
        c4065a.f18846g.setVisibility(0);
        c4065a.f18848i.setVisibility(0);
        c4065a.f18842c.setVisibility(8);
        c4065a.f18842c.setVisibility(8);
        c4065a.f18848i.m25691f();
        c4065a.f18848i.m25692g();
        c4065a.f18847h.setVisibility(0);
        c4065a.f18847h.setProgress(100);
    }

    /* renamed from: H */
    public void m25179H(View view, int i10) throws Resources.NotFoundException {
        List<CloudRestoreItem> list;
        if (view == null || this.f18836b == null || (list = this.f18838d) == null || i10 >= list.size()) {
            return;
        }
        m25182d((C4065a) view.getTag(), this.f18838d.get(i10), i10);
    }

    /* renamed from: I */
    public void m25180I(View view, int i10) throws Resources.NotFoundException {
        List<CloudRestoreItem> list;
        if (view == null || this.f18836b == null || (list = this.f18838d) == null || i10 >= list.size()) {
            return;
        }
        C4065a c4065a = (C4065a) view.getTag();
        m25181c(c4065a, this.f18838d.get(i10));
        m25182d(c4065a, this.f18838d.get(i10), i10);
    }

    /* renamed from: c */
    public final void m25181c(C4065a c4065a, RestoreStatus restoreStatus) {
        String appId = restoreStatus.getAppId();
        if (SplitAppUtil.hasSplitAppSuffix(appId)) {
            c4065a.f18841b.setVisibility(0);
            appId = SplitAppUtil.getSplitOriAppId(appId);
        } else {
            c4065a.f18841b.setVisibility(8);
        }
        if ("virtual.hmos.sync.switch.status".equals(appId)) {
            appId = "virtual.sync.switch.status";
        }
        Drawable drawable = C14333b.m85483r().containsKey(appId) ? CloudBackup3rdIconUtil.getDrawable(appId) : CloudBackup3rdIconUtil.get3rdDrawable(appId);
        c4065a.f18840a.setTag(restoreStatus.getAppId());
        c4065a.f18840a.setImageDrawable(drawable);
    }

    /* renamed from: d */
    public final void m25182d(C4065a c4065a, RestoreStatus restoreStatus, int i10) throws Resources.NotFoundException {
        int uid = restoreStatus.getUid();
        String appId = restoreStatus.getAppId();
        int current = restoreStatus.getCurrent();
        int count = restoreStatus.getCount();
        C11839m.m70688i("RestoreModuleListAdapter", "buildView appId " + appId + " uid = " + uid + " statue " + restoreStatus.getStatus() + " type = " + restoreStatus.getType() + " current = " + current);
        c4065a.f18843d.setText(restoreStatus.getAppName());
        c4065a.f18850k.setVisibility(((this.f18839e && current < count && restoreStatus.isShowChildList()) || (!this.f18839e && restoreStatus.isShowChildList())) ? 0 : 8);
        m25176E(c4065a, restoreStatus);
        c4065a.f18852m.setVisibility(getCount() - 1 == i10 ? 8 : 0);
        c4065a.f18845f.setMaxWidth(C11842p.m70801d0());
    }

    /* renamed from: e */
    public final C4065a m25183e(View view) {
        C4065a c4065a = new C4065a();
        c4065a.f18840a = (ImageView) C12809f.m76831d(view, R$id.manage_item_icon);
        c4065a.f18841b = (ImageView) C12809f.m76831d(view, R$id.manage_item_icon_badge);
        c4065a.f18842c = (ImageView) C12809f.m76831d(view, R$id.fail_image);
        c4065a.f18843d = (TextView) C12809f.m76831d(view, R$id.appid_tv);
        c4065a.f18844e = (TextView) C12809f.m76831d(view, R$id.count_tv);
        c4065a.f18846g = (RelativeLayout) C12809f.m76831d(view, R$id.rl_success);
        c4065a.f18847h = (CircleProgressView) C12809f.m76831d(view, R$id.bc_circle_progress_view);
        c4065a.f18848i = (CheckMarkView) C12809f.m76831d(view, R$id.check_mark_view);
        c4065a.f18849j = (HwProgressBar) C12809f.m76831d(view, R$id.item_progress);
        c4065a.f18845f = (TextView) C12809f.m76831d(view, R$id.app_size_tv);
        c4065a.f18852m = C12809f.m76831d(view, R$id.list_item_divider);
        c4065a.f18853n = (RelativeLayout) C12809f.m76831d(view, R$id.restore_bg_layout);
        c4065a.f18850k = C12809f.m76831d(view, R$id.expandable_iv);
        c4065a.f18851l = C12809f.m76831d(view, R$id.restore_right_layout);
        return c4065a;
    }

    /* renamed from: f */
    public final void m25184f(C4065a c4065a, RestoreStatus restoreStatus) {
        int count = restoreStatus.getCount();
        if (restoreStatus.isSystemShowModule()) {
            int current = restoreStatus.getCurrent();
            if (count > 0) {
                c4065a.f18844e.setText(ModuleRestoreResultUtil.getWaitingTips(this.f18835a, restoreStatus, count, this.f18835a.getString(R$string.cloudbackup_backupmedia_tip, C13843a.m83104z(Integer.valueOf(current)), C13843a.m83104z(Integer.valueOf(count)))));
            } else {
                c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_new_wait_2));
            }
        }
        if (restoreStatus.is3rdAppType()) {
            c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_new_wait_2));
        } else {
            int current2 = restoreStatus.getCurrent();
            if (count == 0) {
                count = 1;
            }
            c4065a.f18844e.setText(ModuleRestoreResultUtil.getWaitingTips(this.f18835a, restoreStatus, count, this.f18835a.getString(R$string.cloudbackup_backupmedia_tip, String.valueOf(current2), C13843a.m83104z(Integer.valueOf(count)))));
        }
        c4065a.f18851l.setVisibility(8);
        c4065a.f18844e.setTextColor(this.f18836b.getColor(R$color.emui_color_gray_7));
        c4065a.f18846g.setVisibility(8);
        c4065a.f18849j.setVisibility(8);
        c4065a.f18845f.setVisibility(8);
        if (restoreStatus.isShowChildList() || !RestoreAggregatedAppUtil.isShowAggregatedDialog((CloudRestoreItem) restoreStatus)) {
            return;
        }
        m25173B(c4065a, restoreStatus, false);
    }

    /* renamed from: g */
    public final List<CloudRestoreItem> m25185g(List<CloudRestoreItem> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list);
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            CloudRestoreItem cloudRestoreItem = (CloudRestoreItem) it.next();
            if (SplitAppUtil.hasSplitAppSuffix(cloudRestoreItem.getAppId())) {
                String splitOriAppId = SplitAppUtil.getSplitOriAppId(cloudRestoreItem.getAppId());
                String splitAppType = SplitAppUtil.getSplitAppType(cloudRestoreItem.getAppId());
                if (SplitAppUtil.isTwinApp(splitAppType, splitOriAppId)) {
                    cloudRestoreItem.setOriBackupAppName(splitOriAppId);
                    cloudRestoreItem.setSplitApkType(splitAppType);
                    List arrayList2 = map.get(splitOriAppId) != null ? (List) map.get(splitOriAppId) : new ArrayList();
                    if (arrayList2 != null) {
                        arrayList2.add(cloudRestoreItem);
                        map.put(splitOriAppId, arrayList2);
                    }
                    it.remove();
                }
            }
        }
        if (!map.isEmpty()) {
            for (final String str : map.keySet()) {
                Optional optionalFindFirst = arrayList.stream().filter(new Predicate() { // from class: ae.a2
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return RestoreModuleListAdapter.m25170m(str, (CloudRestoreItem) obj);
                    }
                }).findFirst();
                if (optionalFindFirst.isPresent()) {
                    CloudRestoreItem cloudRestoreItem2 = (CloudRestoreItem) optionalFindFirst.get();
                    List<CloudRestoreItem> list2 = (List) map.get(str);
                    if (list2 != null) {
                        list2.sort(new Comparator() { // from class: ae.b2
                            @Override // java.util.Comparator
                            public final int compare(Object obj, Object obj2) {
                                return RestoreModuleListAdapter.m25171n((CloudRestoreItem) obj, (CloudRestoreItem) obj2);
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

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18838d.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        List<CloudRestoreItem> list;
        CloudRestoreItem cloudRestoreItem;
        C4065a c4065aM25183e;
        View viewM76832e;
        if (this.f18836b == null || (list = this.f18838d) == null || i10 >= list.size() || (cloudRestoreItem = this.f18838d.get(i10)) == null) {
            return view;
        }
        if (view == null) {
            viewM76832e = C12809f.m76832e(this.f18837c, R$layout.restore_content_detail_item);
            c4065aM25183e = m25183e(viewM76832e);
            viewM76832e.setTag(c4065aM25183e);
        } else {
            c4065aM25183e = (C4065a) view.getTag();
            viewM76832e = view;
        }
        if (c4065aM25183e == null) {
            return view;
        }
        m25181c(c4065aM25183e, cloudRestoreItem);
        m25182d(c4065aM25183e, cloudRestoreItem, i10);
        m25177F(c4065aM25183e, i10);
        return viewM76832e;
    }

    /* renamed from: h */
    public final void m25186h(C4065a c4065a, RestoreStatus restoreStatus) {
        c4065a.f18851l.setVisibility(8);
        c4065a.f18844e.setTextColor(this.f18836b.getColor(R$color.emui_color_gray_7));
        int count = restoreStatus.getCount();
        int current = restoreStatus.getCurrent();
        if (count <= current) {
            c4065a.f18851l.setVisibility(0);
            c4065a.f18846g.setVisibility(8);
            c4065a.f18849j.setVisibility(8);
            c4065a.f18842c.setVisibility(0);
            c4065a.f18845f.setVisibility(8);
            c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_failed));
            return;
        }
        if (current > 0) {
            c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_partial_fail));
        } else {
            c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_failed));
        }
        if (!"thirdApp".equals(restoreStatus.getAppId())) {
            c4065a.f18851l.setVisibility(0);
            c4065a.f18846g.setVisibility(8);
            c4065a.f18849j.setVisibility(8);
            c4065a.f18842c.setVisibility(0);
            c4065a.f18845f.setVisibility(8);
            return;
        }
        int i10 = count - current;
        c4065a.f18845f.setText(this.f18836b.getQuantityString(R$plurals.restore_item_restoration_failed, i10, Integer.valueOf(i10)).replace(String.valueOf(i10), C13843a.m83104z(Integer.valueOf(i10))));
        c4065a.f18845f.setVisibility(0);
        c4065a.f18851l.setVisibility(8);
        if (current > 0) {
            c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_item_restore_part_completed));
        } else {
            c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_failed));
        }
        if (restoreStatus instanceof CloudRestoreItem) {
            List<CloudRestoreItem> listM29202r = ((CloudRestoreItem) restoreStatus).m29202r();
            boolean z10 = false;
            int i11 = 0;
            for (int i12 = 0; i12 < listM29202r.size(); i12++) {
                if (listM29202r.get(i12).getStatus() == 1) {
                    i11++;
                    z10 = true;
                }
            }
            if (z10) {
                c4065a.f18844e.setText(this.f18835a.getString(R$string.cloudbackup_restore_cancel));
                int i13 = i10 - i11;
                if (i13 <= 0) {
                    c4065a.f18845f.setVisibility(8);
                } else {
                    c4065a.f18845f.setText(this.f18836b.getQuantityString(R$plurals.restore_item_restoration_failed, i13, Integer.valueOf(i13)).replace(String.valueOf(i13), C13843a.m83104z(Integer.valueOf(i13))));
                }
            }
        }
    }

    /* renamed from: i */
    public final void m25187i(C4065a c4065a, RestoreStatus restoreStatus) {
        c4065a.f18851l.setVisibility(8);
        c4065a.f18849j.setVisibility(8);
        c4065a.f18845f.setVisibility(8);
        int count = restoreStatus.getCount();
        int current = restoreStatus.getCurrent();
        if (count > 0) {
            c4065a.f18844e.setText(ModuleRestoreResultUtil.getWaitingTips(this.f18835a, restoreStatus, count, this.f18835a.getString(R$string.cloudbackup_backupmedia_tip, C13843a.m83104z(Integer.valueOf(current)), C13843a.m83104z(Integer.valueOf(count)))));
        } else {
            c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_new_wait_2));
        }
        c4065a.f18844e.setTextColor(this.f18836b.getColor(R$color.emui_color_gray_7));
    }

    /* renamed from: j */
    public final void m25188j(C4065a c4065a, RestoreStatus restoreStatus) {
        c4065a.f18851l.setVisibility(8);
        c4065a.f18844e.setTextColor(this.f18836b.getColor(R$color.emui_color_gray_7));
        int count = restoreStatus.getCount();
        int current = restoreStatus.getCurrent();
        if (count <= current) {
            c4065a.f18845f.setVisibility(8);
            c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_new_failure_restore));
            c4065a.f18844e.setTextColor(this.f18836b.getColor(R$color.emui_functional_red));
            return;
        }
        if (current > 0) {
            c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_completed_not_succeed_part));
        } else {
            c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_completed_not_succeed));
        }
        if (!"thirdApp".equals(restoreStatus.getAppId())) {
            c4065a.f18851l.setVisibility(0);
            c4065a.f18846g.setVisibility(8);
            c4065a.f18849j.setVisibility(8);
            c4065a.f18842c.setVisibility(0);
            c4065a.f18845f.setVisibility(8);
            return;
        }
        int i10 = count - current;
        c4065a.f18845f.setText(this.f18836b.getQuantityString(R$plurals.restore_item_unsuccessful_recovery, i10, Integer.valueOf(i10)).replace(String.valueOf(i10), C13843a.m83104z(Integer.valueOf(i10))));
        c4065a.f18845f.setVisibility(0);
        c4065a.f18851l.setVisibility(8);
        if (current > 0) {
            c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_item_restore_part_completed));
        } else {
            c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_completed_not_succeed));
        }
    }

    /* renamed from: k */
    public final void m25189k(C4065a c4065a, RestoreStatus restoreStatus) {
        int current = restoreStatus.getCurrent();
        int count = restoreStatus.getCount();
        if (count > 0) {
            c4065a.f18844e.setText(this.f18836b.getQuantityString(R$plurals.restore_new_restoring_4, current, this.f18835a.getString(R$string.cloudbackup_backupmedia_tip, C13843a.m83104z(Integer.valueOf(current)), C13843a.m83104z(Integer.valueOf(count)))));
        } else {
            c4065a.f18844e.setText(this.f18835a.getString(R$string.main_cloudrestoring));
        }
        c4065a.f18851l.setVisibility(0);
        c4065a.f18849j.setVisibility(0);
        c4065a.f18849j.setFlickerEnable(true);
        c4065a.f18845f.setVisibility(8);
        c4065a.f18846g.setVisibility(8);
        c4065a.f18844e.setTextColor(this.f18836b.getColor(R$color.emui_color_gray_7));
        c4065a.f18842c.setVisibility(8);
    }

    @Override // android.widget.Adapter
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public RestoreStatus getItem(int i10) {
        List<CloudRestoreItem> list = this.f18838d;
        if (list == null || i10 >= list.size()) {
            return null;
        }
        return this.f18838d.get(i10);
    }

    /* renamed from: o */
    public final void m25191o(C4065a c4065a) {
        c4065a.f18851l.setVisibility(8);
        c4065a.f18844e.setText(this.f18835a.getString(R$string.cloudbackup_restore_cancel));
        c4065a.f18844e.setTextColor(this.f18836b.getColor(R$color.emui_color_gray_7));
        c4065a.f18846g.setVisibility(8);
        c4065a.f18849j.setVisibility(8);
        c4065a.f18845f.setVisibility(8);
    }

    /* renamed from: p */
    public final void m25192p(C4065a c4065a, RestoreStatus restoreStatus) {
        c4065a.f18844e.setTextColor(this.f18836b.getColor(R$color.emui_color_gray_7));
        int count = restoreStatus.getCount();
        if (restoreStatus.getAppType() == -1 && (count = restoreStatus.getCount()) == 0) {
            count = 1;
        }
        if (count <= 0 || !C14333b.m85486u().containsKey(restoreStatus.getAppId())) {
            c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_completed_not_succeed));
        } else {
            int current = restoreStatus.getCurrent();
            int i10 = count - current;
            if (i10 < 0) {
                current = 0;
            } else {
                count = i10;
            }
            String strReplace = this.f18836b.getQuantityString(R$plurals.restore_new_failure_part_data, count, Integer.valueOf(count)).replace(String.valueOf(count), C13843a.m83104z(Integer.valueOf(count)));
            this.f18836b.getQuantityString(R$plurals.restore_new_completed_part_2, current, Integer.valueOf(current)).replace(String.valueOf(current), C13843a.m83104z(Integer.valueOf(current)));
            if (current > 0) {
                c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_completed_not_succeed_part));
            } else {
                c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_completed_not_succeed));
            }
            c4065a.f18845f.setText(strReplace);
            c4065a.f18845f.setVisibility(8);
            c4065a.f18845f.setTextColor(this.f18836b.getColor(R$color.emui_functional_red));
        }
        c4065a.f18846g.setVisibility(8);
        c4065a.f18849j.setVisibility(8);
        m25173B(c4065a, restoreStatus, true);
    }

    /* renamed from: q */
    public final void m25193q(C4065a c4065a, RestoreStatus restoreStatus) {
        c4065a.f18844e.setTextColor(this.f18836b.getColor(R$color.emui_color_gray_7));
        c4065a.f18845f.setVisibility(8);
        int count = restoreStatus.getCount();
        if (restoreStatus.getAppType() == -1 && (count = restoreStatus.getCount()) == 0) {
            count = 1;
        }
        if (count <= 0 || !C14333b.m85486u().containsKey(restoreStatus.getAppId())) {
            c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_failed));
        } else {
            int current = restoreStatus.getCurrent();
            if (count - current >= 0 && current > 0) {
                c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_partial_fail));
            } else {
                c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_failed));
            }
        }
        c4065a.f18846g.setVisibility(8);
        c4065a.f18849j.setVisibility(8);
        m25173B(c4065a, restoreStatus, true);
    }

    /* renamed from: r */
    public final void m25194r(C4065a c4065a, RestoreStatus restoreStatus) {
        if (restoreStatus.isShowChildList()) {
            m25187i(c4065a, restoreStatus);
        } else {
            m25184f(c4065a, restoreStatus);
        }
    }

    /* renamed from: s */
    public void mo24915s(C4065a c4065a, RestoreStatus restoreStatus) {
        if (restoreStatus.is3rdAppType()) {
            m25199z(c4065a, restoreStatus);
        } else {
            m25172A(c4065a, restoreStatus);
        }
        c4065a.f18851l.setVisibility(0);
        c4065a.f18844e.setTextColor(this.f18836b.getColor(R$color.emui_color_gray_7));
        c4065a.f18846g.setVisibility(8);
        c4065a.f18849j.setVisibility(0);
        c4065a.f18845f.setVisibility(8);
        c4065a.f18842c.setVisibility(8);
    }

    /* renamed from: t */
    public final void m25195t(C4065a c4065a, String str, RestoreStatus restoreStatus) throws Resources.NotFoundException {
        c4065a.f18842c.setVisibility(8);
        String appId = restoreStatus.getAppId();
        int current = restoreStatus.getCurrent();
        int count = restoreStatus.getCount();
        if ("thirdApp".equals(appId)) {
            c4065a.f18851l.setVisibility(8);
            int i10 = count - current;
            if (i10 < 0) {
                current = 0;
            } else {
                count = i10;
            }
            if (current > 0) {
                c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_item_restore_part_completed));
            } else {
                c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_failed));
            }
            c4065a.f18845f.setText(this.f18836b.getQuantityString(R$plurals.restore_item_restoration_failed, count, Integer.valueOf(count)).replace(String.valueOf(count), C13843a.m83104z(Integer.valueOf(count))));
            c4065a.f18845f.setVisibility(0);
        } else if ("sysdata".equals(appId)) {
            c4065a.f18851l.setVisibility(8);
            int count2 = restoreStatus.getCount() - current;
            if (count2 < 0) {
                count2 = restoreStatus.getCount();
                current = 0;
            }
            c4065a.f18844e.setText(this.f18836b.getString(R$string.restore_new_completed_part, this.f18836b.getQuantityString(R$plurals.backup_backed_total, current, Integer.valueOf(current), Integer.valueOf(count)).replace(String.valueOf(current), C13843a.m83104z(Integer.valueOf(current))).replace(String.valueOf(count), C13843a.m83104z(Integer.valueOf(count)))));
            c4065a.f18845f.setText(this.f18836b.getQuantityString(R$plurals.restore_new_failure_part_data, count2, Integer.valueOf(count2)).replace(String.valueOf(count2), C13843a.m83104z(Integer.valueOf(count2))));
            c4065a.f18845f.setVisibility(0);
        } else {
            m25173B(c4065a, restoreStatus, true);
            c4065a.f18845f.setVisibility(8);
            CloudRestoreItem cloudRestoreItem = (CloudRestoreItem) restoreStatus;
            if (cloudRestoreItem.m29202r() == null || cloudRestoreItem.m29202r().size() <= 1) {
                c4065a.f18844e.setText(str);
            } else {
                c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_completed_not_succeed));
            }
        }
        c4065a.f18849j.setVisibility(8);
        c4065a.f18846g.setVisibility(8);
        c4065a.f18844e.setTextColor(this.f18836b.getColor(R$color.emui_color_gray_7));
    }

    /* renamed from: u */
    public void mo24916u(C4065a c4065a, RestoreStatus restoreStatus) {
        if (restoreStatus.isShowChildList()) {
            m25188j(c4065a, restoreStatus);
        } else {
            m25192p(c4065a, restoreStatus);
        }
    }

    /* renamed from: v */
    public final void m25196v(C4065a c4065a, RestoreStatus restoreStatus) {
        c4065a.f18851l.setVisibility(8);
        c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_item_restore_paused));
        c4065a.f18844e.setTextColor(this.f18836b.getColor(R$color.emui_color_gray_7));
        c4065a.f18846g.setVisibility(8);
        c4065a.f18849j.setVisibility(8);
        c4065a.f18845f.setVisibility(8);
        if (restoreStatus.isShowChildList() || !RestoreAggregatedAppUtil.isShowAggregatedDialog((CloudRestoreItem) restoreStatus)) {
            return;
        }
        m25173B(c4065a, restoreStatus, false);
    }

    /* renamed from: w */
    public final void m25197w(C4065a c4065a, RestoreStatus restoreStatus) {
        if (restoreStatus.isShowChildList()) {
            m25186h(c4065a, restoreStatus);
        } else {
            m25193q(c4065a, restoreStatus);
        }
    }

    /* renamed from: x */
    public void mo24917x(C4065a c4065a, RestoreStatus restoreStatus) throws Resources.NotFoundException {
        String string;
        int count = restoreStatus.getCount();
        if (restoreStatus.isShowChildList()) {
            if (count == 0) {
                string = this.f18835a.getString(R$string.restore_new_completed);
            } else if ("thirdApp".equals(restoreStatus.getAppId())) {
                string = this.f18836b.getString(R$string.restore_new_completed_part, this.f18836b.getQuantityString(R$plurals.backup_backed_total, count, Integer.valueOf(count), Integer.valueOf(count)).replace(String.valueOf(count), C13843a.m83104z(Integer.valueOf(count))));
            } else {
                string = this.f18836b.getQuantityString(R$plurals.restore_new_completed_part_2, count, Integer.valueOf(count)).replace(String.valueOf(count), C13843a.m83104z(Integer.valueOf(count)));
            }
        } else if (restoreStatus.is3rdAppType() || restoreStatus.isVirtual()) {
            string = this.f18835a.getString(R$string.restore_new_completed);
            if (restoreStatus.getAction() == 1) {
                string = this.f18835a.getString(R$string.cloudbackup_app_restore_failed_no_retry);
            }
        } else {
            if (count == 0) {
                count = 1;
            }
            string = this.f18836b.getQuantityString(R$plurals.restore_new_completed_part_2, count, Integer.valueOf(count)).replace(String.valueOf(count), C13843a.m83104z(Integer.valueOf(count)));
            if (C14333b.m85482q().contains(restoreStatus.getAppId())) {
                string = this.f18835a.getString(R$string.restore_new_completed);
            }
        }
        c4065a.f18844e.setText(string);
        if ("sysdata".equals(restoreStatus.getAppId()) || "thirdApp".equals(restoreStatus.getAppId())) {
            c4065a.f18851l.setVisibility(8);
        } else {
            c4065a.f18851l.setVisibility(0);
        }
        if (this.f18839e && "thirdApp".equals(restoreStatus.getAppId())) {
            c4065a.f18851l.setVisibility(0);
        }
        c4065a.f18844e.setTextColor(this.f18836b.getColor(R$color.emui_color_gray_7));
        c4065a.f18849j.setVisibility(8);
        c4065a.f18845f.setVisibility(8);
        m25178G(c4065a);
    }

    /* renamed from: y */
    public final void m25198y(C4065a c4065a, RestoreStatus restoreStatus) {
        if (!CBAccess.inRestoreTask()) {
            C11839m.m70686d("RestoreModuleListAdapter", "restoring not in restoreTask");
            mo24916u(c4065a, restoreStatus);
        } else if (restoreStatus.isShowChildList()) {
            m25189k(c4065a, restoreStatus);
        } else {
            mo24915s(c4065a, restoreStatus);
        }
    }

    /* renamed from: z */
    public final void m25199z(C4065a c4065a, RestoreStatus restoreStatus) {
        if (RestoreProgress.isPrepare(restoreStatus.getSubStatus())) {
            c4065a.f18844e.setText(R$string.cloudbackup_prepare_data);
            return;
        }
        int current = restoreStatus.getCurrent();
        int status = restoreStatus.getStatus();
        long asize = restoreStatus.getAsize();
        long jMin = Math.min(asize, restoreStatus.getBytesDownloadedApp());
        if (status == 3) {
            c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_new_wait_2));
            return;
        }
        if (status == 4 || status == 5) {
            if (current == 100) {
                c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_new_wait_for_installation));
                return;
            }
            if (asize <= 0) {
                c4065a.f18844e.setText(this.f18835a.getString(R$string.cloudbackup_downloading, C2783d.m16075C(current)));
                return;
            } else {
                TextView textView = c4065a.f18844e;
                Context context = this.f18835a;
                textView.setText(context.getString(R$string.cloudbackup_restore_downloading_data_size, RestoreProgress.formatData(context, jMin), RestoreProgress.formatData(this.f18835a, asize)));
                return;
            }
        }
        if (status == 6) {
            c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_new_installing));
            return;
        }
        if (status != 7) {
            return;
        }
        if (restoreStatus.getSize() == 0) {
            c4065a.f18844e.setText(this.f18835a.getString(R$string.restoring_data));
            return;
        }
        long jMin2 = Math.min(restoreStatus.getPmsAlreadyBytes(), restoreStatus.getSize());
        TextView textView2 = c4065a.f18844e;
        Context context2 = this.f18835a;
        textView2.setText(context2.getString(R$string.restore_import_data_size, RestoreProgress.formatData(context2, jMin2), RestoreProgress.formatData(this.f18835a, restoreStatus.getSize())));
    }
}
