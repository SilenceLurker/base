package xyz.silencelurker.hw.base;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import xyz.silencelurker.hw.base.dao.Dao;
import xyz.silencelurker.hw.base.entity.Department;
import xyz.silencelurker.hw.base.entity.factory.DepartmentFactory;
import xyz.silencelurker.hw.base.jdbc.DepartmentServiceImpl;

@SpringBootTest
@WebAppConfiguration
class BaseApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("Junit Test Is Working ...");
	}

	// @Resource
	// private StuffServiceImpl stuffServiceImpl;

	// @Test
	// void serviceTest() {
	// List<Stuff> list = stuffServiceImpl.findAll();
	// System.out.println(list.get(1).getName());
	// }

	@Test
	void conTest() {
		Connection con = Dao.getCon();
		if (con == null) {
			System.out.println("Connection Error!");
		} else {
			System.out.println("Connection Success!");
		}
	}

	@Resource
	private DepartmentServiceImpl departmentServiceImpl;

	@Test
	void listTest() {
		List<Department> list = departmentServiceImpl.findAll();

		Iterator<Department> it = list.iterator();

		while (it.hasNext()) {
			Department d = it.next();
			System.out.println(d.getDepartmentId() + d.getDepartment());
		}
	}

	@Test
	void selectTest() {
		Department d = departmentServiceImpl.findById(3);
		System.err.println(d.getDepartmentId() + d.getDepartment());
	}

	@Test
	void updateTest() {
		DepartmentFactory df = new DepartmentFactory();
		df.setDepartmentInfo("更新后测试");
		df.setId(6);

		Department d = df.build();

		departmentServiceImpl.update(8, d);

		d = departmentServiceImpl.findById(6);

		System.err.println(d.getDepartmentId() + " " + d.getDepartment());
	}

}
