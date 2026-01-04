package je;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupSpaceUnEnoughActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudBackupSpaceInsufficientNewActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceGuideActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import p514o9.C11839m;

/* renamed from: je.p */
/* loaded from: classes3.dex */
public class C10802p {
    /* renamed from: a */
    public static Intent m65746a(Context context, String str, String str2) {
        Intent intent;
        intent = new Intent();
        str.hashCode();
        switch (str) {
            case "detail":
                intent.setClass(context, CloudSpaceGuideActivity.class);
                intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
                intent.putExtra("backup_notification_type", 12);
                break;
            case "web":
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str2));
                intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
                break;
            case "close":
                intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 10);
                break;
            case "application":
                if (!NotifyConstants.BUY_MORE.equals(str2)) {
                    break;
                } else {
                    intent.setClass(context, CloudSpaceUpgradeActivity.class);
                    intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 8);
                    break;
                }
            case "detail2":
                intent.setClass(context, CloudBackupSpaceUnEnoughActivity.class);
                intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
                intent.putExtra("backup_notification_type", 13);
                break;
            case "detail3":
                intent.setClass(context, CloudBackupSpaceInsufficientNewActivity.class);
                intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
                intent.putExtra("gotoUri", CloudBackupSpaceInsufficientNewActivity.class.getSimpleName());
                intent.putExtra("backup_notification_type", 15);
                break;
        }
        return intent;
    }

    /* renamed from: b */
    public static Intent m65747b(Context context, String str, Intent intent) {
        Class<?> cls = NotifyConstants.getGotoAppMapping().get(str);
        if (cls != null) {
            intent.setClass(context, cls);
            intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
            return intent;
        }
        C11839m.m70687e("JumpUtil", "no uri match, return null, uri is: " + str);
        return null;
    }
}
