package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public class NoShareAlbumLayoutView extends LinearLayout implements View.OnClickListener {
    private static final String TAG = "NoShareAlbumLayout";
    private LinearLayout hasEnoughPicArea;
    private LinearLayout noShareAlbumArea;

    public NoShareAlbumLayoutView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.no_share_album_layout, (ViewGroup) null);
        addView(viewInflate);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76831d(viewInflate, R$id.no_share_album_area);
        this.noShareAlbumArea = linearLayout;
        linearLayout.setLayoutParams(layoutParams);
        this.hasEnoughPicArea = (LinearLayout) C12809f.m76831d(viewInflate, R$id.normal_album_has_enough_Container);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void refreshData() {
        C11839m.m70688i(TAG, "refreshData");
        LinearLayout linearLayout = this.noShareAlbumArea;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            LinearLayout linearLayout2 = this.hasEnoughPicArea;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
                this.hasEnoughPicArea.setOnClickListener(this);
            }
        }
    }

    public NoShareAlbumLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }
}
