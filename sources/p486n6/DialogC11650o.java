package p486n6;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentCallbacks2;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$style;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p471m6.C11415a;
import p834z6.C14141a;
import sk.C12809f;

/* renamed from: n6.o */
/* loaded from: classes2.dex */
public class DialogC11650o extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    public Activity f54051a;

    /* renamed from: b */
    public View f54052b;

    /* renamed from: c */
    public RecyclerView f54053c;

    /* renamed from: d */
    public List<C11415a> f54054d;

    /* renamed from: n6.o$a */
    public interface a {
        /* renamed from: s0 */
        void mo13845s0();

        /* renamed from: w */
        void mo13850w(String str, int i10);
    }

    public DialogC11650o(Activity activity, String str, List<C11415a> list) {
        C11415a next;
        super(activity, R$style.NoTitleDialog);
        this.f54051a = activity;
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.width = -1;
                attributes.windowAnimations = R$style.BottomInAndOutStyle;
                attributes.gravity = 80;
                window.setAttributes(attributes);
            }
        }
        Iterator<C11415a> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                next = it.next();
                if (next.m68362a().getId().equals(str)) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        ArrayList arrayList = new ArrayList();
        if (next != null) {
            arrayList.add(next);
        }
        for (C11415a c11415a : list) {
            if (!c11415a.m68362a().getId().equals(str)) {
                arrayList.add(c11415a);
            }
        }
        this.f54054d = arrayList;
        View viewInflate = LayoutInflater.from(activity).inflate(R$layout.album_switch_dialog, (ViewGroup) null);
        this.f54052b = viewInflate;
        this.f54053c = (RecyclerView) C12809f.m76831d(viewInflate, R$id.rc_relation_list);
        ((RelativeLayout) C12809f.m76831d(this.f54052b, R$id.rl_close)).setOnClickListener(this);
        ((RelativeLayout) C12809f.m76831d(this.f54052b, R$id.rl_add)).setOnClickListener(this);
        C14141a c14141a = new C14141a(activity, this);
        this.f54053c.setAdapter(c14141a);
        this.f54053c.setLayoutManager(new LinearLayoutManager(activity));
        c14141a.m84905D(this.f54054d);
        c14141a.m5213j();
        setContentView(this.f54052b);
    }

    /* renamed from: a */
    public final void m69575a() {
        Activity activity = this.f54051a;
        if (activity == null || activity.getResources() == null) {
            return;
        }
        Window window = getWindow();
        DisplayMetrics displayMetrics = this.f54051a.getResources().getDisplayMetrics();
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.album_radio) {
            C11415a c11415a = this.f54054d.get(((Integer) view.getTag()).intValue());
            ComponentCallbacks2 componentCallbacks2 = this.f54051a;
            if (componentCallbacks2 instanceof a) {
                ((a) componentCallbacks2).mo13850w(c11415a.m68362a().getId(), c11415a.m68362a().getType().intValue());
            }
            dismiss();
            return;
        }
        if (id2 == R$id.rl_close) {
            dismiss();
        } else if (id2 == R$id.rl_add) {
            ComponentCallbacks2 componentCallbacks22 = this.f54051a;
            if (componentCallbacks22 instanceof a) {
                ((a) componentCallbacks22).mo13845s0();
            }
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        m69575a();
        super.show();
    }
}
