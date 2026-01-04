package com.huawei.android.hicloud.commonlib.helper;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.android.hicloud.commonlib.helper.CheckUpgradeCallBack;
import com.huawei.android.hicloud.commonlib.helper.IHisyncProxyCallBack;
import com.huawei.android.hicloud.commonlib.helper.IsHwIdLoginCallBack;

/* loaded from: classes3.dex */
public interface IHisyncProxyService extends IInterface {

    /* renamed from: com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService$a */
    public static abstract class AbstractBinderC2770a extends Binder implements IHisyncProxyService {
        public AbstractBinderC2770a() {
            attachInterface(this, "com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService");
                return true;
            }
            switch (i10) {
                case 1:
                    boolean zInRestore = inRestore();
                    parcel2.writeNoException();
                    parcel2.writeInt(zInRestore ? 1 : 0);
                    return true;
                case 2:
                    boolean zInBackup = inBackup();
                    parcel2.writeNoException();
                    parcel2.writeInt(zInBackup ? 1 : 0);
                    return true;
                case 3:
                    boolean zInRestoreFirst = inRestoreFirst();
                    parcel2.writeNoException();
                    parcel2.writeInt(zInRestoreFirst ? 1 : 0);
                    return true;
                case 4:
                    startRestoreMainActivity();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    collectOOBEMigrate(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    String hiSyncClass = getHiSyncClass(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(hiSyncClass);
                    return true;
                case 7:
                    boolean zIsModuleEnable = isModuleEnable(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsModuleEnable ? 1 : 0);
                    return true;
                case 8:
                    setModuleEnable(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    boolean autoListBackupOn = setAutoListBackupOn(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(autoListBackupOn ? 1 : 0);
                    return true;
                case 10:
                    HAonPause(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    HAonResume(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    HApageActionEvent(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    HAEventWithInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    HAreportOpenCloudSpace(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    reportCloseCloudBackup();
                    parcel2.writeNoException();
                    return true;
                case 16:
                    initHiAnalyticsUtil(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 17:
                    UBAonResume(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 18:
                    UBAonPause(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 19:
                    UBAEvent(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 20:
                    UBAonEventOnePair(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 21:
                    UBAonPageEvent(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    UBAEventWithInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 23:
                    ifHidePhoneFinderSettingSugg();
                    parcel2.writeNoException();
                    return true;
                case 24:
                    ifShowPhoneFinderSettingSugg();
                    parcel2.writeNoException();
                    return true;
                case 25:
                    boolean zRegisterCallBack = registerCallBack(IHisyncProxyCallBack.AbstractBinderC2768a.m15893a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRegisterCallBack ? 1 : 0);
                    return true;
                case 26:
                    boolean zUnregisterCallBack = unregisterCallBack(IHisyncProxyCallBack.AbstractBinderC2768a.m15893a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zUnregisterCallBack ? 1 : 0);
                    return true;
                case 27:
                    urlsVerifyProcess(IHisyncProxyCallBack.AbstractBinderC2768a.m15893a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 28:
                    scheduleGetConfigJob();
                    parcel2.writeNoException();
                    return true;
                case 29:
                    executeQueryBasicTask(IHisyncProxyCallBack.AbstractBinderC2768a.m15893a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 30:
                    cancelSpaceUsedNotifyTimer();
                    parcel2.writeNoException();
                    return true;
                case 31:
                    setSpaceUsedNotifyTimer(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 32:
                    boolean switchDefaultValue = getSwitchDefaultValue(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchDefaultValue ? 1 : 0);
                    return true;
                case 33:
                    boolean zIsBrowserSupportSyncAbility = isBrowserSupportSyncAbility();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsBrowserSupportSyncAbility ? 1 : 0);
                    return true;
                case 34:
                    setGalleryDefaultValue();
                    parcel2.writeNoException();
                    return true;
                case 35:
                    saveBooleanSp(parcel.readString(), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 36:
                    String oOBEAgreement = getOOBEAgreement(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(oOBEAgreement);
                    return true;
                case 37:
                    saveSwitchStatusAndSync(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 38:
                    checkPushNotifications();
                    parcel2.writeNoException();
                    return true;
                case 39:
                    updateBackupForSetting();
                    parcel2.writeNoException();
                    return true;
                case 40:
                    boolean zIsShowGalleryItemView = isShowGalleryItemView();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsShowGalleryItemView ? 1 : 0);
                    return true;
                case 41:
                    boolean autoListBackupOn2 = getAutoListBackupOn(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(autoListBackupOn2 ? 1 : 0);
                    return true;
                case 42:
                    albumNotifySwitchChanged((Bundle) C2771b.m15897b(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 43:
                    boolean zIsEuropeAccount = isEuropeAccount();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsEuropeAccount ? 1 : 0);
                    return true;
                case 44:
                    processSignAgreement(parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 45:
                    boolean zIsSupportAntiTheft = isSupportAntiTheft();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsSupportAntiTheft ? 1 : 0);
                    return true;
                case 46:
                    oobeBIReport();
                    parcel2.writeNoException();
                    return true;
                case 47:
                    collectEvent(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 48:
                    setAllModuleDisable();
                    parcel2.writeNoException();
                    return true;
                case 49:
                    cloudbackupOpr(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 50:
                    boolean phonefinderSwitch = getPhonefinderSwitch();
                    parcel2.writeNoException();
                    parcel2.writeInt(phonefinderSwitch ? 1 : 0);
                    return true;
                case 51:
                    boolean zIsSendPhoneFinderOning = isSendPhoneFinderOning();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsSendPhoneFinderOning ? 1 : 0);
                    return true;
                case 52:
                    normalBIReport();
                    parcel2.writeNoException();
                    return true;
                case 53:
                    boolean zIsSupportPhoneFinder = isSupportPhoneFinder();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsSupportPhoneFinder ? 1 : 0);
                    return true;
                case 54:
                    report(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 55:
                    writeLastlocSwitchStatusToFile(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 56:
                    openPhoneFinderInBack();
                    parcel2.writeNoException();
                    return true;
                case 57:
                    writeUISwitchToFile();
                    parcel2.writeNoException();
                    return true;
                case 58:
                    clearAllConfig();
                    parcel2.writeNoException();
                    return true;
                case 59:
                    setMrGuide(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 60:
                    reportAppEvent(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 61:
                    boolean zIsHiCloudLogin = isHiCloudLogin();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsHiCloudLogin ? 1 : 0);
                    return true;
                case 62:
                    isHwIdLogin();
                    parcel2.writeNoException();
                    return true;
                case 63:
                    regLoginCallback(IsHwIdLoginCallBack.AbstractBinderC2772a.m15900a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 64:
                    unRegLoginCallback();
                    parcel2.writeNoException();
                    return true;
                case 65:
                    checkUpgrade(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 66:
                    regUpgradeCallback(CheckUpgradeCallBack.AbstractBinderC2764a.m15812a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 67:
                    unRegUpgradeCallback();
                    parcel2.writeNoException();
                    return true;
                case 68:
                    initUnloginOOBETaskChecker();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.commonlib.helper.IHisyncProxyService$b */
    public static class C2771b {
        /* renamed from: b */
        public static <T> T m15897b(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void HAEventWithInfo(String str, String str2, String str3, String str4) throws RemoteException;

    void HAonPause(String str) throws RemoteException;

    void HAonResume(String str) throws RemoteException;

    void HApageActionEvent(String str, String str2) throws RemoteException;

    void HAreportOpenCloudSpace(String str) throws RemoteException;

    void UBAEvent(String str, String str2, String str3, String str4) throws RemoteException;

    void UBAEventWithInfo(String str, String str2, String str3, String str4, String str5, String str6) throws RemoteException;

    void UBAonEventOnePair(String str, String str2, String str3, String str4) throws RemoteException;

    void UBAonPageEvent(String str, String str2, String str3, String str4) throws RemoteException;

    void UBAonPause(String str, String str2, String str3, String str4, int i10) throws RemoteException;

    void UBAonResume(String str, String str2, String str3, String str4) throws RemoteException;

    void albumNotifySwitchChanged(Bundle bundle) throws RemoteException;

    void cancelSpaceUsedNotifyTimer() throws RemoteException;

    void checkPushNotifications() throws RemoteException;

    void checkUpgrade(String str) throws RemoteException;

    void clearAllConfig() throws RemoteException;

    void cloudbackupOpr(boolean z10) throws RemoteException;

    void collectEvent(String str, String str2) throws RemoteException;

    void collectOOBEMigrate(int i10, String str) throws RemoteException;

    void executeQueryBasicTask(IHisyncProxyCallBack iHisyncProxyCallBack, int i10, boolean z10) throws RemoteException;

    boolean getAutoListBackupOn(String str) throws RemoteException;

    String getHiSyncClass(String str) throws RemoteException;

    String getOOBEAgreement(String str) throws RemoteException;

    boolean getPhonefinderSwitch() throws RemoteException;

    boolean getSwitchDefaultValue(String str, boolean z10) throws RemoteException;

    void ifHidePhoneFinderSettingSugg() throws RemoteException;

    void ifShowPhoneFinderSettingSugg() throws RemoteException;

    boolean inBackup() throws RemoteException;

    boolean inRestore() throws RemoteException;

    boolean inRestoreFirst() throws RemoteException;

    void initHiAnalyticsUtil(String str) throws RemoteException;

    void initUnloginOOBETaskChecker() throws RemoteException;

    boolean isBrowserSupportSyncAbility() throws RemoteException;

    boolean isEuropeAccount() throws RemoteException;

    boolean isHiCloudLogin() throws RemoteException;

    void isHwIdLogin() throws RemoteException;

    boolean isModuleEnable(String str) throws RemoteException;

    boolean isSendPhoneFinderOning() throws RemoteException;

    boolean isShowGalleryItemView() throws RemoteException;

    boolean isSupportAntiTheft() throws RemoteException;

    boolean isSupportPhoneFinder() throws RemoteException;

    void normalBIReport() throws RemoteException;

    void oobeBIReport() throws RemoteException;

    void openPhoneFinderInBack() throws RemoteException;

    void processSignAgreement(boolean z10, boolean z11, boolean z12, boolean z13) throws RemoteException;

    void regLoginCallback(IsHwIdLoginCallBack isHwIdLoginCallBack) throws RemoteException;

    void regUpgradeCallback(CheckUpgradeCallBack checkUpgradeCallBack) throws RemoteException;

    boolean registerCallBack(IHisyncProxyCallBack iHisyncProxyCallBack) throws RemoteException;

    void report(String str, boolean z10) throws RemoteException;

    void reportAppEvent(String str) throws RemoteException;

    void reportCloseCloudBackup() throws RemoteException;

    void saveBooleanSp(String str, String str2, boolean z10) throws RemoteException;

    void saveSwitchStatusAndSync(String str) throws RemoteException;

    void scheduleGetConfigJob() throws RemoteException;

    void setAllModuleDisable() throws RemoteException;

    boolean setAutoListBackupOn(String str, boolean z10) throws RemoteException;

    void setGalleryDefaultValue() throws RemoteException;

    void setModuleEnable(String str, boolean z10) throws RemoteException;

    void setMrGuide(boolean z10) throws RemoteException;

    void setSpaceUsedNotifyTimer(boolean z10) throws RemoteException;

    void startRestoreMainActivity() throws RemoteException;

    void unRegLoginCallback() throws RemoteException;

    void unRegUpgradeCallback() throws RemoteException;

    boolean unregisterCallBack(IHisyncProxyCallBack iHisyncProxyCallBack) throws RemoteException;

    void updateBackupForSetting() throws RemoteException;

    void urlsVerifyProcess(IHisyncProxyCallBack iHisyncProxyCallBack) throws RemoteException;

    void writeLastlocSwitchStatusToFile(boolean z10) throws RemoteException;

    void writeUISwitchToFile() throws RemoteException;
}
