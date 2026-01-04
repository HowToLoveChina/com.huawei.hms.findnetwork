package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.core.view.ActionProvider;
import p211d.C8968a;

/* loaded from: classes.dex */
public class ShareActionProvider extends ActionProvider {

    /* renamed from: d */
    public int f2145d;

    /* renamed from: e */
    public final MenuItemOnMenuItemClickListenerC0501a f2146e;

    /* renamed from: f */
    public final Context f2147f;

    /* renamed from: g */
    public String f2148g;

    /* renamed from: androidx.appcompat.widget.ShareActionProvider$a */
    public class MenuItemOnMenuItemClickListenerC0501a implements MenuItem.OnMenuItemClickListener {
        public MenuItemOnMenuItemClickListenerC0501a() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            ShareActionProvider shareActionProvider = ShareActionProvider.this;
            Intent intentM2898b = C0516b.m2896d(shareActionProvider.f2147f, shareActionProvider.f2148g).m2898b(menuItem.getItemId());
            if (intentM2898b == null) {
                return true;
            }
            String action = intentM2898b.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                ShareActionProvider.this.m2814l(intentM2898b);
            }
            ShareActionProvider.this.f2147f.startActivity(intentM2898b);
            return true;
        }
    }

    public ShareActionProvider(Context context) {
        super(context);
        this.f2145d = 4;
        this.f2146e = new MenuItemOnMenuItemClickListenerC0501a();
        this.f2148g = "share_history.xml";
        this.f2147f = context;
    }

    @Override // androidx.core.view.ActionProvider
    /* renamed from: a */
    public boolean mo2399a() {
        return true;
    }

    @Override // androidx.core.view.ActionProvider
    /* renamed from: c */
    public View mo2400c() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.f2147f);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(C0516b.m2896d(this.f2147f, this.f2148g));
        }
        TypedValue typedValue = new TypedValue();
        this.f2147f.getTheme().resolveAttribute(R$attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(C8968a.m56743b(this.f2147f, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R$string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R$string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    @Override // androidx.core.view.ActionProvider
    /* renamed from: f */
    public void mo2402f(SubMenu subMenu) {
        subMenu.clear();
        C0516b c0516bM2896d = C0516b.m2896d(this.f2147f, this.f2148g);
        PackageManager packageManager = this.f2147f.getPackageManager();
        int iM2901f = c0516bM2896d.m2901f();
        int iMin = Math.min(iM2901f, this.f2145d);
        for (int i10 = 0; i10 < iMin; i10++) {
            ResolveInfo resolveInfoM2900e = c0516bM2896d.m2900e(i10);
            subMenu.add(0, i10, i10, resolveInfoM2900e.loadLabel(packageManager)).setIcon(resolveInfoM2900e.loadIcon(packageManager)).setOnMenuItemClickListener(this.f2146e);
        }
        if (iMin < iM2901f) {
            SubMenu subMenuAddSubMenu = subMenu.addSubMenu(0, iMin, iMin, this.f2147f.getString(R$string.abc_activity_chooser_view_see_all));
            for (int i11 = 0; i11 < iM2901f; i11++) {
                ResolveInfo resolveInfoM2900e2 = c0516bM2896d.m2900e(i11);
                subMenuAddSubMenu.add(0, i11, i11, resolveInfoM2900e2.loadLabel(packageManager)).setIcon(resolveInfoM2900e2.loadIcon(packageManager)).setOnMenuItemClickListener(this.f2146e);
            }
        }
    }

    /* renamed from: l */
    public void m2814l(Intent intent) {
        intent.addFlags(134742016);
    }
}
