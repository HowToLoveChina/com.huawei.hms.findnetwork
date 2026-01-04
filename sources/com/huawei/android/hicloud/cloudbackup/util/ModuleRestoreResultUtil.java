package com.huawei.android.hicloud.cloudbackup.util;

import android.app.Activity;
import android.content.Context;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.cloudbackup.model.RestoreStatus;
import p514o9.C11839m;
import p618rm.C12590s0;
import p709vj.C13452e;
import p783xp.C13843a;

/* loaded from: classes2.dex */
public class ModuleRestoreResultUtil {
    private static final String TAG = "ModuleRestoreResultUtil";

    private static String getDefaultTips(Context context, CloudRestoreItem cloudRestoreItem) {
        int count = cloudRestoreItem.getCount();
        int current = cloudRestoreItem.getCurrent();
        return cloudRestoreItem.isSystemShowModule() ? count > 0 ? getWaitingTips(context, cloudRestoreItem, count, context.getString(R$string.cloudbackup_backupmedia_tip, C13843a.m83104z(Integer.valueOf(current)), C13843a.m83104z(Integer.valueOf(count)))) : context.getString(R$string.restore_new_wait_2) : (cloudRestoreItem.isVirtual() || cloudRestoreItem.is3rdAppType() || count == 0) ? context.getString(R$string.restore_new_wait_2) : getWaitingTips(context, cloudRestoreItem, count, context.getString(R$string.cloudbackup_backupmedia_tip, C13843a.m83104z(Integer.valueOf(current)), C13843a.m83104z(Integer.valueOf(count))));
    }

    private static String getRestoreFailedTips(Context context, CloudRestoreItem cloudRestoreItem) {
        int count = cloudRestoreItem.getCount();
        int current = cloudRestoreItem.getCurrent();
        return cloudRestoreItem.is3rdAppType() ? context.getString(R$string.restore_completed_not_succeed) : (count < current || cloudRestoreItem.isVirtual()) ? context.getString(R$string.restore_completed_not_succeed) : current > 0 ? context.getString(R$string.restore_completed_not_succeed_part) : context.getString(R$string.restore_completed_not_succeed);
    }

    private static String getRestorePrepareFailedTips(Context context, CloudRestoreItem cloudRestoreItem) {
        return (cloudRestoreItem.getCurrent() <= 0 || cloudRestoreItem.getCount() <= 0) ? context.getString(R$string.restore_failed) : context.getString(R$string.restore_partial_fail);
    }

    public static String getRestoreResultTips(Context context, CloudRestoreItem cloudRestoreItem) {
        if (context == null) {
            C11839m.m70689w(TAG, "context is null");
            return "";
        }
        if (cloudRestoreItem == null) {
            C11839m.m70689w(TAG, "restoreItem is null");
            return "";
        }
        int status = cloudRestoreItem.getStatus();
        String appId = cloudRestoreItem.getAppId();
        C11839m.m70689w(TAG, "getRestoreResultTips appid: " + appId + "; status: " + status);
        if (context instanceof Activity) {
            String strM75742F = C12590s0.m75742F((Activity) context, appId);
            if (!strM75742F.equals("")) {
                return context.getString(R$string.hicloud_restore_permission_disabled, strM75742F);
            }
        }
        if (status == 8) {
            if (cloudRestoreItem.getType() == 1) {
                return getSuccessTips(context, cloudRestoreItem);
            }
            int iM80916g0 = C13452e.m80781L().m80916g0();
            return (iM80916g0 == 5 || iM80916g0 == 8) ? getRestorePrepareFailedTips(context, cloudRestoreItem) : getRestoreFailedTips(context, cloudRestoreItem);
        }
        switch (status) {
            case -3:
                if (!RestoreUtil.isHiCreatePromptNotSupportRestore(cloudRestoreItem)) {
                    break;
                } else {
                    break;
                }
            case -1:
                int i10 = R$string.restore_new_recovery_not_supported;
                if (cloudRestoreItem.is3rdAppType() && cloudRestoreItem.m29187M()) {
                    i10 = R$string.cloudbackup_app_restore_failed_no_retry;
                }
                break;
        }
        return "";
    }

    private static String getSuccessTips(Context context, CloudRestoreItem cloudRestoreItem) {
        int current = cloudRestoreItem.getCurrent();
        int count = cloudRestoreItem.getCount();
        if ((cloudRestoreItem.isSystemShowModule() && current == 0) || cloudRestoreItem.isVirtual()) {
            return context.getString(R$string.restore_new_completed);
        }
        if (cloudRestoreItem.is3rdAppType()) {
            return cloudRestoreItem.getAction() == 1 ? context.getString(R$string.cloudbackup_app_restore_failed_no_retry) : context.getString(R$string.restore_new_completed);
        }
        if ("sysdata".equals(cloudRestoreItem.getAppId())) {
            return context.getResources().getString(R$string.restore_new_completed_part, context.getResources().getQuantityString(R$plurals.backup_backed_total, current, Integer.valueOf(current), Integer.valueOf(count)).replace(String.valueOf(current), C13843a.m83104z(Integer.valueOf(current))).replace(String.valueOf(count), C13843a.m83104z(Integer.valueOf(count))));
        }
        if (!"thirdApp".equals(cloudRestoreItem.getAppId()) && current != 0) {
            return context.getResources().getQuantityString(R$plurals.restore_new_completed_part_2, current, Integer.valueOf(current)).replace(String.valueOf(current), C13843a.m83104z(Integer.valueOf(current)));
        }
        return context.getString(R$string.restore_new_completed);
    }

    public static String getWaitingTips(Context context, RestoreStatus restoreStatus, int i10, String str) {
        if (context == null || restoreStatus == null) {
            return "";
        }
        if (!restoreStatus.isShowChildList() && restoreStatus.isHarmonyNext()) {
            return context.getString(R$string.restore_new_wait_2);
        }
        return context.getResources().getQuantityString(R$plurals.restore_new_wait_1, i10, str);
    }

    public static boolean isModuleRestoring(CloudRestoreItem cloudRestoreItem) {
        if (cloudRestoreItem == null) {
            return false;
        }
        return cloudRestoreItem.getStatus() == 3 || cloudRestoreItem.getStatus() == 4 || cloudRestoreItem.getStatus() == 5 || cloudRestoreItem.getStatus() == 6 || cloudRestoreItem.getStatus() == 7;
    }
}
