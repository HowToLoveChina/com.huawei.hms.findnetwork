package com.huawei.android.hicloud.p088ui.uiextend;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.uilistener.LogoutItemCheckedChangeListener;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.android.p073ds.R$styleable;
import gp.C10028c;
import p015ak.C0209d;
import p336he.C10155f;
import p514o9.C11829c;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class AccountLogoutItemView extends LinearLayout implements CompoundButton.OnCheckedChangeListener {
    private static final double FONT_SCALE = 1.45d;
    protected Context mCurrentContext;
    protected String mDisableModuleName;
    protected boolean mDividerShow;
    protected View mDividerView;
    protected ImageView mIconView;
    protected Drawable mImg;
    private LogoutItemCheckedChangeListener mItemCheckedChangeListener;
    private int mPosition;
    protected CheckBox mSwitch;
    protected boolean mSwitchSelect;
    protected String mTitle;
    protected TextView mTitleView;

    public AccountLogoutItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (context == null) {
            return;
        }
        this.mCurrentContext = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.account_logout_item_attr);
        initView(context);
        initAttribute(typedArrayObtainStyledAttributes);
    }

    private void initAttribute(TypedArray typedArray) {
        if (typedArray != null) {
            this.mImg = typedArray.getDrawable(R$styleable.account_logout_item_attr_account_logout_item_img);
            this.mTitle = typedArray.getString(R$styleable.account_logout_item_attr_account_logout_item_title);
            this.mSwitchSelect = typedArray.getBoolean(R$styleable.account_logout_item_attr_account_logout_switch_checked, false);
            this.mDividerShow = typedArray.getBoolean(R$styleable.account_logout_item_attr_account_logout_item_divider, false);
            this.mDisableModuleName = typedArray.getString(R$styleable.account_logout_item_attr_account_logout_module_disable);
            this.mIconView.setImageDrawable(this.mImg);
            this.mTitleView.setText(this.mTitle);
            setChecked(this.mSwitchSelect);
            setDividerViewType(this.mDividerShow);
            this.mSwitch.setOnCheckedChangeListener(this);
            initDisabledModule();
            typedArray.recycle();
        }
    }

    private boolean isFontScaleSetUpMax() {
        return ((double) this.mCurrentContext.getResources().getConfiguration().fontScale) >= FONT_SCALE;
    }

    private void setWlanTitle() {
        Context context = this.mCurrentContext;
        if (context != null) {
            String string = context.getString(R$string.wifi_sync);
            if (C0209d.m1262h2()) {
                string = this.mCurrentContext.getString(R$string.wlan_sync);
            }
            this.mTitleView.setText(string);
        }
    }

    public void initDisabledModule() {
        if (TextUtils.isEmpty(this.mDisableModuleName)) {
            return;
        }
        String str = this.mDisableModuleName;
        str.hashCode();
        switch (str) {
            case "funcfg_wlan":
                setWlanTitle();
                if (!C10028c.m62183d0(this.mCurrentContext).m62395t1("funcfg_wlan")) {
                    setVisibility(8);
                    break;
                }
                break;
            case "funcfg_notes":
                if (!C10155f.m63252E()) {
                    setVisibility(8);
                    break;
                }
                break;
            case "funcfg_contacts":
                if (!C10155f.m63302z()) {
                    setVisibility(8);
                    break;
                }
                break;
            case "funcfg_calendar":
                if (!C10155f.m63297u()) {
                    setVisibility(8);
                    break;
                }
                break;
            case "funcfg_browser":
                if (!C10155f.m63296t(this.mCurrentContext)) {
                    setVisibility(8);
                    break;
                }
                break;
        }
    }

    public void initOnClickListener() {
        setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.AccountLogoutItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AccountLogoutItemView.this.setChecked(!r0.isChecked());
            }
        });
    }

    public void initView(Context context) {
        View.inflate(context, R$layout.account_logout_item_view, this);
        this.mIconView = (ImageView) C12809f.m76831d(this, R$id.account_logout_item_icon);
        this.mTitleView = (TextView) C12809f.m76831d(this, R$id.account_logout_item_title);
        boolean z10 = context instanceof Activity;
        if (z10 && C11842p.m70771U0() && C11842p.m70774V0((Activity) context)) {
            this.mTitleView.setMaxWidth(C11842p.m70770U(context));
        } else if (z10 && C11842p.m70771U0() && isFontScaleSetUpMax()) {
            this.mTitleView.setMaxWidth(C11842p.m70734I(context));
        } else {
            this.mTitleView.setMaxWidth(C11842p.m70713B(context));
        }
        this.mDividerView = C12809f.m76831d(this, R$id.account_logout_item_divider);
        this.mSwitch = (CheckBox) C12809f.m76831d(this, R$id.account_logout_item_switch);
    }

    public boolean isChecked() {
        return this.mSwitch.isChecked();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        LogoutItemCheckedChangeListener logoutItemCheckedChangeListener = this.mItemCheckedChangeListener;
        if (logoutItemCheckedChangeListener != null) {
            logoutItemCheckedChangeListener.mo25261a(this, this.mPosition, z10);
        }
    }

    public void setChecked(boolean z10) {
        this.mSwitch.setChecked(z10);
    }

    public void setDividerViewType(boolean z10) {
        if (z10) {
            this.mDividerView.setVisibility(0);
        } else {
            this.mDividerView.setVisibility(8);
        }
    }

    public void setIconView(String str) {
        Bitmap bitmapM70501B = C11829c.m70501B(str);
        BitmapDrawable bitmapDrawable = bitmapM70501B != null ? new BitmapDrawable((Resources) null, bitmapM70501B) : null;
        if (bitmapDrawable != null) {
            this.mIconView.setImageDrawable(bitmapDrawable);
        }
    }

    public void setItemOnCheckedChangeListener(int i10, LogoutItemCheckedChangeListener logoutItemCheckedChangeListener) {
        this.mPosition = i10;
        this.mItemCheckedChangeListener = logoutItemCheckedChangeListener;
    }

    public void setTitleText(String str) {
        this.mTitleView.setText(str);
    }

    public void setIconView(Drawable drawable) {
        if (drawable != null) {
            this.mIconView.setImageDrawable(drawable);
        }
    }
}
