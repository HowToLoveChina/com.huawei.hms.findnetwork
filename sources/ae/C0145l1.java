package ae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.p106db.bean.MainMenuItem;
import java.util.ArrayList;
import java.util.Iterator;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11842p;
import sk.C12809f;

/* renamed from: ae.l1 */
/* loaded from: classes3.dex */
public class C0145l1 extends BaseAdapter {

    /* renamed from: a */
    public ArrayList<MainMenuItem> f523a;

    /* renamed from: b */
    public Context f524b;

    /* renamed from: c */
    public boolean f525c;

    /* renamed from: ae.l1$a */
    public static class a {

        /* renamed from: a */
        public TextView f526a;

        /* renamed from: b */
        public ImageView f527b;

        /* renamed from: c */
        public View f528c;

        /* renamed from: d */
        public LinearLayout f529d;

        public a(View view) {
            this.f526a = (TextView) C12809f.m76831d(view, R$id.main_menu_item_name);
            this.f528c = C12809f.m76831d(view, R$id.menu_item_divider);
            this.f527b = (ImageView) C12809f.m76831d(view, R$id.main_menu_red_dot);
            this.f529d = (LinearLayout) C12809f.m76831d(view, R$id.menu_item_layout);
        }
    }

    public C0145l1(Context context, ArrayList<MainMenuItem> arrayList) {
        new ArrayList();
        this.f523a = arrayList;
        this.f524b = context;
        this.f525c = C0209d.m1269j1();
    }

    /* renamed from: a */
    public ArrayList<MainMenuItem> m824a() {
        return this.f523a;
    }

    /* renamed from: b */
    public final View m825b(View view, int i10, ViewGroup viewGroup) {
        MainMenuItem mainMenuItem = (MainMenuItem) getItem(i10);
        if (this.f524b == null) {
            this.f524b = C0213f.m1377a();
        }
        if (view == null) {
            view = LayoutInflater.from(this.f524b).inflate(R$layout.main_menu_item, viewGroup, false);
        }
        if (mainMenuItem != null) {
            m826c(view, mainMenuItem, i10);
        }
        return view;
    }

    /* renamed from: c */
    public final void m826c(View view, MainMenuItem mainMenuItem, int i10) {
        a aVar;
        if (view.getTag() == null) {
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f526a.setText(mainMenuItem.getItemName());
        if (mainMenuItem.isEnabled()) {
            aVar.f526a.setTextColor(this.f524b.getColor(R$color.main_menu_item_text_color));
        } else {
            aVar.f526a.setTextColor(this.f524b.getColor(R$color.main_menu_item_disenable));
        }
        if (mainMenuItem.isShowRedDot()) {
            aVar.f527b.setVisibility(0);
        } else {
            aVar.f527b.setVisibility(8);
        }
        if (i10 == this.f523a.size() - 1) {
            aVar.f528c.setVisibility(4);
        } else {
            aVar.f528c.setVisibility(0);
        }
        if (this.f525c) {
            aVar.f529d.setMinimumWidth((int) C11842p.m70844o(this.f524b, RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE));
        }
    }

    /* renamed from: d */
    public void m827d(int i10) {
        ArrayList<MainMenuItem> arrayList = this.f523a;
        if (arrayList == null) {
            return;
        }
        Iterator<MainMenuItem> it = arrayList.iterator();
        while (it.hasNext()) {
            if (i10 == it.next().getMenuType()) {
                it.remove();
            }
        }
        notifyDataSetChanged();
    }

    /* renamed from: e */
    public void m828e(ArrayList<MainMenuItem> arrayList) {
        this.f523a = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MainMenuItem> arrayList = this.f523a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        if (i10 < this.f523a.size()) {
            return this.f523a.get(i10);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        return m825b(view, i10, viewGroup);
    }
}
