package com.huawei.android.hicloud.common.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import java.io.File;
import p015ak.C0209d;
import p015ak.C0210d0;
import p037bp.C1270a;
import p232dp.InterfaceC9287f;
import p514o9.C11835i;
import p514o9.C11839m;
import p709vj.C13452e;
import p846zj.C14306d;

/* loaded from: classes3.dex */
public class FACommonProvider extends ContentProvider {

    /* renamed from: b */
    public static UriMatcher f11946b = new UriMatcher(-1);

    /* renamed from: a */
    public InterfaceC9287f f11947a;

    /* renamed from: a */
    public final boolean m15619a() {
        String callingPackage = getCallingPackage();
        if (TextUtils.isEmpty(callingPackage)) {
            C11839m.m70687e("FACommonProvider", "calling pkg name empty");
            return false;
        }
        if (callingPackage.equals(NotifyConstants.InterfaceC4908FA.PACKAGE_NAME)) {
            return C0210d0.m1338f().m1342c(getContext(), callingPackage, "com.huawei.hidisk");
        }
        C11839m.m70687e("FACommonProvider", "not fa pkg name");
        return false;
    }

    /* renamed from: b */
    public final boolean m15620b(Bundle bundle) {
        if (bundle == null) {
            return true;
        }
        long j10 = bundle.getLong("formId");
        if (this.f11947a == null) {
            this.f11947a = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class);
        }
        return this.f11947a.mo58573p(j10);
    }

    /* renamed from: c */
    public final void m15621c(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        long j10 = bundle.getLong("formId");
        if (this.f11947a == null) {
            this.f11947a = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class);
        }
        this.f11947a.mo58575r(j10);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        Bundle bundle2;
        C11839m.m70686d("FACommonProvider", "call from " + getCallingPackage());
        if (!m15619a()) {
            return null;
        }
        C0209d.m1247e(getContext());
        bundle2 = new Bundle();
        str.hashCode();
        switch (str) {
            case "get_locate_interval":
                if (this.f11947a == null) {
                    this.f11947a = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class);
                }
                bundle2.putLong("locateInterval", this.f11947a.mo58549L());
                return bundle2;
            case "locate_sender":
                if (C13452e.m80781L().m80842P0() && C14306d.m85207h()) {
                    m15623e(bundle);
                }
                return bundle2;
            case "delete_form":
                m15621c(bundle);
                return bundle2;
            case "touch_uri":
                C11839m.m70688i("FACommonProvider", "touch_uri");
                if (bundle != null) {
                    m15624f(bundle.getString("mapUri"));
                    m15624f(bundle.getString("avatarUri"));
                }
                return bundle2;
            case "get_user_name":
                bundle2.putString(HwPayConstant.KEY_USER_NAME, m15622d(bundle));
                return bundle2;
            case "get_is_cn":
                if (!C13452e.m80781L().m80842P0() || !C14306d.m85207h()) {
                    bundle2.putBoolean("isCN", false);
                }
                return bundle2;
            case "calc_sender":
                if (C13452e.m80781L().m80842P0() && C14306d.m85207h()) {
                    bundle2.putBoolean("hasForm", m15620b(bundle));
                } else {
                    bundle2.putBoolean("isCN", false);
                }
                return bundle2;
            default:
                return bundle2;
        }
    }

    /* renamed from: d */
    public final String m15622d(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        long j10 = bundle.getLong("formId");
        if (this.f11947a == null) {
            this.f11947a = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class);
        }
        return this.f11947a.mo58578u(j10);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    /* renamed from: e */
    public final void m15623e(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        long j10 = bundle.getLong("formId");
        boolean z10 = bundle.getBoolean("notifyLocate");
        if (this.f11947a == null) {
            this.f11947a = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class);
        }
        this.f11947a.mo58583z(j10, z10);
    }

    /* renamed from: f */
    public final void m15624f(String str) {
        if (str != null) {
            Uri uri = Uri.parse(str);
            String strSubstring = uri.getPath().substring(5);
            File file = new File(strSubstring);
            if (strSubstring.startsWith(C11835i.m70649m(getContext()).getPath()) && file.exists() && file.length() <= 4194304) {
                getContext().grantUriPermission(NotifyConstants.InterfaceC4908FA.PACKAGE_NAME, uri, 3);
            }
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        f11946b.addURI("com.huawei.android.hicloud.HwCloudDriveFAProvider", CloudBackupConstant.Command.PMS_CMD_BACKUP, 1);
        f11946b.addURI("com.huawei.android.hicloud.HwCloudDriveFAProvider", "clouddisk", 2);
        f11946b.addURI("com.huawei.android.hicloud.HwCloudDriveFAProvider", "phonefinder", 3);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        C11839m.m70686d("FACommonProvider", "query from " + getCallingPackage());
        if (!m15619a()) {
            return null;
        }
        C0209d.m1247e(getContext());
        int iMatch = f11946b.match(uri);
        if (iMatch == 1) {
            C11839m.m70688i("FACommonProvider", "URI_MATCH_BACKUP");
        } else if (iMatch == 2) {
            C11839m.m70688i("FACommonProvider", "URI_MATCH_CLOUDDISK");
        } else if (iMatch == 3) {
            C11839m.m70688i("FACommonProvider", "URI_MATCH_PHONEFINDER");
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
