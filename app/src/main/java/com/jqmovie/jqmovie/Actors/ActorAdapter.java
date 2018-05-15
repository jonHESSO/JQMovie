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
    //class to create the gridlayout
    List<Actor> actorList;
    Context context;
    private static LayoutInflater inflater=null;

    public ActorAdapter(Actors actors, List<Actor> actorlist) {
        this.actorList = actorlist;
        context=actors;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return actorList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView actor_text;
        ImageView actor_img;
    }
    //fill gridlayout and actions
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.linearlayout_movie, null);
        holder.actor_text =(TextView) rowView.findViewById(R.id.movie_texts);
        holder.actor_img =(ImageView) rowView.findViewById(R.id.movie_images);


        holder.actor_text.setText(actorList.get(position).getFirstname()+" "+actorList.get(position).getLastname());
        holder.actor_img.setImageResource(actorList.get(position).getPicture());
//action from when you click on an actor
        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, ActorDetails.class);
                intent.putExtra("actorid", actorList.get(position).getParent());

                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
