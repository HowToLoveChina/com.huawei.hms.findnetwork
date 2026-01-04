package cc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.huawei.android.hicloud.oobe.R$color;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.DisableSupportedRelativeLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.UnionSwitch;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import java.util.ArrayList;
import java.util.Iterator;
import p015ak.C0209d;
import p015ak.C0219i;
import p514o9.C11839m;
import sk.C12806c;
import sk.C12809f;

/* renamed from: cc.a */
/* loaded from: classes3.dex */
public class C1417a extends BaseAdapter {

    /* renamed from: a */
    public LayoutInflater f6050a;

    /* renamed from: b */
    public ArrayList<Object> f6051b = new ArrayList<>();

    /* renamed from: c */
    public boolean f6052c = false;

    /* renamed from: d */
    public CompoundButton.OnCheckedChangeListener f6053d;

    /* renamed from: e */
    public Context f6054e;

    /* renamed from: cc.a$a */
    public static class a {

        /* renamed from: a */
        public DisableSupportedRelativeLayout f6055a;

        /* renamed from: b */
        public TextView f6056b;

        /* renamed from: c */
        public UnionSwitch f6057c;

        /* renamed from: d */
        public View f6058d;

        /* renamed from: e */
        public int f6059e;

        /* renamed from: a */
        public void m8156a(int i10) {
            this.f6059e = i10;
        }
    }

    public C1417a(Context context, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f6053d = onCheckedChangeListener;
        this.f6050a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f6054e = context;
    }

    /* renamed from: a */
    public void m8151a(ArrayList<SyncConfigService> arrayList, ArrayList<DriveConfigService> arrayList2) {
        this.f6051b.addAll(arrayList);
        this.f6051b.addAll(arrayList2);
    }

    /* renamed from: b */
    public void m8152b() {
        this.f6051b.clear();
    }

    /* renamed from: c */
    public Object m8153c(String str) {
        Iterator<Object> it = this.f6051b.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof SyncConfigService) {
                SyncConfigService syncConfigService = (SyncConfigService) next;
                if (syncConfigService.getId().equals(str)) {
                    return syncConfigService;
                }
            } else if (next instanceof DriveConfigService) {
                DriveConfigService driveConfigService = (DriveConfigService) next;
                if (driveConfigService.getId().equals(str)) {
                    return driveConfigService;
                }
            } else {
                continue;
            }
        }
        C11839m.m70687e("SyncItemsAdapter", "no module, moduleName = " + str);
        return null;
    }

    /* renamed from: d */
    public ArrayList<Object> m8154d() {
        return this.f6051b;
    }

    /* renamed from: e */
    public void m8155e(boolean z10) {
        this.f6052c = z10;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f6051b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        if (i10 < 0 || i10 >= this.f6051b.size()) {
            return null;
        }
        return this.f6051b.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i10) {
        return (!(this.f6051b.get(i10) instanceof SyncConfigService) && (this.f6051b.get(i10) instanceof DriveConfigService)) ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewM76832e;
        a aVar;
        int itemViewType = getItemViewType(i10);
        if (view == null) {
            aVar = new a();
            viewM76832e = C12809f.m76832e(this.f6050a, R$layout.uniform_guide_sync_func_list_item_layout);
            if (C0219i.m1463a() >= 27) {
                viewM76832e = C12809f.m76832e(this.f6050a, R$layout.uniform_guide_sync_func_list_item_layout_emui111);
            }
            if (this.f6052c) {
                viewM76832e = C12809f.m76832e(this.f6050a, R$layout.uniform_guide_sync_func_list_item_layout_honor);
            }
            DisableSupportedRelativeLayout disableSupportedRelativeLayout = (DisableSupportedRelativeLayout) C12809f.m76831d(viewM76832e, R$id.sync_func_list_item);
            TextView textView = (TextView) C12809f.m76831d(viewM76832e, R$id.open_sync_item_title);
            if (C0219i.m1463a() >= 27) {
                textView.setTextColor(this.f6054e.getColor(R$color.oobe_text_color_primary));
            }
            UnionSwitch unionSwitch = (UnionSwitch) C12809f.m76831d(viewM76832e, R$id.open_sync_item_switch);
            aVar.f6058d = C12809f.m76831d(viewM76832e, R$id.open_sync_item_divider);
            aVar.f6055a = disableSupportedRelativeLayout;
            aVar.f6056b = textView;
            aVar.f6057c = unionSwitch;
            viewM76832e.setTag(aVar);
            aVar.f6055a.m17034b();
            aVar.f6057c.setVisibility(0);
            viewM76832e.setEnabled(true);
            aVar.f6057c.setOnCheckedChangeListener(this.f6053d);
        } else {
            viewM76832e = view;
            aVar = (a) view.getTag();
        }
        if (getCount() <= 1 || i10 >= getCount() - 1) {
            aVar.f6058d.setVisibility(8);
        } else {
            aVar.f6058d.setVisibility(0);
        }
        aVar.m8156a(i10);
        Object obj = this.f6051b.get(i10);
        if (itemViewType != 0) {
            if (itemViewType == 1 && (obj instanceof DriveConfigService)) {
                DriveConfigService driveConfigService = (DriveConfigService) obj;
                if (!C0209d.m1166E1() && !driveConfigService.isSubUser()) {
                    aVar.f6055a.m17033a();
                }
                aVar.f6057c.setTag(driveConfigService.getId());
                aVar.f6056b.setText(driveConfigService.getTitleText());
                aVar.f6057c.setChecked(driveConfigService.isSwitchStatus());
            }
        } else if (obj instanceof SyncConfigService) {
            SyncConfigService syncConfigService = (SyncConfigService) obj;
            if (!C0209d.m1166E1() && !syncConfigService.isSubUser()) {
                aVar.f6055a.m17033a();
            }
            aVar.f6057c.setTag(syncConfigService.getId());
            aVar.f6056b.setText(syncConfigService.getTitleText());
            aVar.f6057c.setChecked(syncConfigService.getSwitchStatus());
            aVar.f6057c.setEnabled(syncConfigService.isSwitchEnable());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar.f6055a);
        C12806c.m76817h(this.f6054e, arrayList);
        return viewM76832e;
    }
}
