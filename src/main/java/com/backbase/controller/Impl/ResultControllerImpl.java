/**
 * 
 */
package com.backbase.controller.Impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.backbase.controller.ResultController;

/**
 * @author M1040042
 *
 */
@Controller
public class ResultControllerImpl implements ResultController{
	@Override
	
	
	public ModelAndView result() {
		ModelAndView model = new ModelAndView("result");
		return model;
	}

}
