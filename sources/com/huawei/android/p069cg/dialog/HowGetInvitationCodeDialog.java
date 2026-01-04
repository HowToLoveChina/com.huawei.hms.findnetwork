package com.huawei.android.p069cg.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import p514o9.C11829c;
import p676ud.AlertDialogC13154a;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes2.dex */
public class HowGetInvitationCodeDialog extends AlertDialogC13154a implements View.OnClickListener {

    /* renamed from: a */
    public TextView f10953a;

    /* renamed from: b */
    public ImageView f10954b;

    public HowGetInvitationCodeDialog(Context context) throws IllegalAccessException, IllegalArgumentException {
        super(context);
        View viewInflate = getLayoutInflater().inflate(R$layout.view_get_invitation_code_dialog, (ViewGroup) null);
        setView(viewInflate);
        C11829c.m70594l1(context, this);
        setCanceledOnTouchOutside(false);
        TextView textView = (TextView) viewInflate.findViewById(R$id.return_button);
        this.f10953a = textView;
        textView.setOnClickListener(this);
        this.f10954b = (ImageView) C12809f.m76831d(viewInflate, R$id.image);
        if (C13843a.m83066R()) {
            this.f10954b.setImageDrawable(context.getDrawable(R$drawable.getcode_zh));
        } else {
            this.f10954b.setImageDrawable(context.getDrawable(R$drawable.getcode_uk));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.return_button) {
            dismiss();
        }
    }
}
