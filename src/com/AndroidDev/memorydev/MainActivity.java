package com.AndroidDev.memorydev;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity implements OnClickListener{
	ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9, img10,
	          img11, img12, imgCapturada;
	Button    jugar, salir;
	TextView  idMensaje;
	int       capImg1, capImg2, capCtrl1, capCtrl2, contador=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		img1 = (ImageView)findViewById(R.id.Imagen1);
		img2 = (ImageView)findViewById(R.id.Imagen2);
		img3 = (ImageView)findViewById(R.id.Imagen3);
		img4 = (ImageView)findViewById(R.id.Imagen4);
		img5 = (ImageView)findViewById(R.id.Imagen5);
		img6 = (ImageView)findViewById(R.id.Imagen6);
		img7 = (ImageView)findViewById(R.id.Imagen7);
		img8 = (ImageView)findViewById(R.id.Imagen8);
		img9 = (ImageView)findViewById(R.id.Imagen9);
		img10 = (ImageView)findViewById(R.id.Imagen10);
		img11 = (ImageView)findViewById(R.id.Imagen11);
		img12 = (ImageView)findViewById(R.id.Imagen12);
		
		jugar = (Button)findViewById(R.id.BtnJugar);
		salir = (Button)findViewById(R.id.BtnSalir);
		
		idMensaje = (TextView)findViewById(R.id.TextContador);
		
		img1.setOnClickListener(this);
		img2.setOnClickListener(this);
		img3.setOnClickListener(this);
		img4.setOnClickListener(this);
		img5.setOnClickListener(this);
		img6.setOnClickListener(this);
		img7.setOnClickListener(this);
		img8.setOnClickListener(this);
		img9.setOnClickListener(this);
		img10.setOnClickListener(this);
		img11.setOnClickListener(this);
		img12.setOnClickListener(this);
		jugar.setOnClickListener(this);
		salir.setOnClickListener(this);
		
		desactivar();
	}

	
	public void desactivar(){
		img1.setEnabled(false);
		img2.setEnabled(false);
		img3.setEnabled(false);
		img4.setEnabled(false);
		img5.setEnabled(false);
		img6.setEnabled(false);
		img7.setEnabled(false);
		img8.setEnabled(false);
		img9.setEnabled(false);
		img10.setEnabled(false);
		img11.setEnabled(false);
		img12.setEnabled(false);
	}
	
	public void activar(){
		img1.setEnabled(true);
		img2.setEnabled(true);
		img3.setEnabled(true);
		img4.setEnabled(true);
		img5.setEnabled(true);
		img6.setEnabled(true);
		img7.setEnabled(true);
		img8.setEnabled(true);
		img9.setEnabled(true);
		img10.setEnabled(true);
		img11.setEnabled(true);
		img12.setEnabled(true);
	}
	
	public void comparar(int idImagen, int idControl, int rControl,final ImageView imagen){
		
		if(capImg1 == 0){
			capImg1 = idImagen;
			capCtrl1 = idControl;
			imgCapturada = (ImageView)findViewById(capCtrl1);
		}
		else{
			capCtrl2 = rControl;
			if(capCtrl2!= capCtrl1){
				capImg2 = idImagen;
				if(capImg1 != capImg2){
					Handler handler = new Handler();
					handler.postDelayed(new Runnable(){
						public void run(){
							imgCapturada.setImageResource(R.drawable.fondo);
							imagen.setImageResource(R.drawable.fondo);
						}
					}, 100);
					capImg1 = 0;
					capImg2 = 0;
				}
				else{
					imgCapturada.setEnabled(false);
					imagen.setEnabled(false);
					contador++;
					capImg1 = 0;
					capImg2 = 0;
				}
			}
			else{
				capCtrl2 = 0;
			}
		}
		
	}
	
	public void cronometro(){
		new CountDownTimer(60000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				jugar.setEnabled(false);
				idMensaje.setText(""+millisUntilFinished/1000);
				if(contador == 6){
					idMensaje.setText("Ganastes!!!");
					onFinish();
				}
				
			}
			
			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				desactivar();
				jugar.setEnabled(true);
				if(contador != 6){
					idMensaje.setText("Perdistes!!!");
				}
			}
		}.start();
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.Imagen1:
				img1.setImageResource(R.drawable.icono1);
				comparar(R.drawable.icono1, R.id.Imagen1, v.getId(), img1);
				break;
			case R.id.Imagen2:
				img2.setImageResource(R.drawable.icono2);
				comparar(R.drawable.icono2, R.id.Imagen2, v.getId(), img2);
				break;
			case R.id.Imagen3:
				img3.setImageResource(R.drawable.icono3);
				comparar(R.drawable.icono3, R.id.Imagen3, v.getId(), img3);
				break;
			case R.id.Imagen4:
				img4.setImageResource(R.drawable.icono4);
				comparar(R.drawable.icono4, R.id.Imagen4, v.getId(), img4);
				break;
			case R.id.Imagen5:
				img5.setImageResource(R.drawable.icono5);
				comparar(R.drawable.icono5, R.id.Imagen5, v.getId(), img5);
				break;
			case R.id.Imagen6:
				img6.setImageResource(R.drawable.icono6);
				comparar(R.drawable.icono6, R.id.Imagen6, v.getId(), img6);
				break;
			case R.id.Imagen7:
				img7.setImageResource(R.drawable.icono1);
				comparar(R.drawable.icono1, R.id.Imagen7, v.getId(), img7);
				break;
			case R.id.Imagen8:
				img8.setImageResource(R.drawable.icono2);
				comparar(R.drawable.icono2, R.id.Imagen8, v.getId(), img8);
				break;
			case R.id.Imagen9:
				img9.setImageResource(R.drawable.icono3);
				comparar(R.drawable.icono3, R.id.Imagen9, v.getId(), img9);
				break;
			case R.id.Imagen10:
				img10.setImageResource(R.drawable.icono4);
				comparar(R.drawable.icono4, R.id.Imagen10, v.getId(), img10);
				break;
			case R.id.Imagen11:
				img11.setImageResource(R.drawable.icono5);
				comparar(R.drawable.icono5, R.id.Imagen11, v.getId(), img11);
				break;
			case R.id.Imagen12:
				img12.setImageResource(R.drawable.icono6);
				comparar(R.drawable.icono6, R.id.Imagen12, v.getId(), img12);
				break;
			case R.id.BtnJugar:
				activar();
				cronometro();
				break;
			case R.id.BtnSalir:
				finish();
				break;
		}
		
	}

}
