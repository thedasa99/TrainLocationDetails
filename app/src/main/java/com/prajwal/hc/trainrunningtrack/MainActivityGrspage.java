package com.prajwal.hc.trainrunningtrack;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.prajwal.hc.trainrunningtrack.listdata.Item;
import com.prajwal.hc.trainrunningtrack.listdata.ItemListAdapter;
import com.prajwal.hc.trainrunningtrack.listdata.ItemListAdapterGr;

import java.util.ArrayList;

public class MainActivityGrspage extends AppCompatActivity {

    public static ArrayList<Item> Itemlist = new ArrayList<Item>();
    ItemListAdapterGr adapter;
    public Context context;
    Activity myActivity;

int id=0;
    ListView listView;
   ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grspage);
        context=this.getApplicationContext();
        myActivity=this;



        try {

            Itemlist.clear();
            int id=1;
            Item chapter1= new Item(id);
            chapter1.setCaption(" 1.Various authorities to proceed under Absolute Block System ");
            chapter1.setDiscription("" );
            chapter1.setUrl("file:///android_asset/gr/"+id+".html");
            Itemlist.add(chapter1);

            id=id+1;
            Item chapter2= new Item(id);
            chapter2.setCaption(" 2.Authorities used during Signal failures   ");
            chapter2.setDiscription("" );
            chapter2.setUrl("file:///android_asset/gr/"+id+".html");
            Itemlist.add(chapter2);

            id=id+1;
            Item chapter3= new Item(id);
            chapter3.setCaption(" 3.Shunting authorities in Absolute Block System   ");
            chapter3.setDiscription("" );
            chapter3.setUrl("file:///android_asset/gr/"+id+".html");
            Itemlist.add(chapter3);

            id=id+1;
            Item chapter4= new Item(id);
            chapter4.setCaption(" 4. Procedures followed during signal passing at danger(SPAD)");
            chapter4.setDiscription("" );
            chapter4.setUrl("file:///android_asset/gr/"+id+".html");
            Itemlist.add(chapter4);

            id=id+1;
            Item chapter5= new Item(id);
            chapter5.setCaption(" 5. Procedures followed during signal passing at danger(SPAD) ");
            chapter5.setDiscription("" );
            chapter5.setUrl("file:///android_asset/gr/"+id+".html");
            Itemlist.add(chapter5);

            id=id+1;
            Item chapter6= new Item(id);
            chapter6.setCaption(" 6. Stopping the Train after passing the Starter in OFF aspect ");
            chapter6.setDiscription("" );
            chapter6.setUrl("file:///android_asset/gr/"+id+".html");
            Itemlist.add(chapter6);


            id=id+1;
            Item chapter7= new Item(id);
            chapter7.setCaption(" 7. Train in a block section without Authority to Proceed and stopped outside station limits ");
            chapter7.setDiscription("" );
            chapter7.setUrl("file:///android_asset/gr/"+id+".html");
            Itemlist.add(chapter7);


            id=id+1;
            Item chapter8= new Item(id);
            chapter8.setCaption(" 8. Running of Goods Trains without Guard/BV");
            chapter8.setDiscription("" );
            chapter8.setUrl("file:///android_asset/gr/"+id+".html");
            Itemlist.add(chapter8);


            id=id+1;
            Item chapter9= new Item(id);
            chapter9.setCaption(" 9. Reporting of Rough /Slack running   ");
            chapter9.setDiscription("" );
            chapter9.setUrl("file:///android_asset/gr/"+id+".html");
            Itemlist.add(chapter9);

            id=id+1;
            Item chapter10= new Item(id);
            chapter10.setCaption(" 10. Exchange of All Right signals   ");
            chapter10.setDiscription("" );
            chapter10.setUrl("file:///android_asset/gr/"+id+".html");
            Itemlist.add(chapter10);

            id=id+1;
            Item chapter11= new Item(id);
            chapter11.setCaption(" 11. Engine Pushing    ");
            chapter11.setDiscription("" );
            chapter11.setUrl("file:///android_asset/gr/"+id+".html");
            Itemlist.add(chapter11);


            id=id+1;
            Item chapter12= new Item(id);
            chapter12.setCaption(" 12. Tail Board/ Tail Lamp    ");
            chapter12.setDiscription("" );
            chapter12.setUrl("file:///android_asset/gr/"+id+".html");
            Itemlist.add(chapter12);

            id=id+1;
            Item chapter13= new Item(id);
            chapter13.setCaption(" 13. Movement against Direction of Traffic- Automatic Area    ");
            chapter13.setDiscription("" );
            chapter13.setUrl("file:///android_asset/gr/"+id+".html");
            Itemlist.add(chapter13);

            id=id+1;
            Item chapter14= new Item(id);
            chapter14.setCaption(" 14. Speed of Trains- Thick/ Foggy weather   ");
            chapter14.setDiscription("" );
            chapter14.setUrl("file:///android_asset/gr/"+id+".html");
            Itemlist.add(chapter14);

        }catch (Exception e){
e.printStackTrace();
        }

        listView = (ListView) findViewById(R.id.listView);
        adapter = new ItemListAdapterGr(myActivity,Itemlist );

        listView.setAdapter(adapter);
        listView.invalidateViews();


    }
}