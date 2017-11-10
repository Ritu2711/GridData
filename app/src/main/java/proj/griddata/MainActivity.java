package proj.griddata;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ImageView img1,img2,img3,img4;
    GridLayout  pCareInstruct, pCareInstruction2;
    private final String android_version_names[] = {
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow"
    };

    private final String android_image_urls[] = {
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img2= (ImageView) findViewById(R.id.img2);
        img3= (ImageView) findViewById(R.id.img3);
        img4= (ImageView) findViewById(R.id.img4);
        pCareInstruction2= (GridLayout) findViewById(R.id.pCareInstruction2);
        pCareInstruct= (GridLayout) findViewById(R.id.pCareInstruct);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int height = 0;

                if(pCareInstruction2.getVisibility() == View.VISIBLE){
                    img4.setImageDrawable(getResources().getDrawable(R.drawable.parquet));
                    img4.setBackgroundColor(Color.TRANSPARENT);
                    MyCustomAnimation a = new MyCustomAnimation(pCareInstruction2, 500, MyCustomAnimation.COLLAPSE);
                    height = a.getHeight();
                    pCareInstruction2.startAnimation(a);
                }else{
                    img4.setBackgroundColor(Color.WHITE);
                    img4.setImageDrawable(getResources().getDrawable(R.drawable.parquetorange));
                    MyCustomAnimation a = new MyCustomAnimation(pCareInstruction2, 500, MyCustomAnimation.EXPAND);
                    a.setHeight(height);

                    pCareInstruction2.startAnimation(a);
                }

            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img3.setBackgroundColor(Color.TRANSPARENT);
                img3.setImageDrawable(getResources().getDrawable(R.drawable.sofa));
                int height = 0;
                if(pCareInstruct.getVisibility() == View.VISIBLE){

                    MyCustomAnimation a = new MyCustomAnimation(pCareInstruct, 500, MyCustomAnimation.COLLAPSE);
                    height = a.getHeight();
                    pCareInstruct.startAnimation(a);
                }else{
                    img3.setBackgroundColor(Color.WHITE);
                    img3.setImageDrawable(getResources().getDrawable(R.drawable.sofaorange));
                    MyCustomAnimation a = new MyCustomAnimation(pCareInstruct, 500, MyCustomAnimation.EXPAND);
                    a.setHeight(height);

                    pCareInstruct.startAnimation(a);
                }


            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img2.setBackgroundColor(Color.TRANSPARENT);
                img2.setImageDrawable(getResources().getDrawable(R.drawable.frame));
                int height = 0;
                if(pCareInstruct.getVisibility() == View.VISIBLE){

                    MyCustomAnimation a = new MyCustomAnimation(pCareInstruct, 500, MyCustomAnimation.COLLAPSE);
                    height = a.getHeight();
                    pCareInstruct.startAnimation(a);
                }else{
                    img2.setBackgroundColor(Color.WHITE);
                    img2.setImageDrawable(getResources().getDrawable(R.drawable.frameorange));
                    MyCustomAnimation a = new MyCustomAnimation(pCareInstruct, 500, MyCustomAnimation.EXPAND);
                    a.setHeight(height);

                    pCareInstruct.startAnimation(a);
                }


            }
        });
        //initViews();
    }
    private void initViews(){
        /*RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),3);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<AndroidVersion> androidVersions = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(),androidVersions);
        recyclerView.setAdapter(adapter);
*/
    }
    private ArrayList<AndroidVersion> prepareData(){

        ArrayList<AndroidVersion> android_version = new ArrayList<>();
        for(int i=0;i<android_version_names.length;i++){
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_version_name(android_version_names[i]);
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }

    public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
        private ArrayList<AndroidVersion> android;
        private Context context;

        public DataAdapter(Context context,ArrayList<AndroidVersion> android) {
            this.android = android;
            this.context = context;
        }

        @Override
        public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rowlayout, viewGroup, false);
            return new ViewHolder(view,context,android
            );
        }

        @Override
        public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

            viewHolder.tv_android.setText(android.get(i).getAndroid_version_name());
            Picasso.with(context).load(android.get(i).getAndroid_image_url()).placeholder(R.mipmap.ic_launcher).resize(240, 120).into(viewHolder.img_android);
        }

        @Override
        public int getItemCount() {
            return android.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView tv_android;
            GridLayout pCareInstruction;
            private ImageView img_android;
            Context ctx;
            List<AndroidVersion> arrayList = new ArrayList();

            public ViewHolder(View view, Context context, List<AndroidVersion> al) {
                super(view);

                tv_android = (TextView) view.findViewById(R.id.tv_android);
                img_android = (ImageView) view.findViewById(R.id.img_android);
              //  pCareInstruction= (GridLayout) view.findViewById(pCareInstruction);
                arrayList = al;
                ctx = context;
                view.setOnClickListener(this);

            }

            @Override
            public void onClick(View view) {

            }
                // openBottomSheet(view);


            }



    }
}
