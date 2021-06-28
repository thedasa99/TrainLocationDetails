/**
 *
 */package com.prajwal.hc.trainrunningtrack.listdata;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.prajwal.hc.trainrunningtrack.MainNotesDisplaypage;
import com.prajwal.hc.trainrunningtrack.R;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;

public class ItemListAdapter extends ArrayAdapter<Item> {

	Context context;
	public ItemListAdapter(Context context, List<Item> items) {
		super(context, 0, items);
		li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		final Item item = getItem(position);


		ViewHolder holder;

			convertView = li.inflate(R.layout.item, null);
			holder = new ViewHolder(convertView);
			holder.caption.setText(item.getCaption());
		    holder.id.setText(""+(position) );

		try {

			//holder.size.setText(item.size);


		}catch (Exception e){}



		final int idn= item.getId();
		final String TemCaption=item.getCaption();
		final String TemURL= item.getUrl();




		holder.lclick.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent i = new Intent( context, MainNotesDisplaypage.class);
				i.putExtra("id", idn );
				i.putExtra("caption", TemCaption );
			    i.putExtra("url", TemURL );
				 context. startActivity(i);
			}
		});

		return convertView;
	}

	@Override
	public long getItemId(int position) {
		return getItem(position).getId();
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	private LayoutInflater li;

	private static class ViewHolder {
		public ViewHolder(View root) {
			lclick = (LinearLayout) root.findViewById(R.id.linearlayoutclick);
			id = (TextView) root.findViewById(R.id.itemId);
			caption = (TextView) root.findViewById(R.id.itemCaption);

		//	size = (TextView) root.findViewById(R.id.itemdsize);

			//imageButton= (Button) root.findViewById(R.id.button);

		 }



		public TextView id;
		public TextView caption;
	    public LinearLayout lclick;

	}
}
