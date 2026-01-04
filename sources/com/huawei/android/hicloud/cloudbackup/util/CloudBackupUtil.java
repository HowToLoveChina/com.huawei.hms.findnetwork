package com.huawei.android.hicloud.cloudbackup.util;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.BackupMemberPrivilege;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.manager.DeviceIconManager;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Device;
import com.huawei.hicloud.request.basic.bean.VisionDeviceInfo;
import com.huawei.hicloud.request.basic.bean.VisionDeviceRsp;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import io.C10582a;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p015ak.C0209d;
import p514o9.C11839m;
import p617rl.C12526j;
import p626ry.C12652a;
import p626ry.C12653b;
import p709vj.C13452e;
import p815ym.AbstractC14026a;

/* loaded from: classes2.dex */
public class CloudBackupUtil {
    private static final String TAG = "CloudBackupUtil";

    public static Device downloadCurrentDeviceInfo() {
        C10582a c10582a = new C10582a(null);
        new VisionDeviceRsp();
        Device device = new Device();
        try {
            C11839m.m70688i(TAG, "downloadCurrentDeviceInfo start ");
            VisionDeviceRsp visionDeviceRspM64931d = c10582a.m64931d();
            if (!C12652a.m76180b(visionDeviceRspM64931d) && !C12652a.m76180b(visionDeviceRspM64931d.getDeviceList())) {
                Iterator<VisionDeviceInfo> it = visionDeviceRspM64931d.getDeviceList().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    VisionDeviceInfo next = it.next();
                    C11839m.m70686d(TAG, "all device terminalType : " + next.getTerminalType());
                    if (C12653b.m76181a(next.getDeviceID(), C13452e.m80781L().m80950o())) {
                        String str = next.getImageUrlHosts().getPrimary() + next.getProdImageList().get(0).getUrlPath();
                        String terminalType = next.getTerminalType();
                        String deviceCategory = next.getDeviceCategory();
                        device.setTerminalType(terminalType);
                        device.setDeviceCategory(deviceCategory);
                        HashMap<String, String> map = new HashMap<>();
                        C11839m.m70688i(TAG, "cur device terminalType : " + terminalType + ", deivceIconUrl : " + str);
                        if (!C12653b.m76182b(terminalType) && !C12653b.m76182b(str)) {
                            map.put(terminalType, str);
                        }
                        if (!C12652a.m76180b(map)) {
                            DeviceIconManager.getInstance().downloadDeviceIcon(map);
                        }
                    }
                }
                return device;
            }
            C11839m.m70687e(TAG, "downloadCurrentDeviceInfo error : visionDeviceRsp error ");
            return device;
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "downloadCurrentDeviceInfo failed and exception msg is: " + e10.toString());
            return device;
        }
    }

    public static String getBackupDeviceIconRootPath(Context context) {
        if (context == null) {
            C11839m.m70687e(TAG, "getBackupDeviceIconRootPath: context is null");
            return null;
        }
        File fileM63442h = C10278a.m63442h(context.getFilesDir() + "/cloudbackupdeviceicon/");
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C11839m.m70687e(TAG, "Failed to create backup directory: " + C10279b.m63452a(fileM63442h));
            return null;
        }
        String strM63452a = C10279b.m63452a(fileM63442h);
        String str = File.separator;
        if (strM63452a.endsWith(str)) {
            return strM63452a;
        }
        return strM63452a + str;
    }

    private static List<BackupMemberPrivilege.AutoBackupFrequency> getDefaultAutoBackupFrequencies() {
        ArrayList arrayList = new ArrayList();
        BackupMemberPrivilege.AutoBackupFrequency autoBackupFrequency = new BackupMemberPrivilege.AutoBackupFrequency();
        autoBackupFrequency.setIndex(0);
        autoBackupFrequency.setFrequencyLevel(1);
        autoBackupFrequency.setGradeCode(new ArrayList(Arrays.asList("D", CloudBackupConstant.UserPackageInfo.FULL_DATA_SERVICE_2048GB, "Q", "NQ", "K", "NK")));
        arrayList.add(autoBackupFrequency);
        BackupMemberPrivilege.AutoBackupFrequency autoBackupFrequency2 = new BackupMemberPrivilege.AutoBackupFrequency();
        autoBackupFrequency2.setIndex(1);
        autoBackupFrequency2.setFrequencyLevel(2);
        autoBackupFrequency2.setGradeCode(new ArrayList(Arrays.asList(CloudBackupConstant.UserPackageInfo.GOLD_MEMBER, CloudBackupConstant.UserPackageInfo.FULL_DATA_SERVICE_200GB)));
        arrayList.add(autoBackupFrequency2);
        BackupMemberPrivilege.AutoBackupFrequency autoBackupFrequency3 = new BackupMemberPrivilege.AutoBackupFrequency();
        autoBackupFrequency3.setIndex(2);
        autoBackupFrequency3.setFrequencyLevel(3);
        autoBackupFrequency3.setGradeCode(new ArrayList(Arrays.asList(CloudBackupConstant.UserPackageInfo.SILVER_MEMBER, CloudBackupConstant.UserPackageInfo.FULL_DATA_SERVICE_50GB)));
        arrayList.add(autoBackupFrequency3);
        BackupMemberPrivilege.AutoBackupFrequency autoBackupFrequency4 = new BackupMemberPrivilege.AutoBackupFrequency();
        autoBackupFrequency4.setIndex(3);
        autoBackupFrequency4.setFrequencyLevel(4);
        autoBackupFrequency4.setGradeCode(new ArrayList(Arrays.asList("N", CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE)));
        arrayList.add(autoBackupFrequency4);
        return arrayList;
    }

    public static String getDeviceDisplayName(Context context, CloudRecoveryItem cloudRecoveryItem) {
        if (context == null || cloudRecoveryItem == null) {
            return "";
        }
        return C0209d.m1232a0(TextUtils.isEmpty(cloudRecoveryItem.getDevDisplayName()) ? TextUtils.isEmpty(cloudRecoveryItem.getDeviceName()) ? cloudRecoveryItem.isCurrent() ? C0209d.m1171G() : context.getString(R$string.setting_other) : cloudRecoveryItem.getDeviceName() : cloudRecoveryItem.getDevDisplayName());
    }

    public static Map<String, Integer> getGradeAllFrequency() {
        List<String> gradeCode;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<BackupMemberPrivilege.AutoBackupFrequency> autoBackupFrequency = new C12526j().m75403l().getAutoBackupFrequency();
        if (AbstractC14026a.m84159a(autoBackupFrequency)) {
            autoBackupFrequency = getDefaultAutoBackupFrequencies();
        }
        try {
            autoBackupFrequency.sort(Comparator.comparingInt(new C2734s()));
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "getGradeAllFrequency, sort failed, e: " + e10.getMessage());
        }
        for (BackupMemberPrivilege.AutoBackupFrequency autoBackupFrequency2 : autoBackupFrequency) {
            if (autoBackupFrequency2 != null && (gradeCode = autoBackupFrequency2.getGradeCode()) != null) {
                CloudBackupConstant.BackupFrequency frequencyLevel = CloudBackupConstant.BackupFrequency.getFrequencyLevel(autoBackupFrequency2.getFrequencyLevel());
                Iterator<String> it = gradeCode.iterator();
                while (it.hasNext()) {
                    linkedHashMap.put(it.next(), Integer.valueOf(frequencyLevel.frequency));
                }
            }
        }
        return linkedHashMap;
    }

    public static int getGradeMinFrequency(String str) {
        List<BackupMemberPrivilege.AutoBackupFrequency> autoBackupFrequency = new C12526j().m75403l().getAutoBackupFrequency();
        if (AbstractC14026a.m84159a(autoBackupFrequency)) {
            autoBackupFrequency = getDefaultAutoBackupFrequencies();
        }
        try {
            autoBackupFrequency.sort(Comparator.comparingInt(new C2734s()));
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "getGradeMinFrequency, sort failed, e: " + e10.getMessage());
        }
        CloudBackupConstant.BackupFrequency frequencyLevel = CloudBackupConstant.BackupFrequency.FREQUENCY_7;
        for (BackupMemberPrivilege.AutoBackupFrequency autoBackupFrequency2 : autoBackupFrequency) {
            if (autoBackupFrequency2 != null) {
                List<String> gradeCode = autoBackupFrequency2.getGradeCode();
                if (!AbstractC14026a.m84159a(gradeCode)) {
                    int frequencyLevel2 = autoBackupFrequency2.getFrequencyLevel();
                    if (gradeCode.contains(str)) {
                        frequencyLevel = CloudBackupConstant.BackupFrequency.getFrequencyLevel(frequencyLevel2);
                    }
                }
            }
        }
        return frequencyLevel.frequency;
    }
}
