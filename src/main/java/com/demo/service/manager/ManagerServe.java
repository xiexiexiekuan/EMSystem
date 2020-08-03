package com.demo.service.manager;

import com.demo.dao.manager.Manager;
import com.demo.entity.User;
import com.demo.entity.exam.ExamRoomInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServe {

    @Autowired
    private Manager managerDao;

    public Integer addExaminee(User user) {
        return managerDao.insertExaminee(user);
    }
    public Integer deleteExaminee(User user) {return managerDao.deleteExaminee(user);}

    /**
     * 添加白名单成员
     */
    public Integer addWhiteList(int listId,int userId) {
        return managerDao.insertWhiteList(listId, userId);
    }

    /**
     * 更新白名单成员
     */

    public Integer updateWhiteList() {

        //待完成
        return 1;
    }

    /**
     * 删除白名单成员
     */

    public Integer deleteWhiteList() {

        //待完成
        return 1;
    }

    /**
     * 集体报名
     */

    public Integer groupEnter() {

        //待完成
        return 1;
    }

    /**集体报考
     *
     */

    public Integer groupApply() {

        //待完成
        return 1;
    }
    /**
     * 集体缴费
     */
    public Integer groupPay() {

        //待完成
        return 1;
    }

    /**
     * 显示所有考场
     */
    public List<ExamRoomInformation> findAllExamRoom() {
        return managerDao.findAllExamRoom();
    }

    /**
     * 根据用户姓名考试号查询
     * @param name
     * @param examId
     * @return
     */
    public List<User> searchByNameAndExam(String name, Integer examId) {
        List<User> l=null;
        l=managerDao.searchByNameAndExam(name,examId);
//        if(l!=null){//设置用户密码为空
//            for (User u:l){
//                u.setPassword("");
//            }
//        }
        return l;
    }
    /**
     * 插入一条考生报名考试信息
     * 返回插入记录主键，需再使用对象的getter方法才可真正得到记录id，否则为记录数，如下：
     * userId=user.getId();
     * @param userId
     * @param examId
     * @return
     */
    public int addExamineeExam(Integer userId, Integer examId) {
        return managerDao.insertExam(userId,examId);
    }

    /**
     * 更新考生信息
     * @param user
     */
    public int updateUser(User user) {
        return managerDao.updateUser(user);
    }

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    public User findUserById(Integer id){
        return managerDao.findUserById(id);
    }
}
