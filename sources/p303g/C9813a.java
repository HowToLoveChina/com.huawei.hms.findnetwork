package p303g;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$bool;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$styleable;

/* renamed from: g.a */
/* loaded from: classes.dex */
public class C9813a {

    /* renamed from: a */
    public Context f48235a;

    public C9813a(Context context) {
        this.f48235a = context;
    }

    /* renamed from: b */
    public static C9813a m60992b(Context context) {
        return new C9813a(context);
    }

    /* renamed from: a */
    public boolean m60993a() {
        return this.f48235a.getApplicationInfo().targetSdkVersion < 14;
    }

    /* renamed from: c */
    public int m60994c() {
        return this.f48235a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    /* renamed from: d */
    public int m60995d() {
        Configuration configuration = this.f48235a.getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        int i11 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i10 > 600) {
            return 5;
        }
        if (i10 > 960 && i11 > 720) {
            return 5;
        }
        if (i10 > 720 && i11 > 960) {
            return 5;
        }
        if (i10 >= 500) {
            return 4;
        }
        if (i10 > 640 && i11 > 480) {
            return 4;
        }
        if (i10 <= 480 || i11 <= 640) {
            return i10 >= 360 ? 3 : 2;
        }
        return 4;
    }

    /* renamed from: e */
    public int m60996e() {
        return this.f48235a.getResources().getDimensionPixelSize(R$dimen.abc_action_bar_stacked_tab_max_width);
    }

    /* renamed from: f */
    public int m60997f() {
        TypedArray typedArrayObtainStyledAttributes = this.f48235a.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0);
        Resources resources = this.f48235a.getResources();
        if (!m60998g()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R$dimen.abc_action_bar_stacked_max_height));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    /* renamed from: g */
    public boolean m60998g() {
        return this.f48235a.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs);
    }

    /* renamed from: h */
    public boolean m60999h() {
        return true;
    }
}
