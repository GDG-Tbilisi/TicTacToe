package com.stichoza.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

import com.google.ads.*;

public class TicTacToeActivity extends Activity {

	int scoreO = 0;
	int scoreX = 0;
	
	int i1 = -1;
	int i2 = -1;
	int i3 = -1;
	int i4 = -1;
	int i5 = -1;
	int i6 = -1;
	int i7 = -1;
	int i8 = -1;
	int i9 = -1;
	
	int nextShape = 1;

	int isGameFinished = 0;
	int gameStartedBy = -1;

    private TextView scoreTextX;
    private TextView scoreTextO;
    private ImageView b1;
    private ImageView b2;
    private ImageView b3;
    private ImageView b4;
    private ImageView b5;
    private ImageView b6;
    private ImageView b7;
    private ImageView b8;
    private ImageView b9;
    private ImageView nextTurnImg;
    
   
    private AdView adView;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.nextTurnImg = (ImageView) findViewById(R.id.ImageViewTurn);
        this.b1 = (ImageView) findViewById(R.id.ImageView1);
        this.b2 = (ImageView) findViewById(R.id.ImageView2);
        this.b3 = (ImageView) findViewById(R.id.ImageView3);
        this.b4 = (ImageView) findViewById(R.id.ImageView4);
        this.b5 = (ImageView) findViewById(R.id.ImageView5);
        this.b6 = (ImageView) findViewById(R.id.ImageView6);
        this.b7 = (ImageView) findViewById(R.id.ImageView7);
        this.b8 = (ImageView) findViewById(R.id.ImageView8);
        this.b9 = (ImageView) findViewById(R.id.ImageView9);

        this.scoreTextX = (TextView) findViewById(R.id.scoreBoardx);
        this.scoreTextO = (TextView) findViewById(R.id.scoreBoardo);

    	scoreTextX.setText(""+scoreX);
    	scoreTextO.setText(""+scoreO);
    	nextTurnImg.setImageResource(R.drawable.ximg);
    	
    	
    	/*
        this.adView = (AdView) findViewById(R.id.llay);
        AdRequest re = new AdRequest();
        re.setTesting(true);
        re.setGender(AdRequest.Gender.FEMALE);
        adView.loadAd(re);*/
    	
    	
    	adView = new AdView(this, AdSize.BANNER, "a14f5b57ed42da6");
    	LinearLayout tbl = (LinearLayout) findViewById(R.id.llay);
        // Add the adView to it
        tbl.addView(adView);
        // Initiate a generic request to load it with an ad
        adView.loadAd(new AdRequest());
    	
    	
    	
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
			public void onClick(View v) {
            	i1 = drawShape(b1, i1);
    	        checkGame();
            }
        });
        
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
			public void onClick(View v) {
            	i2 = drawShape(b2, i2);
    	        checkGame();
            }
        });
        
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
			public void onClick(View v) {
            	i3 = drawShape(b3, i3);
    	        checkGame();
            }
        });
        
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
			public void onClick(View v) {
            	i4 = drawShape(b4, i4);
    	        checkGame();
            }
        });
        
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
			public void onClick(View v) {
            	i5 = drawShape(b5, i5);
    	        checkGame();
            }
        });
        
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
			public void onClick(View v) {
            	i6 = drawShape(b6, i6);
    	        checkGame();
            }
        });
        
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
			public void onClick(View v) {
            	i7 = drawShape(b7, i7);
    	        checkGame();
            }
        });
        
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
			public void onClick(View v) {
            	i8 = drawShape(b8, i8);
    	        checkGame();
            }
        });
        
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
			public void onClick(View v) {
            	i9 = drawShape(b9, i9);
    	        checkGame();
            }
        });
        
    }
    
    
    private int drawShape(ImageView xa, int kff) {
    	int derp;
    	if (isGameFinished == 0) {
	        if (kff == -1) {
		        if (nextShape == 1) {
		        	if (gameStartedBy == -1) {
		        		gameStartedBy = 1;
		        	}
		        	xa.setImageResource(R.drawable.ximg);
		        	derp = 1;
		        	nextShape = 0;
		        	nextTurnImg.setImageResource(R.drawable.oimg);
		        } else {
		        	if (gameStartedBy == -1) {
		        		gameStartedBy = 0;
		        	}
		       		xa.setImageResource(R.drawable.oimg);
		       		derp = 0;
		       		nextShape = 1;
		        	nextTurnImg.setImageResource(R.drawable.ximg);
		       	}
		       	return derp;
	       	} else {
	       		Toast.makeText(TicTacToeActivity.this, R.string.already, Toast.LENGTH_SHORT).show();
	       		return kff;
	       	}
    	} else {
    		
    		/*
    		AlertDialog.Builder builder = new AlertDialog.Builder(TicTacToeActivity.this);
    		builder.setMessage("Are you sure you want to send?")
    		       .setCancelable(false)
    		       .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
    		           public void onClick(DialogInterface dialog, int id) {
    		        	   Toast.makeText(TicTacToeActivity.this, "ggg", Toast.LENGTH_SHORT).show();
    		        	   newGame();
    		           }
    		       })
    		       .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
    		           public void onClick(DialogInterface dialog, int id) {
    		                dialog.cancel();
    		           }
    		       });
    		AlertDialog alert = builder.create();
    		alert.show();
    		*/
    		newGame();
        	gameStartedBy = -1;
    		return -1;
    	}
    }
    
    
    private int checkGame() {
    	if (
    			(i1 == 1 && i2 == 1 && i3 == 1) || (i4 == 1 && i5 == 1 && i6 == 1) || (i7 == 1 && i8 == 1 && i9 == 1)
    			|| (i1 == 1 && i4 == 1 && i7 == 1) ||(i2 == 1 && i5 == 1 && i8 == 1) ||(i3 == 1 && i6 == 1 && i9 == 1)
    			|| (i1 == 1 && i5 == 1 && i9 == 1) ||(i3 == 1 && i5 == 1 && i7 == 1)
    			) {
    		Toast.makeText(TicTacToeActivity.this, R.string.won_x, Toast.LENGTH_SHORT).show();
    		scoreX++;
    		nextShape = 1;
        	nextTurnImg.setImageResource(R.drawable.ximg);
    		isGameFinished = 1;
        	gameStartedBy = -1;
        	scoreTextX.setText(""+scoreX);
        	scoreTextO.setText(""+scoreO);
    		return 1;
    	} else if (
    			(i1 == 0 && i2 == 0 && i3 == 0) || (i4 == 0 && i5 == 0 && i6 == 0) || (i7 == 0 && i8 == 0 && i9 == 0)
    			|| (i1 == 0 && i4 == 0 && i7 == 0) ||(i2 == 0 && i5 == 0 && i8 == 0) ||(i3 == 0 && i6 == 0 && i9 == 0)
    			|| (i1 == 0 && i5 == 0 && i9 == 0) ||(i3 == 0 && i5 == 0 && i7 == 0)
    			) {
    		Toast.makeText(TicTacToeActivity.this, R.string.won_o, Toast.LENGTH_SHORT).show();
    		scoreO++;
    		nextShape = 0;
        	nextTurnImg.setImageResource(R.drawable.oimg);
    		isGameFinished = 1;
        	gameStartedBy = -1;
        	scoreTextX.setText(""+scoreX);
        	scoreTextO.setText(""+scoreO);
    		return 0;
    	} else if (i1 != -1 && i2 != -1 && i3 != -1 && 
    				i4 != -1 && i5 != -1 && i6 != -1 && 
    				i7 != -1 && i8 != -1 && i9 != -1) {
    		Toast.makeText(TicTacToeActivity.this, R.string.won_no, Toast.LENGTH_SHORT).show();
    		isGameFinished = 1;
        	gameStartedBy = -1;
    		return -1;
    	} else {
        	return -1;
    	}
    }
    
    private void newGame() {
    	b1.setImageResource(R.drawable.eimg);
    	b2.setImageResource(R.drawable.eimg);
    	b3.setImageResource(R.drawable.eimg);
    	b4.setImageResource(R.drawable.eimg);
    	b5.setImageResource(R.drawable.eimg);
    	b6.setImageResource(R.drawable.eimg);
    	b7.setImageResource(R.drawable.eimg);
    	b8.setImageResource(R.drawable.eimg);
    	b9.setImageResource(R.drawable.eimg);
    	i1 = -1;
    	i2 = -1;
    	i3 = -1;
    	i4 = -1;
    	i5 = -1;
    	i6 = -1;
    	i7 = -1;
    	i8 = -1;
    	i9 = -1;
    	isGameFinished = 0;
    	Toast.makeText(TicTacToeActivity.this, R.string.new_starting, Toast.LENGTH_SHORT).show();
    }
     
    
    @Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            new AlertDialog.Builder(this)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle(R.string.quit_title)
            .setMessage(R.string.quit_msg)
            .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                	TicTacToeActivity.this.finish();
                }
            })
            .setNegativeButton(R.string.no, null)
            .show();
            return true;
        }
        else {
            return super.onKeyDown(keyCode, event);
        }
    }
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return true;
    }
    
    
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
	        case R.id.res_whl:
	        	scoreO = 0;
	        	scoreX = 0;
	        	scoreTextX.setText("0");
	        	scoreTextO.setText("0");
	        	//return true; BLOCKED because must do next too
	        case R.id.res_curr:
	            newGame();
	            nextShape = gameStartedBy;
	            if (nextShape == 1) {
	            	nextTurnImg.setImageResource(R.drawable.ximg);
	            } else {
	            	nextTurnImg.setImageResource(R.drawable.oimg);
	            }
	        	gameStartedBy = -1;
	            return true;
	        case R.id.aboutt:
	        	AlertDialog abb = new AlertDialog.Builder(this).create();  
	        	//abb.setCancelable(false); // This blocks the 'BACK' button
	        	abb.setIcon(android.R.drawable.ic_dialog_info);
	            abb.setTitle(R.string.about_title);
	        	abb.setMessage(getString(R.string.about_body));  
	        	abb.setButton(getString(R.string.about_quit), new DialogInterface.OnClickListener() {  
	        	    @Override  
	        	    public void onClick(DialogInterface dialog, int which) {  
	        	        dialog.dismiss();                      
	        	    }  
	        	});  
	        	abb.show();  
	        	return true;
	        case R.id.exitt:
	        	new AlertDialog.Builder(this)
	            .setIcon(android.R.drawable.ic_dialog_alert)
	            .setTitle(R.string.quit_title)
	            .setMessage(R.string.quit_msg)
	            .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
	                @Override
	                public void onClick(DialogInterface dialog, int which) {
	                	TicTacToeActivity.this.finish();
	                }
	            })
	            .setNegativeButton(R.string.no, null)
	            .show();
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
        }
    }
    
    
    @Override
    public void onDestroy() {
      adView.destroy();
      super.onDestroy();
    }

}