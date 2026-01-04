package com.huawei.hiar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;

/* loaded from: classes5.dex */
public class ARAugmentedImageDatabase {
    private static final int STREAM_END = -1;
    static final String TAG = "ARAugmentedImageDatabase";
    long mNativeDatabaseHandle;
    private final ARSession mSession;

    public ARAugmentedImageDatabase(ARSession aRSession) {
        this.mSession = aRSession;
        this.mNativeDatabaseHandle = nativeCreate(aRSession.mNativeHandle);
    }

    private static byte[] convertBitmapToGrayScaleByteArray(Bitmap bitmap) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        Paint paint = new Paint();
        paint.setColorFilter(colorMatrixColorFilter);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, 0.0f, 0.0f, paint);
        byte[] bArr = new byte[bitmap.getWidth() * bitmap.getHeight()];
        for (int i10 = 0; i10 < bitmap.getHeight(); i10++) {
            for (int i11 = 0; i11 < bitmap.getWidth(); i11++) {
                bArr[(bitmap.getWidth() * i10) + i11] = (byte) Color.red(bitmapCreateBitmap.getPixel(i11, i10));
            }
        }
        return bArr;
    }

    public static ARAugmentedImageDatabase deserialize(ARSession aRSession, InputStream inputStream) throws IOException {
        return new ARAugmentedImageDatabase(aRSession, nativeDeserialize(aRSession.mNativeHandle, loadDirectByteArray(inputStream)));
    }

    private static byte[] loadDirectByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(32, inputStream.available()));
        byte[] bArr = new byte[8192];
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i10);
        }
    }

    private native int nativeAddImage(long j10, long j11, String str, byte[] bArr, int i10, int i11, int i12);

    private native int nativeAddImageWithPhysicalSize(long j10, long j11, String str, byte[] bArr, int i10, int i11, int i12, float f10);

    private static native long nativeCreate(long j10);

    private static native long nativeDeserialize(long j10, byte[] bArr);

    private static native void nativeDestroy(long j10);

    private native int nativeGetNumImages(long j10, long j11);

    private native byte[] nativeSerialize(long j10, long j11);

    public int addImage(String str, Bitmap bitmap) {
        if (bitmap == null || bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            return 0;
        }
        return nativeAddImage(this.mSession.mNativeHandle, this.mNativeDatabaseHandle, str, convertBitmapToGrayScaleByteArray(bitmap), bitmap.getWidth(), bitmap.getHeight(), bitmap.getWidth());
    }

    public void finalize() throws Throwable {
        long j10 = this.mNativeDatabaseHandle;
        if (j10 != 0) {
            nativeDestroy(j10);
        }
        super.finalize();
    }

    public int getNumImages() {
        return nativeGetNumImages(this.mSession.mNativeHandle, this.mNativeDatabaseHandle);
    }

    public void serialize(OutputStream outputStream) throws IOException {
        byte[] bArrNativeSerialize = nativeSerialize(this.mSession.mNativeHandle, this.mNativeDatabaseHandle);
        ByteBuffer byteBufferPut = ByteBuffer.allocateDirect(bArrNativeSerialize.length).put(bArrNativeSerialize);
        byteBufferPut.flip();
        Channels.newChannel(outputStream).write(byteBufferPut);
    }

    public ARAugmentedImageDatabase(ARSession aRSession, long j10) {
        this.mSession = aRSession;
        this.mNativeDatabaseHandle = j10;
    }

    public int addImage(String str, Bitmap bitmap, float f10) {
        if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            return 0;
        }
        return nativeAddImageWithPhysicalSize(this.mSession.mNativeHandle, this.mNativeDatabaseHandle, str, convertBitmapToGrayScaleByteArray(bitmap), bitmap.getWidth(), bitmap.getHeight(), bitmap.getWidth(), f10);
    }
}
