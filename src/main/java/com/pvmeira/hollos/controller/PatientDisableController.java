package com.pvmeira.hollos.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pvmeira.hollos.entity.Patient;
import com.pvmeira.hollos.entity.PatientHistory;
import com.pvmeira.hollos.enums.ActionHistory;
import com.pvmeira.hollos.service.PatientHistoryService;
import com.pvmeira.hollos.service.PatientService;

@Controller
@RequestMapping("/normal/pacientes/desativados")
public class PatientDisableController {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PatientHistoryService patientHistoryService;
	
	private void addOnHistory(String action, Patient p) {
		PatientHistory h = new PatientHistory();
		h.setActionDate(Calendar.getInstance());
		h.setPatientName(p.getName());
		// TODO: h.setUserName(userName);
		patientHistoryService.insertRegister(action, h);
	}
	
	
	@RequestMapping("/able/{id}")
	public ModelAndView disablePatient(@PathVariable("id") Patient p, RedirectAttributes atributes) {
		this.addOnHistory(ActionHistory.ALTER_HISTORY.getAction(), p);
		this.patientService.activePatient(p);
		ModelAndView mv = new ModelAndView("PesquisaPacienteDesativados");
		atributes.addFlashAttribute("mensagem", "Paciente abilitado com sucesso com sucesso!");
		return mv;
	}
	@RequestMapping("/")
	public ModelAndView listAll() {
		List<Patient>list = this.patientService.listAllPatientDisable();
		ModelAndView mv = new ModelAndView("PesquisaPacienteDesativados");
		mv.addObject("patients", list);
		return mv;
	}

}
