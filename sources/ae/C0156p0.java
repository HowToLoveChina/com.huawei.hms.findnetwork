package ae;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.p088ui.activity.CloudDiskOperateBaseActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.sync.R$color;
import com.huawei.android.sync.R$drawable;
import com.huawei.android.sync.R$id;
import com.huawei.android.sync.R$layout;
import com.huawei.android.sync.R$plurals;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.uikit.hwprogressbutton.widget.HwProgressButton;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0214f0;
import p514o9.C11839m;
import p514o9.C11842p;
import p783xp.C13843a;
import sk.C12806c;
import sk.C12809f;

/* renamed from: ae.p0 */
/* loaded from: classes3.dex */
public class C0156p0 extends BaseAdapter {

    /* renamed from: f */
    public static final Double f569f = Double.valueOf(1.75d);

    /* renamed from: a */
    public Context f570a;

    /* renamed from: b */
    public LayoutInflater f571b;

    /* renamed from: c */
    public List<ModuleItem> f572c;

    /* renamed from: d */
    public String f573d;

    /* renamed from: e */
    public SharedPreferences f574e;

    /* renamed from: ae.p0$a */
    public class a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ ModuleItem f575a;

        public a(ModuleItem moduleItem) {
            this.f575a = moduleItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i10 = c.f579a[this.f575a.getState().ordinal()];
            if (i10 == 1) {
                C0156p0.this.m869d(this.f575a);
                return;
            }
            if (i10 == 2) {
                ((CloudDiskOperateBaseActivity) C0156p0.this.f570a).m19735a2(this.f575a);
                return;
            }
            if (i10 != 3) {
                return;
            }
            if (this.f575a.isInTask()) {
                ((CloudDiskOperateBaseActivity) C0156p0.this.f570a).m19735a2(this.f575a);
            } else {
                this.f575a.setState(ModuleItem.State.NORMAL);
                C0156p0.this.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: ae.p0$b */
    public class b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ ModuleItem f577a;

        public b(ModuleItem moduleItem) {
            this.f577a = moduleItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((CloudDiskOperateBaseActivity) C0156p0.this.f570a).m19732X1(this.f577a);
        }
    }

    /* renamed from: ae.p0$c */
    public static /* synthetic */ class c {

        /* renamed from: a */
        public static final /* synthetic */ int[] f579a;

        static {
            int[] iArr = new int[ModuleItem.State.values().length];
            f579a = iArr;
            try {
                iArr[ModuleItem.State.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f579a[ModuleItem.State.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f579a[ModuleItem.State.WAITING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f579a[ModuleItem.State.CANCLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f579a[ModuleItem.State.DELETING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: ae.p0$d */
    public static class d {

        /* renamed from: a */
        public NotchFitRelativeLayout f580a;

        /* renamed from: b */
        public RelativeLayout f581b;

        /* renamed from: c */
        public TextView f582c;

        /* renamed from: d */
        public TextView f583d;

        /* renamed from: e */
        public HwButton f584e;

        /* renamed from: f */
        public HwProgressButton f585f;

        /* renamed from: g */
        public ModuleItem f586g;

        /* renamed from: h */
        public View f587h;
    }

    public C0156p0(Context context, List<ModuleItem> list, String str) {
        this.f570a = context;
        this.f572c = list;
        this.f573d = str;
        this.f571b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: c */
    public final void m868c(View view) throws Resources.NotFoundException {
        view.setEnabled(false);
        d dVar = (d) view.getTag();
        ModuleItem moduleItem = dVar.f586g;
        if (TextUtils.isEmpty(moduleItem.getDisplayName())) {
            dVar.f582c.setText(this.f570a.getResources().getString(R$string.setting_other));
        } else {
            dVar.f582c.setText(moduleItem.getDisplayName());
        }
        if ("autosmslistkey".equals(this.f573d) || "autocallloglistkey".equals(this.f573d)) {
            dVar.f583d.setText(CloudSyncUtil.m15998c0(this.f570a.getResources().getQuantityString(R$plurals.cloudbackup_some_records, moduleItem.getNum(), Integer.valueOf(moduleItem.getNum())), Integer.valueOf(moduleItem.getNum())));
        } else if ("autophonemanagerkey".equals(this.f573d)) {
            dVar.f583d.setText(C13843a.m83086h(this.f570a, moduleItem.getSpace()));
        } else {
            dVar.f583d.setText(this.f570a.getResources().getString(R$string.about_recover_tip_null, this.f570a.getResources().getQuantityString(R$plurals.cloudbackup_some_records, moduleItem.getNum(), Integer.valueOf(moduleItem.getNum())), C13843a.m83086h(this.f570a, moduleItem.getSpace())));
        }
        m871f(moduleItem, dVar);
        dVar.f585f.setOnClickListener(new a(moduleItem));
        dVar.f584e.setOnClickListener(new b(moduleItem));
        m874i(view);
    }

    /* renamed from: d */
    public final void m869d(ModuleItem moduleItem) {
        if (("autorecordingkey".equals(this.f573d) || "autophonemanagerkey".equals(this.f573d)) && CloudSyncUtil.m16022k0()) {
            ((CloudDiskOperateBaseActivity) this.f570a).m19727S2();
        } else {
            ((CloudDiskOperateBaseActivity) this.f570a).m19734Z1(moduleItem);
        }
    }

    /* renamed from: e */
    public final View m870e(ViewGroup viewGroup) {
        return this.f571b.inflate(((double) this.f570a.getResources().getConfiguration().fontScale) >= f569f.doubleValue() ? R$layout.down_delete_clouddata_view_font : R$layout.down_delete_clouddata_view, viewGroup, false);
    }

    /* renamed from: f */
    public final void m871f(ModuleItem moduleItem, d dVar) {
        this.f574e = C0214f0.m1382b(this.f570a, "deviceNameSp", 0);
        String deviceID = moduleItem.getDeviceID();
        if (TextUtils.isEmpty(deviceID)) {
            C11839m.m70687e("CloudDiskOperateAdpater", "setDownloadButtonText deviceid is null ");
            dVar.f585f.setIdleText(this.f570a.getResources().getString(R$string.doadload_new));
        }
        String str = this.f573d;
        str.hashCode();
        switch (str) {
            case "autorecordingkey":
                m873h(this.f574e.getBoolean("autorecordingkey_download" + deviceID, false), dVar);
                break;
            case "autosmslistkey":
                m873h(this.f574e.getBoolean("autosmslistkey_download" + deviceID, false), dVar);
                break;
            case "autophonemanagerkey":
                m873h(this.f574e.getBoolean("autophonemanagerkey_download" + deviceID, false), dVar);
                break;
            case "autocallloglistkey":
                m873h(this.f574e.getBoolean("autocallloglistkey_download" + deviceID, false), dVar);
                break;
            case "notepad":
                m873h(this.f574e.getBoolean("notepad_download" + deviceID, false), dVar);
                break;
            default:
                dVar.f585f.setIdleText(this.f570a.getResources().getString(R$string.doadload_new));
                break;
        }
    }

    /* renamed from: g */
    public final void m872g(int i10, d dVar) {
        int iM70840n = C11842p.m70840n(this.f570a, 4);
        if (getCount() == 1) {
            dVar.f581b.setBackground(this.f570a.getDrawable(R$drawable.category_item_single_bg));
            dVar.f581b.setPadding(0, iM70840n, 0, iM70840n);
        } else if (i10 == 0) {
            dVar.f581b.setBackground(this.f570a.getDrawable(R$drawable.category_item_up_bg));
            dVar.f581b.setPadding(0, iM70840n, 0, 0);
        } else if (i10 == getCount() - 1) {
            dVar.f581b.setBackground(this.f570a.getDrawable(R$drawable.category_item_down_bg));
            dVar.f581b.setPadding(0, 0, 0, iM70840n);
        } else {
            dVar.f581b.setBackground(this.f570a.getDrawable(R$drawable.category_item_middle_bg));
            dVar.f581b.setPadding(0, 0, 0, 0);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f572c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f572c.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        d dVar = new d();
        ModuleItem moduleItem = (ModuleItem) getItem(i10);
        if (moduleItem == null) {
            return null;
        }
        View viewM870e = m870e(viewGroup);
        dVar.f580a = (NotchFitRelativeLayout) C12809f.m76831d(viewM870e, R$id.notch_fit_layout);
        dVar.f581b = (RelativeLayout) C12809f.m76831d(viewM870e, R$id.cloud_data_item);
        dVar.f582c = (TextView) C12809f.m76831d(viewM870e, R$id.device_name);
        dVar.f583d = (TextView) C12809f.m76831d(viewM870e, R$id.clouddata_totalnum_title);
        HwProgressButton hwProgressButton = (HwProgressButton) C12809f.m76831d(viewM870e, R$id.clouddata_download_btn);
        dVar.f585f = hwProgressButton;
        hwProgressButton.getProgressBar().setImportantForAccessibility(2);
        dVar.f584e = (HwButton) C12809f.m76831d(viewM870e, R$id.clouddata_delete_btn);
        dVar.f587h = C12809f.m76831d(viewM870e, R$id.down_delete_clouddata_divider);
        dVar.f586g = moduleItem;
        viewM870e.setTag(dVar);
        m872g(i10, dVar);
        if (i10 == getCount() - 1) {
            dVar.f587h.setVisibility(8);
        } else {
            dVar.f587h.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar.f580a);
        C12806c.m76817h(this.f570a, arrayList);
        m868c(viewM870e);
        return viewM870e;
    }

    /* renamed from: h */
    public final void m873h(boolean z10, d dVar) {
        if (z10) {
            dVar.f585f.setIdleText(this.f570a.getResources().getString(R$string.doadload_complete));
        } else {
            dVar.f585f.setIdleText(this.f570a.getResources().getString(R$string.doadload_new));
        }
    }

    /* renamed from: i */
    public final void m874i(View view) {
        d dVar = (d) view.getTag();
        if (dVar.f586g.getState().equals(ModuleItem.State.NORMAL)) {
            dVar.f582c.setAlpha(1.0f);
            dVar.f583d.setAlpha(1.0f);
            dVar.f585f.setAlpha(1.0f);
            dVar.f584e.setTextColor(this.f570a.getResources().getColor(R$color.enui50_red_color));
            dVar.f584e.setEnabled(true);
            dVar.f584e.setClickable(true);
            m871f(dVar.f586g, dVar);
            dVar.f585f.setEnabled(true);
            return;
        }
        if (dVar.f586g.getState().equals(ModuleItem.State.DELETING)) {
            dVar.f582c.setAlpha(0.3f);
            dVar.f583d.setAlpha(0.3f);
            dVar.f585f.setAlpha(0.3f);
            dVar.f584e.setTextColor(this.f570a.getResources().getColor(R$color.enui50_red_color_30));
            dVar.f584e.setEnabled(false);
            dVar.f584e.setClickable(false);
            dVar.f585f.setEnabled(false);
            m871f(dVar.f586g, dVar);
            return;
        }
        dVar.f582c.setAlpha(1.0f);
        dVar.f583d.setAlpha(1.0f);
        dVar.f585f.setAlpha(1.0f);
        dVar.f584e.setTextColor(this.f570a.getResources().getColor(R$color.enui50_red_color_30));
        dVar.f584e.setEnabled(false);
        dVar.f584e.setClickable(false);
        dVar.f585f.setEnabled(true);
        if (dVar.f586g.getState().equals(ModuleItem.State.CANCLE)) {
            dVar.f585f.setEnabled(false);
        }
        dVar.f585f.setIdleText(this.f570a.getResources().getString(R$string.cloudbackup_Cancel));
        dVar.f585f.incrementProgressBy(dVar.f586g.getProgress());
    }
}
