package p486n6;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.activity.ShareAlbumHomePageActivity;
import com.huawei.android.p069cg.activity.UploadShareAlbumActivity;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.uikit.hwprogressbar.widget.HwProgressBar;
import java.text.SimpleDateFormat;
import java.util.Date;
import p015ak.C0209d;
import p015ak.C0224k0;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1130k;
import p031b7.C1140u;
import p514o9.C11829c;
import p546p6.C12091d;
import p581qk.AbstractC12367d;
import p604r7.C12469b;
import p616rk.C12515a;
import p676ud.AlertDialogC13154a;
import p684un.C13224c;
import p709vj.C13452e;
import sk.C12809f;

/* renamed from: n6.h */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC11643h extends AlertDialogC13154a implements View.OnClickListener, TextWatcher {

    /* renamed from: a */
    public String f54002a;

    /* renamed from: b */
    public Activity f54003b;

    /* renamed from: c */
    public View f54004c;

    /* renamed from: d */
    public EditText f54005d;

    /* renamed from: e */
    public View f54006e;

    /* renamed from: f */
    public TextView f54007f;

    /* renamed from: g */
    public TextView f54008g;

    /* renamed from: h */
    public TextView f54009h;

    /* renamed from: i */
    public HwProgressBar f54010i;

    /* renamed from: j */
    public Handler f54011j;

    /* renamed from: n6.h$a */
    public class a extends AbstractC12367d {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Album album = new Album();
            album.setAlbumName(ViewOnClickListenerC11643h.this.f54002a);
            album.setShareType(0);
            try {
                Album albumM74750d = C12469b.m74746l().m74750d(album);
                if (albumM74750d != null) {
                    C1120a.m6677i("CreateNormalAlbumDialog", "createNormalAlbum " + albumM74750d.getId());
                    Message messageObtain = Message.obtain();
                    messageObtain.obj = albumM74750d;
                    messageObtain.what = FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH;
                    ViewOnClickListenerC11643h.this.f54011j.sendMessage(messageObtain);
                }
            } catch (C4616s e10) {
                C1120a.m6676e("CreateNormalAlbumDialog", "createNormalAlbum HttpResponseException " + e10.getMessage());
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 1032;
                messageObtain2.obj = e10;
                ViewOnClickListenerC11643h.this.f54011j.sendMessage(messageObtain2);
                C1122c.m6682B(e10, ViewOnClickListenerC11643h.this.f54011j, ViewOnClickListenerC11643h.this.f54003b);
            } catch (Exception e11) {
                C1120a.m6676e("CreateNormalAlbumDialog", "createNormalAlbum Exception " + e11.getMessage());
                Message messageObtain3 = Message.obtain();
                messageObtain3.what = 1033;
                ViewOnClickListenerC11643h.this.f54011j.sendMessage(messageObtain3);
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* renamed from: n6.h$b */
    public class b extends Handler {
        public b() {
            super(ViewOnClickListenerC11643h.this.f54003b.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1013) {
                C1120a.m6675d("CreateNormalAlbumDialog", "UploadShareAlbumActivity");
                if (ViewOnClickListenerC11643h.this.f54003b == null) {
                    return;
                }
                ViewOnClickListenerC11643h.this.m69531k();
                Album album = (Album) message.obj;
                if (album == null) {
                    C1120a.m6676e("CreateNormalAlbumDialog", "album is null");
                    return;
                }
                Intent intent = new Intent();
                if (CloudAlbumSettings.m14363h().m14384t()) {
                    intent.setClass(ViewOnClickListenerC11643h.this.f54003b, UploadShareAlbumActivity.class);
                    intent.putExtra("is_from_create_entry", true);
                } else {
                    intent.setClass(ViewOnClickListenerC11643h.this.f54003b, ShareAlbumHomePageActivity.class);
                    intent.putExtra("param_album_type", album.getShareType());
                    intent.putExtra("is_from_create_entry", true);
                }
                intent.putExtra("param_album_id", album.getId());
                C0224k0.m1542L(ViewOnClickListenerC11643h.this.f54003b, intent);
                ViewOnClickListenerC11643h.this.f54003b.finish();
            } else if (i10 == 1032 || i10 == 1033) {
                ViewOnClickListenerC11643h.this.f54010i.setVisibility(8);
                ViewOnClickListenerC11643h.this.f54009h.setVisibility(0);
                ViewOnClickListenerC11643h.this.m69530j(message);
            }
            if (message.what == 4956) {
                ViewOnClickListenerC11643h.this.m69528n(true);
            } else {
                C12091d.m72280a0().m72361j1(ViewOnClickListenerC11643h.this.f54003b, message.what, "");
            }
        }
    }

    public ViewOnClickListenerC11643h(Activity activity) throws IllegalAccessException, IllegalArgumentException {
        super(activity);
        this.f54003b = activity;
        this.f54011j = new b();
        this.f54004c = LayoutInflater.from(activity).inflate(R$layout.dialog_create_normal_album, (ViewGroup) null);
        initView();
        setView(this.f54004c);
        Window window = getWindow();
        if (window != null) {
            window.setFlags(1024, 1024);
        }
        setCanceledOnTouchOutside(false);
        C11829c.m70594l1(activity, this);
    }

    private void initView() {
        TextView textView = (TextView) C12809f.m76831d(this.f54004c, R$id.tv_cancel_create);
        this.f54008g = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) C12809f.m76831d(this.f54004c, R$id.tv_confirm_create);
        this.f54009h = textView2;
        textView2.setOnClickListener(this);
        this.f54010i = (HwProgressBar) C12809f.m76831d(this.f54004c, R$id.loading_layout);
        EditText editText = (EditText) C12809f.m76831d(this.f54004c, R$id.et_input_name);
        this.f54005d = editText;
        editText.addTextChangedListener(this);
        this.f54005d.setFilters(new InputFilter[]{C1130k.m6918c(), C1130k.m6917b()});
        this.f54006e = C12809f.m76831d(this.f54004c, R$id.custom_input_underline);
        this.f54007f = (TextView) C12809f.m76831d(this.f54004c, R$id.tv_name_check_hint);
        m69528n(false);
        m69527l();
    }

    /* renamed from: l */
    private void m69527l() {
        if (this.f54003b == null) {
            return;
        }
        String string = this.f54003b.getString(R$string.normal_album_name_hint, new SimpleDateFormat("yyyy-MMdd").format(new Date(System.currentTimeMillis())).split("-")[1]);
        this.f54005d.setHint(string);
        this.f54002a = string;
        C1120a.m6675d("CreateNormalAlbumDialog", "setDefaultHint defaultAlbumName " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m69528n(boolean z10) {
        Activity activity = this.f54003b;
        if (activity == null) {
            return;
        }
        this.f54006e.setBackgroundColor(activity.getColor(z10 ? R$color.color_FB374E : R$color.color_open_data_sync_desc));
        this.f54007f.setText(this.f54003b.getString(z10 ? R$string.sensitive_word : R$string.normal_album_name_example));
        this.f54007f.setTextColor(this.f54003b.getColor(z10 ? R$color.color_FB374E : R$color.color_input_hint));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    /* renamed from: i */
    public final void m69529i() {
        C1120a.m6675d("CreateNormalAlbumDialog", "jump to single album");
        if (!NetworkUtil.isNetworkAvailable(this.f54003b)) {
            C1140u.m7197i(this.f54003b);
            return;
        }
        this.f54010i.setVisibility(0);
        this.f54009h.setVisibility(8);
        C12515a.m75110o().m75175e(new a(), false);
    }

    /* renamed from: j */
    public final void m69530j(Message message) {
        C4616s c4616s;
        if (message.what != 1032 || (c4616s = (C4616s) message.obj) == null) {
            return;
        }
        if (!C1122c.m6699G1(c4616s)) {
            C12091d.m72280a0().m72309H0(this.f54011j, c4616s);
            C12091d.m72280a0().m72307G0(c4616s, this.f54011j);
            return;
        }
        C1120a.m6676e("CreateNormalAlbumDialog", " handleCreateFail user isUserSuspended");
        if (this.f54003b == null) {
            C1120a.m6676e("CreateNormalAlbumDialog", " handleCreateFail context is null");
        } else {
            C12091d.m72280a0().m72359i1(this.f54003b);
        }
    }

    /* renamed from: k */
    public final void m69531k() {
        C1120a.m6675d("CreateNormalAlbumDialog", "reportCreateAlbumEvent");
        C13224c.m79487f1().m79585f0("share_album_create_normal_album", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "share_album_create_normal_album", "1", "cloud_space_home_page_dialog");
    }

    /* renamed from: m */
    public void m69532m() {
        EditText editText = this.f54005d;
        if (editText != null) {
            editText.setFocusable(true);
            this.f54005d.requestFocus();
            getWindow().clearFlags(131080);
            getWindow().setSoftInputMode(5);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C1120a.m6676e("CreateNormalAlbumDialog", " do not fast click ");
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.tv_confirm_create) {
            m69529i();
        } else if (id2 == R$id.tv_cancel_create) {
            dismiss();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        String string = charSequence.toString();
        this.f54002a = string;
        if (TextUtils.isEmpty(string)) {
            m69527l();
            m69528n(false);
        }
    }
}
