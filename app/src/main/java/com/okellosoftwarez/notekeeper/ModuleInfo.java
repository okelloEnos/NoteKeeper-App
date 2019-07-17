package com.okellosoftwarez.notekeeper;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Okello Enos.
 */

public final class ModuleInfo implements Parcelable {
    private final String mModuleId;
    private final String mTitle;
    private boolean mIsComplete = false;

    public ModuleInfo(String moduleId, String title) {
        this(moduleId, title, false);
    }

    public ModuleInfo(String moduleId, String title, boolean isComplete) {
        mModuleId = moduleId;
        mTitle = title;
        mIsComplete = isComplete;
    }

    public ModuleInfo(Parcel parcel) {
        mModuleId = parcel.readString();
        mTitle = parcel.readString();
        mIsComplete = parcel.readByte() == 1;
    }

    public String getModuleId() {
        return mModuleId;
    }

    public String getTitle() {
        return mTitle;
    }

    public boolean isComplete() {
        return mIsComplete;
    }

    public void setComplete(boolean complete) {
        mIsComplete = complete;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModuleInfo that = (ModuleInfo) o;

        return mModuleId.equals(that.mModuleId);
    }

    @Override
    public int hashCode() {
        return mModuleId.hashCode();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mModuleId);
        parcel.writeString(mTitle);
        parcel.writeByte((byte) (mIsComplete ? 1 : 0));


    }
    public final static Parcelable.Creator<ModuleInfo> CREATOR = new Parcelable.Creator<ModuleInfo>(){

        @Override
        public ModuleInfo createFromParcel(Parcel parcel) {
            return new ModuleInfo(parcel);
        }

        @Override
        public ModuleInfo[] newArray(int i) {
            return new ModuleInfo[i];
        }
    };
}
