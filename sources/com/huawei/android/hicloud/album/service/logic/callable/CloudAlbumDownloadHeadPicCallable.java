package com.huawei.android.hicloud.album.service.logic.callable;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.huawei.android.hicloud.drive.user.request.Users;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.base.drive.user.model.User;
import com.huawei.hicloud.base.drive.user.model.UsersListRequest;
import hk.C10278a;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.Callable;
import mk.C11476b;
import okhttp3.C11922g0;
import p012ab.C0086a;
import p015ak.C0209d;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1124e;
import p035bk.C1248a;
import p283fa.C9679b;
import p546p6.C12091d;
import p701v6.C13356c;
import p733w9.C13576a;

/* loaded from: classes2.dex */
public class CloudAlbumDownloadHeadPicCallable implements Callable<Object> {
    private static final String TAG = "CloudAlbumDownloadHeadPicCallable";
    private String cachePath;
    private Context context;
    private ImageView imageView;
    private String traceId = C1122c.m6755Z0("04019");
    private String userId;

    public CloudAlbumDownloadHeadPicCallable(Context context, String str, ImageView imageView) {
        this.context = context;
        this.userId = str;
        this.imageView = imageView;
    }

    private void downloadHeadPic() {
        C0086a c0086aM60455e = C9679b.m60452d().m60455e();
        if (c0086aM60455e == null) {
            C1120a.m6676e(TAG, "downloadHeadPic userClient is null ");
            return;
        }
        try {
            String str = "userId in (" + this.userId + ")";
            UsersListRequest usersListRequest = new UsersListRequest();
            usersListRequest.setQueryParam(str);
            Users.List list = c0086aM60455e.m676c().list(usersListRequest);
            list.setHeader("x-hw-thinsdkapp-version", C1122c.m6833t0(C0213f.m1377a()));
            list.setHeader("x-hw-3rdapp-packagename", "com.huawei.hidisk");
            list.setHeader("x-hw-3rdapp-version", "16.0.0.300");
            list.setHeader("x-hw-trace-id", this.traceId);
            list.setFields2("userList(profilePhotoLink,userId)");
            List<User> userList = list.execute().getUserList();
            if (userList != null && !userList.isEmpty()) {
                User user = userList.get(0);
                if (TextUtils.isEmpty(user.getProfilePhotoLink())) {
                    showDefaultHead();
                } else if (user.getUserId().equals(this.userId)) {
                    downloadUrl(user.getProfilePhotoLink());
                }
            }
        } catch (C4616s e10) {
            C1120a.m6676e(TAG, "downloadHeadPic HttpResponseException " + e10.toString());
        } catch (Exception e11) {
            C1120a.m6676e(TAG, "downloadHeadPic Exception " + e11.toString());
        }
    }

    private void downloadUrl(String str) throws Exception {
        FileOutputStream fileOutputStream;
        InputStream inputStreamM71632s;
        Throwable th2;
        C11922g0 c11922g0;
        if (!C1122c.m6797k(this.cachePath, true)) {
            C1120a.m6678w(TAG, "downloadUrl checkCachePath is invalid ");
            return;
        }
        C1120a.m6675d(TAG, "downloadUrl url: " + str);
        C13356c c13356c = null;
        FileOutputStream fileOutputStreamM63447m = null;
        try {
            C13356c c13356c2 = new C13356c(str, 0L, 0L, this.traceId);
            try {
                C11922g0 c11922g0M80135i = c13356c2.m80135i(null);
                try {
                    inputStreamM71632s = c11922g0M80135i.m71595s().m71632s();
                    try {
                        String str2 = this.cachePath + ".tmp_h";
                        C1122c.m6694F(str2);
                        fileOutputStreamM63447m = C10278a.m63447m(str2, false);
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i10 = inputStreamM71632s.read(bArr);
                            if (i10 == -1) {
                                break;
                            }
                            fileOutputStreamM63447m.write(bArr, 0, i10);
                            fileOutputStreamM63447m.flush();
                        }
                        C1122c.m6735S1(str2, this.cachePath);
                        if (C1122c.m6837u1(this.cachePath)) {
                            C1120a.m6675d(TAG, "download cachePath: " + this.cachePath);
                            if (this.imageView != null) {
                                C12091d.q0 q0Var = new C12091d.q0(C0209d.m1311u(this.cachePath), this.imageView);
                                Activity activityM6730R = C1122c.m6730R(this.imageView);
                                if (activityM6730R != null) {
                                    activityM6730R.runOnUiThread(q0Var);
                                }
                            }
                        }
                        hanfleFinally(c13356c2, fileOutputStreamM63447m, inputStreamM71632s, c11922g0M80135i);
                    } catch (Throwable th3) {
                        th2 = th3;
                        c11922g0 = c11922g0M80135i;
                        fileOutputStream = fileOutputStreamM63447m;
                        c13356c = c13356c2;
                        hanfleFinally(c13356c, fileOutputStream, inputStreamM71632s, c11922g0);
                        throw th2;
                    }
                } catch (Throwable th4) {
                    inputStreamM71632s = null;
                    th2 = th4;
                    c11922g0 = c11922g0M80135i;
                    fileOutputStream = null;
                }
            } catch (Throwable th5) {
                fileOutputStream = null;
                inputStreamM71632s = null;
                th2 = th5;
                c11922g0 = null;
            }
        } catch (Throwable th6) {
            fileOutputStream = null;
            inputStreamM71632s = null;
            th2 = th6;
            c11922g0 = null;
        }
    }

    private void hanfleFinally(C13356c c13356c, OutputStream outputStream, InputStream inputStream, C11922g0 c11922g0) throws IOException {
        if (c13356c != null) {
            c13356c.m80129c();
        }
        if (outputStream != null) {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e10) {
                C1120a.m6676e(TAG, "downloadUrl outputStream close error!error message:" + e10.getMessage());
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e11) {
                C1120a.m6676e(TAG, "downloadUrl inputStream close error,error message:" + e11.getMessage());
            }
        }
        if (c11922g0 != null) {
            c11922g0.close();
        }
    }

    private void showDefaultHead() {
        Activity activityM6730R = C1122c.m6730R(this.imageView);
        if (activityM6730R != null) {
            activityM6730R.runOnUiThread(new C12091d.q0(C1248a.m7477h(activityM6730R.getResources(), R$drawable.img_defaultavatar_list_gray), this.imageView));
        }
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        String str = C11476b.m68626h(this.userId) + CloudAlbumDownloadBabyHeadPicCallable.DEFAULT_HEAD_EXT;
        this.cachePath = C1124e.m6871o(this.context) + "/.cloudShare/thumb/headPic/" + str;
        C1120a.m6675d(TAG, "fileName: " + str + ", cachePath: " + this.cachePath);
        C13576a c13576aM81565a = C13576a.m81565a();
        if (!c13576aM81565a.m81566b(this.cachePath)) {
            C1120a.m6676e(TAG, "download file path repeat.");
            showDefaultHead();
            return null;
        }
        try {
            if (C1122c.m6837u1(this.cachePath)) {
                C1120a.m6675d(TAG, "already exist cachePath: " + this.cachePath);
                if (this.imageView != null) {
                    C12091d.q0 q0Var = new C12091d.q0(C0209d.m1311u(this.cachePath), this.imageView);
                    Activity activityM6730R = C1122c.m6730R(this.imageView);
                    if (activityM6730R != null) {
                        activityM6730R.runOnUiThread(q0Var);
                    }
                }
            } else {
                downloadHeadPic();
            }
            c13576aM81565a.m81568d(this.cachePath);
            return null;
        } catch (Throwable th2) {
            c13576aM81565a.m81568d(this.cachePath);
            throw th2;
        }
    }
}
