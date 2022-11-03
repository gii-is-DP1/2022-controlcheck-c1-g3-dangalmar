package org.springframework.samples.petclinic.recoveryroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "recoveryroom")
public class RecoveryRoomController {
	
	private static final String VIEW = "recoveryroom/createOrUpdateRecoveryRoomForm";
	
	private RecoveryRoomService reco;
	
	@Autowired
	public RecoveryRoomController(RecoveryRoomService reco) {
		this.reco=reco;
	}
	
	@GetMapping(value= "/create")
	public String initCreationForm(ModelMap model) {
		RecoveryRoom recovery=new RecoveryRoom();
		model.put("recoveryRoom", recovery);
		return VIEW;
	}
    
}
