package p486n6;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import p015ak.C0212e0;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* renamed from: n6.j */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC11645j extends AlertDialogC13154a implements View.OnClickListener {

    /* renamed from: a */
    public Context f54016a;

    /* renamed from: b */
    public Button f54017b;

    /* renamed from: c */
    public Button f54018c;

    /* renamed from: d */
    public Button f54019d;

    /* renamed from: e */
    public TextView f54020e;

    /* renamed from: f */
    public TextView f54021f;

    /* renamed from: g */
    public String f54022g;

    /* renamed from: h */
    public Handler f54023h;

    /* renamed from: i */
    public int f54024i;

    public ViewOnClickListenerC11645j(Context context, String str, int i10, Handler handler) {
        super(context);
        this.f54016a = context;
        this.f54022g = str;
        this.f54024i = i10;
        this.f54023h = handler;
    }

    /* renamed from: a */
    public final void m69533a() {
        int i10 = this.f54024i;
        if (i10 == 1) {
            this.f54020e.setText(this.f54016a.getString(R$string.play_video_mobile_title));
            this.f54017b.setText(this.f54016a.getString(R$string.button_play_video_immediately));
            this.f54018c.setText(this.f54016a.getString(R$string.album_media_play_video_immediately_and_never_notify));
        } else if (i10 == 2 || i10 == 3) {
            this.f54020e.setText(this.f54016a.getString(R$string.download_mobile_title));
            this.f54017b.setText(this.f54016a.getString(R$string.button_download_immediately));
            this.f54018c.setText(this.f54016a.getString(R$string.album_media_download_immediately_and_never_notify));
        } else {
            if (i10 != 4) {
                return;
            }
            this.f54020e.setText(this.f54016a.getString(R$string.upload_mobile_title));
            this.f54017b.setText(this.f54016a.getString(R$string.button_upload_immediately));
            this.f54018c.setText(this.f54016a.getString(R$string.album_media_upload_immediately_and_never_notify));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.download_immediately_button) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = this.f54024i;
            this.f54023h.sendMessage(message);
            dismiss();
            return;
        }
        if (id2 != R$id.download_immediately_and_not_notify_button) {
            if (id2 == R$id.cancel_button) {
                dismiss();
            }
        } else {
            C0212e0.m1368r(this.f54016a, "mobile_data_tips_sp", "current_tips_setting_type", 2);
            Message message2 = new Message();
            message2.what = 0;
            message2.arg1 = this.f54024i;
            this.f54023h.sendMessage(message2);
            dismiss();
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.gallery_download_network_tips_dialog_layout);
        this.f54017b = (Button) C12809f.m76830c(this, R$id.download_immediately_button);
        this.f54018c = (Button) C12809f.m76830c(this, R$id.download_immediately_and_not_notify_button);
        this.f54019d = (Button) C12809f.m76830c(this, R$id.cancel_button);
        this.f54020e = (TextView) C12809f.m76830c(this, R$id.title);
        this.f54021f = (TextView) C12809f.m76830c(this, R$id.sub_title);
        this.f54017b.setOnClickListener(this);
        this.f54018c.setOnClickListener(this);
        this.f54019d.setOnClickListener(this);
        this.f54021f.setText(this.f54016a.getString(R$string.tip_mobile_message, this.f54022g));
        m69533a();
    }
}
