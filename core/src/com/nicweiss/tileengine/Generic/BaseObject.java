package com.nicweiss.tileengine.Generic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;


public class BaseObject {
    protected float x;
    protected float y;
    protected float x_scale = 1;
    protected float y_scale = 1;
    protected Texture img;
    protected float rotation = 0;
    protected float opacity = 1;
    protected boolean deleted = false;
    protected String objectId;
    protected boolean isTouched = false;


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        img.dispose();
    }

    public void draw(Batch batch) {
        if (img == null) return;
        if (deleted) return;

        batch.setColor(1, 1, 1, opacity);
        batch.draw(img,
                x, y,
                0, 0,
                img.getWidth() * x_scale, img.getHeight() * y_scale,
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
        this.isTouched = false;
        if (touch_x >= x && touch_x <= x + img.getWidth()) {
            if (touch_y >= y && touch_y <= y + img.getHeight()) {
                this.isTouched = true;
                onTouch();
            }
        }
    }

    public void touchOut() {
        isTouched = false;
    }

    public void onTouch() {
        Gdx.app.log("Touch: ", "YEP!");
    }

    public void touch() {

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

    public void setScaleOfX(float new_scale_x) {
        x_scale = new_scale_x;
    }

    public void setScaleOfY(float new_scale_y) {
        y_scale = new_scale_y;
    }


    public void delete() {
        deleted = true;
    }

    public boolean status() {
        return deleted;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public float getWidth() {
        return img.getWidth() * x_scale;
    }

    public float getHeight() {
        return img.getHeight() * y_scale;
    }
}
