package com.example.demo.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
    public String index() {
        return "redirect:/Gold";
    }
	@RequestMapping("/Gold")
    public String index1(HttpSession session) {
		Integer golds = (Integer) session.getAttribute("golds");
		Random r = new Random();
		if (golds==null) {
			session.setAttribute("golds", 0);
			session.setAttribute("messages", new ArrayList<String>());
		}
		return "Home.jsp";
    }
	@RequestMapping(value="/process_money", method=RequestMethod.POST)
    public String index2(HttpSession session,@RequestParam(value="building") String building ) {
			Integer golds = (Integer) session.getAttribute("golds");
			Random r = new Random();
			if (golds==null) {
				session.setAttribute("golds", 0);
				session.setAttribute("messages", new ArrayList<String>());
			} else {
				if (building.equalsIgnoreCase("farm")) {
					System.out.println("You are in !!!");
					int result = r.nextInt(21-10) + 10;
					golds +=result;
					session.setAttribute("golds", golds);
					ArrayList<String> messagesArr = (ArrayList<String>)session.getAttribute("messages");
			        LocalDateTime now = LocalDateTime.now();
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			        String formatDateTime = now.format(formatter);

					messagesArr.add("Earned "+ golds + " gold from the farm! (" + formatDateTime+")");
					session.setAttribute("messages", messagesArr);
				}
				else if (building.equalsIgnoreCase("cave")) {
					int result = r.nextInt(11-5) + 5;
					golds +=result;
					session.setAttribute("golds", golds);
					ArrayList<String> messagesArr = (ArrayList<String>)session.getAttribute("messages");
			        LocalDateTime now = LocalDateTime.now();
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			        String formatDateTime = now.format(formatter);

					messagesArr.add("Earned "+ golds + " gold from the cave! (" + formatDateTime+")");
					session.setAttribute("messages", messagesArr);
				}
				else if (building.equalsIgnoreCase("house")) {
					int result = r.nextInt(6-2) + 2;
					golds +=result;
					session.setAttribute("golds", golds);
					ArrayList<String> messagesArr = (ArrayList<String>)session.getAttribute("messages");
			        LocalDateTime now = LocalDateTime.now();
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			        String formatDateTime = now.format(formatter);

					messagesArr.add("Earned "+ golds + " gold from the house! (" + formatDateTime+")");
					session.setAttribute("messages", messagesArr);
				}
				else if (building.equalsIgnoreCase("casino")) {
					int result = r.nextInt(50-(-50)) + (-50);
					golds +=result;
					session.setAttribute("golds", golds);
					ArrayList<String> messagesArr = (ArrayList<String>)session.getAttribute("messages");
			        LocalDateTime now = LocalDateTime.now();
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			        String formatDateTime = now.format(formatter);

					messagesArr.add("Earned "+ golds + " gold from the casino! (" + formatDateTime+")");
					session.setAttribute("messages", messagesArr);
				}
				else if (building.equalsIgnoreCase("spa")) {
					int result = r.nextInt(21-5) + 5;
					golds -=result;
					session.setAttribute("golds", golds);
					ArrayList<String> messagesArr = (ArrayList<String>)session.getAttribute("messages");
			        LocalDateTime now = LocalDateTime.now();
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			        String formatDateTime = now.format(formatter);

					messagesArr.add("loses "+ golds + " gold from the spa! (" + formatDateTime+")");
					session.setAttribute("messages", messagesArr);
				}
				return "redirect:/Gold";
			}
            return "redirect:/Gold";
		}
	@RequestMapping(value="/reset", method=RequestMethod.POST)
    public String index3(HttpSession session) {
		session.setAttribute("golds", 0);
		ArrayList<String> messagesArr = (ArrayList<String>)session.getAttribute("messages");
		messagesArr.clear();
		session.setAttribute("messages", messagesArr);
		
        return "redirect:/Gold";
    }
}
