package com.jqmovie.jqmovie.Actors;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jqmovie.jqmovie.R;
import com.jqmovie.jqmovie.db.Entities.Actor;

import java.util.List;

public class ActorAdapter extends BaseAdapter {

    /*String[] result*/
    List<Actor> actorList;
    Context context;
    /*int [] imageId;*/
    private static LayoutInflater inflater=null;
    /*public ActorAdapter(Actors actors, String[] actorList, int[] actorImages) {*/
    public ActorAdapter(Actors actors, List<Actor> actorlist) {
        // TODO Auto-generated constructor stub
        /*result=actorList;*/
        this.actorList = actorlist;
        context=actors;
        /*imageId=actorImages;*/
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        /*return result.length;*/
        return actorList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView actor_text;
        ImageView actor_img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.linearlayout_movie, null);
        holder.actor_text =(TextView) rowView.findViewById(R.id.movie_texts);
        holder.actor_img =(ImageView) rowView.findViewById(R.id.movie_images);

        /*holder.actor_text.setText(result[position]);
        holder.actor_img.setImageResource(imageId[position]);*/

        holder.actor_text.setText(actorList.get(position).getFirstname());
        holder.actor_img.setImageResource(actorList.get(position).getPicture());

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                /*Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_SHORT).show();*/
                Toast.makeText(context, "You Clicked "+actorList.get(position).getFirstname(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, ActorDetails.class);
                /*intent.putExtra("Name", result[position]);*/
                intent.putExtra("Name", actorList.get(position).getFirstname());

                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
