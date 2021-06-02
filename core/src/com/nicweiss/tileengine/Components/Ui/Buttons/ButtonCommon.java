package com.nicweiss.tileengine.Components.Ui.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.nicweiss.tileengine.Components.Ui.UiObject;

public class ButtonCommon extends UiObject {
    private Texture touchedImg;
    private Texture unTouchedImg;

    BitmapFont font = new BitmapFont();

    public void init(){
        setImage("Components/Buttons/600x200_common_button.png", false);
        setImage("Components/Buttons/600x200_common_button_touched.png", true);
    }

    @Override
    public void onTouch() {
        callback.callingBack(getObjectId());
    }

    @Override
    public void draw(Batch batch) {
        if (isTouched) {
            img = touchedImg;
        } else {
            img = unTouchedImg;
        }
        super.draw(batch);
        font.getData().setScale(6);
        font.draw(batch, title, getX() + (getWidth() / 2) - (title.length() * 30) + 40, getY() + 130);
    }

    public void setImage(String imageName, boolean touched) {
        Texture texture = new Texture(imageName);
        img = texture;
        if (touched) {
            touchedImg = texture;
        } else {
            unTouchedImg = texture;
        }
    }
}
