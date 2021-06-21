package com.nicweiss.tileengine.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nicweiss.tileengine.Generic.View;
import com.nicweiss.tileengine.Lib.Ui;


public class MapMenu extends View {

    public Ui ui;


    public MapMenu() {
        ui = new Ui(store);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public void render(SpriteBatch batch) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor((float) 0x00 / 0xff, (float) 0x00 / 0xff, (float) 0x00 / 0xff, 1);
    }
}
