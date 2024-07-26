/**
 * 
 */
package com.rahul.learn.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.learn.dto.Students;
import com.rahul.learn.logtime.annotation.LogExecutionTime;
import com.rahul.learn.service.ReportingService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * @author rahul
   @since  20-Feb-2024 2024 7:02:08 pm
 */
@Validated
@RestController
@RequestMapping("/reports")
@Slf4j
public class ReportController {
	
	@Autowired
	ReportingService reportingService;
	
	@LogExecutionTime
	@PostMapping("/pdf")
	public ResponseEntity<?> getPdfFile(HttpServletRequest httpServletRequest,@RequestBody List<Students> students) throws IOException {
		String traceId = httpServletRequest.getHeader("TraceID");
		log.info("TraceID {} Pdf file API called",traceId);
		StringBuffer filename = new StringBuffer("student_details");
		String ext = ".pdf";
		String mediatype = "application/pdf";
		Object fileData = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		byteArrayOutputStream = reportingService.generatePDF(traceId,students);
		ByteArrayResource resource = new ByteArrayResource(byteArrayOutputStream.toByteArray());
		fileData = resource;
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachemt; filename="+ filename + ext)
				.contentType(MediaType.parseMediaType(mediatype)).body(fileData);
	}

}
