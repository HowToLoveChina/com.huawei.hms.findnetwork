package p486n6;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.p088ui.uiextend.CustomRoundImageView;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.p071ui.InvitationCodeView;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p015ak.C0209d;
import p031b7.C1120a;
import p031b7.C1140u;
import p514o9.C11841o;
import p546p6.C12091d;
import p783xp.C13843a;
import sk.C12809f;

/* renamed from: n6.b */
/* loaded from: classes2.dex */
public class DialogC11637b extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    public Activity f53972a;

    /* renamed from: b */
    public Album f53973b;

    /* renamed from: c */
    public String f53974c;

    /* renamed from: d */
    public String f53975d;

    public DialogC11637b(Activity activity, Album album, String str, String str2) {
        super(activity);
        this.f53972a = activity;
        this.f53973b = album;
        this.f53974c = str;
        this.f53975d = str2;
        m69507a(activity);
    }

    /* renamed from: a */
    public final void m69507a(Context context) {
        View viewInflate = View.inflate(context, R$layout.album_share_invite_code_sheet, null);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.album_share_code_card_title);
        TextView textView2 = (TextView) C12809f.m76831d(viewInflate, R$id.album_share_code_moment);
        CustomRoundImageView customRoundImageView = (CustomRoundImageView) C12809f.m76831d(viewInflate, R$id.album_share_code_moment_pic_child);
        CustomRoundImageView customRoundImageView2 = (CustomRoundImageView) C12809f.m76831d(viewInflate, R$id.album_share_code_moment_pic);
        InvitationCodeView invitationCodeView = (InvitationCodeView) C12809f.m76831d(viewInflate, R$id.invitation_code);
        ImageView imageView = (ImageView) C12809f.m76831d(viewInflate, R$id.close_sheet);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(viewInflate, R$id.rl_send_way_wechat);
        RelativeLayout relativeLayout2 = (RelativeLayout) C12809f.m76831d(viewInflate, R$id.rl_send_way_qq);
        RelativeLayout relativeLayout3 = (RelativeLayout) C12809f.m76831d(viewInflate, R$id.rl_send_way_sms);
        RelativeLayout relativeLayout4 = (RelativeLayout) C12809f.m76831d(viewInflate, R$id.rl_send_way_more);
        imageView.setOnClickListener(this);
        relativeLayout.setOnClickListener(this);
        relativeLayout2.setOnClickListener(this);
        relativeLayout3.setOnClickListener(this);
        relativeLayout4.setOnClickListener(this);
        Album album = this.f53973b;
        if (album != null) {
            if (album.getShareType().intValue() == 1) {
                customRoundImageView2.setVisibility(8);
                customRoundImageView.setVisibility(0);
                textView.setText(R$string.tv_child_share_code);
                C1140u.m7201m(context, this.f53973b, customRoundImageView);
            } else {
                textView.setText(R$string.tv_share_album_code);
                if (!C12091d.m72280a0().m72306G(this.f53973b, customRoundImageView2)) {
                    customRoundImageView2.setImageDrawable(context.getDrawable(R$drawable.normal_album_bg));
                }
            }
            textView2.setText(this.f53973b.getAlbumName());
        }
        if (!TextUtils.isEmpty(this.f53974c)) {
            invitationCodeView.m14716i(this.f53974c, false);
        }
        setContentView(viewInflate);
        getWindow().findViewById(R$id.design_bottom_sheet).setBackgroundResource(R.color.transparent);
    }

    /* renamed from: b */
    public final void m69508b(Intent intent) {
        intent.setAction("android.intent.action.SEND");
        intent.setType(InterfaceC5483d.f25083i);
        intent.putExtra("android.intent.extra.TEXT", !TextUtils.isEmpty(this.f53975d) ? this.f53975d : !TextUtils.isEmpty(this.f53974c) ? this.f53974c : "");
        Intent intentCreateChooser = Intent.createChooser(intent, "");
        intentCreateChooser.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        try {
            this.f53972a.startActivity(intentCreateChooser);
        } catch (Exception e10) {
            C1120a.m6676e("AlbumShareInviteCodeSheetDialog", "startActivity error: " + e10.toString());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        C1120a.m6677i("AlbumShareInviteCodeSheetDialog", "onClick");
        Intent intent = new Intent();
        if (id2 == R$id.rl_send_way_wechat) {
            C1120a.m6677i("AlbumShareInviteCodeSheetDialog", "click wechat");
            if (C0209d.m1184K0(this.f53972a, "com.tencent.mm")) {
                C0209d.m1302r2(intent, "com.tencent.mm");
                m69508b(intent);
                return;
            } else {
                Activity activity = this.f53972a;
                C11841o.m70706b(this.f53972a, activity.getString(R$string.install_app_first, activity.getString(R$string.app_wechat)), 0);
                return;
            }
        }
        if (id2 == R$id.rl_send_way_qq) {
            C1120a.m6677i("AlbumShareInviteCodeSheetDialog", "click qq");
            if (C0209d.m1184K0(this.f53972a, "com.tencent.mobileqq")) {
                C0209d.m1302r2(intent, "com.tencent.mobileqq");
                m69508b(intent);
                return;
            } else {
                Activity activity2 = this.f53972a;
                C11841o.m70706b(this.f53972a, activity2.getString(R$string.install_app_first, activity2.getString(R$string.app_qq)), 0);
                return;
            }
        }
        if (id2 != R$id.rl_send_way_sms) {
            if (id2 == R$id.rl_send_way_more) {
                C1120a.m6677i("AlbumShareInviteCodeSheetDialog", "click more");
                m69508b(intent);
                return;
            } else {
                if (id2 == R$id.close_sheet) {
                    dismiss();
                    return;
                }
                return;
            }
        }
        C1120a.m6677i("AlbumShareInviteCodeSheetDialog", "click sms");
        String strM83049A = C13843a.m83049A();
        if (C0209d.m1184K0(this.f53972a, strM83049A)) {
            C0209d.m1302r2(intent, strM83049A);
            m69508b(intent);
        } else {
            Activity activity3 = this.f53972a;
            C11841o.m70706b(this.f53972a, activity3.getString(R$string.install_app_first, activity3.getString(R$string.app_sms)), 0);
        }
    }
}
