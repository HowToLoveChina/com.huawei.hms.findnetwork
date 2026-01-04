package p486n6;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.p071ui.CommonCircularProgressView;
import p015ak.C0213f;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* renamed from: n6.k */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC11646k extends AlertDialogC13154a implements View.OnClickListener {

    /* renamed from: g */
    public static final String f54025g = Formatter.formatShortFileSize(C0213f.m1377a(), 0);

    /* renamed from: a */
    public Context f54026a;

    /* renamed from: b */
    public CommonCircularProgressView f54027b;

    /* renamed from: c */
    public Button f54028c;

    /* renamed from: d */
    public TextView f54029d;

    /* renamed from: e */
    public String f54030e;

    /* renamed from: f */
    public Handler f54031f;

    public ViewOnClickListenerC11646k(Context context, String str, Handler handler) {
        super(context);
        this.f54026a = context;
        this.f54030e = str;
        this.f54031f = handler;
    }

    /* renamed from: a */
    public void m69534a(String str, int i10) {
        TextView textView = this.f54029d;
        if (textView == null || this.f54027b == null) {
            return;
        }
        textView.setText(this.f54026a.getString(R$string.album_media_download_complete_percentage_with_sum, str, this.f54030e));
        this.f54027b.setProgress(i10);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && view.getId() == R$id.cancel_button) {
            this.f54031f.sendEmptyMessage(1);
            dismiss();
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.gallery_downloading_dialog_layout);
        this.f54027b = (CommonCircularProgressView) C12809f.m76830c(this, R$id.round_progress);
        this.f54029d = (TextView) C12809f.m76830c(this, R$id.sub_title);
        Button button = (Button) C12809f.m76830c(this, R$id.cancel_button);
        this.f54028c = button;
        button.setOnClickListener(this);
        this.f54029d.setText(this.f54026a.getString(R$string.album_media_download_complete_percentage_with_sum, f54025g, this.f54030e));
        this.f54027b.setProgress(0);
    }
}
