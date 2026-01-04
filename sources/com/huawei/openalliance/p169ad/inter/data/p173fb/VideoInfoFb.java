package com.huawei.openalliance.p169ad.inter.data.p173fb;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class VideoInfoFb extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public VideoInfoFb get(int i10) {
            return get(new VideoInfoFb(), i10);
        }

        public VideoInfoFb get(VideoInfoFb videoInfoFb, int i10) {
            return videoInfoFb.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addAutoPlayAreaRatio(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(15, i10, 100);
    }

    public static void addAutoPlayNetwork(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(5, i10, 0);
    }

    public static void addAutoStopPlayAreaRatio(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(16, i10, 90);
    }

    public static void addBackFromFullScreen(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(14, z10, false);
    }

    public static void addCheckSha256(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(12, z10, false);
    }

    public static void addCustomExposureType(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(22, i10, 0);
    }

    public static void addDirectReturnVideoAd(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(20, z10, false);
    }

    public static void addDownloadNetwork(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(17, i10, 0);
    }

    public static void addLiveRoomName(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(25, i10, 0);
    }

    public static void addNeedContinueAutoPlay(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(13, z10, true);
    }

    public static void addOriginUrl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    public static void addPlayProgress(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(9, i10, 0);
    }

    public static void addSha256(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(8, i10, 0);
    }

    public static void addShowSoundIcon(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(19, z10, true);
    }

    public static void addSoundSwitch(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(10, i10, 0);
    }

    public static void addSplashSwitchTime(FlatBufferBuilder flatBufferBuilder, float f10) {
        flatBufferBuilder.addFloat(21, f10, 0.0d);
    }

    public static void addTimeBeforeVideoAutoPlay(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(7, i10, 200);
    }

    public static void addUseTemplate(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(23, i10, 0);
    }

    public static void addVideoAutoPlay(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(4, i10, 0);
    }

    public static void addVideoAutoPlayWithSound(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(6, i10, 0);
    }

    public static void addVideoDownloadUrl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }

    public static void addVideoDuration(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(2, i10, 0);
    }

    public static void addVideoFileSize(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(3, i10, 0);
    }

    public static void addVideoPlayMode(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(11, i10, 1);
    }

    public static void addVideoRatio(FlatBufferBuilder flatBufferBuilder, float f10) {
        flatBufferBuilder.addFloat(18, f10, 0.0d);
    }

    public static void addVideoType(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(24, i10, 0);
    }

    public static int createVideoInfoFb(FlatBufferBuilder flatBufferBuilder, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, boolean z10, boolean z11, boolean z12, int i22, int i23, int i24, float f10, boolean z13, boolean z14, float f11, int i25, int i26, int i27, int i28) {
        flatBufferBuilder.startTable(26);
        addLiveRoomName(flatBufferBuilder, i28);
        addVideoType(flatBufferBuilder, i27);
        addUseTemplate(flatBufferBuilder, i26);
        addCustomExposureType(flatBufferBuilder, i25);
        addSplashSwitchTime(flatBufferBuilder, f11);
        addVideoRatio(flatBufferBuilder, f10);
        addDownloadNetwork(flatBufferBuilder, i24);
        addAutoStopPlayAreaRatio(flatBufferBuilder, i23);
        addAutoPlayAreaRatio(flatBufferBuilder, i22);
        addVideoPlayMode(flatBufferBuilder, i21);
        addSoundSwitch(flatBufferBuilder, i20);
        addPlayProgress(flatBufferBuilder, i19);
        addSha256(flatBufferBuilder, i18);
        addTimeBeforeVideoAutoPlay(flatBufferBuilder, i17);
        addVideoAutoPlayWithSound(flatBufferBuilder, i16);
        addAutoPlayNetwork(flatBufferBuilder, i15);
        addVideoAutoPlay(flatBufferBuilder, i14);
        addVideoFileSize(flatBufferBuilder, i13);
        addVideoDuration(flatBufferBuilder, i12);
        addOriginUrl(flatBufferBuilder, i11);
        addVideoDownloadUrl(flatBufferBuilder, i10);
        addDirectReturnVideoAd(flatBufferBuilder, z14);
        addShowSoundIcon(flatBufferBuilder, z13);
        addBackFromFullScreen(flatBufferBuilder, z12);
        addNeedContinueAutoPlay(flatBufferBuilder, z11);
        addCheckSha256(flatBufferBuilder, z10);
        return endVideoInfoFb(flatBufferBuilder);
    }

    public static int endVideoInfoFb(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static VideoInfoFb getRootAsVideoInfoFb(ByteBuffer byteBuffer) {
        return getRootAsVideoInfoFb(byteBuffer, new VideoInfoFb());
    }

    public static void startVideoInfoFb(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(26);
    }

    public VideoInfoFb __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public int autoPlayAreaRatio() {
        int i__offset = __offset(34);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 100;
    }

    public int autoPlayNetwork() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public int autoStopPlayAreaRatio() {
        int i__offset = __offset(36);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 90;
    }

    public boolean backFromFullScreen() {
        int i__offset = __offset(32);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public boolean checkSha256() {
        int i__offset = __offset(28);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public int customExposureType() {
        int i__offset = __offset(48);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public boolean directReturnVideoAd() {
        int i__offset = __offset(44);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public int downloadNetwork() {
        int i__offset = __offset(38);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String liveRoomName() {
        int i__offset = __offset(54);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer liveRoomNameAsByteBuffer() {
        return __vector_as_bytebuffer(54, 1);
    }

    public ByteBuffer liveRoomNameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 54, 1);
    }

    public boolean needContinueAutoPlay() {
        int i__offset = __offset(30);
        return i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) != 0;
    }

    public String originUrl() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer originUrlAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer originUrlInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public int playProgress() {
        int i__offset = __offset(22);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
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

    public boolean showSoundIcon() {
        int i__offset = __offset(42);
        return i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) != 0;
    }

    public String soundSwitch() {
        int i__offset = __offset(24);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer soundSwitchAsByteBuffer() {
        return __vector_as_bytebuffer(24, 1);
    }

    public ByteBuffer soundSwitchInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 24, 1);
    }

    public float splashSwitchTime() {
        int i__offset = __offset(46);
        if (i__offset != 0) {
            return this.f9449bb.getFloat(i__offset + this.bb_pos);
        }
        return 0.0f;
    }

    public int timeBeforeVideoAutoPlay() {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 200;
    }

    public String useTemplate() {
        int i__offset = __offset(50);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer useTemplateAsByteBuffer() {
        return __vector_as_bytebuffer(50, 1);
    }

    public ByteBuffer useTemplateInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 50, 1);
    }

    public String videoAutoPlay() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer videoAutoPlayAsByteBuffer() {
        return __vector_as_bytebuffer(12, 1);
    }

    public ByteBuffer videoAutoPlayInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 12, 1);
    }

    public String videoAutoPlayWithSound() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer videoAutoPlayWithSoundAsByteBuffer() {
        return __vector_as_bytebuffer(16, 1);
    }

    public ByteBuffer videoAutoPlayWithSoundInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 16, 1);
    }

    public String videoDownloadUrl() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer videoDownloadUrlAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer videoDownloadUrlInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public int videoDuration() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public int videoFileSize() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public int videoPlayMode() {
        int i__offset = __offset(26);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 1;
    }

    public float videoRatio() {
        int i__offset = __offset(40);
        if (i__offset != 0) {
            return this.f9449bb.getFloat(i__offset + this.bb_pos);
        }
        return 0.0f;
    }

    public int videoType() {
        int i__offset = __offset(52);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public static VideoInfoFb getRootAsVideoInfoFb(ByteBuffer byteBuffer, VideoInfoFb videoInfoFb) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return videoInfoFb.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
