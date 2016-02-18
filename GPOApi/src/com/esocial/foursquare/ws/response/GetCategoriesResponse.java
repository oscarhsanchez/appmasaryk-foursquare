package com.esocial.foursquare.ws.response;

import java.util.ArrayList;

import com.esocial.foursquare.obj.FsCategory;
import com.esocial.foursquare.ws.WsResponse;

public class GetCategoriesResponse extends WsResponse {
	
	public String result;
	public ArrayList<FsCategory> categories;
		
}
