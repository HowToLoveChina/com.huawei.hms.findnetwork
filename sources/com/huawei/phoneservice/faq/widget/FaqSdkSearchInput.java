package com.huawei.phoneservice.faq.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.R$string;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import com.huawei.phoneservice.faq.base.util.FaqTahitiUtils;
import com.huawei.phoneservice.faq.base.util.FaqUiUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.faq.p174ui.FaqCategoryActivity;
import com.huawei.phoneservice.faq.p174ui.FaqSearchActivity;
import com.huawei.phoneservice.faq.p174ui.FaqSecondaryListActivity;
import com.huawei.phoneservice.faq.p174ui.FaqThirdListActivity;
import com.huawei.uikit.hwresources.C8732R;

/* loaded from: classes4.dex */
public class FaqSdkSearchInput extends LinearLayout implements View.OnClickListener, TextWatcher, View.OnFocusChangeListener, TextView.OnEditorActionListener {

    /* renamed from: a */
    public ImageView f39361a;

    /* renamed from: b */
    public EditText f39362b;

    /* renamed from: c */
    public ImageView f39363c;

    /* renamed from: d */
    public TextView f39364d;

    /* renamed from: e */
    public View f39365e;

    /* renamed from: f */
    public Context f39366f;

    /* renamed from: g */
    public InterfaceC8432c f39367g;

    /* renamed from: h */
    public InterfaceC8433d f39368h;

    /* renamed from: com.huawei.phoneservice.faq.widget.FaqSdkSearchInput$a */
    public class RunnableC8430a implements Runnable {
        public RunnableC8430a() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.widget.FaqSdkSearchInput$b */
    public class RunnableC8431b implements Runnable {
        public RunnableC8431b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FaqSdkSearchInput.this.f39362b.setText("");
            FaqSdkSearchInput.this.f39362b.clearFocus();
            FaqSdkSearchInput.this.f39364d.setVisibility(8);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.widget.FaqSdkSearchInput$c */
    public interface InterfaceC8432c {
        /* renamed from: A */
        void mo52070A(EditText editText);

        /* renamed from: a */
        void mo52075a(int i10);
    }

    /* renamed from: com.huawei.phoneservice.faq.widget.FaqSdkSearchInput$d */
    public interface InterfaceC8433d {
        /* renamed from: a */
        void mo52088a();

        /* renamed from: a */
        void mo52089a(String str);

        /* renamed from: b */
        void mo52090b();
    }

    public FaqSdkSearchInput(Context context) {
        super(context);
        m52481c(context);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        InterfaceC8432c interfaceC8432c = this.f39367g;
        if (interfaceC8432c != null) {
            interfaceC8432c.mo52070A(this.f39362b);
        }
    }

    /* renamed from: b */
    public final void m52480b() {
        Runnable runnableC8430a;
        this.f39368h.mo52089a(this.f39362b.getText().toString());
        Context context = this.f39366f;
        if ((context instanceof FaqCategoryActivity) || (context instanceof FaqSecondaryListActivity) || (context instanceof FaqThirdListActivity)) {
            runnableC8430a = new RunnableC8430a();
        } else {
            if (context instanceof FaqSearchActivity) {
                if (FaqStringUtil.isEmpty(this.f39362b.getText().toString())) {
                    this.f39362b.requestFocus();
                }
                EditText editText = this.f39362b;
                editText.setSelection(editText.getText().toString().length());
                return;
            }
            runnableC8430a = new RunnableC8431b();
        }
        postDelayed(runnableC8430a, 300L);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    /* renamed from: c */
    public final void m52481c(Context context) {
        EditText editText;
        Resources resources;
        int i10;
        this.f39366f = context;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.faq_sdk_search_input, this);
        this.f39365e = viewInflate;
        this.f39361a = (ImageView) viewInflate.findViewById(R$id.faq_sdk_iv_search);
        this.f39362b = (EditText) this.f39365e.findViewById(R$id.faq_sdk_sv_search_input);
        this.f39363c = (ImageView) this.f39365e.findViewById(R$id.faq_sdk_iv_search_del);
        TextView textView = (TextView) this.f39365e.findViewById(R$id.faq_sdk_search_cancel);
        this.f39364d = textView;
        FaqUiUtils.viewMapToButton(textView);
        if (context instanceof FaqCategoryActivity) {
            editText = this.f39362b;
            resources = getResources();
            i10 = R$string.faq_sdk_hint_search_main_key;
        } else {
            editText = this.f39362b;
            resources = getResources();
            i10 = R$string.faq_sdk_hint_search_key;
        }
        editText.setHint(resources.getString(i10));
        this.f39361a.setOnClickListener(this);
        this.f39363c.setOnClickListener(this);
        this.f39364d.setOnClickListener(this);
        this.f39362b.addTextChangedListener(this);
        this.f39362b.setOnFocusChangeListener(this);
        this.f39362b.setOnEditorActionListener(this);
    }

    public EditText getEditTextContent() {
        return this.f39362b;
    }

    public InterfaceC8432c getOnClick() {
        return this.f39367g;
    }

    public InterfaceC8433d getOnclick() {
        return this.f39368h;
    }

    public TextView getTextViewCancel() {
        return this.f39364d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (NoDoubleClickUtil.isDoubleClick(view)) {
            return;
        }
        if (view == this.f39361a) {
            m52480b();
            return;
        }
        if (view == this.f39363c) {
            this.f39362b.setText("");
            this.f39362b.requestFocus();
        } else if (view == this.f39364d) {
            Context context = this.f39366f;
            if (context instanceof FaqSearchActivity) {
                ((FaqSearchActivity) context).finish();
                return;
            }
            this.f39362b.setText("");
            this.f39362b.clearFocus();
            this.f39364d.setVisibility(8);
            this.f39368h.mo52090b();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        FaqTahitiUtils.setDefaultMargin((Activity) this.f39366f, new int[]{R$id.faq_search_input}, C8732R.dimen.emui_dimens_max_start);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 != 3) {
            return false;
        }
        m52480b();
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        InterfaceC8433d interfaceC8433d;
        if (view == this.f39362b && z10 && (interfaceC8433d = this.f39368h) != null) {
            interfaceC8433d.mo52088a();
            this.f39364d.setVisibility(0);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        InterfaceC8432c interfaceC8432c;
        if (this.f39362b.getText().toString().length() == 0) {
            this.f39361a.setEnabled(false);
            this.f39363c.setVisibility(8);
            this.f39364d.setVisibility(0);
            this.f39362b.setHint(getResources().getString(R$string.faq_sdk_hint_search_main_key));
            interfaceC8432c = this.f39367g;
            if (interfaceC8432c == null) {
                return;
            }
        } else if (this.f39362b.getText().toString().length() >= 2) {
            this.f39361a.setEnabled(true);
            this.f39363c.setVisibility(0);
            this.f39364d.setVisibility(0);
            interfaceC8432c = this.f39367g;
            if (interfaceC8432c == null) {
                return;
            }
        } else if (this.f39367g == null || this.f39362b.getText().toString() == null) {
            return;
        } else {
            interfaceC8432c = this.f39367g;
        }
        interfaceC8432c.mo52075a(this.f39362b.getText().toString().length());
    }

    public void setOnClick(InterfaceC8432c interfaceC8432c) {
        this.f39367g = interfaceC8432c;
    }

    public void setOnclick(InterfaceC8433d interfaceC8433d) {
        this.f39368h = interfaceC8433d;
    }

    public void setSearchInput(String str) {
        this.f39362b.setText(str);
        EditText editText = this.f39362b;
        editText.setSelection(editText.getText().length());
    }

    public FaqSdkSearchInput(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m52481c(context);
    }

    public FaqSdkSearchInput(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m52481c(context);
    }
}
