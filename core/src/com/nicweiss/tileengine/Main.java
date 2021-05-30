package com.nicweiss.tileengine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.nicweiss.tileengine.Views.Logo;

import static com.badlogic.gdx.Application.LOG_INFO;


public class Main extends ApplicationAdapter {
	ExtendViewport viewport;
	public static OrthographicCamera camera;

	public static View view;
	public static Store store;
	public static

	SpriteBatch batch;


	@Override
	public void create () {
		Gdx.app.setLogLevel(LOG_INFO);

		store = new Store();
		store.init();

		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
//		Gdx.app.log("CREATE! ", "screenWidth: " + String.valueOf(screenWidth) + " - screenHeight: " + String.valueOf(screenHeight));

		float ratioX = 0;
		float ratioY = 0;

		for (float i = screenWidth; i != 0; i--) {
			ratioX = screenWidth / i;
			ratioY = screenHeight / i;
			float divisionRemainderX = ratioX - (int) ratioX;
			float divisionRemainderY = ratioY - (int) ratioY;

			if ((divisionRemainderX == 0) && (divisionRemainderY == 0)) {
				break;
			}
		}

		float newWidth = Store.display.get("width");
		float newHeight = ((float) newWidth / ratioX) * ratioY;
		Store.display.put("height", newHeight);

		camera = new OrthographicCamera();
		viewport = new ExtendViewport(newWidth, newHeight, camera);
		viewport.apply();
		camera.position.set(newWidth / 2, newHeight / 2, 0);
		changeView(new Logo());
		batch = new SpriteBatch();
	}

	public static void changeView(View newView){
		if(view!=null) {
			view.destruct();
			view = null;
		}
		System.gc();
		view = newView;
		view.init();
		Gdx.input.setInputProcessor(view);
		Gdx.input.setCatchBackKey(true);
	}


	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		viewport.update(width, height);
	}

	@Override
	public void render () {
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		view.render(batch);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
