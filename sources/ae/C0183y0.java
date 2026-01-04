package ae;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupDeviceInfo;
import com.huawei.android.hicloud.cloudbackup.manager.DeviceIconManager;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0223k;
import p336he.C10153d;
import sk.C12809f;

/* renamed from: ae.y0 */
/* loaded from: classes3.dex */
public class C0183y0 extends BaseAdapter {

    /* renamed from: a */
    public LayoutInflater f726a;

    /* renamed from: b */
    public Context f727b;

    /* renamed from: c */
    public List<CloudBackupDeviceInfo> f728c = new ArrayList();

    /* renamed from: d */
    public View.OnClickListener f729d;

    /* renamed from: ae.y0$a */
    public static class a {

        /* renamed from: a */
        public TextView f730a = null;

        /* renamed from: b */
        public TextView f731b = null;

        /* renamed from: c */
        public TextView f732c = null;

        /* renamed from: d */
        public View f733d = null;

        /* renamed from: e */
        public ImageView f734e;

        /* renamed from: f */
        public int f735f;

        /* renamed from: f */
        public int m1057f() {
            return this.f735f;
        }

        /* renamed from: g */
        public void m1058g(int i10) {
            this.f735f = i10;
        }

        /* renamed from: h */
        public void m1059h(NotchFitRelativeLayout notchFitRelativeLayout, TextView textView, TextView textView2, TextView textView3, View view, ImageView imageView) {
            this.f730a = textView;
            this.f731b = textView2;
            this.f732c = textView3;
            this.f733d = view;
            this.f734e = imageView;
        }
    }

    public C0183y0(Context context, View.OnClickListener onClickListener) {
        this.f727b = null;
        this.f727b = context;
        this.f729d = onClickListener;
        this.f726a = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    public void m1048a(List<CloudBackupDeviceInfo> list) {
        this.f728c.addAll(list);
    }

    /* renamed from: b */
    public void m1049b() {
        this.f728c.clear();
    }

    /* renamed from: c */
    public final void m1050c(a aVar, CloudBackupDeviceInfo cloudBackupDeviceInfo) {
        List<CloudRecoveryItem> recoveryItems = cloudBackupDeviceInfo.getRecoveryItems();
        if (!cloudBackupDeviceInfo.isTempBackup() || recoveryItems == null || recoveryItems.size() <= 0) {
            m1051d(aVar, cloudBackupDeviceInfo);
            return;
        }
        CloudRecoveryItem cloudRecoveryItem = recoveryItems.get(0);
        if (cloudRecoveryItem == null || cloudRecoveryItem.getOccupySpaceType() == 1) {
            m1051d(aVar, cloudBackupDeviceInfo);
            return;
        }
        long backupEndTime = cloudRecoveryItem.getBackupEndTime();
        if (backupEndTime != 0) {
            String strM63240d = C10153d.m63240d(this.f727b, backupEndTime);
            if (TextUtils.isEmpty(strM63240d)) {
                aVar.f731b.setVisibility(8);
            } else {
                aVar.f731b.setText(strM63240d);
                aVar.f731b.setVisibility(0);
            }
        }
        int expiratoryInDays = cloudRecoveryItem.getExpiratoryInDays();
        if (expiratoryInDays == 0) {
            expiratoryInDays++;
        }
        aVar.f732c.setText(this.f727b.getResources().getQuantityString(R$plurals.temp_backup_will_delete, expiratoryInDays, Integer.valueOf(expiratoryInDays)));
        aVar.f732c.setVisibility(0);
    }

    /* renamed from: d */
    public final void m1051d(a aVar, CloudBackupDeviceInfo cloudBackupDeviceInfo) {
        aVar.f732c.setVisibility(8);
        long deviceBackupSpace = cloudBackupDeviceInfo.getDeviceBackupSpace();
        if (deviceBackupSpace <= 0) {
            aVar.f731b.setVisibility(8);
            return;
        }
        aVar.f731b.setText(C0209d.m1157C0(C0223k.m1524g(this.f727b, deviceBackupSpace)));
        aVar.f731b.setVisibility(0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f728c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        if (i10 < 0 || i10 >= this.f728c.size()) {
            return null;
        }
        return this.f728c.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewM76832e;
        a aVar;
        if (view == null) {
            aVar = new a();
            viewM76832e = C0209d.m1195O(this.f727b) >= 3.2f ? C12809f.m76832e(this.f726a, R$layout.backup_item_font_scale) : C12809f.m76832e(this.f726a, R$layout.backup_item);
            NotchFitRelativeLayout notchFitRelativeLayout = (NotchFitRelativeLayout) C12809f.m76831d(viewM76832e, R$id.backup_detail);
            TextView textView = (TextView) C12809f.m76831d(viewM76832e, R$id.backup_detail_title);
            TextView textView2 = (TextView) C12809f.m76831d(viewM76832e, R$id.gallery_value);
            TextView textView3 = (TextView) C12809f.m76831d(viewM76832e, R$id.backup_record_last_time);
            ImageView imageView = (ImageView) C12809f.m76831d(viewM76832e, R$id.iv_backup_device_arrow);
            View viewM76831d = C12809f.m76831d(viewM76832e, R$id.backup_item_divider);
            ImageView imageView2 = (ImageView) C12809f.m76831d(viewM76832e, R$id.backup_detail_icon);
            imageView.setVisibility(0);
            aVar.m1059h(notchFitRelativeLayout, textView, textView2, textView3, viewM76831d, imageView2);
            viewM76832e.setTag(aVar);
            viewM76832e.setOnClickListener(this.f729d);
        } else {
            viewM76832e = view;
            aVar = (a) view.getTag();
        }
        aVar.m1058g(i10);
        String string = this.f727b.getString(R$string.setting_other);
        String str = "\u202a" + this.f728c.get(i10).getDevDisplayName() + "\u202c";
        if (TextUtils.isEmpty(str)) {
            this.f728c.get(i10).setDevDisplayName(string);
        } else {
            string = str;
        }
        if (this.f728c.get(i10).isCurrent()) {
            TextView textView4 = aVar.f730a;
            Context context = this.f727b;
            textView4.setText(context.getString(R$string.about_recover_tip, string, context.getString(R$string.current_device_new), ""));
        } else {
            aVar.f730a.setText(string);
        }
        this.f728c.get(i10).getLastBackupTime();
        m1050c(aVar, this.f728c.get(i10));
        if (i10 == this.f728c.size() - 1) {
            aVar.f733d.setVisibility(8);
        } else {
            aVar.f733d.setVisibility(0);
        }
        aVar.f730a.setContentDescription(((Object) aVar.f730a.getText()) + ".");
        aVar.f731b.setContentDescription(aVar.f731b.getText());
        aVar.f734e.setImageDrawable(DeviceIconManager.getInstance().getDeviceIconFromCache(this.f728c.get(i10).getTerminalType(), this.f728c.get(i10).getDeviceCategory()));
        return viewM76832e;
    }
}
