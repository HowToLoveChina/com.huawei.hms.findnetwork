package com.huawei.openalliance.p169ad.inter.data.p173fb;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import com.huawei.openalliance.p169ad.inter.data.p173fb.PermissionEntityFb;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class AppInfoFb extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public AppInfoFb get(int i10) {
            return get(new AppInfoFb(), i10);
        }

        public AppInfoFb get(AppInfoFb appInfoFb, int i10) {
            return appInfoFb.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addActName(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(40, i10, 0);
    }

    public static void addAfDlBtnText(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(25, i10, 0);
    }

    public static void addAllAreaPopDelay(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addLong(43, j10, 0L);
    }

    public static void addAllowedNonWifiNetwork(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(33, z10, false);
    }

    public static void addAppCountry(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(36, i10, 0);
    }

    public static void addAppDesc(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(20, i10, 0);
    }

    public static void addAppDetailsUrl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(51, i10, 0);
    }

    public static void addAppLanguage(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(35, i10, 0);
    }

    public static void addAppName(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }

    public static void addAppType(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(41, i10, 1);
    }

    public static void addAutoOpenAfterInstall(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(42, i10, 0);
    }

    public static void addAutoOpenSwitchLandingOrDetail(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(54, i10, 0);
    }

    public static void addChannelInfo(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(17, i10, 0);
    }

    public static void addChannelInfoSaveLimit(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(18, i10, -2);
    }

    public static void addCheckSha256(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(9, z10, false);
    }

    public static void addContentInstallBtnAction(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(53, i10, 0);
    }

    public static void addContiBtn(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(48, i10, 0);
    }

    public static void addCurInstallWay(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(39, i10, 0);
    }

    public static void addDeveloperName(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(37, i10, 0);
    }

    public static void addDlBtnText(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(24, i10, 0);
    }

    public static void addDlOpenBtnText(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(55, i10, 0);
    }

    public static void addDownCountDesc(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(59, i10, 0);
    }

    public static void addDownloadNum(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addLong(58, j10, 0L);
    }

    public static void addDownloadUrl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(5, i10, 0);
    }

    public static void addFileSize(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addLong(7, j10, 0L);
    }

    public static void addFullScrnNotify(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(29, i10, 0);
    }

    public static void addFullScrnNotifyText(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(30, i10, 0);
    }

    public static void addHasPermissions(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(34, i10, 0);
    }

    public static void addHot(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(56, i10, 0);
    }

    public static void addIconUrl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(4, i10, 0);
    }

    public static void addInsActvNotifyBtnText(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(31, i10, 0);
    }

    public static void addInsActvNotifyCfg(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(32, i10, 1);
    }

    public static void addInstallConfig(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(13, i10, 0);
    }

    public static void addInstallPermiText(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(45, i10, 0);
    }

    public static void addInstallPureModeText(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(47, i10, 0);
    }

    public static void addIntent(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(26, i10, 0);
    }

    public static void addIntentPackage(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(27, i10, 0);
    }

    public static void addIntentUri(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(10, i10, 0);
    }

    public static void addNextInstallWays(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(38, i10, 0);
    }

    public static void addNoAlertTime(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(21, i10, 0);
    }

    public static void addPackageName(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    public static void addPermPromptForCard(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(14, z10, true);
    }

    public static void addPermPromptForLanding(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(15, z10, false);
    }

    public static void addPermissionUrl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(50, i10, 0);
    }

    public static void addPermissions(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(11, i10, 0);
    }

    public static void addPopNotify(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(28, i10, 0);
    }

    public static void addPopUpAfterInstallNew(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(16, i10, 0);
    }

    public static void addPopUpAfterInstallText(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(23, i10, 0);
    }

    public static void addPopUpStyle(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(44, i10, 0);
    }

    public static void addPriorInstallWay(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(12, i10, 0);
    }

    public static void addPrivacyUrl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(52, i10, 0);
    }

    public static void addPureModeText(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(46, i10, 0);
    }

    public static void addRateNum(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addLong(57, j10, 0L);
    }

    public static void addReservedPkgName(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(49, i10, 0);
    }

    public static void addSafeDownloadUrl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(6, i10, 0);
    }

    public static void addSha256(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(8, i10, 0);
    }

    public static void addTrafficReminder(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(22, i10, 0);
    }

    public static void addUniqueId(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(19, i10, 0);
    }

    public static void addVersionCode(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(2, i10, 0);
    }

    public static void addVersionName(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(3, i10, 0);
    }

    public static int createAppInfoFb(FlatBufferBuilder flatBufferBuilder, int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, int i17, boolean z10, int i18, int i19, int i20, int i21, boolean z11, boolean z12, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38, boolean z13, int i39, int i40, int i41, int i42, int i43, int i44, int i45, int i46, int i47, long j11, int i48, int i49, int i50, int i51, int i52, int i53, int i54, int i55, int i56, int i57, int i58, int i59, int i60, long j12, long j13, int i61) {
        flatBufferBuilder.startTable(60);
        addDownloadNum(flatBufferBuilder, j13);
        addRateNum(flatBufferBuilder, j12);
        addAllAreaPopDelay(flatBufferBuilder, j11);
        addFileSize(flatBufferBuilder, j10);
        addDownCountDesc(flatBufferBuilder, i61);
        addHot(flatBufferBuilder, i60);
        addDlOpenBtnText(flatBufferBuilder, i59);
        addAutoOpenSwitchLandingOrDetail(flatBufferBuilder, i58);
        addContentInstallBtnAction(flatBufferBuilder, i57);
        addPrivacyUrl(flatBufferBuilder, i56);
        addAppDetailsUrl(flatBufferBuilder, i55);
        addPermissionUrl(flatBufferBuilder, i54);
        addReservedPkgName(flatBufferBuilder, i53);
        addContiBtn(flatBufferBuilder, i52);
        addInstallPureModeText(flatBufferBuilder, i51);
        addPureModeText(flatBufferBuilder, i50);
        addInstallPermiText(flatBufferBuilder, i49);
        addPopUpStyle(flatBufferBuilder, i48);
        addAutoOpenAfterInstall(flatBufferBuilder, i47);
        addAppType(flatBufferBuilder, i46);
        addActName(flatBufferBuilder, i45);
        addCurInstallWay(flatBufferBuilder, i44);
        addNextInstallWays(flatBufferBuilder, i43);
        addDeveloperName(flatBufferBuilder, i42);
        addAppCountry(flatBufferBuilder, i41);
        addAppLanguage(flatBufferBuilder, i40);
        addHasPermissions(flatBufferBuilder, i39);
        addInsActvNotifyCfg(flatBufferBuilder, i38);
        addInsActvNotifyBtnText(flatBufferBuilder, i37);
        addFullScrnNotifyText(flatBufferBuilder, i36);
        addFullScrnNotify(flatBufferBuilder, i35);
        addPopNotify(flatBufferBuilder, i34);
        addIntentPackage(flatBufferBuilder, i33);
        addIntent(flatBufferBuilder, i32);
        addAfDlBtnText(flatBufferBuilder, i31);
        addDlBtnText(flatBufferBuilder, i30);
        addPopUpAfterInstallText(flatBufferBuilder, i29);
        addTrafficReminder(flatBufferBuilder, i28);
        addNoAlertTime(flatBufferBuilder, i27);
        addAppDesc(flatBufferBuilder, i26);
        addUniqueId(flatBufferBuilder, i25);
        addChannelInfoSaveLimit(flatBufferBuilder, i24);
        addChannelInfo(flatBufferBuilder, i23);
        addPopUpAfterInstallNew(flatBufferBuilder, i22);
        addInstallConfig(flatBufferBuilder, i21);
        addPriorInstallWay(flatBufferBuilder, i20);
        addPermissions(flatBufferBuilder, i19);
        addIntentUri(flatBufferBuilder, i18);
        addSha256(flatBufferBuilder, i17);
        addSafeDownloadUrl(flatBufferBuilder, i16);
        addDownloadUrl(flatBufferBuilder, i15);
        addIconUrl(flatBufferBuilder, i14);
        addVersionName(flatBufferBuilder, i13);
        addVersionCode(flatBufferBuilder, i12);
        addPackageName(flatBufferBuilder, i11);
        addAppName(flatBufferBuilder, i10);
        addAllowedNonWifiNetwork(flatBufferBuilder, z13);
        addPermPromptForLanding(flatBufferBuilder, z12);
        addPermPromptForCard(flatBufferBuilder, z11);
        addCheckSha256(flatBufferBuilder, z10);
        return endAppInfoFb(flatBufferBuilder);
    }

    public static int createPermissionsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int endAppInfoFb(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static AppInfoFb getRootAsAppInfoFb(ByteBuffer byteBuffer) {
        return getRootAsAppInfoFb(byteBuffer, new AppInfoFb());
    }

    public static void startAppInfoFb(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(60);
    }

    public static void startPermissionsVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public AppInfoFb __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public String actName() {
        int i__offset = __offset(84);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer actNameAsByteBuffer() {
        return __vector_as_bytebuffer(84, 1);
    }

    public ByteBuffer actNameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 84, 1);
    }

    public String afDlBtnText() {
        int i__offset = __offset(54);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer afDlBtnTextAsByteBuffer() {
        return __vector_as_bytebuffer(54, 1);
    }

    public ByteBuffer afDlBtnTextInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 54, 1);
    }

    public long allAreaPopDelay() {
        int i__offset = __offset(90);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public boolean allowedNonWifiNetwork() {
        int i__offset = __offset(70);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public String appCountry() {
        int i__offset = __offset(76);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer appCountryAsByteBuffer() {
        return __vector_as_bytebuffer(76, 1);
    }

    public ByteBuffer appCountryInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 76, 1);
    }

    public String appDesc() {
        int i__offset = __offset(44);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer appDescAsByteBuffer() {
        return __vector_as_bytebuffer(44, 1);
    }

    public ByteBuffer appDescInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 44, 1);
    }

    public String appDetailsUrl() {
        int i__offset = __offset(106);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer appDetailsUrlAsByteBuffer() {
        return __vector_as_bytebuffer(106, 1);
    }

    public ByteBuffer appDetailsUrlInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 106, 1);
    }

    public String appLanguage() {
        int i__offset = __offset(74);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer appLanguageAsByteBuffer() {
        return __vector_as_bytebuffer(74, 1);
    }

    public ByteBuffer appLanguageInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 74, 1);
    }

    public String appName() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer appNameAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer appNameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public int appType() {
        int i__offset = __offset(86);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 1;
    }

    public int autoOpenAfterInstall() {
        int i__offset = __offset(88);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public int autoOpenSwitchLandingOrDetail() {
        int i__offset = __offset(112);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String channelInfo() {
        int i__offset = __offset(38);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer channelInfoAsByteBuffer() {
        return __vector_as_bytebuffer(38, 1);
    }

    public ByteBuffer channelInfoInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 38, 1);
    }

    public int channelInfoSaveLimit() {
        int i__offset = __offset(40);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return -2;
    }

    public boolean checkSha256() {
        int i__offset = __offset(22);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public String contentInstallBtnAction() {
        int i__offset = __offset(110);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer contentInstallBtnActionAsByteBuffer() {
        return __vector_as_bytebuffer(110, 1);
    }

    public ByteBuffer contentInstallBtnActionInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 110, 1);
    }

    public String contiBtn() {
        int i__offset = __offset(100);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer contiBtnAsByteBuffer() {
        return __vector_as_bytebuffer(100, 1);
    }

    public ByteBuffer contiBtnInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 100, 1);
    }

    public String curInstallWay() {
        int i__offset = __offset(82);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer curInstallWayAsByteBuffer() {
        return __vector_as_bytebuffer(82, 1);
    }

    public ByteBuffer curInstallWayInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 82, 1);
    }

    public String developerName() {
        int i__offset = __offset(78);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer developerNameAsByteBuffer() {
        return __vector_as_bytebuffer(78, 1);
    }

    public ByteBuffer developerNameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 78, 1);
    }

    public String dlBtnText() {
        int i__offset = __offset(52);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer dlBtnTextAsByteBuffer() {
        return __vector_as_bytebuffer(52, 1);
    }

    public ByteBuffer dlBtnTextInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 52, 1);
    }

    public String dlOpenBtnText() {
        int i__offset = __offset(114);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer dlOpenBtnTextAsByteBuffer() {
        return __vector_as_bytebuffer(114, 1);
    }

    public ByteBuffer dlOpenBtnTextInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 114, 1);
    }

    public String downCountDesc() {
        int i__offset = __offset(122);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer downCountDescAsByteBuffer() {
        return __vector_as_bytebuffer(122, 1);
    }

    public ByteBuffer downCountDescInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 122, 1);
    }

    public long downloadNum() {
        int i__offset = __offset(120);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public String downloadUrl() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer downloadUrlAsByteBuffer() {
        return __vector_as_bytebuffer(14, 1);
    }

    public ByteBuffer downloadUrlInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 14, 1);
    }

    public long fileSize() {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public int fullScrnNotify() {
        int i__offset = __offset(62);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String fullScrnNotifyText() {
        int i__offset = __offset(64);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer fullScrnNotifyTextAsByteBuffer() {
        return __vector_as_bytebuffer(64, 1);
    }

    public ByteBuffer fullScrnNotifyTextInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 64, 1);
    }

    public int hasPermissions() {
        int i__offset = __offset(72);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String hot() {
        int i__offset = __offset(116);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer hotAsByteBuffer() {
        return __vector_as_bytebuffer(116, 1);
    }

    public ByteBuffer hotInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 116, 1);
    }

    public String iconUrl() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer iconUrlAsByteBuffer() {
        return __vector_as_bytebuffer(12, 1);
    }

    public ByteBuffer iconUrlInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 12, 1);
    }

    public String insActvNotifyBtnText() {
        int i__offset = __offset(66);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer insActvNotifyBtnTextAsByteBuffer() {
        return __vector_as_bytebuffer(66, 1);
    }

    public ByteBuffer insActvNotifyBtnTextInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 66, 1);
    }

    public int insActvNotifyCfg() {
        int i__offset = __offset(68);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 1;
    }

    public InstallConfigFb installConfig() {
        return installConfig(new InstallConfigFb());
    }

    public String installPermiText() {
        int i__offset = __offset(94);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer installPermiTextAsByteBuffer() {
        return __vector_as_bytebuffer(94, 1);
    }

    public ByteBuffer installPermiTextInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 94, 1);
    }

    public String installPureModeText() {
        int i__offset = __offset(98);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer installPureModeTextAsByteBuffer() {
        return __vector_as_bytebuffer(98, 1);
    }

    public ByteBuffer installPureModeTextInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 98, 1);
    }

    public String intent() {
        int i__offset = __offset(56);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer intentAsByteBuffer() {
        return __vector_as_bytebuffer(56, 1);
    }

    public ByteBuffer intentInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 56, 1);
    }

    public String intentPackage() {
        int i__offset = __offset(58);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer intentPackageAsByteBuffer() {
        return __vector_as_bytebuffer(58, 1);
    }

    public ByteBuffer intentPackageInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 58, 1);
    }

    public String intentUri() {
        int i__offset = __offset(24);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer intentUriAsByteBuffer() {
        return __vector_as_bytebuffer(24, 1);
    }

    public ByteBuffer intentUriInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 24, 1);
    }

    public String nextInstallWays() {
        int i__offset = __offset(80);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer nextInstallWaysAsByteBuffer() {
        return __vector_as_bytebuffer(80, 1);
    }

    public ByteBuffer nextInstallWaysInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 80, 1);
    }

    public int noAlertTime() {
        int i__offset = __offset(46);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String packageName() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer packageNameAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer packageNameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public boolean permPromptForCard() {
        int i__offset = __offset(32);
        return i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) != 0;
    }

    public boolean permPromptForLanding() {
        int i__offset = __offset(34);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public String permissionUrl() {
        int i__offset = __offset(104);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer permissionUrlAsByteBuffer() {
        return __vector_as_bytebuffer(104, 1);
    }

    public ByteBuffer permissionUrlInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 104, 1);
    }

    public PermissionEntityFb permissions(int i10) {
        return permissions(new PermissionEntityFb(), i10);
    }

    public int permissionsLength() {
        int i__offset = __offset(26);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public PermissionEntityFb.Vector permissionsVector() {
        return permissionsVector(new PermissionEntityFb.Vector());
    }

    public int popNotify() {
        int i__offset = __offset(60);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public int popUpAfterInstallNew() {
        int i__offset = __offset(36);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String popUpAfterInstallText() {
        int i__offset = __offset(50);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer popUpAfterInstallTextAsByteBuffer() {
        return __vector_as_bytebuffer(50, 1);
    }

    public ByteBuffer popUpAfterInstallTextInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 50, 1);
    }

    public int popUpStyle() {
        int i__offset = __offset(92);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String priorInstallWay() {
        int i__offset = __offset(28);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer priorInstallWayAsByteBuffer() {
        return __vector_as_bytebuffer(28, 1);
    }

    public ByteBuffer priorInstallWayInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 28, 1);
    }

    public String privacyUrl() {
        int i__offset = __offset(108);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer privacyUrlAsByteBuffer() {
        return __vector_as_bytebuffer(108, 1);
    }

    public ByteBuffer privacyUrlInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 108, 1);
    }

    public String pureModeText() {
        int i__offset = __offset(96);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer pureModeTextAsByteBuffer() {
        return __vector_as_bytebuffer(96, 1);
    }

    public ByteBuffer pureModeTextInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 96, 1);
    }

    public long rateNum() {
        int i__offset = __offset(118);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public String reservedPkgName() {
        int i__offset = __offset(102);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer reservedPkgNameAsByteBuffer() {
        return __vector_as_bytebuffer(102, 1);
    }

    public ByteBuffer reservedPkgNameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 102, 1);
    }

    public String safeDownloadUrl() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer safeDownloadUrlAsByteBuffer() {
        return __vector_as_bytebuffer(16, 1);
    }

    public ByteBuffer safeDownloadUrlInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 16, 1);
    }

    public String sha256() {
        int i__offset = __offset(20);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer sha256AsByteBuffer() {
        return __vector_as_bytebuffer(20, 1);
    }

    public ByteBuffer sha256InByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 20, 1);
    }

    public int trafficReminder() {
        int i__offset = __offset(48);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String uniqueId() {
        int i__offset = __offset(42);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer uniqueIdAsByteBuffer() {
        return __vector_as_bytebuffer(42, 1);
    }

    public ByteBuffer uniqueIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 42, 1);
    }

    public String versionCode() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer versionCodeAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer versionCodeInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public String versionName() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer versionNameAsByteBuffer() {
        return __vector_as_bytebuffer(10, 1);
    }

    public ByteBuffer versionNameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 10, 1);
    }

    public static AppInfoFb getRootAsAppInfoFb(ByteBuffer byteBuffer, AppInfoFb appInfoFb) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return appInfoFb.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public InstallConfigFb installConfig(InstallConfigFb installConfigFb) {
        int i__offset = __offset(30);
        if (i__offset != 0) {
            return installConfigFb.__assign(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    public PermissionEntityFb permissions(PermissionEntityFb permissionEntityFb, int i10) {
        int i__offset = __offset(26);
        if (i__offset != 0) {
            return permissionEntityFb.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public PermissionEntityFb.Vector permissionsVector(PermissionEntityFb.Vector vector) {
        int i__offset = __offset(26);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }
}
