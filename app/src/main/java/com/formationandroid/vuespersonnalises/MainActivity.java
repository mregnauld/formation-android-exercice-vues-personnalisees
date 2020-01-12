package com.formationandroid.vuespersonnalises;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener
{
	
	// Vues :
	private DessinView dessinView = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// init :
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// vues :
		dessinView = findViewById(R.id.vue_dessin);
		
		// listener :
		dessinView.setOnTouchListener(this);
	}
	
	@Override
	public boolean onTouch(View view, MotionEvent event)
	{
		// les constantes de type ACTION_POINTER_XXX permettent de traiter des événements multitouch :
		if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_POINTER_DOWN)
		{
			dessinView.dessinerRond(event.getX(), event.getY());
			return true;
		}
		return false;
	}
	
}
