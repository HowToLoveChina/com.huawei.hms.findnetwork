package com.huawei.android.p069cg.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import p514o9.C11829c;
import p676ud.AlertDialogC13154a;
import p684un.C13224c;
import sk.C12809f;

/* loaded from: classes2.dex */
public class ShareAlbumGuideDialog extends AlertDialogC13154a implements View.OnClickListener {
    public ShareAlbumGuideDialog(Context context) throws IllegalAccessException, IllegalArgumentException {
        super(context);
        View viewInflate = getLayoutInflater().inflate(R$layout.layout_share_album_guide, (ViewGroup) null);
        setView(viewInflate);
        m14393a(viewInflate);
        Window window = getWindow();
        if (window != null) {
            window.setFlags(1024, 1024);
        }
        setCanceledOnTouchOutside(false);
        C11829c.m70594l1(context, this);
    }

    /* renamed from: a */
    public final void m14393a(View view) {
        ((TextView) C12809f.m76831d(view, R$id.tv_got_it)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.tv_got_it) {
            C13224c.m79487f1().m79593q0("CLICK_CLOUD_PHOTOS_GUIDE_DIALOG_KNOWN");
            dismiss();
        }
    }

    public void showDialog() {
        show();
    }
}
