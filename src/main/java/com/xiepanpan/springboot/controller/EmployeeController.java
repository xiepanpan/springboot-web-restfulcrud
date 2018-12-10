package com.xiepanpan.springboot.controller;

import com.xiepanpan.springboot.dao.DepartmentDao;
import com.xiepanpan.springboot.dao.EmployeeDao;
import com.xiepanpan.springboot.entities.Department;
import com.xiepanpan.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


/**
 * @description: 员工控制层
 * @author: xiepanpan
 * @create: 2018-12-05 22:22
 **/
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emps/list";
    }

    /**
     *  跳转到员工添加
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emps/add";
    }

    /**
     * 保存员工信息
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        System.out.println("保存的员工信息:"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 跳转到修改页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/emp/{id}")
    private String toEditPage(@PathVariable("id")Integer id,Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emps/add";
    }

    /**
     * 修改员工
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        System.out.println("修改的员工数据"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id")Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
