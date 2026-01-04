package com.huawei.android.hicloud.drive.clouddisk.model;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class Digest {
    private static final short SOURCE_LAYER = 0;
    private static final String TAG = "Digest";
    private int blockSize;
    private List<DeltaFragment> fragments;
    private List<DeltaFragment> mergedFragments;
    private int tag;

    public Digest(int i10, int i11, List<DeltaFragment> list) {
        this.tag = i10;
        this.blockSize = i11;
        this.fragments = list;
    }

    public static Digest diffDn(Digest digest, Digest digest2) {
        return digest.diff(digest2, true);
    }

    public static Digest diffUp(Digest digest, Digest digest2) {
        return digest.diff(digest2, false);
    }

    public Digest diff(Digest digest, boolean z10) {
        if (digest.tag != this.tag) {
            throw new IllegalArgumentException("unknown digest tag");
        }
        if (digest.blockSize != this.blockSize) {
            throw new IllegalArgumentException("block size not match");
        }
        List<DeltaFragment> fragments = getFragments();
        List<DeltaFragment> fragments2 = digest.getFragments();
        return new Digest(this.tag, this.blockSize, z10 ? DeltaFragment.diffDn(fragments, fragments2) : DeltaFragment.diffUp(fragments2, fragments));
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public List<DeltaFragment> getFragments() {
        return this.fragments;
    }

    public List<DeltaFragment> getMergedFragments() {
        return Collections.unmodifiableList(this.mergedFragments);
    }

    public int getTag() {
        return this.tag;
    }

    public Digest newDigest(List<DeltaFragment> list) {
        return new Digest(this.tag, this.blockSize, list);
    }

    public byte[] serialize(boolean z10) throws IOException {
        int size = this.fragments.size();
        int i10 = ((z10 ? 58 : 48) * size) + 10;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort((this.tag << 1) | (z10 ? 1 : 0));
                dataOutputStream.writeInt(this.blockSize);
                dataOutputStream.writeInt(size);
                if (z10) {
                    for (DeltaFragment deltaFragment : this.fragments) {
                        dataOutputStream.writeLong(deltaFragment.getPosition());
                        dataOutputStream.writeLong(deltaFragment.getLength());
                        dataOutputStream.write(deltaFragment.getSha256());
                        dataOutputStream.writeShort(deltaFragment.getLayerSeq());
                        dataOutputStream.writeLong(deltaFragment.getOffset());
                    }
                } else {
                    for (DeltaFragment deltaFragment2 : this.fragments) {
                        dataOutputStream.writeLong(deltaFragment2.getPosition());
                        dataOutputStream.writeLong(deltaFragment2.getLength());
                        dataOutputStream.write(deltaFragment2.getSha256());
                    }
                }
                dataOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (byteArray.length != i10) {
                    throw new IOException("error format, illegal length");
                }
                C11839m.m70688i(TAG, "buff size: " + i10);
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public void setLayer(int i10) {
        for (DeltaFragment deltaFragment : this.fragments) {
            if (deltaFragment.getLayerSeq() == 0) {
                deltaFragment.setLayerSeq((short) i10);
            }
        }
    }

    public void setMergedFragments(List<DeltaFragment> list) {
        this.mergedFragments = list;
    }
}
