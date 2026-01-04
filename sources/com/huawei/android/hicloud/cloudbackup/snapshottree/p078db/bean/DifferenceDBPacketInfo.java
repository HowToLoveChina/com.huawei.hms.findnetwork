package com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class DifferenceDBPacketInfo implements Serializable {
    private static final long serialVersionUID = -2334567830053266757L;
    byte[] content;
    private int length;
    private long offset;

    public byte[] getContent() {
        return this.content;
    }

    public int getLength() {
        return this.length;
    }

    public long getOffset() {
        return this.offset;
    }

    public void setContent(byte[] bArr) {
        this.content = bArr;
    }

    public void setLength(int i10) {
        this.length = i10;
    }

    public void setOffset(long j10) {
        this.offset = j10;
    }
}
