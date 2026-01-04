package p486n6;

import android.content.DialogInterface;
import android.content.res.Resources;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$plurals;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.activity.GalleryMainActivity;
import p676ud.AlertDialogC13154a;

/* renamed from: n6.f */
/* loaded from: classes2.dex */
public class AlertDialogC11641f extends AlertDialogC13154a {

    /* renamed from: a */
    public GalleryMainActivity f53993a;

    /* renamed from: b */
    public int f53994b;

    /* renamed from: c */
    public boolean f53995c;

    /* renamed from: n6.f$a */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                AlertDialogC11641f.this.f53993a.m13552r3();
            } else {
                AlertDialogC11641f.this.f53993a.m13551q3();
            }
            AlertDialogC11641f.this.f53995c = true;
            AlertDialogC11641f.this.dismiss();
        }
    }

    /* renamed from: n6.f$b */
    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (AlertDialogC11641f.this.f53995c) {
                return;
            }
            AlertDialogC11641f.this.f53993a.m13551q3();
        }
    }

    public AlertDialogC11641f(GalleryMainActivity galleryMainActivity, int i10) {
        super(galleryMainActivity);
        this.f53994b = i10;
        this.f53993a = galleryMainActivity;
        a aVar = new a();
        setButton(-1, galleryMainActivity.getString(R$string.gallery_main_cg_dialog_primary_btn_remove), aVar);
        setButton(-2, galleryMainActivity.getString(R$string.gallery_shelve_cancel), aVar);
        setCanceledOnTouchOutside(false);
        setOnDismissListener(new b());
        setTitle(this.f53993a.getResources().getString(R$string.gallery_shelve_close_switch));
    }

    public void showDialog() {
        Resources resources = this.f53993a.getResources();
        int i10 = R$plurals.gallery_main_cg_dialog_primary_tip;
        int i11 = this.f53994b;
        setMessage(resources.getQuantityString(i10, i11, Integer.valueOf(i11)));
        show();
        getButton(-1).setTextColor(this.f53993a.getResources().getColor(R$color.enui50_red_color));
    }
}
