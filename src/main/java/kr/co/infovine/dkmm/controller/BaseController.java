package kr.co.infovine.dkmm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;

import org.codehaus.jettison.json.JSONObject;
import kr.co.infovine.dkmm.api.model.base.ResponseModel;
import lombok.extern.slf4j.Slf4j;
import reactor.netty.http.client.HttpClient;

@Slf4j
@Controller
public class BaseController {
	
	@Autowired
	HttpClient httpClient;
	
	@Value("${url.server.api}")
	String urlServerApi;
	
	
	@RequestMapping(value="/error.do")
	public ModelAndView error(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		model.setViewName("error");
		return model;
	}

	@RequestMapping(value="/index.do")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();

		String inflowChannel = request.getParameter("inflow_channel");
		if(inflowChannel!=null) {
			if(inflowChannel.equals("")) {
				inflowChannel = (String) request.getAttribute("inflow_channel");
			}
		}
		else {
			inflowChannel = (String) request.getAttribute("inflow_channel");
		}

		String url = null;
		if(inflowChannel!=null){
			switch(inflowChannel){
				case "RkFDRUJPT0tfUA==":		//페이스북 프로모션
					url = "https://appdkmm.page.link/nBmg?inflowChannel=RkFDRUJPT0tfUA==";
					break;
				case "TkFWRVJfUA==":		//네이버 프로모션
					url = "https://appdkmm.page.link/4wzb?inflowChannel=TkFWRVJfUA==";
					break;
				case "S0FLQU9fUA==":		//카카오 프로모션
					url = "https://appdkmm.page.link/Jt1i?inflowChannel=S0FLQU9fUA==";
					break;
				case "R09PR0xFX1A=":		//구글 프로모션
					url = "https://appdkmm.page.link/HyGq?inflowChannel=R09PR0xFX1A=";
					break;
				case "RkFDRUJPT0s=":		//페이스북
					url = "https://appdkmm.page.link/UJjq?inflowChannel=RkFDRUJPT0s=";
					break;
				case "TkFWRVI=":		//네이버
					url = "https://appdkmm.page.link/78oJ?inflowChannel=TkFWRVI=";
					break;
				case "S0FLQU8=":		//카카오
					url = "https://appdkmm.page.link/94wQ?inflowChannel=S0FLQU8=";
					break;
				case "T0ZGTElORTAwMQ==":		//오프라인001
					url = "https://appdkmm.page.link/1oqY?inflowChannel=T0ZGTElORTAwMQ==";
					break;
				case "R09PR0xF":		//구글
					url = "https://appdkmm.page.link/FhSa?inflowChannel=R09PR0xF";
					break;
				default:				//일반유입
					url = "https://appdkmm.page.link/tTRV?inflowChannel=" + inflowChannel;
					break;
			}
		}
		else{
			//inflow_channel 없을경우(일반유입)
			url = "https://appdkmm.page.link/6R7o";
		}

		boolean flag = true;
		String userAgent = request.getHeader("User-Agent").toUpperCase();
		String IS_MOBILE = "MOBI";
		if(userAgent.indexOf(IS_MOBILE) > -1) {
			flag = false;
		}
		if(flag){
			if(inflowChannel!=null){
				model.setViewName("indexWeb");
				model.addObject("inflow_channel", inflowChannel);
				model.addObject("url", url);
			}
			else {
				model.setViewName("indexWeb");
				model.addObject("url", url);
			}
		}

		return model;
	}

	@RequestMapping(value = "/favicon.ico", method = RequestMethod.GET)
	public void favicon( HttpServletRequest request, HttpServletResponse reponse ) {
		try {
			reponse.sendRedirect("/assets/images/favicon.ico");
		} catch (IOException e) {
		}
	}

	// region 설명: 로드벨런싱 체크
	/**
	 * 2022-12-26 Made by Duhyun, Kim
	 * @param args
	 * return : ResponseModel
	 */
	@RequestMapping(value="/checkHealth.do", method = RequestMethod.GET
			, produces = "application/json; charset=utf8" )
	@ResponseBody
	public ResponseModel checkHealth(HttpServletRequest request, HttpServletResponse response) {
		ResponseModel result = new ResponseModel();
		try {
			result.setCode("0000");
		}
		catch (Exception e) {
			result.setCode("0001");
		}
		return result;
	}
	// end region
}
