package p676ud;

import android.app.AlertDialog;
import android.content.Context;
import p015ak.C0219i;
import p514o9.C11829c;
import p514o9.C11840n;

/* renamed from: ud.a */
/* loaded from: classes3.dex */
public class AlertDialogC13154a extends AlertDialog {
    public AlertDialogC13154a(Context context) throws IllegalAccessException, IllegalArgumentException {
        super(context);
        C11829c.m70594l1(context, this);
    }

    public void setDialogNoNavBeforeHarmony31() {
        if (C0219i.m1465c()) {
            return;
        }
        C11829c.m70585i1(getWindow());
        C11829c.m70572e0(this);
        C11840n.m70694e(this);
    }
}
