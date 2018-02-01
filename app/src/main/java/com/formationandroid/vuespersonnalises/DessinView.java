package com.formationandroid.vuespersonnalises;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DessinView extends View
{
	
	// Infos :
	private float rayonMax = 0;
	private int couleurRond = 0;
	
	// Pinceau :
	private Paint paint = null;
	
	// Coordonnées rond :
	private float xCentre = -1;
	private float yCentre = -1;
	
	
	/**
	 * Constructeur.
	 * @param context Context
	 */
	public DessinView(Context context)
	{
		super(context);
		init(context, null);
	}
	
	/**
	 * Constructeur.
	 * @param context Context
	 * @param attrs Attributs
	 */
	public DessinView(Context context, @Nullable AttributeSet attrs)
	{
		super(context, attrs);
		init(context, attrs);
	}
	
	/**
	 * Constructeur.
	 * @param context Context
	 * @param attrs Attributs
	 * @param defStyleAttr Style
	 */
	public DessinView(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
		init(context, attrs);
	}
	
	/**
	 * Suite constructeur.
	 * @param context Context
	 * @param attrs Attributs
	 */
	private void init(Context context, AttributeSet attrs)
	{
		if (context != null && attrs != null)
		{
			// infos :
			rayonMax = context.getResources().getDimension(R.dimen.main_rayon_max_rond);
			
			// récupération d'un tableau d'arguments :
			TypedArray arguments = context.obtainStyledAttributes(attrs, R.styleable.DessinView);
			
			// lecture de chaque argument :
			couleurRond = arguments.getColor(R.styleable.DessinView_couleurRond, 0);
			
			// IMPORTANT !! ne pas oublier :
			arguments.recycle();
			
			// pinceau :
			paint = new Paint(Paint.ANTI_ALIAS_FLAG);
			paint.setColor(couleurRond);
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		// init :
		super.onDraw(canvas);
		
		// dessin d'un rond aléatoire :
		if (xCentre > -1 && yCentre > -1)
		{
			// dessin :
			canvas.drawCircle(xCentre, yCentre, (int) (Math.random() * rayonMax), paint);
			
			// remise à -1 des coordonnées pour ne pas redessiner à chaque passage :
			xCentre = -1;
			yCentre = -1;
		}
	}
	
	/**
	 * Demande de dessin de rond.
	 * @param xCentre Abscisse du centre du rond
	 * @param yCentre Ordonnée du centre du rond
	 */
	public void dessinerRond(float xCentre, float yCentre)
	{
		this.xCentre = xCentre;
		this.yCentre = yCentre;
		invalidate();
	}
	
}
