package p737wd;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.widget.Button;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.hicloud.sync.R$color;
import com.huawei.hicloud.sync.R$drawable;
import java.lang.reflect.InvocationTargetException;
import p676ud.AlertDialogC13154a;
import tj.C13019a;

/* renamed from: wd.d */
/* loaded from: classes3.dex */
public class AlertDialogC13591d extends AlertDialogC13154a {

    /* renamed from: a */
    public Context f61153a;

    /* renamed from: wd.d$b */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: wd.d$b$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                if (AlertDialogC13591d.this.f61153a == null) {
                    return;
                }
                if (AlertDialogC13591d.this.f61153a instanceof Activity) {
                    ((Activity) AlertDialogC13591d.this.f61153a).finish();
                }
                if (AlertDialogC13591d.this.f61153a != null) {
                    new HwAnimationReflection(AlertDialogC13591d.this.f61153a).m15927c(2);
                }
            }
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            new Handler().postDelayed(new a(), 200L);
            C13019a.m78347n().m78355r();
        }
    }

    public AlertDialogC13591d(Context context, String str, String str2) {
        super(context);
        this.f61153a = context;
        setMessage(str);
        setButton(-2, str2, new b());
        setCancelable(false);
        show();
        Button button = getButton(-2);
        if (button != null) {
            button.setBackground(this.f61153a.getDrawable(R$drawable.hwbutton_emphasize_emui));
            button.setTextColor(context.getColor(R$color.hwbutton_selector_text_emphasize_emui));
        }
    }
}
