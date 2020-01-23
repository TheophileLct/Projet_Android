package worldline.ssm.rd.ux.wltwitter.async;

import android.os.AsyncTask;

import worldline.ssm.rd.ux.wltwitter.WLTwitterApplication;
import worldline.ssm.rd.ux.wltwitter.helpers.TwitterHelper;
import worldline.ssm.rd.ux.wltwitter.pojo.Tweet;
import java.util.List;

public class RetrieveTweetsAsyncTask extends AsyncTask<String, Void, List<Tweet>> {

    protected List<Tweet> doInBackground(String...strings){
        if(null!=strings && strings.length>0){
            return TwitterHelper.getTweetsOfUser(strings[0]);
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Tweet> tweets) {
        super.onPostExecute(tweets);
        if(tweets != null){
            for(Tweet t : tweets){
                System.out.println(WLTwitterApplication.class.getName()+t.text);
            }
        }
    }
}
