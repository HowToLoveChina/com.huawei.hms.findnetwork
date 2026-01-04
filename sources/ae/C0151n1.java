package ae;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.DisableSupportedRelativeLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.UnionSwitch;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.util.NotifyUtil;
import java.util.ArrayList;
import p015ak.C0209d;
import p514o9.C11829c;
import sk.C12806c;
import sk.C12809f;

/* renamed from: ae.n1 */
/* loaded from: classes3.dex */
public class C0151n1 extends BaseAdapter {

    /* renamed from: a */
    public LayoutInflater f542a;

    /* renamed from: b */
    public Context f543b;

    /* renamed from: c */
    public CompoundButton.OnCheckedChangeListener f544c;

    /* renamed from: d */
    public ArrayList<SyncConfigService> f545d = new ArrayList<>();

    /* renamed from: ae.n1$b */
    public static class b {

        /* renamed from: a */
        public DisableSupportedRelativeLayout f546a;

        /* renamed from: b */
        public ImageView f547b;

        /* renamed from: c */
        public TextView f548c;

        /* renamed from: d */
        public UnionSwitch f549d;

        /* renamed from: e */
        public int f550e;

        public b() {
        }

        /* renamed from: a */
        public void m843a(int i10) {
            this.f550e = i10;
        }
    }

    public C0151n1(Context context, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f542a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f543b = context;
        this.f544c = onCheckedChangeListener;
    }

    /* renamed from: a */
    public void m841a(SyncConfigService syncConfigService) {
        if (syncConfigService == null) {
            return;
        }
        this.f545d.add(syncConfigService);
    }

    /* renamed from: b */
    public void m842b() {
        this.f545d.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f545d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        if (i10 < 0 || i10 >= this.f545d.size()) {
            return null;
        }
        return this.f545d.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        View viewM76832e;
        b bVar;
        Drawable bitmapDrawable = null;
        byte b10 = 0;
        if (view == null) {
            bVar = new b();
            viewM76832e = C12809f.m76832e(this.f542a, R$layout.merge_alert_dialog_sync_config_item_layout);
            DisableSupportedRelativeLayout disableSupportedRelativeLayout = (DisableSupportedRelativeLayout) C12809f.m76831d(viewM76832e, R$id.rl_sync_config_item);
            ImageView imageView = (ImageView) C12809f.m76831d(viewM76832e, R$id.rl_sync_config_item_img);
            TextView textView = (TextView) C12809f.m76831d(viewM76832e, R$id.rl_sync_config_item_title);
            UnionSwitch unionSwitch = (UnionSwitch) C12809f.m76831d(viewM76832e, R$id.rl_sync_config_item_switch);
            bVar.f546a = disableSupportedRelativeLayout;
            bVar.f547b = imageView;
            bVar.f548c = textView;
            bVar.f549d = unionSwitch;
            viewM76832e.setTag(bVar);
            bVar.f546a.m17034b();
            viewM76832e.setEnabled(true);
            bVar.f549d.setOnCheckedChangeListener(this.f544c);
        } else {
            viewM76832e = view;
            bVar = (b) view.getTag();
        }
        bVar.m843a(i10);
        SyncConfigService syncConfigService = this.f545d.get(i10);
        bVar.f549d.setTag(syncConfigService.getId());
        if (NotifyUtil.HI_NOTE_SYNC_TYPE.equals(syncConfigService.getId()) && C0209d.m1293p1()) {
            bitmapDrawable = ResourcesCompat.getDrawable(this.f543b.getResources(), R$drawable.hinote_sync_icon, this.f543b.getTheme());
        } else {
            Bitmap bitmapM70501B = C11829c.m70501B(syncConfigService.getIconPath());
            if (bitmapM70501B != null) {
                bitmapDrawable = new BitmapDrawable((Resources) null, bitmapM70501B);
            }
        }
        if (bitmapDrawable != null) {
            bVar.f547b.setBackground(bitmapDrawable);
        }
        bVar.f548c.setText(syncConfigService.getTitleText());
        bVar.f549d.setChecked(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar.f546a);
        C12806c.m76817h(this.f543b, arrayList);
        return viewM76832e;
    }
}
