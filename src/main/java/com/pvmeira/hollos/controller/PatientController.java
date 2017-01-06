package com.pvmeira.hollos.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pvmeira.hollos.entity.Patient;
import com.pvmeira.hollos.entity.PatientHistory;
import com.pvmeira.hollos.enums.ActionHistory;
import com.pvmeira.hollos.repository.filter.PatientSearchFilter;
import com.pvmeira.hollos.service.PatientHistoryService;
import com.pvmeira.hollos.service.PatientService;

@Controller
@RequestMapping("/pacientes")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private PatientHistoryService patientHistoryService;

	private static final String CADASTRO_VIEW = "CadastroPaciente";

	@RequestMapping("/novo")
	public ModelAndView newPatient() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Patient());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Patient patient, Errors errors, RedirectAttributes atributes) {

		if (errors.hasErrors()) {
			return CADASTRO_VIEW;
		}

		try {
			patientService.save(patient);
			this.addOnHistory(ActionHistory.SAVE_HISTORY.getAction(), patient);
			atributes.addFlashAttribute("mensagem", "Paciente salvo com sucesso!");
			return "redirect:/pacientes/novo";
		} catch (IllegalArgumentException e) {
			return CADASTRO_VIEW;
		}
	}

	private void addOnHistory(String action, Patient p) {
		PatientHistory h = new PatientHistory();
		h.setActionDate(Calendar.getInstance());
		h.setPatientName(p.getName());
		// TODO: h.setUserName(userName);
		patientHistoryService.insertRegister(action, h);
	}
	
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") PatientSearchFilter filtro) {
		List<Patient> allPatients = patientService.filtrar(filtro);
		ModelAndView mv = new ModelAndView("PesquisaPaciente");
		mv.addObject("patients", allPatients);
		return mv;
	}
	
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes atributes) {
		patientService.delete(id);
		atributes.addFlashAttribute("mensagem", "Registro exluído com sucesso!");
		return "redirect:/pacientes";
	}

}
