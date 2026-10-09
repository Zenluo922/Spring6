package cn.powernode.dao.impl;

import cn.powernode.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository("studentDaoImplForMySQL")
public class studentDaoImplForMySQL implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("MySQL数据库正在删除学生信息");
    }
}
