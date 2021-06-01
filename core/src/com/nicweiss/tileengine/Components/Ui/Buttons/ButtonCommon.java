package com.nicweiss.tileengine.Components.Ui.Buttons;

import com.badlogic.gdx.Gdx;
import com.nicweiss.tileengine.Components.Ui.UiObject;

public class ButtonCommon extends UiObject {
    public void init(){
        setImage("Components/Buttons/600x200_common_button.png");
        setY(1000);
        setX(1080/2 -300);
                Gdx.app.log("Debug","Common button created");
    }

    @Override
    public void onTouch() {
        y = getY() + 10;
        setY(y);
        callback.callingBack("Button touched!!!");
    }
}
