package com.nicweiss.tileengine.Components.Ui;

import com.badlogic.gdx.Gdx;
import com.nicweiss.tileengine.Generic.BaseObject;

public class UiObject extends BaseObject {
    public String title;

    public interface Callback{
        void callingBack(String str);
    }

    public Callback callback;

    public void registerCallBack(Callback callback){
        this.callback = callback;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
