package com.serbus.reelerview;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<ReelModel> reelModelList;

    // creating consturctor
    public VideoAdapter(List<ReelModel> reelModelList)
    {
        this.reelModelList = reelModelList;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        // the layout that
                        // we created above
                        R.layout.video, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position)
    {
        holder.setDataVideo(reelModelList.get(position));
    }

    @Override
    public int getItemCount()
    {
        return reelModelList.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder {

        VideoView videoView;
        TextView VideoTitle, videoDescp;
        ProgressBar ProgreesVideo;

        public VideoViewHolder(@NonNull View itemView)
        {
            super(itemView);

            // getting all this from the
            // java file we created in above steps
            videoView = itemView.findViewById(R.id.videoView);
            VideoTitle = itemView.findViewById(R.id.VideoTitle);
            videoDescp = itemView.findViewById(R.id.videoDescp);
            ProgreesVideo = itemView.findViewById(R.id.ProgreesVideo);
        }

        void setDataVideo(ReelModel reelModel)
        {
            VideoTitle.setText(reelModel.videoTitle);
            videoDescp.setText(reelModel.VideoDescription);
            videoView.setVideoPath(reelModel.videoURL);
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer)
                {
                    ProgreesVideo.setVisibility(View.GONE);
                    mediaPlayer.start();

                    // getting video ratio/screen ratio so that it can fix in screen
                    float videoRatio = mediaPlayer.getVideoWidth() / (float)mediaPlayer.getVideoHeight();
                    float screenRatio = videoView.getWidth() / (float)videoView.getHeight();
                    float scale = videoRatio / screenRatio;
                    if (scale >= 1f) {
                        videoView.setScaleX(scale);
                    }
                    else {
                        videoView.setScaleY(1f / scale);
                    }
                }
            });
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer)
                {
                    mediaPlayer.start();
                }
            });
        }
    }
}
