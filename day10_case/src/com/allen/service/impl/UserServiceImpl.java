package com.allen.service.impl;

import com.allen.dao.UserDao;
import com.allen.dao.impl.UserDaoImpl;
import com.allen.domain.PageBean;
import com.allen.domain.User;
import com.allen.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        //调用dao完成查询
        return dao.findAll();
    }

    @Override
    public int add(User user) {
        return dao.add(user);
    }

    @Override
    public int update(User user) {
        return dao.update(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User finUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if (ids!= null && ids.length > 0){
            //1、遍历数组
            for (String id : ids) {
                //2、调用dao删除
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //1、创建一个空的PageBean对象
        PageBean<User> pb = new PageBean<User>();
        //2、设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3、调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //4、调用dao查询list集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<User> list= dao.findByPage(start,rows,condition);
        pb.setList(list);

        //5、计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

}
