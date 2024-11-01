package com.ssw.service;


import java.util.List;

import com.ssw.model.Parent;
import com.ssw.model.Tutor;

public interface TutorService {

	void addTutor(Tutor tutor);

	List<Tutor> viewAllTutors();

	Tutor getTutorById(int tutorid);

	void updateTutor(Tutor existingTutor);

	void sendDemoRequestEmailToTutor(Parent existingParent, Tutor existingTutor);

	void saveTutorAgain(Tutor existingTutor);

	void sendBookedTutorByParentEmailToTutor(Parent existingParent, Tutor existingTutor);

	void saveTutorRating(Tutor existingTutor);

	String tutorLogin(Tutor tutor);

	void updateTutorData(Tutor existingTutor);

	

	

	

}
