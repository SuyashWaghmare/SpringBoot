package com.ssw.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ssw.model.Parent;
import com.ssw.model.Tutor;
import com.ssw.repository.TutorRepository;
import com.ssw.service.TutorService;

@Service
public class TutorServiceIMPL implements TutorService {

	@Autowired
	private TutorRepository tutorrepo;

	@Autowired
	private JavaMailSender sender;

	@Override
	public void addTutor(Tutor tutor) {
		Tutor formail = tutorrepo.save(tutor);
		sendMail(formail);

	}

	public void sendMail(Tutor tutor) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(tutor.getMailid());
		message.setSubject("Welcome to SSW Online Coaching Application");
		message.setText("Dear " + tutor.getMailid() + ",\n\n Yor are registered as Tutor on our platform !"
				+ "\n\n Your Username : " + tutor.getUsername() + "\n Your Password : " + tutor.getPassword());
		sender.send(message);

	}

	@Override
	public List<Tutor> viewAllTutors() {

		return tutorrepo.findAll();
	}

	@Override
	public Tutor getTutorById(int tutorid) {
		if (tutorrepo.existsById(tutorid)) {

			return tutorrepo.findById(tutorid).get();

		}

		else
			return new Tutor();
	}

	@Override
	public void updateTutor(Tutor existingTutor) {
		tutorrepo.save(existingTutor);
	}

	@Override
	public void sendDemoRequestEmailToTutor(Parent existingParent, Tutor existingTutor) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(existingTutor.getMailid());
		message.setSubject("Demo Request Notification");

		String text = "Dear Tutor " + existingTutor.getTutorname() + ",\n\n"
				+ "You have received a demo request from Parent,\n" + "Parent Name: " + existingParent.getParentname()
				+ "\n" + "Parent Mobile Number: " + existingParent.getParentmobileno() + "\n" + "Parent Email: "
				+ existingParent.getMailid() + "\n" + "Please check your account for more details.";
		message.setText(text);
		sender.send(message);

	}

	@Override
	public void saveTutorAgain(Tutor existingTutor) {

		tutorrepo.save(existingTutor);
	}

	@Override
	public void sendBookedTutorByParentEmailToTutor(Parent existingParent, Tutor existingTutor) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(existingTutor.getMailid());
		message.setSubject("Booked by Parent");

		String text = "Dear Tutor " + existingTutor.getTutorname() + ",\n\n" + "You have booked by a Parent,\n"
				+ "Parent Name: " + existingParent.getParentname() + "\n" + "Parent Mobile Number: "
				+ existingParent.getParentmobileno() + "\n" + "Parent Email: " + existingParent.getMailid() + "\n"
				+ "Please check your account for more details.";
		message.setText(text);
		sender.send(message);

	}

	@Override
	public void saveTutorRating(Tutor existingTutor) {
		tutorrepo.save(existingTutor);

	}

	@Override
	public String tutorLogin(Tutor tutor) {
		Tutor savedTutor = tutorrepo.findByUsername(tutor.getUsername());

		if (savedTutor != null && savedTutor.getUsername().equals(tutor.getUsername())
				&& savedTutor.getPassword().equals(tutor.getPassword())) {
			return "Login successful";
		} else {
			return "Invalid credentials";
		}
	}

	@Override
	public void updateTutorData(Tutor existingTutor) {
		Tutor updateTutor = tutorrepo.save(existingTutor);
		sendMailAfterUpdate(updateTutor);
	}

	public void sendMailAfterUpdate(Tutor tutor) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(tutor.getMailid());
		message.setSubject("Profile Updated SSW Online Coaching Application");
		message.setText("Dear " + tutor.getMailid() + ",\n\n Yor are updated your Tutor Profile !"
				+ "\n\n Your Username : " + tutor.getUsername() + "\n Your Password : " + tutor.getPassword());
		sender.send(message);

	}
}
