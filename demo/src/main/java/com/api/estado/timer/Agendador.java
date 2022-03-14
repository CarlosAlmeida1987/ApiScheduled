package com.api.estado.timer;

import java.util.Date;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.estado.controller.ApiController;
import com.api.estado.service.impl.UpdatesService;

public class Agendador extends TimerTask {
	
	@Autowired
	private ApiController updatesController;

    Date instanteAtual;

    @Override
    public void run() {
          instanteAtual = new Date();
          System.out.println(instanteAtual);
          
     //String api  =  updatesController.getUpdates();
     
     //System.out.println(api);
          
    }


}