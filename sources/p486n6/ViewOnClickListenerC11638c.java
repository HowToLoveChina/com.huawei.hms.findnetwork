package p486n6;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import java.util.List;
import p471m6.C11418d;
import p514o9.C11829c;
import p676ud.AlertDialogC13154a;
import p834z6.C14143c;
import sk.C12809f;

/* renamed from: n6.c */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC11638c extends AlertDialogC13154a implements View.OnClickListener {

    /* renamed from: a */
    public Activity f53976a;

    /* renamed from: b */
    public View f53977b;

    /* renamed from: c */
    public RecyclerView f53978c;

    /* renamed from: d */
    public TextView f53979d;

    /* renamed from: e */
    public List<C11418d> f53980e;

    /* renamed from: f */
    public C14143c f53981f;

    /* renamed from: g */
    public int f53982g;

    /* renamed from: n6.c$a */
    public interface a {
        /* renamed from: N */
        void mo13734N(String str);
    }

    public ViewOnClickListenerC11638c(Activity activity, List<C11418d> list) throws IllegalAccessException, IllegalArgumentException {
        super(activity);
        this.f53982g = -1;
        this.f53976a = activity;
        this.f53980e = list;
        View viewInflate = LayoutInflater.from(activity).inflate(R$layout.album_baby_relation_select, (ViewGroup) null);
        this.f53977b = viewInflate;
        ((TextView) C12809f.m76831d(viewInflate, R$id.tv_cancel_select)).setOnClickListener(this);
        ((TextView) C12809f.m76831d(this.f53977b, R$id.tv_confirm_select)).setOnClickListener(this);
        this.f53978c = (RecyclerView) C12809f.m76831d(this.f53977b, R$id.rc_relation_list);
        this.f53979d = (TextView) C12809f.m76831d(this.f53977b, R$id.dialog_title);
        C14143c c14143c = new C14143c(activity, this);
        this.f53981f = c14143c;
        this.f53978c.setAdapter(c14143c);
        this.f53978c.setLayoutManager(new GridLayoutManager(activity, 4));
        this.f53981f.m84910D(list);
        initView();
        setView(this.f53977b);
        Window window = getWindow();
        if (window != null) {
            window.setFlags(1024, 1024);
        }
        setCanceledOnTouchOutside(false);
        C11829c.m70594l1(activity, this);
    }

    private void initView() {
        this.f53979d.setText(R$string.album_other_baby_relationship);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i10;
        int id2 = view.getId();
        if (id2 == R$id.rlay_relation_0) {
            int iIntValue = ((Integer) view.getTag()).intValue();
            this.f53982g = iIntValue;
            C14143c c14143c = this.f53981f;
            if (c14143c != null) {
                c14143c.m84911E(iIntValue);
                this.f53981f.m84910D(this.f53980e);
                return;
            }
            return;
        }
        if (id2 == R$id.tv_cancel_select) {
            dismiss();
            return;
        }
        if (id2 != R$id.tv_confirm_select || (i10 = this.f53982g) == -1) {
            return;
        }
        String strM68410a = this.f53980e.get(i10).m68410a();
        ComponentCallbacks2 componentCallbacks2 = this.f53976a;
        if (componentCallbacks2 instanceof a) {
            ((a) componentCallbacks2).mo13734N(strM68410a);
            dismiss();
        }
    }

    public final void setHeight() {
        Activity activity = this.f53976a;
        if (activity == null || activity.getResources() == null) {
            return;
        }
        Window window = getWindow();
        DisplayMetrics displayMetrics = this.f53976a.getResources().getDisplayMetrics();
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

    @Override // android.app.Dialog
    public void show() {
        setHeight();
        super.show();
    }
}
