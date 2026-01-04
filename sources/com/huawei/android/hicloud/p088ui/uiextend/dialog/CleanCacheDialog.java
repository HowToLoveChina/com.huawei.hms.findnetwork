package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.huawei.android.p073ds.R$layout;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class CleanCacheDialog extends AlertDialogC13154a {
    Context mContext;

    public CleanCacheDialog(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private void initView() {
        setView(LayoutInflater.from(this.mContext).inflate(R$layout.clean_cache_dialog, (ViewGroup) null));
        setCancelable(false);
    }
}
