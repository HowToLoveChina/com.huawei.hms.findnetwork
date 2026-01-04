package com.huawei.android.hicloud.p088ui.common;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11842p;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class VerticalBtnAlertDialog extends AlertDialogC13154a {

    /* renamed from: a */
    public TextView f17858a;

    /* renamed from: b */
    public TextView f17859b;

    /* renamed from: c */
    public TextView f17860c;

    /* renamed from: d */
    public TextView f17861d;

    /* renamed from: e */
    public TextView f17862e;

    public VerticalBtnAlertDialog(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        View viewInflate = C0209d.m1195O(C0213f.m1377a()) >= 1.75f ? LayoutInflater.from(getContext()).inflate(R$layout.vertical_btn_dialog_font_scale, (ViewGroup) null) : LayoutInflater.from(getContext()).inflate(R$layout.vertical_btn_dialog, (ViewGroup) null);
        this.f17858a = (TextView) C12809f.m76831d(viewInflate, R$id.tv_title);
        this.f17859b = (TextView) C12809f.m76831d(viewInflate, R$id.tv_desc);
        C11842p.m70721D1(this.f17858a, 2.0f);
        this.f17860c = (TextView) C12809f.m76831d(viewInflate, R$id.btn_positive);
        this.f17861d = (TextView) C12809f.m76831d(viewInflate, R$id.btn_cancel);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.btn_neural);
        this.f17862e = textView;
        textView.setVisibility(8);
        this.f17861d.setVisibility(8);
        this.f17860c.setVisibility(8);
        setView(viewInflate);
        super.setCanceledOnTouchOutside(false);
    }

    /* renamed from: d */
    public final /* synthetic */ void m23923d(DialogInterface.OnClickListener onClickListener, View view) {
        dismiss();
        onClickListener.onClick(this, -2);
    }

    /* renamed from: e */
    public final /* synthetic */ void m23924e(DialogInterface.OnClickListener onClickListener, View view) {
        dismiss();
        onClickListener.onClick(this, -3);
    }

    /* renamed from: f */
    public final /* synthetic */ void m23925f(DialogInterface.OnClickListener onClickListener, View view) {
        dismiss();
        onClickListener.onClick(this, -1);
    }

    /* renamed from: g */
    public void m23926g(String str) {
        this.f17859b.setText(str);
    }

    /* renamed from: h */
    public void m23927h(int i10) {
        TextView textView = this.f17861d;
        if (textView == null) {
            return;
        }
        textView.setBackgroundResource(i10);
    }

    /* renamed from: i */
    public void m23928i(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
        TextView textView = this.f17861d;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
        this.f17861d.setVisibility(0);
        if (onClickListener == null) {
            return;
        }
        this.f17861d.setOnClickListener(new View.OnClickListener() { // from class: ud.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f59677a.m23923d(onClickListener, view);
            }
        });
    }

    @Override // android.app.Dialog
    public boolean isShowing() {
        return super.isShowing();
    }

    /* renamed from: j */
    public void m23929j(int i10) {
        TextView textView = this.f17861d;
        if (textView == null) {
            return;
        }
        textView.setTextColor(ContextCompat.getColorStateList(getContext(), i10));
    }

    /* renamed from: k */
    public void m23930k(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
        TextView textView = this.f17862e;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
        this.f17862e.setVisibility(0);
        if (onClickListener == null) {
            return;
        }
        this.f17862e.setOnClickListener(new View.OnClickListener() { // from class: ud.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f59681a.m23924e(onClickListener, view);
            }
        });
    }

    /* renamed from: l */
    public void m23931l(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
        TextView textView = this.f17860c;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
        this.f17860c.setVisibility(0);
        if (onClickListener == null) {
            return;
        }
        this.f17860c.setOnClickListener(new View.OnClickListener() { // from class: ud.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f59679a.m23925f(onClickListener, view);
            }
        });
    }

    /* renamed from: m */
    public void m23932m(String str) {
        this.f17858a.setText(str);
    }
}
