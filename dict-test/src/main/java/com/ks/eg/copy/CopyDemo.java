package com.ks.eg.copy;

import java.io.Serializable;
import java.lang.reflect.Field;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.cglib.beans.BeanCopier;

public class CopyDemo {

	@Ignore
	@Test
	public void BeanCopierDemo() {
		BeanCopier copy = BeanCopier.create(A.class, B.class, false);
		A a = new A("xxx", "yy");
		B b = new B();
		copy.copy(a, b, null);

		System.out.println(b.getUsername() + "_" + b.getPassword());
	}

	@Test
	public void BeanCopierTrueDemo() {
		BeanCopier copy = BeanCopier.create(A.class, B.class, true);
		A a = new A("xxx", "yy");
		B b = new B();
		b.setSex("B");
		copy.copy(a, b, null);

		Field[] fields = A.class.getFields();
		for (Field field : fields) {
			System.out.println(field);
		}
	}

}

class A implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public A(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

class B implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String sex;

	public B() {
		super();
	}

	public B(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
