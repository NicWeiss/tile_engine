package com.nicweiss.tileengine.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nicweiss.tileengine.Main;
import com.nicweiss.tileengine.View;


public class Logo extends View{
    Texture logo;
    float opacity;
    int counter;
    ShapeRenderer shapeRenderer;

    public void init(){
        logo = new Texture("TELogo.png");
        opacity=1;
        counter = 150;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        openMenu();
        return false;
    }

    private void openMenu(){
        Main.changeView(new MainMenu());
    }

    public void render(SpriteBatch batch) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor((float)0x00/0xff , (float)0x00/0xff, (float)0x00/0xff, 1);

        float displayHeight = store.display.get("height");

        batch.draw(logo, 0,(displayHeight / 2) - (logo.getHeight() / 2));
        counter--;
        if(counter<0)
            opacity-=0.01;
        batch.setColor(1,1,1, opacity);

        if (opacity<0) {
            batch.setColor(1, 1, 1, 1);
            openMenu();
        }
    }

}