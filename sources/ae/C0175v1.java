package ae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.uiextend.OtherDetailItemLayout;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.fastengine.fastview.NavigationUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p015ak.C0209d;
import p514o9.C11839m;
import p703v8.C13380q;
import sk.C12809f;

/* renamed from: ae.v1 */
/* loaded from: classes3.dex */
public class C0175v1 extends BaseAdapter {

    /* renamed from: a */
    public View.OnClickListener f675a;

    /* renamed from: b */
    public LayoutInflater f676b;

    /* renamed from: c */
    public CopyOnWriteArrayList<C13380q> f677c = new CopyOnWriteArrayList<>();

    /* renamed from: ae.v1$a */
    public static class a {

        /* renamed from: a */
        public OtherDetailItemLayout f678a;

        /* renamed from: b */
        public int f679b;

        /* renamed from: b */
        public int m969b() {
            return this.f679b;
        }

        /* renamed from: c */
        public void m970c(int i10) {
            this.f679b = i10;
        }

        /* renamed from: d */
        public void m971d(OtherDetailItemLayout otherDetailItemLayout) {
            this.f678a = otherDetailItemLayout;
        }
    }

    public C0175v1(Context context, View.OnClickListener onClickListener) {
        this.f675a = onClickListener;
        this.f676b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    public void m965a(C13380q c13380q) {
        this.f677c.add(c13380q);
    }

    /* renamed from: b */
    public C13380q m966b(String str) {
        Iterator<C13380q> it = this.f677c.iterator();
        while (it.hasNext()) {
            C13380q next = it.next();
            if (str.equals(next.m80333d())) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: c */
    public void m967c(String str) {
        int size = this.f677c.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (str.equals(this.f677c.get(i10).m80333d())) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 < 0 || i10 >= size) {
            return;
        }
        this.f677c.remove(i10);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f677c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        if (i10 < 0 || i10 >= this.f677c.size()) {
            return null;
        }
        return this.f677c.get(i10);
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
            viewM76832e = C12809f.m76832e(this.f676b, R$layout.other_detail_list_item);
            aVar.m971d((OtherDetailItemLayout) C12809f.m76831d(viewM76832e, R$id.other_detail_list_items));
            viewM76832e.setTag(aVar);
        } else {
            viewM76832e = view;
            aVar = (a) view.getTag();
        }
        String strM80333d = this.f677c.get(i10).m80333d();
        boolean zM16117X = C2783d.m16117X(strM80333d);
        C11839m.m70686d("OtherDetailAdapter", "module name=" + strM80333d + ",isBaned=" + zM16117X);
        if (zM16117X) {
            aVar.f678a.disable();
            viewM76832e.setEnabled(false);
        } else {
            viewM76832e.setOnClickListener(this.f675a);
            aVar.f678a.enable();
            viewM76832e.setEnabled(true);
        }
        if ((!"calllog".equals(strM80333d) && !"record".equals(strM80333d) && !"phonemanager".equals(strM80333d) && !NavigationUtils.SMS_SCHEMA_PREF.equals(strM80333d)) || C0209d.m1166E1()) {
            aVar.f678a.setBackgroundResource(R$drawable.emui50_list_selector_card_down);
        }
        aVar.m970c(i10);
        aVar.f678a.setTitle(this.f677c.get(i10).m80337h());
        aVar.f678a.setImage(this.f677c.get(i10).m80331b());
        aVar.f678a.setSize(this.f677c.get(i10).m80335f());
        aVar.f678a.setTipsLayoutMaxWidth();
        aVar.f678a.setNoNumber();
        if (this.f677c.get(i10).m80342m()) {
            aVar.f678a.showLoading();
        } else {
            aVar.f678a.hideLoading();
        }
        if (i10 == getCount() - 1) {
            aVar.f678a.hideDivider();
        } else {
            aVar.f678a.showDivider();
        }
        return viewM76832e;
    }
}
