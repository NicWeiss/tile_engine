package com.nicweiss.tileengine.Lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.nicweiss.tileengine.Generic.BaseObject;

public class Font {
    private BaseObject[] fontImages;
    private String txt;

    public void setText(String text) {
        txt = text;
        String[] charArray = text.split("");
        fontImages = new BaseObject[charArray.length];

        float previousWidth = 0;

        for (int i = 0; i < charArray.length-1; i++) {
            BaseObject charObject = new BaseObject();
            charObject.setImage("Components/Font/" + (int)text.charAt(i) + ".png");
            charObject.setX(previousWidth);
            previousWidth = previousWidth + charObject.getWidth();
            fontImages[i] = charObject;
        }
    }

    public void draw(Batch batch, String ttl, float x, float y){
        float previousWidth = x;

        for (int i = 0; i < fontImages.length-1; i++) {
            fontImages[i].draw(batch);
            fontImages[i].setX(previousWidth);
            fontImages[i].setY(y);
            previousWidth = previousWidth + fontImages[i].getWidth();
        }
    }
}
