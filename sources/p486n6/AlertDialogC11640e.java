package p486n6;

import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.activity.GalleryMainActivity;
import java.util.Locale;
import p015ak.C0209d;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p514o9.C11829c;
import p676ud.AlertDialogC13154a;

/* renamed from: n6.e */
/* loaded from: classes2.dex */
public class AlertDialogC11640e extends AlertDialogC13154a {

    /* renamed from: a */
    public GalleryMainActivity f53990a;

    /* renamed from: n6.e$b */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (AlertDialogC11640e.this.f53990a == null) {
                C1120a.m6676e("CloseAsyncSwitchDialog", "galleryMainActivity is null");
                return;
            }
            AlertDialogC11640e.this.f53990a.m13504N3(false);
            if (-2 == i10) {
                AlertDialogC11640e.this.f53990a.m13553s3();
            } else if (-1 == i10) {
                AlertDialogC11640e.this.f53990a.m13535f4();
            } else if (C1122c.m6807m1(C0213f.m1377a())) {
                AlertDialogC11640e.this.f53990a.m13558x3();
            } else {
                AlertDialogC11640e.this.f53990a.m13553s3();
            }
            AlertDialogC11640e.this.dismiss();
        }

        public /* synthetic */ b(AlertDialogC11640e alertDialogC11640e, a aVar) {
            this();
        }
    }

    /* renamed from: n6.e$c */
    public class c implements DialogInterface.OnCancelListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            AlertDialogC11640e.this.f53990a.m13504N3(false);
            AlertDialogC11640e.this.f53990a.m13558x3();
        }
    }

    public AlertDialogC11640e(Context context, GalleryMainActivity galleryMainActivity) throws IllegalAccessException, IllegalArgumentException {
        super(context);
        this.f53990a = galleryMainActivity;
        setView(C0209d.m1195O(context) >= 1.75f ? getLayoutInflater().inflate(R$layout.view_close_switch_dialog_font_scale, (ViewGroup) null) : getLayoutInflater().inflate(R$layout.view_close_switch_dialog, (ViewGroup) null));
        setTitle(this.f53990a.getResources().getString(R$string.gallery_shelve_close_switch));
        b bVar = new b();
        setButton(-1, context.getString(R$string.managing_cloud_storage_space).toUpperCase(Locale.ROOT), bVar);
        setButton(-2, context.getString(R$string.dialog_still_disable), bVar);
        setButton(-3, context.getString(R$string.gallery_shelve_cancel), bVar);
        setOnCancelListener(new c());
        C11829c.m70594l1(context, this);
        setCanceledOnTouchOutside(false);
    }

    public void showDialog() {
        show();
        if (C0209d.m1220W0()) {
            return;
        }
        getButton(-1).setTextColor(this.f53990a.getResources().getColor(R$color.hwbutton_selector_text_emphasize_emui));
        getButton(-1).setBackground(this.f53990a.getDrawable(R$drawable.hwbutton_emphasize_emui));
    }
}
