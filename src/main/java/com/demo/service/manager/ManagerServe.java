package com.demo.service.manager;

import com.demo.controller.UrlController;
import com.demo.dao.manager.Manager;
import com.demo.entity.User;
import com.demo.entity.exam.ExamRoomInformation;
import com.demo.entity.exam.ExamTeacher;
import com.demo.entity.exam.UserInformation;
import com.demo.entity.exam.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ManagerServe {

    @Autowired
    private Manager managerDao;

    public Integer addExaminee(User user) {
        return managerDao.insertExaminee(user);
    }
    public Integer deleteExaminee(User user) {return managerDao.deleteExaminee(user);}

    /**
     * 查找所有白名单
     */
    public List<Whitelist> findAllWhiteList() {return managerDao.findAllWhiteList();}

    /**
     * 添加白名单成员
     */
    public Integer addWhiteList(int userId) {
        String num = managerDao.findExamineeNumById(userId);

        return managerDao.insertWhiteList(userId,num);
    }

    /**
     * 更新白名单成员
     */
    public Integer updateWhiteList(Whitelist whitelist) {
        whitelist.setExamineeNum(managerDao.findExamineeNumById(whitelist.getUserId()));
        return managerDao.updateWhiteList(whitelist);
    }

    /**
     * 删除白名单成员
     */
    public Integer deleteWhiteList(int listId) {

        return managerDao.deleteWhiteList(listId);
    }

    /**
     * 是否是考点
     */
    public boolean checkRoom()
    {
        //获得所在院校
        String roomName = UrlController.currentUser.getInstitute();
        //查找考点编号
        Integer roomId = managerDao.findRoomIdByName(roomName);
        if(roomId>0)
            return true;
        return false;
    }
    /**
     * 显示所有考场
     */
    public List<ExamRoomInformation> findAllExamRoom() {
        return managerDao.findAllExamRoom();
    }

    /**
     * 查找单个考场
     */
    public ExamRoomInformation findExamRoomById(int examRoomId) {
        return managerDao.findExamRoomById(examRoomId);
    }
    /**
     * 添加考场
     */
    public Integer addExamRoom(ExamRoomInformation examRoomInformation) {
        //获得所在院校
        String roomName = UrlController.currentUser.getInstitute();
        //查找考点编号
        Integer roomId = managerDao.findRoomIdByName(roomName);

        examRoomInformation.setRoomId(roomId);
        return managerDao.insertExamRoom(examRoomInformation);
    }

    /**
     * 更新考场
     */
    public Integer updateExamRoom(ExamRoomInformation examRoomInformation) {
        return managerDao.updateExamRoom(examRoomInformation);
    }

    /**
     * 删除考场
     */
    public Integer deleteExamRoom(int examRoomId) {
        return managerDao.deleteExamRoom(examRoomId);
    }

    /**
     * 显示所有考务人员
     */
    public List<ExamTeacher> findAllExamTeacher() {
        return managerDao.findAllExamTeacher();
    }

    /**
     * 查找单个考务人员
     */
    public ExamTeacher findExamTeacherById(int examTeacherId) {
        return managerDao.findExamTeacherById(examTeacherId);
    }
    /**
     * 添加考务人员
     */
    public Integer addExamTeacher(ExamTeacher examTeacher) {
        //获得所在院校
        String roomName = UrlController.currentUser.getInstitute();
        //查找考点编号
        Integer roomId = managerDao.findRoomIdByName(roomName);

        examTeacher.setRoomId(roomId);
        return managerDao.insertExamTeacher(examTeacher);
    }

    /**
     * 更新考务人员
     */
    public Integer updateExamTeacher(ExamTeacher examTeacher) {
        return managerDao.updateExamTeacher(examTeacher);
    }

    /**
     * 删除考务人员
     */
    public Integer deleteExamTeacher(int examTeacherId) {
        return managerDao.deleteExamTeacher(examTeacherId);
    }

    /**
     * 查找审核通过的本院校学生
     * @return
     */
    public List<UserInformation> findStudentPassPreview() {
        return managerDao.findStudentPassPreview();

    }

    /**
     * 集体报名
     */

    public Integer groupEnter() {
        //应用型考生
        List<UserInformation> studentList = managerDao.findStudentPassPreview();
        for(int i=0;i<studentList.size();i++) {
            UserInformation student = studentList.get(i);
            //插入一条报考信息
        }
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
