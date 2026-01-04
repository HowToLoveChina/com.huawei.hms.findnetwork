package p312g8;

import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import java.util.HashMap;
import java.util.Map;

/* renamed from: g8.c */
/* loaded from: classes2.dex */
public class C9892c {

    /* renamed from: a */
    public static final Map<Integer, String> f48539a = new a();

    /* renamed from: g8.c$a */
    public class a extends HashMap<Integer, String> {
        public a() {
            put(8, "setAlbumProperties(SettingParams)");
            put(9, "updateSyncPrompt(SyncPrompt)");
            put(1, "getGeneralAlbumVersion(String)");
            put(2, "getSyncLock(String)");
            put(3, "keepSyncLock(String,String)");
            put(4, "releaseSyncLock(String,String)");
            put(5, "getServerTime");
            put(7, "getFileTransferStatus(String)");
            put(11, "getGeneralAlbums(String)");
            put(13, "getAllGeneralFiles(List,int,int,String)");
            put(14, "getChangedGeneralFiles(List,long,int,String,String)");
            put(15, "downloadGeneralFiles(List,int,int,boolean,boolean,String)");
            put(17, "createGeneralAlbums(List,String,String)");
            put(18, "modifyGeneralAlbums(List,String,String)");
            put(20, "deleteGeneralAlbums(List,String,String)");
            put(21, "createGeneralFiles(List,String,boolean,String)");
            put(22, "modifyGeneralFiles(List,String,String)");
            put(24, "deleteGeneralFiles(List,String,String)");
            put(36, "copyGeneralFiles(List,String,String,long,long)");
            put(37, "queryUserSpace(String,int,String,String,String)");
            put(6, "getShareAlbumVersion(String)");
            put(12, "getShareAlbums(String)");
            put(25, "getGroupAlbums(String)");
            put(26, "getAllShareFiles(ShareAlbumData,int,String)");
            put(16, "downloadShareFiles(List,int,int,boolean,boolean,String)");
            put(27, "getChangedShareFiles(ShareAlbumData,String,String)");
            put(28, "deleteShareAlbum(ShareAlbumData,String)");
            put(29, "deleteShareFile(String,String,List,String)");
            put(23, "createShareFiles(List,boolean,String)");
            put(82, "createBatch(String,String,String)");
            put(30, "getTagVersion(String)");
            put(31, "getCategoryInfoList(String)");
            put(32, "getTagInfo(SmartAlbumData,String,String)");
            put(33, "getAllTagFiles(SmartTagData,String,String)");
            put(34, "getChangeTagFiles(SmartTagData,String,String)");
            put(19, "modifyShareAlbum(ShareAlbumData,String)");
            put(41, "createShareAlbum(ShareAlbumData)");
            put(42, "addShareReceiver(ShareAlbumData,List)");
            put(43, "removeShareReceiver(ShareAlbumData,List)");
            put(44, "shareResultConfirm(String,String,int)");
            put(45, "cancelReceivedShare(ShareAlbumData)");
            put(46, "createShortLink(String)");
            put(47, "modifyShareAlbumPrivilege(String,int)");
            put(48, "getAvatar(List)");
            put(49, "downloadAvatar(List,String)");
            put(10, "checkAccount(List)");
            put(50, "getGroupIdList");
            put(71, "startDownload(List)");
            put(70, "startDownloadFile(List,boolean)");
            put(72, "pauseDownload(List)");
            put(73, "cancelDownload(List)");
            put(74, "startDownloadAll()");
            put(75, "pauseDownloadAll");
            put(76, "cancelDownloadAll");
            put(77, "getDownloadFileCount(int)");
            put(78, "getDownloadFileStatus(List)");
            put(79, "getDownloadFileStatusLimit(int,int,int)");
            put(80, "deleteDownloadHistory(List)");
            put(81, "deleteDownloadHistoryAll(int)");
            put(61, "dealPushEvent(int)");
            put(62, "dealSwitchEvent(int,boolean)");
            put(63, "dealStateChangedEvent(int,int)");
            put(64, "dealSyncStateChangedEvent(int,int)");
            put(65, "dealStateEvent(int,boolean)");
            put(66, "destroyGeneralTasks(int,int)");
            put(67, "destroyShareTasks(int,int)");
            put(68, "queryDisableState(int,String)");
            put(69, "updateSaveOriginalStatus(int,int,int)");
            put(90, "cancelUploadTask(String)");
            put(91, "reportTagTransferStatus(String)");
            put(92, "getTagTransferStatus()");
            put(93, TrackConstants$Opers.REQUEST);
            put(94, "albumVersionReset");
            put(95, "getAllSimplifyInfo(String,List,int,int,String)");
            put(96, "getDetailedInfo(String,List,boolean)");
            put(97, "getVideoPlayUrlAsync(FileData)");
            put(98, "getShareAlbumList()");
            put(99, "modifyShareAlbumData(ShareAlbumData)");
        }
    }

    /* renamed from: a */
    public static Map<Integer, String> m61373a() {
        return f48539a;
    }
}
