package ae;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.manager.DeviceIconManager;
import com.huawei.android.hicloud.cloudspace.bean.CBSpaceDetail;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.router.data.ExtraDeviceInfo;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0223k;
import p336he.C10153d;
import p514o9.C11842p;
import sk.C12809f;

/* renamed from: ae.w1 */
/* loaded from: classes3.dex */
public class C0178w1 extends BaseAdapter {

    /* renamed from: a */
    public LayoutInflater f684a;

    /* renamed from: b */
    public Context f685b;

    /* renamed from: c */
    public List<CBSpaceDetail> f686c = new ArrayList();

    /* renamed from: d */
    public View.OnClickListener f687d;

    /* renamed from: e */
    public final boolean f688e;

    /* renamed from: ae.w1$a */
    public static class a {

        /* renamed from: a */
        public TextView f689a = null;

        /* renamed from: b */
        public TextView f690b = null;

        /* renamed from: c */
        public TextView f691c = null;

        /* renamed from: d */
        public View f692d = null;

        /* renamed from: e */
        public ImageView f693e;

        /* renamed from: f */
        public ImageView f694f;

        /* renamed from: g */
        public int f695g;

        /* renamed from: g */
        public int m984g() {
            return this.f695g;
        }

        /* renamed from: h */
        public void m985h(int i10) {
            this.f695g = i10;
        }

        /* renamed from: i */
        public void m986i(TextView textView, TextView textView2, TextView textView3, View view, ImageView imageView, ImageView imageView2) {
            this.f689a = textView;
            this.f691c = textView2;
            this.f690b = textView3;
            this.f692d = view;
            this.f693e = imageView;
            this.f694f = imageView2;
        }
    }

    public C0178w1(Context context, View.OnClickListener onClickListener, boolean z10) {
        this.f685b = null;
        this.f685b = context;
        this.f687d = onClickListener;
        this.f684a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f688e = z10;
    }

    /* renamed from: a */
    public void m972a(List<CBSpaceDetail> list) {
        this.f686c.addAll(list);
    }

    /* renamed from: b */
    public void m973b(CBSpaceDetail cBSpaceDetail) {
        this.f686c.add(cBSpaceDetail);
    }

    /* renamed from: c */
    public void m974c() {
        this.f686c.clear();
    }

    /* renamed from: d */
    public void m975d(String str) {
        int size = this.f686c.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (str.equals(this.f686c.get(i10).getDeviceID())) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 < 0 || i10 >= size) {
            return;
        }
        this.f686c.remove(i10);
    }

    /* renamed from: e */
    public final void m976e(a aVar, CBSpaceDetail cBSpaceDetail) {
        long lastbackupTime = cBSpaceDetail.getLastbackupTime();
        if (!this.f688e && lastbackupTime > 0) {
            aVar.f690b.setVisibility(0);
            aVar.f690b.setText(DateUtils.formatDateTime(this.f685b, lastbackupTime, C11842p.m70824j()));
        } else {
            aVar.f690b.setVisibility(8);
        }
        long size = cBSpaceDetail.getSize();
        String strM1157C0 = C0209d.m1157C0(C0223k.m1524g(this.f685b, size));
        if (size <= 0) {
            aVar.f691c.setVisibility(8);
        } else if (this.f688e) {
            aVar.f691c.setVisibility(0);
            aVar.f691c.setText(strM1157C0);
        } else {
            aVar.f691c.setVisibility(0);
            aVar.f691c.setText(this.f685b.getString(R$string.backup_data_size, strM1157C0));
        }
    }

    /* renamed from: f */
    public final void m977f(a aVar, CBSpaceDetail cBSpaceDetail) {
        if (!cBSpaceDetail.isTempBackup() || cBSpaceDetail.getExtraDeviceInfos() == null || cBSpaceDetail.getExtraDeviceInfos().size() <= 0) {
            m976e(aVar, cBSpaceDetail);
            return;
        }
        ExtraDeviceInfo extraDeviceInfo = cBSpaceDetail.getExtraDeviceInfos().get(0);
        if (extraDeviceInfo == null || extraDeviceInfo.getOccupySpaceType().intValue() == 1) {
            m976e(aVar, cBSpaceDetail);
            return;
        }
        long lastbackupTime = cBSpaceDetail.getLastbackupTime();
        if (lastbackupTime != 0) {
            String strM63240d = C10153d.m63240d(this.f685b, lastbackupTime);
            if (TextUtils.isEmpty(strM63240d)) {
                aVar.f691c.setVisibility(8);
            } else {
                aVar.f691c.setText(strM63240d);
                aVar.f691c.setVisibility(0);
            }
        }
        int expiratoryInDays = extraDeviceInfo.getExpiratoryInDays();
        if (expiratoryInDays == 0) {
            expiratoryInDays++;
        }
        aVar.f690b.setText(this.f685b.getResources().getQuantityString(R$plurals.temp_backup_will_delete, expiratoryInDays, Integer.valueOf(expiratoryInDays)));
        aVar.f690b.setVisibility(0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f686c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        if (i10 < 0 || i10 >= this.f686c.size()) {
            return null;
        }
        return this.f686c.get(i10);
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
            viewM76832e = C0209d.m1195O(this.f685b) >= 3.2f ? C12809f.m76832e(this.f684a, R$layout.backup_item_font_scale) : C12809f.m76832e(this.f684a, R$layout.backup_item);
            aVar.m986i((TextView) C12809f.m76831d(viewM76832e, R$id.backup_detail_title), (TextView) C12809f.m76831d(viewM76832e, R$id.gallery_value), (TextView) C12809f.m76831d(viewM76832e, R$id.backup_record_last_time), C12809f.m76831d(viewM76832e, R$id.backup_item_divider), (ImageView) C12809f.m76831d(viewM76832e, R$id.backup_detail_icon), (ImageView) C12809f.m76831d(viewM76832e, R$id.iv_backup_device_right_arrow));
            viewM76832e.setTag(aVar);
            viewM76832e.setOnClickListener(this.f687d);
        } else {
            viewM76832e = view;
            aVar = (a) view.getTag();
        }
        aVar.m985h(i10);
        String string = this.f685b.getString(R$string.setting_other);
        String str = "\u202a" + this.f686c.get(i10).getDeviceName() + "\u202c";
        if (TextUtils.isEmpty(str)) {
            this.f686c.get(i10).setDeviceName(string);
        } else {
            string = str;
        }
        if (this.f686c.get(i10).isCurrent()) {
            TextView textView = aVar.f689a;
            Context context = this.f685b;
            textView.setText(context.getString(R$string.about_recover_tip, string, context.getString(R$string.current_device_new), ""));
        } else {
            aVar.f689a.setText(string);
        }
        m977f(aVar, this.f686c.get(i10));
        if (i10 == this.f686c.size() - 1) {
            aVar.f692d.setVisibility(8);
        } else {
            aVar.f692d.setVisibility(0);
        }
        aVar.f689a.setContentDescription(((Object) aVar.f689a.getText()) + ".");
        aVar.f691c.setContentDescription(aVar.f691c.getText());
        aVar.f693e.setImageDrawable(DeviceIconManager.getInstance().getDeviceIconFromCache(this.f686c.get(i10).getTerminalType(), this.f686c.get(i10).getDeviceCategory()));
        aVar.f694f.setVisibility(0);
        return viewM76832e;
    }
}
