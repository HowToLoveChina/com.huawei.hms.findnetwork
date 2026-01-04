package p031b7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.huawei.android.hicloud.album.service.logic.callable.CloudAlbumDownloadBabyHeadPicCallable;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Inviter;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.activity.AlbumManageActivity;
import com.huawei.android.p069cg.activity.JoinBabyAlbumActivity;
import com.huawei.android.p069cg.activity.JoinCommonAlbumActivity;
import com.huawei.android.p069cg.activity.ShareAlbumHomePageActivity;
import com.huawei.hicloud.bean.AutoIdentifyInvitationCode;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.framework.common.NetworkUtil;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p015ak.C0213f;
import p292fn.C9733f;
import p514o9.C11841o;
import p546p6.C12091d;
import p676ud.AlertDialogC13154a;
import p684un.C13224c;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: b7.u */
/* loaded from: classes2.dex */
public class C1140u {
    /* renamed from: a */
    public static void m7189a(Activity activity, String str) {
        if (activity == null || TextUtils.isEmpty(str)) {
            C1120a.m6676e("UIUtil", "copyToClipboard invalid");
        } else {
            Toast.makeText(activity, activity.getString(R$string.copy_invite_code), 0).show();
        }
    }

    /* renamed from: b */
    public static int m7190b(Context context, float f10) {
        if (context == null || context.getResources() == null || context.getResources().getDisplayMetrics() == null) {
            return 0;
        }
        return (int) TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics());
    }

    /* renamed from: c */
    public static Intent m7191c(Inviter inviter) {
        Intent intent = new Intent();
        if (inviter == null || TextUtils.isEmpty(inviter.getAlbumId())) {
            intent.setClass(C0213f.m1377a(), AlbumManageActivity.class);
            intent.putExtra("show_tab_id", 2);
        } else {
            intent.setClass(C0213f.m1377a(), ShareAlbumHomePageActivity.class);
            intent.putExtra("param_album_id", inviter.getAlbumId());
            intent.putExtra("param_album_type", inviter.getShareType());
        }
        return intent;
    }

    /* renamed from: d */
    public static String m7192d(String str) {
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("UIUtil", "inviteCode is empty");
            return "";
        }
        C1120a.m6675d("UIUtil", "onLongClick inviteCode " + str);
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C1120a.m6678w("UIUtil", "configMap is null");
            return "";
        }
        try {
            AutoIdentifyInvitationCode autoIdentifyInvitationCode = (AutoIdentifyInvitationCode) new Gson().fromJson(hiCloudSysParamMapM60757p.getAutoIdentifyInvitationCode(), AutoIdentifyInvitationCode.class);
            if (autoIdentifyInvitationCode == null) {
                C1120a.m6678w("UIUtil", "autoIdentifyInvitationCode is null");
                return "";
            }
            String createRule = autoIdentifyInvitationCode.getCreateRule();
            C1120a.m6675d("UIUtil", "extractRule : " + createRule);
            if (TextUtils.isEmpty(createRule)) {
                C1120a.m6678w("UIUtil", "extractRule isEmpty");
                return "";
            }
            String str2 = String.format(createRule, str);
            C1120a.m6675d("UIUtil", "onLongClick result " + str2);
            return str2;
        } catch (Exception e10) {
            C1120a.m6676e("UIUtil", "parse config error: " + e10.toString());
            return "";
        }
    }

    /* renamed from: e */
    public static String m7193e(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str.hashCode();
        switch (str) {
        }
        return "";
    }

    /* renamed from: f */
    public static void m7194f(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null) {
            C1120a.m6676e("UIUtil", "hideIme imm is null ");
            return;
        }
        boolean zIsActive = inputMethodManager.isActive();
        C1120a.m6675d("UIUtil", "hideIme isImeShow " + zIsActive);
        if (zIsActive) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /* renamed from: g */
    public static boolean m7195g(Activity activity) {
        if (NetworkUtil.isNetworkAvailable(activity)) {
            return false;
        }
        m7197i(activity);
        return true;
    }

    /* renamed from: h */
    public static String m7196h(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i10 = 0;
        if (str.contains(SplitAppUtil.SPLIT_APP_SUFFIX)) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length == 0) {
                return str;
            }
            String str2 = strArrSplit[0];
            char[] charArray = str.toCharArray();
            StringBuilder sb2 = new StringBuilder();
            while (i10 < charArray.length) {
                if (i10 <= 0 || i10 >= str2.length() || charArray[i10] == '@') {
                    sb2.append(charArray[i10]);
                } else {
                    sb2.append('*');
                }
                i10++;
            }
            return sb2.toString();
        }
        if (str.length() > 4) {
            char[] charArray2 = str.toCharArray();
            StringBuilder sb3 = new StringBuilder();
            while (i10 < charArray2.length) {
                if (i10 > str.length() - 5) {
                    sb3.append('*');
                } else {
                    sb3.append(charArray2[i10]);
                }
                i10++;
            }
            return sb3.toString();
        }
        char[] charArray3 = str.toCharArray();
        StringBuilder sb4 = new StringBuilder();
        while (i10 < charArray3.length) {
            if (i10 > 0) {
                sb4.append('*');
            } else {
                sb4.append(charArray3[i10]);
            }
            i10++;
        }
        return sb4.toString();
    }

    /* renamed from: i */
    public static void m7197i(Activity activity) {
        if (activity == null) {
            return;
        }
        Toast.makeText(activity, R$string.alert_net_disconnect_20160420, 0).show();
    }

    /* renamed from: j */
    public static void m7198j(Inviter inviter, Activity activity, AlertDialogC13154a alertDialogC13154a) {
        if (inviter == null) {
            C11841o.m70706b(activity, activity.getString(R$string.server_error), 0);
            C1120a.m6676e("UIUtil", "inviter is null");
            return;
        }
        String albumUserId = inviter.getAlbumUserId();
        if (!TextUtils.isEmpty(albumUserId) && albumUserId.equals(C13452e.m80781L().m80971t0())) {
            activity.startActivity(m7191c(inviter));
            alertDialogC13154a.dismiss();
            return;
        }
        Boolean joined = inviter.getJoined();
        if (joined != null && joined.booleanValue()) {
            activity.startActivity(m7191c(inviter));
            alertDialogC13154a.dismiss();
            return;
        }
        m7199k(inviter.getShareType().intValue());
        if (inviter.getShareType().intValue() == 0) {
            Intent intent = new Intent(activity, (Class<?>) JoinCommonAlbumActivity.class);
            intent.putExtra("key_inviter_string", inviter.toString());
            activity.startActivity(intent);
            alertDialogC13154a.dismiss();
            return;
        }
        Intent intent2 = new Intent(activity, (Class<?>) JoinBabyAlbumActivity.class);
        intent2.putExtra("key_inviter_string", inviter.toString());
        activity.startActivity(intent2);
        alertDialogC13154a.dismiss();
    }

    /* renamed from: k */
    public static void m7199k(int i10) {
        C1120a.m6675d("UIUtil", "reportJoinShareAlbum albumType " + i10);
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("share_type", String.valueOf(i10));
        C13224c.m79487f1().m79592m0("action_code_show_join_album", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "action_code_show_join_album", "1", "from_cloud_album_appeal_main", linkedHashMapM79497A);
    }

    /* renamed from: l */
    public static void m7200l(Context context, Album album, ImageView imageView) {
        m7202n(context, album, imageView, true);
    }

    /* renamed from: m */
    public static void m7201m(Context context, Album album, ImageView imageView) {
        m7202n(context, album, imageView, false);
    }

    /* renamed from: n */
    public static void m7202n(Context context, Album album, ImageView imageView, boolean z10) {
        if (C12091d.m72280a0().m72313J0(album)) {
            C12091d.m72280a0().m72294A(album, imageView, z10);
            return;
        }
        String str = C1124e.m6871o(context) + "/.cloudShare/thumb/headPic/" + (album.getId() + CloudAlbumDownloadBabyHeadPicCallable.DEFAULT_HEAD_EXT);
        if (C1122c.m6837u1(str)) {
            imageView.setImageBitmap(C0209d.m1311u(str));
            return;
        }
        if (z10) {
            imageView.setImageDrawable(context.getDrawable(R$drawable.ic_share_album_tab_default));
        } else {
            m7203o(context, album, imageView);
        }
        C12091d.m72280a0().m72294A(album, imageView, z10);
    }

    /* renamed from: o */
    public static void m7203o(Context context, Album album, ImageView imageView) {
        try {
            String sex = album.getBabyInfo().getSex();
            if ("male".equals(sex)) {
                imageView.setImageDrawable(context.getDrawable(R$drawable.ic_default_boy));
            } else if ("female".equals(sex)) {
                imageView.setImageDrawable(context.getDrawable(R$drawable.ic_default_girl));
            } else {
                imageView.setImageDrawable(context.getDrawable(R$drawable.ic_default_unborn));
            }
        } catch (Exception e10) {
            C1120a.m6676e("UIUtil", "setChildAlbumBackground error: " + e10.toString());
            imageView.setImageDrawable(context.getDrawable(R$drawable.ic_default_unborn));
        }
    }

    /* renamed from: p */
    public static void m7204p(Context context, Album album, ImageView imageView) {
        if (C12091d.m72280a0().m72306G(album, imageView)) {
            return;
        }
        imageView.setImageDrawable(context.getDrawable(R$drawable.cloud_album_defalut_pic));
    }
}
