package p486n6;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.p069cg.activity.GalleryMainActivity;
import p031b7.C1120a;
import p514o9.C11829c;
import p676ud.AlertDialogC13154a;

/* renamed from: n6.n */
/* loaded from: classes2.dex */
public class AlertDialogC11649n extends AlertDialogC13154a {

    /* renamed from: b */
    public static final String f54047b = "n";

    /* renamed from: a */
    public GalleryMainActivity f54048a;

    /* renamed from: n6.n$b */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (AlertDialogC11649n.this.f54048a == null) {
                C1120a.m6676e(AlertDialogC11649n.f54047b, "galleryMainActivity is null");
                return;
            }
            if (-1 == i10) {
                AlertDialogC11649n.this.f54048a.m13559y3();
            } else {
                AlertDialogC11649n.this.f54048a.m13487F2();
            }
            AlertDialogC11649n.this.dismiss();
        }

        public /* synthetic */ b(AlertDialogC11649n alertDialogC11649n, a aVar) {
            this();
        }
    }

    /* renamed from: n6.n$c */
    public class c implements DialogInterface.OnCancelListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            AlertDialogC11649n.this.f54048a.m13487F2();
        }
    }

    public AlertDialogC11649n(Context context, GalleryMainActivity galleryMainActivity) throws IllegalAccessException, IllegalArgumentException {
        super(context);
        this.f54048a = galleryMainActivity;
        setOnCancelListener(new c());
        C11829c.m70594l1(context, this);
        setCanceledOnTouchOutside(false);
    }

    /* renamed from: c */
    public void m69574c(String str, String str2, String str3, String str4) {
        setTitle(str);
        setMessage(str2);
        b bVar = new b();
        setButton(-1, str3, bVar);
        setButton(-2, str4, bVar);
    }
}
