package com.c19m.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.AbstractDocument.BranchElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.c19m.service.MyService;

@CrossOrigin(origins = "*")
@Controller
public class MyController{

	
	@Autowired
	private MyService myService;
	
	@RequestMapping("insert.do")
	public ModelAndView insertCommand(){
		return new ModelAndView("mainPage");
	}
	
	@RequestMapping(value = "covidko.do", method=RequestMethod.GET)
	public String covid_koTable(){
		StringBuffer result = new StringBuffer();
		try {
			String APIurl = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson?serviceKey=%2Bc6uay4R3WotAQklde0zdRtCyjoZa2c2bihkx0Ll9Sf89wtvvthVcpzS2O6vvm0t%2Fe8Mm6PGadBAgEvo%2B9NNFg%3D%3D&pageNo=1&numOfRows:10;";
			
			URL url = new URL(APIurl);
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setRequestMethod("GET");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
			
			String returnLine;
			while((returnLine = br.readLine()) != null) {
				result.append(returnLine);
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		String res = result.toString();
		
		System.out.println(res);
		return res;
	}
}
