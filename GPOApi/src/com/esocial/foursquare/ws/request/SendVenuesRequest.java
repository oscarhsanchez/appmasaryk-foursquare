package com.esocial.foursquare.ws.request;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.bouncycastle.util.encoders.Base64;

import com.esocial.foursquare.obj.FsVenue;
import com.esocial.foursquare.ws.WsRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class SendVenuesRequest extends WsRequest  {
	
	private final String metodo = "metadata/ubicaciones/foursquare/venues/";        

	public <T> T execute(ArrayList<FsVenue> venues, Class<T> responseClass) throws Exception {
		Gson gsonc = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();			
        String jList = gsonc.toJson(venues);
		
		List<NameValuePair> param = new ArrayList<NameValuePair>(2);
		param.add(new BasicNameValuePair("array", new String(Base64.encode(jList.getBytes("UTF-8")))));
		
		return super.executePostDefaultHeaders(metodo, param, responseClass);
	}
		
}
