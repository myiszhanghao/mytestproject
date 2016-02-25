package com.example.listviewdome;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import android.app.Activity;

public class MyListViewTest extends Activity {
	/** Called when the activity is first created. */
	ListView listView;
	MyAdapter listAdapter;
	ArrayList<String> listString;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_listview);
		
		listView = (ListView)this.findViewById(R.id.listview);
		listString = new ArrayList<String>();
		for(int i = 0 ; i < 100 ; i++){
			listString.add(Integer.toString(i));
		}
		listAdapter = new MyAdapter(this);
		listView.setAdapter(listAdapter);
	}
	
	class MyAdapter extends BaseAdapter{
		Context mContext;
		LinearLayout linearLayout = null;
		LayoutInflater inflater;
		TextView tex;
		final int VIEW_TYPE = 3;
		final int TYPE_1 = 0;
		final int TYPE_2 = 1;
		final int TYPE_3 = 2;

		public MyAdapter(Context context) {
			// TODO Auto-generated constructor stub
			mContext = context;
			inflater = LayoutInflater.from(mContext);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return listString.size();
		}

		//ÿ��convert view������ô˷�������õ�ǰ����Ҫ��view��ʽ
		@Override
		public int getItemViewType(int position) {
			// TODO Auto-generated method stub
			int p = position%6;
			if(p == 0)
			return TYPE_1;
			else if(p < 3)
				return TYPE_2;
			else if(p < 6)
				return TYPE_3;
			else
				return TYPE_1;
		}

		@Override
		public int getViewTypeCount() {
			// TODO Auto-generated method stub
			return 3;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return listString.get(arg0);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent){
			// TODO Auto-generated method stub
			viewHolder1 holder1 = null;
			viewHolder2 holder2 = null;
			viewHolder3 holder3 = null;
			int type = getItemViewType(position);

			//��convertView����Ҫnew�������ؼ�
			if(convertView == null){
				Log.e("convertView = ", " NULL");
				//����ǰ�������ʽ��ȷ��new�Ĳ���
				switch(type){
				case TYPE_1:
					convertView = inflater.inflate(R.layout.listitem1, parent, false);
					holder1 = new viewHolder1();
					holder1.textView = (TextView)convertView.findViewById(R.id.textview1);
					holder1.checkBox = (CheckBox)convertView.findViewById(R.id.checkbox);
					Log.e("convertView = ", "NULL TYPE_1");
					convertView.setTag(holder1);
					break;
				case TYPE_2:
					convertView = inflater.inflate(R.layout.listitem2, parent, false);
					holder2 = new viewHolder2();
					holder2.textView = (TextView)convertView.findViewById(R.id.textview2);
					Log.e("convertView = ", "NULL TYPE_2");
					convertView.setTag(holder2);
					break;
				case TYPE_3:
					convertView = inflater.inflate(R.layout.listitem3, parent, false);
					holder3 = new viewHolder3();
					holder3.textView = (TextView)convertView.findViewById(R.id.textview3);
					holder3.imageView = (ImageView)convertView.findViewById(R.id.imageview);
					Log.e("convertView = ", "NULL TYPE_3");
					convertView.setTag(holder3);
					break;
				}
			}else{
				//��convertView������ʽ��ȡ�ò��õĲ���
				switch(type){
				case TYPE_1:
					holder1 = (viewHolder1) convertView.getTag();
					Log.e("convertView !!!!!!= ", "NULL TYPE_1");
					break;
				case TYPE_2:
					holder2 = (viewHolder2) convertView.getTag();
					Log.e("convertView !!!!!!= ", "NULL TYPE_2");
					break;
				case TYPE_3:
					holder3 = (viewHolder3) convertView.getTag();
					Log.e("convertView !!!!!!= ", "NULL TYPE_3");
					break;
				}
			}
			
			//������Դ
			switch(type){
			case TYPE_1:
				holder1.textView.setText(Integer.toString(position));
				holder1.checkBox.setChecked(true);
				break;
			case TYPE_2:
				holder2.textView.setText(Integer.toString(position));
				break;
			case TYPE_3:
				holder3.textView.setText(Integer.toString(position));
				holder3.imageView.setBackgroundResource(R.drawable.ic_launcher);
				break;
			}

			return convertView;
		}
	}
	
	//�������ֵĿؼ���Դ
	class viewHolder1{
		CheckBox checkBox;
		TextView textView;
	}

	class viewHolder2{
		TextView textView;
	}

	class viewHolder3{
		ImageView imageView;
		TextView textView;
	}
}
