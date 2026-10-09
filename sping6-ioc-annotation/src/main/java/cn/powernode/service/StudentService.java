package cn.powernode.service;

import cn.powernode.dao.StudentDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentService {

    @Resource(name = "studentDaoImplForMySQL")
    private StudentDao studentDao;
    public void deleteStudent(){
        studentDao.deleteById();
    }
}
