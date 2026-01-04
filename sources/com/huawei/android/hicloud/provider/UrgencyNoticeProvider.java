package com.huawei.android.hicloud.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.huawei.hicloud.notification.HiCloudNotification;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import p015ak.C0209d;
import p514o9.C11839m;
import p674ub.C13152i;

/* loaded from: classes3.dex */
public class UrgencyNoticeProvider extends ContentProvider {

    /* renamed from: a */
    public static final UriMatcher f12718a = new UriMatcher(-1);

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
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
        UriMatcher uriMatcher = f12718a;
        uriMatcher.addURI("com.huawei.android.hicloud.urgencynoticeprovider", "is_urgency_code", 1);
        uriMatcher.addURI("com.huawei.android.hicloud.urgencynoticeprovider", "is_urgency_status", 2);
        uriMatcher.addURI("com.huawei.android.hicloud.urgencynoticeprovider", "content_urgency_ontop", 3);
        uriMatcher.addURI("com.huawei.android.hicloud.urgencynoticeprovider", "execute_notification", 4);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!C0209d.m1247e(getContext())) {
            return null;
        }
        int iMatch = f12718a.match(uri);
        C11839m.m70686d("UrgencyNoticeProvider", "match result: " + iMatch);
        if (iMatch == 1) {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{"urgency_provider_result"});
            matrixCursor.addRow(new Object[]{C13152i.m79070o().m79108u()});
            return matrixCursor;
        }
        if (iMatch == 2) {
            MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{"urgency_provider_result"});
            matrixCursor2.addRow(new Object[]{C13152i.m79070o().m79109v()});
            return matrixCursor2;
        }
        if (iMatch == 3) {
            MatrixCursor matrixCursor3 = new MatrixCursor(new String[]{"urgency_provider_result"});
            matrixCursor3.addRow(new Object[]{C13152i.m79070o().m79090S()});
            return matrixCursor3;
        }
        if (iMatch != 4) {
            return null;
        }
        HiCloudNotification.getInstance().execute(HNConstants.NotifyType.SCENE_HIDISK);
        NotificationReportUtil.reportTriggerSrc("0001");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
