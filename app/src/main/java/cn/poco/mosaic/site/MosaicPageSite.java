package cn.poco.mosaic.site;

import android.content.Context;

import java.util.HashMap;

import cn.poco.MaterialMgr2.site.DownloadMorePageSite;
import cn.poco.framework.BaseSite;
import cn.poco.framework.IPage;
import cn.poco.framework.MyFramework;
import cn.poco.framework.SiteID;
import cn.poco.framework2.Framework2;
import cn.poco.login.site.LoginPageSite1;
import cn.poco.mosaic.MosaicPage;
import cn.poco.resource.ResType;

/**
 * 素材美化-马赛克
 */
public class MosaicPageSite extends BaseSite {
    public MosaicPageSite() {
        super(SiteID.MOSAIC);
    }

    @Override
    public IPage MakePage(Context context) {
        return new MosaicPage(context, this);
    }

    /**
     * @param params img:Bitmap
     */
    public void OnBack(Context context, HashMap<String, Object> params) {
        MyFramework.SITE_Back(context, null, Framework2.ANIM_NONE);
    }

    /**
     * @param params img:Bitmap
     */
    public void OnSave(Context context, HashMap<String, Object> params) {
    }

    public void OpenDownloadMore(Context context, ResType type) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("type", type);
        MyFramework.SITE_Popup(context, DownloadMorePageSite.class, params, Framework2.ANIM_NONE);
    }

    public void OnLogin(Context context) {
        MyFramework.SITE_Popup(context, LoginPageSite1.class, null, Framework2.ANIM_NONE);
    }
}
