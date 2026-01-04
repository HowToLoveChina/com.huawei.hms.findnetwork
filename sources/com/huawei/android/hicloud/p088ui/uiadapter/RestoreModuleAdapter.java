package com.huawei.android.hicloud.p088ui.uiadapter;

import ae.C0166s1;
import ae.C0169t1;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
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
import com.huawei.android.hicloud.cloudbackup.util.ModuleRestoreResultUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.RestoreMainActivity;
import com.huawei.android.hicloud.p088ui.views.CheckMarkView;
import com.huawei.android.hicloud.p088ui.views.CircleProgressView;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0234s;
import p514o9.C11839m;
import p514o9.C11842p;
import p709vj.C13452e;
import p783xp.C13843a;
import p848zl.C14333b;
import sk.C12809f;

/* loaded from: classes3.dex */
public class RestoreModuleAdapter extends BaseAdapter {

    /* renamed from: a */
    public Context f18817a;

    /* renamed from: b */
    public Resources f18818b;

    /* renamed from: c */
    public LayoutInflater f18819c;

    /* renamed from: d */
    public List<CloudRestoreItem> f18820d = new ArrayList();

    /* renamed from: e */
    public final boolean f18821e;

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.RestoreModuleAdapter$a */
    public static class C4064a {

        /* renamed from: a */
        public ImageView f18822a;

        /* renamed from: b */
        public ImageView f18823b;

        /* renamed from: c */
        public ImageView f18824c;

        /* renamed from: d */
        public RelativeLayout f18825d;

        /* renamed from: e */
        public CircleProgressView f18826e;

        /* renamed from: f */
        public CheckMarkView f18827f;

        /* renamed from: g */
        public TextView f18828g;

        /* renamed from: h */
        public TextView f18829h;

        /* renamed from: i */
        public HwProgressBar f18830i;

        /* renamed from: j */
        public RelativeLayout f18831j;

        /* renamed from: k */
        public ImageView f18832k;

        /* renamed from: l */
        public TextView f18833l;

        /* renamed from: m */
        public TextView f18834m;
    }

    public RestoreModuleAdapter(Context context) {
        this.f18817a = context;
        if (context != null) {
            this.f18818b = context.getResources();
            this.f18819c = (LayoutInflater) this.f18817a.getSystemService("layout_inflater");
        }
        this.f18821e = RestoreUtil.isNewBmRecord();
    }

    /* renamed from: b */
    public static long m25114b(CloudRestoreItem cloudRestoreItem, long j10) {
        long jMin = Math.min(cloudRestoreItem.getBytesDownloaded(), j10);
        if (cloudRestoreItem.m29202r() == null || cloudRestoreItem.m29202r().size() == 0) {
            return jMin;
        }
        String appId = cloudRestoreItem.getAppId();
        return (NavigationUtils.SMS_SCHEMA_PREF.equals(appId) || "chatSms".equals(appId) || "soundrecorder".equals(appId) || "callRecorder".equals(appId) || cloudRestoreItem.m29190O()) ? Math.min(cloudRestoreItem.m29202r().stream().filter(new C0166s1()).mapToLong(new C0169t1()).sum(), j10) : jMin;
    }

    /* renamed from: g */
    public static long m25115g(CloudRestoreItem cloudRestoreItem) {
        long size;
        long asize;
        if (cloudRestoreItem.isHarmonyNext()) {
            return cloudRestoreItem.getSize();
        }
        if (cloudRestoreItem.getBmAppDataType() == 2) {
            size = cloudRestoreItem.getSize();
            asize = cloudRestoreItem.getAsize();
        } else {
            if (1 == cloudRestoreItem.getAction() || TextUtils.equals(cloudRestoreItem.m29203s(), "thirdApp")) {
                return cloudRestoreItem.getAsize();
            }
            if (TextUtils.equals(cloudRestoreItem.m29203s(), "thirdAppData")) {
                return cloudRestoreItem.getSize();
            }
            size = cloudRestoreItem.getSize();
            asize = cloudRestoreItem.getAsize();
        }
        return size + asize;
    }

    /* renamed from: A */
    public void m25116A(CloudRestoreItem cloudRestoreItem) {
        if (cloudRestoreItem == null) {
            return;
        }
        for (CloudRestoreItem cloudRestoreItem2 : this.f18820d) {
            if (cloudRestoreItem2.getAction() != 2) {
                cloudRestoreItem2.update(cloudRestoreItem);
            }
        }
        notifyDataSetChanged();
    }

    /* renamed from: B */
    public final String m25117B(int i10, long j10, long j11) {
        if (i10 == 100 || (j10 > 0 && j10 == j11)) {
            return this.f18817a.getString(R$string.restore_new_wait_for_installation);
        }
        if (j10 <= 0) {
            return this.f18817a.getString(R$string.cloudbackup_downloading, C2783d.m16075C(i10));
        }
        Context context = this.f18817a;
        return context.getString(R$string.cloudbackup_restore_downloading_data_size, RestoreProgress.formatData(context, j11), RestoreProgress.formatData(this.f18817a, j10));
    }

    /* renamed from: a */
    public final C4064a m25118a(View view) {
        C4064a c4064a = new C4064a();
        c4064a.f18825d = (RelativeLayout) C12809f.m76831d(view, R$id.rl_success);
        c4064a.f18826e = (CircleProgressView) C12809f.m76831d(view, R$id.bc_circle_progress_view);
        c4064a.f18827f = (CheckMarkView) C12809f.m76831d(view, R$id.check_mark_view);
        c4064a.f18830i = (HwProgressBar) C12809f.m76831d(view, R$id.item_progress);
        c4064a.f18831j = (RelativeLayout) C12809f.m76831d(view, R$id.restore_right_layout);
        c4064a.f18832k = (ImageView) C12809f.m76831d(view, R$id.expandable_iv);
        c4064a.f18834m = (TextView) C12809f.m76831d(view, R$id.appid_tv);
        c4064a.f18833l = (TextView) C12809f.m76831d(view, R$id.app_size_tv);
        c4064a.f18828g = (TextView) C12809f.m76831d(view, R$id.count_tv);
        m25124i(this.f18817a, c4064a.f18828g);
        c4064a.f18829h = (TextView) C12809f.m76831d(view, R$id.child_desc_tv);
        c4064a.f18822a = (ImageView) C12809f.m76831d(view, R$id.manage_item_icon);
        c4064a.f18823b = (ImageView) C12809f.m76831d(view, R$id.manage_item_icon_badge);
        c4064a.f18824c = (ImageView) C12809f.m76831d(view, R$id.fail_image);
        return c4064a;
    }

    /* renamed from: c */
    public final long m25119c(long j10, boolean z10, CloudRestoreItem cloudRestoreItem) {
        if (cloudRestoreItem.getBmAppDataType() == 2) {
            return Math.min(j10, cloudRestoreItem.getBytesDownloadedFiles() + cloudRestoreItem.getBytesDownloadedApp());
        }
        return Math.min(j10, z10 ? cloudRestoreItem.getBytesDownloadedFiles() : cloudRestoreItem.getBytesDownloadedApp());
    }

    /* renamed from: d */
    public final String m25120d(CloudRestoreItem cloudRestoreItem) {
        return cloudRestoreItem.getAppId().equals(NextRestoreConstants.BUNDLE_NAME_GALLERY) ? "com.huawei.hmos.photos" : cloudRestoreItem.getAppId().equals("com.huawei.hmos.meetimeservice") ? "com.huawei.hmos.meetime" : cloudRestoreItem.getAppId().equals("com.huawei.hmos.callrecorder") ? "com.huawei.hmos.soundrecorder" : cloudRestoreItem.getAppId().equals("com.huawei.hmos.calendardata") ? "com.huawei.hmos.calendar" : cloudRestoreItem.getAppId().equals("com.ohos.telephonydataability") ? "com.ohos.mms" : cloudRestoreItem.getAppId();
    }

    /* renamed from: e */
    public final String m25121e(CloudRestoreItem cloudRestoreItem) {
        return RestoreUtil.getRestoreItemName(cloudRestoreItem);
    }

    @Override // android.widget.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public CloudRestoreItem getItem(int i10) {
        List<CloudRestoreItem> list = this.f18820d;
        if (list == null || i10 >= list.size()) {
            return null;
        }
        return this.f18820d.get(i10);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18820d.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        List<CloudRestoreItem> list;
        CloudRestoreItem cloudRestoreItem;
        C4064a c4064aM25118a;
        View viewM76832e;
        if (this.f18818b == null || (list = this.f18820d) == null || i10 >= list.size() || (cloudRestoreItem = this.f18820d.get(i10)) == null) {
            return view;
        }
        String strM25120d = m25120d(cloudRestoreItem);
        if (view == null) {
            viewM76832e = C12809f.m76832e(this.f18819c, R$layout.restore_main_content_detail_item);
            c4064aM25118a = m25118a(viewM76832e);
            viewM76832e.setTag(c4064aM25118a);
        } else {
            c4064aM25118a = (C4064a) view.getTag();
            viewM76832e = view;
        }
        if (c4064aM25118a == null) {
            return view;
        }
        if (SplitAppUtil.hasSplitAppSuffix(strM25120d)) {
            c4064aM25118a.f18823b.setVisibility(0);
            strM25120d = SplitAppUtil.getSplitOriAppId(strM25120d);
        } else {
            c4064aM25118a.f18823b.setVisibility(8);
        }
        c4064aM25118a.f18822a.setTag(strM25120d);
        c4064aM25118a.f18822a.setImageDrawable(RestoreUtil.getRestoreItemDrawable(cloudRestoreItem, strM25120d));
        c4064aM25118a.f18834m.setText(m25121e(cloudRestoreItem));
        if (this.f18821e && "thirdApp".equals(strM25120d)) {
            c4064aM25118a.f18832k.setVisibility(8);
        } else {
            c4064aM25118a.f18832k.setVisibility(cloudRestoreItem.isShowChildList() ? 0 : 8);
        }
        m25139x(c4064aM25118a, cloudRestoreItem);
        if (!C11842p.m70753O0(this.f18817a) && c4064aM25118a.f18833l.getVisibility() == 0) {
            int iM70758Q = ((int) (C11842p.m70758Q(this.f18817a) - C11842p.m70844o(this.f18817a, 116))) / 3;
            c4064aM25118a.f18833l.setMaxWidth(iM70758Q);
            int i11 = iM70758Q * 2;
            c4064aM25118a.f18828g.setMaxWidth(i11);
            c4064aM25118a.f18834m.setMaxWidth(i11);
            c4064aM25118a.f18829h.setMaxWidth(i11);
        }
        C12809f.m76831d(viewM76832e, R$id.list_item_divider).setVisibility(getCount() + (-1) == i10 ? 8 : 0);
        m25140y(viewM76832e, i10);
        return viewM76832e;
    }

    /* renamed from: h */
    public final long m25123h(boolean z10, CloudRestoreItem cloudRestoreItem) {
        return cloudRestoreItem.isHarmonyNext() ? cloudRestoreItem.getSize() : cloudRestoreItem.getBmAppDataType() == 2 ? cloudRestoreItem.getSize() + cloudRestoreItem.getAsize() : z10 ? cloudRestoreItem.getSize() : cloudRestoreItem.getAsize();
    }

    /* renamed from: i */
    public final void m25124i(Context context, TextView textView) {
        if (C0234s.m1643u()) {
            textView.setPadding(0, 0, 0, (int) C11842p.m70844o(context, 6));
        }
    }

    /* renamed from: j */
    public final boolean m25125j(CloudRestoreItem cloudRestoreItem) {
        return (cloudRestoreItem == null || cloudRestoreItem.m29202r() == null || cloudRestoreItem.m29202r().size() != 1) ? false : true;
    }

    /* renamed from: k */
    public final boolean m25126k(CloudRestoreItem cloudRestoreItem) {
        return ("doc".equals(cloudRestoreItem.getAppId()) || "doc1".equals(cloudRestoreItem.getAppId())) ? false : true;
    }

    /* renamed from: l */
    public final void m25127l(C4064a c4064a) {
        c4064a.f18831j.setVisibility(8);
        c4064a.f18830i.setVisibility(8);
        c4064a.f18833l.setVisibility(8);
        c4064a.f18829h.setVisibility(8);
        c4064a.f18828g.setText(this.f18817a.getString(R$string.cloudbackup_restore_cancel));
        c4064a.f18828g.setTextColor(this.f18818b.getColor(R$color.emui_color_gray_7));
    }

    /* renamed from: m */
    public final void m25128m(C4064a c4064a, CloudRestoreItem cloudRestoreItem) {
        c4064a.f18831j.setVisibility(8);
        c4064a.f18830i.setVisibility(8);
        c4064a.f18833l.setVisibility(8);
        c4064a.f18829h.setVisibility(8);
        c4064a.f18828g.setTextColor(this.f18818b.getColor(R$color.emui_color_gray_7));
        int count = cloudRestoreItem.getCount();
        int current = cloudRestoreItem.getCurrent();
        C11839m.m70686d("RestoreModuleAdapter", "restoreDefault appId" + cloudRestoreItem.getAppId() + " isSystemShowModule =" + cloudRestoreItem.isSystemShowModule() + " restoreItem.isVirtual() =" + cloudRestoreItem.isVirtual());
        if (cloudRestoreItem.isSystemShowModule()) {
            if (count > 0) {
                c4064a.f18828g.setText(ModuleRestoreResultUtil.getWaitingTips(this.f18817a, cloudRestoreItem, count, this.f18817a.getString(R$string.cloudbackup_backupmedia_tip, C13843a.m83104z(Integer.valueOf(current)), C13843a.m83104z(Integer.valueOf(count)))));
            } else {
                c4064a.f18828g.setText(this.f18817a.getString(R$string.restore_new_wait_2));
            }
        } else if (cloudRestoreItem.isVirtual() || cloudRestoreItem.is3rdAppType() || count == 0) {
            c4064a.f18828g.setText(this.f18817a.getString(R$string.restore_new_wait_2));
        } else {
            c4064a.f18828g.setText(ModuleRestoreResultUtil.getWaitingTips(this.f18817a, cloudRestoreItem, count, this.f18817a.getString(R$string.cloudbackup_backupmedia_tip, C13843a.m83104z(Integer.valueOf(current)), C13843a.m83104z(Integer.valueOf(count)))));
        }
        if ("sysdata".equals(cloudRestoreItem.getAppId()) || !RestoreAggregatedAppUtil.isShowAggregatedDialog(cloudRestoreItem)) {
            return;
        }
        c4064a.f18825d.setVisibility(8);
        m25137v(c4064a, cloudRestoreItem, false);
    }

    /* renamed from: n */
    public final void m25129n(C4064a c4064a, String str, CloudRestoreItem cloudRestoreItem) throws Resources.NotFoundException {
        c4064a.f18824c.setVisibility(8);
        c4064a.f18829h.setVisibility(8);
        String appId = cloudRestoreItem.getAppId();
        int current = cloudRestoreItem.getCurrent();
        int count = cloudRestoreItem.getCount();
        if ("thirdApp".equals(appId)) {
            c4064a.f18831j.setVisibility(8);
            int i10 = count - current;
            if (i10 < 0) {
                current = 0;
            } else {
                count = i10;
            }
            if (current > 0) {
                c4064a.f18828g.setText(this.f18817a.getString(R$string.restore_item_restore_part_completed));
            } else {
                c4064a.f18828g.setText(this.f18817a.getString(R$string.restore_failed));
            }
            c4064a.f18833l.setText(this.f18818b.getQuantityString(R$plurals.restore_item_restoration_failed, count, Integer.valueOf(count)).replace(String.valueOf(count), C13843a.m83104z(Integer.valueOf(count))));
            c4064a.f18833l.setVisibility(0);
        } else if ("sysdata".equals(appId)) {
            c4064a.f18831j.setVisibility(8);
            int count2 = cloudRestoreItem.getCount() - current;
            if (count2 < 0) {
                count2 = cloudRestoreItem.getCount();
                current = 0;
            }
            c4064a.f18828g.setText(this.f18818b.getString(R$string.restore_new_completed_part, this.f18818b.getQuantityString(R$plurals.backup_backed_total, current, Integer.valueOf(current), Integer.valueOf(count)).replace(String.valueOf(current), C13843a.m83104z(Integer.valueOf(current))).replace(String.valueOf(count), C13843a.m83104z(Integer.valueOf(count)))));
            c4064a.f18833l.setText(this.f18818b.getQuantityString(R$plurals.restore_new_failure_part_data, count2, Integer.valueOf(count2)).replace(String.valueOf(count2), C13843a.m83104z(Integer.valueOf(count2))));
            c4064a.f18833l.setVisibility(0);
        } else {
            m25137v(c4064a, cloudRestoreItem, true);
            c4064a.f18833l.setVisibility(8);
            if (cloudRestoreItem.m29202r() == null || cloudRestoreItem.m29202r().size() <= 1) {
                c4064a.f18828g.setText(str);
            } else {
                c4064a.f18828g.setText(this.f18817a.getString(R$string.restore_completed_not_succeed));
            }
        }
        c4064a.f18830i.setVisibility(8);
        c4064a.f18825d.setVisibility(8);
        c4064a.f18828g.setTextColor(this.f18818b.getColor(R$color.emui_color_gray_7));
    }

    /* renamed from: o */
    public final void m25130o(C4064a c4064a, CloudRestoreItem cloudRestoreItem) throws Resources.NotFoundException {
        c4064a.f18831j.setVisibility(8);
        c4064a.f18829h.setVisibility(8);
        c4064a.f18828g.setTextColor(this.f18818b.getColor(R$color.emui_color_gray_7));
        int count = cloudRestoreItem.getCount();
        int current = cloudRestoreItem.getCurrent();
        if (cloudRestoreItem.is3rdAppType()) {
            c4064a.f18833l.setVisibility(8);
            if (m25125j(cloudRestoreItem)) {
                c4064a.f18828g.setText(ModuleRestoreResultUtil.getRestoreResultTips(this.f18817a, cloudRestoreItem.m29202r().get(0)));
            } else {
                c4064a.f18828g.setText(this.f18817a.getString(R$string.restore_completed_not_succeed));
            }
        } else if ("sysdata".equals(cloudRestoreItem.getAppId())) {
            c4064a.f18828g.setText(this.f18818b.getString(R$string.restore_new_completed_part, this.f18818b.getQuantityString(R$plurals.backup_backed_total, current, Integer.valueOf(current), Integer.valueOf(count)).replace(String.valueOf(current), C13843a.m83104z(Integer.valueOf(current))).replace(String.valueOf(count), C13843a.m83104z(Integer.valueOf(count)))));
            int i10 = count - current;
            c4064a.f18833l.setText(this.f18818b.getQuantityString(R$plurals.restore_new_failure_part_data, i10, Integer.valueOf(i10)).replace(String.valueOf(i10), C13843a.m83104z(Integer.valueOf(i10))));
            c4064a.f18833l.setVisibility(0);
        } else if (count < current || cloudRestoreItem.isVirtual()) {
            c4064a.f18833l.setVisibility(8);
            if (m25125j(cloudRestoreItem)) {
                c4064a.f18828g.setText(ModuleRestoreResultUtil.getRestoreResultTips(this.f18817a, cloudRestoreItem.m29202r().get(0)));
            } else {
                c4064a.f18828g.setText(this.f18817a.getString(R$string.restore_completed_not_succeed));
            }
        } else {
            if (m25125j(cloudRestoreItem)) {
                c4064a.f18828g.setText(ModuleRestoreResultUtil.getRestoreResultTips(this.f18817a, cloudRestoreItem.m29202r().get(0)));
            } else if (current > 0) {
                c4064a.f18828g.setText(this.f18817a.getString(R$string.restore_completed_not_succeed_part));
            } else {
                c4064a.f18828g.setText(this.f18817a.getString(R$string.restore_completed_not_succeed));
            }
            c4064a.f18833l.setVisibility(8);
        }
        if ("sysdata".equals(cloudRestoreItem.getAppId())) {
            return;
        }
        c4064a.f18825d.setVisibility(8);
        c4064a.f18830i.setVisibility(8);
        m25137v(c4064a, cloudRestoreItem, true);
    }

    /* renamed from: p */
    public final void m25131p(C4064a c4064a, CloudRestoreItem cloudRestoreItem) {
        c4064a.f18831j.setVisibility(8);
        c4064a.f18830i.setVisibility(8);
        c4064a.f18833l.setVisibility(8);
        c4064a.f18829h.setVisibility(8);
        c4064a.f18828g.setText(this.f18817a.getString(R$string.restore_item_restore_paused));
        c4064a.f18828g.setTextColor(this.f18818b.getColor(R$color.emui_color_gray_7));
        if ("sysdata".equals(cloudRestoreItem.getAppId()) || !RestoreAggregatedAppUtil.isShowAggregatedDialog(cloudRestoreItem)) {
            return;
        }
        c4064a.f18825d.setVisibility(8);
        m25137v(c4064a, cloudRestoreItem, false);
    }

    /* renamed from: q */
    public final void m25132q(C4064a c4064a, CloudRestoreItem cloudRestoreItem) throws Resources.NotFoundException {
        c4064a.f18831j.setVisibility(8);
        c4064a.f18829h.setVisibility(8);
        c4064a.f18828g.setTextColor(this.f18818b.getColor(R$color.emui_color_gray_7));
        int count = cloudRestoreItem.getCount();
        int current = cloudRestoreItem.getCurrent();
        if ("sysdata".equals(cloudRestoreItem.getAppId())) {
            c4064a.f18828g.setText(this.f18818b.getString(R$string.restore_new_completed_part, this.f18818b.getQuantityString(R$plurals.backup_backed_total, current, Integer.valueOf(current), Integer.valueOf(count)).replace(String.valueOf(current), C13843a.m83104z(Integer.valueOf(current))).replace(String.valueOf(count), C13843a.m83104z(Integer.valueOf(count)))));
            int i10 = count - current;
            c4064a.f18833l.setText(this.f18818b.getQuantityString(R$plurals.restore_new_failure_part_data, i10, Integer.valueOf(i10)).replace(String.valueOf(i10), C13843a.m83104z(Integer.valueOf(i10))));
            c4064a.f18833l.setVisibility(0);
        } else {
            if (m25125j(cloudRestoreItem)) {
                c4064a.f18828g.setText(ModuleRestoreResultUtil.getRestoreResultTips(this.f18817a, cloudRestoreItem.m29202r().get(0)));
            } else if (current <= 0 || count <= 0) {
                c4064a.f18828g.setText(this.f18817a.getString(R$string.restore_failed));
            } else {
                c4064a.f18828g.setText(this.f18817a.getString(R$string.restore_partial_fail));
            }
            c4064a.f18833l.setVisibility(8);
        }
        if ("sysdata".equals(cloudRestoreItem.getAppId())) {
            return;
        }
        c4064a.f18825d.setVisibility(8);
        c4064a.f18830i.setVisibility(8);
        m25137v(c4064a, cloudRestoreItem, true);
    }

    /* renamed from: r */
    public final void m25133r(C4064a c4064a, CloudRestoreItem cloudRestoreItem) throws Resources.NotFoundException {
        String strReplace;
        if ("sysdata".equals(cloudRestoreItem.getAppId())) {
            c4064a.f18831j.setVisibility(8);
        } else {
            c4064a.f18831j.setVisibility(0);
        }
        m25141z(c4064a);
        c4064a.f18833l.setVisibility(8);
        c4064a.f18830i.setVisibility(8);
        c4064a.f18829h.setVisibility(8);
        c4064a.f18828g.setTextColor(this.f18818b.getColor(R$color.emui_color_gray_7));
        int current = cloudRestoreItem.getCurrent();
        int count = cloudRestoreItem.getCount();
        C11839m.m70688i("RestoreModuleAdapter", "restoreSuccess appid = " + cloudRestoreItem.getAppId() + " count = " + count + " appType" + cloudRestoreItem.getAppType() + " current = " + current);
        if ((cloudRestoreItem.isSystemShowModule() && current == 0) || (cloudRestoreItem.isVirtual() && m25126k(cloudRestoreItem))) {
            c4064a.f18828g.setText(this.f18817a.getString(R$string.restore_new_completed));
            return;
        }
        if (cloudRestoreItem.is3rdAppType()) {
            c4064a.f18828g.setText(this.f18817a.getString(R$string.restore_new_completed));
            if (cloudRestoreItem.getAction() == 1) {
                c4064a.f18828g.setText(this.f18817a.getString(R$string.cloudbackup_app_restore_failed_no_retry));
                return;
            }
            return;
        }
        if ("sysdata".equals(cloudRestoreItem.getAppId())) {
            strReplace = this.f18818b.getString(R$string.restore_new_completed_part, this.f18818b.getQuantityString(R$plurals.backup_backed_total, current, Integer.valueOf(current), Integer.valueOf(count)).replace(String.valueOf(current), C13843a.m83104z(Integer.valueOf(current))).replace(String.valueOf(count), C13843a.m83104z(Integer.valueOf(count))));
        } else if ("thirdApp".equals(cloudRestoreItem.getAppId())) {
            strReplace = this.f18817a.getString(R$string.restore_new_completed);
        } else {
            if (current == 0) {
                c4064a.f18828g.setText(this.f18817a.getString(R$string.restore_new_completed));
                return;
            }
            strReplace = this.f18818b.getQuantityString(R$plurals.restore_new_completed_part_2, current, Integer.valueOf(current)).replace(String.valueOf(current), C13843a.m83104z(Integer.valueOf(current)));
        }
        c4064a.f18828g.setText(strReplace);
    }

    /* renamed from: s */
    public final void m25134s(C4064a c4064a, CloudRestoreItem cloudRestoreItem) throws Resources.NotFoundException {
        if (!CBAccess.inRestoreTask()) {
            C11839m.m70686d("RestoreModuleAdapter", "restoring not in restoreTask");
            m25130o(c4064a, cloudRestoreItem);
            return;
        }
        if ("sysdata".equals(cloudRestoreItem.getAppId()) || cloudRestoreItem.m29202r() == null || cloudRestoreItem.m29202r().size() <= 1) {
            c4064a.f18829h.setVisibility(8);
        } else {
            c4064a.f18829h.setVisibility(0);
        }
        c4064a.f18831j.setVisibility(0);
        c4064a.f18830i.setVisibility(0);
        c4064a.f18830i.setFlickerEnable(true);
        c4064a.f18824c.setVisibility(8);
        c4064a.f18833l.setVisibility(8);
        c4064a.f18825d.setVisibility(8);
        if ("sysdata".equals(cloudRestoreItem.getAppId()) || cloudRestoreItem.m29202r() == null || cloudRestoreItem.m29202r().size() <= 1) {
            if ("sysdata".equals(cloudRestoreItem.getAppId()) || !m25125j(cloudRestoreItem)) {
                m25136u(c4064a.f18828g, cloudRestoreItem, false);
                return;
            } else {
                m25136u(c4064a.f18828g, cloudRestoreItem.m29202r().get(0), false);
                return;
            }
        }
        if (this.f18821e && "thirdApp".equals(cloudRestoreItem.getAppId())) {
            m25136u(c4064a.f18828g, cloudRestoreItem, false);
        } else {
            m25136u(c4064a.f18828g, cloudRestoreItem.m29202r().get(0), true);
            m25136u(c4064a.f18829h, cloudRestoreItem.m29202r().get(1), true);
        }
    }

    /* renamed from: t */
    public final String m25135t(CloudRestoreItem cloudRestoreItem) {
        if (RestoreProgress.isPrepare(cloudRestoreItem.getSubStatus())) {
            return this.f18817a.getString(R$string.cloudbackup_prepare_data);
        }
        int current = cloudRestoreItem.getCurrent();
        int status = cloudRestoreItem.getStatus();
        boolean zEquals = TextUtils.equals("thirdAppData", cloudRestoreItem.m29203s());
        long jM25123h = m25123h(zEquals, cloudRestoreItem);
        long jM25119c = m25119c(jM25123h, zEquals, cloudRestoreItem);
        if (status == 3) {
            return this.f18817a.getString(R$string.restore_new_wait_2);
        }
        if (status == 4) {
            if (!this.f18821e) {
                return m25117B(current, jM25123h, jM25119c);
            }
            Context context = this.f18817a;
            return context.getString(R$string.cloudbackup_restore_downloading_data_size, RestoreProgress.formatData(context, jM25119c), RestoreProgress.formatData(this.f18817a, jM25123h));
        }
        if (status == 5) {
            if (!this.f18821e || jM25123h == jM25119c) {
                return this.f18817a.getString(R$string.restore_new_wait_for_installation);
            }
            Context context2 = this.f18817a;
            return context2.getString(R$string.cloudbackup_restore_downloading_data_size, RestoreProgress.formatData(context2, jM25119c), RestoreProgress.formatData(this.f18817a, jM25123h));
        }
        if (status == 6) {
            return this.f18817a.getString(R$string.restore_new_installing);
        }
        if (status != 7) {
            return "";
        }
        if (cloudRestoreItem.getSize() == 0) {
            return this.f18817a.getString(R$string.restoring_data);
        }
        long jMin = Math.min(cloudRestoreItem.getPmsAlreadyBytes(), cloudRestoreItem.getSize());
        Context context3 = this.f18817a;
        return context3.getString(R$string.restore_import_data_size, RestoreProgress.formatData(context3, jMin), RestoreProgress.formatData(this.f18817a, cloudRestoreItem.getSize()));
    }

    /* renamed from: u */
    public final void m25136u(TextView textView, CloudRestoreItem cloudRestoreItem, boolean z10) {
        String string;
        int count = cloudRestoreItem.getCount();
        int iMin = Math.min(cloudRestoreItem.getCurrent(), count);
        long jM25115g = m25115g(cloudRestoreItem);
        long jM25114b = m25114b(cloudRestoreItem, jM25115g);
        if (!ModuleRestoreResultUtil.isModuleRestoring(cloudRestoreItem)) {
            string = ModuleRestoreResultUtil.getRestoreResultTips(this.f18817a, cloudRestoreItem);
        } else if (C14333b.m85486u().containsKey(cloudRestoreItem.getAppId()) || cloudRestoreItem.isShowRestoreProgressTotal() || cloudRestoreItem.isHarmonyNext()) {
            String string2 = this.f18817a.getString(R$string.cloudbackup_backupmedia_tip, C13843a.m83104z(Integer.valueOf(iMin)), C13843a.m83104z(Integer.valueOf(count)));
            if (count <= 0 && jM25115g <= 0) {
                string = this.f18817a.getString(R$string.main_cloudrestoring);
            } else if (RestoreProgress.isPrepare(cloudRestoreItem.getSubStatus())) {
                string = this.f18817a.getString(R$string.cloudbackup_prepare_data);
            } else {
                int status = cloudRestoreItem.getStatus();
                if (status != 4 && status != 5) {
                    string = (!"sysdata".equals(cloudRestoreItem.getAppId()) && cloudRestoreItem.isHarmonyNext() && status == 7) ? this.f18817a.getString(R$string.main_cloudrestoring) : this.f18817a.getString(R$string.restore_import_data, string2);
                } else if (jM25115g > 0) {
                    Context context = this.f18817a;
                    string = context.getString(R$string.cloudbackup_restore_downloading_data_size, RestoreProgress.formatData(context, jM25114b), RestoreProgress.formatData(this.f18817a, jM25115g));
                } else {
                    string = this.f18817a.getString(R$string.cloudbackup_restore_downloading_2, C13843a.m83104z(Integer.valueOf(iMin)), C13843a.m83104z(Integer.valueOf(count)));
                }
            }
        } else if (cloudRestoreItem.m29187M() || cloudRestoreItem.getUid() != 0) {
            string = m25135t(cloudRestoreItem);
        } else if (jM25115g > 0) {
            Context context2 = this.f18817a;
            string = context2.getString(R$string.cloudbackup_restore_downloading_data_size, RestoreProgress.formatData(context2, jM25114b), RestoreProgress.formatData(this.f18817a, jM25115g));
        } else {
            string = count > 0 ? this.f18817a.getString(R$string.cloudbackup_downloading, C2783d.m16075C(iMin)) : this.f18817a.getString(R$string.main_cloudrestoring);
        }
        if (z10) {
            Context context3 = this.f18817a;
            textView.setText(context3.getString(R$string.connect_string_colon, RestoreAggregatedAppUtil.getAppName(context3, cloudRestoreItem), string));
        } else {
            textView.setText(string);
        }
        textView.setTextColor(this.f18818b.getColor(R$color.emui_color_gray_7));
    }

    /* renamed from: v */
    public final void m25137v(C4064a c4064a, CloudRestoreItem cloudRestoreItem, boolean z10) {
        if (cloudRestoreItem == null || cloudRestoreItem.m29202r() == null || cloudRestoreItem.m29202r().size() <= 1) {
            if (z10) {
                c4064a.f18831j.setVisibility(0);
                c4064a.f18824c.setVisibility(0);
                c4064a.f18832k.setVisibility(8);
                return;
            }
            return;
        }
        int iM80916g0 = C13452e.m80781L().m80916g0();
        if (iM80916g0 == 0 || iM80916g0 == 1) {
            return;
        }
        c4064a.f18831j.setVisibility(8);
        c4064a.f18824c.setVisibility(8);
        c4064a.f18832k.setVisibility(0);
    }

    /* renamed from: w */
    public void m25138w(List<CloudRestoreItem> list) {
        this.f18820d.clear();
        this.f18820d.addAll(list);
    }

    /* renamed from: x */
    public final void m25139x(C4064a c4064a, CloudRestoreItem cloudRestoreItem) throws Resources.NotFoundException {
        int status = cloudRestoreItem.getStatus();
        String appId = cloudRestoreItem.getAppId();
        String strM22100u2 = ((RestoreMainActivity) this.f18817a).m22100u2(appId);
        if (!strM22100u2.equals("")) {
            c4064a.f18831j.setVisibility(8);
            c4064a.f18833l.setVisibility(8);
            c4064a.f18828g.setText(this.f18817a.getString(R$string.hicloud_restore_permission_disabled, strM22100u2));
            c4064a.f18828g.setTextColor(this.f18818b.getColor(R$color.emui_functional_red));
        }
        C11839m.m70688i("RestoreModuleAdapter", "buildView appId " + appId + " statue " + cloudRestoreItem.getStatus() + " type = " + cloudRestoreItem.getType());
        switch (status) {
            case -8:
                m25129n(c4064a, this.f18817a.getString(R$string.restoring_failed_by_module_deleted), cloudRestoreItem);
                break;
            case -7:
                m25129n(c4064a, this.f18817a.getString(R$string.restore_safebox_unsupport_tip), cloudRestoreItem);
                break;
            case -6:
                m25129n(c4064a, this.f18817a.getString(R$string.item_app_not_compatible), cloudRestoreItem);
                break;
            case -5:
                m25129n(c4064a, this.f18817a.getString(R$string.item_app_no_exist), cloudRestoreItem);
                break;
            case -4:
                m25129n(c4064a, this.f18817a.getString(R$string.item_hm_un_support_tip), cloudRestoreItem);
                break;
            case -3:
                if (!RestoreUtil.isHiCreatePromptNotSupportRestore(cloudRestoreItem)) {
                    m25129n(c4064a, this.f18817a.getString(R$string.item_clone_un_support_tip), cloudRestoreItem);
                    break;
                } else {
                    m25129n(c4064a, this.f18817a.getString(R$string.restore_new_recovery_not_supported), cloudRestoreItem);
                    break;
                }
            case -2:
                m25129n(c4064a, this.f18817a.getString(R$string.item_app_foreground_tip), cloudRestoreItem);
                break;
            case -1:
                int i10 = R$string.restore_new_recovery_not_supported;
                if (cloudRestoreItem.is3rdAppType() && cloudRestoreItem.m29187M()) {
                    i10 = R$string.cloudbackup_app_restore_failed_no_retry;
                }
                m25129n(c4064a, this.f18817a.getString(i10), cloudRestoreItem);
                break;
            case 0:
                m25128m(c4064a, cloudRestoreItem);
                break;
            case 1:
                m25127l(c4064a);
                break;
            case 2:
                m25131p(c4064a, cloudRestoreItem);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                m25134s(c4064a, cloudRestoreItem);
                break;
            case 8:
                if (cloudRestoreItem.getType() != 1) {
                    int iM80916g0 = C13452e.m80781L().m80916g0();
                    C11839m.m70688i("RestoreModuleAdapter", "buildView appId :restoreStatus" + iM80916g0);
                    if (iM80916g0 != 5 && iM80916g0 != 8) {
                        m25130o(c4064a, cloudRestoreItem);
                        break;
                    } else {
                        m25132q(c4064a, cloudRestoreItem);
                        break;
                    }
                } else {
                    m25133r(c4064a, cloudRestoreItem);
                    break;
                }
        }
    }

    /* renamed from: y */
    public final void m25140y(View view, int i10) {
        if (i10 == getCount() - 1) {
            if (i10 != 0 || this.f18821e) {
                view.setBackground(this.f18817a.getDrawable(R$drawable.cardview_list_bottom_shape_white));
                return;
            } else {
                view.setBackground(this.f18817a.getDrawable(R$drawable.storage_manage_cardview_list_shape_white));
                return;
            }
        }
        if (i10 != 0 || this.f18821e) {
            view.setBackground(this.f18817a.getDrawable(R$color.storage_manager_card_bg));
        } else {
            view.setBackground(this.f18817a.getDrawable(R$drawable.cardview_list_top_shape_white));
        }
    }

    /* renamed from: z */
    public final void m25141z(C4064a c4064a) {
        c4064a.f18824c.setVisibility(8);
        c4064a.f18825d.setVisibility(0);
        c4064a.f18827f.setVisibility(0);
        c4064a.f18827f.m25691f();
        c4064a.f18827f.m25692g();
        c4064a.f18826e.setVisibility(0);
        c4064a.f18826e.setProgress(100);
    }
}
