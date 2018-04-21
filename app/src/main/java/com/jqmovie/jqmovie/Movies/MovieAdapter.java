package com.jqmovie.jqmovie.Movies;


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

public class MovieAdapter extends BaseAdapter {

    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public MovieAdapter(Movies movies, String[] movieList, int[] movieImages) {
        // TODO Auto-generated constructor stub
        result=movieList;
        context=movies;
        imageId=movieImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
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
        TextView movie_text;
        ImageView movie_img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        MovieAdapter.Holder holder=new MovieAdapter.Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.linearlayout_movie, null);
        holder.movie_text =(TextView) rowView.findViewById(R.id.movie_texts);
        holder.movie_img =(ImageView) rowView.findViewById(R.id.movie_images);

        holder.movie_text.setText(result[position]);
        holder.movie_img.setImageResource(imageId[position]);

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, MovieDetails.class);
                intent.putExtra("Title", result[position]);

                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
