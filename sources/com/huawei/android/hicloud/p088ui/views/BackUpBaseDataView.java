package com.huawei.android.hicloud.p088ui.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.android.p073ds.R$styleable;
import com.huawei.hicloud.sync.R$dimen;
import p514o9.C11839m;
import p676ud.C13164k;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackUpBaseDataView extends RelativeLayout {

    /* renamed from: a */
    public Context f19315a;

    /* renamed from: b */
    public RelativeLayout f19316b;

    /* renamed from: c */
    public CheckBox f19317c;

    /* renamed from: d */
    public ImageView f19318d;

    /* renamed from: e */
    public ProgressBar f19319e;

    /* renamed from: f */
    public TextView f19320f;

    /* renamed from: g */
    public TextView f19321g;

    /* renamed from: h */
    public LinearLayout f19322h;

    /* renamed from: i */
    public TextView f19323i;

    /* renamed from: j */
    public RelativeLayout f19324j;

    /* renamed from: k */
    public CircleProgressView f19325k;

    /* renamed from: l */
    public CheckMarkView f19326l;

    /* renamed from: m */
    public View f19327m;

    /* renamed from: n */
    public Activity f19328n;

    public BackUpBaseDataView(Context context) {
        this(context, null, 0, 0);
    }

    /* renamed from: b */
    public final void m25646b(TypedArray typedArray) {
        if (typedArray != null) {
            this.f19317c.setVisibility(typedArray.getBoolean(R$styleable.backup_base_data_showCheckBox, false) ? 0 : 8);
            this.f19318d.setVisibility(typedArray.getBoolean(R$styleable.backup_base_data_showTips, false) ? 0 : 8);
            this.f19322h.setVisibility(typedArray.getBoolean(R$styleable.backup_base_data_showEneArrow, false) ? 0 : 8);
        }
    }

    /* renamed from: c */
    public final void m25647c(Context context) {
        this.f19327m = View.inflate(context, R$layout.backup_base_data, this);
        this.f19316b = (RelativeLayout) C12809f.m76831d(this, R$id.basic_data_main_layout);
        this.f19317c = (CheckBox) C12809f.m76831d(this, R$id.check_base_data);
        ImageView imageView = (ImageView) C12809f.m76831d(this, R$id.tips);
        this.f19318d = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: de.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                this.f45835a.m25648d(view);
            }
        });
        this.f19321g = (TextView) C12809f.m76831d(this, R$id.tv_base_data_desc);
        this.f19320f = (TextView) C12809f.m76831d(this, R$id.restore_item_incompatibility_text);
        this.f19322h = (LinearLayout) C12809f.m76831d(this, R$id.ll_end_arrow);
        this.f19323i = (TextView) C12809f.m76831d(this, R$id.tv_failed_number);
        this.f19324j = (RelativeLayout) C12809f.m76831d(this, R$id.rl_restore_success);
        this.f19325k = (CircleProgressView) C12809f.m76831d(this, R$id.bc_circle_progress_view);
        this.f19326l = (CheckMarkView) C12809f.m76831d(this, R$id.check_mark_view);
        this.f19319e = (ProgressBar) C12809f.m76831d(this, R$id.pgb_loading);
        this.f19323i.setMaxWidth(this.f19315a.getResources().getDisplayMetrics().widthPixels / 3);
        setClickable(false);
    }

    /* renamed from: d */
    public final /* synthetic */ void m25648d(View view) throws Resources.NotFoundException {
        C11839m.m70688i("BackUpBaseDataView", "tips is clicked");
        Activity activity = this.f19328n;
        if (activity != null) {
            new C13164k(activity, 0.66d).m79170u(this.f19318d, this.f19315a.getString(R$string.backup_base_data_tips), 0, this.f19315a.getResources().getDimensionPixelOffset(R$dimen.cloud_space_8_dp));
        }
    }

    public CheckBox getCheckBox() {
        return this.f19317c;
    }

    public View getContentView() {
        return this.f19327m;
    }

    public TextView getIncompatibilityText() {
        return this.f19320f;
    }

    public RelativeLayout getMainItemLayout() {
        return this.f19316b;
    }

    public ProgressBar getPgbLoading() {
        return this.f19319e;
    }

    public TextView getTvBaseDataDesc() {
        return this.f19321g;
    }

    public void setBindActivity(Activity activity) {
        this.f19328n = activity;
    }

    public BackUpBaseDataView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }

    public BackUpBaseDataView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public BackUpBaseDataView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f19315a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.backup_base_data);
        m25647c(context);
        m25646b(typedArrayObtainStyledAttributes);
    }
}
