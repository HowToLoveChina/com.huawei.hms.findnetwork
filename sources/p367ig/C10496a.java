package p367ig;

import android.app.Dialog;
import android.content.Context;
import java.util.HashMap;

/* renamed from: ig.a */
/* loaded from: classes4.dex */
public class C10496a {

    /* renamed from: a */
    public static HashMap<String, Dialog> f50662a = new HashMap<>();

    /* renamed from: a */
    public static void m64585a(Context context) {
        String string = context.toString();
        if (f50662a.containsKey(string)) {
            Dialog dialog = f50662a.get(string);
            f50662a.remove(string);
            if (dialog == null || dialog.getWindow() == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        }
    }
}
