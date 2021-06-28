package com.prajwal.hc.trainrunningtrack;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.prajwal.hc.trainrunningtrack.listdata.Item;
import com.prajwal.hc.trainrunningtrack.listdata.ItemListAdapter;

import java.util.ArrayList;

public class MainActivityBPCRules extends AppCompatActivity {

    public static ArrayList<Item> Itemlist = new ArrayList<Item>();
    ItemListAdapter adapter;
    public Context context;
    Activity myActivity;

       ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bpcrules);
        context=this.getApplicationContext();
        myActivity=this;


        try {

            Itemlist.clear();
              int id=1;
                Item chapter1= new Item(id);
                chapter1.setCaption(" 1.Intensive BPC   ");
                chapter1.setDiscription("" );
                chapter1.setUrl("file:///android_asset/bpc/"+id+".html");
                Itemlist.add(chapter1);

             id=id+1;
            Item chapter2= new Item(id);
            chapter2.setCaption(" 2.Intensive : End to End   ");
            chapter2.setDiscription("" );
            chapter2.setUrl("file:///android_asset/bpc/"+id+".html");
            Itemlist.add(chapter2);

            id=id+1;
            Item chapter3= new Item(id);
            chapter3.setCaption(" 3.Intensive: Green Color   ");
            chapter3.setDiscription("" );
            chapter3.setUrl("file:///android_asset/bpc/"+id+".html");
            Itemlist.add(chapter3);

            id=id+1;
            Item chapter4= new Item(id);
            chapter4.setCaption(" 4. Premium BPC ");
            chapter4.setDiscription("" );
            chapter4.setUrl("file:///android_asset/bpc/"+id+".html");
            Itemlist.add(chapter4);

            id=id+1;
            Item chapter5= new Item(id);
            chapter5.setCaption(" 5. Premium : End to End  ");
            chapter5.setDiscription("" );
            chapter5.setUrl("file:///android_asset/bpc/"+id+".html");
            Itemlist.add(chapter5);

            id=id+1;
            Item chapter6= new Item(id);
            chapter6.setCaption(" 6. Premium : Green Color ");
            chapter6.setDiscription("" );
            chapter6.setUrl("file:///android_asset/bpc/"+id+".html");
            Itemlist.add(chapter6);


            id=id+1;
            Item chapter7= new Item(id);
            chapter7.setCaption(" 7. Closed Circuit BPC ");
            chapter7.setDiscription("" );
            chapter7.setUrl("file:///android_asset/bpc/"+id+".html");
            Itemlist.add(chapter7);


            id=id+1;
            Item chapter8= new Item(id);
            chapter8.setCaption(" 8. Closed Circuit :Yellow  Color");
            chapter8.setDiscription("" );
            chapter8.setUrl("file:///android_asset/bpc/"+id+".html");
            Itemlist.add(chapter8);


            id=id+1;
            Item chapter9= new Item(id);
            chapter9.setCaption(" 9. Steel  Rake  BPC   ");
            chapter9.setDiscription("" );
            chapter9.setUrl("file:///android_asset/bpc/"+id+".html");
            Itemlist.add(chapter9);

            id=id+1;
            Item chapter10= new Item(id);
            chapter10.setCaption(" 10. Material train  BPC   ");
            chapter10.setDiscription("" );
            chapter10.setUrl("file:///android_asset/bpc/"+id+".html");
            Itemlist.add(chapter10);


         }catch (Exception e){

       }

        listView = (ListView) findViewById(R.id.listView);
        adapter = new ItemListAdapter(myActivity,Itemlist );

        listView.setAdapter(adapter);
        listView.invalidateViews();



    }
}