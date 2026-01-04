package com.huawei.android.hicloud.album.service;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.android.hicloud.album.service.ICloudAlbumSdkServiceCallback;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.GeneralAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.RiskInform;
import com.huawei.android.hicloud.album.service.p075vo.SettingParams;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.ShareReceiverData;
import com.huawei.android.hicloud.album.service.p075vo.SimplifyInfo;
import com.huawei.android.hicloud.album.service.p075vo.SmartAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.SmartTagData;
import com.huawei.android.hicloud.album.service.p075vo.Stat;
import com.huawei.android.hicloud.album.service.p075vo.SyncPrompt;
import com.huawei.android.hicloud.album.service.p075vo.UserSpace;
import java.util.List;

/* loaded from: classes2.dex */
public interface ICloudAlbumSdkService extends IInterface {

    public static abstract class Stub extends Binder implements ICloudAlbumSdkService {
        static final int TRANSACTION_addShareReceiver = 46;
        static final int TRANSACTION_cancelDownload = 35;
        static final int TRANSACTION_cancelDownloadAll = 38;
        static final int TRANSACTION_cancelReceivedShare = 49;
        static final int TRANSACTION_cancelUploadTask = 76;
        static final int TRANSACTION_checkAccount = 45;
        static final int TRANSACTION_closeAlbumSwitch = 69;
        static final int TRANSACTION_copyGeneralFiles = 68;
        static final int TRANSACTION_createBatch = 28;
        static final int TRANSACTION_createGeneralAlbums = 22;
        static final int TRANSACTION_createGeneralFiles = 27;
        static final int TRANSACTION_createShareAlbum = 44;
        static final int TRANSACTION_createShareFiles = 29;
        static final int TRANSACTION_createShortLink = 50;
        static final int TRANSACTION_deleteDownloadHistory = 42;
        static final int TRANSACTION_deleteDownloadHistoryAll = 43;
        static final int TRANSACTION_deleteGeneralAlbums = 25;
        static final int TRANSACTION_deleteGeneralFiles = 31;
        static final int TRANSACTION_deleteShareAlbum = 26;
        static final int TRANSACTION_deleteShareFiles = 32;
        static final int TRANSACTION_destroyGeneralTasks = 62;
        static final int TRANSACTION_destroyShareTasks = 63;
        static final int TRANSACTION_downloadAvatar = 53;
        static final int TRANSACTION_downloadGeneralFiles = 20;
        static final int TRANSACTION_downloadShareFiles = 21;
        static final int TRANSACTION_dropDownloadFileInfo = 79;
        static final int TRANSACTION_getAllGeneralFiles = 16;
        static final int TRANSACTION_getAllShareFiles = 17;
        static final int TRANSACTION_getAllSimplifyInfo = 83;
        static final int TRANSACTION_getAllTagFiles = 60;
        static final int TRANSACTION_getAvatarInfo = 52;
        static final int TRANSACTION_getCategoryInfoList = 58;
        static final int TRANSACTION_getChangeTagFiles = 61;
        static final int TRANSACTION_getChangedGeneralFiles = 18;
        static final int TRANSACTION_getChangedShareFiles = 19;
        static final int TRANSACTION_getDetailedInfo = 84;
        static final int TRANSACTION_getDeviceInfoListAsync = 87;
        static final int TRANSACTION_getDownloadFileCount = 39;
        static final int TRANSACTION_getDownloadFileStatus = 40;
        static final int TRANSACTION_getDownloadFileStatusLimit = 41;
        static final int TRANSACTION_getFileTransferStatus = 6;
        static final int TRANSACTION_getGeneralAlbumVersion = 7;
        static final int TRANSACTION_getGeneralAlbums = 13;
        static final int TRANSACTION_getGroupAlbums = 15;
        static final int TRANSACTION_getGroupMemberInfoList = 56;
        static final int TRANSACTION_getServerTime = 12;
        static final int TRANSACTION_getSessionId = 64;
        static final int TRANSACTION_getShareAlbumVersion = 8;
        static final int TRANSACTION_getShareAlbums = 14;
        static final int TRANSACTION_getShareGroupList = 65;
        static final int TRANSACTION_getSnsGroups = 55;
        static final int TRANSACTION_getSyncLock = 9;
        static final int TRANSACTION_getSyncStrategyState = 3;
        static final int TRANSACTION_getTagInfo = 59;
        static final int TRANSACTION_getTagTransferStatus = 78;
        static final int TRANSACTION_getTagVersion = 57;
        static final int TRANSACTION_getUsedPower = 90;
        static final int TRANSACTION_getVideoPlayUrlAsync = 86;
        static final int TRANSACTION_isSupportSns = 54;
        static final int TRANSACTION_keepSyncLock = 10;
        static final int TRANSACTION_modifyGeneralAlbums = 23;
        static final int TRANSACTION_modifyGeneralFiles = 30;
        static final int TRANSACTION_modifyShareAlbum = 24;
        static final int TRANSACTION_modifyShareAlbumData = 89;
        static final int TRANSACTION_modifyShareAlbumPrivilege = 51;
        static final int TRANSACTION_pauseDownload = 34;
        static final int TRANSACTION_pauseDownloadAll = 37;
        static final int TRANSACTION_queryDisableState = 73;
        static final int TRANSACTION_queryDisuseState = 70;
        static final int TRANSACTION_queryUserSpace = 72;
        static final int TRANSACTION_queryUserSpaceSync = 85;
        static final int TRANSACTION_reLogin = 75;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_releaseSyncLock = 11;
        static final int TRANSACTION_removeShareReceiver = 47;
        static final int TRANSACTION_report = 82;
        static final int TRANSACTION_reportRisks = 88;
        static final int TRANSACTION_reportTagTransferStatus = 77;
        static final int TRANSACTION_request = 80;
        static final int TRANSACTION_setAidlVersion = 67;
        static final int TRANSACTION_setAlbumProperties = 4;
        static final int TRANSACTION_shareResultConfirm = 48;
        static final int TRANSACTION_startDownload = 33;
        static final int TRANSACTION_startDownloadAll = 36;
        static final int TRANSACTION_startDownloadFile = 81;
        static final int TRANSACTION_syncOpsReport = 66;
        static final int TRANSACTION_unregisterCallback = 2;
        static final int TRANSACTION_updateDownloadStatus = 71;
        static final int TRANSACTION_updateSaveOriginalStatus = 74;
        static final int TRANSACTION_updateSyncPrompt = 5;

        /* renamed from: com.huawei.android.hicloud.album.service.ICloudAlbumSdkService$Stub$a */
        public static class C2410a implements ICloudAlbumSdkService {

            /* renamed from: a */
            public IBinder f11511a;

            public C2410a(IBinder iBinder) {
                this.f11511a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11511a;
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.android.hicloud.album.service.ICloudAlbumSdkService");
        }

        public static ICloudAlbumSdkService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.hicloud.album.service.ICloudAlbumSdkService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICloudAlbumSdkService)) ? new C2410a(iBinder) : (ICloudAlbumSdkService) iInterfaceQueryLocalInterface;
        }

        public abstract /* synthetic */ int addShareReceiver(ShareAlbumData shareAlbumData, List list) throws RemoteException;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public abstract /* synthetic */ int cancelDownload(List list) throws RemoteException;

        public abstract /* synthetic */ int cancelDownloadAll() throws RemoteException;

        public abstract /* synthetic */ int cancelReceivedShare(ShareAlbumData shareAlbumData) throws RemoteException;

        public abstract /* synthetic */ int cancelUploadTask(String str) throws RemoteException;

        public abstract /* synthetic */ int checkAccount(List list) throws RemoteException;

        public abstract /* synthetic */ void closeAlbumSwitch() throws RemoteException;

        public abstract /* synthetic */ int copyGeneralFiles(List list, String str, String str2, long j10, long j11) throws RemoteException;

        public abstract /* synthetic */ int createBatch(String str, String str2, String str3) throws RemoteException;

        public abstract /* synthetic */ int createGeneralAlbums(List list, String str, String str2) throws RemoteException;

        public abstract /* synthetic */ int createGeneralFiles(List list, String str, boolean z10, String str2) throws RemoteException;

        public abstract /* synthetic */ int createShareAlbum(ShareAlbumData shareAlbumData) throws RemoteException;

        public abstract /* synthetic */ int createShareFiles(List list, boolean z10, String str) throws RemoteException;

        public abstract /* synthetic */ int createShortLink(String str) throws RemoteException;

        public abstract /* synthetic */ int deleteDownloadHistory(List list) throws RemoteException;

        public abstract /* synthetic */ int deleteDownloadHistoryAll(int i10) throws RemoteException;

        public abstract /* synthetic */ int deleteGeneralAlbums(List list, String str, String str2) throws RemoteException;

        public abstract /* synthetic */ int deleteGeneralFiles(List list, String str, String str2) throws RemoteException;

        public abstract /* synthetic */ int deleteShareAlbum(ShareAlbumData shareAlbumData, String str) throws RemoteException;

        public abstract /* synthetic */ int deleteShareFiles(String str, String str2, List list, String str3) throws RemoteException;

        public abstract /* synthetic */ int destroyGeneralTasks(int i10, int i11) throws RemoteException;

        public abstract /* synthetic */ int destroyShareTasks(int i10, int i11) throws RemoteException;

        public abstract /* synthetic */ int downloadAvatar(List list) throws RemoteException;

        public abstract /* synthetic */ int downloadGeneralFiles(List list, int i10, int i11, boolean z10, boolean z11, String str) throws RemoteException;

        public abstract /* synthetic */ int downloadShareFiles(List list, int i10, int i11, boolean z10, boolean z11, String str) throws RemoteException;

        public abstract /* synthetic */ int dropDownloadFileInfo() throws RemoteException;

        public abstract /* synthetic */ int getAllGeneralFiles(List list, int i10, int i11, String str) throws RemoteException;

        public abstract /* synthetic */ int getAllShareFiles(ShareAlbumData shareAlbumData, int i10, String str) throws RemoteException;

        public abstract /* synthetic */ int getAllSimplifyInfo(String str, List list, int i10, int i11, String str2) throws RemoteException;

        public abstract /* synthetic */ int getAllTagFiles(SmartTagData smartTagData, String str, String str2) throws RemoteException;

        public abstract /* synthetic */ int getAvatarInfo(List list) throws RemoteException;

        public abstract /* synthetic */ int getCategoryInfoList(String str) throws RemoteException;

        public abstract /* synthetic */ int getChangeTagFiles(SmartTagData smartTagData, String str, String str2) throws RemoteException;

        public abstract /* synthetic */ int getChangedGeneralFiles(List list, long j10, int i10, String str, String str2) throws RemoteException;

        public abstract /* synthetic */ int getChangedShareFiles(ShareAlbumData shareAlbumData, String str, String str2) throws RemoteException;

        public abstract /* synthetic */ int getDetailedInfo(String str, List list, boolean z10) throws RemoteException;

        public abstract /* synthetic */ int getDeviceInfoListAsync() throws RemoteException;

        public abstract /* synthetic */ int getDownloadFileCount(int i10) throws RemoteException;

        public abstract /* synthetic */ List getDownloadFileStatus(List list) throws RemoteException;

        public abstract /* synthetic */ List getDownloadFileStatusLimit(int i10, int i11, int i12) throws RemoteException;

        public abstract /* synthetic */ int getFileTransferStatus(String str) throws RemoteException;

        public abstract /* synthetic */ int getGeneralAlbumVersion(String str) throws RemoteException;

        public abstract /* synthetic */ int getGeneralAlbums(String str) throws RemoteException;

        public abstract /* synthetic */ int getGroupAlbums(String str) throws RemoteException;

        public abstract /* synthetic */ List getGroupMemberInfoList(String str) throws RemoteException;

        public abstract /* synthetic */ int getServerTime() throws RemoteException;

        public abstract /* synthetic */ String getSessionId(int i10, int i11) throws RemoteException;

        public abstract /* synthetic */ int getShareAlbumVersion(String str) throws RemoteException;

        public abstract /* synthetic */ int getShareAlbums(String str) throws RemoteException;

        public abstract /* synthetic */ List getShareGroupList() throws RemoteException;

        public abstract /* synthetic */ String[] getSnsGroups() throws RemoteException;

        public abstract /* synthetic */ int getSyncLock(String str) throws RemoteException;

        public abstract /* synthetic */ int getSyncStrategyState() throws RemoteException;

        public abstract /* synthetic */ int getTagInfo(SmartAlbumData smartAlbumData, String str, String str2) throws RemoteException;

        public abstract /* synthetic */ int getTagTransferStatus() throws RemoteException;

        public abstract /* synthetic */ int getTagVersion(String str) throws RemoteException;

        public abstract /* synthetic */ Bundle getUsedPower() throws RemoteException;

        public abstract /* synthetic */ int getVideoPlayUrlAsync(FileData fileData) throws RemoteException;

        public abstract /* synthetic */ boolean isSupportSns() throws RemoteException;

        public abstract /* synthetic */ int keepSyncLock(String str, String str2) throws RemoteException;

        public abstract /* synthetic */ int modifyGeneralAlbums(List list, String str, String str2) throws RemoteException;

        public abstract /* synthetic */ int modifyGeneralFiles(List list, String str, String str2) throws RemoteException;

        public abstract /* synthetic */ int modifyShareAlbum(ShareAlbumData shareAlbumData, String str) throws RemoteException;

        public abstract /* synthetic */ int modifyShareAlbumData(ShareAlbumData shareAlbumData) throws RemoteException;

        public abstract /* synthetic */ int modifyShareAlbumPrivilege(String str, int i10) throws RemoteException;

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.huawei.android.hicloud.album.service.ICloudAlbumSdkService");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.android.hicloud.album.service.ICloudAlbumSdkService");
                return true;
            }
            switch (i10) {
                case 1:
                    boolean zRegisterCallback = registerCallback(ICloudAlbumSdkServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRegisterCallback ? 1 : 0);
                    return true;
                case 2:
                    unregisterCallback(ICloudAlbumSdkServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    int syncStrategyState = getSyncStrategyState();
                    parcel2.writeNoException();
                    parcel2.writeInt(syncStrategyState);
                    return true;
                case 4:
                    int albumProperties = setAlbumProperties((SettingParams) C2411a.m15038d(parcel, SettingParams.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(albumProperties);
                    return true;
                case 5:
                    int iUpdateSyncPrompt = updateSyncPrompt((SyncPrompt) C2411a.m15038d(parcel, SyncPrompt.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iUpdateSyncPrompt);
                    return true;
                case 6:
                    int fileTransferStatus = getFileTransferStatus(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(fileTransferStatus);
                    return true;
                case 7:
                    int generalAlbumVersion = getGeneralAlbumVersion(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(generalAlbumVersion);
                    return true;
                case 8:
                    int shareAlbumVersion = getShareAlbumVersion(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(shareAlbumVersion);
                    return true;
                case 9:
                    int syncLock = getSyncLock(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(syncLock);
                    return true;
                case 10:
                    int iKeepSyncLock = keepSyncLock(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iKeepSyncLock);
                    return true;
                case 11:
                    int iReleaseSyncLock = releaseSyncLock(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iReleaseSyncLock);
                    return true;
                case 12:
                    int serverTime = getServerTime();
                    parcel2.writeNoException();
                    parcel2.writeInt(serverTime);
                    return true;
                case 13:
                    int generalAlbums = getGeneralAlbums(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(generalAlbums);
                    return true;
                case 14:
                    int shareAlbums = getShareAlbums(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(shareAlbums);
                    return true;
                case 15:
                    int groupAlbums = getGroupAlbums(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(groupAlbums);
                    return true;
                case 16:
                    int allGeneralFiles = getAllGeneralFiles(parcel.createStringArrayList(), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(allGeneralFiles);
                    return true;
                case 17:
                    int allShareFiles = getAllShareFiles((ShareAlbumData) C2411a.m15038d(parcel, ShareAlbumData.CREATOR), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(allShareFiles);
                    return true;
                case 18:
                    int changedGeneralFiles = getChangedGeneralFiles(parcel.createStringArrayList(), parcel.readLong(), parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(changedGeneralFiles);
                    return true;
                case 19:
                    int changedShareFiles = getChangedShareFiles((ShareAlbumData) C2411a.m15038d(parcel, ShareAlbumData.CREATOR), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(changedShareFiles);
                    return true;
                case 20:
                    int iDownloadGeneralFiles = downloadGeneralFiles(parcel.createTypedArrayList(FileData.CREATOR), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iDownloadGeneralFiles);
                    return true;
                case 21:
                    int iDownloadShareFiles = downloadShareFiles(parcel.createTypedArrayList(FileData.CREATOR), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iDownloadShareFiles);
                    return true;
                case 22:
                    int iCreateGeneralAlbums = createGeneralAlbums(parcel.createTypedArrayList(GeneralAlbumData.CREATOR), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iCreateGeneralAlbums);
                    return true;
                case 23:
                    int iModifyGeneralAlbums = modifyGeneralAlbums(parcel.createTypedArrayList(GeneralAlbumData.CREATOR), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iModifyGeneralAlbums);
                    return true;
                case 24:
                    int iModifyShareAlbum = modifyShareAlbum((ShareAlbumData) C2411a.m15038d(parcel, ShareAlbumData.CREATOR), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iModifyShareAlbum);
                    return true;
                case 25:
                    int iDeleteGeneralAlbums = deleteGeneralAlbums(parcel.createStringArrayList(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iDeleteGeneralAlbums);
                    return true;
                case 26:
                    int iDeleteShareAlbum = deleteShareAlbum((ShareAlbumData) C2411a.m15038d(parcel, ShareAlbumData.CREATOR), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iDeleteShareAlbum);
                    return true;
                case 27:
                    int iCreateGeneralFiles = createGeneralFiles(parcel.createTypedArrayList(FileData.CREATOR), parcel.readString(), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iCreateGeneralFiles);
                    return true;
                case 28:
                    int iCreateBatch = createBatch(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iCreateBatch);
                    return true;
                case 29:
                    int iCreateShareFiles = createShareFiles(parcel.createTypedArrayList(FileData.CREATOR), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iCreateShareFiles);
                    return true;
                case 30:
                    int iModifyGeneralFiles = modifyGeneralFiles(parcel.createTypedArrayList(FileData.CREATOR), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iModifyGeneralFiles);
                    return true;
                case 31:
                    int iDeleteGeneralFiles = deleteGeneralFiles(parcel.createTypedArrayList(FileData.CREATOR), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iDeleteGeneralFiles);
                    return true;
                case 32:
                    int iDeleteShareFiles = deleteShareFiles(parcel.readString(), parcel.readString(), parcel.createTypedArrayList(FileData.CREATOR), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iDeleteShareFiles);
                    return true;
                case 33:
                    int iStartDownload = startDownload(parcel.createTypedArrayList(FileData.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iStartDownload);
                    return true;
                case 34:
                    int iPauseDownload = pauseDownload(parcel.createTypedArrayList(FileData.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iPauseDownload);
                    return true;
                case 35:
                    int iCancelDownload = cancelDownload(parcel.createTypedArrayList(FileData.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iCancelDownload);
                    return true;
                case 36:
                    int iStartDownloadAll = startDownloadAll();
                    parcel2.writeNoException();
                    parcel2.writeInt(iStartDownloadAll);
                    return true;
                case 37:
                    int iPauseDownloadAll = pauseDownloadAll();
                    parcel2.writeNoException();
                    parcel2.writeInt(iPauseDownloadAll);
                    return true;
                case 38:
                    int iCancelDownloadAll = cancelDownloadAll();
                    parcel2.writeNoException();
                    parcel2.writeInt(iCancelDownloadAll);
                    return true;
                case 39:
                    int downloadFileCount = getDownloadFileCount(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(downloadFileCount);
                    return true;
                case 40:
                    List downloadFileStatus = getDownloadFileStatus(parcel.createTypedArrayList(FileData.CREATOR));
                    parcel2.writeNoException();
                    C2411a.m15039e(parcel2, downloadFileStatus, 1);
                    return true;
                case 41:
                    List downloadFileStatusLimit = getDownloadFileStatusLimit(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    C2411a.m15039e(parcel2, downloadFileStatusLimit, 1);
                    return true;
                case 42:
                    int iDeleteDownloadHistory = deleteDownloadHistory(parcel.createTypedArrayList(FileData.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iDeleteDownloadHistory);
                    return true;
                case 43:
                    int iDeleteDownloadHistoryAll = deleteDownloadHistoryAll(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iDeleteDownloadHistoryAll);
                    return true;
                case 44:
                    int iCreateShareAlbum = createShareAlbum((ShareAlbumData) C2411a.m15038d(parcel, ShareAlbumData.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iCreateShareAlbum);
                    return true;
                case 45:
                    int iCheckAccount = checkAccount(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    parcel2.writeInt(iCheckAccount);
                    return true;
                case 46:
                    int iAddShareReceiver = addShareReceiver((ShareAlbumData) C2411a.m15038d(parcel, ShareAlbumData.CREATOR), parcel.createTypedArrayList(ShareReceiverData.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iAddShareReceiver);
                    return true;
                case 47:
                    int iRemoveShareReceiver = removeShareReceiver((ShareAlbumData) C2411a.m15038d(parcel, ShareAlbumData.CREATOR), parcel.createTypedArrayList(ShareReceiverData.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRemoveShareReceiver);
                    return true;
                case 48:
                    int iShareResultConfirm = shareResultConfirm(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iShareResultConfirm);
                    return true;
                case 49:
                    int iCancelReceivedShare = cancelReceivedShare((ShareAlbumData) C2411a.m15038d(parcel, ShareAlbumData.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iCancelReceivedShare);
                    return true;
                case 50:
                    int iCreateShortLink = createShortLink(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iCreateShortLink);
                    return true;
                case 51:
                    int iModifyShareAlbumPrivilege = modifyShareAlbumPrivilege(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iModifyShareAlbumPrivilege);
                    return true;
                case 52:
                    int avatarInfo = getAvatarInfo(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    parcel2.writeInt(avatarInfo);
                    return true;
                case 53:
                    int iDownloadAvatar = downloadAvatar(parcel.createTypedArrayList(ShareReceiverData.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iDownloadAvatar);
                    return true;
                case 54:
                    boolean zIsSupportSns = isSupportSns();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsSupportSns ? 1 : 0);
                    return true;
                case 55:
                    String[] snsGroups = getSnsGroups();
                    parcel2.writeNoException();
                    parcel2.writeStringArray(snsGroups);
                    return true;
                case 56:
                    List groupMemberInfoList = getGroupMemberInfoList(parcel.readString());
                    parcel2.writeNoException();
                    C2411a.m15039e(parcel2, groupMemberInfoList, 1);
                    return true;
                case 57:
                    int tagVersion = getTagVersion(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(tagVersion);
                    return true;
                case 58:
                    int categoryInfoList = getCategoryInfoList(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(categoryInfoList);
                    return true;
                case 59:
                    int tagInfo = getTagInfo((SmartAlbumData) C2411a.m15038d(parcel, SmartAlbumData.CREATOR), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(tagInfo);
                    return true;
                case 60:
                    int allTagFiles = getAllTagFiles((SmartTagData) C2411a.m15038d(parcel, SmartTagData.CREATOR), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(allTagFiles);
                    return true;
                case 61:
                    int changeTagFiles = getChangeTagFiles((SmartTagData) C2411a.m15038d(parcel, SmartTagData.CREATOR), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(changeTagFiles);
                    return true;
                case 62:
                    int iDestroyGeneralTasks = destroyGeneralTasks(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iDestroyGeneralTasks);
                    return true;
                case 63:
                    int iDestroyShareTasks = destroyShareTasks(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iDestroyShareTasks);
                    return true;
                case 64:
                    String sessionId = getSessionId(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(sessionId);
                    return true;
                case 65:
                    List shareGroupList = getShareGroupList();
                    parcel2.writeNoException();
                    C2411a.m15039e(parcel2, shareGroupList, 1);
                    return true;
                case 66:
                    int iSyncOpsReport = syncOpsReport(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iSyncOpsReport);
                    return true;
                case 67:
                    int aidlVersion = setAidlVersion(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(aidlVersion);
                    return true;
                case 68:
                    int iCopyGeneralFiles = copyGeneralFiles(parcel.createTypedArrayList(FileData.CREATOR), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(iCopyGeneralFiles);
                    return true;
                case 69:
                    closeAlbumSwitch();
                    parcel2.writeNoException();
                    return true;
                case 70:
                    int iQueryDisuseState = queryDisuseState();
                    parcel2.writeNoException();
                    parcel2.writeInt(iQueryDisuseState);
                    return true;
                case 71:
                    int iUpdateDownloadStatus = updateDownloadStatus(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(iUpdateDownloadStatus);
                    return true;
                case 72:
                    int iQueryUserSpace = queryUserSpace(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iQueryUserSpace);
                    return true;
                case 73:
                    int iQueryDisableState = queryDisableState(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iQueryDisableState);
                    return true;
                case 74:
                    int iUpdateSaveOriginalStatus = updateSaveOriginalStatus(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iUpdateSaveOriginalStatus);
                    return true;
                case 75:
                    int iReLogin = reLogin();
                    parcel2.writeNoException();
                    parcel2.writeInt(iReLogin);
                    return true;
                case 76:
                    int iCancelUploadTask = cancelUploadTask(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iCancelUploadTask);
                    return true;
                case 77:
                    int iReportTagTransferStatus = reportTagTransferStatus(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iReportTagTransferStatus);
                    return true;
                case 78:
                    int tagTransferStatus = getTagTransferStatus();
                    parcel2.writeNoException();
                    parcel2.writeInt(tagTransferStatus);
                    return true;
                case 79:
                    int iDropDownloadFileInfo = dropDownloadFileInfo();
                    parcel2.writeNoException();
                    parcel2.writeInt(iDropDownloadFileInfo);
                    return true;
                case 80:
                    int iRequest = request(parcel.readInt(), (Bundle) C2411a.m15038d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRequest);
                    return true;
                case 81:
                    int iStartDownloadFile = startDownloadFile(parcel.createTypedArrayList(FileData.CREATOR), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(iStartDownloadFile);
                    return true;
                case 82:
                    int iReport = report(parcel.readString(), (Stat) C2411a.m15038d(parcel, Stat.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iReport);
                    return true;
                case 83:
                    int allSimplifyInfo = getAllSimplifyInfo(parcel.readString(), parcel.createStringArrayList(), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(allSimplifyInfo);
                    return true;
                case 84:
                    int detailedInfo = getDetailedInfo(parcel.readString(), parcel.createTypedArrayList(SimplifyInfo.CREATOR), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(detailedInfo);
                    return true;
                case 85:
                    UserSpace userSpaceQueryUserSpaceSync = queryUserSpaceSync(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    C2411a.m15040f(parcel2, userSpaceQueryUserSpaceSync, 1);
                    return true;
                case 86:
                    int videoPlayUrlAsync = getVideoPlayUrlAsync((FileData) C2411a.m15038d(parcel, FileData.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(videoPlayUrlAsync);
                    return true;
                case 87:
                    int deviceInfoListAsync = getDeviceInfoListAsync();
                    parcel2.writeNoException();
                    parcel2.writeInt(deviceInfoListAsync);
                    return true;
                case 88:
                    int iReportRisks = reportRisks(parcel.createTypedArrayList(RiskInform.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iReportRisks);
                    return true;
                case 89:
                    int iModifyShareAlbumData = modifyShareAlbumData((ShareAlbumData) C2411a.m15038d(parcel, ShareAlbumData.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iModifyShareAlbumData);
                    return true;
                case 90:
                    Bundle usedPower = getUsedPower();
                    parcel2.writeNoException();
                    C2411a.m15040f(parcel2, usedPower, 1);
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }

        public abstract /* synthetic */ int pauseDownload(List list) throws RemoteException;

        public abstract /* synthetic */ int pauseDownloadAll() throws RemoteException;

        public abstract /* synthetic */ int queryDisableState(int i10, String str) throws RemoteException;

        public abstract /* synthetic */ int queryDisuseState() throws RemoteException;

        public abstract /* synthetic */ int queryUserSpace(String str, int i10, String str2, String str3, String str4) throws RemoteException;

        public abstract /* synthetic */ UserSpace queryUserSpaceSync(String str, int i10, String str2, String str3, String str4) throws RemoteException;

        public abstract /* synthetic */ int reLogin() throws RemoteException;

        public abstract /* synthetic */ boolean registerCallback(ICloudAlbumSdkServiceCallback iCloudAlbumSdkServiceCallback) throws RemoteException;

        public abstract /* synthetic */ int releaseSyncLock(String str, String str2) throws RemoteException;

        public abstract /* synthetic */ int removeShareReceiver(ShareAlbumData shareAlbumData, List list) throws RemoteException;

        public abstract /* synthetic */ int report(String str, Stat stat) throws RemoteException;

        public abstract /* synthetic */ int reportRisks(List list) throws RemoteException;

        public abstract /* synthetic */ int reportTagTransferStatus(String str) throws RemoteException;

        public abstract /* synthetic */ int request(int i10, Bundle bundle) throws RemoteException;

        public abstract /* synthetic */ int setAidlVersion(int i10) throws RemoteException;

        public abstract /* synthetic */ int setAlbumProperties(SettingParams settingParams) throws RemoteException;

        public abstract /* synthetic */ int shareResultConfirm(String str, String str2, int i10) throws RemoteException;

        public abstract /* synthetic */ int startDownload(List list) throws RemoteException;

        public abstract /* synthetic */ int startDownloadAll() throws RemoteException;

        public abstract /* synthetic */ int startDownloadFile(List list, boolean z10) throws RemoteException;

        public abstract /* synthetic */ int syncOpsReport(String str, int i10, int i11, String str2) throws RemoteException;

        public abstract /* synthetic */ void unregisterCallback(ICloudAlbumSdkServiceCallback iCloudAlbumSdkServiceCallback) throws RemoteException;

        public abstract /* synthetic */ int updateDownloadStatus(int i10, boolean z10) throws RemoteException;

        public abstract /* synthetic */ int updateSaveOriginalStatus(int i10, int i11, int i12) throws RemoteException;

        public abstract /* synthetic */ int updateSyncPrompt(SyncPrompt syncPrompt) throws RemoteException;
    }

    /* renamed from: com.huawei.android.hicloud.album.service.ICloudAlbumSdkService$a */
    public static class C2411a {
        /* renamed from: d */
        public static <T> T m15038d(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* renamed from: e */
        public static <T extends Parcelable> void m15039e(Parcel parcel, List<T> list, int i10) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                m15040f(parcel, list.get(i11), i10);
            }
        }

        /* renamed from: f */
        public static <T extends Parcelable> void m15040f(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }
}
