package com.prajwal.hc.trainrunningtrack.listdata;

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

import com.prajwal.hc.trainrunningtrack.R;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;

public class itemadaptertemple {
     /*

    public class ItemListAdapter extends ArrayAdapter<Item> {


        Context context;
        public ItemListAdapter(Context context, List<Item> items) {
            super(context, 0, items);
            li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // The item we want to get the view for
            // --
            final Item item = getItem(position);

            // Re-use the view if possible
            // --
            com.prajwal.hc.trainrunningtrack.listdata.ItemListAdapter.ViewHolder holder;

            convertView = li.inflate(R.layout.item, null);
            holder = new com.prajwal.hc.trainrunningtrack.listdata.ItemListAdapter.ViewHolder(convertView);
            holder.caption.setText(item.getCaption());
            holder.desc.setText(item.getDiscription());
            holder.id.setText(""+(position+1) );

            try {

                //holder.size.setText(item.size);


            }catch (Exception e){}

            try{
                if(item._image!=null){

                    byte[] outImage=item._image;
                    ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
                    Bitmap theImage = BitmapFactory.decodeStream(imageStream);
                    BitmapDrawable drawable = new BitmapDrawable(this.context.getResources(), theImage);
                    holder.lclick.setBackground(drawable);
                    //Global.Msg_Toast("i"+theImage.getByteCount(),context);

                }
            }catch(Exception e){}

            final int idn= item.getId();
            final String TemCaption=item.getCaption();
            final String TemURL= item.getUrl();
            final String TemDesc=item.getDiscription();
            final String filename=item.getUrl();
            final String  TempSubject=item.getSUBJECT();

            try {
                File SDCardRoot = Environment.getExternalStorageDirectory();
                final String RingtonePath = new String(SDCardRoot + File.separator + AllInServicePref_files.FolderPathname + File.separator + "HC_" + idn + TemCaption + filename);
                final File oldfile = new File(RingtonePath);
                if (oldfile.exists()) {
                    // Bitmap bmp = BitmapFactory.decodeFile(oldfile.getAbsolutePath());
                    //ByteArrayInputStream imageStream = new ByteArrayInputStream(byteArray);
                    //   Bitmap theImage = BitmapFactory.decodeStream(imageStream);
                    // Bitmap bitmapResized = Bitmap.createScaledBitmap(bmp, 150, 100, false);
                    // BitmapDrawable drawable = new BitmapDrawable(context.getResources(), bitmapResized);
                    // holder.lclick.setBackground(drawable);
                }

            }catch (Exception e){}

            holder.lclick.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    // Intent i = new Intent( context, OnlineWebActionBarControlWebViewActivity.class);
                    // Intent i = new Intent( context, OnlineSingleListItem.class);


                    //	Intent i = new Intent( context, PlayMusicmy.class);
                    //	Intent i = new Intent( context, PlayerViewDemoActivity.class);
                    Intent i = new Intent( context, VideoPlayerPage.class);
                    i.putExtra("id", idn );
                    i.putExtra("caption", TemCaption );
                    i.putExtra("desc", TemDesc );
                    i.putExtra("url", TemURL );
                    i.putExtra("subject", TempSubject );
                    i.putExtra("filename", filename );

                    Global.	SubjectSelectedId=idn;
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
                desc = (TextView) root.findViewById(R.id.itemdiscription);
                //	size = (TextView) root.findViewById(R.id.itemdsize);

                //imageButton= (Button) root.findViewById(R.id.button);

            }



            public TextView id;
            public TextView caption;
            public TextView desc;
            public TextView size;
            public Button imageButton;
            public LinearLayout lclick;

        }
    }
*/
}
