package com.nicweiss.tileengine.Components.Ui.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.nicweiss.tileengine.Components.Ui.UiObject;
import com.nicweiss.tileengine.Generic.Store;
import com.nicweiss.tileengine.Lib.Font;


public class ButtonCommon extends UiObject {
    private Texture touchedImg;
    private Texture unTouchedImg;
    private Font fontTitle;

    public void init(Store store) {
        this.store = store;
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
        fontTitle.draw(
                batch,
                title,
                ((store.display.get("width") / 2) - (fontTitle.getWidth() / 2)),
                ((img.getHeight()/2) + (getY()) + fontTitle.getHeight()/2)
        );
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
        fontTitle = new Font(24, Color.WHITE);
        fontTitle.setText(title);
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
