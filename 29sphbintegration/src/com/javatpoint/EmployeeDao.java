package com.javatpoint;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeDao {
    HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Transactional
    public void saveEmployee(Employee e) {
        template.save(e);
    }

    public void updateEmployee(Employee e) {
        template.update(e);
    }

    public void deleteEmployee(Employee e) {
        template.delete(e);
    }
}
