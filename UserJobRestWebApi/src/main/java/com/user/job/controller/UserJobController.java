package com.user.job.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.user.job.dao.JobRepo;
import com.user.job.model.Job;
import com.user.job.model.User;
import com.user.job.service.UserJobService;

@RestController
@RequestMapping("/userJob")
public class UserJobController {

	@Autowired
	UserJobService service;

	@Autowired
	JobRepo jobRepo;

	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}

	@PostMapping("/createJob")
	public Job createJob(@RequestBody Job job) {
		return service.createJob(job);
	}

	@GetMapping("/job/getjob/{jobid}")
	public Optional<Job> getJobById(@PathVariable int jobid) {
		return service.getJobById(jobid);
	}

	// get Job by Type
	@GetMapping("/job/getByType/{type}")
	public List<Job> getJobByType(@PathVariable String type) {
		return service.getJobByType(type);
	}

	// get Job by Experience
	@GetMapping("/job/getByExp/{exp}")
	public List<Job> findByJobExp(@PathVariable int exp) {
		return service.getJobByExp(exp);
	}

	// Filter Job by Country:
	@GetMapping("/job/getByCountry/{country}")
	public List<Job> getJobBycountry(@PathVariable String country) {
		return service.getJobBycountry(country);
	}

	// Filter Job by Availability
	@GetMapping("/job/getByAvailability/{availability}")
	public List<Job> getJobByavailability(@PathVariable String availability) {
		return service.getJobByavailability(availability);
	}

	// -> Filter Job by Skills:

	@GetMapping("/user/getalluser")
	public Iterable<User> getUser() {
		return service.getAllUser();
	}

	@PostMapping("/import-excel")
	public ResponseEntity<List<Job>> importExcelFile(@RequestParam("file") MultipartFile files) throws IOException {
		HttpStatus status = HttpStatus.OK;
		List<Job> jobList = new ArrayList<>();

		XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);

		for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
			if (index > 0) {
				Job job = new Job();
				User u = new User();
				XSSFRow row = worksheet.getRow(index);

				job.setJobTitle(row.getCell(0).getStringCellValue());
				job.setJobDescription(row.getCell(1).getStringCellValue());
				job.setCountry(row.getCell(2).getStringCellValue());
				job.setState(row.getCell(3).getStringCellValue());
				job.setAvailability(row.getCell(4).getStringCellValue());
				job.setReplyRate(row.getCell(5).getNumericCellValue());
				job.setPayRate(row.getCell(6).getNumericCellValue());
				job.setExperience(row.getCell(7).getNumericCellValue());
				job.setSkills(row.getCell(8).getStringCellValue());
				job.setLanguage(row.getCell(9).getStringCellValue());
				job.setJobType(row.getCell(10).getStringCellValue());

				String users = row.getCell(11).getStringCellValue();
				String[] user = users.split(",");
				List<User> set = new ArrayList<User>();
				List<String> list = new ArrayList<String>(Arrays.asList(user));
				Iterator<String> it = list.iterator();
				while(it.hasNext()) {
					u.setUserName(it.next());
					set.add(u);
				}
				job.setUsers(set);

				jobList.add(job);

			}
		}

		return new ResponseEntity<>(service.createJobs(jobList), status);
	}

}
