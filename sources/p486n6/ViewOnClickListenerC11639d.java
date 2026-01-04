package p486n6;

import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* renamed from: n6.d */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC11639d extends AlertDialogC13154a implements View.OnClickListener {

    /* renamed from: a */
    public Context f53983a;

    /* renamed from: b */
    public View f53984b;

    /* renamed from: c */
    public RadioButton f53985c;

    /* renamed from: d */
    public RadioButton f53986d;

    /* renamed from: e */
    public RadioButton f53987e;

    /* renamed from: f */
    public b f53988f;

    /* renamed from: n6.d$a */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 != i10) {
                if (-2 == i10) {
                    ViewOnClickListenerC11639d.this.f53988f.mo13876h0();
                    return;
                }
                return;
            }
            if (ViewOnClickListenerC11639d.this.f53985c.isChecked()) {
                ViewOnClickListenerC11639d.this.f53988f.mo13869D(0);
            }
            if (ViewOnClickListenerC11639d.this.f53986d.isChecked()) {
                ViewOnClickListenerC11639d.this.f53988f.mo13869D(1);
            }
            if (ViewOnClickListenerC11639d.this.f53987e.isChecked()) {
                ViewOnClickListenerC11639d.this.f53988f.mo13869D(2);
            }
        }
    }

    /* renamed from: n6.d$b */
    public interface b {
        /* renamed from: D */
        void mo13869D(int i10);

        /* renamed from: h0 */
        void mo13876h0();
    }

    public ViewOnClickListenerC11639d(Context context, b bVar, int i10) {
        super(context);
        this.f53983a = context;
        this.f53988f = bVar;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.album_baby_sex_selection_dialog, (ViewGroup) null);
        this.f53984b = viewInflate;
        RadioButton radioButton = (RadioButton) C12809f.m76831d(viewInflate, R$id.baby_boy);
        this.f53985c = radioButton;
        radioButton.setOnClickListener(this);
        RadioButton radioButton2 = (RadioButton) C12809f.m76831d(this.f53984b, R$id.baby_girl);
        this.f53986d = radioButton2;
        radioButton2.setOnClickListener(this);
        RadioButton radioButton3 = (RadioButton) C12809f.m76831d(this.f53984b, R$id.baby_unknown);
        this.f53987e = radioButton3;
        radioButton3.setOnClickListener(this);
        setView(this.f53984b);
        initView();
        m69513e(0);
    }

    private void initView() {
        a aVar = new a();
        setButton(-1, this.f53983a.getString(R$string.conform), aVar);
        setButton(-2, this.f53983a.getString(R$string.cloudbackup_Cancel), aVar);
        setTitle(R$string.album_baby_gender);
    }

    private void setHeight() {
        Context context = this.f53983a;
        if (context == null || context.getResources() == null) {
            return;
        }
        Window window = getWindow();
        DisplayMetrics displayMetrics = this.f53983a.getResources().getDisplayMetrics();
        if (window == null || displayMetrics == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        int height = window.getDecorView().getHeight();
        int i10 = displayMetrics.heightPixels;
        if (height >= ((int) (i10 * 0.7d))) {
            attributes.height = (int) (i10 * 0.7d);
        } else {
            attributes.height = -2;
        }
        window.setAttributes(attributes);
    }

    /* renamed from: e */
    public final void m69513e(int i10) {
        if (i10 == 0) {
            this.f53985c.setChecked(true);
            this.f53986d.setChecked(false);
            this.f53987e.setChecked(false);
        } else if (i10 == 1) {
            this.f53985c.setChecked(false);
            this.f53986d.setChecked(true);
            this.f53987e.setChecked(false);
        } else if (i10 != 2) {
            this.f53985c.setChecked(false);
            this.f53986d.setChecked(false);
            this.f53987e.setChecked(false);
        } else {
            this.f53985c.setChecked(false);
            this.f53986d.setChecked(false);
            this.f53987e.setChecked(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.baby_boy) {
            this.f53985c.setChecked(true);
            this.f53986d.setChecked(false);
            this.f53987e.setChecked(false);
        } else if (id2 == R$id.baby_girl) {
            this.f53985c.setChecked(false);
            this.f53986d.setChecked(true);
            this.f53987e.setChecked(false);
        } else if (id2 == R$id.baby_unknown) {
            this.f53985c.setChecked(false);
            this.f53986d.setChecked(false);
            this.f53987e.setChecked(true);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        setHeight();
        super.show();
    }
}
