package com.huawei.android.p069cg.activity;

import android.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.android.dynamicfeature.plugin.language.LanguagePlugin;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Inviter;
import com.huawei.android.hicloud.drive.cloudphoto.model.Permission;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hms.p148ui.SafeIntent;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1140u;
import p514o9.C11842p;
import p546p6.C12091d;
import p546p6.C12112y;
import p581qk.AbstractC12367d;
import p604r7.C12469b;
import p616rk.C12515a;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes2.dex */
public class AlbumShareInviteActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: A */
    public String f9954A;

    /* renamed from: B */
    public String f9955B;

    /* renamed from: C */
    public TextView f9956C;

    /* renamed from: D */
    public TextView f9957D;

    /* renamed from: E */
    public TextView f9958E;

    /* renamed from: F */
    public TextView f9959F;

    /* renamed from: G */
    public UnionSwitch f9960G;

    /* renamed from: H */
    public UnionSwitch f9961H;

    /* renamed from: I */
    public Handler f9962I = new HandlerC2175a();

    /* renamed from: J */
    public boolean f9963J = false;

    /* renamed from: p */
    public NotchTopFitRelativeLayout f9964p;

    /* renamed from: q */
    public NotchFitLinearLayout f9965q;

    /* renamed from: r */
    public TextView f9966r;

    /* renamed from: s */
    public Dialog f9967s;

    /* renamed from: t */
    public ImageView f9968t;

    /* renamed from: u */
    public ImageView f9969u;

    /* renamed from: v */
    public RelativeLayout f9970v;

    /* renamed from: w */
    public RelativeLayout f9971w;

    /* renamed from: x */
    public int f9972x;

    /* renamed from: y */
    public String f9973y;

    /* renamed from: z */
    public Album f9974z;

    /* renamed from: com.huawei.android.cg.activity.AlbumShareInviteActivity$a */
    public class HandlerC2175a extends Handler {
        public HandlerC2175a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            C1120a.m6675d("AlbumShareInviteActivity", " msg.what " + message.what);
            int i10 = message.what;
            if (i10 != 1022) {
                if (i10 == 2000) {
                    C12091d.m72280a0().m72359i1(AlbumShareInviteActivity.this);
                }
            } else {
                String str = (String) message.obj;
                C1120a.m6675d("AlbumShareInviteActivity", "inviterId " + str);
                AlbumShareInviteActivity.this.m13350h2(str);
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.AlbumShareInviteActivity$b */
    public class C2176b extends AbstractC12367d {
        public C2176b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                String strM13344Y1 = AlbumShareInviteActivity.this.m13344Y1();
                C1120a.m6675d("AlbumShareInviteActivity", "privilege " + strM13344Y1);
                String strM13343W1 = AlbumShareInviteActivity.this.m13343W1();
                C1120a.m6675d("AlbumShareInviteActivity", "remark " + strM13343W1);
                Inviter inviterM74749c = C12469b.m74746l().m74749c(AlbumShareInviteActivity.this.f9973y, AlbumShareInviteActivity.this.f9954A, strM13343W1, strM13344Y1, "wechat", AlbumShareInviteActivity.this.f9963J);
                if (inviterM74749c != null) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = PlayerConstants.ErrorCode.SWITCH_PLAYMODE_AUDIO_FAILED;
                    messageObtain.obj = inviterM74749c.getInviterId();
                    AlbumShareInviteActivity.this.f9962I.sendMessage(messageObtain);
                }
            } catch (C4616s e10) {
                C1120a.m6676e("AlbumShareInviteActivity", "inviteSpecialFriend HttpResponseException " + e10);
                if (C1122c.m6699G1(e10)) {
                    C1120a.m6676e("AlbumShareInviteActivity", " inviteSpecialFriend user suspended");
                    Message messageObtain2 = Message.obtain();
                    messageObtain2.what = 2000;
                    AlbumShareInviteActivity.this.f9962I.sendMessage(messageObtain2);
                }
            } catch (Exception e11) {
                C1120a.m6676e("AlbumShareInviteActivity", "inviteSpecialFriend Exception " + e11.getMessage());
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.AlbumShareInviteActivity$c */
    public static class C2177c extends ClickableSpan {

        /* renamed from: a */
        public AlbumShareInviteActivity f9977a;

        /* renamed from: b */
        public boolean f9978b;

        public C2177c(AlbumShareInviteActivity albumShareInviteActivity) {
            this.f9977a = albumShareInviteActivity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.f9977a.m13352j2();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.f9977a.getResources().getColor(R$color.emui_functional_blue, null));
            textPaint.bgColor = this.f9977a.getResources().getColor(this.f9978b ? R$color.emui9_list_seletor_color : R$color.transparent, null);
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: X1 */
    private void m13338X1() {
        this.f9973y = new SafeIntent(getIntent()).getStringExtra("param_album_id");
        C1120a.m6675d("AlbumShareInviteActivity", "mAlbumId " + this.f9973y);
    }

    /* renamed from: a2 */
    private void m13339a2() {
        setContentView(R$layout.album_share_invite);
    }

    /* renamed from: b2 */
    private void m13340b2() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f9973y = safeIntent.getStringExtra("param_album_id");
        Album albumM72310I = C12091d.m72280a0().m72310I(this.f9973y);
        this.f9974z = albumM72310I;
        if (albumM72310I == null) {
            C1120a.m6676e("AlbumShareInviteActivity", "initData mAlbum is null");
            return;
        }
        this.f9972x = albumM72310I.getShareType().intValue();
        this.f9954A = safeIntent.getStringExtra("param_album_relation");
        this.f9955B = safeIntent.getStringExtra("param_album_child_nickname");
        if (this.f9972x == 1) {
            this.f9969u.setVisibility(0);
            this.f9968t.setVisibility(8);
            C1140u.m7201m(this, this.f9974z, this.f9969u);
        } else {
            this.f9969u.setVisibility(8);
            this.f9968t.setVisibility(0);
            if (!C12091d.m72280a0().m72306G(this.f9974z, this.f9968t)) {
                this.f9968t.setImageDrawable(getDrawable(R$drawable.normal_album_bg));
            }
        }
        m13351i2();
        C1120a.m6675d("AlbumShareInviteActivity", "mAlbumId " + this.f9973y);
    }

    /* renamed from: c2 */
    private void m13341c2() {
        this.f9964p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f9965q = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.main_all);
        this.f9968t = (ImageView) C12809f.m76829b(this, R$id.share_invite_pic);
        this.f9969u = (ImageView) C12809f.m76829b(this, R$id.share_invite_pic_baby);
        this.f9971w = (RelativeLayout) C12809f.m76829b(this, R$id.ic_back_hot_space);
        this.f9956C = (TextView) C12809f.m76829b(this, R$id.action_bar_title);
        this.f9957D = (TextView) C12809f.m76829b(this, R$id.join_album_share_tips);
        this.f9958E = (TextView) C12809f.m76829b(this, R$id.album_manager_tab_pic_title);
        this.f9959F = (TextView) C12809f.m76829b(this, R$id.permission_tips);
        UnionSwitch unionSwitch = (UnionSwitch) C12809f.m76829b(this, R$id.upload_item_switch);
        this.f9960G = unionSwitch;
        unionSwitch.setCheckedProgrammatically(false);
        UnionSwitch unionSwitch2 = (UnionSwitch) C12809f.m76829b(this, R$id.download_item_switch);
        this.f9961H = unionSwitch2;
        unionSwitch2.setCheckedProgrammatically(false);
        this.f9971w.setOnClickListener(this);
        this.f9966r = (TextView) C12809f.m76829b(this, R$id.share_manager_confirm);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.start_use_button);
        this.f9970v = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.f9966r.setOnClickListener(this);
        m13353k2();
    }

    /* renamed from: V1 */
    public final void m13342V1() {
        C1120a.m6677i("AlbumShareInviteActivity", "closeManager");
        this.f9963J = false;
        Toast.makeText(this, getString(R$string.done_disable_audit), 0).show();
        m13353k2();
    }

    /* renamed from: W1 */
    public final String m13343W1() {
        List<Permission> permissions;
        Album album = this.f9974z;
        String remark = "";
        if (album != null && album.getPermissions() != null && (permissions = this.f9974z.getPermissions()) != null && permissions.size() > 0) {
            for (Permission permission : permissions) {
                if (permission != null && permission.getUserId().equals(this.f9974z.getAlbumOwnerId())) {
                    remark = permission.getRemark();
                    C1120a.m6675d("AlbumShareInviteActivity", "getAlbumOwnerRemark ownerRemark " + remark);
                }
            }
        }
        C1120a.m6675d("AlbumShareInviteActivity", "getAlbumOwnerRemark ownerRemark " + remark);
        return remark;
    }

    /* renamed from: Y1 */
    public final String m13344Y1() {
        String strM6769d = this.f9960G.isChecked() ? C1122c.m6769d(HNConstants.DataType.f22634NA, "upload") : C1122c.m6726P1(HNConstants.DataType.f22634NA, "upload");
        return this.f9961H.isChecked() ? C1122c.m6769d(strM6769d, "download") : C1122c.m6726P1(strM6769d, "download");
    }

    /* renamed from: Z1 */
    public final String m13345Z1() {
        return TextUtils.isEmpty(this.f9954A) ? "" : C12091d.m72280a0().m72350e0(this, this.f9954A);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f9964p);
        arrayList.add(this.f9965q);
        return arrayList;
    }

    /* renamed from: d2 */
    public final void m13346d2() {
        C12515a.m75110o().m75175e(new C2176b(), false);
    }

    /* renamed from: e2 */
    public final /* synthetic */ void m13347e2(DialogInterface dialogInterface, int i10) {
        if (dialogInterface == null || this.f9967s == null) {
            return;
        }
        if (this.f9963J) {
            m13342V1();
        } else {
            m13349g2();
        }
        this.f9967s.dismiss();
        this.f9967s = null;
    }

    /* renamed from: f2 */
    public final /* synthetic */ void m13348f2(DialogInterface dialogInterface, int i10) {
        Dialog dialog;
        if (dialogInterface == null || (dialog = this.f9967s) == null) {
            return;
        }
        dialog.dismiss();
        this.f9967s = null;
    }

    /* renamed from: g2 */
    public final void m13349g2() {
        C1120a.m6677i("AlbumShareInviteActivity", "openManager");
        this.f9963J = true;
        Toast.makeText(this, getString(R$string.done_enbable_audit), 0).show();
        m13353k2();
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019f  */
    /* renamed from: h2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m13350h2(java.lang.String r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.p069cg.activity.AlbumShareInviteActivity.m13350h2(java.lang.String):void");
    }

    /* renamed from: i2 */
    public final void m13351i2() {
        UnionSwitch unionSwitch = this.f9960G;
        if (unionSwitch != null) {
            unionSwitch.setCheckedProgrammatically(true);
        }
        if (this.f9972x != 1) {
            this.f9957D.setText(getString(R$string.join_normal_share_album));
            TextView textView = this.f9958E;
            Album album = this.f9974z;
            textView.setText(album != null ? album.getAlbumName() : "");
            this.f9964p.setBackground(getDrawable(R$drawable.ic_common_album_bg));
            this.f9956C.setText(getString(R$string.invite_friend));
            return;
        }
        if (TextUtils.isEmpty(m13345Z1()) || "other".equals(this.f9954A)) {
            this.f9956C.setText(getString(R$string.invite_friend));
            this.f9959F.setText(getString(R$string.friend_permission));
        } else {
            this.f9956C.setText(getString(R$string.invite_grandma));
            this.f9959F.setText(getString(R$string.album_one_permission, m13345Z1()));
        }
        this.f9957D.setText(getString(R$string.join_baby_album));
        TextView textView2 = this.f9958E;
        Album album2 = this.f9974z;
        textView2.setText(album2 != null ? album2.getAlbumName() : "");
        this.f9964p.setBackground(getDrawable(R$drawable.ic_baby_album_bg));
    }

    /* renamed from: j2 */
    public final void m13352j2() {
        String string;
        int i10;
        if (this.f9967s == null) {
            if (this.f9963J) {
                string = getString(R$string.disable_audit);
                i10 = R$string.common_btn_close;
            } else {
                string = getString(R$string.enbable_audit);
                i10 = R$string.hicloud_cover_open_btn;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(string);
            builder.setPositiveButton(i10, new DialogInterface.OnClickListener() { // from class: k6.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    this.f52058a.m13347e2(dialogInterface, i11);
                }
            });
            builder.setNegativeButton(R$string.sync_data_merge_btn_confirm, new DialogInterface.OnClickListener() { // from class: k6.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    this.f52059a.m13348f2(dialogInterface, i11);
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            this.f9967s = alertDialogCreate;
            C11842p.m70890z1(this, alertDialogCreate);
            this.f9967s.setCanceledOnTouchOutside(true);
            try {
                this.f9967s.show();
            } catch (Exception unused) {
                C1120a.m6676e("AlbumShareInviteActivity", "showConfirm bad window");
            }
        }
    }

    /* renamed from: k2 */
    public final void m13353k2() {
        if (this.f9963J) {
            String string = getString(R$string.disable_audit);
            SpannableString spannableString = new SpannableString(getString(R$string.invite_manager_tips_close_new, string));
            int iIndexOf = spannableString.toString().indexOf(string);
            spannableString.setSpan(new C2177c(this), iIndexOf, string.length() + iIndexOf, 33);
            this.f9966r.setText(spannableString);
        } else {
            String string2 = getString(R$string.enbable_audit);
            SpannableString spannableString2 = new SpannableString(getString(R$string.invite_manager_tips_open_new, string2));
            int iIndexOf2 = spannableString2.toString().indexOf(string2);
            spannableString2.setSpan(new C2177c(this), iIndexOf2, string2.length() + iIndexOf2, 33);
            this.f9966r.setText(spannableString2);
        }
        this.f9966r.setHighlightColor(getColor(R.color.transparent));
        this.f9966r.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            C1120a.m6676e("AlbumShareInviteActivity", "view is null");
            return;
        }
        if (C0209d.m1226Y0()) {
            C1120a.m6676e("AlbumShareInviteActivity", "do not fast click");
            return;
        }
        int id2 = view.getId();
        if (id2 != R$id.start_use_button) {
            if (id2 == R$id.ic_back_hot_space) {
                finish();
            }
        } else if (!C0209d.m1184K0(this, "com.tencent.mm")) {
            Toast.makeText(this, getString(R$string.general_no_tips, getString(R$string.app_wechat)), 0).show();
        } else {
            C12091d.m72280a0().m72299C0();
            m13346d2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        new LanguagePlugin().activityInit(this);
        super.onConfigurationChanged(configuration);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        m13339a2();
        m13341c2();
        m13340b2();
        m13338X1();
        mo19005p1();
        C11842p.m70889z0(this);
        m22369I1();
        C12112y.m72547b(this, "wx50a006ee9dc22259");
    }
}
