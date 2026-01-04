package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.ListItemRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiutil.NewHiSyncUtil;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import java.util.List;
import p015ak.C0209d;
import p514o9.C11839m;
import p514o9.C11842p;
import p709vj.C13452e;
import p711vl.C13467g;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudBackupRecordsAdapter extends BaseAdapter {

    /* renamed from: a */
    public List<CloudRecoveryItem> f18641a;

    /* renamed from: b */
    public Context f18642b;

    /* renamed from: c */
    public Resources f18643c;

    /* renamed from: d */
    public LayoutInflater f18644d;

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.CloudBackupRecordsAdapter$a */
    public static class C4039a {

        /* renamed from: a */
        public ListItemRelativeLayout f18645a;

        /* renamed from: b */
        public TextView f18646b;

        /* renamed from: c */
        public TextView f18647c;

        /* renamed from: d */
        public View f18648d;

        /* renamed from: e */
        public TextView f18649e;

        /* renamed from: f */
        public TextView f18650f;

        /* renamed from: g */
        public TextView f18651g;

        /* renamed from: h */
        public TextView f18652h;

        /* renamed from: i */
        public TextView f18653i;

        /* renamed from: j */
        public ImageView f18654j;
    }

    public CloudBackupRecordsAdapter(Context context) {
        this.f18642b = context;
        if (context != null) {
            this.f18643c = context.getResources();
            this.f18644d = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    /* renamed from: a */
    public final SpannableStringBuilder m24906a(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int length = str2.length();
        int iIndexOf = str.indexOf(str2);
        int i10 = length + iIndexOf;
        C11839m.m70686d("CloudBackupRecordsAdapter", "content =" + str + " handleContent =" + str2);
        if (iIndexOf >= 0 && str.length() > i10) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f18642b.getColor(R$color.cloud_color_error)), iIndexOf, i10, 33);
        }
        return spannableStringBuilder;
    }

    /* renamed from: b */
    public final int m24907b(int i10) {
        if (i10 == 1) {
            return 1;
        }
        if (i10 != 2) {
            return i10 != 3 ? 0 : 4;
        }
        return 2;
    }

    /* renamed from: c */
    public final String m24908c(CloudRecoveryItem cloudRecoveryItem) {
        String deviceName = cloudRecoveryItem.getDeviceName();
        String terminalType = cloudRecoveryItem.getTerminalType();
        String devDisplayName = cloudRecoveryItem.getDevDisplayName();
        if (!TextUtils.isEmpty(devDisplayName)) {
            deviceName = devDisplayName;
        } else if (TextUtils.isEmpty(deviceName)) {
            deviceName = this.f18642b.getString(R$string.setting_other);
        }
        String strM1232a0 = C0209d.m1232a0(deviceName);
        if (!cloudRecoveryItem.isCurrent()) {
            return NewHiSyncUtil.m25634d("", strM1232a0, terminalType, devDisplayName, this.f18642b);
        }
        Context context = this.f18642b;
        return context.getString(R$string.about_recover_tip, strM1232a0, context.getString(R$string.current_device_new), "");
    }

    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public CloudRecoveryItem getItem(int i10) {
        List<CloudRecoveryItem> list = this.f18641a;
        return (list == null || i10 >= list.size()) ? new CloudRecoveryItem() : this.f18641a.get(i10);
    }

    /* renamed from: e */
    public final void m24910e(CloudRecoveryItem cloudRecoveryItem, C4039a c4039a) {
        int backupRecordLabel = cloudRecoveryItem.getBackupRecordLabel();
        if (backupRecordLabel != 3) {
            c4039a.f18653i.setVisibility(8);
            c4039a.f18652h.setAlpha(1.0f);
            c4039a.f18647c.setAlpha(1.0f);
            c4039a.f18654j.setAlpha(1.0f);
            c4039a.f18647c.setTextColor(this.f18642b.getColor(R$color.title_color_90));
            if (cloudRecoveryItem.isTempBackup()) {
                c4039a.f18652h.setVisibility(8);
                return;
            } else if (!C13452e.m80781L().m80887a1()) {
                c4039a.f18652h.setVisibility(8);
                return;
            } else {
                c4039a.f18652h.setVisibility(0);
                m24911f(c4039a, backupRecordLabel);
                return;
            }
        }
        TextView textView = c4039a.f18647c;
        Context context = this.f18642b;
        int i10 = R$color.title_color_90;
        textView.setTextColor(context.getColor(i10));
        c4039a.f18652h.setVisibility(0);
        m24911f(c4039a, m24907b(cloudRecoveryItem.getBmDataType()));
        c4039a.f18647c.setMaxWidth(this.f18643c.getDisplayMetrics().widthPixels / 2);
        c4039a.f18645a.setBackground(this.f18642b.getDrawable(R$drawable.hmos_list_selector));
        if (cloudRecoveryItem.getModuleCompatibility() == 0 || cloudRecoveryItem.isTempBackup()) {
            c4039a.f18653i.setVisibility(0);
            c4039a.f18653i.setText(this.f18643c.getString(R$string.backup_recover_all_items_not_support));
            c4039a.f18647c.setAlpha(0.4f);
            c4039a.f18652h.setAlpha(0.4f);
            c4039a.f18654j.setAlpha(0.4f);
            c4039a.f18645a.setBackground(null);
        } else if (cloudRecoveryItem.getModuleCompatibility() == 1) {
            c4039a.f18653i.setVisibility(0);
            c4039a.f18647c.setAlpha(1.0f);
            c4039a.f18652h.setAlpha(1.0f);
            c4039a.f18654j.setAlpha(1.0f);
            c4039a.f18653i.setText(this.f18643c.getString(R$string.backup_recover_some_items_not_support));
        } else {
            c4039a.f18647c.setTextColor(this.f18642b.getColor(i10));
            c4039a.f18653i.setVisibility(8);
            c4039a.f18647c.setAlpha(1.0f);
            c4039a.f18652h.setAlpha(1.0f);
            c4039a.f18654j.setAlpha(1.0f);
        }
        if (C13452e.m80781L().m80887a1()) {
            c4039a.f18652h.setVisibility(0);
        } else {
            c4039a.f18652h.setVisibility(8);
        }
    }

    /* renamed from: f */
    public final void m24911f(C4039a c4039a, int i10) {
        if (i10 == 1) {
            c4039a.f18652h.setText(this.f18643c.getString(R$string.backup_base_data));
            return;
        }
        if (i10 == 2) {
            c4039a.f18652h.setText(this.f18643c.getString(R$string.backup_base_and_full_data_new));
        } else if (i10 == 4) {
            c4039a.f18652h.setText(this.f18643c.getString(R$string.backup_full_data));
        } else {
            c4039a.f18652h.setText(this.f18643c.getString(R$string.history_data_title));
        }
    }

    /* renamed from: g */
    public final void m24912g(C4039a c4039a, View view) {
        try {
            boolean zM76836i = C12809f.m76836i(c4039a.f18652h);
            C12809f.m76843p(C12809f.m76831d(view, R$id.frame_layout), zM76836i);
            C12809f.m76843p(C12809f.m76831d(view, R$id.frame_layout_first_lines), !zM76836i);
            if (zM76836i) {
                return;
            }
            ImageView imageView = (ImageView) C12809f.m76831d(view, R$id.right_arrow_first_lines);
            imageView.setAlpha(c4039a.f18654j.getAlpha());
            c4039a.f18654j = imageView;
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupRecordsAdapter", "setFontRightArrow error, e = " + e10.getMessage());
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<CloudRecoveryItem> list = this.f18641a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        List<CloudRecoveryItem> list;
        C4039a c4039a;
        if (this.f18643c != null && (list = this.f18641a) != null && i10 < list.size()) {
            CloudRecoveryItem cloudRecoveryItem = this.f18641a.get(i10);
            if (cloudRecoveryItem == null) {
                return view;
            }
            float fM1195O = C0209d.m1195O(this.f18642b);
            if (view == null) {
                view = fM1195O >= 1.45f ? C12809f.m76832e(this.f18644d, R$layout.recovery_list_item_font_scale) : C12809f.m76832e(this.f18644d, R$layout.recovery_list_item);
                c4039a = new C4039a();
                c4039a.f18645a = (ListItemRelativeLayout) C12809f.m76831d(view, R$id.recovery_list_item_content);
                c4039a.f18647c = (TextView) C12809f.m76831d(view, R$id.recovery_list_item_title);
                c4039a.f18646b = (TextView) C12809f.m76831d(view, R$id.recovery_list_item_value);
                c4039a.f18648d = C12809f.m76831d(view, R$id.recovery_list_item_divider);
                c4039a.f18649e = (TextView) C12809f.m76831d(view, R$id.recovery_list_item_refurbishment);
                c4039a.f18650f = (TextView) C12809f.m76831d(view, R$id.number_of_days);
                c4039a.f18651g = (TextView) C12809f.m76831d(view, R$id.recovery_list_item_unfinished);
                c4039a.f18652h = (TextView) C12809f.m76831d(view, R$id.tv_data_type);
                c4039a.f18653i = (TextView) C12809f.m76831d(view, R$id.recovery_list_item_incompatibility_tips);
                c4039a.f18654j = (ImageView) C12809f.m76831d(view, R$id.right_arrow);
                view.setTag(c4039a);
            } else {
                c4039a = (C4039a) view.getTag();
            }
            c4039a.f18645a.setTag(Integer.valueOf(i10));
            c4039a.f18648d.setVisibility(getCount() + (-1) == i10 ? 8 : 0);
            c4039a.f18647c.setText(cloudRecoveryItem.isBackupCompleted() ? DateUtils.formatDateTime(this.f18642b, cloudRecoveryItem.getBackupEndTime(), C11842p.m70824j()) : DateUtils.formatDateTime(this.f18642b, cloudRecoveryItem.getStartTime(), C11842p.m70824j()));
            m24908c(cloudRecoveryItem);
            if (C13452e.m80781L().m80887a1()) {
                C12809f.m76831d(view, R$id.rl_content).setMinimumHeight(this.f18643c.getDimensionPixelOffset(R$dimen.cloud_space_48_dp));
                if (fM1195O >= 1.45f) {
                    c4039a.f18647c.setMaxWidth(this.f18643c.getDisplayMetrics().widthPixels);
                } else {
                    c4039a.f18647c.setMaxWidth(this.f18643c.getDisplayMetrics().widthPixels / 2);
                }
            }
            c4039a.f18646b.setVisibility(8);
            c4039a.f18645a.setTag(Integer.valueOf(i10));
            c4039a.f18649e.setVisibility(cloudRecoveryItem.isRefurbishment() ? 0 : 8);
            c4039a.f18650f.setVisibility(cloudRecoveryItem.isRefurbishment() ? 0 : 8);
            c4039a.f18651g.setVisibility(cloudRecoveryItem.isBackupCompleted() ? 8 : 0);
            c4039a.f18649e.setMaxWidth(C0209d.m1272k0(this.f18642b) / 2);
            c4039a.f18651g.setMaxWidth(C0209d.m1272k0(this.f18642b) / 2);
            c4039a.f18646b.setMaxWidth(C0209d.m1272k0(this.f18642b) / 2);
            m24910e(cloudRecoveryItem, c4039a);
            if (cloudRecoveryItem.isRefurbishment()) {
                int iM81089d = C13467g.m81086c().m81089d("refurbish_backup_record_refeffe_days", 3);
                c4039a.f18650f.setText(m24906a(this.f18643c.getQuantityString(R$plurals.cloudbackup_number_of_days, iM81089d, Integer.valueOf(iM81089d)), C13843a.m83104z(Integer.valueOf(iM81089d))));
                c4039a.f18652h.setVisibility(8);
                c4039a.f18653i.setVisibility(8);
            }
            if (fM1195O >= 1.45f) {
                m24912g(c4039a, view);
            }
        }
        return view;
    }

    /* renamed from: h */
    public void m24913h(List<CloudRecoveryItem> list) {
        this.f18641a = list;
        notifyDataSetChanged();
    }
}
