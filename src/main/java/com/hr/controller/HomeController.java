	package com.hr.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import com.captcha.botdetect.web.servlet.Captcha;
//import com.webtools.lab10.dao.UserDAO;
import com.hr.pojo.*;
import com.hr.dao.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// public String home(Locale locale, Model model) {
	// logger.info("Welcome home! The client locale is {}.", locale);
	//
	// Date date = new Date();
	//
	// DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
	// DateFormat.LONG, locale);
	//
	// String formattedDate = dateFormat.format(date);
	//
	// model.addAttribute("serverTime", formattedDate );
	//
	// return "home";
	// }

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginForm() {

		return "user-login";
	}

	@RequestMapping(value = "/user/create.htm", method = RequestMethod.GET)
	public String registerUser() {

		return "user-create-form";
	}

	@RequestMapping(value = "/user/create-form.htm", method = RequestMethod.POST)
	public String handleCreateForm(HttpServletRequest request,UserDao userDao, HrDao hrDao, StudentDao studentDao, ModelMap map) {

		String role = request.getParameter("dropdown");
		String userEmail = request.getParameter("useremail");
		String password = request.getParameter("password");
		String userName = request.getParameter("username");
		User user = null;
		try {
			user = userDao.getUser(userEmail);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(user == null) {
		if (role.equals("hr")) {

			Hr hr = new Hr();
			hr.setUserEmail(userEmail);
			hr.setPassword(password);
			hr.setHrName(userName);

			try {
				Hr h = hrDao.register(hr);

				return "user-created";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		else {

			Student student = new Student();
			student.setUserEmail(userEmail);
			student.setPassword(password);
			student.setStudentName(userName);

			try {
				Student s = studentDao.register(student);

				return "user-created";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return null;
		}else {
			map.addAttribute("errorMessage", "User with same email already exist");
			return "error";
		}
	}

	@RequestMapping(value = "/user/login.htm", method = RequestMethod.POST)
	public String loginSuccessful(HttpServletRequest request, UserDao userDao, StudentDao studentDao,
			ApplicationDao applicationDao, HrDao hrDao, ModelMap map, JobDao jobDao) {
		HttpSession session = request.getSession(true);
		String role = request.getParameter("dropdown");
		String userEmail = request.getParameter("useremail");
		String password = request.getParameter("password");
		System.out.println("Tushar");
		if (role.equals("hr")) {

			try {
				User u = userDao.get(userEmail, password);
				System.out.println(u);
				if (u != null) {
					System.out.println(u.getUser_id());
					boolean flag = hrDao.getID((int) u.getUser_id());
					if (flag == true) {
						session.setAttribute("user", u);

						try {
							List<Job> job_list = jobDao.getJobs();
							System.out.println(job_list);
							if (job_list != null || job_list.size() != 0) {
								map.addAttribute("job_list", job_list);

							}
							// User user = (User) session.getAttribute("user");
							List<Application> applicationList = applicationDao.getAllApplication();
							System.out.println(applicationList);
							if (applicationList != null || applicationList.size() != 0) {
								map.addAttribute("applicationList", applicationList);
							}
							return "hrView";
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					} else {
						map.addAttribute("errorMessage",
								"these are not a valid HR credentials Please select appropriate role or ebter valid credentials..!!");
						return "error";
					}

				} else {
					map.addAttribute("errorMessage", "Invalid username/password!");
					return "error";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else {

			try {
				User u = userDao.get(userEmail, password);

				if (u != null) {
					boolean flag = studentDao.getID((int) u.getUser_id());
					if (flag == true) {

						session.setAttribute("user", u);

						try {
							List<Job> job_list = jobDao.getOpenJobs();
							System.out.println(job_list);
							if (job_list != null || job_list.size() != 0) {
								map.addAttribute("job_list", job_list);

							}
							User user = (User) session.getAttribute("user");
							List<Application> applicationList = applicationDao
									.getApplication(String.valueOf(user.getUser_id()));
							System.out.println(applicationList);
							if (applicationList != null || applicationList.size() != 0) {
								map.addAttribute("applicationList", applicationList);
							}
							return "applicantView";
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return "applicantView";
					} else {
						map.addAttribute("errorMessage",
								"these are not a valid applicant credentials Please select appropriate role or ebter valid credentials..!!");
						return "error";
					}
				} else {
					map.addAttribute("errorMessage", "Invalid username/password!");
					return "error";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return null;
	}

	@RequestMapping(value = "/user/logout.htm", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "user-login";
	}

	@RequestMapping(value = "/user/create-job.htm", method = RequestMethod.POST)
	public String createTheJob(HttpServletRequest request, JobDao jobDao, ApplicationDao applicationDao, ModelMap map) {

		String jobDesc = request.getParameter("jobdesc");
		
		
		Job job = new Job();
		job.setJobDesc(jobDesc);
		job.setStatus("OPEN");

		try {
			jobDao.createJob(job);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			List<Job> job_list = jobDao.getJobs();
			System.out.println(job_list);
			if (job_list != null || job_list.size() != 0) {
				map.addAttribute("job_list", job_list);
			}
			List<Application> applicationList = applicationDao.getAllApplication();
			System.out.println(applicationList);
			if (applicationList != null || applicationList.size() != 0) {
				map.addAttribute("applicationList", applicationList);
			}
			return "hrView";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "hrView";
	}

	@RequestMapping(value = "/user/apply.htm", method = RequestMethod.POST)
	public String createApplication(HttpServletRequest request, JobDao jobDao, ApplicationDao applicationDao,
			ModelMap map) {

		HttpSession session = request.getSession();
		String job_id = request.getParameter("job_id");
		User user = (User) session.getAttribute("user");

		Application application = new Application();

		if (job_id != null) {

			try {
				Job job = jobDao.getJob(job_id);
				job.setStatus("PROGRESS");
				application.setJob(job);
				application.setUser(user);
				applicationDao.createApplication(application);

				List<Job> job_list = jobDao.getOpenJobs();

				if (job_list != null || job_list.size() != 0) {
					map.addAttribute("job_list", job_list);
				}

				List<Application> applicationList = applicationDao.getApplication(String.valueOf(user.getUser_id()));
				System.out.println(applicationList);
				if (applicationList != null || applicationList.size() != 0) {
					map.addAttribute("applicationList", applicationList);
				}

				return "applicantView";

			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			map.addAttribute("errorMessage", "Please select a job to apply");
			return "error";
		}

		return null;

	}

	@RequestMapping(value = "/user/decision.htm", method = RequestMethod.POST)
	public String acceptdecision(HttpServletRequest request, JobDao jobDao, ApplicationDao applicationDao,
			ModelMap map) {

		HttpSession session = request.getSession();
		String application_id = request.getParameter("application_id");
		String action = request.getParameter("action");

		if (application_id != null) {

			if (action.equals("Accept")) {
				try {
					Application application = applicationDao.getapplication(application_id);
					application.getJob().setStatus("ACCEPTED");

					List<Job> job_list = jobDao.getJobs();

					if (job_list != null || job_list.size() != 0) {
						map.addAttribute("job_list", job_list);
					}

					List<Application> applicationList = applicationDao.getAllApplication();
					System.out.println(applicationList);
					if (applicationList != null || applicationList.size() != 0) {
						map.addAttribute("applicationList", applicationList);
					}
					return "hrView";

				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else if (action.equals("Reject")) {
				try {
					Application application = applicationDao.getapplication(application_id);
					application.getJob().setStatus("REJECTED");

					List<Job> job_list = jobDao.getJobs();

					if (job_list != null || job_list.size() != 0) {
						map.addAttribute("job_list", job_list);
					}

					List<Application> applicationList = applicationDao.getAllApplication();
					System.out.println(applicationList);
					if (applicationList != null || applicationList.size() != 0) {
						map.addAttribute("applicationList", applicationList);
					}
					return "hrView";

				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			return null;
		}

		else {
			map.addAttribute("errorMessage", "Please select a job to accept or reject");
			return "error";
		}

	}

}
