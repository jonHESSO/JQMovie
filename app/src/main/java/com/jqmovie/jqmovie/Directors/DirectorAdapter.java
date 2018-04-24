package com.jqmovie.jqmovie.Directors;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jqmovie.jqmovie.Actors.ActorDetails;
import com.jqmovie.jqmovie.R;
import com.jqmovie.jqmovie.db.Entities.Director;

import java.util.List;


public class DirectorAdapter extends BaseAdapter {

    List<Director> directorList;
    Context context;

    private static LayoutInflater inflater=null;
    public DirectorAdapter(Directors directors, List<Director> directorList) {
        // TODO Auto-generated constructor stub
        this.directorList = directorList;
        context=directors;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return directorList.size();
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
        TextView director_text;
        ImageView director_img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        DirectorAdapter.Holder holder=new DirectorAdapter.Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.linearlayout_movie, null);
        holder.director_text =(TextView) rowView.findViewById(R.id.movie_texts);
        holder.director_img =(ImageView) rowView.findViewById(R.id.movie_images);

        holder.director_text.setText(directorList.get(position).getFirstname()+" "+directorList.get(position).getLastname());
        holder.director_img.setImageResource(directorList.get(position).getPicture());

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(context, DirectorDetails.class);
                intent.putExtra("directorid", directorList.get(position).getDirectorid());

                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
