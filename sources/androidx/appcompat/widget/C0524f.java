package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;
import androidx.appcompat.widget.C0548w;
import p211d.C8968a;
import p723w.C13503b;

/* renamed from: androidx.appcompat.widget.f */
/* loaded from: classes.dex */
public final class C0524f {

    /* renamed from: b */
    public static final PorterDuff.Mode f2321b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c */
    public static C0524f f2322c;

    /* renamed from: a */
    public C0548w f2323a;

    /* renamed from: androidx.appcompat.widget.f$a */
    public class a implements C0548w.c {

        /* renamed from: a */
        public final int[] f2324a = {R$drawable.abc_textfield_search_default_mtrl_alpha, R$drawable.abc_textfield_default_mtrl_alpha, R$drawable.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b */
        public final int[] f2325b = {R$drawable.abc_ic_commit_search_api_mtrl_alpha, R$drawable.abc_seekbar_tick_mark_material, R$drawable.abc_ic_menu_share_mtrl_alpha, R$drawable.abc_ic_menu_copy_mtrl_am_alpha, R$drawable.abc_ic_menu_cut_mtrl_alpha, R$drawable.abc_ic_menu_selectall_mtrl_alpha, R$drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c */
        public final int[] f2326c = {R$drawable.abc_textfield_activated_mtrl_alpha, R$drawable.abc_textfield_search_activated_mtrl_alpha, R$drawable.abc_cab_background_top_mtrl_alpha, R$drawable.abc_text_cursor_material, R$drawable.abc_text_select_handle_left_mtrl, R$drawable.abc_text_select_handle_middle_mtrl, R$drawable.abc_text_select_handle_right_mtrl};

        /* renamed from: d */
        public final int[] f2327d = {R$drawable.abc_popup_background_mtrl_mult, R$drawable.abc_cab_background_internal_bg, R$drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e */
        public final int[] f2328e = {R$drawable.abc_tab_indicator_material, R$drawable.abc_textfield_search_material};

        /* renamed from: f */
        public final int[] f2329f = {R$drawable.abc_btn_check_material, R$drawable.abc_btn_radio_material, R$drawable.abc_btn_check_material_anim, R$drawable.abc_btn_radio_material_anim};

        /* JADX WARN: Removed duplicated region for block: B:52:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0066 A[RETURN] */
        @Override // androidx.appcompat.widget.C0548w.c
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean mo2976a(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.C0524f.m2967a()
                int[] r1 = r6.f2324a
                boolean r1 = r6.m2981f(r1, r8)
                r2 = 1
                r3 = 0
                r4 = -1
                if (r1 == 0) goto L14
                int r6 = androidx.appcompat.R$attr.colorControlNormal
            L11:
                r1 = r2
            L12:
                r8 = r4
                goto L49
            L14:
                int[] r1 = r6.f2326c
                boolean r1 = r6.m2981f(r1, r8)
                if (r1 == 0) goto L1f
                int r6 = androidx.appcompat.R$attr.colorControlActivated
                goto L11
            L1f:
                int[] r1 = r6.f2327d
                boolean r6 = r6.m2981f(r1, r8)
                r1 = 16842801(0x1010031, float:2.3693695E-38)
                if (r6 == 0) goto L2e
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            L2c:
                r6 = r1
                goto L11
            L2e:
                int r6 = androidx.appcompat.R$drawable.abc_list_divider_mtrl_alpha
                if (r8 != r6) goto L41
                r6 = 1109603123(0x42233333, float:40.8)
                int r6 = java.lang.Math.round(r6)
                r8 = 16842800(0x1010030, float:2.3693693E-38)
                r1 = r2
                r5 = r8
                r8 = r6
                r6 = r5
                goto L49
            L41:
                int r6 = androidx.appcompat.R$drawable.abc_dialog_material_background
                if (r8 != r6) goto L46
                goto L2c
            L46:
                r6 = r3
                r1 = r6
                goto L12
            L49:
                if (r1 == 0) goto L66
                boolean r1 = androidx.appcompat.widget.C0544s.m3140a(r9)
                if (r1 == 0) goto L55
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L55:
                int r6 = androidx.appcompat.widget.C0515a0.m2892c(r7, r6)
                android.graphics.PorterDuffColorFilter r6 = androidx.appcompat.widget.C0524f.m2969e(r6, r0)
                r9.setColorFilter(r6)
                if (r8 == r4) goto L65
                r9.setAlpha(r8)
            L65:
                return r2
            L66:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0524f.a.mo2976a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // androidx.appcompat.widget.C0548w.c
        /* renamed from: b */
        public PorterDuff.Mode mo2977b(int i10) {
            if (i10 == R$drawable.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.C0548w.c
        /* renamed from: c */
        public Drawable mo2978c(C0548w c0548w, Context context, int i10) {
            if (i10 == R$drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{c0548w.m3166i(context, R$drawable.abc_cab_background_internal_bg), c0548w.m3166i(context, R$drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (i10 == R$drawable.abc_ratingbar_material) {
                return m2987l(c0548w, context, R$dimen.abc_star_big);
            }
            if (i10 == R$drawable.abc_ratingbar_indicator_material) {
                return m2987l(c0548w, context, R$dimen.abc_star_medium);
            }
            if (i10 == R$drawable.abc_ratingbar_small_material) {
                return m2987l(c0548w, context, R$dimen.abc_star_small);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.C0548w.c
        /* renamed from: d */
        public ColorStateList mo2979d(Context context, int i10) {
            if (i10 == R$drawable.abc_edit_text_material) {
                return C8968a.m56742a(context, R$color.abc_tint_edittext);
            }
            if (i10 == R$drawable.abc_switch_track_mtrl_alpha) {
                return C8968a.m56742a(context, R$color.abc_tint_switch_track);
            }
            if (i10 == R$drawable.abc_switch_thumb_material) {
                return m2986k(context);
            }
            if (i10 == R$drawable.abc_btn_default_mtrl_shape) {
                return m2985j(context);
            }
            if (i10 == R$drawable.abc_btn_borderless_material) {
                return m2982g(context);
            }
            if (i10 == R$drawable.abc_btn_colored_material) {
                return m2984i(context);
            }
            if (i10 == R$drawable.abc_spinner_mtrl_am_alpha || i10 == R$drawable.abc_spinner_textfield_background_material) {
                return C8968a.m56742a(context, R$color.abc_tint_spinner);
            }
            if (m2981f(this.f2325b, i10)) {
                return C0515a0.m2894e(context, R$attr.colorControlNormal);
            }
            if (m2981f(this.f2328e, i10)) {
                return C8968a.m56742a(context, R$color.abc_tint_default);
            }
            if (m2981f(this.f2329f, i10)) {
                return C8968a.m56742a(context, R$color.abc_tint_btn_checkable);
            }
            if (i10 == R$drawable.abc_seekbar_thumb_material) {
                return C8968a.m56742a(context, R$color.abc_tint_seek_thumb);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.C0548w.c
        /* renamed from: e */
        public boolean mo2980e(Context context, int i10, Drawable drawable) {
            if (i10 == R$drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.background);
                int i11 = R$attr.colorControlNormal;
                m2988m(drawableFindDrawableByLayerId, C0515a0.m2892c(context, i11), C0524f.f2321b);
                m2988m(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), C0515a0.m2892c(context, i11), C0524f.f2321b);
                m2988m(layerDrawable.findDrawableByLayerId(R.id.progress), C0515a0.m2892c(context, R$attr.colorControlActivated), C0524f.f2321b);
                return true;
            }
            if (i10 != R$drawable.abc_ratingbar_material && i10 != R$drawable.abc_ratingbar_indicator_material && i10 != R$drawable.abc_ratingbar_small_material) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m2988m(layerDrawable2.findDrawableByLayerId(R.id.background), C0515a0.m2891b(context, R$attr.colorControlNormal), C0524f.f2321b);
            Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress);
            int i12 = R$attr.colorControlActivated;
            m2988m(drawableFindDrawableByLayerId2, C0515a0.m2892c(context, i12), C0524f.f2321b);
            m2988m(layerDrawable2.findDrawableByLayerId(R.id.progress), C0515a0.m2892c(context, i12), C0524f.f2321b);
            return true;
        }

        /* renamed from: f */
        public final boolean m2981f(int[] iArr, int i10) {
            for (int i11 : iArr) {
                if (i11 == i10) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: g */
        public final ColorStateList m2982g(Context context) {
            return m2983h(context, 0);
        }

        /* renamed from: h */
        public final ColorStateList m2983h(Context context, int i10) {
            int iM2892c = C0515a0.m2892c(context, R$attr.colorControlHighlight);
            return new ColorStateList(new int[][]{C0515a0.f2260b, C0515a0.f2263e, C0515a0.f2261c, C0515a0.f2267i}, new int[]{C0515a0.m2891b(context, R$attr.colorButtonNormal), C13503b.m81222f(iM2892c, i10), C13503b.m81222f(iM2892c, i10), i10});
        }

        /* renamed from: i */
        public final ColorStateList m2984i(Context context) {
            return m2983h(context, C0515a0.m2892c(context, R$attr.colorAccent));
        }

        /* renamed from: j */
        public final ColorStateList m2985j(Context context) {
            return m2983h(context, C0515a0.m2892c(context, R$attr.colorButtonNormal));
        }

        /* renamed from: k */
        public final ColorStateList m2986k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i10 = R$attr.colorSwitchThumbNormal;
            ColorStateList colorStateListM2894e = C0515a0.m2894e(context, i10);
            if (colorStateListM2894e == null || !colorStateListM2894e.isStateful()) {
                iArr[0] = C0515a0.f2260b;
                iArr2[0] = C0515a0.m2891b(context, i10);
                iArr[1] = C0515a0.f2264f;
                iArr2[1] = C0515a0.m2892c(context, R$attr.colorControlActivated);
                iArr[2] = C0515a0.f2267i;
                iArr2[2] = C0515a0.m2892c(context, i10);
            } else {
                int[] iArr3 = C0515a0.f2260b;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListM2894e.getColorForState(iArr3, 0);
                iArr[1] = C0515a0.f2264f;
                iArr2[1] = C0515a0.m2892c(context, R$attr.colorControlActivated);
                iArr[2] = C0515a0.f2267i;
                iArr2[2] = colorStateListM2894e.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        /* renamed from: l */
        public final LayerDrawable m2987l(C0548w c0548w, Context context, int i10) throws Resources.NotFoundException {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i10);
            Drawable drawableM3166i = c0548w.m3166i(context, R$drawable.abc_star_black_48dp);
            Drawable drawableM3166i2 = c0548w.m3166i(context, R$drawable.abc_star_half_black_48dp);
            if ((drawableM3166i instanceof BitmapDrawable) && drawableM3166i.getIntrinsicWidth() == dimensionPixelSize && drawableM3166i.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableM3166i;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableM3166i.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableM3166i.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableM3166i2 instanceof BitmapDrawable) && drawableM3166i2.getIntrinsicWidth() == dimensionPixelSize && drawableM3166i2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableM3166i2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableM3166i2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableM3166i2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.secondaryProgress);
            layerDrawable.setId(2, R.id.progress);
            return layerDrawable;
        }

        /* renamed from: m */
        public final void m2988m(Drawable drawable, int i10, PorterDuff.Mode mode) {
            if (C0544s.m3140a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = C0524f.f2321b;
            }
            drawable.setColorFilter(C0524f.m2969e(i10, mode));
        }
    }

    /* renamed from: b */
    public static synchronized C0524f m2968b() {
        try {
            if (f2322c == null) {
                m2970h();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f2322c;
    }

    /* renamed from: e */
    public static synchronized PorterDuffColorFilter m2969e(int i10, PorterDuff.Mode mode) {
        return C0548w.m3157k(i10, mode);
    }

    /* renamed from: h */
    public static synchronized void m2970h() {
        if (f2322c == null) {
            C0524f c0524f = new C0524f();
            f2322c = c0524f;
            c0524f.f2323a = C0548w.m3156g();
            f2322c.f2323a.m3174t(new a());
        }
    }

    /* renamed from: i */
    public static void m2971i(Drawable drawable, C0519c0 c0519c0, int[] iArr) {
        C0548w.m3160v(drawable, c0519c0, iArr);
    }

    /* renamed from: c */
    public synchronized Drawable m2972c(Context context, int i10) {
        return this.f2323a.m3166i(context, i10);
    }

    /* renamed from: d */
    public synchronized Drawable m2973d(Context context, int i10, boolean z10) {
        return this.f2323a.m3167j(context, i10, z10);
    }

    /* renamed from: f */
    public synchronized ColorStateList m2974f(Context context, int i10) {
        return this.f2323a.m3168l(context, i10);
    }

    /* renamed from: g */
    public synchronized void m2975g(Context context) {
        this.f2323a.m3172r(context);
    }
}
