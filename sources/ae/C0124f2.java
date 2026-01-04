package ae;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.uiextend.StorageManagerItemLayout;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.notification.util.NotifyUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p015ak.C0209d;
import p514o9.C11839m;
import p703v8.C13380q;
import p709vj.C13452e;
import sk.C12809f;

/* renamed from: ae.f2 */
/* loaded from: classes3.dex */
public class C0124f2 extends BaseAdapter {

    /* renamed from: a */
    public LayoutInflater f455a;

    /* renamed from: c */
    public View.OnClickListener f457c;

    /* renamed from: d */
    public Context f458d;

    /* renamed from: e */
    public final boolean f459e;

    /* renamed from: b */
    public CopyOnWriteArrayList<C13380q> f456b = new CopyOnWriteArrayList<>();

    /* renamed from: f */
    public boolean f460f = C13452e.m80781L().m80819J0();

    /* renamed from: ae.f2$a */
    public static class a {

        /* renamed from: a */
        public StorageManagerItemLayout f461a;

        /* renamed from: b */
        public int f462b;

        /* renamed from: b */
        public int m805b() {
            return this.f462b;
        }

        /* renamed from: c */
        public void m806c(int i10) {
            this.f462b = i10;
        }

        /* renamed from: d */
        public void m807d(StorageManagerItemLayout storageManagerItemLayout) {
            this.f461a = storageManagerItemLayout;
        }
    }

    public C0124f2(Context context, View.OnClickListener onClickListener, boolean z10) {
        this.f457c = onClickListener;
        this.f458d = context;
        this.f455a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f459e = z10;
    }

    /* renamed from: a */
    public void m795a(C13380q c13380q) {
        if (c13380q == null) {
            C11839m.m70689w("StorageManageAdapter", "item is null, skip add");
            return;
        }
        if (TextUtils.isEmpty(c13380q.m80335f()) && this.f459e) {
            C11839m.m70689w("StorageManageAdapter", "addItem isNewMemberDataManagement is true");
            return;
        }
        String strM80333d = c13380q.m80333d();
        Iterator<C13380q> it = this.f456b.iterator();
        while (it.hasNext()) {
            C13380q next = it.next();
            if (next == null) {
                C11839m.m70688i("StorageManageAdapter", "storageItem is null, skip");
            } else if (TextUtils.equals(strM80333d, next.m80333d())) {
                C11839m.m70688i("StorageManageAdapter", strM80333d + " has already exsit, skip add");
                return;
            }
        }
        this.f456b.add(c13380q);
    }

    /* renamed from: b */
    public void m796b() {
        this.f456b.clear();
    }

    /* renamed from: c */
    public void m797c() {
        for (int i10 = 0; i10 < this.f456b.size(); i10++) {
            C13380q c13380q = this.f456b.get(i10);
            if (c13380q.m80339j()) {
                c13380q.m80326I(NotifyUtil.getStringFromDriveConfig(c13380q.m80334e()));
            }
        }
        notifyDataSetChanged();
    }

    /* renamed from: d */
    public C13380q m798d(String str) {
        Iterator<C13380q> it = this.f456b.iterator();
        while (it.hasNext()) {
            C13380q next = it.next();
            if (str.equals(next.m80333d())) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: e */
    public List<String> m799e() {
        ArrayList arrayList = new ArrayList();
        Iterator<C13380q> it = this.f456b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m80333d());
        }
        return arrayList;
    }

    /* renamed from: f */
    public long m800f() {
        Iterator<C13380q> it = this.f456b.iterator();
        long j10 = 0;
        while (it.hasNext()) {
            long jM80336g = it.next().m80336g();
            if (jM80336g > 0) {
                j10 += jM80336g;
            }
        }
        return j10;
    }

    /* renamed from: g */
    public void m801g(String str) {
        int size = this.f456b.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (str.equals(this.f456b.get(i10).m80333d())) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 < 0 || i10 >= size) {
            return;
        }
        this.f456b.remove(i10);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f456b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        if (i10 < 0 || i10 >= this.f456b.size()) {
            return null;
        }
        return this.f456b.get(i10);
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
            viewM76832e = C12809f.m76832e(this.f455a, R$layout.storage_manage_list_item);
            aVar.m807d((StorageManagerItemLayout) C12809f.m76831d(viewM76832e, R$id.storage_manage_list_items));
            viewM76832e.setTag(aVar);
        } else {
            viewM76832e = view;
            aVar = (a) view.getTag();
        }
        String strM80333d = this.f456b.get(i10).m80333d();
        aVar.m806c(i10);
        aVar.f461a.setTitle(this.f456b.get(i10).m80337h());
        aVar.f461a.setSize(this.f456b.get(i10).m80335f());
        aVar.f461a.showUnResolveView(this.f456b.get(i10).m80343n() && !this.f459e);
        aVar.f461a.setImage(this.f456b.get(i10).m80331b());
        aVar.f461a.setTipsLayoutMaxWidth();
        aVar.f461a.setNoNumber();
        if (this.f456b.get(i10).m80342m()) {
            aVar.f461a.showLoading();
        } else {
            aVar.f461a.hideLoading();
        }
        int dimensionPixelSize = this.f458d.getResources().getDimensionPixelSize(R$dimen.cs_4_dp);
        if ((!"wlan".equals(strM80333d) && !"gallery_sync".equals(strM80333d) && !"cloud_backup".equals(strM80333d)) || C0209d.m1166E1()) {
            aVar.f461a.setBackgroundResource(R$drawable.emui50_list_selector_card_down);
        }
        boolean zM16117X = C2783d.m16117X(strM80333d);
        C11839m.m70686d("StorageManageAdapter", "module name=" + strM80333d + ",isBaned=" + zM16117X);
        if (zM16117X) {
            aVar.f461a.disable();
            viewM76832e.setEnabled(false);
        } else {
            viewM76832e.setOnClickListener(this.f457c);
            aVar.f461a.enable();
            viewM76832e.setEnabled(true);
            if (this.f460f && C2783d.m16109T(strM80333d)) {
                viewM76832e.setEnabled(false);
                aVar.f461a.hideArrow();
            } else {
                viewM76832e.setEnabled(true);
                aVar.f461a.showArrow();
            }
        }
        if (i10 == 0) {
            aVar.f461a.showDivider();
            viewM76832e.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, 0);
        } else if (i10 == getCount() - 1) {
            aVar.f461a.hideDivider();
            viewM76832e.setPadding(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
        } else {
            aVar.f461a.showDivider();
            viewM76832e.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
        return viewM76832e;
    }

    /* renamed from: h */
    public void m802h(boolean z10) {
        this.f460f = z10;
    }

    /* renamed from: i */
    public void m803i() {
        for (int i10 = 0; i10 < this.f456b.size(); i10++) {
            C13380q c13380q = this.f456b.get(i10);
            if (c13380q.m80340k()) {
                c13380q.m80326I(NotifyUtil.getStringFromSyncConfig(c13380q.m80334e()));
            }
        }
        notifyDataSetChanged();
    }
}
