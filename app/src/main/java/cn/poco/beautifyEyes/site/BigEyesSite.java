package cn.poco.beautifyEyes.site;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.HashMap;

import cn.poco.beautifyEyes.page.BigEyesPage;
import cn.poco.framework.FileCacheMgr;
import cn.poco.framework.IPage;
import cn.poco.framework.MyFramework;
import cn.poco.framework.SiteID;
import cn.poco.framework2.Framework2;
import cn.poco.makeup.site.ChangePointPageSite;
import cn.poco.share.site.SharePageSite;
import cn.poco.utils.Utils;

/**
 * Created by Shine on 2016/12/5.
 * 大眼的site
 * 流程：从美颜美形功能bar点击进入;
 */

public class BigEyesSite extends BeautyBaseSite{

    public BigEyesSite() {
        super(SiteID.BIGEYES);

    }

    @Override
    public IPage MakePage(Context context) {
        return new BigEyesPage(context, this);
    }

    @Override
    public void onBack(Context context, HashMap<String, Object> params) {
        MyFramework.SITE_Back(context, null, Framework2.ANIM_NONE);
    }

	/**
     * @param params
     * img:Bitmap
     */
    @Override
    public void onSave(Context context, HashMap<String, Object> params) {
        Bitmap bmp = (Bitmap)params.get("img");
        if(bmp != null)
        {
            String path = FileCacheMgr.GetLinePath();
            if(path != null)
            {
                if(Utils.SaveTempImg(bmp, path))
                {
                    HashMap<String, Object> temp = new HashMap<>();

                    temp.put("img", path);
                    MyFramework.SITE_Open(context, SharePageSite.class, temp, Framework2.ANIM_NONE);
                }
            }
        }
    }

    @Override
    public void pinFaceChat(Context context, HashMap<String, Object> params) {
        Bitmap bmp = (Bitmap)params.get("imgs");
        if (bmp != null) {
            HashMap<String ,Object> temp = new HashMap<>();
            temp.put("imgs", bmp);
            temp.put("type", params.get("type"));
            temp.put("index", params.get("index"));
            MyFramework.SITE_Popup(context, ChangePointPageSite.class, temp, Framework2.ANIM_NONE);
        }
    }
}
