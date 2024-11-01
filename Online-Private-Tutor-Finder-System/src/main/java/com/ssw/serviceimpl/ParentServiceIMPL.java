package com.ssw.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ssw.model.Parent;
import com.ssw.model.Tutor;
import com.ssw.repository.ParentRepository;
import com.ssw.service.ParentService;

@Service
public class ParentServiceIMPL implements ParentService {

	@Autowired
	private ParentRepository parentrepo;

	@Autowired
	private JavaMailSender sender;

	@Override
	public void addParent(Parent parent) {
		Parent forParentMail = parentrepo.save(parent);
		sendMail(forParentMail);

	}

	public void sendMail(Parent parent) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(parent.getMailid());
		message.setSubject("Welcome to SSW Online Coaching Application");
		message.setText("Dear " + parent.getMailid() + ",\n\n Yor are registered as Parent on our platform !"
				+ "\n\n Your Username : " + parent.getUsername() + "\n Your Password : " + parent.getPassword());
		sender.send(message);

	}

	@Override
	public List<Parent> viewAllParents() {

		return parentrepo.findAll();
	}

	@Override
	public String parentLogin(Parent parent) {

		Parent savedParent = parentrepo.findByUsername(parent.getUsername());

		if (savedParent != null && savedParent.getUsername().equals(parent.getUsername())
				&& savedParent.getPassword().equals(parent.getPassword())) {
			return "Login successful";
		} else {
			return "Invalid credentials";
		}
	}

	@Override
	public Parent getParentById(long parentmobileno) {
		if (parentrepo.existsById(parentmobileno)) {

			return parentrepo.findById(parentmobileno).get();

		}

		else
			return new Parent();
	}

	@Override
	public void updateParent(Parent existingParent) {
		parentrepo.save(existingParent);

	}

	@Override
	public void sendDemoRequestEmailToParent(Parent existingParent, Tutor existingTutor) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(existingParent.getMailid());
		message.setSubject("Demo Request Notification");

		String text = "Dear Parent " + existingParent.getParentname() + ",\n\n"
				+ "You have sent a demo request to our Tutor,\n" + "Tutor Name: " + existingTutor.getTutorname() + "\n"
				+ "Mobile Number: " + existingTutor.getMobileno() + "\n" + "Email: " + existingTutor.getMailid() + "\n"
				+ "Please wait for the Tutor to accept your request.";

		message.setText(text);
		sender.send(message);

	}

	@Override
	public void acceptedDemoRequestByTutorMail(Parent existingParent, Tutor existingTutor) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(existingParent.getMailid());
		message.setSubject("Demo Request Accepted By Tutor");

		String text = "Dear Parent " + existingParent.getParentname() + ",\n\n" + "Our Tutor,\n" + "Tutor Name: "
				+ existingTutor.getTutorname() + "\n" + "Mobile Number: " + existingTutor.getMobileno() + "\n"
				+ "Email: " + existingTutor.getMailid() + "\n" + "has accepted your demo request.";

		message.setText(text);
		sender.send(message);

	}

	@Override
	public void saveParentAgain(Parent existingParent) {

		parentrepo.save(existingParent);
	}

	@Override
	public void senBookedTutorEmailToParent(Parent existingParent, Tutor existingTutor) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(existingParent.getMailid());
		message.setSubject("Tutor Booking");

		String text = "Dear Parent " + existingParent.getParentname() + ",\n\n" + "Our Tutor,\n" + "Tutor Name: "
				+ existingTutor.getTutorname() + "\n" + "Mobile Number: " + existingTutor.getMobileno() + "\n"
				+ "Email: " + existingTutor.getMailid() + "\n" + "has allotted (booked) to you.";

		message.setText(text);
		sender.send(message);

	}

}
