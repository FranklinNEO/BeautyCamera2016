package cn.poco.adMaster;

import android.content.Context;

import com.adnonstop.admasterlibs.data.AdPackage;

import java.util.ArrayList;

/**
 * Created by Raining on 2017/9/29.
 */

public class SidebarAdBanner extends ShareAdBanner
{
	public SidebarAdBanner(Context context)
	{
		super(context);
	}

	@Override
	protected String GetPos()
	{
		return SidebarAdMaster.POS_BANNER;
	}

	@Override
	public void Run(Callback cb)
	{
		mCb = cb;
		ArrayList<AdPackage> obj = SidebarAdMaster.getInstance(mContext).sync_ar_GetCloudCacheRes(mContext, null, mHolder);
		ShowBanner(obj);
	}
}
