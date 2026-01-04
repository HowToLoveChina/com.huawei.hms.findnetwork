package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.BackupOptionsDetailActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$string;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0223k;
import p514o9.C11839m;
import p618rm.C12590s0;
import p848zl.C14333b;

/* loaded from: classes3.dex */
public class BackupSpaceDetailAdapter extends BaseAdapter {

    /* renamed from: a */
    public LayoutInflater f18570a;

    /* renamed from: b */
    public Context f18571b;

    /* renamed from: c */
    public Resources f18572c;

    /* renamed from: d */
    public List<AppDetailsInfo> f18573d = new ArrayList();

    /* renamed from: e */
    public DeleteBackupModuleListener f18574e;

    /* renamed from: f */
    public View.OnClickListener f18575f;

    /* renamed from: g */
    public boolean f18576g;

    /* renamed from: h */
    public ThirdIconAdapter f18577h;

    /* renamed from: i */
    public boolean f18578i;

    /* renamed from: j */
    public boolean f18579j;

    public interface CheckBoxChangedListener {
    }

    public interface DeleteBackupModuleListener {
        /* renamed from: K */
        void mo20013K(int i10, String str);

        /* renamed from: r0 */
        void mo20020r0(int i10, String str);
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupSpaceDetailAdapter$a */
    public class ViewOnClickListenerC4031a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ int f18580a;

        /* renamed from: b */
        public final /* synthetic */ String f18581b;

        public ViewOnClickListenerC4031a(int i10, String str) {
            this.f18580a = i10;
            this.f18581b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BackupSpaceDetailAdapter.this.getItem(this.f18580a) == null || BackupSpaceDetailAdapter.this.f18574e == null) {
                return;
            }
            BackupSpaceDetailAdapter.this.f18574e.mo20013K(this.f18580a, this.f18581b);
        }
    }

    public BackupSpaceDetailAdapter(Context context, View.OnClickListener onClickListener, boolean z10) {
        this.f18571b = context;
        this.f18572c = context.getResources();
        this.f18575f = onClickListener;
        this.f18570a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f18576g = z10;
    }

    /* renamed from: b */
    public void m24815b(List<AppDetailsInfo> list) {
        this.f18573d.clear();
        this.f18573d.addAll(list);
        notifyDataSetChanged();
    }

    /* renamed from: c */
    public String m24816c(AppDetailsInfo appDetailsInfo) {
        String str = (appDetailsInfo == null || appDetailsInfo.getProperties() == null) ? "" : appDetailsInfo.getProperties().get(SnapshotBackupMeta.KEY_STRING_APP_NAME);
        return ("thirdAppData".equals(appDetailsInfo.getParentId()) && appDetailsInfo.getExistSplit().booleanValue()) ? this.f18571b.getString(R$string.item_contains_twin_label, str) : str;
    }

    @Override // android.widget.Adapter
    /* renamed from: d */
    public AppDetailsInfo getItem(int i10) {
        return i10 >= this.f18573d.size() ? new AppDetailsInfo() : this.f18573d.get(i10);
    }

    /* renamed from: e */
    public List<AppDetailsInfo> m24818e() {
        return this.f18573d;
    }

    /* renamed from: f */
    public boolean m24819f() {
        return this.f18576g;
    }

    /* renamed from: g */
    public int m24820g(String str) {
        if ("chatSms".equals(str)) {
            str = NavigationUtils.SMS_SCHEMA_PREF;
        }
        if ("callRecorder".equals(str)) {
            str = "soundrecorder";
        }
        for (int i10 = 0; i10 < this.f18573d.size(); i10++) {
            if (this.f18573d.get(i10).getBackupAppName().equals(str)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18573d.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i10) {
        return getItem(i10).getBackupAppName().equals("thirdAppData") ? 1 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013c  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(int r8, android.view.View r9, android.view.ViewGroup r10) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.uiadapter.BackupSpaceDetailAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    /* renamed from: h */
    public int m24821h(ListView listView, int i10) {
        return i10 + listView.getHeaderViewsCount();
    }

    /* renamed from: i */
    public final View m24822i(ListView listView, int i10) {
        if (listView != null && i10 != -1) {
            int iM24821h = m24821h(listView, i10);
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            if (iM24821h >= firstVisiblePosition && iM24821h <= lastVisiblePosition) {
                C11839m.m70686d("BackupSpaceDetailNewAdapter", "refresh view, position = " + i10 + ", adjPosition: " + iM24821h);
                return listView.getChildAt(iM24821h - firstVisiblePosition);
            }
        }
        return null;
    }

    /* renamed from: j */
    public final void m24823j(C4033c c4033c, int i10, String str) {
        c4033c.f18597k.setOnClickListener(new ViewOnClickListenerC4031a(i10, str));
    }

    /* renamed from: k */
    public final void m24824k(C4033c c4033c) {
        if (c4033c == null || c4033c.f18588b == null) {
            C11839m.m70687e("BackupSpaceDetailNewAdapter", "backHolderView is null");
        } else {
            c4033c.f18588b.setMinimumHeight((int) TypedValue.applyDimension(1, c4033c.f18592f.getVisibility() == 0 ? 96.0f : 72.0f, this.f18571b.getResources().getDisplayMetrics()));
        }
    }

    /* renamed from: l */
    public final void m24825l(C4033c c4033c, AppDetailsInfo appDetailsInfo, int i10) {
        String backupAppName = appDetailsInfo.getBackupAppName();
        m24826m(c4033c, backupAppName, appDetailsInfo);
        m24823j(c4033c, i10, backupAppName);
        m24834u(c4033c, appDetailsInfo, i10, backupAppName);
        m24830q(c4033c, i10);
        m24824k(c4033c);
    }

    /* renamed from: m */
    public final void m24826m(C4033c c4033c, String str, AppDetailsInfo appDetailsInfo) {
        if (appDetailsInfo.isVirtualApp()) {
            String virtualName = CloudBackupLanguageUtil.getVirtualName(str);
            TextView textView = c4033c.f18590d;
            if (TextUtils.isEmpty(virtualName)) {
                virtualName = m24816c(appDetailsInfo);
            }
            textView.setText(virtualName);
            c4033c.f18589c.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(str, null));
            return;
        }
        if (C14333b.m85483r().containsKey(str)) {
            c4033c.f18590d.setText(C2783d.m16079E(this.f18571b, str));
            c4033c.f18589c.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(str));
        } else {
            c4033c.f18590d.setText(C14333b.f63653e.containsKey(str) ? C2783d.m16079E(this.f18571b, str) : m24816c(appDetailsInfo));
            c4033c.f18589c.setImageDrawable(CloudBackup3rdIconUtil.get3rdDrawable(str));
        }
    }

    /* renamed from: n */
    public void m24827n(CheckBoxChangedListener checkBoxChangedListener) {
    }

    /* renamed from: o */
    public void m24828o(DeleteBackupModuleListener deleteBackupModuleListener) {
        this.f18574e = deleteBackupModuleListener;
    }

    /* renamed from: p */
    public void m24829p(boolean z10) {
        this.f18576g = z10;
        if (z10) {
            for (AppDetailsInfo appDetailsInfo : this.f18573d) {
                if (appDetailsInfo.getUiStyle() != 2) {
                    appDetailsInfo.setUiStyle(1);
                }
                appDetailsInfo.setCheck(false);
            }
            return;
        }
        for (AppDetailsInfo appDetailsInfo2 : this.f18573d) {
            if (appDetailsInfo2.getUiStyle() != 2) {
                appDetailsInfo2.setUiStyle(0);
            }
            appDetailsInfo2.setCheck(false);
        }
    }

    /* renamed from: q */
    public final void m24830q(C4033c c4033c, int i10) {
        if (i10 != (this.f18578i ? getCount() - 1 : getCount()) - 1) {
            c4033c.f18594h.setVisibility(0);
            if (i10 == 0) {
                Context context = this.f18571b;
                if (!(context instanceof BackupOptionsDetailActivity)) {
                    c4033c.f18587a.setBackground(context.getDrawable(R$drawable.cardview_list_top_shape_white));
                    return;
                }
            }
            c4033c.f18587a.setBackground(this.f18571b.getDrawable(R$color.storage_manager_card_bg));
            return;
        }
        c4033c.f18594h.setVisibility(8);
        if (i10 != 0) {
            c4033c.f18587a.setBackground(this.f18571b.getDrawable(R$drawable.cardview_list_bottom_shape_white));
            return;
        }
        Context context2 = this.f18571b;
        if (context2 instanceof BackupOptionsDetailActivity) {
            c4033c.f18587a.setBackground(context2.getDrawable(R$drawable.cardview_list_bottom_shape_white));
        } else {
            c4033c.f18587a.setBackground(context2.getDrawable(R$drawable.storage_manage_cardview_list_shape_white));
        }
    }

    /* renamed from: r */
    public final void m24831r(C4032b c4032b, AppDetailsInfo appDetailsInfo) {
        if (c4032b == null || appDetailsInfo == null) {
            return;
        }
        if (appDetailsInfo.isRequestLoading()) {
            c4032b.f18584b.setVisibility(0);
            c4032b.f18584b.setText(this.f18571b.getResources().getString(R$string.cloud_space_detail_list_loading_tip));
            return;
        }
        if (appDetailsInfo.isRequestFail()) {
            if (appDetailsInfo.getErrorCode() == 5009 || "baseData".equals(appDetailsInfo.getBackupAppName())) {
                c4032b.f18584b.setVisibility(8);
                return;
            } else {
                c4032b.f18584b.setVisibility(0);
                c4032b.f18584b.setText(this.f18571b.getResources().getString(R$string.backup_cleanup_loading_error_tip_1));
                return;
            }
        }
        c4032b.f18584b.setVisibility(0);
        long totalSize = appDetailsInfo.getTotalSize();
        if (totalSize > 0) {
            c4032b.f18584b.setText(C0223k.m1524g(this.f18571b, totalSize));
        } else if (C12590s0.m75865j1() && totalSize == 0) {
            c4032b.f18584b.setText(this.f18571b.getResources().getString(R$string.basic_data_service));
        } else {
            c4032b.f18584b.setText(this.f18571b.getString(R$string.backup_option_no_data));
        }
    }

    /* renamed from: s */
    public void m24832s(ListView listView, String str, boolean z10) {
        RecyclerView recyclerView;
        if (TextUtils.isEmpty(str) || this.f18573d == null || listView == null || this.f18572c == null) {
            return;
        }
        if (z10) {
            View viewM24822i = m24822i(listView, getCount() - 1);
            if (viewM24822i == null || !(viewM24822i.getTag() instanceof C4032b)) {
                return;
            }
            C4032b c4032b = (C4032b) viewM24822i.getTag();
            ThirdIconAdapter thirdIconAdapter = this.f18577h;
            if (thirdIconAdapter == null || (recyclerView = c4032b.f18586d) == null) {
                return;
            }
            thirdIconAdapter.m25308F(recyclerView, str);
            return;
        }
        int iM24820g = m24820g(str);
        if (iM24820g == -1) {
            return;
        }
        AppDetailsInfo appDetailsInfo = this.f18573d.get(iM24820g);
        View viewM24822i2 = m24822i(listView, iM24820g);
        if (viewM24822i2 == null || appDetailsInfo == null) {
            return;
        }
        C4033c c4033c = (C4033c) viewM24822i2.getTag();
        if (appDetailsInfo.isVirtualApp()) {
            c4033c.f18589c.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(str, null));
        } else if (C14333b.m85483r().containsKey(str)) {
            c4033c.f18589c.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(str));
        } else {
            c4033c.f18589c.setImageDrawable(CloudBackup3rdIconUtil.get3rdDrawable(str));
        }
    }

    /* renamed from: t */
    public void m24833t(ListView listView, AppDetailsInfo appDetailsInfo) {
        String backupAppName;
        int iM24820g;
        if (appDetailsInfo == null || this.f18573d == null || (iM24820g = m24820g((backupAppName = appDetailsInfo.getBackupAppName()))) == -1) {
            return;
        }
        for (AppDetailsInfo appDetailsInfo2 : this.f18573d) {
            if (TextUtils.equals(backupAppName, appDetailsInfo2.getBackupAppName())) {
                appDetailsInfo2.copy(appDetailsInfo);
                View viewM24822i = m24822i(listView, iM24820g);
                if (viewM24822i != null) {
                    if (viewM24822i.getTag() instanceof C4033c) {
                        C4033c c4033c = (C4033c) viewM24822i.getTag();
                        m24835v(c4033c, appDetailsInfo2);
                        m24834u(c4033c, appDetailsInfo2, iM24820g, backupAppName);
                        return;
                    } else {
                        if (viewM24822i.getTag() instanceof C4032b) {
                            m24831r((C4032b) viewM24822i.getTag(), appDetailsInfo2);
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: u */
    public final void m24834u(C4033c c4033c, AppDetailsInfo appDetailsInfo, int i10, String str) {
        if ("baseData".equals(str)) {
            c4033c.f18595i.setVisibility(0);
            c4033c.f18595i.setOnClickListener(this.f18575f);
            c4033c.f18593g.setVisibility(8);
            c4033c.f18597k.setVisibility(8);
            c4033c.f18595i.setAlpha(0.6f);
            c4033c.f18592f.setVisibility(0);
            c4033c.f18592f.setText(this.f18571b.getString(R$string.cloudbackup_base_data_tip));
            c4033c.f18598l.setVisibility(8);
            return;
        }
        c4033c.f18595i.setVisibility(8);
        c4033c.f18596j.setVisibility(8);
        if (appDetailsInfo.getUiStyle() == 1) {
            c4033c.f18593g.setVisibility(0);
            c4033c.f18597k.setVisibility(8);
            c4033c.f18598l.setVisibility(8);
            c4033c.f18593g.setChecked(appDetailsInfo.isCheck());
        } else if (appDetailsInfo.getUiStyle() == 0) {
            c4033c.f18593g.setChecked(false);
            c4033c.f18597k.setVisibility(this.f18579j ? 8 : 0);
            c4033c.f18597k.setTag(Integer.valueOf(i10));
            c4033c.f18598l.setVisibility(8);
            c4033c.f18593g.setVisibility(8);
        } else {
            c4033c.f18593g.setChecked(false);
            c4033c.f18597k.setVisibility(8);
            c4033c.f18598l.setVisibility(0);
            c4033c.f18593g.setVisibility(8);
        }
        c4033c.f18592f.setVisibility(8);
    }

    /* renamed from: v */
    public final void m24835v(C4033c c4033c, AppDetailsInfo appDetailsInfo) {
        if (c4033c == null || appDetailsInfo == null) {
            return;
        }
        if (appDetailsInfo.isTemp()) {
            long totalSize = appDetailsInfo.getTotalSize();
            if (totalSize <= 0) {
                c4033c.f18591e.setText(this.f18571b.getString(R$string.backup_option_no_data));
                return;
            } else {
                c4033c.f18591e.setText(C0223k.m1524g(this.f18571b, totalSize));
                return;
            }
        }
        if (appDetailsInfo.isRequestLoading()) {
            c4033c.f18591e.setVisibility(0);
            c4033c.f18591e.setText(this.f18571b.getResources().getString(R$string.cloud_space_detail_list_loading_tip));
            return;
        }
        if (appDetailsInfo.isRequestFail()) {
            if (appDetailsInfo.getErrorCode() == 5009 || "baseData".equals(appDetailsInfo.getBackupAppName())) {
                c4033c.f18591e.setVisibility(8);
                return;
            } else {
                c4033c.f18591e.setVisibility(0);
                c4033c.f18591e.setText(this.f18571b.getResources().getString(R$string.backup_cleanup_loading_error_tip_1));
                return;
            }
        }
        c4033c.f18591e.setVisibility(0);
        long totalSize2 = appDetailsInfo.getTotalSize();
        if (totalSize2 > 0) {
            c4033c.f18591e.setText(C0223k.m1524g(this.f18571b, totalSize2));
        } else if (C12590s0.m75865j1() && totalSize2 == 0) {
            c4033c.f18591e.setText(this.f18571b.getResources().getString(R$string.basic_data_service));
        } else {
            c4033c.f18591e.setText(this.f18571b.getString(R$string.backup_option_no_data));
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupSpaceDetailAdapter$b */
    public static class C4032b {

        /* renamed from: a */
        public NotchFitRelativeLayout f18583a;

        /* renamed from: b */
        public TextView f18584b;

        /* renamed from: c */
        public TextView f18585c;

        /* renamed from: d */
        public RecyclerView f18586d;

        public C4032b() {
            this.f18583a = null;
            this.f18584b = null;
            this.f18585c = null;
            this.f18586d = null;
        }

        public /* synthetic */ C4032b(ViewOnClickListenerC4031a viewOnClickListenerC4031a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupSpaceDetailAdapter$c */
    public static class C4033c {

        /* renamed from: a */
        public RelativeLayout f18587a;

        /* renamed from: b */
        public RelativeLayout f18588b;

        /* renamed from: c */
        public ImageView f18589c;

        /* renamed from: d */
        public TextView f18590d;

        /* renamed from: e */
        public TextView f18591e;

        /* renamed from: f */
        public TextView f18592f;

        /* renamed from: g */
        public CheckBox f18593g;

        /* renamed from: h */
        public View f18594h;

        /* renamed from: i */
        public ImageView f18595i;

        /* renamed from: j */
        public ImageView f18596j;

        /* renamed from: k */
        public ImageButton f18597k;

        /* renamed from: l */
        public HwProgressBar f18598l;

        public C4033c() {
            this.f18587a = null;
            this.f18588b = null;
            this.f18589c = null;
            this.f18590d = null;
            this.f18591e = null;
            this.f18592f = null;
            this.f18593g = null;
            this.f18594h = null;
        }

        public /* synthetic */ C4033c(ViewOnClickListenerC4031a viewOnClickListenerC4031a) {
            this();
        }
    }
}
