package ae;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordOperation;
import java.util.ArrayList;
import java.util.List;
import ne.C11667a;
import p514o9.C11842p;
import p709vj.C13452e;
import sk.C12806c;
import sk.C12809f;

/* renamed from: ae.z0 */
/* loaded from: classes3.dex */
public class C0186z0 extends BaseAdapter {

    /* renamed from: a */
    public LayoutInflater f740a;

    /* renamed from: b */
    public Context f741b;

    /* renamed from: c */
    public List<CBSSyncRecordOperation> f742c = new ArrayList();

    /* renamed from: d */
    public View.OnClickListener f743d;

    /* renamed from: ae.z0$a */
    public static class a {

        /* renamed from: a */
        public NotchFitRelativeLayout f744a;

        /* renamed from: b */
        public TextView f745b = null;

        /* renamed from: c */
        public TextView f746c = null;

        /* renamed from: d */
        public View f747d = null;
    }

    public C0186z0(Context context, View.OnClickListener onClickListener) {
        this.f741b = null;
        this.f741b = context;
        this.f743d = onClickListener;
        this.f740a = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    public void m1060a(List<CBSSyncRecordOperation> list) {
        this.f742c.addAll(list);
    }

    /* renamed from: b */
    public final void m1061b(CBSSyncRecordOperation cBSSyncRecordOperation, a aVar, String str) throws Resources.NotFoundException {
        Resources resources;
        if (C13452e.m80781L().m80950o().equals(cBSSyncRecordOperation.getDeviceID()) && (resources = this.f741b.getResources()) != null && str != null) {
            str = resources.getString(R$string.cloudbackup_self_device_new_update, str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        aVar.f745b.setText(str);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f742c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f742c.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        View viewM76832e;
        a aVar;
        if (view == null) {
            aVar = new a();
            viewM76832e = C12809f.m76832e(this.f740a, R$layout.device_records_list_item);
            aVar.f744a = (NotchFitRelativeLayout) C12809f.m76831d(viewM76832e, R$id.device_records_list_item);
            aVar.f745b = (TextView) C12809f.m76831d(viewM76832e, R$id.device_records_list_item_title);
            aVar.f746c = (TextView) C12809f.m76831d(viewM76832e, R$id.device_records_list_item_value);
            aVar.f747d = C12809f.m76831d(viewM76832e, R$id.device_records_item_divider);
            viewM76832e.setTag(aVar);
            viewM76832e.setOnClickListener(this.f743d);
        } else {
            viewM76832e = view;
            aVar = (a) view.getTag();
        }
        String aliasName = this.f742c.get(i10).getAliasName();
        String devDisplayName = this.f742c.get(i10).getDevDisplayName();
        if (TextUtils.isEmpty(devDisplayName)) {
            m1061b(this.f742c.get(i10), aVar, aliasName);
        } else {
            m1061b(this.f742c.get(i10), aVar, devDisplayName);
        }
        if (this.f742c.get(i10) != null) {
            String opDesc = this.f742c.get(i10).getOpDesc();
            String dateTime = DateUtils.formatDateTime(this.f741b, C11667a.m69660b(this.f742c.get(i10).getLastUpdateTime(), "yyyy-MM-dd'T'HH:mm:sszzz"), C11842p.m70824j());
            if (!TextUtils.isEmpty(opDesc)) {
                aVar.f746c.setText(this.f741b.getString(R$string.connect_string_colon, opDesc, dateTime));
                aVar.f746c.setVisibility(0);
            }
        } else {
            aVar.f746c.setVisibility(8);
        }
        if (i10 == this.f742c.size() - 1) {
            aVar.f747d.setVisibility(8);
        } else {
            aVar.f747d.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar.f744a);
        C12806c.m76817h(this.f741b, arrayList);
        return viewM76832e;
    }
}
