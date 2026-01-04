package com.huawei.openalliance.p169ad.inter.data.p173fb;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class InstallConfigFb extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public InstallConfigFb get(int i10) {
            return get(new InstallConfigFb(), i10);
        }

        public InstallConfigFb get(InstallConfigFb installConfigFb, int i10) {
            return installConfigFb.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addAppBtnInstallWay(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    public static void addContentBtnInstallWay(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(2, i10, 0);
    }

    public static void addCreativeInstallWay(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }

    public static int createInstallConfigFb(FlatBufferBuilder flatBufferBuilder, int i10, int i11, int i12) {
        flatBufferBuilder.startTable(3);
        addContentBtnInstallWay(flatBufferBuilder, i12);
        addAppBtnInstallWay(flatBufferBuilder, i11);
        addCreativeInstallWay(flatBufferBuilder, i10);
        return endInstallConfigFb(flatBufferBuilder);
    }

    public static int endInstallConfigFb(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static InstallConfigFb getRootAsInstallConfigFb(ByteBuffer byteBuffer) {
        return getRootAsInstallConfigFb(byteBuffer, new InstallConfigFb());
    }

    public static void startInstallConfigFb(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(3);
    }

    public InstallConfigFb __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public String appBtnInstallWay() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer appBtnInstallWayAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer appBtnInstallWayInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public String contentBtnInstallWay() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer contentBtnInstallWayAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer contentBtnInstallWayInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public String creativeInstallWay() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer creativeInstallWayAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer creativeInstallWayInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public static InstallConfigFb getRootAsInstallConfigFb(ByteBuffer byteBuffer, InstallConfigFb installConfigFb) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return installConfigFb.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
