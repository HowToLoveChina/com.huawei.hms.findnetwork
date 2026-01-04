package ae;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupUtil;
import com.huawei.android.hicloud.constant.backup.Constant;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p514o9.C11839m;
import p709vj.C13452e;
import sk.C12809f;

/* renamed from: ae.k1 */
/* loaded from: classes3.dex */
public class C0142k1 extends BaseAdapter {

    /* renamed from: a */
    public Context f506a;

    /* renamed from: b */
    public Map<Integer, Boolean> f507b = new HashMap();

    /* renamed from: c */
    public List<Integer> f508c;

    /* renamed from: d */
    public Map<String, String> f509d;

    /* renamed from: e */
    public Map<String, String> f510e;

    /* renamed from: ae.k1$a */
    public class a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ int f511a;

        public a(int i10) {
            this.f511a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (Integer num : C0142k1.this.f507b.keySet()) {
                if (num.intValue() == this.f511a) {
                    C0142k1.this.f507b.put(num, Boolean.TRUE);
                } else {
                    C0142k1.this.f507b.put(num, Boolean.FALSE);
                }
            }
            C0142k1.this.notifyDataSetChanged();
        }
    }

    /* renamed from: ae.k1$b */
    public class b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ int f513a;

        public b(int i10) {
            this.f513a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (Integer num : C0142k1.this.f507b.keySet()) {
                if (num.intValue() == this.f513a) {
                    C0142k1.this.f507b.put(num, Boolean.TRUE);
                } else {
                    C0142k1.this.f507b.put(num, Boolean.FALSE);
                }
            }
            C0142k1.this.notifyDataSetChanged();
        }
    }

    public C0142k1(Context context, List<Integer> list) {
        new ArrayList();
        this.f506a = context;
        this.f508c = list;
    }

    /* renamed from: g */
    public static /* synthetic */ int m814g(String str, String str2) {
        return Integer.parseInt(str.split(" ")[0]) - Integer.parseInt(str2.split(" ")[0]);
    }

    /* renamed from: c */
    public final String m815c(int i10) {
        String strM817e = m817e(i10);
        return TextUtils.isEmpty(strM817e) ? i10 != 1 ? i10 != 3 ? i10 != 5 ? "" : this.f506a.getString(R$string.backup_app_exclusive_one, 50) : this.f506a.getString(R$string.backup_app_exclusive_one, 200) : this.f506a.getString(R$string.backup_app_exclusive_three, 2) : strM817e;
    }

    /* renamed from: d */
    public int m816d() {
        int iIntValue = 7;
        for (Map.Entry<Integer, Boolean> entry : this.f507b.entrySet()) {
            if (entry.getValue().booleanValue()) {
                iIntValue = entry.getKey().intValue();
            }
        }
        return iIntValue;
    }

    /* renamed from: e */
    public final String m817e(int i10) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Integer> entry : CloudBackupUtil.getGradeAllFrequency().entrySet()) {
            if (i10 == entry.getValue().intValue()) {
                arrayList.add(entry.getKey());
            }
        }
        Map<String, String> map = this.f510e;
        if (map == null || map.isEmpty() || arrayList.size() == 0) {
            return "";
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = this.f510e.get((String) it.next());
            if (!TextUtils.isEmpty(str) && !arrayList2.contains(str)) {
                arrayList2.add(str);
            }
        }
        int size = arrayList2.size();
        if (size == 0) {
            return "";
        }
        if (size > 1) {
            arrayList2.sort(new Comparator() { // from class: ae.j1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C0142k1.m814g((String) obj, (String) obj2);
                }
            });
        }
        String str2 = (String) arrayList2.get(0);
        return i10 == 1 ? this.f506a.getString(R$string.backup_app_exclusive_three, Integer.valueOf(Integer.parseInt(str2.split(" ")[0]))) : this.f506a.getString(R$string.frequency_summary, str2);
    }

    /* renamed from: f */
    public final String m818f(int i10) throws Resources.NotFoundException {
        String string;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Integer> entry : CloudBackupUtil.getGradeAllFrequency().entrySet()) {
            if (i10 == entry.getValue().intValue()) {
                arrayList.add(entry.getKey());
            }
        }
        Map<String, String> map = this.f509d;
        if (map == null || map.isEmpty() || arrayList.size() <= 0) {
            return "";
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = this.f509d.get((String) it.next());
            if (!TextUtils.isEmpty(str) && !arrayList2.contains(str)) {
                arrayList2.add(str);
            }
        }
        int size = arrayList2.size();
        if (size <= 0) {
            return "";
        }
        if (size <= 1) {
            string = (String) arrayList2.get(0);
        } else {
            string = this.f506a.getResources().getString(size >= 7 ? Constant.m16241a().get(8).intValue() : Constant.m16241a().get(Integer.valueOf(size)).intValue(), arrayList2.toArray(new Object[0]));
        }
        return !C13452e.m80781L().m80887a1() ? this.f506a.getString(R$string.frequency_summary, string) : string;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f508c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f508c.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        View viewInflate;
        c cVar;
        Integer num = this.f508c.get(i10);
        int iIntValue = num.intValue();
        if (view == null) {
            cVar = new c(null);
            viewInflate = View.inflate(this.f506a, R$layout.backup_frequency_item, null);
            cVar.f515a = (LinearLayout) C12809f.m76831d(viewInflate, R$id.ll_prefrence_view_switch);
            cVar.f516b = (TextView) C12809f.m76831d(viewInflate, R$id.frequency_title);
            cVar.f517c = (TextView) C12809f.m76831d(viewInflate, R$id.frequency_summary);
            cVar.f518d = (CheckBox) C12809f.m76831d(viewInflate, R$id.frequency_radio);
            cVar.f519e = (LinearLayout) C12809f.m76831d(viewInflate, R$id.list_view_buttom_line);
            viewInflate.setTag(cVar);
        } else {
            viewInflate = view;
            cVar = (c) view.getTag();
        }
        boolean zBooleanValue = false;
        if (i10 == this.f508c.size() - 1) {
            cVar.f519e.setVisibility(8);
        } else {
            cVar.f519e.setVisibility(0);
        }
        String strM818f = m818f(iIntValue);
        if (TextUtils.isEmpty(strM818f)) {
            cVar.f517c.setVisibility(8);
        } else {
            cVar.f517c.setText(strM818f);
            cVar.f517c.setVisibility(0);
        }
        String quantityString = this.f506a.getResources().getQuantityString(R$plurals.auto_backup_frequency, iIntValue, num);
        C11839m.m70688i("AutoBackupFrequencyDialog", "getView frequency :" + iIntValue);
        if (!C13452e.m80781L().m80791C0() || iIntValue == 7) {
            cVar.f515a.setFocusable(true);
            cVar.f515a.setClickable(true);
            cVar.f518d.setEnabled(true);
            cVar.f515a.setAlpha(1.0f);
            cVar.f518d.setOnClickListener(new a(iIntValue));
            cVar.f515a.setOnClickListener(new b(iIntValue));
        } else {
            cVar.f515a.setFocusable(false);
            cVar.f515a.setClickable(false);
            cVar.f518d.setEnabled(false);
            cVar.f518d.setButtonDrawable(R$drawable.backup_circle_enabled);
            cVar.f515a.setAlpha(0.4f);
            String strM815c = m815c(iIntValue);
            quantityString = iIntValue != 1 ? this.f506a.getResources().getQuantityString(R$plurals.auto_backup_frequency_new, iIntValue, num, strM815c) : this.f506a.getResources().getString(R$string.auto_backup_frequency_new_one, strM815c);
        }
        cVar.f516b.setText(quantityString);
        if (C13452e.m80781L().m80791C0()) {
            cVar.f517c.setVisibility(8);
        }
        if (this.f507b.get(num) == null) {
            this.f507b.put(num, Boolean.FALSE);
        } else {
            zBooleanValue = this.f507b.get(num).booleanValue();
        }
        cVar.f518d.setChecked(zBooleanValue);
        if (zBooleanValue) {
            cVar.f518d.setButtonDrawable(R$drawable.backup_circle_select);
        } else {
            cVar.f518d.setButtonDrawable(R$drawable.backup_circle_enabled);
        }
        return viewInflate;
    }

    /* renamed from: h */
    public void m819h(Map<String, String> map) {
        this.f510e = map;
    }

    /* renamed from: i */
    public void m820i(Map<String, String> map) {
        this.f509d = map;
    }

    /* renamed from: j */
    public void m821j(int i10) {
        this.f507b.put(Integer.valueOf(i10), Boolean.TRUE);
    }

    /* renamed from: ae.k1$c */
    public static class c {

        /* renamed from: a */
        public LinearLayout f515a;

        /* renamed from: b */
        public TextView f516b;

        /* renamed from: c */
        public TextView f517c;

        /* renamed from: d */
        public CheckBox f518d;

        /* renamed from: e */
        public LinearLayout f519e;

        public c() {
            this.f515a = null;
            this.f516b = null;
            this.f517c = null;
            this.f518d = null;
            this.f519e = null;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
