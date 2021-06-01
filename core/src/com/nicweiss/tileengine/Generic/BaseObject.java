package com.nicweiss.tileengine.Generic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;


public class BaseObject {
    protected float x;
    protected float y;
    protected int x_scale;
    protected int y_scale;
    protected Texture img;
    protected float rotation = 0;
    protected float opacity = 1;
    protected boolean deleted = false;


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        img.dispose();
    }

    public void draw(Batch batch) {
        if(img==null)return;
        if(deleted)return;

        batch.setColor(1, 1, 1, opacity);
        batch.draw(img,
                x , y ,
                x_scale / 2, y_scale / 2,
                img.getWidth(), img.getHeight(),
                1, 1,
                rotation,
                0, 0,
                img.getWidth(), img.getHeight(),
                false, false);
    }

    public void setTexture(Texture texture) {
        img = texture;
    }

    public void setImage(String imageName) {
        Texture texture = new Texture(imageName);
        img = texture;
    }


    public void checkTouch(float touch_x, float touch_y) {
        if (touch_x >= x && touch_x <= x + img.getWidth()) {
            if (touch_y >= y && touch_y <= y + img.getHeight()) {
                onTouch();
            }
        }
    }

    public void onTouch(){
        Gdx.app.log("Touch: ","YEP!");
    }

    public void touch(){

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getScaleOfX() {
        return x_scale;
    }

    public float getscaleOfY() {
        return y_scale;
    }

    public void setOpacity(float new_opacity) {
        opacity = new_opacity;
    }

    public void setX(float new_x) {
        x = new_x;
    }

    public void setY(float new_y) {
        y = new_y;
    }

    public void setScaleOfX(int new_scale_x) {
        x_scale = new_scale_x;
    }

    public void setScaleOfY(int new_scale_y) {
        y_scale = new_scale_y;
    }


    public void delete() {
        deleted = true;
    }

    public boolean statatus() {
        return deleted;
    }
}
