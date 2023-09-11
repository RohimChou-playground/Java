package com.rohim;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.register(ApplicationContextConfig.class);
		appContext.refresh();

		OrgMemberRepository orgMemberRepository = appContext.getBean(OrgMemberRepository.class);
		OrgMember user = orgMemberRepository.findById("Z00038387").orElse(null);
		System.out.println(user.getEmpName());
	}
}
