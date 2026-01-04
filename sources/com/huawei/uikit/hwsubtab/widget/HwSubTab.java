package com.huawei.uikit.hwsubtab.widget;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ImageSpan;
import android.text.style.TypefaceSpan;
import com.huawei.uikit.hwsubtab.C8735R;

/* loaded from: classes5.dex */
public class HwSubTab {
    public static final int INVALID_POSITION = -1;

    /* renamed from: g */
    private static final String f44220g = "";

    /* renamed from: a */
    private HwSubTabWidget f44221a;

    /* renamed from: b */
    private HwSubTabListener f44222b;

    /* renamed from: c */
    private int f44223c;

    /* renamed from: d */
    private CharSequence f44224d;

    /* renamed from: e */
    private Object f44225e;

    /* renamed from: f */
    private int f44226f;

    public HwSubTab(HwSubTabWidget hwSubTabWidget) {
        this(hwSubTabWidget, "");
    }

    /* renamed from: a */
    private SpannableString m55546a(CharSequence charSequence, CharSequence charSequence2) {
        SpannableString spannableString = new SpannableString(((Object) charSequence) + " " + ((Object) charSequence2));
        spannableString.setSpan(new ImageSpan(this.f44221a.getContext(), C8735R.drawable.hwsubtab_imagespan), charSequence.length(), charSequence.length() + 1, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(this.f44221a.getSubTitleTextSize()), charSequence.length(), spannableString.length(), 33);
        spannableString.setSpan(new TypefaceSpan(this.f44221a.getContext().getString(C8735R.string.emui_text_font_family_regular)), charSequence.length(), spannableString.length(), 33);
        return spannableString;
    }

    public HwSubTabListener getCallback() {
        return this.f44222b;
    }

    public int getPosition() {
        return this.f44223c;
    }

    public int getSubTabId() {
        return this.f44226f;
    }

    public Object getTag() {
        return this.f44225e;
    }

    public CharSequence getText() {
        return this.f44224d;
    }

    public void select() {
        this.f44221a.selectSubTab(this);
        this.f44221a.selectSubTabEx(this);
    }

    public void setPosition(int i10) {
        this.f44223c = i10;
    }

    public void setSubTabId(int i10) {
        this.f44226f = i10;
    }

    public HwSubTab setSubTabListener(HwSubTabListener hwSubTabListener) {
        this.f44222b = hwSubTabListener;
        return this;
    }

    public HwSubTab setTag(Object obj) {
        this.f44225e = obj;
        return this;
    }

    public HwSubTab setText(int i10) {
        return setText(this.f44221a.getContext().getResources().getText(i10));
    }

    public HwSubTab(HwSubTabWidget hwSubTabWidget, CharSequence charSequence) {
        this(hwSubTabWidget, charSequence, (HwSubTabListener) null);
    }

    public HwSubTab setText(int i10, int i11) {
        return setText(this.f44221a.getContext().getResources().getText(i10), this.f44221a.getContext().getResources().getText(i11));
    }

    public HwSubTab(HwSubTabWidget hwSubTabWidget, CharSequence charSequence, HwSubTabListener hwSubTabListener) {
        this(hwSubTabWidget, charSequence, hwSubTabListener, null);
    }

    public HwSubTab(HwSubTabWidget hwSubTabWidget, CharSequence charSequence, Object obj) {
        this(hwSubTabWidget, charSequence, null, obj);
    }

    public HwSubTab(HwSubTabWidget hwSubTabWidget, CharSequence charSequence, HwSubTabListener hwSubTabListener, Object obj) {
        this(hwSubTabWidget, charSequence, "", hwSubTabListener, obj);
    }

    public HwSubTab setText(CharSequence charSequence) {
        this.f44224d = charSequence;
        int i10 = this.f44223c;
        if (i10 >= 0) {
            this.f44221a.updateSubTab(i10);
        }
        return this;
    }

    public HwSubTab(HwSubTabWidget hwSubTabWidget, CharSequence charSequence, CharSequence charSequence2, HwSubTabListener hwSubTabListener, Object obj) {
        this.f44223c = -1;
        this.f44226f = -1;
        this.f44221a = hwSubTabWidget;
        this.f44222b = hwSubTabListener;
        this.f44225e = obj;
        if (charSequence2 != null && !charSequence2.equals("")) {
            this.f44224d = m55546a(charSequence, charSequence2);
        } else {
            this.f44224d = charSequence;
        }
    }

    public HwSubTab setText(CharSequence charSequence, CharSequence charSequence2) {
        this.f44224d = m55546a(charSequence, charSequence2);
        int i10 = this.f44223c;
        if (i10 >= 0) {
            this.f44221a.updateSubTab(i10);
        }
        return this;
    }
}
