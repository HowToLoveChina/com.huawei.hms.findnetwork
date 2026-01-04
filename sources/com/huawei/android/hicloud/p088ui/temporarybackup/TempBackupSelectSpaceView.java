package com.huawei.android.hicloud.p088ui.temporarybackup;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.android.p073ds.R$styleable;
import com.huawei.hicloud.sync.R$dimen;
import p514o9.C11829c;
import p514o9.C11839m;
import p618rm.C12600v1;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class TempBackupSelectSpaceView extends RelativeLayout {

    /* renamed from: a */
    public final Context f18429a;

    /* renamed from: b */
    public TextView f18430b;

    /* renamed from: c */
    public TextView f18431c;

    /* renamed from: d */
    public ImageView f18432d;

    /* renamed from: e */
    public PopupWindow f18433e;

    /* renamed from: f */
    public EnumC4011b f18434f;

    /* renamed from: g */
    public StateChangeListener f18435g;

    /* renamed from: h */
    public RadioButton f18436h;

    /* renamed from: i */
    public RadioButton f18437i;

    /* renamed from: j */
    public boolean f18438j;

    /* renamed from: k */
    public long f18439k;

    /* renamed from: l */
    public RelativeLayout f18440l;

    public interface StateChangeListener {
        /* renamed from: a */
        void mo24614a(EnumC4011b enumC4011b);
    }

    /* renamed from: com.huawei.android.hicloud.ui.temporarybackup.TempBackupSelectSpaceView$a */
    public static /* synthetic */ class C4010a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f18441a;

        static {
            int[] iArr = new int[EnumC4011b.values().length];
            f18441a = iArr;
            try {
                iArr[EnumC4011b.SPACE_TYPE_USER_SPACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18441a[EnumC4011b.SPACE_TYPE_EXTRAS_SPACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.temporarybackup.TempBackupSelectSpaceView$b */
    public enum EnumC4011b {
        SPACE_TYPE_EXTRAS_SPACE(0),
        SPACE_TYPE_USER_SPACE(1);


        /* renamed from: a */
        public final int f18445a;

        EnumC4011b(int i10) {
            this.f18445a = i10;
        }

        /* renamed from: b */
        public static EnumC4011b m24615b(int i10) {
            return i10 != 0 ? i10 != 1 ? SPACE_TYPE_USER_SPACE : SPACE_TYPE_USER_SPACE : SPACE_TYPE_EXTRAS_SPACE;
        }

        /* renamed from: e */
        public int m24616e() {
            return this.f18445a;
        }
    }

    public TempBackupSelectSpaceView(Context context) {
        this(context, null);
    }

    private PopupWindow getPopupWindowView() {
        View viewInflate = LayoutInflater.from(this.f18429a).inflate(R$layout.temp_backup_select_space_popup_window, (ViewGroup) null);
        View viewM76831d = C12809f.m76831d(viewInflate, R$id.user_space_item);
        View viewM76831d2 = C12809f.m76831d(viewInflate, R$id.extras_space_item);
        int i10 = R$id.tv_title;
        TextView textView = (TextView) C12809f.m76831d(viewM76831d, i10);
        int i11 = R$id.tv_desc;
        TextView textView2 = (TextView) C12809f.m76831d(viewM76831d, i11);
        textView.setText(this.f18429a.getString(R$string.temp_backup_save_to_user_space));
        textView2.setText(C4012a.m24662s("temp_backup_save_to_user_space_desc", this.f18429a.getString(R$string.temp_backup_save_to_user_space_desc), new Object[0]));
        int i12 = R$id.radio_button;
        RadioButton radioButton = (RadioButton) C12809f.m76831d(viewM76831d, i12);
        this.f18437i = radioButton;
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: zd.l2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f63425a.m24605j(compoundButton, z10);
            }
        });
        viewM76831d.setOnClickListener(new View.OnClickListener() { // from class: zd.m2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f63430a.m24606k(view);
            }
        });
        TextView textView3 = (TextView) C12809f.m76831d(viewM76831d2, i10);
        TextView textView4 = (TextView) C12809f.m76831d(viewM76831d2, i11);
        textView3.setText(this.f18429a.getString(R$string.temp_backup_save_to_extras_space));
        int i13 = C12600v1.f57994d;
        int i14 = C12600v1.f57996f;
        int i15 = i13 + i14;
        textView4.setText(i14 > 0 ? this.f18429a.getResources().getQuantityString(R$plurals.save_to_extra_space_desc, i15, Integer.valueOf(i15)) : this.f18429a.getResources().getQuantityString(R$plurals.temp_backup_save_to_extras_space_desc, i15, Integer.valueOf(i15)));
        RadioButton radioButton2 = (RadioButton) C12809f.m76831d(viewM76831d2, i12);
        this.f18436h = radioButton2;
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: zd.n2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f63436a.m24607l(compoundButton, z10);
            }
        });
        viewM76831d2.setOnClickListener(new View.OnClickListener() { // from class: zd.o2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f63445a.m24608m(view);
            }
        });
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: zd.p2
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                this.f63453a.m24609n();
            }
        });
        m24603h();
        return popupWindow;
    }

    /* renamed from: g */
    public void m24602g() {
        PopupWindow popupWindow = this.f18433e;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public EnumC4011b getType() {
        return this.f18434f;
    }

    /* renamed from: h */
    public final void m24603h() {
        int i10 = C4010a.f18441a[this.f18434f.ordinal()];
        if (i10 == 1) {
            this.f18430b.setText(this.f18429a.getString(R$string.temp_backup_save_to_user_space));
            this.f18431c.setText(C4012a.m24662s("temp_backup_save_to_user_space_desc", this.f18429a.getString(R$string.temp_backup_save_to_user_space_desc), new Object[0]));
            RadioButton radioButton = this.f18437i;
            if (radioButton != null) {
                radioButton.setChecked(true);
                this.f18436h.setChecked(false);
                return;
            }
            return;
        }
        if (i10 != 2) {
            return;
        }
        this.f18430b.setText(this.f18429a.getString(R$string.temp_backup_save_to_extras_space));
        int i11 = C12600v1.f57994d;
        int i12 = C12600v1.f57996f;
        int i13 = i11 + i12;
        this.f18431c.setText(i12 > 0 ? this.f18429a.getResources().getQuantityString(R$plurals.save_to_extra_space_desc, i13, Integer.valueOf(i13)) : this.f18429a.getResources().getQuantityString(R$plurals.temp_backup_save_to_extras_space_desc, i13, Integer.valueOf(i13)));
        RadioButton radioButton2 = this.f18437i;
        if (radioButton2 != null) {
            radioButton2.setChecked(false);
            this.f18436h.setChecked(true);
        }
    }

    /* renamed from: i */
    public final void m24604i() {
        View viewInflate = View.inflate(getContext(), R$layout.temp_backup_select_space_view, this);
        this.f18430b = (TextView) C12809f.m76831d(viewInflate, R$id.tv_title);
        this.f18431c = (TextView) C12809f.m76831d(viewInflate, R$id.tv_desc);
        this.f18432d = (ImageView) C12809f.m76831d(viewInflate, R$id.img_select);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(viewInflate, R$id.temp_vip_save_other_space_layout);
        this.f18440l = relativeLayout;
        relativeLayout.setEnabled(this.f18438j);
        this.f18440l.setOnClickListener(new View.OnClickListener() { // from class: zd.q2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f63456a.m24610o(view);
            }
        });
    }

    /* renamed from: j */
    public final /* synthetic */ void m24605j(CompoundButton compoundButton, boolean z10) {
        if (z10) {
            m24611p(EnumC4011b.SPACE_TYPE_USER_SPACE);
        }
    }

    /* renamed from: k */
    public final /* synthetic */ void m24606k(View view) {
        m24611p(EnumC4011b.SPACE_TYPE_USER_SPACE);
        C4012a.m24631O("event_id_select_space_dialog", "select user space", this.f18429a.getClass().getSimpleName());
    }

    /* renamed from: l */
    public final /* synthetic */ void m24607l(CompoundButton compoundButton, boolean z10) {
        if (z10) {
            m24611p(EnumC4011b.SPACE_TYPE_EXTRAS_SPACE);
        }
    }

    /* renamed from: m */
    public final /* synthetic */ void m24608m(View view) {
        m24611p(EnumC4011b.SPACE_TYPE_EXTRAS_SPACE);
        C4012a.m24631O("event_id_select_space_dialog", "select extras space", this.f18429a.getClass().getSimpleName());
    }

    /* renamed from: n */
    public final /* synthetic */ void m24609n() {
        this.f18439k = System.currentTimeMillis();
    }

    /* renamed from: o */
    public final /* synthetic */ void m24610o(View view) {
        if (System.currentTimeMillis() - this.f18439k > 100) {
            m24613r();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        PopupWindow popupWindow = this.f18433e;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.f18433e.dismiss();
        m24613r();
    }

    /* renamed from: p */
    public void m24611p(EnumC4011b enumC4011b) {
        if (C13452e.m80781L().m80907e1()) {
            setVisibility(0);
            this.f18434f = enumC4011b;
        } else {
            setVisibility(8);
            this.f18434f = EnumC4011b.SPACE_TYPE_EXTRAS_SPACE;
        }
        C12600v1.m76047c().m76055j(this.f18434f);
        m24603h();
        StateChangeListener stateChangeListener = this.f18435g;
        if (stateChangeListener != null) {
            stateChangeListener.mo24614a(this.f18434f);
        }
        m24602g();
    }

    /* renamed from: q */
    public final void m24612q() {
        if (this.f18433e.isShowing()) {
            C11839m.m70689w("TempBackupSelectSpaceVi", "popup window is showing");
            return;
        }
        this.f18433e.setWidth((int) (C11829c.m70549V(this.f18429a) * 0.87d));
        this.f18433e.showAsDropDown(this.f18432d, 0, -this.f18429a.getResources().getDimensionPixelOffset(R$dimen.cloud_space_12_dp));
    }

    /* renamed from: r */
    public final void m24613r() {
        if (this.f18433e == null) {
            this.f18433e = getPopupWindowView();
        }
        m24612q();
    }

    @Override // android.view.View
    public void setClickable(boolean z10) {
        super.setClickable(z10);
        this.f18438j = z10;
        this.f18440l.setEnabled(z10);
        if (z10) {
            this.f18430b.setAlpha(1.0f);
            this.f18431c.setAlpha(1.0f);
            this.f18432d.setAlpha(1.0f);
        } else {
            this.f18430b.setAlpha(0.4f);
            this.f18431c.setAlpha(0.24f);
            this.f18432d.setAlpha(0.4f);
        }
    }

    public void setStateChangeListener(StateChangeListener stateChangeListener) {
        this.f18435g = stateChangeListener;
    }

    public TempBackupSelectSpaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TempBackupSelectSpaceView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public TempBackupSelectSpaceView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f18438j = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.backup_temp_select_space);
        try {
            this.f18438j = typedArrayObtainStyledAttributes.getBoolean(R$styleable.backup_temp_select_space_needClick, true);
            typedArrayObtainStyledAttributes.recycle();
            if (C13452e.m80781L().m80907e1()) {
                setVisibility(0);
            } else {
                setVisibility(8);
            }
            this.f18429a = context;
            this.f18434f = C12600v1.m76047c().m76053d();
            m24604i();
            m24603h();
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
