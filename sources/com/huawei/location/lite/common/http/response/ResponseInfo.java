package com.huawei.location.lite.common.http.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import as.C1016d;
import com.huawei.location.activity.C6738e;
import es.C9545j;
import es.C9552q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import p531or.C11991a;

/* loaded from: classes8.dex */
public class ResponseInfo implements Parcelable {
    public static final Parcelable.Creator<ResponseInfo> CREATOR = new C6788a();
    public static final int ERROR_EXCEPTION_LEVEL = 100;
    public static final int FAILURE_EXCEPTION_LEVEL = 101;
    private static final int MAX_TRANSFER_DATA_LIMIT = 468992;
    private static final String TAG = "ResponseInfo";
    private String bigDataPath;
    private int errorCode;
    private int errorLevel;
    private String msg;
    private byte[] responseBytes;
    private String responseString;

    /* renamed from: com.huawei.location.lite.common.http.response.ResponseInfo$a */
    public class C6788a implements Parcelable.Creator<ResponseInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResponseInfo createFromParcel(Parcel parcel) {
            return new ResponseInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResponseInfo[] newArray(int i10) {
            return new ResponseInfo[i10];
        }
    }

    public ResponseInfo() {
    }

    public ResponseInfo(Parcel parcel) {
        this.errorLevel = parcel.readInt();
        this.errorCode = parcel.readInt();
        this.msg = parcel.readString();
        this.responseString = parcel.readString();
        this.responseBytes = parcel.createByteArray();
        this.bigDataPath = parcel.readString();
    }

    private void readFromSd() throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.bigDataPath), StandardCharsets.UTF_8));
            try {
                StringBuilder sb2 = new StringBuilder("");
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        new File(this.bigDataPath).delete();
                        this.responseString = sb2.toString();
                        bufferedReader.close();
                        return;
                    }
                    sb2.append(line);
                }
            } finally {
            }
        } catch (IOException unused) {
            C1016d.m6183c("Fly", "readFromSd stream exception");
        }
    }

    private File saveToSd(byte[] bArr) throws IOException {
        File file = new File(this.bigDataPath);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                fileOutputStream.flush();
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
            C1016d.m6183c("Fly", "saveToSd write exception");
        }
        return file;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getErrorLevel() {
        return this.errorLevel;
    }

    public String getMsg() {
        return this.msg;
    }

    public byte[] getResponseBytes() {
        byte[] bArr = this.responseBytes;
        return bArr == null ? new byte[0] : (byte[]) bArr.clone();
    }

    public String getResponseString() throws IOException {
        if (!TextUtils.isEmpty(this.bigDataPath)) {
            readFromSd();
        }
        return this.responseString;
    }

    public void setErrorCode(int i10) {
        this.errorCode = i10;
    }

    public void setErrorLevel(int i10) {
        this.errorLevel = i10;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setResponseBytes(byte[] bArr) {
        if (bArr != null) {
            this.responseBytes = (byte[]) bArr.clone();
        }
    }

    public void setResponseString(String str) throws IOException {
        if (C9552q.m59643a() == 200 && !TextUtils.isEmpty(str)) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            if (bytes.length >= MAX_TRANSFER_DATA_LIMIT) {
                C1016d.m6186f(TAG, "response data over MAX_TRANSFER_DATA_LIMIT");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(C9545j.m59600a(C11991a.m72145a()));
                this.bigDataPath = C6738e.m38291a(sb2, File.separator, "http_parcelable_data.temp");
                saveToSd(bytes);
                return;
            }
        }
        this.responseString = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.errorLevel);
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.msg);
        parcel.writeString(this.responseString);
        parcel.writeByteArray(this.responseBytes);
        parcel.writeString(this.bigDataPath);
    }
}
