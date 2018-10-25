package com.root.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.query.Query;

import com.root.model.UserModel;

public class HibernateMain {

	// insert user form in database
	public String insertInDatabase(UserModel userModel) {

		String response = checkUserDetail(userModel);

		Session session = HibernateUtil.getSession();
		
		if (response.equals("okkk")) {
			try {
				session.beginTransaction();
				session.save(userModel);
				session.getTransaction().commit();
				session.close();
				HibernateUtil.shutdown();
				return "Success";
			} catch (Exception e) {
				e.printStackTrace();
				HibernateUtil.shutdown();
				return "Failure";
			}
		} else {
			HibernateUtil.shutdown();
			return response;
		}
	}

	private String checkUserDetail(UserModel userModel) {
		// TODO Auto-generated method stub
		String name = userModel.getName();
		String mobileNumber = userModel.getMobileNumber();
		String email = userModel.getEmail();
		String pincode = userModel.getPincode();
		String area = userModel.getAreaName();
		String state = userModel.getStateName();
		String res = "okkk";
		if (mobileNumber.length() != 10) {
			res = "Enter ten digit mobile number";
		} else if (!checkMobileDigit(mobileNumber)) {
			res = "enter only digit";
		} else if (!checkNameChar(name)) {
			res = "name shuld be only in alphabet";
		} else if (!checkEmail(email)) {
			res = "enter a valid email";
		} else if (pincode.length() != 6) {
			res = "enter valid pincode and enter only six digit";
		} else if (!checkPincode(pincode)) {
			res = "enter only digit";
		} else if (area.equals(null)) {
			res = "choose area";
		} else if (state.equals(null)) {
			res = "choose state";
		}
		return res;
	}

	private boolean checkPincode(String pincode) {
		// TODO Auto-generated method stub
		String patternStr = "^[0-9]*$";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(pincode);
		boolean matchFound = matcher.matches();
		return matchFound;
	}

	private boolean checkEmail(String email) {
		// TODO Auto-generated method stub

		String patternStr = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern pattern = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		boolean matchFound = matcher.matches();
		return matchFound;

	}

	private boolean checkNameChar(String name) {
		// TODO Auto-generated method stub
		String patternStr = "[a-zA-Z]+";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(name);
		boolean matchFound = matcher.matches();
		return matchFound;
	}

	private boolean checkMobileDigit(String mobileNumber) {
		// TODO Auto-generated method stub
		String patternStr = "^[0-9]*$";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(mobileNumber);
		boolean matchFound = matcher.matches();
		return matchFound;
	}

//	public void getData() {
//
//		Session session = HibernateUtil.getSession();
//		session.beginTransaction();
//		String pinr = "110078";
//		String hql = "FROM UserModel u WHERE u.pincode = :pin ";
//
//		Query<?> query = session.createQuery(hql);
//		query.setParameter("pin", pinr);
//		List<?> results = query.list();
//		for (Iterator<?> i = results.iterator(); i.hasNext();) {
//			UserModel model = (UserModel) i.next();
//			System.out.println("area: " + model.getAreaName());
//		}
//		session.close();
//		HibernateUtil.shutdown();
//	}
//
//	public static void main(String str[]) {
//		HibernateMain hb = new HibernateMain();
//		hb.getData();
//	}

}
