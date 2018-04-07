package com.examples.hp.directconnectiontofarmers;
import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SQLiteListAdapter extends BaseAdapter {
	
    Context context;
    ArrayList<String> id;
    ArrayList<String> item;
    ArrayList<String> description;
    ArrayList<String> price;
    ArrayList<String> name ;
    ArrayList<String> phone ;
    ArrayList<String> location ;


    public SQLiteListAdapter(
    		Context context2,
            ArrayList<String> did,

            ArrayList<String> ditem,
    		ArrayList<String> ddescription,
    		ArrayList<String> dprice,
    		ArrayList<String> dname,
            ArrayList<String> dphone,

            ArrayList<String> dlocation

            )
    {
        	
    	this.context = context2;
        this.id = did;
        this.item = ditem;
        this.description = ddescription;
        this.price = dprice ;
        this.name = dname ;
        this.phone = dphone ;
        this.location = dlocation ;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return id.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public View getView(int position, View child, ViewGroup parent) {
    	
        Holder holder;
        
        LayoutInflater layoutInflater;
        
        if (child == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child = layoutInflater.inflate(R.layout.listviewdatalayout, null);
            
            holder = new Holder();
            
            holder.textviewitem = (TextView) child.findViewById(R.id.item);
            holder.textviewdescription = (TextView) child.findViewById(R.id.description);
            holder.textviewprice = (TextView) child.findViewById(R.id.price);
            holder.textviewname = (TextView) child.findViewById(R.id.name);
            holder.textviewphone = (TextView) child.findViewById(R.id.phone);

            holder.textviewlocation= (TextView) child.findViewById(R.id.location);


            child.setTag(holder);
            
        } else {
        	
        	holder = (Holder) child.getTag();
        }
        holder.textviewitem.setText("Item Name:"+item.get(position));
        holder.textviewdescription.setText("Descrption:"+description.get(position));
        holder.textviewprice.setText("Price:"+price.get(position)+"\n---------------------------");
        holder.textviewname.setText("Sold By:"+name.get(position));
        holder.textviewphone.setText("Contact:"+phone.get(position));
        holder.textviewlocation.setText("Location:"+location.get(position));


        return child;
    }

    public class Holder {
        TextView textviewid;
        TextView textviewitem;
        TextView textviewdescription;
        TextView textviewprice;
        TextView textviewname;
        TextView textviewphone;
        TextView textviewlocation;


    }

}