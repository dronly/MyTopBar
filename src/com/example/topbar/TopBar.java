package com.example.topbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressLint("NewApi") public class TopBar extends RelativeLayout{

	private Button leftButton, rightButton;
	private TextView tvTitle;
	
	private int leftTextColor;
	private Drawable leftBackground;
	private String leftTitle;
	
	private int rightTextColor;
	private Drawable rightBackground;
	private String rightTitle;
	
	private float titleTextSize;
	private int titleTextColor;
	private String titleText;
	
	private TopBarClickListener topBarClickListener;
	
	public interface TopBarClickListener{
		public void leftClick();
		public void rightClick();
	}
	
	public void setOnTopBarClickListener(TopBarClickListener listener){
		this.topBarClickListener = listener;
	}
	
	private LayoutParams leftParams, rightParams, titleParams; 
	
	@SuppressLint("NewApi") public TopBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.TopBar);
		
		leftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);
		leftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
		leftTitle = ta.getString(R.styleable.TopBar_leftText);
		
		rightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, 0);
		rightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);
		rightTitle = ta.getString(R.styleable.TopBar_rightText);
		
		titleText = ta.getString(R.styleable.TopBar_titleText);
		titleTextColor = ta.getColor(R.styleable.TopBar_titleTextColor, 0);
		titleTextSize = ta.getDimension(R.styleable.TopBar_titleTextSize, 0);
		
		ta.recycle();
		
		leftButton = new Button(context);
		rightButton = new Button(context);
		tvTitle = new TextView(context);
		
		leftButton.setTextColor(leftTextColor);
		leftButton.setBackground(leftBackground);
		leftButton.setText(leftTitle);
		
		
		rightButton.setTextColor(rightTextColor);
		rightButton.setBackground(rightBackground);
		rightButton.setText(rightTitle);
		
		tvTitle.setText(titleText);
		tvTitle.setTextColor(titleTextColor);
		tvTitle.setTextSize(titleTextSize);
		tvTitle.setGravity(Gravity.CENTER);
		
		setBackgroundColor(0xFF101010);
		
		leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
		addView(leftButton,leftParams);
		
		rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
		addView(rightButton, rightParams);

		titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
		addView(tvTitle,titleParams);
		
		leftButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				topBarClickListener.leftClick();
			}
		});
		rightButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				topBarClickListener.rightClick();
			}
		});
		
	}

	public void setLeftIsvisable(boolean flag){
		if(flag){
			leftButton.setVisibility(View.VISIBLE);
		}else{
			leftButton.setVisibility(View.GONE);
		}
	}
	
}
